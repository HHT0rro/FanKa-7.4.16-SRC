package com.google.android.exoplayer2.extractor.ts;

import java.util.Arrays;

/* compiled from: NalUnitTargetBuffer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final int f20631a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f20632b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f20633c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f20634d;

    /* renamed from: e, reason: collision with root package name */
    public int f20635e;

    public t(int i10, int i11) {
        this.f20631a = i10;
        byte[] bArr = new byte[i11 + 3];
        this.f20634d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i10, int i11) {
        if (this.f20632b) {
            int i12 = i11 - i10;
            byte[] bArr2 = this.f20634d;
            int length = bArr2.length;
            int i13 = this.f20635e;
            if (length < i13 + i12) {
                this.f20634d = Arrays.copyOf(bArr2, (i13 + i12) * 2);
            }
            System.arraycopy((Object) bArr, i10, (Object) this.f20634d, this.f20635e, i12);
            this.f20635e += i12;
        }
    }

    public boolean b(int i10) {
        if (!this.f20632b) {
            return false;
        }
        this.f20635e -= i10;
        this.f20632b = false;
        this.f20633c = true;
        return true;
    }

    public boolean c() {
        return this.f20633c;
    }

    public void d() {
        this.f20632b = false;
        this.f20633c = false;
    }

    public void e(int i10) {
        com.google.android.exoplayer2.util.a.g(!this.f20632b);
        boolean z10 = i10 == this.f20631a;
        this.f20632b = z10;
        if (z10) {
            this.f20635e = 3;
            this.f20633c = false;
        }
    }
}
