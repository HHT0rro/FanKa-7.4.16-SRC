package rc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import rc.e;

/* compiled from: SdkUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static String f53377a;

    public static String a() {
        if (!TextUtils.isEmpty(f53377a)) {
            return f53377a;
        }
        a f10 = e.a.f53381a.f();
        if (f10 == null) {
            return "";
        }
        String g3 = TextUtils.isEmpty(f10.c()) ? g(e.a.f53381a.g()) : f10.c();
        String b4 = TextUtils.isEmpty(f10.e()) ? b(e.a.f53381a.g()) : f10.e();
        if (TextUtils.isEmpty(g3) || TextUtils.isEmpty(b4)) {
            return "";
        }
        f53377a = g3 + ";" + b4 + ";Android;" + Build.VERSION.RELEASE + ";" + Build.MODEL;
        if (b.f53376a) {
            b.a("TANX_EXPOSE_UTIL", "getUserAgent: mUserAgent = " + f53377a);
        }
        return f53377a;
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e2) {
            b.a("TANX_EXPOSE_UTIL", "getVersionName: exception" + e2.getMessage());
            return "";
        }
    }

    public static String c(String str) {
        try {
            return String.format("%032x", new BigInteger(1, MessageDigest.getInstance("MD5").digest(str.getBytes())));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(String str, JSONObject jSONObject) {
        if (str != null && jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                    str = str.replace(next, optString);
                }
            }
        }
        return str;
    }

    public static String e(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new JSONObject(map).toString();
    }

    public static Map<String, Object> f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        HashMap hashMap = new HashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (!TextUtils.isEmpty(next) && opt != null) {
                hashMap.put(next, opt);
            }
        }
        return hashMap;
    }

    public static String g(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageName();
        } catch (Exception e2) {
            b.a("TANX_EXPOSE_UTIL", "getVersionName: exception" + e2.getMessage());
            return "";
        }
    }
}
