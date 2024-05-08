package java.security.acl;

import java.security.Principal;
import java.util.Enumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@Deprecated(forRemoval = true, since = "9")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Acl extends Owner {
    boolean addEntry(Principal principal, AclEntry aclEntry) throws NotOwnerException;

    boolean checkPermission(Principal principal, Permission permission);

    Enumeration<AclEntry> entries();

    String getName();

    Enumeration<Permission> getPermissions(Principal principal);

    boolean removeEntry(Principal principal, AclEntry aclEntry) throws NotOwnerException;

    void setName(Principal principal, String str) throws NotOwnerException;

    String toString();
}
