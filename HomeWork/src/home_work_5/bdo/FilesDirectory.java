package home_work_5.bdo;

import java.util.List;

public class FilesDirectory {
    private final String directory;
    private List<String> files;

    public FilesDirectory(String directory, List<String> files) {
        this.directory = directory;
        this.files = files;
    }

    public String getDirectory() {
        return directory;
    }

    public List<String> getFiles() {
        return files;
    }
}
