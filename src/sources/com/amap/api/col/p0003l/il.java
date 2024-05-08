package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

/* compiled from: StatisticsEntity.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class il {

    /* renamed from: a, reason: collision with root package name */
    private Context f6474a;

    /* renamed from: b, reason: collision with root package name */
    private String f6475b;

    /* renamed from: c, reason: collision with root package name */
    private String f6476c;

    /* renamed from: d, reason: collision with root package name */
    private String f6477d;

    /* renamed from: e, reason: collision with root package name */
    private String f6478e;

    public il(Context context, String str, String str2, String str3) throws fi {
        if (!TextUtils.isEmpty(str3) && str3.length() <= 256) {
            this.f6474a = context.getApplicationContext();
            this.f6476c = str;
            this.f6477d = str2;
            this.f6475b = str3;
            return;
        }
        throw new fi("无效的参数 - IllegalArgumentException");
    }

    private static byte[] a(int i10) {
        return new byte[]{(byte) ((i10 >> 24) & 255), (byte) ((i10 >> 16) & 255), (byte) ((i10 >> 8) & 255), (byte) (i10 & 255)};
    }

    private byte[] b(String str) {
        byte[] a10;
        if (!TextUtils.isEmpty(str) && (a10 = fv.a(this.f6478e)) != null) {
            return fv.a(a10.length);
        }
        return new byte[]{0, 0};
    }

    public final void a(String str) throws fi {
        if (!TextUtils.isEmpty(str) && str.length() <= 65536) {
            this.f6478e = str;
            return;
        }
        throw new fi("无效的参数 - IllegalArgumentException");
    }

    public final byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream;
        int i10 = 0;
        byte[] bArr = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            fv.a(byteArrayOutputStream, this.f6476c);
            fv.a(byteArrayOutputStream, this.f6477d);
            fv.a(byteArrayOutputStream, this.f6475b);
            fv.a(byteArrayOutputStream, String.valueOf(fm.j(this.f6474a)));
            try {
                i10 = (int) (System.currentTimeMillis() / 1000);
            } catch (Throwable unused) {
            }
            byteArrayOutputStream.write(a(i10));
            byteArrayOutputStream.write(b(this.f6478e));
            byteArrayOutputStream.write(fv.a(this.f6478e));
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream2 = byteArrayOutputStream;
            try {
                gy.b(th, "se", "tds");
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
                return bArr;
            } catch (Throwable th4) {
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                throw th4;
            }
        }
        return bArr;
    }
}
