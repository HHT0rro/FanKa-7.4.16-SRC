package com.ss.android.downloadlib.hc;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class oa {

    /* renamed from: m, reason: collision with root package name */
    private static Map<String, m> f38779m = Collections.synchronizedMap(new HashMap());

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface m {
        void m();

        void m(String str);
    }

    public static boolean dk(String str) {
        return com.ss.android.downloadlib.addownload.c.np().m(com.ss.android.downloadlib.addownload.c.getContext(), str);
    }

    private static m ej(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f38779m.remove(str);
    }

    public static void m(String[] strArr, m mVar) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        m(valueOf, mVar);
        TTDelegateActivity.m(valueOf, strArr);
    }

    public static void m(String str) {
        m ej;
        if (TextUtils.isEmpty(str) || (ej = ej(str)) == null) {
            return;
        }
        ej.m();
    }

    public static void m(String str, String str2) {
        m ej;
        if (TextUtils.isEmpty(str) || (ej = ej(str)) == null) {
            return;
        }
        ej.m(str2);
    }

    private static void m(String str, m mVar) {
        if (TextUtils.isEmpty(str) || mVar == null) {
            return;
        }
        f38779m.put(str, mVar);
    }
}
