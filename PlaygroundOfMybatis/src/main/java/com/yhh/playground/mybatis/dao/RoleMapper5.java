package com.yhh.playground.mybatis.dao;

import com.yhh.playground.mybatis.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper5 {

    @Select("select * from role r, user_role ur where r.id=ur.role_id and ur.user_id=#{uid}")
    List<Role> findByUid(int uid);
}
