package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SequenceBuilder.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class h<T> extends i<T> implements Iterator<T>, Continuation<p>, zd.a {

    /* renamed from: b, reason: collision with root package name */
    public int f51082b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public T f51083c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Iterator<? extends T> f51084d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Continuation<? super p> f51085e;

    @Override // kotlin.sequences.i
    @Nullable
    public Object a(T t2, @NotNull Continuation<? super p> continuation) {
        this.f51083c = t2;
        this.f51082b = 3;
        this.f51085e = continuation;
        Object d10 = sd.a.d();
        if (d10 == sd.a.d()) {
            td.f.c(continuation);
        }
        return d10 == sd.a.d() ? d10 : p.f51048a;
    }

    @Override // kotlin.sequences.i
    @Nullable
    public Object b(@NotNull Iterator<? extends T> it, @NotNull Continuation<? super p> continuation) {
        if (!it.hasNext()) {
            return p.f51048a;
        }
        this.f51084d = it;
        this.f51082b = 2;
        this.f51085e = continuation;
        Object d10 = sd.a.d();
        if (d10 == sd.a.d()) {
            td.f.c(continuation);
        }
        return d10 == sd.a.d() ? d10 : p.f51048a;
    }

    public final Throwable d() {
        int i10 = this.f51082b;
        if (i10 == 4) {
            return new NoSuchElementException();
        }
        if (i10 != 5) {
            return new IllegalStateException("Unexpected state of the iterator: " + this.f51082b);
        }
        return new IllegalStateException("Iterator has failed.");
    }

    public final T e() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public final void f(@Nullable Continuation<? super p> continuation) {
        this.f51085e = continuation;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i10 = this.f51082b;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2 || i10 == 3) {
                        return true;
                    }
                    if (i10 == 4) {
                        return false;
                    }
                    throw d();
                }
                Iterator<? extends T> it = this.f51084d;
                s.f(it);
                if (it.hasNext()) {
                    this.f51082b = 2;
                    return true;
                }
                this.f51084d = null;
            }
            this.f51082b = 5;
            Continuation<? super p> continuation = this.f51085e;
            s.f(continuation);
            this.f51085e = null;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m3565constructorimpl(p.f51048a));
        }
    }

    @Override // java.util.Iterator
    public T next() {
        int i10 = this.f51082b;
        if (i10 == 0 || i10 == 1) {
            return e();
        }
        if (i10 == 2) {
            this.f51082b = 1;
            Iterator<? extends T> it = this.f51084d;
            s.f(it);
            return it.next();
        }
        if (i10 == 3) {
            this.f51082b = 0;
            T t2 = this.f51083c;
            this.f51083c = null;
            return t2;
        }
        throw d();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        kotlin.e.b(obj);
        this.f51082b = 4;
    }
}
