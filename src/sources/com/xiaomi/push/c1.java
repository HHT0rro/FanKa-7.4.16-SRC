package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c1 extends n.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z0 f47149b;

    public c1(z0 z0Var) {
        this.f47149b = z0Var;
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return 10053;
    }

    @Override // java.lang.Runnable
    public void run() {
        n1 n1Var;
        n1 n1Var2;
        Context context;
        n1Var = this.f47149b.f48534i;
        if (n1Var != null) {
            n1Var2 = this.f47149b.f48534i;
            context = this.f47149b.f48530e;
            n1Var2.b(context);
            this.f47149b.m("delete_time");
        }
    }
}
