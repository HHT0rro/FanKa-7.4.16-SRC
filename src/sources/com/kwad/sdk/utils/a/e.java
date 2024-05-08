package com.kwad.sdk.utils.a;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.a.c;
import com.kwad.sdk.utils.q;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {
    public static ExecutorService aJs = Executors.newSingleThreadExecutor();
    public static boolean aPh = NO();

    private static boolean NO() {
        d.setExecutor(aJs);
        d.a(new c.d() { // from class: com.kwad.sdk.utils.a.e.1
            @Override // com.kwad.sdk.utils.a.c.d
            public final void a(String str, Exception exc) {
                com.kwad.sdk.core.e.c.w("UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(exc));
            }

            @Override // com.kwad.sdk.utils.a.c.d
            public final void e(String str, Throwable th) {
                com.kwad.sdk.core.e.c.e("UnionKv", "name:" + str + " msg:" + Log.getStackTraceString(th));
            }

            @Override // com.kwad.sdk.utils.a.c.d
            public final void i(String str, String str2) {
                com.kwad.sdk.core.e.c.i("UnionKv", "name:" + str + " msg:" + str2);
            }
        });
        aPh = true;
        return true;
    }

    public static c av(@NonNull Context context, String str) {
        if (!aPh) {
            NO();
        }
        return new c.a(q.N(context, "ks_union"), str).NM();
    }
}
