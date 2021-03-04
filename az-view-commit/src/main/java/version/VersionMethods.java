package version;

import org.apache.log4j.Logger;
import param.PathParam;
import udf.UDF;
import zip.JarMethods;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class VersionMethods {
    private static final Logger log = Logger.getLogger(VersionMethods.class);

    public static String versionPath;

    public VersionMethods(){
        versionPath= PathParam.versionPath;
    }

    public void wrtieVersionProject() throws IOException {

        File file = new File(versionPath);
        if (!file.exists()){
            file.createNewFile();
        }

        UDF.writeFile("azkaban-flow-version: 2.0",versionPath);
        log.info("version file completed");

    }
}
