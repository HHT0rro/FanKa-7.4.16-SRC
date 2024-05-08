package com.cupidapp.live.base.utils;

/* compiled from: FKColorUtils.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class h {
    public static final int a(int i10, float f10) {
        return (Math.min(255, Math.max(0, (int) (f10 * 255))) << 24) + (i10 & 16777215);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0011  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0012 A[Catch: Exception -> 0x000c, TRY_LEAVE, TryCatch #0 {Exception -> 0x000c, blocks: (B:17:0x0003, B:8:0x0012), top: B:16:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int b(@org.jetbrains.annotations.Nullable java.lang.String r2) {
        /*
            r0 = 0
            if (r2 == 0) goto Le
            int r1 = r2.length()     // Catch: java.lang.Exception -> Lc
            if (r1 != 0) goto La
            goto Le
        La:
            r1 = 0
            goto Lf
        Lc:
            r2 = move-exception
            goto L1c
        Le:
            r1 = 1
        Lf:
            if (r1 == 0) goto L12
            goto L1f
        L12:
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> Lc
            int r2 = android.graphics.Color.parseColor(r2)     // Catch: java.lang.Exception -> Lc
            r0 = r2
            goto L1f
        L1c:
            r2.printStackTrace()
        L1f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.utils.h.b(java.lang.String):int");
    }
}
