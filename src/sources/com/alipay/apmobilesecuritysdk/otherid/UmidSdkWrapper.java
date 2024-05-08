package com.alipay.apmobilesecuritysdk.otherid;

import android.content.Context;
import c0.d;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import z.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class UmidSdkWrapper {
    private static final String UMIDTOKEN_FILE_NAME = "xxxwww_v2";
    private static final String UMIDTOKEN_KEY_NAME = "umidtk";
    private static volatile String cachedUmidToken = "";
    private static volatile boolean initUmidFinished;

    private static String compatUmidBug(Context context, String str) {
        if (!a.d(str) && !a.e(str, "000000000000000000000000")) {
            return str;
        }
        String utdid = UtdidWrapper.getUtdid(context);
        if (utdid != null && utdid.contains(SymbolValues.QUESTION_EN_SYMBOL)) {
            utdid = "";
        }
        return a.d(utdid) ? "" : utdid;
    }

    public static synchronized String getSecurityToken(Context context) {
        String str;
        synchronized (UmidSdkWrapper.class) {
            str = cachedUmidToken;
        }
        return str;
    }

    public static String startUmidTaskSync(Context context, int i10) {
        return "";
    }

    private static synchronized void updateLocalUmidToken(Context context, String str) {
        synchronized (UmidSdkWrapper.class) {
            if (a.g(str)) {
                d.a(context, UMIDTOKEN_FILE_NAME, UMIDTOKEN_KEY_NAME, str);
                cachedUmidToken = str;
            }
        }
    }
}
