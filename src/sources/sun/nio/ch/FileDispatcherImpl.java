package sun.nio.ch;

import dalvik.system.BlockGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.SelectableChannel;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class FileDispatcherImpl extends FileDispatcher {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void close0(FileDescriptor fileDescriptor) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void closeIntFD(int i10) throws IOException;

    static native int force0(FileDescriptor fileDescriptor, boolean z10) throws IOException;

    static native int lock0(FileDescriptor fileDescriptor, boolean z10, long j10, long j11, boolean z11) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void preClose0(FileDescriptor fileDescriptor) throws IOException;

    static native int pread0(FileDescriptor fileDescriptor, long j10, int i10, long j11) throws IOException;

    static native int pwrite0(FileDescriptor fileDescriptor, long j10, int i10, long j11) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int read0(FileDescriptor fileDescriptor, long j10, int i10) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long readv0(FileDescriptor fileDescriptor, long j10, int i10) throws IOException;

    static native void release0(FileDescriptor fileDescriptor, long j10, long j11) throws IOException;

    static native long size0(FileDescriptor fileDescriptor) throws IOException;

    static native int truncate0(FileDescriptor fileDescriptor, long j10) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int write0(FileDescriptor fileDescriptor, long j10, int i10) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long writev0(FileDescriptor fileDescriptor, long j10, int i10) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileDispatcherImpl(boolean append) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileDispatcherImpl() {
    }

    @Override // sun.nio.ch.NativeDispatcher
    int read(FileDescriptor fd2, long address, int len) throws IOException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return read0(fd2, address, len);
    }

    @Override // sun.nio.ch.NativeDispatcher
    int pread(FileDescriptor fd2, long address, int len, long position) throws IOException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return pread0(fd2, address, len, position);
    }

    @Override // sun.nio.ch.NativeDispatcher
    long readv(FileDescriptor fd2, long address, int len) throws IOException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return readv0(fd2, address, len);
    }

    @Override // sun.nio.ch.NativeDispatcher
    int write(FileDescriptor fd2, long address, int len) throws IOException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return write0(fd2, address, len);
    }

    @Override // sun.nio.ch.NativeDispatcher
    int pwrite(FileDescriptor fd2, long address, int len, long position) throws IOException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return pwrite0(fd2, address, len, position);
    }

    @Override // sun.nio.ch.NativeDispatcher
    long writev(FileDescriptor fd2, long address, int len) throws IOException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return writev0(fd2, address, len);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.ch.FileDispatcher
    public int force(FileDescriptor fd2, boolean metaData) throws IOException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return force0(fd2, metaData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.ch.FileDispatcher
    public int truncate(FileDescriptor fd2, long size) throws IOException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return truncate0(fd2, size);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.ch.FileDispatcher
    public long size(FileDescriptor fd2) throws IOException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return size0(fd2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.ch.FileDispatcher
    public int lock(FileDescriptor fd2, boolean blocking, long pos, long size, boolean shared) throws IOException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return lock0(fd2, blocking, pos, size, shared);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.ch.FileDispatcher
    public void release(FileDescriptor fd2, long pos, long size) throws IOException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        release0(fd2, pos, size);
    }

    @Override // sun.nio.ch.NativeDispatcher
    void close(FileDescriptor fd2) throws IOException {
        close0(fd2);
    }

    @Override // sun.nio.ch.NativeDispatcher
    void preClose(FileDescriptor fd2) throws IOException {
        preClose0(fd2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.ch.FileDispatcher
    public FileDescriptor duplicateForMapping(FileDescriptor fd2) {
        return new FileDescriptor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.ch.FileDispatcher
    public boolean canTransferToDirectly(SelectableChannel sc2) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.ch.FileDispatcher
    public boolean transferToDirectlyNeedsPositionLock() {
        return false;
    }
}
