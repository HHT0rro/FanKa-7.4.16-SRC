package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.n;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b1 extends n.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z0 f47129b;

    public b1(z0 z0Var) {
        this.f47129b = z0Var;
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return 10054;
    }

    @Override // java.lang.Runnable
    public void run() {
        String n10;
        Context context;
        Context context2;
        fc.c.m("exec== DbSizeControlJob");
        n10 = this.f47129b.n();
        context = this.f47129b.f48530e;
        e1 e1Var = new e1(n10, new WeakReference(context));
        context2 = this.f47129b.f48530e;
        k1.b(context2).e(e1Var);
        this.f47129b.m("check_time");
    }
}
