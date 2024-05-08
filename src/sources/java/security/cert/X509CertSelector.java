package java.security.cert;

import java.io.IOException;
import java.math.BigInteger;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
import sun.security.util.Debug;
import sun.security.util.DerInputStream;
import sun.security.util.DerValue;
import sun.security.util.HexDumpEncoder;
import sun.security.util.ObjectIdentifier;
import sun.security.x509.AlgorithmId;
import sun.security.x509.CertificatePoliciesExtension;
import sun.security.x509.CertificatePolicyId;
import sun.security.x509.CertificatePolicySet;
import sun.security.x509.DNSName;
import sun.security.x509.EDIPartyName;
import sun.security.x509.ExtendedKeyUsageExtension;
import sun.security.x509.GeneralName;
import sun.security.x509.GeneralNameInterface;
import sun.security.x509.GeneralNames;
import sun.security.x509.GeneralSubtree;
import sun.security.x509.GeneralSubtrees;
import sun.security.x509.IPAddressName;
import sun.security.x509.NameConstraintsExtension;
import sun.security.x509.OIDName;
import sun.security.x509.OtherName;
import sun.security.x509.PolicyInformation;
import sun.security.x509.PrivateKeyUsageExtension;
import sun.security.x509.RFC822Name;
import sun.security.x509.SubjectAlternativeNameExtension;
import sun.security.x509.URIName;
import sun.security.x509.X400Address;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509Key;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class X509CertSelector implements CertSelector {
    private static final int CERT_POLICIES_ID = 3;
    private static final int EXTENDED_KEY_USAGE_ID = 4;
    private static final String[] EXTENSION_OIDS;
    private static final Boolean FALSE;
    static final int NAME_ANY = 0;
    private static final int NAME_CONSTRAINTS_ID = 2;
    static final int NAME_DIRECTORY = 4;
    static final int NAME_DNS = 2;
    static final int NAME_EDI = 5;
    static final int NAME_IP = 7;
    static final int NAME_OID = 8;
    static final int NAME_RFC822 = 1;
    static final int NAME_URI = 6;
    static final int NAME_X400 = 3;
    private static final int NUM_OF_EXTENSIONS = 5;
    private static final int PRIVATE_KEY_USAGE_ID = 0;
    private static final int SUBJECT_ALT_NAME_ID = 1;
    private byte[] authorityKeyID;
    private Date certificateValid;
    private X500Principal issuer;
    private Set<ObjectIdentifier> keyPurposeOIDSet;
    private Set<String> keyPurposeSet;
    private boolean[] keyUsage;

    /* renamed from: nc, reason: collision with root package name */
    private NameConstraintsExtension f50393nc;
    private byte[] ncBytes;
    private Set<GeneralNameInterface> pathToGeneralNames;
    private Set<List<?>> pathToNames;
    private CertificatePolicySet policy;
    private Set<String> policySet;
    private Date privateKeyValid;
    private BigInteger serialNumber;
    private X500Principal subject;
    private Set<GeneralNameInterface> subjectAlternativeGeneralNames;
    private Set<List<?>> subjectAlternativeNames;
    private byte[] subjectKeyID;
    private PublicKey subjectPublicKey;
    private ObjectIdentifier subjectPublicKeyAlgID;
    private byte[] subjectPublicKeyBytes;
    private X509Certificate x509Cert;
    private static final Debug debug = Debug.getInstance("certpath");
    private static final ObjectIdentifier ANY_EXTENDED_KEY_USAGE = ObjectIdentifier.newInternal(new int[]{2, 5, 29, 37, 0});
    private int basicConstraints = -1;
    private boolean matchAllSubjectAltNames = true;

    static {
        CertPathHelperImpl.initialize();
        FALSE = Boolean.FALSE;
        EXTENSION_OIDS = r1;
        String[] strArr = {"2.5.29.16", "2.5.29.17", "2.5.29.30", "2.5.29.32", "2.5.29.37"};
    }

    public void setCertificate(X509Certificate cert) {
        this.x509Cert = cert;
    }

    public void setSerialNumber(BigInteger serial) {
        this.serialNumber = serial;
    }

    public void setIssuer(X500Principal issuer) {
        this.issuer = issuer;
    }

    public void setIssuer(String issuerDN) throws IOException {
        if (issuerDN == null) {
            this.issuer = null;
        } else {
            this.issuer = new X500Name(issuerDN).asX500Principal();
        }
    }

    public void setIssuer(byte[] issuerDN) throws IOException {
        X500Principal x500Principal;
        if (issuerDN == null) {
            x500Principal = null;
        } else {
            try {
                x500Principal = new X500Principal(issuerDN);
            } catch (IllegalArgumentException e2) {
                throw new IOException("Invalid name", e2);
            }
        }
        this.issuer = x500Principal;
    }

    public void setSubject(X500Principal subject) {
        this.subject = subject;
    }

    public void setSubject(String subjectDN) throws IOException {
        if (subjectDN == null) {
            this.subject = null;
        } else {
            this.subject = new X500Name(subjectDN).asX500Principal();
        }
    }

    public void setSubject(byte[] subjectDN) throws IOException {
        X500Principal x500Principal;
        if (subjectDN == null) {
            x500Principal = null;
        } else {
            try {
                x500Principal = new X500Principal(subjectDN);
            } catch (IllegalArgumentException e2) {
                throw new IOException("Invalid name", e2);
            }
        }
        this.subject = x500Principal;
    }

    public void setSubjectKeyIdentifier(byte[] subjectKeyID) {
        if (subjectKeyID == null) {
            this.subjectKeyID = null;
        } else {
            this.subjectKeyID = (byte[]) subjectKeyID.clone();
        }
    }

    public void setAuthorityKeyIdentifier(byte[] authorityKeyID) {
        if (authorityKeyID == null) {
            this.authorityKeyID = null;
        } else {
            this.authorityKeyID = (byte[]) authorityKeyID.clone();
        }
    }

    public void setCertificateValid(Date certValid) {
        if (certValid == null) {
            this.certificateValid = null;
        } else {
            this.certificateValid = (Date) certValid.clone();
        }
    }

    public void setPrivateKeyValid(Date privateKeyValid) {
        if (privateKeyValid == null) {
            this.privateKeyValid = null;
        } else {
            this.privateKeyValid = (Date) privateKeyValid.clone();
        }
    }

    public void setSubjectPublicKeyAlgID(String oid) throws IOException {
        if (oid == null) {
            this.subjectPublicKeyAlgID = null;
        } else {
            this.subjectPublicKeyAlgID = new ObjectIdentifier(oid);
        }
    }

    public void setSubjectPublicKey(PublicKey key) {
        if (key == null) {
            this.subjectPublicKey = null;
            this.subjectPublicKeyBytes = null;
        } else {
            this.subjectPublicKey = key;
            this.subjectPublicKeyBytes = key.getEncoded();
        }
    }

    public void setSubjectPublicKey(byte[] key) throws IOException {
        if (key == null) {
            this.subjectPublicKey = null;
            this.subjectPublicKeyBytes = null;
        } else {
            byte[] bArr = (byte[]) key.clone();
            this.subjectPublicKeyBytes = bArr;
            this.subjectPublicKey = X509Key.parse(new DerValue(bArr));
        }
    }

    public void setKeyUsage(boolean[] keyUsage) {
        if (keyUsage == null) {
            this.keyUsage = null;
        } else {
            this.keyUsage = (boolean[]) keyUsage.clone();
        }
    }

    public void setExtendedKeyUsage(Set<String> keyPurposeSet) throws IOException {
        if (keyPurposeSet == null || keyPurposeSet.isEmpty()) {
            this.keyPurposeSet = null;
            this.keyPurposeOIDSet = null;
            return;
        }
        this.keyPurposeSet = Collections.unmodifiableSet(new HashSet(keyPurposeSet));
        this.keyPurposeOIDSet = new HashSet();
        for (String s2 : this.keyPurposeSet) {
            this.keyPurposeOIDSet.add(new ObjectIdentifier(s2));
        }
    }

    public void setMatchAllSubjectAltNames(boolean matchAllNames) {
        this.matchAllSubjectAltNames = matchAllNames;
    }

    public void setSubjectAlternativeNames(Collection<List<?>> names) throws IOException {
        if (names == null) {
            this.subjectAlternativeNames = null;
            this.subjectAlternativeGeneralNames = null;
        } else if (names.isEmpty()) {
            this.subjectAlternativeNames = null;
            this.subjectAlternativeGeneralNames = null;
        } else {
            Set<List<?>> tempNames = cloneAndCheckNames(names);
            this.subjectAlternativeGeneralNames = parseNames(tempNames);
            this.subjectAlternativeNames = tempNames;
        }
    }

    public void addSubjectAlternativeName(int type, String name) throws IOException {
        addSubjectAlternativeNameInternal(type, name);
    }

    public void addSubjectAlternativeName(int type, byte[] name) throws IOException {
        addSubjectAlternativeNameInternal(type, name.clone());
    }

    private void addSubjectAlternativeNameInternal(int type, Object name) throws IOException {
        GeneralNameInterface tempName = makeGeneralNameInterface(type, name);
        if (this.subjectAlternativeNames == null) {
            this.subjectAlternativeNames = new HashSet();
        }
        if (this.subjectAlternativeGeneralNames == null) {
            this.subjectAlternativeGeneralNames = new HashSet();
        }
        List<Object> list = new ArrayList<>(2);
        list.add(Integer.valueOf(type));
        list.add(name);
        this.subjectAlternativeNames.add(list);
        this.subjectAlternativeGeneralNames.add(tempName);
    }

    private static Set<GeneralNameInterface> parseNames(Collection<List<?>> names) throws IOException {
        Set<GeneralNameInterface> genNames = new HashSet<>();
        for (List<?> nameList : names) {
            if (nameList.size() != 2) {
                throw new IOException("name list size not 2");
            }
            Object o10 = nameList.get(0);
            if (!(o10 instanceof Integer)) {
                throw new IOException("expected an Integer");
            }
            int nameType = ((Integer) o10).intValue();
            genNames.add(makeGeneralNameInterface(nameType, nameList.get(1)));
        }
        return genNames;
    }

    static boolean equalNames(Collection<?> object1, Collection<?> object2) {
        if (object1 == null || object2 == null) {
            return object1 == object2;
        }
        return object1.equals(object2);
    }

    static GeneralNameInterface makeGeneralNameInterface(int type, Object name) throws IOException {
        GeneralNameInterface result;
        GeneralNameInterface result2;
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("X509CertSelector.makeGeneralNameInterface(" + type + ")...");
        }
        if (name instanceof String) {
            if (debug2 != null) {
                debug2.println("X509CertSelector.makeGeneralNameInterface() name is String: " + name);
            }
            switch (type) {
                case 1:
                    result2 = new RFC822Name((String) name);
                    break;
                case 2:
                    result2 = new DNSName((String) name);
                    break;
                case 3:
                case 5:
                default:
                    throw new IOException("unable to parse String names of type " + type);
                case 4:
                    result2 = new X500Name((String) name);
                    break;
                case 6:
                    result2 = new URIName((String) name);
                    break;
                case 7:
                    result2 = new IPAddressName((String) name);
                    break;
                case 8:
                    result2 = new OIDName((String) name);
                    break;
            }
            if (debug2 != null) {
                debug2.println("X509CertSelector.makeGeneralNameInterface() result: " + result2.toString());
                return result2;
            }
            return result2;
        }
        if (name instanceof byte[]) {
            DerValue val = new DerValue((byte[]) name);
            if (debug2 != null) {
                debug2.println("X509CertSelector.makeGeneralNameInterface() is byte[]");
            }
            switch (type) {
                case 0:
                    result = new OtherName(val);
                    break;
                case 1:
                    result = new RFC822Name(val);
                    break;
                case 2:
                    result = new DNSName(val);
                    break;
                case 3:
                    result = new X400Address(val);
                    break;
                case 4:
                    result = new X500Name(val);
                    break;
                case 5:
                    result = new EDIPartyName(val);
                    break;
                case 6:
                    result = new URIName(val);
                    break;
                case 7:
                    result = new IPAddressName(val);
                    break;
                case 8:
                    result = new OIDName(val);
                    break;
                default:
                    throw new IOException("unable to parse byte array names of type " + type);
            }
            if (debug2 != null) {
                debug2.println("X509CertSelector.makeGeneralNameInterface() result: " + result.toString());
            }
            return result;
        }
        if (debug2 != null) {
            debug2.println("X509CertSelector.makeGeneralName() input name not String or byte array");
        }
        throw new IOException("name not String or byte array");
    }

    public void setNameConstraints(byte[] bytes) throws IOException {
        if (bytes == null) {
            this.ncBytes = null;
            this.f50393nc = null;
        } else {
            this.ncBytes = (byte[]) bytes.clone();
            this.f50393nc = new NameConstraintsExtension(FALSE, bytes);
        }
    }

    public void setBasicConstraints(int minMaxPathLen) {
        if (minMaxPathLen < -2) {
            throw new IllegalArgumentException("basic constraints less than -2");
        }
        this.basicConstraints = minMaxPathLen;
    }

    public void setPolicy(Set<String> certPolicySet) throws IOException {
        if (certPolicySet == null) {
            this.policySet = null;
            this.policy = null;
            return;
        }
        Set<String> tempSet = Collections.unmodifiableSet(new HashSet(certPolicySet));
        Vector<CertificatePolicyId> polIdVector = new Vector<>();
        for (Object o10 : tempSet) {
            if (!(o10 instanceof String)) {
                throw new IOException("non String in certPolicySet");
            }
            polIdVector.add(new CertificatePolicyId(new ObjectIdentifier((String) o10)));
        }
        this.policySet = tempSet;
        this.policy = new CertificatePolicySet(polIdVector);
    }

    public void setPathToNames(Collection<List<?>> names) throws IOException {
        if (names == null || names.isEmpty()) {
            this.pathToNames = null;
            this.pathToGeneralNames = null;
        } else {
            Set<List<?>> tempNames = cloneAndCheckNames(names);
            this.pathToGeneralNames = parseNames(tempNames);
            this.pathToNames = tempNames;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPathToNamesInternal(Set<GeneralNameInterface> names) {
        this.pathToNames = Collections.emptySet();
        this.pathToGeneralNames = names;
    }

    public void addPathToName(int type, String name) throws IOException {
        addPathToNameInternal(type, name);
    }

    public void addPathToName(int type, byte[] name) throws IOException {
        addPathToNameInternal(type, name.clone());
    }

    private void addPathToNameInternal(int type, Object name) throws IOException {
        GeneralNameInterface tempName = makeGeneralNameInterface(type, name);
        if (this.pathToGeneralNames == null) {
            this.pathToNames = new HashSet();
            this.pathToGeneralNames = new HashSet();
        }
        List<Object> list = new ArrayList<>(2);
        list.add(Integer.valueOf(type));
        list.add(name);
        this.pathToNames.add(list);
        this.pathToGeneralNames.add(tempName);
    }

    public X509Certificate getCertificate() {
        return this.x509Cert;
    }

    public BigInteger getSerialNumber() {
        return this.serialNumber;
    }

    public X500Principal getIssuer() {
        return this.issuer;
    }

    public String getIssuerAsString() {
        X500Principal x500Principal = this.issuer;
        if (x500Principal == null) {
            return null;
        }
        return x500Principal.getName();
    }

    public byte[] getIssuerAsBytes() throws IOException {
        X500Principal x500Principal = this.issuer;
        if (x500Principal == null) {
            return null;
        }
        return x500Principal.getEncoded();
    }

    public X500Principal getSubject() {
        return this.subject;
    }

    public String getSubjectAsString() {
        X500Principal x500Principal = this.subject;
        if (x500Principal == null) {
            return null;
        }
        return x500Principal.getName();
    }

    public byte[] getSubjectAsBytes() throws IOException {
        X500Principal x500Principal = this.subject;
        if (x500Principal == null) {
            return null;
        }
        return x500Principal.getEncoded();
    }

    public byte[] getSubjectKeyIdentifier() {
        byte[] bArr = this.subjectKeyID;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public byte[] getAuthorityKeyIdentifier() {
        byte[] bArr = this.authorityKeyID;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public Date getCertificateValid() {
        Date date = this.certificateValid;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public Date getPrivateKeyValid() {
        Date date = this.privateKeyValid;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public String getSubjectPublicKeyAlgID() {
        ObjectIdentifier objectIdentifier = this.subjectPublicKeyAlgID;
        if (objectIdentifier == null) {
            return null;
        }
        return objectIdentifier.toString();
    }

    public PublicKey getSubjectPublicKey() {
        return this.subjectPublicKey;
    }

    public boolean[] getKeyUsage() {
        boolean[] zArr = this.keyUsage;
        if (zArr == null) {
            return null;
        }
        return (boolean[]) zArr.clone();
    }

    public Set<String> getExtendedKeyUsage() {
        return this.keyPurposeSet;
    }

    public boolean getMatchAllSubjectAltNames() {
        return this.matchAllSubjectAltNames;
    }

    public Collection<List<?>> getSubjectAlternativeNames() {
        Set<List<?>> set = this.subjectAlternativeNames;
        if (set == null) {
            return null;
        }
        return cloneNames(set);
    }

    private static Set<List<?>> cloneNames(Collection<List<?>> names) {
        try {
            return cloneAndCheckNames(names);
        } catch (IOException e2) {
            throw new RuntimeException("cloneNames encountered IOException: " + e2.getMessage());
        }
    }

    private static Set<List<?>> cloneAndCheckNames(Collection<List<?>> names) throws IOException {
        Set<List<?>> namesCopy = new HashSet<>();
        Iterator<List<?>> iterator2 = names.iterator2();
        while (iterator2.hasNext()) {
            namesCopy.add(new ArrayList<>(iterator2.next()));
        }
        for (List<?> list : namesCopy) {
            if (list.size() == 2) {
                Object o10 = list.get(0);
                if (!(o10 instanceof Integer)) {
                    throw new IOException("expected an Integer");
                }
                int nameType = ((Integer) o10).intValue();
                if (nameType >= 0 && nameType <= 8) {
                    Object nameObject = list.get(1);
                    if (!(nameObject instanceof byte[]) && !(nameObject instanceof String)) {
                        Debug debug2 = debug;
                        if (debug2 != null) {
                            debug2.println("X509CertSelector.cloneAndCheckNames() name not byte array");
                        }
                        throw new IOException("name not byte array or String");
                    }
                    if (nameObject instanceof byte[]) {
                        list.set(1, ((byte[]) nameObject).clone());
                    }
                } else {
                    throw new IOException("name type not 0-8");
                }
            } else {
                throw new IOException("name list size not 2");
            }
        }
        return namesCopy;
    }

    public byte[] getNameConstraints() {
        byte[] bArr = this.ncBytes;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public int getBasicConstraints() {
        return this.basicConstraints;
    }

    public Set<String> getPolicy() {
        return this.policySet;
    }

    public Collection<List<?>> getPathToNames() {
        Set<List<?>> set = this.pathToNames;
        if (set == null) {
            return null;
        }
        return cloneNames(set);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("X509CertSelector: [\n");
        if (this.x509Cert != null) {
            sb2.append("  Certificate: " + this.x509Cert.toString() + "\n");
        }
        if (this.serialNumber != null) {
            sb2.append("  Serial Number: " + this.serialNumber.toString() + "\n");
        }
        if (this.issuer != null) {
            sb2.append("  Issuer: " + getIssuerAsString() + "\n");
        }
        if (this.subject != null) {
            sb2.append("  Subject: " + getSubjectAsString() + "\n");
        }
        sb2.append("  matchAllSubjectAltNames flag: " + String.valueOf(this.matchAllSubjectAltNames) + "\n");
        if (this.subjectAlternativeNames != null) {
            sb2.append("  SubjectAlternativeNames:\n");
            for (List<?> list : this.subjectAlternativeNames) {
                sb2.append("    type " + list.get(0) + ", name " + list.get(1) + "\n");
            }
        }
        if (this.subjectKeyID != null) {
            HexDumpEncoder enc = new HexDumpEncoder();
            sb2.append("  Subject Key Identifier: " + enc.encodeBuffer(this.subjectKeyID) + "\n");
        }
        if (this.authorityKeyID != null) {
            HexDumpEncoder enc2 = new HexDumpEncoder();
            sb2.append("  Authority Key Identifier: " + enc2.encodeBuffer(this.authorityKeyID) + "\n");
        }
        if (this.certificateValid != null) {
            sb2.append("  Certificate Valid: " + this.certificateValid.toString() + "\n");
        }
        if (this.privateKeyValid != null) {
            sb2.append("  Private Key Valid: " + this.privateKeyValid.toString() + "\n");
        }
        if (this.subjectPublicKeyAlgID != null) {
            sb2.append("  Subject Public Key AlgID: " + this.subjectPublicKeyAlgID.toString() + "\n");
        }
        if (this.subjectPublicKey != null) {
            sb2.append("  Subject Public Key: " + this.subjectPublicKey.toString() + "\n");
        }
        if (this.keyUsage != null) {
            sb2.append("  Key Usage: " + keyUsageToString(this.keyUsage) + "\n");
        }
        if (this.keyPurposeSet != null) {
            sb2.append("  Extended Key Usage: " + this.keyPurposeSet.toString() + "\n");
        }
        if (this.policy != null) {
            sb2.append("  Policy: " + this.policy.toString() + "\n");
        }
        if (this.pathToGeneralNames != null) {
            sb2.append("  Path to names:\n");
            Iterator<GeneralNameInterface> i10 = this.pathToGeneralNames.iterator2();
            while (i10.hasNext()) {
                sb2.append("    " + ((Object) i10.next()) + "\n");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    private static String keyUsageToString(boolean[] k10) {
        String s2;
        s2 = "KeyUsage [\n";
        try {
            s2 = k10[0] ? "KeyUsage [\n  DigitalSignature\n" : "KeyUsage [\n";
            if (k10[1]) {
                s2 = s2 + "  Non_repudiation\n";
            }
            if (k10[2]) {
                s2 = s2 + "  Key_Encipherment\n";
            }
            if (k10[3]) {
                s2 = s2 + "  Data_Encipherment\n";
            }
            if (k10[4]) {
                s2 = s2 + "  Key_Agreement\n";
            }
            if (k10[5]) {
                s2 = s2 + "  Key_CertSign\n";
            }
            if (k10[6]) {
                s2 = s2 + "  Crl_Sign\n";
            }
            if (k10[7]) {
                s2 = s2 + "  Encipher_Only\n";
            }
            if (k10[8]) {
                s2 = s2 + "  Decipher_Only\n";
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
        }
        return s2 + "]\n";
    }

    private static Extension getExtensionObject(X509Certificate cert, int extId) throws IOException {
        if (cert instanceof X509CertImpl) {
            X509CertImpl impl = (X509CertImpl) cert;
            switch (extId) {
                case 0:
                    return impl.getPrivateKeyUsageExtension();
                case 1:
                    return impl.getSubjectAlternativeNameExtension();
                case 2:
                    return impl.getNameConstraintsExtension();
                case 3:
                    return impl.getCertificatePoliciesExtension();
                case 4:
                    return impl.getExtendedKeyUsageExtension();
                default:
                    return null;
            }
        }
        byte[] rawExtVal = cert.getExtensionValue(EXTENSION_OIDS[extId]);
        if (rawExtVal == null) {
            return null;
        }
        DerInputStream in = new DerInputStream(rawExtVal);
        byte[] encoded = in.getOctetString();
        switch (extId) {
            case 0:
                try {
                    return new PrivateKeyUsageExtension(FALSE, encoded);
                } catch (CertificateException ex) {
                    throw new IOException(ex.getMessage());
                }
            case 1:
                return new SubjectAlternativeNameExtension(FALSE, encoded);
            case 2:
                return new NameConstraintsExtension(FALSE, encoded);
            case 3:
                return new CertificatePoliciesExtension(FALSE, encoded);
            case 4:
                return new ExtendedKeyUsageExtension(FALSE, encoded);
            default:
                return null;
        }
    }

    @Override // java.security.cert.CertSelector
    public boolean match(Certificate cert) {
        boolean result = false;
        if (!(cert instanceof X509Certificate)) {
            return false;
        }
        X509Certificate xcert = (X509Certificate) cert;
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("X509CertSelector.match(SN: " + xcert.getSerialNumber().toString(16) + "\n  Issuer: " + ((Object) xcert.getIssuerDN()) + "\n  Subject: " + ((Object) xcert.getSubjectDN()) + ")");
        }
        X509Certificate x509Certificate = this.x509Cert;
        if (x509Certificate != null && !x509Certificate.equals(xcert)) {
            if (debug2 != null) {
                debug2.println("X509CertSelector.match: certs don't match");
            }
            return false;
        }
        BigInteger bigInteger = this.serialNumber;
        if (bigInteger != null && !bigInteger.equals(xcert.getSerialNumber())) {
            if (debug2 != null) {
                debug2.println("X509CertSelector.match: serial numbers don't match");
            }
            return false;
        }
        X500Principal x500Principal = this.issuer;
        if (x500Principal != null && !x500Principal.equals(xcert.getIssuerX500Principal())) {
            if (debug2 != null) {
                debug2.println("X509CertSelector.match: issuer DNs don't match");
            }
            return false;
        }
        X500Principal x500Principal2 = this.subject;
        if (x500Principal2 != null && !x500Principal2.equals(xcert.getSubjectX500Principal())) {
            if (debug2 != null) {
                debug2.println("X509CertSelector.match: subject DNs don't match");
            }
            return false;
        }
        Date date = this.certificateValid;
        if (date != null) {
            try {
                xcert.checkValidity(date);
            } catch (CertificateException e2) {
                Debug debug3 = debug;
                if (debug3 != null) {
                    debug3.println("X509CertSelector.match: certificate not within validity period");
                }
                return false;
            }
        }
        if (this.subjectPublicKeyBytes != null) {
            byte[] certKey = xcert.getPublicKey().getEncoded();
            if (!Arrays.equals(this.subjectPublicKeyBytes, certKey)) {
                if (debug2 != null) {
                    debug2.println("X509CertSelector.match: subject public keys don't match");
                }
                return false;
            }
        }
        if (matchBasicConstraints(xcert) && matchKeyUsage(xcert) && matchExtendedKeyUsage(xcert) && matchSubjectKeyID(xcert) && matchAuthorityKeyID(xcert) && matchPrivateKeyValid(xcert) && matchSubjectPublicKeyAlgID(xcert) && matchPolicy(xcert) && matchSubjectAlternativeNames(xcert) && matchPathToNames(xcert) && matchNameConstraints(xcert)) {
            result = true;
        }
        if (result && debug2 != null) {
            debug2.println("X509CertSelector.match returning: true");
        }
        return result;
    }

    private boolean matchSubjectKeyID(X509Certificate xcert) {
        if (this.subjectKeyID == null) {
            return true;
        }
        try {
            byte[] extVal = xcert.getExtensionValue("2.5.29.14");
            if (extVal == null) {
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("X509CertSelector.match: no subject key ID extension");
                }
                return false;
            }
            DerInputStream in = new DerInputStream(extVal);
            byte[] certSubjectKeyID = in.getOctetString();
            if (certSubjectKeyID != null && Arrays.equals(this.subjectKeyID, certSubjectKeyID)) {
                return true;
            }
            Debug debug3 = debug;
            if (debug3 != null) {
                debug3.println("X509CertSelector.match: subject key IDs don't match");
            }
            return false;
        } catch (IOException e2) {
            Debug debug4 = debug;
            if (debug4 != null) {
                debug4.println("X509CertSelector.match: exception in subject key ID check");
            }
            return false;
        }
    }

    private boolean matchAuthorityKeyID(X509Certificate xcert) {
        if (this.authorityKeyID == null) {
            return true;
        }
        try {
            byte[] extVal = xcert.getExtensionValue("2.5.29.35");
            if (extVal == null) {
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("X509CertSelector.match: no authority key ID extension");
                }
                return false;
            }
            DerInputStream in = new DerInputStream(extVal);
            byte[] certAuthKeyID = in.getOctetString();
            if (certAuthKeyID != null && Arrays.equals(this.authorityKeyID, certAuthKeyID)) {
                return true;
            }
            Debug debug3 = debug;
            if (debug3 != null) {
                debug3.println("X509CertSelector.match: authority key IDs don't match");
            }
            return false;
        } catch (IOException e2) {
            Debug debug4 = debug;
            if (debug4 != null) {
                debug4.println("X509CertSelector.match: exception in authority key ID check");
            }
            return false;
        }
    }

    private boolean matchPrivateKeyValid(X509Certificate xcert) {
        if (this.privateKeyValid == null) {
            return true;
        }
        PrivateKeyUsageExtension ext = null;
        try {
            ext = (PrivateKeyUsageExtension) getExtensionObject(xcert, 0);
            if (ext != null) {
                ext.valid(this.privateKeyValid);
            }
            return true;
        } catch (IOException e42) {
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("X509CertSelector.match: IOException in private key usage check; X509CertSelector: " + toString());
                e42.printStackTrace();
            }
            return false;
        } catch (CertificateExpiredException e12) {
            if (debug != null) {
                String time = "n/a";
                try {
                    Date notAfter = ext.get(PrivateKeyUsageExtension.NOT_AFTER);
                    time = notAfter.toString();
                } catch (CertificateException e2) {
                }
                debug.println("X509CertSelector.match: private key usage not within validity date; ext.NOT_After: " + time + "; X509CertSelector: " + toString());
                e12.printStackTrace();
            }
            return false;
        } catch (CertificateNotYetValidException e22) {
            if (debug != null) {
                String time2 = "n/a";
                try {
                    Date notBefore = ext.get(PrivateKeyUsageExtension.NOT_BEFORE);
                    time2 = notBefore.toString();
                } catch (CertificateException e10) {
                }
                debug.println("X509CertSelector.match: private key usage not within validity date; ext.NOT_BEFORE: " + time2 + "; X509CertSelector: " + toString());
                e22.printStackTrace();
            }
            return false;
        }
    }

    private boolean matchSubjectPublicKeyAlgID(X509Certificate xcert) {
        if (this.subjectPublicKeyAlgID == null) {
            return true;
        }
        try {
            byte[] encodedKey = xcert.getPublicKey().getEncoded();
            DerValue val = new DerValue(encodedKey);
            if (val.tag != 48) {
                throw new IOException("invalid key format");
            }
            AlgorithmId algID = AlgorithmId.parse(val.data.getDerValue());
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("X509CertSelector.match: subjectPublicKeyAlgID = " + ((Object) this.subjectPublicKeyAlgID) + ", xcert subjectPublicKeyAlgID = " + ((Object) algID.getOID()));
            }
            if (this.subjectPublicKeyAlgID.equals(algID.getOID())) {
                return true;
            }
            if (debug2 != null) {
                debug2.println("X509CertSelector.match: subject public key alg IDs don't match");
            }
            return false;
        } catch (IOException e2) {
            Debug debug3 = debug;
            if (debug3 != null) {
                debug3.println("X509CertSelector.match: IOException in subject public key algorithm OID check");
            }
            return false;
        }
    }

    private boolean matchKeyUsage(X509Certificate xcert) {
        boolean[] certKeyUsage;
        int keyBit;
        if (this.keyUsage != null && (certKeyUsage = xcert.getKeyUsage()) != null) {
            while (true) {
                boolean[] zArr = this.keyUsage;
                if (keyBit >= zArr.length) {
                    break;
                }
                keyBit = (!zArr[keyBit] || (keyBit < certKeyUsage.length && certKeyUsage[keyBit])) ? keyBit + 1 : 0;
            }
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("X509CertSelector.match: key usage bits don't match");
                return false;
            }
            return false;
        }
        return true;
    }

    private boolean matchExtendedKeyUsage(X509Certificate xcert) {
        Set<String> set = this.keyPurposeSet;
        if (set == null || set.isEmpty()) {
            return true;
        }
        try {
            ExtendedKeyUsageExtension ext = (ExtendedKeyUsageExtension) getExtensionObject(xcert, 4);
            if (ext != null) {
                Vector<ObjectIdentifier> certKeyPurposeVector = ext.get(ExtendedKeyUsageExtension.USAGES);
                if (!certKeyPurposeVector.contains(ANY_EXTENDED_KEY_USAGE) && !certKeyPurposeVector.containsAll(this.keyPurposeOIDSet)) {
                    Debug debug2 = debug;
                    if (debug2 != null) {
                        debug2.println("X509CertSelector.match: cert failed extendedKeyUsage criterion");
                    }
                    return false;
                }
            }
            return true;
        } catch (IOException e2) {
            Debug debug3 = debug;
            if (debug3 != null) {
                debug3.println("X509CertSelector.match: IOException in extended key usage check");
            }
            return false;
        }
    }

    private boolean matchSubjectAlternativeNames(X509Certificate xcert) {
        Set<List<?>> set = this.subjectAlternativeNames;
        if (set == null || set.isEmpty()) {
            return true;
        }
        try {
            SubjectAlternativeNameExtension sanExt = (SubjectAlternativeNameExtension) getExtensionObject(xcert, 1);
            if (sanExt == null) {
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("X509CertSelector.match: no subject alternative name extension");
                }
                return false;
            }
            GeneralNames certNames = sanExt.get(SubjectAlternativeNameExtension.SUBJECT_NAME);
            Iterator<GeneralNameInterface> i10 = this.subjectAlternativeGeneralNames.iterator2();
            while (i10.hasNext()) {
                GeneralNameInterface matchName = i10.next();
                boolean found = false;
                Iterator<GeneralName> t2 = certNames.iterator();
                while (t2.hasNext() && !found) {
                    GeneralNameInterface certName = t2.next().getName();
                    found = certName.equals(matchName);
                }
                if (!found && (this.matchAllSubjectAltNames || !i10.hasNext())) {
                    Debug debug3 = debug;
                    if (debug3 != null) {
                        debug3.println("X509CertSelector.match: subject alternative name " + ((Object) matchName) + " not found");
                    }
                    return false;
                }
                if (found && !this.matchAllSubjectAltNames) {
                    break;
                }
            }
            return true;
        } catch (IOException e2) {
            Debug debug4 = debug;
            if (debug4 != null) {
                debug4.println("X509CertSelector.match: IOException in subject alternative name check");
            }
            return false;
        }
    }

    private boolean matchNameConstraints(X509Certificate xcert) {
        NameConstraintsExtension nameConstraintsExtension = this.f50393nc;
        if (nameConstraintsExtension == null) {
            return true;
        }
        try {
            if (nameConstraintsExtension.verify(xcert)) {
                return true;
            }
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("X509CertSelector.match: name constraints not satisfied");
            }
            return false;
        } catch (IOException e2) {
            Debug debug3 = debug;
            if (debug3 != null) {
                debug3.println("X509CertSelector.match: IOException in name constraints check");
            }
            return false;
        }
    }

    private boolean matchPolicy(X509Certificate xcert) {
        if (this.policy == null) {
            return true;
        }
        try {
            CertificatePoliciesExtension ext = (CertificatePoliciesExtension) getExtensionObject(xcert, 3);
            if (ext == null) {
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("X509CertSelector.match: no certificate policy extension");
                }
                return false;
            }
            List<PolicyInformation> policies = ext.get(CertificatePoliciesExtension.POLICIES);
            List<CertificatePolicyId> policyIDs = new ArrayList<>(policies.size());
            for (PolicyInformation info : policies) {
                policyIDs.add(info.getPolicyIdentifier());
            }
            CertificatePolicySet certificatePolicySet = this.policy;
            if (certificatePolicySet != null) {
                boolean foundOne = false;
                if (certificatePolicySet.getCertPolicyIds().isEmpty()) {
                    if (policyIDs.isEmpty()) {
                        Debug debug3 = debug;
                        if (debug3 != null) {
                            debug3.println("X509CertSelector.match: cert failed policyAny criterion");
                        }
                        return false;
                    }
                } else {
                    Iterator<CertificatePolicyId> iterator2 = this.policy.getCertPolicyIds().iterator2();
                    while (true) {
                        if (!iterator2.hasNext()) {
                            break;
                        }
                        CertificatePolicyId id2 = iterator2.next();
                        if (policyIDs.contains(id2)) {
                            foundOne = true;
                            break;
                        }
                    }
                    if (!foundOne) {
                        Debug debug4 = debug;
                        if (debug4 != null) {
                            debug4.println("X509CertSelector.match: cert failed policyAny criterion");
                        }
                        return false;
                    }
                }
            }
            return true;
        } catch (IOException e2) {
            Debug debug5 = debug;
            if (debug5 != null) {
                debug5.println("X509CertSelector.match: IOException in certificate policy ID check");
            }
            return false;
        }
    }

    private boolean matchPathToNames(X509Certificate xcert) {
        if (this.pathToGeneralNames == null) {
            return true;
        }
        try {
            NameConstraintsExtension ext = (NameConstraintsExtension) getExtensionObject(xcert, 2);
            if (ext == null) {
                return true;
            }
            Debug debug2 = debug;
            if (debug2 != null && Debug.isOn("certpath")) {
                debug2.println("X509CertSelector.match pathToNames:\n");
                Iterator<GeneralNameInterface> i10 = this.pathToGeneralNames.iterator2();
                while (i10.hasNext()) {
                    debug.println("    " + ((Object) i10.next()) + "\n");
                }
            }
            GeneralSubtrees permitted = ext.get(NameConstraintsExtension.PERMITTED_SUBTREES);
            GeneralSubtrees excluded = ext.get(NameConstraintsExtension.EXCLUDED_SUBTREES);
            if (excluded != null && !matchExcluded(excluded)) {
                return false;
            }
            if (permitted != null) {
                if (!matchPermitted(permitted)) {
                    return false;
                }
            }
            return true;
        } catch (IOException e2) {
            Debug debug3 = debug;
            if (debug3 != null) {
                debug3.println("X509CertSelector.match: IOException in name constraints check");
            }
            return false;
        }
    }

    private boolean matchExcluded(GeneralSubtrees excluded) {
        Iterator<GeneralSubtree> t2 = excluded.iterator();
        while (t2.hasNext()) {
            GeneralSubtree tree = t2.next();
            GeneralNameInterface excludedName = tree.getName().getName();
            for (GeneralNameInterface pathToName : this.pathToGeneralNames) {
                if (excludedName.getType() == pathToName.getType()) {
                    switch (pathToName.constrains(excludedName)) {
                        case 0:
                        case 2:
                            Debug debug2 = debug;
                            if (debug2 != null) {
                                debug2.println("X509CertSelector.match: name constraints inhibit path to specified name");
                                debug2.println("X509CertSelector.match: excluded name: " + ((Object) pathToName));
                                return false;
                            }
                            return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean matchPermitted(GeneralSubtrees permitted) {
        for (GeneralNameInterface pathToName : this.pathToGeneralNames) {
            Iterator<GeneralSubtree> t2 = permitted.iterator();
            boolean permittedNameFound = false;
            boolean nameTypeFound = false;
            String names = "";
            while (t2.hasNext() && !permittedNameFound) {
                GeneralSubtree tree = t2.next();
                GeneralNameInterface permittedName = tree.getName().getName();
                if (permittedName.getType() == pathToName.getType()) {
                    nameTypeFound = true;
                    names = names + "  " + ((Object) permittedName);
                    switch (pathToName.constrains(permittedName)) {
                        case 0:
                        case 2:
                            permittedNameFound = true;
                            break;
                    }
                }
            }
            if (!permittedNameFound && nameTypeFound) {
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("X509CertSelector.match: name constraints inhibit path to specified name; permitted names of type " + pathToName.getType() + ": " + names);
                    return false;
                }
                return false;
            }
        }
        return true;
    }

    private boolean matchBasicConstraints(X509Certificate xcert) {
        if (this.basicConstraints == -1) {
            return true;
        }
        int maxPathLen = xcert.getBasicConstraints();
        int i10 = this.basicConstraints;
        if (i10 == -2) {
            if (maxPathLen != -1) {
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("X509CertSelector.match: not an EE cert");
                }
                return false;
            }
        } else if (maxPathLen < i10) {
            Debug debug3 = debug;
            if (debug3 != null) {
                debug3.println("X509CertSelector.match: cert's maxPathLen is less than the min maxPathLen set by basicConstraints. (" + maxPathLen + " < " + this.basicConstraints + ")");
            }
            return false;
        }
        return true;
    }

    private static <T> Set<T> cloneSet(Set<T> set) {
        if (set instanceof HashSet) {
            Object clone = ((HashSet) set).clone();
            return (Set) clone;
        }
        return new HashSet(set);
    }

    @Override // java.security.cert.CertSelector, com.android.internal.org.bouncycastle.util.Selector
    public Object clone() {
        try {
            X509CertSelector copy = (X509CertSelector) super.clone();
            Set<List<?>> set = this.subjectAlternativeNames;
            if (set != null) {
                copy.subjectAlternativeNames = cloneSet(set);
                copy.subjectAlternativeGeneralNames = cloneSet(this.subjectAlternativeGeneralNames);
            }
            if (this.pathToGeneralNames != null) {
                copy.pathToNames = cloneSet(this.pathToNames);
                copy.pathToGeneralNames = cloneSet(this.pathToGeneralNames);
            }
            return copy;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2.toString(), e2);
        }
    }
}
