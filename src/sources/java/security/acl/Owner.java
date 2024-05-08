package java.security.acl;

import java.security.Principal;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@Deprecated(forRemoval = true, since = "9")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Owner {
    boolean addOwner(Principal principal, Principal principal2) throws NotOwnerException;

    boolean deleteOwner(Principal principal, Principal principal2) throws NotOwnerException, LastOwnerException;

    boolean isOwner(Principal principal);
}
