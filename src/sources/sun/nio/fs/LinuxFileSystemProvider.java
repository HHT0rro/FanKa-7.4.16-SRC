package sun.nio.fs;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.spi.FileTypeDetector;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LinuxFileSystemProvider extends UnixFileSystemProvider {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.fs.UnixFileSystemProvider
    public LinuxFileSystem newFileSystem(String dir) {
        return new LinuxFileSystem(this, dir);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.fs.UnixFileSystemProvider
    public LinuxFileStore getFileStore(UnixPath path) throws IOException {
        throw new SecurityException("getFileStore");
    }

    @Override // sun.nio.fs.UnixFileSystemProvider, java.nio.file.spi.FileSystemProvider
    public <V extends FileAttributeView> V getFileAttributeView(Path path, Class<V> cls, LinkOption... linkOptionArr) {
        return (V) super.getFileAttributeView(path, cls, linkOptionArr);
    }

    @Override // sun.nio.fs.UnixFileSystemProvider, sun.nio.fs.AbstractFileSystemProvider
    public DynamicFileAttributeView getFileAttributeView(Path obj, String name, LinkOption... options) {
        return super.getFileAttributeView(obj, name, options);
    }

    @Override // sun.nio.fs.UnixFileSystemProvider, java.nio.file.spi.FileSystemProvider
    public <A extends BasicFileAttributes> A readAttributes(Path path, Class<A> cls, LinkOption... linkOptionArr) throws IOException {
        return (A) super.readAttributes(path, cls, linkOptionArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.fs.UnixFileSystemProvider
    public FileTypeDetector getFileTypeDetector() {
        return new MimeTypesFileTypeDetector();
    }
}
