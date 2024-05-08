package com.alibaba.security.common.json.parser;

import com.alibaba.security.common.json.parser.deserializer.FieldDeserializer;
import com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer;
import com.alibaba.security.common.json.util.RPFieldInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DefaultFieldDeserializer extends FieldDeserializer {
    public ObjectDeserializer fieldValueDeserilizer;

    public DefaultFieldDeserializer(ParserConfig parserConfig, Class<?> cls, RPFieldInfo rPFieldInfo) {
        super(cls, rPFieldInfo, 2);
    }

    public ObjectDeserializer getFieldValueDeserilizer(ParserConfig parserConfig) {
        if (this.fieldValueDeserilizer == null) {
            RPFieldInfo rPFieldInfo = this.fieldInfo;
            this.fieldValueDeserilizer = parserConfig.getDeserializer(rPFieldInfo.fieldClass, rPFieldInfo.fieldType);
        }
        return this.fieldValueDeserilizer;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
    @Override // com.alibaba.security.common.json.parser.deserializer.FieldDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void parseField(com.alibaba.security.common.json.parser.DefaultJSONParser r6, java.lang.Object r7, java.lang.reflect.Type r8, java.util.Map<java.lang.String, java.lang.Object> r9) {
        /*
            r5 = this;
            com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer r0 = r5.fieldValueDeserilizer
            if (r0 != 0) goto L12
            com.alibaba.security.common.json.parser.ParserConfig r0 = r6.config
            com.alibaba.security.common.json.util.RPFieldInfo r1 = r5.fieldInfo
            java.lang.Class<?> r2 = r1.fieldClass
            java.lang.reflect.Type r1 = r1.fieldType
            com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer r0 = r0.getDeserializer(r2, r1)
            r5.fieldValueDeserilizer = r0
        L12:
            com.alibaba.security.common.json.util.RPFieldInfo r0 = r5.fieldInfo
            java.lang.reflect.Type r0 = r0.fieldType
            boolean r1 = r8 instanceof java.lang.reflect.ParameterizedType
            if (r1 == 0) goto L2e
            com.alibaba.security.common.json.parser.ParseContext r2 = r6.contex
            if (r2 == 0) goto L20
            r2.type = r8
        L20:
            java.lang.Class<?> r2 = r5.clazz
            java.lang.reflect.Type r0 = com.alibaba.security.common.json.util.RPFieldInfo.getFieldType(r2, r8, r0)
            com.alibaba.security.common.json.parser.ParserConfig r2 = r6.config
            com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer r2 = r2.getDeserializer(r0)
            r5.fieldValueDeserilizer = r2
        L2e:
            boolean r2 = r0 instanceof java.lang.reflect.ParameterizedType
            if (r2 == 0) goto L62
            if (r1 == 0) goto L62
            r1 = r0
            java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1
            java.lang.reflect.ParameterizedType r8 = (java.lang.reflect.ParameterizedType) r8
            java.lang.reflect.Type[] r2 = r1.getActualTypeArguments()
            java.lang.reflect.Type r3 = r8.getRawType()
            boolean r4 = r3 instanceof java.lang.Class
            if (r4 == 0) goto L62
            java.lang.Class r3 = (java.lang.Class) r3
            java.lang.reflect.TypeVariable[] r3 = r3.getTypeParameters()
            java.lang.reflect.Type[] r8 = r8.getActualTypeArguments()
            boolean r8 = com.alibaba.security.common.json.util.RPTypeUtils.getArgument(r2, r3, r8)
            if (r8 == 0) goto L62
            com.alibaba.security.common.json.util.ParameterizedTypeImpl r0 = new com.alibaba.security.common.json.util.ParameterizedTypeImpl
            java.lang.reflect.Type r8 = r1.getOwnerType()
            java.lang.reflect.Type r1 = r1.getRawType()
            r0.<init>(r2, r8, r1)
        L62:
            com.alibaba.security.common.json.util.RPFieldInfo r8 = r5.fieldInfo
            java.lang.String r1 = r8.format
            if (r1 == 0) goto L77
            com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer r2 = r5.fieldValueDeserilizer
            boolean r3 = r2 instanceof com.alibaba.security.common.json.serializer.DateCodec
            if (r3 == 0) goto L77
            com.alibaba.security.common.json.serializer.DateCodec r2 = (com.alibaba.security.common.json.serializer.DateCodec) r2
            java.lang.String r8 = r8.name
            java.lang.Object r8 = r2.deserialze(r6, r0, r8, r1)
            goto L7f
        L77:
            com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer r1 = r5.fieldValueDeserilizer
            java.lang.String r8 = r8.name
            java.lang.Object r8 = r1.deserialze(r6, r0, r8)
        L7f:
            int r0 = r6.resolveStatus
            r1 = 1
            if (r0 != r1) goto L92
            com.alibaba.security.common.json.parser.DefaultJSONParser$ResolveTask r7 = r6.getLastResolveTask()
            r7.fieldDeserializer = r5
            com.alibaba.security.common.json.parser.ParseContext r8 = r6.contex
            r7.ownerContext = r8
            r7 = 0
            r6.resolveStatus = r7
            goto Lb6
        L92:
            if (r7 != 0) goto L9c
            com.alibaba.security.common.json.util.RPFieldInfo r6 = r5.fieldInfo
            java.lang.String r6 = r6.name
            r9.put(r6, r8)
            goto Lb6
        L9c:
            if (r8 != 0) goto Lb3
            com.alibaba.security.common.json.util.RPFieldInfo r6 = r5.fieldInfo
            java.lang.Class<?> r6 = r6.fieldClass
            java.lang.Class<java.lang.Byte> r9 = java.lang.Byte.TYPE
            if (r6 == r9) goto Lb2
            java.lang.Class<java.lang.Short> r9 = java.lang.Short.TYPE
            if (r6 == r9) goto Lb2
            java.lang.Class<java.lang.Float> r9 = java.lang.Float.TYPE
            if (r6 == r9) goto Lb2
            java.lang.Class<java.lang.Double> r9 = java.lang.Double.TYPE
            if (r6 != r9) goto Lb3
        Lb2:
            return
        Lb3:
            r5.setValue(r7, r8)
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.parser.DefaultFieldDeserializer.parseField(com.alibaba.security.common.json.parser.DefaultJSONParser, java.lang.Object, java.lang.reflect.Type, java.util.Map):void");
    }
}
