package javax.security.auth.x500;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.security.auth.Destroyable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class X500PrivateCredential implements Destroyable {
    private String alias;
    private X509Certificate cert;
    private PrivateKey key;

    public X500PrivateCredential(X509Certificate cert, PrivateKey key) {
        if (cert == null || key == null) {
            throw new IllegalArgumentException();
        }
        this.cert = cert;
        this.key = key;
        this.alias = null;
    }

    public X500PrivateCredential(X509Certificate cert, PrivateKey key, String alias) {
        if (cert == null || key == null || alias == null) {
            throw new IllegalArgumentException();
        }
        this.cert = cert;
        this.key = key;
        this.alias = alias;
    }

    public X509Certificate getCertificate() {
        return this.cert;
    }

    public PrivateKey getPrivateKey() {
        return this.key;
    }

    public String getAlias() {
        return this.alias;
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        this.cert = null;
        this.key = null;
        this.alias = null;
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return this.cert == null && this.key == null && this.alias == null;
    }
}
