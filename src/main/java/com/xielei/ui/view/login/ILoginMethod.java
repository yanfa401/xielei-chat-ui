package com.xielei.ui.view.login;

/**
 * 窗体方法接口
 */
public interface ILoginMethod {

    /**
     * 打开登录窗口
     */
    void doShow();

    /**
     * 登录失败
     */
    void doLoginError();

    /**
     * 登录成功,跳转聊天窗口[关闭登陆窗口，打开新窗口]
     */
    void doLoginSuccess();

}
