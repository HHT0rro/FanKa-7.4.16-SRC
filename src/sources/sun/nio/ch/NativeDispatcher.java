package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class NativeDispatcher {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void close(FileDescriptor fileDescriptor) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int read(FileDescriptor fileDescriptor, long j10, int i10) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long readv(FileDescriptor fileDescriptor, long j10, int i10) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int write(FileDescriptor fileDescriptor, long j10, int i10) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long writev(FileDescriptor fileDescriptor, long j10, int i10) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean needsPositionLock() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int pread(FileDescriptor fd2, long address, int len, long position) throws IOException {
        throw new IOException("Operation Unsupported");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int pwrite(FileDescriptor fd2, long address, int len, long position) throws IOException {
        throw new IOException("Operation Unsupported");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void preClose(FileDescriptor fd2) throws IOException {
    }
}
