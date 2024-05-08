package com.android.internal.org.bouncycastle.cms;

import com.alibaba.security.common.utils.DESCoderUtils;
import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1InputStream;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Set;
import com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject;
import com.android.internal.org.bouncycastle.asn1.BEROctetStringGenerator;
import com.android.internal.org.bouncycastle.asn1.BERSet;
import com.android.internal.org.bouncycastle.asn1.DERNull;
import com.android.internal.org.bouncycastle.asn1.DERSet;
import com.android.internal.org.bouncycastle.asn1.DERTaggedObject;
import com.android.internal.org.bouncycastle.asn1.cms.ContentInfo;
import com.android.internal.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.android.internal.org.bouncycastle.cert.X509AttributeCertificateHolder;
import com.android.internal.org.bouncycastle.cert.X509CRLHolder;
import com.android.internal.org.bouncycastle.cert.X509CertificateHolder;
import com.android.internal.org.bouncycastle.operator.DigestCalculator;
import com.android.internal.org.bouncycastle.util.Store;
import com.android.internal.org.bouncycastle.util.Strings;
import com.android.internal.org.bouncycastle.util.io.Streams;
import com.android.internal.org.bouncycastle.util.io.TeeInputStream;
import com.android.internal.org.bouncycastle.util.io.TeeOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class CMSUtils {
    private static final Set<String> des;
    private static final Set ecAlgs;
    private static final Set gostAlgs;
    private static final Set mqvAlgs;

    CMSUtils() {
    }

    static {
        HashSet hashSet = new HashSet();
        des = hashSet;
        mqvAlgs = new HashSet();
        ecAlgs = new HashSet();
        gostAlgs = new HashSet();
        hashSet.add(DESCoderUtils.SECRETFACTORY_ALGORITHM);
        hashSet.add("DESEDE");
    }

    static boolean isMQV(ASN1ObjectIdentifier algorithm) {
        return mqvAlgs.contains(algorithm);
    }

    static boolean isEC(ASN1ObjectIdentifier algorithm) {
        return ecAlgs.contains(algorithm);
    }

    static boolean isGOST(ASN1ObjectIdentifier algorithm) {
        return gostAlgs.contains(algorithm);
    }

    static boolean isDES(String algorithmID) {
        String name = Strings.toUpperCase(algorithmID);
        return des.contains(name);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isEquivalent(AlgorithmIdentifier algId1, AlgorithmIdentifier algId2) {
        if (algId1 == null || algId2 == null || !algId1.getAlgorithm().equals((ASN1Primitive) algId2.getAlgorithm())) {
            return false;
        }
        ASN1Encodable params1 = algId1.getParameters();
        ASN1Encodable params2 = algId2.getParameters();
        if (params1 != null) {
            if (!params1.equals(params2) && (!params1.equals(DERNull.INSTANCE) || params2 != null)) {
                return false;
            }
            return true;
        }
        if (params2 != null && !params2.equals(DERNull.INSTANCE)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ContentInfo readContentInfo(byte[] input) throws CMSException {
        return readContentInfo(new ASN1InputStream(input));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ContentInfo readContentInfo(InputStream input) throws CMSException {
        return readContentInfo(new ASN1InputStream(input));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List getCertificatesFromStore(Store certStore) throws CMSException {
        List certs = new ArrayList();
        try {
            for (X509CertificateHolder c4 : certStore.getMatches(null)) {
                certs.add(c4.toASN1Structure());
            }
            return certs;
        } catch (ClassCastException e2) {
            throw new CMSException("error processing certs", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List getAttributeCertificatesFromStore(Store attrStore) throws CMSException {
        List certs = new ArrayList();
        try {
            for (X509AttributeCertificateHolder attrCert : attrStore.getMatches(null)) {
                certs.add(new DERTaggedObject(false, 2, attrCert.toASN1Structure()));
            }
            return certs;
        } catch (ClassCastException e2) {
            throw new CMSException("error processing certs", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List getCRLsFromStore(Store crlStore) throws CMSException {
        List crls = new ArrayList();
        try {
            for (Object rev : crlStore.getMatches(null)) {
                if (rev instanceof X509CRLHolder) {
                    X509CRLHolder c4 = (X509CRLHolder) rev;
                    crls.add(c4.toASN1Structure());
                } else if (rev instanceof ASN1TaggedObject) {
                    crls.add(rev);
                }
            }
            return crls;
        } catch (ClassCastException e2) {
            throw new CMSException("error processing certs", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ASN1Set createBerSetFromList(List derObjects) {
        ASN1EncodableVector v2 = new ASN1EncodableVector();
        Iterator it = derObjects.iterator2();
        while (it.hasNext()) {
            v2.add((ASN1Encodable) it.next());
        }
        return new BERSet(v2);
    }

    static ASN1Set createDerSetFromList(List derObjects) {
        ASN1EncodableVector v2 = new ASN1EncodableVector();
        Iterator it = derObjects.iterator2();
        while (it.hasNext()) {
            v2.add((ASN1Encodable) it.next());
        }
        return new DERSet(v2);
    }

    static OutputStream createBEROctetOutputStream(OutputStream s2, int tagNo, boolean isExplicit, int bufferSize) throws IOException {
        BEROctetStringGenerator octGen = new BEROctetStringGenerator(s2, tagNo, isExplicit);
        if (bufferSize != 0) {
            return octGen.getOctetOutputStream(new byte[bufferSize]);
        }
        return octGen.getOctetOutputStream();
    }

    private static ContentInfo readContentInfo(ASN1InputStream in) throws CMSException {
        try {
            ContentInfo info = ContentInfo.getInstance(in.readObject());
            if (info == null) {
                throw new CMSException("No content found.");
            }
            return info;
        } catch (IOException e2) {
            throw new CMSException("IOException reading content.", e2);
        } catch (ClassCastException e10) {
            throw new CMSException("Malformed content.", e10);
        } catch (IllegalArgumentException e11) {
            throw new CMSException("Malformed content.", e11);
        }
    }

    public static byte[] streamToByteArray(InputStream in) throws IOException {
        return Streams.readAll(in);
    }

    public static byte[] streamToByteArray(InputStream in, int limit) throws IOException {
        return Streams.readAllLimited(in, limit);
    }

    static InputStream attachDigestsToInputStream(Collection digests, InputStream s2) {
        InputStream result = s2;
        Iterator it = digests.iterator2();
        while (it.hasNext()) {
            DigestCalculator digest = (DigestCalculator) it.next();
            result = new TeeInputStream(result, digest.getOutputStream());
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OutputStream attachSignersToOutputStream(Collection signers, OutputStream s2) {
        OutputStream result = s2;
        Iterator it = signers.iterator2();
        while (it.hasNext()) {
            SignerInfoGenerator signerGen = (SignerInfoGenerator) it.next();
            result = getSafeTeeOutputStream(result, signerGen.getCalculatingOutputStream());
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OutputStream getSafeOutputStream(OutputStream s2) {
        return s2 == null ? new NullOutputStream() : s2;
    }

    static OutputStream getSafeTeeOutputStream(OutputStream s12, OutputStream s2) {
        return s12 == null ? getSafeOutputStream(s2) : s2 == null ? getSafeOutputStream(s12) : new TeeOutputStream(s12, s2);
    }
}
