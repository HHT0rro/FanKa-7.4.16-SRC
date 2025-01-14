package com.jd.ad.sdk.jad_ob;

import android.os.Build;
import com.jd.ad.sdk.jad_ob.jad_dq;
import com.jd.ad.sdk.jad_sf.jad_an;

/* compiled from: JADOSIntoUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_fs {
    public static String jad_an() {
        String str = "";
        if (!jad_dq.jad_an.jad_an.jad_an("osVersion")) {
            return "";
        }
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("osVersion", true)) {
            str = jad_anVar.jad_dq("osVersion");
        } else {
            str = Build.VERSION.RELEASE;
            jad_anVar.jad_bo("osVersion", str);
        }
        return str;
    }

    public static String jad_bo() {
        if (!jad_dq.jad_an.jad_an.jad_an("osApiVersion")) {
            return "";
        }
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("osApiVersion", true)) {
            return jad_anVar.jad_dq("osApiVersion");
        }
        StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("");
        jad_an.append(Build.VERSION.SDK_INT);
        String sb2 = jad_an.toString();
        jad_anVar.jad_bo("osApiVersion", sb2);
        return sb2;
    }

    public static String jad_cp() {
        String str = "";
        if (!jad_dq.jad_an.jad_an.jad_an("ua")) {
            return "";
        }
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("ua", true)) {
            str = jad_anVar.jad_dq("ua");
        } else {
            str = System.getProperty("http.agent") + " JADYunSDK/2.4.6";
            jad_anVar.jad_bo("ua", str);
        }
        return str;
    }

    public static int jad_dq() {
        if (!jad_dq.jad_an.jad_an.jad_an("jdAppInstalled")) {
            return -1;
        }
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        if (jad_anVar.jad_an("jdAppInstalled", true)) {
            return jad_anVar.jad_cp("jdAppInstalled");
        }
        boolean jad_an = com.jd.ad.sdk.jad_do.jad_an.jad_an("com.jingdong.app.mall");
        jad_anVar.jad_bo("jdAppInstalled", Integer.valueOf(jad_an ? 1 : 0));
        return jad_an ? 1 : 0;
    }
}
