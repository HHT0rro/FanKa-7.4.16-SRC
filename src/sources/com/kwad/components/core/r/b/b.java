package com.kwad.components.core.r.b;

import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.core.proxy.c;
import com.kwad.sdk.R;
import com.kwad.sdk.components.m;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b extends Presenter {
    private FrameLayout SK;
    private com.kwad.components.core.r.a.b SN;
    private m SQ;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.SN = (com.kwad.components.core.r.a.b) Jx();
        this.SK = (FrameLayout) findViewById(R.id.ksad_js_container);
        this.SQ = this.SN.SE.a(null);
        this.SN.Ms.add(new com.kwad.components.core.l.a.a() { // from class: com.kwad.components.core.r.b.b.1
            @Override // com.kwad.components.core.l.a.a
            public final void c(c cVar) {
            }

            @Override // com.kwad.components.core.l.a.a
            public final void d(c cVar) {
            }

            @Override // com.kwad.components.core.l.a.a
            public final void fP() {
            }

            @Override // com.kwad.components.core.l.a.a
            public final void fQ() {
                if (b.this.SN.SD != null) {
                    b.this.SN.SD.callbackDismiss();
                }
            }
        });
        if (this.SQ == null) {
            if (getActivity() != null) {
                getActivity().finish();
            }
        } else {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            View view = this.SQ.getView();
            view.setLayoutParams(layoutParams);
            this.SK.addView(view);
            this.SQ.bindActivity(getActivity());
            this.SQ.render();
        }
    }

    public final boolean onBackPressed() {
        m mVar = this.SQ;
        return mVar != null && mVar.onBackPressed();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
