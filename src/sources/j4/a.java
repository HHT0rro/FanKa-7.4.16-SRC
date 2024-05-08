package j4;

import android.text.TextUtils;
import h4.c;
import h4.d;
import java.io.IOException;

/* compiled from: WebPReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a extends c {

    /* renamed from: c, reason: collision with root package name */
    public static ThreadLocal<byte[]> f50297c = new ThreadLocal<>();

    public a(d dVar) {
        super(dVar);
    }

    public static byte[] c() {
        byte[] bArr = f50297c.get();
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[4];
        f50297c.set(bArr2);
        return bArr2;
    }

    public int d() throws IOException {
        return g() + 1;
    }

    public int e() throws IOException {
        byte[] c4 = c();
        read(c4, 0, 4);
        return ((c4[3] & 255) << 24) | (c4[0] & 255) | ((c4[1] & 255) << 8) | ((c4[2] & 255) << 16);
    }

    public int f() throws IOException {
        byte[] c4 = c();
        read(c4, 0, 2);
        return ((c4[1] & 255) << 8) | (c4[0] & 255);
    }

    public int g() throws IOException {
        byte[] c4 = c();
        read(c4, 0, 3);
        return ((c4[2] & 255) << 16) | (c4[0] & 255) | ((c4[1] & 255) << 8);
    }

    public int h() throws IOException {
        byte[] c4 = c();
        read(c4, 0, 4);
        return ((c4[3] & 255) << 24) | (c4[0] & 255) | ((c4[1] & 255) << 8) | ((c4[2] & 255) << 16);
    }

    public boolean i(String str) throws IOException {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return false;
        }
        int e2 = e();
        for (int i10 = 0; i10 < 4; i10++) {
            if (((e2 >> (i10 * 8)) & 255) != str.charAt(i10)) {
                return false;
            }
        }
        return true;
    }
}
