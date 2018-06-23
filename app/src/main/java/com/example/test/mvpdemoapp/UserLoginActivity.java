package com.example.test.mvpdemoapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.test.mvpdemoapp.bean.User;
import com.example.test.mvpdemoapp.presenter.UserLoginPresenter;
import com.example.test.mvpdemoapp.view.IUserLoginView;

public class UserLoginActivity extends Activity implements IUserLoginView {

    private EditText etUserNm, etPwd;
    private Button btnLogin, btnClear;
    private ProgressBar mPbLoading;

    private UserLoginPresenter userLoginPresenter = new UserLoginPresenter(UserLoginActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        initView();
    }

    private void initView() {
        etUserNm = (EditText) findViewById(R.id.et_user_nm);
        etPwd = (EditText) findViewById(R.id.et_pwd);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnClear = (Button) findViewById(R.id.btn_clear);
        mPbLoading = (ProgressBar) findViewById(R.id.pb_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.login();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.clear();
            }
        });

    }

    @Override
    public String getUserName() {
        return etUserNm.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPwd.getText().toString();
    }

    @Override
    public void clearUserName() {
        etUserNm.setText("");
    }

    @Override
    public void clearPassword() {
        etPwd.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUsername(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
    }
}
