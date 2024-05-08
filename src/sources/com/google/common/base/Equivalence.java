package com.google.common.base;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class Equivalence<T> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Equals extends Equivalence<Object> implements Serializable {
        public static final Equals INSTANCE = new Equals();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(Object obj) {
            return obj.hashCode();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class EquivalentToPredicate<T> implements p<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<T> equivalence;
        private final T target;

        public EquivalentToPredicate(Equivalence<T> equivalence, T t2) {
            this.equivalence = (Equivalence) o.r(equivalence);
            this.target = t2;
        }

        @Override // com.google.common.base.p
        public boolean apply(T t2) {
            return this.equivalence.equivalent(t2, this.target);
        }

        @Override // com.google.common.base.p
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EquivalentToPredicate)) {
                return false;
            }
            EquivalentToPredicate equivalentToPredicate = (EquivalentToPredicate) obj;
            return this.equivalence.equals(equivalentToPredicate.equivalence) && l.a(this.target, equivalentToPredicate.target);
        }

        public int hashCode() {
            return l.b(this.equivalence, this.target);
        }

        public String toString() {
            String valueOf = String.valueOf(this.equivalence);
            String valueOf2 = String.valueOf(this.target);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 15 + valueOf2.length());
            sb2.append(valueOf);
            sb2.append(".equivalentTo(");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Identity extends Equivalence<Object> implements Serializable {
        public static final Identity INSTANCE = new Identity();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;
        private final T reference;

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Wrapper)) {
                return false;
            }
            Wrapper wrapper = (Wrapper) obj;
            if (this.equivalence.equals(wrapper.equivalence)) {
                return this.equivalence.equivalent(this.reference, wrapper.reference);
            }
            return false;
        }

        public T get() {
            return this.reference;
        }

        public int hashCode() {
            return this.equivalence.hash(this.reference);
        }

        public String toString() {
            String valueOf = String.valueOf(this.equivalence);
            String valueOf2 = String.valueOf(this.reference);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 7 + valueOf2.length());
            sb2.append(valueOf);
            sb2.append(".wrap(");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }

        private Wrapper(Equivalence<? super T> equivalence, T t2) {
            this.equivalence = (Equivalence) o.r(equivalence);
            this.reference = t2;
        }
    }

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    public abstract boolean doEquivalent(T t2, T t10);

    public abstract int doHash(T t2);

    public final boolean equivalent(T t2, T t10) {
        if (t2 == t10) {
            return true;
        }
        if (t2 == null || t10 == null) {
            return false;
        }
        return doEquivalent(t2, t10);
    }

    public final p<T> equivalentTo(T t2) {
        return new EquivalentToPredicate(this, t2);
    }

    public final int hash(T t2) {
        if (t2 == null) {
            return 0;
        }
        return doHash(t2);
    }

    public final <F> Equivalence<F> onResultOf(g<? super F, ? extends T> gVar) {
        return new FunctionalEquivalence(gVar, this);
    }

    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new PairwiseEquivalence(this);
    }

    public final <S extends T> Wrapper<S> wrap(S s2) {
        return new Wrapper<>(s2);
    }
}
