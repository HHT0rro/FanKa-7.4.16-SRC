package com.alimm.tanx.core.ad.ad.feed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.utils.DimenUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.ViewSize;
import com.alimm.tanx.core.view.player.ui.TanxPlayerView;
import com.wangmai.appsdkdex.R$mipmap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxVideoView extends TanxPlayerView {
    public static final String TAG = "TanxVideoView";
    public ITanxAd iTanxAd;
    public ImageView ivPlayer;
    public View.OnClickListener onClickListener;

    public TanxVideoView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.ivPlayer = new ImageView(getContext());
        int dp2px = DimenUtil.dp2px(getContext(), 30.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp2px, dp2px);
        layoutParams.gravity = 17;
        this.ivPlayer.setImageResource(R$mipmap.pause);
        this.ivPlayer.setLayoutParams(layoutParams);
        View.OnClickListener onClickListener = this.onClickListener;
        if (onClickListener != null) {
            this.ivPlayer.setOnClickListener(onClickListener);
        }
        addView(this.ivPlayer, layoutParams);
    }

    @Override // com.alimm.tanx.core.ad.view.TanxAdView
    public boolean allowSettingViewSize() {
        return true;
    }

    @Override // com.alimm.tanx.core.ad.view.TanxAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        try {
            int size = View.MeasureSpec.getSize(i10);
            int parseInt = (int) (size / (Integer.parseInt(this.iTanxAd.getBidInfo().getCreativeItem().getVideoWidth()) / Integer.parseInt(this.iTanxAd.getBidInfo().getCreativeItem().getVideoHeight())));
            ViewSize.setViewSize(this, size, parseInt);
            i10 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            i11 = View.MeasureSpec.makeMeasureSpec(parseInt, 1073741824);
        } catch (Exception e2) {
            LogUtils.e(e2);
        }
        super.onMeasure(i10, i11);
    }

    public void setLoadingType() {
        post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.feed.TanxVideoView.2
            @Override // java.lang.Runnable
            public void run() {
                TanxVideoView.this.ivPlayer.setVisibility(0);
                TanxVideoView.this.ivPlayer.setImageResource(R$mipmap.londing);
            }
        });
    }

    public void setPauseType() {
        post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.feed.TanxVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                TanxVideoView.this.ivPlayer.setVisibility(0);
                TanxVideoView.this.ivPlayer.setImageResource(R$mipmap.pause);
            }
        });
    }

    public void setPlayClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.ivPlayer;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
        this.onClickListener = onClickListener;
    }

    public void setPlayType() {
        post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.feed.TanxVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                TanxVideoView.this.ivPlayer.setVisibility(8);
            }
        });
    }

    public void setTanxAd(ITanxAd iTanxAd) {
        this.iTanxAd = iTanxAd;
    }

    public TanxVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TanxVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
