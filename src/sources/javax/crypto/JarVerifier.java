package javax.crypto;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.cert.Certificate;
import java.util.jar.JarEntry;
import java.util.jar.JarException;
import java.util.jar.JarFile;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class JarVerifier {
    private CryptoPermissions appPerms = null;
    private URL jarURL;
    private boolean savePerms;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JarVerifier(URL jarURL, boolean savePerms) {
        this.jarURL = jarURL;
        this.savePerms = savePerms;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void verify() throws JarException, IOException {
        if (!this.savePerms) {
            return;
        }
        final URL url = this.jarURL.getProtocol().equalsIgnoreCase("jar") ? this.jarURL : new URL("jar:" + this.jarURL.toString() + "!/");
        JarFile jf = null;
        try {
            try {
                jf = (JarFile) AccessController.doPrivileged(new PrivilegedExceptionAction<JarFile>() { // from class: javax.crypto.JarVerifier.1
                    @Override // java.security.PrivilegedExceptionAction
                    public JarFile run() throws Exception {
                        JarURLConnection conn = (JarURLConnection) url.openConnection();
                        conn.setUseCaches(false);
                        return conn.getJarFile();
                    }
                });
                if (jf != null) {
                    JarEntry je2 = jf.getJarEntry("cryptoPerms");
                    if (je2 == null) {
                        throw new JarException("Can not find cryptoPerms");
                    }
                    try {
                        CryptoPermissions cryptoPermissions = new CryptoPermissions();
                        this.appPerms = cryptoPermissions;
                        cryptoPermissions.load(jf.getInputStream(je2));
                    } catch (Exception ex) {
                        JarException jex = new JarException("Cannot load/parse" + this.jarURL.toString());
                        jex.initCause(ex);
                        throw jex;
                    }
                }
            } catch (PrivilegedActionException pae) {
                throw new SecurityException("Cannot load " + url.toString(), pae);
            }
        } finally {
            if (jf != null) {
                jf.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void verifyPolicySigned(Certificate[] certs) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CryptoPermissions getPermissions() {
        return this.appPerms;
    }
}
