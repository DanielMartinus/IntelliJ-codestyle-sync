import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import junit.framework.Test;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dionsegijn on 2/2/17.
 */
public class Sync extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        final Project project = e.getProject();
        if (project == null) {
            return;
        }
        TestDialog testDialog = new TestDialog();
    }

    public class TestDialog extends DialogWrapper {

        TestDialog() {
            super(false);

            init();
        }

        @Nullable
        protected JComponent createCenterPanel() {
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.add(new JButton("Button"));

            return panel;
        }

    }

}
