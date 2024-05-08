package com.huawei.hms.hatool;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f30122a;

    /* renamed from: b, reason: collision with root package name */
    private int f30123b = 0;

    public h(int i10) {
        this.f30122a = null;
        this.f30122a = new byte[i10];
    }

    public void a(byte[] bArr, int i10) {
        if (i10 <= 0) {
            return;
        }
        byte[] bArr2 = this.f30122a;
        int length = bArr2.length;
        int i11 = this.f30123b;
        if (length - i11 >= i10) {
            System.arraycopy((Object) bArr, 0, (Object) bArr2, i11, i10);
        } else {
            byte[] bArr3 = new byte[(bArr2.length + i10) << 1];
            System.arraycopy((Object) bArr2, 0, (Object) bArr3, 0, i11);
            System.arraycopy((Object) bArr, 0, (Object) bArr3, this.f30123b, i10);
            this.f30122a = bArr3;
        }
        this.f30123b += i10;
    }

    public byte[] a() {
        int i10 = this.f30123b;
        if (i10 <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i10];
        System.arraycopy((Object) this.f30122a, 0, (Object) bArr, 0, i10);
        return bArr;
    }

    public int b() {
        return this.f30123b;
    }
}
