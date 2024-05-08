package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.SelectableChannel;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class FileDispatcher extends NativeDispatcher {
    public static final int INTERRUPTED = 2;
    public static final int LOCKED = 0;
    public static final int NO_LOCK = -1;
    public static final int RET_EX_LOCK = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean canTransferToDirectly(SelectableChannel selectableChannel);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract FileDescriptor duplicateForMapping(FileDescriptor fileDescriptor) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int force(FileDescriptor fileDescriptor, boolean z10) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int lock(FileDescriptor fileDescriptor, boolean z10, long j10, long j11, boolean z11) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void release(FileDescriptor fileDescriptor, long j10, long j11) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long size(FileDescriptor fileDescriptor) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean transferToDirectlyNeedsPositionLock();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int truncate(FileDescriptor fileDescriptor, long j10) throws IOException;
}
