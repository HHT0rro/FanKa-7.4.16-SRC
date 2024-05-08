package com.kwad.components.ad.splashscreen.c;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class f extends e {
    private ComplianceTextView cj;

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(com.kwad.components.ad.splashscreen.f.c.z(com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate)) ? R.id.ksad_compliance_right_view : R.id.ksad_compliance_left_view);
        this.cj = complianceTextView;
        complianceTextView.setBackgroundColor(0);
        this.cj.setVisibility(0);
        this.cj.setAdTemplate(this.Dg.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
