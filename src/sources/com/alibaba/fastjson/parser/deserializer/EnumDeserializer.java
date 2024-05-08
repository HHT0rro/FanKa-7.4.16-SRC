package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import java.lang.reflect.Type;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class EnumDeserializer implements ObjectDeserializer {
    public final Class<?> enumClass;
    public long[] enumNameHashCodes;
    public final Enum[] enums;
    public final Enum[] ordinalEnums;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public EnumDeserializer(java.lang.Class<?> r22) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.EnumDeserializer.<init>(java.lang.Class):void");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i10 = jSONLexer.token();
            if (i10 == 2) {
                int intValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
                if (intValue >= 0) {
                    Object[] objArr = this.ordinalEnums;
                    if (intValue <= objArr.length) {
                        return (T) objArr[intValue];
                    }
                }
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + intValue);
            }
            if (i10 != 4) {
                if (i10 == 8) {
                    jSONLexer.nextToken(16);
                    return null;
                }
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + defaultJSONParser.parse());
            }
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (stringVal.length() == 0) {
                return null;
            }
            long j10 = -3750763034362895579L;
            long j11 = -3750763034362895579L;
            for (int i11 = 0; i11 < stringVal.length(); i11++) {
                int charAt = stringVal.charAt(i11);
                long j12 = j10 ^ charAt;
                if (charAt >= 65 && charAt <= 90) {
                    charAt += 32;
                }
                j10 = j12 * 1099511628211L;
                j11 = (j11 ^ charAt) * 1099511628211L;
            }
            T t2 = (T) getEnumByHashCode(j10);
            if (t2 == null && j11 != j10) {
                t2 = (T) getEnumByHashCode(j11);
            }
            if (t2 == null && jSONLexer.isEnabled(Feature.ErrorOnEnumNotMatch)) {
                throw new JSONException("not match enum value, " + this.enumClass.getName() + " : " + stringVal);
            }
            return t2;
        } catch (JSONException e2) {
            throw e2;
        } catch (Exception e10) {
            throw new JSONException(e10.getMessage(), e10);
        }
    }

    public Enum getEnumByHashCode(long j10) {
        int binarySearch;
        if (this.enums != null && (binarySearch = Arrays.binarySearch(this.enumNameHashCodes, j10)) >= 0) {
            return this.enums[binarySearch];
        }
        return null;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    public Enum<?> valueOf(int i10) {
        return this.ordinalEnums[i10];
    }
}
