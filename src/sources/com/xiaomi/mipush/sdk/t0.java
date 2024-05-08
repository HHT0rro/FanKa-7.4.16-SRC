package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.xiaomi.push.l7;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class t0 {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, String> f47079a = new HashMap<>();

    public static synchronized String a(Context context, String str) {
        String str2;
        synchronized (t0.class) {
            str2 = f47079a.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
        }
        return str2;
    }

    public static String b(d dVar) {
        int i10 = v0.f47085a[dVar.ordinal()];
        if (i10 == 1) {
            return "hms_push_token";
        }
        if (i10 == 2) {
            return "fcm_push_token";
        }
        if (i10 == 3) {
            return "cos_push_token";
        }
        if (i10 != 4) {
            return null;
        }
        return "ftos_push_token";
    }

    public static HashMap<String, String> c(Context context, d dVar) {
        StringBuilder sb2;
        ah ahVar;
        HashMap<String, String> hashMap = new HashMap<>();
        String b4 = b(dVar);
        if (TextUtils.isEmpty(b4)) {
            return hashMap;
        }
        int i10 = v0.f47085a[dVar.ordinal()];
        String str = null;
        ApplicationInfo applicationInfo = null;
        if (i10 != 1) {
            if (i10 == 2) {
                sb2 = new StringBuilder();
                sb2.append("brand:");
                ahVar = ah.FCM;
            } else if (i10 == 3) {
                sb2 = new StringBuilder();
                sb2.append("brand:");
                ahVar = ah.OPPO;
            } else if (i10 == 4) {
                sb2 = new StringBuilder();
                sb2.append("brand:");
                ahVar = ah.VIVO;
            }
            sb2.append(ahVar.name());
            sb2.append("~");
            sb2.append("token");
            sb2.append(com.huawei.openalliance.ad.constant.u.bD);
            sb2.append(a(context, b4));
            sb2.append("~");
            sb2.append("package_name");
            sb2.append(com.huawei.openalliance.ad.constant.u.bD);
            sb2.append(context.getPackageName());
            str = sb2.toString();
        } else {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (Exception e2) {
                fc.c.n(e2.toString());
            }
            str = "brand:" + y0.a(context).name() + "~token" + com.huawei.openalliance.ad.constant.u.bD + a(context, b4) + "~package_name" + com.huawei.openalliance.ad.constant.u.bD + context.getPackageName() + "~app_id" + com.huawei.openalliance.ad.constant.u.bD + (applicationInfo != null ? applicationInfo.metaData.getInt("com.huawei.hms.client.appid") : -1);
        }
        hashMap.put("RegInfo", str);
        return hashMap;
    }

    public static void d(Context context) {
        boolean z10 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String b4 = b(d.ASSEMBLE_PUSH_HUAWEI);
        String b10 = b(d.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(b4, "")) && TextUtils.isEmpty(sharedPreferences.getString(b10, ""))) {
            z10 = true;
        }
        if (z10) {
            h0.g(context).n(2, b4);
        }
    }

    public static boolean e(Context context, d dVar) {
        if (w0.c(dVar) != null) {
            return kc.j.d(context).i(w0.c(dVar).a(), true);
        }
        return false;
    }

    public static void f(Context context) {
        q0.e(context).b();
    }

    public static void g(Context context, d dVar, String str) {
        com.xiaomi.push.n.c(context).g(new u0(str, context, dVar));
    }

    public static void h(Context context) {
        q0.e(context).a();
    }

    public static synchronized void j(Context context, d dVar, String str) {
        synchronized (t0.class) {
            String b4 = b(dVar);
            if (TextUtils.isEmpty(b4)) {
                fc.c.i("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            l7.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(b4, str));
            fc.c.i("ASSEMBLE_PUSH : update sp file success!  " + str);
        }
    }
}
