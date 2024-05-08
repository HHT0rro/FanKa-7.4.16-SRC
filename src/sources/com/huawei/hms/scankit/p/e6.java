package com.huawei.hms.scankit.p;

/* compiled from: PlanarYUVLuminanceSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class e6 extends p4 {

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f30938c;

    /* renamed from: d, reason: collision with root package name */
    private final int f30939d;

    /* renamed from: e, reason: collision with root package name */
    private final int f30940e;

    /* renamed from: f, reason: collision with root package name */
    private final int f30941f;

    /* renamed from: g, reason: collision with root package name */
    private final int f30942g;

    public e6(byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, boolean z10) {
        super(i14, i15);
        if (i12 + i14 <= i10 && i13 + i15 <= i11) {
            this.f30938c = bArr;
            this.f30939d = i10;
            this.f30940e = i11;
            this.f30941f = i12;
            this.f30942g = i13;
            if (z10) {
                a(i14, i15);
                return;
            }
            return;
        }
        try {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.huawei.hms.scankit.p.p4
    public byte[] a(int i10, byte[] bArr) {
        if (i10 >= 0 && i10 < a()) {
            int c4 = c();
            if (bArr == null || bArr.length < c4) {
                bArr = new byte[c4];
            }
            System.arraycopy((Object) this.f30938c, ((i10 + this.f30942g) * this.f30939d) + this.f30941f, (Object) bArr, 0, c4);
            return bArr;
        }
        try {
            throw new IllegalArgumentException("Requested row is outside the image: " + i10);
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.huawei.hms.scankit.p.p4
    public byte[] b() {
        int c4 = c();
        int a10 = a();
        int i10 = this.f30939d;
        if (c4 == i10 && a10 == this.f30940e) {
            return this.f30938c;
        }
        int i11 = c4 * a10;
        byte[] bArr = new byte[i11];
        int i12 = (this.f30942g * i10) + this.f30941f;
        if (c4 == i10) {
            try {
                System.arraycopy((Object) this.f30938c, i12, (Object) bArr, 0, i11);
                return bArr;
            } catch (ArrayIndexOutOfBoundsException | Exception unused) {
                return null;
            }
        }
        for (int i13 = 0; i13 < a10; i13++) {
            try {
                System.arraycopy((Object) this.f30938c, i12, (Object) bArr, i13 * c4, c4);
                i12 += this.f30939d;
            } catch (ArrayIndexOutOfBoundsException | Exception unused2) {
                return null;
            }
        }
        return bArr;
    }

    @Override // com.huawei.hms.scankit.p.p4
    public p4 a(int i10, int i11, int i12, int i13) {
        return new e6(this.f30938c, this.f30939d, this.f30940e, this.f30941f + i10, this.f30942g + i11, i12, i13, false);
    }

    private void a(int i10, int i11) {
        byte[] bArr = this.f30938c;
        int i12 = (this.f30942g * this.f30939d) + this.f30941f;
        int i13 = 0;
        while (i13 < i11) {
            int i14 = (i10 / 2) + i12;
            int i15 = (i12 + i10) - 1;
            int i16 = i12;
            while (i16 < i14) {
                if (w7.a(bArr, i16) && w7.a(bArr, i15)) {
                    byte b4 = bArr[i16];
                    bArr[i16] = bArr[i15];
                    bArr[i15] = b4;
                }
                i16++;
                i15--;
            }
            i13++;
            i12 += this.f30939d;
        }
    }
}
