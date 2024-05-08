package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.nio.charset.Charset;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> implements GenericHttpMessageConverter<Object> {
    public static final MediaType APPLICATION_JAVASCRIPT = new MediaType("application", "javascript");

    @Deprecated
    public String dateFormat;
    private FastJsonConfig fastJsonConfig;

    @Deprecated
    public SerializerFeature[] features;

    @Deprecated
    public SerializeFilter[] filters;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Spring4TypeResolvableHelper {
        private static boolean hasClazzResolvableType;

        static {
            try {
                Class.forName("org.springframework.core.ResolvableType");
                hasClazzResolvableType = true;
            } catch (ClassNotFoundException unused) {
                hasClazzResolvableType = false;
            }
        }

        private Spring4TypeResolvableHelper() {
        }

        public static /* synthetic */ boolean access$000() {
            return isSupport();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Type getType(Type type, Class<?> cls) {
            if (cls == null) {
                return type;
            }
            ResolvableType forType = ResolvableType.forType(type);
            if (type instanceof TypeVariable) {
                ResolvableType resolveVariable = resolveVariable((TypeVariable) type, ResolvableType.forClass(cls));
                return resolveVariable != ResolvableType.NONE ? resolveVariable.resolve() : type;
            }
            if (!(type instanceof ParameterizedType) || !forType.hasUnresolvableGenerics()) {
                return type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class[] clsArr = new Class[parameterizedType.getActualTypeArguments().length];
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i10 = 0; i10 < actualTypeArguments.length; i10++) {
                Type type2 = actualTypeArguments[i10];
                if (type2 instanceof TypeVariable) {
                    ResolvableType resolveVariable2 = resolveVariable((TypeVariable) type2, ResolvableType.forClass(cls));
                    if (resolveVariable2 != ResolvableType.NONE) {
                        clsArr[i10] = resolveVariable2.resolve();
                    } else {
                        clsArr[i10] = ResolvableType.forType(type2).resolve();
                    }
                } else {
                    clsArr[i10] = ResolvableType.forType(type2).resolve();
                }
            }
            return ResolvableType.forClassWithGenerics(forType.getRawClass(), clsArr).getType();
        }

        private static boolean isSupport() {
            return hasClazzResolvableType;
        }

        private static ResolvableType resolveVariable(TypeVariable<?> typeVariable, ResolvableType resolvableType) {
            if (resolvableType.hasGenerics()) {
                ResolvableType forType = ResolvableType.forType(typeVariable, resolvableType);
                if (forType.resolve() != null) {
                    return forType;
                }
            }
            ResolvableType superType = resolvableType.getSuperType();
            if (superType != ResolvableType.NONE) {
                ResolvableType resolveVariable = resolveVariable(typeVariable, superType);
                if (resolveVariable.resolve() != null) {
                    return resolveVariable;
                }
            }
            for (ResolvableType resolvableType2 : resolvableType.getInterfaces()) {
                ResolvableType resolveVariable2 = resolveVariable(typeVariable, resolvableType2);
                if (resolveVariable2.resolve() != null) {
                    return resolveVariable2;
                }
            }
            return ResolvableType.NONE;
        }
    }

    public FastJsonHttpMessageConverter() {
        super(MediaType.ALL);
        this.features = new SerializerFeature[0];
        this.filters = new SerializeFilter[0];
        this.fastJsonConfig = new FastJsonConfig();
    }

    private Object readType(Type type, HttpInputMessage httpInputMessage) {
        try {
            return JSON.parseObject(httpInputMessage.getBody(), this.fastJsonConfig.getCharset(), type, this.fastJsonConfig.getParserConfig(), this.fastJsonConfig.getParseProcess(), JSON.DEFAULT_PARSER_FEATURE, this.fastJsonConfig.getFeatures());
        } catch (JSONException e2) {
            throw new HttpMessageNotReadableException("JSON parse error: " + e2.getMessage(), e2);
        } catch (IOException e10) {
            throw new HttpMessageNotReadableException("I/O error while reading input message", e10);
        }
    }

    private Object strangeCodeForJackson(Object obj) {
        return (obj == null || !"com.fasterxml.jackson.databind.node.ObjectNode".equals(obj.getClass().getName())) ? obj : obj.toString();
    }

    @Deprecated
    public void addSerializeFilter(SerializeFilter serializeFilter) {
        if (serializeFilter == null) {
            return;
        }
        int length = this.fastJsonConfig.getSerializeFilters().length;
        int i10 = length + 1;
        SerializeFilter[] serializeFilterArr = new SerializeFilter[i10];
        System.arraycopy(this.fastJsonConfig.getSerializeFilters(), 0, serializeFilterArr, 0, length);
        serializeFilterArr[i10 - 1] = serializeFilter;
        this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
    }

    public boolean canRead(Type type, Class<?> cls, MediaType mediaType) {
        return super.canRead(cls, mediaType);
    }

    public boolean canWrite(Type type, Class<?> cls, MediaType mediaType) {
        return super.canWrite(cls, mediaType);
    }

    @Deprecated
    public Charset getCharset() {
        return this.fastJsonConfig.getCharset();
    }

    @Deprecated
    public String getDateFormat() {
        return this.fastJsonConfig.getDateFormat();
    }

    public FastJsonConfig getFastJsonConfig() {
        return this.fastJsonConfig;
    }

    @Deprecated
    public SerializerFeature[] getFeatures() {
        return this.fastJsonConfig.getSerializerFeatures();
    }

    @Deprecated
    public SerializeFilter[] getFilters() {
        return this.fastJsonConfig.getSerializeFilters();
    }

    public Type getType(Type type, Class<?> cls) {
        return Spring4TypeResolvableHelper.access$000() ? Spring4TypeResolvableHelper.getType(type, cls) : type;
    }

    public Object read(Type type, Class<?> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return readType(getType(type, cls), httpInputMessage);
    }

    public Object readInternal(Class<? extends Object> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return readType(getType(cls, null), httpInputMessage);
    }

    @Deprecated
    public void setCharset(Charset charset) {
        this.fastJsonConfig.setCharset(charset);
    }

    @Deprecated
    public void setDateFormat(String str) {
        this.fastJsonConfig.setDateFormat(str);
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig) {
        this.fastJsonConfig = fastJsonConfig;
    }

    @Deprecated
    public void setFeatures(SerializerFeature... serializerFeatureArr) {
        this.fastJsonConfig.setSerializerFeatures(serializerFeatureArr);
    }

    @Deprecated
    public void setFilters(SerializeFilter... serializeFilterArr) {
        this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
    }

    public boolean supports(Class<?> cls) {
        return true;
    }

    public void write(Object obj, Type type, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        super.write(obj, mediaType, httpOutputMessage);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
    
        if ((r2 instanceof com.alibaba.fastjson.JSONPObject) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeInternal(java.lang.Object r12, org.springframework.http.HttpOutputMessage r13) throws java.io.IOException, org.springframework.http.converter.HttpMessageNotWritableException {
        /*
            r11 = this;
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream
            r8.<init>()
            org.springframework.http.HttpHeaders r9 = r13.getHeaders()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            com.alibaba.fastjson.support.config.FastJsonConfig r0 = r11.fastJsonConfig     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            com.alibaba.fastjson.serializer.SerializeFilter[] r0 = r0.getSerializeFilters()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r0 = 0
            java.lang.Object r12 = r11.strangeCodeForJackson(r12)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            boolean r2 = r12 instanceof com.alibaba.fastjson.support.spring.FastJsonContainer     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            if (r2 == 0) goto L32
            com.alibaba.fastjson.support.spring.FastJsonContainer r12 = (com.alibaba.fastjson.support.spring.FastJsonContainer) r12     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            com.alibaba.fastjson.support.spring.PropertyPreFilters r2 = r12.getFilters()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            java.util.List r2 = r2.getFilters()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r1.addAll(r2)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            java.lang.Object r12 = r12.getValue()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
        L32:
            r2 = r12
            boolean r12 = r2 instanceof com.alibaba.fastjson.support.spring.MappingFastJsonValue     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r3 = 1
            if (r12 == 0) goto L47
            r12 = r2
            com.alibaba.fastjson.support.spring.MappingFastJsonValue r12 = (com.alibaba.fastjson.support.spring.MappingFastJsonValue) r12     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            java.lang.String r12 = r12.getJsonpFunction()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            boolean r12 = org.springframework.util.StringUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            if (r12 != 0) goto L4d
            goto L4b
        L47:
            boolean r12 = r2 instanceof com.alibaba.fastjson.JSONPObject     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            if (r12 == 0) goto L4d
        L4b:
            r12 = 1
            goto L4e
        L4d:
            r12 = 0
        L4e:
            com.alibaba.fastjson.support.config.FastJsonConfig r0 = r11.fastJsonConfig     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            java.nio.charset.Charset r3 = r0.getCharset()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            com.alibaba.fastjson.support.config.FastJsonConfig r0 = r11.fastJsonConfig     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            com.alibaba.fastjson.serializer.SerializeConfig r4 = r0.getSerializeConfig()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            int r0 = r1.size()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            com.alibaba.fastjson.serializer.SerializeFilter[] r0 = new com.alibaba.fastjson.serializer.SerializeFilter[r0]     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            java.lang.Object[] r0 = r1.toArray(r0)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r5 = r0
            com.alibaba.fastjson.serializer.SerializeFilter[] r5 = (com.alibaba.fastjson.serializer.SerializeFilter[]) r5     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            com.alibaba.fastjson.support.config.FastJsonConfig r0 = r11.fastJsonConfig     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            java.lang.String r6 = r0.getDateFormat()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            int r7 = com.alibaba.fastjson.JSON.DEFAULT_GENERATE_FEATURE     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            com.alibaba.fastjson.support.config.FastJsonConfig r0 = r11.fastJsonConfig     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            com.alibaba.fastjson.serializer.SerializerFeature[] r10 = r0.getSerializerFeatures()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r0 = r8
            r1 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r10
            int r0 = com.alibaba.fastjson.JSON.writeJSONString(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            if (r12 == 0) goto L87
            org.springframework.http.MediaType r12 = com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter.APPLICATION_JAVASCRIPT     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r9.setContentType(r12)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
        L87:
            com.alibaba.fastjson.support.config.FastJsonConfig r12 = r11.fastJsonConfig     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            boolean r12 = r12.isWriteContentLength()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            if (r12 == 0) goto L93
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r9.setContentLength(r0)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
        L93:
            java.io.OutputStream r12 = r13.getBody()     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r8.writeTo(r12)     // Catch: java.lang.Throwable -> L9e com.alibaba.fastjson.JSONException -> La0
            r8.close()
            return
        L9e:
            r12 = move-exception
            goto Lbc
        La0:
            r12 = move-exception
            org.springframework.http.converter.HttpMessageNotWritableException r13 = new org.springframework.http.converter.HttpMessageNotWritableException     // Catch: java.lang.Throwable -> L9e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
            r0.<init>()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r1 = "Could not write JSON: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r1 = r12.getMessage()     // Catch: java.lang.Throwable -> L9e
            r0.append(r1)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L9e
            r13.<init>(r0, r12)     // Catch: java.lang.Throwable -> L9e
            throw r13     // Catch: java.lang.Throwable -> L9e
        Lbc:
            r8.close()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter.writeInternal(java.lang.Object, org.springframework.http.HttpOutputMessage):void");
    }
}
