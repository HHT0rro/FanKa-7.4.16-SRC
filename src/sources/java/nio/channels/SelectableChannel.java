package java.nio.channels;

import java.io.IOException;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.nio.channels.spi.SelectorProvider;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class SelectableChannel extends AbstractInterruptibleChannel implements Channel {
    public abstract Object blockingLock();

    public abstract SelectableChannel configureBlocking(boolean z10) throws IOException;

    public abstract boolean isBlocking();

    public abstract boolean isRegistered();

    public abstract SelectionKey keyFor(Selector selector);

    public abstract SelectorProvider provider();

    public abstract SelectionKey register(Selector selector, int i10, Object obj) throws ClosedChannelException;

    public abstract int validOps();

    public final SelectionKey register(Selector sel, int ops) throws ClosedChannelException {
        return register(sel, ops, null);
    }
}
