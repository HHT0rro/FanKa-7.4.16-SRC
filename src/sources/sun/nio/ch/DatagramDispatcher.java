package sun.nio.ch;

import dalvik.system.BlockGuard;
import java.io.FileDescriptor;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class DatagramDispatcher extends NativeDispatcher {
    static native int read0(FileDescriptor fileDescriptor, long j10, int i10) throws IOException;

    static native long readv0(FileDescriptor fileDescriptor, long j10, int i10) throws IOException;

    static native int write0(FileDescriptor fileDescriptor, long j10, int i10) throws IOException;

    static native long writev0(FileDescriptor fileDescriptor, long j10, int i10) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.ch.NativeDispatcher
    public int read(FileDescriptor fd2, long address, int len) throws IOException {
        BlockGuard.getThreadPolicy().onNetwork();
        return read0(fd2, address, len);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.ch.NativeDispatcher
    public long readv(FileDescriptor fd2, long address, int len) throws IOException {
        BlockGuard.getThreadPolicy().onNetwork();
        return readv0(fd2, address, len);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.ch.NativeDispatcher
    public int write(FileDescriptor fd2, long address, int len) throws IOException {
        BlockGuard.getThreadPolicy().onNetwork();
        return write0(fd2, address, len);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.ch.NativeDispatcher
    public long writev(FileDescriptor fd2, long address, int len) throws IOException {
        BlockGuard.getThreadPolicy().onNetwork();
        return writev0(fd2, address, len);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.ch.NativeDispatcher
    public void close(FileDescriptor fd2) throws IOException {
        FileDispatcherImpl.close0(fd2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.ch.NativeDispatcher
    public void preClose(FileDescriptor fd2) throws IOException {
        FileDispatcherImpl.preClose0(fd2);
    }
}
