package com.xielei.ui.view;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * 这里将一些公用的方法和事件操作抽象为父类，共所有的框体使用
 *
 * @author xielei
 * @date 2023/5/15 09:24
 */
public abstract class UIObject extends Stage {

    protected Parent root;

    private double xOffset;

    private double yOffset;

    public <T> T $(String id, Class<T> clazz) {
        return (T) root.lookup("#" + id);
    }

    public void clearViewListSelectedAll(ListView<Pane>... listViews) {
        for (ListView<Pane> listView : listViews) {
            listView.getSelectionModel().clearSelection();
        }
    }

    /**
     * 这里的root是我们整个登陆窗体的元素面板，可以通过它来设置一些行为设置或者还可以通过ID查找根里面还有的元素root.lookup
     * 在我们所有使用的桌面程序里，都是可以通过鼠标拖拽来移动位置的。那么这里我们是定义三个鼠标事件，来实现窗体的移动，如下；
     * setOnMousePressed；鼠标按下事件，这个时候记录窗体位置
     * setOnMouseDragged；鼠标拖动事件，这个设置setX、setY
     * setOnMouseReleased；鼠标释放事件，这个时候恢复默认鼠标样式，最终完成了整个窗口的拖拽过程
     */
    public void move() {
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = getX() - event.getScreenX();
                yOffset = getY() - event.getScreenY();
                root.setCursor(Cursor.CLOSED_HAND);
            }
        });


        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setX(event.getScreenX() + xOffset);
                setY(event.getScreenY() + yOffset);
            }
        });


        root.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                root.setCursor(Cursor.DEFAULT);
            }
        });
    }

    /**
     * 初始化页面
     */
    public abstract void initView();

    /**
     * 初始化事件定义
     */
    public abstract void initEventDefine();

}
