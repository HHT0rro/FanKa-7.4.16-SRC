package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class az implements com.kwad.sdk.core.webview.c.a {

    @Nullable
    private KsAppDownloadListener VG;

    @Nullable
    private com.kwad.sdk.core.webview.c.c VX;

    @Nullable
    private KsAppDownloadListener XY;
    private final com.kwad.sdk.core.webview.b cO;
    private final com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public float Ya;
        public long creativeId;
        public int status;
        public long totalBytes;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "progress", this.Ya);
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", this.status);
            com.kwad.sdk.utils.t.putValue(jSONObject, DBDefinition.TOTAL_BYTES, this.totalBytes);
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }
    }

    public az(com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar) {
        this.cO = bVar;
        this.mApkDownloadHelper = cVar;
    }

    private KsAppDownloadListener sm() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.jshandler.az.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                az.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                az.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                az.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                az.this.a(6, 1.0f);
                if (az.this.XY != null) {
                    az.this.XY.onInstalled();
                }
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i10) {
                az.this.a(3, (i10 * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i10) {
                az.this.a(2, (i10 * 1.0f) / 100.0f);
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        KsAppDownloadListener ksAppDownloadListener;
        this.VX = null;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.VG) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
        this.VG = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.cO.GN()) {
            cVar.onError(-1, "native photo is null");
            return;
        }
        this.VX = cVar;
        com.kwad.components.core.e.d.c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            KsAppDownloadListener ksAppDownloadListener = this.VG;
            if (ksAppDownloadListener == null) {
                KsAppDownloadListener sm = sm();
                this.VG = sm;
                this.mApkDownloadHelper.b(sm);
                return;
            }
            cVar2.d(ksAppDownloadListener);
        }
    }

    public az(com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable KsAppDownloadListener ksAppDownloadListener) {
        this.cO = bVar;
        this.mApkDownloadHelper = cVar;
        this.XY = ksAppDownloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, float f10) {
        if (this.VX != null) {
            a aVar = new a();
            aVar.Ya = f10;
            aVar.status = i10;
            aVar.totalBytes = com.kwad.sdk.core.response.b.e.dQ(this.cO.getAdTemplate()).totalBytes;
            this.VX.a(aVar);
        }
    }
}
