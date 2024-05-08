package com.alibaba.security.common.json.parser;

import com.alibaba.security.common.json.RPJSONException;
import com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class EnumDeserializer implements ObjectDeserializer {
    private final Class<?> enumClass;
    public final Enum[] values;

    public EnumDeserializer(Class<?> cls) {
        this.enumClass = cls;
        this.values = (Enum[]) cls.getEnumConstants();
    }

    @Override // com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i10 = jSONLexer.token;
            if (i10 == 2) {
                int intValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
                if (intValue >= 0) {
                    Object[] objArr = this.values;
                    if (intValue <= objArr.length) {
                        return (T) objArr[intValue];
                    }
                }
                throw new RPJSONException("parse enum " + this.enumClass.getName() + " error, value : " + intValue);
            }
            if (i10 == 4) {
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextToken(16);
                if (stringVal.length() == 0) {
                    return null;
                }
                return (T) Enum.valueOf(this.enumClass, stringVal);
            }
            if (i10 == 8) {
                jSONLexer.nextToken(16);
                return null;
            }
            throw new RPJSONException("parse enum " + this.enumClass.getName() + " error, value : " + defaultJSONParser.parse());
        } catch (RPJSONException e2) {
            throw e2;
        } catch (Exception e10) {
            throw new RPJSONException(e10.getMessage(), e10);
        }
    }
}
