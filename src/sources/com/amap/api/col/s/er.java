package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: MobileUpdateStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class er extends eu {

    /* renamed from: b, reason: collision with root package name */
    private Context f7926b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f7927d;

    /* renamed from: e, reason: collision with root package name */
    private int f7928e;

    /* renamed from: f, reason: collision with root package name */
    private int f7929f;

    /* renamed from: a, reason: collision with root package name */
    private String f7925a = "iKey";

    /* renamed from: g, reason: collision with root package name */
    private int f7930g = 0;

    public er(Context context, boolean z10, int i10, int i11, String str, int i12) {
        a(context, z10, i10, i11, str, i12);
    }

    private void a(Context context, boolean z10, int i10, int i11, String str, int i12) {
        this.f7926b = context;
        this.f7927d = z10;
        this.f7928e = i10;
        this.f7929f = i11;
        this.f7925a = str;
        this.f7930g = i12;
    }

    @Override // com.amap.api.col.s.eu
    public final int b() {
        int i10;
        int i11 = Integer.MAX_VALUE;
        if ((ca.i(this.f7926b) != 1 && (i10 = this.f7928e) > 0) || ((i10 = this.f7930g) > 0 && i10 < Integer.MAX_VALUE)) {
            i11 = i10;
        }
        eu euVar = this.f7936c;
        return euVar != null ? Math.max(i11, euVar.b()) : i11;
    }

    @Override // com.amap.api.col.s.eu
    public final boolean a() {
        if (ca.i(this.f7926b) == 1) {
            return true;
        }
        if (!this.f7927d) {
            return false;
        }
        String a10 = dd.a(this.f7926b, this.f7925a);
        if (TextUtils.isEmpty(a10)) {
            return true;
        }
        String[] split = a10.split("\\|");
        if (split != null && split.length >= 2) {
            return !ci.a(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.f7929f;
        }
        dd.b(this.f7926b, this.f7925a);
        return true;
    }

    @Override // com.amap.api.col.s.eu
    public final void a(int i10) {
        if (ca.i(this.f7926b) == 1) {
            return;
        }
        String a10 = ci.a(System.currentTimeMillis(), "yyyyMMdd");
        String a11 = dd.a(this.f7926b, this.f7925a);
        if (!TextUtils.isEmpty(a11)) {
            String[] split = a11.split("\\|");
            if (split != null && split.length >= 2) {
                if (a10.equals(split[0])) {
                    i10 += Integer.parseInt(split[1]);
                }
            } else {
                dd.b(this.f7926b, this.f7925a);
            }
        }
        dd.a(this.f7926b, this.f7925a, a10 + "|" + i10);
    }
}
