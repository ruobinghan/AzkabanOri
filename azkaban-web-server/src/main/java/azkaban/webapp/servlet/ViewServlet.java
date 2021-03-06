package azkaban.webapp.servlet;

import azkaban.server.AzkabanAPI;
import azkaban.server.session.Session;
import azkaban.webapp.AzkabanWebServer;
import git.GitMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yaml.YamlMethods;
import yaml.unit.Node;
import zip.ZipMethods;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ViewServlet extends LoginAbstractAzkabanServlet {
    private static final Logger logger = LoggerFactory.getLogger(ViewServlet.class);
    public ViewServlet() {
        super(createAPIEndpoints());
    }

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        final AzkabanWebServer server = getApplication();
        //this.triggerManager = server.getTriggerManager();
    }

    @Override
    protected void handleGet(final HttpServletRequest req, final HttpServletResponse resp,
                             final Session session) throws ServletException, IOException {
        if (hasParam(req, "action")) {
            final String action = getParam(req, "action");
            if (action.equals("uploadView")) {
                logger.info("get mode");
                commitView(req,resp,session);
            }
        }
    }

    @Override
    protected void handlePost(final HttpServletRequest req, final HttpServletResponse resp,
                              final Session session) throws ServletException, IOException {
        if (hasParam(req, "action")) {
            final String action = getParam(req, "action");
            if (action.equals("uploadView")) {
                logger.info("post mode");
                commitView(req,resp,session);
            }
        }
    }
    private static List<AzkabanAPI> createAPIEndpoints() {
        final List<AzkabanAPI> apiEndpoints = new ArrayList<>();
        apiEndpoints.add(new AzkabanAPI("action", "uploadView"));
        apiEndpoints.add(new AzkabanAPI("json", ""));
        return apiEndpoints;
    }

    private  void handleView(final HttpServletRequest req, final HttpServletResponse resp,
                             final Session session)throws ServletException{
        if (hasParam(req, "json")) {
            final String json = getParam(req, "json");
            logger.info("json: "+json);
        }
    }

    private void commitView(final HttpServletRequest req, final HttpServletResponse resp,
                            final Session session)throws ServletException{
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
            logger.error(e.getMessage());
        }
    }

}
