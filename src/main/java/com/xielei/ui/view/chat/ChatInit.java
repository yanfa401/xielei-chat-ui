package com.xielei.ui.view.chat;

import java.io.IOException;

import com.xielei.ui.view.UIObject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

/**
 * @author xielei
 * @date 2023/5/15 16:27
 */
public abstract class ChatInit extends UIObject {


    private static final String RESOURCE_NAME  = "/fxml/chat/chat.fxml";


    public ChatInit() {
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
        this.getIcons().add(new Image("/fxml/chat/img/head/logo.png"));
        initView();
        initEventDefine();
    }
}
