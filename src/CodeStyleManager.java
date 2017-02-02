import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.project.Project;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

/**
 * Created by dionsegijn on 2/2/17.
 */
public class CodeStyleManager {

    private String projectBasePath;

    CodeStyleManager(String projectBasePath) {
        this.projectBasePath = projectBasePath;
    }

    void sync() {
        if(projectBasePath == null) return;

        if(!createFolder(getCodestylePath())) {
            checkForExistingCodestyles();
        }
    }

    private String getCodestylePath() {
        String projectLevelCodestyleFolder = "/.codestyles";
        return projectBasePath + projectLevelCodestyleFolder;
    }

    private boolean createFolder(String path) {
        return new File(path).mkdirs();
    }

    private void checkForExistingCodestyles() {
        File[] files = new File(getCodestylePath()).listFiles();

        // File is not a directory
        if(files == null) {
            return;
        }

        ArrayList<File> copyFiles = new ArrayList<>();
        for (File file : files) {
            if (file.isFile() && isXMLFileExtension(file.getName())) {
                copyFiles.add(file);
            }
        }
        copyFiles(copyFiles);
    }

    private void copyFiles(ArrayList<File> files) {
        String configPath = PathManager.getConfigPath();
        createFolder(configPath + "/codestyles");

        for(File file : files) {
            try {
                copyFile(file, new File(configPath + "/codestyles/" + file.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void copyFile(File from, File to) throws IOException {
        Files.copy(from.toPath(), to.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private boolean isXMLFileExtension(String fileName) {
        if (fileName == null) return false;
        int lastIndex = fileName.lastIndexOf('.');
        return lastIndex > 0 && "xml".equalsIgnoreCase(fileName.substring(lastIndex + 1));
    }
}
