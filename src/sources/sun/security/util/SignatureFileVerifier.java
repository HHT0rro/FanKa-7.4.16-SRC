package sun.security.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.CodeSigner;
import java.security.CryptoPrimitive;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.cert.CertPath;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarException;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import sun.security.jca.Providers;
import sun.security.pkcs.PKCS7;
import sun.security.pkcs.SignerInfo;
import sun.security.util.ManifestDigester;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SignatureFileVerifier {
    private PKCS7 block;
    private CertificateFactory certificateFactory;
    private HashMap<String, MessageDigest> createdDigests;

    /* renamed from: md, reason: collision with root package name */
    private ManifestDigester f53743md;
    private String name;
    private byte[] sfBytes;
    private ArrayList<CodeSigner[]> signerCache;
    private boolean workaround = false;
    private static final Debug debug = Debug.getInstance("jar");
    private static final Set<CryptoPrimitive> DIGEST_PRIMITIVE_SET = Collections.unmodifiableSet(EnumSet.of(CryptoPrimitive.MESSAGE_DIGEST));
    private static final DisabledAlgorithmConstraints JAR_DISABLED_CHECK = new DisabledAlgorithmConstraints(DisabledAlgorithmConstraints.PROPERTY_JAR_DISABLED_ALGS);
    private static final String ATTR_DIGEST = "-DIGEST-Manifest-Main-Attributes".toUpperCase(Locale.ENGLISH);
    private static final char[] hexc = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public SignatureFileVerifier(ArrayList<CodeSigner[]> signerCache, ManifestDigester md2, String name, byte[] rawBytes) throws IOException, CertificateException {
        this.certificateFactory = null;
        Object obj = null;
        try {
            obj = Providers.startJarVerification();
            PKCS7 pkcs7 = new PKCS7(rawBytes);
            this.block = pkcs7;
            this.sfBytes = pkcs7.getContentInfo().getData();
            this.certificateFactory = CertificateFactory.getInstance("X509");
            Providers.stopJarVerification(obj);
            this.name = name.substring(0, name.lastIndexOf(".")).toUpperCase(Locale.ENGLISH);
            this.f53743md = md2;
            this.signerCache = signerCache;
        } catch (Throwable th) {
            Providers.stopJarVerification(obj);
            throw th;
        }
    }

    public boolean needSignatureFileBytes() {
        return this.sfBytes == null;
    }

    public boolean needSignatureFile(String name) {
        return this.name.equalsIgnoreCase(name);
    }

    public void setSignatureFile(byte[] sfBytes) {
        this.sfBytes = sfBytes;
    }

    public static boolean isBlockOrSF(String s2) {
        if (s2.endsWith(".SF") || s2.endsWith(".DSA") || s2.endsWith(".RSA") || s2.endsWith(".EC")) {
            return true;
        }
        return false;
    }

    public static boolean isSigningRelated(String name) {
        String name2 = name.toUpperCase(Locale.ENGLISH);
        if (!name2.startsWith("META-INF/")) {
            return false;
        }
        String name3 = name2.substring(9);
        if (name3.indexOf(47) != -1) {
            return false;
        }
        if (isBlockOrSF(name3) || name3.equals("MANIFEST.MF")) {
            return true;
        }
        if (!name3.startsWith("SIG-")) {
            return false;
        }
        int extIndex = name3.lastIndexOf(46);
        if (extIndex != -1) {
            String ext = name3.substring(extIndex + 1);
            if (ext.length() > 3 || ext.length() < 1) {
                return false;
            }
            for (int index = 0; index < ext.length(); index++) {
                char cc2 = ext.charAt(index);
                if ((cc2 < 'A' || cc2 > 'Z') && (cc2 < '0' || cc2 > '9')) {
                    return false;
                }
            }
        }
        return true;
    }

    private MessageDigest getDigest(String algorithm) throws SignatureException {
        if (!JAR_DISABLED_CHECK.permits(DIGEST_PRIMITIVE_SET, algorithm, null)) {
            SignatureException e2 = new SignatureException("SignatureFile check failed. Disabled algorithm used: " + algorithm);
            throw e2;
        }
        if (this.createdDigests == null) {
            this.createdDigests = new HashMap<>();
        }
        MessageDigest digest = this.createdDigests.get(algorithm);
        if (digest == null) {
            try {
                digest = MessageDigest.getInstance(algorithm);
                this.createdDigests.put(algorithm, digest);
                return digest;
            } catch (NoSuchAlgorithmException e10) {
                return digest;
            }
        }
        return digest;
    }

    public void process(Hashtable<String, CodeSigner[]> signers, List<Object> manifestDigests) throws IOException, SignatureException, NoSuchAlgorithmException, JarException, CertificateException {
        Object obj = null;
        try {
            obj = Providers.startJarVerification();
            processImpl(signers, manifestDigests);
        } finally {
            Providers.stopJarVerification(obj);
        }
    }

    private void processImpl(Hashtable<String, CodeSigner[]> signers, List<Object> manifestDigests) throws IOException, SignatureException, NoSuchAlgorithmException, JarException, CertificateException {
        Manifest sf = new Manifest();
        sf.read(new ByteArrayInputStream(this.sfBytes));
        String version = sf.getMainAttributes().getValue(Attributes.Name.SIGNATURE_VERSION);
        if (version == null || !version.equalsIgnoreCase("1.0")) {
            return;
        }
        SignerInfo[] infos = this.block.verify(this.sfBytes);
        if (infos == null) {
            throw new SecurityException("cannot verify signature block file " + this.name);
        }
        CodeSigner[] newSigners = getSigners(infos, this.block);
        if (newSigners == null) {
            return;
        }
        boolean manifestSigned = verifyManifestHash(sf, this.f53743md, manifestDigests);
        if (!manifestSigned && !verifyManifestMainAttrs(sf, this.f53743md)) {
            throw new SecurityException("Invalid signature file digest for Manifest main attributes");
        }
        for (Map.Entry<String, Attributes> e2 : sf.getEntries().entrySet()) {
            String name = e2.getKey();
            if (manifestSigned || verifySection(e2.getValue(), name, this.f53743md)) {
                if (name.startsWith("./")) {
                    name = name.substring(2);
                }
                if (name.startsWith("/")) {
                    name = name.substring(1);
                }
                updateSigners(newSigners, signers, name);
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("processSignature signed name = " + name);
                }
            } else {
                Debug debug3 = debug;
                if (debug3 != null) {
                    debug3.println("processSignature unsigned name = " + name);
                }
            }
        }
        updateSigners(newSigners, signers, JarFile.MANIFEST_NAME);
    }

    private boolean verifyManifestHash(Manifest sf, ManifestDigester md2, List<Object> manifestDigests) throws IOException, SignatureException {
        Attributes mattr = sf.getMainAttributes();
        boolean manifestSigned = false;
        for (Map.Entry<Object, Object> se : mattr.entrySet()) {
            String key = se.getKey().toString();
            if (key.toUpperCase(Locale.ENGLISH).endsWith("-DIGEST-MANIFEST")) {
                String algorithm = key.substring(0, key.length() - 16);
                manifestDigests.add(key);
                manifestDigests.add(se.getValue());
                MessageDigest digest = getDigest(algorithm);
                if (digest != null) {
                    byte[] computedHash = md2.manifestDigest(digest);
                    byte[] expectedHash = Base64.getMimeDecoder().decode((String) se.getValue());
                    Debug debug2 = debug;
                    if (debug2 != null) {
                        debug2.println("Signature File: Manifest digest " + digest.getAlgorithm());
                        debug2.println("  sigfile  " + toHex(expectedHash));
                        debug2.println("  computed " + toHex(computedHash));
                        debug2.println();
                    }
                    if (MessageDigest.isEqual(computedHash, expectedHash)) {
                        manifestSigned = true;
                    }
                }
            }
        }
        return manifestSigned;
    }

    private boolean verifyManifestMainAttrs(Manifest sf, ManifestDigester md2) throws IOException, SignatureException {
        Attributes mattr = sf.getMainAttributes();
        boolean attrsVerified = true;
        Iterator<Map.Entry<Object, Object>> iterator2 = mattr.entrySet().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            Map.Entry<Object, Object> se = iterator2.next();
            String key = se.getKey().toString();
            String upperCase = key.toUpperCase(Locale.ENGLISH);
            String str = ATTR_DIGEST;
            if (upperCase.endsWith(str)) {
                String algorithm = key.substring(0, key.length() - str.length());
                MessageDigest digest = getDigest(algorithm);
                if (digest != null) {
                    ManifestDigester.Entry mde = md2.get(ManifestDigester.MF_MAIN_ATTRS, false);
                    byte[] computedHash = mde.digest(digest);
                    byte[] expectedHash = Base64.getMimeDecoder().decode((String) se.getValue());
                    Debug debug2 = debug;
                    if (debug2 != null) {
                        debug2.println("Signature File: Manifest Main Attributes digest " + digest.getAlgorithm());
                        debug2.println("  sigfile  " + toHex(expectedHash));
                        debug2.println("  computed " + toHex(computedHash));
                        debug2.println();
                    }
                    if (!MessageDigest.isEqual(computedHash, expectedHash)) {
                        attrsVerified = false;
                        if (debug2 != null) {
                            debug2.println("Verification of Manifest main attributes failed");
                            debug2.println();
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        return attrsVerified;
    }

    private boolean verifySection(Attributes sfAttr, String name, ManifestDigester md2) throws IOException, SignatureException {
        byte[] computed;
        boolean oneDigestVerified = false;
        ManifestDigester.Entry mde = md2.get(name, this.block.isOldStyle());
        if (mde == null) {
            throw new SecurityException("no manifest section for signature file entry " + name);
        }
        if (sfAttr != null) {
            for (Map.Entry<Object, Object> se : sfAttr.entrySet()) {
                String key = se.getKey().toString();
                if (key.toUpperCase(Locale.ENGLISH).endsWith("-DIGEST")) {
                    String algorithm = key.substring(0, key.length() - 7);
                    MessageDigest digest = getDigest(algorithm);
                    if (digest != null) {
                        boolean ok = false;
                        byte[] expected = Base64.getMimeDecoder().decode((String) se.getValue());
                        if (this.workaround) {
                            computed = mde.digestWorkaround(digest);
                        } else {
                            computed = mde.digest(digest);
                        }
                        Debug debug2 = debug;
                        if (debug2 != null) {
                            debug2.println("Signature Block File: " + name + " digest=" + digest.getAlgorithm());
                            debug2.println("  expected " + toHex(expected));
                            debug2.println("  computed " + toHex(computed));
                            debug2.println();
                        }
                        if (MessageDigest.isEqual(computed, expected)) {
                            oneDigestVerified = true;
                            ok = true;
                        } else if (!this.workaround) {
                            byte[] computed2 = mde.digestWorkaround(digest);
                            if (MessageDigest.isEqual(computed2, expected)) {
                                if (debug2 != null) {
                                    debug2.println("  re-computed " + toHex(computed2));
                                    debug2.println();
                                }
                                this.workaround = true;
                                oneDigestVerified = true;
                                ok = true;
                            }
                        }
                        if (!ok) {
                            throw new SecurityException("invalid " + digest.getAlgorithm() + " signature file digest for " + name);
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return oneDigestVerified;
    }

    private CodeSigner[] getSigners(SignerInfo[] infos, PKCS7 block) throws IOException, NoSuchAlgorithmException, SignatureException, CertificateException {
        ArrayList<CodeSigner> signers = null;
        for (SignerInfo info : infos) {
            ArrayList<X509Certificate> chain = info.getCertificateChain(block);
            CertPath certChain = this.certificateFactory.generateCertPath(chain);
            if (signers == null) {
                signers = new ArrayList<>();
            }
            signers.add(new CodeSigner(certChain, info.getTimestamp()));
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("Signature Block Certificate: " + ((Object) chain.get(0)));
            }
        }
        if (signers != null) {
            return (CodeSigner[]) signers.toArray(new CodeSigner[signers.size()]);
        }
        return null;
    }

    static String toHex(byte[] data) {
        StringBuffer sb2 = new StringBuffer(data.length * 2);
        for (int i10 = 0; i10 < data.length; i10++) {
            char[] cArr = hexc;
            sb2.append(cArr[(data[i10] >> 4) & 15]);
            sb2.append(cArr[data[i10] & 15]);
        }
        return sb2.toString();
    }

    static boolean contains(CodeSigner[] set, CodeSigner signer) {
        for (CodeSigner codeSigner : set) {
            if (codeSigner.equals(signer)) {
                return true;
            }
        }
        return false;
    }

    static boolean isSubSet(CodeSigner[] subset, CodeSigner[] set) {
        if (set == subset) {
            return true;
        }
        for (CodeSigner codeSigner : subset) {
            if (!contains(set, codeSigner)) {
                return false;
            }
        }
        return true;
    }

    static boolean matches(CodeSigner[] signers, CodeSigner[] oldSigners, CodeSigner[] newSigners) {
        boolean found;
        if (oldSigners == null && signers == newSigners) {
            return true;
        }
        if ((oldSigners != null && !isSubSet(oldSigners, signers)) || !isSubSet(newSigners, signers)) {
            return false;
        }
        for (int i10 = 0; i10 < signers.length; i10++) {
            if ((oldSigners != null && contains(oldSigners, signers[i10])) || contains(newSigners, signers[i10])) {
                found = true;
            } else {
                found = false;
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    void updateSigners(CodeSigner[] newSigners, Hashtable<String, CodeSigner[]> signers, String name) {
        CodeSigner[] cachedSigners;
        CodeSigner[] cachedSigners2;
        CodeSigner[] oldSigners = signers.get(name);
        int i10 = this.signerCache.size();
        do {
            i10--;
            if (i10 != -1) {
                cachedSigners2 = this.signerCache.get(i10);
            } else {
                if (oldSigners == null) {
                    cachedSigners = newSigners;
                } else {
                    cachedSigners = new CodeSigner[oldSigners.length + newSigners.length];
                    System.arraycopy(oldSigners, 0, cachedSigners, 0, oldSigners.length);
                    System.arraycopy(newSigners, 0, cachedSigners, oldSigners.length, newSigners.length);
                }
                this.signerCache.add(cachedSigners);
                signers.put(name, cachedSigners);
                return;
            }
        } while (!matches(cachedSigners2, oldSigners, newSigners));
        signers.put(name, cachedSigners2);
    }
}
