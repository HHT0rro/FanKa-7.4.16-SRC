package com.kwad.components.ad.splashscreen.c.a;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.kwad.sdk.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends com.kwad.components.ad.splashscreen.c.e {
    private AnimatorSet Er;
    private TextView Es;
    private ViewGroup Et;
    private ViewGroup Eu;

    private void initView() {
        this.Es = (TextView) findViewById(R.id.ksad_ad_developer_text);
        this.Et = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_view);
        this.Eu = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_dialog_root);
    }

    private void lA() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.Eu, Key.ALPHA, 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.Es, Key.ALPHA, 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.Et, "scaleX", 0.8f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.Et, "scaleY", 0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.Er = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        this.Er.setDuration(300L);
        this.Er.start();
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        lA();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        AnimatorSet animatorSet = this.Er;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
