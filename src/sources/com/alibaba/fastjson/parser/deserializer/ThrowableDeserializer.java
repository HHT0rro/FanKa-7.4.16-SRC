package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.ParserConfig;
import java.lang.reflect.Constructor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    private Throwable createException(String str, Throwable th, Class<?> cls) throws Exception {
        Constructor<?> constructor = null;
        Constructor<?> constructor2 = null;
        Constructor<?> constructor3 = null;
        for (Constructor<?> constructor4 : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor4.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor3 = constructor4;
            } else if (parameterTypes.length == 1 && parameterTypes[0] == String.class) {
                constructor2 = constructor4;
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Throwable.class) {
                constructor = constructor4;
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(str, th);
        }
        if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(str);
        }
        if (constructor3 != null) {
            return (Throwable) constructor3.newInstance(new Object[0]);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        if (java.lang.Throwable.class.isAssignableFrom(r14) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ec, code lost:
    
        if (r14 != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ee, code lost:
    
        r15 = (T) new java.lang.Exception(r5, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0107, code lost:
    
        if (r6 == null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0109, code lost:
    
        ((java.lang.Throwable) r15).setStackTrace(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010c, code lost:
    
        if (r0 == null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010e, code lost:
    
        if (r14 == null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0112, code lost:
    
        if (r14 != r12.clazz) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0114, code lost:
    
        r2 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0116, code lost:
    
        r13 = r13.getConfig().getDeserializer(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0120, code lost:
    
        if ((r13 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0122, code lost:
    
        r2 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0125, code lost:
    
        if (r2 == null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0127, code lost:
    
        r13 = r0.entrySet().iterator2();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0133, code lost:
    
        if (r13.hasNext() == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0135, code lost:
    
        r14 = (java.util.Map.Entry) r13.next();
        r0 = (java.lang.String) r14.getKey();
        r14 = r14.getValue();
        r0 = r2.getFieldDeserializer(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0149, code lost:
    
        if (r0 == null) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x014b, code lost:
    
        r0.setValue(r15, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x014f, code lost:
    
        return (T) r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00fa, code lost:
    
        if (java.lang.Throwable.class.isAssignableFrom(r14) == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0173, code lost:
    
        throw new com.alibaba.fastjson.JSONException("type not match, not Throwable. " + r14.getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00fc, code lost:
    
        r15 = (T) createException(r5, r3, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0100, code lost:
    
        if (r15 != null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0102, code lost:
    
        r15 = (T) new java.lang.Exception(r5, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0150, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0158, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error", r13);
     */
    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r13, java.lang.reflect.Type r14, java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }
}
