package com.alibaba.security.common.json.util;

import com.alibaba.security.common.json.RPJSONAware;
import com.alibaba.security.common.json.annotation.RPJSONField;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPFieldInfo implements Comparable<RPFieldInfo> {
    public final String[] alternateNames;
    public final Class<?> declaringClass;
    public final Field field;
    public final boolean fieldAccess;
    private final RPJSONField fieldAnnotation;
    public final Class<?> fieldClass;
    public final boolean fieldTransient;
    public final Type fieldType;
    public final String format;
    public final boolean getOnly;
    public final boolean isEnum;
    public final Method method;
    private final RPJSONField methodAnnotation;
    public final String name;
    public final long nameHashCode;
    private int ordinal;

    public RPFieldInfo(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i10, int i11) {
        this.name = str;
        this.declaringClass = cls;
        this.fieldClass = cls2;
        this.fieldType = type;
        this.method = null;
        this.field = field;
        this.ordinal = i10;
        this.isEnum = cls2.isEnum() && !RPJSONAware.class.isAssignableFrom(cls2);
        this.fieldAnnotation = null;
        this.methodAnnotation = null;
        if (field != null) {
            int modifiers = field.getModifiers();
            int i12 = modifiers & 1;
            this.fieldAccess = true;
            this.fieldTransient = Modifier.isTransient(modifiers);
        } else {
            this.fieldAccess = false;
            this.fieldTransient = false;
        }
        this.getOnly = false;
        long j10 = -3750763034362895579L;
        for (int i13 = 0; i13 < str.length(); i13++) {
            j10 = (j10 ^ str.charAt(i13)) * 1099511628211L;
        }
        this.nameHashCode = j10;
        this.format = null;
        this.alternateNames = new String[0];
    }

    public static Type getFieldType(Class<?> cls, Type type, Type type2) {
        TypeVariable<Class<? super Object>>[] typeVariableArr;
        ParameterizedType parameterizedType;
        if (cls != null && type != null) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type fieldType = getFieldType(cls, type, genericComponentType);
                return genericComponentType != fieldType ? Array.newInstance(RPTypeUtils.getClass(fieldType), 0).getClass() : type2;
            }
            if (!RPTypeUtils.isGenericParamType(type)) {
                return type2;
            }
            if (type2 instanceof TypeVariable) {
                ParameterizedType parameterizedType2 = (ParameterizedType) RPTypeUtils.getGenericParamType(type);
                Class<?> cls2 = RPTypeUtils.getClass(parameterizedType2);
                TypeVariable typeVariable = (TypeVariable) type2;
                for (int i10 = 0; i10 < cls2.getTypeParameters().length; i10++) {
                    if (cls2.getTypeParameters()[i10].getName().equals(typeVariable.getName())) {
                        return parameterizedType2.getActualTypeArguments()[i10];
                    }
                }
            }
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                Type[] typeArr = null;
                if (type instanceof ParameterizedType) {
                    parameterizedType = (ParameterizedType) type;
                    typeVariableArr = cls.getTypeParameters();
                } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                    parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                    typeVariableArr = cls.getSuperclass().getTypeParameters();
                } else {
                    typeVariableArr = null;
                    parameterizedType = null;
                }
                boolean z10 = false;
                for (int i11 = 0; i11 < actualTypeArguments.length && parameterizedType != null; i11++) {
                    Type type3 = actualTypeArguments[i11];
                    if (type3 instanceof TypeVariable) {
                        TypeVariable typeVariable2 = (TypeVariable) type3;
                        for (int i12 = 0; i12 < typeVariableArr.length; i12++) {
                            if (typeVariableArr[i12].getName().equals(typeVariable2.getName())) {
                                if (typeArr == null) {
                                    typeArr = parameterizedType.getActualTypeArguments();
                                }
                                actualTypeArguments[i11] = typeArr[i12];
                                z10 = true;
                            }
                        }
                    }
                }
                if (z10) {
                    return new ParameterizedTypeImpl(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType());
                }
            }
        }
        return type2;
    }

    public boolean equals(RPFieldInfo rPFieldInfo) {
        return rPFieldInfo == this || compareTo(rPFieldInfo) == 0;
    }

    public Object get(Object obj) throws IllegalAccessException, InvocationTargetException {
        if (this.fieldAccess) {
            return this.field.get(obj);
        }
        return this.method.invoke(obj, new Object[0]);
    }

    public RPJSONField getAnnotation() {
        RPJSONField rPJSONField = this.fieldAnnotation;
        return rPJSONField != null ? rPJSONField : this.methodAnnotation;
    }

    public void set(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Method method = this.method;
        if (method != null) {
            method.invoke(obj, obj2);
        } else {
            this.field.set(obj, obj2);
        }
    }

    public String toString() {
        return this.name;
    }

    @Override // java.lang.Comparable
    public int compareTo(RPFieldInfo rPFieldInfo) {
        int i10 = this.ordinal;
        int i11 = rPFieldInfo.ordinal;
        if (i10 < i11) {
            return -1;
        }
        if (i10 > i11) {
            return 1;
        }
        return this.name.compareTo(rPFieldInfo.name);
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0140, code lost:
    
        r7 = r16.declaringClass.getTypeParameters();
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0148, code lost:
    
        if (r11 >= r7.length) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0150, code lost:
    
        if (r2.equals(r7[r11]) == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0155, code lost:
    
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0152, code lost:
    
        r2 = r8[r11];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public RPFieldInfo(java.lang.String r17, java.lang.reflect.Method r18, java.lang.reflect.Field r19, java.lang.Class<?> r20, java.lang.reflect.Type r21, int r22, int r23, com.alibaba.security.common.json.annotation.RPJSONField r24, com.alibaba.security.common.json.annotation.RPJSONField r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.util.RPFieldInfo.<init>(java.lang.String, java.lang.reflect.Method, java.lang.reflect.Field, java.lang.Class, java.lang.reflect.Type, int, int, com.alibaba.security.common.json.annotation.RPJSONField, com.alibaba.security.common.json.annotation.RPJSONField, boolean):void");
    }
}
