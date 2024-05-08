package com.wangmai.ad.dex.allmodules.appg;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.SplashAd;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.wangmai.ad.dex.allmodules.appa;
import com.wangmai.ad.dex.allmodules.bean.DemandEntityHandle;
import com.wangmai.ad.dex.allmodules.utils.appp;
import com.wangmai.appsdkdex.WMDexAdHelper;
import com.wangmai.common.Ibase.IBaseInterface;
import com.wangmai.common.Ibase.XAdBaseListener;
import com.wangmai.common.bean.AppConfigRespBean;
import com.wangmai.common.bean.MediaAdSlotIdConfig;
import com.wangmai.common.bean.Optimization;
import com.wangmai.common.bean.SdkThirdPlatform;
import com.wangmai.common.bean.SdkTrackEventBean;
import com.wangmai.common.utils.AesUtil;
import com.wangmai.common.utils.AppConfigUtil;
import com.wangmai.common.utils.ConstantInfo;
import com.wangmai.common.utils.GsonUtils;
import com.wangmai.common.utils.SDKTrackUtils;
import com.wangmai.common.utils.ThreadUtils;
import com.wangmai.common.utils.Utils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: BaseAdDex.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public abstract class appa<T> implements appa.appf, IBaseInterface<T> {
    private static String appu = "BaseAdDex";

    /* renamed from: appa, reason: collision with root package name */
    private Context f46778appa;
    public String appb;
    protected XAdBaseListener appc;
    protected int appe;
    protected int appf;
    protected int appg;
    public int apph;
    public int appi;
    public String appj;
    public int appk;
    private long appm;
    private long appn;
    private long appo;
    public AppConfigRespBean appp;
    private MediaAdSlotIdConfig appq;
    public SdkThirdPlatform appr;
    protected boolean apps;
    protected boolean appd = false;
    protected int appl = -1;
    protected Handler appt = new Handler(Looper.getMainLooper());

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: BaseAdDex.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.appg.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class RunnableC0685appa implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ ViewGroup f46779appa;

        RunnableC0685appa(ViewGroup viewGroup) {
            this.f46779appa = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            appa.this.apph = this.f46779appa.getWidth();
            appa.this.appi = this.f46779appa.getHeight();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: BaseAdDex.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appb implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46780appa;
        final /* synthetic */ SdkThirdPlatform appb;

        appb(String str, SdkThirdPlatform sdkThirdPlatform) {
            this.f46780appa = str;
            this.appb = sdkThirdPlatform;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.equals("api", this.f46780appa)) {
                Context appd = appa.this.appd();
                appa appaVar = appa.this;
                String str = appaVar.appj;
                String str2 = appaVar.appb;
                String thirdSlotId = this.appb.getSdkThirdAdslotConfig().getThirdSlotId();
                String thirdAppId = this.appb.getSdkThirdAdslotConfig().getThirdAppId();
                int thirdSlotIdKey = this.appb.getSdkThirdAdslotConfig().getThirdSlotIdKey();
                appa appaVar2 = appa.this;
                com.wangmai.ad.dex.allmodules.appe.appb.appa(appd, str, str2, thirdSlotId, thirdAppId, thirdSlotIdKey, appaVar2.apph, appaVar2.appi, this.appb.getSdkThirdAdslotConfig().getV());
            }
            appa appaVar3 = appa.this;
            appaVar3.appa(SdkTrackEventBean.TrackEventEnum.AdSdkBidReq, appaVar3.appd(this.appb), appa.this.appe(this.appb), (String) null, "需求方发起请求(AdSdkBidReq)");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: BaseAdDex.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appc implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ SdkThirdPlatform f46781appa;
        final /* synthetic */ int appb;

        appc(SdkThirdPlatform sdkThirdPlatform, int i10) {
            this.f46781appa = sdkThirdPlatform;
            this.appb = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!TextUtils.equals("api", this.f46781appa.getClassType())) {
                    appa.this.appo = System.currentTimeMillis();
                    com.wangmai.ad.dex.allmodules.appe.appb.appa(appa.this.appd(), appa.this.appj, appa.this.appb, this.f46781appa.getSdkThirdAdslotConfig().getThirdSlotId(), this.f46781appa.getSdkThirdAdslotConfig().getThirdAppId(), this.f46781appa.getSdkThirdAdslotConfig().getThirdSlotIdKey(), appa.this.apph, appa.this.appi, this.f46781appa.getSdkThirdAdslotConfig().getV(), appa.this.appo - appa.this.appm, appa.this.appo - appa.this.appn, this.appb, this.f46781appa.getSdkThirdAdslotConfig().getPriceRatio(), this.f46781appa.getSdkThirdAdslotConfig().getGapRatio());
                }
                HashMap hashMap = new HashMap();
                hashMap.put("priceRatio", String.valueOf(this.f46781appa.getSdkThirdAdslotConfig().getPriceRatio()));
                hashMap.put("gapRatio", String.valueOf(this.f46781appa.getSdkThirdAdslotConfig().getGapRatio()));
                appa.this.appa(SdkTrackEventBean.TrackEventEnum.AdSdkBidRespSuccess, appa.this.appd(this.f46781appa), appa.this.appe(this.f46781appa), String.valueOf(this.appb), null, hashMap, null, "需求方请求成功(AdSdkBidRespSuccess)");
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder("SDK需求方请求成功上报错误:");
                SdkThirdPlatform sdkThirdPlatform = this.f46781appa;
                if (sdkThirdPlatform != null && sdkThirdPlatform.getSdkThirdAdslotConfig() != null) {
                    String thirdSlotId = this.f46781appa.getSdkThirdAdslotConfig().getThirdSlotId();
                    sb2.append("demandAdSlotId=");
                    sb2.append(thirdSlotId);
                    sb2.append(",");
                }
                sb2.append("error=");
                sb2.append(th);
                appa.appa.appf.appd.appe(appa.appu, sb2.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: BaseAdDex.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appd implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46782appa;
        final /* synthetic */ SdkThirdPlatform appb;
        final /* synthetic */ String appc;

        appd(String str, SdkThirdPlatform sdkThirdPlatform, String str2) {
            this.f46782appa = str;
            this.appb = sdkThirdPlatform;
            this.appc = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!TextUtils.equals("api", this.f46782appa)) {
                    appa.this.appo = System.currentTimeMillis();
                    com.wangmai.ad.dex.allmodules.appe.appb.appa(appa.this.appd(), appa.this.appj, appa.this.appb, this.appb.getSdkThirdAdslotConfig().getThirdSlotId(), this.appb.getSdkThirdAdslotConfig().getThirdAppId(), this.appb.getSdkThirdAdslotConfig().getThirdSlotIdKey(), appa.this.apph, appa.this.appi, this.appb.getSdkThirdAdslotConfig().getV(), appa.this.appo - appa.this.appm, appa.this.appo - appa.this.appn, this.appc);
                }
                appa.this.appa(SdkTrackEventBean.TrackEventEnum.AdSdkBidRespFailure, appa.this.appd(this.appb), appa.this.appe(this.appb), this.appc, "需求方请求失败(AdSdkBidRespFailure)");
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder("SDK需求方请求失败上报错误:");
                SdkThirdPlatform sdkThirdPlatform = this.appb;
                if (sdkThirdPlatform != null && sdkThirdPlatform.getSdkThirdAdslotConfig() != null) {
                    String thirdSlotId = this.appb.getSdkThirdAdslotConfig().getThirdSlotId();
                    sb2.append("demandAdSlotId=");
                    sb2.append(thirdSlotId);
                    sb2.append(",");
                }
                sb2.append("error=");
                sb2.append(th);
                appa.appa.appf.appd.appe(appa.appu, sb2.toString());
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: BaseAdDex.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appe implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46783appa;
        final /* synthetic */ SdkThirdPlatform appb;
        final /* synthetic */ String appc;

        appe(String str, SdkThirdPlatform sdkThirdPlatform, String str2) {
            this.f46783appa = str;
            this.appb = sdkThirdPlatform;
            this.appc = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!TextUtils.equals("api", this.f46783appa)) {
                    appa.this.appo = System.currentTimeMillis();
                    com.wangmai.ad.dex.allmodules.appe.appb.appa(appa.this.appd(), appa.this.appj, appa.this.appb, this.appb.getSdkThirdAdslotConfig().getThirdSlotId(), this.appb.getSdkThirdAdslotConfig().getThirdAppId(), this.appb.getSdkThirdAdslotConfig().getThirdSlotIdKey(), appa.this.apph, appa.this.appi, this.appb.getSdkThirdAdslotConfig().getV(), appa.this.appo - appa.this.appm, appa.this.appo - appa.this.appn, appa.this.appe, appa.this.appf, appa.this.appe, this.appb.getSdkThirdAdslotConfig().getPriceRatio(), this.appb.getSdkThirdAdslotConfig().getGapRatio());
                }
                appa.this.appa(SdkTrackEventBean.TrackEventEnum.AdSdkDisplayRespSuccess, appa.this.appd(this.appb), appa.this.appe(this.appb), null, this.appc, "需求方曝光成功(AdSdkDisplayRespSuccess)");
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder("SDK需求方曝光上报错误:");
                SdkThirdPlatform sdkThirdPlatform = this.appb;
                if (sdkThirdPlatform != null && sdkThirdPlatform.getSdkThirdAdslotConfig() != null) {
                    String thirdSlotId = this.appb.getSdkThirdAdslotConfig().getThirdSlotId();
                    sb2.append("demandAdSlotId=");
                    sb2.append(thirdSlotId);
                    sb2.append(",");
                }
                sb2.append("error=");
                sb2.append(th);
                appa.appa.appf.appd.appe(appa.appu, sb2.toString());
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: BaseAdDex.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appf implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46784appa;
        final /* synthetic */ SdkThirdPlatform appb;
        final /* synthetic */ String appc;

        appf(String str, SdkThirdPlatform sdkThirdPlatform, String str2) {
            this.f46784appa = str;
            this.appb = sdkThirdPlatform;
            this.appc = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!TextUtils.equals("api", this.f46784appa)) {
                    appa.this.appo = System.currentTimeMillis();
                    com.wangmai.ad.dex.allmodules.appe.appb.appa(appa.this.appd(), appa.this.appj, appa.this.appb, this.appb.getSdkThirdAdslotConfig().getThirdSlotId(), this.appb.getSdkThirdAdslotConfig().getThirdAppId(), this.appb.getSdkThirdAdslotConfig().getThirdSlotIdKey(), appa.this.apph, appa.this.appi, this.appb.getSdkThirdAdslotConfig().getV(), appa.this.appo - appa.this.appm, appa.this.appo - appa.this.appn);
                }
                appa appaVar = appa.this;
                SdkTrackEventBean.TrackEventEnum trackEventEnum = SdkTrackEventBean.TrackEventEnum.AdClick;
                int appd = appa.this.appd(this.appb);
                String appe = appa.this.appe(this.appb);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(ConstantInfo.downX);
                stringBuffer.append(",");
                stringBuffer.append(ConstantInfo.downY);
                appaVar.appa(trackEventEnum, appd, appe, stringBuffer.toString(), this.appc, "需求方点击成功(AdClick)");
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder("SDK需求方点击上报错误:");
                SdkThirdPlatform sdkThirdPlatform = this.appb;
                if (sdkThirdPlatform != null && sdkThirdPlatform.getSdkThirdAdslotConfig() != null) {
                    String thirdSlotId = this.appb.getSdkThirdAdslotConfig().getThirdSlotId();
                    sb2.append("demandAdSlotId=");
                    sb2.append(thirdSlotId);
                    sb2.append(",");
                }
                sb2.append("error=");
                sb2.append(th);
                appa.appa.appf.appd.appe(appa.appu, sb2.toString());
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: BaseAdDex.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appg implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ DemandEntityHandle f46785appa;

        appg(DemandEntityHandle demandEntityHandle) {
            this.f46785appa = demandEntityHandle;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f46785appa != null) {
                    if (!TextUtils.equals("api", this.f46785appa.getDemandClassType())) {
                        appa.this.appo = System.currentTimeMillis();
                        com.wangmai.ad.dex.allmodules.appe.appb.appb(appa.this.appd(), appa.this.appj, appa.this.appb, this.f46785appa.getDemandAdSlotId(), this.f46785appa.getDemandAppId(), this.f46785appa.getDemandSlotIdKey(), appa.this.apph, appa.this.appi, this.f46785appa.getV(), appa.this.appo - appa.this.appm, appa.this.appo - appa.this.appn, appa.this.appe, appa.this.appf, appa.this.appe, this.f46785appa.getPriceRatio(), this.f46785appa.getGapRatio());
                    } else {
                        com.wangmai.ad.dex.allmodules.utils.appf.appa(this.f46785appa.getWinReportUrl(), "API需求方竟胜上报");
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("priceRatio", String.valueOf(this.f46785appa.getPriceRatio()));
                    hashMap.put("gapRatio", String.valueOf(this.f46785appa.getGapRatio()));
                    hashMap.put("calcDspBidPrice", String.valueOf(this.f46785appa.getClientBidPrice()));
                    hashMap.put("calcMediaWinPrice", String.valueOf(Math.round(this.f46785appa.getMediaBidPrice() * this.f46785appa.getGapRatio())));
                    appa.this.appa(SdkTrackEventBean.TrackEventEnum.AdWin, this.f46785appa.getDemandPlatformId(), this.f46785appa.getDemandAdSlotId(), String.valueOf(appa.this.appe), String.valueOf(appa.this.appf), hashMap, null, "媒体竟侧竟胜打点(AdWin)");
                }
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder("媒体侧竞价成功上报错误:");
                DemandEntityHandle demandEntityHandle = this.f46785appa;
                if (demandEntityHandle != null) {
                    String demandAdSlotId = demandEntityHandle.getDemandAdSlotId();
                    sb2.append("demandAdSlotId=");
                    sb2.append(demandAdSlotId);
                    sb2.append(",");
                }
                sb2.append("error=");
                sb2.append(th);
                appa.appa.appf.appd.appe(appa.appu, sb2.toString());
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: BaseAdDex.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class apph implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46786appa;

        apph(String str) {
            this.f46786appa = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            XAdBaseListener xAdBaseListener = appa.this.appc;
            if (xAdBaseListener != null) {
                xAdBaseListener.onNoAd(this.f46786appa);
            }
        }
    }

    public appa(Activity activity, String str, ViewGroup viewGroup, XAdBaseListener xAdBaseListener, String str2) {
        this.apps = false;
        try {
            appa.appa.appf.appd.appa(appu, "媒体是否允许SDK采集位置信息：" + ConstantInfo.isCanUseLocation());
            appa.appa.appf.appd.appa(appu, "媒体传入的Location信息：" + ((Object) ConstantInfo.getDevWMLocation()));
            appa.appa.appf.appd.appa(appu, "媒体是否允许SDK采集设备硬件参数信息：" + ConstantInfo.isCanUsePhoneState());
            appa.appa.appf.appd.appa(appu, "媒体传入的IMEI信息：" + ConstantInfo.getDevImei());
            appa.appa.appf.appd.appa(appu, "媒体是否允许SDK采集OAID信息：" + ConstantInfo.isCanUseOaid());
            appa.appa.appf.appd.appa(appu, "媒体传入的OAID信息：" + ConstantInfo.getDevOaid());
            appa.appa.appf.appd.appa(appu, "媒体是否允许SDK采集WIFI信息：" + ConstantInfo.isCanUseWifiState());
            appa.appa.appf.appd.appa(appu, "媒体传入的Mac地址：" + ConstantInfo.getDevMacAddress());
            appa.appa.appf.appd.appa(appu, "媒体是否允许SDK采集Network信息：" + ConstantInfo.isCanUseNetworkState());
            appa.appa.appf.appd.appa(appu, "媒体是否允许SDK采集存储信息：" + ConstantInfo.isCanUseWriteExternal());
            appa.appa.appf.appd.appa(appu, "媒体是否允许SDK采集已安装应用列表信息：" + ConstantInfo.isCanUseAppList());
            appa.appa.appf.appd.appa(appu, "媒体是否允许SDK使用录音功能：" + ConstantInfo.isCanUsePermissionRecordAudio());
            this.appc = xAdBaseListener;
            if (xAdBaseListener == null) {
                appa.appa.appf.appd.appb(appu, "AdListener为空");
                return;
            }
            if (activity != null && !TextUtils.isEmpty(str)) {
                this.apps = true;
                this.appb = str;
                if (this.f46778appa == null) {
                    this.f46778appa = activity.getApplicationContext();
                }
                if (WMDexAdHelper.getTopActivity() == null) {
                    WMDexAdHelper.setTopActivity(activity);
                }
                this.appp = AppConfigUtil.getInstance().getAppConfig(this.f46778appa);
                this.appq = AppConfigUtil.getInstance().getMediaAdSlotConfigByAdSlotId(this.appp, str);
                if (this.appq != null) {
                    if (viewGroup != null) {
                        viewGroup.post(new RunnableC0685appa(viewGroup));
                        return;
                    }
                    return;
                } else {
                    appb("无效配置信息:adSlotId=" + str);
                    return;
                }
            }
            appb("缺失必要参数:activity=" + ((Object) activity) + ",adSlotId=" + str);
        } catch (Throwable th) {
            appb("请求数据错误:adSlotId=" + str + ",error=" + th);
        }
    }

    private void appl() {
        try {
            if (!appa.appa.appf.appc.appb && !TextUtils.isEmpty(this.appp.getRealmName())) {
                com.wangmai.ad.dex.allmodules.utils.appf.f46826appa = this.appp.getRealmName();
                if (!TextUtils.isEmpty(this.appp.getTrackHost())) {
                    com.wangmai.ad.dex.allmodules.utils.appf.appb = this.appp.getTrackHost();
                }
                com.wangmai.ad.dex.allmodules.utils.appf.appa();
            }
            if (this.appq.getSdkAdslotConfig().getOptimization() != null && this.appq.getSdkAdslotConfig().getOptimization().getCloseObj() != null) {
                this.appk = this.appq.getSdkAdslotConfig().getOptimization().getCloseObj().getCloseRand();
            }
            if (this.appp.getCkeckBundles() != null && this.appp.getCkeckBundles().getPackageName() != null && this.appp.getCkeckBundles().getPackageName().size() > 0) {
                com.wangmai.ad.dex.allmodules.utils.appf.appa(appd(), this.appp.getCkeckBundles().getPackageName());
            }
            appa.appa.appf.appd.appe(appu, "素材采集上报概率trackAdmRandom=" + this.appl);
            appp.appa(this.appq, appd());
            appj();
        } catch (Throwable th) {
            appb("返回数据无效:mediaAdSlotId=" + this.appb + ",error=" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void appa(Bundle bundle) {
    }

    protected int appd(SdkThirdPlatform sdkThirdPlatform) {
        if (sdkThirdPlatform == null) {
            return -1;
        }
        try {
            return sdkThirdPlatform.getId();
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appu, "getDemandPlatformId error:" + th.toString());
            return -1;
        }
    }

    public int appe() {
        try {
            if (this.appq != null) {
                return this.appq.getSdkAdslotConfig().getBannerRft();
            }
            return 0;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appu, "getBannerRft error:" + th.toString());
            return 0;
        }
    }

    public Optimization appf() {
        try {
            if (this.appq != null) {
                return this.appq.getSdkAdslotConfig().getOptimization();
            }
            return null;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appu, "getOptimization error:" + th.toString());
            return null;
        }
    }

    public int appg() {
        try {
            if (this.appq != null) {
                return this.appq.getSdkAdslotConfig().getfSdkAdPrompt();
            }
            return 0;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appu, "getfSdkAdPrompt error:" + th.toString());
            return 0;
        }
    }

    public int apph() {
        try {
            if (this.appq != null) {
                return this.appq.getSdkAdslotConfig().getfSdkDownloadPopup();
            }
            return 0;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appu, "getfSdkDownloadPopup error:" + th.toString());
            return 0;
        }
    }

    public int appi() {
        try {
            if (this.appq == null || this.appq.getSdkAdslotConfig() == null) {
                return 0;
            }
            return this.appq.getSdkAdslotConfig().getSdkInvokeFailRetry();
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appu, "getSdkInvokeFailRetry error:" + th.toString());
            return 0;
        }
    }

    public abstract void appj();

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public String getCurrentVCode() {
        SdkThirdPlatform sdkThirdPlatform = this.appr;
        if (sdkThirdPlatform != null) {
            return sdkThirdPlatform.getSdkThirdAdslotConfig().getV();
        }
        return null;
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public String getRequestId() {
        return this.appj;
    }

    @Override // com.wangmai.common.Ibase.IBaseInterface
    public void setImplement(T t2) {
    }

    public void appb() {
        try {
            if (this.appp != null && this.appq != null) {
                com.wangmai.ad.dex.allmodules.utils.appf.appb(appd());
                this.appm = System.currentTimeMillis();
                if (this.apph == 0) {
                    this.apph = Utils.getWindowWidth(appd());
                }
                if (this.appi == 0) {
                    this.appi = Utils.getWindowHeight(appd());
                }
                appa.appa.appf.appd.appa(appu, SplashAd.KEY_FETCHAD, "WindowWidth=" + this.apph, "WindowHeight=" + this.appi);
                try {
                    this.appj = AesUtil.encrypt(UUID.randomUUID().toString() + System.currentTimeMillis() + "", ConstantInfo.getAppToken());
                    com.wangmai.ad.dex.allmodules.appe.appb.appa(appd(), this.appj, this.appb, this.apph, this.appi, "");
                    appl();
                    return;
                } catch (Throwable th) {
                    appb("请求中requestId错误:mediaAdSlotId=" + this.appb + ",error=" + th);
                    return;
                }
            }
            appa.appa.appf.appd.appe(appu, "无效配置信息:mediaAdSlotId=" + this.appb);
        } catch (Throwable th2) {
            appb("请求数据错误:mediaAdSlotId=" + this.appb + ",error=" + th2);
        }
    }

    public void appc() {
        try {
            appa.appa.appf.appd.appa(appu, "并行请求本次广告", Integer.valueOf(this.apph), Integer.valueOf(this.appi), GsonUtils.getInstance().toJson(this.appq));
            List<SdkThirdPlatform> sdkThirdPlatforms = this.appq.getSdkThirdPlatforms();
            if (sdkThirdPlatforms != null && sdkThirdPlatforms.size() > 0) {
                new com.wangmai.ad.dex.allmodules.appa(appd(), this.appb, sdkThirdPlatforms, this.appq.getSdkAdslotConfig(), this).appa();
            } else {
                appb("暂无可用的请求策略:mediaAdSlotId=" + this.appb);
            }
        } catch (Throwable th) {
            appb("请求策略错误:mediaAdSlotId=" + this.appb + ",error=" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void appa(DemandEntityHandle demandEntityHandle, SdkThirdPlatform sdkThirdPlatform, appa.appa.appa.appa appaVar, appa.appc appcVar) {
        int dspBidPrice;
        try {
            if (appcVar.appa(sdkThirdPlatform)) {
                appcVar.appa(sdkThirdPlatform, appaVar, demandEntityHandle);
                if (sdkThirdPlatform.getSdkThirdAdslotConfig().getBiddingType() == 2) {
                    dspBidPrice = appaVar.getDspPrice();
                } else {
                    dspBidPrice = demandEntityHandle.getDspBidPrice();
                }
                appa(sdkThirdPlatform, dspBidPrice);
            }
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder("需求方请求成功处理错误:");
            if (sdkThirdPlatform != null && sdkThirdPlatform.getSdkThirdAdslotConfig() != null) {
                String thirdSlotId = sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotId();
                sb2.append("demandAdSlotId=");
                sb2.append(thirdSlotId);
                sb2.append(",");
            }
            sb2.append("error=");
            sb2.append(th);
            appa.appa.appf.appd.appe(appu, sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context appd() {
        Context context = this.f46778appa;
        if (context != null) {
            return context;
        }
        if (WMDexAdHelper.getTopActivity() != null && WMDexAdHelper.getTopActivity().get() != null) {
            return WMDexAdHelper.getTopActivity().get().getApplicationContext();
        }
        throw new NullPointerException("Context空，请检查广告请求构造器是否正确传入!");
    }

    public String appe(SdkThirdPlatform sdkThirdPlatform) {
        if (sdkThirdPlatform == null) {
            return "";
        }
        try {
            return sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotId();
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appu, "getDemandSlotId error:" + th.toString());
            return "";
        }
    }

    private void appc(SdkThirdPlatform sdkThirdPlatform, String str, String str2) {
        ThreadUtils.runOnThreadPool(new appd(str2, sdkThirdPlatform, str));
    }

    public String appc(SdkThirdPlatform sdkThirdPlatform) {
        if (sdkThirdPlatform == null) {
            return "";
        }
        try {
            return sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotAppKey();
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appu, "getDemandAppKey error:" + th.toString());
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void appa(DemandEntityHandle demandEntityHandle, SdkThirdPlatform sdkThirdPlatform, List<String> list, String str, appa.appc appcVar) {
        try {
            if (appcVar.appa(sdkThirdPlatform)) {
                appcVar.appa(sdkThirdPlatform, str, demandEntityHandle, list);
                appc(sdkThirdPlatform, str, sdkThirdPlatform.getClassType());
            }
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder("需求方请求失败处理错误:");
            if (sdkThirdPlatform != null && sdkThirdPlatform.getSdkThirdAdslotConfig() != null) {
                String thirdSlotId = sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotId();
                sb2.append("demandAdSlotId=");
                sb2.append(thirdSlotId);
                sb2.append(",");
            }
            sb2.append("error=");
            sb2.append(th);
            appa.appa.appf.appd.appe(appu, sb2.toString());
        }
    }

    public void appb(SdkThirdPlatform sdkThirdPlatform, String str) {
        try {
            ThreadUtils.runOnThreadPool(new appb(str, sdkThirdPlatform));
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder("SDK需求方请求上报错误:");
            if (sdkThirdPlatform != null && sdkThirdPlatform.getSdkThirdAdslotConfig() != null) {
                String thirdSlotId = sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotId();
                sb2.append("demandAdSlotId=");
                sb2.append(thirdSlotId);
                sb2.append(",");
            }
            sb2.append("error=");
            sb2.append(th);
            appa.appa.appf.appd.appe(appu, sb2.toString());
        }
    }

    public void appb(SdkThirdPlatform sdkThirdPlatform, String str, String str2) {
        ThreadUtils.runOnThreadPool(new appe(str, sdkThirdPlatform, str2));
    }

    @Override // com.wangmai.ad.dex.allmodules.appa.appf
    public void appa(SdkThirdPlatform sdkThirdPlatform) {
        StringBuffer stringBuffer = new StringBuffer("需求方请求超时:");
        stringBuffer.append(sdkThirdPlatform.getName());
        stringBuffer.append(",");
        stringBuffer.append(sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotId());
        appc(sdkThirdPlatform, stringBuffer.toString(), sdkThirdPlatform.getClassType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void appb(DemandEntityHandle demandEntityHandle) {
        ThreadUtils.runOnThreadPool(new appg(demandEntityHandle));
    }

    private void appb(String str) {
        appa.appa.appf.appd.appb(appu, "onNoAd:" + str);
        XAdBaseListener xAdBaseListener = this.appc;
        if (xAdBaseListener != null) {
            xAdBaseListener.onNoAd(str);
        }
    }

    public String appb(SdkThirdPlatform sdkThirdPlatform) {
        if (sdkThirdPlatform == null) {
            return "";
        }
        try {
            return sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdAppId();
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appu, "getDemandAppId error:" + th.toString());
            return "";
        }
    }

    private void appa(SdkThirdPlatform sdkThirdPlatform, int i10) {
        ThreadUtils.runOnThreadPool(new appc(sdkThirdPlatform, i10));
    }

    public void appa(SdkThirdPlatform sdkThirdPlatform, String str, String str2) {
        appa.appa.appf.appd.appa(appu, "onAdClickSuccess", str, this.appj, str2, Long.valueOf(this.appm), Long.valueOf(this.appn), Double.valueOf(ConstantInfo.downX), Double.valueOf(ConstantInfo.downY));
        ThreadUtils.runOnThreadPool(new appf(str, sdkThirdPlatform, str2));
    }

    protected void appb(SdkTrackEventBean.TrackEventEnum trackEventEnum, String str, String str2) {
        appa(trackEventEnum, -1, (String) null, str, str2);
    }

    @Override // com.wangmai.ad.dex.allmodules.appa.appf
    public void appa(DemandEntityHandle demandEntityHandle) {
        try {
            appb(SdkTrackEventBean.TrackEventEnum.AdBidRespSuccess, (String) null, "媒体请求成功(AdBidRespSuccess)");
            HashMap hashMap = new HashMap();
            hashMap.put("priceRatio", String.valueOf(demandEntityHandle.getPriceRatio()));
            hashMap.put("gapRatio", String.valueOf(demandEntityHandle.getGapRatio()));
            hashMap.put("calcDspBidPrice", String.valueOf(demandEntityHandle.getClientBidPrice()));
            appa(SdkTrackEventBean.TrackEventEnum.AdBidFinish, demandEntityHandle.getDemandPlatformId(), demandEntityHandle.getDemandAdSlotId(), String.valueOf(demandEntityHandle.getDspBidPrice()), null, hashMap, null, "SDK竞价完成");
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder("媒体请求成功(竞价完成)处理错误:");
            if (demandEntityHandle != null) {
                String demandAdSlotId = demandEntityHandle.getDemandAdSlotId();
                sb2.append("demandAdSlotId=");
                sb2.append(demandAdSlotId);
                sb2.append(",");
            }
            sb2.append("error=");
            sb2.append(th);
            appa.appa.appf.appd.appe(appu, sb2.toString());
        }
    }

    @Override // com.wangmai.ad.dex.allmodules.appa.appf
    public void appa(String str) {
        ThreadUtils.runOnUIThread(new apph(str));
        appb(SdkTrackEventBean.TrackEventEnum.AdBidRespFailure, str, "媒体请求失败(AdBidRespFailure)");
    }

    @Override // com.wangmai.ad.dex.allmodules.appa.appf
    public void appa(SdkTrackEventBean.TrackEventEnum trackEventEnum, String str, String str2) {
        appb(trackEventEnum, str, str2);
    }

    public String appa(SdkThirdPlatform sdkThirdPlatform, String str) {
        String thirdSlotId;
        try {
            if (TextUtils.equals("api", str)) {
                thirdSlotId = this.appb;
            } else {
                thirdSlotId = sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotId();
            }
            return thirdSlotId;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appu, "getSlotId error:" + th.toString());
            return "";
        }
    }

    public boolean appa() {
        try {
            if (this.appq == null || this.appq.getSdkAdslotConfig().getOptimization() == null || this.appq.getSdkAdslotConfig().getOptimization().getAdCache() == null) {
                return false;
            }
            return this.appq.getSdkAdslotConfig().getOptimization().getAdCache().getCacheCount() > 0;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appu, "isAvailableCache error:" + th.toString());
            return false;
        }
    }

    public boolean appa(appa.appa.appa.appa appaVar, String str, String str2) {
        this.appn = System.currentTimeMillis();
        return (appaVar == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void appa(int i10) {
        try {
            if (appa()) {
                com.wangmai.ad.dex.allmodules.appd.appa.appa().appa(this.appb, i10);
            } else {
                appa.appa.appf.appd.appe(appu, "当前媒体代码位未开启缓存配置，无需移除缓存");
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appu, "removeExposedDemandFromCache error:" + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void appa(SdkTrackEventBean.TrackEventEnum trackEventEnum, int i10, String str, String str2, String str3) {
        appa(trackEventEnum, i10, str, str2, null, null, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void appa(SdkTrackEventBean.TrackEventEnum trackEventEnum, int i10, String str, String str2, String str3, String str4) {
        appa(trackEventEnum, i10, str, str2, null, str3, str4);
    }

    protected void appa(SdkTrackEventBean.TrackEventEnum trackEventEnum, int i10, String str, String str2, String str3, String str4, String str5) {
        appa(trackEventEnum, i10, str, str2, str3, null, str4, str5);
    }

    protected void appa(SdkTrackEventBean.TrackEventEnum trackEventEnum, int i10, String str, String str2, String str3, Map<String, String> map, String str4, String str5) {
        String str6 = this.appj;
        if (TextUtils.isEmpty(str4)) {
            str4 = str6;
        }
        if (trackEventEnum == SdkTrackEventBean.TrackEventEnum.AdClick) {
            ConstantInfo.downX = ShadowDrawableWrapper.COS_45;
            ConstantInfo.downY = ShadowDrawableWrapper.COS_45;
            if (SDKTrackUtils.getInstance().queryAlreadyTrackEvent(str4, SdkTrackEventBean.TrackEventEnum.AdClick)) {
                appa.appa.appf.appd.appa(appu, "点击事件已经埋点，无需再次埋点");
                return;
            }
        }
        SdkTrackEventBean.EventBean eventBean = new SdkTrackEventBean.EventBean(trackEventEnum);
        if (i10 > 0) {
            eventBean.setThird_id(i10);
        }
        if (!TextUtils.isEmpty(str)) {
            eventBean.setThird_slot_id(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            eventBean.setExt1(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            eventBean.setExt2(str3);
        }
        if (map != null && !map.isEmpty()) {
            eventBean.setExt_data(map);
        }
        SDKTrackUtils.getInstance().addTrackBean(appd(), str4, eventBean, str5);
    }

    public String appa(String str, SdkThirdPlatform sdkThirdPlatform, appa.appa.appa.appa appaVar, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("需求方执行失败[");
        stringBuffer.append(str);
        stringBuffer.append("]");
        stringBuffer.append("demandName:");
        stringBuffer.append(sdkThirdPlatform.getName());
        stringBuffer.append(",demandClassType:");
        stringBuffer.append(sdkThirdPlatform.getClassType());
        stringBuffer.append(",demandAppId:");
        stringBuffer.append(sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdAppId());
        stringBuffer.append(",demandAdSlotId:");
        stringBuffer.append(sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotId());
        stringBuffer.append(",biddingType:");
        stringBuffer.append(sdkThirdPlatform.getSdkThirdAdslotConfig().getBiddingType());
        stringBuffer.append(",sortType:");
        stringBuffer.append(sdkThirdPlatform.getSdkThirdAdslotConfig().getSortType());
        stringBuffer.append(",processer:");
        stringBuffer.append((Object) appaVar);
        stringBuffer.append(",error:");
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }
}
