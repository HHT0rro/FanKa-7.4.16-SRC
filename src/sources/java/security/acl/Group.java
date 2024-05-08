package java.security.acl;

import java.security.Principal;
import java.util.Enumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
@Deprecated(forRemoval = true, since = "9")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Group extends Principal {
    boolean addMember(Principal principal);

    boolean isMember(Principal principal);

    Enumeration<? extends Principal> members();

    boolean removeMember(Principal principal);
}
