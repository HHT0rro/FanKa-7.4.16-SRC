package com.xiaomi.push;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class q2 {
    public static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static boolean b(Context context, String str, long j10) {
        return kc.j.d(context).i(hv.DCJobMutualSwitch.a(), false) && !l.a(context, str, j10);
    }

    public static byte[] c(String str, byte[] bArr) {
        byte[] b4 = m0.b(str);
        try {
            a(b4);
            return w5.b(b4, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] d(String str, byte[] bArr) {
        byte[] b4 = m0.b(str);
        try {
            a(b4);
            return w5.c(b4, bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
