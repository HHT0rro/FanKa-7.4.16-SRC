package com.tencent.turingface.sdk.mfa;

import com.tencent.turingface.sdk.mfa.ORjG3;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class SkEpO {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ORjG3 f45713a;

    public static ORjG3 a() {
        try {
            return new ORjG3();
        } catch (Exception unused) {
            return null;
        }
    }

    public static ORjG3.SkEpO a(String str) {
        ORjG3.ShGzN shGzN = new ORjG3.ShGzN(str, str, 5000L);
        ORjG3.SkEpO skEpO = null;
        try {
            if (f45713a == null) {
                synchronized (SkEpO.class) {
                    if (f45713a == null) {
                        f45713a = a();
                    }
                }
            }
            skEpO = f45713a.a(shGzN);
        } catch (Exception e2) {
            if (((e2 instanceof IOException) || (e2 instanceof InterruptedException)) && f45713a != null) {
                synchronized (SkEpO.class) {
                    if (f45713a != null) {
                        ORjG3 oRjG3 = f45713a;
                        oRjG3.getClass();
                        try {
                            oRjG3.a();
                        } catch (Throwable unused) {
                        }
                        f45713a = null;
                    }
                }
            }
        }
        return skEpO == null ? new ORjG3.SkEpO("", "e") : skEpO;
    }
}
