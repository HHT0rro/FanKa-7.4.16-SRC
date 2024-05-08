package sun.nio.fs;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class UnixNativeDispatcher {
    private static final int SUPPORTS_BIRTHTIME = 65536;
    private static final int SUPPORTS_FUTIMES = 4;
    private static final int SUPPORTS_OPENAT = 2;
    private static final int capabilities = init();

    private static native void access0(long j10, int i10) throws UnixException;

    private static native void chmod0(long j10, int i10) throws UnixException;

    private static native void chown0(long j10, int i10, int i11) throws UnixException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void close(int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void closedir(long j10) throws UnixException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int dup(int i10) throws UnixException;

    private static native boolean exists0(long j10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void fchmod(int i10, int i11) throws UnixException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void fchown(int i10, int i11, int i12) throws UnixException;

    static native void fclose(long j10) throws UnixException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long fdopendir(int i10) throws UnixException;

    private static native long fopen0(long j10, long j11) throws UnixException;

    static native long fpathconf(int i10, int i11) throws UnixException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void fstat(int i10, UnixFileAttributes unixFileAttributes) throws UnixException;

    private static native void fstatat0(int i10, long j10, int i11, UnixFileAttributes unixFileAttributes) throws UnixException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void futimes(int i10, long j10, long j11) throws UnixException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native byte[] getcwd();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native byte[] getgrgid(int i10) throws UnixException;

    private static native int getgrnam0(long j10) throws UnixException;

    private static native int getpwnam0(long j10) throws UnixException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native byte[] getpwuid(int i10) throws UnixException;

    private static native int init();

    private static native void lchown0(long j10, int i10, int i11) throws UnixException;

    private static native void link0(long j10, long j11) throws UnixException;

    private static native void lstat0(long j10, UnixFileAttributes unixFileAttributes) throws UnixException;

    private static native void mkdir0(long j10, int i10) throws UnixException;

    private static native void mknod0(long j10, int i10, long j11) throws UnixException;

    private static native int open0(long j10, int i10, int i11) throws UnixException;

    private static native int openat0(int i10, long j10, int i11, int i12) throws UnixException;

    private static native long opendir0(long j10) throws UnixException;

    private static native long pathconf0(long j10, int i10) throws UnixException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int read(int i10, long j10, int i11) throws UnixException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native byte[] readdir(long j10) throws UnixException;

    private static native byte[] readlink0(long j10) throws UnixException;

    private static native byte[] realpath0(long j10) throws UnixException;

    private static native void rename0(long j10, long j11) throws UnixException;

    private static native void renameat0(int i10, long j10, int i11, long j11) throws UnixException;

    private static native void rmdir0(long j10) throws UnixException;

    private static native void stat0(long j10, UnixFileAttributes unixFileAttributes) throws UnixException;

    private static native int stat1(long j10);

    private static native void statvfs0(long j10, UnixFileStoreAttributes unixFileStoreAttributes) throws UnixException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native byte[] strerror(int i10);

    private static native void symlink0(long j10, long j11) throws UnixException;

    private static native void unlink0(long j10) throws UnixException;

    private static native void unlinkat0(int i10, long j10, int i11) throws UnixException;

    private static native void utimes0(long j10, long j11, long j12) throws UnixException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int write(int i10, long j10, int i11) throws UnixException;

    private static NativeBuffer copyToNativeBuffer(UnixPath path) {
        byte[] cstr = path.getByteArrayForSysCalls();
        int size = cstr.length + 1;
        NativeBuffer buffer = NativeBuffers.getNativeBufferFromCache(size);
        if (buffer == null) {
            buffer = NativeBuffers.allocNativeBuffer(size);
        } else if (buffer.owner() == path) {
            return buffer;
        }
        NativeBuffers.copyCStringToNativeBuffer(cstr, buffer);
        buffer.setOwner(path);
        return buffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int open(UnixPath path, int flags, int mode) throws UnixException {
        NativeBuffer buffer = copyToNativeBuffer(path);
        try {
            return open0(buffer.address(), flags, mode);
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int openat(int dfd, byte[] path, int flags, int mode) throws UnixException {
        NativeBuffer buffer = NativeBuffers.asNativeBuffer(path);
        try {
            return openat0(dfd, buffer.address(), flags, mode);
        } finally {
            buffer.release();
        }
    }

    static long fopen(UnixPath filename, String mode) throws UnixException {
        NativeBuffer pathBuffer = copyToNativeBuffer(filename);
        NativeBuffer modeBuffer = NativeBuffers.asNativeBuffer(Util.toBytes(mode));
        try {
            return fopen0(pathBuffer.address(), modeBuffer.address());
        } finally {
            modeBuffer.release();
            pathBuffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void link(UnixPath existing, UnixPath newfile) throws UnixException {
        NativeBuffer existingBuffer = copyToNativeBuffer(existing);
        NativeBuffer newBuffer = copyToNativeBuffer(newfile);
        try {
            link0(existingBuffer.address(), newBuffer.address());
        } finally {
            newBuffer.release();
            existingBuffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void unlink(UnixPath path) throws UnixException {
        NativeBuffer buffer = copyToNativeBuffer(path);
        try {
            unlink0(buffer.address());
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void unlinkat(int dfd, byte[] path, int flag) throws UnixException {
        NativeBuffer buffer = NativeBuffers.asNativeBuffer(path);
        try {
            unlinkat0(dfd, buffer.address(), flag);
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void mknod(UnixPath path, int mode, long dev) throws UnixException {
        NativeBuffer buffer = copyToNativeBuffer(path);
        try {
            mknod0(buffer.address(), mode, dev);
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void rename(UnixPath from, UnixPath to) throws UnixException {
        NativeBuffer fromBuffer = copyToNativeBuffer(from);
        NativeBuffer toBuffer = copyToNativeBuffer(to);
        try {
            rename0(fromBuffer.address(), toBuffer.address());
        } finally {
            toBuffer.release();
            fromBuffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void renameat(int fromfd, byte[] from, int tofd, byte[] to) throws UnixException {
        NativeBuffer fromBuffer = NativeBuffers.asNativeBuffer(from);
        NativeBuffer toBuffer = NativeBuffers.asNativeBuffer(to);
        try {
            renameat0(fromfd, fromBuffer.address(), tofd, toBuffer.address());
        } finally {
            toBuffer.release();
            fromBuffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void mkdir(UnixPath path, int mode) throws UnixException {
        NativeBuffer buffer = copyToNativeBuffer(path);
        try {
            mkdir0(buffer.address(), mode);
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void rmdir(UnixPath path) throws UnixException {
        NativeBuffer buffer = copyToNativeBuffer(path);
        try {
            rmdir0(buffer.address());
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] readlink(UnixPath path) throws UnixException {
        NativeBuffer buffer = copyToNativeBuffer(path);
        try {
            return readlink0(buffer.address());
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] realpath(UnixPath path) throws UnixException {
        NativeBuffer buffer = copyToNativeBuffer(path);
        try {
            return realpath0(buffer.address());
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void symlink(byte[] name1, UnixPath name2) throws UnixException {
        NativeBuffer targetBuffer = NativeBuffers.asNativeBuffer(name1);
        NativeBuffer linkBuffer = copyToNativeBuffer(name2);
        try {
            symlink0(targetBuffer.address(), linkBuffer.address());
        } finally {
            linkBuffer.release();
            targetBuffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void stat(UnixPath path, UnixFileAttributes attrs) throws UnixException {
        NativeBuffer buffer = copyToNativeBuffer(path);
        try {
            stat0(buffer.address(), attrs);
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int stat(UnixPath path) {
        NativeBuffer buffer = copyToNativeBuffer(path);
        try {
            return stat1(buffer.address());
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void lstat(UnixPath path, UnixFileAttributes attrs) throws UnixException {
        NativeBuffer buffer = copyToNativeBuffer(path);
        try {
            lstat0(buffer.address(), attrs);
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fstatat(int dfd, byte[] path, int flag, UnixFileAttributes attrs) throws UnixException {
        NativeBuffer buffer = NativeBuffers.asNativeBuffer(path);
        try {
            fstatat0(dfd, buffer.address(), flag, attrs);
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void chown(UnixPath path, int uid, int gid) throws UnixException {
        NativeBuffer buffer = copyToNativeBuffer(path);
        try {
            chown0(buffer.address(), uid, gid);
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void lchown(UnixPath path, int uid, int gid) throws UnixException {
        NativeBuffer buffer = copyToNativeBuffer(path);
        try {
            lchown0(buffer.address(), uid, gid);
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void chmod(UnixPath path, int mode) throws UnixException {
        NativeBuffer buffer = copyToNativeBuffer(path);
        try {
            chmod0(buffer.address(), mode);
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void utimes(UnixPath path, long times0, long times1) throws UnixException {
        NativeBuffer buffer = copyToNativeBuffer(path);
        try {
            utimes0(buffer.address(), times0, times1);
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long opendir(UnixPath path) throws UnixException {
        NativeBuffer buffer = copyToNativeBuffer(path);
        try {
            return opendir0(buffer.address());
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void access(UnixPath path, int amode) throws UnixException {
        NativeBuffer buffer = copyToNativeBuffer(path);
        try {
            access0(buffer.address(), amode);
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean exists(UnixPath path) {
        NativeBuffer buffer = copyToNativeBuffer(path);
        try {
            return exists0(buffer.address());
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getpwnam(String name) throws UnixException {
        NativeBuffer buffer = NativeBuffers.asNativeBuffer(Util.toBytes(name));
        try {
            return getpwnam0(buffer.address());
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getgrnam(String name) throws UnixException {
        NativeBuffer buffer = NativeBuffers.asNativeBuffer(Util.toBytes(name));
        try {
            return getgrnam0(buffer.address());
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void statvfs(UnixPath path, UnixFileStoreAttributes attrs) throws UnixException {
        NativeBuffer buffer = copyToNativeBuffer(path);
        try {
            statvfs0(buffer.address(), attrs);
        } finally {
            buffer.release();
        }
    }

    static long pathconf(UnixPath path, int name) throws UnixException {
        NativeBuffer buffer = copyToNativeBuffer(path);
        try {
            return pathconf0(buffer.address(), name);
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean openatSupported() {
        return (capabilities & 2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean futimesSupported() {
        return (capabilities & 4) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean birthtimeSupported() {
        return (capabilities & 65536) != 0;
    }
}
