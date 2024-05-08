package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class be implements com.kwad.sdk.core.webview.c.a {
    private static Handler Ym;
    private com.kwad.components.core.e.d.c Kz;
    private com.kwad.sdk.core.webview.b Yl;
    private b Yn;

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int kl;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        @MainThread
        void Q(int i10);
    }

    public be(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, b bVar2) {
        this.Yl = bVar;
        this.Kz = cVar;
        this.Yn = bVar2;
        if (Ym == null) {
            Ym = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "playableConvert";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            final int i10 = aVar.kl;
            Ym.post(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.be.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    if (be.this.Yn != null) {
                        be.this.Yn.Q(i10);
                    }
                }
            });
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
        }
    }
}
