package com.alibaba.security.common.json.serializer;

import com.alibaba.security.common.json.RPJSON;
import com.alibaba.security.common.json.RPJSONAware;
import com.alibaba.security.common.json.RPJSONException;
import com.alibaba.security.common.json.RPJSONObject;
import com.alibaba.security.common.json.RPJSONStreamAware;
import com.alibaba.security.common.json.parser.DefaultJSONParser;
import com.alibaba.security.common.json.parser.JSONLexer;
import com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer;
import com.alibaba.security.common.json.util.RPTypeUtils;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class MiscCodec implements ObjectSerializer, ObjectDeserializer {
    public static final MiscCodec instance = new MiscCodec();

    private MiscCodec() {
    }

    /* JADX WARN: Type inference failed for: r8v7, types: [T, java.text.SimpleDateFormat] */
    @Override // com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object parse;
        if (type == StackTraceElement.class) {
            return (T) parseStackTraceElement(defaultJSONParser);
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (defaultJSONParser.resolveStatus == 2) {
            defaultJSONParser.resolveStatus = 0;
            defaultJSONParser.accept(16);
            if (jSONLexer.token() == 4) {
                if ("val".equals(jSONLexer.stringVal())) {
                    jSONLexer.nextToken();
                    defaultJSONParser.accept(17);
                    parse = defaultJSONParser.parse();
                    defaultJSONParser.accept(13);
                } else {
                    throw new RPJSONException("syntax error");
                }
            } else {
                throw new RPJSONException("syntax error");
            }
        } else {
            parse = defaultJSONParser.parse();
        }
        if (parse == null) {
            return null;
        }
        if (parse instanceof String) {
            String str = (String) parse;
            if (str.length() == 0) {
                return null;
            }
            if (type == UUID.class) {
                return (T) UUID.fromString(str);
            }
            if (type == Class.class) {
                return (T) RPTypeUtils.loadClass(str, defaultJSONParser.config.defaultClassLoader);
            }
            if (type == Locale.class) {
                String[] split = str.split("_");
                if (split.length == 1) {
                    return (T) new Locale(split[0]);
                }
                if (split.length == 2) {
                    return (T) new Locale(split[0], split[1]);
                }
                return (T) new Locale(split[0], split[1], split[2]);
            }
            if (type == URI.class) {
                return (T) URI.create(str);
            }
            if (type == URL.class) {
                try {
                    return (T) new URL(str);
                } catch (MalformedURLException e2) {
                    throw new RPJSONException("create url error", e2);
                }
            }
            if (type == Pattern.class) {
                return (T) Pattern.compile(str);
            }
            if (type == Charset.class) {
                return (T) Charset.forName(str);
            }
            if (type == Currency.class) {
                return (T) Currency.getInstance(str);
            }
            if (type == SimpleDateFormat.class) {
                ?? r82 = (T) new SimpleDateFormat(str, defaultJSONParser.lexer.locale);
                r82.setTimeZone(defaultJSONParser.lexer.timeZone);
                return r82;
            }
            if (type != Character.TYPE && type != Character.class) {
                if ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName())) {
                    try {
                        return (T) Class.forName("android.net.Uri").getMethod("parse", String.class).invoke(null, str);
                    } catch (Exception e10) {
                        throw new RPJSONException("parse android.net.Uri error.", e10);
                    }
                }
                return (T) TimeZone.getTimeZone(str);
            }
            return (T) RPTypeUtils.castToChar(str);
        }
        if (parse instanceof RPJSONObject) {
            RPJSONObject rPJSONObject = (RPJSONObject) parse;
            if (type == Currency.class) {
                String string = rPJSONObject.getString("currency");
                if (string != null) {
                    return (T) Currency.getInstance(string);
                }
                String string2 = rPJSONObject.getString("currencyCode");
                if (string2 != null) {
                    return (T) Currency.getInstance(string2);
                }
            }
            if (type == Map.Entry.class) {
                return (T) rPJSONObject.entrySet().iterator2().next();
            }
        }
        throw new RPJSONException("except string value");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0166, code lost:
    
        return (T) new java.lang.StackTraceElement(r5, r7, r8, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T parseStackTraceElement(com.alibaba.security.common.json.parser.DefaultJSONParser r17) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.serializer.MiscCodec.parseStackTraceElement(com.alibaba.security.common.json.parser.DefaultJSONParser):java.lang.Object");
    }

    @Override // com.alibaba.security.common.json.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if (type != Character.TYPE && type != Character.class) {
                if ((serializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) != 0 && Enumeration.class.isAssignableFrom(RPTypeUtils.getClass(type))) {
                    serializeWriter.write("[]");
                    return;
                } else {
                    serializeWriter.writeNull();
                    return;
                }
            }
            jSONSerializer.write("");
            return;
        }
        if (obj instanceof Pattern) {
            jSONSerializer.write(((Pattern) obj).pattern());
            return;
        }
        if (obj instanceof TimeZone) {
            jSONSerializer.write(((TimeZone) obj).getID());
            return;
        }
        if (obj instanceof Currency) {
            jSONSerializer.write(((Currency) obj).getCurrencyCode());
            return;
        }
        if (obj instanceof Class) {
            jSONSerializer.write(((Class) obj).getName());
            return;
        }
        if (obj instanceof Character) {
            Character ch = (Character) obj;
            if (ch.charValue() == 0) {
                jSONSerializer.write("\u0000");
                return;
            } else {
                jSONSerializer.write(ch.toString());
                return;
            }
        }
        int i10 = 0;
        if (obj instanceof SimpleDateFormat) {
            String pattern = ((SimpleDateFormat) obj).toPattern();
            if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0 && obj.getClass() != type) {
                serializeWriter.write(123);
                serializeWriter.writeFieldName(RPJSON.DEFAULT_TYPE_KEY, false);
                jSONSerializer.write(obj.getClass().getName());
                serializeWriter.write(44);
                serializeWriter.writeFieldName("val", false);
                serializeWriter.writeString(pattern);
                serializeWriter.write(125);
                return;
            }
            serializeWriter.writeString(pattern);
            return;
        }
        if (obj instanceof RPJSONStreamAware) {
            ((RPJSONStreamAware) obj).writeJSONString(serializeWriter);
            return;
        }
        if (obj instanceof RPJSONAware) {
            serializeWriter.write(((RPJSONAware) obj).toJSONString());
            return;
        }
        if (obj instanceof JSONSerializable) {
            ((JSONSerializable) obj).write(jSONSerializer, obj2, type);
            return;
        }
        if (obj instanceof Enumeration) {
            Type type2 = null;
            if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0 && (type instanceof ParameterizedType)) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            }
            Enumeration enumeration = (Enumeration) obj;
            SerialContext serialContext = jSONSerializer.context;
            jSONSerializer.setContext(serialContext, obj, obj2, 0);
            try {
                serializeWriter.write(91);
                while (enumeration.hasMoreElements()) {
                    Object nextElement = enumeration.nextElement();
                    int i11 = i10 + 1;
                    if (i10 != 0) {
                        serializeWriter.write(44);
                    }
                    if (nextElement == null) {
                        serializeWriter.writeNull();
                    } else {
                        jSONSerializer.config.get(nextElement.getClass()).write(jSONSerializer, nextElement, Integer.valueOf(i11 - 1), type2);
                    }
                    i10 = i11;
                }
                serializeWriter.write(93);
                return;
            } finally {
                jSONSerializer.context = serialContext;
            }
        }
        jSONSerializer.write(obj.toString());
    }
}
