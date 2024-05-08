package java.util.concurrent.atomic;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import jdk.internal.misc.Unsafe;
import jdk.internal.reflect.CallerSensitive;
import jdk.internal.reflect.Reflection;
import sun.reflect.misc.ReflectUtil;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AtomicReferenceFieldUpdater<T, V> {
    public abstract boolean compareAndSet(T t2, V v2, V v10);

    public abstract V get(T t2);

    public abstract void lazySet(T t2, V v2);

    public abstract void set(T t2, V v2);

    public abstract boolean weakCompareAndSet(T t2, V v2, V v10);

    @CallerSensitive
    public static <U, W> AtomicReferenceFieldUpdater<U, W> newUpdater(Class<U> tclass, Class<W> vclass, String fieldName) {
        return new AtomicReferenceFieldUpdaterImpl(tclass, vclass, fieldName, Reflection.getCallerClass());
    }

    protected AtomicReferenceFieldUpdater() {
    }

    public V getAndSet(T obj, V newValue) {
        V prev;
        do {
            prev = get(obj);
        } while (!compareAndSet(obj, prev, newValue));
        return prev;
    }

    public final V getAndUpdate(T t2, UnaryOperator<V> unaryOperator) {
        V v2;
        do {
            v2 = get(t2);
        } while (!compareAndSet(t2, v2, unaryOperator.apply(v2)));
        return v2;
    }

    public final V updateAndGet(T t2, UnaryOperator<V> unaryOperator) {
        V v2;
        V v10;
        do {
            v2 = get(t2);
            v10 = (V) unaryOperator.apply(v2);
        } while (!compareAndSet(t2, v2, v10));
        return v10;
    }

    public final V getAndAccumulate(T t2, V v2, BinaryOperator<V> binaryOperator) {
        V v10;
        do {
            v10 = get(t2);
        } while (!compareAndSet(t2, v10, binaryOperator.apply(v10, v2)));
        return v10;
    }

    public final V accumulateAndGet(T t2, V v2, BinaryOperator<V> binaryOperator) {
        V v10;
        V v11;
        do {
            v10 = get(t2);
            v11 = (V) binaryOperator.apply(v10, v2);
        } while (!compareAndSet(t2, v10, v11));
        return v11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class AtomicReferenceFieldUpdaterImpl<T, V> extends AtomicReferenceFieldUpdater<T, V> {
        private static final Unsafe U = Unsafe.getUnsafe();
        private final Class<?> cclass;
        private final long offset;
        private final Class<T> tclass;
        private final Class<V> vclass;

        /* JADX WARN: Multi-variable type inference failed */
        AtomicReferenceFieldUpdaterImpl(Class<T> tclass, Class<V> vclass, String fieldName, Class<?> caller) {
            try {
                Field field = tclass.getDeclaredField(fieldName);
                int modifiers = field.getModifiers();
                ReflectUtil.ensureMemberAccess(caller, tclass, null, modifiers);
                Class<?> fieldClass = field.getType();
                if (vclass != fieldClass) {
                    throw new ClassCastException();
                }
                if (vclass.isPrimitive()) {
                    throw new IllegalArgumentException("Must be reference type");
                }
                if (!Modifier.isVolatile(modifiers)) {
                    throw new IllegalArgumentException("Must be volatile type");
                }
                this.cclass = (Modifier.isProtected(modifiers) && tclass.isAssignableFrom(caller) && !isSamePackage(tclass, caller)) ? caller : tclass;
                this.tclass = tclass;
                this.vclass = vclass;
                this.offset = U.objectFieldOffset(field);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        private static boolean isSamePackage(Class<?> class1, Class<?> class2) {
            return class1.getClassLoader() == class2.getClassLoader() && class1.getPackageName() == class2.getPackageName();
        }

        private final void accessCheck(T obj) {
            if (!this.cclass.isInstance(obj)) {
                throwAccessCheckException(obj);
            }
        }

        private final void throwAccessCheckException(T obj) {
            if (this.cclass == this.tclass) {
                throw new ClassCastException();
            }
            throw new RuntimeException(new IllegalAccessException("Class " + this.cclass.getName() + " can not access a protected member of class " + this.tclass.getName() + " using an instance of " + obj.getClass().getName()));
        }

        private final void valueCheck(V v2) {
            if (v2 != null && !this.vclass.isInstance(v2)) {
                throwCCE();
            }
        }

        static void throwCCE() {
            throw new ClassCastException();
        }

        @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
        public final boolean compareAndSet(T obj, V expect, V update) {
            accessCheck(obj);
            valueCheck(update);
            return U.compareAndSetReference(obj, this.offset, expect, update);
        }

        @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
        public final boolean weakCompareAndSet(T obj, V expect, V update) {
            accessCheck(obj);
            valueCheck(update);
            return U.compareAndSetReference(obj, this.offset, expect, update);
        }

        @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
        public final void set(T obj, V newValue) {
            accessCheck(obj);
            valueCheck(newValue);
            U.putReferenceVolatile(obj, this.offset, newValue);
        }

        @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
        public final void lazySet(T obj, V newValue) {
            accessCheck(obj);
            valueCheck(newValue);
            U.putReferenceRelease(obj, this.offset, newValue);
        }

        @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
        public final V get(T t2) {
            accessCheck(t2);
            return (V) U.getReferenceVolatile(t2, this.offset);
        }

        @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
        public final V getAndSet(T t2, V v2) {
            accessCheck(t2);
            valueCheck(v2);
            return (V) U.getAndSetReference(t2, this.offset, v2);
        }
    }
}
