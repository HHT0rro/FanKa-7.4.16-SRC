package java.nio.file.attribute;

import java.io.IOException;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface PosixFileAttributeView extends BasicFileAttributeView, FileOwnerAttributeView {
    @Override // java.nio.file.attribute.BasicFileAttributeView, java.nio.file.attribute.AttributeView
    String name();

    @Override // java.nio.file.attribute.BasicFileAttributeView
    PosixFileAttributes readAttributes() throws IOException;

    void setGroup(GroupPrincipal groupPrincipal) throws IOException;

    void setPermissions(Set<PosixFilePermission> set) throws IOException;
}
