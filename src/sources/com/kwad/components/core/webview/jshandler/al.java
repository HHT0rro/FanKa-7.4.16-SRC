package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class al implements com.kwad.sdk.core.webview.c.a {
    private final Handler WA;
    private final com.kwad.sdk.core.webview.b Wf;

    @Nullable
    private final b Xu;

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public boolean XA;
        public String XB;
        public int XC;
        public com.kwad.sdk.core.webview.d.b.c XD;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "clickAction";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.WA.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        final com.kwad.components.core.e.d.c cVar2;
        final a aVar = new a();
        final AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.XB));
        } catch (JSONException e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
        }
        if (com.kwad.sdk.core.response.b.e.dI(adTemplate)) {
            if (this.Wf.aDK != null) {
                cVar2 = (com.kwad.components.core.e.d.c) this.Wf.aDK.gA(com.kwad.sdk.core.response.b.e.dQ(adTemplate).downloadId);
            } else {
                cVar2 = null;
            }
            if (this.Wf.aDL) {
                this.WA.post(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.al.1
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        com.kwad.components.core.e.d.a.a(new a.C0461a(al.this.Wf.OE.getContext()).aq(adTemplate).b(cVar2).an(aVar.XC).ao(true).ag(aVar.XD.KG).aq(true).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.al.1.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                            }
                        }));
                    }
                });
            } else if (this.Xu != null) {
                this.WA.post(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.al.2
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                    }
                });
            }
            cVar.a(null);
        }
    }
}
