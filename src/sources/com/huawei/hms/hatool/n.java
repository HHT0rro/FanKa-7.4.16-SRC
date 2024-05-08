package com.huawei.hms.hatool;

import android.util.Pair;
import java.nio.charset.Charset;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f30184a = Charset.forName("UTF-8");

    public static Pair<byte[], String> a(String str, int i10) {
        if (str == null || str.length() < i10) {
            return new Pair<>(new byte[0], str);
        }
        String substring = str.substring(0, i10);
        return new Pair<>(va.c.b(substring), str.substring(i10));
    }

    public static String a(String str, String str2) {
        Pair<byte[], String> a10 = a(str, 32);
        return new String(sa.a.i(va.c.b((String) a10.second), va.c.b(str2), (byte[]) a10.first), f30184a);
    }

    public static String a(byte[] bArr, String str) {
        String str2;
        if (bArr == null || bArr.length == 0 || str == null) {
            str2 = "cbc encrypt(byte) param is not right";
        } else {
            byte[] b4 = va.c.b(str);
            if (b4.length >= 16) {
                return va.c.a(sa.b.h(bArr, b4));
            }
            str2 = "key length is not right";
        }
        v.b("AesCipher", str2);
        return "";
    }

    public static String b(String str, String str2) {
        return va.c.a(sa.a.l(str.getBytes(f30184a), va.c.b(str2)));
    }
}
