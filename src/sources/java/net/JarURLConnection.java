package java.net;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import sun.net.www.ParseUtil;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class JarURLConnection extends URLConnection {
    private String entryName;
    private URL jarFileURL;
    protected URLConnection jarFileURLConnection;

    public abstract JarFile getJarFile() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public JarURLConnection(URL url) throws MalformedURLException {
        super(url);
        parseSpecs(url);
    }

    private void parseSpecs(URL url) throws MalformedURLException {
        String spec = url.getFile();
        int separator = spec.indexOf("!/");
        if (separator == -1) {
            throw new MalformedURLException("no !/ found in url spec:" + spec);
        }
        this.jarFileURL = new URL(spec.substring(0, separator));
        int separator2 = separator + 1 + 1;
        if (separator2 != spec.length()) {
            String substring = spec.substring(separator2, spec.length());
            this.entryName = substring;
            this.entryName = ParseUtil.decode(substring);
        }
    }

    public URL getJarFileURL() {
        return this.jarFileURL;
    }

    public String getEntryName() {
        return this.entryName;
    }

    public Manifest getManifest() throws IOException {
        return getJarFile().getManifest();
    }

    public JarEntry getJarEntry() throws IOException {
        if (this.entryName == null) {
            return null;
        }
        return getJarFile().getJarEntry(this.entryName);
    }

    public Attributes getAttributes() throws IOException {
        JarEntry e2 = getJarEntry();
        if (e2 != null) {
            return e2.getAttributes();
        }
        return null;
    }

    public Attributes getMainAttributes() throws IOException {
        Manifest man = getManifest();
        if (man != null) {
            return man.getMainAttributes();
        }
        return null;
    }

    public Certificate[] getCertificates() throws IOException {
        JarEntry e2 = getJarEntry();
        if (e2 != null) {
            return e2.getCertificates();
        }
        return null;
    }
}
