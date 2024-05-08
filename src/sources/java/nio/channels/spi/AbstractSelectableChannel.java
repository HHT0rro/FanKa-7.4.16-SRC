package java.nio.channels.spi;

import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractSelectableChannel extends SelectableChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private volatile boolean nonBlocking;
    private final SelectorProvider provider;
    private SelectionKey[] keys = null;
    private int keyCount = 0;
    private final Object keyLock = new Object();
    private final Object regLock = new Object();

    protected abstract void implCloseSelectableChannel() throws IOException;

    protected abstract void implConfigureBlocking(boolean z10) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractSelectableChannel(SelectorProvider provider) {
        this.provider = provider;
    }

    @Override // java.nio.channels.SelectableChannel
    public final SelectorProvider provider() {
        return this.provider;
    }

    private void addKey(SelectionKey k10) {
        int i10 = 0;
        SelectionKey[] selectionKeyArr = this.keys;
        if (selectionKeyArr != null && this.keyCount < selectionKeyArr.length) {
            i10 = 0;
            while (true) {
                SelectionKey[] selectionKeyArr2 = this.keys;
                if (i10 >= selectionKeyArr2.length || selectionKeyArr2[i10] == null) {
                    break;
                } else {
                    i10++;
                }
            }
        } else if (selectionKeyArr != null) {
            int n10 = selectionKeyArr.length * 2;
            SelectionKey[] ks = new SelectionKey[n10];
            int i11 = 0;
            while (true) {
                SelectionKey[] selectionKeyArr3 = this.keys;
                if (i11 >= selectionKeyArr3.length) {
                    break;
                }
                ks[i11] = selectionKeyArr3[i11];
                i11++;
            }
            this.keys = ks;
            i10 = this.keyCount;
        } else {
            this.keys = new SelectionKey[2];
        }
        this.keys[i10] = k10;
        this.keyCount++;
    }

    private SelectionKey findKey(Selector sel) {
        if (this.keys == null) {
            return null;
        }
        int i10 = 0;
        while (true) {
            SelectionKey[] selectionKeyArr = this.keys;
            if (i10 >= selectionKeyArr.length) {
                return null;
            }
            SelectionKey selectionKey = selectionKeyArr[i10];
            if (selectionKey == null || selectionKey.selector() != sel) {
                i10++;
            } else {
                return this.keys[i10];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeKey(SelectionKey k10) {
        synchronized (this.keyLock) {
            int i10 = 0;
            while (true) {
                SelectionKey[] selectionKeyArr = this.keys;
                if (i10 < selectionKeyArr.length) {
                    if (selectionKeyArr[i10] == k10) {
                        selectionKeyArr[i10] = null;
                        this.keyCount--;
                    }
                    i10++;
                } else {
                    ((AbstractSelectionKey) k10).invalidate();
                }
            }
        }
    }

    private boolean haveValidKeys() {
        synchronized (this.keyLock) {
            if (this.keyCount == 0) {
                return false;
            }
            int i10 = 0;
            while (true) {
                SelectionKey[] selectionKeyArr = this.keys;
                if (i10 >= selectionKeyArr.length) {
                    return false;
                }
                SelectionKey selectionKey = selectionKeyArr[i10];
                if (selectionKey != null && selectionKey.isValid()) {
                    return true;
                }
                i10++;
            }
        }
    }

    @Override // java.nio.channels.SelectableChannel
    public final boolean isRegistered() {
        boolean z10;
        synchronized (this.keyLock) {
            z10 = this.keyCount != 0;
        }
        return z10;
    }

    @Override // java.nio.channels.SelectableChannel
    public final SelectionKey keyFor(Selector sel) {
        SelectionKey findKey;
        synchronized (this.keyLock) {
            findKey = findKey(sel);
        }
        return findKey;
    }

    @Override // java.nio.channels.SelectableChannel
    public final SelectionKey register(Selector sel, int ops, Object att) throws ClosedChannelException {
        SelectionKey k10;
        if (((~validOps()) & ops) != 0) {
            throw new IllegalArgumentException();
        }
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
        synchronized (this.regLock) {
            if (isBlocking()) {
                throw new IllegalBlockingModeException();
            }
            synchronized (this.keyLock) {
                if (!isOpen()) {
                    throw new ClosedChannelException();
                }
                k10 = findKey(sel);
                if (k10 != null) {
                    k10.attach(att);
                    k10.interestOps(ops);
                } else {
                    k10 = ((AbstractSelector) sel).register(this, ops, att);
                    addKey(k10);
                }
            }
        }
        return k10;
    }

    @Override // java.nio.channels.spi.AbstractInterruptibleChannel
    protected final void implCloseChannel() throws IOException {
        implCloseSelectableChannel();
        SelectionKey[] copyOfKeys = null;
        synchronized (this.keyLock) {
            SelectionKey[] selectionKeyArr = this.keys;
            if (selectionKeyArr != null) {
                copyOfKeys = (SelectionKey[]) selectionKeyArr.clone();
            }
        }
        if (copyOfKeys != null) {
            for (SelectionKey k10 : copyOfKeys) {
                if (k10 != null) {
                    k10.cancel();
                }
            }
        }
    }

    @Override // java.nio.channels.SelectableChannel
    public final boolean isBlocking() {
        return !this.nonBlocking;
    }

    @Override // java.nio.channels.SelectableChannel
    public final Object blockingLock() {
        return this.regLock;
    }

    @Override // java.nio.channels.SelectableChannel
    public final SelectableChannel configureBlocking(boolean block) throws IOException {
        synchronized (this.regLock) {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            boolean z10 = true;
            boolean blocking = !this.nonBlocking;
            if (block != blocking) {
                if (block && haveValidKeys()) {
                    throw new IllegalBlockingModeException();
                }
                implConfigureBlocking(block);
                if (block) {
                    z10 = false;
                }
                this.nonBlocking = z10;
            }
        }
        return this;
    }
}
