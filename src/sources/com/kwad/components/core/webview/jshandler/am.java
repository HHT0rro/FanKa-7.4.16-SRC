package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class am implements com.kwad.sdk.core.webview.c.a {
    private List<c> mHolders = new ArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends com.kwad.sdk.core.download.a.a {
        private c XE;

        public a(c cVar) {
            this.XE = cVar;
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            am.a(this.XE, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            am.a(this.XE, 5, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            am.a(this.XE, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            am.a(this.XE, 6, 1.0f);
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i10) {
            am.a(this.XE, 3, (i10 * 1.0f) / 100.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
            am.a(this.XE, 2, (i10 * 1.0f) / 100.0f);
        }
    }

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b extends com.kwad.sdk.core.response.a.a {
        public long creativeId = -1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c {
        private com.kwad.components.core.e.d.c XF;
        private a XG;
        private AdTemplate mAdTemplate;
        private com.kwad.sdk.core.webview.c.c ns;

        public c(com.kwad.components.core.e.d.c cVar, AdTemplate adTemplate) {
            this.XF = cVar;
            this.mAdTemplate = adTemplate;
        }

        public final void destroy() {
            a aVar;
            com.kwad.components.core.e.d.c cVar = this.XF;
            if (cVar == null || (aVar = this.XG) == null) {
                return;
            }
            cVar.c(aVar);
        }

        public final long getCreativeId() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return -1L;
            }
            return com.kwad.sdk.core.response.b.e.ea(adTemplate);
        }

        public final void a(a aVar) {
            this.XF.b(aVar);
            this.XG = aVar;
        }
    }

    public am(List<AdTemplate> list, List<com.kwad.components.core.e.d.c> list2) {
        if (list == null || list2 == null) {
            return;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mHolders.add(new c(list2.get(i10), list.get(i10)));
        }
    }

    private c K(long j10) {
        if (j10 == -1) {
            return null;
        }
        for (c cVar : this.mHolders) {
            if (cVar.getCreativeId() == j10) {
                return cVar;
            }
        }
        return null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                b bVar = new b();
                bVar.parseJson(jSONObject);
                c K = K(bVar.creativeId);
                if (K != null) {
                    K.ns = cVar;
                    K.a(new a(K));
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerMultiProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        Iterator<c> iterator2 = this.mHolders.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(c cVar, int i10, float f10) {
        if (cVar == null || cVar.ns == null) {
            return;
        }
        com.kwad.sdk.core.e.c.d("MultiProgressListener", "notifyDownloadProgress: " + ((Object) cVar.ns) + f10);
        com.kwad.sdk.core.webview.c.c cVar2 = cVar.ns;
        az.a aVar = new az.a();
        aVar.Ya = f10;
        aVar.status = i10;
        aVar.creativeId = cVar.getCreativeId();
        aVar.totalBytes = com.kwad.sdk.core.response.b.e.dQ(cVar.mAdTemplate).totalBytes;
        cVar2.a(aVar);
    }
}
