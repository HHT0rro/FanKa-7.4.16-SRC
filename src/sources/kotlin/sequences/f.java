package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Sequences.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class f<T> implements g<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Function0<T> f51077a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Function1<T, T> f51078b;

    /* compiled from: Sequences.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a implements Iterator<T>, zd.a {

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public T f51079b;

        /* renamed from: c, reason: collision with root package name */
        public int f51080c = -2;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f<T> f51081d;

        public a(f<T> fVar) {
            this.f51081d = fVar;
        }

        public final void a() {
            T t2;
            if (this.f51080c == -2) {
                t2 = (T) this.f51081d.f51077a.invoke();
            } else {
                Function1 function1 = this.f51081d.f51078b;
                T t10 = this.f51079b;
                s.f(t10);
                t2 = (T) function1.invoke(t10);
            }
            this.f51079b = t2;
            this.f51080c = t2 == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f51080c < 0) {
                a();
            }
            return this.f51080c == 1;
        }

        @Override // java.util.Iterator
        @NotNull
        public T next() {
            if (this.f51080c < 0) {
                a();
            }
            if (this.f51080c != 0) {
                T t2 = this.f51079b;
                s.g(t2, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                this.f51080c = -1;
                return t2;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@NotNull Function0<? extends T> getInitialValue, @NotNull Function1<? super T, ? extends T> getNextValue) {
        s.i(getInitialValue, "getInitialValue");
        s.i(getNextValue, "getNextValue");
        this.f51077a = getInitialValue;
        this.f51078b = getNextValue;
    }

    @Override // kotlin.sequences.g
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}
