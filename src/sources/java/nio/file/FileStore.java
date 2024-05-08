package java.nio.file;

import java.io.IOException;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class FileStore {
    public abstract Object getAttribute(String str) throws IOException;

    public abstract <V extends FileStoreAttributeView> V getFileStoreAttributeView(Class<V> cls);

    public abstract long getTotalSpace() throws IOException;

    public abstract long getUnallocatedSpace() throws IOException;

    public abstract long getUsableSpace() throws IOException;

    public abstract boolean isReadOnly();

    public abstract String name();

    public abstract boolean supportsFileAttributeView(Class<? extends FileAttributeView> cls);

    public abstract boolean supportsFileAttributeView(String str);

    public abstract String type();

    public long getBlockSize() throws IOException {
        throw new UnsupportedOperationException();
    }
}
