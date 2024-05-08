package com.alibaba.security.common.json.parser;

import com.alibaba.security.common.json.RPJSONException;
import com.alibaba.security.common.json.RPJSONObject;
import com.alibaba.security.common.json.annotation.RPJSONType;
import com.alibaba.security.common.json.parser.deserializer.ExtraProcessable;
import com.alibaba.security.common.json.parser.deserializer.ExtraProcessor;
import com.alibaba.security.common.json.parser.deserializer.ExtraTypeProvider;
import com.alibaba.security.common.json.parser.deserializer.FieldDeserializer;
import com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer;
import com.alibaba.security.common.json.util.RPFieldInfo;
import com.alibaba.security.common.json.util.RPTypeUtils;
import com.android.internal.accessibility.common.ShortcutConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    private final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    public final JavaBeanInfo beanInfo;
    private final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private final FieldDeserializer[] fieldDeserializers;
    private transient long[] smartMatchHashArray;
    private transient int[] smartMatchHashArrayMapping;
    private final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, cls, type, JavaBeanInfo.build(cls, cls.getModifiers(), type, false, true, true, true, parserConfig.propertyNamingStrategy));
    }

    private <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        Enum r82;
        String str;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        T t2 = (T) createInstance(defaultJSONParser, type);
        int length = this.sortedFieldDeserializers.length;
        int i10 = 0;
        while (i10 < length) {
            char c4 = i10 == length + (-1) ? ']' : ',';
            FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i10];
            RPFieldInfo rPFieldInfo = fieldDeserializer.fieldInfo;
            Class<?> cls = rPFieldInfo.fieldClass;
            try {
                if (cls == Integer.TYPE) {
                    int scanLongValue = (int) jSONLexer.scanLongValue();
                    if (rPFieldInfo.fieldAccess) {
                        rPFieldInfo.field.setInt(t2, scanLongValue);
                    } else {
                        fieldDeserializer.setValue(t2, new Integer(scanLongValue));
                    }
                    char c10 = jSONLexer.ch;
                    if (c10 == ',') {
                        int i11 = jSONLexer.bp + 1;
                        jSONLexer.bp = i11;
                        jSONLexer.ch = i11 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i11);
                        jSONLexer.token = 16;
                    } else if (c10 == ']') {
                        int i12 = jSONLexer.bp + 1;
                        jSONLexer.bp = i12;
                        jSONLexer.ch = i12 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i12);
                        jSONLexer.token = 15;
                    } else {
                        jSONLexer.nextToken();
                    }
                } else if (cls == String.class) {
                    char c11 = jSONLexer.ch;
                    if (c11 == '\"') {
                        str = jSONLexer.scanStringValue('\"');
                    } else if (c11 == 'n' && jSONLexer.text.startsWith("null", jSONLexer.bp)) {
                        int i13 = jSONLexer.bp + 4;
                        jSONLexer.bp = i13;
                        jSONLexer.ch = i13 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i13);
                        str = null;
                    } else {
                        throw new RPJSONException("not match string. feild : " + obj);
                    }
                    if (rPFieldInfo.fieldAccess) {
                        rPFieldInfo.field.set(t2, str);
                    } else {
                        fieldDeserializer.setValue(t2, str);
                    }
                    char c12 = jSONLexer.ch;
                    if (c12 == ',') {
                        int i14 = jSONLexer.bp + 1;
                        jSONLexer.bp = i14;
                        jSONLexer.ch = i14 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i14);
                        jSONLexer.token = 16;
                    } else if (c12 == ']') {
                        int i15 = jSONLexer.bp + 1;
                        jSONLexer.bp = i15;
                        jSONLexer.ch = i15 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i15);
                        jSONLexer.token = 15;
                    } else {
                        jSONLexer.nextToken();
                    }
                } else {
                    if (cls == Long.TYPE) {
                        long scanLongValue2 = jSONLexer.scanLongValue();
                        if (rPFieldInfo.fieldAccess) {
                            rPFieldInfo.field.setLong(t2, scanLongValue2);
                        } else {
                            fieldDeserializer.setValue(t2, new Long(scanLongValue2));
                        }
                        char c13 = jSONLexer.ch;
                        if (c13 == ',') {
                            int i16 = jSONLexer.bp + 1;
                            jSONLexer.bp = i16;
                            jSONLexer.ch = i16 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i16);
                            jSONLexer.token = 16;
                        } else if (c13 == ']') {
                            int i17 = jSONLexer.bp + 1;
                            jSONLexer.bp = i17;
                            jSONLexer.ch = i17 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i17);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls == Boolean.TYPE) {
                        boolean scanBoolean = jSONLexer.scanBoolean();
                        if (rPFieldInfo.fieldAccess) {
                            rPFieldInfo.field.setBoolean(t2, scanBoolean);
                        } else {
                            fieldDeserializer.setValue(t2, Boolean.valueOf(scanBoolean));
                        }
                        char c14 = jSONLexer.ch;
                        if (c14 == ',') {
                            int i18 = jSONLexer.bp + 1;
                            jSONLexer.bp = i18;
                            jSONLexer.ch = i18 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i18);
                            jSONLexer.token = 16;
                        } else if (c14 == ']') {
                            int i19 = jSONLexer.bp + 1;
                            jSONLexer.bp = i19;
                            jSONLexer.ch = i19 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i19);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls.isEnum()) {
                        char c15 = jSONLexer.ch;
                        if (c15 == '\"') {
                            String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.symbolTable);
                            r82 = scanSymbol == null ? null : Enum.valueOf(cls, scanSymbol);
                        } else if (c15 >= '0' && c15 <= '9') {
                            r82 = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.config)).values[(int) jSONLexer.scanLongValue()];
                        } else {
                            throw new RPJSONException("illegal enum." + jSONLexer.info());
                        }
                        fieldDeserializer.setValue(t2, r82);
                        char c16 = jSONLexer.ch;
                        if (c16 == ',') {
                            int i20 = jSONLexer.bp + 1;
                            jSONLexer.bp = i20;
                            jSONLexer.ch = i20 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i20);
                            jSONLexer.token = 16;
                        } else if (c16 == ']') {
                            int i21 = jSONLexer.bp + 1;
                            jSONLexer.bp = i21;
                            jSONLexer.ch = i21 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i21);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls == Date.class && jSONLexer.ch == '1') {
                        fieldDeserializer.setValue(t2, new Date(jSONLexer.scanLongValue()));
                        char c17 = jSONLexer.ch;
                        if (c17 == ',') {
                            int i22 = jSONLexer.bp + 1;
                            jSONLexer.bp = i22;
                            jSONLexer.ch = i22 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i22);
                            jSONLexer.token = 16;
                        } else if (c17 == ']') {
                            int i23 = jSONLexer.bp + 1;
                            jSONLexer.bp = i23;
                            jSONLexer.ch = i23 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i23);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else {
                        char c18 = jSONLexer.ch;
                        if (c18 == '[') {
                            int i24 = jSONLexer.bp + 1;
                            jSONLexer.bp = i24;
                            jSONLexer.ch = i24 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i24);
                            jSONLexer.token = 14;
                        } else if (c18 == '{') {
                            int i25 = jSONLexer.bp + 1;
                            jSONLexer.bp = i25;
                            jSONLexer.ch = i25 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i25);
                            jSONLexer.token = 12;
                        } else {
                            jSONLexer.nextToken();
                        }
                        fieldDeserializer.parseField(defaultJSONParser, t2, rPFieldInfo.fieldType, null);
                        if (c4 == ']') {
                            if (jSONLexer.token != 15) {
                                throw new RPJSONException("syntax error");
                            }
                        } else if (c4 == ',' && jSONLexer.token != 16) {
                            throw new RPJSONException("syntax error");
                        }
                    }
                    i10++;
                }
                i10++;
            } catch (IllegalAccessException e2) {
                throw new RPJSONException("set " + rPFieldInfo.name + "error", e2);
            }
        }
        if (jSONLexer.ch == ',') {
            int i26 = jSONLexer.bp + 1;
            jSONLexer.bp = i26;
            jSONLexer.ch = i26 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i26);
            jSONLexer.token = 16;
        } else {
            jSONLexer.nextToken();
        }
        return t2;
    }

    private boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str);
        if (fieldDeserializer == null) {
            long fnv_64_lower = RPTypeUtils.fnv_64_lower(str);
            if (this.smartMatchHashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                int i10 = 0;
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i10 >= fieldDeserializerArr.length) {
                        break;
                    }
                    jArr[i10] = RPTypeUtils.fnv_64_lower(fieldDeserializerArr[i10].fieldInfo.name);
                    i10++;
                }
                Arrays.sort(jArr);
                this.smartMatchHashArray = jArr;
            }
            int binarySearch = Arrays.binarySearch(this.smartMatchHashArray, fnv_64_lower);
            if (binarySearch < 0 && str.startsWith("is")) {
                binarySearch = Arrays.binarySearch(this.smartMatchHashArray, RPTypeUtils.fnv_64_lower(str.substring(2)));
            }
            if (binarySearch >= 0) {
                if (this.smartMatchHashArrayMapping == null) {
                    int[] iArr = new int[this.smartMatchHashArray.length];
                    Arrays.fill(iArr, -1);
                    int i11 = 0;
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i11 >= fieldDeserializerArr2.length) {
                            break;
                        }
                        int binarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, RPTypeUtils.fnv_64_lower(fieldDeserializerArr2[i11].fieldInfo.name));
                        if (binarySearch2 >= 0) {
                            iArr[binarySearch2] = i11;
                        }
                        i11++;
                    }
                    this.smartMatchHashArrayMapping = iArr;
                }
                int i12 = this.smartMatchHashArrayMapping[binarySearch];
                if (i12 != -1) {
                    fieldDeserializer = this.sortedFieldDeserializers[i12];
                }
            }
        }
        int i13 = Feature.SupportNonPublicField.mask;
        if (fieldDeserializer == null && ((defaultJSONParser.lexer.features & i13) != 0 || (i13 & this.beanInfo.parserFeatures) != 0)) {
            if (this.extraFieldDeserializers == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(1, 0.75f, 1);
                for (Field field : this.clazz.getDeclaredFields()) {
                    String name = field.getName();
                    if (getFieldDeserializer(name) == null) {
                        int modifiers = field.getModifiers();
                        if ((modifiers & 16) == 0 && (modifiers & 8) == 0) {
                            concurrentHashMap.put(name, field);
                        }
                    }
                }
                this.extraFieldDeserializers = concurrentHashMap;
            }
            Object obj2 = this.extraFieldDeserializers.get(str);
            if (obj2 != null) {
                if (obj2 instanceof FieldDeserializer) {
                    fieldDeserializer = (FieldDeserializer) obj2;
                } else {
                    Field field2 = (Field) obj2;
                    field2.setAccessible(true);
                    fieldDeserializer = new DefaultFieldDeserializer(defaultJSONParser.config, this.clazz, new RPFieldInfo(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0));
                    this.extraFieldDeserializers.put(str, fieldDeserializer);
                }
            }
        }
        if (fieldDeserializer == null) {
            parseExtra(defaultJSONParser, obj, str);
            return false;
        }
        jSONLexer.nextTokenWithChar(ShortcutConstants.SERVICES_SEPARATOR);
        fieldDeserializer.parseField(defaultJSONParser, obj, type, map);
        return true;
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        Object newInstance;
        if ((type instanceof Class) && this.clazz.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new RPJSONObject((defaultJSONParser.lexer.features & Feature.OrderedField.mask) != 0));
        }
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        Constructor<?> constructor = javaBeanInfo.defaultConstructor;
        if (constructor == null && javaBeanInfo.factoryMethod == null) {
            return null;
        }
        Method method = javaBeanInfo.factoryMethod;
        if (method != null && javaBeanInfo.defaultConstructorParameterSize > 0) {
            return null;
        }
        try {
            if (javaBeanInfo.defaultConstructorParameterSize != 0) {
                newInstance = constructor.newInstance(defaultJSONParser.contex.object);
            } else if (constructor != null) {
                newInstance = constructor.newInstance(new Object[0]);
            } else {
                newInstance = method.invoke(null, new Object[0]);
            }
            if (defaultJSONParser != null && (defaultJSONParser.lexer.features & Feature.InitStringFieldAsEmpty.mask) != 0) {
                for (RPFieldInfo rPFieldInfo : this.beanInfo.fields) {
                    if (rPFieldInfo.fieldClass == String.class) {
                        rPFieldInfo.set(newInstance, "");
                    }
                }
            }
            return newInstance;
        } catch (Exception e2) {
            throw new RPJSONException("create instance error, class " + this.clazz.getName(), e2);
        }
    }

    @Override // com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null);
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        if (str == null) {
            return null;
        }
        int i10 = 0;
        if (!this.beanInfo.ordered) {
            int length = this.sortedFieldDeserializers.length - 1;
            while (i10 <= length) {
                int i11 = (i10 + length) >>> 1;
                int compareTo = this.sortedFieldDeserializers[i11].fieldInfo.name.compareTo(str);
                if (compareTo < 0) {
                    i10 = i11 + 1;
                } else {
                    if (compareTo <= 0) {
                        return this.sortedFieldDeserializers[i11];
                    }
                    length = i11 - 1;
                }
            }
            Map<String, FieldDeserializer> map = this.alterNameFieldDeserializers;
            if (map != null) {
                return map.get(str);
            }
            return null;
        }
        while (true) {
            FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
            if (i10 >= fieldDeserializerArr.length) {
                return null;
            }
            FieldDeserializer fieldDeserializer = fieldDeserializerArr[i10];
            if (fieldDeserializer.fieldInfo.name.equalsIgnoreCase(str)) {
                return fieldDeserializer;
            }
            i10++;
        }
    }

    public FieldDeserializer getFieldDeserializerByHash(long j10) {
        int i10 = 0;
        while (true) {
            FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
            if (i10 >= fieldDeserializerArr.length) {
                return null;
            }
            FieldDeserializer fieldDeserializer = fieldDeserializerArr[i10];
            if (fieldDeserializer.fieldInfo.nameHashCode == j10) {
                return fieldDeserializer;
            }
            i10++;
        }
    }

    public JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        RPJSONType rPJSONType = javaBeanInfo.jsonType;
        if (rPJSONType == null) {
            return null;
        }
        for (Class<?> cls : rPJSONType.seeAlso()) {
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    public void parseExtra(DefaultJSONParser defaultJSONParser, Object obj, String str) {
        Object parseObject;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if ((jSONLexer.features & Feature.IgnoreNotMatch.mask) != 0) {
            jSONLexer.nextTokenWithChar(ShortcutConstants.SERVICES_SEPARATOR);
            Type type = null;
            List<ExtraTypeProvider> list = defaultJSONParser.extraTypeProviders;
            if (list != null) {
                Iterator<ExtraTypeProvider> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    type = iterator2.next().getExtraType(obj, str);
                }
            }
            if (type == null) {
                parseObject = defaultJSONParser.parse();
            } else {
                parseObject = defaultJSONParser.parseObject(type);
            }
            if (obj instanceof ExtraProcessable) {
                ((ExtraProcessable) obj).processExtra(str, parseObject);
                return;
            }
            List<ExtraProcessor> list2 = defaultJSONParser.extraProcessors;
            if (list2 != null) {
                Iterator<ExtraProcessor> iterator22 = list2.iterator2();
                while (iterator22.hasNext()) {
                    iterator22.next().processExtra(obj, str, parseObject);
                }
                return;
            }
            return;
        }
        throw new RPJSONException("setter not found, class " + this.clazz.getName() + ", property " + str);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type, JavaBeanInfo javaBeanInfo) {
        this.clazz = cls;
        this.beanInfo = javaBeanInfo;
        RPFieldInfo[] rPFieldInfoArr = javaBeanInfo.sortedFields;
        this.sortedFieldDeserializers = new FieldDeserializer[rPFieldInfoArr.length];
        int length = rPFieldInfoArr.length;
        HashMap hashMap = null;
        for (int i10 = 0; i10 < length; i10++) {
            RPFieldInfo rPFieldInfo = javaBeanInfo.sortedFields[i10];
            FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, cls, rPFieldInfo);
            this.sortedFieldDeserializers[i10] = createFieldDeserializer;
            for (String str : rPFieldInfo.alternateNames) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, createFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = hashMap;
        RPFieldInfo[] rPFieldInfoArr2 = javaBeanInfo.fields;
        this.fieldDeserializers = new FieldDeserializer[rPFieldInfoArr2.length];
        int length2 = rPFieldInfoArr2.length;
        for (int i11 = 0; i11 < length2; i11++) {
            this.fieldDeserializers[i11] = getFieldDeserializer(javaBeanInfo.fields[i11].name);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x02de, code lost:
    
        r14.nextTokenWithChar(com.android.internal.accessibility.common.ShortcutConstants.SERVICES_SEPARATOR);
        r0 = r14.token;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02e4, code lost:
    
        if (r0 != 4) goto L269;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02e6, code lost:
    
        r0 = r14.stringVal();
        r1 = "@".equals(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02f0, code lost:
    
        if (r1 == 0) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02f2, code lost:
    
        r1 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02f6, code lost:
    
        r2 = (T) r1.object;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x034d, code lost:
    
        r14.nextToken(13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0352, code lost:
    
        if (r14.token != 13) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0354, code lost:
    
        r14.nextToken(16);
        r45.setContext(r1, r2, r47);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x035c, code lost:
    
        r3 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x035e, code lost:
    
        if (r3 == null) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0360, code lost:
    
        r3.object = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0362, code lost:
    
        r45.setContext(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0365, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0366, code lost:
    
        r3 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x036f, code lost:
    
        throw new com.alibaba.security.common.json.RPJSONException("illegal ref");
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0370, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0375, code lost:
    
        r11 = r1;
        r10 = r2;
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0372, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0373, code lost:
    
        r3 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x02fe, code lost:
    
        r1 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0306, code lost:
    
        if ("..".equals(r0) == false) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0308, code lost:
    
        r2 = r1.parent;
        r3 = r2.object;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x030c, code lost:
    
        if (r3 == null) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x030e, code lost:
    
        r21 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x031c, code lost:
    
        r2 = (T) r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0311, code lost:
    
        r45.addResolveTask(new com.alibaba.security.common.json.parser.DefaultJSONParser.ResolveTask(r2, r0));
        r45.resolveStatus = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0325, code lost:
    
        if ("$".equals(r0) == false) goto L248;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0327, code lost:
    
        r2 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0328, code lost:
    
        r3 = r2.parent;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x032a, code lost:
    
        if (r3 == null) goto L588;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x032c, code lost:
    
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x032e, code lost:
    
        r3 = r2.object;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0330, code lost:
    
        if (r3 == null) goto L246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0333, code lost:
    
        r45.addResolveTask(new com.alibaba.security.common.json.parser.DefaultJSONParser.ResolveTask(r2, r0));
        r45.resolveStatus = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x033f, code lost:
    
        r45.addResolveTask(new com.alibaba.security.common.json.parser.DefaultJSONParser.ResolveTask(r1, r0));
        r45.resolveStatus = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x037a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x037b, code lost:
    
        r3 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x039e, code lost:
    
        r11 = r1;
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x02f8, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x02f9, code lost:
    
        r11 = r1;
        r10 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x037e, code lost:
    
        r1 = r22;
        r3 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x039c, code lost:
    
        throw new com.alibaba.security.common.json.RPJSONException("illegal ref, " + com.alibaba.security.common.json.parser.JSONToken.name(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x039d, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x03b7, code lost:
    
        if (r0.equals(r4) == false) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0763, code lost:
    
        throw new com.alibaba.security.common.json.RPJSONException("syntax error, unexpect token " + com.alibaba.security.common.json.parser.JSONToken.name(r0.token));
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x067f, code lost:
    
        r21 = r25;
        r6 = r40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x040e, code lost:
    
        r3 = getSeeAlso(r45.config, r44.beanInfo, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x0416, code lost:
    
        if (r3 != null) goto L313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x0418, code lost:
    
        r3 = com.alibaba.security.common.json.util.RPTypeUtils.loadClass(r1, r45.config.defaultClassLoader);
        r2 = com.alibaba.security.common.json.util.RPTypeUtils.getClass(r46);
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x0424, code lost:
    
        if (r2 == null) goto L311;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x0426, code lost:
    
        if (r3 == null) goto L309;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x042c, code lost:
    
        if (r2.isAssignableFrom(r3) == false) goto L309;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x0436, code lost:
    
        throw new com.alibaba.security.common.json.RPJSONException("type not match");
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x043d, code lost:
    
        r3 = r45.config.getDeserializer(r3);
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x0446, code lost:
    
        if ((r3 instanceof com.alibaba.security.common.json.parser.JavaBeanDeserializer) == false) goto L320;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x0448, code lost:
    
        r3 = r3;
        r2 = (T) r3.deserialze(r45, r2, r47, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x044f, code lost:
    
        if (r0 == null) goto L321;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x0451, code lost:
    
        r3.getFieldDeserializer(r0).setValue(r2, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x045f, code lost:
    
        if (r40 == null) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x0461, code lost:
    
        r40.object = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x0465, code lost:
    
        r45.setContext(r41);
     */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x046a, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x0459, code lost:
    
        r2 = (T) r3.deserialze(r45, r2, r47);
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x0443, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x046b, code lost:
    
        r3 = r21;
        r4 = r41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x0478, code lost:
    
        throw new com.alibaba.security.common.json.RPJSONException("syntax error");
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x0479, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x047a, code lost:
    
        r6 = r40;
        r10 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x004b, code lost:
    
        r11 = r4;
        r10 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x02b7, code lost:
    
        r14.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x02bc, code lost:
    
        r41 = r22;
        r40 = r25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0779  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x04ba A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0679  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x067a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0067 A[Catch: all -> 0x0048, TRY_LEAVE, TryCatch #3 {all -> 0x0048, blocks: (B:17:0x0038, B:19:0x003d, B:25:0x0052, B:27:0x0058, B:32:0x0067, B:39:0x0076, B:44:0x0082, B:46:0x008c, B:49:0x0093, B:51:0x00a8, B:52:0x00b0, B:53:0x00b9, B:59:0x00c0), top: B:15:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0631  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x04a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02a5  */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v44 */
    /* JADX WARN: Type inference failed for: r1v56, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v58, types: [com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.alibaba.security.common.json.parser.deserializer.FieldDeserializer] */
    /* JADX WARN: Type inference failed for: r3v77 */
    /* JADX WARN: Type inference failed for: r3v78, types: [com.alibaba.security.common.json.parser.deserializer.FieldDeserializer[]] */
    /* JADX WARN: Type inference failed for: r3v79, types: [com.alibaba.security.common.json.parser.deserializer.FieldDeserializer] */
    /* JADX WARN: Type inference failed for: r3v80 */
    /* JADX WARN: Type inference failed for: r3v83 */
    /* JADX WARN: Type inference failed for: r45v0, types: [com.alibaba.security.common.json.parser.DefaultJSONParser] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T> T deserialze(com.alibaba.security.common.json.parser.DefaultJSONParser r45, java.lang.reflect.Type r46, java.lang.Object r47, java.lang.Object r48) {
        /*
            Method dump skipped, instructions count: 1924
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.parser.JavaBeanDeserializer.deserialze(com.alibaba.security.common.json.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public Object createInstance(Map<String, Object> map, ParserConfig parserConfig) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        if (javaBeanInfo.creatorConstructor == null) {
            Object createInstance = createInstance((DefaultJSONParser) null, this.clazz);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                FieldDeserializer fieldDeserializer = getFieldDeserializer(entry.getKey());
                if (fieldDeserializer != null) {
                    Object value = entry.getValue();
                    RPFieldInfo rPFieldInfo = fieldDeserializer.fieldInfo;
                    Method method = rPFieldInfo.method;
                    if (method != null) {
                        method.invoke(createInstance, RPTypeUtils.cast(value, method.getGenericParameterTypes()[0], parserConfig));
                    } else {
                        rPFieldInfo.field.set(createInstance, RPTypeUtils.cast(value, rPFieldInfo.fieldType, parserConfig));
                    }
                }
            }
            return createInstance;
        }
        RPFieldInfo[] rPFieldInfoArr = javaBeanInfo.fields;
        int length = rPFieldInfoArr.length;
        Object[] objArr = new Object[length];
        for (int i10 = 0; i10 < length; i10++) {
            RPFieldInfo rPFieldInfo2 = rPFieldInfoArr[i10];
            Object obj = map.get(rPFieldInfo2.name);
            if (obj == null) {
                obj = RPTypeUtils.defaultValue(rPFieldInfo2.fieldClass);
            }
            objArr[i10] = obj;
        }
        Constructor<?> constructor = this.beanInfo.creatorConstructor;
        if (constructor == null) {
            return null;
        }
        try {
            return constructor.newInstance(objArr);
        } catch (Exception e2) {
            throw new RPJSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e2);
        }
    }
}
