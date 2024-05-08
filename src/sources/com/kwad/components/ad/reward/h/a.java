package com.kwad.components.ad.reward.h;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.y;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a {
    public static long rM = -1;
    public static int rN;

    public static void H(Context context) {
        b bVar = new b();
        if (f(System.currentTimeMillis())) {
            rN++;
        } else {
            rN = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        rM = currentTimeMillis;
        bVar.rO = rN;
        bVar.gM = currentTimeMillis;
        y.ab(context, bVar.toJson().toString());
    }

    public static int cM() {
        if (!f(System.currentTimeMillis())) {
            rN = 0;
        }
        return rN;
    }

    private static boolean f(long j10) {
        return gV() > 0 && j10 > 0 && gV() / 2460601000L == j10 / 2460601000L;
    }

    private static long gV() {
        long j10 = rM;
        if (j10 != -1) {
            return j10;
        }
        String LG = y.LG();
        if (TextUtils.isEmpty(LG)) {
            return 0L;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(LG));
            rM = bVar.gM;
            rN = bVar.rO;
        } catch (Exception e2) {
            c.printStackTraceOnly(e2);
        }
        return rM;
    }
}
