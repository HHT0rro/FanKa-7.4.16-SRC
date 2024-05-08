package com.tencent.cloud.huiyansdkface.wehttp2;

import com.huawei.hms.feature.dynamic.f.e;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HttpsCertificateUtils {
    public static String getCertificate(String str) {
        String trim = str.trim();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("-----BEGIN CERTIFICATE-----\n");
        int length = trim.length();
        int i10 = 0;
        while (true) {
            int i11 = i10 + 64;
            if (i11 >= length) {
                break;
            }
            sb2.append(trim.substring(i10, i11) + "\n");
            i10 = i11;
        }
        int i12 = length % 64;
        if (i12 > 0) {
            sb2.append(trim.substring(length - i12, length) + "\n");
        }
        sb2.append("-----END CERTIFICATE-----");
        return sb2.toString();
    }

    public static String getFingerPrint(String str) {
        try {
            return ByteString.of(MessageDigest.getInstance("SHA256").digest(((X509Certificate) CertificateFactory.getInstance(e.f29912b).generateCertificate(new ByteArrayInputStream(str.getBytes()))).getPublicKey().getEncoded())).hex();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
