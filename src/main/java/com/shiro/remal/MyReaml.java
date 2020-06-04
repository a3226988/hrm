package com.shiro.remal;

import com.dao.UserDao;
import com.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Create by gc on 2020/5/19
 * 铁甲依然在
 */
public class MyReaml extends AuthorizingRealm {

    @Autowired
    UserDao userDao;

    //授权：确认用户的权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //1、根据principals（用户名）去数据库中查询该用户拥有的角色和权限
        String username = principals.toString();
        Set<String> roles = userDao.queryRoleNamesByUsername(username);
        Set<String> premissions = userDao.queryPermsNamesByUsername(username);
        //2、将角色和权限封装到AuthorizationInfo交给shrio
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(premissions);
        return authorizationInfo;
    }
    //认证：确认用户的身份
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //token就是收集到的用户的信息
        //1、根据用户提交的用户名，查看用户名是否存在
        String username = token.getPrincipal().toString();
        //2、查询数据库，确认用户名是否存在
        User user = userDao.queryByUsername(username);
        if(user==null){
            throw new UnknownAccountException("用户名不存在！");
        }else{
            SecurityUtils.getSubject().getSession().setAttribute("user",user);
            //3、如果用户名存在，获取该用户的正确的密码
            //4、将正确的用户名和密码交给shiro判断
            //认证用户是否正确的工作还是要交给shiro，我们提供正确的用户名和密码
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,user.getPassword(),this.getName());
            return authenticationInfo;
        }
    }

    /**
     * 模拟查询数据库，根据用户名查询该用户的密码
     * 如果用户存在，返回对应的密码，如果不存在返回null
     * @param username
     * @return
     */
  /*  public String checkUserName(String username){
        if(username.equals("zhangsan")||username.equals("admin")){
            return "123";
        }
        return null;
    }*/

    /**
     * 模拟从数据库中查询用户的角色集合
     * @param username
     * @return
     */
   /* public Set<String> getRoles(String username){
        Set<String> sets = new HashSet<>();
        if(username.equals("zhangsan")){
            sets.add("normal");
            sets.add("boss");
        }else{
            sets.add("manager");
        }
        return sets;
    }*/
    /**
     * 模拟从数据库中查询用户的角色集合
     * @param username
     * @return
     */
   /* public Set<String> getPermissions(String username){
        Set<String> sets = new HashSet<>();
        if(username.equals("zhangsan")){
            sets.add("emp:show");
            sets.add("emp:delete");
        }else{
            sets.add("emp:add");
            sets.add("emp:delete");
            sets.add("emp:update");
            sets.add("emp:edit");
        }
        return sets;
    }*/
}
