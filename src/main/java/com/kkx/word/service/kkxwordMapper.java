package com.kkx.word.service;

import com.kkx.word.bean.kkxword;
import com.kkx.word.bean.kkxwordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface kkxwordMapper {
    long countByExample(kkxwordExample example);

    int deleteByExample(kkxwordExample example);

    int insert(kkxword record);

    int insertSelective(kkxword record);

    List<kkxword> selectByExample(kkxwordExample example);

    int updateByExampleSelective(@Param("record") kkxword record, @Param("example") kkxwordExample example);

    int updateByExample(@Param("record") kkxword record, @Param("example") kkxwordExample example);


    /**
     * 根据类型
     * 查询不通类型下的词表的数量
     * @param _type
     * @return
     */
    Integer getCountByWordType(Integer _type);

    /**
     * 获取用户自定义列最大id
     * @return
     */
    Long getMaxIdByWord();


}