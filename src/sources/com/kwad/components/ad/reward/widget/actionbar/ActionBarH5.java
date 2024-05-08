package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ActionBarH5 extends FrameLayout implements c {
    private View BA;
    private TextView By;
    private a Bz;
    private TextView dM;
    private AdTemplate mAdTemplate;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void N(boolean z10);
    }

    public ActionBarH5(Context context) {
        super(context);
        B(context);
    }

    private void B(Context context) {
        l.inflate(context, R.layout.ksad_video_actionbar_h5, this);
        this.By = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.dM = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.BA = findViewById(R.id.ksad_download_bar_cover);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (d.dF(this.mAdTemplate)) {
            b(view, false);
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        this.Bz = aVar;
        AdInfo dQ = e.dQ(adTemplate);
        this.By.setText(com.kwad.sdk.core.response.b.a.au(dQ));
        this.dM.setText(com.kwad.sdk.core.response.b.a.aE(dQ));
        setClickable(true);
        this.BA.setClickable(true);
        new f(this.BA, this);
        new f(this, this);
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    private void b(View view, final boolean z10) {
        com.kwad.components.core.e.d.a.a(new a.C0461a(view.getContext()).aq(this.mAdTemplate).an(view == this.BA ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (ActionBarH5.this.Bz != null) {
                    ActionBarH5.this.Bz.N(z10);
                }
            }
        }));
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        B(context);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }
}
