package com.alibaba.security.common.utils;

import com.alibaba.security.common.log.RPLogging;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class CommonUtils {
    private static final String TAG = "CommonUtils";

    public static boolean checkWindVaneExist() {
        try {
            Class.forName("android.taobao.windvane.WindVaneSDK");
            Class.forName("android.taobao.windvane.extra.uc.WVUCWebView");
            return true;
        } catch (ClassNotFoundException unused) {
            RPLogging.d(TAG, "WindVane sdk is not exist");
            return false;
        }
    }

    public static String getExceptionMsg(Throwable th) {
        return th == null ? "" : th.getMessage();
    }

    public static String getStackTrace(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.printStackTrace(printWriter);
            return stringWriter.toString();
        } finally {
            printWriter.close();
        }
    }
}
