package com.alimm.tanx.core.ad.ad.splash;

import android.webkit.WebView;
import android.widget.LinearLayout;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.TanxSplashAdView;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new;
import com.alimm.tanx.core.ad.base.BaseWebViewUtil;
import com.alimm.tanx.core.bridge.Callback;
import com.alimm.tanx.core.bridge.JsHandler;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.AbstractMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SplashWebViewUtil extends BaseWebViewUtil {
    public ITanxSplashExpressAd tanxc_do;
    public TanxSplashAdView tanxc_if;
    public SplashWebInterface tanxc_try;
    public long tanxc_for = 0;
    public final long tanxc_int = 500;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface SplashWebInterface extends BaseWebViewUtil.BaseWebInterface {
    }

    private void tanxc_new() {
        super.tanxc_do(new BaseWebViewUtil.AdInterface() { // from class: com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.1
            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.AdInterface
            public void adClose() {
                LogUtils.d("SplashWebViewUtil", "RewardVideo.notifyClose");
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.AdInterface
            public void adSkip(boolean z10) {
                LogUtils.d("SplashWebViewUtil", "RewardVideo.notifyAdSkip:" + z10);
            }
        });
    }

    @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil
    public boolean tanxc_do() {
        return true;
    }

    public void tanxc_do(LinearLayout linearLayout, ITanxSplashExpressAd iTanxSplashExpressAd, TanxSplashAdView tanxSplashAdView, SplashWebInterface splashWebInterface) {
        LogUtils.d("SplashWebViewUtil", "init");
        if (iTanxSplashExpressAd == null) {
            return;
        }
        this.tanxc_if = tanxSplashAdView;
        this.tanxc_do = iTanxSplashExpressAd;
        super.tanxc_do(linearLayout, iTanxSplashExpressAd.getBidInfo(), iTanxSplashExpressAd.getAdSlot(), splashWebInterface);
        this.tanxc_try = splashWebInterface;
        tanxc_new();
    }

    @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil
    public void tanxc_do(WebView webView) {
        super.tanxc_do(webView);
        this.tanxc_new.register("WebAd.notifyAdExpose", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.2
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("SplashWebViewUtil", "WebAd.notifyAdExpose");
                    abstractMap.get("area");
                    ITanxSplashExpressAd iTanxSplashExpressAd = SplashWebViewUtil.this.tanxc_do;
                    if (iTanxSplashExpressAd != null) {
                        iTanxSplashExpressAd.onResourceLoadSuccess();
                    }
                    callback.call(true, null);
                } catch (Exception e2) {
                    LogUtils.e("SplashWebViewUtil", e2);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyAdClick", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.3
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("SplashWebViewUtil", "WebAd.notifyAdClick");
                    long currentTimeMillis = System.currentTimeMillis();
                    SplashWebViewUtil splashWebViewUtil = SplashWebViewUtil.this;
                    if (currentTimeMillis - splashWebViewUtil.tanxc_for >= 500) {
                        splashWebViewUtil.tanxc_for = System.currentTimeMillis();
                        abstractMap.get("area");
                        String str = (String) abstractMap.get("clickThroughUrl");
                        String str2 = (String) abstractMap.get("deepLinkUrl");
                        ITanxSplashExpressAd iTanxSplashExpressAd = SplashWebViewUtil.this.tanxc_do;
                        if (iTanxSplashExpressAd != null && (iTanxSplashExpressAd instanceof tanxc_new)) {
                            ((tanxc_new) iTanxSplashExpressAd).tanxc_do(str, str2, false);
                            if (SplashWebViewUtil.this.tanxc_do.getOnSplashAdListener() != null) {
                                SplashWebViewUtil.this.tanxc_do.getOnSplashAdListener().onAdClicked();
                            }
                        }
                        callback.call(true, null);
                        return;
                    }
                    LogUtils.d("SplashWebViewUtil", "mClickedOnce = true");
                } catch (Exception e2) {
                    LogUtils.e("SplashWebViewUtil", e2);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyError", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.4
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d("SplashWebViewUtil", "WebAd.notifyError");
                Integer num = (Integer) abstractMap.get("cmd");
                SplashWebViewUtil.this.tanxc_try.webError(num == null ? -1 : num.intValue(), (String) abstractMap.get("msg"));
                callback.call(true, null);
            }
        });
    }
}
