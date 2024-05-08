package java.io;

import java.security.Permission;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class FilePermission extends Permission implements Serializable {
    public FilePermission(String path, String actions) {
        super(path);
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
