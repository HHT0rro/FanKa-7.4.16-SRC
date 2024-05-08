package java.security;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class UnresolvedPermission extends Permission implements Serializable {
    public UnresolvedPermission(String type, String name, String actions, java.security.cert.Certificate[] certs) {
        super("");
    }

    @Override // java.security.Permission
    public boolean implies(Permission p10) {
        return false;
    }

    @Override // java.security.Permission
    public String getActions() {
        return null;
    }

    public String getUnresolvedType() {
        return null;
    }

    public String getUnresolvedName() {
        return null;
    }

    public String getUnresolvedActions() {
        return null;
    }

    public java.security.cert.Certificate[] getUnresolvedCerts() {
        return null;
    }
}
