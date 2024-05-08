package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class MapSerializer extends SerializeFilterable implements ObjectSerializer {
    public static MapSerializer instance = new MapSerializer();
    private static final int NON_STRINGKEY_AS_STRING = SerializerFeature.of(new SerializerFeature[]{SerializerFeature.BrowserCompatible, SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.BrowserSecure});

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i10) throws IOException {
        write(jSONSerializer, obj, obj2, type, i10, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01fd A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:19:0x0052, B:23:0x0055, B:25:0x0061, B:33:0x0080, B:34:0x0091, B:35:0x00a1, B:37:0x00a7, B:39:0x00b9, B:42:0x00c1, B:45:0x00c6, B:47:0x00d0, B:49:0x00d4, B:57:0x00df, B:60:0x00ed, B:62:0x00f1, B:65:0x00f9, B:68:0x00fe, B:70:0x0108, B:72:0x010c, B:76:0x0117, B:80:0x0121, B:82:0x0125, B:85:0x012d, B:88:0x0132, B:90:0x013c, B:92:0x0140, B:96:0x014b, B:100:0x0155, B:102:0x0159, B:105:0x0161, B:108:0x0166, B:110:0x0170, B:112:0x0174, B:116:0x0180, B:120:0x018b, B:122:0x018f, B:125:0x0197, B:128:0x019c, B:130:0x01a6, B:132:0x01aa, B:133:0x01b3, B:134:0x01b9, B:136:0x01bd, B:139:0x01c5, B:142:0x01ca, B:144:0x01d4, B:146:0x01d8, B:147:0x01e1, B:150:0x01ea, B:153:0x01ef, B:155:0x01f3, B:160:0x01fd, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:176:0x0297, B:179:0x02a4, B:181:0x02ac, B:182:0x02b3, B:184:0x02bd, B:186:0x02c1, B:188:0x02c5, B:190:0x02d0, B:191:0x02d6, B:194:0x02e4, B:197:0x026e, B:198:0x0271, B:200:0x0279, B:202:0x028d, B:203:0x0290, B:204:0x0281, B:206:0x0285, B:211:0x0222, B:223:0x0075), top: B:18:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x023d A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:19:0x0052, B:23:0x0055, B:25:0x0061, B:33:0x0080, B:34:0x0091, B:35:0x00a1, B:37:0x00a7, B:39:0x00b9, B:42:0x00c1, B:45:0x00c6, B:47:0x00d0, B:49:0x00d4, B:57:0x00df, B:60:0x00ed, B:62:0x00f1, B:65:0x00f9, B:68:0x00fe, B:70:0x0108, B:72:0x010c, B:76:0x0117, B:80:0x0121, B:82:0x0125, B:85:0x012d, B:88:0x0132, B:90:0x013c, B:92:0x0140, B:96:0x014b, B:100:0x0155, B:102:0x0159, B:105:0x0161, B:108:0x0166, B:110:0x0170, B:112:0x0174, B:116:0x0180, B:120:0x018b, B:122:0x018f, B:125:0x0197, B:128:0x019c, B:130:0x01a6, B:132:0x01aa, B:133:0x01b3, B:134:0x01b9, B:136:0x01bd, B:139:0x01c5, B:142:0x01ca, B:144:0x01d4, B:146:0x01d8, B:147:0x01e1, B:150:0x01ea, B:153:0x01ef, B:155:0x01f3, B:160:0x01fd, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:176:0x0297, B:179:0x02a4, B:181:0x02ac, B:182:0x02b3, B:184:0x02bd, B:186:0x02c1, B:188:0x02c5, B:190:0x02d0, B:191:0x02d6, B:194:0x02e4, B:197:0x026e, B:198:0x0271, B:200:0x0279, B:202:0x028d, B:203:0x0290, B:204:0x0281, B:206:0x0285, B:211:0x0222, B:223:0x0075), top: B:18:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0255 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:19:0x0052, B:23:0x0055, B:25:0x0061, B:33:0x0080, B:34:0x0091, B:35:0x00a1, B:37:0x00a7, B:39:0x00b9, B:42:0x00c1, B:45:0x00c6, B:47:0x00d0, B:49:0x00d4, B:57:0x00df, B:60:0x00ed, B:62:0x00f1, B:65:0x00f9, B:68:0x00fe, B:70:0x0108, B:72:0x010c, B:76:0x0117, B:80:0x0121, B:82:0x0125, B:85:0x012d, B:88:0x0132, B:90:0x013c, B:92:0x0140, B:96:0x014b, B:100:0x0155, B:102:0x0159, B:105:0x0161, B:108:0x0166, B:110:0x0170, B:112:0x0174, B:116:0x0180, B:120:0x018b, B:122:0x018f, B:125:0x0197, B:128:0x019c, B:130:0x01a6, B:132:0x01aa, B:133:0x01b3, B:134:0x01b9, B:136:0x01bd, B:139:0x01c5, B:142:0x01ca, B:144:0x01d4, B:146:0x01d8, B:147:0x01e1, B:150:0x01ea, B:153:0x01ef, B:155:0x01f3, B:160:0x01fd, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:176:0x0297, B:179:0x02a4, B:181:0x02ac, B:182:0x02b3, B:184:0x02bd, B:186:0x02c1, B:188:0x02c5, B:190:0x02d0, B:191:0x02d6, B:194:0x02e4, B:197:0x026e, B:198:0x0271, B:200:0x0279, B:202:0x028d, B:203:0x0290, B:204:0x0281, B:206:0x0285, B:211:0x0222, B:223:0x0075), top: B:18:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0297 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:19:0x0052, B:23:0x0055, B:25:0x0061, B:33:0x0080, B:34:0x0091, B:35:0x00a1, B:37:0x00a7, B:39:0x00b9, B:42:0x00c1, B:45:0x00c6, B:47:0x00d0, B:49:0x00d4, B:57:0x00df, B:60:0x00ed, B:62:0x00f1, B:65:0x00f9, B:68:0x00fe, B:70:0x0108, B:72:0x010c, B:76:0x0117, B:80:0x0121, B:82:0x0125, B:85:0x012d, B:88:0x0132, B:90:0x013c, B:92:0x0140, B:96:0x014b, B:100:0x0155, B:102:0x0159, B:105:0x0161, B:108:0x0166, B:110:0x0170, B:112:0x0174, B:116:0x0180, B:120:0x018b, B:122:0x018f, B:125:0x0197, B:128:0x019c, B:130:0x01a6, B:132:0x01aa, B:133:0x01b3, B:134:0x01b9, B:136:0x01bd, B:139:0x01c5, B:142:0x01ca, B:144:0x01d4, B:146:0x01d8, B:147:0x01e1, B:150:0x01ea, B:153:0x01ef, B:155:0x01f3, B:160:0x01fd, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:176:0x0297, B:179:0x02a4, B:181:0x02ac, B:182:0x02b3, B:184:0x02bd, B:186:0x02c1, B:188:0x02c5, B:190:0x02d0, B:191:0x02d6, B:194:0x02e4, B:197:0x026e, B:198:0x0271, B:200:0x0279, B:202:0x028d, B:203:0x0290, B:204:0x0281, B:206:0x0285, B:211:0x0222, B:223:0x0075), top: B:18:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02a4 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:19:0x0052, B:23:0x0055, B:25:0x0061, B:33:0x0080, B:34:0x0091, B:35:0x00a1, B:37:0x00a7, B:39:0x00b9, B:42:0x00c1, B:45:0x00c6, B:47:0x00d0, B:49:0x00d4, B:57:0x00df, B:60:0x00ed, B:62:0x00f1, B:65:0x00f9, B:68:0x00fe, B:70:0x0108, B:72:0x010c, B:76:0x0117, B:80:0x0121, B:82:0x0125, B:85:0x012d, B:88:0x0132, B:90:0x013c, B:92:0x0140, B:96:0x014b, B:100:0x0155, B:102:0x0159, B:105:0x0161, B:108:0x0166, B:110:0x0170, B:112:0x0174, B:116:0x0180, B:120:0x018b, B:122:0x018f, B:125:0x0197, B:128:0x019c, B:130:0x01a6, B:132:0x01aa, B:133:0x01b3, B:134:0x01b9, B:136:0x01bd, B:139:0x01c5, B:142:0x01ca, B:144:0x01d4, B:146:0x01d8, B:147:0x01e1, B:150:0x01ea, B:153:0x01ef, B:155:0x01f3, B:160:0x01fd, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:176:0x0297, B:179:0x02a4, B:181:0x02ac, B:182:0x02b3, B:184:0x02bd, B:186:0x02c1, B:188:0x02c5, B:190:0x02d0, B:191:0x02d6, B:194:0x02e4, B:197:0x026e, B:198:0x0271, B:200:0x0279, B:202:0x028d, B:203:0x0290, B:204:0x0281, B:206:0x0285, B:211:0x0222, B:223:0x0075), top: B:18:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x024f A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:221:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:19:0x0052, B:23:0x0055, B:25:0x0061, B:33:0x0080, B:34:0x0091, B:35:0x00a1, B:37:0x00a7, B:39:0x00b9, B:42:0x00c1, B:45:0x00c6, B:47:0x00d0, B:49:0x00d4, B:57:0x00df, B:60:0x00ed, B:62:0x00f1, B:65:0x00f9, B:68:0x00fe, B:70:0x0108, B:72:0x010c, B:76:0x0117, B:80:0x0121, B:82:0x0125, B:85:0x012d, B:88:0x0132, B:90:0x013c, B:92:0x0140, B:96:0x014b, B:100:0x0155, B:102:0x0159, B:105:0x0161, B:108:0x0166, B:110:0x0170, B:112:0x0174, B:116:0x0180, B:120:0x018b, B:122:0x018f, B:125:0x0197, B:128:0x019c, B:130:0x01a6, B:132:0x01aa, B:133:0x01b3, B:134:0x01b9, B:136:0x01bd, B:139:0x01c5, B:142:0x01ca, B:144:0x01d4, B:146:0x01d8, B:147:0x01e1, B:150:0x01ea, B:153:0x01ef, B:155:0x01f3, B:160:0x01fd, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:176:0x0297, B:179:0x02a4, B:181:0x02ac, B:182:0x02b3, B:184:0x02bd, B:186:0x02c1, B:188:0x02c5, B:190:0x02d0, B:191:0x02d6, B:194:0x02e4, B:197:0x026e, B:198:0x0271, B:200:0x0279, B:202:0x028d, B:203:0x0290, B:204:0x0281, B:206:0x0285, B:211:0x0222, B:223:0x0075), top: B:18:0x0052 }] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r24, java.lang.Object r25, java.lang.Object r26, java.lang.reflect.Type r27, int r28, boolean r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 791
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.MapSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }
}
