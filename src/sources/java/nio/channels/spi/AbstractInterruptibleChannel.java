package java.nio.channels.spi;

import java.io.IOException;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.Channel;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.InterruptibleChannel;
import sun.nio.ch.Interruptible;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractInterruptibleChannel implements Channel, InterruptibleChannel {
    private final Object closeLock = new Object();
    private volatile boolean closed;
    private volatile Thread interrupted;
    private Interruptible interruptor;

    protected abstract void implCloseChannel() throws IOException;

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this.closeLock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            implCloseChannel();
        }
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.closed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void begin() {
        if (this.interruptor == null) {
            this.interruptor = new Interruptible() { // from class: java.nio.channels.spi.AbstractInterruptibleChannel.1
                @Override // sun.nio.ch.Interruptible
                public void interrupt(Thread target) {
                    synchronized (AbstractInterruptibleChannel.this.closeLock) {
                        if (AbstractInterruptibleChannel.this.closed) {
                            return;
                        }
                        AbstractInterruptibleChannel.this.closed = true;
                        AbstractInterruptibleChannel.this.interrupted = target;
                        try {
                            AbstractInterruptibleChannel.this.implCloseChannel();
                        } catch (IOException e2) {
                        }
                    }
                }
            };
        }
        blockedOn(this.interruptor);
        Thread me2 = Thread.currentThread();
        if (me2.isInterrupted()) {
            this.interruptor.interrupt(me2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void end(boolean completed) throws AsynchronousCloseException {
        blockedOn(null);
        Thread interrupted = this.interrupted;
        if (interrupted != null && interrupted == Thread.currentThread()) {
            this.interrupted = null;
            throw new ClosedByInterruptException();
        }
        if (!completed && this.closed) {
            throw new AsynchronousCloseException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void blockedOn(Interruptible intr) {
        Thread.currentThread().blockedOn(intr);
    }
}
