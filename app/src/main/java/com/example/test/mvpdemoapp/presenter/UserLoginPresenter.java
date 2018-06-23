package com.example.test.mvpdemoapp.presenter;

import android.os.Handler;

import com.example.test.mvpdemoapp.bean.User;
import com.example.test.mvpdemoapp.biz.IUserBiz;
import com.example.test.mvpdemoapp.biz.OnLoginListener;
import com.example.test.mvpdemoapp.biz.UserBiz;
import com.example.test.mvpdemoapp.view.IUserLoginView;

/**
 * Created by zhangchunpeng on 2018/6/23.
 */

public class UserLoginPresenter {

    private IUserBiz userBiz;

    private IUserLoginView userLoginView;

    private Handler mHander = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView){
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login(){
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程执行
                mHander.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();

                    }
                });
            }

            @Override
            public void loginFailed() {
                //需要在UI线程执行
                mHander.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });
            }
        });
    }


    public void clear()
    {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }

}
