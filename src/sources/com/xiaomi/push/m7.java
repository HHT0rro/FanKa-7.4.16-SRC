package com.xiaomi.push;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class m7 {
    public static String a(String str, String str2) {
        try {
            return (String) n7.c(null, "android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(null, str, str2);
        } catch (Exception e2) {
            fc.c.i("SystemProperties.get: " + ((Object) e2));
            return str2;
        }
    }
}
