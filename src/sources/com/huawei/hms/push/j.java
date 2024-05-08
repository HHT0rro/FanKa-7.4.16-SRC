package com.huawei.hms.push;

import android.app.Notification;
import android.text.TextUtils;

/* compiled from: NotificationUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class j {
    public static k a(o oVar) {
        k kVar = k.STYLE_DEFAULT;
        return (oVar.v() < 0 || oVar.v() >= k.values().length) ? kVar : k.values()[oVar.v()];
    }

    public static void a(Notification.Builder builder, String str, o oVar) {
        Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
        if (!TextUtils.isEmpty(oVar.g())) {
            bigTextStyle.setBigContentTitle(oVar.g());
        }
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            bigTextStyle.bigText(str);
        }
        builder.setStyle(bigTextStyle);
    }
}
