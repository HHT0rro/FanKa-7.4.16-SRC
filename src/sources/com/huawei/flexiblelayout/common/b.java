package com.huawei.flexiblelayout.common;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

/* compiled from: GenericTypeReflector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {

    /* compiled from: GenericTypeReflector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a implements ParameterizedType, Serializable {

        /* renamed from: d, reason: collision with root package name */
        private static final long f27925d = 0;

        /* renamed from: a, reason: collision with root package name */
        private final Type f27926a;

        /* renamed from: b, reason: collision with root package name */
        private final Type f27927b;

        /* renamed from: c, reason: collision with root package name */
        private final Type[] f27928c;

        public a(Type type, Type type2, Type... typeArr) {
            int i10 = 0;
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z10 = true;
                boolean z11 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z11) {
                    z10 = false;
                }
                a(z10);
            }
            this.f27926a = type == null ? null : b.a(type);
            this.f27927b = b.a(type2);
            this.f27928c = (Type[]) typeArr.clone();
            while (true) {
                Type[] typeArr2 = this.f27928c;
                if (i10 >= typeArr2.length) {
                    return;
                }
                a(typeArr2[i10]);
                a(this.f27928c[i10]);
                Type[] typeArr3 = this.f27928c;
                typeArr3[i10] = b.a(typeArr3[i10]);
                i10++;
            }
        }

        private static void a(boolean z10) {
            if (!z10) {
                throw new IllegalArgumentException();
            }
        }

        private static String b(Type type) {
            return type instanceof Class ? ((Class) type).getName() : type.toString();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (this == parameterizedType) {
                return true;
            }
            return Objects.equals(this.f27926a, parameterizedType.getOwnerType()) && Objects.equals(this.f27927b, parameterizedType.getRawType()) && Arrays.equals(this.f27928c, parameterizedType.getActualTypeArguments());
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f27928c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f27926a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f27927b;
        }

        public int hashCode() {
            int hashCode = Arrays.hashCode(this.f27928c) ^ this.f27927b.hashCode();
            Type type = this.f27926a;
            return hashCode ^ (type == null ? 0 : type.hashCode());
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder((this.f27928c.length + 1) * 30);
            sb2.append(b(this.f27927b));
            if (this.f27928c.length == 0) {
                return sb2.toString();
            }
            sb2.append("<");
            sb2.append(b(this.f27928c[0]));
            for (int i10 = 1; i10 < this.f27928c.length; i10++) {
                sb2.append(", ");
                sb2.append(b(this.f27928c[i10]));
            }
            sb2.append(">");
            return sb2.toString();
        }

        private static <T> void a(T t2) {
            Objects.requireNonNull(t2);
        }

        private void a(Type type) {
            a(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
        }
    }

    private b() {
    }

    public static <T> Class<T> a(Class<T> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        while (!(genericSuperclass instanceof ParameterizedType)) {
            cls = cls.getSuperclass();
            if (cls == null) {
                return null;
            }
            genericSuperclass = cls.getGenericSuperclass();
        }
        return (Class<T>) b(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public static Class<?> b(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type;
            if (typeVariable.getBounds().length == 0) {
                return Object.class;
            }
            return b(typeVariable.getBounds()[0]);
        }
        throw new IllegalArgumentException("Not supported: " + ((Object) type.getClass()));
    }

    public static Type a(Type type, Class<?> cls, Type type2) {
        while (type2 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type2;
            Type a10 = a(type, cls, (TypeVariable<?>) typeVariable);
            if (a10 == typeVariable) {
                return a10;
            }
            type2 = a10;
        }
        if (!(type2 instanceof ParameterizedType)) {
            return type2;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type2;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        int length = actualTypeArguments.length;
        boolean z10 = false;
        for (int i10 = 0; i10 < length; i10++) {
            Type a11 = a(type, cls, actualTypeArguments[i10]);
            if (a11 != actualTypeArguments[i10]) {
                if (!z10) {
                    actualTypeArguments = (Type[]) actualTypeArguments.clone();
                    z10 = true;
                }
                actualTypeArguments[i10] = a11;
            }
        }
        return z10 ? new a(null, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
    }

    public static Type a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> a10 = a(typeVariable);
        if (a10 == null) {
            return typeVariable;
        }
        Type a11 = a(type, cls, a10);
        if (!(a11 instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) a11).getActualTypeArguments()[a(a10.getTypeParameters(), typeVariable)];
    }

    private static Class<?> a(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    public static Type a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i10 = 0; i10 < length; i10++) {
                if (interfaces[i10] == cls2) {
                    return cls.getGenericInterfaces()[i10];
                }
                if (cls2.isAssignableFrom(interfaces[i10])) {
                    return a(cls.getGenericInterfaces()[i10], interfaces[i10], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    private static int a(Object[] objArr, Object obj) {
        for (int i10 = 0; i10 < objArr.length; i10++) {
            if (obj.equals(objArr[i10])) {
                return i10;
            }
        }
        throw new NoSuchElementException();
    }

    public static Type a(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (!(type instanceof ParameterizedType)) {
            return type;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        return new a(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
    }
}
