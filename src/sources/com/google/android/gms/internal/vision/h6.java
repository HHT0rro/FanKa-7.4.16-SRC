package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h6 {
    public static String a(c6 c6Var, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(str);
        c(c6Var, sb2, 0);
        return sb2.toString();
    }

    public static final String b(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (Character.isUpperCase(charAt)) {
                sb2.append("_");
            }
            sb2.append(Character.toLowerCase(charAt));
        }
        return sb2.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x021b, code lost:
    
        if (((java.lang.Double) r6).doubleValue() == com.google.android.material.shadow.ShadowDrawableWrapper.COS_45) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01e5, code lost:
    
        if (((java.lang.Boolean) r6).booleanValue() == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01e7, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01f8, code lost:
    
        if (((java.lang.Integer) r6).intValue() == 0) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0209, code lost:
    
        if (((java.lang.Float) r6).floatValue() == 0.0f) goto L84;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(com.google.android.gms.internal.vision.c6 r13, java.lang.StringBuilder r14, int r15) {
        /*
            Method dump skipped, instructions count: 695
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.h6.c(com.google.android.gms.internal.vision.c6, java.lang.StringBuilder, int):void");
    }

    public static final void d(StringBuilder sb2, int i10, String str, Object obj) {
        if (obj instanceof List) {
            Iterator iterator2 = ((List) obj).iterator2();
            while (iterator2.hasNext()) {
                d(sb2, i10, str, iterator2.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator iterator22 = ((Map) obj).entrySet().iterator2();
            while (iterator22.hasNext()) {
                d(sb2, i10, str, (Map.Entry) iterator22.next());
            }
            return;
        }
        sb2.append('\n');
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            sb2.append(' ');
        }
        sb2.append(str);
        if (obj instanceof String) {
            sb2.append(": \"");
            sb2.append(g7.a(zzht.zza((String) obj)));
            sb2.append('\"');
            return;
        }
        if (obj instanceof zzht) {
            sb2.append(": \"");
            sb2.append(g7.a((zzht) obj));
            sb2.append('\"');
            return;
        }
        if (obj instanceof x4) {
            sb2.append(" {");
            c((x4) obj, sb2, i10 + 2);
            sb2.append("\n");
            while (i11 < i10) {
                sb2.append(' ');
                i11++;
            }
            sb2.append(com.alipay.sdk.util.i.f4738d);
            return;
        }
        if (obj instanceof Map.Entry) {
            sb2.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int i13 = i10 + 2;
            d(sb2, i13, "key", entry.getKey());
            d(sb2, i13, "value", entry.getValue());
            sb2.append("\n");
            while (i11 < i10) {
                sb2.append(' ');
                i11++;
            }
            sb2.append(com.alipay.sdk.util.i.f4738d);
            return;
        }
        sb2.append(": ");
        sb2.append(obj.toString());
    }
}
