package kc;

import com.xiaomi.push.m0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class s {

    /* renamed from: d, reason: collision with root package name */
    public int f50855d = -666;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f50852a = new byte[256];

    /* renamed from: c, reason: collision with root package name */
    public int f50854c = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f50853b = 0;

    public static int b(byte b4) {
        return b4 >= 0 ? b4 : b4 + 256;
    }

    public static void f(byte[] bArr, int i10, int i11) {
        byte b4 = bArr[i10];
        bArr[i10] = bArr[i11];
        bArr[i11] = b4;
    }

    public static byte[] g(String str, String str2) {
        byte[] b4 = m0.b(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[b4.length + 1 + bytes.length];
        for (int i10 = 0; i10 < b4.length; i10++) {
            bArr[i10] = b4[i10];
        }
        bArr[b4.length] = 95;
        for (int i11 = 0; i11 < bytes.length; i11++) {
            bArr[b4.length + 1 + i11] = bytes[i11];
        }
        return bArr;
    }

    public static byte[] h(byte[] bArr, String str) {
        return i(bArr, m0.b(str));
    }

    public static byte[] i(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        s sVar = new s();
        sVar.e(bArr);
        sVar.c();
        for (int i10 = 0; i10 < bArr2.length; i10++) {
            bArr3[i10] = (byte) (bArr2[i10] ^ sVar.a());
        }
        return bArr3;
    }

    public static byte[] j(byte[] bArr, byte[] bArr2, boolean z10, int i10, int i11) {
        byte[] bArr3;
        int i12;
        if (i10 < 0 || i10 > bArr2.length || i10 + i11 > bArr2.length) {
            throw new IllegalArgumentException("start = " + i10 + " len = " + i11);
        }
        if (z10) {
            bArr3 = bArr2;
            i12 = i10;
        } else {
            bArr3 = new byte[i11];
            i12 = 0;
        }
        s sVar = new s();
        sVar.e(bArr);
        sVar.c();
        for (int i13 = 0; i13 < i11; i13++) {
            bArr3[i12 + i13] = (byte) (bArr2[i10 + i13] ^ sVar.a());
        }
        return bArr3;
    }

    public byte a() {
        int i10 = (this.f50853b + 1) % 256;
        this.f50853b = i10;
        int b4 = (this.f50854c + b(this.f50852a[i10])) % 256;
        this.f50854c = b4;
        f(this.f50852a, this.f50853b, b4);
        byte[] bArr = this.f50852a;
        return bArr[(b(bArr[this.f50853b]) + b(this.f50852a[this.f50854c])) % 256];
    }

    public final void c() {
        this.f50854c = 0;
        this.f50853b = 0;
    }

    public final void d(int i10, byte[] bArr, boolean z10) {
        int length = bArr.length;
        for (int i11 = 0; i11 < 256; i11++) {
            this.f50852a[i11] = (byte) i11;
        }
        this.f50854c = 0;
        this.f50853b = 0;
        while (true) {
            int i12 = this.f50853b;
            if (i12 >= i10) {
                break;
            }
            int b4 = ((this.f50854c + b(this.f50852a[i12])) + b(bArr[this.f50853b % length])) % 256;
            this.f50854c = b4;
            f(this.f50852a, this.f50853b, b4);
            this.f50853b++;
        }
        if (i10 != 256) {
            this.f50855d = ((this.f50854c + b(this.f50852a[i10])) + b(bArr[i10 % length])) % 256;
        }
        if (z10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("S_");
            int i13 = i10 - 1;
            sb2.append(i13);
            sb2.append(com.huawei.openalliance.ad.constant.u.bD);
            for (int i14 = 0; i14 <= i10; i14++) {
                sb2.append(" ");
                sb2.append(b(this.f50852a[i14]));
            }
            sb2.append("   j_");
            sb2.append(i13);
            sb2.append("=");
            sb2.append(this.f50854c);
            sb2.append("   j_");
            sb2.append(i10);
            sb2.append("=");
            sb2.append(this.f50855d);
            sb2.append("   S_");
            sb2.append(i13);
            sb2.append("[j_");
            sb2.append(i13);
            sb2.append("]=");
            sb2.append(b(this.f50852a[this.f50854c]));
            sb2.append("   S_");
            sb2.append(i13);
            sb2.append("[j_");
            sb2.append(i10);
            sb2.append("]=");
            sb2.append(b(this.f50852a[this.f50855d]));
            if (this.f50852a[1] != 0) {
                sb2.append("   S[1]!=0");
            }
            fc.c.i(sb2.toString());
        }
    }

    public final void e(byte[] bArr) {
        d(256, bArr, false);
    }
}
