package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class CharArrayCodec implements ObjectDeserializer {
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T deserialze(DefaultJSONParser defaultJSONParser) {
        boolean z10;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            return (T) stringVal.toCharArray();
        }
        if (jSONLexer.token() == 2) {
            Number integerValue = jSONLexer.integerValue();
            jSONLexer.nextToken(16);
            return (T) integerValue.toString().toCharArray();
        }
        Object parse = defaultJSONParser.parse();
        if (parse instanceof String) {
            return (T) ((String) parse).toCharArray();
        }
        if (!(parse instanceof Collection)) {
            if (parse == null) {
                return null;
            }
            return (T) JSON.toJSONString(parse).toCharArray();
        }
        Collection collection = (Collection) parse;
        Iterator iterator2 = collection.iterator2();
        while (true) {
            z10 = true;
            if (!iterator2.hasNext()) {
                break;
            }
            Object next = iterator2.next();
            if ((next instanceof String) && ((String) next).length() != 1) {
                z10 = false;
                break;
            }
        }
        if (z10) {
            char[] cArr = new char[collection.size()];
            Iterator iterator22 = collection.iterator2();
            int i10 = 0;
            while (iterator22.hasNext()) {
                cArr[i10] = ((String) iterator22.next()).charAt(0);
                i10++;
            }
            return cArr;
        }
        throw new JSONException("can not cast to char[]");
    }
}
