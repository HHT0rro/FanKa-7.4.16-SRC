package com.vivo.push.util;

import android.content.Context;
import android.util.Base64;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AESParseManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f46385c;

    /* renamed from: a, reason: collision with root package name */
    private byte[] f46386a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f46387b;

    private a(Context context) {
        ad.b().a(ContextDelegate.getContext(context));
        ad b4 = ad.b();
        this.f46386a = b4.c();
        this.f46387b = b4.d();
    }

    public static a a(Context context) {
        if (f46385c == null) {
            synchronized (a.class) {
                if (f46385c == null) {
                    f46385c = new a(context.getApplicationContext());
                }
            }
        }
        return f46385c;
    }

    public final String b(String str) throws Exception {
        return new String(j.a(j.a(a()), j.a(b()), Base64.decode(str, 2)), "utf-8");
    }

    private byte[] b() {
        byte[] bArr = this.f46387b;
        return (bArr == null || bArr.length <= 0) ? ad.b().d() : bArr;
    }

    public final String a(String str) throws Exception {
        String a10 = j.a(a());
        String a11 = j.a(b());
        byte[] bytes = str.getBytes("utf-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(a11.getBytes("utf-8"), AESEncrypt.ALGORITHM);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(a10.getBytes("utf-8")));
        return Base64.encodeToString(cipher.doFinal(bytes), 2);
    }

    private byte[] a() {
        byte[] bArr = this.f46386a;
        return (bArr == null || bArr.length <= 0) ? ad.b().c() : bArr;
    }
}
