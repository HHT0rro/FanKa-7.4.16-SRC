package java.util.stream;

import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.AbstractShortCircuitTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractShortCircuitTask<P_IN, P_OUT, R, K extends AbstractShortCircuitTask<P_IN, P_OUT, R, K>> extends AbstractTask<P_IN, P_OUT, R, K> {
    protected volatile boolean canceled;
    protected final AtomicReference<R> sharedResult;

    protected abstract R getEmptyResult();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractShortCircuitTask(PipelineHelper<P_OUT> helper, Spliterator<P_IN> spliterator) {
        super(helper, spliterator);
        this.sharedResult = new AtomicReference<>(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractShortCircuitTask(K parent, Spliterator<P_IN> spliterator) {
        super(parent, spliterator);
        this.sharedResult = parent.sharedResult;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
    
        r9 = r6.doLeaf();
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.stream.AbstractTask, java.util.concurrent.CountedCompleter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void compute() {
        /*
            r13 = this;
            java.util.Spliterator<P_IN> r0 = r13.spliterator
            long r1 = r0.estimateSize()
            long r3 = r13.getTargetSize(r1)
            r5 = 0
            r6 = r13
            java.util.concurrent.atomic.AtomicReference<R> r7 = r13.sharedResult
        Le:
            java.lang.Object r8 = r7.get()
            r9 = r8
            if (r8 != 0) goto L59
            boolean r8 = r6.taskCanceled()
            if (r8 == 0) goto L20
            java.lang.Object r9 = r6.getEmptyResult()
            goto L59
        L20:
            int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r8 <= 0) goto L54
            java.util.Spliterator r8 = r0.trySplit()
            r10 = r8
            if (r8 != 0) goto L2c
            goto L54
        L2c:
            java.util.stream.AbstractTask r8 = r6.makeChild(r10)
            java.util.stream.AbstractShortCircuitTask r8 = (java.util.stream.AbstractShortCircuitTask) r8
            r11 = r8
            r6.leftChild = r8
            java.util.stream.AbstractTask r8 = r6.makeChild(r0)
            java.util.stream.AbstractShortCircuitTask r8 = (java.util.stream.AbstractShortCircuitTask) r8
            r12 = r8
            r6.rightChild = r8
            r8 = 1
            r6.setPendingCount(r8)
            if (r5 == 0) goto L49
            r5 = 0
            r0 = r10
            r6 = r11
            r8 = r12
            goto L4c
        L49:
            r5 = 1
            r6 = r12
            r8 = r11
        L4c:
            r8.fork()
            long r1 = r0.estimateSize()
            goto Le
        L54:
            java.lang.Object r9 = r6.doLeaf()
        L59:
            r6.setLocalResult(r9)
            r6.tryComplete()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.stream.AbstractShortCircuitTask.compute():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void shortCircuit(R result) {
        if (result != null) {
            this.sharedResult.compareAndSet(null, result);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.util.stream.AbstractTask
    public void setLocalResult(R localResult) {
        if (isRoot()) {
            if (localResult != null) {
                this.sharedResult.compareAndSet(null, localResult);
                return;
            }
            return;
        }
        super.setLocalResult(localResult);
    }

    @Override // java.util.stream.AbstractTask, java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public R getRawResult() {
        return getLocalResult();
    }

    @Override // java.util.stream.AbstractTask
    public R getLocalResult() {
        if (isRoot()) {
            R r10 = this.sharedResult.get();
            return r10 == null ? getEmptyResult() : r10;
        }
        return (R) super.getLocalResult();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cancel() {
        this.canceled = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected boolean taskCanceled() {
        boolean cancel = this.canceled;
        if (!cancel) {
            for (AbstractShortCircuitTask abstractShortCircuitTask = (AbstractShortCircuitTask) getParent(); !cancel && abstractShortCircuitTask != null; abstractShortCircuitTask = (AbstractShortCircuitTask) abstractShortCircuitTask.getParent()) {
                cancel = abstractShortCircuitTask.canceled;
            }
        }
        return cancel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void cancelLaterNodes() {
        K node = this;
        for (AbstractShortCircuitTask<P_IN, P_OUT, R, K> abstractShortCircuitTask = (AbstractShortCircuitTask) getParent(); abstractShortCircuitTask != null; abstractShortCircuitTask = (AbstractShortCircuitTask) abstractShortCircuitTask.getParent()) {
            if (abstractShortCircuitTask.leftChild == node) {
                AbstractShortCircuitTask abstractShortCircuitTask2 = (AbstractShortCircuitTask) abstractShortCircuitTask.rightChild;
                if (!abstractShortCircuitTask2.canceled) {
                    abstractShortCircuitTask2.cancel();
                }
            }
            node = abstractShortCircuitTask;
        }
    }
}
