package com.kwad.components.ad.reward.widget.tailframe;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TailFrameBarH5View extends LinearLayout {
    public TextView dL;
    public TextView dM;
    public ValueAnimator jo;

    public TailFrameBarH5View(Context context) {
        this(context, null, 0);
    }

    private void f(Context context, int i10) {
        l.inflate(context, i10, this);
        this.dL = (TextView) findViewById(R.id.ksad_tf_h5_ad_desc);
        this.dM = (TextView) findViewById(R.id.ksad_tf_h5_open_btn);
    }

    private void kl() {
        if (this.jo != null) {
            km();
            this.jo.start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.jo = ofFloat;
        ofFloat.setDuration(1200L);
        this.jo.setRepeatCount(-1);
        this.jo.setRepeatMode(1);
        this.jo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.tailframe.TailFrameBarH5View.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5View.this.dM.setScaleY(floatValue);
                TailFrameBarH5View.this.dM.setScaleX(floatValue);
            }
        });
        this.jo.start();
    }

    public final void b(@NonNull AdTemplate adTemplate) {
        AdInfo dQ = e.dQ(adTemplate);
        this.dL.setText(com.kwad.sdk.core.response.b.a.au(dQ));
        this.dM.setText(com.kwad.sdk.core.response.b.a.aE(dQ));
        kl();
    }

    public final void g(boolean z10, boolean z11) {
        int i10;
        if (!z10) {
            i10 = R.layout.ksad_video_tf_bar_h5_landscape;
        } else if (z11) {
            i10 = R.layout.ksad_video_tf_bar_h5_portrait_vertical;
        } else {
            i10 = R.layout.ksad_video_tf_bar_h5_portrait_horizontal;
        }
        f(getContext(), i10);
    }

    public TextView getH5OpenBtn() {
        return this.dM;
    }

    public final void km() {
        ValueAnimator valueAnimator = this.jo;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.jo.cancel();
        this.jo.end();
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
