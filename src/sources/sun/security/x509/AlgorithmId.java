package sun.security.x509;

import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import sun.security.util.DerEncoder;
import sun.security.util.DerInputStream;
import sun.security.util.DerOutputStream;
import sun.security.util.DerValue;
import sun.security.util.ObjectIdentifier;
import ta.b;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class AlgorithmId implements Serializable, DerEncoder {
    public static final ObjectIdentifier AES_oid;
    private static final int[] DH_PKIX_data;
    public static final ObjectIdentifier DH_PKIX_oid;
    private static final int[] DH_data;
    public static final ObjectIdentifier DH_oid;
    private static final int[] DSA_OIW_data;
    public static final ObjectIdentifier DSA_OIW_oid;
    private static final int[] DSA_PKIX_data;
    public static final ObjectIdentifier DSA_oid;
    public static final ObjectIdentifier ECDH_oid;
    public static final ObjectIdentifier EC_oid;
    public static final ObjectIdentifier MD2_oid;
    public static final ObjectIdentifier MD5_oid;
    private static final int[] RSAEncryption_data;
    public static final ObjectIdentifier RSAEncryption_oid;
    private static final int[] RSA_data;
    public static final ObjectIdentifier RSA_oid;
    public static final ObjectIdentifier SHA224_oid;
    public static final ObjectIdentifier SHA256_oid;
    public static final ObjectIdentifier SHA384_oid;
    public static final ObjectIdentifier SHA512_oid;
    public static final ObjectIdentifier SHA_oid;
    private static final int[] dsaWithSHA1_PKIX_data;
    private static final int[] md2WithRSAEncryption_data;
    public static final ObjectIdentifier md2WithRSAEncryption_oid;
    private static final int[] md5WithRSAEncryption_data;
    public static final ObjectIdentifier md5WithRSAEncryption_oid;
    private static final Map<ObjectIdentifier, String> nameTable;
    public static final ObjectIdentifier pbeWithMD5AndDES_oid;
    public static final ObjectIdentifier pbeWithMD5AndRC2_oid;
    public static final ObjectIdentifier pbeWithSHA1AndDES_oid;
    public static ObjectIdentifier pbeWithSHA1AndDESede_oid = null;
    public static ObjectIdentifier pbeWithSHA1AndRC2_40_oid = null;
    public static final ObjectIdentifier pbeWithSHA1AndRC2_oid;
    private static final long serialVersionUID = 7205873507486557157L;
    private static final int[] sha1WithDSA_OIW_data;
    public static final ObjectIdentifier sha1WithDSA_OIW_oid;
    public static final ObjectIdentifier sha1WithDSA_oid;
    public static final ObjectIdentifier sha1WithECDSA_oid;
    private static final int[] sha1WithRSAEncryption_OIW_data;
    public static final ObjectIdentifier sha1WithRSAEncryption_OIW_oid;
    private static final int[] sha1WithRSAEncryption_data;
    public static final ObjectIdentifier sha1WithRSAEncryption_oid;
    public static final ObjectIdentifier sha224WithDSA_oid;
    public static final ObjectIdentifier sha224WithECDSA_oid;
    private static final int[] sha224WithRSAEncryption_data;
    public static final ObjectIdentifier sha224WithRSAEncryption_oid;
    public static final ObjectIdentifier sha256WithDSA_oid;
    public static final ObjectIdentifier sha256WithECDSA_oid;
    private static final int[] sha256WithRSAEncryption_data;
    public static final ObjectIdentifier sha256WithRSAEncryption_oid;
    public static final ObjectIdentifier sha384WithECDSA_oid;
    private static final int[] sha384WithRSAEncryption_data;
    public static final ObjectIdentifier sha384WithRSAEncryption_oid;
    public static final ObjectIdentifier sha512WithECDSA_oid;
    private static final int[] sha512WithRSAEncryption_data;
    public static final ObjectIdentifier sha512WithRSAEncryption_oid;
    private static final int[] shaWithDSA_OIW_data;
    public static final ObjectIdentifier shaWithDSA_OIW_oid;
    public static final ObjectIdentifier specifiedWithECDSA_oid;
    private AlgorithmParameters algParams;
    private ObjectIdentifier algid;
    private boolean constructedFromDer;
    protected DerValue params;
    private static int initOidTableVersion = -1;
    private static final Map<String, ObjectIdentifier> oidTable = new HashMap(1);

    @Deprecated
    public AlgorithmId() {
        this.constructedFromDer = true;
    }

    public AlgorithmId(ObjectIdentifier oid) {
        this.constructedFromDer = true;
        this.algid = oid;
    }

    public AlgorithmId(ObjectIdentifier oid, AlgorithmParameters algparams) {
        this.constructedFromDer = true;
        this.algid = oid;
        this.algParams = algparams;
        this.constructedFromDer = false;
    }

    private AlgorithmId(ObjectIdentifier oid, DerValue params) throws IOException {
        this.constructedFromDer = true;
        this.algid = oid;
        this.params = params;
        if (params != null) {
            decodeParams();
        }
    }

    protected void decodeParams() throws IOException {
        String algidString = this.algid.toString();
        try {
            AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance(algidString);
            this.algParams = algorithmParameters;
            algorithmParameters.init(this.params.toByteArray());
        } catch (NoSuchAlgorithmException e2) {
            this.algParams = null;
        }
    }

    public final void encode(DerOutputStream out) throws IOException {
        derEncode(out);
    }

    @Override // sun.security.util.DerEncoder
    public void derEncode(OutputStream out) throws IOException {
        DerOutputStream bytes = new DerOutputStream();
        DerOutputStream tmp = new DerOutputStream();
        bytes.putOID(this.algid);
        if (!this.constructedFromDer) {
            AlgorithmParameters algorithmParameters = this.algParams;
            if (algorithmParameters != null) {
                this.params = new DerValue(algorithmParameters.getEncoded());
            } else {
                this.params = null;
            }
        }
        DerValue derValue = this.params;
        if (derValue == null) {
            bytes.putNull();
        } else {
            bytes.putDerValue(derValue);
        }
        tmp.write((byte) 48, bytes);
        out.write(tmp.toByteArray());
    }

    public final byte[] encode() throws IOException {
        DerOutputStream out = new DerOutputStream();
        derEncode(out);
        return out.toByteArray();
    }

    public final ObjectIdentifier getOID() {
        return this.algid;
    }

    public String getName() {
        String algName;
        String algName2 = nameTable.get(this.algid);
        if (algName2 != null) {
            return algName2;
        }
        if (this.params != null && this.algid.equals((Object) specifiedWithECDSA_oid)) {
            try {
                AlgorithmId paramsId = parse(new DerValue(getEncodedParams()));
                String paramsName = paramsId.getName();
                makeSigAlg(paramsName, "EC");
            } catch (IOException e2) {
            }
        }
        synchronized (oidTable) {
            reinitializeMappingTableLocked();
            algName = nameTable.get(this.algid);
        }
        return algName == null ? this.algid.toString() : algName;
    }

    public AlgorithmParameters getParameters() {
        return this.algParams;
    }

    public byte[] getEncodedParams() throws IOException {
        DerValue derValue = this.params;
        if (derValue == null) {
            return null;
        }
        return derValue.toByteArray();
    }

    public boolean equals(AlgorithmId other) {
        DerValue derValue = this.params;
        boolean paramsEqual = derValue == null ? other.params == null : derValue.equals(other.params);
        return this.algid.equals((Object) other.algid) && paramsEqual;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AlgorithmId) {
            return equals((AlgorithmId) other);
        }
        if (other instanceof ObjectIdentifier) {
            return equals((ObjectIdentifier) other);
        }
        return false;
    }

    public final boolean equals(ObjectIdentifier id2) {
        return this.algid.equals((Object) id2);
    }

    public int hashCode() {
        return (this.algid.toString() + paramsToString()).hashCode();
    }

    protected String paramsToString() {
        if (this.params == null) {
            return "";
        }
        AlgorithmParameters algorithmParameters = this.algParams;
        if (algorithmParameters != null) {
            return algorithmParameters.toString();
        }
        return ", params unparsed";
    }

    public String toString() {
        return getName() + paramsToString();
    }

    public static AlgorithmId parse(DerValue val) throws IOException {
        DerValue params;
        if (val.tag != 48) {
            throw new IOException("algid parse error, not a sequence");
        }
        DerInputStream in = val.toDerInputStream();
        ObjectIdentifier algid = in.getOID();
        if (in.available() == 0) {
            params = null;
        } else {
            params = in.getDerValue();
            if (params.tag == 5) {
                if (params.length() != 0) {
                    throw new IOException("invalid NULL");
                }
                params = null;
            }
            if (in.available() != 0) {
                throw new IOException("Invalid AlgorithmIdentifier: extra data");
            }
        }
        return new AlgorithmId(algid, params);
    }

    @Deprecated
    public static AlgorithmId getAlgorithmId(String algname) throws NoSuchAlgorithmException {
        return get(algname);
    }

    public static AlgorithmId get(String algname) throws NoSuchAlgorithmException {
        try {
            ObjectIdentifier oid = algOID(algname);
            if (oid == null) {
                throw new NoSuchAlgorithmException("unrecognized algorithm name: " + algname);
            }
            return new AlgorithmId(oid);
        } catch (IOException e2) {
            throw new NoSuchAlgorithmException("Invalid ObjectIdentifier " + algname);
        }
    }

    public static AlgorithmId get(AlgorithmParameters algparams) throws NoSuchAlgorithmException {
        String algname = algparams.getAlgorithm();
        try {
            ObjectIdentifier oid = algOID(algname);
            if (oid == null) {
                throw new NoSuchAlgorithmException("unrecognized algorithm name: " + algname);
            }
            return new AlgorithmId(oid, algparams);
        } catch (IOException e2) {
            throw new NoSuchAlgorithmException("Invalid ObjectIdentifier " + algname);
        }
    }

    private static ObjectIdentifier algOID(String name) throws IOException {
        ObjectIdentifier objectIdentifier;
        if (name.indexOf(46) != -1) {
            if (name.startsWith("OID.")) {
                return new ObjectIdentifier(name.substring("OID.".length()));
            }
            return new ObjectIdentifier(name);
        }
        if (name.equalsIgnoreCase("MD5")) {
            return MD5_oid;
        }
        if (name.equalsIgnoreCase("MD2")) {
            return MD2_oid;
        }
        if (name.equalsIgnoreCase(b.f53790a) || name.equalsIgnoreCase("SHA1") || name.equalsIgnoreCase("SHA-1")) {
            return SHA_oid;
        }
        if (name.equalsIgnoreCase("SHA-256") || name.equalsIgnoreCase("SHA256")) {
            return SHA256_oid;
        }
        if (name.equalsIgnoreCase("SHA-384") || name.equalsIgnoreCase("SHA384")) {
            return SHA384_oid;
        }
        if (name.equalsIgnoreCase("SHA-512") || name.equalsIgnoreCase("SHA512")) {
            return SHA512_oid;
        }
        if (name.equalsIgnoreCase("SHA-224") || name.equalsIgnoreCase("SHA224")) {
            return SHA224_oid;
        }
        if (name.equalsIgnoreCase("RSA")) {
            return RSAEncryption_oid;
        }
        if (name.equalsIgnoreCase("Diffie-Hellman") || name.equalsIgnoreCase("DH")) {
            return DH_oid;
        }
        if (name.equalsIgnoreCase("DSA")) {
            return DSA_oid;
        }
        if (name.equalsIgnoreCase("EC")) {
            return EC_oid;
        }
        if (name.equalsIgnoreCase("ECDH")) {
            return ECDH_oid;
        }
        if (name.equalsIgnoreCase(AESEncrypt.ALGORITHM)) {
            return AES_oid;
        }
        if (name.equalsIgnoreCase("MD5withRSA") || name.equalsIgnoreCase("MD5/RSA")) {
            return md5WithRSAEncryption_oid;
        }
        if (name.equalsIgnoreCase("MD2withRSA") || name.equalsIgnoreCase("MD2/RSA")) {
            return md2WithRSAEncryption_oid;
        }
        if (name.equalsIgnoreCase("SHAwithDSA") || name.equalsIgnoreCase("SHA1withDSA") || name.equalsIgnoreCase("SHA/DSA") || name.equalsIgnoreCase("SHA1/DSA") || name.equalsIgnoreCase("DSAWithSHA1") || name.equalsIgnoreCase("DSS") || name.equalsIgnoreCase("SHA-1/DSA")) {
            return sha1WithDSA_oid;
        }
        if (name.equalsIgnoreCase("SHA224WithDSA")) {
            return sha224WithDSA_oid;
        }
        if (name.equalsIgnoreCase("SHA256WithDSA")) {
            return sha256WithDSA_oid;
        }
        if (name.equalsIgnoreCase("SHA1WithRSA") || name.equalsIgnoreCase("SHA1/RSA")) {
            return sha1WithRSAEncryption_oid;
        }
        if (name.equalsIgnoreCase("SHA1withECDSA") || name.equalsIgnoreCase("ECDSA")) {
            return sha1WithECDSA_oid;
        }
        if (name.equalsIgnoreCase("SHA224withECDSA")) {
            return sha224WithECDSA_oid;
        }
        if (name.equalsIgnoreCase("SHA256withECDSA")) {
            return sha256WithECDSA_oid;
        }
        if (name.equalsIgnoreCase("SHA384withECDSA")) {
            return sha384WithECDSA_oid;
        }
        if (name.equalsIgnoreCase("SHA512withECDSA")) {
            return sha512WithECDSA_oid;
        }
        Map<String, ObjectIdentifier> map = oidTable;
        synchronized (map) {
            reinitializeMappingTableLocked();
            objectIdentifier = map.get(name.toUpperCase(Locale.ENGLISH));
        }
        return objectIdentifier;
    }

    private static void reinitializeMappingTableLocked() {
        String stdAlgName;
        int currentVersion = Security.getVersion();
        if (initOidTableVersion != currentVersion) {
            Provider[] provs = Security.getProviders();
            for (int i10 = 0; i10 < provs.length; i10++) {
                Enumeration<Object> enum_ = provs[i10].keys();
                while (enum_.hasMoreElements()) {
                    String alias = (String) enum_.nextElement();
                    String upperCaseAlias = alias.toUpperCase(Locale.ENGLISH);
                    if (upperCaseAlias.startsWith("ALG.ALIAS")) {
                        int index = upperCaseAlias.indexOf("OID.", 0);
                        if (index != -1) {
                            int index2 = index + "OID.".length();
                            if (index2 == alias.length()) {
                                break;
                            }
                            String oidString = alias.substring(index2);
                            String stdAlgName2 = provs[i10].getProperty(alias);
                            if (stdAlgName2 != null) {
                                String stdAlgName3 = stdAlgName2.toUpperCase(Locale.ENGLISH);
                                ObjectIdentifier oid = null;
                                try {
                                    oid = new ObjectIdentifier(oidString);
                                } catch (IOException e2) {
                                }
                                if (oid != null) {
                                    Map<String, ObjectIdentifier> map = oidTable;
                                    if (!map.containsKey(stdAlgName3)) {
                                        map.put(stdAlgName3, oid);
                                    }
                                    Map<ObjectIdentifier, String> map2 = nameTable;
                                    if (!map2.containsKey(oid)) {
                                        map2.put(oid, stdAlgName3);
                                    }
                                }
                            }
                        } else {
                            int sep = alias.indexOf(46, "ALG.ALIAS.".length());
                            String suffix = alias.substring(sep + 1);
                            ObjectIdentifier oid2 = null;
                            try {
                                oid2 = new ObjectIdentifier(suffix);
                            } catch (IOException e10) {
                            }
                            if (oid2 != null && (stdAlgName = provs[i10].getProperty(alias)) != null) {
                                String stdAlgName4 = stdAlgName.toUpperCase(Locale.ENGLISH);
                                Map<String, ObjectIdentifier> map3 = oidTable;
                                if (!map3.containsKey(stdAlgName4)) {
                                    map3.put(stdAlgName4, oid2);
                                }
                                Map<ObjectIdentifier, String> map4 = nameTable;
                                if (!map4.containsKey(oid2)) {
                                    map4.put(oid2, stdAlgName4);
                                }
                            }
                        }
                    }
                }
            }
            initOidTableVersion = currentVersion;
        }
    }

    private static ObjectIdentifier oid(int... values) {
        return ObjectIdentifier.newInternal(values);
    }

    static {
        HashMap hashMap = new HashMap();
        nameTable = hashMap;
        ObjectIdentifier newInternal = ObjectIdentifier.newInternal(new int[]{1, 2, 840, 113549, 2, 2});
        MD2_oid = newInternal;
        ObjectIdentifier newInternal2 = ObjectIdentifier.newInternal(new int[]{1, 2, 840, 113549, 2, 5});
        MD5_oid = newInternal2;
        ObjectIdentifier newInternal3 = ObjectIdentifier.newInternal(new int[]{1, 3, 14, 3, 2, 26});
        SHA_oid = newInternal3;
        ObjectIdentifier newInternal4 = ObjectIdentifier.newInternal(new int[]{2, 16, 840, 1, 101, 3, 4, 2, 4});
        SHA224_oid = newInternal4;
        ObjectIdentifier newInternal5 = ObjectIdentifier.newInternal(new int[]{2, 16, 840, 1, 101, 3, 4, 2, 1});
        SHA256_oid = newInternal5;
        ObjectIdentifier newInternal6 = ObjectIdentifier.newInternal(new int[]{2, 16, 840, 1, 101, 3, 4, 2, 2});
        SHA384_oid = newInternal6;
        ObjectIdentifier newInternal7 = ObjectIdentifier.newInternal(new int[]{2, 16, 840, 1, 101, 3, 4, 2, 3});
        SHA512_oid = newInternal7;
        int[] iArr = {1, 2, 840, 113549, 1, 3, 1};
        DH_data = iArr;
        int[] iArr2 = {1, 2, 840, 10046, 2, 1};
        DH_PKIX_data = iArr2;
        int[] iArr3 = {1, 3, 14, 3, 2, 12};
        DSA_OIW_data = iArr3;
        int[] iArr4 = {1, 2, 840, 10040, 4, 1};
        DSA_PKIX_data = iArr4;
        int[] iArr5 = {2, 5, 8, 1, 1};
        RSA_data = iArr5;
        int[] iArr6 = {1, 2, 840, 113549, 1, 1, 1};
        RSAEncryption_data = iArr6;
        ObjectIdentifier oid = oid(1, 2, 840, 10045, 2, 1);
        EC_oid = oid;
        ObjectIdentifier oid2 = oid(1, 3, 132, 1, 12);
        ECDH_oid = oid2;
        ObjectIdentifier oid3 = oid(2, 16, 840, 1, 101, 3, 4, 1);
        AES_oid = oid3;
        int[] iArr7 = {1, 2, 840, 113549, 1, 1, 2};
        md2WithRSAEncryption_data = iArr7;
        int[] iArr8 = {1, 2, 840, 113549, 1, 1, 4};
        md5WithRSAEncryption_data = iArr8;
        int[] iArr9 = {1, 2, 840, 113549, 1, 1, 5};
        sha1WithRSAEncryption_data = iArr9;
        int[] iArr10 = {1, 3, 14, 3, 2, 29};
        sha1WithRSAEncryption_OIW_data = iArr10;
        int[] iArr11 = {1, 2, 840, 113549, 1, 1, 14};
        sha224WithRSAEncryption_data = iArr11;
        int[] iArr12 = {1, 2, 840, 113549, 1, 1, 11};
        sha256WithRSAEncryption_data = iArr12;
        int[] iArr13 = {1, 2, 840, 113549, 1, 1, 12};
        sha384WithRSAEncryption_data = iArr13;
        int[] iArr14 = {1, 2, 840, 113549, 1, 1, 13};
        sha512WithRSAEncryption_data = iArr14;
        int[] iArr15 = {1, 3, 14, 3, 2, 13};
        shaWithDSA_OIW_data = iArr15;
        int[] iArr16 = {1, 3, 14, 3, 2, 27};
        sha1WithDSA_OIW_data = iArr16;
        int[] iArr17 = {1, 2, 840, 10040, 4, 3};
        dsaWithSHA1_PKIX_data = iArr17;
        ObjectIdentifier oid4 = oid(2, 16, 840, 1, 101, 3, 4, 3, 1);
        sha224WithDSA_oid = oid4;
        ObjectIdentifier oid5 = oid(2, 16, 840, 1, 101, 3, 4, 3, 2);
        sha256WithDSA_oid = oid5;
        ObjectIdentifier oid6 = oid(1, 2, 840, 10045, 4, 1);
        sha1WithECDSA_oid = oid6;
        ObjectIdentifier oid7 = oid(1, 2, 840, 10045, 4, 3, 1);
        sha224WithECDSA_oid = oid7;
        ObjectIdentifier oid8 = oid(1, 2, 840, 10045, 4, 3, 2);
        sha256WithECDSA_oid = oid8;
        ObjectIdentifier oid9 = oid(1, 2, 840, 10045, 4, 3, 3);
        sha384WithECDSA_oid = oid9;
        ObjectIdentifier oid10 = oid(1, 2, 840, 10045, 4, 3, 4);
        sha512WithECDSA_oid = oid10;
        specifiedWithECDSA_oid = oid(1, 2, 840, 10045, 4, 3);
        ObjectIdentifier newInternal8 = ObjectIdentifier.newInternal(new int[]{1, 2, 840, 113549, 1, 5, 3});
        pbeWithMD5AndDES_oid = newInternal8;
        ObjectIdentifier newInternal9 = ObjectIdentifier.newInternal(new int[]{1, 2, 840, 113549, 1, 5, 6});
        pbeWithMD5AndRC2_oid = newInternal9;
        ObjectIdentifier newInternal10 = ObjectIdentifier.newInternal(new int[]{1, 2, 840, 113549, 1, 5, 10});
        pbeWithSHA1AndDES_oid = newInternal10;
        ObjectIdentifier newInternal11 = ObjectIdentifier.newInternal(new int[]{1, 2, 840, 113549, 1, 5, 11});
        pbeWithSHA1AndRC2_oid = newInternal11;
        pbeWithSHA1AndDESede_oid = ObjectIdentifier.newInternal(new int[]{1, 2, 840, 113549, 1, 12, 1, 3});
        pbeWithSHA1AndRC2_40_oid = ObjectIdentifier.newInternal(new int[]{1, 2, 840, 113549, 1, 12, 1, 6});
        ObjectIdentifier newInternal12 = ObjectIdentifier.newInternal(iArr);
        DH_oid = newInternal12;
        ObjectIdentifier newInternal13 = ObjectIdentifier.newInternal(iArr2);
        DH_PKIX_oid = newInternal13;
        ObjectIdentifier newInternal14 = ObjectIdentifier.newInternal(iArr3);
        DSA_OIW_oid = newInternal14;
        ObjectIdentifier newInternal15 = ObjectIdentifier.newInternal(iArr4);
        DSA_oid = newInternal15;
        ObjectIdentifier newInternal16 = ObjectIdentifier.newInternal(iArr5);
        RSA_oid = newInternal16;
        ObjectIdentifier newInternal17 = ObjectIdentifier.newInternal(iArr6);
        RSAEncryption_oid = newInternal17;
        ObjectIdentifier newInternal18 = ObjectIdentifier.newInternal(iArr7);
        md2WithRSAEncryption_oid = newInternal18;
        ObjectIdentifier newInternal19 = ObjectIdentifier.newInternal(iArr8);
        md5WithRSAEncryption_oid = newInternal19;
        ObjectIdentifier newInternal20 = ObjectIdentifier.newInternal(iArr9);
        sha1WithRSAEncryption_oid = newInternal20;
        ObjectIdentifier newInternal21 = ObjectIdentifier.newInternal(iArr10);
        sha1WithRSAEncryption_OIW_oid = newInternal21;
        ObjectIdentifier newInternal22 = ObjectIdentifier.newInternal(iArr11);
        sha224WithRSAEncryption_oid = newInternal22;
        ObjectIdentifier newInternal23 = ObjectIdentifier.newInternal(iArr12);
        sha256WithRSAEncryption_oid = newInternal23;
        ObjectIdentifier newInternal24 = ObjectIdentifier.newInternal(iArr13);
        sha384WithRSAEncryption_oid = newInternal24;
        ObjectIdentifier newInternal25 = ObjectIdentifier.newInternal(iArr14);
        sha512WithRSAEncryption_oid = newInternal25;
        ObjectIdentifier newInternal26 = ObjectIdentifier.newInternal(iArr15);
        shaWithDSA_OIW_oid = newInternal26;
        ObjectIdentifier newInternal27 = ObjectIdentifier.newInternal(iArr16);
        sha1WithDSA_OIW_oid = newInternal27;
        ObjectIdentifier newInternal28 = ObjectIdentifier.newInternal(iArr17);
        sha1WithDSA_oid = newInternal28;
        hashMap.put(newInternal2, "MD5");
        hashMap.put(newInternal, "MD2");
        hashMap.put(newInternal3, "SHA-1");
        hashMap.put(newInternal4, "SHA-224");
        hashMap.put(newInternal5, "SHA-256");
        hashMap.put(newInternal6, "SHA-384");
        hashMap.put(newInternal7, "SHA-512");
        hashMap.put(newInternal17, "RSA");
        hashMap.put(newInternal16, "RSA");
        hashMap.put(newInternal12, "Diffie-Hellman");
        hashMap.put(newInternal13, "Diffie-Hellman");
        hashMap.put(newInternal15, "DSA");
        hashMap.put(newInternal14, "DSA");
        hashMap.put(oid, "EC");
        hashMap.put(oid2, "ECDH");
        hashMap.put(oid3, AESEncrypt.ALGORITHM);
        hashMap.put(oid6, "SHA1withECDSA");
        hashMap.put(oid7, "SHA224withECDSA");
        hashMap.put(oid8, "SHA256withECDSA");
        hashMap.put(oid9, "SHA384withECDSA");
        hashMap.put(oid10, "SHA512withECDSA");
        hashMap.put(newInternal19, "MD5withRSA");
        hashMap.put(newInternal18, "MD2withRSA");
        hashMap.put(newInternal28, "SHA1withDSA");
        hashMap.put(newInternal27, "SHA1withDSA");
        hashMap.put(newInternal26, "SHA1withDSA");
        hashMap.put(oid4, "SHA224withDSA");
        hashMap.put(oid5, "SHA256withDSA");
        hashMap.put(newInternal20, "SHA1withRSA");
        hashMap.put(newInternal21, "SHA1withRSA");
        hashMap.put(newInternal22, "SHA224withRSA");
        hashMap.put(newInternal23, "SHA256withRSA");
        hashMap.put(newInternal24, "SHA384withRSA");
        hashMap.put(newInternal25, "SHA512withRSA");
        hashMap.put(newInternal8, "PBEWithMD5AndDES");
        hashMap.put(newInternal9, "PBEWithMD5AndRC2");
        hashMap.put(newInternal10, "PBEWithSHA1AndDES");
        hashMap.put(newInternal11, "PBEWithSHA1AndRC2");
        hashMap.put(pbeWithSHA1AndDESede_oid, "PBEWithSHA1AndDESede");
        hashMap.put(pbeWithSHA1AndRC2_40_oid, "PBEWithSHA1AndRC2_40");
    }

    public static String makeSigAlg(String digAlg, String encAlg) {
        String digAlg2 = digAlg.replace("-", "");
        if (encAlg.equalsIgnoreCase("EC")) {
            encAlg = "ECDSA";
        }
        return digAlg2 + "with" + encAlg;
    }

    public static String getEncAlgFromSigAlg(String signatureAlgorithm) {
        String keyAlgorithm;
        String signatureAlgorithm2 = signatureAlgorithm.toUpperCase(Locale.ENGLISH);
        int with = signatureAlgorithm2.indexOf("WITH");
        if (with <= 0) {
            return null;
        }
        int and = signatureAlgorithm2.indexOf("AND", with + 4);
        if (and > 0) {
            keyAlgorithm = signatureAlgorithm2.substring(with + 4, and);
        } else {
            keyAlgorithm = signatureAlgorithm2.substring(with + 4);
        }
        if (keyAlgorithm.equalsIgnoreCase("ECDSA")) {
            return "EC";
        }
        return keyAlgorithm;
    }

    public static String getDigAlgFromSigAlg(String signatureAlgorithm) {
        String signatureAlgorithm2 = signatureAlgorithm.toUpperCase(Locale.ENGLISH);
        int with = signatureAlgorithm2.indexOf("WITH");
        if (with > 0) {
            return signatureAlgorithm2.substring(0, with);
        }
        return null;
    }
}
