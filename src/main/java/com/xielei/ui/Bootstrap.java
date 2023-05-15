package com.xielei.ui;

import com.xielei.ui.view.chat.ChatController;
import com.xielei.ui.view.chat.IChatMethod;
import com.xielei.ui.view.login.ILoginEvent;
import com.xielei.ui.view.login.ILoginMethod;
import com.xielei.ui.view.login.LoginController;

import javafx.application.Application;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xielei
 * @date 2023/5/12 14:43
 */
@Slf4j
public class Bootstrap extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        ILoginMethod login = new LoginController(new ILoginEvent() {
//            @Override
//            public void doLoginCheck(String userId, String userPassword) {
//                log.debug("登陆 userId：" + userId + "userPassword：" + userPassword);
//            }
//        });
//        login.doShow();

        IChatMethod chat = new ChatController();
        chat.doShow();
    }
}
