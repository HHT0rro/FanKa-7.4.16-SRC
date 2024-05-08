package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class JavaBeanSerializer extends SerializeFilterable implements ObjectSerializer {
    public SerializeBeanInfo beanInfo;
    public final FieldSerializer[] getters;
    private volatile transient long[] hashArray;
    private volatile transient short[] hashArrayMapping;
    public final FieldSerializer[] sortedGetters;

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (Map<String, String>) null);
    }

    public static Map<String, String> createAliasMap(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public boolean applyLabel(JSONSerializer jSONSerializer, String str) {
        List<LabelFilter> list = jSONSerializer.labelFilters;
        if (list != null) {
            Iterator<LabelFilter> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                if (!iterator2.next().apply(str)) {
                    return false;
                }
            }
        }
        List<LabelFilter> list2 = this.labelFilters;
        if (list2 == null) {
            return true;
        }
        Iterator<LabelFilter> iterator22 = list2.iterator2();
        while (iterator22.hasNext()) {
            if (!iterator22.next().apply(str)) {
                return false;
            }
        }
        return true;
    }

    public BeanContext getBeanContext(int i10) {
        return this.sortedGetters[i10].fieldContext;
    }

    public Set<String> getFieldNames(Object obj) throws Exception {
        HashSet hashSet = new HashSet();
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                hashSet.add(fieldSerializer.fieldInfo.name);
            }
        }
        return hashSet;
    }

    public FieldSerializer getFieldSerializer(String str) {
        if (str == null) {
            return null;
        }
        int i10 = 0;
        int length = this.sortedGetters.length - 1;
        while (i10 <= length) {
            int i11 = (i10 + length) >>> 1;
            int compareTo = this.sortedGetters[i11].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i10 = i11 + 1;
            } else {
                if (compareTo <= 0) {
                    return this.sortedGetters[i11];
                }
                length = i11 - 1;
            }
        }
        return null;
    }

    public Type getFieldType(int i10) {
        return this.sortedGetters[i10].fieldInfo.fieldType;
    }

    public Object getFieldValue(Object obj, String str) {
        FieldSerializer fieldSerializer = getFieldSerializer(str);
        if (fieldSerializer != null) {
            try {
                return fieldSerializer.getPropertyValue(obj);
            } catch (IllegalAccessException e2) {
                throw new JSONException("getFieldValue error." + str, e2);
            } catch (InvocationTargetException e10) {
                throw new JSONException("getFieldValue error." + str, e10);
            }
        }
        throw new JSONException("field not found. " + str);
    }

    public List<Object> getFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            arrayList.add(fieldSerializer.getPropertyValue(obj));
        }
        return arrayList;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            boolean isEnabled = SerializerFeature.isEnabled(fieldSerializer.features, SerializerFeature.SkipTransientField);
            FieldInfo fieldInfo = fieldSerializer.fieldInfo;
            if (!isEnabled || fieldInfo == null || !fieldInfo.fieldTransient) {
                linkedHashMap.put(fieldInfo.name, fieldSerializer.getPropertyValue(obj));
            }
        }
        return linkedHashMap;
    }

    public List<Object> getObjectFieldValues(Object obj) throws Exception {
        ArrayList arrayList = new ArrayList(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            Class<?> cls = fieldSerializer.fieldInfo.fieldClass;
            if (!cls.isPrimitive() && !cls.getName().startsWith("java.lang.")) {
                arrayList.add(fieldSerializer.getPropertyValue(obj));
            }
        }
        return arrayList;
    }

    public int getSize(Object obj) throws Exception {
        int i10 = 0;
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                i10++;
            }
        }
        return i10;
    }

    public Class<?> getType() {
        return this.beanInfo.beanType;
    }

    public boolean isWriteAsArray(JSONSerializer jSONSerializer) {
        return isWriteAsArray(jSONSerializer, 0);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i10) throws IOException {
        write(jSONSerializer, obj, obj2, type, i10, false);
    }

    public char writeAfter(JSONSerializer jSONSerializer, Object obj, char c4) {
        List<AfterFilter> list = jSONSerializer.afterFilters;
        if (list != null) {
            Iterator<AfterFilter> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                c4 = iterator2.next().writeAfter(jSONSerializer, obj, c4);
            }
        }
        List<AfterFilter> list2 = this.afterFilters;
        if (list2 != null) {
            Iterator<AfterFilter> iterator22 = list2.iterator2();
            while (iterator22.hasNext()) {
                c4 = iterator22.next().writeAfter(jSONSerializer, obj, c4);
            }
        }
        return c4;
    }

    public void writeAsArray(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i10) throws IOException {
        write(jSONSerializer, obj, obj2, type, i10);
    }

    public void writeAsArrayNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i10) throws IOException {
        write(jSONSerializer, obj, obj2, type, i10);
    }

    public char writeBefore(JSONSerializer jSONSerializer, Object obj, char c4) {
        List<BeforeFilter> list = jSONSerializer.beforeFilters;
        if (list != null) {
            Iterator<BeforeFilter> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                c4 = iterator2.next().writeBefore(jSONSerializer, obj, c4);
            }
        }
        List<BeforeFilter> list2 = this.beforeFilters;
        if (list2 != null) {
            Iterator<BeforeFilter> iterator22 = list2.iterator2();
            while (iterator22.hasNext()) {
                c4 = iterator22.next().writeBefore(jSONSerializer, obj, c4);
            }
        }
        return c4;
    }

    public void writeClassName(JSONSerializer jSONSerializer, String str, Object obj) {
        if (str == null) {
            str = jSONSerializer.config.typeKey;
        }
        jSONSerializer.out.writeFieldName(str, false);
        String str2 = this.beanInfo.typeName;
        if (str2 == null) {
            Class<?> cls = obj.getClass();
            if (TypeUtils.isProxy(cls)) {
                cls = cls.getSuperclass();
            }
            str2 = cls.getName();
        }
        jSONSerializer.write(str2);
    }

    public void writeDirectNonContext(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i10) throws IOException {
        write(jSONSerializer, obj, obj2, type, i10);
    }

    public void writeNoneASM(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i10) throws IOException {
        write(jSONSerializer, obj, obj2, type, i10, false);
    }

    public boolean writeReference(JSONSerializer jSONSerializer, Object obj, int i10) {
        IdentityHashMap<Object, SerialContext> identityHashMap;
        SerialContext serialContext = jSONSerializer.context;
        int i11 = SerializerFeature.DisableCircularReferenceDetect.mask;
        if (serialContext == null || (serialContext.features & i11) != 0 || (i10 & i11) != 0 || (identityHashMap = jSONSerializer.references) == null || !identityHashMap.containsKey(obj)) {
            return false;
        }
        jSONSerializer.writeReference(obj);
        return true;
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, createAliasMap(strArr));
    }

    public boolean isWriteAsArray(JSONSerializer jSONSerializer, int i10) {
        int i11 = SerializerFeature.BeanToArray.mask;
        return ((this.beanInfo.features & i11) == 0 && !jSONSerializer.out.beanToArray && (i10 & i11) == 0) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:159:0x028f, code lost:
    
        if ((r33.beanInfo.features & r4) == 0) goto L239;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0426, code lost:
    
        if (r0 == false) goto L314;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x00f7, code lost:
    
        if (r11.fieldTransient != false) goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:227:0x03f9 A[Catch: Exception -> 0x0434, all -> 0x0453, TryCatch #5 {Exception -> 0x0434, blocks: (B:74:0x0150, B:81:0x017b, B:84:0x01a3, B:86:0x01af, B:88:0x01ba, B:90:0x01c4, B:93:0x01ce, B:95:0x01d9, B:97:0x01dd, B:101:0x01e4, B:103:0x01e7, B:105:0x01ec, B:107:0x01f2, B:109:0x01fd, B:111:0x0201, B:114:0x0208, B:116:0x020b, B:119:0x0213, B:121:0x021b, B:123:0x0226, B:125:0x022a, B:128:0x0231, B:130:0x0234, B:132:0x0239, B:133:0x023e, B:135:0x0246, B:137:0x0251, B:139:0x0255, B:142:0x025c, B:144:0x025f, B:146:0x0264, B:148:0x026b, B:150:0x026f, B:154:0x027d, B:156:0x0281, B:158:0x028a, B:160:0x0291, B:162:0x0297, B:164:0x029b, B:167:0x02a6, B:169:0x02aa, B:171:0x02ae, B:174:0x02b9, B:176:0x02bd, B:178:0x02c1, B:181:0x02cc, B:183:0x02d0, B:185:0x02d4, B:188:0x02e2, B:190:0x02e6, B:192:0x02ea, B:195:0x02f7, B:197:0x02fb, B:199:0x02ff, B:202:0x030d, B:204:0x0311, B:206:0x0315, B:210:0x0321, B:212:0x0325, B:214:0x0329, B:216:0x0334, B:218:0x0341, B:222:0x034d, B:223:0x0353, B:225:0x03f5, B:227:0x03f9, B:229:0x03fd, B:235:0x0407, B:237:0x040f, B:238:0x0417, B:240:0x041d, B:253:0x035e, B:254:0x0361, B:256:0x0367, B:258:0x0373, B:262:0x0388, B:267:0x0392, B:269:0x03a2, B:272:0x03aa, B:275:0x03b4, B:277:0x03bd, B:280:0x03c3, B:281:0x03c7, B:282:0x03cb, B:284:0x03d0, B:285:0x03d4, B:286:0x03d8, B:288:0x03dc, B:290:0x03e0, B:294:0x03ee, B:295:0x03f2, B:296:0x039a), top: B:73:0x0150 }] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0407 A[Catch: Exception -> 0x0434, all -> 0x0453, TryCatch #5 {Exception -> 0x0434, blocks: (B:74:0x0150, B:81:0x017b, B:84:0x01a3, B:86:0x01af, B:88:0x01ba, B:90:0x01c4, B:93:0x01ce, B:95:0x01d9, B:97:0x01dd, B:101:0x01e4, B:103:0x01e7, B:105:0x01ec, B:107:0x01f2, B:109:0x01fd, B:111:0x0201, B:114:0x0208, B:116:0x020b, B:119:0x0213, B:121:0x021b, B:123:0x0226, B:125:0x022a, B:128:0x0231, B:130:0x0234, B:132:0x0239, B:133:0x023e, B:135:0x0246, B:137:0x0251, B:139:0x0255, B:142:0x025c, B:144:0x025f, B:146:0x0264, B:148:0x026b, B:150:0x026f, B:154:0x027d, B:156:0x0281, B:158:0x028a, B:160:0x0291, B:162:0x0297, B:164:0x029b, B:167:0x02a6, B:169:0x02aa, B:171:0x02ae, B:174:0x02b9, B:176:0x02bd, B:178:0x02c1, B:181:0x02cc, B:183:0x02d0, B:185:0x02d4, B:188:0x02e2, B:190:0x02e6, B:192:0x02ea, B:195:0x02f7, B:197:0x02fb, B:199:0x02ff, B:202:0x030d, B:204:0x0311, B:206:0x0315, B:210:0x0321, B:212:0x0325, B:214:0x0329, B:216:0x0334, B:218:0x0341, B:222:0x034d, B:223:0x0353, B:225:0x03f5, B:227:0x03f9, B:229:0x03fd, B:235:0x0407, B:237:0x040f, B:238:0x0417, B:240:0x041d, B:253:0x035e, B:254:0x0361, B:256:0x0367, B:258:0x0373, B:262:0x0388, B:267:0x0392, B:269:0x03a2, B:272:0x03aa, B:275:0x03b4, B:277:0x03bd, B:280:0x03c3, B:281:0x03c7, B:282:0x03cb, B:284:0x03d0, B:285:0x03d4, B:286:0x03d8, B:288:0x03dc, B:290:0x03e0, B:294:0x03ee, B:295:0x03f2, B:296:0x039a), top: B:73:0x0150 }] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x03a2 A[Catch: Exception -> 0x0434, all -> 0x0453, TryCatch #5 {Exception -> 0x0434, blocks: (B:74:0x0150, B:81:0x017b, B:84:0x01a3, B:86:0x01af, B:88:0x01ba, B:90:0x01c4, B:93:0x01ce, B:95:0x01d9, B:97:0x01dd, B:101:0x01e4, B:103:0x01e7, B:105:0x01ec, B:107:0x01f2, B:109:0x01fd, B:111:0x0201, B:114:0x0208, B:116:0x020b, B:119:0x0213, B:121:0x021b, B:123:0x0226, B:125:0x022a, B:128:0x0231, B:130:0x0234, B:132:0x0239, B:133:0x023e, B:135:0x0246, B:137:0x0251, B:139:0x0255, B:142:0x025c, B:144:0x025f, B:146:0x0264, B:148:0x026b, B:150:0x026f, B:154:0x027d, B:156:0x0281, B:158:0x028a, B:160:0x0291, B:162:0x0297, B:164:0x029b, B:167:0x02a6, B:169:0x02aa, B:171:0x02ae, B:174:0x02b9, B:176:0x02bd, B:178:0x02c1, B:181:0x02cc, B:183:0x02d0, B:185:0x02d4, B:188:0x02e2, B:190:0x02e6, B:192:0x02ea, B:195:0x02f7, B:197:0x02fb, B:199:0x02ff, B:202:0x030d, B:204:0x0311, B:206:0x0315, B:210:0x0321, B:212:0x0325, B:214:0x0329, B:216:0x0334, B:218:0x0341, B:222:0x034d, B:223:0x0353, B:225:0x03f5, B:227:0x03f9, B:229:0x03fd, B:235:0x0407, B:237:0x040f, B:238:0x0417, B:240:0x041d, B:253:0x035e, B:254:0x0361, B:256:0x0367, B:258:0x0373, B:262:0x0388, B:267:0x0392, B:269:0x03a2, B:272:0x03aa, B:275:0x03b4, B:277:0x03bd, B:280:0x03c3, B:281:0x03c7, B:282:0x03cb, B:284:0x03d0, B:285:0x03d4, B:286:0x03d8, B:288:0x03dc, B:290:0x03e0, B:294:0x03ee, B:295:0x03f2, B:296:0x039a), top: B:73:0x0150 }] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x03f2 A[Catch: Exception -> 0x0434, all -> 0x0453, TryCatch #5 {Exception -> 0x0434, blocks: (B:74:0x0150, B:81:0x017b, B:84:0x01a3, B:86:0x01af, B:88:0x01ba, B:90:0x01c4, B:93:0x01ce, B:95:0x01d9, B:97:0x01dd, B:101:0x01e4, B:103:0x01e7, B:105:0x01ec, B:107:0x01f2, B:109:0x01fd, B:111:0x0201, B:114:0x0208, B:116:0x020b, B:119:0x0213, B:121:0x021b, B:123:0x0226, B:125:0x022a, B:128:0x0231, B:130:0x0234, B:132:0x0239, B:133:0x023e, B:135:0x0246, B:137:0x0251, B:139:0x0255, B:142:0x025c, B:144:0x025f, B:146:0x0264, B:148:0x026b, B:150:0x026f, B:154:0x027d, B:156:0x0281, B:158:0x028a, B:160:0x0291, B:162:0x0297, B:164:0x029b, B:167:0x02a6, B:169:0x02aa, B:171:0x02ae, B:174:0x02b9, B:176:0x02bd, B:178:0x02c1, B:181:0x02cc, B:183:0x02d0, B:185:0x02d4, B:188:0x02e2, B:190:0x02e6, B:192:0x02ea, B:195:0x02f7, B:197:0x02fb, B:199:0x02ff, B:202:0x030d, B:204:0x0311, B:206:0x0315, B:210:0x0321, B:212:0x0325, B:214:0x0329, B:216:0x0334, B:218:0x0341, B:222:0x034d, B:223:0x0353, B:225:0x03f5, B:227:0x03f9, B:229:0x03fd, B:235:0x0407, B:237:0x040f, B:238:0x0417, B:240:0x041d, B:253:0x035e, B:254:0x0361, B:256:0x0367, B:258:0x0373, B:262:0x0388, B:267:0x0392, B:269:0x03a2, B:272:0x03aa, B:275:0x03b4, B:277:0x03bd, B:280:0x03c3, B:281:0x03c7, B:282:0x03cb, B:284:0x03d0, B:285:0x03d4, B:286:0x03d8, B:288:0x03dc, B:290:0x03e0, B:294:0x03ee, B:295:0x03f2, B:296:0x039a), top: B:73:0x0150 }] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x04c7 A[Catch: all -> 0x04da, TRY_ENTER, TryCatch #13 {all -> 0x04da, blocks: (B:316:0x04c7, B:317:0x0517, B:319:0x051d, B:320:0x0535, B:322:0x0539, B:325:0x0542, B:326:0x0547, B:330:0x04de, B:332:0x04e2, B:334:0x04e6, B:335:0x0501), top: B:314:0x04c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x051d A[Catch: all -> 0x04da, TryCatch #13 {all -> 0x04da, blocks: (B:316:0x04c7, B:317:0x0517, B:319:0x051d, B:320:0x0535, B:322:0x0539, B:325:0x0542, B:326:0x0547, B:330:0x04de, B:332:0x04e2, B:334:0x04e6, B:335:0x0501), top: B:314:0x04c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0539 A[Catch: all -> 0x04da, TryCatch #13 {all -> 0x04da, blocks: (B:316:0x04c7, B:317:0x0517, B:319:0x051d, B:320:0x0535, B:322:0x0539, B:325:0x0542, B:326:0x0547, B:330:0x04de, B:332:0x04e2, B:334:0x04e6, B:335:0x0501), top: B:314:0x04c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0489 A[Catch: all -> 0x0453, Exception -> 0x0493, TRY_LEAVE, TryCatch #6 {Exception -> 0x0493, blocks: (B:385:0x0471, B:387:0x0479, B:389:0x0481, B:391:0x0489), top: B:384:0x0471 }] */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0162  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r34, java.lang.Object r35, java.lang.Object r36, java.lang.reflect.Type r37, int r38, boolean r39) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }

    public JavaBeanSerializer(Class<?> cls, Map<String, String> map) {
        this(TypeUtils.buildBeanInfo(cls, map, null));
    }

    public JavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        FieldSerializer[] fieldSerializerArr;
        boolean z10;
        this.beanInfo = serializeBeanInfo;
        this.sortedGetters = new FieldSerializer[serializeBeanInfo.sortedFields.length];
        int i10 = 0;
        while (true) {
            fieldSerializerArr = this.sortedGetters;
            if (i10 >= fieldSerializerArr.length) {
                break;
            }
            fieldSerializerArr[i10] = new FieldSerializer(serializeBeanInfo.beanType, serializeBeanInfo.sortedFields[i10]);
            i10++;
        }
        FieldInfo[] fieldInfoArr = serializeBeanInfo.fields;
        if (fieldInfoArr == serializeBeanInfo.sortedFields) {
            this.getters = fieldSerializerArr;
        } else {
            this.getters = new FieldSerializer[fieldInfoArr.length];
            int i11 = 0;
            while (true) {
                if (i11 >= this.getters.length) {
                    z10 = false;
                    break;
                }
                FieldSerializer fieldSerializer = getFieldSerializer(serializeBeanInfo.fields[i11].name);
                if (fieldSerializer == null) {
                    z10 = true;
                    break;
                } else {
                    this.getters[i11] = fieldSerializer;
                    i11++;
                }
            }
            if (z10) {
                FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                System.arraycopy(fieldSerializerArr2, 0, this.getters, 0, fieldSerializerArr2.length);
            }
        }
        JSONType jSONType = serializeBeanInfo.jsonType;
        if (jSONType != null) {
            for (Class<? extends SerializeFilter> cls : jSONType.serialzeFilters()) {
                try {
                    addFilter(cls.getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused) {
                }
            }
        }
        JSONType jSONType2 = serializeBeanInfo.jsonType;
        if (jSONType2 != null) {
            for (Class<? extends SerializeFilter> cls2 : jSONType2.serialzeFilters()) {
                try {
                    addFilter(cls2.getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception unused2) {
                }
            }
        }
    }

    public FieldSerializer getFieldSerializer(long j10) {
        PropertyNamingStrategy[] propertyNamingStrategyArr;
        int binarySearch;
        if (this.hashArray == null) {
            propertyNamingStrategyArr = PropertyNamingStrategy.values();
            long[] jArr = new long[this.sortedGetters.length * propertyNamingStrategyArr.length];
            int i10 = 0;
            int i11 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr = this.sortedGetters;
                if (i10 >= fieldSerializerArr.length) {
                    break;
                }
                String str = fieldSerializerArr[i10].fieldInfo.name;
                jArr[i11] = TypeUtils.fnv1a_64(str);
                i11++;
                for (PropertyNamingStrategy propertyNamingStrategy : propertyNamingStrategyArr) {
                    String translate = propertyNamingStrategy.translate(str);
                    if (!str.equals(translate)) {
                        jArr[i11] = TypeUtils.fnv1a_64(translate);
                        i11++;
                    }
                }
                i10++;
            }
            Arrays.sort(jArr, 0, i11);
            this.hashArray = new long[i11];
            System.arraycopy((Object) jArr, 0, (Object) this.hashArray, 0, i11);
        } else {
            propertyNamingStrategyArr = null;
        }
        int binarySearch2 = Arrays.binarySearch(this.hashArray, j10);
        if (binarySearch2 < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            if (propertyNamingStrategyArr == null) {
                propertyNamingStrategyArr = PropertyNamingStrategy.values();
            }
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, (short) -1);
            int i12 = 0;
            while (true) {
                FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                if (i12 >= fieldSerializerArr2.length) {
                    break;
                }
                String str2 = fieldSerializerArr2[i12].fieldInfo.name;
                int binarySearch3 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(str2));
                if (binarySearch3 >= 0) {
                    sArr[binarySearch3] = (short) i12;
                }
                for (PropertyNamingStrategy propertyNamingStrategy2 : propertyNamingStrategyArr) {
                    String translate2 = propertyNamingStrategy2.translate(str2);
                    if (!str2.equals(translate2) && (binarySearch = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(translate2))) >= 0) {
                        sArr[binarySearch] = (short) i12;
                    }
                }
                i12++;
            }
            this.hashArrayMapping = sArr;
        }
        short s2 = this.hashArrayMapping[binarySearch2];
        if (s2 != -1) {
            return this.sortedGetters[s2];
        }
        return null;
    }

    public Object getFieldValue(Object obj, String str, long j10, boolean z10) {
        FieldSerializer fieldSerializer = getFieldSerializer(j10);
        if (fieldSerializer == null) {
            if (!z10) {
                return null;
            }
            throw new JSONException("field not found. " + str);
        }
        try {
            return fieldSerializer.getPropertyValue(obj);
        } catch (IllegalAccessException e2) {
            throw new JSONException("getFieldValue error." + str, e2);
        } catch (InvocationTargetException e10) {
            throw new JSONException("getFieldValue error." + str, e10);
        }
    }
}
