package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ah {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35761a = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=";

    /* renamed from: b, reason: collision with root package name */
    private final String f35762b = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy";

    /* renamed from: c, reason: collision with root package name */
    private final String f35763c = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl";

    /* renamed from: d, reason: collision with root package name */
    private final String f35764d = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==";

    /* renamed from: e, reason: collision with root package name */
    private final String f35765e = "SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=";

    private void b(JSONObject jSONObject, int i10) {
        try {
            Object a10 = dh.a(new String(c.a(f35761a.getBytes(), 2)), (Object) null, "getPackageManager", new Object[0]);
            if (a10 != null) {
                a(a10, jSONObject, i10);
            }
        } catch (Exception unused) {
        }
    }

    private void c(JSONObject jSONObject, int i10) {
        Object a10;
        Object a11;
        try {
            if (Build.VERSION.SDK_INT < 29 || (a10 = dh.a(new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==".getBytes(), 2)), new String(c.a("SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=".getBytes(), 2)))) == null || (a11 = dh.a("android.util.Singleton", a10, MonitorConstants.CONNECT_TYPE_GET, new Object[0])) == null) {
                return;
            }
            a(a11, jSONObject, i10);
        } catch (Exception unused) {
        }
    }

    private void d(JSONObject jSONObject, int i10) {
        Object a10;
        try {
            Object a11 = dh.a(new String(c.a(f35761a.getBytes(), 2)), (Object) null, "currentActivityThread", new Object[0]);
            if (a11 == null || (a10 = dh.a(a11.getClass(), a11, "mInstrumentation")) == null) {
                return;
            }
            a(a10, jSONObject, i10);
        } catch (Exception unused) {
        }
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            b(jSONObject, 0);
            a(jSONObject, 1);
            c(jSONObject, 2);
            d(jSONObject, 3);
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private void a(JSONObject jSONObject, int i10) {
        Object a10;
        Object a11;
        try {
            String str = new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy".getBytes(), 2));
            String str2 = new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl".getBytes(), 2));
            if (Build.VERSION.SDK_INT >= 26) {
                a10 = dh.a(str, "IActivityManagerSingleton");
            } else {
                a10 = dh.a(str2, "gDefault");
            }
            if (a10 == null || (a11 = dh.a("android.util.Singleton", a10, MonitorConstants.CONNECT_TYPE_GET, new Object[0])) == null) {
                return;
            }
            a(a11, jSONObject, i10);
        } catch (Exception unused) {
        }
    }

    private boolean a(Object obj, JSONObject jSONObject, int i10) {
        if (jSONObject != null) {
            try {
                boolean isProxyClass = Proxy.isProxyClass(obj.getClass());
                String name = obj.getClass().getName();
                int i11 = 1;
                if (isProxyClass) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i10);
                    String sb3 = sb2.toString();
                    if (!isProxyClass) {
                        i11 = 0;
                    }
                    jSONObject.put(sb3, i11);
                    jSONObject.put(i10 + "-c", name);
                } else if (i10 == 3 && !name.contains("Instrumentation")) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(i10);
                    String sb5 = sb4.toString();
                    if (!isProxyClass) {
                        i11 = 0;
                    }
                    jSONObject.put(sb5, i11);
                    jSONObject.put(i10 + "-c", name);
                }
                return isProxyClass;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            PackageManager packageManager = context.getPackageManager();
            Object a10 = dh.a(packageManager.getClass(), packageManager, "mPM");
            if (a10 == null) {
                return null;
            }
            if (a(a10, jSONObject, 0)) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
