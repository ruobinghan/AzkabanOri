package view;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import param.PathParam;
import java.awt.*;
import java.io.File;

public class viewMethods {
    private static final Logger logger = LoggerFactory.getLogger(viewMethods.class);

    public  void startViewEdit(){
        if (java.awt.Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(new File(PathParam.VIEW_EDIT_HTML_PATH));
            } catch (Exception e) {
                logger.info(e.getMessage());
            }
        }
    }
}
