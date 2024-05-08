package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a1 extends n.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z0 f47104b;

    public a1(z0 z0Var) {
        this.f47104b = z0Var;
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return 10052;
    }

    @Override // java.lang.Runnable
    public void run() {
        n1 n1Var;
        n1 n1Var2;
        Context context;
        fc.c.m("exec== mUploadJob");
        n1Var = this.f47104b.f48534i;
        if (n1Var != null) {
            n1Var2 = this.f47104b.f48534i;
            context = this.f47104b.f48530e;
            n1Var2.a(context);
            this.f47104b.m("upload_time");
        }
    }
}
