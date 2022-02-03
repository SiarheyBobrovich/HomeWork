package home_work_5.service;

import home_work_5.api.ISearchEngine;
import home_work_5.dto.EasySearch;
import home_work_5.dto.RegExSearch;
import home_work_5.dto.SearchRunnable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SearchInDirectoryThreadService {

    public void run(File[] files) {
        String word;

        while (!(word = getWord()).equals("")) {

            for (File file : files) {
                String line;
                long countWord = 0;
                ISearchEngine engine = new EasySearch();

                try(BufferedReader reader = new BufferedReader(new FileReader(file))) {

                    ExecutorService executorService = Executors.newFixedThreadPool(4);
                    List<Future<Long>> futures = new ArrayList<>();

                    while ((line = reader.readLine()) != null) {
                        futures.add(executorService.submit(new SearchRunnable(line, word, engine)));
                    }

                    for (Future<Long> future : futures) {
                        try {
                            countWord += future.get();
                        } catch (InterruptedException e) {
                            System.out.println("Операция прервана");
                        } catch (ExecutionException e) {
                            throw new RuntimeException("Ошибка получения результата", e);
                        }
                    }

                    executorService.shutdown();

                } catch (FileNotFoundException e) {
                    System.out.println("Файл" + file.getName() + " не найден.");;
                } catch (IOException e) {
                    System.out.println("Ошибка чтения файла " + file.getName());
                }


                try (Writer writer = new FileWriter("result.txt", true)){
                    writer.write(file.getName() + " - " + word + " - " + countWord + "\n");
                    writer.flush();
                }catch (IOException e) {
                    throw new RuntimeException("Не удалось записать в файл", e);
                }
            }
        }
    }

    private String getWord() {
        Scanner console = new Scanner(System.in);
        System.out.print("Введите слово для поиска: ");
        return console.nextLine();
    }
}
