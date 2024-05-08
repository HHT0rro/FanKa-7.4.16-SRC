package java.security;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class AllPermission extends Permission {
    public AllPermission() {
        super("");
    }

    public AllPermission(String name, String actions) {
        super("");
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
