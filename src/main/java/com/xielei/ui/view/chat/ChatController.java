package com.xielei.ui.view.chat;

/**
 * @author xielei
 * @date 2023/5/15 16:49
 */
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
}
