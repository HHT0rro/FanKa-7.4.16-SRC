package com.android.internal.org.bouncycastle.jcajce.util;

import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1OctetString;
import com.android.internal.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.android.internal.org.bouncycastle.asn1.x9.ECNamedCurveTable;
import com.android.internal.org.bouncycastle.asn1.x9.X962Parameters;
import com.android.internal.org.bouncycastle.asn1.x9.X9ECParameters;
import com.android.internal.org.bouncycastle.asn1.x9.X9ECPoint;
import com.android.internal.org.bouncycastle.crypto.ec.CustomNamedCurves;
import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import java.io.IOException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ECKeyUtil {
    public static ECPublicKey createKeyWithCompression(ECPublicKey ecPublicKey) {
        return new ECPublicKeyWithCompression(ecPublicKey);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static class ECPublicKeyWithCompression implements ECPublicKey {
        private final ECPublicKey ecPublicKey;

        public ECPublicKeyWithCompression(ECPublicKey ecPublicKey) {
            this.ecPublicKey = ecPublicKey;
        }

        @Override // java.security.interfaces.ECPublicKey
        public ECPoint getW() {
            return this.ecPublicKey.getW();
        }

        @Override // java.security.Key
        public String getAlgorithm() {
            return this.ecPublicKey.getAlgorithm();
        }

        @Override // java.security.Key
        public String getFormat() {
            return this.ecPublicKey.getFormat();
        }

        @Override // java.security.Key
        public byte[] getEncoded() {
            ECCurve curve;
            SubjectPublicKeyInfo publicKeyInfo = SubjectPublicKeyInfo.getInstance(this.ecPublicKey.getEncoded());
            X962Parameters params = X962Parameters.getInstance(publicKeyInfo.getAlgorithm().getParameters());
            if (params.isNamedCurve()) {
                ASN1ObjectIdentifier oid = (ASN1ObjectIdentifier) params.getParameters();
                X9ECParameters x92 = CustomNamedCurves.getByOID(oid);
                if (x92 == null) {
                    x92 = ECNamedCurveTable.getByOID(oid);
                }
                curve = x92.getCurve();
            } else {
                if (params.isImplicitlyCA()) {
                    throw new IllegalStateException("unable to identify implictlyCA");
                }
                curve = X9ECParameters.getInstance(params.getParameters()).getCurve();
            }
            com.android.internal.org.bouncycastle.math.ec.ECPoint p10 = curve.decodePoint(publicKeyInfo.getPublicKeyData().getOctets());
            ASN1OctetString pEnc = ASN1OctetString.getInstance(new X9ECPoint(p10, true).toASN1Primitive());
            try {
                return new SubjectPublicKeyInfo(publicKeyInfo.getAlgorithm(), pEnc.getOctets()).getEncoded();
            } catch (IOException e2) {
                throw new IllegalStateException("unable to encode EC public key: " + e2.getMessage());
            }
        }

        @Override // java.security.interfaces.ECKey
        public ECParameterSpec getParams() {
            return this.ecPublicKey.getParams();
        }
    }
}
