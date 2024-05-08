package com.wangmai.ad.dex.allmodules.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: PathUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appq {
    public static String appj;
    private static final Object appk = new Object();
    private static File appl;
    private static appq appm;

    /* renamed from: appa, reason: collision with root package name */
    private File f46859appa = null;
    private File appb = null;
    private File appc = null;
    private File appd = null;
    private File appe = null;
    private File appf = null;
    private File appg = null;
    private File apph;
    private File appi;

    public static appq appd() {
        appq appqVar;
        synchronized (appk) {
            if (appm == null) {
                appm = new appq();
            }
            appqVar = appm;
        }
        return appqVar;
    }

    private static File appe(String str, String str2, Context context) {
        String str3;
        if (str == null) {
            str3 = appj + str2 + "/image/";
        } else {
            str3 = appj + str + "/" + str2 + "/image/";
        }
        return new File(appa(context), str3);
    }

    private static File appf(String str, String str2, Context context) {
        String str3;
        if (str == null) {
            str3 = appj + str2 + "/image/thumb/";
        } else {
            str3 = appj + str + "/" + str2 + "/image/thumb/";
        }
        return new File(appa(context), str3);
    }

    private static File appg(String str, String str2, Context context) {
        String str3;
        if (str == null) {
            str3 = appj + str2 + "/other/";
        } else {
            str3 = appj + str + "/" + str2 + "/other/";
        }
        return new File(appa(context), str3);
    }

    private static File apph(String str, String str2, Context context) {
        String str3;
        if (str == null) {
            str3 = appj + str2 + "/video/";
        } else {
            str3 = appj + str + "/" + str2 + "/video/";
        }
        return new File(appa(context), str3);
    }

    private static File appi(String str, String str2, Context context) {
        String str3;
        if (str == null) {
            str3 = appj + str2 + "/video";
        } else {
            str3 = appj + str + "/" + str2 + "/video";
        }
        return new File(appa(context), str3);
    }

    private static File appj(String str, String str2, Context context) {
        String str3;
        if (str == null) {
            str3 = appj + str2 + "/voice/";
        } else {
            str3 = appj + str + "/" + str2 + "/voice/";
        }
        return new File(appa(context), str3);
    }

    public void appa(String str, String str2, Context context) {
        String packageName = context.getPackageName();
        appa.appa.appf.appd.appa("PathUtil", "initDirs-str:" + packageName);
        appj = "/Cloudy/data/" + packageName + "/";
        this.f46859appa = appj(str, str2, context);
        if (!this.f46859appa.exists()) {
            this.f46859appa.mkdirs();
        }
        this.appb = appe(str, str2, context);
        if (!this.appb.exists()) {
            this.appb.mkdirs();
        }
        this.appc = appd(str, str2, context);
        if (!this.appc.exists()) {
            this.appc.mkdirs();
        }
        this.appe = appc(str, str2, context);
        if (!this.appe.exists()) {
            this.appe.mkdirs();
        }
        this.appd = appf(str, str2, context);
        if (!this.appd.exists()) {
            this.appd.mkdirs();
        }
        this.appf = apph(str, str2, context);
        if (!this.appf.exists()) {
            this.appf.mkdirs();
        }
        this.appg = appi(str, str2, context);
        if (!this.appg.exists()) {
            this.appg.mkdirs();
        }
        this.apph = appb(str, str2, context);
        if (this.apph.exists()) {
            return;
        }
        this.appi = appg(str, str2, context);
        if (this.appi.exists()) {
            return;
        }
        this.apph.mkdirs();
    }

    public File appb() {
        if (!this.appi.exists()) {
            this.appi.mkdirs();
        }
        return this.appi;
    }

    public File appc() {
        if (!this.appf.exists()) {
            this.appf.mkdirs();
        }
        return this.appf;
    }

    private static File appb(String str, String str2, Context context) {
        String str3;
        if (str == null) {
            str3 = appj + str2 + "/file/";
        } else {
            str3 = appj + str + "/" + str2 + "/file/";
        }
        return new File(appa(context), str3);
    }

    private static File appc(String str, String str2, Context context) {
        String str3;
        if (str == null) {
            str3 = appj + str2 + "/chat/";
        } else {
            str3 = appj + str + "/" + str2 + "/chat/";
        }
        return new File(appa(context), str3);
    }

    private static File appd(String str, String str2, Context context) {
        String str3;
        if (str == null) {
            str3 = appj + str2 + "/image/head/";
        } else {
            str3 = appj + str + "/" + str2 + "/image/head/";
        }
        return new File(appa(context), str3);
    }

    public File appa() {
        if (!this.apph.exists()) {
            this.apph.mkdirs();
        }
        return this.apph;
    }

    private static File appa(Context context) {
        if (appl == null) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory.exists()) {
                return externalStorageDirectory;
            }
            appl = context.getFilesDir();
        }
        return appl;
    }
}
