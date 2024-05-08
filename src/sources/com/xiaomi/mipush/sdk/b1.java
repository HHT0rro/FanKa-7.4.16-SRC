package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hv;
import com.xiaomi.push.x3;
import kc.j;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b1 extends j.a {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f46970d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b1(int i10, String str, Context context) {
        super(i10, str);
        this.f46970d = context;
    }

    @Override // kc.j.a
    public void a() {
        x3.b(this.f46970d).e(kc.j.d(this.f46970d).a(hv.AwakeInfoUploadWaySwitch.a(), 0));
    }
}
