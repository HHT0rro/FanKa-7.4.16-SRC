package java.security;

import java.io.Serializable;
import java.net.URL;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CodeSource implements Serializable {
    private final URL location;

    public CodeSource(URL url, java.security.cert.Certificate[] certs) {
        this.location = url;
    }

    public CodeSource(URL url, CodeSigner[] signers) {
        this.location = url;
    }

    public final URL getLocation() {
        return this.location;
    }

    public final java.security.cert.Certificate[] getCertificates() {
        return null;
    }

    public final CodeSigner[] getCodeSigners() {
        return null;
    }

    public boolean implies(CodeSource codesource) {
        return true;
    }
}
