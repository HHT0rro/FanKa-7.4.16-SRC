package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import android.content.Context;
import com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd;
import com.alimm.tanx.core.ad.listener.model.IModel;

/* compiled from: RewardPresenter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_int extends com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do<IModel, ITanxRewardVideoAd, ITanxRewardExpressAd> {
    public tanxc_int(Context context, IModel iModel) {
        super(context, iModel);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.presenter.tanxc_do
    public ITanxRewardExpressAd tanxc_do(ITanxRewardVideoAd iTanxRewardVideoAd) {
        return new tanxc_new(iTanxRewardVideoAd);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
    
        if (r3 == 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0069, code lost:
    
        com.alimm.tanx.core.utils.LogUtils.d("video_cache", "不是激励视频广告，不需要缓存，直接回调媒体");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
    
        if (r9 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0072, code lost:
    
        r9.onRewardVideoCached(r8.get(0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void tanxc_do(final java.util.List<com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd> r8, final com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd> r9) {
        /*
            r7 = this;
            if (r8 == 0) goto L9a
            int r0 = r8.size()     // Catch: java.lang.Exception -> La5
            if (r0 != 0) goto La
            goto L9a
        La:
            r0 = 0
            java.lang.Object r1 = r8.get(r0)     // Catch: java.lang.Exception -> La5
            com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd r1 = (com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd) r1     // Catch: java.lang.Exception -> La5
            com.alimm.tanx.core.ad.bean.BidInfo r2 = r1.getBidInfo()     // Catch: java.lang.Exception -> La5
            if (r2 == 0) goto L8f
            com.alimm.tanx.core.ad.bean.BidInfo r2 = r1.getBidInfo()     // Catch: java.lang.Exception -> La5
            com.alimm.tanx.core.ad.bean.TemplateConfig r2 = r2.getTemplateConf()     // Catch: java.lang.Exception -> La5
            if (r2 == 0) goto L8f
            com.alimm.tanx.core.ad.bean.BidInfo r2 = r1.getBidInfo()     // Catch: java.lang.Exception -> La5
            com.alimm.tanx.core.ad.bean.TemplateConfig r2 = r2.getTemplateConf()     // Catch: java.lang.Exception -> La5
            java.lang.String r2 = r2.getPidStyleId()     // Catch: java.lang.Exception -> La5
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> La5
            if (r2 == 0) goto L34
            goto L8f
        L34:
            com.alimm.tanx.core.ad.bean.BidInfo r2 = r1.getBidInfo()     // Catch: java.lang.Exception -> La5
            com.alimm.tanx.core.ad.bean.TemplateConfig r2 = r2.getTemplateConf()     // Catch: java.lang.Exception -> La5
            java.lang.String r2 = r2.getPidStyleId()     // Catch: java.lang.Exception -> La5
            r3 = -1
            int r4 = r2.hashCode()     // Catch: java.lang.Exception -> La5
            r5 = 1448635041(0x56586aa1, float:5.948812E13)
            r6 = 1
            if (r4 == r5) goto L5b
            r5 = 1448635042(0x56586aa2, float:5.9488124E13)
            if (r4 == r5) goto L51
            goto L64
        L51:
            java.lang.String r4 = "100003"
            boolean r2 = r2.equals(r4)     // Catch: java.lang.Exception -> La5
            if (r2 == 0) goto L64
            r3 = 1
            goto L64
        L5b:
            java.lang.String r4 = "100002"
            boolean r2 = r2.equals(r4)     // Catch: java.lang.Exception -> La5
            if (r2 == 0) goto L64
            r3 = 0
        L64:
            if (r3 == 0) goto L7c
            if (r3 == r6) goto L69
            goto Lc5
        L69:
            java.lang.String r1 = "video_cache"
            java.lang.String r2 = "不是激励视频广告，不需要缓存，直接回调媒体"
            com.alimm.tanx.core.utils.LogUtils.d(r1, r2)     // Catch: java.lang.Exception -> La5
            if (r9 == 0) goto Lc5
            java.lang.Object r8 = r8.get(r0)     // Catch: java.lang.Exception -> La5
            com.alimm.tanx.core.ad.listener.INewTanxExpressAd r8 = (com.alimm.tanx.core.ad.listener.INewTanxExpressAd) r8     // Catch: java.lang.Exception -> La5
            r9.onRewardVideoCached(r8)     // Catch: java.lang.Exception -> La5
            goto Lc5
        L7c:
            com.alimm.tanx.core.utils.VideoCacheManager r2 = com.alimm.tanx.core.utils.VideoCacheManager.getInstance()     // Catch: java.lang.Exception -> La5
            java.lang.Object r3 = r8.get(r0)     // Catch: java.lang.Exception -> La5
            com.alimm.tanx.core.ad.ITanxAd r3 = (com.alimm.tanx.core.ad.ITanxAd) r3     // Catch: java.lang.Exception -> La5
            com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_int$1 r4 = new com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_int$1     // Catch: java.lang.Exception -> La5
            r4.<init>()     // Catch: java.lang.Exception -> La5
            r2.preload(r3, r0, r4)     // Catch: java.lang.Exception -> La5
            goto Lc5
        L8f:
            com.alimm.tanx.core.request.TanxError r8 = new com.alimm.tanx.core.request.TanxError     // Catch: java.lang.Exception -> La5
            java.lang.String r0 = "RewardPresenter返回广告getBidInfo||getTemplateConf||getPidStyleId为空"
            r8.<init>(r0)     // Catch: java.lang.Exception -> La5
            r9.onError(r8)     // Catch: java.lang.Exception -> La5
            return
        L9a:
            com.alimm.tanx.core.request.TanxError r8 = new com.alimm.tanx.core.request.TanxError     // Catch: java.lang.Exception -> La5
            java.lang.String r0 = "RewardPresenter返回广告list为空"
            r8.<init>(r0)     // Catch: java.lang.Exception -> La5
            r9.onError(r8)     // Catch: java.lang.Exception -> La5
            return
        La5:
            r8 = move-exception
            if (r9 == 0) goto Lc5
            com.alimm.tanx.core.request.TanxError r0 = new com.alimm.tanx.core.request.TanxError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "缓存try - catch异常: "
            r1.append(r2)
            java.lang.String r8 = com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(r8)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            r9.onError(r0)
        Lc5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_int.tanxc_do(java.util.List, com.alimm.tanx.core.ad.listener.ITanxAdLoader$OnRewardAdLoadListener):void");
    }
}
