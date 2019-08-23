package com.sap.report.mapper;

import com.sap.report.entity.Screen;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : Jenson.Liu
 * @date : 2019-08-20  15:58
 */
@Mapper
public interface ScreenMapper {

    /**
     * 插入screen
     * produce所在位置
     * @param screen
     */
    void saveScreen(@Param("screen") ScreenMapper screen);

    /**
     * 根据excleName修改produce的坐标
     * @param excelName
     */
    void updateScreenProduce(@Param("excelName") String excelName);

    /**
     * 根据excelName删除
     * @param excelName
     */
    void delete(@Param("excelName")String excelName);
}
