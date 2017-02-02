import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.diagnostic.Logger;

import com.intellij.openapi.ui.DialogWrapper;
import junit.framework.Test;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by dionsegijn on 2/2/17.
 */
public class Sync extends AnAction {

    private static final Logger log = Logger.getInstance(Sync.class);
    private static final String folderName = "/.codestyles";

    private static String projectBasePath;

    @Override
    public void actionPerformed(AnActionEvent e) {
        final Project project = e.getProject();
        if (project == null) {
            return;
        }
        // Set for getCodestylePath
        projectBasePath = project.getBasePath();

        if(!checkForPluginFolder()) {
            checkForExistingCodestyles();
        }
    }

    private String getCodestylePath() {
        return projectBasePath + folderName;
    }

    private void showMessageBox(String text) {
        JPanel panel = new JPanel();
        panel.add(new JLabel(text));
        JOptionPane.showMessageDialog(null,panel,"Information",JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean checkForPluginFolder() {
        return new File(getCodestylePath()).mkdirs();
    }

    private void checkForExistingCodestyles() {
        File[] files = new File(getCodestylePath()).listFiles();

        // File is not a directory
        if(files == null) {
            showMessageBox("No directory found");
            return;
        }

        for (File file : files) {
            if (file.isFile() && isXMLFileExtension(file.getName())) {
                showMessageBox("Found XML file: " + file.getName());
            }
        }
    }

    private boolean isXMLFileExtension(String fileName) {
        if (fileName == null) return false;
        int lastIndex = fileName.lastIndexOf('.');
        return lastIndex > 0 && "xml".equalsIgnoreCase(fileName.substring(lastIndex + 1));
    }


}
