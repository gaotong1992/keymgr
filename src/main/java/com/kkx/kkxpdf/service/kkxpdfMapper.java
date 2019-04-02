package com.kkx.kkxpdf.service;

import com.kkx.kkxpdf.bean.kkxpdf;
import com.kkx.kkxpdf.bean.kkxpdfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface kkxpdfMapper {
    long countByExample(kkxpdfExample example);

    int deleteByExample(kkxpdfExample example);

    int deleteByPrimaryKey(Long contentid);

    int insert(kkxpdf record);

    int insertSelective(kkxpdf record);

    List<kkxpdf> selectByExampleWithBLOBs(kkxpdfExample example);

    List<kkxpdf> selectByExample(kkxpdfExample example);

    kkxpdf selectByPrimaryKey(Long contentid);

    int updateByExampleSelective(@Param("record") kkxpdf record, @Param("example") kkxpdfExample example);

    int updateByExampleWithBLOBs(@Param("record") kkxpdf record, @Param("example") kkxpdfExample example);

    int updateByExample(@Param("record") kkxpdf record, @Param("example") kkxpdfExample example);

    int updateByPrimaryKeySelective(kkxpdf record);

    int updateByPrimaryKeyWithBLOBs(kkxpdf record);

    int updateByPrimaryKey(kkxpdf record);

    /**
     * 获取最大值id
     * @return
     */
    long getMaxIdByWord();
}