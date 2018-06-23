package com.example.test.mvpdemoapp.biz;

import com.example.test.mvpdemoapp.bean.User;

/**
 * Created by zhangchunpeng on 2018/6/23.
 */

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}
