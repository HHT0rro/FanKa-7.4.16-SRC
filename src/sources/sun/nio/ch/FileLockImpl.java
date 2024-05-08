package sun.nio.ch;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.Channel;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FileLockImpl extends FileLock {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private volatile boolean invalid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileLockImpl(FileChannel channel, long position, long size, boolean shared) {
        super(channel, position, size, shared);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileLockImpl(AsynchronousFileChannel channel, long position, long size, boolean shared) {
        super(channel, position, size, shared);
    }

    @Override // java.nio.channels.FileLock
    public boolean isValid() {
        return !this.invalid;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidate() {
        this.invalid = true;
    }

    @Override // java.nio.channels.FileLock
    public synchronized void release() throws IOException {
        Channel ch = acquiredBy();
        if (!ch.isOpen()) {
            throw new ClosedChannelException();
        }
        if (isValid()) {
            if (ch instanceof FileChannelImpl) {
                ((FileChannelImpl) ch).release(this);
            } else if (ch instanceof AsynchronousFileChannelImpl) {
                ((AsynchronousFileChannelImpl) ch).release(this);
            } else {
                throw new AssertionError();
            }
            invalidate();
        }
    }
}
