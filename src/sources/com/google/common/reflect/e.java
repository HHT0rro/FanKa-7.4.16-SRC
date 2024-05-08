package com.google.common.reflect;

import com.google.common.base.i;
import com.google.common.base.l;
import com.google.common.base.o;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.reflect.Types;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TypeResolver.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final c f26743a;

    /* compiled from: TypeResolver.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends g {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f26744b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Type f26745c;

        public a(Map map, Type type) {
            this.f26744b = map;
            this.f26745c = type;
        }

        @Override // com.google.common.reflect.g
        public void b(Class<?> cls) {
            if (this.f26745c instanceof WildcardType) {
                return;
            }
            String valueOf = String.valueOf(cls);
            String valueOf2 = String.valueOf(this.f26745c);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 25 + valueOf2.length());
            sb2.append("No type mapping from ");
            sb2.append(valueOf);
            sb2.append(" to ");
            sb2.append(valueOf2);
            throw new IllegalArgumentException(sb2.toString());
        }

        @Override // com.google.common.reflect.g
        public void c(GenericArrayType genericArrayType) {
            Type type = this.f26745c;
            if (type instanceof WildcardType) {
                return;
            }
            Type i10 = Types.i(type);
            o.m(i10 != null, "%s is not an array type.", this.f26745c);
            e.g(this.f26744b, genericArrayType.getGenericComponentType(), i10);
        }

        @Override // com.google.common.reflect.g
        public void d(ParameterizedType parameterizedType) {
            Type type = this.f26745c;
            if (type instanceof WildcardType) {
                return;
            }
            ParameterizedType parameterizedType2 = (ParameterizedType) e.e(ParameterizedType.class, type);
            if (parameterizedType.getOwnerType() != null && parameterizedType2.getOwnerType() != null) {
                e.g(this.f26744b, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
            }
            o.n(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, this.f26745c);
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
            o.n(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
            for (int i10 = 0; i10 < actualTypeArguments.length; i10++) {
                e.g(this.f26744b, actualTypeArguments[i10], actualTypeArguments2[i10]);
            }
        }

        @Override // com.google.common.reflect.g
        public void e(TypeVariable<?> typeVariable) {
            this.f26744b.put(new d(typeVariable), this.f26745c);
        }

        @Override // com.google.common.reflect.g
        public void f(WildcardType wildcardType) {
            Type type = this.f26745c;
            if (type instanceof WildcardType) {
                WildcardType wildcardType2 = (WildcardType) type;
                Type[] upperBounds = wildcardType.getUpperBounds();
                Type[] upperBounds2 = wildcardType2.getUpperBounds();
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                o.n(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, this.f26745c);
                for (int i10 = 0; i10 < upperBounds.length; i10++) {
                    e.g(this.f26744b, upperBounds[i10], upperBounds2[i10]);
                }
                for (int i11 = 0; i11 < lowerBounds.length; i11++) {
                    e.g(this.f26744b, lowerBounds[i11], lowerBounds2[i11]);
                }
            }
        }
    }

    /* compiled from: TypeResolver.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class b extends g {

        /* renamed from: b, reason: collision with root package name */
        public final Map<d, Type> f26746b = Maps.p();

        public static ImmutableMap<d, Type> g(Type type) {
            o.r(type);
            b bVar = new b();
            bVar.a(type);
            return ImmutableMap.copyOf((Map) bVar.f26746b);
        }

        @Override // com.google.common.reflect.g
        public void b(Class<?> cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        @Override // com.google.common.reflect.g
        public void d(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            o.x(typeParameters.length == actualTypeArguments.length);
            for (int i10 = 0; i10 < typeParameters.length; i10++) {
                h(new d(typeParameters[i10]), actualTypeArguments[i10]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.g
        public void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.g
        public void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }

        public final void h(d dVar, Type type) {
            if (this.f26746b.containsKey(dVar)) {
                return;
            }
            Type type2 = type;
            while (type2 != null) {
                if (dVar.a(type2)) {
                    while (type != null) {
                        type = this.f26746b.remove(d.c(type));
                    }
                    return;
                }
                type2 = this.f26746b.get(d.c(type2));
            }
            this.f26746b.put(dVar, type);
        }
    }

    /* compiled from: TypeResolver.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final TypeVariable<?> f26750a;

        public d(TypeVariable<?> typeVariable) {
            this.f26750a = (TypeVariable) o.r(typeVariable);
        }

        public static d c(Type type) {
            if (type instanceof TypeVariable) {
                return new d((TypeVariable) type);
            }
            return null;
        }

        public boolean a(Type type) {
            if (type instanceof TypeVariable) {
                return b((TypeVariable) type);
            }
            return false;
        }

        public final boolean b(TypeVariable<?> typeVariable) {
            return this.f26750a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.f26750a.getName().equals(typeVariable.getName());
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return b(((d) obj).f26750a);
            }
            return false;
        }

        public int hashCode() {
            return l.b(this.f26750a.getGenericDeclaration(), this.f26750a.getName());
        }

        public String toString() {
            return this.f26750a.toString();
        }
    }

    /* compiled from: TypeResolver.java */
    /* renamed from: com.google.common.reflect.e$e, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class C0241e {

        /* renamed from: b, reason: collision with root package name */
        public static final C0241e f26751b = new C0241e();

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f26752a;

        /* compiled from: TypeResolver.java */
        /* renamed from: com.google.common.reflect.e$e$a */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends C0241e {

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ TypeVariable f26753c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(C0241e c0241e, AtomicInteger atomicInteger, TypeVariable typeVariable) {
                super(atomicInteger, null);
                this.f26753c = typeVariable;
            }

            @Override // com.google.common.reflect.e.C0241e
            public TypeVariable<?> b(Type[] typeArr) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                linkedHashSet.addAll(Arrays.asList(this.f26753c.getBounds()));
                if (linkedHashSet.size() > 1) {
                    linkedHashSet.remove(Object.class);
                }
                return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
            }
        }

        public /* synthetic */ C0241e(AtomicInteger atomicInteger, a aVar) {
            this(atomicInteger);
        }

        public final Type a(Type type) {
            o.r(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.j(e().a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class cls = (Class) parameterizedType.getRawType();
                TypeVariable<?>[] typeParameters = cls.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i10 = 0; i10 < actualTypeArguments.length; i10++) {
                    actualTypeArguments[i10] = d(typeParameters[i10]).a(actualTypeArguments[i10]);
                }
                return Types.m(e().c(parameterizedType.getOwnerType()), cls, actualTypeArguments);
            }
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? b(wildcardType.getUpperBounds()) : type;
            }
            throw new AssertionError((Object) "must have been one of the known types");
        }

        public TypeVariable<?> b(Type[] typeArr) {
            int incrementAndGet = this.f26752a.incrementAndGet();
            String f10 = i.g(SymbolValues.CHAR_AND_SYMBOL).f(typeArr);
            StringBuilder sb2 = new StringBuilder(String.valueOf(f10).length() + 33);
            sb2.append("capture#");
            sb2.append(incrementAndGet);
            sb2.append("-of ? extends ");
            sb2.append(f10);
            return Types.k(C0241e.class, sb2.toString(), typeArr);
        }

        public final Type c(Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        public final C0241e d(TypeVariable<?> typeVariable) {
            return new a(this, this.f26752a, typeVariable);
        }

        public final C0241e e() {
            return new C0241e(this.f26752a);
        }

        public C0241e() {
            this(new AtomicInteger());
        }

        public C0241e(AtomicInteger atomicInteger) {
            this.f26752a = atomicInteger;
        }
    }

    public /* synthetic */ e(c cVar, a aVar) {
        this(cVar);
    }

    public static e d(Type type) {
        return new e().o(b.g(type));
    }

    public static <T> T e(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            String valueOf = String.valueOf(obj);
            String simpleName = cls.getSimpleName();
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 10 + simpleName.length());
            sb2.append(valueOf);
            sb2.append(" is not a ");
            sb2.append(simpleName);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public static e f(Type type) {
        return new e().o(b.g(C0241e.f26751b.a(type)));
    }

    public static void g(Map<d, Type> map, Type type, Type type2) {
        if (type.equals(type2)) {
            return;
        }
        new a(map, type2).a(type);
    }

    public final Type h(GenericArrayType genericArrayType) {
        return Types.j(j(genericArrayType.getGenericComponentType()));
    }

    public final ParameterizedType i(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        return Types.m(ownerType == null ? null : j(ownerType), (Class) j(parameterizedType.getRawType()), k(parameterizedType.getActualTypeArguments()));
    }

    public Type j(Type type) {
        o.r(type);
        if (type instanceof TypeVariable) {
            return this.f26743a.a((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return i((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return h((GenericArrayType) type);
        }
        return type instanceof WildcardType ? m((WildcardType) type) : type;
    }

    public final Type[] k(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i10 = 0; i10 < typeArr.length; i10++) {
            typeArr2[i10] = j(typeArr[i10]);
        }
        return typeArr2;
    }

    public Type[] l(Type[] typeArr) {
        for (int i10 = 0; i10 < typeArr.length; i10++) {
            typeArr[i10] = j(typeArr[i10]);
        }
        return typeArr;
    }

    public final WildcardType m(WildcardType wildcardType) {
        return new Types.WildcardTypeImpl(k(wildcardType.getLowerBounds()), k(wildcardType.getUpperBounds()));
    }

    public e n(Type type, Type type2) {
        HashMap p10 = Maps.p();
        g(p10, (Type) o.r(type), (Type) o.r(type2));
        return o(p10);
    }

    public e o(Map<d, ? extends Type> map) {
        return new e(this.f26743a.c(map));
    }

    /* compiled from: TypeResolver.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final ImmutableMap<d, Type> f26747a;

        /* compiled from: TypeResolver.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends c {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TypeVariable f26748b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f26749c;

            public a(c cVar, TypeVariable typeVariable, c cVar2) {
                this.f26748b = typeVariable;
                this.f26749c = cVar2;
            }

            @Override // com.google.common.reflect.e.c
            public Type b(TypeVariable<?> typeVariable, c cVar) {
                return typeVariable.getGenericDeclaration().equals(this.f26748b.getGenericDeclaration()) ? typeVariable : this.f26749c.b(typeVariable, cVar);
            }
        }

        public c() {
            this.f26747a = ImmutableMap.of();
        }

        public final Type a(TypeVariable<?> typeVariable) {
            return b(typeVariable, new a(this, typeVariable, this));
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.reflect.GenericDeclaration] */
        public Type b(TypeVariable<?> typeVariable, c cVar) {
            Type type = this.f26747a.get(new d(typeVariable));
            a aVar = null;
            if (type == null) {
                Type[] bounds = typeVariable.getBounds();
                if (bounds.length == 0) {
                    return typeVariable;
                }
                Type[] k10 = new e(cVar, aVar).k(bounds);
                return (Types.b.f26733a && Arrays.equals(bounds, k10)) ? typeVariable : Types.k(typeVariable.getGenericDeclaration(), typeVariable.getName(), k10);
            }
            return new e(cVar, aVar).j(type);
        }

        public final c c(Map<d, ? extends Type> map) {
            ImmutableMap.b builder = ImmutableMap.builder();
            builder.j(this.f26747a);
            for (Map.Entry<d, ? extends Type> entry : map.entrySet()) {
                d key = entry.getKey();
                Type value = entry.getValue();
                o.m(!key.a(value), "Type variable %s bound to itself", key);
                builder.g(key, value);
            }
            return new c(builder.d());
        }

        public c(ImmutableMap<d, Type> immutableMap) {
            this.f26747a = immutableMap;
        }
    }

    public e() {
        this.f26743a = new c();
    }

    public e(c cVar) {
        this.f26743a = cVar;
    }
}
