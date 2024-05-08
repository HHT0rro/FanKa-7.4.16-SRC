package com.google.common.reflect;

import com.google.common.base.i;
import com.google.common.base.o;
import com.google.common.base.p;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.b0;
import com.google.common.collect.i1;
import com.google.common.collect.r;
import com.google.common.reflect.Types;
import com.google.common.reflect.a;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class TypeToken<T> extends com.google.common.reflect.c<T> implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;
    private transient com.google.common.reflect.e covariantTypeResolver;
    private transient com.google.common.reflect.e invariantTypeResolver;
    private final Type runtimeType;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class ClassSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        private transient ImmutableSet<TypeToken<? super T>> classes;

        private ClassSet() {
            super();
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) f.f26727b.a().c(TypeToken.this.getRawTypes()));
        }

        public /* synthetic */ ClassSet(TypeToken typeToken, a aVar) {
            this();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.b0, com.google.common.collect.s, com.google.common.collect.z
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.classes;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> i10 = r.g(f.f26726a.a().d(TypeToken.this)).f(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).i();
            this.classes = i10;
            return i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        public SimpleTypeToken(Type type) {
            super(type, null);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum TypeFilter implements p<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD { // from class: com.google.common.reflect.TypeToken.TypeFilter.1
            @Override // com.google.common.reflect.TypeToken.TypeFilter, com.google.common.base.p
            public boolean apply(TypeToken<?> typeToken) {
                return ((((TypeToken) typeToken).runtimeType instanceof TypeVariable) || (((TypeToken) typeToken).runtimeType instanceof WildcardType)) ? false : true;
            }
        },
        INTERFACE_ONLY { // from class: com.google.common.reflect.TypeToken.TypeFilter.2
            @Override // com.google.common.reflect.TypeToken.TypeFilter, com.google.common.base.p
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }
        };

        @Override // com.google.common.base.p
        public abstract /* synthetic */ boolean apply(T t2);

        /* synthetic */ TypeFilter(a aVar) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends a.b<T> {
        public a(Method method) {
            super(method);
        }

        @Override // com.google.common.reflect.a
        public TypeToken<T> a() {
            return TypeToken.this;
        }

        @Override // com.google.common.reflect.a
        public String toString() {
            String valueOf = String.valueOf(a());
            String aVar = super.toString();
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + String.valueOf(aVar).length());
            sb2.append(valueOf);
            sb2.append(".");
            sb2.append(aVar);
            return sb2.toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends a.C0240a<T> {
        public b(Constructor constructor) {
            super(constructor);
        }

        @Override // com.google.common.reflect.a
        public TypeToken<T> a() {
            return TypeToken.this;
        }

        @Override // com.google.common.reflect.a.C0240a
        public Type[] b() {
            return TypeToken.this.getInvariantTypeResolver().l(super.b());
        }

        @Override // com.google.common.reflect.a
        public String toString() {
            String valueOf = String.valueOf(a());
            String f10 = i.h(", ").f(b());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 2 + String.valueOf(f10).length());
            sb2.append(valueOf);
            sb2.append("(");
            sb2.append(f10);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c extends g {
        public c() {
        }

        @Override // com.google.common.reflect.g
        public void c(GenericArrayType genericArrayType) {
            a(genericArrayType.getGenericComponentType());
        }

        @Override // com.google.common.reflect.g
        public void d(ParameterizedType parameterizedType) {
            a(parameterizedType.getActualTypeArguments());
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.g
        public void e(TypeVariable<?> typeVariable) {
            String valueOf = String.valueOf(TypeToken.this.runtimeType);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 58);
            sb2.append(valueOf);
            sb2.append("contains a type variable and is not safe for the operation");
            throw new IllegalArgumentException(sb2.toString());
        }

        @Override // com.google.common.reflect.g
        public void f(WildcardType wildcardType) {
            a(wildcardType.getLowerBounds());
            a(wildcardType.getUpperBounds());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class d extends g {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImmutableSet.a f26723b;

        public d(TypeToken typeToken, ImmutableSet.a aVar) {
            this.f26723b = aVar;
        }

        @Override // com.google.common.reflect.g
        public void b(Class<?> cls) {
            this.f26723b.a(cls);
        }

        @Override // com.google.common.reflect.g
        public void c(GenericArrayType genericArrayType) {
            this.f26723b.a(Types.h(TypeToken.of(genericArrayType.getGenericComponentType()).getRawType()));
        }

        @Override // com.google.common.reflect.g
        public void d(ParameterizedType parameterizedType) {
            this.f26723b.a((Class) parameterizedType.getRawType());
        }

        @Override // com.google.common.reflect.g
        public void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.g
        public void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final Type[] f26724a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f26725b;

        public e(Type[] typeArr, boolean z10) {
            this.f26724a = typeArr;
            this.f26725b = z10;
        }

        public boolean a(Type type) {
            for (Type type2 : this.f26724a) {
                boolean isSubtypeOf = TypeToken.of(type2).isSubtypeOf(type);
                boolean z10 = this.f26725b;
                if (isSubtypeOf == z10) {
                    return z10;
                }
            }
            return !this.f26725b;
        }

        public boolean b(Type type) {
            TypeToken<?> of = TypeToken.of(type);
            for (Type type2 : this.f26724a) {
                boolean isSubtypeOf = of.isSubtypeOf(type2);
                boolean z10 = this.f26725b;
                if (isSubtypeOf == z10) {
                    return z10;
                }
            }
            return !this.f26725b;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class f<K> {

        /* renamed from: a, reason: collision with root package name */
        public static final f<TypeToken<?>> f26726a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final f<Class<?>> f26727b = new b();

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends f<TypeToken<?>> {
            public a() {
                super(null);
            }

            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public Iterable<? extends TypeToken<?>> e(TypeToken<?> typeToken) {
                return typeToken.getGenericInterfaces();
            }

            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Class<?> f(TypeToken<?> typeToken) {
                return typeToken.getRawType();
            }

            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public TypeToken<?> g(TypeToken<?> typeToken) {
                return typeToken.getGenericSuperclass();
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class b extends f<Class<?>> {
            public b() {
                super(null);
            }

            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public Iterable<? extends Class<?>> e(Class<?> cls) {
                return Arrays.asList(cls.getInterfaces());
            }

            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Class<?> f(Class<?> cls) {
                return cls;
            }

            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public Class<?> g(Class<?> cls) {
                return cls.getSuperclass();
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class c extends e<K> {
            public c(f fVar, f fVar2) {
                super(fVar2);
            }

            @Override // com.google.common.reflect.TypeToken.f
            public ImmutableList<K> c(Iterable<? extends K> iterable) {
                ImmutableList.a builder = ImmutableList.builder();
                for (K k10 : iterable) {
                    if (!f(k10).isInterface()) {
                        builder.a(k10);
                    }
                }
                return super.c(builder.k());
            }

            @Override // com.google.common.reflect.TypeToken.f
            public Iterable<? extends K> e(K k10) {
                return ImmutableSet.of();
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class d extends Ordering<K> {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Comparator f26728b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Map f26729c;

            public d(Comparator comparator, Map map) {
                this.f26728b = comparator;
                this.f26729c = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Ordering, java.util.Comparator
            public int compare(K k10, K k11) {
                Comparator comparator = this.f26728b;
                Object obj = this.f26729c.get(k10);
                Objects.requireNonNull(obj);
                Object obj2 = this.f26729c.get(k11);
                Objects.requireNonNull(obj2);
                return comparator.compare(obj, obj2);
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class e<K> extends f<K> {

            /* renamed from: c, reason: collision with root package name */
            public final f<K> f26730c;

            public e(f<K> fVar) {
                super(null);
                this.f26730c = fVar;
            }

            @Override // com.google.common.reflect.TypeToken.f
            public Class<?> f(K k10) {
                return this.f26730c.f(k10);
            }

            @Override // com.google.common.reflect.TypeToken.f
            public K g(K k10) {
                return this.f26730c.g(k10);
            }
        }

        public f() {
        }

        public static <K, V> ImmutableList<K> h(Map<K, V> map, Comparator<? super V> comparator) {
            return (ImmutableList<K>) new d(comparator, map).immutableSortedCopy(map.h());
        }

        public final f<K> a() {
            return new c(this, this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int b(K k10, Map<? super K, Integer> map) {
            Integer num = map.get(k10);
            if (num != null) {
                return num.intValue();
            }
            boolean isInterface = f(k10).isInterface();
            Iterator<? extends K> iterator2 = e(k10).iterator2();
            int i10 = isInterface;
            while (iterator2.hasNext()) {
                i10 = Math.max(i10, b(iterator2.next(), map));
            }
            K g3 = g(k10);
            int i11 = i10;
            if (g3 != null) {
                i11 = Math.max(i10, b(g3, map));
            }
            int i12 = i11 + 1;
            map.put(k10, Integer.valueOf(i12));
            return i12;
        }

        public ImmutableList<K> c(Iterable<? extends K> iterable) {
            HashMap p10 = Maps.p();
            Iterator<? extends K> iterator2 = iterable.iterator2();
            while (iterator2.hasNext()) {
                b(iterator2.next(), p10);
            }
            return h(p10, Ordering.natural().reverse());
        }

        public final ImmutableList<K> d(K k10) {
            return c(ImmutableList.of(k10));
        }

        public abstract Iterable<? extends K> e(K k10);

        public abstract Class<?> f(K k10);

        public abstract K g(K k10);

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public /* synthetic */ TypeToken(Type type, a aVar) {
        this(type);
    }

    private static e any(Type[] typeArr) {
        return new e(typeArr, true);
    }

    private TypeToken<? super T> boundAsSuperclass(Type type) {
        TypeToken<? super T> typeToken = (TypeToken<? super T>) of(type);
        if (typeToken.getRawType().isInterface()) {
            return null;
        }
        return typeToken;
    }

    private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] typeArr) {
        ImmutableList.a builder = ImmutableList.builder();
        for (Type type : typeArr) {
            TypeToken<?> of = of(type);
            if (of.getRawType().isInterface()) {
                builder.a(of);
            }
        }
        return builder.k();
    }

    private static Type canonicalizeTypeArg(TypeVariable<?> typeVariable, Type type) {
        if (type instanceof WildcardType) {
            return canonicalizeWildcardType(typeVariable, (WildcardType) type);
        }
        return canonicalizeWildcardsInType(type);
    }

    private static WildcardType canonicalizeWildcardType(TypeVariable<?> typeVariable, WildcardType wildcardType) {
        Type[] bounds = typeVariable.getBounds();
        ArrayList arrayList = new ArrayList();
        for (Type type : wildcardType.getUpperBounds()) {
            if (!any(bounds).a(type)) {
                arrayList.add(canonicalizeWildcardsInType(type));
            }
        }
        return new Types.WildcardTypeImpl(wildcardType.getLowerBounds(), (Type[]) arrayList.toArray(new Type[0]));
    }

    private static ParameterizedType canonicalizeWildcardsInParameterizedType(ParameterizedType parameterizedType) {
        Class cls = (Class) parameterizedType.getRawType();
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i10 = 0; i10 < actualTypeArguments.length; i10++) {
            actualTypeArguments[i10] = canonicalizeTypeArg(typeParameters[i10], actualTypeArguments[i10]);
        }
        return Types.m(parameterizedType.getOwnerType(), cls, actualTypeArguments);
    }

    private static Type canonicalizeWildcardsInType(Type type) {
        if (type instanceof ParameterizedType) {
            return canonicalizeWildcardsInParameterizedType((ParameterizedType) type);
        }
        return type instanceof GenericArrayType ? Types.j(canonicalizeWildcardsInType(((GenericArrayType) type).getGenericComponentType())) : type;
    }

    private static e every(Type[] typeArr) {
        return new e(typeArr, false);
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> cls) {
        Class<?> componentType = cls.getComponentType();
        if (componentType != null) {
            TypeToken<?> componentType2 = getComponentType();
            Objects.requireNonNull(componentType2);
            return (TypeToken<? extends T>) of(newArrayClassOrGenericArrayType(componentType2.getSubtype(componentType).runtimeType));
        }
        String valueOf = String.valueOf(cls);
        String valueOf2 = String.valueOf(this);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 36 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append(" does not appear to be a subtype of ");
        sb2.append(valueOf2);
        throw new IllegalArgumentException(sb2.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeToken<? super T> getArraySupertype(Class<? super T> cls) {
        TypeToken<?> componentType = getComponentType();
        if (componentType != 0) {
            Class<?> componentType2 = cls.getComponentType();
            Objects.requireNonNull(componentType2);
            return (TypeToken<? super T>) of(newArrayClassOrGenericArrayType(componentType.getSupertype(componentType2).runtimeType));
        }
        String valueOf = String.valueOf(cls);
        String valueOf2 = String.valueOf(this);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 23 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append(" isn't a super type of ");
        sb2.append(valueOf2);
        throw new IllegalArgumentException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.common.reflect.e getCovariantTypeResolver() {
        com.google.common.reflect.e eVar = this.covariantTypeResolver;
        if (eVar != null) {
            return eVar;
        }
        com.google.common.reflect.e d10 = com.google.common.reflect.e.d(this.runtimeType);
        this.covariantTypeResolver = d10;
        return d10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.common.reflect.e getInvariantTypeResolver() {
        com.google.common.reflect.e eVar = this.invariantTypeResolver;
        if (eVar != null) {
            return eVar;
        }
        com.google.common.reflect.e f10 = com.google.common.reflect.e.f(this.runtimeType);
        this.invariantTypeResolver = f10;
        return f10;
    }

    private Type getOwnerTypeIfPresent() {
        Type type = this.runtimeType;
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getOwnerType();
        }
        if (type instanceof Class) {
            return ((Class) type).getEnclosingClass();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImmutableSet<Class<? super T>> getRawTypes() {
        ImmutableSet.a builder = ImmutableSet.builder();
        new d(this, builder).a(this.runtimeType);
        return builder.m();
    }

    private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> cls, Type[] typeArr) {
        if (typeArr.length > 0) {
            return (TypeToken<? extends T>) of(typeArr[0]).getSubtype(cls);
        }
        String valueOf = String.valueOf(cls);
        String valueOf2 = String.valueOf(this);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 21 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append(" isn't a subclass of ");
        sb2.append(valueOf2);
        throw new IllegalArgumentException(sb2.toString());
    }

    private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> cls, Type[] typeArr) {
        for (Type type : typeArr) {
            TypeToken<?> of = of(type);
            if (of.isSubtypeOf(cls)) {
                return (TypeToken<? super T>) of.getSupertype(cls);
            }
        }
        String valueOf = String.valueOf(cls);
        String valueOf2 = String.valueOf(this);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 23 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append(" isn't a super type of ");
        sb2.append(valueOf2);
        throw new IllegalArgumentException(sb2.toString());
    }

    private boolean is(Type type, TypeVariable<?> typeVariable) {
        if (this.runtimeType.equals(type)) {
            return true;
        }
        if (type instanceof WildcardType) {
            WildcardType canonicalizeWildcardType = canonicalizeWildcardType(typeVariable, (WildcardType) type);
            return every(canonicalizeWildcardType.getUpperBounds()).b(this.runtimeType) && every(canonicalizeWildcardType.getLowerBounds()).a(this.runtimeType);
        }
        return canonicalizeWildcardsInType(this.runtimeType).equals(canonicalizeWildcardsInType(type));
    }

    private boolean isOwnedBySubtypeOf(Type type) {
        Iterator<TypeToken<? super T>> iterator2 = getTypes().iterator2();
        while (iterator2.hasNext()) {
            Type ownerTypeIfPresent = iterator2.next().getOwnerTypeIfPresent();
            if (ownerTypeIfPresent != null && of(ownerTypeIfPresent).isSubtypeOf(type)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSubtypeOfArrayType(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                return of((Class) cls.getComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return of(((GenericArrayType) type).getGenericComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
        }
        return false;
    }

    private boolean isSubtypeOfParameterizedType(ParameterizedType parameterizedType) {
        Class<? super Object> rawType = of(parameterizedType).getRawType();
        if (!someRawTypeIsSubclassOf(rawType)) {
            return false;
        }
        TypeVariable<Class<? super Object>>[] typeParameters = rawType.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i10 = 0; i10 < typeParameters.length; i10++) {
            if (!of(getCovariantTypeResolver().j(typeParameters[i10])).is(actualTypeArguments[i10], typeParameters[i10])) {
                return false;
            }
        }
        return Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers()) || parameterizedType.getOwnerType() == null || isOwnedBySubtypeOf(parameterizedType.getOwnerType());
    }

    private boolean isSupertypeOfArray(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (!cls.isArray()) {
                return cls.isAssignableFrom(Object[].class);
            }
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(cls.getComponentType());
        }
        if (type instanceof GenericArrayType) {
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
        }
        return false;
    }

    private boolean isWrapper() {
        return com.google.common.primitives.d.b().contains(this.runtimeType);
    }

    private static Type newArrayClassOrGenericArrayType(Type type) {
        return Types.JavaVersion.JAVA7.newArrayType(type);
    }

    public static <T> TypeToken<T> of(Class<T> cls) {
        return new SimpleTypeToken(cls);
    }

    private TypeToken<?> resolveSupertype(Type type) {
        TypeToken<?> of = of(getCovariantTypeResolver().j(type));
        of.covariantTypeResolver = this.covariantTypeResolver;
        of.invariantTypeResolver = this.invariantTypeResolver;
        return of;
    }

    private Type resolveTypeArgsForSubclass(Class<?> cls) {
        if ((this.runtimeType instanceof Class) && (cls.getTypeParameters().length == 0 || getRawType().getTypeParameters().length != 0)) {
            return cls;
        }
        TypeToken genericType = toGenericType(cls);
        return new com.google.common.reflect.e().n(genericType.getSupertype(getRawType()).runtimeType, this.runtimeType).j(genericType.runtimeType);
    }

    private boolean someRawTypeIsSubclassOf(Class<?> cls) {
        i1<Class<? super T>> iterator2 = getRawTypes().iterator2();
        while (iterator2.hasNext()) {
            if (cls.isAssignableFrom(iterator2.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> TypeToken<? extends T> toGenericType(Class<T> cls) {
        if (cls.isArray()) {
            return (TypeToken<? extends T>) of(Types.j(toGenericType(cls.getComponentType()).runtimeType));
        }
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type type = (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? null : toGenericType(cls.getEnclosingClass()).runtimeType;
        if (typeParameters.length <= 0 && (type == null || type == cls.getEnclosingClass())) {
            return of((Class) cls);
        }
        return (TypeToken<? extends T>) of(Types.m(type, cls, typeParameters));
    }

    public final com.google.common.reflect.a<T, T> constructor(Constructor<?> constructor) {
        o.n(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
        return new b(constructor);
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeToken) {
            return this.runtimeType.equals(((TypeToken) obj).runtimeType);
        }
        return false;
    }

    public final TypeToken<?> getComponentType() {
        Type i10 = Types.i(this.runtimeType);
        if (i10 == null) {
            return null;
        }
        return of(i10);
    }

    public final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundsAsInterfaces(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return boundsAsInterfaces(((WildcardType) type).getUpperBounds());
        }
        ImmutableList.a builder = ImmutableList.builder();
        for (Type type2 : getRawType().getGenericInterfaces()) {
            builder.a(resolveSupertype(type2));
        }
        return builder.k();
    }

    public final TypeToken<? super T> getGenericSuperclass() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundAsSuperclass(((TypeVariable) type).getBounds()[0]);
        }
        if (type instanceof WildcardType) {
            return boundAsSuperclass(((WildcardType) type).getUpperBounds()[0]);
        }
        Type genericSuperclass = getRawType().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return (TypeToken<? super T>) resolveSupertype(genericSuperclass);
    }

    public final Class<? super T> getRawType() {
        return getRawTypes().iterator2().next();
    }

    public final TypeToken<? extends T> getSubtype(Class<?> cls) {
        o.m(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        Type type = this.runtimeType;
        if (type instanceof WildcardType) {
            return getSubtypeFromLowerBounds(cls, ((WildcardType) type).getLowerBounds());
        }
        if (isArray()) {
            return getArraySubtype(cls);
        }
        o.n(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        TypeToken<? extends T> typeToken = (TypeToken<? extends T>) of(resolveTypeArgsForSubclass(cls));
        o.n(typeToken.isSubtypeOf((TypeToken<?>) this), "%s does not appear to be a subtype of %s", typeToken, this);
        return typeToken;
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        o.n(someRawTypeIsSubclassOf(cls), "%s is not a super class of %s", cls, this);
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return getSupertypeFromUpperBounds(cls, ((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return getSupertypeFromUpperBounds(cls, ((WildcardType) type).getUpperBounds());
        }
        if (cls.isArray()) {
            return getArraySupertype(cls);
        }
        return (TypeToken<? super T>) resolveSupertype(toGenericType(cls).runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet();
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    public final boolean isPrimitive() {
        Type type = this.runtimeType;
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    public final boolean isSubtypeOf(TypeToken<?> typeToken) {
        return isSubtypeOf(typeToken.getType());
    }

    public final boolean isSupertypeOf(TypeToken<?> typeToken) {
        return typeToken.isSubtypeOf(getType());
    }

    public final com.google.common.reflect.a<T, Object> method(Method method) {
        o.n(someRawTypeIsSubclassOf(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new a(method);
    }

    public final TypeToken<T> rejectTypeVariables() {
        new c().a(this.runtimeType);
        return this;
    }

    public final TypeToken<?> resolveType(Type type) {
        o.r(type);
        return of(getInvariantTypeResolver().j(type));
    }

    public String toString() {
        return Types.s(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        return isWrapper() ? of(com.google.common.primitives.d.c((Class) this.runtimeType)) : this;
    }

    public final <X> TypeToken<T> where(com.google.common.reflect.d<X> dVar, TypeToken<X> typeToken) {
        new com.google.common.reflect.e();
        throw null;
    }

    public final TypeToken<T> wrap() {
        return isPrimitive() ? of(com.google.common.primitives.d.d((Class) this.runtimeType)) : this;
    }

    public Object writeReplace() {
        return of(new com.google.common.reflect.e().j(this.runtimeType));
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class InterfaceSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        private final transient TypeToken<T>.TypeSet allTypes;
        private transient ImmutableSet<TypeToken<? super T>> interfaces;

        public InterfaceSet(TypeToken<T>.TypeSet typeSet) {
            super();
            this.allTypes = typeSet;
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return r.g(f.f26727b.c(TypeToken.this.getRawTypes())).f(new p() { // from class: com.google.common.reflect.f
                @Override // com.google.common.base.p
                public final boolean apply(Object obj) {
                    return ((Class) obj).isInterface();
                }
            }).i();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.b0, com.google.common.collect.s, com.google.common.collect.z
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.interfaces;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> i10 = r.g(this.allTypes).f(TypeFilter.INTERFACE_ONLY).i();
            this.interfaces = i10;
            return i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class TypeSet extends b0<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;
        private transient ImmutableSet<TypeToken<? super T>> types;

        public TypeSet() {
        }

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet(TypeToken.this, null);
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this);
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) f.f26727b.c(TypeToken.this.getRawTypes()));
        }

        @Override // com.google.common.collect.b0, com.google.common.collect.s, com.google.common.collect.z
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.types;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> i10 = r.g(f.f26726a.d(TypeToken.this)).f(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).i();
            this.types = i10;
            return i10;
        }
    }

    public TypeToken() {
        Type capture = capture();
        this.runtimeType = capture;
        o.B(!(capture instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", capture);
    }

    public static TypeToken<?> of(Type type) {
        return new SimpleTypeToken(type);
    }

    public final boolean isSubtypeOf(Type type) {
        o.r(type);
        if (type instanceof WildcardType) {
            return any(((WildcardType) type).getLowerBounds()).b(this.runtimeType);
        }
        Type type2 = this.runtimeType;
        if (type2 instanceof WildcardType) {
            return any(((WildcardType) type2).getUpperBounds()).a(type);
        }
        if (type2 instanceof TypeVariable) {
            return type2.equals(type) || any(((TypeVariable) this.runtimeType).getBounds()).a(type);
        }
        if (type2 instanceof GenericArrayType) {
            return of(type).isSupertypeOfArray((GenericArrayType) this.runtimeType);
        }
        if (type instanceof Class) {
            return someRawTypeIsSubclassOf((Class) type);
        }
        if (type instanceof ParameterizedType) {
            return isSubtypeOfParameterizedType((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return isSubtypeOfArrayType((GenericArrayType) type);
        }
        return false;
    }

    public final boolean isSupertypeOf(Type type) {
        return of(type).isSubtypeOf(getType());
    }

    public final <X> TypeToken<T> where(com.google.common.reflect.d<X> dVar, Class<X> cls) {
        return where(dVar, of((Class) cls));
    }

    public TypeToken(Class<?> cls) {
        Type capture = super.capture();
        if (capture instanceof Class) {
            this.runtimeType = capture;
        } else {
            this.runtimeType = com.google.common.reflect.e.d(cls).j(capture);
        }
    }

    private TypeToken(Type type) {
        this.runtimeType = (Type) o.r(type);
    }
}
