package com.alimm.tanx.core.ad.interaction;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.browser.TanxBrowserActivity;
import com.alimm.tanx.core.ad.interaction.tanxc_do;
import com.alimm.tanx.core.ad.interaction.tanxc_for;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.TanxTestLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AdClickHandler implements NotConfused {
    public static final String TAG = "AdClickHandler";

    private void openWebActivity(Context context, String str, AdClickInfo adClickInfo) {
        Intent intent = new Intent();
        intent.setClass(context, TanxBrowserActivity.class);
        intent.putExtra("url", str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public boolean handleClickAndUt(Context context, AdClickInfo adClickInfo, boolean z10) {
        return handleClickAndUt(context, adClickInfo, false, z10);
    }

    public boolean handleClickAndUt(Context context, AdClickInfo adClickInfo, boolean z10, boolean z11) {
        tanxc_for tanxc_forVar;
        String str;
        LogUtils.d("DeepLinkManager", "handleClickAndUt..");
        BidInfo bidInfo = adClickInfo.getBidInfo();
        String pid = adClickInfo.getTanxAdSlot() != null ? adClickInfo.getTanxAdSlot().getPid() : "";
        String reqId = adClickInfo.getTanxAdSlot() != null ? adClickInfo.getTanxAdSlot().getReqId() : "";
        String deepLinkUrl = (TextUtils.isEmpty(adClickInfo.getClickThroughUrl()) && TextUtils.isEmpty(adClickInfo.getDeepLinkUrl())) ? bidInfo.getDeepLinkUrl() : adClickInfo.getDeepLinkUrl();
        LogUtils.d("DeepLinkManager", "deepLinkUrl: " + deepLinkUrl);
        tanxc_forVar = tanxc_for.tanxc_do.tanxc_do;
        boolean tanxc_do = tanxc_forVar.tanxc_do(context, deepLinkUrl, bidInfo, reqId, pid);
        LogUtils.d("DeepLinkManager", "handle: " + tanxc_do);
        String clickThroughUrl = (TextUtils.isEmpty(adClickInfo.getClickThroughUrl()) && TextUtils.isEmpty(adClickInfo.getDeepLinkUrl())) ? bidInfo.getClickThroughUrl() : adClickInfo.getClickThroughUrl();
        if (tanxc_do || z10) {
            str = deepLinkUrl;
        } else {
            LogUtils.d("DeepLinkManager", "ClickThroughUrl: " + clickThroughUrl);
            if (!TextUtils.isEmpty(clickThroughUrl)) {
                openWebActivity(context, clickThroughUrl, adClickInfo);
                tanxc_do.C0090tanxc_do.tanxc_do.tanxc_do(clickThroughUrl, bidInfo);
            }
            str = clickThroughUrl;
        }
        if (z11) {
            TanxBaseUt.utNavigate(adClickInfo, tanxc_do ? "deepLink" : "throughUrl", str, deepLinkUrl, clickThroughUrl);
        }
        TanxBaseUt.utClick(adClickInfo, tanxc_do, str, deepLinkUrl, clickThroughUrl);
        LogUtils.d("TanxSDK-DoClick", "TanxSDK落地页唤端跳转 reqId：" + adClickInfo.getReqId());
        TanxTestLog.sendLog("点击url", str);
        return tanxc_do;
    }
}
