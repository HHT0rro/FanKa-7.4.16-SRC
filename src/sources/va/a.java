package va;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f54060a = "BaseKeyUtil";

    public static int a(int i10, int i11, int i12) {
        if (i11 < i10) {
            i10 = i11;
        }
        return i12 < i10 ? i12 : i10;
    }

    public static boolean b(int i10) {
        return i10 >= 16;
    }

    public static boolean c(int i10, byte[] bArr) {
        return b(i10) & d(bArr);
    }

    public static boolean d(byte[] bArr) {
        return bArr.length >= 16;
    }

    public static byte[] e(String str, String str2, String str3, String str4, int i10, boolean z10) {
        return g(str, str2, str3, c.b(str4), i10, z10);
    }

    public static byte[] f(String str, String str2, String str3, byte[] bArr, int i10, int i11, boolean z10) {
        byte[] b4 = c.b(str);
        byte[] b10 = c.b(str2);
        byte[] b11 = c.b(str3);
        int a10 = a(b4.length, b10.length, b11.length);
        if (c(a10, bArr)) {
            char[] cArr = new char[a10];
            for (int i12 = 0; i12 < a10; i12++) {
                cArr[i12] = (char) ((b4[i12] ^ b10[i12]) ^ b11[i12]);
            }
            if (!z10) {
                f.d(f54060a, "exportRootKey: sha1");
                return ta.a.b(cArr, bArr, i10, i11 * 8);
            }
            f.d(f54060a, "exportRootKey: sha256");
            return ta.a.c(cArr, bArr, i10, i11 * 8);
        }
        throw new IllegalArgumentException("key length must be more than 128bit.");
    }

    public static byte[] g(String str, String str2, String str3, byte[] bArr, int i10, boolean z10) {
        return f(str, str2, str3, bArr, 10000, i10, z10);
    }

    public static byte[] h(String str, String str2, String str3, byte[] bArr, boolean z10) {
        return g(str, str2, str3, bArr, 16, z10);
    }
}
