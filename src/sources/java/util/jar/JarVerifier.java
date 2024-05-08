package java.util.jar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.CodeSigner;
import java.security.CodeSource;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.zip.ZipEntry;
import jdk.internal.util.jar.JarIndex;
import sun.security.util.Debug;
import sun.security.util.ManifestDigester;
import sun.security.util.ManifestEntryVerifier;
import sun.security.util.SignatureFileVerifier;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class JarVerifier {
    static final Debug debug = Debug.getInstance("jar");
    boolean eagerValidation;
    private List<CodeSigner[]> jarCodeSigners;
    private URL lastURL;
    private Map<CodeSigner[], CodeSource> lastURLMap;
    private volatile ManifestDigester manDig;
    final String manifestName;
    byte[] manifestRawBytes;
    private ArrayList<CodeSigner[]> signerCache;
    private Map<String, CodeSigner[]> signerMap;
    private boolean parsingBlockOrSF = false;
    private boolean parsingMeta = true;
    private boolean anyToVerify = true;
    private Object csdomain = new Object();
    private Map<URL, Map<CodeSigner[], CodeSource>> urlToCodeSourceMap = new HashMap();
    private Map<CodeSigner[], CodeSource> signerToCodeSource = new HashMap();
    private CodeSigner[] emptySigner = new CodeSigner[0];
    private Enumeration<String> emptyEnumeration = new Enumeration<String>() { // from class: java.util.jar.JarVerifier.3
        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public String nextElement() {
            throw new NoSuchElementException();
        }
    };
    private Hashtable<String, CodeSigner[]> sigFileSigners = new Hashtable<>();
    private Hashtable<String, CodeSigner[]> verifiedSigners = new Hashtable<>();
    private Hashtable<String, byte[]> sigFileData = new Hashtable<>(11);
    private ArrayList<SignatureFileVerifier> pendingBlocks = new ArrayList<>();
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private List<Object> manifestDigests = new ArrayList();

    public JarVerifier(String name, byte[] rawBytes) {
        this.manifestRawBytes = null;
        this.manifestName = name;
        this.manifestRawBytes = rawBytes;
    }

    public void beginEntry(JarEntry je2, ManifestEntryVerifier mev) throws IOException {
        if (je2 == null) {
            return;
        }
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("beginEntry " + je2.getName());
        }
        String name = je2.getName();
        if (this.parsingMeta) {
            String uname = name.toUpperCase(Locale.ENGLISH);
            if (uname.startsWith("META-INF/") || uname.startsWith("/META-INF/")) {
                if (je2.isDirectory()) {
                    mev.setEntry(null, je2);
                    return;
                }
                if (uname.equals(JarFile.MANIFEST_NAME) || uname.equals(JarIndex.INDEX_NAME)) {
                    return;
                }
                if (SignatureFileVerifier.isBlockOrSF(uname)) {
                    this.parsingBlockOrSF = true;
                    this.baos.reset();
                    mev.setEntry(null, je2);
                    return;
                }
            }
        }
        if (this.parsingMeta) {
            doneWithMeta();
        }
        if (je2.isDirectory()) {
            mev.setEntry(null, je2);
            return;
        }
        if (name.startsWith("./")) {
            name = name.substring(2);
        }
        if (name.startsWith("/")) {
            name = name.substring(1);
        }
        if (this.sigFileSigners.get(name) != null || this.verifiedSigners.get(name) != null) {
            mev.setEntry(name, je2);
        } else {
            mev.setEntry(null, je2);
        }
    }

    public void update(int b4, ManifestEntryVerifier mev) throws IOException {
        if (b4 != -1) {
            if (this.parsingBlockOrSF) {
                this.baos.write(b4);
                return;
            } else {
                mev.update((byte) b4);
                return;
            }
        }
        processEntry(mev);
    }

    public void update(int n10, byte[] b4, int off, int len, ManifestEntryVerifier mev) throws IOException {
        if (n10 != -1) {
            if (this.parsingBlockOrSF) {
                this.baos.write(b4, off, n10);
                return;
            } else {
                mev.update(b4, off, n10);
                return;
            }
        }
        processEntry(mev);
    }

    private void processEntry(ManifestEntryVerifier mev) throws IOException {
        if (!this.parsingBlockOrSF) {
            JarEntry je2 = mev.getEntry();
            if (je2 != null && je2.signers == null) {
                je2.signers = mev.verify(this.verifiedSigners, this.sigFileSigners);
                je2.certs = mapSignersToCertArray(je2.signers);
                return;
            }
            return;
        }
        try {
            this.parsingBlockOrSF = false;
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("processEntry: processing block");
            }
            String uname = mev.getEntry().getName().toUpperCase(Locale.ENGLISH);
            if (uname.endsWith(".SF")) {
                String key = uname.substring(0, uname.length() - 3);
                byte[] bytes = this.baos.toByteArray();
                this.sigFileData.put(key, bytes);
                Iterator<SignatureFileVerifier> it = this.pendingBlocks.iterator2();
                while (it.hasNext()) {
                    SignatureFileVerifier sfv = it.next();
                    if (sfv.needSignatureFile(key)) {
                        Debug debug3 = debug;
                        if (debug3 != null) {
                            debug3.println("processEntry: processing pending block");
                        }
                        sfv.setSignatureFile(bytes);
                        sfv.process(this.sigFileSigners, this.manifestDigests);
                    }
                }
                return;
            }
            String key2 = uname.substring(0, uname.lastIndexOf("."));
            if (this.signerCache == null) {
                this.signerCache = new ArrayList<>();
            }
            if (this.manDig == null) {
                synchronized (this.manifestRawBytes) {
                    if (this.manDig == null) {
                        this.manDig = new ManifestDigester(this.manifestRawBytes);
                        this.manifestRawBytes = null;
                    }
                }
            }
            SignatureFileVerifier sfv2 = new SignatureFileVerifier(this.signerCache, this.manDig, uname, this.baos.toByteArray());
            if (sfv2.needSignatureFileBytes()) {
                byte[] bytes2 = this.sigFileData.get(key2);
                if (bytes2 == null) {
                    if (debug2 != null) {
                        debug2.println("adding pending block");
                    }
                    this.pendingBlocks.add(sfv2);
                    return;
                }
                sfv2.setSignatureFile(bytes2);
            }
            sfv2.process(this.sigFileSigners, this.manifestDigests);
        } catch (IOException ioe) {
            Debug debug4 = debug;
            if (debug4 != null) {
                debug4.println("processEntry caught: " + ((Object) ioe));
            }
        } catch (NoSuchAlgorithmException nsae) {
            Debug debug5 = debug;
            if (debug5 != null) {
                debug5.println("processEntry caught: " + ((Object) nsae));
            }
        } catch (SignatureException se) {
            Debug debug6 = debug;
            if (debug6 != null) {
                debug6.println("processEntry caught: " + ((Object) se));
            }
        } catch (CertificateException ce2) {
            Debug debug7 = debug;
            if (debug7 != null) {
                debug7.println("processEntry caught: " + ((Object) ce2));
            }
        }
    }

    @Deprecated
    public Certificate[] getCerts(String name) {
        return mapSignersToCertArray(getCodeSigners(name));
    }

    public Certificate[] getCerts(JarFile jar, JarEntry entry) {
        return mapSignersToCertArray(getCodeSigners(jar, entry));
    }

    public CodeSigner[] getCodeSigners(String name) {
        return this.verifiedSigners.get(name);
    }

    public CodeSigner[] getCodeSigners(JarFile jar, JarEntry entry) {
        String name = entry.getName();
        if (this.eagerValidation && this.sigFileSigners.get(name) != null) {
            try {
                InputStream s2 = jar.getInputStream(entry);
                byte[] buffer = new byte[1024];
                for (int n10 = buffer.length; n10 != -1; n10 = s2.read(buffer, 0, buffer.length)) {
                }
                s2.close();
            } catch (IOException e2) {
            }
        }
        return getCodeSigners(name);
    }

    private static Certificate[] mapSignersToCertArray(CodeSigner[] signers) {
        if (signers != null) {
            ArrayList<Certificate> certChains = new ArrayList<>();
            for (CodeSigner codeSigner : signers) {
                certChains.addAll(codeSigner.getSignerCertPath().getCertificates());
            }
            return (Certificate[]) certChains.toArray(new Certificate[certChains.size()]);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean nothingToVerify() {
        return !this.anyToVerify;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doneWithMeta() {
        this.parsingMeta = false;
        this.anyToVerify = !this.sigFileSigners.isEmpty();
        this.baos = null;
        this.sigFileData = null;
        this.pendingBlocks = null;
        this.signerCache = null;
        this.manDig = null;
        if (this.sigFileSigners.containsKey(JarFile.MANIFEST_NAME)) {
            CodeSigner[] codeSigners = this.sigFileSigners.remove(JarFile.MANIFEST_NAME);
            this.verifiedSigners.put(JarFile.MANIFEST_NAME, codeSigners);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class VerifierStream extends InputStream {
        private InputStream is;
        private JarVerifier jv;
        private ManifestEntryVerifier mev;
        private long numLeft;

        /* JADX INFO: Access modifiers changed from: package-private */
        public VerifierStream(Manifest man, JarEntry je2, InputStream is, JarVerifier jv) throws IOException {
            if (is == null) {
                throw new NullPointerException("is == null");
            }
            this.is = is;
            this.jv = jv;
            ManifestEntryVerifier manifestEntryVerifier = new ManifestEntryVerifier(man);
            this.mev = manifestEntryVerifier;
            this.jv.beginEntry(je2, manifestEntryVerifier);
            long size = je2.getSize();
            this.numLeft = size;
            if (size == 0) {
                this.jv.update(-1, this.mev);
            }
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            InputStream inputStream = this.is;
            if (inputStream == null) {
                throw new IOException("stream closed");
            }
            if (this.numLeft <= 0) {
                return -1;
            }
            int b4 = inputStream.read();
            this.jv.update(b4, this.mev);
            long j10 = this.numLeft - 1;
            this.numLeft = j10;
            if (j10 == 0) {
                this.jv.update(-1, this.mev);
            }
            return b4;
        }

        @Override // java.io.InputStream
        public int read(byte[] b4, int off, int len) throws IOException {
            InputStream inputStream = this.is;
            if (inputStream == null) {
                throw new IOException("stream closed");
            }
            long j10 = this.numLeft;
            if (j10 > 0 && j10 < len) {
                len = (int) j10;
            }
            if (j10 > 0) {
                int n10 = inputStream.read(b4, off, len);
                this.jv.update(n10, b4, off, len, this.mev);
                long j11 = this.numLeft - n10;
                this.numLeft = j11;
                if (j11 == 0) {
                    this.jv.update(-1, b4, off, len, this.mev);
                }
                return n10;
            }
            return -1;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            InputStream inputStream = this.is;
            if (inputStream != null) {
                inputStream.close();
            }
            this.is = null;
            this.mev = null;
            this.jv = null;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            InputStream inputStream = this.is;
            if (inputStream == null) {
                throw new IOException("stream closed");
            }
            return inputStream.available();
        }
    }

    private synchronized CodeSource mapSignersToCodeSource(URL url, CodeSigner[] signers) {
        Map<CodeSigner[], CodeSource> map;
        CodeSource cs;
        if (url == this.lastURL) {
            map = this.lastURLMap;
        } else {
            map = this.urlToCodeSourceMap.get(url);
            if (map == null) {
                map = new HashMap();
                this.urlToCodeSourceMap.put(url, map);
            }
            this.lastURLMap = map;
            this.lastURL = url;
        }
        cs = map.get(signers);
        if (cs == null) {
            cs = new VerifierCodeSource(this.csdomain, url, signers);
            this.signerToCodeSource.put(signers, cs);
        }
        return cs;
    }

    private CodeSource[] mapSignersToCodeSources(URL url, List<CodeSigner[]> signers, boolean unsigned) {
        List<CodeSource> sources = new ArrayList<>();
        for (int i10 = 0; i10 < signers.size(); i10++) {
            sources.add(mapSignersToCodeSource(url, signers.get(i10)));
        }
        if (unsigned) {
            sources.add(mapSignersToCodeSource(url, null));
        }
        return (CodeSource[]) sources.toArray(new CodeSource[sources.size()]);
    }

    private CodeSigner[] findMatchingSigners(CodeSource cs) {
        if (cs instanceof VerifierCodeSource) {
            VerifierCodeSource vcs = (VerifierCodeSource) cs;
            if (vcs.isSameDomain(this.csdomain)) {
                return ((VerifierCodeSource) cs).getPrivateSigners();
            }
        }
        CodeSource[] sources = mapSignersToCodeSources(cs.getLocation(), getJarCodeSigners(), true);
        List<CodeSource> sourceList = new ArrayList<>();
        for (CodeSource codeSource : sources) {
            sourceList.add(codeSource);
        }
        int j10 = sourceList.indexOf(cs);
        if (j10 != -1) {
            CodeSigner[] match = ((VerifierCodeSource) sourceList.get(j10)).getPrivateSigners();
            if (match == null) {
                return this.emptySigner;
            }
            return match;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class VerifierCodeSource extends CodeSource {
        private static final long serialVersionUID = -9047366145967768825L;
        Object csdomain;
        Certificate[] vcerts;
        URL vlocation;
        CodeSigner[] vsigners;

        VerifierCodeSource(Object csdomain, URL location, CodeSigner[] signers) {
            super(location, signers);
            this.csdomain = csdomain;
            this.vlocation = location;
            this.vsigners = signers;
        }

        VerifierCodeSource(Object csdomain, URL location, Certificate[] certs) {
            super(location, certs);
            this.csdomain = csdomain;
            this.vlocation = location;
            this.vcerts = certs;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof VerifierCodeSource) {
                VerifierCodeSource that = (VerifierCodeSource) obj;
                if (isSameDomain(that.csdomain)) {
                    if (that.vsigners != this.vsigners || that.vcerts != this.vcerts) {
                        return false;
                    }
                    URL url = that.vlocation;
                    if (url != null) {
                        return url.equals(this.vlocation);
                    }
                    URL url2 = this.vlocation;
                    if (url2 == null) {
                        return true;
                    }
                    return url2.equals(url);
                }
            }
            return super.equals(obj);
        }

        boolean isSameDomain(Object csdomain) {
            return this.csdomain == csdomain;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CodeSigner[] getPrivateSigners() {
            return this.vsigners;
        }

        private Certificate[] getPrivateCertificates() {
            return this.vcerts;
        }
    }

    private synchronized Map<String, CodeSigner[]> signerMap() {
        if (this.signerMap == null) {
            HashMap hashMap = new HashMap(this.verifiedSigners.size() + this.sigFileSigners.size());
            this.signerMap = hashMap;
            hashMap.putAll(this.verifiedSigners);
            this.signerMap.putAll(this.sigFileSigners);
        }
        return this.signerMap;
    }

    public synchronized Enumeration<String> entryNames(JarFile jar, CodeSource[] cs) {
        final Iterator<Map.Entry<String, CodeSigner[]>> itor;
        final List<CodeSigner[]> req;
        final Enumeration<String> enum2;
        Map<String, CodeSigner[]> map = signerMap();
        itor = map.entrySet().iterator2();
        boolean matchUnsigned = false;
        req = new ArrayList<>(cs.length);
        for (CodeSource codeSource : cs) {
            CodeSigner[] match = findMatchingSigners(codeSource);
            if (match != null) {
                if (match.length > 0) {
                    req.add(match);
                } else {
                    matchUnsigned = true;
                }
            } else {
                matchUnsigned = true;
            }
        }
        enum2 = matchUnsigned ? unsignedEntryNames(jar) : this.emptyEnumeration;
        return new Enumeration<String>() { // from class: java.util.jar.JarVerifier.1
            String name;

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                if (this.name != null) {
                    return true;
                }
                while (itor.hasNext()) {
                    Map.Entry<String, CodeSigner[]> e2 = (Map.Entry) itor.next();
                    if (req.contains(e2.getValue())) {
                        this.name = e2.getKey();
                        return true;
                    }
                }
                if (enum2.hasMoreElements()) {
                    this.name = (String) enum2.nextElement();
                    return true;
                }
                return false;
            }

            @Override // java.util.Enumeration
            public String nextElement() {
                if (hasMoreElements()) {
                    String value = this.name;
                    this.name = null;
                    return value;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public Enumeration<JarEntry> entries2(final JarFile jar, final Enumeration<? extends ZipEntry> e2) {
        final Map<String, CodeSigner[]> map = new HashMap<>();
        map.putAll(signerMap());
        return new Enumeration<JarEntry>() { // from class: java.util.jar.JarVerifier.2
            JarEntry entry;
            Enumeration<String> signers = null;

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                if (this.entry != null) {
                    return true;
                }
                while (e2.hasMoreElements()) {
                    ZipEntry ze = (ZipEntry) e2.nextElement();
                    if (!JarVerifier.isSigningRelated(ze.getName())) {
                        this.entry = jar.newEntry(ze);
                        return true;
                    }
                }
                if (this.signers == null) {
                    this.signers = Collections.enumeration(map.h());
                }
                if (this.signers.hasMoreElements()) {
                    String name = this.signers.nextElement();
                    this.entry = jar.newEntry(new ZipEntry(name));
                    return true;
                }
                return false;
            }

            @Override // java.util.Enumeration
            public JarEntry nextElement() {
                if (hasMoreElements()) {
                    JarEntry je2 = this.entry;
                    map.remove(je2.getName());
                    this.entry = null;
                    return je2;
                }
                throw new NoSuchElementException();
            }
        };
    }

    static boolean isSigningRelated(String name) {
        return SignatureFileVerifier.isSigningRelated(name);
    }

    private Enumeration<String> unsignedEntryNames(JarFile jar) {
        final Map<String, CodeSigner[]> map = signerMap();
        final Enumeration<JarEntry> entries = jar.entries();
        return new Enumeration<String>() { // from class: java.util.jar.JarVerifier.4
            String name;

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                if (this.name != null) {
                    return true;
                }
                while (entries.hasMoreElements()) {
                    ZipEntry e2 = (ZipEntry) entries.nextElement();
                    String value = e2.getName();
                    if (!e2.isDirectory() && !JarVerifier.isSigningRelated(value) && map.get(value) == null) {
                        this.name = value;
                        return true;
                    }
                }
                return false;
            }

            @Override // java.util.Enumeration
            public String nextElement() {
                if (hasMoreElements()) {
                    String value = this.name;
                    this.name = null;
                    return value;
                }
                throw new NoSuchElementException();
            }
        };
    }

    private synchronized List<CodeSigner[]> getJarCodeSigners() {
        if (this.jarCodeSigners == null) {
            HashSet<CodeSigner[]> set = new HashSet<>();
            set.addAll(signerMap().values());
            ArrayList arrayList = new ArrayList();
            this.jarCodeSigners = arrayList;
            arrayList.addAll(set);
        }
        return this.jarCodeSigners;
    }

    public synchronized CodeSource[] getCodeSources(JarFile jar, URL url) {
        boolean hasUnsigned;
        hasUnsigned = unsignedEntryNames(jar).hasMoreElements();
        return mapSignersToCodeSources(url, getJarCodeSigners(), hasUnsigned);
    }

    public CodeSource getCodeSource(URL url, String name) {
        CodeSigner[] signers = signerMap().get(name);
        return mapSignersToCodeSource(url, signers);
    }

    public CodeSource getCodeSource(URL url, JarFile jar, JarEntry je2) {
        return mapSignersToCodeSource(url, getCodeSigners(jar, je2));
    }

    public void setEagerValidation(boolean eager) {
        this.eagerValidation = eager;
    }

    public synchronized List<Object> getManifestDigests() {
        return Collections.unmodifiableList(this.manifestDigests);
    }

    static CodeSource getUnsignedCS(URL url) {
        return new VerifierCodeSource((Object) null, url, (Certificate[]) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isTrustedManifestEntry(String name) {
        CodeSigner[] forMan = this.verifiedSigners.get(this.manifestName);
        if (forMan == null) {
            return true;
        }
        CodeSigner[] forName = this.sigFileSigners.get(name);
        if (forName == null) {
            forName = this.verifiedSigners.get(name);
        }
        return forName != null && forName.length == forMan.length;
    }
}
