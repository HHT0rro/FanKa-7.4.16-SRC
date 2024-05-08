package java.security.cert;

import java.net.URI;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class URICertStoreParameters implements CertStoreParameters {
    private int myhash = -1;
    private final URI uri;

    public URICertStoreParameters(URI uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        this.uri = uri;
    }

    public URI getURI() {
        return this.uri;
    }

    @Override // java.security.cert.CertStoreParameters
    public URICertStoreParameters clone() {
        try {
            return new URICertStoreParameters(this.uri);
        } catch (NullPointerException e2) {
            throw new InternalError(e2.toString(), e2);
        }
    }

    public int hashCode() {
        if (this.myhash == -1) {
            this.myhash = this.uri.hashCode() * 7;
        }
        return this.myhash;
    }

    public boolean equals(Object p10) {
        if (p10 == null || !(p10 instanceof URICertStoreParameters)) {
            return false;
        }
        if (p10 == this) {
            return true;
        }
        URICertStoreParameters other = (URICertStoreParameters) p10;
        return this.uri.equals(other.getURI());
    }

    public String toString() {
        return "URICertStoreParameters: " + this.uri.toString();
    }
}
