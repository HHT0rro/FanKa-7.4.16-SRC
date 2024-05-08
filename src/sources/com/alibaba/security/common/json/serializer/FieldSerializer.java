package com.alibaba.security.common.json.serializer;

import com.alibaba.security.common.json.RPJSONException;
import com.alibaba.security.common.json.annotation.RPJSONField;
import com.alibaba.security.common.json.util.RPFieldInfo;
import com.android.internal.accessibility.common.ShortcutConstants;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Collection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class FieldSerializer implements Comparable<FieldSerializer> {
    public final int features;
    public final RPFieldInfo fieldInfo;
    public final String format;
    public char[] name_chars;
    private RuntimeSerializerInfo runtimeInfo;
    public final boolean writeNull;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class RuntimeSerializerInfo {
        public ObjectSerializer fieldSerializer;
        public Class<?> runtimeFieldClass;

        public RuntimeSerializerInfo(ObjectSerializer objectSerializer, Class<?> cls) {
            this.fieldSerializer = objectSerializer;
            this.runtimeFieldClass = cls;
        }
    }

    public FieldSerializer(RPFieldInfo rPFieldInfo) {
        boolean z10;
        this.fieldInfo = rPFieldInfo;
        RPJSONField annotation = rPFieldInfo.getAnnotation();
        if (annotation != null) {
            z10 = false;
            for (SerializerFeature serializerFeature : annotation.serialzeFeatures()) {
                if (serializerFeature == SerializerFeature.WriteMapNullValue) {
                    z10 = true;
                }
            }
            String trim = annotation.format().trim();
            r1 = trim.length() != 0 ? trim : null;
            this.features = SerializerFeature.of(annotation.serialzeFeatures());
        } else {
            this.features = 0;
            z10 = false;
        }
        this.writeNull = z10;
        this.format = r1;
        String str = rPFieldInfo.name;
        int length = str.length();
        this.name_chars = new char[length + 3];
        str.getChars(0, str.length(), this.name_chars, 1);
        char[] cArr = this.name_chars;
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = ShortcutConstants.SERVICES_SEPARATOR;
    }

    public Object getPropertyValue(Object obj) throws Exception {
        try {
            return this.fieldInfo.get(obj);
        } catch (Exception e2) {
            RPFieldInfo rPFieldInfo = this.fieldInfo;
            Member member = rPFieldInfo.method;
            if (member == null) {
                member = rPFieldInfo.field;
            }
            throw new RPJSONException("get property error。 " + (member.getDeclaringClass().getName() + "." + member.getName()), e2);
        }
    }

    public void writePrefix(JSONSerializer jSONSerializer) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        int i10 = serializeWriter.features;
        if ((SerializerFeature.QuoteFieldNames.mask & i10) != 0) {
            if ((i10 & SerializerFeature.UseSingleQuotes.mask) != 0) {
                serializeWriter.writeFieldName(this.fieldInfo.name, true);
                return;
            } else {
                char[] cArr = this.name_chars;
                serializeWriter.write(cArr, 0, cArr.length);
                return;
            }
        }
        serializeWriter.writeFieldName(this.fieldInfo.name, true);
    }

    public void writeValue(JSONSerializer jSONSerializer, Object obj) throws Exception {
        Class<?> cls;
        String str = this.format;
        if (str != null) {
            jSONSerializer.writeWithFormat(obj, str);
            return;
        }
        if (this.runtimeInfo == null) {
            if (obj == null) {
                cls = this.fieldInfo.fieldClass;
            } else {
                cls = obj.getClass();
            }
            this.runtimeInfo = new RuntimeSerializerInfo(jSONSerializer.config.get(cls), cls);
        }
        RuntimeSerializerInfo runtimeSerializerInfo = this.runtimeInfo;
        if (obj == null) {
            if ((this.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0 && Number.class.isAssignableFrom(runtimeSerializerInfo.runtimeFieldClass)) {
                jSONSerializer.out.write(48);
                return;
            }
            int i10 = this.features;
            if ((SerializerFeature.WriteNullBooleanAsFalse.mask & i10) != 0 && Boolean.class == runtimeSerializerInfo.runtimeFieldClass) {
                jSONSerializer.out.write("false");
                return;
            } else if ((i10 & SerializerFeature.WriteNullListAsEmpty.mask) != 0 && Collection.class.isAssignableFrom(runtimeSerializerInfo.runtimeFieldClass)) {
                jSONSerializer.out.write("[]");
                return;
            } else {
                runtimeSerializerInfo.fieldSerializer.write(jSONSerializer, null, this.fieldInfo.name, runtimeSerializerInfo.runtimeFieldClass);
                return;
            }
        }
        Class<?> cls2 = obj.getClass();
        if (cls2 == runtimeSerializerInfo.runtimeFieldClass) {
            ObjectSerializer objectSerializer = runtimeSerializerInfo.fieldSerializer;
            RPFieldInfo rPFieldInfo = this.fieldInfo;
            objectSerializer.write(jSONSerializer, obj, rPFieldInfo.name, rPFieldInfo.fieldType);
        } else {
            ObjectSerializer objectSerializer2 = jSONSerializer.config.get(cls2);
            RPFieldInfo rPFieldInfo2 = this.fieldInfo;
            objectSerializer2.write(jSONSerializer, obj, rPFieldInfo2.name, rPFieldInfo2.fieldType);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(FieldSerializer fieldSerializer) {
        return this.fieldInfo.compareTo(fieldSerializer.fieldInfo);
    }
}
