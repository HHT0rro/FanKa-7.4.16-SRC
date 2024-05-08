package java.lang.ref;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PhantomReference<T> extends Reference<T> {
    @Override // java.lang.ref.Reference
    public T get() {
        return null;
    }

    public PhantomReference(T referent, ReferenceQueue<? super T> q10) {
        super(referent, q10);
    }
}
