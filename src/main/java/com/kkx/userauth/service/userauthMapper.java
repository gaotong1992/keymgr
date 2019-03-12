package com.kkx.userauth.service;

import com.kkx.userauth.bean.userauth;
import com.kkx.userauth.bean.userauthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userauthMapper {
    long countByExample(userauthExample example);

    int deleteByExample(userauthExample example);

    int insert(userauth record);

    int insertSelective(userauth record);

    List<userauth> selectByExample(userauthExample example);

    int updateByExampleSelective(@Param("record") userauth record, @Param("example") userauthExample example);

    int updateByExample(@Param("record") userauth record, @Param("example") userauthExample example);

    /**
     * 获取用户权限表下一个id
     * @return
     */
    Long getNextIdByUserAuth();
}