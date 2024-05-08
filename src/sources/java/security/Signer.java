package java.security;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@Deprecated(forRemoval = true, since = "1.2")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Signer extends Identity {
    private static final long serialVersionUID = -1763464102261361480L;
    private PrivateKey privateKey;

    protected Signer() {
    }

    public Signer(String name) {
        super(name);
    }

    public Signer(String name, IdentityScope scope) throws KeyManagementException {
        super(name, scope);
    }

    public PrivateKey getPrivateKey() {
        check("getSignerPrivateKey");
        return this.privateKey;
    }

    public final void setKeyPair(KeyPair pair) throws InvalidParameterException, KeyException {
        check("setSignerKeyPair");
        final PublicKey pub = pair.getPublic();
        PrivateKey priv = pair.getPrivate();
        if (pub == null || priv == null) {
            throw new InvalidParameterException();
        }
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() { // from class: java.security.Signer.1
                @Override // java.security.PrivilegedExceptionAction
                public Void run() throws KeyManagementException {
                    Signer.this.setPublicKey(pub);
                    return null;
                }
            });
            this.privateKey = priv;
        } catch (PrivilegedActionException pae) {
            throw ((KeyManagementException) pae.getException());
        }
    }

    @Override // java.security.Identity
    String printKeys() {
        PublicKey publicKey = getPublicKey();
        if (publicKey != null && this.privateKey != null) {
            return "\tpublic and private keys initialized";
        }
        return "\tno keys";
    }

    @Override // java.security.Identity, java.security.Principal
    public String toString() {
        return "[Signer]" + super.toString();
    }

    private static void check(String directive) {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkSecurityAccess(directive);
        }
    }
}
