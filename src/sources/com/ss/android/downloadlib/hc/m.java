package com.ss.android.downloadlib.hc;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.u;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m {

    /* renamed from: com.ss.android.downloadlib.hc.m$m, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0580m implements InvocationHandler {

        /* renamed from: m, reason: collision with root package name */
        private Object f38778m;

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if ("startActivity".contains(method.getName())) {
                    m.m(objArr);
                }
            } catch (Throwable unused) {
            }
            return method.invoke(this.f38778m, objArr);
        }

        private C0580m(Object obj) {
            this.f38778m = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ej() {
        Field declaredField;
        try {
            if (Build.VERSION.SDK_INT < 26) {
                declaredField = Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault");
            } else {
                declaredField = Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            }
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 == null) {
                return;
            }
            Class<?> cls = Class.forName("android.app.IActivityManager");
            declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new C0580m(obj2)));
        } catch (Throwable unused) {
        }
    }

    public static String m(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.m.ej.m(new File(str));
    }

    public static String dk(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = com.ss.android.downloadlib.addownload.c.getContext().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static int m(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return 5;
        }
        return com.ss.android.m.ej.m(str, new File(str2));
    }

    public static void m() {
        if (com.ss.android.downloadlib.addownload.c.w().optInt("hook", 0) != 1) {
            return;
        }
        com.ss.android.downloadlib.l.m().m(new Runnable() { // from class: com.ss.android.downloadlib.hc.m.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.n.np.e();
                m.ej();
            }
        }, 10000L);
    }

    public static void m(Object[] objArr) {
        if (com.ss.android.downloadlib.addownload.c.w().optInt("hook", 0) == 1 && (objArr[1] instanceof String) && (objArr[2] instanceof Intent)) {
            Intent intent = (Intent) objArr[2];
            if ("android.intent.action.VIEW".equals(intent.getAction()) && DownloadConstants.MIME_APK.equals(intent.getType())) {
                if (com.ss.android.socialbase.appdownloader.n.np.l()) {
                    String optString = com.ss.android.downloadlib.addownload.c.w().optString("hook_vivo_arg", "com.android.settings");
                    if ("null".equals(optString)) {
                        return;
                    }
                    objArr[1] = optString;
                    return;
                }
                if (com.ss.android.socialbase.appdownloader.n.np.np()) {
                    String optString2 = com.ss.android.downloadlib.addownload.c.w().optString("hook_kllk_arg1", "com." + DownloadConstants.LOWER_OPPO + ".market");
                    if (!"null".equals(optString2)) {
                        objArr[1] = optString2;
                    }
                    String optString3 = com.ss.android.downloadlib.addownload.c.w().optString("hook_kllk_arg2", "com.android.browser");
                    String optString4 = com.ss.android.downloadlib.addownload.c.w().optString("hook_kllk_arg3", "m.store." + DownloadConstants.LOWER_OPPO + "mobile.com");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(DownloadConstants.LOWER_OPPO);
                    sb2.append("_extra_pkg_name");
                    intent.putExtra(sb2.toString(), optString3);
                    intent.putExtra("refererHost", optString4);
                    if (com.ss.android.downloadlib.addownload.c.w().optInt("hook_kllk_arg4", 0) == 1) {
                        Intent intent2 = new Intent();
                        intent2.putExtra(DownloadConstants.LOWER_OPPO + "_extra_pkg_name", optString3);
                        intent2.putExtra("refererHost", optString4);
                        intent.putExtra("android.intent.extra.INTENT", intent2);
                        return;
                    }
                    return;
                }
                if (com.ss.android.socialbase.appdownloader.n.np.m()) {
                    String optString5 = com.ss.android.downloadlib.addownload.c.w().optString("hook_huawei_arg1", u.W);
                    if (!"null".equals(optString5)) {
                        objArr[1] = optString5;
                    }
                    intent.putExtra("caller_package", com.ss.android.downloadlib.addownload.c.w().optString("hook_huawei_arg2", u.W));
                }
            }
        }
    }
}
