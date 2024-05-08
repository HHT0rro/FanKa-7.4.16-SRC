package z7;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class p<T> implements e8.a<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f55015c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f55016a = f55015c;

    /* renamed from: b, reason: collision with root package name */
    public volatile e8.a<T> f55017b;

    public p(e8.a<T> aVar) {
        this.f55017b = aVar;
    }

    @Override // e8.a
    public T get() {
        T t2 = (T) this.f55016a;
        Object obj = f55015c;
        if (t2 == obj) {
            synchronized (this) {
                t2 = (T) this.f55016a;
                if (t2 == obj) {
                    t2 = this.f55017b.get();
                    this.f55016a = t2;
                    this.f55017b = null;
                }
            }
        }
        return t2;
    }
}
