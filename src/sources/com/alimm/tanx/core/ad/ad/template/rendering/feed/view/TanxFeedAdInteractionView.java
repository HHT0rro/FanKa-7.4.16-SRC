package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TouchTraceView;
import com.alimm.tanx.core.image.ImageManager;
import com.alimm.tanx.core.image.util.GifConfig;
import com.alimm.tanx.core.image.util.ImageConfig;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.DimenUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.wangmai.appsdkdex.R$id;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxFeedAdInteractionView extends TanxFeedAdNativeView {
    public static final String TAG = "TanxFeedAdInteractionView";
    public final String ALL_SLIDE_DISTANCE_KEY;
    public final String DIRECTION_SLIDE_DISTANCE_KEY;
    public final String FEED_INTERACTION_GIF_URL;
    public final String SLIDE_DIRECTION_KEY;
    public final int defaultAllSlideDistance;
    public final int defaultDirectionSlideDistance;
    public final int defaultSlideDirection;
    public final TanxFrameLayout flGif;
    public final ImageView ivGif;
    public float radio;

    public TanxFeedAdInteractionView(Context context) {
        this(context, null);
    }

    private boolean isInterAction() {
        ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
        if (iTanxFeedAd != null && iTanxFeedAd.getBidInfo() != null) {
            LogUtils.d(TAG, "交互type为3,为信息流滑动");
            return this.iTanxFeedAd.getBidInfo().getInteractType2FeedSlide();
        }
        LogUtils.d(TAG, "交互type不为3");
        return false;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView, com.alimm.tanx.core.ad.view.TanxAdView
    public boolean allowSettingViewSize() {
        return true;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView
    public void loadAdContent(String str) {
        LogUtils.d(TAG, str);
        super.loadAdContent(str);
        if (!isInterAction() || ImageManager.getLoader() == null) {
            return;
        }
        ImageManager.getLoader().loadGif(new GifConfig(this.ivGif, OrangeManager.getInstance().getFeedInteractionGifUrlParam("feedInteractionGifUrl")), new ImageConfig.GifCallback() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView.2
            @Override // com.alimm.tanx.core.image.util.ImageConfig.GifCallback
            public void onFailure(String str2) {
                TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), TanxFeedAdInteractionView.TAG, str2, "main");
                LogUtils.e(TanxFeedAdInteractionView.TAG, str2);
            }

            @Override // com.alimm.tanx.core.image.util.ImageConfig.GifCallback
            public void onSuccess() {
                LogUtils.d(TanxFeedAdInteractionView.TAG, "加载gif成功");
            }
        });
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        ITanxFeedAd iTanxFeedAd = this.iTanxFeedAd;
        if (iTanxFeedAd != null && iTanxFeedAd.getBidInfo() != null) {
            float templateHeight2Int = this.iTanxFeedAd.getBidInfo().getTemplateHeight2Int() / this.iTanxFeedAd.getBidInfo().getTemplateWidth2Int();
            this.radio = templateHeight2Int;
            this.flGif.setViewSize(templateHeight2Int);
        }
        super.onMeasure(i10, i11);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdView
    public void renderAd() {
        super.renderAd();
        if (isInterAction()) {
            this.ivGif.setVisibility(0);
            TouchTraceView touchTraceView = new TouchTraceView(getContext(), null, new TouchTraceView.InteractionCallBack() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdInteractionView.1
                @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TouchTraceView.InteractionCallBack
                public void onInteractionEnd(int i10, int i11, int i12) {
                    int i13;
                    int i14;
                    int i15;
                    ITanxFeedAd iTanxFeedAd = TanxFeedAdInteractionView.this.iTanxFeedAd;
                    if (iTanxFeedAd == null || iTanxFeedAd.getBidInfo() == null || TanxFeedAdInteractionView.this.iTanxFeedAd.getBidInfo().getTemplateConf() == null) {
                        i13 = 1;
                        i14 = 55;
                        i15 = 120;
                    } else {
                        i13 = TanxFeedAdInteractionView.this.iTanxFeedAd.getBidInfo().getTemplateConf().getSlideType2Int();
                        i14 = TanxFeedAdInteractionView.this.iTanxFeedAd.getBidInfo().getTemplateConf().getSlideDistance2Int();
                        i15 = TanxFeedAdInteractionView.this.iTanxFeedAd.getBidInfo().getTemplateConf().getAllSlideDistance2Int();
                    }
                    if (i13 == 2) {
                        if (Math.abs(i11) >= DimenUtil.dp2px(TanxFeedAdInteractionView.this.getContext(), i14) || i12 >= DimenUtil.dp2px(TanxFeedAdInteractionView.this.getContext(), i15)) {
                            TanxFeedAdInteractionView tanxFeedAdInteractionView = TanxFeedAdInteractionView.this;
                            tanxFeedAdInteractionView.iTanxFeedAd.click(tanxFeedAdInteractionView);
                            return;
                        }
                        return;
                    }
                    if (Math.abs(i10) >= DimenUtil.dp2px(TanxFeedAdInteractionView.this.getContext(), i14) || i12 >= DimenUtil.dp2px(TanxFeedAdInteractionView.this.getContext(), i15)) {
                        TanxFeedAdInteractionView tanxFeedAdInteractionView2 = TanxFeedAdInteractionView.this;
                        tanxFeedAdInteractionView2.iTanxFeedAd.click(tanxFeedAdInteractionView2);
                    }
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TouchTraceView.InteractionCallBack
                public void onInteractionStart() {
                    LogUtils.d("", "");
                }
            });
            touchTraceView.tanxc_do(this.radio);
            this.flAdContentRoot.addView(touchTraceView);
            return;
        }
        this.flGif.setVisibility(8);
    }

    public TanxFeedAdInteractionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DIRECTION_SLIDE_DISTANCE_KEY = "directionSlideDistance";
        this.ALL_SLIDE_DISTANCE_KEY = "allSlideDistance";
        this.SLIDE_DIRECTION_KEY = "slideDirection";
        this.FEED_INTERACTION_GIF_URL = "feedInteractionGifUrl";
        this.defaultDirectionSlideDistance = 55;
        this.defaultAllSlideDistance = 120;
        this.defaultSlideDirection = 1;
        this.radio = 0.56f;
        this.ivGif = (ImageView) this.f4176v.findViewById(R$id.iv_gif);
        TanxFrameLayout tanxFrameLayout = (TanxFrameLayout) this.f4176v.findViewById(R$id.fl_gif);
        this.flGif = tanxFrameLayout;
        tanxFrameLayout.setVisibility(0);
    }
}
