package java.util.jar;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import jdk.internal.util.jar.JarIndex;
import sun.security.util.ManifestEntryVerifier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class JarInputStream extends ZipInputStream {
    private final boolean doVerify;
    private JarEntry first;
    private JarVerifier jv;
    private Manifest man;
    private ManifestEntryVerifier mev;
    private boolean tryManifest;

    public JarInputStream(InputStream in) throws IOException {
        this(in, true);
    }

    public JarInputStream(InputStream in, boolean verify) throws IOException {
        super(in);
        this.doVerify = verify;
        JarEntry e2 = (JarEntry) super.getNextEntry();
        if (e2 != null && e2.getName().equalsIgnoreCase("META-INF/")) {
            e2 = (JarEntry) super.getNextEntry();
        }
        this.first = checkManifest(e2);
    }

    private JarEntry checkManifest(JarEntry e2) throws IOException {
        if (e2 != null && JarFile.MANIFEST_NAME.equalsIgnoreCase(e2.getName())) {
            this.man = new Manifest();
            byte[] bytes = getBytes(new BufferedInputStream(this));
            this.man.read(new ByteArrayInputStream(bytes));
            closeEntry();
            if (this.doVerify) {
                this.jv = new JarVerifier(e2.getName(), bytes);
                this.mev = new ManifestEntryVerifier(this.man);
            }
            return (JarEntry) super.getNextEntry();
        }
        return e2;
    }

    private byte[] getBytes(InputStream is) throws IOException {
        byte[] buffer = new byte[8192];
        ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
        while (true) {
            int n10 = is.read(buffer, 0, buffer.length);
            if (n10 != -1) {
                baos.write(buffer, 0, n10);
            } else {
                return baos.toByteArray();
            }
        }
    }

    public Manifest getManifest() {
        return this.man;
    }

    @Override // java.util.zip.ZipInputStream
    public ZipEntry getNextEntry() throws IOException {
        JarEntry e2;
        JarEntry jarEntry = this.first;
        if (jarEntry == null) {
            e2 = (JarEntry) super.getNextEntry();
            if (this.tryManifest) {
                e2 = checkManifest(e2);
                this.tryManifest = false;
            }
        } else {
            JarEntry e10 = this.first;
            if (jarEntry.getName().equalsIgnoreCase(JarIndex.INDEX_NAME)) {
                this.tryManifest = true;
            }
            this.first = null;
            e2 = e10;
        }
        JarVerifier jarVerifier = this.jv;
        if (jarVerifier != null && e2 != null) {
            if (jarVerifier.nothingToVerify()) {
                this.jv = null;
                this.mev = null;
            } else {
                this.jv.beginEntry(e2, this.mev);
            }
        }
        return e2;
    }

    public JarEntry getNextJarEntry() throws IOException {
        return (JarEntry) getNextEntry();
    }

    @Override // java.util.zip.ZipInputStream, java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] b4, int off, int len) throws IOException {
        int n10;
        if (this.first == null) {
            n10 = super.read(b4, off, len);
        } else {
            n10 = -1;
        }
        JarVerifier jarVerifier = this.jv;
        if (jarVerifier != null) {
            jarVerifier.update(n10, b4, off, len, this.mev);
        }
        return n10;
    }

    @Override // java.util.zip.ZipInputStream
    protected ZipEntry createZipEntry(String name) {
        JarEntry e2 = new JarEntry(name);
        Manifest manifest = this.man;
        if (manifest != null) {
            e2.attr = manifest.getAttributes(name);
        }
        return e2;
    }
}
