package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class BigDecimalCodec implements ObjectSerializer, ObjectDeserializer {
    public static final BigDecimal LOW = BigDecimal.valueOf(-9007199254740991L);
    public static final BigDecimal HIGH = BigDecimal.valueOf(9007199254740991L);
    public static final BigDecimalCodec instance = new BigDecimalCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            return (T) deserialze(defaultJSONParser);
        } catch (Exception e2) {
            throw new JSONException("parseDecimal error, field : " + obj, e2);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i10) throws IOException {
        String bigDecimal;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        BigDecimal bigDecimal2 = (BigDecimal) obj;
        int scale = bigDecimal2.scale();
        if (SerializerFeature.isEnabled(i10, serializeWriter.features, SerializerFeature.WriteBigDecimalAsPlain) && scale >= -100 && scale < 100) {
            bigDecimal = bigDecimal2.toPlainString();
        } else {
            bigDecimal = bigDecimal2.toString();
        }
        if (scale == 0 && bigDecimal.length() >= 16 && SerializerFeature.isEnabled(i10, serializeWriter.features, SerializerFeature.BrowserCompatible) && (bigDecimal2.compareTo(LOW) < 0 || bigDecimal2.compareTo(HIGH) > 0)) {
            serializeWriter.writeString(bigDecimal);
            return;
        }
        serializeWriter.write(bigDecimal);
        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName) && type != BigDecimal.class && bigDecimal2.scale() == 0) {
            serializeWriter.write(46);
        }
    }

    public static <T> T deserialze(DefaultJSONParser defaultJSONParser) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 2) {
            T t2 = (T) jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            return t2;
        }
        if (jSONLexer.token() == 3) {
            T t10 = (T) jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            return t10;
        }
        Object parse = defaultJSONParser.parse();
        if (parse == null) {
            return null;
        }
        return (T) TypeUtils.castToBigDecimal(parse);
    }
}
