package com.xielei.ui.view.chat.element.group_bar_chat;

import java.util.Date;

import com.xielei.ui.util.DateUtil;
import com.xielei.ui.util.Ids;
import com.xielei.ui.view.chat.data.RemindCount;
import com.xielei.ui.view.chat.data.TalkBoxData;

import cn.hutool.core.util.IdUtil;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * 单个对话框
 *
 * @author xielei
 * @date 2023/5/17 10:17
 */
public class ElementTalk {

    /**
     * 初始化单个对话框元素信息
     *
     * @param talkId 对话id
     * @param talkType 对话类型, 单聊or群聊
     * @param talkName 对话人昵称
     * @param talkHead 对话人头像
     * @param talkContent 对话内容
     * @param talkDate 对话日期
     */
    public ElementTalk(String talkId, Integer talkType, String talkName, String talkHead, String talkContent, Date talkDate) {
        // 初始化对话面板
        pane = new Pane();
        pane.setId(Ids.ElementTalkId.createTalkPaneId(talkId));
        pane.setUserData(new TalkBoxData(talkId, talkType, talkName, talkHead));
        pane.setPrefSize(270, 80);
        pane.getStyleClass().add("talkElement");
        ObservableList<Node> children = pane.getChildren();

        // 头像区域
        head = new Label();
        head.setPrefSize(50, 50);
        head.setLayoutX(15);
        head.setLayoutY(15);
        head.getStyleClass().add("element_head");
        head.setStyle(String.format("-fx-background-image: url('/fxml/chat/img/head/%s.png')", talkHead));
        children.add(head);

        // 昵称区域
        nikeName = new Label();
        nikeName.setPrefSize(140, 25);
        nikeName.setLayoutX(80);
        nikeName.setLayoutY(15);
        nikeName.setText(talkName);
        nikeName.getStyleClass().add("element_nikeName");
        children.add(nikeName);

        // 信息简述
        msgSketch = new Label();
        msgSketch.setId(Ids.ElementTalkId.createMsgSketchId(talkId));
        msgSketch.setPrefSize(200, 25);
        msgSketch.setLayoutX(80);
        msgSketch.setLayoutY(40);
        msgSketch.getStyleClass().add("element_msgSketch");
        children.add(msgSketch);

        // 信息时间
        msgDate = new Label();
        msgDate.setId(Ids.ElementTalkId.createMsgDataId(talkId));
        msgDate.setPrefSize(60, 25);
        msgDate.setLayoutX(220);
        msgDate.setLayoutY(15);
        msgDate.getStyleClass().add("element_msgData");
        children.add(msgDate);
        // 填充；信息简述 & 信息时间
        fillMsgSketch(talkContent, talkDate);

        // 消息提醒
        msgRemind = new Label();
        msgRemind.setPrefSize(15, 15);
        msgRemind.setLayoutX(60);
        msgRemind.setLayoutY(5);
        msgRemind.setUserData(new RemindCount());
        msgRemind.setText("");
        msgRemind.setVisible(false);
        msgRemind.getStyleClass().add("element_msgRemind");
        children.add(msgRemind);

        // 删除对话框按钮
        delete = new Button();
        delete.setVisible(false);
        delete.setPrefSize(4, 4);
        delete.setLayoutY(26);
        delete.setLayoutX(-8);
        delete.getStyleClass().add("element_delete");
        children.add(delete);


    }

    /**
     * 对话面板
     */
    private final Pane pane;

    /**
     * 头像区域
     */
    private final Label head;

    /**
     * 昵称区域
     */
    private final Label nikeName;

    /**
     * 信息简述
     */
    private final Label msgSketch;

    /**
     * 信息时间
     */
    private final Label msgDate;

    /**
     * 消息提醒
     */
    private final Label msgRemind;

    /**
     * 删除对话框按钮
     */
    private final Button delete;


    public Pane pane() {
        return pane;
    }

    public Label msgRemind() {
        return msgRemind;
    }

    public Button delete() {
        return delete;
    }

    /**
     * 设置信息简述, 包含简要内容和最后消息时间
     * @param talkSketch
     * @param talkDate
     */
    public void fillMsgSketch(String talkSketch, Date talkDate) {
        if (talkSketch != null) {
            if (talkSketch.length() > 30) {
                talkSketch = talkSketch.substring(0, 30);
            }
            msgSketch.setText(talkSketch);
        }
        if (talkDate == null) {
            talkDate = new Date();
            msgDate.setText(DateUtil.simpleDate(talkDate));
        }
    }

    /**
     * 清空信息简述
     */
    public void clearMsgSketch() {
        msgSketch.setText("");
    }
}
