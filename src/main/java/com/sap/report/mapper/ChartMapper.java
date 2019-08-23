package com.sap.report.mapper;

import com.sap.report.entity.Chart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-20  16:13
 */
@Mapper
public interface ChartMapper {

    /**
     * 插入组合键excelName和chart
     *
     * @param chart
     */
    void saveChart(Chart chart);

    /**
     * 根据excelName删除
     * @param excelName
     */
    void deleteChart(@Param("excelName")String excelName);

    /**
     * 获取所有的chart的column参数
     * @param chartColumn
     * @return
     */
    List<Character> getChartColumn(@Param("excelName")String excelName);
}
