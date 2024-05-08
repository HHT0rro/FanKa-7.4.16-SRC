package com.amap.api.col.s;

import android.content.Context;

/* compiled from: WiFiUplateStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ev extends eu {

    /* renamed from: a, reason: collision with root package name */
    private Context f7937a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f7938b = false;

    public ev(Context context) {
        this.f7937a = context;
    }

    @Override // com.amap.api.col.s.eu
    public final boolean a() {
        return ca.i(this.f7937a) == 1 || this.f7938b;
    }
}
