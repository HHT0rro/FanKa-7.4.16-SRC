package com.ishumei.smantifraud.l111l11111I1l;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.huawei.hms.feature.dynamic.f.e;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l11111lIl {
    public static int l1111l111111Il() {
        Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
        if (context == null) {
            return 0;
        }
        return context.getApplicationInfo().targetSdkVersion;
    }

    public static String l1111l111111Il(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            return ((X509Certificate) CertificateFactory.getInstance(e.f29912b).generateCertificate(new ByteArrayInputStream((byte[]) com.ishumei.smantifraud.l111l1111llIl.l111l11111I1l.l1111l111111Il(obj, "toByteArray")))).getSubjectDN().toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static Map<String, String> l1111l111111Il(Context context) {
        HashMap hashMap = new HashMap();
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            String str = resolveActivity != null ? resolveActivity.activityInfo.packageName : null;
            hashMap.put("pkg", str);
            if (str != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
                StringBuilder sb2 = new StringBuilder();
                sb2.append((Object) packageManager.getApplicationLabel(applicationInfo));
                hashMap.put("label", sb2.toString());
                hashMap.put("ver", packageManager.getPackageInfo(str, 0).versionName);
            }
        } catch (Throwable unused) {
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    private static Object[] l1111l111111Il(String str) {
        Object[] objArr;
        Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
        if (context == null) {
            return null;
        }
        try {
            Object l1111l111111Il = com.ishumei.smantifraud.l111l1111llIl.l111l11111I1l.l1111l111111Il(context.getPackageManager(), "getPackageInfo", new Class[]{String.class, Integer.TYPE}, new Object[]{str, 64});
            if (l1111l111111Il != null && (objArr = (Object[]) com.ishumei.smantifraud.l111l1111llIl.l111l11111I1l.l111l11111lIl(l1111l111111Il, "signatures")) != null) {
                if (objArr.length > 0) {
                    return objArr;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String l111l11111I1l() {
        Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
        if (context == null && (context = com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l1111l111111Il()) == null) {
            return null;
        }
        try {
            return (String) com.ishumei.smantifraud.l111l1111llIl.l111l11111I1l.l1111l111111Il(context, "getPackageName");
        } catch (Exception unused) {
            return "";
        }
    }

    public static Object l111l11111Il() {
        Object[] l1111l111111Il;
        Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
        if (context == null || (l1111l111111Il = l1111l111111Il(context.getPackageName())) == null || l1111l111111Il.length <= 0) {
            return null;
        }
        return l1111l111111Il[0];
    }

    public static String l111l11111lIl() {
        Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
        if (context == null && (context = com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l1111l111111Il()) == null) {
            return null;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(l111l11111I1l(), 0).versionName;
            return str == null ? "" : str;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String l111l11111lIl(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity != null) {
            return resolveActivity.activityInfo.packageName;
        }
        return null;
    }

    public static int l111l1111l1Il() {
        return (com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il.getApplicationInfo().flags & 2) > 0 ? 1 : 0;
    }

    public static Map<String, String> l111l1111lI1l() {
        try {
            HashMap hashMap = new HashMap();
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("getPackageManager", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(cls, new Object[0]);
            Class<?> cls2 = invoke instanceof Proxy ? Proxy.getInvocationHandler(invoke).getClass() : null;
            if (invoke != null && !invoke.getClass().getName().equals("android.content.pm.IPackageManager$Stub$Proxy")) {
                hashMap.put("pm", invoke.getClass().getName());
            }
            if (cls2 != null) {
                hashMap.put("proxy", cls2.getName());
            }
            if (hashMap.isEmpty()) {
                return null;
            }
            return hashMap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Map<String, Long> l111l1111llIl() {
        try {
            PackageInfo packageInfo = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il.getPackageManager().getPackageInfo(l111l11111I1l(), 0);
            HashMap hashMap = new HashMap();
            hashMap.put("fit", Long.valueOf(packageInfo.firstInstallTime));
            hashMap.put("lut", Long.valueOf(packageInfo.lastUpdateTime));
            return hashMap;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
