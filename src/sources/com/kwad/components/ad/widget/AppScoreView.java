package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AppScoreView extends LinearLayout {
    private ImageView HS;
    private ImageView HT;

    public AppScoreView(Context context) {
        this(context, null);
    }

    private void initView() {
        LinearLayout.inflate(getContext(), R.layout.ksad_app_score, this);
        this.HS = (ImageView) findViewById(R.id.ksad_score_fourth);
        this.HT = (ImageView) findViewById(R.id.ksad_score_fifth);
    }

    public void setScore(float f10) {
        double d10 = f10;
        if (d10 > 4.5d) {
            ImageView imageView = this.HS;
            int i10 = R.drawable.ksad_star_checked;
            imageView.setImageResource(i10);
            this.HT.setImageResource(i10);
            return;
        }
        if (d10 > 4.0d) {
            this.HS.setImageResource(R.drawable.ksad_star_checked);
            this.HT.setImageResource(R.drawable.ksad_star_half);
            return;
        }
        if (d10 > 3.5d) {
            this.HS.setImageResource(R.drawable.ksad_star_checked);
            this.HT.setImageResource(R.drawable.ksad_star_unchecked);
        } else if (d10 > 3.0d) {
            this.HS.setImageResource(R.drawable.ksad_star_half);
            this.HT.setImageResource(R.drawable.ksad_star_unchecked);
        } else if (d10 == 3.0d) {
            ImageView imageView2 = this.HS;
            int i11 = R.drawable.ksad_star_unchecked;
            imageView2.setImageResource(i11);
            this.HT.setImageResource(i11);
        }
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppScoreView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        initView();
    }
}
