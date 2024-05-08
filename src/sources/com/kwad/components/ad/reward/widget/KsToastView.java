package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.n.l;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class KsToastView extends LinearLayout {
    public TextView Bd;
    private String Be;
    private Runnable Bf;
    private int countDown;

    public KsToastView(Context context) {
        super(context);
        this.countDown = 3;
        this.Be = "%ss后自动进入";
        this.Bf = null;
        init(context);
    }

    public static /* synthetic */ int b(KsToastView ksToastView) {
        int i10 = ksToastView.countDown;
        ksToastView.countDown = i10 - 1;
        return i10;
    }

    private void init(Context context) {
        l.inflate(context, R.layout.ksad_interstitial_toast_layout, this);
        this.Bd = (TextView) findViewById(R.id.ksad_total_count_down_text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i10) {
        this.Bd.setText(String.format(this.Be, Integer.valueOf(i10)));
    }

    public final void U(int i10) {
        if (this.Bf == null) {
            this.Bf = new Runnable() { // from class: com.kwad.components.ad.reward.widget.KsToastView.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (KsToastView.this.countDown == 0) {
                        return;
                    }
                    KsToastView ksToastView = KsToastView.this;
                    ksToastView.x(ksToastView.countDown);
                    KsToastView.b(KsToastView.this);
                    KsToastView.this.postDelayed(this, 1000L);
                }
            };
        }
        this.countDown = 3;
        post(this.Bf);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.Bf);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 3;
        this.Be = "%ss后自动进入";
        this.Bf = null;
        init(context);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.countDown = 3;
        this.Be = "%ss后自动进入";
        this.Bf = null;
        init(context);
    }

    public KsToastView(Context context, boolean z10) {
        super(context);
        this.countDown = 3;
        this.Be = "%ss后自动进入";
        this.Bf = null;
        init(context);
    }
}
