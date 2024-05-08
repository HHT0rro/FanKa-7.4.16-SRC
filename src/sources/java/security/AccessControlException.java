package java.security;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class AccessControlException extends SecurityException {
    private static final long serialVersionUID = 5138225684096988535L;
    private Permission perm;

    public AccessControlException(String s2) {
        super(s2);
    }

    public AccessControlException(String s2, Permission p10) {
        super(s2);
        this.perm = p10;
    }

    public Permission getPermission() {
        return this.perm;
    }
}
