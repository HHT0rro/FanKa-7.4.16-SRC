package java.util.jar;

import com.android.internal.logging.nano.MetricsProto;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.CodeSigner;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.Spliterators;
import java.util.jar.JarVerifier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import sun.misc.IOUtils;
import sun.security.util.ManifestEntryVerifier;
import sun.security.util.SignatureFileVerifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class JarFile extends ZipFile {
    private static final int[] CLASSPATH_LASTOCC;
    public static final String MANIFEST_NAME = "META-INF/MANIFEST.MF";
    private volatile boolean hasCheckedSpecialAttributes;
    private boolean hasClassPathAttribute;
    private JarVerifier jv;
    private boolean jvInitialized;
    private JarEntry manEntry;
    private Manifest manifest;
    private boolean verify;
    private static final char[] CLASSPATH_CHARS = {'c', 'l', 'a', 's', 's', '-', 'p', 'a', 't', 'h'};
    private static final int[] CLASSPATH_OPTOSFT = new int[10];

    private native String[] getMetaInfEntryNames();

    public JarFile(String name) throws IOException {
        this(new File(name), true, 1);
    }

    public JarFile(String name, boolean verify) throws IOException {
        this(new File(name), verify, 1);
    }

    public JarFile(File file) throws IOException {
        this(file, true, 1);
    }

    public JarFile(File file, boolean verify) throws IOException {
        this(file, verify, 1);
    }

    public JarFile(File file, boolean verify, int mode) throws IOException {
        this(file, true, verify, mode);
    }

    public JarFile(String name, boolean enableZipPathValidator, boolean verify) throws IOException {
        this(new File(name), enableZipPathValidator, verify, 1);
    }

    public JarFile(File file, boolean enableZipPathValidator, boolean verify, int mode) throws IOException {
        super(file, mode, enableZipPathValidator);
        this.verify = verify;
    }

    public Manifest getManifest() throws IOException {
        return getManifestFromReference();
    }

    private synchronized Manifest getManifestFromReference() throws IOException {
        Manifest man;
        JarEntry manEntry;
        man = this.manifest;
        if (man == null && (manEntry = getManEntry()) != null) {
            if (this.verify) {
                byte[] b4 = getBytes(manEntry);
                man = new Manifest(new ByteArrayInputStream(b4));
                if (!this.jvInitialized) {
                    this.jv = new JarVerifier(manEntry.getName(), b4);
                }
            } else {
                man = new Manifest(super.getInputStream(manEntry));
            }
            this.manifest = man;
        }
        return man;
    }

    public JarEntry getJarEntry(String name) {
        return (JarEntry) getEntry(name);
    }

    @Override // java.util.zip.ZipFile
    public ZipEntry getEntry(String name) {
        ZipEntry ze = super.getEntry(name);
        if (ze != null) {
            return new JarFileEntry(ze);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class JarEntryIterator implements Enumeration<JarEntry>, Iterator<JarEntry> {

        /* renamed from: e, reason: collision with root package name */
        final Enumeration<? extends ZipEntry> f50502e;

        private JarEntryIterator() {
            this.f50502e = JarFile.super.entries();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f50502e.hasMoreElements();
        }

        @Override // java.util.Iterator
        public JarEntry next() {
            ZipEntry ze = this.f50502e.nextElement();
            return new JarFileEntry(ze);
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return hasNext();
        }

        @Override // java.util.Enumeration
        public JarEntry nextElement() {
            return next();
        }
    }

    @Override // java.util.zip.ZipFile
    public Enumeration<JarEntry> entries() {
        return new JarEntryIterator();
    }

    @Override // java.util.zip.ZipFile
    public Stream<JarEntry> stream() {
        return StreamSupport.stream(Spliterators.spliterator(new JarEntryIterator(), size(), MetricsProto.MetricsEvent.ACTION_OUTPUT_CHOOSER_DISCONNECT), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class JarFileEntry extends JarEntry {
        JarFileEntry(ZipEntry ze) {
            super(ze);
        }

        @Override // java.util.jar.JarEntry
        public Attributes getAttributes() throws IOException {
            Manifest man = JarFile.this.getManifest();
            if (man != null) {
                return man.getAttributes(getName());
            }
            return null;
        }

        @Override // java.util.jar.JarEntry
        public Certificate[] getCertificates() {
            try {
                JarFile.this.maybeInstantiateVerifier();
                if (this.certs == null && JarFile.this.jv != null) {
                    this.certs = JarFile.this.jv.getCerts(JarFile.this, this);
                }
                if (this.certs == null) {
                    return null;
                }
                return (Certificate[]) this.certs.clone();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // java.util.jar.JarEntry
        public CodeSigner[] getCodeSigners() {
            try {
                JarFile.this.maybeInstantiateVerifier();
                if (this.signers == null && JarFile.this.jv != null) {
                    this.signers = JarFile.this.jv.getCodeSigners(JarFile.this, this);
                }
                if (this.signers == null) {
                    return null;
                }
                return (CodeSigner[]) this.signers.clone();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeInstantiateVerifier() throws IOException {
        if (this.jv == null && this.verify) {
            String[] names = getMetaInfEntryNames();
            if (names != null) {
                for (String str : names) {
                    String name = str.toUpperCase(Locale.ENGLISH);
                    if (name.endsWith(".DSA") || name.endsWith(".RSA") || name.endsWith(".EC") || name.endsWith(".SF")) {
                        getManifest();
                        return;
                    }
                }
            }
            this.verify = false;
        }
    }

    private void initializeVerifier() {
        ManifestEntryVerifier mev = null;
        try {
            String[] names = getMetaInfEntryNames();
            if (names != null) {
                for (int i10 = 0; i10 < names.length; i10++) {
                    String uname = names[i10].toUpperCase(Locale.ENGLISH);
                    if (MANIFEST_NAME.equals(uname) || SignatureFileVerifier.isBlockOrSF(uname)) {
                        JarEntry e2 = getJarEntry(names[i10]);
                        if (e2 == null) {
                            throw new JarException("corrupted jar file");
                        }
                        if (mev == null) {
                            mev = new ManifestEntryVerifier(getManifestFromReference());
                        }
                        byte[] b4 = getBytes(e2);
                        if (b4 != null && b4.length > 0) {
                            this.jv.beginEntry(e2, mev);
                            this.jv.update(b4.length, b4, 0, b4.length, mev);
                            this.jv.update(-1, null, 0, 0, mev);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            this.jv = null;
            this.verify = false;
            if (JarVerifier.debug != null) {
                JarVerifier.debug.println("jarfile parsing error!");
                ex.printStackTrace();
            }
        }
        JarVerifier jarVerifier = this.jv;
        if (jarVerifier != null) {
            jarVerifier.doneWithMeta();
            if (JarVerifier.debug != null) {
                JarVerifier.debug.println("done with meta!");
            }
            if (this.jv.nothingToVerify()) {
                if (JarVerifier.debug != null) {
                    JarVerifier.debug.println("nothing to verify!");
                }
                this.jv = null;
                this.verify = false;
            }
        }
    }

    private byte[] getBytes(ZipEntry ze) throws IOException {
        InputStream is = super.getInputStream(ze);
        try {
            byte[] readFully = IOUtils.readFully(is, (int) ze.getSize(), true);
            if (is != null) {
                is.close();
            }
            return readFully;
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.util.zip.ZipFile
    public synchronized InputStream getInputStream(ZipEntry ze) throws IOException {
        maybeInstantiateVerifier();
        if (this.jv == null) {
            return super.getInputStream(ze);
        }
        if (!this.jvInitialized) {
            initializeVerifier();
            this.jvInitialized = true;
            if (this.jv == null) {
                return super.getInputStream(ze);
            }
        }
        return new JarVerifier.VerifierStream(getManifestFromReference(), ze instanceof JarFileEntry ? (JarEntry) ze : getJarEntry(ze.getName()), super.getInputStream(ze), this.jv);
    }

    static {
        int[] iArr = new int[128];
        CLASSPATH_LASTOCC = iArr;
        iArr[99] = 1;
        iArr[108] = 2;
        iArr[115] = 5;
        iArr[45] = 6;
        iArr[112] = 7;
        iArr[97] = 8;
        iArr[116] = 9;
        iArr[104] = 10;
        for (int i10 = 0; i10 < 9; i10++) {
            CLASSPATH_OPTOSFT[i10] = 10;
        }
        CLASSPATH_OPTOSFT[9] = 1;
    }

    private synchronized JarEntry getManEntry() {
        String[] names;
        if (this.manEntry == null) {
            JarEntry jarEntry = getJarEntry(MANIFEST_NAME);
            this.manEntry = jarEntry;
            if (jarEntry == null && (names = getMetaInfEntryNames()) != null) {
                int i10 = 0;
                while (true) {
                    if (i10 >= names.length) {
                        break;
                    }
                    if (!MANIFEST_NAME.equals(names[i10].toUpperCase(Locale.ENGLISH))) {
                        i10++;
                    } else {
                        this.manEntry = getJarEntry(names[i10]);
                        break;
                    }
                }
            }
        }
        return this.manEntry;
    }

    public boolean hasClassPathAttribute() throws IOException {
        checkForSpecialAttributes();
        return this.hasClassPathAttribute;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        r2 = r2 + java.lang.Math.max((r3 + 1) - r10[r4 & 127], r11[r3]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean match(char[] r8, byte[] r9, int[] r10, int[] r11) {
        /*
            r7 = this;
            int r0 = r8.length
            int r1 = r9.length
            int r1 = r1 - r0
            r2 = 0
        L4:
            if (r2 > r1) goto L34
            int r3 = r0 + (-1)
        L8:
            if (r3 < 0) goto L32
            int r4 = r2 + r3
            r4 = r9[r4]
            char r4 = (char) r4
            int r5 = r4 + (-65)
            int r6 = 90 - r4
            r5 = r5 | r6
            if (r5 < 0) goto L1a
            int r5 = r4 + 32
            char r5 = (char) r5
            goto L1b
        L1a:
            r5 = r4
        L1b:
            r4 = r5
            char r5 = r8[r3]
            if (r4 == r5) goto L2f
            int r5 = r3 + 1
            r6 = r4 & 127(0x7f, float:1.78E-43)
            r6 = r10[r6]
            int r5 = r5 - r6
            r6 = r11[r3]
            int r5 = java.lang.Math.max(r5, r6)
            int r2 = r2 + r5
            goto L4
        L2f:
            int r3 = r3 + (-1)
            goto L8
        L32:
            r3 = 1
            return r3
        L34:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.jar.JarFile.match(char[], byte[], int[], int[]):boolean");
    }

    private void checkForSpecialAttributes() throws IOException {
        if (this.hasCheckedSpecialAttributes) {
            return;
        }
        JarEntry manEntry = getManEntry();
        if (manEntry != null) {
            byte[] b4 = getBytes(manEntry);
            if (match(CLASSPATH_CHARS, b4, CLASSPATH_LASTOCC, CLASSPATH_OPTOSFT)) {
                this.hasClassPathAttribute = true;
            }
        }
        this.hasCheckedSpecialAttributes = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JarEntry newEntry(ZipEntry ze) {
        return new JarFileEntry(ze);
    }
}
