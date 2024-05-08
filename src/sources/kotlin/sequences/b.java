package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: Sequences.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b<T> implements g<T>, c<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final g<T> f51065a;

    /* renamed from: b, reason: collision with root package name */
    public final int f51066b;

    /* compiled from: Sequences.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a implements Iterator<T>, zd.a {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final Iterator<T> f51067b;

        /* renamed from: c, reason: collision with root package name */
        public int f51068c;

        public a(b<T> bVar) {
            this.f51067b = bVar.f51065a.iterator();
            this.f51068c = bVar.f51066b;
        }

        public final void a() {
            while (this.f51068c > 0 && this.f51067b.hasNext()) {
                this.f51067b.next();
                this.f51068c--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f51067b.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            return this.f51067b.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull g<? extends T> sequence, int i10) {
        s.i(sequence, "sequence");
        this.f51065a = sequence;
        this.f51066b = i10;
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i10 + '.').toString());
    }

    @Override // kotlin.sequences.c
    @NotNull
    public g<T> a(int i10) {
        int i11 = this.f51066b + i10;
        return i11 < 0 ? new b(this, i10) : new b(this.f51065a, i11);
    }

    @Override // kotlin.sequences.g
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}
