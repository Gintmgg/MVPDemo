package com.example.test.mvpdemoapp.biz;

/**
 * Created by zhangchunpeng on 2018/6/23.
 */

public interface IUserBiz {
    public void login(String username, String password, OnLoginListener loginListener);
}
