package com.alibaba.security.common.json.parser.deserializer;

import com.alibaba.security.common.json.RPJSONException;
import com.alibaba.security.common.json.parser.DefaultJSONParser;
import com.alibaba.security.common.json.util.RPFieldInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class FieldDeserializer {
    public final Class<?> clazz;
    public long[] enumNameHashCodes;
    public Enum[] enums;
    public final RPFieldInfo fieldInfo;

    public FieldDeserializer(Class<?> cls, RPFieldInfo rPFieldInfo, int i10) {
        this.clazz = cls;
        this.fieldInfo = rPFieldInfo;
        if (rPFieldInfo == null) {
            return;
        }
        Class<?> cls2 = rPFieldInfo.fieldClass;
        if (cls2.isEnum()) {
            Enum[] enumArr = (Enum[]) cls2.getEnumConstants();
            int length = enumArr.length;
            long[] jArr = new long[length];
            this.enumNameHashCodes = new long[enumArr.length];
            for (int i11 = 0; i11 < enumArr.length; i11++) {
                long j10 = -3750763034362895579L;
                for (int i12 = 0; i12 < enumArr[i11].name().length(); i12++) {
                    j10 = (j10 ^ r2.charAt(i12)) * 1099511628211L;
                }
                jArr[i11] = j10;
                this.enumNameHashCodes[i11] = j10;
            }
            Arrays.sort(this.enumNameHashCodes);
            this.enums = new Enum[enumArr.length];
            for (int i13 = 0; i13 < this.enumNameHashCodes.length; i13++) {
                int i14 = 0;
                while (true) {
                    if (i14 >= length) {
                        break;
                    }
                    if (this.enumNameHashCodes[i13] == jArr[i14]) {
                        this.enums[i13] = enumArr[i14];
                        break;
                    }
                    i14++;
                }
            }
        }
    }

    public Enum getEnumByHashCode(long j10) {
        int binarySearch;
        if (this.enums == null || (binarySearch = Arrays.binarySearch(this.enumNameHashCodes, j10)) == -1) {
            return null;
        }
        return this.enums[binarySearch];
    }

    public abstract void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map);

    public void setValue(Object obj, int i10) throws IllegalAccessException {
        this.fieldInfo.field.setInt(obj, i10);
    }

    public void setValue(Object obj, long j10) throws IllegalAccessException {
        this.fieldInfo.field.setLong(obj, j10);
    }

    public void setValue(Object obj, float f10) throws IllegalAccessException {
        this.fieldInfo.field.setFloat(obj, f10);
    }

    public void setValue(Object obj, double d10) throws IllegalAccessException {
        this.fieldInfo.field.setDouble(obj, d10);
    }

    public void setValue(Object obj, Object obj2) {
        if (obj2 == null && this.fieldInfo.fieldClass.isPrimitive()) {
            return;
        }
        RPFieldInfo rPFieldInfo = this.fieldInfo;
        Field field = rPFieldInfo.field;
        Method method = rPFieldInfo.method;
        try {
            if (rPFieldInfo.fieldAccess) {
                if (rPFieldInfo.getOnly) {
                    if (Map.class.isAssignableFrom(rPFieldInfo.fieldClass)) {
                        Map map = (Map) field.get(obj);
                        if (map != null) {
                            map.putAll((Map) obj2);
                            return;
                        }
                        return;
                    }
                    Collection collection = (Collection) field.get(obj);
                    if (collection != null) {
                        collection.addAll((Collection) obj2);
                        return;
                    }
                    return;
                }
                field.set(obj, obj2);
                return;
            }
            if (rPFieldInfo.getOnly) {
                if (Map.class.isAssignableFrom(rPFieldInfo.fieldClass)) {
                    Map map2 = (Map) method.invoke(obj, new Object[0]);
                    if (map2 != null) {
                        map2.putAll((Map) obj2);
                        return;
                    }
                    return;
                }
                Collection collection2 = (Collection) method.invoke(obj, new Object[0]);
                if (collection2 != null) {
                    collection2.addAll((Collection) obj2);
                    return;
                }
                return;
            }
            method.invoke(obj, obj2);
        } catch (Exception e2) {
            throw new RPJSONException("set property error, " + this.fieldInfo.name, e2);
        }
    }
}
