package com.tencent.turingface.sdk.mfa;

import android.util.Base64;
import com.alipay.sdk.util.i;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class tfWT8 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f45951a = kC0XR.a(kC0XR.T0);

    /* renamed from: b, reason: collision with root package name */
    public static final String f45952b = kC0XR.a(kC0XR.P0);

    /* renamed from: c, reason: collision with root package name */
    public static final String f45953c = kC0XR.a(kC0XR.Q0);

    /* renamed from: d, reason: collision with root package name */
    public static final String f45954d = kC0XR.a(kC0XR.R0);

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ boolean f45955e = true;

    public static String a(Certificate certificate) throws Exception {
        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        bufferedWriter.write("-----BEGIN CERTIFICATE-----");
        bufferedWriter.write("\n");
        byte[] encode = Base64.encode(certificate.getEncoded(), 2);
        char[] cArr = new char[64];
        for (int i10 = 0; i10 < encode.length; i10 += 64) {
            int i11 = 0;
            while (i11 != 64) {
                int i12 = i10 + i11;
                if (i12 >= encode.length) {
                    break;
                }
                cArr[i11] = (char) encode[i12];
                i11++;
            }
            bufferedWriter.write(cArr, 0, i11);
            bufferedWriter.write("\n");
        }
        bufferedWriter.write("-----END CERTIFICATE-----");
        bufferedWriter.write("\n");
        bufferedWriter.close();
        return stringWriter.toString();
    }

    public static void a(X509Certificate x509Certificate, F2BEC f2bec) throws Exception, IOException {
        byte[] extensionValue = x509Certificate.getExtensionValue(f45951a);
        if (extensionValue != null && extensionValue.length != 0) {
            try {
                byte b4 = "{".getBytes()[0];
                byte b10 = i.f4738d.getBytes()[0];
                int i10 = 0;
                int i11 = 0;
                for (int i12 = 0; i12 < extensionValue.length; i12++) {
                    byte b11 = extensionValue[i12];
                    if (b11 == b4) {
                        i10 = i12;
                    } else if (b11 == b10) {
                        i11 = i12;
                    }
                }
                if (i10 <= 0 || i10 >= i11) {
                    return;
                }
                if (!f45955e && extensionValue[i10 - 1] != (i11 - i10) + 1) {
                    throw new AssertionError();
                }
                int i13 = (i11 - i10) + 1;
                byte[] bArr = new byte[i13];
                System.arraycopy((Object) extensionValue, i10, (Object) bArr, 0, i13);
                JSONObject jSONObject = new JSONObject(new String(bArr));
                f2bec.f45582h = jSONObject.getString(f45953c);
                f2bec.f45581g = jSONObject.getInt(f45954d);
                f2bec.f45580f = jSONObject.getLong(f45952b);
                return;
            } catch (Exception e2) {
                StringBuilder b12 = com.tencent.turingcam.oqKCa.b("C");
                b12.append((Object) e2.getStackTrace());
                throw new Exception(b12.toString());
            }
        }
        throw new Exception("Couldn't find the keystore attestation extension data.");
    }
}
