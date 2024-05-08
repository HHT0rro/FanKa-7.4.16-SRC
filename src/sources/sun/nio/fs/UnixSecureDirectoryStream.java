package sun.nio.fs;

import dalvik.annotation.optimization.ReachabilitySensitive;
import dalvik.system.CloseGuard;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.ClosedDirectoryStreamException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.DirectoryStream;
import java.nio.file.LinkOption;
import java.nio.file.NotDirectoryException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.ProviderMismatchException;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.UserPrincipal;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import sun.nio.fs.UnixUserPrincipals;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class UnixSecureDirectoryStream implements SecureDirectoryStream<Path> {

    @ReachabilitySensitive
    private final int dfd;
    private final UnixDirectoryStream ds;

    @ReachabilitySensitive
    private final CloseGuard guard;

    @Override // java.nio.file.SecureDirectoryStream
    public /* bridge */ /* synthetic */ SeekableByteChannel newByteChannel(Path path, Set set, FileAttribute[] fileAttributeArr) throws IOException {
        return newByteChannel2(path, (Set<? extends OpenOption>) set, (FileAttribute<?>[]) fileAttributeArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnixSecureDirectoryStream(UnixPath dir, long dp, int dfd, DirectoryStream.Filter<? super Path> filter) {
        CloseGuard closeGuard = CloseGuard.get();
        this.guard = closeGuard;
        this.ds = new UnixDirectoryStream(dir, dp, filter);
        this.dfd = dfd;
        if (dfd != -1) {
            closeGuard.open("close");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ds.writeLock().lock();
        try {
            if (this.ds.closeImpl()) {
                UnixNativeDispatcher.close(this.dfd);
            }
            this.ds.writeLock().unlock();
            this.guard.close();
        } catch (Throwable th) {
            this.ds.writeLock().unlock();
            throw th;
        }
    }

    @Override // java.nio.file.DirectoryStream, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Path> iterator2() {
        return this.ds.iterator(this);
    }

    private UnixPath getName(Path obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        if (!(obj instanceof UnixPath)) {
            throw new ProviderMismatchException();
        }
        return (UnixPath) obj;
    }

    @Override // java.nio.file.SecureDirectoryStream
    public SecureDirectoryStream<Path> newDirectoryStream(Path obj, LinkOption... options) throws IOException {
        int newdfd2;
        long ptr;
        UnixPath file = getName(obj);
        UnixPath child = this.ds.directory().resolve((Path) file);
        boolean followLinks = Util.followLinks(options);
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            child.checkRead();
        }
        this.ds.readLock().lock();
        try {
            if (!this.ds.isOpen()) {
                throw new ClosedDirectoryStreamException();
            }
            int newdfd1 = -1;
            int newdfd22 = -1;
            try {
                int flags = UnixConstants.O_RDONLY;
                if (!followLinks) {
                    flags |= UnixConstants.O_NOFOLLOW;
                }
                newdfd1 = UnixNativeDispatcher.openat(this.dfd, file.asByteArray(), flags, 0);
                newdfd22 = UnixNativeDispatcher.dup(newdfd1);
                long ptr2 = UnixNativeDispatcher.fdopendir(newdfd1);
                newdfd2 = newdfd22;
                ptr = ptr2;
            } catch (UnixException x10) {
                if (newdfd1 != -1) {
                    UnixNativeDispatcher.close(newdfd1);
                }
                if (newdfd22 != -1) {
                    UnixNativeDispatcher.close(newdfd22);
                }
                if (x10.errno() == UnixConstants.ENOTDIR) {
                    throw new NotDirectoryException(file.toString());
                }
                x10.rethrowAsIOException(file);
                newdfd2 = newdfd22;
                ptr = 0;
            }
            return new UnixSecureDirectoryStream(child, ptr, newdfd2, null);
        } finally {
            this.ds.readLock().unlock();
        }
    }

    /* renamed from: newByteChannel, reason: avoid collision after fix types in other method */
    public SeekableByteChannel newByteChannel2(Path obj, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
        UnixPath file = getName(obj);
        int mode = UnixFileModeAttribute.toUnixMode(UnixFileModeAttribute.ALL_READWRITE, attrs);
        String pathToCheck = this.ds.directory().resolve((Path) file).getPathForPermissionCheck();
        this.ds.readLock().lock();
        try {
            if (!this.ds.isOpen()) {
                throw new ClosedDirectoryStreamException();
            }
            try {
                return UnixChannelFactory.newFileChannel(this.dfd, file, pathToCheck, options, mode);
            } catch (UnixException x10) {
                x10.rethrowAsIOException(file);
                this.ds.readLock().unlock();
                return null;
            }
        } finally {
            this.ds.readLock().unlock();
        }
    }

    private void implDelete(Path obj, boolean haveFlags, int flags) throws IOException {
        UnixPath file = getName(obj);
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            this.ds.directory().resolve((Path) file).checkDelete();
        }
        this.ds.readLock().lock();
        try {
            if (!this.ds.isOpen()) {
                throw new ClosedDirectoryStreamException();
            }
            if (!haveFlags) {
                UnixFileAttributes attrs = null;
                try {
                    attrs = UnixFileAttributes.get(this.dfd, file, false);
                } catch (UnixException x10) {
                    x10.rethrowAsIOException(file);
                }
                flags = attrs.isDirectory() ? 512 : 0;
            }
            try {
                UnixNativeDispatcher.unlinkat(this.dfd, file.asByteArray(), flags);
            } catch (UnixException x11) {
                if ((flags & 512) != 0 && (x11.errno() == UnixConstants.EEXIST || x11.errno() == UnixConstants.ENOTEMPTY)) {
                    throw new DirectoryNotEmptyException(null);
                }
                x11.rethrowAsIOException(file);
            }
        } finally {
            this.ds.readLock().unlock();
        }
    }

    @Override // java.nio.file.SecureDirectoryStream
    public void deleteFile(Path file) throws IOException {
        implDelete(file, true, 0);
    }

    @Override // java.nio.file.SecureDirectoryStream
    public void deleteDirectory(Path dir) throws IOException {
        implDelete(dir, true, 512);
    }

    @Override // java.nio.file.SecureDirectoryStream
    public void move(Path fromObj, SecureDirectoryStream<Path> dir, Path toObj) throws IOException {
        UnixPath from = getName(fromObj);
        UnixPath to = getName(toObj);
        if (dir == null) {
            throw new NullPointerException();
        }
        if (!(dir instanceof UnixSecureDirectoryStream)) {
            throw new ProviderMismatchException();
        }
        UnixSecureDirectoryStream that = (UnixSecureDirectoryStream) dir;
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            this.ds.directory().resolve((Path) from).checkWrite();
            that.ds.directory().resolve((Path) to).checkWrite();
        }
        this.ds.readLock().lock();
        try {
            that.ds.readLock().lock();
            try {
                if (!this.ds.isOpen() || !that.ds.isOpen()) {
                    throw new ClosedDirectoryStreamException();
                }
                try {
                    UnixNativeDispatcher.renameat(this.dfd, from.asByteArray(), that.dfd, to.asByteArray());
                } catch (UnixException x10) {
                    if (x10.errno() == UnixConstants.EXDEV) {
                        throw new AtomicMoveNotSupportedException(from.toString(), to.toString(), x10.errorString());
                    }
                    x10.rethrowAsIOException(from, to);
                }
            } finally {
                that.ds.readLock().unlock();
            }
        } finally {
            this.ds.readLock().unlock();
        }
    }

    private <V extends FileAttributeView> V getFileAttributeViewImpl(UnixPath file, Class<V> type, boolean followLinks) {
        if (type == null) {
            throw new NullPointerException();
        }
        if (type != BasicFileAttributeView.class) {
            if (type == PosixFileAttributeView.class || type == FileOwnerAttributeView.class) {
                return new PosixFileAttributeViewImpl(file, followLinks);
            }
            return null;
        }
        return new BasicFileAttributeViewImpl(file, followLinks);
    }

    @Override // java.nio.file.SecureDirectoryStream
    public <V extends FileAttributeView> V getFileAttributeView(Class<V> cls) {
        return (V) getFileAttributeViewImpl(null, cls, false);
    }

    @Override // java.nio.file.SecureDirectoryStream
    public <V extends FileAttributeView> V getFileAttributeView(Path path, Class<V> cls, LinkOption... linkOptionArr) {
        return (V) getFileAttributeViewImpl(getName(path), cls, Util.followLinks(linkOptionArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class BasicFileAttributeViewImpl implements BasicFileAttributeView {
        final UnixPath file;
        final boolean followLinks;

        BasicFileAttributeViewImpl(UnixPath file, boolean followLinks) {
            this.file = file;
            this.followLinks = followLinks;
        }

        int open() throws IOException {
            int oflags = UnixConstants.O_RDONLY;
            if (!this.followLinks) {
                oflags |= UnixConstants.O_NOFOLLOW;
            }
            try {
                return UnixNativeDispatcher.openat(UnixSecureDirectoryStream.this.dfd, this.file.asByteArray(), oflags, 0);
            } catch (UnixException x10) {
                x10.rethrowAsIOException(this.file);
                return -1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkWriteAccess() {
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                if (this.file == null) {
                    UnixSecureDirectoryStream.this.ds.directory().checkWrite();
                } else {
                    UnixSecureDirectoryStream.this.ds.directory().resolve((Path) this.file).checkWrite();
                }
            }
        }

        @Override // java.nio.file.attribute.BasicFileAttributeView, java.nio.file.attribute.AttributeView
        public String name() {
            return "basic";
        }

        @Override // java.nio.file.attribute.BasicFileAttributeView
        public BasicFileAttributes readAttributes() throws IOException {
            UnixFileAttributes attrs;
            UnixSecureDirectoryStream.this.ds.readLock().lock();
            try {
                if (!UnixSecureDirectoryStream.this.ds.isOpen()) {
                    throw new ClosedDirectoryStreamException();
                }
                SecurityManager sm = System.getSecurityManager();
                if (sm != null) {
                    if (this.file == null) {
                        UnixSecureDirectoryStream.this.ds.directory().checkRead();
                    } else {
                        UnixSecureDirectoryStream.this.ds.directory().resolve((Path) this.file).checkRead();
                    }
                }
                try {
                    if (this.file == null) {
                        attrs = UnixFileAttributes.get(UnixSecureDirectoryStream.this.dfd);
                    } else {
                        attrs = UnixFileAttributes.get(UnixSecureDirectoryStream.this.dfd, this.file, this.followLinks);
                    }
                    return attrs.asBasicFileAttributes();
                } catch (UnixException x10) {
                    x10.rethrowAsIOException(this.file);
                    UnixSecureDirectoryStream.this.ds.readLock().unlock();
                    return null;
                }
            } finally {
                UnixSecureDirectoryStream.this.ds.readLock().unlock();
            }
        }

        @Override // java.nio.file.attribute.BasicFileAttributeView
        public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) throws IOException {
            checkWriteAccess();
            UnixSecureDirectoryStream.this.ds.readLock().lock();
            try {
                if (!UnixSecureDirectoryStream.this.ds.isOpen()) {
                    throw new ClosedDirectoryStreamException();
                }
                int fd2 = this.file == null ? UnixSecureDirectoryStream.this.dfd : open();
                if (lastModifiedTime == null || lastAccessTime == null) {
                    try {
                        try {
                            UnixFileAttributes attrs = UnixFileAttributes.get(fd2);
                            if (lastModifiedTime == null) {
                                lastModifiedTime = attrs.lastModifiedTime();
                            }
                            if (lastAccessTime == null) {
                                lastAccessTime = attrs.lastAccessTime();
                            }
                        } catch (UnixException x10) {
                            x10.rethrowAsIOException(this.file);
                        }
                    } finally {
                        if (this.file != null) {
                            UnixNativeDispatcher.close(fd2);
                        }
                    }
                }
                try {
                    UnixNativeDispatcher.futimes(fd2, lastAccessTime.to(TimeUnit.MICROSECONDS), lastModifiedTime.to(TimeUnit.MICROSECONDS));
                } catch (UnixException x11) {
                    x11.rethrowAsIOException(this.file);
                }
            } finally {
                UnixSecureDirectoryStream.this.ds.readLock().unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class PosixFileAttributeViewImpl extends BasicFileAttributeViewImpl implements PosixFileAttributeView {
        PosixFileAttributeViewImpl(UnixPath file, boolean followLinks) {
            super(file, followLinks);
        }

        private void checkWriteAndUserAccess() {
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                checkWriteAccess();
                sm.checkPermission(new RuntimePermission("accessUserInformation"));
            }
        }

        @Override // sun.nio.fs.UnixSecureDirectoryStream.BasicFileAttributeViewImpl, java.nio.file.attribute.BasicFileAttributeView, java.nio.file.attribute.AttributeView
        public String name() {
            return "posix";
        }

        @Override // sun.nio.fs.UnixSecureDirectoryStream.BasicFileAttributeViewImpl, java.nio.file.attribute.BasicFileAttributeView
        public PosixFileAttributes readAttributes() throws IOException {
            UnixFileAttributes attrs;
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                if (this.file == null) {
                    UnixSecureDirectoryStream.this.ds.directory().checkRead();
                } else {
                    UnixSecureDirectoryStream.this.ds.directory().resolve((Path) this.file).checkRead();
                }
                sm.checkPermission(new RuntimePermission("accessUserInformation"));
            }
            UnixSecureDirectoryStream.this.ds.readLock().lock();
            try {
                if (!UnixSecureDirectoryStream.this.ds.isOpen()) {
                    throw new ClosedDirectoryStreamException();
                }
                try {
                    if (this.file == null) {
                        attrs = UnixFileAttributes.get(UnixSecureDirectoryStream.this.dfd);
                    } else {
                        attrs = UnixFileAttributes.get(UnixSecureDirectoryStream.this.dfd, this.file, this.followLinks);
                    }
                    return attrs;
                } catch (UnixException x10) {
                    x10.rethrowAsIOException(this.file);
                    UnixSecureDirectoryStream.this.ds.readLock().unlock();
                    return null;
                }
            } finally {
                UnixSecureDirectoryStream.this.ds.readLock().unlock();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
        
            if (r0 >= 0) goto L13;
         */
        @Override // java.nio.file.attribute.PosixFileAttributeView
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void setPermissions(java.util.Set<java.nio.file.attribute.PosixFilePermission> r4) throws java.io.IOException {
            /*
                r3 = this;
                r3.checkWriteAndUserAccess()
                sun.nio.fs.UnixSecureDirectoryStream r0 = sun.nio.fs.UnixSecureDirectoryStream.this
                sun.nio.fs.UnixDirectoryStream r0 = sun.nio.fs.UnixSecureDirectoryStream.m3839$$Nest$fgetds(r0)
                java.util.concurrent.locks.Lock r0 = r0.readLock()
                r0.lock()
                sun.nio.fs.UnixSecureDirectoryStream r0 = sun.nio.fs.UnixSecureDirectoryStream.this     // Catch: java.lang.Throwable -> L6b
                sun.nio.fs.UnixDirectoryStream r0 = sun.nio.fs.UnixSecureDirectoryStream.m3839$$Nest$fgetds(r0)     // Catch: java.lang.Throwable -> L6b
                boolean r0 = r0.isOpen()     // Catch: java.lang.Throwable -> L6b
                if (r0 == 0) goto L65
                sun.nio.fs.UnixPath r0 = r3.file     // Catch: java.lang.Throwable -> L6b
                if (r0 != 0) goto L27
                sun.nio.fs.UnixSecureDirectoryStream r0 = sun.nio.fs.UnixSecureDirectoryStream.this     // Catch: java.lang.Throwable -> L6b
                int r0 = sun.nio.fs.UnixSecureDirectoryStream.m3838$$Nest$fgetdfd(r0)     // Catch: java.lang.Throwable -> L6b
                goto L2b
            L27:
                int r0 = r3.open()     // Catch: java.lang.Throwable -> L6b
            L2b:
                int r1 = sun.nio.fs.UnixFileModeAttribute.toUnixMode(r4)     // Catch: java.lang.Throwable -> L3c sun.nio.fs.UnixException -> L3e
                sun.nio.fs.UnixNativeDispatcher.fchmod(r0, r1)     // Catch: java.lang.Throwable -> L3c sun.nio.fs.UnixException -> L3e
                sun.nio.fs.UnixPath r1 = r3.file     // Catch: java.lang.Throwable -> L6b
                if (r1 == 0) goto L4b
                if (r0 < 0) goto L4b
            L38:
                sun.nio.fs.UnixNativeDispatcher.close(r0)     // Catch: java.lang.Throwable -> L6b
                goto L4b
            L3c:
                r1 = move-exception
                goto L5a
            L3e:
                r1 = move-exception
                sun.nio.fs.UnixPath r2 = r3.file     // Catch: java.lang.Throwable -> L3c
                r1.rethrowAsIOException(r2)     // Catch: java.lang.Throwable -> L3c
                sun.nio.fs.UnixPath r1 = r3.file     // Catch: java.lang.Throwable -> L6b
                if (r1 == 0) goto L4b
                if (r0 < 0) goto L4b
                goto L38
            L4b:
                sun.nio.fs.UnixSecureDirectoryStream r0 = sun.nio.fs.UnixSecureDirectoryStream.this
                sun.nio.fs.UnixDirectoryStream r0 = sun.nio.fs.UnixSecureDirectoryStream.m3839$$Nest$fgetds(r0)
                java.util.concurrent.locks.Lock r0 = r0.readLock()
                r0.unlock()
                return
            L5a:
                sun.nio.fs.UnixPath r2 = r3.file     // Catch: java.lang.Throwable -> L6b
                if (r2 == 0) goto L63
                if (r0 < 0) goto L63
                sun.nio.fs.UnixNativeDispatcher.close(r0)     // Catch: java.lang.Throwable -> L6b
            L63:
                throw r1     // Catch: java.lang.Throwable -> L6b
            L65:
                java.nio.file.ClosedDirectoryStreamException r0 = new java.nio.file.ClosedDirectoryStreamException     // Catch: java.lang.Throwable -> L6b
                r0.<init>()     // Catch: java.lang.Throwable -> L6b
                throw r0     // Catch: java.lang.Throwable -> L6b
            L6b:
                r0 = move-exception
                sun.nio.fs.UnixSecureDirectoryStream r1 = sun.nio.fs.UnixSecureDirectoryStream.this
                sun.nio.fs.UnixDirectoryStream r1 = sun.nio.fs.UnixSecureDirectoryStream.m3839$$Nest$fgetds(r1)
                java.util.concurrent.locks.Lock r1 = r1.readLock()
                r1.unlock()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.fs.UnixSecureDirectoryStream.PosixFileAttributeViewImpl.setPermissions(java.util.Set):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0044, code lost:
        
            if (r0 >= 0) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void setOwners(int r4, int r5) throws java.io.IOException {
            /*
                r3 = this;
                r3.checkWriteAndUserAccess()
                sun.nio.fs.UnixSecureDirectoryStream r0 = sun.nio.fs.UnixSecureDirectoryStream.this
                sun.nio.fs.UnixDirectoryStream r0 = sun.nio.fs.UnixSecureDirectoryStream.m3839$$Nest$fgetds(r0)
                java.util.concurrent.locks.Lock r0 = r0.readLock()
                r0.lock()
                sun.nio.fs.UnixSecureDirectoryStream r0 = sun.nio.fs.UnixSecureDirectoryStream.this     // Catch: java.lang.Throwable -> L67
                sun.nio.fs.UnixDirectoryStream r0 = sun.nio.fs.UnixSecureDirectoryStream.m3839$$Nest$fgetds(r0)     // Catch: java.lang.Throwable -> L67
                boolean r0 = r0.isOpen()     // Catch: java.lang.Throwable -> L67
                if (r0 == 0) goto L61
                sun.nio.fs.UnixPath r0 = r3.file     // Catch: java.lang.Throwable -> L67
                if (r0 != 0) goto L27
                sun.nio.fs.UnixSecureDirectoryStream r0 = sun.nio.fs.UnixSecureDirectoryStream.this     // Catch: java.lang.Throwable -> L67
                int r0 = sun.nio.fs.UnixSecureDirectoryStream.m3838$$Nest$fgetdfd(r0)     // Catch: java.lang.Throwable -> L67
                goto L2b
            L27:
                int r0 = r3.open()     // Catch: java.lang.Throwable -> L67
            L2b:
                sun.nio.fs.UnixNativeDispatcher.fchown(r0, r4, r5)     // Catch: java.lang.Throwable -> L38 sun.nio.fs.UnixException -> L3a
                sun.nio.fs.UnixPath r1 = r3.file     // Catch: java.lang.Throwable -> L67
                if (r1 == 0) goto L47
                if (r0 < 0) goto L47
            L34:
                sun.nio.fs.UnixNativeDispatcher.close(r0)     // Catch: java.lang.Throwable -> L67
                goto L47
            L38:
                r1 = move-exception
                goto L56
            L3a:
                r1 = move-exception
                sun.nio.fs.UnixPath r2 = r3.file     // Catch: java.lang.Throwable -> L38
                r1.rethrowAsIOException(r2)     // Catch: java.lang.Throwable -> L38
                sun.nio.fs.UnixPath r1 = r3.file     // Catch: java.lang.Throwable -> L67
                if (r1 == 0) goto L47
                if (r0 < 0) goto L47
                goto L34
            L47:
                sun.nio.fs.UnixSecureDirectoryStream r0 = sun.nio.fs.UnixSecureDirectoryStream.this
                sun.nio.fs.UnixDirectoryStream r0 = sun.nio.fs.UnixSecureDirectoryStream.m3839$$Nest$fgetds(r0)
                java.util.concurrent.locks.Lock r0 = r0.readLock()
                r0.unlock()
                return
            L56:
                sun.nio.fs.UnixPath r2 = r3.file     // Catch: java.lang.Throwable -> L67
                if (r2 == 0) goto L5f
                if (r0 < 0) goto L5f
                sun.nio.fs.UnixNativeDispatcher.close(r0)     // Catch: java.lang.Throwable -> L67
            L5f:
                throw r1     // Catch: java.lang.Throwable -> L67
            L61:
                java.nio.file.ClosedDirectoryStreamException r0 = new java.nio.file.ClosedDirectoryStreamException     // Catch: java.lang.Throwable -> L67
                r0.<init>()     // Catch: java.lang.Throwable -> L67
                throw r0     // Catch: java.lang.Throwable -> L67
            L67:
                r0 = move-exception
                sun.nio.fs.UnixSecureDirectoryStream r1 = sun.nio.fs.UnixSecureDirectoryStream.this
                sun.nio.fs.UnixDirectoryStream r1 = sun.nio.fs.UnixSecureDirectoryStream.m3839$$Nest$fgetds(r1)
                java.util.concurrent.locks.Lock r1 = r1.readLock()
                r1.unlock()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.fs.UnixSecureDirectoryStream.PosixFileAttributeViewImpl.setOwners(int, int):void");
        }

        @Override // java.nio.file.attribute.FileOwnerAttributeView
        public UserPrincipal getOwner() throws IOException {
            return readAttributes().owner();
        }

        @Override // java.nio.file.attribute.FileOwnerAttributeView
        public void setOwner(UserPrincipal owner) throws IOException {
            if (!(owner instanceof UnixUserPrincipals.User)) {
                throw new ProviderMismatchException();
            }
            if (owner instanceof UnixUserPrincipals.Group) {
                throw new IOException("'owner' parameter can't be a group");
            }
            int uid = ((UnixUserPrincipals.User) owner).uid();
            setOwners(uid, -1);
        }

        @Override // java.nio.file.attribute.PosixFileAttributeView
        public void setGroup(GroupPrincipal group) throws IOException {
            if (!(group instanceof UnixUserPrincipals.Group)) {
                throw new ProviderMismatchException();
            }
            int gid = ((UnixUserPrincipals.Group) group).gid();
            setOwners(-1, gid);
        }
    }

    protected void finalize() throws IOException {
        CloseGuard closeGuard = this.guard;
        if (closeGuard != null) {
            closeGuard.warnIfOpen();
        }
        close();
    }
}
