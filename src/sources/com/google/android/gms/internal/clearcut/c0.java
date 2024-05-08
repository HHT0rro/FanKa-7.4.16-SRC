package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final zzbn f23831a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f23832b;

    public c0(int i10) {
        byte[] bArr = new byte[i10];
        this.f23832b = bArr;
        this.f23831a = zzbn.S(bArr);
    }

    public /* synthetic */ c0(int i10, z zVar) {
        this(i10);
    }

    public final zzbb a() {
        if (this.f23831a.u() == 0) {
            return new zzbi(this.f23832b);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public final zzbn b() {
        return this.f23831a;
    }
}
