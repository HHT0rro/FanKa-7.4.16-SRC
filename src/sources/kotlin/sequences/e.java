package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Sequences.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class e<T> implements g<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final g<T> f51070a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f51071b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Function1<T, Boolean> f51072c;

    /* compiled from: Sequences.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a implements Iterator<T>, zd.a {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final Iterator<T> f51073b;

        /* renamed from: c, reason: collision with root package name */
        public int f51074c = -1;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public T f51075d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ e<T> f51076e;

        public a(e<T> eVar) {
            this.f51076e = eVar;
            this.f51073b = eVar.f51070a.iterator();
        }

        public final void a() {
            while (this.f51073b.hasNext()) {
                T next = this.f51073b.next();
                if (((Boolean) this.f51076e.f51072c.invoke(next)).booleanValue() == this.f51076e.f51071b) {
                    this.f51075d = next;
                    this.f51074c = 1;
                    return;
                }
            }
            this.f51074c = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f51074c == -1) {
                a();
            }
            return this.f51074c == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f51074c == -1) {
                a();
            }
            if (this.f51074c != 0) {
                T t2 = this.f51075d;
                this.f51075d = null;
                this.f51074c = -1;
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
    public e(@NotNull g<? extends T> sequence, boolean z10, @NotNull Function1<? super T, Boolean> predicate) {
        s.i(sequence, "sequence");
        s.i(predicate, "predicate");
        this.f51070a = sequence;
        this.f51071b = z10;
        this.f51072c = predicate;
    }

    @Override // kotlin.sequences.g
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}
