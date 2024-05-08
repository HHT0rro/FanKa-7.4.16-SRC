package java.nio.file;

import com.huawei.appgallery.agd.common.utils.StringUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.nio.channels.Channels;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.FileTreeWalker;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.spi.FileSystemProvider;
import java.nio.file.spi.FileTypeDetector;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.Spliterators;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import sun.nio.fs.DefaultFileTypeDetector;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Files {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BUFFER_SIZE = 8192;
    private static final int MAX_BUFFER_SIZE = 2147483639;

    private Files() {
    }

    private static FileSystemProvider provider(Path path) {
        return path.getFileSystem().provider();
    }

    private static Runnable asUncheckedRunnable(final Closeable c4) {
        return new Runnable() { // from class: java.nio.file.Files$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                Files.lambda$asUncheckedRunnable$0(Closeable.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$asUncheckedRunnable$0(Closeable c4) {
        try {
            c4.close();
        } catch (IOException e2) {
            throw new UncheckedIOException(e2);
        }
    }

    public static InputStream newInputStream(Path path, OpenOption... options) throws IOException {
        return provider(path).newInputStream(path, options);
    }

    public static OutputStream newOutputStream(Path path, OpenOption... options) throws IOException {
        return provider(path).newOutputStream(path, options);
    }

    public static SeekableByteChannel newByteChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
        return provider(path).newByteChannel(path, options, attrs);
    }

    public static SeekableByteChannel newByteChannel(Path path, OpenOption... options) throws IOException {
        Set<OpenOption> set = new HashSet<>(options.length);
        Collections.addAll(set, options);
        return newByteChannel(path, set, new FileAttribute[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class AcceptAllFilter implements DirectoryStream.Filter<Path> {
        static final AcceptAllFilter FILTER = new AcceptAllFilter();

        private AcceptAllFilter() {
        }

        @Override // java.nio.file.DirectoryStream.Filter
        public boolean accept(Path entry) {
            return true;
        }
    }

    public static DirectoryStream<Path> newDirectoryStream(Path dir) throws IOException {
        return provider(dir).newDirectoryStream(dir, AcceptAllFilter.FILTER);
    }

    public static DirectoryStream<Path> newDirectoryStream(Path dir, String glob) throws IOException {
        if (glob.equals(StringUtils.NO_PRINT_CODE)) {
            return newDirectoryStream(dir);
        }
        FileSystem fs = dir.getFileSystem();
        final PathMatcher matcher = fs.getPathMatcher("glob:" + glob);
        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() { // from class: java.nio.file.Files.1
            @Override // java.nio.file.DirectoryStream.Filter
            public boolean accept(Path entry) {
                return PathMatcher.this.matches(entry.getFileName());
            }
        };
        return fs.provider().newDirectoryStream(dir, filter);
    }

    public static DirectoryStream<Path> newDirectoryStream(Path dir, DirectoryStream.Filter<? super Path> filter) throws IOException {
        return provider(dir).newDirectoryStream(dir, filter);
    }

    public static Path createFile(Path path, FileAttribute<?>... attrs) throws IOException {
        EnumSet<StandardOpenOption> options = EnumSet.of(StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
        newByteChannel(path, options, attrs).close();
        return path;
    }

    public static Path createDirectory(Path dir, FileAttribute<?>... attrs) throws IOException {
        provider(dir).createDirectory(dir, attrs);
        return dir;
    }

    public static Path createDirectories(Path dir, FileAttribute<?>... attrs) throws IOException {
        try {
            createAndCheckIsDirectory(dir, attrs);
            return dir;
        } catch (FileAlreadyExistsException x10) {
            throw x10;
        } catch (IOException e2) {
            SecurityException se = null;
            try {
                dir = dir.toAbsolutePath();
            } catch (SecurityException x11) {
                se = x11;
            }
            Path parent = dir.getParent();
            while (parent != null) {
                try {
                    provider(parent).checkAccess(parent, new AccessMode[0]);
                    break;
                } catch (NoSuchFileException e10) {
                    parent = parent.getParent();
                }
            }
            if (parent == null) {
                if (se == null) {
                    throw new FileSystemException(dir.toString(), null, "Unable to determine if root directory exists");
                }
                throw se;
            }
            Path child = parent;
            for (Path name : parent.relativize(dir)) {
                child = child.resolve(name);
                createAndCheckIsDirectory(child, attrs);
            }
            return dir;
        }
    }

    private static void createAndCheckIsDirectory(Path dir, FileAttribute<?>... attrs) throws IOException {
        try {
            createDirectory(dir, attrs);
        } catch (FileAlreadyExistsException x10) {
            if (!isDirectory(dir, LinkOption.NOFOLLOW_LINKS)) {
                throw x10;
            }
        }
    }

    public static Path createTempFile(Path dir, String prefix, String suffix, FileAttribute<?>... attrs) throws IOException {
        return TempFileHelper.createTempFile((Path) Objects.requireNonNull(dir), prefix, suffix, attrs);
    }

    public static Path createTempFile(String prefix, String suffix, FileAttribute<?>... attrs) throws IOException {
        return TempFileHelper.createTempFile(null, prefix, suffix, attrs);
    }

    public static Path createTempDirectory(Path dir, String prefix, FileAttribute<?>... attrs) throws IOException {
        return TempFileHelper.createTempDirectory((Path) Objects.requireNonNull(dir), prefix, attrs);
    }

    public static Path createTempDirectory(String prefix, FileAttribute<?>... attrs) throws IOException {
        return TempFileHelper.createTempDirectory(null, prefix, attrs);
    }

    public static Path createSymbolicLink(Path link, Path target, FileAttribute<?>... attrs) throws IOException {
        provider(link).createSymbolicLink(link, target, attrs);
        return link;
    }

    public static Path createLink(Path link, Path existing) throws IOException {
        provider(link).createLink(link, existing);
        return link;
    }

    public static void delete(Path path) throws IOException {
        provider(path).delete(path);
    }

    public static boolean deleteIfExists(Path path) throws IOException {
        return provider(path).deleteIfExists(path);
    }

    public static Path copy(Path source, Path target, CopyOption... options) throws IOException {
        FileSystemProvider provider = provider(source);
        if (provider(target) == provider) {
            provider.copy(source, target, options);
        } else {
            CopyMoveHelper.copyToForeignTarget(source, target, options);
        }
        return target;
    }

    public static Path move(Path source, Path target, CopyOption... options) throws IOException {
        FileSystemProvider provider = provider(source);
        if (provider(target) == provider) {
            provider.move(source, target, options);
        } else {
            CopyMoveHelper.moveToForeignTarget(source, target, options);
        }
        return target;
    }

    public static Path readSymbolicLink(Path link) throws IOException {
        return provider(link).readSymbolicLink(link);
    }

    public static FileStore getFileStore(Path path) throws IOException {
        return provider(path).getFileStore(path);
    }

    public static boolean isSameFile(Path path, Path path2) throws IOException {
        return provider(path).isSameFile(path, path2);
    }

    public static boolean isHidden(Path path) throws IOException {
        return provider(path).isHidden(path);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class FileTypeDetectors {
        static final FileTypeDetector defaultFileTypeDetector = createDefaultFileTypeDetector();
        static final List<FileTypeDetector> installeDetectors = loadInstalledDetectors();

        private FileTypeDetectors() {
        }

        private static FileTypeDetector createDefaultFileTypeDetector() {
            return (FileTypeDetector) AccessController.doPrivileged(new PrivilegedAction<FileTypeDetector>() { // from class: java.nio.file.Files.FileTypeDetectors.1
                @Override // java.security.PrivilegedAction
                public FileTypeDetector run() {
                    return DefaultFileTypeDetector.create();
                }
            });
        }

        private static List<FileTypeDetector> loadInstalledDetectors() {
            return (List) AccessController.doPrivileged(new PrivilegedAction<List<FileTypeDetector>>() { // from class: java.nio.file.Files.FileTypeDetectors.2
                @Override // java.security.PrivilegedAction
                public List<FileTypeDetector> run() {
                    List<FileTypeDetector> list = new ArrayList<>();
                    ServiceLoader<FileTypeDetector> loader = ServiceLoader.load(FileTypeDetector.class, ClassLoader.getSystemClassLoader());
                    Iterator<FileTypeDetector> iterator2 = loader.iterator2();
                    while (iterator2.hasNext()) {
                        FileTypeDetector detector = iterator2.next();
                        list.add(detector);
                    }
                    return list;
                }
            });
        }
    }

    public static String probeContentType(Path path) throws IOException {
        for (FileTypeDetector detector : FileTypeDetectors.installeDetectors) {
            String result = detector.probeContentType(path);
            if (result != null) {
                return result;
            }
        }
        return FileTypeDetectors.defaultFileTypeDetector.probeContentType(path);
    }

    public static <V extends FileAttributeView> V getFileAttributeView(Path path, Class<V> cls, LinkOption... linkOptionArr) {
        return (V) provider(path).getFileAttributeView(path, cls, linkOptionArr);
    }

    public static <A extends BasicFileAttributes> A readAttributes(Path path, Class<A> cls, LinkOption... linkOptionArr) throws IOException {
        return (A) provider(path).readAttributes(path, cls, linkOptionArr);
    }

    public static Path setAttribute(Path path, String attribute, Object value, LinkOption... options) throws IOException {
        provider(path).setAttribute(path, attribute, value, options);
        return path;
    }

    public static Object getAttribute(Path path, String attribute, LinkOption... options) throws IOException {
        String name;
        if (attribute.indexOf(42) >= 0 || attribute.indexOf(44) >= 0) {
            throw new IllegalArgumentException(attribute);
        }
        Map<String, Object> map = readAttributes(path, attribute, options);
        int pos = attribute.indexOf(58);
        if (pos == -1) {
            name = attribute;
        } else {
            name = pos == attribute.length() ? "" : attribute.substring(pos + 1);
        }
        return map.get(name);
    }

    public static Map<String, Object> readAttributes(Path path, String attributes, LinkOption... options) throws IOException {
        return provider(path).readAttributes(path, attributes, options);
    }

    public static Set<PosixFilePermission> getPosixFilePermissions(Path path, LinkOption... options) throws IOException {
        return ((PosixFileAttributes) readAttributes(path, PosixFileAttributes.class, options)).permissions();
    }

    public static Path setPosixFilePermissions(Path path, Set<PosixFilePermission> perms) throws IOException {
        PosixFileAttributeView view = (PosixFileAttributeView) getFileAttributeView(path, PosixFileAttributeView.class, new LinkOption[0]);
        if (view == null) {
            throw new UnsupportedOperationException();
        }
        view.setPermissions(perms);
        return path;
    }

    public static UserPrincipal getOwner(Path path, LinkOption... options) throws IOException {
        FileOwnerAttributeView view = (FileOwnerAttributeView) getFileAttributeView(path, FileOwnerAttributeView.class, options);
        if (view == null) {
            throw new UnsupportedOperationException();
        }
        return view.getOwner();
    }

    public static Path setOwner(Path path, UserPrincipal owner) throws IOException {
        FileOwnerAttributeView view = (FileOwnerAttributeView) getFileAttributeView(path, FileOwnerAttributeView.class, new LinkOption[0]);
        if (view == null) {
            throw new UnsupportedOperationException();
        }
        view.setOwner(owner);
        return path;
    }

    public static boolean isSymbolicLink(Path path) {
        try {
            return readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS).isSymbolicLink();
        } catch (IOException e2) {
            return false;
        }
    }

    public static boolean isDirectory(Path path, LinkOption... options) {
        try {
            return readAttributes(path, BasicFileAttributes.class, options).isDirectory();
        } catch (IOException e2) {
            return false;
        }
    }

    public static boolean isRegularFile(Path path, LinkOption... options) {
        try {
            return readAttributes(path, BasicFileAttributes.class, options).isRegularFile();
        } catch (IOException e2) {
            return false;
        }
    }

    public static FileTime getLastModifiedTime(Path path, LinkOption... options) throws IOException {
        return readAttributes(path, BasicFileAttributes.class, options).lastModifiedTime();
    }

    public static Path setLastModifiedTime(Path path, FileTime time) throws IOException {
        ((BasicFileAttributeView) getFileAttributeView(path, BasicFileAttributeView.class, new LinkOption[0])).setTimes(time, null, null);
        return path;
    }

    public static long size(Path path) throws IOException {
        return readAttributes(path, BasicFileAttributes.class, new LinkOption[0]).size();
    }

    private static boolean followLinks(LinkOption... options) {
        boolean followLinks = true;
        for (LinkOption opt : options) {
            if (opt == LinkOption.NOFOLLOW_LINKS) {
                followLinks = false;
            } else {
                if (opt == null) {
                    throw new NullPointerException();
                }
                throw new AssertionError((Object) "Should not get here");
            }
        }
        return followLinks;
    }

    public static boolean exists(Path path, LinkOption... options) {
        try {
            if (followLinks(options)) {
                provider(path).checkAccess(path, new AccessMode[0]);
            } else {
                readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            }
            return true;
        } catch (IOException e2) {
            return false;
        }
    }

    public static boolean notExists(Path path, LinkOption... options) {
        try {
            if (followLinks(options)) {
                provider(path).checkAccess(path, new AccessMode[0]);
            } else {
                readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            }
            return false;
        } catch (NoSuchFileException e2) {
            return true;
        } catch (IOException e10) {
            return false;
        }
    }

    private static boolean isAccessible(Path path, AccessMode... modes) {
        try {
            provider(path).checkAccess(path, modes);
            return true;
        } catch (IOException e2) {
            return false;
        }
    }

    public static boolean isReadable(Path path) {
        return isAccessible(path, AccessMode.READ);
    }

    public static boolean isWritable(Path path) {
        return isAccessible(path, AccessMode.WRITE);
    }

    public static boolean isExecutable(Path path) {
        return isAccessible(path, AccessMode.EXECUTE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0015. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x006e A[Catch: all -> 0x008b, TryCatch #1 {all -> 0x008b, blocks: (B:3:0x0005, B:4:0x0009, B:5:0x0015, B:36:0x0018, B:37:0x0085, B:38:0x008a, B:6:0x001c, B:8:0x002c, B:9:0x0066, B:11:0x006e, B:13:0x0073, B:15:0x0077, B:21:0x007a, B:26:0x0030, B:28:0x0040, B:30:0x0044, B:31:0x0048, B:33:0x004f, B:34:0x005d), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.nio.file.Path walkFileTree(java.nio.file.Path r5, java.util.Set<java.nio.file.FileVisitOption> r6, int r7, java.nio.file.FileVisitor<? super java.nio.file.Path> r8) throws java.io.IOException {
        /*
            java.nio.file.FileTreeWalker r0 = new java.nio.file.FileTreeWalker
            r0.<init>(r6, r7)
            java.nio.file.FileTreeWalker$Event r1 = r0.walk(r5)     // Catch: java.lang.Throwable -> L8b
        L9:
            int[] r2 = java.nio.file.Files.AnonymousClass3.$SwitchMap$java$nio$file$FileTreeWalker$EventType     // Catch: java.lang.Throwable -> L8b
            java.nio.file.FileTreeWalker$EventType r3 = r1.type()     // Catch: java.lang.Throwable -> L8b
            int r3 = r3.ordinal()     // Catch: java.lang.Throwable -> L8b
            r2 = r2[r3]     // Catch: java.lang.Throwable -> L8b
            switch(r2) {
                case 1: goto L48;
                case 2: goto L30;
                case 3: goto L1c;
                default: goto L18;
            }     // Catch: java.lang.Throwable -> L8b
        L18:
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L8b
            goto L85
        L1c:
            java.nio.file.Path r2 = r1.file()     // Catch: java.lang.Throwable -> L8b
            java.io.IOException r3 = r1.ioeException()     // Catch: java.lang.Throwable -> L8b
            java.nio.file.FileVisitResult r2 = r8.postVisitDirectory(r2, r3)     // Catch: java.lang.Throwable -> L8b
            java.nio.file.FileVisitResult r3 = java.nio.file.FileVisitResult.SKIP_SIBLINGS     // Catch: java.lang.Throwable -> L8b
            if (r2 != r3) goto L66
            java.nio.file.FileVisitResult r3 = java.nio.file.FileVisitResult.CONTINUE     // Catch: java.lang.Throwable -> L8b
            r2 = r3
            goto L66
        L30:
            java.nio.file.Path r2 = r1.file()     // Catch: java.lang.Throwable -> L8b
            java.nio.file.attribute.BasicFileAttributes r3 = r1.attributes()     // Catch: java.lang.Throwable -> L8b
            java.nio.file.FileVisitResult r2 = r8.preVisitDirectory(r2, r3)     // Catch: java.lang.Throwable -> L8b
            java.nio.file.FileVisitResult r3 = java.nio.file.FileVisitResult.SKIP_SUBTREE     // Catch: java.lang.Throwable -> L8b
            if (r2 == r3) goto L44
            java.nio.file.FileVisitResult r3 = java.nio.file.FileVisitResult.SKIP_SIBLINGS     // Catch: java.lang.Throwable -> L8b
            if (r2 != r3) goto L66
        L44:
            r0.pop()     // Catch: java.lang.Throwable -> L8b
            goto L66
        L48:
            java.io.IOException r2 = r1.ioeException()     // Catch: java.lang.Throwable -> L8b
            if (r2 != 0) goto L5d
        L4f:
            java.nio.file.Path r3 = r1.file()     // Catch: java.lang.Throwable -> L8b
            java.nio.file.attribute.BasicFileAttributes r4 = r1.attributes()     // Catch: java.lang.Throwable -> L8b
            java.nio.file.FileVisitResult r3 = r8.visitFile(r3, r4)     // Catch: java.lang.Throwable -> L8b
            r2 = r3
            goto L66
        L5d:
            java.nio.file.Path r3 = r1.file()     // Catch: java.lang.Throwable -> L8b
            java.nio.file.FileVisitResult r3 = r8.visitFileFailed(r3, r2)     // Catch: java.lang.Throwable -> L8b
            r2 = r3
        L66:
            java.lang.Object r3 = java.util.Objects.requireNonNull(r2)     // Catch: java.lang.Throwable -> L8b
            java.nio.file.FileVisitResult r4 = java.nio.file.FileVisitResult.CONTINUE     // Catch: java.lang.Throwable -> L8b
            if (r3 == r4) goto L7a
            java.nio.file.FileVisitResult r3 = java.nio.file.FileVisitResult.TERMINATE     // Catch: java.lang.Throwable -> L8b
            if (r2 != r3) goto L73
            goto L81
        L73:
            java.nio.file.FileVisitResult r3 = java.nio.file.FileVisitResult.SKIP_SIBLINGS     // Catch: java.lang.Throwable -> L8b
            if (r2 != r3) goto L7a
            r0.skipRemainingSiblings()     // Catch: java.lang.Throwable -> L8b
        L7a:
            java.nio.file.FileTreeWalker$Event r3 = r0.next()     // Catch: java.lang.Throwable -> L8b
            r1 = r3
            if (r1 != 0) goto L9
        L81:
            r0.close()
            return r5
        L85:
            java.lang.String r3 = "Should not get here"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L8b
            throw r2     // Catch: java.lang.Throwable -> L8b
        L8b:
            r1 = move-exception
            r0.close()     // Catch: java.lang.Throwable -> L90
            goto L94
        L90:
            r2 = move-exception
            r1.addSuppressed(r2)
        L94:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.nio.file.Files.walkFileTree(java.nio.file.Path, java.util.Set, int, java.nio.file.FileVisitor):java.nio.file.Path");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.nio.file.Files$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$java$nio$file$FileTreeWalker$EventType;

        static {
            int[] iArr = new int[FileTreeWalker.EventType.values().length];
            $SwitchMap$java$nio$file$FileTreeWalker$EventType = iArr;
            try {
                iArr[FileTreeWalker.EventType.ENTRY.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$nio$file$FileTreeWalker$EventType[FileTreeWalker.EventType.START_DIRECTORY.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$nio$file$FileTreeWalker$EventType[FileTreeWalker.EventType.END_DIRECTORY.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    public static Path walkFileTree(Path start, FileVisitor<? super Path> visitor) throws IOException {
        return walkFileTree(start, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, visitor);
    }

    public static BufferedReader newBufferedReader(Path path, Charset cs) throws IOException {
        CharsetDecoder decoder = cs.newDecoder();
        Reader reader = new InputStreamReader(newInputStream(path, new OpenOption[0]), decoder);
        return new BufferedReader(reader);
    }

    public static BufferedReader newBufferedReader(Path path) throws IOException {
        return newBufferedReader(path, StandardCharsets.UTF_8);
    }

    public static BufferedWriter newBufferedWriter(Path path, Charset cs, OpenOption... options) throws IOException {
        CharsetEncoder encoder = cs.newEncoder();
        Writer writer = new OutputStreamWriter(newOutputStream(path, options), encoder);
        return new BufferedWriter(writer);
    }

    public static BufferedWriter newBufferedWriter(Path path, OpenOption... options) throws IOException {
        return newBufferedWriter(path, StandardCharsets.UTF_8, options);
    }

    private static long copy(InputStream source, OutputStream sink) throws IOException {
        long nread = 0;
        byte[] buf = new byte[8192];
        while (true) {
            int n10 = source.read(buf);
            if (n10 > 0) {
                sink.write(buf, 0, n10);
                nread += n10;
            } else {
                return nread;
            }
        }
    }

    public static long copy(InputStream in, Path target, CopyOption... options) throws IOException {
        Objects.requireNonNull(in);
        boolean replaceExisting = false;
        for (CopyOption opt : options) {
            if (opt == StandardCopyOption.REPLACE_EXISTING) {
                replaceExisting = true;
            } else {
                if (opt == null) {
                    throw new NullPointerException("options contains 'null'");
                }
                throw new UnsupportedOperationException(((Object) opt) + " not supported");
            }
        }
        SecurityException se = null;
        if (replaceExisting) {
            try {
                deleteIfExists(target);
            } catch (SecurityException x10) {
                se = x10;
            }
        }
        try {
            OutputStream ostream = newOutputStream(target, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
            try {
                long copy = copy(in, ostream);
                if (ostream != null) {
                    ostream.close();
                }
                return copy;
            } catch (Throwable th) {
                if (ostream != null) {
                    try {
                        ostream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (FileAlreadyExistsException x11) {
            if (se != null) {
                throw se;
            }
            throw x11;
        }
    }

    public static long copy(Path source, OutputStream out) throws IOException {
        Objects.requireNonNull(out);
        InputStream in = newInputStream(source, new OpenOption[0]);
        try {
            long copy = copy(in, out);
            if (in != null) {
                in.close();
            }
            return copy;
        } catch (Throwable th) {
            if (in != null) {
                try {
                    in.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private static byte[] read(InputStream source, int initialSize) throws IOException {
        int n10;
        int capacity = initialSize;
        byte[] buf = new byte[capacity];
        int nread = 0;
        while (true) {
            int n11 = source.read(buf, nread, capacity - nread);
            if (n11 > 0) {
                nread += n11;
            } else {
                if (n11 < 0 || (n10 = source.read()) < 0) {
                    break;
                }
                if (capacity <= 2147483639 - capacity) {
                    capacity = Math.max(capacity << 1, 8192);
                } else {
                    if (capacity == 2147483639) {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                    capacity = 2147483639;
                }
                buf = Arrays.copyOf(buf, capacity);
                buf[nread] = (byte) n10;
                nread++;
            }
        }
        return capacity == nread ? buf : Arrays.copyOf(buf, nread);
    }

    public static byte[] readAllBytes(Path path) throws IOException {
        SeekableByteChannel sbc = newByteChannel(path, new OpenOption[0]);
        try {
            InputStream in = Channels.newInputStream(sbc);
            try {
                long size = sbc.size();
                if (size > 2147483639) {
                    throw new OutOfMemoryError("Required array size too large");
                }
                byte[] read = read(in, (int) size);
                if (in != null) {
                    in.close();
                }
                if (sbc != null) {
                    sbc.close();
                }
                return read;
            } finally {
            }
        } catch (Throwable th) {
            if (sbc != null) {
                try {
                    sbc.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static List<String> readAllLines(Path path, Charset cs) throws IOException {
        BufferedReader reader = newBufferedReader(path, cs);
        try {
            List<String> result = new ArrayList<>();
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                result.add(line);
            }
            if (reader != null) {
                reader.close();
            }
            return result;
        } catch (Throwable th) {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static List<String> readAllLines(Path path) throws IOException {
        return readAllLines(path, StandardCharsets.UTF_8);
    }

    public static Path write(Path path, byte[] bytes, OpenOption... options) throws IOException {
        Objects.requireNonNull(bytes);
        OutputStream out = newOutputStream(path, options);
        try {
            int len = bytes.length;
            int rem = len;
            while (rem > 0) {
                int n10 = Math.min(rem, 8192);
                out.write(bytes, len - rem, n10);
                rem -= n10;
            }
            if (out != null) {
                out.close();
            }
            return path;
        } catch (Throwable th) {
            if (out != null) {
                try {
                    out.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static Path write(Path path, Iterable<? extends CharSequence> lines, Charset cs, OpenOption... options) throws IOException {
        Objects.requireNonNull(lines);
        CharsetEncoder encoder = cs.newEncoder();
        OutputStream out = newOutputStream(path, options);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, encoder));
        try {
            for (CharSequence line : lines) {
                writer.append(line);
                writer.newLine();
            }
            writer.close();
            return path;
        } catch (Throwable th) {
            try {
                writer.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static Path write(Path path, Iterable<? extends CharSequence> lines, OpenOption... options) throws IOException {
        return write(path, lines, StandardCharsets.UTF_8, options);
    }

    public static Stream<Path> list(Path dir) throws IOException {
        DirectoryStream<Path> ds = newDirectoryStream(dir);
        try {
            final Iterator<Path> delegate = ds.iterator2();
            Iterator<Path> it = new Iterator<Path>() { // from class: java.nio.file.Files.2
                @Override // java.util.Iterator
                public boolean hasNext() {
                    try {
                        return Iterator.this.hasNext();
                    } catch (DirectoryIteratorException e2) {
                        throw new UncheckedIOException(e2.getCause());
                    }
                }

                @Override // java.util.Iterator
                public Path next() {
                    try {
                        return (Path) Iterator.this.next();
                    } catch (DirectoryIteratorException e2) {
                        throw new UncheckedIOException(e2.getCause());
                    }
                }
            };
            return (Stream) StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 1), false).onClose(asUncheckedRunnable(ds));
        } catch (Error | RuntimeException e2) {
            try {
                ds.close();
            } catch (IOException ex) {
                try {
                    e2.addSuppressed(ex);
                } catch (Throwable th) {
                }
            }
            throw e2;
        }
    }

    public static Stream<Path> walk(Path start, int maxDepth, FileVisitOption... options) throws IOException {
        FileTreeIterator iterator = new FileTreeIterator(start, maxDepth, options);
        try {
            Stream stream = StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, 1), false);
            Objects.requireNonNull(iterator);
            return stream.onClose(new Files$$ExternalSyntheticLambda0(iterator)).map(new Function() { // from class: java.nio.file.Files$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Path file;
                    file = ((FileTreeWalker.Event) obj).file();
                    return file;
                }
            });
        } catch (Error | RuntimeException e2) {
            iterator.close();
            throw e2;
        }
    }

    public static Stream<Path> walk(Path start, FileVisitOption... options) throws IOException {
        return walk(start, Integer.MAX_VALUE, options);
    }

    public static Stream<Path> find(Path start, int maxDepth, final BiPredicate<Path, BasicFileAttributes> matcher, FileVisitOption... options) throws IOException {
        FileTreeIterator iterator = new FileTreeIterator(start, maxDepth, options);
        try {
            Stream stream = StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, 1), false);
            Objects.requireNonNull(iterator);
            return stream.onClose(new Files$$ExternalSyntheticLambda0(iterator)).filter(new Predicate() { // from class: java.nio.file.Files$$ExternalSyntheticLambda2
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean test;
                    test = BiPredicate.this.test(r2.file(), ((FileTreeWalker.Event) obj).attributes());
                    return test;
                }
            }).map(new Function() { // from class: java.nio.file.Files$$ExternalSyntheticLambda3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Path file;
                    file = ((FileTreeWalker.Event) obj).file();
                    return file;
                }
            });
        } catch (Error | RuntimeException e2) {
            iterator.close();
            throw e2;
        }
    }

    public static Stream<String> lines(Path path, Charset cs) throws IOException {
        BufferedReader br = newBufferedReader(path, cs);
        try {
            return (Stream) br.lines().onClose(asUncheckedRunnable(br));
        } catch (Error | RuntimeException e2) {
            try {
                br.close();
            } catch (IOException ex) {
                try {
                    e2.addSuppressed(ex);
                } catch (Throwable th) {
                }
            }
            throw e2;
        }
    }

    public static Stream<String> lines(Path path) throws IOException {
        return lines(path, StandardCharsets.UTF_8);
    }
}
