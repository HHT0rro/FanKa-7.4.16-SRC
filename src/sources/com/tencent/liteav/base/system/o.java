package com.tencent.liteav.base.system;

import com.tencent.liteav.base.Log;
import java.security.MessageDigest;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f42857a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Code restructure failed: missing block: B:52:0x01c8, code lost:
    
        if (r3 == null) goto L78;
     */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x01e6: MOVE (r3 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:98:0x01e6 */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0173 A[Catch: all -> 0x01ab, Exception -> 0x01ae, TryCatch #12 {Exception -> 0x01ae, all -> 0x01ab, blocks: (B:36:0x0153, B:38:0x0173, B:39:0x0176, B:41:0x0194, B:42:0x0197), top: B:35:0x0153 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0194 A[Catch: all -> 0x01ab, Exception -> 0x01ae, TryCatch #12 {Exception -> 0x01ae, all -> 0x01ab, blocks: (B:36:0x0153, B:38:0x0173, B:39:0x0176, B:41:0x0194, B:42:0x0197), top: B:35:0x0153 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf A[LOOP:0: B:67:0x00ba->B:69:0x00bf, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ee A[EDGE_INSN: B:70:0x00ee->B:71:0x00ee BREAK  A[LOOP:0: B:67:0x00ba->B:69:0x00bf], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f1 A[LOOP:1: B:72:0x00ef->B:73:0x00f1, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 493
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.base.system.o.a(java.lang.String):java.lang.String");
    }

    private static String b(String str) {
        if (str == null) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            char[] cArr = new char[digest.length << 1];
            int i10 = 0;
            for (int i11 = 0; i11 < digest.length; i11++) {
                int i12 = i10 + 1;
                char[] cArr2 = f42857a;
                cArr[i10] = cArr2[(digest[i11] & 240) >>> 4];
                i10 = i12 + 1;
                cArr[i12] = cArr2[digest[i11] & 15];
            }
            return new String(cArr);
        } catch (Exception e2) {
            Log.e("UUID", "stringToMd5 failed.", e2);
            return "";
        }
    }
}
