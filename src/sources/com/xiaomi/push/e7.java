package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class e7 {
    public int a() {
        return 0;
    }

    public abstract int b(byte[] bArr, int i10, int i11);

    public void c(int i10) {
    }

    public abstract void d(byte[] bArr, int i10, int i11);

    public byte[] e() {
        return null;
    }

    public int f() {
        return -1;
    }

    public int g(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        while (i12 < i11) {
            int b4 = b(bArr, i10 + i12, i11 - i12);
            if (b4 <= 0) {
                throw new jx("Cannot read. Remote side has closed. Tried to read " + i11 + " bytes, but only got " + i12 + " bytes.");
            }
            i12 += b4;
        }
        return i12;
    }
}
