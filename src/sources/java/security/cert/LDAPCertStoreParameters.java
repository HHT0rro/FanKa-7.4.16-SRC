package java.security.cert;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LDAPCertStoreParameters implements CertStoreParameters {
    private static final int LDAP_DEFAULT_PORT = 389;
    private int port;
    private String serverName;

    public LDAPCertStoreParameters(String serverName, int port) {
        if (serverName == null) {
            throw new NullPointerException();
        }
        this.serverName = serverName;
        this.port = port;
    }

    public LDAPCertStoreParameters(String serverName) {
        this(serverName, 389);
    }

    public LDAPCertStoreParameters() {
        this("localhost", 389);
    }

    public String getServerName() {
        return this.serverName;
    }

    public int getPort() {
        return this.port;
    }

    @Override // java.security.cert.CertStoreParameters
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2.toString(), e2);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("LDAPCertStoreParameters: [\n");
        sb2.append("  serverName: " + this.serverName + "\n");
        sb2.append("  port: " + this.port + "\n");
        sb2.append("]");
        return sb2.toString();
    }
}
