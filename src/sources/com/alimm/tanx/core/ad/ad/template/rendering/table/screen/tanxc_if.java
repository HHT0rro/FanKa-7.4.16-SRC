package com.alimm.tanx.core.ad.ad.template.rendering.table.screen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd;
import com.alimm.tanx.core.ad.ad.table.screen.model.TableScreenParam;
import com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.constant.TanxAdType;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.utils.LogUtils;

/* compiled from: TanxTableScreenExpressAd.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_if extends com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if<ITanxTableScreenAd> implements ITanxTableScreenExpressAd {
    public ITanxTableScreenAd tanxc_do;
    public ITanxTableScreenExpressAd.OnTableScreenAdListener tanxc_if;
    public TableScreenParam tanxc_int;

    public tanxc_if(ITanxTableScreenAd iTanxTableScreenAd) {
        super(iTanxTableScreenAd);
        this.tanxc_do = iTanxTableScreenAd;
    }

    private void tanxc_do(Context context, Class<?> cls) {
        com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_do.put(getRequestId(), this);
        Intent intent = new Intent(context, cls);
        intent.addFlags(268435456);
        intent.putExtra("REQ_ID", getRequestId());
        context.startActivity(intent);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public String getScene() {
        return TanxAdType.TABLE_SCREEN_STRING;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    public void refresh() {
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd
    public void setOnTableScreenAdListener(ITanxTableScreenExpressAd.OnTableScreenAdListener onTableScreenAdListener) {
        this.tanxc_if = onTableScreenAdListener;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd
    public void showAd(Activity activity) {
        showAd(activity, new TableScreenParam());
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
    public TanxAdView getAdView() {
        return null;
    }

    public ITanxTableScreenExpressAd.OnTableScreenAdListener tanxc_if() {
        return this.tanxc_if;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd
    public void showAd(Activity activity, TableScreenParam tableScreenParam) {
        ITanxTableScreenAd iTanxTableScreenAd = this.tanxc_do;
        if (iTanxTableScreenAd != null && iTanxTableScreenAd.getBidInfo() != null && this.tanxc_do.getBidInfo().getTemplateConf() != null && !TextUtils.isEmpty(this.tanxc_do.getBidInfo().getTemplateConf().getPidStyleId())) {
            LogUtils.d("TanxRewardExpressAd PidStyleId:", this.tanxc_do.getBidInfo().getTemplateConf().getPidStyleId());
            LogUtils.d("TanxRewardExpressAd", "启动插屏广告");
            this.tanxc_int = tableScreenParam;
            tanxc_do(activity, TableScreenPortraitActivity.class);
            return;
        }
        TanxError tanxError = new TanxError("TanxRewardExpressAd showAd() iTanxRewardVideoAd为空|| getBidInfo||getTemplateConf||getPidStyleId为空");
        ITanxTableScreenExpressAd.OnTableScreenAdListener onTableScreenAdListener = this.tanxc_if;
        if (onTableScreenAdListener != null) {
            onTableScreenAdListener.onError(tanxError);
        }
        LogUtils.e(tanxError);
    }
}
