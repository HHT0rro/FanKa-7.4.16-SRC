package java.nio.file.attribute;

import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface PosixFileAttributes extends BasicFileAttributes {
    GroupPrincipal group();

    UserPrincipal owner();

    Set<PosixFilePermission> permissions();
}
