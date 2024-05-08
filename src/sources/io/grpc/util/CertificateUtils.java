package io.grpc.util;

import com.google.common.io.BaseEncoding;
import com.huawei.hms.feature.dynamic.f.e;
import io.grpc.ExperimentalApi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/8024")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class CertificateUtils {
    public static PrivateKey getPrivateKey(InputStream inputStream) throws UnsupportedEncodingException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        String readLine;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        do {
            readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
        } while (!"-----BEGIN PRIVATE KEY-----".equals(readLine));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String readLine2 = bufferedReader.readLine();
            if (readLine2 == null || "-----END PRIVATE KEY-----".equals(readLine2)) {
                break;
            }
            sb2.append(readLine2);
        }
        PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(BaseEncoding.a().b(sb2.toString()));
        try {
            try {
                return KeyFactory.getInstance("RSA").generatePrivate(pKCS8EncodedKeySpec);
            } catch (InvalidKeySpecException unused) {
                return KeyFactory.getInstance("EC").generatePrivate(pKCS8EncodedKeySpec);
            }
        } catch (InvalidKeySpecException e2) {
            throw new InvalidKeySpecException("Neither RSA nor EC worked", e2);
        }
    }

    public static X509Certificate[] getX509Certificates(InputStream inputStream) throws CertificateException {
        return (X509Certificate[]) CertificateFactory.getInstance(e.f29912b).generateCertificates(inputStream).toArray(new X509Certificate[0]);
    }
}
