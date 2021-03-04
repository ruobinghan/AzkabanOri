package udf;

import org.apache.log4j.Logger;

import java.io.*;

public class UDF {
    private static final Logger log = Logger.getLogger(UDF.class);
    /**
     * 清空目录下的文件
     * @param filePath 指定所清空的目录
     * @return
     */
    public static boolean cleanDir(String filePath) {
        boolean flag = true;
        if(filePath != null) {
            File file = new File(filePath);
            if(file.exists()) {
                File[] filePaths = file.listFiles();
                for(File f : filePaths) {
                    if(f.isFile()) {
                        f.delete();
                    }
                    if(f.isDirectory()){
                        String fpath = f.getPath();
                        cleanDir(fpath);
                        f.delete();
                    }
                }
            }
        }else {
            log.info("清空 "+filePath+"失败！！！");
            flag = false;
        }
        if(flag==true){
            log.info("清空 "+filePath+"成功!");
        }
        return flag;
    }

    /**新建文件*/
    public  static  void createFile(String path,String fileName)throws IOException {
        File testFile = new File(path+fileName);
        try{
            if (!testFile.exists()) {
                testFile.createNewFile();
            }
            System.out.println("testFile:"+testFile);
        }catch (Exception e){
           log.error(e.getMessage());
        }
    }

    /**将指定内容写入文件*/
    public  static void writeFile(String content,String filePath) {
        try{
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(filePath),"utf-8");
            out.write(content);
            out.flush();
            out.close();

        }catch(IOException e){
            log.error(e.getMessage());
        }
    }
}
