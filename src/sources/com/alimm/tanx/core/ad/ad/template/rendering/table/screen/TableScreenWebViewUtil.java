package com.alimm.tanx.core.ad.ad.template.rendering.table.screen;

import android.webkit.WebView;
import android.widget.LinearLayout;
import com.alimm.tanx.core.ad.base.BaseWebViewUtil;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.bridge.Callback;
import com.alimm.tanx.core.bridge.JsHandler;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.AbstractMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TableScreenWebViewUtil extends BaseWebViewUtil {
    public tanxc_if tanxc_for;
    public TableScreenInterface tanxc_int;
    public long tanxc_do = 0;
    public final long tanxc_if = 500;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface TableScreenInterface extends BaseWebViewUtil.BaseWebInterface {
    }

    private void tanxc_new() {
        super.tanxc_do(new BaseWebViewUtil.AdInterface() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.1
            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.AdInterface
            public void adClose() {
                LogUtils.d("TableScreenWebViewUtil", "RewardVideo.notifyClose");
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.AdInterface
            public void adSkip(boolean z10) {
                LogUtils.d("TableScreenWebViewUtil", "RewardVideo.notifyAdSkip:" + z10);
            }
        });
    }

    @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil
    public boolean tanxc_do() {
        return true;
    }

    public void tanxc_do(LinearLayout linearLayout, BidInfo bidInfo, TanxAdSlot tanxAdSlot, tanxc_if tanxc_ifVar, TableScreenInterface tableScreenInterface) {
        LogUtils.d("TableScreenWebViewUtil", "init");
        super.tanxc_do(linearLayout, bidInfo, tanxAdSlot, tableScreenInterface);
        this.tanxc_for = tanxc_ifVar;
        this.tanxc_int = tableScreenInterface;
        tanxc_new();
    }

    @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil
    public void tanxc_do(WebView webView) {
        super.tanxc_do(webView);
        this.tanxc_new.register("WebAd.notifyAdExpose", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.2
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("TableScreenWebViewUtil", "WebAd.notifyAdExpose");
                    abstractMap.get("area");
                    if (TableScreenWebViewUtil.this.tanxc_for != null && TableScreenWebViewUtil.this.tanxc_for.tanxc_do != null) {
                        TableScreenWebViewUtil.this.tanxc_for.tanxc_do.onResourceLoadSuccess();
                    }
                    callback.call(true, null);
                } catch (Exception e2) {
                    LogUtils.e("TableScreenWebViewUtil", e2);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyAdClick", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.3
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("TableScreenWebViewUtil", "WebAd.notifyAdClick");
                    long currentTimeMillis = System.currentTimeMillis();
                    TableScreenWebViewUtil tableScreenWebViewUtil = TableScreenWebViewUtil.this;
                    if (currentTimeMillis - tableScreenWebViewUtil.tanxc_do >= 500) {
                        tableScreenWebViewUtil.tanxc_do = System.currentTimeMillis();
                        abstractMap.get("area");
                        String str = (String) abstractMap.get("clickThroughUrl");
                        String str2 = (String) abstractMap.get("deepLinkUrl");
                        if (TableScreenWebViewUtil.this.tanxc_for != null && TableScreenWebViewUtil.this.tanxc_for.tanxc_do != null) {
                            TableScreenWebViewUtil.this.tanxc_for.tanxc_do.click(str, str2);
                            if (TableScreenWebViewUtil.this.tanxc_for.tanxc_if() != null) {
                                TableScreenWebViewUtil.this.tanxc_for.tanxc_if().onAdClicked(null, TableScreenWebViewUtil.this.tanxc_for.tanxc_do);
                            }
                        }
                        callback.call(true, null);
                        return;
                    }
                    LogUtils.d("TableScreenWebViewUtil", "mClickedOnce = true");
                } catch (Exception e2) {
                    LogUtils.e("TableScreenWebViewUtil", e2);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyError", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.4
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d("TableScreenWebViewUtil", "WebAd.notifyError");
                Integer num = (Integer) abstractMap.get("cmd");
                TableScreenWebViewUtil.this.tanxc_int.webError(num == null ? -1 : num.intValue(), (String) abstractMap.get("msg"));
                callback.call(true, null);
            }
        });
    }
}
