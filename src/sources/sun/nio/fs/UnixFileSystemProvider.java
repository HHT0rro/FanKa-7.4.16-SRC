package sun.nio.fs;

import java.io.FilePermission;
import java.io.IOException;
import java.lang.reflect.GenericDeclaration;
import java.net.URI;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.AccessMode;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemAlreadyExistsException;
import java.nio.file.LinkOption;
import java.nio.file.LinkPermission;
import java.nio.file.NotDirectoryException;
import java.nio.file.NotLinkException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.ProviderMismatchException;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.spi.FileTypeDetector;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import sun.nio.ch.ThreadPool;
import sun.security.util.SecurityConstants;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class UnixFileSystemProvider extends AbstractFileSystemProvider {
    private static final byte[] EMPTY_PATH = new byte[0];
    private static final String USER_DIR = "user.dir";
    private final UnixFileSystem theFileSystem;

    abstract FileStore getFileStore(UnixPath unixPath) throws IOException;

    abstract UnixFileSystem newFileSystem(String str);

    public UnixFileSystemProvider() {
        String userDir = System.getProperty(USER_DIR);
        this.theFileSystem = newFileSystem(userDir);
    }

    UnixFileSystem theFileSystem() {
        return this.theFileSystem;
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final String getScheme() {
        return "file";
    }

    private void checkUri(URI uri) {
        if (!uri.getScheme().equalsIgnoreCase(getScheme())) {
            throw new IllegalArgumentException("URI does not match this provider");
        }
        if (uri.getRawAuthority() != null) {
            throw new IllegalArgumentException("Authority component present");
        }
        String path = uri.getPath();
        if (path == null) {
            throw new IllegalArgumentException("Path component is undefined");
        }
        if (!path.equals("/")) {
            throw new IllegalArgumentException("Path component should be '/'");
        }
        if (uri.getRawQuery() != null) {
            throw new IllegalArgumentException("Query component present");
        }
        if (uri.getRawFragment() != null) {
            throw new IllegalArgumentException("Fragment component present");
        }
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final FileSystem newFileSystem(URI uri, Map<String, ?> env) {
        checkUri(uri);
        throw new FileSystemAlreadyExistsException();
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public final FileSystem getFileSystem(URI uri) {
        checkUri(uri);
        return this.theFileSystem;
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public Path getPath(URI uri) {
        return UnixUriUtils.fromUri(this.theFileSystem, uri);
    }

    UnixPath checkPath(Path obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        if (!(obj instanceof UnixPath)) {
            throw new ProviderMismatchException();
        }
        return (UnixPath) obj;
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public <V extends FileAttributeView> V getFileAttributeView(Path obj, Class<V> type, LinkOption... options) {
        UnixPath file = UnixPath.toUnixPath(obj);
        boolean followLinks = Util.followLinks(options);
        if (type == BasicFileAttributeView.class) {
            return UnixFileAttributeViews.createBasicView(file, followLinks);
        }
        if (type == PosixFileAttributeView.class) {
            return UnixFileAttributeViews.createPosixView(file, followLinks);
        }
        if (type == FileOwnerAttributeView.class) {
            return UnixFileAttributeViews.createOwnerView(file, followLinks);
        }
        if (type == null) {
            throw new NullPointerException();
        }
        return null;
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public <A extends BasicFileAttributes> A readAttributes(Path path, Class<A> cls, LinkOption... linkOptionArr) throws IOException {
        GenericDeclaration genericDeclaration;
        if (cls == BasicFileAttributes.class) {
            genericDeclaration = BasicFileAttributeView.class;
        } else if (cls == PosixFileAttributes.class) {
            genericDeclaration = PosixFileAttributeView.class;
        } else {
            if (cls == null) {
                throw new NullPointerException();
            }
            throw new UnsupportedOperationException();
        }
        return (A) ((BasicFileAttributeView) getFileAttributeView(path, (Class) genericDeclaration, linkOptionArr)).readAttributes();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sun.nio.fs.AbstractFileSystemProvider
    public DynamicFileAttributeView getFileAttributeView(Path obj, String name, LinkOption... options) {
        UnixPath file = UnixPath.toUnixPath(obj);
        boolean followLinks = Util.followLinks(options);
        if (name.equals("basic")) {
            return UnixFileAttributeViews.createBasicView(file, followLinks);
        }
        if (name.equals("posix")) {
            return UnixFileAttributeViews.createPosixView(file, followLinks);
        }
        if (name.equals("unix")) {
            return UnixFileAttributeViews.createUnixView(file, followLinks);
        }
        if (name.equals("owner")) {
            return UnixFileAttributeViews.createOwnerView(file, followLinks);
        }
        return null;
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public FileChannel newFileChannel(Path obj, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
        UnixPath file = checkPath(obj);
        int mode = UnixFileModeAttribute.toUnixMode(UnixFileModeAttribute.ALL_READWRITE, attrs);
        try {
            return UnixChannelFactory.newFileChannel(file, options, mode);
        } catch (UnixException x10) {
            x10.rethrowAsIOException(file);
            return null;
        }
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public AsynchronousFileChannel newAsynchronousFileChannel(Path obj, Set<? extends OpenOption> options, ExecutorService executor, FileAttribute<?>... attrs) throws IOException {
        UnixPath file = checkPath(obj);
        int mode = UnixFileModeAttribute.toUnixMode(UnixFileModeAttribute.ALL_READWRITE, attrs);
        ThreadPool pool = executor == null ? null : ThreadPool.wrap(executor, 0);
        try {
            return UnixChannelFactory.newAsynchronousFileChannel(file, options, mode, pool);
        } catch (UnixException x10) {
            x10.rethrowAsIOException(file);
            return null;
        }
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public SeekableByteChannel newByteChannel(Path obj, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
        UnixPath file = UnixPath.toUnixPath(obj);
        int mode = UnixFileModeAttribute.toUnixMode(UnixFileModeAttribute.ALL_READWRITE, attrs);
        try {
            return UnixChannelFactory.newFileChannel(file, options, mode);
        } catch (UnixException x10) {
            x10.rethrowAsIOException(file);
            return null;
        }
    }

    @Override // sun.nio.fs.AbstractFileSystemProvider
    boolean implDelete(Path obj, boolean failIfNotExists) throws IOException {
        UnixPath file = UnixPath.toUnixPath(obj);
        file.checkDelete();
        UnixFileAttributes attrs = null;
        try {
            UnixFileAttributes attrs2 = UnixFileAttributes.get(file, false);
            if (attrs2.isDirectory()) {
                UnixNativeDispatcher.rmdir(file);
                return true;
            }
            UnixNativeDispatcher.unlink(file);
            return true;
        } catch (UnixException x10) {
            if (!failIfNotExists && x10.errno() == UnixConstants.ENOENT) {
                return false;
            }
            if (0 != 0 && attrs.isDirectory() && (x10.errno() == UnixConstants.EEXIST || x10.errno() == UnixConstants.ENOTEMPTY)) {
                throw new DirectoryNotEmptyException(file.getPathForExceptionMessage());
            }
            x10.rethrowAsIOException(file);
            return false;
        }
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public void copy(Path source, Path target, CopyOption... options) throws IOException {
        UnixCopyFile.copy(UnixPath.toUnixPath(source), UnixPath.toUnixPath(target), options);
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public void move(Path source, Path target, CopyOption... options) throws IOException {
        UnixCopyFile.move(UnixPath.toUnixPath(source), UnixPath.toUnixPath(target), options);
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public void checkAccess(Path obj, AccessMode... modes) throws IOException {
        UnixPath file = UnixPath.toUnixPath(obj);
        boolean e2 = false;
        boolean r10 = false;
        boolean w3 = false;
        boolean x10 = false;
        if (modes.length == 0) {
            e2 = true;
        } else {
            for (AccessMode mode : modes) {
                switch (AnonymousClass3.$SwitchMap$java$nio$file$AccessMode[mode.ordinal()]) {
                    case 1:
                        r10 = true;
                        break;
                    case 2:
                        w3 = true;
                        break;
                    case 3:
                        x10 = true;
                        break;
                    default:
                        throw new AssertionError((Object) "Should not get here");
                }
            }
        }
        int mode2 = 0;
        if (e2 || r10) {
            file.checkRead();
            mode2 = 0 | (r10 ? UnixConstants.R_OK : UnixConstants.F_OK);
        }
        if (w3) {
            file.checkWrite();
            mode2 |= UnixConstants.W_OK;
        }
        if (x10) {
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                sm.checkExec(file.getPathForPermissionCheck());
            }
            mode2 |= UnixConstants.X_OK;
        }
        try {
            UnixNativeDispatcher.access(file, mode2);
        } catch (UnixException exc) {
            exc.rethrowAsIOException(file);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: sun.nio.fs.UnixFileSystemProvider$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$java$nio$file$AccessMode;

        static {
            int[] iArr = new int[AccessMode.values().length];
            $SwitchMap$java$nio$file$AccessMode = iArr;
            try {
                iArr[AccessMode.READ.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$nio$file$AccessMode[AccessMode.WRITE.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$nio$file$AccessMode[AccessMode.EXECUTE.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public boolean isSameFile(Path obj1, Path obj2) throws IOException {
        UnixPath file1 = UnixPath.toUnixPath(obj1);
        if (file1.equals(obj2)) {
            return true;
        }
        if (obj2 == null) {
            throw new NullPointerException();
        }
        if (!(obj2 instanceof UnixPath)) {
            return false;
        }
        UnixPath file2 = (UnixPath) obj2;
        file1.checkRead();
        file2.checkRead();
        try {
            UnixFileAttributes attrs1 = UnixFileAttributes.get(file1, true);
            try {
                UnixFileAttributes attrs2 = UnixFileAttributes.get(file2, true);
                return attrs1.isSameFile(attrs2);
            } catch (UnixException x10) {
                x10.rethrowAsIOException(file2);
                return false;
            }
        } catch (UnixException x11) {
            x11.rethrowAsIOException(file1);
            return false;
        }
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public boolean isHidden(Path obj) {
        byte[] path;
        UnixPath file = UnixPath.toUnixPath(obj);
        file.checkRead();
        UnixPath name = file.getFileName();
        if (name == null) {
            return false;
        }
        if (name.isEmpty()) {
            path = name.getFileSystem().defaultDirectory();
        } else {
            path = name.asByteArray();
        }
        return path[0] == 46;
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public FileStore getFileStore(Path obj) throws IOException {
        throw new SecurityException("getFileStore");
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public void createDirectory(Path obj, FileAttribute<?>... attrs) throws IOException {
        UnixPath dir = UnixPath.toUnixPath(obj);
        dir.checkWrite();
        int mode = UnixFileModeAttribute.toUnixMode(UnixFileModeAttribute.ALL_PERMISSIONS, attrs);
        try {
            UnixNativeDispatcher.mkdir(dir, mode);
        } catch (UnixException x10) {
            if (x10.errno() == UnixConstants.EISDIR) {
                throw new FileAlreadyExistsException(dir.toString());
            }
            x10.rethrowAsIOException(dir);
        }
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public DirectoryStream<Path> newDirectoryStream(Path obj, DirectoryStream.Filter<? super Path> filter) throws IOException {
        int dfd2;
        long dp;
        UnixPath dir = UnixPath.toUnixPath(obj);
        dir.checkRead();
        if (filter == null) {
            throw new NullPointerException();
        }
        if (!UnixNativeDispatcher.openatSupported() || UnixConstants.O_NOFOLLOW == 0) {
            try {
                long ptr = UnixNativeDispatcher.opendir(dir);
                return new UnixDirectoryStream(dir, ptr, filter);
            } catch (UnixException x10) {
                if (x10.errno() == UnixConstants.ENOTDIR) {
                    throw new NotDirectoryException(dir.getPathForExceptionMessage());
                }
                x10.rethrowAsIOException(dir);
            }
        }
        int dfd1 = -1;
        int dfd22 = -1;
        try {
            dfd1 = UnixNativeDispatcher.open(dir, UnixConstants.O_RDONLY, 0);
            dfd22 = UnixNativeDispatcher.dup(dfd1);
            long dp2 = UnixNativeDispatcher.fdopendir(dfd1);
            dfd2 = dfd22;
            dp = dp2;
        } catch (UnixException x11) {
            if (dfd1 != -1) {
                UnixNativeDispatcher.close(dfd1);
            }
            if (dfd22 != -1) {
                UnixNativeDispatcher.close(dfd22);
            }
            if (x11.errno() == UnixConstants.ENOTDIR) {
                throw new NotDirectoryException(dir.getPathForExceptionMessage());
            }
            x11.rethrowAsIOException(dir);
            dfd2 = dfd22;
            dp = 0;
        }
        return new UnixSecureDirectoryStream(dir, dp, dfd2, filter);
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public void createSymbolicLink(Path obj1, Path obj2, FileAttribute<?>... attrs) throws IOException {
        UnixPath link = UnixPath.toUnixPath(obj1);
        UnixPath target = UnixPath.toUnixPath(obj2);
        if (attrs.length > 0) {
            UnixFileModeAttribute.toUnixMode(0, attrs);
            throw new UnsupportedOperationException("Initial file attributesnot supported when creating symbolic link");
        }
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new LinkPermission("symbolic"));
            link.checkWrite();
        }
        try {
            UnixNativeDispatcher.symlink(target.asByteArray(), link);
        } catch (UnixException x10) {
            x10.rethrowAsIOException(link);
        }
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public void createLink(Path obj1, Path obj2) throws IOException {
        UnixPath link = UnixPath.toUnixPath(obj1);
        UnixPath existing = UnixPath.toUnixPath(obj2);
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new LinkPermission("hard"));
            link.checkWrite();
            existing.checkWrite();
        }
        try {
            UnixNativeDispatcher.link(existing, link);
        } catch (UnixException x10) {
            x10.rethrowAsIOException(link, existing);
        }
    }

    @Override // java.nio.file.spi.FileSystemProvider
    public Path readSymbolicLink(Path obj1) throws IOException {
        UnixPath link = UnixPath.toUnixPath(obj1);
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            FilePermission perm = new FilePermission(link.getPathForPermissionCheck(), SecurityConstants.FILE_READLINK_ACTION);
            sm.checkPermission(perm);
        }
        try {
            byte[] target = UnixNativeDispatcher.readlink(link);
            return new UnixPath(link.getFileSystem(), target);
        } catch (UnixException x10) {
            if (x10.errno() == UnixConstants.EINVAL) {
                throw new NotLinkException(link.getPathForExceptionMessage());
            }
            x10.rethrowAsIOException(link);
            return null;
        }
    }

    @Override // sun.nio.fs.AbstractFileSystemProvider
    public final boolean isDirectory(Path obj) {
        UnixPath file = UnixPath.toUnixPath(obj);
        file.checkRead();
        int mode = UnixNativeDispatcher.stat(file);
        return (UnixConstants.S_IFMT & mode) == UnixConstants.S_IFDIR;
    }

    @Override // sun.nio.fs.AbstractFileSystemProvider
    public final boolean isRegularFile(Path obj) {
        UnixPath file = UnixPath.toUnixPath(obj);
        file.checkRead();
        int mode = UnixNativeDispatcher.stat(file);
        return (UnixConstants.S_IFMT & mode) == UnixConstants.S_IFREG;
    }

    @Override // sun.nio.fs.AbstractFileSystemProvider
    public final boolean exists(Path obj) {
        UnixPath file = UnixPath.toUnixPath(obj);
        file.checkRead();
        return UnixNativeDispatcher.exists(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileTypeDetector getFileTypeDetector() {
        return new AbstractFileTypeDetector() { // from class: sun.nio.fs.UnixFileSystemProvider.1
            @Override // sun.nio.fs.AbstractFileTypeDetector
            public String implProbeContentType(Path file) {
                return null;
            }
        };
    }

    final FileTypeDetector chain(final AbstractFileTypeDetector... detectors) {
        return new AbstractFileTypeDetector() { // from class: sun.nio.fs.UnixFileSystemProvider.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // sun.nio.fs.AbstractFileTypeDetector
            public String implProbeContentType(Path file) throws IOException {
                for (AbstractFileTypeDetector detector : detectors) {
                    String result = detector.implProbeContentType(file);
                    if (result != null && !result.isEmpty()) {
                        return result;
                    }
                }
                return null;
            }
        };
    }

    @Override // sun.nio.fs.AbstractFileSystemProvider
    public byte[] getSunPathForSocketFile(Path obj) {
        UnixPath file = UnixPath.toUnixPath(obj);
        if (file.isEmpty()) {
            return EMPTY_PATH;
        }
        return file.getByteArrayForSysCalls();
    }
}
