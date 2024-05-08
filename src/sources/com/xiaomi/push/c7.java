package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c7 extends e7 {

    /* renamed from: a, reason: collision with root package name */
    public r6 f47163a;

    /* renamed from: b, reason: collision with root package name */
    public int f47164b;

    public c7(int i10) {
        this.f47163a = new r6(i10);
    }

    @Override // com.xiaomi.push.e7
    public int b(byte[] bArr, int i10, int i11) {
        byte[] b4 = this.f47163a.b();
        if (i11 > this.f47163a.a() - this.f47164b) {
            i11 = this.f47163a.a() - this.f47164b;
        }
        if (i11 > 0) {
            System.arraycopy((Object) b4, this.f47164b, (Object) bArr, i10, i11);
            this.f47164b += i11;
        }
        return i11;
    }

    @Override // com.xiaomi.push.e7
    public void d(byte[] bArr, int i10, int i11) {
        this.f47163a.write(bArr, i10, i11);
    }

    public int h() {
        return this.f47163a.size();
    }
}
