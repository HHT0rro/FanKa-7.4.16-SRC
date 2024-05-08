package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.Pipe;
import java.nio.channels.spi.SelectorProvider;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SinkChannelImpl extends Pipe.SinkChannel implements SelChImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ST_INUSE = 0;
    private static final int ST_KILLED = 1;
    private static final int ST_UNINITIALIZED = -1;

    /* renamed from: nd, reason: collision with root package name */
    private static final NativeDispatcher f53727nd = new FileDispatcherImpl();

    /* renamed from: fd, reason: collision with root package name */
    FileDescriptor f53728fd;
    int fdVal;
    private final Object lock;
    private volatile int state;
    private final Object stateLock;
    private volatile long thread;

    @Override // sun.nio.ch.SelChImpl
    public FileDescriptor getFD() {
        return this.f53728fd;
    }

    @Override // sun.nio.ch.SelChImpl
    public int getFDVal() {
        return this.fdVal;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SinkChannelImpl(SelectorProvider sp, FileDescriptor fd2) {
        super(sp);
        this.thread = 0L;
        this.lock = new Object();
        this.stateLock = new Object();
        this.state = -1;
        this.f53728fd = fd2;
        this.fdVal = IOUtil.fdVal(fd2);
        this.state = 0;
    }

    @Override // java.nio.channels.spi.AbstractSelectableChannel
    protected void implCloseSelectableChannel() throws IOException {
        synchronized (this.stateLock) {
            if (this.state != 1) {
                f53727nd.preClose(this.f53728fd);
            }
            long th = this.thread;
            if (th != 0) {
                NativeThread.signal(th);
            }
            if (!isRegistered()) {
                kill();
            }
        }
    }

    @Override // sun.nio.ch.SelChImpl
    public void kill() throws IOException {
        synchronized (this.stateLock) {
            if (this.state == 1) {
                return;
            }
            if (this.state == -1) {
                this.state = 1;
            } else {
                f53727nd.close(this.f53728fd);
                this.state = 1;
            }
        }
    }

    @Override // java.nio.channels.spi.AbstractSelectableChannel
    protected void implConfigureBlocking(boolean block) throws IOException {
        IOUtil.configureBlocking(this.f53728fd, block);
    }

    public boolean translateReadyOps(int ops, int initialOps, SelectionKeyImpl sk) {
        int intOps = sk.nioInterestOps();
        int oldOps = sk.nioReadyOps();
        int newOps = initialOps;
        if ((Net.POLLNVAL & ops) != 0) {
            throw new Error("POLLNVAL detected");
        }
        if (((Net.POLLERR | Net.POLLHUP) & ops) != 0) {
            sk.nioReadyOps(intOps);
            return ((~oldOps) & intOps) != 0;
        }
        if ((Net.POLLOUT & ops) != 0 && (intOps & 4) != 0) {
            newOps |= 4;
        }
        sk.nioReadyOps(newOps);
        return ((~oldOps) & newOps) != 0;
    }

    @Override // sun.nio.ch.SelChImpl
    public boolean translateAndUpdateReadyOps(int ops, SelectionKeyImpl sk) {
        return translateReadyOps(ops, sk.nioReadyOps(), sk);
    }

    @Override // sun.nio.ch.SelChImpl
    public boolean translateAndSetReadyOps(int ops, SelectionKeyImpl sk) {
        return translateReadyOps(ops, 0, sk);
    }

    @Override // sun.nio.ch.SelChImpl
    public void translateAndSetInterestOps(int ops, SelectionKeyImpl sk) {
        if (ops == 4) {
            ops = Net.POLLOUT;
        }
        sk.selector.putEventOps(sk, ops);
    }

    private void ensureOpen() throws IOException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer src) throws IOException {
        ensureOpen();
        synchronized (this.lock) {
            int n10 = 0;
            boolean z10 = true;
            try {
                begin();
                if (!isOpen()) {
                    return 0;
                }
                this.thread = NativeThread.current();
                do {
                    n10 = IOUtil.write(this.f53728fd, src, -1L, f53727nd);
                    if (n10 != -3) {
                        break;
                    }
                } while (isOpen());
                int normalize = IOStatus.normalize(n10);
                this.thread = 0L;
                if (n10 <= 0 && n10 != -2) {
                    z10 = false;
                }
                end(z10);
                return normalize;
            } finally {
                this.thread = 0L;
                if (n10 <= 0 && n10 != -2) {
                    z10 = false;
                }
                end(z10);
            }
        }
    }

    @Override // java.nio.channels.GatheringByteChannel
    public long write(ByteBuffer[] srcs) throws IOException {
        if (srcs == null) {
            throw new NullPointerException();
        }
        ensureOpen();
        synchronized (this.lock) {
            long n10 = 0;
            try {
                begin();
                if (!isOpen()) {
                    return 0L;
                }
                this.thread = NativeThread.current();
                do {
                    n10 = IOUtil.write(this.f53728fd, srcs, f53727nd);
                    if (n10 != -3) {
                        break;
                    }
                } while (isOpen());
                long normalize = IOStatus.normalize(n10);
                this.thread = 0L;
                end(n10 > 0 || n10 == -2);
                return normalize;
            } finally {
                this.thread = 0L;
                end(n10 > 0 || n10 == -2);
            }
        }
    }

    @Override // java.nio.channels.GatheringByteChannel
    public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
        if (offset < 0 || length < 0 || offset > srcs.length - length) {
            throw new IndexOutOfBoundsException();
        }
        return write(Util.subsequence(srcs, offset, length));
    }
}
