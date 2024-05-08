package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d2 {
    public static String a(a2 a2Var, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(str);
        b(a2Var, sb2, 0);
        return sb2.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x021a, code lost:
    
        if (((java.lang.Double) r11).doubleValue() == com.google.android.material.shadow.ShadowDrawableWrapper.COS_45) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01e6, code lost:
    
        if (((java.lang.Boolean) r11).booleanValue() == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01e8, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01f7, code lost:
    
        if (((java.lang.Integer) r11).intValue() == 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0208, code lost:
    
        if (((java.lang.Float) r11).floatValue() == 0.0f) goto L80;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(com.google.android.gms.internal.clearcut.a2 r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instructions count: 688
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.d2.b(com.google.android.gms.internal.clearcut.a2, java.lang.StringBuilder, int):void");
    }

    public static final void c(StringBuilder sb2, int i10, String str, Object obj) {
        if (obj instanceof List) {
            Iterator iterator2 = ((List) obj).iterator2();
            while (iterator2.hasNext()) {
                c(sb2, i10, str, iterator2.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator iterator22 = ((Map) obj).entrySet().iterator2();
            while (iterator22.hasNext()) {
                c(sb2, i10, str, (Map.Entry) iterator22.next());
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
            sb2.append(f3.a(zzbb.zzf((String) obj)));
            sb2.append('\"');
            return;
        }
        if (obj instanceof zzbb) {
            sb2.append(": \"");
            sb2.append(f3.a((zzbb) obj));
            sb2.append('\"');
            return;
        }
        if (obj instanceof x0) {
            sb2.append(" {");
            b((x0) obj, sb2, i10 + 2);
            sb2.append("\n");
            while (i11 < i10) {
                sb2.append(' ');
                i11++;
            }
            sb2.append(com.alipay.sdk.util.i.f4738d);
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb2.append(": ");
            sb2.append(obj.toString());
            return;
        }
        sb2.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i13 = i10 + 2;
        c(sb2, i13, "key", entry.getKey());
        c(sb2, i13, "value", entry.getValue());
        sb2.append("\n");
        while (i11 < i10) {
            sb2.append(' ');
            i11++;
        }
        sb2.append(com.alipay.sdk.util.i.f4738d);
    }

    public static final String d(String str) {
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
}
