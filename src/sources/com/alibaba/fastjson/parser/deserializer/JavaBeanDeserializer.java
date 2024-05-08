package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    private final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    public final JavaBeanInfo beanInfo;
    public final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private Map<String, FieldDeserializer> fieldDeserializerMap;
    private final FieldDeserializer[] fieldDeserializers;
    private transient long[] hashArray;
    private transient short[] hashArrayMapping;
    private transient long[] smartMatchHashArray;
    private transient short[] smartMatchHashArrayMapping;
    public final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls) {
        this(parserConfig, cls, cls);
    }

    private Object createFactoryInstance(ParserConfig parserConfig, Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        return this.beanInfo.factoryMethod.invoke(null, obj);
    }

    public static boolean isSetFlag(int i10, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        int i11 = i10 / 32;
        int i12 = i10 % 32;
        if (i11 < iArr.length) {
            if (((1 << i12) & iArr[i11]) != 0) {
                return true;
            }
        }
        return false;
    }

    public static void parseArray(Collection collection, ObjectDeserializer objectDeserializer, DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
        int i10 = jSONLexerBase.token();
        if (i10 == 8) {
            jSONLexerBase.nextToken(16);
            jSONLexerBase.token();
            return;
        }
        if (i10 != 14) {
            defaultJSONParser.throwException(i10);
        }
        if (jSONLexerBase.getCurrent() == '[') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(14);
        } else {
            jSONLexerBase.nextToken(14);
        }
        if (jSONLexerBase.token() == 15) {
            jSONLexerBase.nextToken();
            return;
        }
        int i11 = 0;
        while (true) {
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type, Integer.valueOf(i11)));
            i11++;
            if (jSONLexerBase.token() != 16) {
                break;
            }
            if (jSONLexerBase.getCurrent() == '[') {
                jSONLexerBase.next();
                jSONLexerBase.setToken(14);
            } else {
                jSONLexerBase.nextToken(14);
            }
        }
        int i12 = jSONLexerBase.token();
        if (i12 != 15) {
            defaultJSONParser.throwException(i12);
        }
        if (jSONLexerBase.getCurrent() == ',') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(16);
        } else {
            jSONLexerBase.nextToken(16);
        }
    }

    public void check(JSONLexer jSONLexer, int i10) {
        if (jSONLexer.token() != i10) {
            throw new JSONException("syntax error");
        }
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        Object newInstance;
        if ((type instanceof Class) && this.clazz.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
        }
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        Constructor<?> constructor = javaBeanInfo.defaultConstructor;
        Object obj = null;
        if (constructor == null && javaBeanInfo.factoryMethod == null) {
            return null;
        }
        Method method = javaBeanInfo.factoryMethod;
        if (method != null && javaBeanInfo.defaultConstructorParameterSize > 0) {
            return null;
        }
        try {
            if (javaBeanInfo.defaultConstructorParameterSize != 0) {
                ParseContext context = defaultJSONParser.getContext();
                if (context != null && context.object != null) {
                    if (type instanceof Class) {
                        String name = ((Class) type).getName();
                        String substring = name.substring(0, name.lastIndexOf(36));
                        Object obj2 = context.object;
                        String name2 = obj2.getClass().getName();
                        if (!name2.equals(substring)) {
                            ParseContext parseContext = context.parent;
                            if (parseContext == null || parseContext.object == null || !("java.util.ArrayList".equals(name2) || "java.util.List".equals(name2) || "java.util.Collection".equals(name2) || "java.util.Map".equals(name2) || "java.util.HashMap".equals(name2))) {
                                obj = obj2;
                            } else if (parseContext.object.getClass().getName().equals(substring)) {
                                obj = parseContext.object;
                            }
                            obj2 = obj;
                        }
                        if (obj2 != null && (!(obj2 instanceof Collection) || !((Collection) obj2).isEmpty())) {
                            newInstance = constructor.newInstance(obj2);
                        } else {
                            throw new JSONException("can't create non-static inner class instance.");
                        }
                    } else {
                        throw new JSONException("can't create non-static inner class instance.");
                    }
                } else {
                    throw new JSONException("can't create non-static inner class instance.");
                }
            } else if (constructor != null) {
                newInstance = constructor.newInstance(new Object[0]);
            } else {
                newInstance = method.invoke(null, new Object[0]);
            }
            if (defaultJSONParser != null && defaultJSONParser.lexer.isEnabled(Feature.InitStringFieldAsEmpty)) {
                for (FieldInfo fieldInfo : this.beanInfo.fields) {
                    if (fieldInfo.fieldClass == String.class) {
                        try {
                            fieldInfo.set(newInstance, "");
                        } catch (Exception e2) {
                            throw new JSONException("create instance error, class " + this.clazz.getName(), e2);
                        }
                    }
                }
            }
            return newInstance;
        } catch (JSONException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new JSONException("create instance error, class " + this.clazz.getName(), e11);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, 0);
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        Enum<?> scanEnum;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 14) {
            T t2 = (T) createInstance(defaultJSONParser, type);
            int i10 = 0;
            int length = this.sortedFieldDeserializers.length;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                char c4 = i10 == length + (-1) ? ']' : ',';
                FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i10];
                Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
                if (cls == Integer.TYPE) {
                    fieldDeserializer.setValue((Object) t2, jSONLexer.scanInt(c4));
                } else if (cls == String.class) {
                    fieldDeserializer.setValue((Object) t2, jSONLexer.scanString(c4));
                } else if (cls == Long.TYPE) {
                    fieldDeserializer.setValue(t2, jSONLexer.scanLong(c4));
                } else if (cls.isEnum()) {
                    char current = jSONLexer.getCurrent();
                    if (current == '\"' || current == 'n') {
                        scanEnum = jSONLexer.scanEnum(cls, defaultJSONParser.getSymbolTable(), c4);
                    } else if (current >= '0' && current <= '9') {
                        scanEnum = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.getConfig())).valueOf(jSONLexer.scanInt(c4));
                    } else {
                        scanEnum = scanEnum(jSONLexer, c4);
                    }
                    fieldDeserializer.setValue(t2, scanEnum);
                } else if (cls == Boolean.TYPE) {
                    fieldDeserializer.setValue(t2, jSONLexer.scanBoolean(c4));
                } else if (cls == Float.TYPE) {
                    fieldDeserializer.setValue(t2, Float.valueOf(jSONLexer.scanFloat(c4)));
                } else if (cls == Double.TYPE) {
                    fieldDeserializer.setValue(t2, Double.valueOf(jSONLexer.scanDouble(c4)));
                } else if (cls == Date.class && jSONLexer.getCurrent() == '1') {
                    fieldDeserializer.setValue(t2, new Date(jSONLexer.scanLong(c4)));
                } else if (cls == BigDecimal.class) {
                    fieldDeserializer.setValue(t2, jSONLexer.scanDecimal(c4));
                } else {
                    jSONLexer.nextToken(14);
                    FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                    fieldDeserializer.setValue(t2, defaultJSONParser.parseObject(fieldInfo.fieldType, fieldInfo.name));
                    if (jSONLexer.token() == 15) {
                        break;
                    }
                    check(jSONLexer, c4 == ']' ? 15 : 16);
                }
                i10++;
            }
            jSONLexer.nextToken(16);
            return t2;
        }
        throw new JSONException("error");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        return getFieldDeserializer(str, null);
    }

    public Type getFieldType(int i10) {
        return this.sortedFieldDeserializers[i10].fieldInfo.fieldType;
    }

    public JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        JSONType jSONType = javaBeanInfo.jsonType;
        if (jSONType == null) {
            return null;
        }
        for (Class<?> cls : jSONType.seeAlso()) {
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

    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        return parseField(defaultJSONParser, str, obj, type, map, null);
    }

    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i10) {
        return parseRest(defaultJSONParser, type, obj, obj2, i10, new int[0]);
    }

    public Enum<?> scanEnum(JSONLexer jSONLexer, char c4) {
        throw new JSONException("illegal enum. " + jSONLexer.info());
    }

    public FieldDeserializer smartMatch(String str) {
        return smartMatch(str, null);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, JavaBeanInfo.build(cls, type, parserConfig.propertyNamingStrategy, parserConfig.fieldBased, parserConfig.compatibleWithJavaBean, parserConfig.isJacksonCompatible()));
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, int i10) {
        return (T) deserialze(defaultJSONParser, type, obj, null, i10, null);
    }

    public FieldDeserializer getFieldDeserializer(String str, int[] iArr) {
        FieldDeserializer fieldDeserializer;
        if (str == null) {
            return null;
        }
        Map<String, FieldDeserializer> map = this.fieldDeserializerMap;
        if (map != null && (fieldDeserializer = map.get(str)) != null) {
            return fieldDeserializer;
        }
        int i10 = 0;
        int length = this.sortedFieldDeserializers.length - 1;
        while (i10 <= length) {
            int i11 = (i10 + length) >>> 1;
            int compareTo = this.sortedFieldDeserializers[i11].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i10 = i11 + 1;
            } else {
                if (compareTo <= 0) {
                    if (isSetFlag(i11, iArr)) {
                        return null;
                    }
                    return this.sortedFieldDeserializers[i11];
                }
                length = i11 - 1;
            }
        }
        Map<String, FieldDeserializer> map2 = this.alterNameFieldDeserializers;
        if (map2 != null) {
            return map2.get(str);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d9  */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean parseField(com.alibaba.fastjson.parser.DefaultJSONParser r22, java.lang.String r23, java.lang.Object r24, java.lang.reflect.Type r25, java.util.Map<java.lang.String, java.lang.Object> r26, int[] r27) {
        /*
            Method dump skipped, instructions count: 518
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.parseField(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.String, java.lang.Object, java.lang.reflect.Type, java.util.Map, int[]):boolean");
    }

    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i10, int[] iArr) {
        return deserialze(defaultJSONParser, type, obj, obj2, i10, iArr);
    }

    public Enum scanEnum(JSONLexerBase jSONLexerBase, char[] cArr, ObjectDeserializer objectDeserializer) {
        EnumDeserializer enumDeserializer = objectDeserializer instanceof EnumDeserializer ? (EnumDeserializer) objectDeserializer : null;
        if (enumDeserializer == null) {
            jSONLexerBase.matchStat = -1;
            return null;
        }
        long scanEnumSymbol = jSONLexerBase.scanEnumSymbol(cArr);
        if (jSONLexerBase.matchStat <= 0) {
            return null;
        }
        Enum enumByHashCode = enumDeserializer.getEnumByHashCode(scanEnumSymbol);
        if (enumByHashCode == null) {
            if (scanEnumSymbol == -3750763034362895579L) {
                return null;
            }
            if (jSONLexerBase.isEnabled(Feature.ErrorOnEnumNotMatch)) {
                throw new JSONException("not match enum value, " + ((Object) enumDeserializer.enumClass));
            }
        }
        return enumByHashCode;
    }

    public FieldDeserializer smartMatch(String str, int[] iArr) {
        boolean z10;
        if (str == null) {
            return null;
        }
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str, iArr);
        if (fieldDeserializer == null) {
            long fnv1a_64_lower = TypeUtils.fnv1a_64_lower(str);
            int i10 = 0;
            if (this.smartMatchHashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                int i11 = 0;
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i11 >= fieldDeserializerArr.length) {
                        break;
                    }
                    jArr[i11] = TypeUtils.fnv1a_64_lower(fieldDeserializerArr[i11].fieldInfo.name);
                    i11++;
                }
                Arrays.sort(jArr);
                this.smartMatchHashArray = jArr;
            }
            int binarySearch = Arrays.binarySearch(this.smartMatchHashArray, fnv1a_64_lower);
            if (binarySearch < 0) {
                z10 = str.startsWith("is");
                if (z10) {
                    binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(str.substring(2)));
                }
            } else {
                z10 = false;
            }
            if (binarySearch >= 0) {
                if (this.smartMatchHashArrayMapping == null) {
                    short[] sArr = new short[this.smartMatchHashArray.length];
                    Arrays.fill(sArr, (short) -1);
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i10 >= fieldDeserializerArr2.length) {
                            break;
                        }
                        int binarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(fieldDeserializerArr2[i10].fieldInfo.name));
                        if (binarySearch2 >= 0) {
                            sArr[binarySearch2] = (short) i10;
                        }
                        i10++;
                    }
                    this.smartMatchHashArrayMapping = sArr;
                }
                short s2 = this.smartMatchHashArrayMapping[binarySearch];
                if (s2 != -1 && !isSetFlag(s2, iArr)) {
                    fieldDeserializer = this.sortedFieldDeserializers[s2];
                }
            }
            if (fieldDeserializer != null) {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                if ((fieldInfo.parserFeatures & Feature.DisableFieldSmartMatch.mask) != 0) {
                    return null;
                }
                Class<?> cls = fieldInfo.fieldClass;
                if (z10 && cls != Boolean.TYPE && cls != Boolean.class) {
                    return null;
                }
            }
        }
        return fieldDeserializer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:159:0x03be, code lost:
    
        if (r13.isEnabled(com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas) != false) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x04d8, code lost:
    
        r11 = r28;
        r1 = getSeeAlso(r11, r33.beanInfo, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x04e0, code lost:
    
        if (r1 != null) goto L382;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x04e2, code lost:
    
        r7 = r11.checkAutoType(r0, com.alibaba.fastjson.util.TypeUtils.getClass(r35), r13.getFeatures());
        r1 = r34.getConfig().getDeserializer(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x04f8, code lost:
    
        r2 = (T) r1.deserialze(r34, r7, r36);
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x04fe, code lost:
    
        if ((r1 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L388;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0500, code lost:
    
        r1 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0502, code lost:
    
        if (r3 == null) goto L388;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0504, code lost:
    
        r1.getFieldDeserializer(r3).setValue((java.lang.Object) r2, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x050b, code lost:
    
        if (r4 == null) goto L390;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x050d, code lost:
    
        r4.object = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0511, code lost:
    
        r34.setContext(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0514, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x04f7, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0524, code lost:
    
        r7 = r4;
        r31 = r6;
        r0 = r20;
        r38 = 0;
        r1 = r1;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0691, code lost:
    
        if (r12 != null) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x08be, code lost:
    
        r3 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x08c0, code lost:
    
        r0 = r33.beanInfo.buildMethod;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x08c4, code lost:
    
        if (r0 != null) goto L650;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x08c6, code lost:
    
        if (r7 == null) goto L648;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x08c8, code lost:
    
        r7.object = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x08ca, code lost:
    
        r34.setContext(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x08cd, code lost:
    
        return (T) r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x08cf, code lost:
    
        r0 = (T) r0.invoke(r12, new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x08d5, code lost:
    
        if (r7 == null) goto L654;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x08d7, code lost:
    
        r7.object = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x08d9, code lost:
    
        r34.setContext(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x08dc, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x08dd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x08e5, code lost:
    
        throw new com.alibaba.fastjson.JSONException("build object error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x08e6, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0693, code lost:
    
        if (r0 != null) goto L495;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x06b2, code lost:
    
        r3 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x06b4, code lost:
    
        r1 = r33.beanInfo;
        r2 = r1.creatorConstructorParameters;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x06ba, code lost:
    
        if (r2 == null) goto L549;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x06bc, code lost:
    
        r1 = new java.lang.Object[r2.length];
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x06c1, code lost:
    
        if (r5 >= r2.length) goto L744;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x06c3, code lost:
    
        r6 = r0.remove(r2[r5]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x06c9, code lost:
    
        if (r6 != null) goto L532;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x06cb, code lost:
    
        r10 = r33.beanInfo;
        r11 = r10.creatorConstructorParameterTypes[r5];
        r10 = r10.fields[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x06d7, code lost:
    
        if (r11 != java.lang.Byte.TYPE) goto L508;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x06d9, code lost:
    
        r6 = java.lang.Byte.valueOf(r38);
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x06dd, code lost:
    
        r13 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x075a, code lost:
    
        r1[r5] = r6;
        r5 = r5 + 1;
        r30 = r13;
        r38 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x06e2, code lost:
    
        if (r11 != java.lang.Short.TYPE) goto L511;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x06e4, code lost:
    
        r6 = java.lang.Short.valueOf(r38);
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x06eb, code lost:
    
        if (r11 != java.lang.Integer.TYPE) goto L514;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x06ed, code lost:
    
        r6 = java.lang.Integer.valueOf(r38);
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x06f4, code lost:
    
        if (r11 != java.lang.Long.TYPE) goto L517;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x06f6, code lost:
    
        r6 = 0L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x06fd, code lost:
    
        if (r11 != java.lang.Float.TYPE) goto L520;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x06ff, code lost:
    
        r6 = java.lang.Float.valueOf(0.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0706, code lost:
    
        if (r11 != java.lang.Double.TYPE) goto L523;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x0708, code lost:
    
        r6 = java.lang.Double.valueOf(com.google.android.material.shadow.ShadowDrawableWrapper.COS_45);
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x070f, code lost:
    
        if (r11 != java.lang.Boolean.TYPE) goto L526;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x0711, code lost:
    
        r6 = java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x0714, code lost:
    
        r13 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x0716, code lost:
    
        if (r11 != r13) goto L531;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x071f, code lost:
    
        if ((r10.parserFeatures & com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty.mask) == 0) goto L531;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x0721, code lost:
    
        r6 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x0724, code lost:
    
        r13 = r30;
        r10 = r33.beanInfo.creatorConstructorParameterTypes;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x072a, code lost:
    
        if (r10 == null) goto L531;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x072d, code lost:
    
        if (r5 >= r10.length) goto L531;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x072f, code lost:
    
        r10 = r10[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x0733, code lost:
    
        if ((r10 instanceof java.lang.Class) == false) goto L531;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x0735, code lost:
    
        r10 = (java.lang.Class) r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x073b, code lost:
    
        if (r10.isInstance(r6) != false) goto L531;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x073f, code lost:
    
        if ((r6 instanceof java.util.List) == false) goto L531;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x0741, code lost:
    
        r11 = (java.util.List) r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x0749, code lost:
    
        if (r11.size() != 1) goto L531;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x0754, code lost:
    
        if (r10.isInstance(r11.get(0)) == false) goto L747;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x0756, code lost:
    
        r6 = r11.get(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x0764, code lost:
    
        r13 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x07d9, code lost:
    
        r4 = r33.beanInfo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x07dd, code lost:
    
        if (r4.creatorConstructor == null) goto L632;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x07e1, code lost:
    
        if (r4.f2141kotlin == false) goto L598;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x07e3, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x07e5, code lost:
    
        if (r4 >= r1.length) goto L749;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x07e9, code lost:
    
        if (r1[r4] != null) goto L750;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x07eb, code lost:
    
        r5 = r33.beanInfo.fields;
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x07ef, code lost:
    
        if (r5 == null) goto L751;
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x07f2, code lost:
    
        if (r4 >= r5.length) goto L752;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x07f8, code lost:
    
        if (r5[r4].fieldClass != r13) goto L598;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x07fa, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x0800, code lost:
    
        if (r4 == false) goto L619;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x0831, code lost:
    
        r1 = r33.beanInfo.creatorConstructor.newInstance(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x0839, code lost:
    
        if (r2 == null) goto L628;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x083b, code lost:
    
        r0 = r0.entrySet().iterator2();
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x0847, code lost:
    
        if (r0.hasNext() == false) goto L753;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x0849, code lost:
    
        r2 = r0.next();
        r4 = getFieldDeserializer(r2.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x0859, code lost:
    
        if (r4 == null) goto L756;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x085b, code lost:
    
        r4.setValue(r1, r2.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x0863, code lost:
    
        r12 = (T) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x08b9, code lost:
    
        if (r7 == null) goto L644;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x08bb, code lost:
    
        r7.object = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x0865, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x088c, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error, " + ((java.lang.Object) r2) + ", " + r33.beanInfo.creatorConstructor.toGenericString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x0802, code lost:
    
        r4 = r33.beanInfo.kotlinDefaultConstructor;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x0806, code lost:
    
        if (r4 == null) goto L619;
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x0808, code lost:
    
        r4 = r4.newInstance(new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x080f, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x0811, code lost:
    
        if (r5 >= r1.length) goto L758;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x0813, code lost:
    
        r6 = r1[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x0815, code lost:
    
        if (r6 == null) goto L760;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x0817, code lost:
    
        r10 = r33.beanInfo.fields;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x081b, code lost:
    
        if (r10 == null) goto L761;
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x081e, code lost:
    
        if (r5 >= r10.length) goto L762;
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x0820, code lost:
    
        r10[r5].set(r4, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x0825, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x0828, code lost:
    
        r1 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x082e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x082a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x082b, code lost:
    
        r12 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x07fc, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x07ff, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x088d, code lost:
    
        r0 = r4.factoryMethod;
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x088f, code lost:
    
        if (r0 == null) goto L641;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x0896, code lost:
    
        r12 = (T) r0.invoke(null, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x0898, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x08b8, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create factory method error, " + r33.beanInfo.factoryMethod.toString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x0768, code lost:
    
        r13 = r30;
        r1 = r1.fields;
        r5 = r1.length;
        r6 = new java.lang.Object[r5];
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x0771, code lost:
    
        if (r10 >= r5) goto L763;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x0773, code lost:
    
        r11 = r1[r10];
        r15 = r0.get(r11.name);
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x077b, code lost:
    
        if (r15 != null) goto L578;
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x077d, code lost:
    
        r14 = r11.fieldType;
        r16 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x0783, code lost:
    
        if (r14 != java.lang.Byte.TYPE) goto L556;
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x0785, code lost:
    
        r15 = (byte) 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x07d0, code lost:
    
        r6[r10] = r15;
        r10 = r10 + 1;
        r1 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x078d, code lost:
    
        if (r14 != java.lang.Short.TYPE) goto L559;
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x078f, code lost:
    
        r15 = (short) 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:432:0x0797, code lost:
    
        if (r14 != java.lang.Integer.TYPE) goto L562;
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x0799, code lost:
    
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x07a1, code lost:
    
        if (r14 != java.lang.Long.TYPE) goto L565;
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x07a3, code lost:
    
        r15 = 0L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:440:0x07aa, code lost:
    
        if (r14 != java.lang.Float.TYPE) goto L568;
     */
    /* JADX WARN: Code restructure failed: missing block: B:441:0x07ac, code lost:
    
        r15 = java.lang.Float.valueOf(0.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:444:0x07b3, code lost:
    
        if (r14 != java.lang.Double.TYPE) goto L571;
     */
    /* JADX WARN: Code restructure failed: missing block: B:445:0x07b5, code lost:
    
        r15 = java.lang.Double.valueOf(com.google.android.material.shadow.ShadowDrawableWrapper.COS_45);
     */
    /* JADX WARN: Code restructure failed: missing block: B:448:0x07bc, code lost:
    
        if (r14 != java.lang.Boolean.TYPE) goto L574;
     */
    /* JADX WARN: Code restructure failed: missing block: B:449:0x07be, code lost:
    
        r15 = java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:451:0x07c1, code lost:
    
        if (r14 != r13) goto L772;
     */
    /* JADX WARN: Code restructure failed: missing block: B:453:0x07ca, code lost:
    
        if ((r11.parserFeatures & com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty.mask) == 0) goto L773;
     */
    /* JADX WARN: Code restructure failed: missing block: B:454:0x07cc, code lost:
    
        r15 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:458:0x07ce, code lost:
    
        r16 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:461:0x07d8, code lost:
    
        r1 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:463:0x0695, code lost:
    
        r1 = (T) createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r34, r35);
     */
    /* JADX WARN: Code restructure failed: missing block: B:464:0x0699, code lost:
    
        if (r7 != null) goto L488;
     */
    /* JADX WARN: Code restructure failed: missing block: B:465:0x069b, code lost:
    
        r3 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:466:0x069d, code lost:
    
        r7 = r34.setContext(r3, r1, r36);
     */
    /* JADX WARN: Code restructure failed: missing block: B:467:0x06a8, code lost:
    
        if (r7 == null) goto L491;
     */
    /* JADX WARN: Code restructure failed: missing block: B:468:0x06aa, code lost:
    
        r7.object = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:469:0x06ac, code lost:
    
        r34.setContext(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:470:0x06af, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:471:0x06a6, code lost:
    
        r3 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:473:0x06b0, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x06a2, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:476:0x06a3, code lost:
    
        r12 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:517:0x0934, code lost:
    
        throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token " + com.alibaba.fastjson.parser.JSONToken.name(r13.token()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:520:0x068a, code lost:
    
        r13.nextToken(16);
        r1 = r1;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:521:0x068d, code lost:
    
        r0 = r17;
        r7 = r28;
        r1 = r1;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:564:0x0659, code lost:
    
        r13.nextToken();
        r1 = r1;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:738:0x0360, code lost:
    
        if (r5 == (-2)) goto L293;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0954  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0072 A[Catch: all -> 0x004d, TRY_LEAVE, TryCatch #15 {all -> 0x004d, blocks: (B:17:0x003d, B:19:0x0042, B:25:0x0057, B:27:0x0062, B:29:0x0068, B:34:0x0072, B:41:0x0082, B:49:0x0098, B:70:0x00ea, B:72:0x00f0, B:77:0x00f7, B:81:0x0100, B:87:0x0118, B:91:0x0128, B:92:0x0131, B:93:0x0132, B:95:0x0153, B:96:0x015b, B:97:0x016e, B:122:0x0175), top: B:15:0x003b, inners: #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:486:0x0574 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:499:0x05b8  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x067f  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x0684 A[Catch: all -> 0x0941, TryCatch #0 {all -> 0x0941, blocks: (B:504:0x0677, B:508:0x0684, B:520:0x068a, B:552:0x064d, B:554:0x066f), top: B:503:0x0677 }] */
    /* JADX WARN: Removed duplicated region for block: B:548:0x0619  */
    /* JADX WARN: Removed duplicated region for block: B:584:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:737:0x035f  */
    /* JADX WARN: Type inference failed for: r1v156 */
    /* JADX WARN: Type inference failed for: r1v63 */
    /* JADX WARN: Type inference failed for: r1v70 */
    /* JADX WARN: Type inference failed for: r34v0, types: [com.alibaba.fastjson.parser.DefaultJSONParser] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.alibaba.fastjson.parser.ParseContext] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v41, types: [com.alibaba.fastjson.parser.ParseContext] */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v66 */
    /* JADX WARN: Type inference failed for: r3v67 */
    /* JADX WARN: Type inference failed for: r3v68 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r34, java.lang.reflect.Type r35, java.lang.Object r36, java.lang.Object r37, int r38, int[] r39) {
        /*
            Method dump skipped, instructions count: 2399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object, int, int[]):java.lang.Object");
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo) {
        this.clazz = javaBeanInfo.clazz;
        this.beanInfo = javaBeanInfo;
        FieldInfo[] fieldInfoArr = javaBeanInfo.sortedFields;
        this.sortedFieldDeserializers = new FieldDeserializer[fieldInfoArr.length];
        int length = fieldInfoArr.length;
        HashMap hashMap = null;
        for (int i10 = 0; i10 < length; i10++) {
            FieldInfo fieldInfo = javaBeanInfo.sortedFields[i10];
            FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, javaBeanInfo, fieldInfo);
            this.sortedFieldDeserializers[i10] = createFieldDeserializer;
            if (length > 128) {
                if (this.fieldDeserializerMap == null) {
                    this.fieldDeserializerMap = new HashMap();
                }
                this.fieldDeserializerMap.put(fieldInfo.name, createFieldDeserializer);
            }
            for (String str : fieldInfo.alternateNames) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, createFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = hashMap;
        FieldInfo[] fieldInfoArr2 = javaBeanInfo.fields;
        this.fieldDeserializers = new FieldDeserializer[fieldInfoArr2.length];
        int length2 = fieldInfoArr2.length;
        for (int i11 = 0; i11 < length2; i11++) {
            this.fieldDeserializers[i11] = getFieldDeserializer(javaBeanInfo.fields[i11].name);
        }
    }

    public FieldDeserializer getFieldDeserializer(long j10) {
        int i10 = 0;
        if (this.hashArray == null) {
            long[] jArr = new long[this.sortedFieldDeserializers.length];
            int i11 = 0;
            while (true) {
                FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i11 >= fieldDeserializerArr.length) {
                    break;
                }
                jArr[i11] = TypeUtils.fnv1a_64(fieldDeserializerArr[i11].fieldInfo.name);
                i11++;
            }
            Arrays.sort(jArr);
            this.hashArray = jArr;
        }
        int binarySearch = Arrays.binarySearch(this.hashArray, j10);
        if (binarySearch < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, (short) -1);
            while (true) {
                FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                if (i10 >= fieldDeserializerArr2.length) {
                    break;
                }
                int binarySearch2 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(fieldDeserializerArr2[i10].fieldInfo.name));
                if (binarySearch2 >= 0) {
                    sArr[binarySearch2] = (short) i10;
                }
                i10++;
            }
            this.hashArrayMapping = sArr;
        }
        short s2 = this.hashArrayMapping[binarySearch];
        if (s2 != -1) {
            return this.sortedFieldDeserializers[s2];
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:188:0x01eb, code lost:
    
        if (r13[r12].fieldClass == java.lang.String.class) goto L136;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object createInstance(java.util.Map<java.lang.String, java.lang.Object> r12, com.alibaba.fastjson.parser.ParserConfig r13) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 651
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.createInstance(java.util.Map, com.alibaba.fastjson.parser.ParserConfig):java.lang.Object");
    }
}
