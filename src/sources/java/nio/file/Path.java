package java.nio.file;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.WatchEvent;
import java.nio.file.spi.FileSystemProvider;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Path extends Comparable<Path>, Iterable<Path>, Watchable {
    @Override // java.lang.Comparable
    int compareTo(Path path);

    boolean endsWith(String str);

    boolean endsWith(Path path);

    boolean equals(Object obj);

    Path getFileName();

    FileSystem getFileSystem();

    Path getName(int i10);

    int getNameCount();

    Path getParent();

    Path getRoot();

    int hashCode();

    boolean isAbsolute();

    @Override // java.lang.Iterable
    /* renamed from: iterator */
    Iterator<Path> iterator2();

    Path normalize();

    @Override // java.nio.file.Watchable
    WatchKey register(WatchService watchService, WatchEvent.Kind<?>... kindArr) throws IOException;

    @Override // java.nio.file.Watchable
    WatchKey register(WatchService watchService, WatchEvent.Kind<?>[] kindArr, WatchEvent.Modifier... modifierArr) throws IOException;

    Path relativize(Path path);

    Path resolve(String str);

    Path resolve(Path path);

    Path resolveSibling(String str);

    Path resolveSibling(Path path);

    boolean startsWith(String str);

    boolean startsWith(Path path);

    Path subpath(int i10, int i11);

    Path toAbsolutePath();

    File toFile();

    Path toRealPath(LinkOption... linkOptionArr) throws IOException;

    String toString();

    URI toUri();

    static Path of(String first, String... more) {
        return FileSystems.getDefault().getPath(first, more);
    }

    static Path of(URI uri) {
        String scheme = uri.getScheme();
        if (scheme == null) {
            throw new IllegalArgumentException("Missing scheme");
        }
        if (scheme.equalsIgnoreCase("file")) {
            return FileSystems.getDefault().provider().getPath(uri);
        }
        for (FileSystemProvider provider : FileSystemProvider.installedProviders()) {
            if (provider.getScheme().equalsIgnoreCase(scheme)) {
                return provider.getPath(uri);
            }
        }
        throw new FileSystemNotFoundException("Provider \"" + scheme + "\" not installed");
    }
}
