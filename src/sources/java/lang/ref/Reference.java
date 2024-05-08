package java.lang.ref;

import dalvik.annotation.optimization.FastNative;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Reference<T> {
    private static boolean disableIntrinsic = false;
    private static boolean slowPathEnabled = false;
    Reference<?> pendingNext;
    final ReferenceQueue<? super T> queue;
    Reference queueNext;
    volatile T referent;

    @FastNative
    private final native T getReferent();

    @FastNative
    private final native boolean refersTo0(Object obj);

    @FastNative
    native void clearReferent();

    public T get() {
        return getReferent();
    }

    public final boolean refersTo(T obj) {
        return refersTo0(obj);
    }

    public void clear() {
        clearReferent();
    }

    @Deprecated(since = "9")
    public boolean isEnqueued() {
        ReferenceQueue<? super T> referenceQueue = this.queue;
        return referenceQueue != null && referenceQueue.isEnqueued(this);
    }

    public boolean enqueue() {
        ReferenceQueue<? super T> referenceQueue = this.queue;
        return referenceQueue != null && referenceQueue.enqueue(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Reference(T referent) {
        this(referent, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Reference(T referent, ReferenceQueue<? super T> queue) {
        this.referent = referent;
        this.queue = queue;
    }

    public static void reachabilityFence(Object ref) {
        SinkHolder.sink = ref;
        if (SinkHolder.finalize_count == 0) {
            SinkHolder.sink = null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class SinkHolder {
        static volatile Object sink;
        private static volatile int finalize_count = 0;
        private static Object sinkUser = new Object() { // from class: java.lang.ref.Reference.SinkHolder.1
            protected void finalize() {
                if (SinkHolder.sink == null && SinkHolder.finalize_count > 0) {
                    throw new AssertionError((Object) "Can't get here");
                }
                SinkHolder.finalize_count++;
            }
        };

        private SinkHolder() {
        }
    }
}
