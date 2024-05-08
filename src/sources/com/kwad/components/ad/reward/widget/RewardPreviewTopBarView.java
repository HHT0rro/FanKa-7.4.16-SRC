package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class RewardPreviewTopBarView extends KSFrameLayout implements View.OnClickListener {
    private String Bh;
    private String Bi;
    private ProgressBar Bj;
    private TextView Bk;
    private ImageView Bl;
    private long Bm;
    private long Bn;
    private boolean Bo;
    private a Bp;
    private TextView sA;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void F(boolean z10);

        void G(boolean z10);
    }

    public RewardPreviewTopBarView(@NonNull Context context) {
        super(context);
        this.Bh = " 秒后即可获得奖励";
        this.Bi = "恭喜你获得奖励";
        this.Bm = -1L;
        this.Bo = false;
    }

    @MainThread
    private void e(boolean z10, boolean z11) {
        if (!this.Bo) {
            this.sA.setVisibility(8);
            this.Bk.setText(this.Bi);
            a aVar = this.Bp;
            if (aVar != null) {
                aVar.G(false);
            }
        } else {
            this.sA.setVisibility(0);
        }
        this.Bo = true;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super.init(context, attributeSet);
        FrameLayout.inflate(getContext(), R.layout.ksad_activity_preview_topbar, this);
        this.Bj = (ProgressBar) findViewById(R.id.ksad_preview_topbar_progress);
        this.sA = (TextView) findViewById(R.id.ksad_preview_topbar_reward_tips);
        this.Bk = (TextView) findViewById(R.id.ksad_preview_topbar_reward_count);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_preview_topbar_close);
        this.Bl = imageView;
        imageView.setVisibility(8);
        this.Bl.setOnClickListener(this);
    }

    public final boolean ke() {
        return this.Bo;
    }

    @MainThread
    public final void n(long j10) {
        int ceil = (int) Math.ceil(((float) j10) / 1000.0f);
        TextView textView = this.Bk;
        if (textView != null) {
            textView.setText(ceil + this.Bh);
        }
        e(j10, this.Bm);
        if (this.Bm - j10 >= this.Bn && this.Bl.getVisibility() != 0) {
            this.Bl.setVisibility(0);
        }
        if (ceil <= 0) {
            e(true, false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (!view.equals(this.Bl) || (aVar = this.Bp) == null) {
            return;
        }
        aVar.F(this.Bo);
    }

    @MainThread
    public void setCloseBtnDelayShowDuration(long j10) {
        this.Bn = j10;
        if (j10 <= 0) {
            this.Bl.setVisibility(0);
        }
    }

    @MainThread
    public void setRewardTips(String str) {
        TextView textView = this.sA;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    public void setTopBarListener(a aVar) {
        this.Bp = aVar;
    }

    @MainThread
    public void setTotalCountDuration(long j10) {
        this.Bm = j10;
        this.Bj.setMax((int) j10);
    }

    public RewardPreviewTopBarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bh = " 秒后即可获得奖励";
        this.Bi = "恭喜你获得奖励";
        this.Bm = -1L;
        this.Bo = false;
    }

    @MainThread
    private void e(long j10, long j11) {
        this.Bj.setProgress((int) (j11 - j10));
    }

    public RewardPreviewTopBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.Bh = " 秒后即可获得奖励";
        this.Bi = "恭喜你获得奖励";
        this.Bm = -1L;
        this.Bo = false;
    }
}
