package com.google.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class AbstractIterator<T> implements Iterator<T> {

    /* renamed from: b, reason: collision with root package name */
    public State f25936b = State.NOT_READY;

    /* renamed from: c, reason: collision with root package name */
    public T f25937c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25938a;

        static {
            int[] iArr = new int[State.values().length];
            f25938a = iArr;
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25938a[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public abstract T a();

    public final T b() {
        this.f25936b = State.DONE;
        return null;
    }

    public final boolean c() {
        this.f25936b = State.FAILED;
        this.f25937c = a();
        if (this.f25936b == State.DONE) {
            return false;
        }
        this.f25936b = State.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        o.x(this.f25936b != State.FAILED);
        int i10 = a.f25938a[this.f25936b.ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            return c();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.f25936b = State.NOT_READY;
            T t2 = (T) k.a(this.f25937c);
            this.f25937c = null;
            return t2;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
