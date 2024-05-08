package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: TimeUpdateStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class iz extends ja {

    /* renamed from: a, reason: collision with root package name */
    public int f6513a;

    /* renamed from: b, reason: collision with root package name */
    public long f6514b;

    /* renamed from: d, reason: collision with root package name */
    private String f6515d;

    /* renamed from: e, reason: collision with root package name */
    private Context f6516e;

    public iz(Context context, int i10, String str, ja jaVar) {
        super(jaVar);
        this.f6513a = i10;
        this.f6515d = str;
        this.f6516e = context;
    }

    @Override // com.amap.api.col.p0003l.ja
    public final void a_(boolean z10) {
        super.a_(z10);
        if (z10) {
            String str = this.f6515d;
            long currentTimeMillis = System.currentTimeMillis();
            this.f6514b = currentTimeMillis;
            gw.a(this.f6516e, str, String.valueOf(currentTimeMillis));
        }
    }

    @Override // com.amap.api.col.p0003l.ja
    public final boolean c() {
        if (this.f6514b == 0) {
            String a10 = gw.a(this.f6516e, this.f6515d);
            this.f6514b = TextUtils.isEmpty(a10) ? 0L : Long.parseLong(a10);
        }
        return System.currentTimeMillis() - this.f6514b >= ((long) this.f6513a);
    }
}
