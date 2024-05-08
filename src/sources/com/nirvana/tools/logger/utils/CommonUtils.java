package com.nirvana.tools.logger.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CommonUtils {
    public static String getLimitIntervalIndex(int i10) {
        if (i10 == 0) {
            return getTodayData();
        }
        return getTodayData() + "-" + i10 + "-" + (Calendar.getInstance().get(11) / i10);
    }

    public static String getTodayData() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
