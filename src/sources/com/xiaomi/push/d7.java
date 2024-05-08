package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d7 extends e7 {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f47183a;

    /* renamed from: b, reason: collision with root package name */
    public int f47184b;

    /* renamed from: c, reason: collision with root package name */
    public int f47185c;

    @Override // com.xiaomi.push.e7
    public int a() {
        return this.f47184b;
    }

    @Override // com.xiaomi.push.e7
    public int b(byte[] bArr, int i10, int i11) {
        int f10 = f();
        if (i11 > f10) {
            i11 = f10;
        }
        if (i11 > 0) {
            System.arraycopy((Object) this.f47183a, this.f47184b, (Object) bArr, i10, i11);
            c(i11);
        }
        return i11;
    }

    @Override // com.xiaomi.push.e7
    public void c(int i10) {
        this.f47184b += i10;
    }

    @Override // com.xiaomi.push.e7
    public void d(byte[] bArr, int i10, int i11) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.e7
    public byte[] e() {
        return this.f47183a;
    }

    @Override // com.xiaomi.push.e7
    public int f() {
        return this.f47185c - this.f47184b;
    }

    public void h(byte[] bArr) {
        i(bArr, 0, bArr.length);
    }

    public void i(byte[] bArr, int i10, int i11) {
        this.f47183a = bArr;
        this.f47184b = i10;
        this.f47185c = i10 + i11;
    }
}
