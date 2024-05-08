package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class e3 extends a3 {

    /* renamed from: d, reason: collision with root package name */
    public SharedPreferences f47210d;

    public e3(Context context, int i10) {
        super(context, i10);
        this.f47210d = context.getSharedPreferences("mipush_extra", 0);
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return 9;
    }

    @Override // com.xiaomi.push.a3
    public hs b() {
        return hs.TopApp;
    }

    @Override // com.xiaomi.push.a3
    public String c() {
        return null;
    }
}
