package com.alimm.tanx.core.utils;

import android.text.TextUtils;
import android.util.Log;
import com.alimm.tanx.core.SdkConstant;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ut.core.UtRequest;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class LogUtils implements NotConfused {
    public static final String LOG_TAG = "TanxAdSdk";
    public static final String[] tagCloseSwitch = {UtRequest.TAG, "TanxAdMonitor"};
    public static List<String> tagCloseSwitchList;

    public static void d(String str, String str2) {
        if (isDebugAndIsSwitch(str, "d")) {
            startPrint(LOG_TAG, "[" + str + "] " + str2, "d");
        }
    }

    public static void d2print(String str, String str2) {
        startPrint(LOG_TAG, "[" + str + "] " + str2, "d");
    }

    public static void e(String str, String str2) {
        e(str, str2, "");
    }

    public static String getLogString(String str, String... strArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        sb2.append(str);
        sb2.append("] ");
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str2)) {
                sb2.append(str2);
            }
        }
        return sb2.toString();
    }

    public static String getStackTraceMessage(Throwable th) {
        if (th == null) {
            return "本次throwable为null";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        return stringWriter.toString();
    }

    public static void i(String str, String str2) {
        if (isDebugAndIsSwitch(str, t.f36220e)) {
            startPrint(LOG_TAG, "[" + str + "] " + str2, t.f36220e);
        }
    }

    public static boolean isDebug(String str) {
        try {
            if (tagCloseSwitchList == null) {
                tagCloseSwitchList = Arrays.asList(tagCloseSwitch);
            }
            str.hashCode();
            if (!TanxCoreSdk.getConfig().isDebugMode()) {
                if (!Log.isLoggable(LOG_TAG, 2)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            e(e2);
            return false;
        }
    }

    public static boolean isDebugAndIsSwitch(String str, String str2) {
        boolean z10;
        try {
            if (tagCloseSwitchList == null) {
                tagCloseSwitchList = Arrays.asList(tagCloseSwitch);
            }
            z10 = !tagCloseSwitchList.contains(str);
        } catch (Exception e2) {
            e(e2);
            z10 = true;
        }
        return isDebug(str2) && z10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x0066. Please report as an issue. */
    public static void startPrint(String str, String str2, String str3) {
        String str4 = str2 + " [SDK Version:" + SdkConstant.getSdkVersion() + "]";
        int length = 2001 - str.length();
        str3.hashCode();
        char c4 = 65535;
        switch (str3.hashCode()) {
            case 100:
                if (str3.equals("d")) {
                    c4 = 0;
                    break;
                }
                break;
            case 101:
                if (str3.equals("e")) {
                    c4 = 1;
                    break;
                }
                break;
            case 105:
                if (str3.equals(t.f36220e)) {
                    c4 = 2;
                    break;
                }
                break;
            case 118:
                if (str3.equals(t.f36218c)) {
                    c4 = 3;
                    break;
                }
                break;
            case 119:
                if (str3.equals(IAdInterListener.AdReqParam.WIDTH)) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                while (str4.length() > length) {
                    str4.substring(0, length);
                    str4 = str4.substring(length);
                }
                return;
            case 1:
                while (str4.length() > length) {
                    str4.substring(0, length);
                    str4 = str4.substring(length);
                }
                return;
            case 2:
                while (str4.length() > length) {
                    str4.substring(0, length);
                    str4 = str4.substring(length);
                }
                return;
            case 3:
                while (str4.length() > length) {
                    str4.substring(0, length);
                    str4 = str4.substring(length);
                }
                return;
            case 4:
                while (str4.length() > length) {
                    str4.substring(0, length);
                    str4 = str4.substring(length);
                }
                return;
            default:
                return;
        }
    }

    public static void v(String str, String str2) {
        if (isDebugAndIsSwitch(str, t.f36218c)) {
            startPrint(LOG_TAG, "[" + str + "] " + str2, t.f36218c);
        }
    }

    public static void w(String str, String... strArr) {
        if (isDebugAndIsSwitch(str, IAdInterListener.AdReqParam.WIDTH)) {
            startPrint(LOG_TAG, getLogString(str, strArr), IAdInterListener.AdReqParam.WIDTH);
        }
    }

    public static void e(String str, String str2, String str3) {
        startPrint(LOG_TAG, "[" + str + "] " + str2, "e");
    }

    public static void d(String str, String str2, Throwable th) {
        if (isDebugAndIsSwitch(str, "d")) {
            startPrint(LOG_TAG, "[" + str + "] " + str2 + getStackTraceMessage(th), "d");
        }
    }

    public static void e(Exception exc) {
        e("", exc);
    }

    public static void i(String str, String... strArr) {
        if (isDebugAndIsSwitch(str, t.f36220e)) {
            startPrint(LOG_TAG, getLogString(str, strArr), t.f36220e);
        }
    }

    public static void e(String str, Exception exc) {
        e(str, exc, "");
    }

    public static void d(String str, String... strArr) {
        if (isDebugAndIsSwitch(str, "d")) {
            startPrint(LOG_TAG, getLogString(str, strArr), "d");
        }
    }

    public static void e(String str, Exception exc, String str2) {
        startPrint(LOG_TAG, "[" + str + "] " + getStackTraceMessage(exc), "e");
    }

    public static void e(String str, String str2, Throwable th) {
        startPrint(LOG_TAG, "[" + str + "] " + (str2 + getStackTraceMessage(th)), "e");
    }
}
