package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {
    public static final String TAG = "d";

    private static void a(@NonNull c cVar) {
        try {
            a.a(cVar);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.e(TAG, Log.getStackTraceString(th));
        }
    }

    public static void c(@NonNull c cVar) {
        if (new Random().nextFloat() >= cVar.sampleRate) {
            com.kwad.sdk.core.e.c.d(TAG, "config.sampleRate：" + cVar.sampleRate + " return");
            return;
        }
        if (cVar.KD()) {
            a(cVar);
        }
        if (cVar.KE()) {
            d(cVar);
        }
    }

    public static void cH(final String str) {
        g.schedule(new ay() { // from class: com.kwad.sdk.ranger.d.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                String str2 = String.this;
                if (TextUtils.isEmpty(str2)) {
                    com.kwad.sdk.core.e.c.w(d.TAG, "config is empty");
                    return;
                }
                c go = d.go(str2);
                if (go != null) {
                    com.kwad.sdk.core.e.c.d(d.TAG, "config:" + go.toJson().toString());
                }
                if (go == null || go.KC()) {
                    return;
                }
                d.c(go);
            }
        }, 0L, TimeUnit.SECONDS);
    }

    private static void d(c cVar) {
        b.KA().b(cVar);
    }

    public static c go(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c cVar = new c();
            cVar.parseJson(jSONObject);
            return cVar;
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.w(TAG, e2);
            return null;
        }
    }
}
