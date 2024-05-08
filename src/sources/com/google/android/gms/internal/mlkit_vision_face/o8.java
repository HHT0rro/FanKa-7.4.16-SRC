package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.datatransport.Priority;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class o8 {
    public static n8 f(String str) {
        l8 l8Var = new l8();
        l8Var.f(str);
        l8Var.a(false);
        l8Var.b(true);
        l8Var.c(Priority.VERY_LOW);
        l8Var.d(0);
        return l8Var;
    }

    public abstract String a();

    public abstract boolean b();

    public abstract boolean c();

    public abstract Priority d();

    public abstract int e();
}
