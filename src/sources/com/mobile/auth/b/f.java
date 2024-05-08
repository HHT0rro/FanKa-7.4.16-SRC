package com.mobile.auth.b;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import java.nio.charset.Charset;
import sun.security.util.DerValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f36686a = "f";

    /* renamed from: b, reason: collision with root package name */
    private static byte[] f36687b = {68, DerValue.TAG_APPLICATION, 94, 49, 69, 35, 50, 83};

    /* renamed from: c, reason: collision with root package name */
    private static final Charset f36688c = Charset.forName("UTF-8");

    public static String a(byte[] bArr) {
        try {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                bArr2[i10] = bArr[i10];
                for (byte b4 : f36687b) {
                    bArr2[i10] = (byte) (b4 ^ bArr2[i10]);
                }
            }
            return new String(bArr2);
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return "";
            } catch (Throwable th2) {
                try {
                    ExceptionProcessor.processException(th2);
                    return null;
                } catch (Throwable th3) {
                    ExceptionProcessor.processException(th3);
                    return null;
                }
            }
        }
    }
}
