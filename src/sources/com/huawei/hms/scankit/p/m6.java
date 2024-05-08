package com.huawei.hms.scankit.p;

import java.nio.ByteBuffer;

/* compiled from: RGBLuminanceSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class m6 extends p4 {

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f31287c;

    /* renamed from: d, reason: collision with root package name */
    private final int f31288d;

    /* renamed from: e, reason: collision with root package name */
    private final int f31289e;

    /* renamed from: f, reason: collision with root package name */
    private final int f31290f;

    /* renamed from: g, reason: collision with root package name */
    private final int f31291g;

    public m6(int i10, int i11, ByteBuffer byteBuffer) {
        super(i10, i11);
        this.f31288d = i10;
        this.f31289e = i11;
        this.f31290f = 0;
        this.f31291g = 0;
        byte[] array = byteBuffer.array();
        int i12 = i10 * i11;
        this.f31287c = new byte[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i13 * 4;
            if ((array[i14 + 3] & 255) == 0) {
                this.f31287c[i13] = -1;
            } else {
                this.f31287c[i13] = (byte) ((((((array[i14] & 255) * 306) + ((array[i14 + 1] & 255) * 601)) + ((array[i14 + 2] & 255) * 117)) + 512) >> 10);
            }
        }
    }

    @Override // com.huawei.hms.scankit.p.p4
    public byte[] a(int i10, byte[] bArr) {
        if (i10 >= 0 && i10 < a()) {
            int c4 = c();
            if (bArr == null || bArr.length < c4) {
                bArr = new byte[c4];
            }
            System.arraycopy((Object) this.f31287c, ((i10 + this.f31291g) * this.f31288d) + this.f31290f, (Object) bArr, 0, c4);
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
        int i10 = this.f31288d;
        if (c4 == i10 && a10 == this.f31289e) {
            return this.f31287c;
        }
        int i11 = c4 * a10;
        byte[] bArr = new byte[i11];
        int i12 = (this.f31291g * i10) + this.f31290f;
        if (c4 == i10) {
            System.arraycopy((Object) this.f31287c, i12, (Object) bArr, 0, i11);
            return bArr;
        }
        for (int i13 = 0; i13 < a10; i13++) {
            System.arraycopy((Object) this.f31287c, i12, (Object) bArr, i13 * c4, c4);
            i12 += this.f31288d;
        }
        return bArr;
    }

    @Override // com.huawei.hms.scankit.p.p4
    public p4 a(int i10, int i11, int i12, int i13) {
        return new m6(this.f31287c, this.f31288d, this.f31289e, this.f31290f + i10, this.f31291g + i11, i12, i13);
    }

    private m6(byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15) {
        super(i14, i15);
        if (i14 + i12 <= i10 && i15 + i13 <= i11) {
            this.f31287c = bArr;
            this.f31288d = i10;
            this.f31289e = i11;
            this.f31290f = i12;
            this.f31291g = i13;
            return;
        }
        try {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        } catch (Exception e2) {
            throw e2;
        }
    }
}
