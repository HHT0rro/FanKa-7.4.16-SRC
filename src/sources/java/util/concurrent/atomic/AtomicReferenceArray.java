package java.util.concurrent.atomic;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class AtomicReferenceArray<E> implements Serializable {
    private static final VarHandle AA = MethodHandles.arrayElementVarHandle(Object[].class);
    private static final long serialVersionUID = -6209656149925076980L;
    private final Object[] array;

    public AtomicReferenceArray(int length) {
        this.array = new Object[length];
    }

    public AtomicReferenceArray(E[] array) {
        this.array = Arrays.copyOf(array, array.length, Object[].class);
    }

    public final int length() {
        return this.array.length;
    }

    public final E get(int i10) {
        return (E) (Object) AA.getVolatile(this.array, i10);
    }

    public final void set(int i10, E newValue) {
        (void) AA.setVolatile(this.array, i10, newValue);
    }

    public final void lazySet(int i10, E newValue) {
        (void) AA.setRelease(this.array, i10, newValue);
    }

    public final E getAndSet(int i10, E e2) {
        return (E) (Object) AA.getAndSet(this.array, i10, e2);
    }

    public final boolean compareAndSet(int i10, E expectedValue, E newValue) {
        return (boolean) AA.compareAndSet(this.array, i10, expectedValue, newValue);
    }

    @Deprecated(since = "9")
    public final boolean weakCompareAndSet(int i10, E expectedValue, E newValue) {
        return (boolean) AA.weakCompareAndSetPlain(this.array, i10, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetPlain(int i10, E expectedValue, E newValue) {
        return (boolean) AA.weakCompareAndSetPlain(this.array, i10, expectedValue, newValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final E getAndUpdate(int i10, UnaryOperator<E> unaryOperator) {
        E e2 = (E) get(i10);
        Object obj = null;
        boolean z10 = false;
        while (true) {
            if (!z10) {
                obj = unaryOperator.apply(e2);
            }
            if (weakCompareAndSetVolatile(i10, e2, obj)) {
                return e2;
            }
            Object obj2 = get(i10);
            z10 = e2 == obj2;
            e2 = obj2;
        }
    }

    public final E updateAndGet(int i10, UnaryOperator<E> unaryOperator) {
        E e2 = get(i10);
        E e10 = null;
        boolean z10 = false;
        while (true) {
            if (!z10) {
                e10 = (E) unaryOperator.apply(e2);
            }
            if (weakCompareAndSetVolatile(i10, e2, e10)) {
                return e10;
            }
            E e11 = get(i10);
            z10 = e2 == e11;
            e2 = e11;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final E getAndAccumulate(int i10, E e2, BinaryOperator<E> binaryOperator) {
        E e10 = (E) get(i10);
        Object obj = null;
        boolean z10 = false;
        while (true) {
            if (!z10) {
                obj = binaryOperator.apply(e10, e2);
            }
            if (weakCompareAndSetVolatile(i10, e10, obj)) {
                return e10;
            }
            Object obj2 = get(i10);
            z10 = e10 == obj2;
            e10 = obj2;
        }
    }

    public final E accumulateAndGet(int i10, E e2, BinaryOperator<E> binaryOperator) {
        E e10 = get(i10);
        E e11 = null;
        boolean z10 = false;
        while (true) {
            if (!z10) {
                e11 = (E) binaryOperator.apply(e10, e2);
            }
            if (weakCompareAndSetVolatile(i10, e10, e11)) {
                return e11;
            }
            E e12 = get(i10);
            z10 = e10 == e12;
            e10 = e12;
        }
    }

    public String toString() {
        int iMax = this.array.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b4 = new StringBuilder();
        b4.append('[');
        int i10 = 0;
        while (true) {
            b4.append((Object) get(i10));
            if (i10 == iMax) {
                return b4.append(']').toString();
            }
            b4.append(',').append(' ');
            i10++;
        }
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        Object a10 = s2.readFields().get("array", (Object) null);
        if (a10 == null || !a10.getClass().isArray()) {
            throw new InvalidObjectException("Not array type");
        }
        if (a10.getClass() != Object[].class) {
            a10 = Arrays.copyOf((Object[]) a10, Array.getLength(a10), Object[].class);
        }
        Field arrayField = (Field) AccessController.doPrivileged(new PrivilegedAction() { // from class: java.util.concurrent.atomic.AtomicReferenceArray$$ExternalSyntheticLambda0
            @Override // java.security.PrivilegedAction
            public final Object run() {
                return AtomicReferenceArray.lambda$readObject$0();
            }
        });
        try {
            arrayField.set(this, a10);
        } catch (IllegalAccessException e2) {
            throw new Error(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Field lambda$readObject$0() {
        try {
            Field f10 = AtomicReferenceArray.class.getDeclaredField("array");
            f10.setAccessible(true);
            return f10;
        } catch (ReflectiveOperationException e2) {
            throw new Error(e2);
        }
    }

    public final E getPlain(int i10) {
        return (E) (Object) AA.get(this.array, i10);
    }

    public final void setPlain(int i10, E newValue) {
        (void) AA.set(this.array, i10, newValue);
    }

    public final E getOpaque(int i10) {
        return (E) (Object) AA.getOpaque(this.array, i10);
    }

    public final void setOpaque(int i10, E newValue) {
        (void) AA.setOpaque(this.array, i10, newValue);
    }

    public final E getAcquire(int i10) {
        return (E) (Object) AA.getAcquire(this.array, i10);
    }

    public final void setRelease(int i10, E newValue) {
        (void) AA.setRelease(this.array, i10, newValue);
    }

    public final E compareAndExchange(int i10, E e2, E e10) {
        return (E) (Object) AA.compareAndExchange(this.array, i10, e2, e10);
    }

    public final E compareAndExchangeAcquire(int i10, E e2, E e10) {
        return (E) (Object) AA.compareAndExchangeAcquire(this.array, i10, e2, e10);
    }

    public final E compareAndExchangeRelease(int i10, E e2, E e10) {
        return (E) (Object) AA.compareAndExchangeRelease(this.array, i10, e2, e10);
    }

    public final boolean weakCompareAndSetVolatile(int i10, E expectedValue, E newValue) {
        return (boolean) AA.weakCompareAndSet(this.array, i10, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetAcquire(int i10, E expectedValue, E newValue) {
        return (boolean) AA.weakCompareAndSetAcquire(this.array, i10, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetRelease(int i10, E expectedValue, E newValue) {
        return (boolean) AA.weakCompareAndSetRelease(this.array, i10, expectedValue, newValue);
    }
}
