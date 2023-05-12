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
     * 登录成功
     */
    void doLoginSuccess();

}
