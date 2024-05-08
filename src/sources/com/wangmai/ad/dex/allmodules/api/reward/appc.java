package com.wangmai.ad.dex.allmodules.api.reward;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import appa.appa.appf.appd;
import com.wangmai.ad.dex.allmodules.appf.appf;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.ad.dex.allmodules.utils.appx;
import com.wangmai.common.runnable.HasTypeRunnable;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: WMRewardViewHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appc {
    private String appb;
    private String appc;
    private appf appd;
    private int appe;
    private int appg;
    private int apph;
    private int appi;
    private long appj;
    private String appk;
    private List<String> appl;
    private String appm;
    private int appn;
    private Context appo;

    /* renamed from: appa, reason: collision with root package name */
    private String f46649appa = "WMRewardViewHelper";
    private int appf = 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMRewardViewHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa implements HasTypeRunnable<ApiBean> {
        appa() {
        }

        @Override // com.wangmai.common.runnable.HasTypeRunnable
        /* renamed from: appa, reason: merged with bridge method [inline-methods] */
        public void run(ApiBean apiBean) {
            try {
                if (apiBean == null) {
                    appd.appb(appc.this.f46649appa, "Api Reward 广告获取失败");
                    if (appc.this.appd != null) {
                        appc.this.appd.appb();
                        return;
                    }
                    return;
                }
                ApiBean.RespObj respObj = apiBean.getRespObj();
                ApiBean.WxadBean wxad = respObj.getWxad();
                if (respObj.getError_code() == 0 && wxad != null && wxad.getVideo() != null) {
                    appc.this.appc(wxad.getVideo().getV_url());
                    appc.this.appe = wxad.getVideo().getOrientation();
                    if (appc.this.appd != null) {
                        appc.this.appb(respObj.getNurl());
                        appc.this.appb(apiBean);
                        appc.this.appa(apiBean);
                        appc.this.appa(apiBean.getInvalidCridList());
                        appc.this.appd.appa(apiBean);
                        return;
                    }
                    return;
                }
                appd.appb(appc.this.f46649appa, "Api Reward 广告获取失败:" + respObj.getError_code());
                appc.this.appa(apiBean.getInvalidCridList());
                if (appc.this.appd != null) {
                    appc.this.appd.appb();
                }
            } catch (Throwable th) {
                appd.appb(appc.this.f46649appa, "Api Reward 广告获取失败：" + th.toString());
                if (appc.this.appd != null) {
                    appc.this.appd.appb();
                }
            }
        }
    }

    public appc(Context context, String str, String str2, appf appfVar) {
        this.appo = context;
        this.appb = str;
        this.appc = str2;
        this.appd = appfVar;
        appi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appc(String str) {
        if (!TextUtils.isEmpty(str)) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            if (str != null) {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("User-Agent", appx.appg(this.appo));
                    mediaMetadataRetriever.setDataSource(str, hashMap);
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
            }
            String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
            if (Integer.parseInt(extractMetadata) > Integer.parseInt(extractMetadata2)) {
                this.appf = 1;
            } else {
                this.appf = 2;
            }
            appd.appa(this.f46649appa, "Api Reward View:w=" + extractMetadata, "h=" + extractMetadata2);
            return;
        }
        appd.appb(this.f46649appa, "Api Reward 视频物料地址无效");
        appf appfVar = this.appd;
        if (appfVar != null) {
            appfVar.appb();
        }
    }

    public int appd() {
        return this.appg;
    }

    public List<String> appe() {
        return this.appl;
    }

    public int appf() {
        return this.apph;
    }

    public int appg() {
        return this.appn;
    }

    public String apph() {
        return this.appk;
    }

    void appi() {
        try {
            appd.appa(this.f46649appa, "Api Reward requestId:" + this.appc, "slotId:" + this.appb);
            com.wangmai.ad.dex.allmodules.appc.appb.appa(this.appo, this.f46649appa, this.appb, this.appc, new appa());
        } catch (Throwable th) {
            appd.appb(this.f46649appa, "Api Reward 广告加载失败:" + th.toString());
            appf appfVar = this.appd;
            if (appfVar != null) {
                appfVar.appb();
            }
        }
    }

    void appb(ApiBean apiBean) {
        try {
            appd.appa(this.f46649appa, "IPA.MW Reward DspBidPrice:" + apiBean.getAdPrice().getDspBidPrice(), "MediaBidPrice:" + apiBean.getAdPrice().getMediaBidPrice());
            appb((int) Math.round(apiBean.getAdPrice().getDspBidPrice() * 100.0d));
            appc((int) Math.round(apiBean.getAdPrice().getMediaBidPrice() * 100.0d));
            appd.appa(this.f46649appa, "IPA.MW Reward DspBidPrice:" + appd(), "MediaBidPrice:" + appf());
        } catch (Throwable th) {
            appd.appe(this.f46649appa, "IPA.MW Reward setDspAndMediaPrice exception:" + th.toString());
        }
    }

    public void appd(int i10) {
        this.appn = i10;
    }

    void appa(ApiBean apiBean) {
        try {
            if (apiBean.getOptimization() == null || apiBean.getOptimization().getAdCache() == null) {
                return;
            }
            appa(apiBean.getOptimization().getAdCache().getCacheTime() * 60 * 1000);
            appa(apiBean.getOptimization().getAdCache().getExpireTime());
            appa(apiBean.getOptimization().getAdCache().getCrid());
            appd(apiBean.getOptimization().getAdCache().getThirdSlotIdKey());
            appd.appa(this.f46649appa, "IPA.MW Reward adCacheTime:" + appa(), "expireTime:" + appb(), "ThirdSlotIdKey:" + appg());
        } catch (Throwable th) {
            appd.appe(this.f46649appa, "IPA.MW Reward setAdCache exception" + th.toString());
        }
    }

    public void appb(int i10) {
        this.appg = i10;
    }

    public long appb() {
        return this.appj;
    }

    public void appa(Context context) {
        try {
            if (this.appd != null) {
                appd.appa(this.f46649appa, "Api Reward onShow:orientation=" + this.appe, "videoOrientation=" + this.appf);
                this.appd.appa(context, this.appe, this.appf);
            }
        } catch (Throwable th) {
            appd.appb(this.f46649appa, "Api Reward show:" + th.toString());
        }
    }

    public void appb(String str) {
        this.appk = str;
    }

    public int appa() {
        return this.appi;
    }

    public void appa(int i10) {
        this.appi = i10;
    }

    public void appa(long j10) {
        this.appj = j10;
    }

    public void appa(List<String> list) {
        this.appl = list;
    }

    public void appa(String str) {
        this.appm = str;
    }

    public void appc(int i10) {
        this.apph = i10;
    }

    public String appc() {
        return this.appm;
    }
}
