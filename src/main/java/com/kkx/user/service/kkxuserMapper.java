package com.kkx.user.service;

import com.kkx.user.bean.kkxuser;

public interface kkxuserMapper {





    int deleteByPrimaryKey(Long userid);

    int insert(kkxuser record);

    int insertSelective(kkxuser record);

    kkxuser selectByPrimaryKey(Long userid);

    int updateByPrimaryKeySelective(kkxuser record);

    int updateByPrimaryKey(kkxuser record);
}