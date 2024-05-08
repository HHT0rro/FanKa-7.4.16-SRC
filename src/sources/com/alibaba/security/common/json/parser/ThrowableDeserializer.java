package com.alibaba.security.common.json.parser;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        if (java.lang.Throwable.class.isAssignableFrom(r1) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d3, code lost:
    
        if (r1 != null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d5, code lost:
    
        r0 = (T) new java.lang.Exception(r11, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x015a, code lost:
    
        if (r12 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x015c, code lost:
    
        ((java.lang.Throwable) r0).setStackTrace(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x015f, code lost:
    
        return (T) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00dc, code lost:
    
        r0 = r1.getConstructors();
        r1 = r0.length;
        r4 = null;
        r5 = null;
        r8 = null;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e6, code lost:
    
        if (r3 >= r1) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e8, code lost:
    
        r13 = r0[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ef, code lost:
    
        if (r13.getParameterTypes().length != 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f1, code lost:
    
        r8 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0121, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f8, code lost:
    
        if (r13.getParameterTypes().length != 1) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0101, code lost:
    
        if (r13.getParameterTypes()[0] != java.lang.String.class) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0103, code lost:
    
        r5 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x010b, code lost:
    
        if (r13.getParameterTypes().length != 2) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0114, code lost:
    
        if (r13.getParameterTypes()[0] != java.lang.String.class) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x011e, code lost:
    
        if (r13.getParameterTypes()[1] != java.lang.Throwable.class) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0120, code lost:
    
        r4 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0124, code lost:
    
        if (r4 == null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0126, code lost:
    
        r6 = (java.lang.Throwable) r4.newInstance(r11, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0151, code lost:
    
        if (r6 != null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0153, code lost:
    
        r0 = (T) new java.lang.Exception(r11, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0159, code lost:
    
        r0 = (T) r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0136, code lost:
    
        if (r5 == null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0138, code lost:
    
        r6 = (java.lang.Throwable) r5.newInstance(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0145, code lost:
    
        if (r8 == null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0147, code lost:
    
        r6 = (java.lang.Throwable) r8.newInstance(new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0160, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0168, code lost:
    
        throw new com.alibaba.security.common.json.RPJSONException("create instance error", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d0 A[SYNTHETIC] */
    @Override // com.alibaba.security.common.json.parser.JavaBeanDeserializer, com.alibaba.security.common.json.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T deserialze(com.alibaba.security.common.json.parser.DefaultJSONParser r17, java.lang.reflect.Type r18, java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.parser.ThrowableDeserializer.deserialze(com.alibaba.security.common.json.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }
}
