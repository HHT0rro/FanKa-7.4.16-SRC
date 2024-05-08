package p001.p002.p003.p004.p005.p007;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: а.а.а.а.а.б.а, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0848 {

    /* renamed from: а, reason: contains not printable characters */
    private static final char[] f622 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: а, reason: contains not printable characters */
    public static String m3870(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int length = bArr.length;
        StringBuilder sb2 = new StringBuilder(length * 2);
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append(f622[(bArr[i10] >> 4) & 15]);
            sb2.append(f622[bArr[i10] & 15]);
        }
        return sb2.toString();
    }

    /* renamed from: а, reason: contains not printable characters */
    public static byte[] m3871(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i10 = 0; i10 < length; i10 += 2) {
            bArr[i10 / 2] = (byte) ((Character.digit(str.charAt(i10), 16) << 4) + Character.digit(str.charAt(i10 + 1), 16));
        }
        return bArr;
    }
}
