package javax.security.auth;

import java.security.Permission;
import java.security.Principal;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class PrivateCredentialPermission extends Permission {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PrivateCredentialPermission(String credentialClass, Set<Principal> principals) {
        super("");
    }

    public PrivateCredentialPermission(String name, String actions) {
        super("");
    }

    public String getCredentialClass() {
        return null;
    }

    public String[][] getPrincipals() {
        return null;
    }

    @Override // java.security.Permission
    public boolean implies(Permission p10) {
        return true;
    }

    @Override // java.security.Permission
    public String getActions() {
        return null;
    }
}
