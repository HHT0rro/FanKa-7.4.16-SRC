package com.kwad.components.core.webview.tachikoma.c;

import android.view.View;
import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.components.m;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d extends Presenter {
    private FrameLayout SK;
    private m SQ;
    private e YI;
    public b aay;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        b bVar = (b) Jx();
        this.aay = bVar;
        e eVar = bVar.YI;
        this.YI = eVar;
        if (eVar != null) {
            eVar.a(new com.kwad.components.core.webview.tachikoma.e.d() { // from class: com.kwad.components.core.webview.tachikoma.c.d.1
                @Override // com.kwad.components.core.webview.tachikoma.e.d
                public final void fR() {
                }

                @Override // com.kwad.components.core.webview.tachikoma.e.d
                public final void fZ() {
                }
            });
        }
        m a10 = this.aay.aaB.a(null);
        this.SQ = a10;
        if (a10 == null) {
            this.aay.aaA.callbackPageStatus(false, null);
            this.YI.getDialog().dismiss();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View view = this.SQ.getView();
        view.setLayoutParams(layoutParams);
        this.SK.addView(view);
        this.SQ.render();
        this.aay.aaA.callbackPageStatus(true, null);
    }

    public final boolean onBackPressed() {
        m mVar = this.SQ;
        return mVar != null && mVar.onBackPressed();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.SK = (FrameLayout) findViewById(R.id.ksad_tk_dialog_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
