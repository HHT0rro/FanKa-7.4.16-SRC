package java.util.concurrent.atomic;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class AtomicReference<V> implements Serializable {
    private static final VarHandle VALUE;
    private static final long serialVersionUID = -1848883965231344442L;
    private volatile V value;

    static {
        try {
            MethodHandles.Lookup l10 = MethodHandles.lookup();
            VALUE = l10.findVarHandle(AtomicReference.class, "value", Object.class);
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public AtomicReference(V initialValue) {
        this.value = initialValue;
    }

    public AtomicReference() {
    }

    public final V get() {
        return this.value;
    }

    public final void set(V newValue) {
        this.value = newValue;
    }

    public final void lazySet(V newValue) {
        (void) VALUE.setRelease(this, newValue);
    }

    public final boolean compareAndSet(V expectedValue, V newValue) {
        return (boolean) VALUE.compareAndSet(this, expectedValue, newValue);
    }

    @Deprecated(since = "9")
    public final boolean weakCompareAndSet(V expectedValue, V newValue) {
        return (boolean) VALUE.weakCompareAndSetPlain(this, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetPlain(V expectedValue, V newValue) {
        return (boolean) VALUE.weakCompareAndSetPlain(this, expectedValue, newValue);
    }

    public final V getAndSet(V v2) {
        return (V) (Object) VALUE.getAndSet(this, v2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V getAndUpdate(UnaryOperator<V> unaryOperator) {
        V v2 = (V) get();
        Object obj = null;
        boolean z10 = false;
        while (true) {
            if (!z10) {
                obj = unaryOperator.apply(v2);
            }
            if (weakCompareAndSetVolatile(v2, obj)) {
                return v2;
            }
            Object obj2 = get();
            z10 = v2 == obj2;
            v2 = obj2;
        }
    }

    public final V updateAndGet(UnaryOperator<V> unaryOperator) {
        V v2 = get();
        V v10 = null;
        boolean z10 = false;
        while (true) {
            if (!z10) {
                v10 = (V) unaryOperator.apply(v2);
            }
            if (weakCompareAndSetVolatile(v2, v10)) {
                return v10;
            }
            V v11 = get();
            z10 = v2 == v11;
            v2 = v11;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V getAndAccumulate(V v2, BinaryOperator<V> binaryOperator) {
        V v10 = (V) get();
        Object obj = null;
        boolean z10 = false;
        while (true) {
            if (!z10) {
                obj = binaryOperator.apply(v10, v2);
            }
            if (weakCompareAndSetVolatile(v10, obj)) {
                return v10;
            }
            Object obj2 = get();
            z10 = v10 == obj2;
            v10 = obj2;
        }
    }

    public final V accumulateAndGet(V v2, BinaryOperator<V> binaryOperator) {
        V v10 = get();
        V v11 = null;
        boolean z10 = false;
        while (true) {
            if (!z10) {
                v11 = (V) binaryOperator.apply(v10, v2);
            }
            if (weakCompareAndSetVolatile(v10, v11)) {
                return v11;
            }
            V v12 = get();
            z10 = v10 == v12;
            v10 = v12;
        }
    }

    public String toString() {
        return String.valueOf(get());
    }

    public final V getPlain() {
        return (V) (Object) VALUE.get(this);
    }

    public final void setPlain(V newValue) {
        (void) VALUE.set(this, newValue);
    }

    public final V getOpaque() {
        return (V) (Object) VALUE.getOpaque(this);
    }

    public final void setOpaque(V newValue) {
        (void) VALUE.setOpaque(this, newValue);
    }

    public final V getAcquire() {
        return (V) (Object) VALUE.getAcquire(this);
    }

    public final void setRelease(V newValue) {
        (void) VALUE.setRelease(this, newValue);
    }

    public final V compareAndExchange(V v2, V v10) {
        return (V) (Object) VALUE.compareAndExchange(this, v2, v10);
    }

    public final V compareAndExchangeAcquire(V v2, V v10) {
        return (V) (Object) VALUE.compareAndExchangeAcquire(this, v2, v10);
    }

    public final V compareAndExchangeRelease(V v2, V v10) {
        return (V) (Object) VALUE.compareAndExchangeRelease(this, v2, v10);
    }

    public final boolean weakCompareAndSetVolatile(V expectedValue, V newValue) {
        return (boolean) VALUE.weakCompareAndSet(this, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetAcquire(V expectedValue, V newValue) {
        return (boolean) VALUE.weakCompareAndSetAcquire(this, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetRelease(V expectedValue, V newValue) {
        return (boolean) VALUE.weakCompareAndSetRelease(this, expectedValue, newValue);
    }
}
