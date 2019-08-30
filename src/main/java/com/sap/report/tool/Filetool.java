package com.sap.report.tool;

import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.ArrayList;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-12  16:19
 */

public class Filetool {

    /**
     * 获取文件夹下的所有文件
     * @param fileFolder
     * @return
     */
    public static ArrayList<String> ListFiles(String fileFolder){
        File[] files = new File(fileFolder).listFiles();
        ArrayList<String> filesName= new ArrayList<>();
        for (File file:files){
            filesName.add(file.getName());
        }
        return filesName;
    }

    /**
     *
     * @param multipartFilelist
     * @return
     */
    public static ArrayList<File> MultipartFiletoFile(MultipartFile[] multipartFilelist) {
        ArrayList<File> fileArrayList = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFilelist) {
            File file = null;
            InputStream ins = null;
            try {
                ins = multipartFile.getInputStream();
                file = new File("src/main/resources/static/lips/"+multipartFile.getOriginalFilename());
                OutputStream os = new FileOutputStream(file);
                int bytesRead = 0;
                byte[] buffer = new byte[8192];
                while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
                os.close();
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            File del = new File(file.toURI());
            fileArrayList.add(del);
        }
        return fileArrayList;
    }

    public static void copyfileByname(File sourceFile,String copyPath) throws IOException{
        String name = sourceFile.getName();
        File copyPathfloder = new File(copyPath);
        copyPathfloder.mkdir();
        File copyFile = new File(copyPathfloder.getAbsolutePath()+"/"+name);
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(sourceFile);
            output = new FileOutputStream(copyFile);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }
}
