package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

/* compiled from: StatisticsHeaderDataStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class em extends eo {

    /* renamed from: a, reason: collision with root package name */
    public static int f7918a = 13;

    /* renamed from: b, reason: collision with root package name */
    public static int f7919b = 6;

    /* renamed from: e, reason: collision with root package name */
    private Context f7920e;

    public em(Context context, eo eoVar) {
        super(eoVar);
        this.f7920e = context;
    }

    @Override // com.amap.api.col.s.eo
    public final byte[] a(byte[] bArr) {
        byte[] a10 = a(this.f7920e);
        byte[] bArr2 = new byte[a10.length + bArr.length];
        System.arraycopy((Object) a10, 0, (Object) bArr2, 0, a10.length);
        System.arraycopy((Object) bArr, 0, (Object) bArr2, a10.length, bArr.length);
        return bArr2;
    }

    private static byte[] a(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            try {
                ci.a(byteArrayOutputStream, "1.2." + f7918a + "." + f7919b);
                ci.a(byteArrayOutputStream, "Android");
                ci.a(byteArrayOutputStream, ca.k());
                ci.a(byteArrayOutputStream, ca.h());
                ci.a(byteArrayOutputStream, ca.f(context));
                ci.a(byteArrayOutputStream, Build.MANUFACTURER);
                ci.a(byteArrayOutputStream, Build.MODEL);
                ci.a(byteArrayOutputStream, Build.DEVICE);
                ci.a(byteArrayOutputStream, ca.m());
                ci.a(byteArrayOutputStream, bw.c(context));
                ci.a(byteArrayOutputStream, bw.d(context));
                ci.a(byteArrayOutputStream, bw.f(context));
                byteArrayOutputStream.write(new byte[]{0});
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                try {
                    df.c(th, "sm", "gh");
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        return bArr;
    }
}
