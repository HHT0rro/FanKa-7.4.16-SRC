package com.kwad.components.ad.interstitial.c;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat gL = new SimpleDateFormat("yyyy-MM-dd");
    public long gM = -1;
    public int jA = 0;

    public static void H(Context context) {
        String LF = y.LF();
        a aVar = new a();
        if (TextUtils.isEmpty(LF)) {
            aVar.jA = 1;
            aVar.gM = System.currentTimeMillis();
            y.Z(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(LF));
            if (c(aVar.gM, System.currentTimeMillis())) {
                aVar.jA++;
            } else {
                aVar.jA = 1;
                aVar.gM = System.currentTimeMillis();
            }
            y.Z(context, aVar.toJson().toString());
        } catch (Exception e2) {
            c.printStackTraceOnly(e2);
        }
    }

    private static boolean c(long j10, long j11) {
        if (j10 > 0 && j11 > 0) {
            try {
                return gL.format(new Date(j10)).equals(gL.format(new Date(j11)));
            } catch (Exception e2) {
                c.printStackTraceOnly(e2);
            }
        }
        return false;
    }

    public static int cM() {
        String LF = y.LF();
        if (TextUtils.isEmpty(LF)) {
            return 0;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(LF));
            if (c(aVar.gM, System.currentTimeMillis())) {
                return aVar.jA;
            }
            return 0;
        } catch (Exception e2) {
            c.printStackTraceOnly(e2);
            return 0;
        }
    }
}
