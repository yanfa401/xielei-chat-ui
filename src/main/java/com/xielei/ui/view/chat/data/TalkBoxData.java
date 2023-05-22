package com.xielei.ui.view.chat.data;

import lombok.Data;

/**
 * 单个对话框的属性
 *
 * @author xielei
 * @date 2023/5/17 10:55
 */
@Data
public class TalkBoxData {

    public TalkBoxData() {
    }

    public TalkBoxData(String talkId, Integer talkType, String talkName, String talkHead) {
        this.talkId = talkId;
        this.talkType = talkType;
        this.talkName = talkName;
        this.talkHead = talkHead;
    }

    /**
     * 对话Id
     */
    private String talkId;

    /**
     * 对话类型
     */
    private Integer talkType;

    /**
     * 对话名称
     */
    private String talkName;

    /**
     * 对话头像
     */
    private String talkHead;
}
