package com.android.internal.org.bouncycastle.cert;

import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1Encoding;
import com.android.internal.org.bouncycastle.asn1.ASN1GeneralizedTime;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.DERBitString;
import com.android.internal.org.bouncycastle.asn1.DERNull;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import com.android.internal.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.android.internal.org.bouncycastle.asn1.x509.AttributeCertificate;
import com.android.internal.org.bouncycastle.asn1.x509.AttributeCertificateInfo;
import com.android.internal.org.bouncycastle.asn1.x509.Certificate;
import com.android.internal.org.bouncycastle.asn1.x509.CertificateList;
import com.android.internal.org.bouncycastle.asn1.x509.Extension;
import com.android.internal.org.bouncycastle.asn1.x509.Extensions;
import com.android.internal.org.bouncycastle.asn1.x509.ExtensionsGenerator;
import com.android.internal.org.bouncycastle.asn1.x509.TBSCertList;
import com.android.internal.org.bouncycastle.asn1.x509.TBSCertificate;
import com.android.internal.org.bouncycastle.operator.ContentSigner;
import com.android.internal.org.bouncycastle.util.Properties;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class CertUtils {
    private static Set EMPTY_SET = Collections.unmodifiableSet(new HashSet());
    private static List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());

    CertUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ASN1Primitive parseNonEmptyASN1(byte[] encoding) throws IOException {
        ASN1Primitive p10 = ASN1Primitive.fromByteArray(encoding);
        if (p10 == null) {
            throw new IOException("no content found");
        }
        return p10;
    }

    static X509CertificateHolder generateFullCert(ContentSigner signer, TBSCertificate tbsCert) {
        try {
            return new X509CertificateHolder(generateStructure(tbsCert, signer.getAlgorithmIdentifier(), generateSig(signer, tbsCert)));
        } catch (IOException e2) {
            throw new IllegalStateException("cannot produce certificate signature");
        }
    }

    static X509AttributeCertificateHolder generateFullAttrCert(ContentSigner signer, AttributeCertificateInfo attrInfo) {
        try {
            return new X509AttributeCertificateHolder(generateAttrStructure(attrInfo, signer.getAlgorithmIdentifier(), generateSig(signer, attrInfo)));
        } catch (IOException e2) {
            throw new IllegalStateException("cannot produce attribute certificate signature");
        }
    }

    static X509CRLHolder generateFullCRL(ContentSigner signer, TBSCertList tbsCertList) {
        try {
            return new X509CRLHolder(generateCRLStructure(tbsCertList, signer.getAlgorithmIdentifier(), generateSig(signer, tbsCertList)));
        } catch (IOException e2) {
            throw new IllegalStateException("cannot produce certificate signature");
        }
    }

    private static byte[] generateSig(ContentSigner signer, ASN1Object tbsObj) throws IOException {
        OutputStream sOut = signer.getOutputStream();
        tbsObj.encodeTo(sOut, ASN1Encoding.DER);
        sOut.close();
        return signer.getSignature();
    }

    private static Certificate generateStructure(TBSCertificate tbsCert, AlgorithmIdentifier sigAlgId, byte[] signature) {
        ASN1EncodableVector v2 = new ASN1EncodableVector();
        v2.add(tbsCert);
        v2.add(sigAlgId);
        v2.add(new DERBitString(signature));
        return Certificate.getInstance(new DERSequence(v2));
    }

    private static AttributeCertificate generateAttrStructure(AttributeCertificateInfo attrInfo, AlgorithmIdentifier sigAlgId, byte[] signature) {
        ASN1EncodableVector v2 = new ASN1EncodableVector();
        v2.add(attrInfo);
        v2.add(sigAlgId);
        v2.add(new DERBitString(signature));
        return AttributeCertificate.getInstance(new DERSequence(v2));
    }

    private static CertificateList generateCRLStructure(TBSCertList tbsCertList, AlgorithmIdentifier sigAlgId, byte[] signature) {
        ASN1EncodableVector v2 = new ASN1EncodableVector();
        v2.add(tbsCertList);
        v2.add(sigAlgId);
        v2.add(new DERBitString(signature));
        return CertificateList.getInstance(new DERSequence(v2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set getCriticalExtensionOIDs(Extensions extensions) {
        if (extensions == null) {
            return EMPTY_SET;
        }
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(extensions.getCriticalExtensionOIDs())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set getNonCriticalExtensionOIDs(Extensions extensions) {
        if (extensions == null) {
            return EMPTY_SET;
        }
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(extensions.getNonCriticalExtensionOIDs())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List getExtensionOIDs(Extensions extensions) {
        if (extensions == null) {
            return EMPTY_LIST;
        }
        return Collections.unmodifiableList(Arrays.asList(extensions.getExtensionOIDs()));
    }

    static void addExtension(ExtensionsGenerator extGenerator, ASN1ObjectIdentifier oid, boolean isCritical, ASN1Encodable value) throws CertIOException {
        try {
            extGenerator.addExtension(oid, isCritical, value);
        } catch (IOException e2) {
            throw new CertIOException("cannot encode extension: " + e2.getMessage(), e2);
        }
    }

    static DERBitString booleanToBitString(boolean[] id2) {
        byte[] bytes = new byte[(id2.length + 7) / 8];
        for (int i10 = 0; i10 != id2.length; i10++) {
            int i11 = i10 / 8;
            bytes[i11] = (byte) (bytes[i11] | (id2[i10] ? 1 << (7 - (i10 % 8)) : 0));
        }
        int i12 = id2.length;
        int pad = i12 % 8;
        if (pad == 0) {
            return new DERBitString(bytes);
        }
        return new DERBitString(bytes, 8 - pad);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean[] bitStringToBoolean(DERBitString bitString) {
        if (bitString != null) {
            byte[] bytes = bitString.getBytes();
            boolean[] boolId = new boolean[(bytes.length * 8) - bitString.getPadBits()];
            for (int i10 = 0; i10 != boolId.length; i10++) {
                boolId[i10] = (bytes[i10 / 8] & (128 >>> (i10 % 8))) != 0;
            }
            return boolId;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Date recoverDate(ASN1GeneralizedTime time) {
        try {
            return time.getDate();
        } catch (ParseException e2) {
            throw new IllegalStateException("unable to recover date: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAlgIdEqual(AlgorithmIdentifier id1, AlgorithmIdentifier id2) {
        if (!id1.getAlgorithm().equals((ASN1Primitive) id2.getAlgorithm())) {
            return false;
        }
        if (Properties.isOverrideSet("com.android.internal.org.bouncycastle.x509.allow_absent_equiv_NULL")) {
            if (id1.getParameters() == null) {
                return id2.getParameters() == null || id2.getParameters().equals(DERNull.INSTANCE);
            }
            if (id2.getParameters() == null) {
                return id1.getParameters() == null || id1.getParameters().equals(DERNull.INSTANCE);
            }
        }
        if (id1.getParameters() != null) {
            return id1.getParameters().equals(id2.getParameters());
        }
        if (id2.getParameters() != null) {
            return id2.getParameters().equals(id1.getParameters());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExtensionsGenerator doReplaceExtension(ExtensionsGenerator extGenerator, Extension ext) {
        boolean isReplaced = false;
        Extensions exts = extGenerator.generate();
        ExtensionsGenerator extGenerator2 = new ExtensionsGenerator();
        Enumeration en = exts.oids();
        while (en.hasMoreElements()) {
            ASN1ObjectIdentifier extOid = (ASN1ObjectIdentifier) en.nextElement();
            if (extOid.equals((ASN1Primitive) ext.getExtnId())) {
                isReplaced = true;
                extGenerator2.addExtension(ext);
            } else {
                extGenerator2.addExtension(exts.getExtension(extOid));
            }
        }
        if (isReplaced) {
            return extGenerator2;
        }
        throw new IllegalArgumentException("replace - original extension (OID = " + ((Object) ext.getExtnId()) + ") not found");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExtensionsGenerator doRemoveExtension(ExtensionsGenerator extGenerator, ASN1ObjectIdentifier oid) {
        boolean isRemoved = false;
        Extensions exts = extGenerator.generate();
        ExtensionsGenerator extGenerator2 = new ExtensionsGenerator();
        Enumeration en = exts.oids();
        while (en.hasMoreElements()) {
            ASN1ObjectIdentifier extOid = (ASN1ObjectIdentifier) en.nextElement();
            if (extOid.equals((ASN1Primitive) oid)) {
                isRemoved = true;
            } else {
                extGenerator2.addExtension(exts.getExtension(extOid));
            }
        }
        if (isRemoved) {
            return extGenerator2;
        }
        throw new IllegalArgumentException("remove - extension (OID = " + ((Object) oid) + ") not found");
    }
}
