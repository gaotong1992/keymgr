package com.kkx.kkxconfig.service;

import com.kkx.kkxconfig.bean.kkxconfig;
import com.kkx.kkxconfig.bean.kkxconfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface kkxconfigMapper {
    long countByExample(kkxconfigExample example);

    int deleteByExample(kkxconfigExample example);

    int deleteByPrimaryKey(Long configid);

    int insert(kkxconfig record);

    int insertSelective(kkxconfig record);

    List<kkxconfig> selectByExample(kkxconfigExample example);

    kkxconfig selectByPrimaryKey(Long configid);

    int updateByExampleSelective(@Param("record") kkxconfig record, @Param("example") kkxconfigExample example);

    int updateByExample(@Param("record") kkxconfig record, @Param("example") kkxconfigExample example);

    int updateByPrimaryKeySelective(kkxconfig record);

    int updateByPrimaryKey(kkxconfig record);
}