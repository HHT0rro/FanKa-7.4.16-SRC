package com.alibaba.security.common.json.serializer;

import com.alibaba.security.common.json.parser.DefaultJSONParser;
import com.alibaba.security.common.json.parser.JSONLexer;
import com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer;
import com.alibaba.security.common.json.util.RPTypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class NumberCodec implements ObjectSerializer, ObjectDeserializer {
    public static final NumberCodec instance = new NumberCodec();
    private DecimalFormat decimalFormat;

    private NumberCodec() {
        this.decimalFormat = null;
    }

    /* JADX WARN: Type inference failed for: r8v16, types: [java.math.BigDecimal, T] */
    @Override // com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i10 = jSONLexer.token();
        if (i10 == 2) {
            if (type != Double.TYPE && type != Double.class) {
                if (type != Float.TYPE && type != Float.class) {
                    long longValue = jSONLexer.longValue();
                    jSONLexer.nextToken(16);
                    if (type != Short.TYPE && type != Short.class) {
                        if (type == Byte.TYPE || type == Byte.class) {
                            return (T) Byte.valueOf((byte) longValue);
                        }
                        if (longValue >= -2147483648L && longValue <= ZipUtils.UPPER_UNIXTIME_BOUND) {
                            return (T) Integer.valueOf((int) longValue);
                        }
                        return (T) Long.valueOf(longValue);
                    }
                    return (T) Short.valueOf((short) longValue);
                }
                String numberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Float.valueOf(Float.parseFloat(numberString));
            }
            String numberString2 = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return (T) Double.valueOf(Double.parseDouble(numberString2));
        }
        if (i10 == 3) {
            if (type != Double.TYPE && type != Double.class) {
                if (type != Float.TYPE && type != Float.class) {
                    ?? r82 = (T) jSONLexer.decimalValue();
                    jSONLexer.nextToken(16);
                    if (type == Short.TYPE || type == Short.class) {
                        return (T) Short.valueOf(r82.shortValue());
                    }
                    return (type == Byte.TYPE || type == Byte.class) ? (T) Byte.valueOf(r82.byteValue()) : r82;
                }
                String numberString3 = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Float.valueOf(Float.parseFloat(numberString3));
            }
            String numberString4 = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return (T) Double.valueOf(Double.parseDouble(numberString4));
        }
        Object parse = defaultJSONParser.parse();
        if (parse == null) {
            return null;
        }
        if (type != Double.TYPE && type != Double.class) {
            if (type != Float.TYPE && type != Float.class) {
                if (type != Short.TYPE && type != Short.class) {
                    if (type != Byte.TYPE && type != Byte.class) {
                        return (T) RPTypeUtils.castToBigDecimal(parse);
                    }
                    return (T) RPTypeUtils.castToByte(parse);
                }
                return (T) RPTypeUtils.castToShort(parse);
            }
            return (T) RPTypeUtils.castToFloat(parse);
        }
        return (T) RPTypeUtils.castToDouble(parse);
    }

    @Override // com.alibaba.security.common.json.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        String format;
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
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            if (Float.isNaN(floatValue)) {
                serializeWriter.writeNull();
                return;
            }
            if (Float.isInfinite(floatValue)) {
                serializeWriter.writeNull();
                return;
            }
            String f10 = Float.toString(floatValue);
            if (f10.endsWith(".0")) {
                f10 = f10.substring(0, f10.length() - 2);
            }
            serializeWriter.write(f10);
            if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
                serializeWriter.write(70);
                return;
            }
            return;
        }
        double doubleValue = ((Double) obj).doubleValue();
        if (Double.isNaN(doubleValue)) {
            serializeWriter.writeNull();
            return;
        }
        if (Double.isInfinite(doubleValue)) {
            serializeWriter.writeNull();
            return;
        }
        DecimalFormat decimalFormat = this.decimalFormat;
        if (decimalFormat == null) {
            format = Double.toString(doubleValue);
            if (format.endsWith(".0")) {
                format = format.substring(0, format.length() - 2);
            }
        } else {
            format = decimalFormat.format(doubleValue);
        }
        serializeWriter.append((CharSequence) format);
        if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
            serializeWriter.write(68);
        }
    }

    public NumberCodec(DecimalFormat decimalFormat) {
        this.decimalFormat = decimalFormat;
    }

    public NumberCodec(String str) {
        this(new DecimalFormat(str));
    }
}
