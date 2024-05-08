package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Time;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TimeDeserializer implements ObjectDeserializer {
    public static final TimeDeserializer instance = new TimeDeserializer();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        long parseLong;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 16) {
            jSONLexer.nextToken(4);
            if (jSONLexer.token() == 4) {
                jSONLexer.nextTokenWithColon(2);
                if (jSONLexer.token() == 2) {
                    long longValue = jSONLexer.longValue();
                    jSONLexer.nextToken(13);
                    if (jSONLexer.token() == 13) {
                        jSONLexer.nextToken(16);
                        return (T) new Time(longValue);
                    }
                    throw new JSONException("syntax error");
                }
                throw new JSONException("syntax error");
            }
            throw new JSONException("syntax error");
        }
        T t2 = (T) defaultJSONParser.parse();
        if (t2 == 0) {
            return null;
        }
        if (t2 instanceof Time) {
            return t2;
        }
        if (t2 instanceof BigDecimal) {
            return (T) new Time(TypeUtils.longValue((BigDecimal) t2));
        }
        if (t2 instanceof Number) {
            return (T) new Time(((Number) t2).longValue());
        }
        if (t2 instanceof String) {
            String str = (String) t2;
            if (str.length() == 0) {
                return null;
            }
            JSONScanner jSONScanner = new JSONScanner(str);
            if (jSONScanner.scanISO8601DateIfMatch()) {
                parseLong = jSONScanner.getCalendar().getTimeInMillis();
            } else {
                boolean z10 = false;
                int i10 = 0;
                while (true) {
                    if (i10 >= str.length()) {
                        z10 = true;
                        break;
                    }
                    char charAt = str.charAt(i10);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i10++;
                }
                if (!z10) {
                    jSONScanner.close();
                    return (T) Time.valueOf(str);
                }
                parseLong = Long.parseLong(str);
            }
            jSONScanner.close();
            return (T) new Time(parseLong);
        }
        throw new JSONException("parse error");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }
}
