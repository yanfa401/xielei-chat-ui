package com.xielei.ui.view.login;


import java.io.IOException;

import com.xielei.ui.view.UIObject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

/**
 * 窗体对象的初始化操作
 * 例如初始化按钮, 初始化root窗体等等
 *
 * todo 后续可以考虑抽出一个类, LoginInit只负责初始化动作, 新搞一个Element做为元素的载体
 *
 * @author xielei
 * @date 2023/5/15 09:31
 */
public abstract class LoginInit extends UIObject {

    private static final String RESOURCE_NAME = "/fxml/login/login.fxml";

    protected ILoginEvent loginEvent;

    public Button login_min;            // 登陆窗口最小化
    public Button login_close;          // 登陆窗口退出
    public Button login_button;         // 登陆按钮
    public TextField userId;            // 用户账户窗口
    public PasswordField userPassword;  // 用户密码窗口

    public LoginInit(ILoginEvent param_loginEvent) {
        this.loginEvent = param_loginEvent;

        try {
            root = FXMLLoader.load(getClass().getResource(RESOURCE_NAME));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        setScene(scene);
        initStyle(StageStyle.TRANSPARENT);
        setResizable(false);
        this.getIcons().add(new Image("/fxml/login/img/logo.png"));

        obtain();
        initView();
        initEventDefine();

    }

    private void obtain() {
        login_min = $("login_min", Button.class);
        login_close = $("login_close", Button.class);
        login_button = $("login_button", Button.class);
        userId = $("userId", TextField.class);
        userPassword = $("userPassword", PasswordField.class);
    }
}
