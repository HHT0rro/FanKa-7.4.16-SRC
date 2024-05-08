package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ConstructorConstructor {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Type, InstanceCreator<?>> f26837a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f26838b;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map, boolean z10) {
        this.f26837a = map;
        this.f26838b = z10;
    }

    public <T> ObjectConstructor<T> a(TypeToken<T> typeToken) {
        final Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        final InstanceCreator<?> instanceCreator = this.f26837a.get(type);
        if (instanceCreator != null) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.1
                @Override // com.google.gson.internal.ObjectConstructor
                public T a() {
                    return (T) instanceCreator.createInstance(type);
                }
            };
        }
        final InstanceCreator<?> instanceCreator2 = this.f26837a.get(rawType);
        if (instanceCreator2 != null) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.2
                @Override // com.google.gson.internal.ObjectConstructor
                public T a() {
                    return (T) instanceCreator2.createInstance(type);
                }
            };
        }
        ObjectConstructor<T> b4 = b(rawType);
        if (b4 != null) {
            return b4;
        }
        ObjectConstructor<T> c4 = c(type, rawType);
        return c4 != null ? c4 : d(rawType);
    }

    public final <T> ObjectConstructor<T> b(Class<? super T> cls) {
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            final String c4 = ReflectionHelper.c(declaredConstructor);
            if (c4 != null) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.3
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T a() {
                        throw new JsonIOException(c4);
                    }
                };
            }
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.4
                @Override // com.google.gson.internal.ObjectConstructor
                public T a() {
                    try {
                        return (T) declaredConstructor.newInstance(new Object[0]);
                    } catch (IllegalAccessException e2) {
                        throw new AssertionError(e2);
                    } catch (InstantiationException e10) {
                        throw new RuntimeException("Failed to invoke " + ((Object) declaredConstructor) + " with no args", e10);
                    } catch (InvocationTargetException e11) {
                        throw new RuntimeException("Failed to invoke " + ((Object) declaredConstructor) + " with no args", e11.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final <T> ObjectConstructor<T> c(final Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.5
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T a() {
                        return (T) new TreeSet();
                    }
                };
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.6
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T a() {
                        Type type2 = type;
                        if (type2 instanceof ParameterizedType) {
                            Type type3 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                            if (type3 instanceof Class) {
                                return (T) EnumSet.noneOf((Class) type3);
                            }
                            throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                        }
                        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                    }
                };
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.7
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T a() {
                        return (T) new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.8
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T a() {
                        return (T) new ArrayDeque();
                    }
                };
            }
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.9
                @Override // com.google.gson.internal.ObjectConstructor
                public T a() {
                    return (T) new ArrayList();
                }
            };
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (cls == EnumMap.class) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.10
                @Override // com.google.gson.internal.ObjectConstructor
                public T a() {
                    Type type2 = type;
                    if (type2 instanceof ParameterizedType) {
                        Type type3 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                        if (type3 instanceof Class) {
                            return (T) new EnumMap((Class) type3);
                        }
                        throw new JsonIOException("Invalid EnumMap type: " + type.toString());
                    }
                    throw new JsonIOException("Invalid EnumMap type: " + type.toString());
                }
            };
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.11
                @Override // com.google.gson.internal.ObjectConstructor
                public T a() {
                    return (T) new ConcurrentSkipListMap();
                }
            };
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.12
                @Override // com.google.gson.internal.ObjectConstructor
                public T a() {
                    return (T) new ConcurrentHashMap();
                }
            };
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.13
                @Override // com.google.gson.internal.ObjectConstructor
                public T a() {
                    return (T) new TreeMap();
                }
            };
        }
        if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.14
                @Override // com.google.gson.internal.ObjectConstructor
                public T a() {
                    return (T) new LinkedHashMap();
                }
            };
        }
        return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.15
            @Override // com.google.gson.internal.ObjectConstructor
            public T a() {
                return (T) new LinkedTreeMap();
            }
        };
    }

    public final <T> ObjectConstructor<T> d(final Class<? super T> cls) {
        if (this.f26838b) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.16

                /* renamed from: a, reason: collision with root package name */
                public final UnsafeAllocator f26849a = UnsafeAllocator.b();

                @Override // com.google.gson.internal.ObjectConstructor
                public T a() {
                    try {
                        return (T) this.f26849a.c(cls);
                    } catch (Exception e2) {
                        throw new RuntimeException("Unable to create instance of " + ((Object) cls) + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e2);
                    }
                }
            };
        }
        final String str = "Unable to create instance of " + ((Object) cls) + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.17
            @Override // com.google.gson.internal.ObjectConstructor
            public T a() {
                throw new JsonIOException(str);
            }
        };
    }

    public String toString() {
        return this.f26837a.toString();
    }
}
