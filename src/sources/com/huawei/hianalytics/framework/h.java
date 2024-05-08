package com.huawei.hianalytics.framework;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hms.ads.uiengineloader.ae;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class h {
    public static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr2 = new byte[0];
        Deflater deflater = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    Deflater deflater2 = new Deflater();
                    try {
                        deflater2.setInput(bArr);
                        deflater2.finish();
                        byte[] bArr3 = new byte[1024];
                        while (!deflater2.finished()) {
                            byteArrayOutputStream.write(bArr3, 0, deflater2.deflate(bArr3));
                        }
                        bArr2 = byteArrayOutputStream.toByteArray();
                        deflater2.end();
                        a(byteArrayOutputStream);
                    } catch (Exception e2) {
                        e = e2;
                        deflater = deflater2;
                        HiLog.e(ae.f29427a, "getBitZip, Exception: e " + e.getMessage());
                        if (deflater != null) {
                            deflater.end();
                        }
                        a(byteArrayOutputStream);
                        return bArr2;
                    } catch (Throwable th) {
                        th = th;
                        deflater = deflater2;
                        if (deflater != null) {
                            deflater.end();
                        }
                        a(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Exception e11) {
            e = e11;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
        return bArr2;
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
                HiLog.sw(ae.f29427a, "closeStream(): Exception: close OutputStream error!");
            }
        }
    }
}
