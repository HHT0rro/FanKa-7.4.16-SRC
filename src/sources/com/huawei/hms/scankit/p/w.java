package com.huawei.hms.scankit.p;

/* compiled from: BitSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f31634a;

    /* renamed from: b, reason: collision with root package name */
    private int f31635b;

    /* renamed from: c, reason: collision with root package name */
    private int f31636c;

    public w(byte[] bArr) {
        this.f31634a = bArr;
    }

    public int a(int i10) {
        if (i10 >= 1 && i10 <= 32 && i10 <= a()) {
            int i11 = this.f31636c;
            int i12 = 0;
            if (i11 > 0) {
                int i13 = 8 - i11;
                int i14 = i10 < i13 ? i10 : i13;
                int i15 = i13 - i14;
                int i16 = w7.a(this.f31634a, this.f31635b) ? (((255 >> (8 - i14)) << i15) & this.f31634a[this.f31635b]) >> i15 : 0;
                i10 -= i14;
                int i17 = this.f31636c + i14;
                this.f31636c = i17;
                if (i17 == 8) {
                    this.f31636c = 0;
                    this.f31635b++;
                }
                i12 = i16;
            }
            if (i10 > 0) {
                while (i10 >= 8) {
                    if (w7.a(this.f31634a, this.f31635b)) {
                        i12 = (i12 << 8) | (this.f31634a[this.f31635b] & 255);
                    }
                    this.f31635b++;
                    i10 -= 8;
                }
                if (i10 > 0) {
                    int i18 = 8 - i10;
                    int i19 = (255 >> i18) << i18;
                    if (w7.a(this.f31634a, this.f31635b)) {
                        i12 = ((i19 & this.f31634a[this.f31635b]) >> i18) | (i12 << i10);
                    }
                    this.f31636c += i10;
                }
            }
            return i12;
        }
        try {
            throw new IllegalArgumentException(String.valueOf(i10));
        } catch (Exception e2) {
            throw e2;
        }
    }

    public int b() {
        return this.f31636c;
    }

    public int c() {
        return this.f31635b;
    }

    public int a() {
        return ((this.f31634a.length - this.f31635b) * 8) - this.f31636c;
    }
}
