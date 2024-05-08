package com.google.common.base;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Suppliers {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class ExpiringMemoizingSupplier<T> implements t<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final t<T> delegate;
        public final long durationNanos;
        public volatile transient long expirationNanos;
        public volatile transient T value;

        public ExpiringMemoizingSupplier(t<T> tVar, long j10, TimeUnit timeUnit) {
            this.delegate = (t) o.r(tVar);
            this.durationNanos = timeUnit.toNanos(j10);
            o.l(j10 > 0, "duration (%s %s) must be > 0", j10, timeUnit);
        }

        @Override // com.google.common.base.t
        public T get() {
            long j10 = this.expirationNanos;
            long h10 = n.h();
            if (j10 == 0 || h10 - j10 >= 0) {
                synchronized (this) {
                    if (j10 == this.expirationNanos) {
                        T t2 = this.delegate.get();
                        this.value = t2;
                        long j11 = h10 + this.durationNanos;
                        if (j11 == 0) {
                            j11 = 1;
                        }
                        this.expirationNanos = j11;
                        return t2;
                    }
                }
            }
            return (T) k.a(this.value);
        }

        public String toString() {
            String valueOf = String.valueOf(this.delegate);
            long j10 = this.durationNanos;
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 62);
            sb2.append("Suppliers.memoizeWithExpiration(");
            sb2.append(valueOf);
            sb2.append(", ");
            sb2.append(j10);
            sb2.append(", NANOS)");
            return sb2.toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class MemoizingSupplier<T> implements t<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final t<T> delegate;
        public volatile transient boolean initialized;
        public transient T value;

        public MemoizingSupplier(t<T> tVar) {
            this.delegate = (t) o.r(tVar);
        }

        @Override // com.google.common.base.t
        public T get() {
            if (!this.initialized) {
                synchronized (this) {
                    if (!this.initialized) {
                        T t2 = this.delegate.get();
                        this.value = t2;
                        this.initialized = true;
                        return t2;
                    }
                }
            }
            return (T) k.a(this.value);
        }

        public String toString() {
            Object obj;
            if (this.initialized) {
                String valueOf = String.valueOf(this.value);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 25);
                sb2.append("<supplier that returned ");
                sb2.append(valueOf);
                sb2.append(">");
                obj = sb2.toString();
            } else {
                obj = this.delegate;
            }
            String valueOf2 = String.valueOf(obj);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 19);
            sb3.append("Suppliers.memoize(");
            sb3.append(valueOf2);
            sb3.append(")");
            return sb3.toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SupplierComposition<F, T> implements t<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final g<? super F, T> function;
        public final t<F> supplier;

        public SupplierComposition(g<? super F, T> gVar, t<F> tVar) {
            this.function = (g) o.r(gVar);
            this.supplier = (t) o.r(tVar);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SupplierComposition)) {
                return false;
            }
            SupplierComposition supplierComposition = (SupplierComposition) obj;
            return this.function.equals(supplierComposition.function) && this.supplier.equals(supplierComposition.supplier);
        }

        @Override // com.google.common.base.t
        public T get() {
            return this.function.apply(this.supplier.get());
        }

        public int hashCode() {
            return l.b(this.function, this.supplier);
        }

        public String toString() {
            String valueOf = String.valueOf(this.function);
            String valueOf2 = String.valueOf(this.supplier);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 21 + valueOf2.length());
            sb2.append("Suppliers.compose(");
            sb2.append(valueOf);
            sb2.append(", ");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum SupplierFunctionImpl implements g {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Suppliers.supplierFunction()";
        }

        @Override // com.google.common.base.g
        public Object apply(t<Object> tVar) {
            return tVar.get();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SupplierOfInstance<T> implements t<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final T instance;

        public SupplierOfInstance(T t2) {
            this.instance = t2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return l.a(this.instance, ((SupplierOfInstance) obj).instance);
            }
            return false;
        }

        @Override // com.google.common.base.t
        public T get() {
            return this.instance;
        }

        public int hashCode() {
            return l.b(this.instance);
        }

        public String toString() {
            String valueOf = String.valueOf(this.instance);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 22);
            sb2.append("Suppliers.ofInstance(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class ThreadSafeSupplier<T> implements t<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final t<T> delegate;

        public ThreadSafeSupplier(t<T> tVar) {
            this.delegate = (t) o.r(tVar);
        }

        @Override // com.google.common.base.t
        public T get() {
            T t2;
            synchronized (this.delegate) {
                t2 = this.delegate.get();
            }
            return t2;
        }

        public String toString() {
            String valueOf = String.valueOf(this.delegate);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 32);
            sb2.append("Suppliers.synchronizedSupplier(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static <T> t<T> a(T t2) {
        return new SupplierOfInstance(t2);
    }
}
