package com.amap.api.col.p0003l;

import android.content.Context;

/* compiled from: WiFiUplateStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class jb extends ja {

    /* renamed from: a, reason: collision with root package name */
    private Context f6527a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f6528b;

    public jb(Context context, boolean z10) {
        this.f6527a = context;
        this.f6528b = z10;
    }

    @Override // com.amap.api.col.p0003l.ja
    public final boolean c() {
        return fm.j(this.f6527a) == 1 || this.f6528b;
    }
}
