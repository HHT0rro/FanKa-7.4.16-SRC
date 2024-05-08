package sun.security.util;

import java.io.File;
import java.io.FileInputStream;
import java.security.AccessController;
import java.security.KeyStore;
import java.security.PrivilegedAction;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import sun.security.x509.X509CertImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class AnchorCertificates {
    private static final String HASH = "SHA-256";
    private static final Debug debug = Debug.getInstance("certpath");
    private static Set<String> certs = Collections.emptySet();
    private static Set<X500Principal> certIssuers = Collections.emptySet();

    static {
        AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: sun.security.util.AnchorCertificates.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                X509Certificate cert;
                String fp;
                File f10 = new File(FilePaths.cacerts());
                try {
                    KeyStore cacerts = KeyStore.getInstance("JKS");
                    FileInputStream fis = new FileInputStream(f10);
                    try {
                        cacerts.load(fis, null);
                        AnchorCertificates.certs = new HashSet();
                        AnchorCertificates.certIssuers = new HashSet();
                        Enumeration<String> list = cacerts.aliases();
                        while (list.hasMoreElements()) {
                            String alias = list.nextElement();
                            if (alias.contains(" [jdk") && (fp = X509CertImpl.getFingerprint(AnchorCertificates.HASH, (cert = (X509Certificate) cacerts.getCertificate(alias)), AnchorCertificates.debug)) != null) {
                                AnchorCertificates.certs.add(fp);
                                AnchorCertificates.certIssuers.add(cert.getSubjectX500Principal());
                            }
                        }
                        fis.close();
                    } finally {
                    }
                } catch (Exception e2) {
                    if (AnchorCertificates.debug != null) {
                        AnchorCertificates.debug.println("Error parsing cacerts");
                        e2.printStackTrace();
                    }
                }
                return null;
            }
        });
    }

    public static boolean contains(X509Certificate cert) {
        Debug debug2 = debug;
        String key = X509CertImpl.getFingerprint(HASH, cert, debug2);
        boolean result = key == null ? false : certs.contains(key);
        if (result && debug2 != null) {
            debug2.println("AnchorCertificate.contains: matched " + ((Object) cert.getSubjectX500Principal()));
        }
        return result;
    }

    private AnchorCertificates() {
    }
}
