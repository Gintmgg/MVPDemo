package com.example.test.mvpdemoapp.view;

import com.example.test.mvpdemoapp.bean.User;

/**
 * Created by zhangchunpeng on 2018/6/23.
 */

public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();

}
