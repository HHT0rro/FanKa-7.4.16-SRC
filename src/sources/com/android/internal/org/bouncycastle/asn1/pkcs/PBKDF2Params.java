package com.android.internal.org.bouncycastle.asn1.pkcs;

import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1OctetString;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.DERNull;
import com.android.internal.org.bouncycastle.asn1.DEROctetString;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import com.android.internal.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.android.internal.org.bouncycastle.util.Arrays;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class PBKDF2Params extends ASN1Object {
    private static final AlgorithmIdentifier algid_hmacWithSHA1 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA1, DERNull.INSTANCE);
    private final ASN1Integer iterationCount;
    private final ASN1Integer keyLength;
    private final ASN1OctetString octStr;
    private final AlgorithmIdentifier prf;

    public static PBKDF2Params getInstance(Object obj) {
        if (obj instanceof PBKDF2Params) {
            return (PBKDF2Params) obj;
        }
        if (obj != null) {
            return new PBKDF2Params(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public PBKDF2Params(byte[] salt, int iterationCount) {
        this(salt, iterationCount, 0);
    }

    public PBKDF2Params(byte[] salt, int iterationCount, int keyLength) {
        this(salt, iterationCount, keyLength, null);
    }

    public PBKDF2Params(byte[] salt, int iterationCount, int keyLength, AlgorithmIdentifier prf) {
        this.octStr = new DEROctetString(Arrays.clone(salt));
        this.iterationCount = new ASN1Integer(iterationCount);
        if (keyLength > 0) {
            this.keyLength = new ASN1Integer(keyLength);
        } else {
            this.keyLength = null;
        }
        this.prf = prf;
    }

    public PBKDF2Params(byte[] salt, int iterationCount, AlgorithmIdentifier prf) {
        this(salt, iterationCount, 0, prf);
    }

    private PBKDF2Params(ASN1Sequence seq) {
        Enumeration e2 = seq.getObjects();
        this.octStr = (ASN1OctetString) e2.nextElement();
        this.iterationCount = (ASN1Integer) e2.nextElement();
        if (e2.hasMoreElements()) {
            Object o10 = e2.nextElement();
            if (o10 instanceof ASN1Integer) {
                this.keyLength = ASN1Integer.getInstance(o10);
                if (e2.hasMoreElements()) {
                    o10 = e2.nextElement();
                } else {
                    o10 = null;
                }
            } else {
                this.keyLength = null;
            }
            if (o10 != null) {
                this.prf = AlgorithmIdentifier.getInstance(o10);
                return;
            } else {
                this.prf = null;
                return;
            }
        }
        this.keyLength = null;
        this.prf = null;
    }

    public byte[] getSalt() {
        return this.octStr.getOctets();
    }

    public BigInteger getIterationCount() {
        return this.iterationCount.getValue();
    }

    public BigInteger getKeyLength() {
        ASN1Integer aSN1Integer = this.keyLength;
        if (aSN1Integer != null) {
            return aSN1Integer.getValue();
        }
        return null;
    }

    public boolean isDefaultPrf() {
        AlgorithmIdentifier algorithmIdentifier = this.prf;
        return algorithmIdentifier == null || algorithmIdentifier.equals(algid_hmacWithSHA1);
    }

    public AlgorithmIdentifier getPrf() {
        AlgorithmIdentifier algorithmIdentifier = this.prf;
        if (algorithmIdentifier != null) {
            return algorithmIdentifier;
        }
        return algid_hmacWithSHA1;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v2 = new ASN1EncodableVector(4);
        v2.add(this.octStr);
        v2.add(this.iterationCount);
        ASN1Integer aSN1Integer = this.keyLength;
        if (aSN1Integer != null) {
            v2.add(aSN1Integer);
        }
        AlgorithmIdentifier algorithmIdentifier = this.prf;
        if (algorithmIdentifier != null && !algorithmIdentifier.equals(algid_hmacWithSHA1)) {
            v2.add(this.prf);
        }
        return new DERSequence(v2);
    }
}
