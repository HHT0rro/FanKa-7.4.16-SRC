package com.kwad.components.ad.splashscreen.local;

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
    public long gM = 0;
    public int gN = 0;

    public static void R(Context context) {
        String LH = y.LH();
        a aVar = new a();
        if (TextUtils.isEmpty(LH)) {
            aVar.gN = 1;
            aVar.gM = System.currentTimeMillis();
            y.ac(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(LH));
            if (c(aVar.gM, System.currentTimeMillis())) {
                aVar.gN++;
            } else {
                aVar.gN = 1;
            }
            aVar.gM = System.currentTimeMillis();
            y.ac(context, aVar.toJson().toString());
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
}
