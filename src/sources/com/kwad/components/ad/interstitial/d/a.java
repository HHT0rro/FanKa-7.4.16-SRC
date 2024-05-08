package com.kwad.components.ad.interstitial.d;

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
    public long jD = -1;
    public int jE = 0;

    public static void J(Context context) {
        String LJ = y.LJ();
        a aVar = new a();
        if (TextUtils.isEmpty(LJ)) {
            aVar.jE = 1;
            aVar.jD = System.currentTimeMillis();
            y.ae(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(LJ));
            if (c(aVar.jD, System.currentTimeMillis())) {
                aVar.jE++;
            } else {
                aVar.jE = 1;
                aVar.jD = System.currentTimeMillis();
            }
            y.ae(context, aVar.toJson().toString());
        } catch (Exception e2) {
            c.printStackTrace(e2);
        }
    }

    private static boolean c(long j10, long j11) {
        if (j10 > 0 && j11 > 0) {
            try {
                return gL.format(new Date(j10)).equals(gL.format(new Date(j11)));
            } catch (Exception e2) {
                c.printStackTrace(e2);
            }
        }
        return false;
    }

    public static int cO() {
        String LJ = y.LJ();
        if (TextUtils.isEmpty(LJ)) {
            return 0;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(LJ));
            if (c(aVar.jD, System.currentTimeMillis())) {
                return aVar.jE;
            }
            return 0;
        } catch (Exception e2) {
            c.printStackTrace(e2);
            return 0;
        }
    }
}
