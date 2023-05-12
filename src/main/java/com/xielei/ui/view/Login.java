package com.xielei.ui.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 单个窗体的需要继承Stage，也就是继承了窗口类，并需要在里面创建场景，才可以运行展示
 *
 * @author xielei
 * @date 2023/5/12 14:44
 */
public class Login extends Stage {

    public Login() {
        try {
            loginPane = FXMLLoader.load(getClass().getResource(RESOURCE_NAME));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(loginPane);
        scene.setFill(Color.TRANSPARENT);
        setScene(scene);
        initStyle(StageStyle.TRANSPARENT);
        setResizable(false);
        this.getIcons().add(new Image("/fxml/login/img/logo.png"));

        move();
        min();
        quit();
        login();
    }

    public static final String RESOURCE_NAME = "/fxml/login/login.fxml";

    /**
     * 登陆窗体的元素面板
     */
    private Parent loginPane;

    private double xOffset;

    private double yOffset;

    /**
     * 这里的loginPane是我们整个登陆窗体的元素面板，可以通过它来设置一些行为设置或者还可以通过ID查找根里面还有的元素loginPane.lookup
     * 在我们所有使用的桌面程序里，都是可以通过鼠标拖拽来移动位置的。那么这里我们是定义三个鼠标事件，来实现窗体的移动，如下；
     * setOnMousePressed；鼠标按下事件，这个时候记录窗体位置
     * setOnMouseDragged；鼠标拖动事件，这个设置setX、setY
     * setOnMouseReleased；鼠标释放事件，这个时候恢复默认鼠标样式，最终完成了整个窗口的拖拽过程
     */
    private void move() {
        loginPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = getX() - event.getScreenX();
                yOffset = getY() - event.getScreenY();
                loginPane.setCursor(Cursor.CLOSED_HAND);
            }
        });


        loginPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setX(event.getScreenX() + xOffset);
                setY(event.getScreenY() + yOffset);
            }
        });


        loginPane.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                loginPane.setCursor(Cursor.DEFAULT);
            }
        });
    }

    public <T> T $(String id, Class<T> clazz) {
        return (T) loginPane.lookup("#" + id);
    }

    /**
     * 最小化窗体事件
     */
    private void min() {
        Button login_min = $("login_min", Button.class);
        login_min.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("执行最小化窗体操作");
                setIconified(true);
            }
        });
    }


    /**
     * 退出窗体事件
     */
    private void quit() {
        Button login_close = $("login_close", Button.class);
        login_close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("执行退出窗体事件");
                close();
                System.exit(0);
            }
        });
    }


    /**
     * 登录事件
     */
    private void login() {
        final TextField textField = $("userId", TextField.class);
        final PasswordField passwordField = $("userPassword", PasswordField.class);

        $("login_button", Button.class).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("执行登录事件");
                System.out.println("账号:" + textField.getText());
                System.out.println("密码:" + passwordField.getText());
            }
        });
    }





}
