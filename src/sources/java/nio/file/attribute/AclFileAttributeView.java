package java.nio.file.attribute;

import java.io.IOException;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface AclFileAttributeView extends FileOwnerAttributeView {
    List<AclEntry> getAcl() throws IOException;

    @Override // java.nio.file.attribute.FileOwnerAttributeView, java.nio.file.attribute.AttributeView
    String name();

    void setAcl(List<AclEntry> list) throws IOException;
}
