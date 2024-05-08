package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g4 extends f4 {

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f25475d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f25476e;

    /* renamed from: f, reason: collision with root package name */
    public int f25477f;

    /* renamed from: g, reason: collision with root package name */
    public int f25478g;

    /* renamed from: h, reason: collision with root package name */
    public int f25479h;

    /* renamed from: i, reason: collision with root package name */
    public int f25480i;

    /* renamed from: j, reason: collision with root package name */
    public int f25481j;

    public g4(byte[] bArr, int i10, int i11, boolean z10) {
        super();
        this.f25481j = Integer.MAX_VALUE;
        this.f25475d = bArr;
        this.f25477f = i11 + i10;
        this.f25479h = i10;
        this.f25480i = i10;
        this.f25476e = z10;
    }

    @Override // com.google.android.gms.internal.vision.f4
    public final int c(int i10) throws zzjk {
        if (i10 >= 0) {
            int e2 = i10 + e();
            int i11 = this.f25481j;
            if (e2 <= i11) {
                this.f25481j = e2;
                f();
                return i11;
            }
            throw zzjk.zza();
        }
        throw zzjk.zzb();
    }

    @Override // com.google.android.gms.internal.vision.f4
    public final int e() {
        return this.f25479h - this.f25480i;
    }

    public final void f() {
        int i10 = this.f25477f + this.f25478g;
        this.f25477f = i10;
        int i11 = i10 - this.f25480i;
        int i12 = this.f25481j;
        if (i11 > i12) {
            int i13 = i11 - i12;
            this.f25478g = i13;
            this.f25477f = i10 - i13;
            return;
        }
        this.f25478g = 0;
    }
}
