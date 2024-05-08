package com.alibaba.security.common.json.serializer;

import com.alibaba.security.common.json.parser.DefaultJSONParser;
import com.alibaba.security.common.json.parser.JSONLexer;
import com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer;
import com.alibaba.security.common.json.util.RPTypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BigDecimalCodec implements ObjectSerializer, ObjectDeserializer {
    public static final BigDecimalCodec instance = new BigDecimalCodec();

    private BigDecimalCodec() {
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [java.math.BigDecimal, T] */
    @Override // com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i10 = jSONLexer.token();
        if (i10 == 2) {
            if (type == BigInteger.class) {
                String numberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) new BigInteger(numberString, 10);
            }
            T t2 = (T) jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            return t2;
        }
        if (i10 == 3) {
            ?? r42 = (T) jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            return type == BigInteger.class ? (T) r42.toBigInteger() : r42;
        }
        Object parse = defaultJSONParser.parse();
        if (parse == null) {
            return null;
        }
        if (type == BigInteger.class) {
            return (T) RPTypeUtils.castToBigInteger(parse);
        }
        return (T) RPTypeUtils.castToBigDecimal(parse);
    }

    @Override // com.alibaba.security.common.json.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
                serializeWriter.write(48);
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        if (obj instanceof BigInteger) {
            serializeWriter.write(((BigInteger) obj).toString());
            return;
        }
        BigDecimal bigDecimal = (BigDecimal) obj;
        serializeWriter.write(bigDecimal.toString());
        if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) == 0 || type == BigDecimal.class || bigDecimal.scale() != 0) {
            return;
        }
        serializeWriter.write(46);
    }
}
