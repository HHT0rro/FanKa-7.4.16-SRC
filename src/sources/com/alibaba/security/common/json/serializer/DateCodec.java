package com.alibaba.security.common.json.serializer;

import com.alibaba.security.common.json.RPJSON;
import com.alibaba.security.common.json.RPJSONException;
import com.alibaba.security.common.json.parser.DefaultJSONParser;
import com.alibaba.security.common.json.parser.Feature;
import com.alibaba.security.common.json.parser.JSONLexer;
import com.alibaba.security.common.json.parser.JSONToken;
import com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer;
import com.alibaba.security.common.json.util.RPTypeUtils;
import com.android.internal.accessibility.common.ShortcutConstants;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class DateCodec implements ObjectSerializer, ObjectDeserializer {
    public static final DateCodec instance = new DateCodec();

    private DateCodec() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.util.Calendar, T] */
    public <T> T cast(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, String str) {
        DateFormat dateFormat;
        if (obj2 == 0) {
            return null;
        }
        if (obj2 instanceof Date) {
            return obj2;
        }
        if (obj2 instanceof Number) {
            return (T) new Date(((Number) obj2).longValue());
        }
        if (obj2 instanceof String) {
            String str2 = (String) obj2;
            if (str2.length() == 0) {
                return null;
            }
            JSONLexer jSONLexer = new JSONLexer(str2);
            try {
                if (jSONLexer.scanISO8601DateIfMatch(false)) {
                    ?? r32 = (T) jSONLexer.calendar;
                    return type == Calendar.class ? r32 : (T) r32.getTime();
                }
                jSONLexer.close();
                if ("0000-00-00".equals(str2) || "0000-00-00T00:00:00".equalsIgnoreCase(str2) || "0001-01-01T00:00:00+08:00".equalsIgnoreCase(str2)) {
                    return null;
                }
                if (str != null) {
                    dateFormat = new SimpleDateFormat(str);
                } else {
                    dateFormat = defaultJSONParser.getDateFormat();
                }
                try {
                    return (T) dateFormat.parse(str2);
                } catch (ParseException unused) {
                    return (T) new Date(Long.parseLong(str2));
                }
            } finally {
                jSONLexer.close();
            }
        }
        throw new RPJSONException("parse error");
    }

    @Override // com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null);
    }

    @Override // com.alibaba.security.common.json.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        Date date;
        char[] charArray;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0 && obj.getClass() != type) {
            if (obj.getClass() == Date.class) {
                serializeWriter.write("new Date(");
                serializeWriter.writeLong(((Date) obj).getTime());
                serializeWriter.write(41);
                return;
            }
            serializeWriter.write(123);
            serializeWriter.writeFieldName(RPJSON.DEFAULT_TYPE_KEY, false);
            jSONSerializer.write(obj.getClass().getName());
            serializeWriter.write(44);
            serializeWriter.writeFieldName("val", false);
            serializeWriter.writeLong(((Date) obj).getTime());
            serializeWriter.write(125);
            return;
        }
        if (obj instanceof Calendar) {
            date = ((Calendar) obj).getTime();
        } else {
            date = (Date) obj;
        }
        if ((serializeWriter.features & SerializerFeature.WriteDateUseDateFormat.mask) != 0) {
            DateFormat dateFormat = jSONSerializer.getDateFormat();
            if (dateFormat == null) {
                dateFormat = new SimpleDateFormat(RPJSON.DEFFAULT_DATE_FORMAT, jSONSerializer.locale);
                dateFormat.setTimeZone(jSONSerializer.timeZone);
            }
            serializeWriter.writeString(dateFormat.format(date));
            return;
        }
        long time = date.getTime();
        int i10 = serializeWriter.features;
        if ((SerializerFeature.UseISO8601DateFormat.mask & i10) != 0) {
            SerializerFeature serializerFeature = SerializerFeature.UseSingleQuotes;
            if ((i10 & serializerFeature.mask) != 0) {
                serializeWriter.write(39);
            } else {
                serializeWriter.write(34);
            }
            Calendar calendar = Calendar.getInstance(jSONSerializer.timeZone, jSONSerializer.locale);
            calendar.setTimeInMillis(time);
            int i11 = calendar.get(1);
            int i12 = calendar.get(2) + 1;
            int i13 = calendar.get(5);
            int i14 = calendar.get(11);
            int i15 = calendar.get(12);
            int i16 = calendar.get(13);
            int i17 = calendar.get(14);
            if (i17 != 0) {
                charArray = "0000-00-00T00:00:00.000".toCharArray();
                SerializeWriter.getChars(i17, 23, charArray);
                SerializeWriter.getChars(i16, 19, charArray);
                SerializeWriter.getChars(i15, 16, charArray);
                SerializeWriter.getChars(i14, 13, charArray);
                SerializeWriter.getChars(i13, 10, charArray);
                SerializeWriter.getChars(i12, 7, charArray);
                SerializeWriter.getChars(i11, 4, charArray);
            } else if (i16 == 0 && i15 == 0 && i14 == 0) {
                charArray = "0000-00-00".toCharArray();
                SerializeWriter.getChars(i13, 10, charArray);
                SerializeWriter.getChars(i12, 7, charArray);
                SerializeWriter.getChars(i11, 4, charArray);
            } else {
                charArray = "0000-00-00T00:00:00".toCharArray();
                SerializeWriter.getChars(i16, 19, charArray);
                SerializeWriter.getChars(i15, 16, charArray);
                SerializeWriter.getChars(i14, 13, charArray);
                SerializeWriter.getChars(i13, 10, charArray);
                SerializeWriter.getChars(i12, 7, charArray);
                SerializeWriter.getChars(i11, 4, charArray);
            }
            serializeWriter.write(charArray);
            if ((serializeWriter.features & serializerFeature.mask) != 0) {
                serializeWriter.write(39);
                return;
            } else {
                serializeWriter.write(34);
                return;
            }
        }
        serializeWriter.writeLong(time);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.util.Calendar, T] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.util.Calendar, T] */
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str) {
        Object obj2;
        T t2;
        Object obj3;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i10 = jSONLexer.token();
        if (i10 == 2) {
            Long valueOf = Long.valueOf(jSONLexer.longValue());
            jSONLexer.nextToken(16);
            obj3 = valueOf;
        } else if (i10 == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            obj3 = stringVal;
            if ((jSONLexer.features & Feature.AllowISO8601DateFormat.mask) != 0) {
                JSONLexer jSONLexer2 = new JSONLexer(stringVal);
                Object obj4 = stringVal;
                if (jSONLexer2.scanISO8601DateIfMatch(true)) {
                    ?? r12 = (T) jSONLexer2.calendar;
                    if (type == Calendar.class) {
                        jSONLexer2.close();
                        return r12;
                    }
                    obj4 = r12.getTime();
                }
                jSONLexer2.close();
                obj3 = obj4;
            }
        } else {
            if (i10 == 8) {
                jSONLexer.nextToken();
                obj2 = null;
                t2 = (T) cast(defaultJSONParser, type, obj, obj2, str);
                if (type != Calendar.class && !(t2 instanceof Calendar)) {
                    Date date = (Date) t2;
                    if (date == null) {
                        return null;
                    }
                    ?? r122 = (T) Calendar.getInstance(jSONLexer.timeZone, jSONLexer.locale);
                    r122.setTime(date);
                    return r122;
                }
            }
            if (i10 == 12) {
                jSONLexer.nextToken();
                if (jSONLexer.token() == 4) {
                    if (RPJSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal())) {
                        jSONLexer.nextToken();
                        defaultJSONParser.accept(17);
                        Class<?> loadClass = RPTypeUtils.loadClass(jSONLexer.stringVal(), defaultJSONParser.config.defaultClassLoader);
                        if (loadClass != null) {
                            type = loadClass;
                        }
                        defaultJSONParser.accept(4);
                        defaultJSONParser.accept(16);
                    }
                    jSONLexer.nextTokenWithChar(ShortcutConstants.SERVICES_SEPARATOR);
                    int i11 = jSONLexer.token();
                    if (i11 == 2) {
                        long longValue = jSONLexer.longValue();
                        jSONLexer.nextToken();
                        Long valueOf2 = Long.valueOf(longValue);
                        defaultJSONParser.accept(13);
                        obj3 = valueOf2;
                    } else {
                        throw new RPJSONException("syntax error : " + JSONToken.name(i11));
                    }
                } else {
                    throw new RPJSONException("syntax error");
                }
            } else if (defaultJSONParser.resolveStatus == 2) {
                defaultJSONParser.resolveStatus = 0;
                defaultJSONParser.accept(16);
                if (jSONLexer.token() == 4) {
                    if ("val".equals(jSONLexer.stringVal())) {
                        jSONLexer.nextToken();
                        defaultJSONParser.accept(17);
                        Object parse = defaultJSONParser.parse();
                        defaultJSONParser.accept(13);
                        obj3 = parse;
                    } else {
                        throw new RPJSONException("syntax error");
                    }
                } else {
                    throw new RPJSONException("syntax error");
                }
            } else {
                obj3 = defaultJSONParser.parse();
            }
        }
        obj2 = obj3;
        t2 = (T) cast(defaultJSONParser, type, obj, obj2, str);
        return type != Calendar.class ? t2 : t2;
    }
}
