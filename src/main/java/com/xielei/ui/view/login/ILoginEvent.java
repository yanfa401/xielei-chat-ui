package com.xielei.ui.view.login;

public interface ILoginEvent {

    /**
     * 登录验证
     * @param userId 账号
     * @param userPassword 密码
     */
    void doLoginCheck(String userId, String userPassword);
}
