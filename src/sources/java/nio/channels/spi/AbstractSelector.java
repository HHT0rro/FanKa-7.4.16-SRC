package java.nio.channels.spi;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import sun.nio.ch.Interruptible;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractSelector extends Selector {
    private final SelectorProvider provider;
    private final AtomicBoolean selectorOpen = new AtomicBoolean(true);
    private final Set<SelectionKey> cancelledKeys = new HashSet();
    private Interruptible interruptor = null;

    protected abstract void implCloseSelector() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SelectionKey register(AbstractSelectableChannel abstractSelectableChannel, int i10, Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractSelector(SelectorProvider provider) {
        this.provider = provider;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancel(SelectionKey k10) {
        synchronized (this.cancelledKeys) {
            this.cancelledKeys.add(k10);
        }
    }

    @Override // java.nio.channels.Selector, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        boolean open = this.selectorOpen.getAndSet(false);
        if (!open) {
            return;
        }
        implCloseSelector();
    }

    @Override // java.nio.channels.Selector
    public final boolean isOpen() {
        return this.selectorOpen.get();
    }

    @Override // java.nio.channels.Selector
    public final SelectorProvider provider() {
        return this.provider;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Set<SelectionKey> cancelledKeys() {
        return this.cancelledKeys;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void deregister(AbstractSelectionKey key) {
        ((AbstractSelectableChannel) key.channel()).removeKey(key);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void begin() {
        if (this.interruptor == null) {
            this.interruptor = new Interruptible() { // from class: java.nio.channels.spi.AbstractSelector.1
                @Override // sun.nio.ch.Interruptible
                public void interrupt(Thread ignore) {
                    AbstractSelector.this.wakeup();
                }
            };
        }
        AbstractInterruptibleChannel.blockedOn(this.interruptor);
        Thread me2 = Thread.currentThread();
        if (me2.isInterrupted()) {
            this.interruptor.interrupt(me2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void end() {
        AbstractInterruptibleChannel.blockedOn(null);
    }
}
