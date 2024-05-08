package com.alibaba.security.common.json.serializer;

import com.alibaba.security.common.json.RPPropertyNamingStrategy;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class JavaBeanSerializer implements ObjectSerializer {
    public int features;
    private final FieldSerializer[] getters;
    private final FieldSerializer[] sortedGetters;
    public final String typeKey;
    public final String typeName;
    private static final char[] true_chars = {'t', 'r', 'u', 'e'};
    private static final char[] false_chars = {'f', 'a', 'l', 's', 'e'};

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (RPPropertyNamingStrategy) null);
    }

    private static Map<String, String> map(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0407 A[Catch: all -> 0x04ce, Exception -> 0x04d4, TryCatch #7 {Exception -> 0x04d4, all -> 0x04ce, blocks: (B:90:0x0160, B:92:0x017b, B:94:0x017f, B:101:0x0184, B:103:0x0188, B:107:0x0191, B:108:0x0195, B:110:0x019b, B:115:0x01b4, B:117:0x01bb, B:119:0x01bf, B:122:0x020b, B:124:0x020f, B:126:0x0216, B:128:0x021a, B:129:0x021f, B:131:0x0223, B:132:0x0228, B:133:0x022c, B:135:0x0232, B:145:0x0252, B:147:0x0256, B:149:0x025e, B:151:0x0262, B:152:0x0267, B:154:0x026b, B:155:0x0270, B:156:0x0277, B:158:0x027d, B:163:0x0297, B:165:0x029b, B:167:0x02a2, B:169:0x02a6, B:170:0x02ab, B:172:0x02af, B:173:0x02b4, B:174:0x02bb, B:176:0x02c1, B:182:0x02de, B:184:0x02e2, B:190:0x02f6, B:192:0x02fa, B:194:0x02fe, B:196:0x0302, B:198:0x0306, B:200:0x030a, B:202:0x031c, B:204:0x0320, B:206:0x0324, B:208:0x030e, B:210:0x0312, B:214:0x0336, B:216:0x033f, B:218:0x0343, B:219:0x0347, B:220:0x034b, B:222:0x0360, B:225:0x036c, B:226:0x0370, B:232:0x037a, B:233:0x037d, B:236:0x0385, B:238:0x0390, B:240:0x0394, B:242:0x0399, B:246:0x03b5, B:249:0x03bf, B:252:0x03c6, B:256:0x03d0, B:260:0x03dc, B:264:0x03e2, B:266:0x03e6, B:267:0x03e8, B:269:0x03f0, B:271:0x03f4, B:272:0x03f8, B:274:0x0407, B:262:0x0411, B:277:0x0414, B:279:0x0418, B:280:0x0421, B:283:0x0427, B:284:0x0432, B:289:0x0445, B:291:0x044e, B:294:0x0454, B:295:0x0459, B:296:0x0460, B:298:0x0464, B:299:0x0469, B:300:0x0470, B:303:0x0476, B:305:0x047f, B:309:0x0493, B:310:0x0498, B:312:0x049d, B:313:0x04a8, B:314:0x04ad, B:315:0x04b2, B:322:0x01cf, B:324:0x01d3, B:326:0x01df, B:328:0x01e3, B:329:0x01f3, B:331:0x01fa, B:356:0x04e9, B:357:0x04ed, B:359:0x04f3, B:365:0x0503, B:367:0x050c, B:370:0x051b, B:372:0x051f, B:373:0x0523), top: B:89:0x0160 }] */
    /* JADX WARN: Removed duplicated region for block: B:346:0x054b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0503 A[Catch: all -> 0x04ce, Exception -> 0x04d4, TRY_ENTER, TryCatch #7 {Exception -> 0x04d4, all -> 0x04ce, blocks: (B:90:0x0160, B:92:0x017b, B:94:0x017f, B:101:0x0184, B:103:0x0188, B:107:0x0191, B:108:0x0195, B:110:0x019b, B:115:0x01b4, B:117:0x01bb, B:119:0x01bf, B:122:0x020b, B:124:0x020f, B:126:0x0216, B:128:0x021a, B:129:0x021f, B:131:0x0223, B:132:0x0228, B:133:0x022c, B:135:0x0232, B:145:0x0252, B:147:0x0256, B:149:0x025e, B:151:0x0262, B:152:0x0267, B:154:0x026b, B:155:0x0270, B:156:0x0277, B:158:0x027d, B:163:0x0297, B:165:0x029b, B:167:0x02a2, B:169:0x02a6, B:170:0x02ab, B:172:0x02af, B:173:0x02b4, B:174:0x02bb, B:176:0x02c1, B:182:0x02de, B:184:0x02e2, B:190:0x02f6, B:192:0x02fa, B:194:0x02fe, B:196:0x0302, B:198:0x0306, B:200:0x030a, B:202:0x031c, B:204:0x0320, B:206:0x0324, B:208:0x030e, B:210:0x0312, B:214:0x0336, B:216:0x033f, B:218:0x0343, B:219:0x0347, B:220:0x034b, B:222:0x0360, B:225:0x036c, B:226:0x0370, B:232:0x037a, B:233:0x037d, B:236:0x0385, B:238:0x0390, B:240:0x0394, B:242:0x0399, B:246:0x03b5, B:249:0x03bf, B:252:0x03c6, B:256:0x03d0, B:260:0x03dc, B:264:0x03e2, B:266:0x03e6, B:267:0x03e8, B:269:0x03f0, B:271:0x03f4, B:272:0x03f8, B:274:0x0407, B:262:0x0411, B:277:0x0414, B:279:0x0418, B:280:0x0421, B:283:0x0427, B:284:0x0432, B:289:0x0445, B:291:0x044e, B:294:0x0454, B:295:0x0459, B:296:0x0460, B:298:0x0464, B:299:0x0469, B:300:0x0470, B:303:0x0476, B:305:0x047f, B:309:0x0493, B:310:0x0498, B:312:0x049d, B:313:0x04a8, B:314:0x04ad, B:315:0x04b2, B:322:0x01cf, B:324:0x01d3, B:326:0x01df, B:328:0x01e3, B:329:0x01f3, B:331:0x01fa, B:356:0x04e9, B:357:0x04ed, B:359:0x04f3, B:365:0x0503, B:367:0x050c, B:370:0x051b, B:372:0x051f, B:373:0x0523), top: B:89:0x0160 }] */
    /* JADX WARN: Removed duplicated region for block: B:370:0x051b A[Catch: all -> 0x04ce, Exception -> 0x04d4, TRY_ENTER, TryCatch #7 {Exception -> 0x04d4, all -> 0x04ce, blocks: (B:90:0x0160, B:92:0x017b, B:94:0x017f, B:101:0x0184, B:103:0x0188, B:107:0x0191, B:108:0x0195, B:110:0x019b, B:115:0x01b4, B:117:0x01bb, B:119:0x01bf, B:122:0x020b, B:124:0x020f, B:126:0x0216, B:128:0x021a, B:129:0x021f, B:131:0x0223, B:132:0x0228, B:133:0x022c, B:135:0x0232, B:145:0x0252, B:147:0x0256, B:149:0x025e, B:151:0x0262, B:152:0x0267, B:154:0x026b, B:155:0x0270, B:156:0x0277, B:158:0x027d, B:163:0x0297, B:165:0x029b, B:167:0x02a2, B:169:0x02a6, B:170:0x02ab, B:172:0x02af, B:173:0x02b4, B:174:0x02bb, B:176:0x02c1, B:182:0x02de, B:184:0x02e2, B:190:0x02f6, B:192:0x02fa, B:194:0x02fe, B:196:0x0302, B:198:0x0306, B:200:0x030a, B:202:0x031c, B:204:0x0320, B:206:0x0324, B:208:0x030e, B:210:0x0312, B:214:0x0336, B:216:0x033f, B:218:0x0343, B:219:0x0347, B:220:0x034b, B:222:0x0360, B:225:0x036c, B:226:0x0370, B:232:0x037a, B:233:0x037d, B:236:0x0385, B:238:0x0390, B:240:0x0394, B:242:0x0399, B:246:0x03b5, B:249:0x03bf, B:252:0x03c6, B:256:0x03d0, B:260:0x03dc, B:264:0x03e2, B:266:0x03e6, B:267:0x03e8, B:269:0x03f0, B:271:0x03f4, B:272:0x03f8, B:274:0x0407, B:262:0x0411, B:277:0x0414, B:279:0x0418, B:280:0x0421, B:283:0x0427, B:284:0x0432, B:289:0x0445, B:291:0x044e, B:294:0x0454, B:295:0x0459, B:296:0x0460, B:298:0x0464, B:299:0x0469, B:300:0x0470, B:303:0x0476, B:305:0x047f, B:309:0x0493, B:310:0x0498, B:312:0x049d, B:313:0x04a8, B:314:0x04ad, B:315:0x04b2, B:322:0x01cf, B:324:0x01d3, B:326:0x01df, B:328:0x01e3, B:329:0x01f3, B:331:0x01fa, B:356:0x04e9, B:357:0x04ed, B:359:0x04f3, B:365:0x0503, B:367:0x050c, B:370:0x051b, B:372:0x051f, B:373:0x0523), top: B:89:0x0160 }] */
    /* JADX WARN: Removed duplicated region for block: B:386:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010d A[Catch: all -> 0x0096, Exception -> 0x009b, TRY_ENTER, TryCatch #9 {Exception -> 0x009b, all -> 0x0096, blocks: (B:400:0x0089, B:402:0x008d, B:403:0x0091, B:33:0x00ab, B:35:0x00b4, B:39:0x00c3, B:42:0x00ca, B:44:0x00d1, B:49:0x00dd, B:51:0x00e3, B:54:0x00ec, B:56:0x00f3, B:57:0x00fb, B:64:0x010d, B:65:0x0111, B:67:0x0117, B:74:0x0130, B:396:0x00e8), top: B:399:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0130 A[Catch: all -> 0x0096, Exception -> 0x009b, TRY_ENTER, TRY_LEAVE, TryCatch #9 {Exception -> 0x009b, all -> 0x0096, blocks: (B:400:0x0089, B:402:0x008d, B:403:0x0091, B:33:0x00ab, B:35:0x00b4, B:39:0x00c3, B:42:0x00ca, B:44:0x00d1, B:49:0x00dd, B:51:0x00e3, B:54:0x00ec, B:56:0x00f3, B:57:0x00fb, B:64:0x010d, B:65:0x0111, B:67:0x0117, B:74:0x0130, B:396:0x00e8), top: B:399:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.alibaba.security.common.json.serializer.ObjectSerializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(com.alibaba.security.common.json.serializer.JSONSerializer r35, java.lang.Object r36, java.lang.Object r37, java.lang.reflect.Type r38) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.serializer.JavaBeanSerializer.write(com.alibaba.security.common.json.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type):void");
    }

    public JavaBeanSerializer(Class<?> cls, RPPropertyNamingStrategy rPPropertyNamingStrategy) {
        this(cls, cls.getModifiers(), null, false, true, true, true, rPPropertyNamingStrategy);
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, cls.getModifiers(), map(strArr), false, true, true, true, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a7 A[LOOP:2: B:29:0x00a1->B:31:0x00a7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public JavaBeanSerializer(java.lang.Class<?> r15, int r16, java.util.Map<java.lang.String, java.lang.String> r17, boolean r18, boolean r19, boolean r20, boolean r21, com.alibaba.security.common.json.RPPropertyNamingStrategy r22) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.serializer.JavaBeanSerializer.<init>(java.lang.Class, int, java.util.Map, boolean, boolean, boolean, boolean, com.alibaba.security.common.json.RPPropertyNamingStrategy):void");
    }
}
