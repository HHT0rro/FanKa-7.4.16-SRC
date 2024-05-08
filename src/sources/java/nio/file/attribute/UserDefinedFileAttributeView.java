package java.nio.file.attribute;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface UserDefinedFileAttributeView extends FileAttributeView {
    void delete(String str) throws IOException;

    List<String> list() throws IOException;

    @Override // java.nio.file.attribute.AttributeView
    String name();

    int read(String str, ByteBuffer byteBuffer) throws IOException;

    int size(String str) throws IOException;

    int write(String str, ByteBuffer byteBuffer) throws IOException;
}
