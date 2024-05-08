package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class aj {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f35766b = {"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/cache/", "/data/", "/dev/"};

    /* renamed from: a, reason: collision with root package name */
    private Context f35767a;

    public aj(Context context) {
        this.f35767a = context;
    }

    public static boolean b() {
        String a10;
        try {
            a10 = bh.a("ro.build.display.id");
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(a10)) {
            return false;
        }
        if (a10.contains("flyme")) {
            return true;
        }
        return a10.toLowerCase().contains("flyme");
    }

    public int a() {
        boolean z10;
        try {
            String[] a10 = a(bi.f35856z);
            int length = a10.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    z10 = false;
                    break;
                }
                if (new File(a10[i10], bi.f35855y).exists()) {
                    z10 = true;
                    break;
                }
                i10++;
            }
        } catch (Exception unused) {
        }
        return z10 ? 1 : 0;
    }

    public String c() {
        try {
            if (Build.VERSION.SDK_INT > 29) {
                return null;
            }
            return aa.a().b("su -v").replace("\n", "");
        } catch (Exception unused) {
            return null;
        }
    }

    public int d() {
        String a10 = aa.a().a("ro.secure");
        return (a10 == null || !"0".equals(a10)) ? 1 : 0;
    }

    public int e() {
        String a10 = aa.a().a("ro.debuggable");
        return (a10 == null || !"0".equals(a10)) ? 1 : 0;
    }

    public int f() {
        String a10 = aa.a().a("ro.adb.secure");
        return (a10 == null || !"0".equals(a10)) ? 1 : 0;
    }

    public JSONObject g() {
        try {
            JSONObject jSONObject = new JSONObject();
            String a10 = a(" which su ");
            if (!TextUtils.isEmpty(a10) && a10.length() > 2) {
                jSONObject.put("0", 1);
                jSONObject.put("0-p", a10);
            } else {
                jSONObject.put("0", 0);
            }
            String a11 = a(" id ");
            if (!TextUtils.isEmpty(a11)) {
                if (a11.toLowerCase().contains("uid=0")) {
                    jSONObject.put("1", 1);
                } else {
                    jSONObject.put("1", 0);
                }
            }
            String a12 = a(" busybox df ");
            if (!TextUtils.isEmpty(a12) && !a12.contains("not found")) {
                if (a12.length() > 30) {
                    jSONObject.put("2", 1);
                } else {
                    jSONObject.put("2", 0);
                }
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public int h() {
        return new File("/system/app/Superuser.apk").exists() ? 1 : 0;
    }

    public String i() {
        for (String str : f35766b) {
            if (new File(str, "magisk").exists()) {
                return str + "magisk";
            }
        }
        return "";
    }

    public String j() {
        for (String str : f35766b) {
            if (new File(str, bi.f35855y).exists()) {
                return str + bi.f35855y;
            }
        }
        return "";
    }

    public String k() {
        try {
            throw new Exception("");
        } catch (Exception e2) {
            for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") || stackTraceElement.getMethodName().equals("invoked") || stackTraceElement.getMethodName().equals("main") || stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    return stackTraceElement.getClassName();
                }
            }
            return "";
        }
    }

    private String[] a(String[] strArr) {
        String str;
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        try {
            str = System.getenv("PATH");
        } catch (Exception unused) {
        }
        if (str != null && !"".equals(str)) {
            String[] split = str.split(com.huawei.openalliance.ad.constant.u.bD);
            int length = split.length;
            for (int i10 = 0; i10 < length; i10++) {
                String str2 = split[i10];
                if (!str2.endsWith("/")) {
                    str2 = str2 + IOUtils.DIR_SEPARATOR_UNIX;
                }
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String a(String str) {
        try {
            return aa.a().b(str).replace("\n", "");
        } catch (Exception unused) {
            return "";
        }
    }
}
