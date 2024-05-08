package sun.nio.ch;

import java.io.IOException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractPollSelectorImpl extends SelectorImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected final int INIT_CAP;
    protected SelectionKeyImpl[] channelArray;
    protected int channelOffset;
    private Object closeLock;
    private boolean closed;
    PollArrayWrapper pollWrapper;
    protected int totalChannels;

    @Override // sun.nio.ch.SelectorImpl
    protected abstract int doSelect(long j10) throws IOException;

    protected abstract void implCloseInterrupt() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractPollSelectorImpl(SelectorProvider sp, int channels, int offset) {
        super(sp);
        this.INIT_CAP = 10;
        this.channelOffset = 0;
        this.closed = false;
        this.closeLock = new Object();
        this.totalChannels = channels;
        this.channelOffset = offset;
    }

    @Override // sun.nio.ch.SelectorImpl
    public void putEventOps(SelectionKeyImpl sk, int ops) {
        synchronized (this.closeLock) {
            if (this.closed) {
                throw new ClosedSelectorException();
            }
            this.pollWrapper.putEventOps(sk.getIndex(), ops);
        }
    }

    @Override // sun.nio.ch.SelectorImpl, java.nio.channels.Selector
    public Selector wakeup() {
        this.pollWrapper.interrupt();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // sun.nio.ch.SelectorImpl
    protected void implClose() throws IOException {
        synchronized (this.closeLock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            for (int i10 = this.channelOffset; i10 < this.totalChannels; i10++) {
                SelectionKeyImpl ski = this.channelArray[i10];
                ski.setIndex(-1);
                deregister(ski);
                SelectableChannel channel = this.channelArray[i10].channel();
                if (!channel.isOpen() && !channel.isRegistered()) {
                    ((SelChImpl) channel).kill();
                }
            }
            implCloseInterrupt();
            this.pollWrapper.free();
            this.pollWrapper = null;
            this.selectedKeys = null;
            this.channelArray = null;
            this.totalChannels = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int updateSelectedKeys() {
        int numKeysUpdated = 0;
        for (int i10 = this.channelOffset; i10 < this.totalChannels; i10++) {
            int rOps = this.pollWrapper.getReventOps(i10);
            if (rOps != 0) {
                SelectionKeyImpl sk = this.channelArray[i10];
                this.pollWrapper.putReventOps(i10, 0);
                if (this.selectedKeys.contains(sk)) {
                    if (sk.channel.translateAndSetReadyOps(rOps, sk)) {
                        numKeysUpdated++;
                    }
                } else {
                    sk.channel.translateAndSetReadyOps(rOps, sk);
                    if ((sk.nioReadyOps() & sk.nioInterestOps()) != 0) {
                        this.selectedKeys.add(sk);
                        numKeysUpdated++;
                    }
                }
            }
        }
        return numKeysUpdated;
    }

    @Override // sun.nio.ch.SelectorImpl
    protected void implRegister(SelectionKeyImpl ski) {
        synchronized (this.closeLock) {
            if (this.closed) {
                throw new ClosedSelectorException();
            }
            if (this.channelArray.length == this.totalChannels) {
                int newSize = this.pollWrapper.totalChannels * 2;
                SelectionKeyImpl[] temp = new SelectionKeyImpl[newSize];
                for (int i10 = this.channelOffset; i10 < this.totalChannels; i10++) {
                    temp[i10] = this.channelArray[i10];
                }
                this.channelArray = temp;
                this.pollWrapper.grow(newSize);
            }
            SelectionKeyImpl[] selectionKeyImplArr = this.channelArray;
            int i11 = this.totalChannels;
            selectionKeyImplArr[i11] = ski;
            ski.setIndex(i11);
            this.pollWrapper.addEntry(ski.channel);
            this.totalChannels++;
            this.keys.add(ski);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // sun.nio.ch.SelectorImpl
    protected void implDereg(SelectionKeyImpl ski) throws IOException {
        int i10 = ski.getIndex();
        int i11 = this.totalChannels;
        if (i10 != i11 - 1) {
            SelectionKeyImpl[] selectionKeyImplArr = this.channelArray;
            SelectionKeyImpl endChannel = selectionKeyImplArr[i11 - 1];
            selectionKeyImplArr[i10] = endChannel;
            endChannel.setIndex(i10);
            this.pollWrapper.release(i10);
            PollArrayWrapper pollArrayWrapper = this.pollWrapper;
            PollArrayWrapper.replaceEntry(pollArrayWrapper, this.totalChannels - 1, pollArrayWrapper, i10);
        } else {
            this.pollWrapper.release(i10);
        }
        SelectionKeyImpl[] selectionKeyImplArr2 = this.channelArray;
        int i12 = this.totalChannels;
        selectionKeyImplArr2[i12 - 1] = null;
        this.totalChannels = i12 - 1;
        PollArrayWrapper pollArrayWrapper2 = this.pollWrapper;
        pollArrayWrapper2.totalChannels--;
        ski.setIndex(-1);
        this.keys.remove(ski);
        this.selectedKeys.remove(ski);
        deregister(ski);
        SelectableChannel channel = ski.channel();
        if (!channel.isOpen() && !channel.isRegistered()) {
            ((SelChImpl) channel).kill();
        }
    }
}
