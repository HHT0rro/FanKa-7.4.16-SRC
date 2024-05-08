package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class PayResultActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4367a = "{\"isLogin\":\"false\"}";

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap<String, Object> f4368b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public static final String f4369c = "hk.alipay.wallet";

    /* renamed from: d, reason: collision with root package name */
    public static final String f4370d = "phonecashier.pay.hash";

    /* renamed from: e, reason: collision with root package name */
    public static final String f4371e = "orderSuffix";

    /* renamed from: f, reason: collision with root package name */
    public static final String f4372f = "externalPkgName";

    /* renamed from: g, reason: collision with root package name */
    public static final String f4373g = "phonecashier.pay.result";

    /* renamed from: h, reason: collision with root package name */
    public static final String f4374h = "phonecashier.pay.resultOrderHash";

    /* renamed from: i, reason: collision with root package name */
    private static String f4375i;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static volatile String f4376a;

        /* renamed from: b, reason: collision with root package name */
        public static volatile String f4377b;
    }

    private static void a(Activity activity, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        Intent intent = new Intent();
        try {
            intent.setPackage(f4369c);
            intent.setData(Uri.parse("alipayhk://platformapi/startApp?appId=20000125&schemePaySession=" + URLEncoder.encode(str, "UTF-8") + "&orderSuffix=" + URLEncoder.encode(str2, "UTF-8") + "&packageName=" + URLEncoder.encode(str3, "UTF-8") + "&externalPkgName=" + URLEncoder.encode(str3, "UTF-8")));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            com.alipay.sdk.util.c.b("msp", "PayTask:payReuslt: UnsupportedEncodingException:" + ((Object) e2));
        }
        if (activity != null) {
            activity.startActivity(intent);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!TextUtils.isEmpty(intent.getStringExtra(f4371e))) {
            a.f4376a = intent.getStringExtra(f4370d);
            a(this, a.f4376a, intent.getStringExtra(f4371e), intent.getStringExtra(f4372f));
            a(this, 300);
            return;
        }
        String stringExtra = intent.getStringExtra(f4373g);
        int intExtra = intent.getIntExtra(f4374h, 0);
        if (intExtra != 0 && TextUtils.equals(a.f4376a, String.valueOf(intExtra))) {
            if (!TextUtils.isEmpty(stringExtra)) {
                a(stringExtra, a.f4376a);
            } else {
                a(a.f4376a);
            }
            a.f4376a = "";
            a(this, 300);
            return;
        }
        com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, com.alipay.sdk.app.statistic.c.P, "Expected " + a.f4376a + ", got " + intExtra);
        a(a.f4376a);
        a(this, 300);
    }

    private static void a(String str) {
        a.f4377b = j.c();
        a(f4368b, str);
    }

    private static void a(String str, String str2) {
        a.f4377b = str;
        a(f4368b, str2);
    }

    private static void a(Activity activity, int i10) {
        new Handler().postDelayed(new f(activity), i10);
    }

    private static boolean a(HashMap<String, Object> hashMap, String str) {
        Object obj;
        if (hashMap == null || str == null || (obj = hashMap.get(str)) == null) {
            return false;
        }
        synchronized (obj) {
            obj.notifyAll();
        }
        return true;
    }
}
