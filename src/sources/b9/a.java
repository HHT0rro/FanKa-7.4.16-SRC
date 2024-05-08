package b9;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f1415a = "0123456789ABCDEF".toCharArray();

    public static byte[] a(char[] cArr) {
        if ((cArr.length & 1) != 0) {
            throw new IllegalArgumentException("Odd number of characters.");
        }
        byte[] bArr = new byte[cArr.length >> 1];
        int i10 = 0;
        int i11 = 0;
        while (i10 < cArr.length) {
            int digit = Character.digit(cArr[i10], 16);
            if (digit == -1) {
                throw new IllegalArgumentException("Illegal hexadecimal character at index " + i10);
            }
            int i12 = i10 + 1;
            int digit2 = Character.digit(cArr[i12], 16);
            if (digit2 == -1) {
                throw new IllegalArgumentException("Illegal hexadecimal character at index " + i12);
            }
            i10 = i12 + 1;
            bArr[i11] = (byte) (((digit << 4) | digit2) & 255);
            i11++;
        }
        return bArr;
    }

    public static byte[] b(String str) {
        return a(str.toCharArray());
    }

    public static String c(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b4 : bArr) {
            char[] cArr = f1415a;
            sb2.append(cArr[(b4 >> 4) & 15]);
            sb2.append(cArr[b4 & 15]);
        }
        return sb2.toString();
    }
}
