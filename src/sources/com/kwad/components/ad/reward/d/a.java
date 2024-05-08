package com.kwad.components.ad.reward.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.y;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a {
    public static void N(@NonNull Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = new b();
        String ce2 = y.ce(context);
        int i10 = 0;
        if (!TextUtils.isEmpty(ce2)) {
            try {
                bVar.parseJson(new JSONObject(ce2));
                if (c(bVar.gM, currentTimeMillis)) {
                    i10 = bVar.rt;
                }
            } catch (Exception e2) {
                c.printStackTraceOnly(e2);
            }
        }
        bVar.gM = currentTimeMillis;
        bVar.rt = i10 + 1;
        y.aa(context, bVar.toJson().toString());
    }

    public static boolean b(@NonNull Context context, AdInfo adInfo) {
        if (!com.kwad.sdk.core.response.b.a.aG(adInfo)) {
            return false;
        }
        int max = Math.max(com.kwad.sdk.core.response.b.a.aH(adInfo) + 1, 1);
        boolean d10 = d(context, max);
        c(context, max);
        return d10 && e(context, com.kwad.sdk.core.response.b.a.aI(adInfo));
    }

    private static boolean c(long j10, long j11) {
        return j10 > 0 && j11 > 0 && j10 / 2460601000L == j11 / 2460601000L;
    }

    private static boolean d(@NonNull Context context, int i10) {
        return i10 != 0 && y.cd(context) % i10 == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x002e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0030 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean e(@androidx.annotation.NonNull android.content.Context r7, int r8) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            com.kwad.components.ad.reward.d.b r2 = new com.kwad.components.ad.reward.d.b
            r2.<init>()
            java.lang.String r7 = com.kwad.sdk.utils.y.ce(r7)
            boolean r3 = android.text.TextUtils.isEmpty(r7)
            r4 = 0
            if (r3 != 0) goto L2b
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L27
            r3.<init>(r7)     // Catch: java.lang.Exception -> L27
            r2.parseJson(r3)     // Catch: java.lang.Exception -> L27
            long r5 = r2.gM     // Catch: java.lang.Exception -> L27
            boolean r7 = c(r5, r0)     // Catch: java.lang.Exception -> L27
            if (r7 == 0) goto L2b
            int r7 = r2.rt     // Catch: java.lang.Exception -> L27
            goto L2c
        L27:
            r7 = move-exception
            com.kwad.sdk.core.e.c.printStackTraceOnly(r7)
        L2b:
            r7 = 0
        L2c:
            if (r7 >= r8) goto L30
            r7 = 1
            return r7
        L30:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.d.a.e(android.content.Context, int):boolean");
    }

    private static void c(@NonNull Context context, int i10) {
        int cd2 = y.cd(context);
        if (cd2 % i10 == 0) {
            y.l(context, 1);
        } else {
            y.l(context, cd2 + 1);
        }
    }
}
