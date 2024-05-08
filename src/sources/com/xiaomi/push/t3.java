package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class t3 {
    public static void a(Context context, String str, int i10, String str2) {
        n.c(context).g(new u3(context, str, i10, str2));
    }

    public static void b(Context context, HashMap<String, String> hashMap) {
        a4 c4 = x3.b(context).c();
        if (c4 != null) {
            c4.a(context, hashMap);
        }
    }

    public static void d(Context context, HashMap<String, String> hashMap) {
        a4 c4 = x3.b(context).c();
        if (c4 != null) {
            c4.b(context, hashMap);
        }
    }

    public static void e(Context context, String str, int i10, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("awake_info", str);
            hashMap.put("event_type", String.valueOf(i10));
            hashMap.put("description", str2);
            int a10 = x3.b(context).a();
            if (a10 != 1) {
                if (a10 != 2) {
                    if (a10 == 3) {
                        b(context, hashMap);
                    }
                }
                f(context, hashMap);
            } else {
                b(context, hashMap);
            }
            d(context, hashMap);
        } catch (Exception e2) {
            fc.c.k(e2);
        }
    }

    public static void f(Context context, HashMap<String, String> hashMap) {
        a4 c4 = x3.b(context).c();
        if (c4 != null) {
            c4.c(context, hashMap);
        }
    }
}
