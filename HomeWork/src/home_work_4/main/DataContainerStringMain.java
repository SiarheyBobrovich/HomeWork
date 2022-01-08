package home_work_4.main;

import home_work_4.dbo.DataContainer;
import home_work_4.service.ContainerStringService;

public class DataContainerStringMain {
    public static void main(String[] args) {
        DataContainer<String> container = new DataContainer<>(new String[4]);
        ContainerStringService service = new ContainerStringService();
        service.run(container);
    }
}
