package com.xielei.ui.view.login;

/**
 * @author xielei
 * @date 2023/5/15 09:59
 */
public class LoginView {

    private LoginInit loginInit;
    private ILoginEvent loginEvent;

    public LoginView(LoginInit loginInit, ILoginEvent loginEvent) {
        this.loginInit = loginInit;
        this.loginEvent = loginEvent;
    }
}
