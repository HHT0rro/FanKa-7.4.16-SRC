package ga;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class a {
    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return new byte[0];
        }
        DataOutputStream dataOutputStream = null;
        dataOutputStream = null;
        dataOutputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                try {
                    DataOutputStream dataOutputStream2 = new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream, bArr.length));
                    try {
                        int length = bArr.length;
                        dataOutputStream2.write(bArr, 0, length);
                        dataOutputStream2.flush();
                        dataOutputStream2.close();
                        dataOutputStream = length;
                    } catch (IOException e2) {
                        e = e2;
                        dataOutputStream = dataOutputStream2;
                        fa.a.b("GZIPUtil", "gzip error!", e);
                        if (dataOutputStream != null) {
                            dataOutputStream.close();
                            dataOutputStream = dataOutputStream;
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th) {
                        th = th;
                        dataOutputStream = dataOutputStream2;
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (IOException e10) {
                                fa.a.b("GZIPUtil", "", e10);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e11) {
                    e = e11;
                }
            } catch (IOException e12) {
                fa.a.b("GZIPUtil", "", e12);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
