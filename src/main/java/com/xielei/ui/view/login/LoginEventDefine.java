package com.xielei.ui.view.login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xielei
 * @date 2023/5/15 09:43
 */
@Slf4j
public class LoginEventDefine {

    private LoginInit loginInit;
    private ILoginEvent loginEvent;
    private ILoginMethod loginMethod;

    public LoginEventDefine(LoginInit loginInit, ILoginEvent loginEvent, ILoginMethod loginMethod) {
        this.loginInit = loginInit;
        this.loginEvent = loginEvent;
        this.loginMethod = loginMethod;

        loginInit.move();
        min();
        quit();
        doEventLogin();
    }


    /**
     * 最小化窗体事件
     */
    private void min() {
        loginInit.login_min.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginInit.setIconified(true);
            }
        });
    }


    /**
     * 退出窗体事件
     */
    private void quit() {
        loginInit.login_close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginInit.close();
                System.exit(0);
            }
        });
    }


    /**
     * 登录事件
     */
    private void doEventLogin() {
        loginInit.login_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                log.debug("执行登录事件");
                log.debug("账号:" + loginInit.userId.getText());
                log.debug("密码:" + loginInit.userPassword.getText());
                loginEvent.doLoginCheck(loginInit.userId.getText(), loginInit.userPassword.getText());
            }
        });
    }


}
