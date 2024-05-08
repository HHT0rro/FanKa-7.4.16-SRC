package javax.crypto;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import javax.crypto.CryptoPolicyParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class CryptoPermissions extends PermissionCollection implements Serializable {
    /* JADX INFO: Access modifiers changed from: package-private */
    public void load(InputStream in) throws IOException, CryptoPolicyParser.ParsingException {
    }

    boolean isEmpty() {
        return true;
    }

    @Override // java.security.PermissionCollection
    public void add(Permission permission) {
    }

    @Override // java.security.PermissionCollection
    public boolean implies(Permission permission) {
        return true;
    }

    @Override // java.security.PermissionCollection
    public Enumeration elements() {
        return null;
    }

    CryptoPermissions getMinimum(CryptoPermissions other) {
        return null;
    }

    PermissionCollection getPermissionCollection(String alg) {
        return null;
    }
}
