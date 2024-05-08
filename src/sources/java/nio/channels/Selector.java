package java.nio.channels;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.spi.SelectorProvider;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Selector implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close() throws IOException;

    public abstract boolean isOpen();

    public abstract Set<SelectionKey> keys();

    public abstract SelectorProvider provider();

    public abstract int select() throws IOException;

    public abstract int select(long j10) throws IOException;

    public abstract int selectNow() throws IOException;

    public abstract Set<SelectionKey> selectedKeys();

    public abstract Selector wakeup();

    public static Selector open() throws IOException {
        return SelectorProvider.provider().openSelector();
    }

    public int select(Consumer<SelectionKey> action, long timeout) throws IOException {
        if (timeout < 0) {
            throw new IllegalArgumentException("Negative timeout");
        }
        return doSelect((Consumer) Objects.requireNonNull(action), timeout);
    }

    public int select(Consumer<SelectionKey> action) throws IOException {
        return select(action, 0L);
    }

    public int selectNow(Consumer<SelectionKey> action) throws IOException {
        return doSelect((Consumer) Objects.requireNonNull(action), -1L);
    }

    private int doSelect(final Consumer<SelectionKey> action, long timeout) throws IOException {
        int numKeySelected;
        synchronized (this) {
            Set<SelectionKey> selectedKeys = selectedKeys();
            synchronized (selectedKeys) {
                selectedKeys.clear();
                if (timeout < 0) {
                    numKeySelected = selectNow();
                } else {
                    numKeySelected = select(timeout);
                }
                Set<SelectionKey> keysToConsume = Set.copyOf(selectedKeys);
                selectedKeys.clear();
                keysToConsume.forEach(new Consumer() { // from class: java.nio.channels.Selector$$ExternalSyntheticLambda0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        Selector.this.lambda$doSelect$0(action, (SelectionKey) obj);
                    }
                });
            }
        }
        return numKeySelected;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doSelect$0(Consumer action, SelectionKey k10) {
        action.accept(k10);
        if (!isOpen()) {
            throw new ClosedSelectorException();
        }
    }
}
