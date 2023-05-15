package com.xielei.ui.view.chat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * @author xielei
 * @date 2023/5/15 16:32
 */
public class ChatEventDefine {

    private ChatInit chatInit;

    public ChatEventDefine(ChatInit chatInit) {
        this.chatInit = chatInit;

        // 注册事件
        chatInit.move();
        this.barChat();
        this.barFriend();
    }

    // 聊天
    private void barChat() {
        final Button bar_chat = chatInit.$("bar_chat", Button.class);
        final Pane group_bar_chat = chatInit.$("group_bar_chat", Pane.class);
        bar_chat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ChatEventDefine.this.switchBarChat(bar_chat, group_bar_chat, true);
                ChatEventDefine.this.switchBarFriend(chatInit.$("bar_friend", Button.class), chatInit.$("group_bar_friend", Pane.class), false);
            }
        });
        bar_chat.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                boolean visible = group_bar_chat.isVisible();
                if (visible) {
                    return;
                }
                bar_chat.setStyle("-fx-background-image: url('/fxml/chat/img/system/chat_1.png')");
            }
        });
        bar_chat.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                boolean visible = group_bar_chat.isVisible();
                if (visible) {
                    return;
                }
                bar_chat.setStyle("-fx-background-image: url('/fxml/chat/img/system/chat_0.png')");
            }
        });
    }

    // 好友
    private void barFriend() {
        final Button bar_friend = chatInit.$("bar_friend", Button.class);
        final Pane group_bar_friend = chatInit.$("group_bar_friend", Pane.class);
        bar_friend.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ChatEventDefine.this.switchBarChat(chatInit.$("bar_chat", Button.class), chatInit.$("group_bar_chat", Pane.class), false);
                ChatEventDefine.this.switchBarFriend(bar_friend, group_bar_friend, true);
            }
        });
        bar_friend.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                boolean visible = group_bar_friend.isVisible();
                if (visible) {
                    return;
                }
                bar_friend.setStyle("-fx-background-image: url('/fxml/chat/img/system/friend_1.png')");
            }
        });
        bar_friend.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                boolean visible = group_bar_friend.isVisible();
                if (visible) {
                    return;
                }
                bar_friend.setStyle("-fx-background-image: url('/fxml/chat/img/system/friend_0.png')");
            }
        });
    }

    // 切换：bar_chat
    private void switchBarChat(Button bar_chat, Pane group_bar_chat, boolean toggle) {
        if (toggle) {
            bar_chat.setStyle("-fx-background-image: url('/fxml/chat/img/system/chat_2.png')");
            group_bar_chat.setVisible(true);
        }
        else {
            bar_chat.setStyle("-fx-background-image: url('/fxml/chat/img/system/chat_0.png')");
            group_bar_chat.setVisible(false);
        }
    }

    // 切换：bar_friend
    private void switchBarFriend(Button bar_friend, Pane group_bar_friend, boolean toggle) {
        if (toggle) {
            bar_friend.setStyle("-fx-background-image: url('/fxml/chat/img/system/friend_2.png')");
            group_bar_friend.setVisible(true);
        }
        else {
            bar_friend.setStyle("-fx-background-image: url('/fxml/chat/img/system/friend_0.png')");
            group_bar_friend.setVisible(false);
        }
    }
}
