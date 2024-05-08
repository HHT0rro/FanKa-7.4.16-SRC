package com.kwad.sdk.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.y;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    public static int aag = 0;
    public static long rM = -1;

    public static void H(Context context) {
        a aVar = new a();
        if (f(System.currentTimeMillis())) {
            aag++;
        } else {
            aag = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        rM = currentTimeMillis;
        aVar.aag = aag;
        aVar.gM = currentTimeMillis;
        y.ak(context, aVar.toJson().toString());
    }

    public static int cM() {
        if (!f(System.currentTimeMillis())) {
            aag = 0;
        }
        return aag;
    }

    private static boolean f(long j10) {
        return gV() > 0 && j10 > 0 && gV() / 2460601000L == j10 / 2460601000L;
    }

    private static long gV() {
        long j10 = rM;
        if (j10 != -1) {
            return j10;
        }
        String LN = y.LN();
        if (TextUtils.isEmpty(LN)) {
            return 0L;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(LN));
            rM = aVar.gM;
            aag = aVar.aag;
        } catch (Exception e2) {
            c.printStackTraceOnly(e2);
        }
        return rM;
    }
}
