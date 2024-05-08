package sun.nio.ch;

import java.io.IOException;
import java.net.SocketException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.IllegalSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class SelectorImpl extends AbstractSelector {
    protected HashSet<SelectionKey> keys;
    private Set<SelectionKey> publicKeys;
    private Set<SelectionKey> publicSelectedKeys;
    protected Set<SelectionKey> selectedKeys;

    protected abstract int doSelect(long j10) throws IOException;

    protected abstract void implClose() throws IOException;

    protected abstract void implDereg(SelectionKeyImpl selectionKeyImpl) throws IOException;

    protected abstract void implRegister(SelectionKeyImpl selectionKeyImpl);

    @Override // java.nio.channels.Selector
    public abstract Selector wakeup();

    /* JADX INFO: Access modifiers changed from: protected */
    public SelectorImpl(SelectorProvider sp) {
        super(sp);
        this.keys = new HashSet<>();
        this.selectedKeys = new HashSet();
        if (Util.atBugLevel("1.4")) {
            this.publicKeys = this.keys;
            this.publicSelectedKeys = this.selectedKeys;
        } else {
            this.publicKeys = Collections.unmodifiableSet(this.keys);
            this.publicSelectedKeys = Util.ungrowableSet(this.selectedKeys);
        }
    }

    @Override // java.nio.channels.Selector
    public Set<SelectionKey> keys() {
        if (!isOpen() && !Util.atBugLevel("1.4")) {
            throw new ClosedSelectorException();
        }
        return this.publicKeys;
    }

    @Override // java.nio.channels.Selector
    public Set<SelectionKey> selectedKeys() {
        if (!isOpen() && !Util.atBugLevel("1.4")) {
            throw new ClosedSelectorException();
        }
        return this.publicSelectedKeys;
    }

    private int lockAndDoSelect(long timeout) throws IOException {
        int doSelect;
        synchronized (this) {
            if (!isOpen()) {
                throw new ClosedSelectorException();
            }
            synchronized (this.publicKeys) {
                synchronized (this.publicSelectedKeys) {
                    doSelect = doSelect(timeout);
                }
            }
        }
        return doSelect;
    }

    @Override // java.nio.channels.Selector
    public int select(long timeout) throws IOException {
        if (timeout >= 0) {
            return lockAndDoSelect(timeout == 0 ? -1L : timeout);
        }
        throw new IllegalArgumentException("Negative timeout");
    }

    @Override // java.nio.channels.Selector
    public int select() throws IOException {
        return select(0L);
    }

    @Override // java.nio.channels.Selector
    public int selectNow() throws IOException {
        return lockAndDoSelect(0L);
    }

    @Override // java.nio.channels.spi.AbstractSelector
    public void implCloseSelector() throws IOException {
        wakeup();
        synchronized (this) {
            synchronized (this.publicKeys) {
                synchronized (this.publicSelectedKeys) {
                    implClose();
                }
            }
        }
    }

    public void putEventOps(SelectionKeyImpl sk, int ops) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.nio.channels.spi.AbstractSelector
    public final SelectionKey register(AbstractSelectableChannel abstractSelectableChannel, int ops, Object attachment) {
        if (!(abstractSelectableChannel instanceof SelChImpl)) {
            throw new IllegalSelectorException();
        }
        SelectionKeyImpl k10 = new SelectionKeyImpl((SelChImpl) abstractSelectableChannel, this);
        k10.attach(attachment);
        synchronized (this.publicKeys) {
            implRegister(k10);
        }
        k10.interestOps(ops);
        return k10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processDeregisterQueue() throws IOException {
        Set<SelectionKey> cks = cancelledKeys();
        synchronized (cks) {
            if (!cks.isEmpty()) {
                Iterator<SelectionKey> i10 = cks.iterator2();
                while (i10.hasNext()) {
                    SelectionKeyImpl ski = (SelectionKeyImpl) i10.next();
                    try {
                        try {
                            implDereg(ski);
                        } catch (SocketException se) {
                            throw new IOException("Error deregistering key", se);
                        }
                    } finally {
                        i10.remove();
                    }
                }
            }
        }
    }
}
