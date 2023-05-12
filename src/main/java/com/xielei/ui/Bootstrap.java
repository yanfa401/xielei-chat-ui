package com.xielei.ui;

import com.xielei.ui.view.Login;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author xielei
 * @date 2023/5/12 14:43
 */
public class Bootstrap extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Login login = new Login();
        login.show();
    }
}
