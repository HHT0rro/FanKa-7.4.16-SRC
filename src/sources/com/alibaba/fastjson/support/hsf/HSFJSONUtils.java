package com.alibaba.fastjson.support.hsf;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.SymbolTable;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class HSFJSONUtils {
    public static final SymbolTable typeSymbolTable = new SymbolTable(1024);
    public static final char[] fieldName_argsTypes = "\"argsTypes\"".toCharArray();
    public static final char[] fieldName_argsObjs = "\"argsObjs\"".toCharArray();
    public static final char[] fieldName_type = "\"@type\":".toCharArray();

    public static Object[] parseInvocationArguments(String str, MethodLocator methodLocator) {
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str);
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.getLexer();
        Object[] objArr = null;
        ParseContext context = defaultJSONParser.setContext(null, null);
        int i10 = jSONLexerBase.token();
        int i11 = 0;
        if (i10 != 12) {
            if (i10 != 14) {
                return null;
            }
            String[] scanFieldStringArray = jSONLexerBase.scanFieldStringArray(null, -1, typeSymbolTable);
            jSONLexerBase.skipWhitespace();
            char current = jSONLexerBase.getCurrent();
            if (current == ']') {
                Type[] genericParameterTypes = methodLocator.findMethod(null).getGenericParameterTypes();
                Object[] objArr2 = new Object[scanFieldStringArray.length];
                while (i11 < scanFieldStringArray.length) {
                    Type type = genericParameterTypes[i11];
                    String str2 = scanFieldStringArray[i11];
                    if (type != String.class) {
                        objArr2[i11] = TypeUtils.cast(str2, type, defaultJSONParser.getConfig());
                    } else {
                        objArr2[i11] = str2;
                    }
                    i11++;
                }
                return objArr2;
            }
            if (current == ',') {
                jSONLexerBase.next();
                jSONLexerBase.skipWhitespace();
            }
            jSONLexerBase.nextToken(14);
            Object[] parseArray = defaultJSONParser.parseArray(methodLocator.findMethod(scanFieldStringArray).getGenericParameterTypes());
            jSONLexerBase.close();
            return parseArray;
        }
        char[] cArr = fieldName_argsTypes;
        SymbolTable symbolTable = typeSymbolTable;
        String[] scanFieldStringArray2 = jSONLexerBase.scanFieldStringArray(cArr, -1, symbolTable);
        if (scanFieldStringArray2 == null && jSONLexerBase.matchStat == -2 && "com.alibaba.fastjson.JSONObject".equals(jSONLexerBase.scanFieldString(fieldName_type))) {
            scanFieldStringArray2 = jSONLexerBase.scanFieldStringArray(cArr, -1, symbolTable);
        }
        Method findMethod = methodLocator.findMethod(scanFieldStringArray2);
        if (findMethod == null) {
            jSONLexerBase.close();
            JSONObject parseObject = JSON.parseObject(str);
            Method findMethod2 = methodLocator.findMethod((String[]) parseObject.getObject("argsTypes", String[].class));
            JSONArray jSONArray = parseObject.getJSONArray("argsObjs");
            if (jSONArray == null) {
                return null;
            }
            Type[] genericParameterTypes2 = findMethod2.getGenericParameterTypes();
            Object[] objArr3 = new Object[genericParameterTypes2.length];
            while (i11 < genericParameterTypes2.length) {
                objArr3[i11] = jSONArray.getObject(i11, genericParameterTypes2[i11]);
                i11++;
            }
            return objArr3;
        }
        Type[] genericParameterTypes3 = findMethod.getGenericParameterTypes();
        jSONLexerBase.skipWhitespace();
        if (jSONLexerBase.getCurrent() == ',') {
            jSONLexerBase.next();
        }
        if (jSONLexerBase.matchField2(fieldName_argsObjs)) {
            jSONLexerBase.nextToken();
            ParseContext context2 = defaultJSONParser.setContext(context, null, "argsObjs");
            Object[] parseArray2 = defaultJSONParser.parseArray(genericParameterTypes3);
            context2.object = parseArray2;
            defaultJSONParser.accept(13);
            defaultJSONParser.handleResovleTask(null);
            objArr = parseArray2;
        }
        defaultJSONParser.close();
        return objArr;
    }
}
