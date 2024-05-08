package java.security;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Permission implements Guard, Serializable {
    private String name;

    public abstract String getActions();

    public abstract boolean implies(Permission permission);

    public Permission(String name) {
        this.name = name;
    }

    @Override // java.security.Guard
    public void checkGuard(Object object) throws SecurityException {
    }

    public final String getName() {
        return this.name;
    }

    public PermissionCollection newPermissionCollection() {
        return new Permissions();
    }
}
