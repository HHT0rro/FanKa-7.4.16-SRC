package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hv;
import kc.j;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class r0 extends j.a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q0 f47076d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(q0 q0Var, int i10, String str) {
        super(i10, str);
        this.f47076d = q0Var;
    }

    @Override // kc.j.a
    public void a() {
        Context context;
        boolean z10;
        Context context2;
        context = this.f47076d.f47070a;
        boolean i10 = kc.j.d(context).i(hv.AggregatePushSwitch.a(), true);
        z10 = this.f47076d.f47072c;
        if (z10 != i10) {
            this.f47076d.f47072c = i10;
            context2 = this.f47076d.f47070a;
            t0.f(context2);
        }
    }
}
