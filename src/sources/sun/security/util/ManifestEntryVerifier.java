package sun.security.util;

import java.io.IOException;
import java.security.CodeSigner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarException;
import java.util.jar.Manifest;
import sun.security.jca.Providers;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ManifestEntryVerifier {
    private static final Debug debug = Debug.getInstance("jar");
    private static final char[] hexc = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private JarEntry entry;
    private Manifest man;
    private String name = null;
    private boolean skip = true;
    private CodeSigner[] signers = null;
    HashMap<String, MessageDigest> createdDigests = new HashMap<>(11);
    ArrayList<MessageDigest> digests = new ArrayList<>();
    ArrayList<byte[]> manifestHashes = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SunProviderHolder {
        private static final Provider instance = Providers.getSunProvider();

        private SunProviderHolder() {
        }
    }

    public ManifestEntryVerifier(Manifest man) {
        this.man = man;
    }

    public void setEntry(String name, JarEntry entry) throws IOException {
        this.digests.clear();
        this.manifestHashes.clear();
        this.name = name;
        this.entry = entry;
        this.skip = true;
        this.signers = null;
        Manifest manifest = this.man;
        if (manifest == null || name == null) {
            return;
        }
        Attributes attr = manifest.getAttributes(name);
        if (attr == null && (attr = this.man.getAttributes("./" + name)) == null && (attr = this.man.getAttributes("/" + name)) == null) {
            return;
        }
        for (Map.Entry<Object, Object> se : attr.entrySet()) {
            String key = se.getKey().toString();
            if (key.toUpperCase(Locale.ENGLISH).endsWith("-DIGEST")) {
                String algorithm = key.substring(0, key.length() - 7);
                MessageDigest digest = this.createdDigests.get(algorithm);
                if (digest == null) {
                    try {
                        digest = MessageDigest.getInstance(algorithm, SunProviderHolder.instance);
                        this.createdDigests.put(algorithm, digest);
                    } catch (NoSuchAlgorithmException e2) {
                    }
                }
                if (digest != null) {
                    this.skip = false;
                    digest.reset();
                    this.digests.add(digest);
                    this.manifestHashes.add(Base64.getMimeDecoder().decode((String) se.getValue()));
                }
            }
        }
    }

    public void update(byte buffer) {
        if (this.skip) {
            return;
        }
        for (int i10 = 0; i10 < this.digests.size(); i10++) {
            this.digests.get(i10).update(buffer);
        }
    }

    public void update(byte[] buffer, int off, int len) {
        if (this.skip) {
            return;
        }
        for (int i10 = 0; i10 < this.digests.size(); i10++) {
            this.digests.get(i10).update(buffer, off, len);
        }
    }

    public JarEntry getEntry() {
        return this.entry;
    }

    public CodeSigner[] verify(Hashtable<String, CodeSigner[]> verifiedSigners, Hashtable<String, CodeSigner[]> sigFileSigners) throws JarException {
        if (this.skip) {
            return null;
        }
        CodeSigner[] codeSignerArr = this.signers;
        if (codeSignerArr != null) {
            return codeSignerArr;
        }
        for (int i10 = 0; i10 < this.digests.size(); i10++) {
            MessageDigest digest = this.digests.get(i10);
            byte[] manHash = this.manifestHashes.get(i10);
            byte[] theHash = digest.digest();
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("Manifest Entry: " + this.name + " digest=" + digest.getAlgorithm());
                debug2.println("  manifest " + toHex(manHash));
                debug2.println("  computed " + toHex(theHash));
                debug2.println();
            }
            if (!MessageDigest.isEqual(theHash, manHash)) {
                throw new SecurityException(digest.getAlgorithm() + " digest error for " + this.name);
            }
        }
        CodeSigner[] remove = sigFileSigners.remove(this.name);
        this.signers = remove;
        if (remove != null) {
            verifiedSigners.put(this.name, remove);
        }
        return this.signers;
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
}
