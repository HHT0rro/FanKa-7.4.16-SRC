package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class j0 extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f47024a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(h0 h0Var, Handler handler) {
        super(handler);
        this.f47024a = h0Var;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        Context context;
        Integer num;
        Context context2;
        Context context3;
        h0 h0Var = this.f47024a;
        context = h0Var.f47010b;
        h0Var.f47017i = Integer.valueOf(kc.q.c(context).a());
        num = this.f47024a.f47017i;
        if (num.intValue() != 0) {
            context2 = this.f47024a.f47010b;
            context2.getContentResolver().unregisterContentObserver(this);
            context3 = this.f47024a.f47010b;
            if (com.xiaomi.push.j0.p(context3)) {
                this.f47024a.M();
            }
        }
    }
}
