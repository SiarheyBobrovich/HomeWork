package home_work_5.main;


import home_work_5.service.SearchWithISearchEngineService;

public class SearchWithISearchEngineMain {
    public static void main(String[] args) {
        String fileName = "Война и мир_книга.txt";
        SearchWithISearchEngineService service = new SearchWithISearchEngineService();

        service.run(fileName);
    }
}
