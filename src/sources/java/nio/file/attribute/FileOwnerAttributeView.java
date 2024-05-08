package java.nio.file.attribute;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface FileOwnerAttributeView extends FileAttributeView {
    UserPrincipal getOwner() throws IOException;

    @Override // java.nio.file.attribute.AttributeView
    String name();

    void setOwner(UserPrincipal userPrincipal) throws IOException;
}
