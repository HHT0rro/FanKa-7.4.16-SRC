package com.cmic.sso.sdk.d;

import android.text.TextUtils;
import com.mobile.auth.n.o;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static C0133a<String, String> f11426a = new C0133a<>();

    /* renamed from: com.cmic.sso.sdk.d.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class C0133a<K, V> extends HashMap<K, V> {
        private C0133a() {
        }
    }

    public static void a(String str) {
        try {
            String str2 = f11426a.get(str);
            f11426a.put(str, String.valueOf((TextUtils.isEmpty(str2) ? 0 : Integer.parseInt(str2)) + 1));
            f11426a.put(str + "Time", o.a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str, String str2) {
        f11426a.put(str, str2);
    }
}
