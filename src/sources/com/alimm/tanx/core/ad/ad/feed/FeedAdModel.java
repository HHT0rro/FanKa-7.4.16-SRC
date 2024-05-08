package com.alimm.tanx.core.ad.ad.feed;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.bean.AdInfo;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.ad.model.BaseModel;
import com.alimm.tanx.core.constant.TanxAdType;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.ut.impl.TanxInterfaceUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.VideoCacheManager;
import com.alimm.tanx.core.view.player.cache.videocache.PreloadListener;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FeedAdModel extends BaseModel {
    private void preload(List<tanxc_do> list, boolean z10) {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                arrayList.add(list.get(i10));
            }
            if (list.size() > 0) {
                for (int i11 = 0; i11 < list.size(); i11++) {
                    final tanxc_do tanxc_doVar = list.get(i11);
                    VideoCacheManager.getInstance().preload(tanxc_doVar, z10, new PreloadListener() { // from class: com.alimm.tanx.core.ad.ad.feed.FeedAdModel.2
                        @Override // com.alimm.tanx.core.view.player.cache.videocache.PreloadListener
                        public void onCached(String str) {
                            TanxCommonUt.cacheCheck(tanxc_doVar, str, 0, null);
                        }

                        @Override // com.alimm.tanx.core.view.player.cache.videocache.PreloadListener
                        public void onError(String str, Exception exc) {
                            TanxCommonUt.cacheCheck(tanxc_doVar, str, 1, exc);
                        }

                        @Override // com.alimm.tanx.core.view.player.cache.videocache.PreloadListener
                        public void onStartCached(ITanxAd iTanxAd) {
                        }
                    });
                }
            }
        } catch (Exception e2) {
            LogUtils.e(e2);
        }
    }

    private BidInfo updateData(BidInfo bidInfo) {
        try {
            if (bidInfo.getTemplateConf() != null && !TextUtils.isEmpty(bidInfo.getTemplateConf().getRenderUrl()) && !TextUtils.isEmpty(bidInfo.getSubMaterials())) {
                String renderUrl = bidInfo.getTemplateConf().getRenderUrl();
                StringBuilder sb2 = new StringBuilder(SymbolValues.QUESTION_EN_SYMBOL);
                Map map = (Map) JSON.parse(bidInfo.getSubMaterials());
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        String str = (String) entry.getKey();
                        String str2 = (String) entry.getValue();
                        sb2.append(str);
                        sb2.append("=");
                        sb2.append(str2);
                        sb2.append("&");
                    }
                    if (sb2.toString().length() >= 2) {
                        String sb3 = sb2.toString();
                        if (sb3.substring(sb3.length() - 1, sb3.length()).equals("&")) {
                            sb3 = sb3.substring(0, sb3.length() - 1);
                        }
                        bidInfo.getTemplateConf().setRenderUrl(renderUrl + sb3);
                    }
                }
            }
        } catch (Exception e2) {
            LogUtils.e(e2);
        }
        return bidInfo;
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public String getScene() {
        return TanxAdType.FEED_STRING;
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void onSuccess(AdInfo adInfo) {
        if (this.requestListener == null) {
            return;
        }
        if (adInfo != null && adInfo.getSeatList() != null && adInfo.getSeatList().size() > 0) {
            boolean z10 = false;
            if (adInfo.getSeatList().get(0) != null && adInfo.getSeatList().get(0).getBidList() != null && adInfo.getSeatList().get(0).getBidList().size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < adInfo.getSeatList().size(); i10++) {
                    List<BidInfo> bidList = adInfo.getSeatList().get(i10).getBidList();
                    if (bidList != null && bidList.size() > 0) {
                        Iterator<BidInfo> iterator2 = bidList.iterator2();
                        while (iterator2.hasNext()) {
                            arrayList.add(new tanxc_do(this.adSlot, updateData(iterator2.next()), adInfo.getRequestId(), getScene()));
                        }
                    }
                }
                TanxAdSlot tanxAdSlot = this.adSlot;
                if (tanxAdSlot != null && tanxAdSlot.isCacheUnderWifi()) {
                    z10 = true;
                }
                preload(arrayList, z10);
                this.requestListener.onSuccess(arrayList);
                return;
            }
        }
        this.requestListener.onError(new TanxError(adInfo != null ? adInfo.getRequestId() : "", TanxError.ERROR_ADINFO_ADCOUNT_NULL));
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel, com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        sendRequest(tanxAdSlot, iTanxRequestListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void timerCancelNotify(AdInfo adInfo, boolean z10, int i10) {
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel, com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(final TanxAdSlot tanxAdSlot, final ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, long j10) {
        final long currentTimeMillis = System.currentTimeMillis();
        TanxInterfaceUt.sendMethodInvoke(tanxAdSlot.getPid(), TanxInterfaceUt.REQUEST_FEED);
        super.sendRequest(tanxAdSlot, new ITanxRequestLoader.ITanxRequestListener<ITanxFeedAd>() { // from class: com.alimm.tanx.core.ad.ad.feed.FeedAdModel.1
            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onError(TanxError tanxError) {
                TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.REQUEST_FEED, "error", System.currentTimeMillis() - currentTimeMillis);
                ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2 = iTanxRequestListener;
                if (iTanxRequestListener2 != null) {
                    iTanxRequestListener2.onError(tanxError);
                }
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onSuccess(List<ITanxFeedAd> list) {
                TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.REQUEST_FEED, "success", System.currentTimeMillis() - currentTimeMillis);
                ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2 = iTanxRequestListener;
                if (iTanxRequestListener2 != null) {
                    iTanxRequestListener2.onSuccess(list);
                }
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onTimeOut() {
                TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.REQUEST_FEED, "time_out", System.currentTimeMillis() - currentTimeMillis);
                ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2 = iTanxRequestListener;
                if (iTanxRequestListener2 != null) {
                    iTanxRequestListener2.onTimeOut();
                }
            }
        }, j10);
    }
}
