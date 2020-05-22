package com.dao;

import com.entity.User;

import java.util.Set;

/**
 * Create by gc on 2020/5/21
 * 铁甲依然在
 */
public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return 用户对象
     */
    User queryByUsername(String username);

    /**
     * 根据用户名查询用户的角色名称集合
     * @param username
     * @return
     */
    Set<String> queryRoleNamesByUsername(String username);

    /**
     * 根据用户名查询权限名称集合
     * @param username
     * @return
     */
    Set<String> queryPermsNamesByUsername(String username);
}
