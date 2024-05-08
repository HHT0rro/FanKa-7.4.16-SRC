package com.alipay.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.mobilesecuritysdk.face.SecurityClientMobile;
import com.alipay.sdk.app.i;
import com.alipay.sdk.util.n;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4592a = "virtualImeiAndImsi";

    /* renamed from: b, reason: collision with root package name */
    private static final String f4593b = "virtual_imei";

    /* renamed from: c, reason: collision with root package name */
    private static final String f4594c = "virtual_imsi";

    /* renamed from: d, reason: collision with root package name */
    private static c f4595d;

    /* renamed from: e, reason: collision with root package name */
    private String f4596e;

    /* renamed from: f, reason: collision with root package name */
    private String f4597f = "sdk-and-lite";

    /* renamed from: g, reason: collision with root package name */
    private String f4598g;

    private c() {
        String a10 = i.a();
        if (i.b()) {
            return;
        }
        this.f4597f += '_' + a10;
    }

    public static synchronized c b() {
        c cVar;
        synchronized (c.class) {
            if (f4595d == null) {
                f4595d = new c();
            }
            cVar = f4595d;
        }
        return cVar;
    }

    private String e() {
        return "1";
    }

    private String f() {
        return "-1;-1";
    }

    private String g() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    public String c() {
        String b4;
        Context b10 = com.alipay.sdk.sys.b.a().b();
        SharedPreferences sharedPreferences = b10.getSharedPreferences(f4592a, 0);
        String string = sharedPreferences.getString(f4593b, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(com.alipay.sdk.tid.b.a(b10).a())) {
            b4 = g();
        } else {
            b4 = com.alipay.sdk.util.a.a(b10).b();
        }
        String str = b4;
        sharedPreferences.edit().putString(f4593b, str).commit();
        return str;
    }

    public String d() {
        String a10;
        Context b4 = com.alipay.sdk.sys.b.a().b();
        SharedPreferences sharedPreferences = b4.getSharedPreferences(f4592a, 0);
        String string = sharedPreferences.getString(f4594c, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(com.alipay.sdk.tid.b.a(b4).a())) {
            String e2 = com.alipay.sdk.sys.b.a().e();
            if (TextUtils.isEmpty(e2)) {
                a10 = g();
            } else {
                a10 = e2.substring(3, 18);
            }
        } else {
            a10 = com.alipay.sdk.util.a.a(b4).a();
        }
        String str = a10;
        sharedPreferences.edit().putString(f4594c, str).commit();
        return str;
    }

    public String a() {
        return this.f4598g;
    }

    public synchronized void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(com.alipay.sdk.sys.b.a().b()).edit().putString(com.alipay.sdk.cons.b.f4547i, str).commit();
        com.alipay.sdk.cons.a.f4520c = str;
    }

    private String b(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    private String b(Context context, HashMap<String, String> hashMap) {
        try {
            return (String) Executors.newFixedThreadPool(2).submit(new d(this, context, hashMap)).get(com.huawei.openalliance.ad.ipc.c.Code, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4435e, com.alipay.sdk.app.statistic.c.f4440j, th);
            return "";
        }
    }

    private String c(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getSSID() : "-1";
    }

    public String a(com.alipay.sdk.tid.b bVar) {
        Context b4 = com.alipay.sdk.sys.b.a().b();
        com.alipay.sdk.util.a a10 = com.alipay.sdk.util.a.a(b4);
        if (TextUtils.isEmpty(this.f4596e)) {
            this.f4596e = "Msp/15.6.2 (" + n.b() + ";" + n.c() + ";" + n.d(b4) + ";" + n.g(b4) + ";" + n.e(b4) + ";" + b(b4);
        }
        String b10 = com.alipay.sdk.util.a.b(b4).b();
        String h10 = n.h(b4);
        String e2 = e();
        String a11 = a10.a();
        String b11 = a10.b();
        String d10 = d();
        String c4 = c();
        if (bVar != null) {
            this.f4598g = bVar.b();
        }
        String replace = Build.MANUFACTURER.replace(";", " ");
        String replace2 = Build.MODEL.replace(";", " ");
        boolean d11 = com.alipay.sdk.sys.b.d();
        String d12 = a10.d();
        String c10 = c(b4);
        String d13 = d(b4);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f4596e);
        sb2.append(";");
        sb2.append(b10);
        sb2.append(";");
        sb2.append(h10);
        sb2.append(";");
        sb2.append(e2);
        sb2.append(";");
        sb2.append(a11);
        sb2.append(";");
        sb2.append(b11);
        sb2.append(";");
        sb2.append(this.f4598g);
        sb2.append(";");
        sb2.append(replace);
        sb2.append(";");
        sb2.append(replace2);
        sb2.append(";");
        sb2.append(d11);
        sb2.append(";");
        sb2.append(d12);
        sb2.append(";");
        sb2.append(f());
        sb2.append(";");
        sb2.append(this.f4597f);
        sb2.append(";");
        sb2.append(d10);
        sb2.append(";");
        sb2.append(c4);
        sb2.append(";");
        sb2.append(c10);
        sb2.append(";");
        sb2.append(d13);
        if (bVar != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("tid", com.alipay.sdk.tid.b.a(b4).a());
            hashMap.put(com.alipay.sdk.cons.b.f4545g, com.alipay.sdk.sys.b.a().e());
            String b12 = b(b4, hashMap);
            if (!TextUtils.isEmpty(b12)) {
                sb2.append(";");
                sb2.append(b12);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    private String d(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getBSSID() : "00";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, HashMap<String, String> hashMap) {
        String str;
        try {
            str = SecurityClientMobile.GetApdid(context, hashMap);
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4435e, com.alipay.sdk.app.statistic.c.f4438h, th);
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4435e, com.alipay.sdk.app.statistic.c.f4439i, "apdid == null");
        }
        com.alipay.sdk.util.c.d("msp", "apdid:" + str);
        return str;
    }

    public String a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            sb2.append("(");
            sb2.append(packageName);
            sb2.append(";");
            sb2.append(packageInfo.versionCode);
            sb2.append(")");
            return sb2.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
