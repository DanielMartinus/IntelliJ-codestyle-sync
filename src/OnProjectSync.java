import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * Created by dionsegijn on 2/2/17.
 */
public class OnProjectSync implements ProjectComponent {

    private String projectBasePath;

    public OnProjectSync(Project project) {
        if (project == null) {
            return;
        }
        projectBasePath = project.getBasePath();
    }

    @Override
    public void initComponent() {}

    @Override
    public void disposeComponent() {}

    @Override
    @NotNull
    public String getComponentName() {
        return "OnProjectSync";
    }

    @Override
    public void projectOpened() {
        new CodeStyleManager(projectBasePath).sync();
    }

    @Override
    public void projectClosed() {}
}
