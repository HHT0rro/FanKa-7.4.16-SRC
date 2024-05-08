package sun.nio.fs;

import java.nio.file.FileSystems;
import java.nio.file.spi.FileSystemProvider;
import java.nio.file.spi.FileTypeDetector;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DefaultFileTypeDetector {
    private DefaultFileTypeDetector() {
    }

    public static FileTypeDetector create() {
        FileSystemProvider provider = FileSystems.getDefault().provider();
        return ((UnixFileSystemProvider) provider).getFileTypeDetector();
    }
}