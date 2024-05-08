package com.alimm.tanx.core.utils;

import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class EncryptUtils implements NotConfused {
    public static final String TAG = "EncryptUtils";

    static {
        System.loadLibrary("tanx");
    }

    public static native byte[] d(String str, String str2);

    public static String decrypt(String str, boolean z10) {
        String str2;
        try {
        } catch (Exception e2) {
            LogUtils.e(TAG, e2.getMessage());
            if (z10) {
                TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, LogUtils.getStackTraceMessage(e2), "");
            }
            e2.printStackTrace();
            str = "";
        }
        if (TanxCoreSdk.getConfig().isDebugMode()) {
            if (SharedPreferencesHelper.getInstance().getEncryptBoolean()) {
                str2 = new String(d(str, TanxCoreSdk.getConfig().getAppKey()));
            }
            LogUtils.d(TAG, str);
            return str;
        }
        str2 = new String(d(str, TanxCoreSdk.getConfig().getAppKey()));
        str = str2;
        LogUtils.d(TAG, str);
        return str;
    }

    public static native byte[] e(String str, String str2);

    public static String encrypt(String str, boolean z10) {
        String str2;
        try {
        } catch (Exception e2) {
            LogUtils.e(TAG, e2.getMessage());
            if (z10) {
                TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, LogUtils.getStackTraceMessage(e2), "");
            }
            e2.printStackTrace();
            str = "";
        }
        if (TanxCoreSdk.getConfig().isDebugMode()) {
            if (SharedPreferencesHelper.getInstance().getEncryptBoolean()) {
                str2 = new String(e(str, TanxCoreSdk.getConfig().getAppKey()));
            }
            LogUtils.d(TAG, str);
            return str;
        }
        str2 = new String(e(str, TanxCoreSdk.getConfig().getAppKey()));
        str = str2;
        LogUtils.d(TAG, str);
        return str;
    }

    public static String decrypt(String str) {
        return decrypt(str, true);
    }

    public static String encrypt(String str) {
        return encrypt(str, true);
    }
}
