package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.ad.base.BaseWebViewUtil;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.bridge.Callback;
import com.alimm.tanx.core.bridge.JsHandler;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.impl.TanxRewardUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.huawei.appgallery.agd.core.impl.report.MaintKey;
import java.util.AbstractMap;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RewardWebViewUtil extends BaseWebViewUtil {
    public tanxc_new tanxc_do;
    public RewardInterface tanxc_if;
    public String tanxc_for = "";
    public String tanxc_int = "";
    public long tanxc_try = -1;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface RewardInterface extends BaseWebViewUtil.BaseWebInterface {
        long getCurrentTime();

        String getPlayState();

        long getTotalTime();

        void setPlayer(Boolean bool, Boolean bool2);

        void webNotifyCountDown(int i10, int i11);
    }

    private void tanxc_new() {
        super.tanxc_do(new BaseWebViewUtil.AdInterface() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.1
            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.AdInterface
            public void adClose() {
                LogUtils.d("RewardWebViewUtil", "RewardVideo.notifyClose");
                RewardWebViewUtil.this.tanxc_if(1);
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.AdInterface
            public void adSkip(boolean z10) {
                LogUtils.d("RewardWebViewUtil", "RewardVideo.notifyAdSkip:" + z10);
                RewardWebViewUtil.this.tanxc_if(1);
            }
        });
    }

    @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil
    public boolean tanxc_do() {
        return true;
    }

    public void tanxc_do(LinearLayout linearLayout, BidInfo bidInfo, TanxAdSlot tanxAdSlot, tanxc_new tanxc_newVar, RewardInterface rewardInterface) {
        LogUtils.d("RewardWebViewUtil", "init");
        super.tanxc_do(linearLayout, bidInfo, tanxAdSlot, rewardInterface);
        this.tanxc_do = tanxc_newVar;
        this.tanxc_if = rewardInterface;
        tanxc_new();
    }

    public void tanxc_if(int i10) {
        if (this.tanxc_try <= 0) {
            return;
        }
        LogUtils.d("utLog", "utPlayEndClickTime");
        TanxRewardUt.utPlayEndClickTime(this.tanxc_do, System.currentTimeMillis() - this.tanxc_try, i10);
        this.tanxc_try = -1L;
    }

    @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil
    public void tanxc_do(WebView webView) {
        super.tanxc_do(webView);
        this.tanxc_new.register("WebAd.getPlayerInfo", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.2
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d("RewardWebViewUtil", "WebAd.getPlayerInfo  - currentTime:" + RewardWebViewUtil.this.tanxc_if.getCurrentTime() + "  totalTime:" + RewardWebViewUtil.this.tanxc_if.getTotalTime() + "  playState:" + RewardWebViewUtil.this.tanxc_if.getPlayState());
                HashMap hashMap = new HashMap();
                hashMap.put("currentTime", Long.valueOf(RewardWebViewUtil.this.tanxc_if.getCurrentTime()));
                hashMap.put(MaintKey.TOTAL_TIME, Long.valueOf(RewardWebViewUtil.this.tanxc_if.getTotalTime()));
                hashMap.put("audioState", RewardWebViewUtil.this.tanxc_do.tanxc_do.mute ? "muted" : "vocal");
                hashMap.put("playState", RewardWebViewUtil.this.tanxc_if.getPlayState());
                LogUtils.d("RewardWebViewUtil", JSON.toJSONString(hashMap));
                callback.call(true, hashMap);
            }
        });
        this.tanxc_new.register("WebAd.notifyAdExpose", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.3
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("RewardWebViewUtil", "WebAd.notifyAdExpose");
                    abstractMap.get("area");
                    if (RewardWebViewUtil.this.tanxc_do != null && RewardWebViewUtil.this.tanxc_do.tanxc_if != null) {
                        RewardWebViewUtil.this.tanxc_do.tanxc_if.onResourceLoadSuccess();
                    }
                    callback.call(true, null);
                } catch (Exception e2) {
                    LogUtils.e("RewardWebViewUtil", e2);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyAdClick", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.4
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    RewardWebViewUtil.this.tanxc_if(0);
                    LogUtils.d("RewardWebViewUtil", "WebAd.notifyAdClick");
                    abstractMap.get("area");
                    String str = (String) abstractMap.get("clickThroughUrl");
                    String str2 = (String) abstractMap.get("deepLinkUrl");
                    if (RewardWebViewUtil.this.tanxc_do != null && RewardWebViewUtil.this.tanxc_do.tanxc_if != null) {
                        RewardWebViewUtil.this.tanxc_do.tanxc_if.click(str, str2);
                        if (RewardWebViewUtil.this.tanxc_do.tanxc_if() != null) {
                            RewardWebViewUtil.this.tanxc_do.tanxc_if().onAdClicked(null, RewardWebViewUtil.this.tanxc_do.tanxc_if);
                        }
                    }
                    callback.call(true, null);
                } catch (Exception e2) {
                    LogUtils.e("RewardWebViewUtil", e2);
                }
            }
        });
        this.tanxc_new.register("WebAd.setPlayer", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.5
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("RewardWebViewUtil", "WebAd.setPlayer");
                    RewardWebViewUtil.this.tanxc_if.setPlayer((Boolean) abstractMap.get("muted"), (Boolean) abstractMap.get("pausing"));
                    callback.call(true, null);
                } catch (Exception e2) {
                    LogUtils.e("RewardWebViewUtil", e2);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyCountDown", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.6
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d("RewardWebViewUtil", "WebAd.notifyCountDown");
                Integer num = (Integer) abstractMap.get(MaintKey.TOTAL_TIME);
                Integer num2 = (Integer) abstractMap.get("currentTime");
                if (num == null) {
                    num = 0;
                }
                if (num2 == null) {
                    num2 = 0;
                }
                RewardWebViewUtil.this.tanxc_if.webNotifyCountDown(num.intValue(), num2.intValue());
                callback.call(true, null);
            }
        });
        this.tanxc_new.register("WebAd.notifyError", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.7
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d("RewardWebViewUtil", "WebAd.notifyError");
                Integer num = (Integer) abstractMap.get("cmd");
                RewardWebViewUtil.this.tanxc_if.webError(num == null ? -1 : num.intValue(), (String) abstractMap.get("msg"));
                callback.call(true, null);
            }
        });
    }

    public void tanxc_do(String str) {
        LogUtils.d("RewardWebViewUtil", "playStateChange - nowPlayStateStr：" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (this.tanxc_int.equals(str)) {
            return;
        }
        hashMap.put("new", str);
        hashMap.put("old", this.tanxc_int);
        this.tanxc_new.postEvent("WebAd.playStateChange", hashMap);
        this.tanxc_int = str;
        if (str == null || !str.equals("end")) {
            return;
        }
        this.tanxc_try = System.currentTimeMillis();
    }

    public void tanxc_do(int i10) {
        LogUtils.d("RewardWebViewUtil", "audioStateChange - volume：" + i10);
        HashMap hashMap = new HashMap();
        String str = i10 <= 0 ? "muted" : "vocal";
        if (this.tanxc_for.equals(str)) {
            return;
        }
        hashMap.put("new", str);
        hashMap.put("old", this.tanxc_for);
        this.tanxc_new.postEvent("WebAd.audioStateChange", hashMap);
        this.tanxc_for = str;
    }
}
