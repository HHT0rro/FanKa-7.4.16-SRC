package java.util.stream;

import java.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.AbstractTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractTask<P_IN, P_OUT, R, K extends AbstractTask<P_IN, P_OUT, R, K>> extends CountedCompleter<R> {
    static final int LEAF_TARGET = ForkJoinPool.getCommonPoolParallelism() << 2;
    protected final PipelineHelper<P_OUT> helper;
    protected K leftChild;
    private R localResult;
    protected K rightChild;
    protected Spliterator<P_IN> spliterator;
    protected long targetSize;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract R doLeaf();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract K makeChild(Spliterator<P_IN> spliterator);

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractTask(PipelineHelper<P_OUT> helper, Spliterator<P_IN> spliterator) {
        super(null);
        this.helper = helper;
        this.spliterator = spliterator;
        this.targetSize = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractTask(K parent, Spliterator<P_IN> spliterator) {
        super(parent);
        this.spliterator = spliterator;
        this.helper = parent.helper;
        this.targetSize = parent.targetSize;
    }

    public static long suggestTargetSize(long sizeEstimate) {
        long est = sizeEstimate / LEAF_TARGET;
        if (est > 0) {
            return est;
        }
        return 1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long getTargetSize(long sizeEstimate) {
        long s2 = this.targetSize;
        if (s2 != 0) {
            return s2;
        }
        long suggestTargetSize = suggestTargetSize(sizeEstimate);
        this.targetSize = suggestTargetSize;
        return suggestTargetSize;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public R getRawResult() {
        return this.localResult;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    protected void setRawResult(R result) {
        if (result != null) {
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public R getLocalResult() {
        return this.localResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLocalResult(R localResult) {
        this.localResult = localResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLeaf() {
        return this.leftChild == null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isRoot() {
        return getParent() == null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public K getParent() {
        return (K) getCompleter();
    }

    @Override // java.util.concurrent.CountedCompleter
    public void compute() {
        Spliterator<P_IN> ls;
        K taskToFork;
        Spliterator<P_IN> rs = this.spliterator;
        long sizeEstimate = rs.estimateSize();
        long sizeThreshold = getTargetSize(sizeEstimate);
        boolean forkRight = false;
        K task = this;
        while (sizeEstimate > sizeThreshold && (ls = rs.trySplit()) != null) {
            K leftChild = task.makeChild(ls);
            task.leftChild = leftChild;
            K rightChild = task.makeChild(rs);
            task.rightChild = rightChild;
            task.setPendingCount(1);
            if (forkRight) {
                forkRight = false;
                rs = ls;
                task = leftChild;
                taskToFork = rightChild;
            } else {
                forkRight = true;
                task = rightChild;
                taskToFork = leftChild;
            }
            taskToFork.fork();
            sizeEstimate = rs.estimateSize();
        }
        task.setLocalResult(task.doLeaf());
        task.tryComplete();
    }

    @Override // java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter<?> caller) {
        this.spliterator = null;
        this.rightChild = null;
        this.leftChild = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLeftmostNode() {
        K node = this;
        while (node != null) {
            K parent = node.getParent();
            if (parent != null && parent.leftChild != node) {
                return false;
            }
            node = parent;
        }
        return true;
    }
}
