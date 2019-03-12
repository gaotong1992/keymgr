package com.kkx.kkxuserword.service;

import com.kkx.kkxuserword.bean.kkxuserword;
import com.kkx.kkxuserword.bean.kkxuserwordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface kkxuserwordMapper {
    long countByExample(kkxuserwordExample example);

    int deleteByExample(kkxuserwordExample example);

    int insert(kkxuserword record);

    int insertSelective(kkxuserword record);

    List<kkxuserword> selectByExample(kkxuserwordExample example);

    int updateByExampleSelective(@Param("record") kkxuserword record, @Param("example") kkxuserwordExample example);

    int updateByExample(@Param("record") kkxuserword record, @Param("example") kkxuserwordExample example);

    /**
     * 获取用户自定义列最大id
     * @return
     */
    Long getMaxIdByUserWord();
}