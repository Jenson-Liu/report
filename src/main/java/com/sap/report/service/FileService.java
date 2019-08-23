package com.sap.report.service;

import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-21  10:47
 */
@Service
public class FileService {

    /**
     * 根据filename查找lips文件夹下对应的file
     * @param fileName
     * @return
     */
    public File getFile(String fileName){
        File[] files = new File("src/main/resources/static/lips").listFiles();
        for (File file:files){
            if(file.getName().contains(fileName)){
                return file;
            }
        }
        return null;
    }
}
