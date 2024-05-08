package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractIterator.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class a<T> implements Iterator<T>, zd.a {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public State f50902b = State.NotReady;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public T f50903c;

    /* compiled from: AbstractIterator.kt */
    /* renamed from: kotlin.collections.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public /* synthetic */ class C0774a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f50904a;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.Done.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.Ready.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f50904a = iArr;
        }
    }

    public abstract void a();

    public final void b() {
        this.f50902b = State.Done;
    }

    public final void c(T t2) {
        this.f50903c = t2;
        this.f50902b = State.Ready;
    }

    public final boolean d() {
        this.f50902b = State.Failed;
        a();
        return this.f50902b == State.Ready;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        State state = this.f50902b;
        if (state != State.Failed) {
            int i10 = C0774a.f50904a[state.ordinal()];
            if (i10 == 1) {
                return false;
            }
            if (i10 != 2) {
                return d();
            }
            return true;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.f50902b = State.NotReady;
            return this.f50903c;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
