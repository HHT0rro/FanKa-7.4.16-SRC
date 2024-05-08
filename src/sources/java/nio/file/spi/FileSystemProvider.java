package java.nio.file.spi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.AccessMode;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class FileSystemProvider {
    private static volatile List<FileSystemProvider> installedProviders;
    private static final Object lock = new Object();
    private static boolean loadingProviders = false;

    /* renamed from: -$$Nest$smloadInstalledProviders, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m3257$$Nest$smloadInstalledProviders() {
        return loadInstalledProviders();
    }

    public abstract void checkAccess(Path path, AccessMode... accessModeArr) throws IOException;

    public abstract void copy(Path path, Path path2, CopyOption... copyOptionArr) throws IOException;

    public abstract void createDirectory(Path path, FileAttribute<?>... fileAttributeArr) throws IOException;

    public abstract void delete(Path path) throws IOException;

    public abstract <V extends FileAttributeView> V getFileAttributeView(Path path, Class<V> cls, LinkOption... linkOptionArr);

    public abstract FileStore getFileStore(Path path) throws IOException;

    public abstract FileSystem getFileSystem(URI uri);

    public abstract Path getPath(URI uri);

    public abstract String getScheme();

    public abstract boolean isHidden(Path path) throws IOException;

    public abstract boolean isSameFile(Path path, Path path2) throws IOException;

    public abstract void move(Path path, Path path2, CopyOption... copyOptionArr) throws IOException;

    public abstract SeekableByteChannel newByteChannel(Path path, Set<? extends OpenOption> set, FileAttribute<?>... fileAttributeArr) throws IOException;

    public abstract DirectoryStream<Path> newDirectoryStream(Path path, DirectoryStream.Filter<? super Path> filter) throws IOException;

    public abstract FileSystem newFileSystem(URI uri, Map<String, ?> map) throws IOException;

    public abstract <A extends BasicFileAttributes> A readAttributes(Path path, Class<A> cls, LinkOption... linkOptionArr) throws IOException;

    public abstract Map<String, Object> readAttributes(Path path, String str, LinkOption... linkOptionArr) throws IOException;

    public abstract void setAttribute(Path path, String str, Object obj, LinkOption... linkOptionArr) throws IOException;

    private static Void checkPermission() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new RuntimePermission("fileSystemProvider"));
            return null;
        }
        return null;
    }

    private FileSystemProvider(Void ignore) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FileSystemProvider() {
        this(checkPermission());
    }

    private static List<FileSystemProvider> loadInstalledProviders() {
        List<FileSystemProvider> list = new ArrayList<>();
        ServiceLoader<FileSystemProvider> sl = ServiceLoader.load(FileSystemProvider.class, ClassLoader.getSystemClassLoader());
        Iterator<FileSystemProvider> iterator2 = sl.iterator2();
        while (iterator2.hasNext()) {
            FileSystemProvider provider = iterator2.next();
            String scheme = provider.getScheme();
            if (!scheme.equalsIgnoreCase("file")) {
                boolean found = false;
                Iterator<FileSystemProvider> iterator22 = list.iterator2();
                while (true) {
                    if (!iterator22.hasNext()) {
                        break;
                    }
                    FileSystemProvider p10 = iterator22.next();
                    if (p10.getScheme().equalsIgnoreCase(scheme)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    list.add(provider);
                }
            }
        }
        return list;
    }

    public static List<FileSystemProvider> installedProviders() {
        if (installedProviders == null) {
            FileSystemProvider defaultProvider = FileSystems.getDefault().provider();
            synchronized (lock) {
                if (installedProviders == null) {
                    if (loadingProviders) {
                        throw new Error("Circular loading of installed providers detected");
                    }
                    loadingProviders = true;
                    List<FileSystemProvider> list = (List) AccessController.doPrivileged(new PrivilegedAction<List<FileSystemProvider>>() { // from class: java.nio.file.spi.FileSystemProvider.1
                        @Override // java.security.PrivilegedAction
                        public List<FileSystemProvider> run() {
                            return FileSystemProvider.m3257$$Nest$smloadInstalledProviders();
                        }
                    });
                    list.add(0, defaultProvider);
                    installedProviders = Collections.unmodifiableList(list);
                }
            }
        }
        return installedProviders;
    }

    public FileSystem newFileSystem(Path path, Map<String, ?> env) throws IOException {
        throw new UnsupportedOperationException();
    }

    public InputStream newInputStream(Path path, OpenOption... options) throws IOException {
        if (options.length > 0) {
            for (OpenOption opt : options) {
                if (opt == StandardOpenOption.APPEND || opt == StandardOpenOption.WRITE) {
                    throw new UnsupportedOperationException("'" + ((Object) opt) + "' not allowed");
                }
            }
        }
        return Channels.newInputStream(Files.newByteChannel(path, options));
    }

    public OutputStream newOutputStream(Path path, OpenOption... options) throws IOException {
        int len = options.length;
        Set<OpenOption> opts = new HashSet<>(len + 3);
        if (len != 0) {
            for (OpenOption opt : options) {
                if (opt == StandardOpenOption.READ) {
                    throw new IllegalArgumentException("READ not allowed");
                }
                opts.add(opt);
            }
        } else {
            opts.add(StandardOpenOption.CREATE);
            opts.add(StandardOpenOption.TRUNCATE_EXISTING);
        }
        opts.add(StandardOpenOption.WRITE);
        return Channels.newOutputStream(newByteChannel(path, opts, new FileAttribute[0]));
    }

    public FileChannel newFileChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
        throw new UnsupportedOperationException();
    }

    public AsynchronousFileChannel newAsynchronousFileChannel(Path path, Set<? extends OpenOption> options, ExecutorService executor, FileAttribute<?>... attrs) throws IOException {
        throw new UnsupportedOperationException();
    }

    public void createSymbolicLink(Path link, Path target, FileAttribute<?>... attrs) throws IOException {
        throw new UnsupportedOperationException();
    }

    public void createLink(Path link, Path existing) throws IOException {
        throw new UnsupportedOperationException();
    }

    public boolean deleteIfExists(Path path) throws IOException {
        try {
            delete(path);
            return true;
        } catch (NoSuchFileException e2) {
            return false;
        }
    }

    public Path readSymbolicLink(Path link) throws IOException {
        throw new UnsupportedOperationException();
    }
}
