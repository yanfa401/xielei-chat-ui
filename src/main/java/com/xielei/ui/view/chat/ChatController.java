package com.xielei.ui.view.chat;

import java.util.Date;

import com.xielei.ui.util.CacheUtil;
import com.xielei.ui.util.Ids;
import com.xielei.ui.view.chat.element.group_bar_chat.ElementTalk;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xielei
 * @date 2023/5/15 16:49
 */
@Slf4j
public class ChatController extends ChatInit implements IChatMethod {

    private ChatEventDefine chatEventDefine;

    @Override
    public void initView() {

    }

    @Override
    public void initEventDefine() {
        chatEventDefine = new ChatEventDefine(this);
    }

    @Override
    public void doShow() {
        super.show();
    }

    @Override
    public void addTalkBox(int index, int talkType, String talkId, final String talkName, String talkHead, String talkSketch, Date talkDate, Boolean selected) {
        // 填充到对话框
        final ListView<Pane> talkList = $("talkList", ListView.class);

        // 判断会话框是否有该对象
        ElementTalk elementTalk = CacheUtil.talkMap.get(talkId);
        if (elementTalk != null) {
            Node talkNode = talkList.lookup("#" + Ids.ElementTalkId.createTalkPaneId(talkId));
            if (talkNode == null) {
                talkList.getItems().add(index, elementTalk.pane());
            }
            if (selected) {
                // 设置选中
                talkList.getSelectionModel().select(elementTalk.pane());
            }
            return;
        }

        // 初始化对话框元素
        final ElementTalk talkElement = new ElementTalk(talkId, talkType, talkName, talkHead, talkSketch, talkDate);
        CacheUtil.talkMap.put(talkId, talkElement);

        // 填充到对话框
        ObservableList<Pane> items = talkList.getItems();
        final Pane talkElementPane = talkElement.pane();
        if (index >= 0) {
            // 添加到指定位置, 一般是第一个位置
            items.add(index, talkElementPane);
        }
        else {
            // 顺序添加
            items.add(talkElementPane);
        }

        if (selected) {
            // 设置选中
            talkList.getSelectionModel().select(talkElementPane);
        }

        // 注册对话框元素点击事件
        talkElementPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                log.debug("点击对话框:" + talkName);
            }
        });

        // 注册鼠标事件 [移入&移出]
        talkElementPane.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                talkElement.delete().setVisible(true);
            }
        });

        talkElementPane.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                talkElement.delete().setVisible(false);
            }
        });

        // 从对话框中删除
        talkElement.delete().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // 移除当前panel元素
                talkList.getItems().remove(talkElementPane);
                talkElement.clearMsgSketch();
            }
        });

    }
}
