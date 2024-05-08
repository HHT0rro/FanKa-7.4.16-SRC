package com.huawei.hmf.services.codec;

import com.huawei.hmf.services.internal.GenericTypeReflector;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TypeToken<T> {
    private final Class<? super T> rawType;
    private final Type type;

    public TypeToken() {
        Type superclassTypeParameter = getSuperclassTypeParameter(getClass());
        this.type = superclassTypeParameter;
        this.rawType = (Class<? super T>) GenericTypeReflector.getType(superclassTypeParameter);
    }

    public static TypeToken<?> get(Type type) {
        return new TypeToken<>(type);
    }

    public static Type getSuperclassTypeParameter(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return GenericTypeReflector.canonicalize(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type-parameter.");
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public static <T> TypeToken<T> get(Class<T> cls) {
        return new TypeToken<>(cls);
    }

    public TypeToken(Type type) {
        Type canonicalize = GenericTypeReflector.canonicalize(type);
        this.type = canonicalize;
        this.rawType = (Class<? super T>) GenericTypeReflector.getType(canonicalize);
    }
}
