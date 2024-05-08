package com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util;

import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1Encoding;
import com.android.internal.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.android.internal.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.android.internal.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class KeyUtil {
    public static byte[] getEncodedSubjectPublicKeyInfo(AlgorithmIdentifier algId, ASN1Encodable keyData) {
        try {
            return getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(algId, keyData));
        } catch (Exception e2) {
            return null;
        }
    }

    public static byte[] getEncodedSubjectPublicKeyInfo(AlgorithmIdentifier algId, byte[] keyData) {
        try {
            return getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(algId, keyData));
        } catch (Exception e2) {
            return null;
        }
    }

    public static byte[] getEncodedSubjectPublicKeyInfo(SubjectPublicKeyInfo info) {
        try {
            return info.getEncoded(ASN1Encoding.DER);
        } catch (Exception e2) {
            return null;
        }
    }

    public static byte[] getEncodedPrivateKeyInfo(AlgorithmIdentifier algId, ASN1Encodable privKey) {
        try {
            PrivateKeyInfo info = new PrivateKeyInfo(algId, privKey.toASN1Primitive());
            return getEncodedPrivateKeyInfo(info);
        } catch (Exception e2) {
            return null;
        }
    }

    public static byte[] getEncodedPrivateKeyInfo(PrivateKeyInfo info) {
        try {
            return info.getEncoded(ASN1Encoding.DER);
        } catch (Exception e2) {
            return null;
        }
    }
}