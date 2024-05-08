package java.nio.file.attribute;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class UserPrincipalLookupService {
    public abstract GroupPrincipal lookupPrincipalByGroupName(String str) throws IOException;

    public abstract UserPrincipal lookupPrincipalByName(String str) throws IOException;
}
