package com.aa12501.myweb.mapper;

import com.aa12501.myweb.entities.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserEntity selectSelective(UserEntity userEntity);

    void insertSelective(UserEntity userEntity);

    void updateSelectiveByPrimaryKey(UserEntity userEntity);

    void deleteByPrimaryKey(UserEntity userEntity);

}
