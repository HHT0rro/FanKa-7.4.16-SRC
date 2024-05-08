package java.nio.file;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface SecureDirectoryStream<T> extends DirectoryStream<T> {
    void deleteDirectory(T t2) throws IOException;

    void deleteFile(T t2) throws IOException;

    <V extends FileAttributeView> V getFileAttributeView(Class<V> cls);

    <V extends FileAttributeView> V getFileAttributeView(T t2, Class<V> cls, LinkOption... linkOptionArr);

    void move(T t2, SecureDirectoryStream<T> secureDirectoryStream, T t10) throws IOException;

    SeekableByteChannel newByteChannel(T t2, Set<? extends OpenOption> set, FileAttribute<?>... fileAttributeArr) throws IOException;

    SecureDirectoryStream<T> newDirectoryStream(T t2, LinkOption... linkOptionArr) throws IOException;
}
