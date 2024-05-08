package java.security;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ProtectionDomain {
    public ProtectionDomain(CodeSource codesource, PermissionCollection permissions) {
    }

    public ProtectionDomain(CodeSource codesource, PermissionCollection permissions, ClassLoader classloader, Principal[] principals) {
    }

    public final CodeSource getCodeSource() {
        return null;
    }

    public final ClassLoader getClassLoader() {
        return null;
    }

    public final Principal[] getPrincipals() {
        return null;
    }

    public final PermissionCollection getPermissions() {
        return null;
    }

    public boolean implies(Permission permission) {
        return true;
    }
}
