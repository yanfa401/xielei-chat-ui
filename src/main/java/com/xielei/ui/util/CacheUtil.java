package com.xielei.ui.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.xielei.ui.view.chat.element.group_bar_chat.ElementTalk;

/**
 * @author xielei
 * @date 2023/5/17 13:34
 */
public abstract class CacheUtil {

    public static final Map<String, ElementTalk> talkMap = new ConcurrentHashMap<>();
}
