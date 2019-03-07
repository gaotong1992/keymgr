package com.kkx.user.service;

import com.kkx.user.bean.kkxuser;

import java.util.List;
import java.util.Map;

public interface kkxuserMapper {





    int deleteByPrimaryKey(Long userid);

    int insert(kkxuser record);

    int insertSelective(kkxuser record);

    kkxuser selectByPrimaryKey(Long userid);

    int updateByPrimaryKeySelective(kkxuser record);

    int updateByPrimaryKey(kkxuser record);

    /**
     * 传入用户名和密码返回登陆对象
     * @param _map
     * @return
     */
    List<kkxuser> selectKkxUserByUnameByUpwd(Map _map);

    /**
     * 获取用户表下一个id
     * @return
     */
    Long selectKkxUserOfNextCateid();

    /**
     * 用户列表
     * @return
     */
    List<kkxuser> selectKkxuserlist();
    /**
     * 根据mac地址查询用户
     * @param _map
     * @return
     */
    List<kkxuser> selectKkxUserByMac(Map _map);
}