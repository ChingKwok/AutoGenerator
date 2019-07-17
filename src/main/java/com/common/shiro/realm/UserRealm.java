package com.common.shiro.realm;

import com.chingkwok.bean.entity.User;
import com.chingkwok.exception.AutoGeneratorException;
import com.chingkwok.exception.eum.AutoGeneratorExceptionEnum;
import com.chingkwok.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by guojingye on 2019/7/17
 */
public class UserRealm extends AuthenticatingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException, AutoGeneratorException {
        //获取用户的输入的账号
        String username = (String) token.getPrincipal();
        List<User> users = userService.searchUserByUserName(username);
        if (users == null || users.size() == 0) {
            throw new AutoGeneratorException(AutoGeneratorExceptionEnum.LOGIN_NOT_EXIST);
        } else if (users.size() > 1) {
            throw new AutoGeneratorException(AutoGeneratorExceptionEnum.USERNAME_REPEAT_ERROR);
        }
        User user = users.get(0);
        String realmName = getName();
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(token.getPrincipal(), token.getCredentials(), credentialsSalt, realmName);
        return simpleAuthenticationInfo;
    }

    public String getName() {
        return "UserRealm";
    }


}
