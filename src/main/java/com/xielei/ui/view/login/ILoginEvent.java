package com.xielei.ui.view.login;

/**
 * 事件接口
 */
public interface ILoginEvent {

    /**
     * 登录验证
     * @param userId 账号
     * @param userPassword 密码
     */
    void doLoginCheck(String userId, String userPassword);
}
