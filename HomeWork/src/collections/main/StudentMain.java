package collections.main;

import collections.service.StudentService;

public class StudentMain {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        service.run();
    }
}
