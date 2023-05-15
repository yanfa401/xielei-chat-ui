package com.xielei.ui.view.login;

import lombok.extern.slf4j.Slf4j;

/**
 * 窗体的控制管理器
 */
@Slf4j
public class LoginController extends LoginInit implements ILoginMethod {

    private LoginView loginView;

    private LoginEventDefine loginEventDefine;

    public LoginController(ILoginEvent param_loginEvent) {
        super(param_loginEvent);
    }

    @Override
    public void initView() {
        loginView = new LoginView(this, loginEvent);
    }

    @Override
    public void initEventDefine() {
        loginEventDefine = new LoginEventDefine(this, loginEvent, this);
    }

    @Override
    public void doShow() {
        super.show();
    }

    @Override
    public void doLoginError() {
        log.error("登陆失败，执行提示操作");
    }

    @Override
    public void doLoginSuccess() {
        log.debug("登陆成功，执行跳转操作");
        // 关闭原窗口
        close();
    }
}
