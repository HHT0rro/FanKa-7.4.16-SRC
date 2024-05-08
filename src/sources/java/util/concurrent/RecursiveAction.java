package java.util.concurrent;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class RecursiveAction extends ForkJoinTask<Void> {
    private static final long serialVersionUID = 5232453952276485070L;

    protected abstract void compute();

    @Override // java.util.concurrent.ForkJoinTask
    public final Void getRawResult() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.util.concurrent.ForkJoinTask
    public final void setRawResult(Void mustBeNull) {
    }

    @Override // java.util.concurrent.ForkJoinTask
    protected final boolean exec() {
        compute();
        return true;
    }
}
