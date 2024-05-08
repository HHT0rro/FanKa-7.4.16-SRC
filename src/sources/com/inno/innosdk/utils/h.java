package com.inno.innosdk.utils;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/* compiled from: Gzip.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h {
    public static byte[] a(String str) {
        return a(str, null);
    }

    public static byte[] a(String str, byte[] bArr) {
        GZIPOutputStream gZIPOutputStream = null;
        if ((bArr == null || bArr.length == 0) && TextUtils.isEmpty(str)) {
            return null;
        }
        if (bArr == null) {
            bArr = str.getBytes();
        }
        byte[] bArr2 = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(bArr);
                    bArr2 = byteArrayOutputStream.toByteArray();
                    com.inno.innosdk.utils.t.a.a(gZIPOutputStream2);
                    com.inno.innosdk.utils.t.a.a(byteArrayOutputStream);
                } catch (IOException e2) {
                    e = e2;
                    gZIPOutputStream = gZIPOutputStream2;
                    com.inno.innosdk.utils.u.a.a((Throwable) e);
                    com.inno.innosdk.utils.t.a.a(gZIPOutputStream);
                    com.inno.innosdk.utils.t.a.a(byteArrayOutputStream);
                    return bArr2;
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    com.inno.innosdk.utils.t.a.a(gZIPOutputStream);
                    com.inno.innosdk.utils.t.a.a(byteArrayOutputStream);
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
            }
            return bArr2;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
