package javax.net.ssl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class SNIMatcher {
    private final int type;

    public abstract boolean matches(SNIServerName sNIServerName);

    /* JADX INFO: Access modifiers changed from: protected */
    public SNIMatcher(int type) {
        if (type < 0) {
            throw new IllegalArgumentException("Server name type cannot be less than zero");
        }
        if (type > 255) {
            throw new IllegalArgumentException("Server name type cannot be greater than 255");
        }
        this.type = type;
    }

    public final int getType() {
        return this.type;
    }
}
