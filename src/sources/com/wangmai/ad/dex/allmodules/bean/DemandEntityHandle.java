package com.wangmai.ad.dex.allmodules.bean;

import android.view.View;
import android.view.ViewGroup;
import appa.appa.appa.appa;
import appa.appa.appf.appb;
import appa.appa.appf.appd;
import com.wangmai.ad.dex.allmodules.api.splash.ApiWMSplashBgView;
import com.wangmai.ad.dex.allmodules.utils.NativeExpotBgView;
import com.wangmai.common.Ibase.XAdBaseListener;
import com.wangmai.common.bean.SdkThirdPlatform;
import com.wangmai.common.bean.SplashBean;
import com.wangmai.common.enums.EnumPatchType;
import com.wangmai.common.nativepot.NativeWMResponse;
import java.util.Calendar;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class DemandEntityHandle {
    private static final String TAG = "DemandEntityHandle";

    @Deprecated
    private int ackflowType;
    private boolean adIsVideo;
    private int bannerHeight;
    private ViewGroup bannerView;
    private int bannerWidth;
    private int biddingType;
    private int cacheNum;
    private long cacheTime;
    private int clientBidPrice;
    private long createTime;
    private String crid;
    private String demandAdSlotId;
    private String demandAppId;
    private String demandClassType;
    private String demandName;
    private int demandPlatformId;
    private int demandProcesserKey;
    private int demandSlotIdKey;
    private int dspBidPrice;
    private String error;
    private long expireTime;
    private SplashBean extraBean;
    private double gapRatio;
    private String lastRequestId;
    private XAdBaseListener listener;
    private EnumPatchType materialType;
    private int mediaBidPrice;
    private int nativeExpressHeight;
    private NativeExpotBgView nativeExpressView;
    private int nativeExpressWidth;
    private NativeWMResponse nativeWMResponse;
    private double priceRatio;
    private int requestIndex;
    private appa sdkProcesser;
    private int sortType;
    private int status = 0;

    /* renamed from: v, reason: collision with root package name */
    private String f46806v;
    private ApiWMSplashBgView viewSplashBg;

    @Deprecated
    private int weight;
    private int weightRatio;
    private String winReportUrl;
    private View wmClickRegionArea;
    private View wmLayoutBottomArea;
    private ViewGroup wmSplashView;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class Status {
        public static final int COMPLETED = 3;
        public static final int FAILED = 1;
        public static final int INIT = 0;
        public static final int SUCCESS = 2;
    }

    public DemandEntityHandle(SdkThirdPlatform sdkThirdPlatform) {
        this.requestIndex = sdkThirdPlatform.getRequestIndex();
        this.demandAppId = sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdAppId();
        this.demandName = sdkThirdPlatform.getName();
        this.demandPlatformId = sdkThirdPlatform.getId();
        this.demandClassType = sdkThirdPlatform.getClassType();
        this.demandAdSlotId = sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotId();
        this.demandSlotIdKey = sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotIdKey();
        this.weightRatio = sdkThirdPlatform.getSdkThirdAdslotConfig().getWeightRatio();
        this.biddingType = sdkThirdPlatform.getSdkThirdAdslotConfig().getBiddingType();
        this.sortType = sdkThirdPlatform.getSdkThirdAdslotConfig().getSortType();
        this.gapRatio = sdkThirdPlatform.getSdkThirdAdslotConfig().getGapRatio();
        this.priceRatio = sdkThirdPlatform.getSdkThirdAdslotConfig().getPriceRatio();
        this.f46806v = sdkThirdPlatform.getSdkThirdAdslotConfig().getV();
        this.cacheTime = sdkThirdPlatform.getSdkThirdAdslotConfig().getCacheTime() * 60 * 1000;
    }

    @Deprecated
    public int getAckflowType() {
        return this.ackflowType;
    }

    public int getBannerHeight() {
        return this.bannerHeight;
    }

    public ViewGroup getBannerView() {
        return this.bannerView;
    }

    public int getBannerWidth() {
        return this.bannerWidth;
    }

    public int getBiddingType() {
        return this.biddingType;
    }

    public int getCacheNum() {
        return this.cacheNum;
    }

    public long getCacheTime() {
        return this.cacheTime;
    }

    public int getClientBidPrice() {
        return this.clientBidPrice;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getCrid() {
        return this.crid;
    }

    public String getDemandAdSlotId() {
        return this.demandAdSlotId;
    }

    public String getDemandAppId() {
        return this.demandAppId;
    }

    public String getDemandClassType() {
        return this.demandClassType;
    }

    public String getDemandName() {
        return this.demandName;
    }

    public int getDemandPlatformId() {
        return this.demandPlatformId;
    }

    public int getDemandProcesserKey() {
        return this.demandProcesserKey;
    }

    public int getDemandSlotIdKey() {
        return this.demandSlotIdKey;
    }

    public int getDspBidPrice() {
        return this.dspBidPrice;
    }

    public String getError() {
        return this.error;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public SplashBean getExtraBean() {
        return this.extraBean;
    }

    public double getGapRatio() {
        return this.gapRatio;
    }

    public String getLastRequestId() {
        return this.lastRequestId;
    }

    public XAdBaseListener getListener() {
        return this.listener;
    }

    public EnumPatchType getMaterialType() {
        return this.materialType;
    }

    public int getMediaBidPrice() {
        return this.mediaBidPrice;
    }

    public int getNativeExpressHeight() {
        return this.nativeExpressHeight;
    }

    public NativeExpotBgView getNativeExpressView() {
        return this.nativeExpressView;
    }

    public int getNativeExpressWidth() {
        return this.nativeExpressWidth;
    }

    public NativeWMResponse getNativeWMResponse() {
        return this.nativeWMResponse;
    }

    public double getPriceRatio() {
        return this.priceRatio;
    }

    public int getRequestIndex() {
        return this.requestIndex;
    }

    public appa getSdkProcesser() {
        return this.sdkProcesser;
    }

    public int getSortType() {
        return this.sortType;
    }

    public int getStatus() {
        return this.status;
    }

    public String getV() {
        return this.f46806v;
    }

    public ApiWMSplashBgView getViewSplashBg() {
        return this.viewSplashBg;
    }

    @Deprecated
    public int getWeight() {
        return this.weight;
    }

    public int getWeightRatio() {
        return this.weightRatio;
    }

    public String getWinReportUrl() {
        return this.winReportUrl;
    }

    public View getWmClickRegionArea() {
        return this.wmClickRegionArea;
    }

    public View getWmLayoutBottomArea() {
        return this.wmLayoutBottomArea;
    }

    public ViewGroup getWmSplashView() {
        return this.wmSplashView;
    }

    public boolean isAdIsVideo() {
        return this.adIsVideo;
    }

    public boolean isExpired() {
        if (System.currentTimeMillis() - this.createTime > this.cacheTime) {
            return true;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i10 = calendar.get(5);
        calendar.setTimeInMillis(this.createTime);
        return i10 != calendar.get(5);
    }

    public void onDestroy() {
        try {
            if (this.sdkProcesser != null) {
                this.sdkProcesser.onDestroy();
                this.sdkProcesser = null;
            }
            if (this.viewSplashBg != null) {
                appb.appb(this.viewSplashBg);
                appb.appa(this.viewSplashBg);
                this.viewSplashBg.destroyDrawingCache();
                this.viewSplashBg = null;
            }
            if (this.wmSplashView != null) {
                appb.appb(this.wmSplashView);
                appb.appa(this.wmSplashView);
                this.wmSplashView.destroyDrawingCache();
                this.wmSplashView = null;
            }
            if (this.wmLayoutBottomArea != null) {
                appb.appb(this.wmLayoutBottomArea);
                appb.appa(this.wmLayoutBottomArea);
                this.wmLayoutBottomArea.destroyDrawingCache();
                this.wmLayoutBottomArea = null;
            }
            if (this.wmClickRegionArea != null) {
                appb.appb(this.wmClickRegionArea);
                appb.appa(this.wmClickRegionArea);
                this.wmClickRegionArea.destroyDrawingCache();
                this.wmClickRegionArea = null;
            }
            if (this.nativeExpressView != null) {
                appb.appb(this.nativeExpressView);
                appb.appa(this.nativeExpressView);
                this.nativeExpressView.destroyDrawingCache();
                this.nativeExpressView.setProcessor(null);
                this.nativeExpressView.setOnTouchListener(null);
                this.nativeExpressView = null;
            }
            this.listener = null;
            this.nativeWMResponse = null;
            this.extraBean = null;
        } catch (Throwable th) {
            appd.appe(TAG, "onDestroy error:" + th.toString());
        }
    }

    @Deprecated
    public void setAckflowType(int i10) {
        this.ackflowType = i10;
    }

    public void setAdIsVideo(boolean z10) {
        this.adIsVideo = z10;
    }

    public void setBannerHeight(int i10) {
        this.bannerHeight = i10;
    }

    public void setBannerView(ViewGroup viewGroup) {
        this.bannerView = viewGroup;
    }

    public void setBannerWidth(int i10) {
        this.bannerWidth = i10;
    }

    public void setBiddingType(int i10) {
        this.biddingType = i10;
    }

    public void setCacheNum(int i10) {
        this.cacheNum = i10;
    }

    public void setCacheTime(long j10) {
        this.cacheTime = j10;
    }

    public void setClientBidPrice(int i10) {
        this.clientBidPrice = i10;
    }

    public void setCreateTime(long j10) {
        this.createTime = j10;
    }

    public void setCrid(String str) {
        this.crid = str;
    }

    public void setDemandAdSlotId(String str) {
        this.demandAdSlotId = str;
    }

    public void setDemandAppId(String str) {
        this.demandAppId = str;
    }

    public void setDemandClassType(String str) {
        this.demandClassType = str;
    }

    public void setDemandName(String str) {
        this.demandName = str;
    }

    public void setDemandProcesserKey(int i10) {
        this.demandProcesserKey = i10;
    }

    public void setDemandSlotIdKey(int i10) {
        this.demandSlotIdKey = i10;
    }

    public void setDspBidPrice(int i10) {
        this.dspBidPrice = i10;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setExpireTime(long j10) {
        this.expireTime = j10;
    }

    public void setExtraBean(SplashBean splashBean) {
        this.extraBean = splashBean;
    }

    public void setGapRatio(double d10) {
        this.gapRatio = d10;
    }

    public void setLastRequestId(String str) {
        this.lastRequestId = str;
    }

    public void setListener(XAdBaseListener xAdBaseListener) {
        this.listener = xAdBaseListener;
    }

    public void setMaterialType(EnumPatchType enumPatchType) {
        this.materialType = enumPatchType;
    }

    public void setMediaBidPrice(int i10) {
        this.mediaBidPrice = i10;
    }

    public void setNativeExpressHeight(int i10) {
        this.nativeExpressHeight = i10;
    }

    public void setNativeExpressView(NativeExpotBgView nativeExpotBgView) {
        this.nativeExpressView = nativeExpotBgView;
    }

    public void setNativeExpressWidth(int i10) {
        this.nativeExpressWidth = i10;
    }

    public void setNativeWMResponse(NativeWMResponse nativeWMResponse) {
        this.nativeWMResponse = nativeWMResponse;
    }

    public void setPriceRatio(double d10) {
        this.priceRatio = d10;
    }

    public void setRequestIndex(int i10) {
        this.requestIndex = i10;
    }

    public void setSdkProcesser(appa appaVar) {
        this.sdkProcesser = appaVar;
        this.demandProcesserKey = appaVar.hashCode();
    }

    public void setSortType(int i10) {
        this.sortType = i10;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public void setV(String str) {
        this.f46806v = str;
    }

    public void setViewSplashBg(ApiWMSplashBgView apiWMSplashBgView) {
        this.viewSplashBg = apiWMSplashBgView;
    }

    @Deprecated
    public void setWeight(int i10) {
        this.weight = i10;
    }

    public void setWeightRatio(int i10) {
        this.weightRatio = i10;
    }

    public void setWinReportUrl(String str) {
        this.winReportUrl = str;
    }

    public void setWmClickRegionArea(View view) {
        this.wmClickRegionArea = view;
    }

    public void setWmLayoutBottomArea(View view) {
        this.wmLayoutBottomArea = view;
    }

    public void setWmSplashView(ViewGroup viewGroup) {
        this.wmSplashView = viewGroup;
    }

    public String toString() {
        return "DemandEntityHandle{requestIndex=" + this.requestIndex + ", demandName='" + this.demandName + "', demandAdSlotId='" + this.demandAdSlotId + "', demandSlotIdKey=" + this.demandSlotIdKey + ", demandProcesserKey=" + this.demandProcesserKey + ", crid=" + this.crid + ", dspBidPrice=" + this.dspBidPrice + ", clientBidPrice=" + this.clientBidPrice + ", mediaBidPrice=" + this.mediaBidPrice + ", cacheNum=" + this.cacheNum + ", cacheTime=" + this.cacheTime + ", createTime=" + this.createTime + ", expireTime=" + this.expireTime + ", status=" + this.status + ", error=" + this.error + ", biddingType=" + this.biddingType + ", sortType=" + this.sortType + ", gapRatio=" + this.gapRatio + ", priceRatio=" + this.priceRatio + ", listener=" + ((Object) this.listener) + '}';
    }
}
