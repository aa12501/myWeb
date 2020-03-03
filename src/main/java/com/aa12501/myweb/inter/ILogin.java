package com.aa12501.myweb.inter;


import com.aa12501.myweb.entities.UserEntity;

public interface ILogin {
    void saveUser(UserEntity userEntity);

    UserEntity findById(Integer userId);

    void updateUserInfo(UserEntity userEntity);
}
