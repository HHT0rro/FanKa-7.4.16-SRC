package java.nio.channels.spi;

import java.nio.channels.SelectionKey;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractSelectionKey extends SelectionKey {
    private volatile boolean valid = true;

    @Override // java.nio.channels.SelectionKey
    public final boolean isValid() {
        return this.valid;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidate() {
        this.valid = false;
    }

    @Override // java.nio.channels.SelectionKey
    public final void cancel() {
        synchronized (this) {
            if (this.valid) {
                this.valid = false;
                ((AbstractSelector) selector()).cancel(this);
            }
        }
    }
}
