package com.sap.report.mapper;

import com.sap.report.entity.Sheet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-20  13:49
 */
@Mapper
public interface SheetMapper {

    /**
     * 记录excel名称以及sheet的筛选列
     * @param sheet
     * @return
     */
    void saveSheet(Sheet sheet);

    /**
     * 输入excel名称，获取sheet列
     * @param excelName
     * @return
     */
    String getSheetName(@Param("excelName")String excelName);

    /**
     * 根据sheetName删除
     * @param excelName
     */
    void deleteSheet(@Param("excelName")String excelName);
}
