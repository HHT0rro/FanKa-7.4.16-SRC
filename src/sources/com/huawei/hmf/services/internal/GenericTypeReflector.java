package com.huawei.hmf.services.internal;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class GenericTypeReflector {
    private GenericTypeReflector() {
    }

    public static Type canonicalize(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (!(type instanceof ParameterizedType)) {
            return type;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        return new ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
    }

    private static Class<?> declaringClass(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    public static Type getGenericSupertype(Type type, Class<?> cls, Class<?> cls2) {
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
                    return getGenericSupertype(cls.getGenericInterfaces()[i10], interfaces[i10], cls2);
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
                    return getGenericSupertype(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Class<?> getType(Type type) {
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
            return getType(typeVariable.getBounds()[0]);
        }
        throw new IllegalArgumentException("Not supported: " + ((Object) type.getClass()));
    }

    private static int indexOf(Object[] objArr, Object obj) {
        for (int i10 = 0; i10 < objArr.length; i10++) {
            if (obj.equals(objArr[i10])) {
                return i10;
            }
        }
        throw new NoSuchElementException();
    }

    public static Type resolve(Type type, Class<?> cls, Type type2) {
        while (type2 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type2;
            Type resolveType = resolveType(type, cls, typeVariable);
            if (resolveType == typeVariable) {
                return resolveType;
            }
            type2 = resolveType;
        }
        if (!(type2 instanceof ParameterizedType)) {
            return type2;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type2;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        int length = actualTypeArguments.length;
        boolean z10 = false;
        for (int i10 = 0; i10 < length; i10++) {
            Type resolve = resolve(type, cls, actualTypeArguments[i10]);
            if (resolve != actualTypeArguments[i10]) {
                if (!z10) {
                    actualTypeArguments = (Type[]) actualTypeArguments.clone();
                    z10 = true;
                }
                actualTypeArguments[i10] = resolve;
            }
        }
        return z10 ? new ParameterizedTypeImpl(null, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
    }

    public static Type resolveType(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> declaringClass = declaringClass(typeVariable);
        if (declaringClass == null) {
            return typeVariable;
        }
        Type genericSupertype = getGenericSupertype(type, cls, declaringClass);
        if (!(genericSupertype instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) genericSupertype).getActualTypeArguments()[indexOf(declaringClass.getTypeParameters(), typeVariable)];
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        public ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            int i10 = 0;
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z10 = true;
                boolean z11 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z11) {
                    z10 = false;
                }
                assertArgument(z10);
            }
            this.ownerType = type == null ? null : GenericTypeReflector.canonicalize(type);
            this.rawType = GenericTypeReflector.canonicalize(type2);
            this.typeArguments = (Type[]) typeArr.clone();
            while (true) {
                Type[] typeArr2 = this.typeArguments;
                if (i10 >= typeArr2.length) {
                    return;
                }
                assertNotNull(typeArr2[i10]);
                assertNotPrimitive(this.typeArguments[i10]);
                Type[] typeArr3 = this.typeArguments;
                typeArr3[i10] = GenericTypeReflector.canonicalize(typeArr3[i10]);
                i10++;
            }
        }

        private static void assertArgument(boolean z10) {
            if (!z10) {
                throw new IllegalArgumentException();
            }
        }

        private static <T> void assertNotNull(T t2) {
            Objects.requireNonNull(t2);
        }

        private void assertNotPrimitive(Type type) {
            assertArgument(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (this == parameterizedType) {
                return true;
            }
            return Objects.equals(this.ownerType, parameterizedType.getOwnerType()) && Objects.equals(this.rawType, parameterizedType.getRawType()) && Arrays.equals(this.typeArguments, parameterizedType.getActualTypeArguments());
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            int hashCode = Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode();
            Type type = this.ownerType;
            return hashCode ^ (type == null ? 0 : type.hashCode());
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder((this.typeArguments.length + 1) * 30);
            sb2.append(toString(this.rawType));
            if (this.typeArguments.length == 0) {
                return sb2.toString();
            }
            sb2.append("<");
            sb2.append(toString(this.typeArguments[0]));
            for (int i10 = 1; i10 < this.typeArguments.length; i10++) {
                sb2.append(", ");
                sb2.append(toString(this.typeArguments[i10]));
            }
            sb2.append(">");
            return sb2.toString();
        }

        private static String toString(Type type) {
            return type instanceof Class ? ((Class) type).getName() : type.toString();
        }
    }

    public static <T> Class<T> getType(Class<T> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        while (!(genericSuperclass instanceof ParameterizedType)) {
            cls = cls.getSuperclass();
            genericSuperclass = cls.getGenericSuperclass();
        }
        return (Class<T>) getType(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }
}
