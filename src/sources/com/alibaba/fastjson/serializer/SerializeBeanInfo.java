package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SerializeBeanInfo {
    public final Class<?> beanType;
    public int features;
    public final FieldInfo[] fields;
    public final JSONType jsonType;
    public final FieldInfo[] sortedFields;
    public final String typeKey;
    public final String typeName;

    public SerializeBeanInfo(Class<?> cls, JSONType jSONType, String str, String str2, int i10, FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2) {
        this.beanType = cls;
        this.jsonType = jSONType;
        this.typeName = str;
        this.typeKey = str2;
        this.features = i10;
        this.fields = fieldInfoArr;
        this.sortedFields = fieldInfoArr2;
    }
}
