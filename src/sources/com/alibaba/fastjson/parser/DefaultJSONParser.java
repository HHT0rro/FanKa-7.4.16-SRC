package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONPathException;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    private static final Set<Class<?>> primitiveClasses = new HashSet();
    private String[] autoTypeAccept;
    private boolean autoTypeEnable;
    public ParserConfig config;
    public ParseContext context;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private List<ExtraProcessor> extraProcessors;
    private List<ExtraTypeProvider> extraTypeProviders;
    public FieldTypeResolver fieldTypeResolver;
    public final Object input;
    public transient BeanContext lastBeanContext;
    public final JSONLexer lexer;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ResolveTask {
        public final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        public final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    static {
        Class<?>[] clsArr = {Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class};
        for (int i10 = 0; i10 < 17; i10++) {
            primitiveClasses.add(clsArr[i10]);
        }
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
    }

    private void addContext(ParseContext parseContext) {
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
        this.contextArray[i10] = parseContext;
    }

    public final void accept(int i10) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i10) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i10) + ", actual " + JSONToken.name(jSONLexer.token()));
    }

    public void acceptType(String str) {
        JSONLexer jSONLexer = this.lexer;
        jSONLexer.nextTokenWithColon();
        if (jSONLexer.token() == 4) {
            if (str.equals(jSONLexer.stringVal())) {
                jSONLexer.nextToken();
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken();
                    return;
                }
                return;
            }
            throw new JSONException("type not match error");
        }
        throw new JSONException("type not match error");
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public void checkListResolve(Collection collection) {
        if (this.resolveStatus == 1) {
            if (collection instanceof List) {
                int size = collection.size() - 1;
                ResolveTask lastResolveTask = getLastResolveTask();
                lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, size);
                lastResolveTask.ownerContext = this.context;
                setResolveStatus(0);
                return;
            }
            ResolveTask lastResolveTask2 = getLastResolveTask();
            lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(collection);
            lastResolveTask2.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    public void checkMapResolve(Map map, Object obj) {
        if (this.resolveStatus == 1) {
            ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
            lastResolveTask.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        JSONLexer jSONLexer = this.lexer;
        try {
            if (jSONLexer.isEnabled(Feature.AutoCloseSource) && jSONLexer.token() != 20) {
                throw new JSONException("not close json text, token : " + JSONToken.name(jSONLexer.token()));
            }
        } finally {
            jSONLexer.close();
        }
    }

    public void config(Feature feature, boolean z10) {
        this.lexer.config(feature, z10);
    }

    public ParserConfig getConfig() {
        return this.config;
    }

    public ParseContext getContext() {
        return this.context;
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.getTimeZone());
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

    public FieldTypeResolver getFieldTypeResolver() {
        return this.fieldTypeResolver;
    }

    public String getInput() {
        Object obj = this.input;
        if (obj instanceof char[]) {
            return new String((char[]) obj);
        }
        return obj.toString();
    }

    public ResolveTask getLastResolveTask() {
        return this.resolveTaskList.get(r0.size() - 1);
    }

    public JSONLexer getLexer() {
        return this.lexer;
    }

    public Object getObject(String str) {
        for (int i10 = 0; i10 < this.contextArrayIndex; i10++) {
            if (str.equals(this.contextArray[i10].toString())) {
                return this.contextArray[i10].object;
            }
        }
        return null;
    }

    public int getResolveStatus() {
        return this.resolveStatus;
    }

    public List<ResolveTask> getResolveTaskList() {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        return this.resolveTaskList;
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public void handleResovleTask(Object obj) {
        Object obj2;
        FieldInfo fieldInfo;
        List<ResolveTask> list = this.resolveTaskList;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            ResolveTask resolveTask = this.resolveTaskList.get(i10);
            String str = resolveTask.referenceValue;
            ParseContext parseContext = resolveTask.ownerContext;
            Object obj3 = parseContext != null ? parseContext.object : null;
            if (str.startsWith("$")) {
                obj2 = getObject(str);
                if (obj2 == null) {
                    try {
                        obj2 = JSONPath.eval(obj, str);
                    } catch (JSONPathException unused) {
                    }
                }
            } else {
                obj2 = resolveTask.context.object;
            }
            FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
            if (fieldDeserializer != null) {
                if (obj2 != null && obj2.getClass() == JSONObject.class && (fieldInfo = fieldDeserializer.fieldInfo) != null && !Map.class.isAssignableFrom(fieldInfo.fieldClass)) {
                    obj2 = JSONPath.eval(this.contextArray[0].object, str);
                }
                fieldDeserializer.setValue(obj3, obj2);
            }
        }
    }

    public boolean isEnabled(Feature feature) {
        return this.lexer.isEnabled(feature);
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
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
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
                    throw new JSONException("not support type : " + ((Object) type));
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
                    throw new JSONException("not support : " + ((Object) typeVariable));
                }
            }
            if (type2 instanceof ParameterizedType) {
                ArrayList arrayList4 = new ArrayList();
                parseArray((ParameterizedType) type2, arrayList4);
                return arrayList4;
            }
            throw new JSONException("TODO : " + ((Object) type));
        }
        throw new JSONException("not support type " + ((Object) type));
    }

    public void parseExtra(Object obj, String str) {
        Object parseObject;
        this.lexer.nextTokenWithColon();
        List<ExtraTypeProvider> list = this.extraTypeProviders;
        Type type = null;
        if (list != null) {
            Iterator<ExtraTypeProvider> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                type = iterator2.next().getExtraType(obj, str);
            }
        }
        if (type == null) {
            parseObject = parse();
        } else {
            parseObject = parseObject(type);
        }
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).processExtra(str, parseObject);
            return;
        }
        List<ExtraProcessor> list2 = this.extraProcessors;
        if (list2 != null) {
            Iterator<ExtraProcessor> iterator22 = list2.iterator2();
            while (iterator22.hasNext()) {
                iterator22.next().processExtra(obj, str, parseObject);
            }
        }
        if (this.resolveStatus == 1) {
            this.resolveStatus = 0;
        }
    }

    public Object parseKey() {
        if (this.lexer.token() == 18) {
            String stringVal = this.lexer.stringVal();
            this.lexer.nextToken(16);
            return stringVal;
        }
        return parse(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x032c, code lost:
    
        if (r3 == com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.class) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x032e, code lost:
    
        setResolveStatus(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0342, code lost:
    
        return r0.deserialze(r18, r8, r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0335, code lost:
    
        if ((r0 instanceof com.alibaba.fastjson.parser.deserializer.MapDeserializer) == false) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0337, code lost:
    
        setResolveStatus(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0288, code lost:
    
        r5.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0293, code lost:
    
        if (r5.token() != 13) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0295, code lost:
    
        r5.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x02a0, code lost:
    
        if ((r18.config.getDeserializer(r8) instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x02a2, code lost:
    
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r19, (java.lang.Class<java.lang.Object>) r8, r18.config);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x02aa, code lost:
    
        if (r0 != null) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x02ae, code lost:
    
        if (r8 != java.lang.Cloneable.class) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x02b0, code lost:
    
        r0 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x02bc, code lost:
    
        if ("java.util.Collections$EmptyMap".equals(r7) == false) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x02be, code lost:
    
        r0 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x02c9, code lost:
    
        if ("java.util.Collections$UnmodifiableMap".equals(r7) == false) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x02cb, code lost:
    
        r0 = java.util.Collections.unmodifiableMap(new java.util.HashMap());
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02d5, code lost:
    
        r0 = r8.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x02dc, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x02a9, code lost:
    
        r0 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x02dd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x02e5, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x02e6, code lost:
    
        setResolveStatus(2);
        r3 = r18.context;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02ec, code lost:
    
        if (r3 == null) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02ee, code lost:
    
        if (r20 == null) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02f2, code lost:
    
        if ((r20 instanceof java.lang.Integer) != false) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x02f8, code lost:
    
        if ((r3.fieldName instanceof java.lang.Integer) != false) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02fa, code lost:
    
        popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0301, code lost:
    
        if (r19.size() <= 0) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0303, code lost:
    
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r19, (java.lang.Class<java.lang.Object>) r8, r18.config);
        setResolveStatus(0);
        parseObject(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0313, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0314, code lost:
    
        r0 = r18.config.getDeserializer(r8);
        r3 = r0.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0324, code lost:
    
        if (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class.isAssignableFrom(r3) == false) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0328, code lost:
    
        if (r3 == com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class) goto L184;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0431 A[Catch: all -> 0x065f, TryCatch #2 {all -> 0x065f, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0082, B:31:0x0095, B:35:0x00aa, B:39:0x0211, B:40:0x0217, B:42:0x0222, B:45:0x022a, B:52:0x0240, B:54:0x024e, B:56:0x0282, B:58:0x0288, B:60:0x0295, B:62:0x0298, B:64:0x02a2, B:68:0x02b0, B:69:0x02b6, B:71:0x02be, B:72:0x02c3, B:74:0x02cb, B:75:0x02d5, B:80:0x02de, B:81:0x02e5, B:82:0x02e6, B:85:0x02f0, B:87:0x02f4, B:89:0x02fa, B:90:0x02fd, B:92:0x0303, B:95:0x0314, B:101:0x032e, B:102:0x033b, B:105:0x0333, B:107:0x0337, B:109:0x0255, B:111:0x025b, B:115:0x0268, B:120:0x0272, B:129:0x034a, B:268:0x0352, B:270:0x035c, B:272:0x036d, B:274:0x0378, B:276:0x0380, B:278:0x0384, B:280:0x038a, B:283:0x038f, B:285:0x0393, B:286:0x03e1, B:288:0x03e9, B:291:0x03f2, B:292:0x040c, B:295:0x0398, B:297:0x03a0, B:300:0x03a6, B:301:0x03b3, B:304:0x03bc, B:308:0x03c2, B:311:0x03c7, B:312:0x03d4, B:314:0x040d, B:315:0x042b, B:134:0x0431, B:136:0x0435, B:138:0x0439, B:141:0x043f, B:145:0x0447, B:151:0x0457, B:153:0x0466, B:155:0x0471, B:156:0x0479, B:157:0x047c, B:158:0x04a8, B:160:0x04b3, B:167:0x04c0, B:170:0x04d0, B:171:0x04f0, B:176:0x048c, B:178:0x0496, B:179:0x04a5, B:180:0x049b, B:185:0x04f5, B:187:0x04ff, B:189:0x0505, B:190:0x0508, B:192:0x0513, B:193:0x0517, B:202:0x0522, B:195:0x0529, B:199:0x0532, B:200:0x0537, B:207:0x053c, B:209:0x0541, B:212:0x054a, B:214:0x0552, B:216:0x0567, B:218:0x0586, B:219:0x058c, B:222:0x0592, B:223:0x0598, B:225:0x05a0, B:227:0x05b1, B:230:0x05b9, B:232:0x05bd, B:233:0x05c4, B:235:0x05c9, B:236:0x05cc, B:247:0x05d4, B:238:0x05de, B:241:0x05e8, B:242:0x05ed, B:244:0x05f2, B:245:0x060c, B:253:0x0572, B:254:0x0579, B:256:0x060d, B:264:0x061f, B:258:0x0626, B:261:0x0632, B:262:0x0652, B:319:0x00be, B:320:0x00dc, B:391:0x00e1, B:393:0x00ec, B:395:0x00f0, B:397:0x00f4, B:400:0x00fa, B:325:0x0109, B:327:0x0111, B:331:0x0123, B:332:0x013b, B:334:0x013c, B:335:0x0141, B:344:0x0156, B:346:0x015c, B:348:0x0163, B:349:0x016e, B:354:0x0180, B:358:0x018a, B:359:0x01a2, B:360:0x017b, B:361:0x0168, B:363:0x01a3, B:364:0x01bb, B:372:0x01c5, B:374:0x01cd, B:378:0x01e0, B:379:0x0200, B:381:0x0201, B:382:0x0206, B:383:0x0207, B:385:0x0653, B:386:0x0658, B:388:0x0659, B:389:0x065e), top: B:23:0x0074, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0457 A[Catch: all -> 0x065f, TryCatch #2 {all -> 0x065f, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0082, B:31:0x0095, B:35:0x00aa, B:39:0x0211, B:40:0x0217, B:42:0x0222, B:45:0x022a, B:52:0x0240, B:54:0x024e, B:56:0x0282, B:58:0x0288, B:60:0x0295, B:62:0x0298, B:64:0x02a2, B:68:0x02b0, B:69:0x02b6, B:71:0x02be, B:72:0x02c3, B:74:0x02cb, B:75:0x02d5, B:80:0x02de, B:81:0x02e5, B:82:0x02e6, B:85:0x02f0, B:87:0x02f4, B:89:0x02fa, B:90:0x02fd, B:92:0x0303, B:95:0x0314, B:101:0x032e, B:102:0x033b, B:105:0x0333, B:107:0x0337, B:109:0x0255, B:111:0x025b, B:115:0x0268, B:120:0x0272, B:129:0x034a, B:268:0x0352, B:270:0x035c, B:272:0x036d, B:274:0x0378, B:276:0x0380, B:278:0x0384, B:280:0x038a, B:283:0x038f, B:285:0x0393, B:286:0x03e1, B:288:0x03e9, B:291:0x03f2, B:292:0x040c, B:295:0x0398, B:297:0x03a0, B:300:0x03a6, B:301:0x03b3, B:304:0x03bc, B:308:0x03c2, B:311:0x03c7, B:312:0x03d4, B:314:0x040d, B:315:0x042b, B:134:0x0431, B:136:0x0435, B:138:0x0439, B:141:0x043f, B:145:0x0447, B:151:0x0457, B:153:0x0466, B:155:0x0471, B:156:0x0479, B:157:0x047c, B:158:0x04a8, B:160:0x04b3, B:167:0x04c0, B:170:0x04d0, B:171:0x04f0, B:176:0x048c, B:178:0x0496, B:179:0x04a5, B:180:0x049b, B:185:0x04f5, B:187:0x04ff, B:189:0x0505, B:190:0x0508, B:192:0x0513, B:193:0x0517, B:202:0x0522, B:195:0x0529, B:199:0x0532, B:200:0x0537, B:207:0x053c, B:209:0x0541, B:212:0x054a, B:214:0x0552, B:216:0x0567, B:218:0x0586, B:219:0x058c, B:222:0x0592, B:223:0x0598, B:225:0x05a0, B:227:0x05b1, B:230:0x05b9, B:232:0x05bd, B:233:0x05c4, B:235:0x05c9, B:236:0x05cc, B:247:0x05d4, B:238:0x05de, B:241:0x05e8, B:242:0x05ed, B:244:0x05f2, B:245:0x060c, B:253:0x0572, B:254:0x0579, B:256:0x060d, B:264:0x061f, B:258:0x0626, B:261:0x0632, B:262:0x0652, B:319:0x00be, B:320:0x00dc, B:391:0x00e1, B:393:0x00ec, B:395:0x00f0, B:397:0x00f4, B:400:0x00fa, B:325:0x0109, B:327:0x0111, B:331:0x0123, B:332:0x013b, B:334:0x013c, B:335:0x0141, B:344:0x0156, B:346:0x015c, B:348:0x0163, B:349:0x016e, B:354:0x0180, B:358:0x018a, B:359:0x01a2, B:360:0x017b, B:361:0x0168, B:363:0x01a3, B:364:0x01bb, B:372:0x01c5, B:374:0x01cd, B:378:0x01e0, B:379:0x0200, B:381:0x0201, B:382:0x0206, B:383:0x0207, B:385:0x0653, B:386:0x0658, B:388:0x0659, B:389:0x065e), top: B:23:0x0074, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x04b3 A[Catch: all -> 0x065f, TryCatch #2 {all -> 0x065f, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0082, B:31:0x0095, B:35:0x00aa, B:39:0x0211, B:40:0x0217, B:42:0x0222, B:45:0x022a, B:52:0x0240, B:54:0x024e, B:56:0x0282, B:58:0x0288, B:60:0x0295, B:62:0x0298, B:64:0x02a2, B:68:0x02b0, B:69:0x02b6, B:71:0x02be, B:72:0x02c3, B:74:0x02cb, B:75:0x02d5, B:80:0x02de, B:81:0x02e5, B:82:0x02e6, B:85:0x02f0, B:87:0x02f4, B:89:0x02fa, B:90:0x02fd, B:92:0x0303, B:95:0x0314, B:101:0x032e, B:102:0x033b, B:105:0x0333, B:107:0x0337, B:109:0x0255, B:111:0x025b, B:115:0x0268, B:120:0x0272, B:129:0x034a, B:268:0x0352, B:270:0x035c, B:272:0x036d, B:274:0x0378, B:276:0x0380, B:278:0x0384, B:280:0x038a, B:283:0x038f, B:285:0x0393, B:286:0x03e1, B:288:0x03e9, B:291:0x03f2, B:292:0x040c, B:295:0x0398, B:297:0x03a0, B:300:0x03a6, B:301:0x03b3, B:304:0x03bc, B:308:0x03c2, B:311:0x03c7, B:312:0x03d4, B:314:0x040d, B:315:0x042b, B:134:0x0431, B:136:0x0435, B:138:0x0439, B:141:0x043f, B:145:0x0447, B:151:0x0457, B:153:0x0466, B:155:0x0471, B:156:0x0479, B:157:0x047c, B:158:0x04a8, B:160:0x04b3, B:167:0x04c0, B:170:0x04d0, B:171:0x04f0, B:176:0x048c, B:178:0x0496, B:179:0x04a5, B:180:0x049b, B:185:0x04f5, B:187:0x04ff, B:189:0x0505, B:190:0x0508, B:192:0x0513, B:193:0x0517, B:202:0x0522, B:195:0x0529, B:199:0x0532, B:200:0x0537, B:207:0x053c, B:209:0x0541, B:212:0x054a, B:214:0x0552, B:216:0x0567, B:218:0x0586, B:219:0x058c, B:222:0x0592, B:223:0x0598, B:225:0x05a0, B:227:0x05b1, B:230:0x05b9, B:232:0x05bd, B:233:0x05c4, B:235:0x05c9, B:236:0x05cc, B:247:0x05d4, B:238:0x05de, B:241:0x05e8, B:242:0x05ed, B:244:0x05f2, B:245:0x060c, B:253:0x0572, B:254:0x0579, B:256:0x060d, B:264:0x061f, B:258:0x0626, B:261:0x0632, B:262:0x0652, B:319:0x00be, B:320:0x00dc, B:391:0x00e1, B:393:0x00ec, B:395:0x00f0, B:397:0x00f4, B:400:0x00fa, B:325:0x0109, B:327:0x0111, B:331:0x0123, B:332:0x013b, B:334:0x013c, B:335:0x0141, B:344:0x0156, B:346:0x015c, B:348:0x0163, B:349:0x016e, B:354:0x0180, B:358:0x018a, B:359:0x01a2, B:360:0x017b, B:361:0x0168, B:363:0x01a3, B:364:0x01bb, B:372:0x01c5, B:374:0x01cd, B:378:0x01e0, B:379:0x0200, B:381:0x0201, B:382:0x0206, B:383:0x0207, B:385:0x0653, B:386:0x0658, B:388:0x0659, B:389:0x065e), top: B:23:0x0074, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04bc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x05b1 A[Catch: all -> 0x065f, TryCatch #2 {all -> 0x065f, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0082, B:31:0x0095, B:35:0x00aa, B:39:0x0211, B:40:0x0217, B:42:0x0222, B:45:0x022a, B:52:0x0240, B:54:0x024e, B:56:0x0282, B:58:0x0288, B:60:0x0295, B:62:0x0298, B:64:0x02a2, B:68:0x02b0, B:69:0x02b6, B:71:0x02be, B:72:0x02c3, B:74:0x02cb, B:75:0x02d5, B:80:0x02de, B:81:0x02e5, B:82:0x02e6, B:85:0x02f0, B:87:0x02f4, B:89:0x02fa, B:90:0x02fd, B:92:0x0303, B:95:0x0314, B:101:0x032e, B:102:0x033b, B:105:0x0333, B:107:0x0337, B:109:0x0255, B:111:0x025b, B:115:0x0268, B:120:0x0272, B:129:0x034a, B:268:0x0352, B:270:0x035c, B:272:0x036d, B:274:0x0378, B:276:0x0380, B:278:0x0384, B:280:0x038a, B:283:0x038f, B:285:0x0393, B:286:0x03e1, B:288:0x03e9, B:291:0x03f2, B:292:0x040c, B:295:0x0398, B:297:0x03a0, B:300:0x03a6, B:301:0x03b3, B:304:0x03bc, B:308:0x03c2, B:311:0x03c7, B:312:0x03d4, B:314:0x040d, B:315:0x042b, B:134:0x0431, B:136:0x0435, B:138:0x0439, B:141:0x043f, B:145:0x0447, B:151:0x0457, B:153:0x0466, B:155:0x0471, B:156:0x0479, B:157:0x047c, B:158:0x04a8, B:160:0x04b3, B:167:0x04c0, B:170:0x04d0, B:171:0x04f0, B:176:0x048c, B:178:0x0496, B:179:0x04a5, B:180:0x049b, B:185:0x04f5, B:187:0x04ff, B:189:0x0505, B:190:0x0508, B:192:0x0513, B:193:0x0517, B:202:0x0522, B:195:0x0529, B:199:0x0532, B:200:0x0537, B:207:0x053c, B:209:0x0541, B:212:0x054a, B:214:0x0552, B:216:0x0567, B:218:0x0586, B:219:0x058c, B:222:0x0592, B:223:0x0598, B:225:0x05a0, B:227:0x05b1, B:230:0x05b9, B:232:0x05bd, B:233:0x05c4, B:235:0x05c9, B:236:0x05cc, B:247:0x05d4, B:238:0x05de, B:241:0x05e8, B:242:0x05ed, B:244:0x05f2, B:245:0x060c, B:253:0x0572, B:254:0x0579, B:256:0x060d, B:264:0x061f, B:258:0x0626, B:261:0x0632, B:262:0x0652, B:319:0x00be, B:320:0x00dc, B:391:0x00e1, B:393:0x00ec, B:395:0x00f0, B:397:0x00f4, B:400:0x00fa, B:325:0x0109, B:327:0x0111, B:331:0x0123, B:332:0x013b, B:334:0x013c, B:335:0x0141, B:344:0x0156, B:346:0x015c, B:348:0x0163, B:349:0x016e, B:354:0x0180, B:358:0x018a, B:359:0x01a2, B:360:0x017b, B:361:0x0168, B:363:0x01a3, B:364:0x01bb, B:372:0x01c5, B:374:0x01cd, B:378:0x01e0, B:379:0x0200, B:381:0x0201, B:382:0x0206, B:383:0x0207, B:385:0x0653, B:386:0x0658, B:388:0x0659, B:389:0x065e), top: B:23:0x0074, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x05bd A[Catch: all -> 0x065f, TryCatch #2 {all -> 0x065f, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0082, B:31:0x0095, B:35:0x00aa, B:39:0x0211, B:40:0x0217, B:42:0x0222, B:45:0x022a, B:52:0x0240, B:54:0x024e, B:56:0x0282, B:58:0x0288, B:60:0x0295, B:62:0x0298, B:64:0x02a2, B:68:0x02b0, B:69:0x02b6, B:71:0x02be, B:72:0x02c3, B:74:0x02cb, B:75:0x02d5, B:80:0x02de, B:81:0x02e5, B:82:0x02e6, B:85:0x02f0, B:87:0x02f4, B:89:0x02fa, B:90:0x02fd, B:92:0x0303, B:95:0x0314, B:101:0x032e, B:102:0x033b, B:105:0x0333, B:107:0x0337, B:109:0x0255, B:111:0x025b, B:115:0x0268, B:120:0x0272, B:129:0x034a, B:268:0x0352, B:270:0x035c, B:272:0x036d, B:274:0x0378, B:276:0x0380, B:278:0x0384, B:280:0x038a, B:283:0x038f, B:285:0x0393, B:286:0x03e1, B:288:0x03e9, B:291:0x03f2, B:292:0x040c, B:295:0x0398, B:297:0x03a0, B:300:0x03a6, B:301:0x03b3, B:304:0x03bc, B:308:0x03c2, B:311:0x03c7, B:312:0x03d4, B:314:0x040d, B:315:0x042b, B:134:0x0431, B:136:0x0435, B:138:0x0439, B:141:0x043f, B:145:0x0447, B:151:0x0457, B:153:0x0466, B:155:0x0471, B:156:0x0479, B:157:0x047c, B:158:0x04a8, B:160:0x04b3, B:167:0x04c0, B:170:0x04d0, B:171:0x04f0, B:176:0x048c, B:178:0x0496, B:179:0x04a5, B:180:0x049b, B:185:0x04f5, B:187:0x04ff, B:189:0x0505, B:190:0x0508, B:192:0x0513, B:193:0x0517, B:202:0x0522, B:195:0x0529, B:199:0x0532, B:200:0x0537, B:207:0x053c, B:209:0x0541, B:212:0x054a, B:214:0x0552, B:216:0x0567, B:218:0x0586, B:219:0x058c, B:222:0x0592, B:223:0x0598, B:225:0x05a0, B:227:0x05b1, B:230:0x05b9, B:232:0x05bd, B:233:0x05c4, B:235:0x05c9, B:236:0x05cc, B:247:0x05d4, B:238:0x05de, B:241:0x05e8, B:242:0x05ed, B:244:0x05f2, B:245:0x060c, B:253:0x0572, B:254:0x0579, B:256:0x060d, B:264:0x061f, B:258:0x0626, B:261:0x0632, B:262:0x0652, B:319:0x00be, B:320:0x00dc, B:391:0x00e1, B:393:0x00ec, B:395:0x00f0, B:397:0x00f4, B:400:0x00fa, B:325:0x0109, B:327:0x0111, B:331:0x0123, B:332:0x013b, B:334:0x013c, B:335:0x0141, B:344:0x0156, B:346:0x015c, B:348:0x0163, B:349:0x016e, B:354:0x0180, B:358:0x018a, B:359:0x01a2, B:360:0x017b, B:361:0x0168, B:363:0x01a3, B:364:0x01bb, B:372:0x01c5, B:374:0x01cd, B:378:0x01e0, B:379:0x0200, B:381:0x0201, B:382:0x0206, B:383:0x0207, B:385:0x0653, B:386:0x0658, B:388:0x0659, B:389:0x065e), top: B:23:0x0074, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x05c9 A[Catch: all -> 0x065f, TryCatch #2 {all -> 0x065f, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0082, B:31:0x0095, B:35:0x00aa, B:39:0x0211, B:40:0x0217, B:42:0x0222, B:45:0x022a, B:52:0x0240, B:54:0x024e, B:56:0x0282, B:58:0x0288, B:60:0x0295, B:62:0x0298, B:64:0x02a2, B:68:0x02b0, B:69:0x02b6, B:71:0x02be, B:72:0x02c3, B:74:0x02cb, B:75:0x02d5, B:80:0x02de, B:81:0x02e5, B:82:0x02e6, B:85:0x02f0, B:87:0x02f4, B:89:0x02fa, B:90:0x02fd, B:92:0x0303, B:95:0x0314, B:101:0x032e, B:102:0x033b, B:105:0x0333, B:107:0x0337, B:109:0x0255, B:111:0x025b, B:115:0x0268, B:120:0x0272, B:129:0x034a, B:268:0x0352, B:270:0x035c, B:272:0x036d, B:274:0x0378, B:276:0x0380, B:278:0x0384, B:280:0x038a, B:283:0x038f, B:285:0x0393, B:286:0x03e1, B:288:0x03e9, B:291:0x03f2, B:292:0x040c, B:295:0x0398, B:297:0x03a0, B:300:0x03a6, B:301:0x03b3, B:304:0x03bc, B:308:0x03c2, B:311:0x03c7, B:312:0x03d4, B:314:0x040d, B:315:0x042b, B:134:0x0431, B:136:0x0435, B:138:0x0439, B:141:0x043f, B:145:0x0447, B:151:0x0457, B:153:0x0466, B:155:0x0471, B:156:0x0479, B:157:0x047c, B:158:0x04a8, B:160:0x04b3, B:167:0x04c0, B:170:0x04d0, B:171:0x04f0, B:176:0x048c, B:178:0x0496, B:179:0x04a5, B:180:0x049b, B:185:0x04f5, B:187:0x04ff, B:189:0x0505, B:190:0x0508, B:192:0x0513, B:193:0x0517, B:202:0x0522, B:195:0x0529, B:199:0x0532, B:200:0x0537, B:207:0x053c, B:209:0x0541, B:212:0x054a, B:214:0x0552, B:216:0x0567, B:218:0x0586, B:219:0x058c, B:222:0x0592, B:223:0x0598, B:225:0x05a0, B:227:0x05b1, B:230:0x05b9, B:232:0x05bd, B:233:0x05c4, B:235:0x05c9, B:236:0x05cc, B:247:0x05d4, B:238:0x05de, B:241:0x05e8, B:242:0x05ed, B:244:0x05f2, B:245:0x060c, B:253:0x0572, B:254:0x0579, B:256:0x060d, B:264:0x061f, B:258:0x0626, B:261:0x0632, B:262:0x0652, B:319:0x00be, B:320:0x00dc, B:391:0x00e1, B:393:0x00ec, B:395:0x00f0, B:397:0x00f4, B:400:0x00fa, B:325:0x0109, B:327:0x0111, B:331:0x0123, B:332:0x013b, B:334:0x013c, B:335:0x0141, B:344:0x0156, B:346:0x015c, B:348:0x0163, B:349:0x016e, B:354:0x0180, B:358:0x018a, B:359:0x01a2, B:360:0x017b, B:361:0x0168, B:363:0x01a3, B:364:0x01bb, B:372:0x01c5, B:374:0x01cd, B:378:0x01e0, B:379:0x0200, B:381:0x0201, B:382:0x0206, B:383:0x0207, B:385:0x0653, B:386:0x0658, B:388:0x0659, B:389:0x065e), top: B:23:0x0074, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x05de A[Catch: all -> 0x065f, TRY_ENTER, TryCatch #2 {all -> 0x065f, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0082, B:31:0x0095, B:35:0x00aa, B:39:0x0211, B:40:0x0217, B:42:0x0222, B:45:0x022a, B:52:0x0240, B:54:0x024e, B:56:0x0282, B:58:0x0288, B:60:0x0295, B:62:0x0298, B:64:0x02a2, B:68:0x02b0, B:69:0x02b6, B:71:0x02be, B:72:0x02c3, B:74:0x02cb, B:75:0x02d5, B:80:0x02de, B:81:0x02e5, B:82:0x02e6, B:85:0x02f0, B:87:0x02f4, B:89:0x02fa, B:90:0x02fd, B:92:0x0303, B:95:0x0314, B:101:0x032e, B:102:0x033b, B:105:0x0333, B:107:0x0337, B:109:0x0255, B:111:0x025b, B:115:0x0268, B:120:0x0272, B:129:0x034a, B:268:0x0352, B:270:0x035c, B:272:0x036d, B:274:0x0378, B:276:0x0380, B:278:0x0384, B:280:0x038a, B:283:0x038f, B:285:0x0393, B:286:0x03e1, B:288:0x03e9, B:291:0x03f2, B:292:0x040c, B:295:0x0398, B:297:0x03a0, B:300:0x03a6, B:301:0x03b3, B:304:0x03bc, B:308:0x03c2, B:311:0x03c7, B:312:0x03d4, B:314:0x040d, B:315:0x042b, B:134:0x0431, B:136:0x0435, B:138:0x0439, B:141:0x043f, B:145:0x0447, B:151:0x0457, B:153:0x0466, B:155:0x0471, B:156:0x0479, B:157:0x047c, B:158:0x04a8, B:160:0x04b3, B:167:0x04c0, B:170:0x04d0, B:171:0x04f0, B:176:0x048c, B:178:0x0496, B:179:0x04a5, B:180:0x049b, B:185:0x04f5, B:187:0x04ff, B:189:0x0505, B:190:0x0508, B:192:0x0513, B:193:0x0517, B:202:0x0522, B:195:0x0529, B:199:0x0532, B:200:0x0537, B:207:0x053c, B:209:0x0541, B:212:0x054a, B:214:0x0552, B:216:0x0567, B:218:0x0586, B:219:0x058c, B:222:0x0592, B:223:0x0598, B:225:0x05a0, B:227:0x05b1, B:230:0x05b9, B:232:0x05bd, B:233:0x05c4, B:235:0x05c9, B:236:0x05cc, B:247:0x05d4, B:238:0x05de, B:241:0x05e8, B:242:0x05ed, B:244:0x05f2, B:245:0x060c, B:253:0x0572, B:254:0x0579, B:256:0x060d, B:264:0x061f, B:258:0x0626, B:261:0x0632, B:262:0x0652, B:319:0x00be, B:320:0x00dc, B:391:0x00e1, B:393:0x00ec, B:395:0x00f0, B:397:0x00f4, B:400:0x00fa, B:325:0x0109, B:327:0x0111, B:331:0x0123, B:332:0x013b, B:334:0x013c, B:335:0x0141, B:344:0x0156, B:346:0x015c, B:348:0x0163, B:349:0x016e, B:354:0x0180, B:358:0x018a, B:359:0x01a2, B:360:0x017b, B:361:0x0168, B:363:0x01a3, B:364:0x01bb, B:372:0x01c5, B:374:0x01cd, B:378:0x01e0, B:379:0x0200, B:381:0x0201, B:382:0x0206, B:383:0x0207, B:385:0x0653, B:386:0x0658, B:388:0x0659, B:389:0x065e), top: B:23:0x0074, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x05d4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x018a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0211 A[Catch: all -> 0x065f, TryCatch #2 {all -> 0x065f, blocks: (B:24:0x0074, B:26:0x0078, B:28:0x0082, B:31:0x0095, B:35:0x00aa, B:39:0x0211, B:40:0x0217, B:42:0x0222, B:45:0x022a, B:52:0x0240, B:54:0x024e, B:56:0x0282, B:58:0x0288, B:60:0x0295, B:62:0x0298, B:64:0x02a2, B:68:0x02b0, B:69:0x02b6, B:71:0x02be, B:72:0x02c3, B:74:0x02cb, B:75:0x02d5, B:80:0x02de, B:81:0x02e5, B:82:0x02e6, B:85:0x02f0, B:87:0x02f4, B:89:0x02fa, B:90:0x02fd, B:92:0x0303, B:95:0x0314, B:101:0x032e, B:102:0x033b, B:105:0x0333, B:107:0x0337, B:109:0x0255, B:111:0x025b, B:115:0x0268, B:120:0x0272, B:129:0x034a, B:268:0x0352, B:270:0x035c, B:272:0x036d, B:274:0x0378, B:276:0x0380, B:278:0x0384, B:280:0x038a, B:283:0x038f, B:285:0x0393, B:286:0x03e1, B:288:0x03e9, B:291:0x03f2, B:292:0x040c, B:295:0x0398, B:297:0x03a0, B:300:0x03a6, B:301:0x03b3, B:304:0x03bc, B:308:0x03c2, B:311:0x03c7, B:312:0x03d4, B:314:0x040d, B:315:0x042b, B:134:0x0431, B:136:0x0435, B:138:0x0439, B:141:0x043f, B:145:0x0447, B:151:0x0457, B:153:0x0466, B:155:0x0471, B:156:0x0479, B:157:0x047c, B:158:0x04a8, B:160:0x04b3, B:167:0x04c0, B:170:0x04d0, B:171:0x04f0, B:176:0x048c, B:178:0x0496, B:179:0x04a5, B:180:0x049b, B:185:0x04f5, B:187:0x04ff, B:189:0x0505, B:190:0x0508, B:192:0x0513, B:193:0x0517, B:202:0x0522, B:195:0x0529, B:199:0x0532, B:200:0x0537, B:207:0x053c, B:209:0x0541, B:212:0x054a, B:214:0x0552, B:216:0x0567, B:218:0x0586, B:219:0x058c, B:222:0x0592, B:223:0x0598, B:225:0x05a0, B:227:0x05b1, B:230:0x05b9, B:232:0x05bd, B:233:0x05c4, B:235:0x05c9, B:236:0x05cc, B:247:0x05d4, B:238:0x05de, B:241:0x05e8, B:242:0x05ed, B:244:0x05f2, B:245:0x060c, B:253:0x0572, B:254:0x0579, B:256:0x060d, B:264:0x061f, B:258:0x0626, B:261:0x0632, B:262:0x0652, B:319:0x00be, B:320:0x00dc, B:391:0x00e1, B:393:0x00ec, B:395:0x00f0, B:397:0x00f4, B:400:0x00fa, B:325:0x0109, B:327:0x0111, B:331:0x0123, B:332:0x013b, B:334:0x013c, B:335:0x0141, B:344:0x0156, B:346:0x015c, B:348:0x0163, B:349:0x016e, B:354:0x0180, B:358:0x018a, B:359:0x01a2, B:360:0x017b, B:361:0x0168, B:363:0x01a3, B:364:0x01bb, B:372:0x01c5, B:374:0x01cd, B:378:0x01e0, B:379:0x0200, B:381:0x0201, B:382:0x0206, B:383:0x0207, B:385:0x0653, B:386:0x0658, B:388:0x0659, B:389:0x065e), top: B:23:0x0074, inners: #0, #1 }] */
    /* JADX WARN: Type inference failed for: r18v0, types: [com.alibaba.fastjson.parser.DefaultJSONParser] */
    /* JADX WARN: Type inference failed for: r7v31, types: [java.util.Date] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object parseObject(java.util.Map r19, java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 1636
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public void popContext() {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = this.context.parent;
        int i10 = this.contextArrayIndex;
        if (i10 <= 0) {
            return;
        }
        int i11 = i10 - 1;
        this.contextArrayIndex = i11;
        this.contextArray[i11] = null;
    }

    public Object resolveReference(String str) {
        if (this.contextArray == null) {
            return null;
        }
        int i10 = 0;
        while (true) {
            ParseContext[] parseContextArr = this.contextArray;
            if (i10 >= parseContextArr.length || i10 >= this.contextArrayIndex) {
                break;
            }
            ParseContext parseContext = parseContextArr[i10];
            if (parseContext.toString().equals(str)) {
                return parseContext.object;
            }
            i10++;
        }
        return null;
    }

    public void setConfig(ParserConfig parserConfig) {
        this.config = parserConfig;
    }

    public void setContext(ParseContext parseContext) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return;
        }
        this.context = parseContext;
    }

    public void setDateFomrat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public void setFieldTypeResolver(FieldTypeResolver fieldTypeResolver) {
        this.fieldTypeResolver = fieldTypeResolver;
    }

    public void setResolveStatus(int i10) {
        this.resolveStatus = i10;
    }

    public void throwException(int i10) {
        throw new JSONException("syntax error, expect " + JSONToken.name(i10) + ", actual " + JSONToken.name(this.lexer.token()));
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(str, new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i10 = jSONLexer.token();
        if (i10 == 2) {
            Number integerValue = jSONLexer.integerValue();
            jSONLexer.nextToken();
            return integerValue;
        }
        if (i10 == 3) {
            Number decimalValue = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
            jSONLexer.nextToken();
            return decimalValue;
        }
        if (i10 == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                JSONScanner jSONScanner = new JSONScanner(stringVal);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch()) {
                        return jSONScanner.getCalendar().getTime();
                    }
                } finally {
                    jSONScanner.close();
                }
            }
            return stringVal;
        }
        if (i10 == 12) {
            return parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), obj);
        }
        if (i10 == 14) {
            JSONArray jSONArray = new JSONArray();
            parseArray(jSONArray, obj);
            return jSONLexer.isEnabled(Feature.UseObjectArray) ? jSONArray.toArray() : jSONArray;
        }
        if (i10 == 18) {
            if ("NaN".equals(jSONLexer.stringVal())) {
                jSONLexer.nextToken();
                return null;
            }
            throw new JSONException("syntax error, " + jSONLexer.info());
        }
        if (i10 != 26) {
            switch (i10) {
                case 6:
                    jSONLexer.nextToken();
                    return Boolean.TRUE;
                case 7:
                    jSONLexer.nextToken();
                    return Boolean.FALSE;
                case 8:
                    jSONLexer.nextToken();
                    return null;
                case 9:
                    jSONLexer.nextToken(18);
                    if (jSONLexer.token() == 18) {
                        jSONLexer.nextToken(10);
                        accept(10);
                        long longValue = jSONLexer.integerValue().longValue();
                        accept(2);
                        accept(11);
                        return new Date(longValue);
                    }
                    throw new JSONException("syntax error");
                default:
                    switch (i10) {
                        case 20:
                            if (jSONLexer.isBlankInput()) {
                                return null;
                            }
                            throw new JSONException("unterminated json string, " + jSONLexer.info());
                        case 21:
                            jSONLexer.nextToken();
                            Collection hashSet = new HashSet();
                            parseArray(hashSet, obj);
                            return hashSet;
                        case 22:
                            jSONLexer.nextToken();
                            Collection treeSet = new TreeSet();
                            parseArray(treeSet, obj);
                            return treeSet;
                        case 23:
                            jSONLexer.nextToken();
                            return null;
                        default:
                            throw new JSONException("syntax error, " + jSONLexer.info());
                    }
            }
        }
        byte[] bytesValue = jSONLexer.bytesValue();
        jSONLexer.nextToken();
        return bytesValue;
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i10) {
        this(str, new JSONScanner(str, i10), parserConfig);
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public ParseContext setContext(Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return setContext(this.context, obj, obj2);
    }

    public DefaultJSONParser(char[] cArr, int i10, ParserConfig parserConfig, int i11) {
        this(cArr, new JSONScanner(cArr, i10, i11), parserConfig);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.getGlobalInstance());
    }

    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer deserializer;
        int i10 = this.lexer.token();
        if (i10 == 21 || i10 == 22) {
            this.lexer.nextToken();
            i10 = this.lexer.token();
        }
        if (i10 == 14) {
            if (Integer.TYPE != type) {
                if (String.class == type) {
                    deserializer = StringCodec.instance;
                    this.lexer.nextToken(4);
                } else {
                    deserializer = this.config.getDeserializer(type);
                    this.lexer.nextToken(deserializer.getFastMatchToken());
                }
            } else {
                deserializer = IntegerCodec.instance;
                this.lexer.nextToken(2);
            }
            ParseContext parseContext = this.context;
            setContext(collection, obj);
            int i11 = 0;
            while (true) {
                try {
                    if (this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (this.lexer.token() == 16) {
                            this.lexer.nextToken();
                        }
                    }
                    if (this.lexer.token() == 15) {
                        setContext(parseContext);
                        this.lexer.nextToken(16);
                        return;
                    }
                    Object obj2 = null;
                    if (Integer.TYPE != type) {
                        if (String.class == type) {
                            if (this.lexer.token() == 4) {
                                obj2 = this.lexer.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                Object parse = parse();
                                if (parse != null) {
                                    obj2 = parse.toString();
                                }
                            }
                            collection.add(obj2);
                        } else {
                            if (this.lexer.token() == 8) {
                                this.lexer.nextToken();
                            } else {
                                obj2 = deserializer.deserialze(this, type, Integer.valueOf(i11));
                            }
                            collection.add(obj2);
                            checkListResolve(collection);
                        }
                    } else {
                        collection.add(IntegerCodec.instance.deserialze(this, null, null));
                    }
                    if (this.lexer.token() == 16) {
                        this.lexer.nextToken(deserializer.getFastMatchToken());
                    }
                    i11++;
                } catch (Throwable th) {
                    setContext(parseContext);
                    throw th;
                }
            }
        } else {
            throw new JSONException("expect '[', but " + JSONToken.name(i10) + ", " + this.lexer.info());
        }
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        ParseContext parseContext2 = new ParseContext(parseContext, obj, obj2);
        this.context = parseContext2;
        addContext(parseContext2);
        return this.context;
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this((Object) null, jSONLexer, parserConfig);
    }

    public final void accept(int i10, int i11) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i10) {
            jSONLexer.nextToken(i11);
        } else {
            throwException(i10);
        }
    }

    public DefaultJSONParser(Object obj, JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.autoTypeAccept = null;
        this.lexer = jSONLexer;
        this.input = obj;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char current = jSONLexer.getCurrent();
        if (current == '{') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 12;
        } else if (current == '[') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 14;
        } else {
            jSONLexer.nextToken();
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object cast;
        Class<?> cls;
        boolean z10;
        Class cls2;
        int i10 = 8;
        if (this.lexer.token() == 8) {
            this.lexer.nextToken(16);
            return null;
        }
        int i11 = 14;
        if (this.lexer.token() == 14) {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                this.lexer.nextToken(15);
                if (this.lexer.token() == 15) {
                    this.lexer.nextToken(16);
                    return new Object[0];
                }
                throw new JSONException("syntax error");
            }
            this.lexer.nextToken(2);
            int i12 = 0;
            while (i12 < typeArr.length) {
                if (this.lexer.token() == i10) {
                    this.lexer.nextToken(16);
                    cast = null;
                } else {
                    Type type = typeArr[i12];
                    if (type != Integer.TYPE && type != Integer.class) {
                        if (type == String.class) {
                            if (this.lexer.token() == 4) {
                                cast = this.lexer.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                cast = TypeUtils.cast(parse(), type, this.config);
                            }
                        } else {
                            if (i12 == typeArr.length - 1 && (type instanceof Class) && (((cls2 = (Class) type) != byte[].class && cls2 != char[].class) || this.lexer.token() != 4)) {
                                z10 = cls2.isArray();
                                cls = cls2.getComponentType();
                            } else {
                                cls = null;
                                z10 = false;
                            }
                            if (z10 && this.lexer.token() != i11) {
                                ArrayList arrayList = new ArrayList();
                                ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                                int fastMatchToken = deserializer.getFastMatchToken();
                                if (this.lexer.token() != 15) {
                                    while (true) {
                                        arrayList.add(deserializer.deserialze(this, type, null));
                                        if (this.lexer.token() != 16) {
                                            break;
                                        }
                                        this.lexer.nextToken(fastMatchToken);
                                    }
                                    if (this.lexer.token() != 15) {
                                        throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                                    }
                                }
                                cast = TypeUtils.cast(arrayList, type, this.config);
                            } else {
                                cast = this.config.getDeserializer(type).deserialze(this, type, Integer.valueOf(i12));
                            }
                        }
                    } else if (this.lexer.token() == 2) {
                        cast = Integer.valueOf(this.lexer.intValue());
                        this.lexer.nextToken(16);
                    } else {
                        cast = TypeUtils.cast(parse(), type, this.config);
                    }
                }
                objArr[i12] = cast;
                if (this.lexer.token() == 15) {
                    break;
                }
                if (this.lexer.token() == 16) {
                    if (i12 == typeArr.length - 1) {
                        this.lexer.nextToken(15);
                    } else {
                        this.lexer.nextToken(2);
                    }
                    i12++;
                    i10 = 8;
                    i11 = 14;
                } else {
                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                }
            }
            if (this.lexer.token() == 15) {
                this.lexer.nextToken(16);
                return objArr;
            }
            throw new JSONException("syntax error");
        }
        throw new JSONException("syntax error : " + this.lexer.tokenName());
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0236, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object parse(com.alibaba.fastjson.parser.deserializer.PropertyProcessable r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 613
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parse(com.alibaba.fastjson.parser.deserializer.PropertyProcessable, java.lang.Object):java.lang.Object");
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    public final void parseArray(Collection collection, Object obj) {
        Number decimalValue;
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == 21 || jSONLexer.token() == 22) {
            jSONLexer.nextToken();
        }
        if (jSONLexer.token() == 14) {
            jSONLexer.nextToken(4);
            ParseContext parseContext = this.context;
            setContext(collection, obj);
            int i10 = 0;
            while (true) {
                try {
                    if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (jSONLexer.token() == 16) {
                            jSONLexer.nextToken();
                        }
                    }
                    int i11 = jSONLexer.token();
                    Object obj2 = null;
                    obj2 = null;
                    if (i11 == 2) {
                        Number integerValue = jSONLexer.integerValue();
                        jSONLexer.nextToken(16);
                        obj2 = integerValue;
                    } else if (i11 == 3) {
                        if (jSONLexer.isEnabled(Feature.UseBigDecimal)) {
                            decimalValue = jSONLexer.decimalValue(true);
                        } else {
                            decimalValue = jSONLexer.decimalValue(false);
                        }
                        obj2 = decimalValue;
                        jSONLexer.nextToken(16);
                    } else if (i11 == 4) {
                        String stringVal = jSONLexer.stringVal();
                        jSONLexer.nextToken(16);
                        obj2 = stringVal;
                        if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                            JSONScanner jSONScanner = new JSONScanner(stringVal);
                            Object obj3 = stringVal;
                            if (jSONScanner.scanISO8601DateIfMatch()) {
                                obj3 = jSONScanner.getCalendar().getTime();
                            }
                            jSONScanner.close();
                            obj2 = obj3;
                        }
                    } else if (i11 == 6) {
                        Boolean bool = Boolean.TRUE;
                        jSONLexer.nextToken(16);
                        obj2 = bool;
                    } else if (i11 == 7) {
                        Boolean bool2 = Boolean.FALSE;
                        jSONLexer.nextToken(16);
                        obj2 = bool2;
                    } else if (i11 == 8) {
                        jSONLexer.nextToken(4);
                    } else if (i11 == 12) {
                        obj2 = parseObject(new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), Integer.valueOf(i10));
                    } else {
                        if (i11 == 20) {
                            throw new JSONException("unclosed jsonArray");
                        }
                        if (i11 == 23) {
                            jSONLexer.nextToken(4);
                        } else if (i11 == 14) {
                            JSONArray jSONArray = new JSONArray();
                            parseArray(jSONArray, Integer.valueOf(i10));
                            obj2 = jSONArray;
                            if (jSONLexer.isEnabled(Feature.UseObjectArray)) {
                                obj2 = jSONArray.toArray();
                            }
                        } else if (i11 != 15) {
                            obj2 = parse();
                        } else {
                            jSONLexer.nextToken(16);
                            return;
                        }
                    }
                    collection.add(obj2);
                    checkListResolve(collection);
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(4);
                    }
                    i10++;
                } finally {
                    setContext(parseContext);
                }
            }
        } else {
            throw new JSONException("syntax error, expect [, actual " + JSONToken.name(jSONLexer.token()) + ", pos " + jSONLexer.pos() + ", fieldName " + obj);
        }
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject(cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return (T) parseObject(type, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T parseObject(Type type, Object obj) {
        int i10 = this.lexer.token();
        if (i10 == 8) {
            this.lexer.nextToken();
            return null;
        }
        if (i10 == 4) {
            if (type == byte[].class) {
                T t2 = (T) this.lexer.bytesValue();
                this.lexer.nextToken();
                return t2;
            }
            if (type == char[].class) {
                String stringVal = this.lexer.stringVal();
                this.lexer.nextToken();
                return (T) stringVal.toCharArray();
            }
        }
        ObjectDeserializer deserializer = this.config.getDeserializer(type);
        try {
            if (deserializer.getClass() == JavaBeanDeserializer.class) {
                if (this.lexer.token() != 12 && this.lexer.token() != 14) {
                    throw new JSONException("syntax error,except start with { or [,but actually start with " + this.lexer.tokenName());
                }
                return (T) ((JavaBeanDeserializer) deserializer).deserialze(this, type, obj, 0);
            }
            return (T) deserializer.deserialze(this, type, obj);
        } catch (JSONException e2) {
            throw e2;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    public void parseObject(Object obj) {
        Object deserialze;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (this.lexer.token() != 12 && this.lexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
        }
        while (true) {
            String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
            if (scanSymbol == null) {
                if (this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                } else if (this.lexer.token() == 16 && this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                }
            }
            FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
            if (fieldDeserializer == null) {
                if (this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
                    this.lexer.nextTokenWithColon();
                    parse();
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken();
                        return;
                    }
                } else {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
                }
            } else {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                Class<?> cls2 = fieldInfo.fieldClass;
                Type type = fieldInfo.fieldType;
                if (cls2 == Integer.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    deserialze = IntegerCodec.instance.deserialze(this, type, null);
                } else if (cls2 == String.class) {
                    this.lexer.nextTokenWithColon(4);
                    deserialze = StringCodec.deserialze(this);
                } else if (cls2 == Long.TYPE) {
                    this.lexer.nextTokenWithColon(2);
                    deserialze = LongCodec.instance.deserialze(this, type, null);
                } else {
                    ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                    this.lexer.nextTokenWithColon(deserializer2.getFastMatchToken());
                    deserialze = deserializer2.deserialze(this, type, null);
                }
                fieldDeserializer.setValue(obj, deserialze);
                if (this.lexer.token() != 16 && this.lexer.token() == 13) {
                    this.lexer.nextToken(16);
                    return;
                }
            }
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public JSONObject parseObject() {
        Object parseObject = parseObject((Map) new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
        if (parseObject instanceof JSONObject) {
            return (JSONObject) parseObject;
        }
        if (parseObject == null) {
            return null;
        }
        return new JSONObject((Map<String, Object>) parseObject);
    }
}
