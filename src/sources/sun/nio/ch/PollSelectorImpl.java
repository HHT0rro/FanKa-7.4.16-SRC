package sun.nio.ch;

import java.io.IOException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class PollSelectorImpl extends AbstractPollSelectorImpl {
    private int fd0;
    private int fd1;
    private Object interruptLock;
    private boolean interruptTriggered;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PollSelectorImpl(SelectorProvider sp) {
        super(sp, 1, 1);
        this.interruptLock = new Object();
        this.interruptTriggered = false;
        long pipeFds = IOUtil.makePipe(false);
        this.fd0 = (int) (pipeFds >>> 32);
        this.fd1 = (int) pipeFds;
        try {
            this.pollWrapper = new PollArrayWrapper(10);
            this.pollWrapper.initInterrupt(this.fd0, this.fd1);
            this.channelArray = new SelectionKeyImpl[10];
        } finally {
        }
    }

    @Override // sun.nio.ch.AbstractPollSelectorImpl, sun.nio.ch.SelectorImpl
    protected int doSelect(long timeout) throws IOException {
        if (this.channelArray == null) {
            throw new ClosedSelectorException();
        }
        processDeregisterQueue();
        try {
            begin();
            this.pollWrapper.poll(this.totalChannels, 0, timeout);
            end();
            processDeregisterQueue();
            int numKeysUpdated = updateSelectedKeys();
            if (this.pollWrapper.getReventOps(0) != 0) {
                this.pollWrapper.putReventOps(0, 0);
                synchronized (this.interruptLock) {
                    IOUtil.drain(this.fd0);
                    this.interruptTriggered = false;
                }
            }
            return numKeysUpdated;
        } catch (Throwable th) {
            end();
            throw th;
        }
    }

    @Override // sun.nio.ch.AbstractPollSelectorImpl
    protected void implCloseInterrupt() throws IOException {
        synchronized (this.interruptLock) {
            this.interruptTriggered = true;
        }
        FileDispatcherImpl.closeIntFD(this.fd0);
        FileDispatcherImpl.closeIntFD(this.fd1);
        this.fd0 = -1;
        this.fd1 = -1;
        this.pollWrapper.release(0);
    }

    @Override // sun.nio.ch.AbstractPollSelectorImpl, sun.nio.ch.SelectorImpl, java.nio.channels.Selector
    public Selector wakeup() {
        synchronized (this.interruptLock) {
            if (!this.interruptTriggered) {
                this.pollWrapper.interrupt();
                this.interruptTriggered = true;
            }
        }
        return this;
    }
}
