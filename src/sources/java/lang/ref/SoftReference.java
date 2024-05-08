package java.lang.ref;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SoftReference<T> extends Reference<T> {
    private static long clock;
    private long timestamp;

    public SoftReference(T referent) {
        super(referent);
        this.timestamp = clock;
    }

    public SoftReference(T referent, ReferenceQueue<? super T> q10) {
        super(referent, q10);
        this.timestamp = clock;
    }

    @Override // java.lang.ref.Reference
    public T get() {
        T t2 = (T) super.get();
        if (t2 != null) {
            long j10 = this.timestamp;
            long j11 = clock;
            if (j10 != j11) {
                this.timestamp = j11;
            }
        }
        return t2;
    }
}
