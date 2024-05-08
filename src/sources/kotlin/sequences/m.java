package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Sequences.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class m<T, R> implements g<R> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final g<T> f51087a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Function1<T, R> f51088b;

    /* compiled from: Sequences.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a implements Iterator<R>, zd.a {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final Iterator<T> f51089b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m<T, R> f51090c;

        public a(m<T, R> mVar) {
            this.f51090c = mVar;
            this.f51089b = mVar.f51087a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f51089b.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) this.f51090c.f51088b.invoke(this.f51089b.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(@NotNull g<? extends T> sequence, @NotNull Function1<? super T, ? extends R> transformer) {
        s.i(sequence, "sequence");
        s.i(transformer, "transformer");
        this.f51087a = sequence;
        this.f51088b = transformer;
    }

    @Override // kotlin.sequences.g
    @NotNull
    public Iterator<R> iterator() {
        return new a(this);
    }
}
