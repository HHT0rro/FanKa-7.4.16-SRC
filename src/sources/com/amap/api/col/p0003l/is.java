package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

/* compiled from: StatisticsHeaderDataStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class is extends iu {

    /* renamed from: a, reason: collision with root package name */
    public static int f6499a = 13;

    /* renamed from: b, reason: collision with root package name */
    public static int f6500b = 6;

    /* renamed from: e, reason: collision with root package name */
    private Context f6501e;

    public is(Context context, iu iuVar) {
        super(iuVar);
        this.f6501e = context;
    }

    @Override // com.amap.api.col.p0003l.iu
    public final byte[] a(byte[] bArr) {
        byte[] a10 = a(this.f6501e);
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
                fv.a(byteArrayOutputStream, "1.2." + f6499a + "." + f6500b);
                fv.a(byteArrayOutputStream, "Android");
                fv.a(byteArrayOutputStream, fm.k());
                fv.a(byteArrayOutputStream, fm.h());
                fv.a(byteArrayOutputStream, fm.f(context));
                fv.a(byteArrayOutputStream, Build.MANUFACTURER);
                fv.a(byteArrayOutputStream, Build.MODEL);
                fv.a(byteArrayOutputStream, Build.DEVICE);
                fv.a(byteArrayOutputStream, fm.n());
                fv.a(byteArrayOutputStream, fj.c(context));
                fv.a(byteArrayOutputStream, fj.d(context));
                fv.a(byteArrayOutputStream, fj.f(context));
                byteArrayOutputStream.write(new byte[]{0});
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                try {
                    gy.b(th, "sm", "gh");
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
