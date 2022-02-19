package my_utils;

import org.json.simple.JSONObject;

import java.nio.file.Path;
import java.util.HashMap;

public class JSONTest {
    public static void main(String[] args) {
        //JSONObject object = new JSONObject(new HashMap());
        Path path = Path.of("HomeWork\\src\\home_work_5\\test2.csv");
        System.out.println(path.toAbsolutePath());
    }

}
