package java.nio.file.attribute;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface DosFileAttributeView extends BasicFileAttributeView {
    @Override // java.nio.file.attribute.BasicFileAttributeView, java.nio.file.attribute.AttributeView
    String name();

    @Override // java.nio.file.attribute.BasicFileAttributeView
    DosFileAttributes readAttributes() throws IOException;

    void setArchive(boolean z10) throws IOException;

    void setHidden(boolean z10) throws IOException;

    void setReadOnly(boolean z10) throws IOException;

    void setSystem(boolean z10) throws IOException;
}
