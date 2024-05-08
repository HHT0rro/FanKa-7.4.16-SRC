package da;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public int f48664b = 1024;

    /* renamed from: c, reason: collision with root package name */
    public int f48665c = 0;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f48663a = new byte[1024];

    public static String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        int i10 = 0;
        for (byte b4 : bArr) {
            int i11 = i10 + 1;
            cArr2[i10] = cArr[(b4 >>> 4) & 15];
            i10 = i11 + 1;
            cArr2[i11] = cArr[b4 & 15];
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cArr2);
        return sb2.toString();
    }

    public void b() {
        this.f48663a = new byte[this.f48664b];
        this.f48665c = 0;
    }

    public void c(byte[] bArr, int i10) {
        if (i10 <= 0) {
            return;
        }
        byte[] bArr2 = this.f48663a;
        int length = bArr2.length;
        int i11 = this.f48665c;
        if (length - i11 >= i10) {
            System.arraycopy((Object) bArr, 0, (Object) bArr2, i11, i10);
        } else {
            byte[] bArr3 = new byte[(bArr2.length + i10) << 1];
            System.arraycopy((Object) bArr2, 0, (Object) bArr3, 0, i11);
            System.arraycopy((Object) bArr, 0, (Object) bArr3, this.f48665c, i10);
            this.f48663a = bArr3;
        }
        this.f48665c += i10;
    }

    public byte[] d() {
        int i10 = this.f48665c;
        if (i10 <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i10];
        System.arraycopy((Object) this.f48663a, 0, (Object) bArr, 0, i10);
        return bArr;
    }

    public int e() {
        return this.f48665c;
    }
}
