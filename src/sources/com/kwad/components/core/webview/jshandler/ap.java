package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ap implements com.kwad.sdk.core.webview.c.a {
    private AdTemplate mAdTemplate;
    private Context mContext;

    public ap(Context context, AdTemplate adTemplate) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.a.c cVar2 = new com.kwad.components.core.webview.a.c();
        if (this.mContext == null) {
            com.kwad.sdk.core.adlog.c.j(this.mAdTemplate, 2);
            cVar.onError(-1, "context为空");
            return;
        }
        AdTemplate adTemplate = null;
        try {
            cVar2.parseJson(new JSONObject(str));
            AdTemplate adTemplate2 = this.mAdTemplate;
            try {
                int i10 = cVar2.VN;
                if (i10 > 0) {
                    adTemplate2 = com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.n.a.d.a.a.at(i10), cVar2.Jj);
                }
                if (adTemplate2 == null) {
                    com.kwad.sdk.core.adlog.c.j(this.mAdTemplate, 2);
                    cVar.onError(-1, "adTemplate为空：" + cVar2.VN);
                    return;
                }
                AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate2);
                if (!com.kwad.sdk.core.response.b.a.S(dQ) && com.kwad.components.core.e.d.e.a(this.mContext, dQ.adConversionInfo.smallAppJumpInfo.mediaSmallAppId, cVar2.VL, cVar2.VM, adTemplate2) == 1) {
                    cVar.a(null);
                } else {
                    cVar.onError(-1, "跳转失败");
                }
            } catch (Exception e2) {
                e = e2;
                adTemplate = adTemplate2;
                com.kwad.sdk.core.adlog.c.j(adTemplate, 2);
                cVar.onError(-1, "解析失败");
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        } catch (Exception e10) {
            e = e10;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "openWechatMiniProgram";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
