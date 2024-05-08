package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class aa implements com.kwad.sdk.core.webview.c.a {
    private Handler WA;
    private boolean WE;
    private boolean WF;
    private final com.kwad.sdk.core.webview.b Wf;
    private boolean Ws;

    @Nullable
    private com.kwad.sdk.core.webview.d.a.a cR;

    @Nullable
    private final com.kwad.components.core.e.d.c mApkDownloadHelper;

    public aa(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, boolean z10, boolean z11, boolean z12) {
        this.WE = false;
        this.WF = false;
        this.Ws = z10;
        this.WA = new Handler(Looper.getMainLooper());
        this.Wf = bVar;
        this.mApkDownloadHelper = cVar;
        this.WE = false;
        if (cVar != null) {
            cVar.as(1);
        }
        this.cR = aVar;
        this.WF = z12;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "convert";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.WA.removeCallbacksAndMessages(null);
        this.cR = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.Wf.GN()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        final com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        try {
            aVar.parseJson(new JSONObject(str));
            aVar.Kr = true;
        } catch (JSONException e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
        }
        if (this.Wf.aDL) {
            this.WA.post(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.aa.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    if (aa.this.Wf.aDM || aVar.XA) {
                        aa.this.Wf.getAdTemplate();
                        com.kwad.components.core.e.d.a.a(aa.this.Wf.OE.getContext(), aa.this.Wf.getAdTemplate(), new a.b() { // from class: com.kwad.components.core.webview.jshandler.aa.1.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                if (aa.this.cR != null) {
                                    aa.this.cR.a(aVar);
                                }
                            }
                        }, aa.this.mApkDownloadHelper, aVar.XA, aa.this.Ws, aa.this.WE, aa.this.WF);
                    }
                }
            });
        } else if (this.cR != null) {
            this.WA.post(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.aa.2
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    if (aa.this.cR != null) {
                        aa.this.cR.a(aVar);
                    }
                }
            });
        }
        cVar.a(null);
    }

    public aa(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, cVar, aVar, false, false, false);
    }

    public aa(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, byte b4) {
        this(bVar, cVar, aVar, false, false, false);
    }
}
