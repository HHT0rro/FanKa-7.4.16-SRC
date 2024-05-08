package com.google.common.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Predicates {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class AndPredicate<T> implements p<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends p<? super T>> components;

        @Override // com.google.common.base.p
        public boolean apply(T t2) {
            for (int i10 = 0; i10 < this.components.size(); i10++) {
                if (!this.components.get(i10).apply(t2)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.base.p
        public boolean equals(Object obj) {
            if (obj instanceof AndPredicate) {
                return this.components.equals(((AndPredicate) obj).components);
            }
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 306654252;
        }

        public String toString() {
            return Predicates.h("and", this.components);
        }

        private AndPredicate(List<? extends p<? super T>> list) {
            this.components = list;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class CompositionPredicate<A, B> implements p<A>, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: f, reason: collision with root package name */
        public final g<A, ? extends B> f25949f;

        /* renamed from: p, reason: collision with root package name */
        public final p<B> f25950p;

        @Override // com.google.common.base.p
        public boolean apply(A a10) {
            return this.f25950p.apply(this.f25949f.apply(a10));
        }

        @Override // com.google.common.base.p
        public boolean equals(Object obj) {
            if (!(obj instanceof CompositionPredicate)) {
                return false;
            }
            CompositionPredicate compositionPredicate = (CompositionPredicate) obj;
            return this.f25949f.equals(compositionPredicate.f25949f) && this.f25950p.equals(compositionPredicate.f25950p);
        }

        public int hashCode() {
            return this.f25949f.hashCode() ^ this.f25950p.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.f25950p);
            String valueOf2 = String.valueOf(this.f25949f);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 2 + valueOf2.length());
            sb2.append(valueOf);
            sb2.append("(");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }

        private CompositionPredicate(p<B> pVar, g<A, ? extends B> gVar) {
            this.f25950p = (p) o.r(pVar);
            this.f25949f = (g) o.r(gVar);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class ContainsPatternFromStringPredicate extends ContainsPatternPredicate {
        private static final long serialVersionUID = 0;

        public ContainsPatternFromStringPredicate(String str) {
            super(n.a(str));
        }

        @Override // com.google.common.base.Predicates.ContainsPatternPredicate
        public String toString() {
            String pattern = this.pattern.pattern();
            StringBuilder sb2 = new StringBuilder(String.valueOf(pattern).length() + 28);
            sb2.append("Predicates.containsPattern(");
            sb2.append(pattern);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class ContainsPatternPredicate implements p<CharSequence>, Serializable {
        private static final long serialVersionUID = 0;
        public final e pattern;

        public ContainsPatternPredicate(e eVar) {
            this.pattern = (e) o.r(eVar);
        }

        @Override // com.google.common.base.p
        public boolean equals(Object obj) {
            if (!(obj instanceof ContainsPatternPredicate)) {
                return false;
            }
            ContainsPatternPredicate containsPatternPredicate = (ContainsPatternPredicate) obj;
            return l.a(this.pattern.pattern(), containsPatternPredicate.pattern.pattern()) && this.pattern.flags() == containsPatternPredicate.pattern.flags();
        }

        public int hashCode() {
            return l.b(this.pattern.pattern(), Integer.valueOf(this.pattern.flags()));
        }

        public String toString() {
            String bVar = j.c(this.pattern).d("pattern", this.pattern.pattern()).b("pattern.flags", this.pattern.flags()).toString();
            StringBuilder sb2 = new StringBuilder(String.valueOf(bVar).length() + 21);
            sb2.append("Predicates.contains(");
            sb2.append(bVar);
            sb2.append(")");
            return sb2.toString();
        }

        @Override // com.google.common.base.p
        public boolean apply(CharSequence charSequence) {
            return this.pattern.matcher(charSequence).a();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class InPredicate<T> implements p<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Collection<?> target;

        @Override // com.google.common.base.p
        public boolean apply(T t2) {
            try {
                return this.target.contains(t2);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // com.google.common.base.p
        public boolean equals(Object obj) {
            if (obj instanceof InPredicate) {
                return this.target.equals(((InPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.target);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 15);
            sb2.append("Predicates.in(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }

        private InPredicate(Collection<?> collection) {
            this.target = (Collection) o.r(collection);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class InstanceOfPredicate<T> implements p<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        @Override // com.google.common.base.p
        public boolean apply(T t2) {
            return this.clazz.isInstance(t2);
        }

        @Override // com.google.common.base.p
        public boolean equals(Object obj) {
            return (obj instanceof InstanceOfPredicate) && this.clazz == ((InstanceOfPredicate) obj).clazz;
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public String toString() {
            String name = this.clazz.getName();
            StringBuilder sb2 = new StringBuilder(name.length() + 23);
            sb2.append("Predicates.instanceOf(");
            sb2.append(name);
            sb2.append(")");
            return sb2.toString();
        }

        private InstanceOfPredicate(Class<?> cls) {
            this.clazz = (Class) o.r(cls);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class IsEqualToPredicate implements p<Object>, Serializable {
        private static final long serialVersionUID = 0;
        private final Object target;

        @Override // com.google.common.base.p
        public boolean apply(Object obj) {
            return this.target.equals(obj);
        }

        @Override // com.google.common.base.p
        public boolean equals(Object obj) {
            if (obj instanceof IsEqualToPredicate) {
                return this.target.equals(((IsEqualToPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.target);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 20);
            sb2.append("Predicates.equalTo(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }

        public <T> p<T> withNarrowedType() {
            return this;
        }

        private IsEqualToPredicate(Object obj) {
            this.target = obj;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class NotPredicate<T> implements p<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final p<T> predicate;

        public NotPredicate(p<T> pVar) {
            this.predicate = (p) o.r(pVar);
        }

        @Override // com.google.common.base.p
        public boolean apply(T t2) {
            return !this.predicate.apply(t2);
        }

        @Override // com.google.common.base.p
        public boolean equals(Object obj) {
            if (obj instanceof NotPredicate) {
                return this.predicate.equals(((NotPredicate) obj).predicate);
            }
            return false;
        }

        public int hashCode() {
            return ~this.predicate.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.predicate);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 16);
            sb2.append("Predicates.not(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum ObjectPredicate implements p<Object> {
        ALWAYS_TRUE { // from class: com.google.common.base.Predicates.ObjectPredicate.1
            @Override // com.google.common.base.Predicates.ObjectPredicate, com.google.common.base.p
            public boolean apply(Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE { // from class: com.google.common.base.Predicates.ObjectPredicate.2
            @Override // com.google.common.base.Predicates.ObjectPredicate, com.google.common.base.p
            public boolean apply(Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.3
            @Override // com.google.common.base.Predicates.ObjectPredicate, com.google.common.base.p
            public boolean apply(Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.4
            @Override // com.google.common.base.Predicates.ObjectPredicate, com.google.common.base.p
            public boolean apply(Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        };

        @Override // com.google.common.base.p
        public abstract /* synthetic */ boolean apply(Object obj);

        public <T> p<T> withNarrowedType() {
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class OrPredicate<T> implements p<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends p<? super T>> components;

        @Override // com.google.common.base.p
        public boolean apply(T t2) {
            for (int i10 = 0; i10 < this.components.size(); i10++) {
                if (this.components.get(i10).apply(t2)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.base.p
        public boolean equals(Object obj) {
            if (obj instanceof OrPredicate) {
                return this.components.equals(((OrPredicate) obj).components);
            }
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 87855567;
        }

        public String toString() {
            return Predicates.h("or", this.components);
        }

        private OrPredicate(List<? extends p<? super T>> list) {
            this.components = list;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SubtypeOfPredicate implements p<Class<?>>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        @Override // com.google.common.base.p
        public boolean equals(Object obj) {
            return (obj instanceof SubtypeOfPredicate) && this.clazz == ((SubtypeOfPredicate) obj).clazz;
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public String toString() {
            String name = this.clazz.getName();
            StringBuilder sb2 = new StringBuilder(name.length() + 22);
            sb2.append("Predicates.subtypeOf(");
            sb2.append(name);
            sb2.append(")");
            return sb2.toString();
        }

        private SubtypeOfPredicate(Class<?> cls) {
            this.clazz = (Class) o.r(cls);
        }

        @Override // com.google.common.base.p
        public boolean apply(Class<?> cls) {
            return this.clazz.isAssignableFrom(cls);
        }
    }

    public static <T> p<T> b() {
        return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    public static <A, B> p<A> c(p<B> pVar, g<A, ? extends B> gVar) {
        return new CompositionPredicate(pVar, gVar);
    }

    public static <T> p<T> d(T t2) {
        if (t2 == null) {
            return f();
        }
        return new IsEqualToPredicate(t2).withNarrowedType();
    }

    public static <T> p<T> e(Collection<? extends T> collection) {
        return new InPredicate(collection);
    }

    public static <T> p<T> f() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    public static <T> p<T> g(p<T> pVar) {
        return new NotPredicate(pVar);
    }

    public static String h(String str, Iterable<?> iterable) {
        StringBuilder sb2 = new StringBuilder("Predicates.");
        sb2.append(str);
        sb2.append('(');
        boolean z10 = true;
        for (Object obj : iterable) {
            if (!z10) {
                sb2.append(',');
            }
            sb2.append(obj);
            z10 = false;
        }
        sb2.append(')');
        return sb2.toString();
    }
}
