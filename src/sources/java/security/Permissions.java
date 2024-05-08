package java.security;

import java.io.Serializable;
import java.util.Enumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Permissions extends PermissionCollection implements Serializable {
    @Override // java.security.PermissionCollection
    public void add(Permission permission) {
    }

    @Override // java.security.PermissionCollection
    public boolean implies(Permission permission) {
        return true;
    }

    @Override // java.security.PermissionCollection
    public Enumeration<Permission> elements() {
        return null;
    }
}
