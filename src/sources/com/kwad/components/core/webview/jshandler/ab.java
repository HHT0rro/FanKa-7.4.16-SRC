package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ab implements com.kwad.sdk.core.webview.c.a {
    private a WI;
    private final com.kwad.sdk.core.webview.b Wf;
    private Handler fS = new Handler(Looper.getMainLooper());

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void bA();
    }

    public ab(com.kwad.sdk.core.webview.b bVar, a aVar) {
        this.Wf = bVar;
        this.WI = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "dislike";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.fS.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.fS.post(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.ab.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                ab.this.WI.bA();
            }
        });
        cVar.a(null);
    }
}
