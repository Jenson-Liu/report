package com.sap.report.tool;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author : Jenson.Liu
 * @date : 8/30/19  2:00 下午
 */
public class FiletoolTest {

    @Test
    public void listFiles() {
        ArrayList<String> arrayList = Filetool.ListFiles("/Users/i501695/IdeaProjects/report/src/main/resources/static/lips");
        for (String name:arrayList){
            System.out.println(name);
        }
    }
}