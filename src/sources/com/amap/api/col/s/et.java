package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: TimeUpdateStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class et extends eu {

    /* renamed from: a, reason: collision with root package name */
    public int f7932a;

    /* renamed from: b, reason: collision with root package name */
    public long f7933b;

    /* renamed from: d, reason: collision with root package name */
    private String f7934d;

    /* renamed from: e, reason: collision with root package name */
    private Context f7935e;

    public et(Context context, int i10, String str, eu euVar) {
        super(euVar);
        this.f7932a = i10;
        this.f7934d = str;
        this.f7935e = context;
    }

    @Override // com.amap.api.col.s.eu
    public final boolean a() {
        if (this.f7933b == 0) {
            String a10 = dd.a(this.f7935e, this.f7934d);
            this.f7933b = TextUtils.isEmpty(a10) ? 0L : Long.parseLong(a10);
        }
        return System.currentTimeMillis() - this.f7933b >= ((long) this.f7932a);
    }

    @Override // com.amap.api.col.s.eu
    public final void a(boolean z10) {
        super.a(z10);
        if (z10) {
            String str = this.f7934d;
            long currentTimeMillis = System.currentTimeMillis();
            this.f7933b = currentTimeMillis;
            dd.a(this.f7935e, str, String.valueOf(currentTimeMillis));
        }
    }
}
