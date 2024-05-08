package com.huawei.hms.scankit.p;

/* compiled from: BarcodeRow.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
final class l {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f31217a;

    /* renamed from: b, reason: collision with root package name */
    private int f31218b = 0;

    public l(int i10) {
        this.f31217a = new byte[i10];
    }

    private void a(int i10, boolean z10) {
        try {
            if (w7.a(this.f31217a, i10)) {
                this.f31217a[i10] = z10 ? (byte) 1 : (byte) 0;
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw e2;
        }
    }

    public void a(boolean z10, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = this.f31218b;
            this.f31218b = i12 + 1;
            a(i12, z10);
        }
    }

    public byte[] a(int i10) {
        int length = this.f31217a.length * i10;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr[i11] = this.f31217a[i11 / i10];
        }
        return bArr;
    }
}
