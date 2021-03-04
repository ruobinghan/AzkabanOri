import git.GitMethods;
import org.apache.log4j.Logger;
import org.yaml.snakeyaml.Yaml;
import yaml.YamlMethods;
import yaml.unit.Node;
import zip.ZipMethods;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class demo {
    private static final Logger log = Logger.getLogger(demo.class);

    public static void main(String[] args) {
        String remotePath = "https://github.com/ruobinghan/azkaban.git";
        String username="597759884@qq.com";
        String password="13904524006hrb";
        String projectName="hanrb";
        String branch="master";
        try {
            GitMethods git= new GitMethods(remotePath,username,password,projectName,branch);
            YamlMethods yml= new YamlMethods();
            ZipMethods zip=new ZipMethods();

            git.Clone();
            git.Package();

            Node n1=yml.creatNode("a1","command","d1");
            Node n2=yml.creatNode("a2","command","d2","a1");

            yml.setNodeList(n1);
            yml.setNodeList(n2);

            if(zip.prepareZip(projectName)){
                zip.creatZipPackage(yml);
            }

        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
