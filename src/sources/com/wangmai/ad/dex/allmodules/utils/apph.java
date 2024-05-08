package com.wangmai.ad.dex.allmodules.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.huawei.openalliance.ad.ipc.c;
import com.wangmai.common.utils.DebugLog;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: CrashHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class apph implements Thread.UncaughtExceptionHandler {
    private static apph appd;

    /* renamed from: appa, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f46844appa;
    private Context appb;
    private Map<String, String> appc = new HashMap();

    private apph() {
    }

    public static apph appa() {
        if (appd == null) {
            synchronized (apph.class) {
                if (appd == null) {
                    appd = new apph();
                }
            }
        }
        return appd;
    }

    public void appb(Context context) {
        this.appb = context.getApplicationContext();
        this.f46844appa = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        appa.appa.appf.appd.appb("CrashHandler", "uncaughtException:" + th.toString());
        if (!appa(th) && (uncaughtExceptionHandler = this.f46844appa) != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        try {
            Thread.sleep(c.Code);
        } catch (InterruptedException e2) {
            DebugLog.release_e("CrashHandler", "uncaughtException:" + e2.toString());
        }
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    private String appb(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("*start*");
        for (Map.Entry<String, String> entry : this.appc.entrySet()) {
            stringBuffer.append(entry.getKey() + "=" + entry.getValue() + "\n");
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        stringBuffer.append(stringWriter.toString());
        stringBuffer.append("*end*");
        appf.appa(this.appb, "", stringBuffer.toString());
        return null;
    }

    private boolean appa(Throwable th) {
        if (th == null) {
            return false;
        }
        appa(this.appb);
        appb(th);
        return true;
    }

    public void appa(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            if (packageInfo != null) {
                String str = packageInfo.versionName == null ? "null" : packageInfo.versionName;
                String str2 = packageInfo.versionCode + "";
                this.appc.put(TTDownloadField.TT_VERSION_NAME, str);
                this.appc.put("versionCode", str2);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            DebugLog.release_e("CrashHandler", "CrashHandler1:" + e2.toString());
        }
        for (Field field : Build.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                this.appc.put(field.getName(), field.get(null).toString());
            } catch (Throwable th) {
                DebugLog.release_e("CrashHandler", "CrashHandler2:" + th.toString());
            }
        }
    }
}
