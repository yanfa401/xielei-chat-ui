package com.xielei.ui.view.chat.data;

import lombok.Data;

/**
 * 消息提醒条数
 *
 * @author xielei
 * @date 2023/5/17 11:08
 */
@Data
public class RemindCount {

    public RemindCount() {
    }

    public RemindCount(int count) {
        this.count = count;
    }

    /**
     * 消息提醒条数
     */
    private int count;
}
