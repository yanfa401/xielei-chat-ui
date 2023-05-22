package com.xielei.ui;

import java.util.Date;

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

        // 模拟测试
        chat.addTalkBox(-1, 0, "1000001", "谢磊", "01_50", "我不是一个简单的男人", new Date(), true);
        chat.addTalkBox(-1, 0, "1000002", "欧鑫赟", "02_50", "我就是我,颜色不一样的烟火", new Date(), false);
        chat.addTalkBox(-1, 0, "1000003", "Miss Li", "03_50", "ASdasfadsadasdadasdas", new Date(), false);
        chat.addTalkBox(-1, 0, "1000004", "jiyu", "04_50", "test test", new Date(), false);
        chat.addTalkBox(0, 1, "5307397", "Sirius", "group_1", "TEST2 TEST3", new Date(), false);
    }
}
