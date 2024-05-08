package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.w0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c0 {
    public static a a(Context context, d dVar) {
        return b(context, dVar);
    }

    public static a b(Context context, d dVar) {
        w0.a b4 = w0.b(dVar);
        if (b4 == null || TextUtils.isEmpty(b4.f47088a) || TextUtils.isEmpty(b4.f47089b)) {
            return null;
        }
        return (a) com.xiaomi.push.k0.g(b4.f47088a, b4.f47089b, context);
    }
}
