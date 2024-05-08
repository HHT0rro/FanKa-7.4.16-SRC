package com.kwad.components.ad.draw.b.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.k.b;
import com.kwad.sdk.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b extends com.kwad.components.ad.draw.a.a {
    private com.kwad.sdk.core.webview.d.a.a cR = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.draw.b.c.b.1
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (b.this.bO.bN != null) {
                b.this.bO.bN.onAdClicked();
            }
        }
    };

    @Nullable
    private com.kwad.components.ad.k.b ci;

    /* renamed from: da, reason: collision with root package name */
    private FrameLayout f36413da;

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.k.b bVar = this.bO.ci;
        this.ci = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.cR);
        com.kwad.components.ad.k.b bVar2 = this.ci;
        FrameLayout frameLayout = this.f36413da;
        com.kwad.components.ad.draw.a.b bVar3 = this.bO;
        bVar2.a(frameLayout, bVar3.mRootContainer, bVar3.mAdTemplate, bVar3.mApkDownloadHelper);
        this.ci.a((b.InterfaceC0424b) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f36413da = (FrameLayout) findViewById(R.id.ksad_play_end_web_card_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.k.b bVar = this.ci;
        if (bVar != null) {
            bVar.lW();
        }
    }
}
