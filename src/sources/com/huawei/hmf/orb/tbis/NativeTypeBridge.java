package com.huawei.hmf.orb.tbis;

import com.huawei.hmf.orb.tbis.TBNativeType;
import com.huawei.hmf.services.internal.GenericTypeReflector;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class NativeTypeBridge {
    private static Map<Type, TypeAdapter> typeAdapterMap = new HashMap();
    private boolean mIsLinked;
    private Type[] mOriginalTypes;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class TypeAdapter {
        private final TBNativeType.Factory factory;
        private final Type type;

        public TypeAdapter(Type type, TBNativeType.Factory factory) {
            this.type = type;
            this.factory = factory;
        }
    }

    public NativeTypeBridge(Type[] typeArr) {
        this.mOriginalTypes = (Type[]) typeArr.clone();
        for (int i10 = 0; i10 < typeArr.length; i10++) {
            TypeAdapter typeAdapter = typeAdapterMap.get(typeArr[i10]);
            if (typeAdapter != null) {
                typeArr[i10] = typeAdapter.type;
                this.mIsLinked = true;
            }
        }
    }

    private static Type getBoxedType(TBNativeType.Factory factory) {
        Type type = factory.getClass().getGenericInterfaces()[0];
        if (type == null || !(type instanceof ParameterizedType)) {
            return String.class;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length < 2) {
            return String.class;
        }
        return GenericTypeReflector.getType(actualTypeArguments[1]);
    }

    public static void registry(Type type, TBNativeType.Factory factory) {
        Type boxedType;
        if (factory instanceof TBNativeType.UnboxFactory) {
            boxedType = ((TBNativeType.UnboxFactory) factory).getType();
        } else {
            boxedType = getBoxedType(factory);
        }
        registry(type, boxedType, factory);
    }

    public Object[] process(Object[] objArr) {
        TypeAdapter typeAdapter;
        if (this.mIsLinked) {
            for (int i10 = 0; i10 < objArr.length; i10++) {
                if (objArr[i10] != null && (typeAdapter = typeAdapterMap.get(this.mOriginalTypes[i10])) != null && typeAdapter.factory != null) {
                    objArr[i10] = typeAdapter.factory.create(objArr[i10]);
                }
            }
        }
        return objArr;
    }

    private static void registry(Type type, Type type2, TBNativeType.Factory factory) {
        typeAdapterMap.put(type, new TypeAdapter(type2, factory));
    }
}
