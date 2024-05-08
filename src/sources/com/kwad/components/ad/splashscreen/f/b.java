package com.kwad.components.ad.splashscreen.f;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b implements com.kwad.sdk.widget.c {
    private a Dt;
    private ViewStub Fq;
    private ViewGroup Fr;
    private View Fs;
    private TextView Ft;
    private boolean Fu;

    @Nullable
    private e Fv;
    private f Fw;

    @NonNull
    private ViewGroup gS;

    @Nullable
    private AdInfo mAdInfo;

    @Nullable
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    public b(@NonNull ViewGroup viewGroup, ViewStub viewStub, boolean z10, com.kwad.components.core.e.d.c cVar) {
        this.gS = viewGroup;
        this.Fq = viewStub;
        this.mApkDownloadHelper = cVar;
        this.Fu = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(String str) {
        TextView textView = this.Ft;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    private void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.Fs = viewGroup.findViewById(R.id.ksad_splash_actionbar_native);
        this.Ft = (TextView) viewGroup.findViewById(R.id.ksad_splash_actionbar_text);
        this.Fw = new f(this.Fs.getContext(), this.Fs, this);
        a(com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mAdInfo, this.mApkDownloadHelper, 4));
    }

    private void i(boolean z10, boolean z11) {
        e eVar = this.Fv;
        if (eVar != null) {
            eVar.h(z10, z11);
        }
    }

    public final void ah(AdTemplate adTemplate) {
        a aVar;
        this.mAdTemplate = adTemplate;
        a aVar2 = this.Dt;
        if (aVar2 == null) {
            this.Dt = new a(this.gS.getContext(), this.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.f.b.1
                {
                    super(r3);
                }

                @Override // com.kwad.components.ad.splashscreen.f.a
                public final void k(int i10, String str) {
                    b.this.V(str);
                }
            };
        } else {
            aVar2.setAdTemplate(adTemplate);
        }
        if (adTemplate != null) {
            this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        }
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (aVar = this.Dt) == null) {
            return;
        }
        cVar.b(aVar);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (this.Fu) {
            i(false, view.equals(this.Fs));
        }
    }

    public final void lw() {
        com.kwad.sdk.core.e.c.d("SplashActionBarNativeHelper", "rollBackToNative mRootViewStub: " + ((Object) this.Fq));
        if (this.Fr == null) {
            ViewStub viewStub = this.Fq;
            if (viewStub != null && viewStub.getParent() != null) {
                this.Fr = (ViewGroup) this.Fq.inflate();
            } else {
                this.Fr = (ViewGroup) this.gS.findViewById(R.id.ksad_splash_actionbar_native_root);
            }
            g(this.Fr);
        }
        ViewGroup viewGroup = this.Fr;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public final void onUnbind() {
        a aVar;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (aVar = this.Dt) == null) {
            return;
        }
        cVar.c(aVar);
    }

    public final void a(@Nullable e eVar) {
        this.Fv = eVar;
    }

    private void a(com.kwad.components.ad.splashscreen.d dVar) {
        if (dVar == null) {
            return;
        }
        V(dVar.ku());
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        i(true, view.equals(this.Fs));
    }
}
