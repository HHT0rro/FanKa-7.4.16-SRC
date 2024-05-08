package com.huawei.openalliance.ad.utils;

import android.content.Context;
import com.huawei.hms.ads.base.R;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h {
    private static final String Code = "CNStrUtil";

    private static String Code(long j10) {
        float f10 = (((float) j10) * 1.0f) / 1048576.0f;
        if (f10 < 0.1f) {
            f10 = 0.1f;
        }
        return String.format(Locale.getDefault(), "%.1f", Float.valueOf(f10));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String Code(android.content.Context r5, int r6, java.lang.String r7, java.lang.Object... r8) {
        /*
            java.lang.String r0 = "getChinaString "
            java.lang.String r1 = "CNStrUtil"
            android.content.res.Resources r2 = r5.getResources()
            r3 = 0
            com.huawei.hms.ads.el r4 = com.huawei.hms.ads.ea.Code(r5)     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            boolean r4 = r4.Code()     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            if (r4 == 0) goto L5d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            r4.<init>()     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            r4.append(r7)     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            java.lang.String r7 = "_zh"
            r4.append(r7)     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            java.lang.String r4 = "string"
            java.lang.String r5 = r5.getPackageName()     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            int r5 = r2.getIdentifier(r7, r4, r5)     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            if (r8 == 0) goto L35
            java.lang.String r5 = r2.getString(r5, r8)     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
            goto L39
        L35:
            java.lang.String r5 = r2.getString(r5)     // Catch: java.lang.Exception -> L3b java.lang.RuntimeException -> L42
        L39:
            r3 = r5
            goto L5d
        L3b:
            r5 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            goto L48
        L42:
            r5 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
        L48:
            r7.append(r0)
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            com.huawei.hms.ads.gl.Z(r1, r5)
        L5d:
            if (r3 != 0) goto L6d
            if (r8 == 0) goto L69
            int r5 = r8.length
            if (r5 <= 0) goto L69
            java.lang.String r3 = r2.getString(r6, r8)
            goto L6d
        L69:
            java.lang.String r3 = r2.getString(r6)
        L6d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.h.Code(android.content.Context, int, java.lang.String, java.lang.Object[]):java.lang.String");
    }

    public static String Code(Context context, long j10) {
        if (context == null) {
            return "";
        }
        return context.getString(R.string.hiad_data_size_prompt, Code(j10));
    }
}
