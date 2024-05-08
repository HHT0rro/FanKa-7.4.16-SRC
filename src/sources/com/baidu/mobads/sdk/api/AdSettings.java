package com.baidu.mobads.sdk.api;

import androidx.annotation.DrawableRes;
import com.baidu.mobads.sdk.internal.cl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AdSettings {
    public static String getSDKVersion() {
        return cl.c() + "";
    }

    public static void setNotificationChannel(String str) {
        CustomNotification.setNotificationChannel(str);
    }

    public static void setNotificationIcon(@DrawableRes int i10) {
        CustomNotification.setNotificationIcon(i10);
    }
}
