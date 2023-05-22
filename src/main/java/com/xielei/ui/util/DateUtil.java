package com.xielei.ui.util;

import java.util.Date;

/**
 * @author xielei
 * @date 2023/5/17 10:33
 */
public final class DateUtil {

    private DateUtil() {
        // empty
    }

    public static String simpleDate(Date date) {
        if (cn.hutool.core.date.DateUtil.isSameDay(new Date(), date)) {
            return cn.hutool.core.date.DateUtil.format(date, "HH:mm");
        }
        else {
            return cn.hutool.core.date.DateUtil.format(date, "yy/MM/dd");
        }
    }

}
