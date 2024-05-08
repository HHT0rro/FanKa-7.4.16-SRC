package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class cj {

    /* renamed from: b, reason: collision with root package name */
    public static final String f10033b = "404";

    /* renamed from: c, reason: collision with root package name */
    public final bs f10041c = bs.a();

    /* renamed from: g, reason: collision with root package name */
    private Context f10042g;

    /* renamed from: a, reason: collision with root package name */
    public static final String f10032a = x.f10417b;

    /* renamed from: f, reason: collision with root package name */
    private static cj f10036f = new cj();

    /* renamed from: d, reason: collision with root package name */
    public static volatile String f10034d = "";

    /* renamed from: e, reason: collision with root package name */
    public static volatile String f10035e = "";

    /* renamed from: h, reason: collision with root package name */
    private static AtomicBoolean f10037h = new AtomicBoolean(false);

    /* renamed from: i, reason: collision with root package name */
    private static String f10038i = "";

    /* renamed from: j, reason: collision with root package name */
    private static AtomicBoolean f10039j = new AtomicBoolean(false);

    /* renamed from: k, reason: collision with root package name */
    private static String f10040k = "";

    private cj() {
    }

    public static cj a() {
        return f10036f;
    }

    private String d() {
        String str = ck.f10047e;
        if (!ck.f10046d.equals(str)) {
            return str;
        }
        try {
            double b4 = by.b(by.a(this.f10042g));
            return b4 > ShadowDrawableWrapper.COS_45 ? String.valueOf(b4) : str;
        } catch (Throwable th) {
            this.f10041c.a(th);
            return str;
        }
    }

    public String b() {
        try {
            if (f10037h.compareAndSet(false, true)) {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                String str = (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
                if (!TextUtils.isEmpty(str)) {
                    f10038i = str;
                }
            }
            return f10038i;
        } catch (Throwable th) {
            this.f10041c.a(th);
            return f10038i;
        }
    }

    public String c() {
        try {
            if (f10039j.get()) {
                return f10040k;
            }
            if (!f10037h.get()) {
                b();
            }
            if (f10038i.equalsIgnoreCase("")) {
                f10039j.set(true);
                return "";
            }
            if (f10039j.compareAndSet(false, true)) {
                String a10 = a("hw_sc.build.platform.version", "");
                if (!TextUtils.isEmpty(a10)) {
                    f10040k = a10;
                }
            }
            return f10040k;
        } catch (Throwable th) {
            this.f10041c.a(th);
            return f10040k;
        }
    }

    public void a(Context context) {
        if (this.f10042g == null) {
            this.f10042g = context;
        }
    }

    public void a(String str, String str2, String str3) {
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ad", str3);
            hashMap.put("stacktrace", str2);
            a(str, f10033b, hashMap);
        } catch (Exception e2) {
            this.f10041c.a(e2);
        }
    }

    private void a(String str, String str2, HashMap<String, String> hashMap) {
        Uri.Builder builder = new Uri.Builder();
        try {
            Uri.Builder appendQueryParameter = builder.appendQueryParameter("type", str2).appendQueryParameter("p_ver", "9.332").appendQueryParameter("appsid", a("appsid", new Object[0])).appendQueryParameter(com.kuaishou.weapon.p0.t.f36218c, "android_" + d() + "_" + ck.f10048f);
            Context context = this.f10042g;
            appendQueryParameter.appendQueryParameter("pack", context != null ? context.getPackageName() : "").appendQueryParameter("sn", a("encodedSn", this.f10042g)).appendQueryParameter("cuid", a("encodedCUID", this.f10042g)).appendQueryParameter("os", "android").appendQueryParameter("osv", bk.a(this.f10042g).c()).appendQueryParameter("romn", b()).appendQueryParameter("romv", c()).appendQueryParameter("bdr", "" + bk.a(this.f10042g).a()).appendQueryParameter("brd", "" + a(bk.a(this.f10042g).e()));
            if (str != null && str.length() > 128) {
                int indexOf = str.indexOf(10);
                if (indexOf <= 0) {
                    indexOf = 127;
                }
                str = str.substring(0, indexOf);
            }
            builder.appendQueryParameter("reason", str);
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    builder.appendQueryParameter(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            this.f10041c.a(th);
        }
        an anVar = new an(f10032a, "POST");
        anVar.a(builder);
        anVar.b();
    }

    private String a(String str, Object... objArr) {
        IXAdContainerFactory c4;
        aa a10 = aa.a();
        if (a10 == null || (c4 = a10.c()) == null) {
            return "";
        }
        Object remoteParam = c4.getRemoteParam(str, objArr);
        return remoteParam instanceof String ? (String) remoteParam : "";
    }

    private String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            this.f10041c.a(th);
            return str2;
        }
    }
}
