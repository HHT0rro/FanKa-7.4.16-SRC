package java.security;

import java.util.Enumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@Deprecated(forRemoval = true, since = "1.2")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class IdentityScope extends Identity {
    private static IdentityScope scope = null;
    private static final long serialVersionUID = -2337346281189773310L;

    public abstract void addIdentity(Identity identity) throws KeyManagementException;

    public abstract Identity getIdentity(String str);

    public abstract Identity getIdentity(PublicKey publicKey);

    public abstract Enumeration<Identity> identities();

    public abstract void removeIdentity(Identity identity) throws KeyManagementException;

    public abstract int size();

    private static void initializeSystemScope() {
        String classname = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: java.security.IdentityScope.1
            @Override // java.security.PrivilegedAction
            public String run() {
                return Security.getProperty("system.scope");
            }
        });
        if (classname == null) {
            return;
        }
        try {
            scope = (IdentityScope) Class.forName(classname).newInstance();
        } catch (Exception e2) {
            System.err.println("unable to establish a system scope from " + classname);
            e2.printStackTrace();
        }
    }

    protected IdentityScope() {
        this("restoring...");
    }

    public IdentityScope(String name) {
        super(name);
    }

    public IdentityScope(String name, IdentityScope scope2) throws KeyManagementException {
        super(name, scope2);
    }

    public static IdentityScope getSystemScope() {
        if (scope == null) {
            initializeSystemScope();
        }
        return scope;
    }

    protected static void setSystemScope(IdentityScope scope2) {
        check("setSystemScope");
        scope = scope2;
    }

    public Identity getIdentity(Principal principal) {
        return getIdentity(principal.getName());
    }

    @Override // java.security.Identity, java.security.Principal
    public String toString() {
        return super.toString() + "[" + size() + "]";
    }

    private static void check(String directive) {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkSecurityAccess(directive);
        }
    }
}
