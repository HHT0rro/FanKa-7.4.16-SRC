package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.utils.LogUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxFeedAdWebView extends TanxFeedAdView {
    public static final String TAG = "TanxFeedAdNativeView";
    public TanxWebFrameLayout tanxWebFrameLayout;

    public TanxFeedAdWebView(Context context) {
        this(context, null);
        this.tanxWebFrameLayout = new TanxWebFrameLayout(getContext());
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView
    public void loadAdContent(String str) {
        this.flAdContentRoot.removeAllViews();
        this.flAdContentRoot.addView(this.tanxWebFrameLayout, new ViewGroup.LayoutParams(-1, -1));
        this.tanxWebFrameLayout.loadAd(this.iTanxFeedAd, this);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
        if (iTanxFeedAd != null && iTanxFeedAd.getBidInfo() != null && this.iTanxFeedAd.getBidInfo().getTemplateConf() != null) {
            this.tanxWebFrameLayout.setViewSize(this.iTanxFeedAd.getBidInfo().getTemplateConf().getWebHeight2Int() / this.iTanxFeedAd.getBidInfo().getTemplateConf().getWebWidth2Int());
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(setViewSize(this.iTanxFeedAd, i10), 1073741824), i11);
        LogUtils.d("TanxFeedAdNativeView", "onMeasure-> w:" + View.MeasureSpec.getSize(i10) + " h:" + View.MeasureSpec.getSize(i11));
    }

    public TanxFeedAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
