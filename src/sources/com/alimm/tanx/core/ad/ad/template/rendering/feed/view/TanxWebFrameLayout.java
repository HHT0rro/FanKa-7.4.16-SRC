package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout;
import com.alimm.tanx.core.ad.listener.ViewClickListener;
import com.alimm.tanx.core.image.util.GifConfig;
import com.alimm.tanx.core.image.util.ImageConfig;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.ut.impl.TanxFeedUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.wangmai.appsdkdex.R$drawable;
import com.wangmai.appsdkdex.R$id;
import com.wangmai.appsdkdex.R$layout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TanxWebFrameLayout extends FrameLayout implements NotConfused {
    public final String TAG;
    public WebView addView;
    public Button btnReLoadH5;
    public boolean errorCreateViewUtUpload;
    public ITanxFeedAd iTanxFeedAd;
    public volatile boolean isH5Ut;
    public ImageView ivLoading;
    public LinearLayout llWeb;
    public LinearLayout llWebError;
    public LinearLayout llWebLoading;
    public TanxFeedAdWebView parentTanxFeedAdWebView;
    public float radio;
    public RelativeLayout rlRoot;

    /* renamed from: v, reason: collision with root package name */
    public View f4177v;
    public FeedWebViewUtil webViewUtil;

    public TanxWebFrameLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexa(boolean z10) {
        if (z10) {
            TanxCoreSdk.getConfig().getImageLoader().loadGif(new GifConfig(this.ivLoading, R$drawable.loading), new ImageConfig.GifCallback() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.3
                @Override // com.alimm.tanx.core.image.util.ImageConfig.GifCallback
                public void onFailure(String str) {
                }

                @Override // com.alimm.tanx.core.image.util.ImageConfig.GifCallback
                public void onSuccess() {
                }
            });
            this.llWebLoading.setVisibility(0);
            return;
        }
        this.llWebLoading.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexb(boolean z10) {
        if (z10) {
            this.llWebError.setVisibility(0);
            errorCreateViewUt();
        } else {
            this.llWebError.setVisibility(8);
        }
    }

    private void errorCreateViewUt() {
        if (this.errorCreateViewUtUpload) {
            return;
        }
        this.errorCreateViewUtUpload = true;
        TanxFeedUt.utViewDraw(this.iTanxFeedAd, 0);
    }

    private void initClick() {
        this.btnReLoadH5.setOnClickListener(new ViewClickListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.1
            @Override // com.alimm.tanx.core.ad.listener.ViewClickListener
            public void viewClick(View view) {
                TanxWebFrameLayout.this.showErrorUi(false);
                TanxWebFrameLayout.this.loadWeb();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadWeb() {
        loading(true);
        TanxCommonUt.utWebStartLoad(this.iTanxFeedAd);
        FeedWebViewUtil feedWebViewUtil = new FeedWebViewUtil();
        this.webViewUtil = feedWebViewUtil;
        feedWebViewUtil.tanxc_do(this.llWeb, this.iTanxFeedAd, this.parentTanxFeedAdWebView, new FeedWebViewUtil.FeedWebInterface() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxWebFrameLayout.2
            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void adClose() {
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void adSkip(boolean z10) {
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void h5NotifyDrawSuccess() {
                TanxWebFrameLayout.this.showErrorUi(false);
                TanxFeedUt.utViewDraw(TanxWebFrameLayout.this.iTanxFeedAd, 1);
                TanxWebFrameLayout.this.iTanxFeedAd.onResourceLoadSuccess();
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void webDrawStatus(boolean z10) {
                if (z10) {
                    LogUtils.d("utLog", "utViewDraw");
                } else {
                    if (!TanxWebFrameLayout.this.isH5Ut) {
                        TanxBaseUt.utErrorCode(TanxWebFrameLayout.this.iTanxFeedAd, UtErrorCode.CRASH_H5_ERROR);
                        TanxWebFrameLayout.this.isH5Ut = true;
                    }
                    TanxWebFrameLayout.this.showErrorUi(true);
                }
                TanxWebFrameLayout.this.loading(false);
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void webError(int i10, String str) {
                LogUtils.e("TanxWebFrameLayout", "webError: cmd :" + i10 + " msg:" + str);
                TanxWebFrameLayout.this.showErrorUi(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loading(final boolean z10) {
        this.llWebLoading.post(new Runnable() { // from class: q.a
            @Override // java.lang.Runnable
            public final void run() {
                TanxWebFrameLayout.this.dexa(z10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorUi(final boolean z10) {
        this.llWebError.post(new Runnable() { // from class: q.b
            @Override // java.lang.Runnable
            public final void run() {
                TanxWebFrameLayout.this.dexb(z10);
            }
        });
    }

    public void loadAd(ITanxFeedAd iTanxFeedAd, TanxFeedAdWebView tanxFeedAdWebView) {
        this.iTanxFeedAd = iTanxFeedAd;
        this.parentTanxFeedAdWebView = tanxFeedAdWebView;
        this.errorCreateViewUtUpload = false;
        loadWeb();
        initClick();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i10) * this.radio), 1073741824));
    }

    public void setViewSize(float f10) {
        this.radio = f10;
    }

    public TanxWebFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TanxWebFrameLayout(Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public TanxWebFrameLayout(Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.TAG = "TanxWebFrameLayout";
        this.isH5Ut = false;
        this.errorCreateViewUtUpload = false;
        this.radio = 0.56f;
        View inflate = LayoutInflater.from(context).inflate(R$layout.tanx_layout_ad_feed_item_web, (ViewGroup) this, true);
        this.f4177v = inflate;
        this.rlRoot = (RelativeLayout) inflate.findViewById(R$id.rl_root);
        this.llWeb = (LinearLayout) this.f4177v.findViewById(R$id.ll_web);
        this.llWebError = (LinearLayout) this.f4177v.findViewById(R$id.ll_web_error);
        this.llWebLoading = (LinearLayout) this.f4177v.findViewById(R$id.ll_web_loading);
        this.ivLoading = (ImageView) this.f4177v.findViewById(R$id.iv_loading);
        this.btnReLoadH5 = (Button) this.f4177v.findViewById(R$id.btn_re_load_h5);
    }
}
