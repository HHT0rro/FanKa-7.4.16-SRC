package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import com.mobile.auth.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ak implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b Wf;
    private int Xr = 0;
    private a Xs;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void onAdShow();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class b extends com.kwad.sdk.core.report.a {
        private String Jj;
        private String KG;
        private int Xt;
        private int actionType;
        private AdTemplate adTemplate;

        public final int getActionType() {
            return this.actionType;
        }

        public final String mM() {
            return this.Jj;
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.actionType = jSONObject.optInt("actionType");
            this.Xt = jSONObject.optInt("refreshType");
            this.KG = jSONObject.optString("payload");
            this.Jj = jSONObject.optString("creativeId");
            try {
                if (jSONObject.has("adTemplate")) {
                    String string = jSONObject.getString("adTemplate");
                    if (this.adTemplate == null) {
                        this.adTemplate = new AdTemplate();
                    }
                    this.adTemplate.parseJson(new JSONObject(string));
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            }
            if (this.adTemplate == null && jSONObject.has("adCacheId")) {
                this.adTemplate = com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.n.a.d.a.a.at(jSONObject.optInt("adCacheId")), this.Jj);
            }
        }

        public final String sp() {
            return this.KG;
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "actionType", this.actionType);
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", this.KG);
            com.kwad.sdk.utils.t.putValue(jSONObject, "refreshType", this.Xt);
            com.kwad.sdk.utils.t.a(jSONObject, "adTemplate", this.adTemplate);
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", this.Jj);
            return jSONObject;
        }
    }

    public ak(com.kwad.sdk.core.webview.b bVar) {
        this.Wf = bVar;
    }

    private AdTemplate c(@NonNull b bVar) {
        if (bVar.adTemplate != null) {
            return bVar.adTemplate;
        }
        return this.Wf.cV(bVar.Jj);
    }

    public final void a(a aVar) {
        this.Xs = aVar;
    }

    public void a(com.kwad.sdk.core.adlog.c.b bVar) {
    }

    public void b(boolean z10, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.core.s.b.qY().a(adTemplate, null, bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return BuildConfig.FLAVOR_type;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            if (c(bVar) == null) {
                cVar.onError(-1, "native adTemplate is null");
            }
            a(bVar);
            cVar.a(null);
        } catch (JSONException e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            cVar.onError(-1, e2.getMessage());
        }
    }

    public void a(@NonNull b bVar) {
        com.kwad.sdk.core.e.c.d("WebCardLogHandler", "handleH5Log actionType actionType" + bVar.actionType);
        if (bVar.actionType == 1) {
            com.kwad.sdk.core.adlog.c.b dd2 = new com.kwad.sdk.core.adlog.c.b().dd(bVar.KG);
            a aVar = this.Xs;
            if (aVar != null) {
                aVar.onAdShow();
            }
            if (bVar.adTemplate != null) {
                dd2.cO(this.Xr);
                b(true, bVar.adTemplate, null, dd2);
                return;
            } else {
                if (bg.isNullString(bVar.mM())) {
                    b(true, this.Wf.getAdTemplate(), null, dd2);
                    return;
                }
                for (AdTemplate adTemplate : this.Wf.GM()) {
                    if (bg.isEquals(bVar.mM(), String.valueOf(com.kwad.sdk.core.response.b.e.ea(adTemplate)))) {
                        b(false, adTemplate, null, dd2);
                        return;
                    }
                }
                return;
            }
        }
        if (bVar.actionType == 2) {
            com.kwad.sdk.widget.e eVar = this.Wf.aDJ;
            com.kwad.sdk.core.adlog.c.b dd3 = new com.kwad.sdk.core.adlog.c.b().cO(this.Xr).dd(bVar.KG);
            if (eVar != null) {
                dd3.f(eVar.getTouchCoords());
            }
            a(dd3);
            com.kwad.sdk.core.adlog.c.a(c(bVar), dd3, this.Wf.mReportExtData);
            return;
        }
        if (bVar.actionType == 12006) {
            com.kwad.components.core.o.a.qi().b(c(bVar), bVar.Xt, this.Xr);
            return;
        }
        if (bVar.actionType == 140) {
            com.kwad.sdk.core.adlog.c.d(c(bVar), this.Wf.mReportExtData, new com.kwad.sdk.core.adlog.c.b().dd(bVar.KG));
        } else if (bVar.actionType == 141) {
            com.kwad.sdk.core.adlog.c.e(c(bVar), this.Wf.mReportExtData, new com.kwad.sdk.core.adlog.c.b().dd(bVar.KG));
        } else {
            com.kwad.sdk.core.adlog.c.a(c(bVar), bVar.actionType, this.Wf.mReportExtData, bVar.KG);
            com.kwad.components.core.webview.tachikoma.d.a.sY().aW(bVar.KG);
        }
    }
}
