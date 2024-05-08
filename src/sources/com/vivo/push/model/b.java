package com.vivo.push.model;

import android.text.TextUtils;
import com.alipay.sdk.util.i;

/* compiled from: PushPackageInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private String f46267a;

    /* renamed from: d, reason: collision with root package name */
    private String f46270d;

    /* renamed from: b, reason: collision with root package name */
    private long f46268b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f46269c = -1;

    /* renamed from: e, reason: collision with root package name */
    private boolean f46271e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f46272f = false;

    public b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f46267a = str;
            return;
        }
        throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
    }

    public final String a() {
        return this.f46267a;
    }

    public final long b() {
        return this.f46268b;
    }

    public final boolean c() {
        return this.f46271e;
    }

    public final boolean d() {
        return this.f46272f;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f46267a + ", mPushVersion=" + this.f46268b + ", mPackageVersion=" + this.f46269c + ", mInBlackList=" + this.f46271e + ", mPushEnable=" + this.f46272f + i.f4738d;
    }

    public final void a(long j10) {
        this.f46268b = j10;
    }

    public final void b(boolean z10) {
        this.f46272f = z10;
    }

    public final void a(boolean z10) {
        this.f46271e = z10;
    }

    public final void a(int i10) {
        this.f46269c = i10;
    }

    public final void a(String str) {
        this.f46270d = str;
    }
}
