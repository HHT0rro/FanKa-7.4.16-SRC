package ac;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f780a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f781b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static byte[] a(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException();
        }
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[str.length() / 2];
        int length = str.length();
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            StringBuilder sb2 = new StringBuilder();
            int i12 = i10 + 1;
            sb2.append(charArray[i10]);
            sb2.append(charArray[i12]);
            bArr[i11] = Integer.valueOf(Integer.parseInt(sb2.toString(), 16) & 255).byteValue();
            i10 = i12 + 1;
            i11++;
        }
        return bArr;
    }
}
