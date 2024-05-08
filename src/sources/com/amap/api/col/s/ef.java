package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

/* compiled from: StatisticsEntity.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ef {

    /* renamed from: a, reason: collision with root package name */
    private Context f7893a;

    /* renamed from: b, reason: collision with root package name */
    private String f7894b;

    /* renamed from: c, reason: collision with root package name */
    private String f7895c;

    /* renamed from: d, reason: collision with root package name */
    private String f7896d;

    /* renamed from: e, reason: collision with root package name */
    private String f7897e;

    public ef(Context context, String str, String str2, String str3) throws bv {
        if (!TextUtils.isEmpty(str3) && str3.length() <= 256) {
            this.f7893a = context.getApplicationContext();
            this.f7895c = str;
            this.f7896d = str2;
            this.f7894b = str3;
            return;
        }
        throw new bv("无效的参数 - IllegalArgumentException");
    }

    private static byte[] a(int i10) {
        return new byte[]{(byte) ((i10 >> 24) & 255), (byte) ((i10 >> 16) & 255), (byte) ((i10 >> 8) & 255), (byte) (i10 & 255)};
    }

    private byte[] b(String str) {
        byte[] a10;
        if (!TextUtils.isEmpty(str) && (a10 = ci.a(this.f7897e)) != null) {
            return ci.a(a10.length);
        }
        return new byte[]{0, 0};
    }

    public final void a(String str) throws bv {
        if (!TextUtils.isEmpty(str) && str.length() <= 65536) {
            this.f7897e = str;
            return;
        }
        throw new bv("无效的参数 - IllegalArgumentException");
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
            ci.a(byteArrayOutputStream, this.f7895c);
            ci.a(byteArrayOutputStream, this.f7896d);
            ci.a(byteArrayOutputStream, this.f7894b);
            ci.a(byteArrayOutputStream, String.valueOf(ca.i(this.f7893a)));
            try {
                i10 = (int) (System.currentTimeMillis() / 1000);
            } catch (Throwable unused) {
            }
            byteArrayOutputStream.write(a(i10));
            byteArrayOutputStream.write(b(this.f7897e));
            byteArrayOutputStream.write(ci.a(this.f7897e));
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream2 = byteArrayOutputStream;
            try {
                df.c(th, "se", "tds");
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
