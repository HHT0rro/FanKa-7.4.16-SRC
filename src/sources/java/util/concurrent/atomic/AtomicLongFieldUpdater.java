package java.util.concurrent.atomic;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;
import jdk.internal.misc.Unsafe;
import jdk.internal.reflect.CallerSensitive;
import jdk.internal.reflect.Reflection;
import sun.reflect.misc.ReflectUtil;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AtomicLongFieldUpdater<T> {
    public abstract boolean compareAndSet(T t2, long j10, long j11);

    public abstract long get(T t2);

    public abstract void lazySet(T t2, long j10);

    public abstract void set(T t2, long j10);

    public abstract boolean weakCompareAndSet(T t2, long j10, long j11);

    @CallerSensitive
    public static <U> AtomicLongFieldUpdater<U> newUpdater(Class<U> tclass, String fieldName) {
        Class<?> caller = Reflection.getCallerClass();
        if (AtomicLong.VM_SUPPORTS_LONG_CAS) {
            return new CASUpdater(tclass, fieldName, caller);
        }
        return new LockedUpdater(tclass, fieldName, caller);
    }

    protected AtomicLongFieldUpdater() {
    }

    public long getAndSet(T obj, long newValue) {
        long prev;
        do {
            prev = get(obj);
        } while (!compareAndSet(obj, prev, newValue));
        return prev;
    }

    public long getAndIncrement(T obj) {
        long prev;
        long next;
        do {
            prev = get(obj);
            next = prev + 1;
        } while (!compareAndSet(obj, prev, next));
        return prev;
    }

    public long getAndDecrement(T obj) {
        long prev;
        long next;
        do {
            prev = get(obj);
            next = prev - 1;
        } while (!compareAndSet(obj, prev, next));
        return prev;
    }

    public long getAndAdd(T obj, long delta) {
        long prev;
        long next;
        do {
            prev = get(obj);
            next = prev + delta;
        } while (!compareAndSet(obj, prev, next));
        return prev;
    }

    public long incrementAndGet(T obj) {
        long prev;
        long next;
        do {
            prev = get(obj);
            next = prev + 1;
        } while (!compareAndSet(obj, prev, next));
        return next;
    }

    public long decrementAndGet(T obj) {
        long prev;
        long next;
        do {
            prev = get(obj);
            next = prev - 1;
        } while (!compareAndSet(obj, prev, next));
        return next;
    }

    public long addAndGet(T obj, long delta) {
        long prev;
        long next;
        do {
            prev = get(obj);
            next = prev + delta;
        } while (!compareAndSet(obj, prev, next));
        return next;
    }

    public final long getAndUpdate(T obj, LongUnaryOperator updateFunction) {
        long prev;
        long next;
        do {
            prev = get(obj);
            next = updateFunction.applyAsLong(prev);
        } while (!compareAndSet(obj, prev, next));
        return prev;
    }

    public final long updateAndGet(T obj, LongUnaryOperator updateFunction) {
        long prev;
        long next;
        do {
            prev = get(obj);
            next = updateFunction.applyAsLong(prev);
        } while (!compareAndSet(obj, prev, next));
        return next;
    }

    public final long getAndAccumulate(T obj, long x10, LongBinaryOperator accumulatorFunction) {
        long prev;
        long next;
        do {
            prev = get(obj);
            next = accumulatorFunction.applyAsLong(prev, x10);
        } while (!compareAndSet(obj, prev, next));
        return prev;
    }

    public final long accumulateAndGet(T obj, long x10, LongBinaryOperator accumulatorFunction) {
        long prev;
        long next;
        do {
            prev = get(obj);
            next = accumulatorFunction.applyAsLong(prev, x10);
        } while (!compareAndSet(obj, prev, next));
        return next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class CASUpdater<T> extends AtomicLongFieldUpdater<T> {
        private static final Unsafe U = Unsafe.getUnsafe();
        private final Class<?> cclass;
        private final long offset;
        private final Class<T> tclass;

        /* JADX WARN: Multi-variable type inference failed */
        CASUpdater(Class<T> tclass, String fieldName, Class<?> caller) {
            try {
                Field field = tclass.getDeclaredField(fieldName);
                int modifiers = field.getModifiers();
                ReflectUtil.ensureMemberAccess(caller, tclass, null, modifiers);
                if (field.getType() != Long.TYPE) {
                    throw new IllegalArgumentException("Must be long type");
                }
                if (!Modifier.isVolatile(modifiers)) {
                    throw new IllegalArgumentException("Must be volatile type");
                }
                this.cclass = (Modifier.isProtected(modifiers) && tclass.isAssignableFrom(caller) && !isSamePackage(tclass, caller)) ? caller : tclass;
                this.tclass = tclass;
                this.offset = U.objectFieldOffset(field);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
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

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public final boolean compareAndSet(T obj, long expect, long update) {
            accessCheck(obj);
            return U.compareAndSetLong(obj, this.offset, expect, update);
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public final boolean weakCompareAndSet(T obj, long expect, long update) {
            accessCheck(obj);
            return U.compareAndSetLong(obj, this.offset, expect, update);
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public final void set(T obj, long newValue) {
            accessCheck(obj);
            U.putLongVolatile(obj, this.offset, newValue);
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public final void lazySet(T obj, long newValue) {
            accessCheck(obj);
            U.putLongRelease(obj, this.offset, newValue);
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public final long get(T obj) {
            accessCheck(obj);
            return U.getLongVolatile(obj, this.offset);
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public final long getAndSet(T obj, long newValue) {
            accessCheck(obj);
            return U.getAndSetLong(obj, this.offset, newValue);
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public final long getAndAdd(T obj, long delta) {
            accessCheck(obj);
            return U.getAndAddLong(obj, this.offset, delta);
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public final long getAndIncrement(T obj) {
            return getAndAdd(obj, 1L);
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public final long getAndDecrement(T obj) {
            return getAndAdd(obj, -1L);
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public final long incrementAndGet(T obj) {
            return getAndAdd(obj, 1L) + 1;
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public final long decrementAndGet(T obj) {
            return getAndAdd(obj, -1L) - 1;
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public final long addAndGet(T obj, long delta) {
            return getAndAdd(obj, delta) + delta;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class LockedUpdater<T> extends AtomicLongFieldUpdater<T> {
        private static final Unsafe U = Unsafe.getUnsafe();
        private final Class<?> cclass;
        private final long offset;
        private final Class<T> tclass;

        /* JADX WARN: Multi-variable type inference failed */
        LockedUpdater(Class<T> tclass, String fieldName, Class<?> caller) {
            try {
                Field field = tclass.getDeclaredField(fieldName);
                int modifiers = field.getModifiers();
                ReflectUtil.ensureMemberAccess(caller, tclass, null, modifiers);
                if (field.getType() != Long.TYPE) {
                    throw new IllegalArgumentException("Must be long type");
                }
                if (!Modifier.isVolatile(modifiers)) {
                    throw new IllegalArgumentException("Must be volatile type");
                }
                this.cclass = (Modifier.isProtected(modifiers) && tclass.isAssignableFrom(caller) && !isSamePackage(tclass, caller)) ? caller : tclass;
                this.tclass = tclass;
                this.offset = U.objectFieldOffset(field);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        private final void accessCheck(T obj) {
            if (!this.cclass.isInstance(obj)) {
                throw accessCheckException(obj);
            }
        }

        private final RuntimeException accessCheckException(T obj) {
            if (this.cclass == this.tclass) {
                return new ClassCastException();
            }
            return new RuntimeException(new IllegalAccessException("Class " + this.cclass.getName() + " can not access a protected member of class " + this.tclass.getName() + " using an instance of " + obj.getClass().getName()));
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public final boolean compareAndSet(T obj, long expect, long update) {
            accessCheck(obj);
            synchronized (this) {
                Unsafe unsafe = U;
                long v2 = unsafe.getLong(obj, this.offset);
                if (v2 != expect) {
                    return false;
                }
                unsafe.putLong(obj, this.offset, update);
                return true;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public final boolean weakCompareAndSet(T obj, long expect, long update) {
            return compareAndSet(obj, expect, update);
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public final void set(T obj, long newValue) {
            accessCheck(obj);
            synchronized (this) {
                U.putLong(obj, this.offset, newValue);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public final void lazySet(T obj, long newValue) {
            set(obj, newValue);
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public final long get(T obj) {
            long j10;
            accessCheck(obj);
            synchronized (this) {
                j10 = U.getLong(obj, this.offset);
            }
            return j10;
        }
    }

    static boolean isSamePackage(Class<?> class1, Class<?> class2) {
        return class1.getClassLoader() == class2.getClassLoader() && class1.getPackageName() == class2.getPackageName();
    }
}
