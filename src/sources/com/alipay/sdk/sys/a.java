package com.alipay.sdk.sys;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.n;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4660a = "\"&";

    /* renamed from: b, reason: collision with root package name */
    public static final String f4661b = "&";

    /* renamed from: c, reason: collision with root package name */
    public static final String f4662c = "bizcontext=\"";

    /* renamed from: d, reason: collision with root package name */
    public static final String f4663d = "bizcontext=";

    /* renamed from: e, reason: collision with root package name */
    public static final String f4664e = "\"";

    /* renamed from: f, reason: collision with root package name */
    public static final String f4665f = "appkey";

    /* renamed from: g, reason: collision with root package name */
    public static final String f4666g = "ty";

    /* renamed from: h, reason: collision with root package name */
    public static final String f4667h = "sv";

    /* renamed from: i, reason: collision with root package name */
    public static final String f4668i = "an";

    /* renamed from: j, reason: collision with root package name */
    public static final String f4669j = "setting";

    /* renamed from: k, reason: collision with root package name */
    public static final String f4670k = "av";

    /* renamed from: l, reason: collision with root package name */
    public static final String f4671l = "sdk_start_time";

    /* renamed from: m, reason: collision with root package name */
    public static final String f4672m = "UTF-8";

    /* renamed from: n, reason: collision with root package name */
    private String f4673n;

    /* renamed from: o, reason: collision with root package name */
    private String f4674o;

    /* renamed from: p, reason: collision with root package name */
    private Context f4675p;

    public a(Context context) {
        this.f4673n = "";
        this.f4674o = "";
        this.f4675p = null;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.f4673n = packageInfo.versionName;
            this.f4674o = packageInfo.packageName;
            this.f4675p = context.getApplicationContext();
        } catch (Exception unused) {
        }
    }

    private boolean b(String str) {
        return !str.contains(f4660a);
    }

    private String c(String str) {
        try {
            String a10 = a(str, "&", f4663d);
            if (TextUtils.isEmpty(a10)) {
                str = str + "&" + b(f4663d, "");
            } else {
                int indexOf = str.indexOf(a10);
                str = str.substring(0, indexOf) + a(a10, f4663d, "", true) + str.substring(indexOf + a10.length());
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    private String d(String str) {
        try {
            String a10 = a(str, f4660a, f4662c);
            if (TextUtils.isEmpty(a10)) {
                return str + "&" + b(f4662c, "\"");
            }
            if (!a10.endsWith("\"")) {
                a10 = a10 + "\"";
            }
            int indexOf = str.indexOf(a10);
            return str.substring(0, indexOf) + a(a10, f4662c, "\"", false) + str.substring(indexOf + a10.length());
        } catch (Throwable unused) {
            return str;
        }
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("new_external_info==")) {
            return str;
        }
        if (b(str)) {
            return c(str);
        }
        return d(str);
    }

    private String b(String str, String str2) throws JSONException, UnsupportedEncodingException {
        return str + a("", "") + str2;
    }

    private String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(str2);
        for (int i10 = 0; i10 < split.length; i10++) {
            if (!TextUtils.isEmpty(split[i10]) && split[i10].startsWith(str3)) {
                return split[i10];
            }
        }
        return null;
    }

    public String a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(f4665f, com.alipay.sdk.cons.a.f4521d);
            jSONObject.put(f4666g, "and_lite");
            jSONObject.put(f4667h, "h.a.3.6.2");
            if (!this.f4674o.contains(f4669j) || !n.b(this.f4675p)) {
                jSONObject.put(f4668i, this.f4674o);
            }
            jSONObject.put(f4670k, this.f4673n);
            jSONObject.put(f4671l, System.currentTimeMillis());
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(str, str2);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            c.a(th);
            return "";
        }
    }

    private String a(String str, String str2, String str3, boolean z10) throws JSONException, UnsupportedEncodingException {
        String substring = str.substring(str2.length());
        JSONObject jSONObject = new JSONObject(substring.substring(0, substring.length() - str3.length()));
        if (!jSONObject.has(f4665f)) {
            jSONObject.put(f4665f, com.alipay.sdk.cons.a.f4521d);
        }
        if (!jSONObject.has(f4666g)) {
            jSONObject.put(f4666g, "and_lite");
        }
        if (!jSONObject.has(f4667h)) {
            jSONObject.put(f4667h, "h.a.3.6.2");
        }
        if (!jSONObject.has(f4668i) && (!this.f4674o.contains(f4669j) || !n.b(this.f4675p))) {
            jSONObject.put(f4668i, this.f4674o);
        }
        if (!jSONObject.has(f4670k)) {
            jSONObject.put(f4670k, this.f4673n);
        }
        if (!jSONObject.has(f4671l)) {
            jSONObject.put(f4671l, System.currentTimeMillis());
        }
        return str2 + jSONObject.toString() + str3;
    }
}
