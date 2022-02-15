package my_utils;

import home_work_5.api.ISearchEngine;
import home_work_5.dto.EasySearch;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.*;

public class WarAndMarThreadSearch {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Введите директорию для поиска: ");
        Path path = Path.of(console.nextLine());

        System.out.print("Введите слово для поиска: ");
        String word = console.nextLine();

        long a = System.currentTimeMillis();

        File path2Writer = new File(path.toFile(), "result.txt");

        List<File> files = List.of(path.toFile().listFiles((dir, name) -> name.endsWith("txt")
                && !name.equals("result.txt")));

        List<CompletableFuture<Void>> completableList = new ArrayList<>();

        ExecutorService service = Executors.newFixedThreadPool(4);
        ISearchEngine searcher = new EasySearch();

        try (Writer writer = new FileWriter(path2Writer, true)) {

            files.forEach(file -> {

                if (file.length() > 1_000_000_000) {
                     completableList.add(readBigFile(file, word, searcher, service, writer));
                }else {
                    completableList.add(readSmallFile(file, word, searcher, service, writer));
                }
            });

            while (!completableList.isEmpty()) {
                for (CompletableFuture<Void> completableFuture : completableList) {
                    if (completableFuture.isDone()) {
                        completableList.remove(completableFuture);
                        break;
                    }
                }
            }

            service.shutdown();

        } catch (IOException e) {
            service.shutdown();
            throw new RuntimeException("Невозможно записать в данную директорию: " + e.getMessage());
        }

        System.out.println("Время работы программы: " + (System.currentTimeMillis() - a) + " мс.");
    }


    private static CompletableFuture<Void> readSmallFile(File file,
                                                         String word,
                                                         ISearchEngine searchEngine,
                                                         ExecutorService executorService, Writer writer) {

        return CompletableFuture.supplyAsync(() -> {

            String text;
            Path tmpFile = null;

            try {
                tmpFile = file.toPath();
                text = Files.readString(tmpFile);

                return searchEngine.search(text, word);

            } catch (IOException e) {
                System.out.println("Не удалось открыть файл: " + tmpFile);
                return -1L;
            }
        }, executorService)
                .thenAcceptAsync(countWord -> write(file, countWord, word, writer), executorService);
    }

    private static CompletableFuture<Void> readBigFile(File file,
                             String word,
                             ISearchEngine searchEngine,
                             ExecutorService executorService, Writer writer) {

         return CompletableFuture.supplyAsync(() -> {

            try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
                long result = 0;
                String text;

                while ((text = reader.readLine()) != null) {
                    result += searchEngine.search(text, word);
                }

                return result;

            } catch (IOException e) {
                return -1L;
            }

        }, executorService)
                .thenAcceptAsync(countWord -> write(file, countWord, word, writer), executorService);
    }

    private static void write(File file, Long value, String word, Writer writer) {

        String readError = "Ошибка чтения файла: " + file.getName() + "\n";

        try {
            if (value >= 0) {
                writer.write(file.getName() + " - " + word + " - " + value + "\n");
            } else {
                writer.write(readError);
            }
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException("Проблема записи", e);
        }
    }
}