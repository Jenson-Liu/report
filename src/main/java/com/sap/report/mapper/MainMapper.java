package com.sap.report.mapper;

import com.sap.report.entity.Main;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-20  14:28
 */
@Mapper
public interface MainMapper {

    /**
     * 针对页面2，显示主要列的数据
     * 添加参数为excel表名和列名
     * 列和表组合主键
     * @param main
     */
    void saveMain(Main main);

    /**
     * 获取excelName对应的column
     * @param excelName
     * @return
     */
    List<Character> getMainColumn(@Param("excelName")String excelName);

    /**
     * 根据excelName删除对应的columns
     * @param excelName
     */
    void deleteMain(@Param("excelName")String excelName);
}
