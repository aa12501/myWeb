package com.aa12501.myweb.entities;

import lombok.Data;

@Data
public class UserEntity {
    private Integer userId; //用户id
    private String password;    //密码
    private String name;        //用户姓名
    private String nickName;    //用户昵称
    private String email;   //用户个人邮箱
    private Integer tel;    //手机号(11位)
    private String college; //学院
    private Integer grade;  //年级
    private String building;    //宿舍楼号
    private Integer room;   //宿舍房号
    private Integer bed;    //宿舍床号
    private String avatarUrl;   //用户头像
    private Long gmtCreate;  //创号时间
    private Long gmtLastLogin;   //最近登录时间
    private String token;   //
}
