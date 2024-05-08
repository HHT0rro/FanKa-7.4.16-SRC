package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd;
import com.alimm.tanx.core.ad.ad.reward.model.VideoParam;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.constant.AdConstants;
import com.alimm.tanx.core.constant.TanxAdType;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.utils.LogUtils;

/* compiled from: TanxRewardExpressAd.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_new extends com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if<ITanxRewardVideoAd> implements ITanxRewardExpressAd {
    public VideoParam tanxc_do;
    public ITanxRewardVideoAd tanxc_if;
    public ITanxRewardExpressAd.OnRewardAdListener tanxc_int;

    public tanxc_new(ITanxRewardVideoAd iTanxRewardVideoAd) {
        super(iTanxRewardVideoAd);
        this.tanxc_if = iTanxRewardVideoAd;
    }

    private void tanxc_do(Context context, Class<?> cls) {
        tanxc_if.tanxc_do.put(getRequestId(), this);
        Intent intent = new Intent(context, cls);
        intent.addFlags(268435456);
        intent.putExtra("REQ_ID", getRequestId());
        context.startActivity(intent);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public String getScene() {
        return TanxAdType.REWARD_VIDEO_STRING;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    public void refresh() {
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd
    public void setOnRewardAdListener(ITanxRewardExpressAd.OnRewardAdListener onRewardAdListener) {
        this.tanxc_int = onRewardAdListener;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd
    public void showAd(Activity activity) {
        showAd(activity, new VideoParam());
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
    public TanxAdView getAdView() {
        return null;
    }

    public ITanxRewardExpressAd.OnRewardAdListener tanxc_if() {
        return this.tanxc_int;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd
    public void showAd(Activity activity, VideoParam videoParam) {
        ITanxRewardVideoAd iTanxRewardVideoAd = this.tanxc_if;
        if (iTanxRewardVideoAd != null && iTanxRewardVideoAd.getBidInfo() != null && this.tanxc_if.getBidInfo().getTemplateConf() != null && !TextUtils.isEmpty(this.tanxc_if.getBidInfo().getTemplateConf().getPidStyleId())) {
            LogUtils.d("TanxRewardExpressAd PidStyleId:", this.tanxc_if.getBidInfo().getTemplateConf().getPidStyleId());
            String pidStyleId = this.tanxc_if.getBidInfo().getTemplateConf().getPidStyleId();
            pidStyleId.hashCode();
            char c4 = 65535;
            switch (pidStyleId.hashCode()) {
                case 1448635041:
                    if (pidStyleId.equals("100002")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case 1448635042:
                    if (pidStyleId.equals("100003")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 1448635076:
                    if (pidStyleId.equals(AdConstants.PID_STYLE_ORDER_REWARD_ID)) {
                        c4 = 2;
                        break;
                    }
                    break;
                case 1448635077:
                    if (pidStyleId.equals(AdConstants.PID_STYLE_NEW_REWARD_ID)) {
                        c4 = 3;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    LogUtils.d("TanxRewardExpressAd", "启动激励视频");
                    this.tanxc_do = videoParam;
                    tanxc_do(activity, RewardVideoPortraitActivity.class);
                    return;
                case 1:
                    LogUtils.d("TanxRewardExpressAd", "启动激励浏览");
                    tanxc_do(activity, RewardPortraitActivity.class);
                    return;
                case 2:
                case 3:
                    LogUtils.d("TanxRewardExpressAd", "启动新激励浏览");
                    if (new tanxc_for(this).tanxc_do(activity)) {
                        return;
                    }
                    tanxc_do(activity, RewardPortraitActivity.class);
                    return;
                default:
                    return;
            }
        }
        TanxError tanxError = new TanxError("TanxRewardExpressAd showAd() iTanxRewardVideoAd为空|| getBidInfo||getTemplateConf||getPidStyleId为空");
        ITanxRewardExpressAd.OnRewardAdListener onRewardAdListener = this.tanxc_int;
        if (onRewardAdListener != null) {
            onRewardAdListener.onError(tanxError);
        }
        LogUtils.e(tanxError);
    }
}
