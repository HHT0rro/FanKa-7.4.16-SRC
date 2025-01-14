package com.alibaba.fastjson.support.config;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FastJsonConfig {
    private Map<Class<?>, SerializeFilter> classSerializeFilters;
    private String dateFormat;
    private ParseProcess parseProcess;
    private Charset charset = IOUtils.UTF8;
    private SerializeConfig serializeConfig = SerializeConfig.getGlobalInstance();
    private ParserConfig parserConfig = ParserConfig.getGlobalInstance();
    private SerializerFeature[] serializerFeatures = {SerializerFeature.BrowserSecure};
    private SerializeFilter[] serializeFilters = new SerializeFilter[0];
    private Feature[] features = new Feature[0];
    private boolean writeContentLength = true;

    public Charset getCharset() {
        return this.charset;
    }

    public Map<Class<?>, SerializeFilter> getClassSerializeFilters() {
        return this.classSerializeFilters;
    }

    public String getDateFormat() {
        return this.dateFormat;
    }

    public Feature[] getFeatures() {
        return this.features;
    }

    public ParseProcess getParseProcess() {
        return this.parseProcess;
    }

    public ParserConfig getParserConfig() {
        return this.parserConfig;
    }

    public SerializeConfig getSerializeConfig() {
        return this.serializeConfig;
    }

    public SerializeFilter[] getSerializeFilters() {
        return this.serializeFilters;
    }

    public SerializerFeature[] getSerializerFeatures() {
        return this.serializerFeatures;
    }

    public boolean isWriteContentLength() {
        return this.writeContentLength;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public void setClassSerializeFilters(Map<Class<?>, SerializeFilter> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<Class<?>, SerializeFilter> entry : map.entrySet()) {
            this.serializeConfig.addFilter(entry.getKey(), entry.getValue());
        }
        this.classSerializeFilters = map;
    }

    public void setDateFormat(String str) {
        this.dateFormat = str;
    }

    public void setFeatures(Feature... featureArr) {
        this.features = featureArr;
    }

    public void setParseProcess(ParseProcess parseProcess) {
        this.parseProcess = parseProcess;
    }

    public void setParserConfig(ParserConfig parserConfig) {
        this.parserConfig = parserConfig;
    }

    public void setSerializeConfig(SerializeConfig serializeConfig) {
        this.serializeConfig = serializeConfig;
    }

    public void setSerializeFilters(SerializeFilter... serializeFilterArr) {
        this.serializeFilters = serializeFilterArr;
    }

    public void setSerializerFeatures(SerializerFeature... serializerFeatureArr) {
        this.serializerFeatures = serializerFeatureArr;
    }

    public void setWriteContentLength(boolean z10) {
        this.writeContentLength = z10;
    }
}
