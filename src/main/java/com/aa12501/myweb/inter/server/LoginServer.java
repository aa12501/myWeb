package com.aa12501.myweb.inter.server;

import com.aa12501.myweb.entities.UserEntity;
import com.aa12501.myweb.inter.ILogin;
import com.aa12501.myweb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServer implements ILogin {

    @Autowired
    private UserMapper userMapper;

    private UserEntity findByEmail(String email) {
        UserEntity user = new UserEntity();
        user.setEmail(email);
        return userMapper.selectSelective(user);
    }

    @Override
    public UserEntity findById(Integer id) {
        UserEntity user = new UserEntity();
        user.setUserId(id);
        return userMapper.selectSelective(user);
    }

    @Override
    public UserEntity findByToken(String token){
        UserEntity user = new UserEntity();
        user.setToken(token);
        return userMapper.selectSelective(user);
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        if (findById(userEntity.getUserId()) != null) {
            throw new RuntimeException("该学号已注册");
        }

        if (findByEmail(userEntity.getEmail()) != null) {
            throw new RuntimeException("该邮箱已注册");
        }

        userEntity.setGmtCreate(System.currentTimeMillis());
        userMapper.insertSelective(userEntity);
    }

    @Override
    public void updateUserInfo(UserEntity userEntity){
        userMapper.updateSelectiveByPrimaryKey(userEntity);
    }
}
