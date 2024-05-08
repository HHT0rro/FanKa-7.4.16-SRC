package com.google.common.collect;

import java.util.NoSuchElementException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class AbstractIterator<T> extends i1<T> {

    /* renamed from: b, reason: collision with root package name */
    public State f26147b = State.NOT_READY;

    /* renamed from: c, reason: collision with root package name */
    public T f26148c;

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
        public static final /* synthetic */ int[] f26149a;

        static {
            int[] iArr = new int[State.values().length];
            f26149a = iArr;
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26149a[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public abstract T a();

    public final T b() {
        this.f26147b = State.DONE;
        return null;
    }

    public final boolean c() {
        this.f26147b = State.FAILED;
        this.f26148c = a();
        if (this.f26147b == State.DONE) {
            return false;
        }
        this.f26147b = State.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        com.google.common.base.o.x(this.f26147b != State.FAILED);
        int i10 = a.f26149a[this.f26147b.ordinal()];
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
            this.f26147b = State.NOT_READY;
            T t2 = (T) l0.a(this.f26148c);
            this.f26148c = null;
            return t2;
        }
        throw new NoSuchElementException();
    }
}
