package java.security.acl;

import java.security.Principal;
import java.util.Enumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@Deprecated(forRemoval = true, since = "9")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface AclEntry extends Cloneable {
    boolean addPermission(Permission permission);

    boolean checkPermission(Permission permission);

    Object clone();

    Principal getPrincipal();

    boolean isNegative();

    Enumeration<Permission> permissions();

    boolean removePermission(Permission permission);

    void setNegativePermissions();

    boolean setPrincipal(Principal principal);

    String toString();
}
