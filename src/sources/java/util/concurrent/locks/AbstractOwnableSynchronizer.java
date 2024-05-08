package java.util.concurrent.locks;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractOwnableSynchronizer implements Serializable {
    private static final long serialVersionUID = 3737899427754241961L;
    private transient Thread exclusiveOwnerThread;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setExclusiveOwnerThread(Thread thread) {
        this.exclusiveOwnerThread = thread;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Thread getExclusiveOwnerThread() {
        return this.exclusiveOwnerThread;
    }
}
