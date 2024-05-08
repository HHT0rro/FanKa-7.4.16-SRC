package com.google.android.gms.internal.mlkit_vision_common;

import androidx.annotation.Nullable;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f7 {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public static f7 f24321a;

    public static synchronized f7 a() {
        f7 f7Var;
        synchronized (f7.class) {
            if (f24321a == null) {
                f24321a = new f7();
            }
            f7Var = f24321a;
        }
        return f7Var;
    }
}
