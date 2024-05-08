package com.kwad.components.core.page.c.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e extends a {
    private LinearLayout Oa;
    private TextView Ob;
    private ImageView Oc;

    private void pA() {
        this.Oa = (LinearLayout) findViewById(R.id.ksad_web_tip_bar);
        if (!TextUtils.isEmpty(this.OH.mPageTitle)) {
            this.Oa.setVisibility(8);
            return;
        }
        this.Ob = (TextView) findViewById(R.id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_web_tip_close_btn);
        this.Oc = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.e.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.Oa.setVisibility(8);
            }
        });
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.OH.mAdTemplate);
        boolean bw = com.kwad.sdk.core.response.b.a.bw(dQ);
        String bs = com.kwad.sdk.core.response.b.a.bs(dQ);
        if (bw) {
            this.Oa.setVisibility(0);
            this.Ob.setText(bs);
            this.Ob.setSelected(true);
        } else {
            this.Oa.setVisibility(8);
        }
        this.OH.a(pB());
    }

    @NonNull
    private KsAdWebView.c pB() {
        return new KsAdWebView.c() { // from class: com.kwad.components.core.page.c.a.e.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.c
            public final void pC() {
                if (e.this.OH.pi() && e.this.Oa.getVisibility() == 0) {
                    e.this.Oa.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        pA();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
