package com.google.android.gms.internal.mlkit_common;

import com.google.android.datatransport.Priority;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class z {
    public static y f(String str) {
        w wVar = new w();
        wVar.f("common");
        wVar.a(false);
        wVar.b(true);
        wVar.c(Priority.VERY_LOW);
        wVar.d(0);
        return wVar;
    }

    public abstract String a();

    public abstract boolean b();

    public abstract boolean c();

    public abstract Priority d();

    public abstract int e();
}
