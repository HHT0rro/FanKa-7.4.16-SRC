package com.mobile.auth.s;

import android.content.Context;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile JSONObject f37619a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile long f37620b;

    public static synchronized JSONObject a(Context context) {
        JSONObject jSONObject;
        synchronized (b.class) {
            try {
                if (System.currentTimeMillis() - f37620b > 1000 || f37619a == null) {
                    f37619a = com.mobile.auth.g.a.a(context).c(context);
                    f37620b = System.currentTimeMillis();
                }
                jSONObject = f37619a;
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return null;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return null;
                }
            }
        }
        return jSONObject;
    }
}
