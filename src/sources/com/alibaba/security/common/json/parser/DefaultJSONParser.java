package com.alibaba.security.common.json.parser;

import com.alibaba.security.common.json.RPJSON;
import com.alibaba.security.common.json.RPJSONArray;
import com.alibaba.security.common.json.RPJSONException;
import com.alibaba.security.common.json.RPJSONObject;
import com.alibaba.security.common.json.parser.deserializer.ExtraProcessor;
import com.alibaba.security.common.json.parser.deserializer.ExtraTypeProvider;
import com.alibaba.security.common.json.parser.deserializer.FieldDeserializer;
import com.alibaba.security.common.json.parser.deserializer.FieldTypeResolver;
import com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer;
import com.alibaba.security.common.json.serializer.IntegerCodec;
import com.alibaba.security.common.json.serializer.StringCodec;
import com.alibaba.security.common.json.util.RPFieldInfo;
import com.alibaba.security.common.json.util.RPTypeUtils;
import com.android.internal.accessibility.common.ShortcutConstants;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    public ParserConfig config;
    public ParseContext contex;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    public List<ExtraProcessor> extraProcessors;
    public List<ExtraTypeProvider> extraTypeProviders;
    public FieldTypeResolver fieldTypeResolver;
    public final JSONLexer lexer;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ResolveTask {
        private final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        private final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.global, RPJSON.DEFAULT_PARSER_FEATURE);
    }

    public final void accept(int i10) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token == i10) {
            jSONLexer.nextToken();
            return;
        }
        throw new RPJSONException("syntax error, expect " + JSONToken.name(i10) + ", actual " + JSONToken.name(this.lexer.token));
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public void checkListResolve(Collection collection) {
        if (collection instanceof List) {
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, collection.size() - 1);
            lastResolveTask.ownerContext = this.contex;
            this.resolveStatus = 0;
            return;
        }
        ResolveTask lastResolveTask2 = getLastResolveTask();
        lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(collection);
        lastResolveTask2.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    public void checkMapResolve(Map map, Object obj) {
        ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
        ResolveTask lastResolveTask = getLastResolveTask();
        lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
        lastResolveTask.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            JSONLexer jSONLexer = this.lexer;
            if (jSONLexer.token == 20) {
                jSONLexer.close();
                return;
            }
            throw new RPJSONException("not close json text, token : " + JSONToken.name(this.lexer.token));
        } catch (Throwable th) {
            this.lexer.close();
            throw th;
        }
    }

    public void config(Feature feature, boolean z10) {
        this.lexer.config(feature, z10);
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.locale);
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.timeZone);
        }
        return this.dateFormat;
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public ResolveTask getLastResolveTask() {
        return this.resolveTaskList.get(r0.size() - 1);
    }

    public void handleResovleTask(Object obj) {
        List<ResolveTask> list = this.resolveTaskList;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            ResolveTask resolveTask = this.resolveTaskList.get(i10);
            FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
            if (fieldDeserializer != null) {
                ParseContext parseContext = resolveTask.ownerContext;
                Object obj2 = null;
                Object obj3 = parseContext != null ? parseContext.object : null;
                String str = resolveTask.referenceValue;
                if (str.startsWith("$")) {
                    for (int i11 = 0; i11 < this.contextArrayIndex; i11++) {
                        if (str.equals(this.contextArray[i11].toString())) {
                            obj2 = this.contextArray[i11].object;
                        }
                    }
                } else {
                    obj2 = resolveTask.context.object;
                }
                fieldDeserializer.setValue(obj3, obj2);
            }
        }
    }

    public Object parse() {
        return parse(null);
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public Object parseArrayWithType(Type type) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token == 8) {
            jSONLexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length == 1) {
            Type type2 = actualTypeArguments[0];
            if (type2 instanceof Class) {
                ArrayList arrayList = new ArrayList();
                parseArray((Class<?>) type2, (Collection) arrayList);
                return arrayList;
            }
            if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type2;
                Type type3 = wildcardType.getUpperBounds()[0];
                if (Object.class.equals(type3)) {
                    if (wildcardType.getLowerBounds().length == 0) {
                        return parse();
                    }
                    throw new RPJSONException("not support type : " + ((Object) type));
                }
                ArrayList arrayList2 = new ArrayList();
                parseArray((Class<?>) type3, (Collection) arrayList2);
                return arrayList2;
            }
            if (type2 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type2;
                Type[] bounds = typeVariable.getBounds();
                if (bounds.length == 1) {
                    Type type4 = bounds[0];
                    if (type4 instanceof Class) {
                        ArrayList arrayList3 = new ArrayList();
                        parseArray((Class<?>) type4, (Collection) arrayList3);
                        return arrayList3;
                    }
                } else {
                    throw new RPJSONException("not support : " + ((Object) typeVariable));
                }
            }
            if (type2 instanceof ParameterizedType) {
                ArrayList arrayList4 = new ArrayList();
                parseArray((ParameterizedType) type2, arrayList4);
                return arrayList4;
            }
            throw new RPJSONException("TODO : " + ((Object) type));
        }
        throw new RPJSONException("not support type " + ((Object) type));
    }

    /* JADX WARN: Code restructure failed: missing block: B:305:0x022c, code lost:
    
        r3.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x0233, code lost:
    
        if (r3.token != 13) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0235, code lost:
    
        r3.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x0238, code lost:
    
        r0 = r19.config.getDeserializer(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x0240, code lost:
    
        if ((r0 instanceof com.alibaba.security.common.json.parser.JavaBeanDeserializer) == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x0242, code lost:
    
        r16 = ((com.alibaba.security.common.json.parser.JavaBeanDeserializer) r0).createInstance((com.alibaba.security.common.json.parser.DefaultJSONParser) r19, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x024d, code lost:
    
        if (r16 != null) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x0251, code lost:
    
        if (r7 != java.lang.Cloneable.class) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x0253, code lost:
    
        r16 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x025f, code lost:
    
        if ("java.util.Collections$EmptyMap".equals(r6) == false) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x0261, code lost:
    
        r16 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x0266, code lost:
    
        r16 = r7.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x026a, code lost:
    
        if (r13 != false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x026c, code lost:
    
        r19.contex = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x026e, code lost:
    
        return r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x024b, code lost:
    
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x026f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x0277, code lost:
    
        throw new com.alibaba.security.common.json.RPJSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x0278, code lost:
    
        r19.resolveStatus = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x027d, code lost:
    
        if (r19.contex == null) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x0281, code lost:
    
        if ((r21 instanceof java.lang.Integer) != false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x0283, code lost:
    
        popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x028a, code lost:
    
        if (r20.size() <= 0) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x028c, code lost:
    
        r0 = com.alibaba.security.common.json.util.RPTypeUtils.cast((java.lang.Object) r20, (java.lang.Class<java.lang.Object>) r7, r19.config);
        parseObject(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x0295, code lost:
    
        if (r13 != false) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x0297, code lost:
    
        r19.contex = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x0299, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x029a, code lost:
    
        r0 = r19.config.getDeserializer(r7).deserialze(r19, r7, r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x02a4, code lost:
    
        if (r13 != false) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x02a6, code lost:
    
        r19.contex = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x02a8, code lost:
    
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0382 A[Catch: all -> 0x067e, TryCatch #2 {all -> 0x067e, blocks: (B:19:0x0063, B:22:0x006d, B:26:0x0076, B:30:0x0089, B:32:0x0093, B:36:0x009b, B:37:0x00b9, B:41:0x01c1, B:44:0x01d4, B:60:0x01f3, B:62:0x0200, B:65:0x0207, B:300:0x020f, B:302:0x0221, B:305:0x022c, B:307:0x0235, B:309:0x0238, B:311:0x0242, B:315:0x0253, B:316:0x0259, B:318:0x0261, B:319:0x0266, B:325:0x0270, B:326:0x0277, B:327:0x0278, B:329:0x027f, B:331:0x0283, B:332:0x0286, B:334:0x028c, B:338:0x029a, B:71:0x02b0, B:74:0x02b8, B:76:0x02bf, B:78:0x02ce, B:80:0x02d6, B:83:0x02db, B:85:0x02df, B:86:0x0329, B:88:0x032d, B:92:0x0337, B:93:0x034f, B:96:0x02e2, B:98:0x02ea, B:100:0x02f0, B:101:0x02fc, B:104:0x0305, B:108:0x030b, B:111:0x0311, B:112:0x031d, B:113:0x0350, B:114:0x036c, B:117:0x0371, B:122:0x0382, B:124:0x0388, B:126:0x0394, B:127:0x039a, B:129:0x039f, B:131:0x0533, B:135:0x053d, B:138:0x0546, B:141:0x0559, B:146:0x0553, B:150:0x0565, B:153:0x0578, B:155:0x0581, B:158:0x0594, B:160:0x05dc, B:164:0x058e, B:167:0x059f, B:170:0x05b2, B:171:0x05ac, B:174:0x05bd, B:177:0x05d0, B:178:0x05ca, B:179:0x05d7, B:180:0x0572, B:181:0x05e6, B:182:0x05fe, B:183:0x03a3, B:188:0x03b3, B:193:0x03c2, B:196:0x03d9, B:198:0x03e2, B:202:0x03ef, B:203:0x03f2, B:205:0x03fc, B:206:0x0403, B:215:0x0407, B:212:0x0419, B:213:0x0431, B:219:0x0400, B:221:0x03d3, B:224:0x0436, B:227:0x0449, B:229:0x045a, B:232:0x046e, B:233:0x0474, B:236:0x047a, B:237:0x0484, B:239:0x048c, B:241:0x049e, B:244:0x04a6, B:245:0x04a8, B:247:0x04ad, B:249:0x04b6, B:251:0x04bf, B:252:0x04c2, B:260:0x04c8, B:262:0x04cf, B:257:0x04dc, B:258:0x04f4, B:266:0x04ba, B:271:0x0465, B:272:0x0443, B:275:0x04fb, B:277:0x0507, B:280:0x051a, B:282:0x0526, B:283:0x05ff, B:285:0x0610, B:286:0x0614, B:294:0x061d, B:291:0x0633, B:292:0x064b, B:347:0x01ce, B:348:0x01fc, B:408:0x00c1, B:411:0x00d2, B:415:0x00cc, B:353:0x00e5, B:355:0x00ef, B:356:0x00f2, B:360:0x00f7, B:361:0x010d, B:369:0x0120, B:371:0x0126, B:373:0x012b, B:375:0x0138, B:376:0x013c, B:380:0x0142, B:381:0x015c, B:382:0x0130, B:384:0x015d, B:385:0x0177, B:393:0x0181, B:396:0x0190, B:398:0x0196, B:399:0x01b4, B:400:0x01b5, B:402:0x064c, B:403:0x0664, B:405:0x0665, B:406:0x067d), top: B:18:0x0063, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0546 A[Catch: all -> 0x067e, TryCatch #2 {all -> 0x067e, blocks: (B:19:0x0063, B:22:0x006d, B:26:0x0076, B:30:0x0089, B:32:0x0093, B:36:0x009b, B:37:0x00b9, B:41:0x01c1, B:44:0x01d4, B:60:0x01f3, B:62:0x0200, B:65:0x0207, B:300:0x020f, B:302:0x0221, B:305:0x022c, B:307:0x0235, B:309:0x0238, B:311:0x0242, B:315:0x0253, B:316:0x0259, B:318:0x0261, B:319:0x0266, B:325:0x0270, B:326:0x0277, B:327:0x0278, B:329:0x027f, B:331:0x0283, B:332:0x0286, B:334:0x028c, B:338:0x029a, B:71:0x02b0, B:74:0x02b8, B:76:0x02bf, B:78:0x02ce, B:80:0x02d6, B:83:0x02db, B:85:0x02df, B:86:0x0329, B:88:0x032d, B:92:0x0337, B:93:0x034f, B:96:0x02e2, B:98:0x02ea, B:100:0x02f0, B:101:0x02fc, B:104:0x0305, B:108:0x030b, B:111:0x0311, B:112:0x031d, B:113:0x0350, B:114:0x036c, B:117:0x0371, B:122:0x0382, B:124:0x0388, B:126:0x0394, B:127:0x039a, B:129:0x039f, B:131:0x0533, B:135:0x053d, B:138:0x0546, B:141:0x0559, B:146:0x0553, B:150:0x0565, B:153:0x0578, B:155:0x0581, B:158:0x0594, B:160:0x05dc, B:164:0x058e, B:167:0x059f, B:170:0x05b2, B:171:0x05ac, B:174:0x05bd, B:177:0x05d0, B:178:0x05ca, B:179:0x05d7, B:180:0x0572, B:181:0x05e6, B:182:0x05fe, B:183:0x03a3, B:188:0x03b3, B:193:0x03c2, B:196:0x03d9, B:198:0x03e2, B:202:0x03ef, B:203:0x03f2, B:205:0x03fc, B:206:0x0403, B:215:0x0407, B:212:0x0419, B:213:0x0431, B:219:0x0400, B:221:0x03d3, B:224:0x0436, B:227:0x0449, B:229:0x045a, B:232:0x046e, B:233:0x0474, B:236:0x047a, B:237:0x0484, B:239:0x048c, B:241:0x049e, B:244:0x04a6, B:245:0x04a8, B:247:0x04ad, B:249:0x04b6, B:251:0x04bf, B:252:0x04c2, B:260:0x04c8, B:262:0x04cf, B:257:0x04dc, B:258:0x04f4, B:266:0x04ba, B:271:0x0465, B:272:0x0443, B:275:0x04fb, B:277:0x0507, B:280:0x051a, B:282:0x0526, B:283:0x05ff, B:285:0x0610, B:286:0x0614, B:294:0x061d, B:291:0x0633, B:292:0x064b, B:347:0x01ce, B:348:0x01fc, B:408:0x00c1, B:411:0x00d2, B:415:0x00cc, B:353:0x00e5, B:355:0x00ef, B:356:0x00f2, B:360:0x00f7, B:361:0x010d, B:369:0x0120, B:371:0x0126, B:373:0x012b, B:375:0x0138, B:376:0x013c, B:380:0x0142, B:381:0x015c, B:382:0x0130, B:384:0x015d, B:385:0x0177, B:393:0x0181, B:396:0x0190, B:398:0x0196, B:399:0x01b4, B:400:0x01b5, B:402:0x064c, B:403:0x0664, B:405:0x0665, B:406:0x067d), top: B:18:0x0063, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0561 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x049e A[Catch: all -> 0x067e, TryCatch #2 {all -> 0x067e, blocks: (B:19:0x0063, B:22:0x006d, B:26:0x0076, B:30:0x0089, B:32:0x0093, B:36:0x009b, B:37:0x00b9, B:41:0x01c1, B:44:0x01d4, B:60:0x01f3, B:62:0x0200, B:65:0x0207, B:300:0x020f, B:302:0x0221, B:305:0x022c, B:307:0x0235, B:309:0x0238, B:311:0x0242, B:315:0x0253, B:316:0x0259, B:318:0x0261, B:319:0x0266, B:325:0x0270, B:326:0x0277, B:327:0x0278, B:329:0x027f, B:331:0x0283, B:332:0x0286, B:334:0x028c, B:338:0x029a, B:71:0x02b0, B:74:0x02b8, B:76:0x02bf, B:78:0x02ce, B:80:0x02d6, B:83:0x02db, B:85:0x02df, B:86:0x0329, B:88:0x032d, B:92:0x0337, B:93:0x034f, B:96:0x02e2, B:98:0x02ea, B:100:0x02f0, B:101:0x02fc, B:104:0x0305, B:108:0x030b, B:111:0x0311, B:112:0x031d, B:113:0x0350, B:114:0x036c, B:117:0x0371, B:122:0x0382, B:124:0x0388, B:126:0x0394, B:127:0x039a, B:129:0x039f, B:131:0x0533, B:135:0x053d, B:138:0x0546, B:141:0x0559, B:146:0x0553, B:150:0x0565, B:153:0x0578, B:155:0x0581, B:158:0x0594, B:160:0x05dc, B:164:0x058e, B:167:0x059f, B:170:0x05b2, B:171:0x05ac, B:174:0x05bd, B:177:0x05d0, B:178:0x05ca, B:179:0x05d7, B:180:0x0572, B:181:0x05e6, B:182:0x05fe, B:183:0x03a3, B:188:0x03b3, B:193:0x03c2, B:196:0x03d9, B:198:0x03e2, B:202:0x03ef, B:203:0x03f2, B:205:0x03fc, B:206:0x0403, B:215:0x0407, B:212:0x0419, B:213:0x0431, B:219:0x0400, B:221:0x03d3, B:224:0x0436, B:227:0x0449, B:229:0x045a, B:232:0x046e, B:233:0x0474, B:236:0x047a, B:237:0x0484, B:239:0x048c, B:241:0x049e, B:244:0x04a6, B:245:0x04a8, B:247:0x04ad, B:249:0x04b6, B:251:0x04bf, B:252:0x04c2, B:260:0x04c8, B:262:0x04cf, B:257:0x04dc, B:258:0x04f4, B:266:0x04ba, B:271:0x0465, B:272:0x0443, B:275:0x04fb, B:277:0x0507, B:280:0x051a, B:282:0x0526, B:283:0x05ff, B:285:0x0610, B:286:0x0614, B:294:0x061d, B:291:0x0633, B:292:0x064b, B:347:0x01ce, B:348:0x01fc, B:408:0x00c1, B:411:0x00d2, B:415:0x00cc, B:353:0x00e5, B:355:0x00ef, B:356:0x00f2, B:360:0x00f7, B:361:0x010d, B:369:0x0120, B:371:0x0126, B:373:0x012b, B:375:0x0138, B:376:0x013c, B:380:0x0142, B:381:0x015c, B:382:0x0130, B:384:0x015d, B:385:0x0177, B:393:0x0181, B:396:0x0190, B:398:0x0196, B:399:0x01b4, B:400:0x01b5, B:402:0x064c, B:403:0x0664, B:405:0x0665, B:406:0x067d), top: B:18:0x0063, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x04ad A[Catch: all -> 0x067e, TryCatch #2 {all -> 0x067e, blocks: (B:19:0x0063, B:22:0x006d, B:26:0x0076, B:30:0x0089, B:32:0x0093, B:36:0x009b, B:37:0x00b9, B:41:0x01c1, B:44:0x01d4, B:60:0x01f3, B:62:0x0200, B:65:0x0207, B:300:0x020f, B:302:0x0221, B:305:0x022c, B:307:0x0235, B:309:0x0238, B:311:0x0242, B:315:0x0253, B:316:0x0259, B:318:0x0261, B:319:0x0266, B:325:0x0270, B:326:0x0277, B:327:0x0278, B:329:0x027f, B:331:0x0283, B:332:0x0286, B:334:0x028c, B:338:0x029a, B:71:0x02b0, B:74:0x02b8, B:76:0x02bf, B:78:0x02ce, B:80:0x02d6, B:83:0x02db, B:85:0x02df, B:86:0x0329, B:88:0x032d, B:92:0x0337, B:93:0x034f, B:96:0x02e2, B:98:0x02ea, B:100:0x02f0, B:101:0x02fc, B:104:0x0305, B:108:0x030b, B:111:0x0311, B:112:0x031d, B:113:0x0350, B:114:0x036c, B:117:0x0371, B:122:0x0382, B:124:0x0388, B:126:0x0394, B:127:0x039a, B:129:0x039f, B:131:0x0533, B:135:0x053d, B:138:0x0546, B:141:0x0559, B:146:0x0553, B:150:0x0565, B:153:0x0578, B:155:0x0581, B:158:0x0594, B:160:0x05dc, B:164:0x058e, B:167:0x059f, B:170:0x05b2, B:171:0x05ac, B:174:0x05bd, B:177:0x05d0, B:178:0x05ca, B:179:0x05d7, B:180:0x0572, B:181:0x05e6, B:182:0x05fe, B:183:0x03a3, B:188:0x03b3, B:193:0x03c2, B:196:0x03d9, B:198:0x03e2, B:202:0x03ef, B:203:0x03f2, B:205:0x03fc, B:206:0x0403, B:215:0x0407, B:212:0x0419, B:213:0x0431, B:219:0x0400, B:221:0x03d3, B:224:0x0436, B:227:0x0449, B:229:0x045a, B:232:0x046e, B:233:0x0474, B:236:0x047a, B:237:0x0484, B:239:0x048c, B:241:0x049e, B:244:0x04a6, B:245:0x04a8, B:247:0x04ad, B:249:0x04b6, B:251:0x04bf, B:252:0x04c2, B:260:0x04c8, B:262:0x04cf, B:257:0x04dc, B:258:0x04f4, B:266:0x04ba, B:271:0x0465, B:272:0x0443, B:275:0x04fb, B:277:0x0507, B:280:0x051a, B:282:0x0526, B:283:0x05ff, B:285:0x0610, B:286:0x0614, B:294:0x061d, B:291:0x0633, B:292:0x064b, B:347:0x01ce, B:348:0x01fc, B:408:0x00c1, B:411:0x00d2, B:415:0x00cc, B:353:0x00e5, B:355:0x00ef, B:356:0x00f2, B:360:0x00f7, B:361:0x010d, B:369:0x0120, B:371:0x0126, B:373:0x012b, B:375:0x0138, B:376:0x013c, B:380:0x0142, B:381:0x015c, B:382:0x0130, B:384:0x015d, B:385:0x0177, B:393:0x0181, B:396:0x0190, B:398:0x0196, B:399:0x01b4, B:400:0x01b5, B:402:0x064c, B:403:0x0664, B:405:0x0665, B:406:0x067d), top: B:18:0x0063, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x04b6 A[Catch: all -> 0x067e, TryCatch #2 {all -> 0x067e, blocks: (B:19:0x0063, B:22:0x006d, B:26:0x0076, B:30:0x0089, B:32:0x0093, B:36:0x009b, B:37:0x00b9, B:41:0x01c1, B:44:0x01d4, B:60:0x01f3, B:62:0x0200, B:65:0x0207, B:300:0x020f, B:302:0x0221, B:305:0x022c, B:307:0x0235, B:309:0x0238, B:311:0x0242, B:315:0x0253, B:316:0x0259, B:318:0x0261, B:319:0x0266, B:325:0x0270, B:326:0x0277, B:327:0x0278, B:329:0x027f, B:331:0x0283, B:332:0x0286, B:334:0x028c, B:338:0x029a, B:71:0x02b0, B:74:0x02b8, B:76:0x02bf, B:78:0x02ce, B:80:0x02d6, B:83:0x02db, B:85:0x02df, B:86:0x0329, B:88:0x032d, B:92:0x0337, B:93:0x034f, B:96:0x02e2, B:98:0x02ea, B:100:0x02f0, B:101:0x02fc, B:104:0x0305, B:108:0x030b, B:111:0x0311, B:112:0x031d, B:113:0x0350, B:114:0x036c, B:117:0x0371, B:122:0x0382, B:124:0x0388, B:126:0x0394, B:127:0x039a, B:129:0x039f, B:131:0x0533, B:135:0x053d, B:138:0x0546, B:141:0x0559, B:146:0x0553, B:150:0x0565, B:153:0x0578, B:155:0x0581, B:158:0x0594, B:160:0x05dc, B:164:0x058e, B:167:0x059f, B:170:0x05b2, B:171:0x05ac, B:174:0x05bd, B:177:0x05d0, B:178:0x05ca, B:179:0x05d7, B:180:0x0572, B:181:0x05e6, B:182:0x05fe, B:183:0x03a3, B:188:0x03b3, B:193:0x03c2, B:196:0x03d9, B:198:0x03e2, B:202:0x03ef, B:203:0x03f2, B:205:0x03fc, B:206:0x0403, B:215:0x0407, B:212:0x0419, B:213:0x0431, B:219:0x0400, B:221:0x03d3, B:224:0x0436, B:227:0x0449, B:229:0x045a, B:232:0x046e, B:233:0x0474, B:236:0x047a, B:237:0x0484, B:239:0x048c, B:241:0x049e, B:244:0x04a6, B:245:0x04a8, B:247:0x04ad, B:249:0x04b6, B:251:0x04bf, B:252:0x04c2, B:260:0x04c8, B:262:0x04cf, B:257:0x04dc, B:258:0x04f4, B:266:0x04ba, B:271:0x0465, B:272:0x0443, B:275:0x04fb, B:277:0x0507, B:280:0x051a, B:282:0x0526, B:283:0x05ff, B:285:0x0610, B:286:0x0614, B:294:0x061d, B:291:0x0633, B:292:0x064b, B:347:0x01ce, B:348:0x01fc, B:408:0x00c1, B:411:0x00d2, B:415:0x00cc, B:353:0x00e5, B:355:0x00ef, B:356:0x00f2, B:360:0x00f7, B:361:0x010d, B:369:0x0120, B:371:0x0126, B:373:0x012b, B:375:0x0138, B:376:0x013c, B:380:0x0142, B:381:0x015c, B:382:0x0130, B:384:0x015d, B:385:0x0177, B:393:0x0181, B:396:0x0190, B:398:0x0196, B:399:0x01b4, B:400:0x01b5, B:402:0x064c, B:403:0x0664, B:405:0x0665, B:406:0x067d), top: B:18:0x0063, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x04bf A[Catch: all -> 0x067e, TryCatch #2 {all -> 0x067e, blocks: (B:19:0x0063, B:22:0x006d, B:26:0x0076, B:30:0x0089, B:32:0x0093, B:36:0x009b, B:37:0x00b9, B:41:0x01c1, B:44:0x01d4, B:60:0x01f3, B:62:0x0200, B:65:0x0207, B:300:0x020f, B:302:0x0221, B:305:0x022c, B:307:0x0235, B:309:0x0238, B:311:0x0242, B:315:0x0253, B:316:0x0259, B:318:0x0261, B:319:0x0266, B:325:0x0270, B:326:0x0277, B:327:0x0278, B:329:0x027f, B:331:0x0283, B:332:0x0286, B:334:0x028c, B:338:0x029a, B:71:0x02b0, B:74:0x02b8, B:76:0x02bf, B:78:0x02ce, B:80:0x02d6, B:83:0x02db, B:85:0x02df, B:86:0x0329, B:88:0x032d, B:92:0x0337, B:93:0x034f, B:96:0x02e2, B:98:0x02ea, B:100:0x02f0, B:101:0x02fc, B:104:0x0305, B:108:0x030b, B:111:0x0311, B:112:0x031d, B:113:0x0350, B:114:0x036c, B:117:0x0371, B:122:0x0382, B:124:0x0388, B:126:0x0394, B:127:0x039a, B:129:0x039f, B:131:0x0533, B:135:0x053d, B:138:0x0546, B:141:0x0559, B:146:0x0553, B:150:0x0565, B:153:0x0578, B:155:0x0581, B:158:0x0594, B:160:0x05dc, B:164:0x058e, B:167:0x059f, B:170:0x05b2, B:171:0x05ac, B:174:0x05bd, B:177:0x05d0, B:178:0x05ca, B:179:0x05d7, B:180:0x0572, B:181:0x05e6, B:182:0x05fe, B:183:0x03a3, B:188:0x03b3, B:193:0x03c2, B:196:0x03d9, B:198:0x03e2, B:202:0x03ef, B:203:0x03f2, B:205:0x03fc, B:206:0x0403, B:215:0x0407, B:212:0x0419, B:213:0x0431, B:219:0x0400, B:221:0x03d3, B:224:0x0436, B:227:0x0449, B:229:0x045a, B:232:0x046e, B:233:0x0474, B:236:0x047a, B:237:0x0484, B:239:0x048c, B:241:0x049e, B:244:0x04a6, B:245:0x04a8, B:247:0x04ad, B:249:0x04b6, B:251:0x04bf, B:252:0x04c2, B:260:0x04c8, B:262:0x04cf, B:257:0x04dc, B:258:0x04f4, B:266:0x04ba, B:271:0x0465, B:272:0x0443, B:275:0x04fb, B:277:0x0507, B:280:0x051a, B:282:0x0526, B:283:0x05ff, B:285:0x0610, B:286:0x0614, B:294:0x061d, B:291:0x0633, B:292:0x064b, B:347:0x01ce, B:348:0x01fc, B:408:0x00c1, B:411:0x00d2, B:415:0x00cc, B:353:0x00e5, B:355:0x00ef, B:356:0x00f2, B:360:0x00f7, B:361:0x010d, B:369:0x0120, B:371:0x0126, B:373:0x012b, B:375:0x0138, B:376:0x013c, B:380:0x0142, B:381:0x015c, B:382:0x0130, B:384:0x015d, B:385:0x0177, B:393:0x0181, B:396:0x0190, B:398:0x0196, B:399:0x01b4, B:400:0x01b5, B:402:0x064c, B:403:0x0664, B:405:0x0665, B:406:0x067d), top: B:18:0x0063, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x04c8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x04ba A[Catch: all -> 0x067e, TryCatch #2 {all -> 0x067e, blocks: (B:19:0x0063, B:22:0x006d, B:26:0x0076, B:30:0x0089, B:32:0x0093, B:36:0x009b, B:37:0x00b9, B:41:0x01c1, B:44:0x01d4, B:60:0x01f3, B:62:0x0200, B:65:0x0207, B:300:0x020f, B:302:0x0221, B:305:0x022c, B:307:0x0235, B:309:0x0238, B:311:0x0242, B:315:0x0253, B:316:0x0259, B:318:0x0261, B:319:0x0266, B:325:0x0270, B:326:0x0277, B:327:0x0278, B:329:0x027f, B:331:0x0283, B:332:0x0286, B:334:0x028c, B:338:0x029a, B:71:0x02b0, B:74:0x02b8, B:76:0x02bf, B:78:0x02ce, B:80:0x02d6, B:83:0x02db, B:85:0x02df, B:86:0x0329, B:88:0x032d, B:92:0x0337, B:93:0x034f, B:96:0x02e2, B:98:0x02ea, B:100:0x02f0, B:101:0x02fc, B:104:0x0305, B:108:0x030b, B:111:0x0311, B:112:0x031d, B:113:0x0350, B:114:0x036c, B:117:0x0371, B:122:0x0382, B:124:0x0388, B:126:0x0394, B:127:0x039a, B:129:0x039f, B:131:0x0533, B:135:0x053d, B:138:0x0546, B:141:0x0559, B:146:0x0553, B:150:0x0565, B:153:0x0578, B:155:0x0581, B:158:0x0594, B:160:0x05dc, B:164:0x058e, B:167:0x059f, B:170:0x05b2, B:171:0x05ac, B:174:0x05bd, B:177:0x05d0, B:178:0x05ca, B:179:0x05d7, B:180:0x0572, B:181:0x05e6, B:182:0x05fe, B:183:0x03a3, B:188:0x03b3, B:193:0x03c2, B:196:0x03d9, B:198:0x03e2, B:202:0x03ef, B:203:0x03f2, B:205:0x03fc, B:206:0x0403, B:215:0x0407, B:212:0x0419, B:213:0x0431, B:219:0x0400, B:221:0x03d3, B:224:0x0436, B:227:0x0449, B:229:0x045a, B:232:0x046e, B:233:0x0474, B:236:0x047a, B:237:0x0484, B:239:0x048c, B:241:0x049e, B:244:0x04a6, B:245:0x04a8, B:247:0x04ad, B:249:0x04b6, B:251:0x04bf, B:252:0x04c2, B:260:0x04c8, B:262:0x04cf, B:257:0x04dc, B:258:0x04f4, B:266:0x04ba, B:271:0x0465, B:272:0x0443, B:275:0x04fb, B:277:0x0507, B:280:0x051a, B:282:0x0526, B:283:0x05ff, B:285:0x0610, B:286:0x0614, B:294:0x061d, B:291:0x0633, B:292:0x064b, B:347:0x01ce, B:348:0x01fc, B:408:0x00c1, B:411:0x00d2, B:415:0x00cc, B:353:0x00e5, B:355:0x00ef, B:356:0x00f2, B:360:0x00f7, B:361:0x010d, B:369:0x0120, B:371:0x0126, B:373:0x012b, B:375:0x0138, B:376:0x013c, B:380:0x0142, B:381:0x015c, B:382:0x0130, B:384:0x015d, B:385:0x0177, B:393:0x0181, B:396:0x0190, B:398:0x0196, B:399:0x01b4, B:400:0x01b5, B:402:0x064c, B:403:0x0664, B:405:0x0665, B:406:0x067d), top: B:18:0x0063, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x01fc A[Catch: all -> 0x067e, TryCatch #2 {all -> 0x067e, blocks: (B:19:0x0063, B:22:0x006d, B:26:0x0076, B:30:0x0089, B:32:0x0093, B:36:0x009b, B:37:0x00b9, B:41:0x01c1, B:44:0x01d4, B:60:0x01f3, B:62:0x0200, B:65:0x0207, B:300:0x020f, B:302:0x0221, B:305:0x022c, B:307:0x0235, B:309:0x0238, B:311:0x0242, B:315:0x0253, B:316:0x0259, B:318:0x0261, B:319:0x0266, B:325:0x0270, B:326:0x0277, B:327:0x0278, B:329:0x027f, B:331:0x0283, B:332:0x0286, B:334:0x028c, B:338:0x029a, B:71:0x02b0, B:74:0x02b8, B:76:0x02bf, B:78:0x02ce, B:80:0x02d6, B:83:0x02db, B:85:0x02df, B:86:0x0329, B:88:0x032d, B:92:0x0337, B:93:0x034f, B:96:0x02e2, B:98:0x02ea, B:100:0x02f0, B:101:0x02fc, B:104:0x0305, B:108:0x030b, B:111:0x0311, B:112:0x031d, B:113:0x0350, B:114:0x036c, B:117:0x0371, B:122:0x0382, B:124:0x0388, B:126:0x0394, B:127:0x039a, B:129:0x039f, B:131:0x0533, B:135:0x053d, B:138:0x0546, B:141:0x0559, B:146:0x0553, B:150:0x0565, B:153:0x0578, B:155:0x0581, B:158:0x0594, B:160:0x05dc, B:164:0x058e, B:167:0x059f, B:170:0x05b2, B:171:0x05ac, B:174:0x05bd, B:177:0x05d0, B:178:0x05ca, B:179:0x05d7, B:180:0x0572, B:181:0x05e6, B:182:0x05fe, B:183:0x03a3, B:188:0x03b3, B:193:0x03c2, B:196:0x03d9, B:198:0x03e2, B:202:0x03ef, B:203:0x03f2, B:205:0x03fc, B:206:0x0403, B:215:0x0407, B:212:0x0419, B:213:0x0431, B:219:0x0400, B:221:0x03d3, B:224:0x0436, B:227:0x0449, B:229:0x045a, B:232:0x046e, B:233:0x0474, B:236:0x047a, B:237:0x0484, B:239:0x048c, B:241:0x049e, B:244:0x04a6, B:245:0x04a8, B:247:0x04ad, B:249:0x04b6, B:251:0x04bf, B:252:0x04c2, B:260:0x04c8, B:262:0x04cf, B:257:0x04dc, B:258:0x04f4, B:266:0x04ba, B:271:0x0465, B:272:0x0443, B:275:0x04fb, B:277:0x0507, B:280:0x051a, B:282:0x0526, B:283:0x05ff, B:285:0x0610, B:286:0x0614, B:294:0x061d, B:291:0x0633, B:292:0x064b, B:347:0x01ce, B:348:0x01fc, B:408:0x00c1, B:411:0x00d2, B:415:0x00cc, B:353:0x00e5, B:355:0x00ef, B:356:0x00f2, B:360:0x00f7, B:361:0x010d, B:369:0x0120, B:371:0x0126, B:373:0x012b, B:375:0x0138, B:376:0x013c, B:380:0x0142, B:381:0x015c, B:382:0x0130, B:384:0x015d, B:385:0x0177, B:393:0x0181, B:396:0x0190, B:398:0x0196, B:399:0x01b4, B:400:0x01b5, B:402:0x064c, B:403:0x0664, B:405:0x0665, B:406:0x067d), top: B:18:0x0063, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01c1 A[Catch: all -> 0x067e, TryCatch #2 {all -> 0x067e, blocks: (B:19:0x0063, B:22:0x006d, B:26:0x0076, B:30:0x0089, B:32:0x0093, B:36:0x009b, B:37:0x00b9, B:41:0x01c1, B:44:0x01d4, B:60:0x01f3, B:62:0x0200, B:65:0x0207, B:300:0x020f, B:302:0x0221, B:305:0x022c, B:307:0x0235, B:309:0x0238, B:311:0x0242, B:315:0x0253, B:316:0x0259, B:318:0x0261, B:319:0x0266, B:325:0x0270, B:326:0x0277, B:327:0x0278, B:329:0x027f, B:331:0x0283, B:332:0x0286, B:334:0x028c, B:338:0x029a, B:71:0x02b0, B:74:0x02b8, B:76:0x02bf, B:78:0x02ce, B:80:0x02d6, B:83:0x02db, B:85:0x02df, B:86:0x0329, B:88:0x032d, B:92:0x0337, B:93:0x034f, B:96:0x02e2, B:98:0x02ea, B:100:0x02f0, B:101:0x02fc, B:104:0x0305, B:108:0x030b, B:111:0x0311, B:112:0x031d, B:113:0x0350, B:114:0x036c, B:117:0x0371, B:122:0x0382, B:124:0x0388, B:126:0x0394, B:127:0x039a, B:129:0x039f, B:131:0x0533, B:135:0x053d, B:138:0x0546, B:141:0x0559, B:146:0x0553, B:150:0x0565, B:153:0x0578, B:155:0x0581, B:158:0x0594, B:160:0x05dc, B:164:0x058e, B:167:0x059f, B:170:0x05b2, B:171:0x05ac, B:174:0x05bd, B:177:0x05d0, B:178:0x05ca, B:179:0x05d7, B:180:0x0572, B:181:0x05e6, B:182:0x05fe, B:183:0x03a3, B:188:0x03b3, B:193:0x03c2, B:196:0x03d9, B:198:0x03e2, B:202:0x03ef, B:203:0x03f2, B:205:0x03fc, B:206:0x0403, B:215:0x0407, B:212:0x0419, B:213:0x0431, B:219:0x0400, B:221:0x03d3, B:224:0x0436, B:227:0x0449, B:229:0x045a, B:232:0x046e, B:233:0x0474, B:236:0x047a, B:237:0x0484, B:239:0x048c, B:241:0x049e, B:244:0x04a6, B:245:0x04a8, B:247:0x04ad, B:249:0x04b6, B:251:0x04bf, B:252:0x04c2, B:260:0x04c8, B:262:0x04cf, B:257:0x04dc, B:258:0x04f4, B:266:0x04ba, B:271:0x0465, B:272:0x0443, B:275:0x04fb, B:277:0x0507, B:280:0x051a, B:282:0x0526, B:283:0x05ff, B:285:0x0610, B:286:0x0614, B:294:0x061d, B:291:0x0633, B:292:0x064b, B:347:0x01ce, B:348:0x01fc, B:408:0x00c1, B:411:0x00d2, B:415:0x00cc, B:353:0x00e5, B:355:0x00ef, B:356:0x00f2, B:360:0x00f7, B:361:0x010d, B:369:0x0120, B:371:0x0126, B:373:0x012b, B:375:0x0138, B:376:0x013c, B:380:0x0142, B:381:0x015c, B:382:0x0130, B:384:0x015d, B:385:0x0177, B:393:0x0181, B:396:0x0190, B:398:0x0196, B:399:0x01b4, B:400:0x01b5, B:402:0x064c, B:403:0x0664, B:405:0x0665, B:406:0x067d), top: B:18:0x0063, inners: #0, #1 }] */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.alibaba.security.common.json.parser.DefaultJSONParser] */
    /* JADX WARN: Type inference failed for: r5v90, types: [java.util.Date] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object parseObject(java.util.Map r20, java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 1668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.parser.DefaultJSONParser.parseObject(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public String parseString() {
        JSONLexer jSONLexer = this.lexer;
        int i10 = jSONLexer.token;
        if (i10 != 4) {
            if (i10 == 2) {
                String numberString = jSONLexer.numberString();
                this.lexer.nextToken(16);
                return numberString;
            }
            Object parse = parse();
            if (parse == null) {
                return null;
            }
            return parse.toString();
        }
        String stringVal = jSONLexer.stringVal();
        JSONLexer jSONLexer2 = this.lexer;
        char c4 = jSONLexer2.ch;
        if (c4 == ',') {
            int i11 = jSONLexer2.bp + 1;
            jSONLexer2.bp = i11;
            jSONLexer2.ch = i11 < jSONLexer2.len ? jSONLexer2.text.charAt(i11) : (char) 26;
            this.lexer.token = 16;
        } else if (c4 == ']') {
            int i12 = jSONLexer2.bp + 1;
            jSONLexer2.bp = i12;
            jSONLexer2.ch = i12 < jSONLexer2.len ? jSONLexer2.text.charAt(i12) : (char) 26;
            this.lexer.token = 15;
        } else if (c4 == '}') {
            int i13 = jSONLexer2.bp + 1;
            jSONLexer2.bp = i13;
            jSONLexer2.ch = i13 < jSONLexer2.len ? jSONLexer2.text.charAt(i13) : (char) 26;
            this.lexer.token = 13;
        } else {
            jSONLexer2.nextToken();
        }
        return stringVal;
    }

    public void popContext() {
        this.contex = this.contex.parent;
        ParseContext[] parseContextArr = this.contextArray;
        int i10 = this.contextArrayIndex;
        parseContextArr[i10 - 1] = null;
        this.contextArrayIndex = i10 - 1;
    }

    public void setContext(ParseContext parseContext) {
        if (this.lexer.disableCircularReferenceDetect) {
            return;
        }
        this.contex = parseContext;
    }

    public void setDateFomrat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(new JSONLexer(str, RPJSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i10 = jSONLexer.token;
        if (i10 == 2) {
            Number integerValue = jSONLexer.integerValue();
            this.lexer.nextToken();
            return integerValue;
        }
        if (i10 == 3) {
            Number decimalValue = jSONLexer.decimalValue((jSONLexer.features & Feature.UseBigDecimal.mask) != 0);
            this.lexer.nextToken();
            return decimalValue;
        }
        if (i10 == 4) {
            String stringVal = jSONLexer.stringVal();
            this.lexer.nextToken(16);
            if ((this.lexer.features & Feature.AllowISO8601DateFormat.mask) != 0) {
                JSONLexer jSONLexer2 = new JSONLexer(stringVal);
                try {
                    if (jSONLexer2.scanISO8601DateIfMatch(true)) {
                        return jSONLexer2.calendar.getTime();
                    }
                } finally {
                    jSONLexer2.close();
                }
            }
            return stringVal;
        }
        if (i10 == 12) {
            return parseObject((jSONLexer.features & Feature.OrderedField.mask) != 0 ? new RPJSONObject(new LinkedHashMap()) : new RPJSONObject(), obj);
        }
        if (i10 != 14) {
            switch (i10) {
                case 6:
                    jSONLexer.nextToken(16);
                    return Boolean.TRUE;
                case 7:
                    jSONLexer.nextToken(16);
                    return Boolean.FALSE;
                case 8:
                    break;
                case 9:
                    jSONLexer.nextToken(18);
                    JSONLexer jSONLexer3 = this.lexer;
                    if (jSONLexer3.token == 18) {
                        jSONLexer3.nextToken(10);
                        accept(10);
                        long longValue = this.lexer.integerValue().longValue();
                        accept(2);
                        accept(11);
                        return new Date(longValue);
                    }
                    throw new RPJSONException("syntax error, " + this.lexer.info());
                default:
                    switch (i10) {
                        case 20:
                            if (jSONLexer.isBlankInput()) {
                                return null;
                            }
                            throw new RPJSONException("syntax error, " + this.lexer.info());
                        case 21:
                            jSONLexer.nextToken();
                            HashSet hashSet = new HashSet();
                            parseArray(hashSet, obj);
                            return hashSet;
                        case 22:
                            jSONLexer.nextToken();
                            TreeSet treeSet = new TreeSet();
                            parseArray(treeSet, obj);
                            return treeSet;
                        case 23:
                            break;
                        default:
                            throw new RPJSONException("syntax error, " + this.lexer.info());
                    }
            }
            jSONLexer.nextToken();
            return null;
        }
        RPJSONArray rPJSONArray = new RPJSONArray();
        parseArray(rPJSONArray, obj);
        return rPJSONArray;
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i10) {
        this(new JSONLexer(str, i10), parserConfig);
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.disableCircularReferenceDetect) {
            return null;
        }
        this.contex = new ParseContext(parseContext, obj, obj2);
        int i10 = this.contextArrayIndex;
        this.contextArrayIndex = i10 + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i10 >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[(parseContextArr.length * 3) / 2];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        ParseContext[] parseContextArr3 = this.contextArray;
        ParseContext parseContext2 = this.contex;
        parseContextArr3[i10] = parseContext2;
        return parseContext2;
    }

    public DefaultJSONParser(char[] cArr, int i10, ParserConfig parserConfig, int i11) {
        this(new JSONLexer(cArr, i10, i11), parserConfig);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.global);
    }

    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer deserializer;
        String str;
        JSONLexer jSONLexer = this.lexer;
        int i10 = jSONLexer.token;
        if (i10 == 21 || i10 == 22) {
            jSONLexer.nextToken();
        }
        JSONLexer jSONLexer2 = this.lexer;
        if (jSONLexer2.token == 14) {
            if (Integer.TYPE != type) {
                if (String.class == type) {
                    deserializer = StringCodec.instance;
                    jSONLexer2.nextToken(4);
                } else {
                    deserializer = this.config.getDeserializer(type);
                    this.lexer.nextToken(12);
                }
            } else {
                deserializer = IntegerCodec.instance;
                jSONLexer2.nextToken(2);
            }
            ParseContext parseContext = this.contex;
            if (!this.lexer.disableCircularReferenceDetect) {
                setContext(parseContext, collection, obj);
            }
            int i11 = 0;
            while (true) {
                try {
                    JSONLexer jSONLexer3 = this.lexer;
                    int i12 = jSONLexer3.token;
                    if (i12 == 16) {
                        jSONLexer3.nextToken();
                    } else {
                        if (i12 == 15) {
                            this.contex = parseContext;
                            jSONLexer3.nextToken(16);
                            return;
                        }
                        Object obj2 = null;
                        String obj3 = null;
                        if (Integer.TYPE != type) {
                            if (String.class == type) {
                                if (i12 == 4) {
                                    str = jSONLexer3.stringVal();
                                    this.lexer.nextToken(16);
                                } else {
                                    Object parse = parse();
                                    if (parse != null) {
                                        obj3 = parse.toString();
                                    }
                                    str = obj3;
                                }
                                collection.add(str);
                            } else {
                                if (i12 == 8) {
                                    jSONLexer3.nextToken();
                                } else {
                                    obj2 = deserializer.deserialze(this, type, Integer.valueOf(i11));
                                }
                                collection.add(obj2);
                                if (this.resolveStatus == 1) {
                                    checkListResolve(collection);
                                }
                            }
                        } else {
                            collection.add(IntegerCodec.instance.deserialze(this, null, null));
                        }
                        JSONLexer jSONLexer4 = this.lexer;
                        if (jSONLexer4.token == 16) {
                            jSONLexer4.nextToken();
                        }
                        i11++;
                    }
                } catch (Throwable th) {
                    this.contex = parseContext;
                    throw th;
                }
            }
        } else {
            throw new RPJSONException("exepct '[', but " + JSONToken.name(this.lexer.token) + ", " + this.lexer.info());
        }
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = RPJSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.lexer = jSONLexer;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char c4 = jSONLexer.ch;
        if (c4 == '{') {
            int i10 = jSONLexer.bp + 1;
            jSONLexer.bp = i10;
            jSONLexer.ch = i10 < jSONLexer.len ? jSONLexer.text.charAt(i10) : (char) 26;
            jSONLexer.token = 12;
            return;
        }
        if (c4 == '[') {
            int i11 = jSONLexer.bp + 1;
            jSONLexer.bp = i11;
            jSONLexer.ch = i11 < jSONLexer.len ? jSONLexer.text.charAt(i11) : (char) 26;
            jSONLexer.token = 14;
            return;
        }
        jSONLexer.nextToken();
    }

    public Object[] parseArray(Type[] typeArr) {
        Object cast;
        Class<?> cls;
        boolean z10;
        int i10;
        JSONLexer jSONLexer = this.lexer;
        int i11 = jSONLexer.token;
        int i12 = 8;
        if (i11 == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        if (i11 == 14) {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                jSONLexer.nextToken(15);
                JSONLexer jSONLexer2 = this.lexer;
                if (jSONLexer2.token == 15) {
                    jSONLexer2.nextToken(16);
                    return new Object[0];
                }
                throw new RPJSONException("syntax error, " + this.lexer.info());
            }
            jSONLexer.nextToken(2);
            int i13 = 0;
            while (i13 < typeArr.length) {
                JSONLexer jSONLexer3 = this.lexer;
                int i14 = jSONLexer3.token;
                if (i14 == i12) {
                    jSONLexer3.nextToken(16);
                    cast = null;
                } else {
                    Type type = typeArr[i13];
                    if (type == Integer.TYPE || type == Integer.class) {
                        if (i14 == 2) {
                            cast = Integer.valueOf(jSONLexer3.intValue());
                            this.lexer.nextToken(16);
                        } else {
                            cast = RPTypeUtils.cast(parse(), type, this.config);
                        }
                    } else if (type != String.class) {
                        if (i13 == typeArr.length - 1 && (type instanceof Class)) {
                            Class cls2 = (Class) type;
                            z10 = cls2.isArray();
                            cls = cls2.getComponentType();
                        } else {
                            cls = null;
                            z10 = false;
                        }
                        if (z10 && this.lexer.token != 14) {
                            ArrayList arrayList = new ArrayList();
                            ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                            if (this.lexer.token != 15) {
                                while (true) {
                                    arrayList.add(deserializer.deserialze(this, type, null));
                                    JSONLexer jSONLexer4 = this.lexer;
                                    i10 = jSONLexer4.token;
                                    if (i10 != 16) {
                                        break;
                                    }
                                    jSONLexer4.nextToken(12);
                                }
                                if (i10 != 15) {
                                    throw new RPJSONException("syntax error, " + this.lexer.info());
                                }
                            }
                            cast = RPTypeUtils.cast(arrayList, type, this.config);
                        } else {
                            cast = this.config.getDeserializer(type).deserialze(this, type, null);
                        }
                    } else if (i14 == 4) {
                        cast = jSONLexer3.stringVal();
                        this.lexer.nextToken(16);
                    } else {
                        cast = RPTypeUtils.cast(parse(), type, this.config);
                    }
                }
                objArr[i13] = cast;
                JSONLexer jSONLexer5 = this.lexer;
                int i15 = jSONLexer5.token;
                if (i15 == 15) {
                    break;
                }
                if (i15 == 16) {
                    if (i13 == typeArr.length - 1) {
                        jSONLexer5.nextToken(15);
                    } else {
                        jSONLexer5.nextToken(2);
                    }
                    i13++;
                    i12 = 8;
                } else {
                    throw new RPJSONException("syntax error, " + this.lexer.info());
                }
            }
            JSONLexer jSONLexer6 = this.lexer;
            if (jSONLexer6.token == 15) {
                jSONLexer6.nextToken(16);
                return objArr;
            }
            throw new RPJSONException("syntax error, " + this.lexer.info());
        }
        throw new RPJSONException("syntax error, " + this.lexer.info());
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x022e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01d6 A[Catch: all -> 0x0236, TryCatch #0 {all -> 0x0236, blocks: (B:11:0x0028, B:14:0x003c, B:21:0x004b, B:24:0x005d, B:28:0x007b, B:30:0x0081, B:32:0x008d, B:35:0x009f, B:37:0x00a8, B:42:0x00b0, B:43:0x0099, B:47:0x00b9, B:50:0x00cb, B:52:0x00d4, B:53:0x00d7, B:58:0x00c5, B:45:0x00e1, B:59:0x00e4, B:61:0x00ea, B:83:0x0119, B:85:0x01e4, B:87:0x01eb, B:88:0x01ee, B:90:0x01f4, B:92:0x01f8, B:98:0x0208, B:102:0x0214, B:105:0x0228, B:107:0x0222, B:108:0x022b, B:112:0x0121, B:117:0x012b, B:118:0x0138, B:120:0x0140, B:121:0x0147, B:122:0x0148, B:124:0x0155, B:125:0x0165, B:126:0x0160, B:127:0x016e, B:128:0x0176, B:129:0x0180, B:130:0x018a, B:132:0x01a2, B:134:0x01ad, B:135:0x01b3, B:136:0x01b8, B:138:0x01c5, B:139:0x01d0, B:140:0x01cb, B:141:0x01d6, B:142:0x0057, B:143:0x0064, B:144:0x0069, B:147:0x0074), top: B:10:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b A[Catch: all -> 0x0236, TryCatch #0 {all -> 0x0236, blocks: (B:11:0x0028, B:14:0x003c, B:21:0x004b, B:24:0x005d, B:28:0x007b, B:30:0x0081, B:32:0x008d, B:35:0x009f, B:37:0x00a8, B:42:0x00b0, B:43:0x0099, B:47:0x00b9, B:50:0x00cb, B:52:0x00d4, B:53:0x00d7, B:58:0x00c5, B:45:0x00e1, B:59:0x00e4, B:61:0x00ea, B:83:0x0119, B:85:0x01e4, B:87:0x01eb, B:88:0x01ee, B:90:0x01f4, B:92:0x01f8, B:98:0x0208, B:102:0x0214, B:105:0x0228, B:107:0x0222, B:108:0x022b, B:112:0x0121, B:117:0x012b, B:118:0x0138, B:120:0x0140, B:121:0x0147, B:122:0x0148, B:124:0x0155, B:125:0x0165, B:126:0x0160, B:127:0x016e, B:128:0x0176, B:129:0x0180, B:130:0x018a, B:132:0x01a2, B:134:0x01ad, B:135:0x01b3, B:136:0x01b8, B:138:0x01c5, B:139:0x01d0, B:140:0x01cb, B:141:0x01d6, B:142:0x0057, B:143:0x0064, B:144:0x0069, B:147:0x0074), top: B:10:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ea A[Catch: all -> 0x0236, LOOP:1: B:60:0x00e8->B:61:0x00ea, LOOP_END, TryCatch #0 {all -> 0x0236, blocks: (B:11:0x0028, B:14:0x003c, B:21:0x004b, B:24:0x005d, B:28:0x007b, B:30:0x0081, B:32:0x008d, B:35:0x009f, B:37:0x00a8, B:42:0x00b0, B:43:0x0099, B:47:0x00b9, B:50:0x00cb, B:52:0x00d4, B:53:0x00d7, B:58:0x00c5, B:45:0x00e1, B:59:0x00e4, B:61:0x00ea, B:83:0x0119, B:85:0x01e4, B:87:0x01eb, B:88:0x01ee, B:90:0x01f4, B:92:0x01f8, B:98:0x0208, B:102:0x0214, B:105:0x0228, B:107:0x0222, B:108:0x022b, B:112:0x0121, B:117:0x012b, B:118:0x0138, B:120:0x0140, B:121:0x0147, B:122:0x0148, B:124:0x0155, B:125:0x0165, B:126:0x0160, B:127:0x016e, B:128:0x0176, B:129:0x0180, B:130:0x018a, B:132:0x01a2, B:134:0x01ad, B:135:0x01b3, B:136:0x01b8, B:138:0x01c5, B:139:0x01d0, B:140:0x01cb, B:141:0x01d6, B:142:0x0057, B:143:0x0064, B:144:0x0069, B:147:0x0074), top: B:10:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01eb A[Catch: all -> 0x0236, TryCatch #0 {all -> 0x0236, blocks: (B:11:0x0028, B:14:0x003c, B:21:0x004b, B:24:0x005d, B:28:0x007b, B:30:0x0081, B:32:0x008d, B:35:0x009f, B:37:0x00a8, B:42:0x00b0, B:43:0x0099, B:47:0x00b9, B:50:0x00cb, B:52:0x00d4, B:53:0x00d7, B:58:0x00c5, B:45:0x00e1, B:59:0x00e4, B:61:0x00ea, B:83:0x0119, B:85:0x01e4, B:87:0x01eb, B:88:0x01ee, B:90:0x01f4, B:92:0x01f8, B:98:0x0208, B:102:0x0214, B:105:0x0228, B:107:0x0222, B:108:0x022b, B:112:0x0121, B:117:0x012b, B:118:0x0138, B:120:0x0140, B:121:0x0147, B:122:0x0148, B:124:0x0155, B:125:0x0165, B:126:0x0160, B:127:0x016e, B:128:0x0176, B:129:0x0180, B:130:0x018a, B:132:0x01a2, B:134:0x01ad, B:135:0x01b3, B:136:0x01b8, B:138:0x01c5, B:139:0x01d0, B:140:0x01cb, B:141:0x01d6, B:142:0x0057, B:143:0x0064, B:144:0x0069, B:147:0x0074), top: B:10:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01f4 A[Catch: all -> 0x0236, TryCatch #0 {all -> 0x0236, blocks: (B:11:0x0028, B:14:0x003c, B:21:0x004b, B:24:0x005d, B:28:0x007b, B:30:0x0081, B:32:0x008d, B:35:0x009f, B:37:0x00a8, B:42:0x00b0, B:43:0x0099, B:47:0x00b9, B:50:0x00cb, B:52:0x00d4, B:53:0x00d7, B:58:0x00c5, B:45:0x00e1, B:59:0x00e4, B:61:0x00ea, B:83:0x0119, B:85:0x01e4, B:87:0x01eb, B:88:0x01ee, B:90:0x01f4, B:92:0x01f8, B:98:0x0208, B:102:0x0214, B:105:0x0228, B:107:0x0222, B:108:0x022b, B:112:0x0121, B:117:0x012b, B:118:0x0138, B:120:0x0140, B:121:0x0147, B:122:0x0148, B:124:0x0155, B:125:0x0165, B:126:0x0160, B:127:0x016e, B:128:0x0176, B:129:0x0180, B:130:0x018a, B:132:0x01a2, B:134:0x01ad, B:135:0x01b3, B:136:0x01b8, B:138:0x01c5, B:139:0x01d0, B:140:0x01cb, B:141:0x01d6, B:142:0x0057, B:143:0x0064, B:144:0x0069, B:147:0x0074), top: B:10:0x0028 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void parseArray(java.util.Collection r17, java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 611
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.parser.DefaultJSONParser.parseArray(java.util.Collection, java.lang.Object):void");
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject(cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return (T) parseObject(type, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T parseObject(Type type, Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i10 = jSONLexer.token;
        if (i10 == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (i10 == 4) {
            if (type == byte[].class) {
                T t2 = (T) jSONLexer.bytesValue();
                this.lexer.nextToken();
                return t2;
            }
            if (type == char[].class) {
                String stringVal = jSONLexer.stringVal();
                this.lexer.nextToken();
                return (T) stringVal.toCharArray();
            }
        }
        try {
            return (T) this.config.getDeserializer(type).deserialze(this, type, obj);
        } catch (RPJSONException e2) {
            throw e2;
        } catch (Exception e10) {
            throw new RPJSONException(e10.getMessage(), e10);
        }
    }

    public void parseObject(Object obj) {
        Object deserialze;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        int i10 = this.lexer.token;
        if (i10 != 12 && i10 != 16) {
            throw new RPJSONException("syntax error, expect {, actual " + JSONToken.name(i10));
        }
        while (true) {
            String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
            if (scanSymbol == null) {
                JSONLexer jSONLexer = this.lexer;
                int i11 = jSONLexer.token;
                if (i11 == 13) {
                    jSONLexer.nextToken(16);
                    return;
                } else if (i11 == 16) {
                    continue;
                }
            }
            FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
            if (fieldDeserializer == null) {
                JSONLexer jSONLexer2 = this.lexer;
                if ((jSONLexer2.features & Feature.IgnoreNotMatch.mask) != 0) {
                    jSONLexer2.nextTokenWithChar(ShortcutConstants.SERVICES_SEPARATOR);
                    parse();
                    JSONLexer jSONLexer3 = this.lexer;
                    if (jSONLexer3.token == 13) {
                        jSONLexer3.nextToken();
                        return;
                    }
                } else {
                    throw new RPJSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
                }
            } else {
                RPFieldInfo rPFieldInfo = fieldDeserializer.fieldInfo;
                Class<?> cls2 = rPFieldInfo.fieldClass;
                Type type = rPFieldInfo.fieldType;
                if (cls2 == Integer.TYPE) {
                    this.lexer.nextTokenWithChar(ShortcutConstants.SERVICES_SEPARATOR);
                    deserialze = IntegerCodec.instance.deserialze(this, type, null);
                } else if (cls2 == String.class) {
                    this.lexer.nextTokenWithChar(ShortcutConstants.SERVICES_SEPARATOR);
                    deserialze = parseString();
                } else if (cls2 == Long.TYPE) {
                    this.lexer.nextTokenWithChar(ShortcutConstants.SERVICES_SEPARATOR);
                    deserialze = IntegerCodec.instance.deserialze(this, type, null);
                } else {
                    ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                    this.lexer.nextTokenWithChar(ShortcutConstants.SERVICES_SEPARATOR);
                    deserialze = deserializer2.deserialze(this, type, null);
                }
                fieldDeserializer.setValue(obj, deserialze);
                JSONLexer jSONLexer4 = this.lexer;
                int i12 = jSONLexer4.token;
                if (i12 != 16 && i12 == 13) {
                    jSONLexer4.nextToken(16);
                    return;
                }
            }
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public RPJSONObject parseObject() {
        return (RPJSONObject) parseObject((this.lexer.features & Feature.OrderedField.mask) != 0 ? new RPJSONObject(new LinkedHashMap()) : new RPJSONObject(), (Object) null);
    }
}
