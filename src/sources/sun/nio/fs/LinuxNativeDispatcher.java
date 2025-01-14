package sun.nio.fs;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class LinuxNativeDispatcher extends UnixNativeDispatcher {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void endmntent(long j10) throws UnixException;

    private static native int fgetxattr0(int i10, long j10, long j11, int i11) throws UnixException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int flistxattr(int i10, long j10, int i11) throws UnixException;

    private static native void fremovexattr0(int i10, long j10) throws UnixException;

    private static native void fsetxattr0(int i10, long j10, long j11, int i11) throws UnixException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int getmntent(long j10, UnixMountEntry unixMountEntry) throws UnixException;

    private static native void init();

    private static native long setmntent0(long j10, long j11) throws UnixException;

    private LinuxNativeDispatcher() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long setmntent(byte[] filename, byte[] type) throws UnixException {
        NativeBuffer pathBuffer = NativeBuffers.asNativeBuffer(filename);
        NativeBuffer typeBuffer = NativeBuffers.asNativeBuffer(type);
        try {
            return setmntent0(pathBuffer.address(), typeBuffer.address());
        } finally {
            typeBuffer.release();
            pathBuffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int fgetxattr(int filedes, byte[] name, long valueAddress, int valueLen) throws UnixException {
        NativeBuffer buffer = NativeBuffers.asNativeBuffer(name);
        try {
            return fgetxattr0(filedes, buffer.address(), valueAddress, valueLen);
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fsetxattr(int filedes, byte[] name, long valueAddress, int valueLen) throws UnixException {
        NativeBuffer buffer = NativeBuffers.asNativeBuffer(name);
        try {
            fsetxattr0(filedes, buffer.address(), valueAddress, valueLen);
        } finally {
            buffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fremovexattr(int filedes, byte[] name) throws UnixException {
        NativeBuffer buffer = NativeBuffers.asNativeBuffer(name);
        try {
            fremovexattr0(filedes, buffer.address());
        } finally {
            buffer.release();
        }
    }

    static {
        init();
    }
}
