package com.android.internal.org.bouncycastle.asn1.x509;

import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1OctetString;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject;
import com.android.internal.org.bouncycastle.asn1.DEROctetString;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import com.android.internal.org.bouncycastle.asn1.DERTaggedObject;
import com.android.internal.org.bouncycastle.crypto.Digest;
import com.android.internal.org.bouncycastle.crypto.digests.AndroidDigestFactory;
import com.android.internal.org.bouncycastle.util.encoders.Hex;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AuthorityKeyIdentifier extends ASN1Object {
    GeneralNames certissuer;
    ASN1Integer certserno;
    ASN1OctetString keyidentifier;

    public static AuthorityKeyIdentifier getInstance(ASN1TaggedObject obj, boolean explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    public static AuthorityKeyIdentifier getInstance(Object obj) {
        if (obj instanceof AuthorityKeyIdentifier) {
            return (AuthorityKeyIdentifier) obj;
        }
        if (obj != null) {
            return new AuthorityKeyIdentifier(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static AuthorityKeyIdentifier fromExtensions(Extensions extensions) {
        return getInstance(Extensions.getExtensionParsedValue(extensions, Extension.authorityKeyIdentifier));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AuthorityKeyIdentifier(ASN1Sequence seq) {
        this.keyidentifier = null;
        this.certissuer = null;
        this.certserno = null;
        Enumeration e2 = seq.getObjects();
        while (e2.hasMoreElements()) {
            ASN1TaggedObject o10 = ASN1TaggedObject.getInstance(e2.nextElement());
            switch (o10.getTagNo()) {
                case 0:
                    this.keyidentifier = ASN1OctetString.getInstance(o10, false);
                    break;
                case 1:
                    this.certissuer = GeneralNames.getInstance(o10, false);
                    break;
                case 2:
                    this.certserno = ASN1Integer.getInstance(o10, false);
                    break;
                default:
                    throw new IllegalArgumentException("illegal tag");
            }
        }
    }

    public AuthorityKeyIdentifier(SubjectPublicKeyInfo spki) {
        this.keyidentifier = null;
        this.certissuer = null;
        this.certserno = null;
        Digest digest = AndroidDigestFactory.getSHA1();
        byte[] resBuf = new byte[digest.getDigestSize()];
        byte[] bytes = spki.getPublicKeyData().getBytes();
        digest.update(bytes, 0, bytes.length);
        digest.doFinal(resBuf, 0);
        this.keyidentifier = new DEROctetString(resBuf);
    }

    public AuthorityKeyIdentifier(SubjectPublicKeyInfo spki, GeneralNames name, BigInteger serialNumber) {
        this.keyidentifier = null;
        this.certissuer = null;
        this.certserno = null;
        Digest digest = AndroidDigestFactory.getSHA1();
        byte[] resBuf = new byte[digest.getDigestSize()];
        byte[] bytes = spki.getPublicKeyData().getBytes();
        digest.update(bytes, 0, bytes.length);
        digest.doFinal(resBuf, 0);
        this.keyidentifier = new DEROctetString(resBuf);
        this.certissuer = name;
        this.certserno = serialNumber != null ? new ASN1Integer(serialNumber) : null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthorityKeyIdentifier(GeneralNames name, BigInteger serialNumber) {
        this((byte[]) null, name, serialNumber);
    }

    public AuthorityKeyIdentifier(byte[] keyIdentifier) {
        this(keyIdentifier, (GeneralNames) null, (BigInteger) null);
    }

    public AuthorityKeyIdentifier(byte[] keyIdentifier, GeneralNames name, BigInteger serialNumber) {
        this.keyidentifier = null;
        this.certissuer = null;
        this.certserno = null;
        this.keyidentifier = keyIdentifier != null ? new DEROctetString(keyIdentifier) : null;
        this.certissuer = name;
        this.certserno = serialNumber != null ? new ASN1Integer(serialNumber) : null;
    }

    public byte[] getKeyIdentifier() {
        ASN1OctetString aSN1OctetString = this.keyidentifier;
        if (aSN1OctetString != null) {
            return aSN1OctetString.getOctets();
        }
        return null;
    }

    public GeneralNames getAuthorityCertIssuer() {
        return this.certissuer;
    }

    public BigInteger getAuthorityCertSerialNumber() {
        ASN1Integer aSN1Integer = this.certserno;
        if (aSN1Integer != null) {
            return aSN1Integer.getValue();
        }
        return null;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v2 = new ASN1EncodableVector(3);
        ASN1OctetString aSN1OctetString = this.keyidentifier;
        if (aSN1OctetString != null) {
            v2.add(new DERTaggedObject(false, 0, aSN1OctetString));
        }
        GeneralNames generalNames = this.certissuer;
        if (generalNames != null) {
            v2.add(new DERTaggedObject(false, 1, generalNames));
        }
        ASN1Integer aSN1Integer = this.certserno;
        if (aSN1Integer != null) {
            v2.add(new DERTaggedObject(false, 2, aSN1Integer));
        }
        return new DERSequence(v2);
    }

    public String toString() {
        ASN1OctetString aSN1OctetString = this.keyidentifier;
        String keyID = aSN1OctetString != null ? Hex.toHexString(aSN1OctetString.getOctets()) : "null";
        return "AuthorityKeyIdentifier: KeyID(" + keyID + ")";
    }
}
