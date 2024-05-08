package com.alibaba.security.common.json.serializer;

import com.alibaba.security.common.json.RPJSONException;
import com.alibaba.security.common.json.parser.DefaultJSONParser;
import com.alibaba.security.common.json.parser.JSONLexer;
import com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer;
import com.alibaba.security.common.json.util.RPTypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class IntegerCodec implements ObjectSerializer, ObjectDeserializer {
    public static IntegerCodec instance = new IntegerCodec();

    private IntegerCodec() {
    }

    @Override // com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t2;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i10 = jSONLexer.token();
        if (i10 == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        if (i10 == 2) {
            if (type != Long.TYPE && type != Long.class) {
                try {
                    t2 = (T) Integer.valueOf(jSONLexer.intValue());
                } catch (NumberFormatException e2) {
                    throw new RPJSONException("int value overflow, field : " + obj, e2);
                }
            } else {
                t2 = (T) Long.valueOf(jSONLexer.longValue());
            }
            jSONLexer.nextToken(16);
            return t2;
        }
        if (i10 == 3) {
            BigDecimal decimalValue = jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            if (type != Long.TYPE && type != Long.class) {
                return (T) Integer.valueOf(decimalValue.intValue());
            }
            return (T) Long.valueOf(decimalValue.longValue());
        }
        T t10 = (T) defaultJSONParser.parse();
        try {
            if (type != Long.TYPE && type != Long.class) {
                t10 = (T) RPTypeUtils.castToInt(t10);
                return t10;
            }
            t10 = (T) RPTypeUtils.castToLong(t10);
            return t10;
        } catch (Exception e10) {
            throw new RPJSONException("cast error, field : " + obj + ", value " + ((Object) t10), e10);
        }
    }

    @Override // com.alibaba.security.common.json.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Number number = (Number) obj;
        if (number == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
                serializeWriter.write(48);
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        if (obj instanceof Long) {
            serializeWriter.writeLong(number.longValue());
        } else {
            serializeWriter.writeInt(number.intValue());
        }
        if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
            Class<?> cls = number.getClass();
            if (cls == Byte.class) {
                serializeWriter.write(66);
                return;
            }
            if (cls != Short.class) {
                if (cls == Long.class) {
                    long longValue = number.longValue();
                    if (longValue > ZipUtils.UPPER_UNIXTIME_BOUND || longValue < -2147483648L || type == Long.class) {
                        return;
                    }
                    serializeWriter.write(76);
                    return;
                }
                return;
            }
            serializeWriter.write(83);
        }
    }
}
