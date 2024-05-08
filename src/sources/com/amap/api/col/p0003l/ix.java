package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: MobileUpdateStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ix extends ja {

    /* renamed from: b, reason: collision with root package name */
    private Context f6507b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6508d;

    /* renamed from: e, reason: collision with root package name */
    private int f6509e;

    /* renamed from: f, reason: collision with root package name */
    private int f6510f;

    /* renamed from: a, reason: collision with root package name */
    private String f6506a = "iKey";

    /* renamed from: g, reason: collision with root package name */
    private int f6511g = 0;

    public ix(Context context, boolean z10, int i10, int i11, String str) {
        a(context, z10, i10, i11, str, 0);
    }

    private void a(Context context, boolean z10, int i10, int i11, String str, int i12) {
        this.f6507b = context;
        this.f6508d = z10;
        this.f6509e = i10;
        this.f6510f = i11;
        this.f6506a = str;
        this.f6511g = i12;
    }

    @Override // com.amap.api.col.p0003l.ja
    public final void a_(int i10) {
        if (fm.j(this.f6507b) == 1) {
            return;
        }
        String a10 = fv.a(System.currentTimeMillis(), "yyyyMMdd");
        String a11 = gw.a(this.f6507b, this.f6506a);
        if (!TextUtils.isEmpty(a11)) {
            String[] split = a11.split("\\|");
            if (split != null && split.length >= 2) {
                if (a10.equals(split[0])) {
                    i10 += Integer.parseInt(split[1]);
                }
            } else {
                gw.b(this.f6507b, this.f6506a);
            }
        }
        gw.a(this.f6507b, this.f6506a, a10 + "|" + i10);
    }

    @Override // com.amap.api.col.p0003l.ja
    public final boolean c() {
        if (fm.j(this.f6507b) == 1) {
            return true;
        }
        if (!this.f6508d) {
            return false;
        }
        String a10 = gw.a(this.f6507b, this.f6506a);
        if (TextUtils.isEmpty(a10)) {
            return true;
        }
        String[] split = a10.split("\\|");
        if (split != null && split.length >= 2) {
            return !fv.a(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f6510f;
        }
        gw.b(this.f6507b, this.f6506a);
        return true;
    }

    public ix(Context context, boolean z10, int i10, int i11, String str, int i12) {
        a(context, z10, i10, i11, str, i12);
    }

    @Override // com.amap.api.col.p0003l.ja
    public final int a() {
        int i10;
        int i11 = Integer.MAX_VALUE;
        if ((fm.j(this.f6507b) != 1 && (i10 = this.f6509e) > 0) || ((i10 = this.f6511g) > 0 && i10 < Integer.MAX_VALUE)) {
            i11 = i10;
        }
        ja jaVar = this.f6526c;
        return jaVar != null ? Math.max(i11, jaVar.a()) : i11;
    }
}
