package com.alibaba.fastjson.parser.deserializer;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class AbstractDateDeserializer extends ContextObjectDeserializer {
    public abstract <T> T cast(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2);

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null, 0);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i10) {
        SimpleDateFormat simpleDateFormat;
        Date date;
        SimpleDateFormat simpleDateFormat2;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        Object obj2 = null;
        if (jSONLexer.token() == 2) {
            long longValue = jSONLexer.longValue();
            jSONLexer.nextToken(16);
            if ("unixtime".equals(str)) {
                longValue *= 1000;
            }
            obj2 = Long.valueOf(longValue);
        } else if (jSONLexer.token() == 4) {
            String stringVal = jSONLexer.stringVal();
            if (str != null) {
                try {
                    simpleDateFormat = new SimpleDateFormat(str, defaultJSONParser.lexer.getLocale());
                } catch (IllegalArgumentException e2) {
                    if (str.contains(ExifInterface.GPS_DIRECTION_TRUE)) {
                        try {
                            simpleDateFormat = new SimpleDateFormat(str.replaceAll(ExifInterface.GPS_DIRECTION_TRUE, "'T'"), defaultJSONParser.lexer.getLocale());
                        } catch (IllegalArgumentException unused) {
                            throw e2;
                        }
                    } else {
                        simpleDateFormat = null;
                    }
                }
                if (JSON.defaultTimeZone != null) {
                    simpleDateFormat.setTimeZone(defaultJSONParser.lexer.getTimeZone());
                }
                try {
                    date = simpleDateFormat.parse(stringVal);
                } catch (ParseException unused2) {
                    date = null;
                }
                if (date == null && JSON.defaultLocale == Locale.CHINA) {
                    try {
                        simpleDateFormat2 = new SimpleDateFormat(str, Locale.US);
                    } catch (IllegalArgumentException e10) {
                        simpleDateFormat2 = simpleDateFormat;
                        if (str.contains(ExifInterface.GPS_DIRECTION_TRUE)) {
                            try {
                                simpleDateFormat2 = new SimpleDateFormat(str.replaceAll(ExifInterface.GPS_DIRECTION_TRUE, "'T'"), defaultJSONParser.lexer.getLocale());
                            } catch (IllegalArgumentException unused3) {
                                throw e10;
                            }
                        }
                    }
                    simpleDateFormat2.setTimeZone(defaultJSONParser.lexer.getTimeZone());
                    try {
                        date = simpleDateFormat2.parse(stringVal);
                    } catch (ParseException unused4) {
                        date = null;
                    }
                }
                if (date != null) {
                    obj2 = date;
                } else if (str.equals("yyyy-MM-dd'T'HH:mm:ss.SSS") && stringVal.length() == 19) {
                    try {
                        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", JSON.defaultLocale);
                        simpleDateFormat3.setTimeZone(JSON.defaultTimeZone);
                        obj2 = simpleDateFormat3.parse(stringVal);
                    } catch (ParseException unused5) {
                    }
                }
            }
            if (obj2 == null) {
                jSONLexer.nextToken(16);
                Object obj3 = stringVal;
                if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                    JSONScanner jSONScanner = new JSONScanner(stringVal);
                    Object obj4 = stringVal;
                    if (jSONScanner.scanISO8601DateIfMatch()) {
                        obj4 = jSONScanner.getCalendar().getTime();
                    }
                    jSONScanner.close();
                    obj3 = obj4;
                }
                obj2 = obj3;
            }
        } else if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
        } else if (jSONLexer.token() == 12) {
            jSONLexer.nextToken();
            if (jSONLexer.token() == 4) {
                if (JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal())) {
                    jSONLexer.nextToken();
                    defaultJSONParser.accept(17);
                    Class<?> checkAutoType = defaultJSONParser.getConfig().checkAutoType(jSONLexer.stringVal(), null, jSONLexer.getFeatures());
                    if (checkAutoType != null) {
                        type = checkAutoType;
                    }
                    defaultJSONParser.accept(4);
                    defaultJSONParser.accept(16);
                }
                jSONLexer.nextTokenWithColon(2);
                if (jSONLexer.token() == 2) {
                    long longValue2 = jSONLexer.longValue();
                    jSONLexer.nextToken();
                    obj2 = Long.valueOf(longValue2);
                    defaultJSONParser.accept(13);
                } else {
                    throw new JSONException("syntax error : " + jSONLexer.tokenName());
                }
            } else {
                throw new JSONException("syntax error");
            }
        } else if (defaultJSONParser.getResolveStatus() == 2) {
            defaultJSONParser.setResolveStatus(0);
            defaultJSONParser.accept(16);
            if (jSONLexer.token() == 4) {
                if ("val".equals(jSONLexer.stringVal())) {
                    jSONLexer.nextToken();
                    defaultJSONParser.accept(17);
                    obj2 = defaultJSONParser.parse();
                    defaultJSONParser.accept(13);
                } else {
                    throw new JSONException("syntax error");
                }
            } else {
                throw new JSONException("syntax error");
            }
        } else {
            obj2 = defaultJSONParser.parse();
        }
        return (T) cast(defaultJSONParser, type, obj, obj2);
    }
}
