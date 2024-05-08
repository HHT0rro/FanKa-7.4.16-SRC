package com.android.internal.org.bouncycastle.asn1.pkcs;

import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RSAPrivateKey extends ASN1Object {
    private BigInteger coefficient;
    private BigInteger exponent1;
    private BigInteger exponent2;
    private BigInteger modulus;
    private ASN1Sequence otherPrimeInfos;
    private BigInteger prime1;
    private BigInteger prime2;
    private BigInteger privateExponent;
    private BigInteger publicExponent;
    private BigInteger version;

    public static RSAPrivateKey getInstance(ASN1TaggedObject obj, boolean explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    public static RSAPrivateKey getInstance(Object obj) {
        if (obj instanceof RSAPrivateKey) {
            return (RSAPrivateKey) obj;
        }
        if (obj != null) {
            return new RSAPrivateKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public RSAPrivateKey(BigInteger modulus, BigInteger publicExponent, BigInteger privateExponent, BigInteger prime1, BigInteger prime2, BigInteger exponent1, BigInteger exponent2, BigInteger coefficient) {
        this.otherPrimeInfos = null;
        this.version = BigInteger.valueOf(0L);
        this.modulus = modulus;
        this.publicExponent = publicExponent;
        this.privateExponent = privateExponent;
        this.prime1 = prime1;
        this.prime2 = prime2;
        this.exponent1 = exponent1;
        this.exponent2 = exponent2;
        this.coefficient = coefficient;
    }

    private RSAPrivateKey(ASN1Sequence seq) {
        this.otherPrimeInfos = null;
        Enumeration e2 = seq.getObjects();
        ASN1Integer v2 = (ASN1Integer) e2.nextElement();
        int versionValue = v2.intValueExact();
        if (versionValue < 0 || versionValue > 1) {
            throw new IllegalArgumentException("wrong version for RSA private key");
        }
        this.version = v2.getValue();
        this.modulus = ((ASN1Integer) e2.nextElement()).getValue();
        this.publicExponent = ((ASN1Integer) e2.nextElement()).getValue();
        this.privateExponent = ((ASN1Integer) e2.nextElement()).getValue();
        this.prime1 = ((ASN1Integer) e2.nextElement()).getValue();
        this.prime2 = ((ASN1Integer) e2.nextElement()).getValue();
        this.exponent1 = ((ASN1Integer) e2.nextElement()).getValue();
        this.exponent2 = ((ASN1Integer) e2.nextElement()).getValue();
        this.coefficient = ((ASN1Integer) e2.nextElement()).getValue();
        if (e2.hasMoreElements()) {
            this.otherPrimeInfos = (ASN1Sequence) e2.nextElement();
        }
    }

    public BigInteger getVersion() {
        return this.version;
    }

    public BigInteger getModulus() {
        return this.modulus;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    public BigInteger getPrivateExponent() {
        return this.privateExponent;
    }

    public BigInteger getPrime1() {
        return this.prime1;
    }

    public BigInteger getPrime2() {
        return this.prime2;
    }

    public BigInteger getExponent1() {
        return this.exponent1;
    }

    public BigInteger getExponent2() {
        return this.exponent2;
    }

    public BigInteger getCoefficient() {
        return this.coefficient;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v2 = new ASN1EncodableVector(10);
        v2.add(new ASN1Integer(this.version));
        v2.add(new ASN1Integer(getModulus()));
        v2.add(new ASN1Integer(getPublicExponent()));
        v2.add(new ASN1Integer(getPrivateExponent()));
        v2.add(new ASN1Integer(getPrime1()));
        v2.add(new ASN1Integer(getPrime2()));
        v2.add(new ASN1Integer(getExponent1()));
        v2.add(new ASN1Integer(getExponent2()));
        v2.add(new ASN1Integer(getCoefficient()));
        ASN1Sequence aSN1Sequence = this.otherPrimeInfos;
        if (aSN1Sequence != null) {
            v2.add(aSN1Sequence);
        }
        return new DERSequence(v2);
    }
}
