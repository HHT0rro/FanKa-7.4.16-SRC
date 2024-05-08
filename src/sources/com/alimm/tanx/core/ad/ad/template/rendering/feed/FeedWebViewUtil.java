package com.alimm.tanx.core.ad.ad.template.rendering.feed;

import android.webkit.WebView;
import android.widget.LinearLayout;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TanxFeedAdWebView;
import com.alimm.tanx.core.ad.base.BaseWebViewUtil;
import com.alimm.tanx.core.bridge.Callback;
import com.alimm.tanx.core.bridge.JsHandler;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.AbstractMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FeedWebViewUtil extends BaseWebViewUtil {
    public ITanxFeedAd tanxc_do;
    public TanxFeedAdWebView tanxc_if;
    public FeedWebInterface tanxc_try;
    public long tanxc_for = 0;
    public final long tanxc_int = 500;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface FeedWebInterface extends BaseWebViewUtil.BaseWebInterface {
    }

    private void tanxc_new() {
        super.tanxc_do(new BaseWebViewUtil.AdInterface() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil.1
            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.AdInterface
            public void adClose() {
                LogUtils.d("FeedWebViewUtil", "RewardVideo.notifyClose");
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.AdInterface
            public void adSkip(boolean z10) {
                LogUtils.d("FeedWebViewUtil", "RewardVideo.notifyAdSkip:" + z10);
            }
        });
    }

    @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil
    public boolean tanxc_do() {
        return false;
    }

    public void tanxc_do(LinearLayout linearLayout, ITanxFeedAd iTanxFeedAd, TanxFeedAdWebView tanxFeedAdWebView, FeedWebInterface feedWebInterface) {
        LogUtils.d("FeedWebViewUtil", "init");
        if (iTanxFeedAd == null) {
            return;
        }
        this.tanxc_if = tanxFeedAdWebView;
        this.tanxc_do = iTanxFeedAd;
        super.tanxc_do(linearLayout, iTanxFeedAd.getBidInfo(), iTanxFeedAd.getAdSlot(), feedWebInterface);
        this.tanxc_try = feedWebInterface;
        tanxc_new();
    }

    @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil
    public void tanxc_do(WebView webView) {
        super.tanxc_do(webView);
        this.tanxc_new.register("WebAd.notifyAdExpose", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil.2
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("FeedWebViewUtil", "WebAd.notifyAdExpose");
                    abstractMap.get("area");
                    ITanxFeedAd iTanxFeedAd = FeedWebViewUtil.this.tanxc_do;
                    if (iTanxFeedAd != null) {
                        iTanxFeedAd.onResourceLoadSuccess();
                    }
                    callback.call(true, null);
                } catch (Exception e2) {
                    LogUtils.e("FeedWebViewUtil", e2);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyAdClick", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil.3
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("FeedWebViewUtil", "WebAd.notifyAdClick");
                    long currentTimeMillis = System.currentTimeMillis();
                    FeedWebViewUtil feedWebViewUtil = FeedWebViewUtil.this;
                    if (currentTimeMillis - feedWebViewUtil.tanxc_for >= 500) {
                        feedWebViewUtil.tanxc_for = System.currentTimeMillis();
                        abstractMap.get("area");
                        abstractMap.get("clickThroughUrl");
                        abstractMap.get("deepLinkUrl");
                        FeedWebViewUtil feedWebViewUtil2 = FeedWebViewUtil.this;
                        ITanxFeedAd iTanxFeedAd = feedWebViewUtil2.tanxc_do;
                        if (iTanxFeedAd != null) {
                            iTanxFeedAd.click(feedWebViewUtil2.tanxc_if);
                        }
                        callback.call(true, null);
                        return;
                    }
                    LogUtils.d("FeedWebViewUtil", "mClickedOnce = true");
                } catch (Exception e2) {
                    LogUtils.e("FeedWebViewUtil", e2);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyError", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil.4
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d("FeedWebViewUtil", "WebAd.notifyError");
                Integer num = (Integer) abstractMap.get("cmd");
                FeedWebViewUtil.this.tanxc_try.webError(num == null ? -1 : num.intValue(), (String) abstractMap.get("msg"));
                callback.call(true, null);
            }
        });
    }
}
