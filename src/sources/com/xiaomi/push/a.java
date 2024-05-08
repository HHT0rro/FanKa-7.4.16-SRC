package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f47100c = new a(new byte[0]);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f47101a;

    /* renamed from: b, reason: collision with root package name */
    public volatile int f47102b = 0;

    public a(byte[] bArr) {
        this.f47101a = bArr;
    }

    public static a b(byte[] bArr) {
        return c(bArr, 0, bArr.length);
    }

    public static a c(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy((Object) bArr, i10, (Object) bArr2, 0, i11);
        return new a(bArr2);
    }

    public int a() {
        return this.f47101a.length;
    }

    public byte[] d() {
        byte[] bArr = this.f47101a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, length);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        byte[] bArr = this.f47101a;
        int length = bArr.length;
        byte[] bArr2 = ((a) obj).f47101a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i10 = this.f47102b;
        if (i10 == 0) {
            byte[] bArr = this.f47101a;
            int length = bArr.length;
            for (byte b4 : bArr) {
                length = (length * 31) + b4;
            }
            i10 = length == 0 ? 1 : length;
            this.f47102b = i10;
        }
        return i10;
    }
}
