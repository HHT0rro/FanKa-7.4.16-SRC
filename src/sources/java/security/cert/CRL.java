package java.security.cert;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class CRL {
    private String type;

    public abstract boolean isRevoked(Certificate certificate);

    public abstract String toString();

    /* JADX INFO: Access modifiers changed from: protected */
    public CRL(String type) {
        this.type = type;
    }

    public final String getType() {
        return this.type;
    }
}
