package com.kwad.components.ad.reward.model;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat gL = new SimpleDateFormat("yyyy-MM-dd");
    public long jD = -1;
    public int jE = 0;

    public static void J(Context context) {
        String LI = y.LI();
        b bVar = new b();
        if (TextUtils.isEmpty(LI)) {
            bVar.jE = 1;
            bVar.jD = System.currentTimeMillis();
            y.ad(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(LI));
            if (c(bVar.jD, System.currentTimeMillis())) {
                bVar.jE++;
            } else {
                bVar.jE = 1;
                bVar.jD = System.currentTimeMillis();
            }
            y.ad(context, bVar.toJson().toString());
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
        }
    }

    private static boolean c(long j10, long j11) {
        if (j10 > 0 && j11 > 0) {
            try {
                return gL.format(new Date(j10)).equals(gL.format(new Date(j11)));
            } catch (Exception e2) {
                com.kwad.sdk.core.e.c.printStackTrace(e2);
            }
        }
        return false;
    }

    public static int cO() {
        String LI = y.LI();
        if (TextUtils.isEmpty(LI)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(LI));
            if (c(bVar.jD, System.currentTimeMillis())) {
                return bVar.jE;
            }
            return 0;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            return 0;
        }
    }
}
