package com.kwad.components.core.e.e;

import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d extends b implements View.OnClickListener {
    private TextView Lr;
    private TextView Ls;
    private TextView qO;

    @Override // com.kwad.components.core.e.e.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (this.Lq.Lp.nB() == 1) {
            this.qO.setText("即将打开" + com.kwad.sdk.core.response.b.a.cd(this.mAdInfo));
        } else if (this.Lq.Lp.nB() == 2) {
            this.qO.setText("即将打开第三方页面");
        }
        com.kwad.sdk.d.a.a.a(this, this.Lr, this.Ls);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.Lq.Lp.ak(true);
        this.Lq.Ln.dismiss();
        if (view == this.Lr) {
            com.kwad.components.core.e.d.a.a(this.Lq.Lp);
            com.kwad.sdk.core.adlog.c.p(this.Lq.Lp.getAdTemplate(), 230);
        } else if (view == this.Ls) {
            com.kwad.sdk.core.adlog.c.p(this.Lq.Lp.getAdTemplate(), 231);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.qO = (TextView) findViewById(R.id.ksad_second_confirm_content_view);
        this.Lr = (TextView) findViewById(R.id.ksad_second_confirm_ensure);
        this.Ls = (TextView) findViewById(R.id.ksad_second_confirm_cancle);
    }
}
