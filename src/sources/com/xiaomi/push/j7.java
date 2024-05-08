package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class j7 {

    /* renamed from: d, reason: collision with root package name */
    public static volatile j7 f47845d;

    /* renamed from: a, reason: collision with root package name */
    public Context f47846a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f47847b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public Map<String, Map<String, String>> f47848c = new HashMap();

    public j7(Context context) {
        this.f47846a = context;
    }

    public static j7 b(Context context) {
        if (f47845d == null) {
            synchronized (j7.class) {
                if (f47845d == null) {
                    f47845d = new j7(context);
                }
            }
        }
        return f47845d;
    }

    public final synchronized String c(String str, String str2) {
        if (this.f47848c != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.f47848c.get(str);
                    if (map == null) {
                        return "";
                    }
                    return map.get(str2);
                } catch (Throwable unused) {
                    return "";
                }
            }
        }
        return "";
    }

    public synchronized String d(String str, String str2, String str3) {
        String c4 = c(str, str2);
        if (!TextUtils.isEmpty(c4)) {
            return c4;
        }
        return this.f47846a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    public synchronized void e(String str, String str2, String str3) {
        f(str, str2, str3);
        this.f47847b.post(new k7(this, str, str2, str3));
    }

    public final synchronized void f(String str, String str2, String str3) {
        if (this.f47848c == null) {
            this.f47848c = new HashMap();
        }
        Map<String, String> map = this.f47848c.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f47848c.put(str, map);
    }
}
