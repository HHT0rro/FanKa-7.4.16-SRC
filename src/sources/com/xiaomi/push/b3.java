package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b3 extends a3 {

    /* renamed from: d, reason: collision with root package name */
    public boolean f47130d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f47131e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f47132f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f47133g;

    public b3(Context context, int i10, boolean z10, boolean z11, boolean z12, boolean z13) {
        super(context, i10);
        this.f47130d = z10;
        this.f47131e = z11;
        if (g7.k()) {
            this.f47131e = false;
        }
        this.f47132f = z12;
        this.f47133g = z13;
    }

    private String g() {
        if (!this.f47130d) {
            return "off";
        }
        try {
            String i10 = i();
            if (TextUtils.isEmpty(i10)) {
                return "";
            }
            return p0.b(i10) + "," + p0.k(i10);
        } catch (Throwable unused) {
            return "";
        }
    }

    private String i() {
        return "";
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return 13;
    }

    @Override // com.xiaomi.push.a3
    public hs b() {
        return hs.DeviceBaseInfo;
    }

    @Override // com.xiaomi.push.a3
    public String c() {
        return g() + "|" + l() + "|" + m() + "|" + k(this.f47110c);
    }

    public final String k(Context context) {
        return !this.f47133g ? "off" : "";
    }

    public final String l() {
        return !this.f47131e ? "off" : "";
    }

    public final String m() {
        return !this.f47132f ? "off" : "";
    }
}
