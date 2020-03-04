package com.aa12501.myweb.inter;


import com.aa12501.myweb.entities.UserEntity;

public interface ILogin {
    void saveUser(UserEntity userEntity);

    UserEntity findById(Integer userId);

    UserEntity findByToken(String token);

    void updateUserInfo(UserEntity userEntity);
}
