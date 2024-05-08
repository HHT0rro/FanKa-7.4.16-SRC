package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g0 extends e0 {

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f23899d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f23900e;

    /* renamed from: f, reason: collision with root package name */
    public int f23901f;

    /* renamed from: g, reason: collision with root package name */
    public int f23902g;

    /* renamed from: h, reason: collision with root package name */
    public int f23903h;

    /* renamed from: i, reason: collision with root package name */
    public int f23904i;

    /* renamed from: j, reason: collision with root package name */
    public int f23905j;

    public g0(byte[] bArr, int i10, int i11, boolean z10) {
        super();
        this.f23905j = Integer.MAX_VALUE;
        this.f23899d = bArr;
        this.f23901f = i11 + i10;
        this.f23903h = i10;
        this.f23904i = i10;
        this.f23900e = z10;
    }

    @Override // com.google.android.gms.internal.clearcut.e0
    public final int c() {
        return this.f23903h - this.f23904i;
    }

    @Override // com.google.android.gms.internal.clearcut.e0
    public final int d(int i10) throws zzco {
        if (i10 < 0) {
            throw new zzco("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int c4 = i10 + c();
        int i11 = this.f23905j;
        if (c4 > i11) {
            throw zzco.zzbl();
        }
        this.f23905j = c4;
        int i12 = this.f23901f + this.f23902g;
        this.f23901f = i12;
        int i13 = i12 - this.f23904i;
        if (i13 > c4) {
            int i14 = i13 - c4;
            this.f23902g = i14;
            this.f23901f = i12 - i14;
        } else {
            this.f23902g = 0;
        }
        return i11;
    }
}
