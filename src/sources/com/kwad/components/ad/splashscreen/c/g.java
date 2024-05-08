package com.kwad.components.ad.splashscreen.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class g extends e {
    private static void j(View view, int i10) {
        if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = i10;
            view.setLayoutParams(layoutParams);
        } else if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.topMargin = i10;
            view.setLayoutParams(layoutParams2);
        }
    }

    private void le() {
        bn.postOnUiThread(new ay() { // from class: com.kwad.components.ad.splashscreen.c.g.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (g.this.getActivity() != null) {
                    try {
                        ViewGroup viewGroup = (ViewGroup) g.this.getActivity().getWindow().getDecorView();
                        if (com.kwad.sdk.d.a.a.C(viewGroup) && com.kwad.sdk.d.a.a.aI(g.this.getActivity()) == viewGroup.getHeight()) {
                            g.this.lf();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lf() {
        if (getContext() == null) {
            return;
        }
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate);
        j(findViewById(com.kwad.components.ad.splashscreen.f.c.z(dQ) ? R.id.ksad_preload_right_container : R.id.ksad_preload_left_container), x(dQ));
        if (com.kwad.components.ad.splashscreen.f.c.z(dQ)) {
            j(findViewById(R.id.ksad_splash_logo_container), com.kwad.sdk.d.a.a.getStatusBarHeight(getActivity()) + com.kwad.sdk.d.a.a.a(getContext(), 12.0f));
            j(findViewById(R.id.ksad_splash_sound), com.kwad.sdk.d.a.a.getStatusBarHeight(getActivity()) + com.kwad.sdk.d.a.a.a(getContext(), 32.0f));
            j(findViewById(R.id.ksad_skip_view_area), com.kwad.sdk.d.a.a.getStatusBarHeight(getActivity()));
        }
    }

    private int x(AdInfo adInfo) {
        int a10;
        int statusBarHeight;
        if (com.kwad.components.ad.splashscreen.f.c.z(adInfo)) {
            a10 = com.kwad.sdk.d.a.a.a(getActivity(), 32.0f);
            statusBarHeight = com.kwad.sdk.d.a.a.getStatusBarHeight(getActivity());
        } else {
            a10 = com.kwad.sdk.d.a.a.a(getActivity(), 16.0f);
            statusBarHeight = com.kwad.sdk.d.a.a.getStatusBarHeight(getActivity());
        }
        return a10 + statusBarHeight;
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        le();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
