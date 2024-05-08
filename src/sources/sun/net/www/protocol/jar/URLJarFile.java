package sun.net.www.protocol.jar;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.security.AccessController;
import java.security.CodeSigner;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.cert.Certificate;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import sun.net.www.ParseUtil;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class URLJarFile extends JarFile {
    private static int BUF_SIZE = 2048;
    private URLJarFileCloseController closeController;
    private Attributes superAttr;
    private Map<String, Attributes> superEntries;
    private Manifest superMan;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface URLJarFileCloseController {
        void close(JarFile jarFile);
    }

    static JarFile getJarFile(URL url) throws IOException {
        return getJarFile(url, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JarFile getJarFile(URL url, URLJarFileCloseController closeController) throws IOException {
        if (isFileURL(url)) {
            return new URLJarFile(url, closeController);
        }
        return retrieve(url, closeController);
    }

    public URLJarFile(File file) throws IOException {
        this(file, (URLJarFileCloseController) null);
    }

    public URLJarFile(File file, URLJarFileCloseController closeController) throws IOException {
        super(file, true, 5);
        this.closeController = null;
        this.closeController = closeController;
    }

    private URLJarFile(URL url, URLJarFileCloseController closeController) throws IOException {
        super(ParseUtil.decode(url.getFile()));
        this.closeController = null;
        this.closeController = closeController;
    }

    private static boolean isFileURL(URL url) {
        if (url.getProtocol().equalsIgnoreCase("file")) {
            String host = url.getHost();
            if (host == null || host.equals("") || host.equals("~") || host.equalsIgnoreCase("localhost")) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // java.util.zip.ZipFile
    protected void finalize() throws IOException {
        close();
    }

    @Override // java.util.jar.JarFile, java.util.zip.ZipFile
    public ZipEntry getEntry(String name) {
        ZipEntry ze = super.getEntry(name);
        if (ze != null) {
            if (ze instanceof JarEntry) {
                return new URLJarFileEntry((JarEntry) ze);
            }
            throw new InternalError(((Object) super.getClass()) + " returned unexpected entry type " + ((Object) ze.getClass()));
        }
        return null;
    }

    @Override // java.util.jar.JarFile
    public Manifest getManifest() throws IOException {
        if (!isSuperMan()) {
            return null;
        }
        Manifest man = new Manifest();
        Attributes attr = man.getMainAttributes();
        attr.putAll((Map) this.superAttr.clone());
        if (this.superEntries != null) {
            Map<String, Attributes> entries = man.getEntries();
            for (String key : this.superEntries.h()) {
                Attributes at = this.superEntries.get(key);
                entries.put(key, (Attributes) at.clone());
            }
        }
        return man;
    }

    @Override // java.util.zip.ZipFile, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        URLJarFileCloseController uRLJarFileCloseController = this.closeController;
        if (uRLJarFileCloseController != null) {
            uRLJarFileCloseController.close(this);
        }
        super.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean isSuperMan() throws IOException {
        if (this.superMan == null) {
            this.superMan = super.getManifest();
        }
        Manifest manifest = this.superMan;
        if (manifest == null) {
            return false;
        }
        this.superAttr = manifest.getMainAttributes();
        this.superEntries = this.superMan.getEntries();
        return true;
    }

    private static JarFile retrieve(URL url) throws IOException {
        return retrieve(url, null);
    }

    private static JarFile retrieve(URL url, final URLJarFileCloseController closeController) throws IOException {
        try {
            final InputStream in = url.openConnection().getInputStream();
            try {
                JarFile result = (JarFile) AccessController.doPrivileged(new PrivilegedExceptionAction<JarFile>() { // from class: sun.net.www.protocol.jar.URLJarFile.1
                    @Override // java.security.PrivilegedExceptionAction
                    public JarFile run() throws IOException {
                        Path tmpFile = Files.createTempFile("jar_cache", null, new FileAttribute[0]);
                        try {
                            Files.copy(InputStream.this, tmpFile, StandardCopyOption.REPLACE_EXISTING);
                            JarFile jarFile = new URLJarFile(tmpFile.toFile(), closeController);
                            tmpFile.toFile().deleteOnExit();
                            return jarFile;
                        } catch (Throwable thr) {
                            try {
                                Files.delete(tmpFile);
                            } catch (IOException ioe) {
                                thr.addSuppressed(ioe);
                            }
                            throw thr;
                        }
                    }
                });
                if (in != null) {
                    in.close();
                }
                return result;
            } finally {
            }
        } catch (PrivilegedActionException pae) {
            throw ((IOException) pae.getException());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class URLJarFileEntry extends JarEntry {

        /* renamed from: je, reason: collision with root package name */
        private JarEntry f53712je;

        URLJarFileEntry(JarEntry je2) {
            super(je2);
            this.f53712je = je2;
        }

        @Override // java.util.jar.JarEntry
        public Attributes getAttributes() throws IOException {
            Map<String, Attributes> e2;
            Attributes a10;
            if (URLJarFile.this.isSuperMan() && (e2 = URLJarFile.this.superEntries) != null && (a10 = e2.get(getName())) != null) {
                return (Attributes) a10.clone();
            }
            return null;
        }

        @Override // java.util.jar.JarEntry
        public Certificate[] getCertificates() {
            Certificate[] certs = this.f53712je.getCertificates();
            if (certs == null) {
                return null;
            }
            return (Certificate[]) certs.clone();
        }

        @Override // java.util.jar.JarEntry
        public CodeSigner[] getCodeSigners() {
            CodeSigner[] csg = this.f53712je.getCodeSigners();
            if (csg == null) {
                return null;
            }
            return (CodeSigner[]) csg.clone();
        }
    }
}
