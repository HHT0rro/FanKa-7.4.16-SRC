package java.util.concurrent;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class RecursiveTask<V> extends ForkJoinTask<V> {
    private static final long serialVersionUID = 5232453952276485270L;
    V result;

    protected abstract V compute();

    @Override // java.util.concurrent.ForkJoinTask
    public final V getRawResult() {
        return this.result;
    }

    @Override // java.util.concurrent.ForkJoinTask
    protected final void setRawResult(V value) {
        this.result = value;
    }

    @Override // java.util.concurrent.ForkJoinTask
    protected final boolean exec() {
        this.result = compute();
        return true;
    }
}
