package com.alibaba.security.common.json.serializer;

import com.alibaba.security.common.json.RPJSON;
import com.alibaba.security.common.json.RPJSONArray;
import com.alibaba.security.common.json.parser.DefaultJSONParser;
import com.alibaba.security.common.json.parser.JSONLexer;
import com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer;
import com.alibaba.security.common.json.util.RPTypeUtils;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.IdentityHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ArrayCodec implements ObjectSerializer, ObjectDeserializer {
    public static final ArrayCodec instance = new ArrayCodec();

    private ArrayCodec() {
    }

    private <T> T toObjectArray(DefaultJSONParser defaultJSONParser, Class<?> cls, RPJSONArray rPJSONArray) {
        if (rPJSONArray == null) {
            return null;
        }
        int size = rPJSONArray.size();
        T t2 = (T) Array.newInstance(cls, size);
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = rPJSONArray.get(i10);
            if (obj == rPJSONArray) {
                Array.set(t2, i10, t2);
            } else {
                if (cls.isArray()) {
                    if (!cls.isInstance(obj)) {
                        obj = toObjectArray(defaultJSONParser, cls, (RPJSONArray) obj);
                    }
                } else {
                    obj = RPTypeUtils.cast(obj, (Class<Object>) cls, defaultJSONParser.config);
                }
                Array.set(t2, i10, obj);
            }
        }
        rPJSONArray.setRelatedArray(t2);
        rPJSONArray.setComponentType(cls);
        return t2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i10 = jSONLexer.token();
        if (i10 == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        if (type != char[].class) {
            if (i10 == 4) {
                T t2 = (T) jSONLexer.bytesValue();
                jSONLexer.nextToken(16);
                return t2;
            }
            Class<?> componentType = ((Class) type).getComponentType();
            RPJSONArray rPJSONArray = new RPJSONArray();
            defaultJSONParser.parseArray(componentType, rPJSONArray, obj);
            return (T) toObjectArray(defaultJSONParser, componentType, rPJSONArray);
        }
        if (i10 == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            return (T) stringVal.toCharArray();
        }
        if (i10 == 2) {
            Number integerValue = jSONLexer.integerValue();
            jSONLexer.nextToken(16);
            return (T) integerValue.toString().toCharArray();
        }
        return (T) RPJSON.toJSONString(defaultJSONParser.parse()).toCharArray();
    }

    @Override // com.alibaba.security.common.json.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Object[] objArr = (Object[]) obj;
        if (obj == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) != 0) {
                serializeWriter.write("[]");
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        int length = objArr.length;
        int i10 = length - 1;
        if (i10 == -1) {
            serializeWriter.append((CharSequence) "[]");
            return;
        }
        SerialContext serialContext = jSONSerializer.context;
        int i11 = 0;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            serializeWriter.write(91);
            if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                jSONSerializer.incrementIndent();
                jSONSerializer.println();
                while (i11 < length) {
                    if (i11 != 0) {
                        serializeWriter.write(44);
                        jSONSerializer.println();
                    }
                    jSONSerializer.write(objArr[i11]);
                    i11++;
                }
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
                serializeWriter.write(93);
                return;
            }
            Class<?> cls = null;
            ObjectSerializer objectSerializer = null;
            while (i11 < i10) {
                Object obj3 = objArr[i11];
                if (obj3 == null) {
                    serializeWriter.append((CharSequence) "null,");
                } else {
                    IdentityHashMap<Object, SerialContext> identityHashMap = jSONSerializer.references;
                    if (identityHashMap != null && identityHashMap.containsKey(obj3)) {
                        jSONSerializer.writeReference(obj3);
                    } else {
                        Class<?> cls2 = obj3.getClass();
                        if (cls2 == cls) {
                            objectSerializer.write(jSONSerializer, obj3, null, null);
                        } else {
                            objectSerializer = jSONSerializer.config.get(cls2);
                            objectSerializer.write(jSONSerializer, obj3, null, null);
                            cls = cls2;
                        }
                    }
                    serializeWriter.write(44);
                }
                i11++;
            }
            Object obj4 = objArr[i10];
            if (obj4 == null) {
                serializeWriter.append((CharSequence) "null]");
            } else {
                IdentityHashMap<Object, SerialContext> identityHashMap2 = jSONSerializer.references;
                if (identityHashMap2 != null && identityHashMap2.containsKey(obj4)) {
                    jSONSerializer.writeReference(obj4);
                } else {
                    jSONSerializer.writeWithFieldName(obj4, Integer.valueOf(i10));
                }
                serializeWriter.write(93);
            }
        } finally {
            jSONSerializer.context = serialContext;
        }
    }
}
