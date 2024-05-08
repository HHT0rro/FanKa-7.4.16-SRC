package jdk.internal.ref;

import java.lang.ref.Cleaner;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class PhantomCleanable<T> extends PhantomReference<T> implements Cleaner.Cleanable {
    private final PhantomCleanable<?> list;
    PhantomCleanable<?> next;
    PhantomCleanable<?> prev;

    protected abstract void performCleanup();

    /* JADX WARN: Multi-variable type inference failed */
    public PhantomCleanable(T referent, java.lang.ref.Cleaner cleaner) {
        super(Objects.requireNonNull(referent), CleanerImpl.getCleanerImpl(cleaner).queue);
        this.prev = this;
        this.next = this;
        this.list = CleanerImpl.getCleanerImpl(cleaner).phantomCleanableList;
        insert();
        Reference.reachabilityFence(referent);
        Reference.reachabilityFence(cleaner);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public PhantomCleanable() {
        super(null, null);
        this.prev = this;
        this.next = this;
        this.list = this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void insert() {
        synchronized (this.list) {
            PhantomCleanable<?> phantomCleanable = this.list;
            this.prev = phantomCleanable;
            PhantomCleanable<?> phantomCleanable2 = phantomCleanable.next;
            this.next = phantomCleanable2;
            phantomCleanable2.prev = this;
            phantomCleanable.next = this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean remove() {
        synchronized (this.list) {
            PhantomCleanable<?> phantomCleanable = this.next;
            if (phantomCleanable == this) {
                return false;
            }
            phantomCleanable.prev = this.prev;
            this.prev.next = phantomCleanable;
            this.prev = this;
            this.next = this;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isListEmpty() {
        boolean z10;
        synchronized (this.list) {
            PhantomCleanable<?> phantomCleanable = this.list;
            z10 = phantomCleanable == phantomCleanable.next;
        }
        return z10;
    }

    @Override // java.lang.ref.Cleaner.Cleanable
    public final void clean() {
        if (remove()) {
            super.clear();
            performCleanup();
        }
    }

    @Override // java.lang.ref.Reference
    public void clear() {
        if (remove()) {
            super.clear();
        }
    }

    @Override // java.lang.ref.Reference
    public final boolean isEnqueued() {
        throw new UnsupportedOperationException("isEnqueued");
    }

    @Override // java.lang.ref.Reference
    public final boolean enqueue() {
        throw new UnsupportedOperationException("enqueue");
    }
}
