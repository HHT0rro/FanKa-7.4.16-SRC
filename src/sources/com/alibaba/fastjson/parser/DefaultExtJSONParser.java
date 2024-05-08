package com.alibaba.fastjson.parser;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DefaultExtJSONParser extends DefaultJSONParser {
    public DefaultExtJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance());
    }

    public DefaultExtJSONParser(String str, ParserConfig parserConfig) {
        super(str, parserConfig);
    }

    public DefaultExtJSONParser(String str, ParserConfig parserConfig, int i10) {
        super(str, parserConfig, i10);
    }

    public DefaultExtJSONParser(char[] cArr, int i10, ParserConfig parserConfig, int i11) {
        super(cArr, i10, parserConfig, i11);
    }
}
