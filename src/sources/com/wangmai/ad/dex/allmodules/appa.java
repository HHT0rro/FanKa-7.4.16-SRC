package com.wangmai.ad.dex.allmodules;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.ads.ContentClassification;
import com.wangmai.ad.dex.allmodules.bean.DemandEntityHandle;
import com.wangmai.ad.dex.allmodules.utils.appj;
import com.wangmai.ad.dex.allmodules.utils.appk;
import com.wangmai.common.bean.SdkAdSlotConfig;
import com.wangmai.common.bean.SdkThirdPlatform;
import com.wangmai.common.bean.SdkTrackEventBean;
import com.wangmai.common.runnable.HasTypeRunnable;
import com.wangmai.common.utils.ConstantInfo;
import com.wangmai.common.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: AdDispatcherManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa {

    /* renamed from: e, reason: collision with root package name */
    private static final String f46689e = "appa";

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f46690f = {"A", "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "W", "X", "Y", "Z"};

    /* renamed from: a, reason: collision with root package name */
    private appd f46691a;

    /* renamed from: appa, reason: collision with root package name */
    private final appf f46692appa;
    private boolean appf;
    private boolean appg;
    private final long appi;
    private long appj;
    private final String appl;
    private int appm;
    private int appn;
    private int appo;
    private int appp;
    private int appq;
    private boolean appr;
    private int apps;
    private ArrayBlockingQueue<SdkThirdPlatform> appt;
    private ArrayBlockingQueue<SdkThirdPlatform> appu;
    private ArrayBlockingQueue<SdkThirdPlatform> appv;
    private ArrayBlockingQueue<SdkThirdPlatform> appw;
    private ArrayBlockingQueue<DemandEntityHandle> appx;
    private ArrayBlockingQueue<DemandEntityHandle> appy;
    private appg appz;

    /* renamed from: b, reason: collision with root package name */
    private appe f46693b;

    /* renamed from: c, reason: collision with root package name */
    private List<DemandEntityHandle> f46694c;
    private final Handler appb = new Handler(Looper.getMainLooper());
    private final int appc = hashCode();
    private boolean appd = false;
    private boolean appe = false;
    private int apph = 0;
    private int appk = 0;

    /* renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, DemandEntityHandle> f46695d = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: AdDispatcherManager.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class C0674appa implements HasTypeRunnable<Integer> {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ SdkThirdPlatform f46696appa;
        final /* synthetic */ int appb;
        final /* synthetic */ DemandEntityHandle appc;

        C0674appa(SdkThirdPlatform sdkThirdPlatform, int i10, DemandEntityHandle demandEntityHandle) {
            this.f46696appa = sdkThirdPlatform;
            this.appb = i10;
            this.appc = demandEntityHandle;
        }

        @Override // com.wangmai.common.runnable.HasTypeRunnable
        /* renamed from: appa, reason: merged with bridge method [inline-methods] */
        public void run(Integer num) {
            if (appa.this.appa(this.f46696appa)) {
                if (num == null || num.intValue() <= 0) {
                    String str = "需求方媒体结算价无效(" + this.f46696appa.getName() + "," + this.f46696appa.getSdkThirdAdslotConfig().getThirdSlotId() + "," + ((Object) num) + ")";
                    appa.appa.appf.appd.appe(appa.f46689e, appa.this.appa(str));
                    this.appc.setError(str);
                    appa.this.appa(2, this.appc, this.f46696appa);
                    return;
                }
                appa.this.appa(this.appb);
                this.appc.setStatus(3);
                this.appc.setMediaBidPrice(num.intValue());
                appa.this.appa(1, this.appc, this.f46696appa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: AdDispatcherManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb implements Runnable {
        appb() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (appa.this.appy != null && !appa.this.appy.isEmpty()) {
                appk.appa.appa((ArrayBlockingQueue<DemandEntityHandle>) appa.this.appy);
                appa appaVar = appa.this;
                appaVar.f46694c = new ArrayList(appaVar.appy);
                appa.this.appy.clear();
            } else {
                appa.this.f46694c = new ArrayList();
            }
            if (appa.this.apps > 0) {
                appa.this.f46692appa.appa(SdkTrackEventBean.TrackEventEnum.AdCacheReq, (String) null, "SDK读取缓存(AdCacheReq)");
                List<DemandEntityHandle> appa2 = com.wangmai.ad.dex.allmodules.appd.appa.appa().appa(appa.this.appl, "本次媒体代码位下所有需求方全部返回");
                if (appa2 == null || appa2.isEmpty()) {
                    appa.this.f46692appa.appa(SdkTrackEventBean.TrackEventEnum.AdCacheRespFailure, "无可用缓存", "SDK读取缓存失败(AdCacheRespFailure)");
                } else {
                    appk.appa.appa(appa2);
                    appa.this.f46694c.addAll(appa2);
                    appa.this.f46692appa.appa(SdkTrackEventBean.TrackEventEnum.AdCacheRespSuccess, String.valueOf(appa2.size()), "SDK读取缓存成功(AdCacheRespSuccess)");
                }
                if (appa.this.f46694c.size() > appa.this.apps) {
                    Collections.sort(appa.this.f46694c, new com.wangmai.ad.dex.allmodules.utils.appe(1));
                    appa appaVar2 = appa.this;
                    appa.appa.appf.appd.appa(appa.f46689e, appaVar2.appa("缓存检查排序后", appaVar2.f46694c));
                    for (int size = appa.this.f46694c.size() - 1; size >= appa.this.apps; size += -1) {
                        DemandEntityHandle demandEntityHandle = (DemandEntityHandle) appa.this.f46694c.get(size);
                        appa.appa.appf.appd.appe(appa.f46689e, "缓存超限，移除低效需求方：" + ((Object) demandEntityHandle));
                        appa.this.f46694c.remove(demandEntityHandle);
                        demandEntityHandle.onDestroy();
                    }
                }
            }
            appa.this.appc();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: AdDispatcherManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appc implements Runnable {
        public appc() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void appb(SdkThirdPlatform sdkThirdPlatform) {
            try {
                Object[] objArr = new Object[2];
                objArr[0] = appa.f46689e;
                appa appaVar = appa.this;
                Object[] objArr2 = new Object[5];
                objArr2[0] = "需求方执行超时:";
                objArr2[1] = sdkThirdPlatform.getName();
                objArr2[2] = sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotId();
                objArr2[3] = sdkThirdPlatform.getSdkThirdAdslotConfig().getBiddingType() == 2 ? "竞价" : "标准";
                objArr2[4] = sdkThirdPlatform.getSdkThirdAdslotConfig().getSortType() == 1 ? "兜底" : "按价格";
                objArr[1] = appaVar.appa(objArr2);
                appa.appa.appf.appd.appe(objArr);
                DemandEntityHandle demandEntityHandle = appa.this.f46695d.containsKey(Integer.valueOf(sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotIdKey())) ? (DemandEntityHandle) appa.this.f46695d.get(Integer.valueOf(sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotIdKey())) : null;
                if (demandEntityHandle == null) {
                    demandEntityHandle = new DemandEntityHandle(sdkThirdPlatform);
                }
                demandEntityHandle.setStatus(1);
                demandEntityHandle.setError("需求方执行超时(" + sdkThirdPlatform.getName() + "," + sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotId() + ")time_out");
                appa.this.appa(2, demandEntityHandle, sdkThirdPlatform);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe(appa.f46689e, "需求方处理失败(onAdRespTimeout):" + th);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (appa.this.apph == 1) {
                    appa.appa.appf.appd.appa(appa.f46689e, appa.this.appa("设置媒体代码位总请求超时监测", Integer.valueOf(appa.this.appm)));
                    appa.this.appz = new appg(this);
                    appa.this.appb.postDelayed(appa.this.appz, appa.this.appm);
                    if (appa.this.appt != null && !appa.this.appt.isEmpty()) {
                        Iterator iterator2 = appa.this.appt.iterator2();
                        while (iterator2.hasNext()) {
                            SdkThirdPlatform sdkThirdPlatform = (SdkThirdPlatform) iterator2.next();
                            DemandEntityHandle demandEntityHandle = new DemandEntityHandle(sdkThirdPlatform);
                            appa.this.f46695d.put(Integer.valueOf(sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotIdKey()), demandEntityHandle);
                            appa.this.f46692appa.appa(this, sdkThirdPlatform, demandEntityHandle);
                        }
                        appa.appa.appf.appd.appa(appa.f46689e, appa.this.appa("设置竞价代码位询价超时监测", Integer.valueOf(appa.this.appo)));
                        appa.this.f46691a = new appd(this);
                        appa.this.appb.postDelayed(appa.this.f46691a, appa.this.appo);
                    }
                }
                if (appa.this.appu == null || appa.this.appu.isEmpty()) {
                    return;
                }
                Iterator iterator22 = appa.this.appu.iterator2();
                while (iterator22.hasNext()) {
                    SdkThirdPlatform sdkThirdPlatform2 = (SdkThirdPlatform) iterator22.next();
                    DemandEntityHandle demandEntityHandle2 = new DemandEntityHandle(sdkThirdPlatform2);
                    appa.this.f46695d.put(Integer.valueOf(sdkThirdPlatform2.getSdkThirdAdslotConfig().getThirdSlotIdKey()), demandEntityHandle2);
                    appa.this.f46692appa.appa(this, sdkThirdPlatform2, demandEntityHandle2);
                }
                appa.appa.appf.appd.appa(appa.f46689e, appa.this.appa("设置标准代码位单轮请求超时监测", Integer.valueOf(appa.this.appn)));
                appa.this.f46693b = new appe(this);
                appa.this.appb.postDelayed(appa.this.f46693b, appa.this.appn);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe(appa.f46689e, appa.this.appa("需求方执行出错", th.toString()));
            }
        }

        public void appa(SdkThirdPlatform sdkThirdPlatform, appa.appa.appa.appa appaVar, DemandEntityHandle demandEntityHandle) {
            try {
                Object[] objArr = new Object[2];
                objArr[0] = appa.f46689e;
                appa appaVar2 = appa.this;
                Object[] objArr2 = new Object[5];
                objArr2[0] = "需求方执行成功:";
                objArr2[1] = sdkThirdPlatform.getName();
                objArr2[2] = sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotId();
                objArr2[3] = sdkThirdPlatform.getSdkThirdAdslotConfig().getBiddingType() == 2 ? "竞价" : "标准";
                objArr2[4] = sdkThirdPlatform.getSdkThirdAdslotConfig().getSortType() == 1 ? "兜底" : "按价格";
                objArr[1] = appaVar2.appa(objArr2);
                appa.appa.appf.appd.appc(objArr);
                if (sdkThirdPlatform.getSdkThirdAdslotConfig().getBiddingType() == 2) {
                    demandEntityHandle.setStatus(2);
                    int dspPrice = appaVar.getDspPrice();
                    if (appa.this.appb(dspPrice, demandEntityHandle, sdkThirdPlatform)) {
                        return;
                    }
                    double gapRatio = sdkThirdPlatform.getSdkThirdAdslotConfig().getGapRatio();
                    double priceRatio = sdkThirdPlatform.getSdkThirdAdslotConfig().getPriceRatio();
                    demandEntityHandle.setDspBidPrice(dspPrice);
                    demandEntityHandle.setClientBidPrice((int) Math.round(dspPrice * gapRatio * priceRatio));
                    if (!TextUtils.equals("api", sdkThirdPlatform.getClassType())) {
                        appa.this.appa(sdkThirdPlatform, dspPrice, demandEntityHandle);
                    } else {
                        int mediaBidPrice = appaVar.getMediaBidPrice();
                        if (appa.this.appb(mediaBidPrice, demandEntityHandle, sdkThirdPlatform)) {
                            return;
                        }
                        demandEntityHandle.setStatus(3);
                        demandEntityHandle.setMediaBidPrice(mediaBidPrice);
                        demandEntityHandle.setCacheTime(appaVar.getAdCacheTime());
                        demandEntityHandle.setExpireTime(appaVar.getExpireTime());
                        demandEntityHandle.setCrid(appaVar.getCrid());
                        demandEntityHandle.setDemandSlotIdKey(appaVar.getThirdSlotIdKey());
                        demandEntityHandle.setWinReportUrl(appaVar.getWinReportUrl());
                        appa.this.appa(appaVar.getInValidCrids());
                        appa.this.appa(1, demandEntityHandle, sdkThirdPlatform);
                    }
                } else {
                    appa.appf(appa.this);
                    demandEntityHandle.setStatus(3);
                    appa.this.appa(1, demandEntityHandle, sdkThirdPlatform);
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appe(appa.f46689e, "需求方处理失败(onAdRespSuccess):" + th);
            }
        }

        public void appa(SdkThirdPlatform sdkThirdPlatform, String str, DemandEntityHandle demandEntityHandle, List<String> list) {
            try {
                Object[] objArr = new Object[2];
                objArr[0] = appa.f46689e;
                appa appaVar = appa.this;
                Object[] objArr2 = new Object[5];
                objArr2[0] = "需求方执行失败";
                objArr2[1] = sdkThirdPlatform.getName();
                objArr2[2] = sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotId();
                objArr2[3] = sdkThirdPlatform.getSdkThirdAdslotConfig().getBiddingType() == 2 ? "竞价" : "标准";
                objArr2[4] = sdkThirdPlatform.getSdkThirdAdslotConfig().getSortType() == 1 ? "兜底" : "按价格";
                objArr[1] = appaVar.appa(objArr2);
                appa.appa.appf.appd.appe(objArr);
                if (appa.this.appb(sdkThirdPlatform)) {
                    appa.this.appw.put(sdkThirdPlatform);
                    appa.this.f46692appa.appa(this, sdkThirdPlatform, demandEntityHandle);
                    return;
                }
                if (TextUtils.equals("api", sdkThirdPlatform.getClassType())) {
                    appa.this.appa(list);
                }
                demandEntityHandle.setStatus(1);
                demandEntityHandle.setError(str);
                appa.this.appa(2, demandEntityHandle, sdkThirdPlatform);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe(appa.f46689e, "需求方处理失败(onAdRespFailed):" + th);
            }
        }

        public boolean appa(SdkThirdPlatform sdkThirdPlatform) {
            return appa.this.appa(sdkThirdPlatform);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: AdDispatcherManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appd implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        appc f46699appa;

        public appd(appc appcVar) {
            this.f46699appa = appcVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            appa.this.appa(this.f46699appa, 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: AdDispatcherManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appe implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        appc f46700appa;

        public appe(appc appcVar) {
            this.f46700appa = appcVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            appa.this.appa(this.f46700appa, 2);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: AdDispatcherManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public interface appf {
        void appa(appc appcVar, SdkThirdPlatform sdkThirdPlatform, DemandEntityHandle demandEntityHandle);

        void appa(DemandEntityHandle demandEntityHandle);

        void appa(SdkThirdPlatform sdkThirdPlatform);

        void appa(SdkTrackEventBean.TrackEventEnum trackEventEnum, String str, String str2);

        void appa(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: AdDispatcherManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appg implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        appc f46701appa;

        public appg(appc appcVar) {
            this.f46701appa = appcVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            appa.this.appa(this.f46701appa, 1);
        }
    }

    public appa(Context context, String str, List<SdkThirdPlatform> list, SdkAdSlotConfig sdkAdSlotConfig, appf appfVar) {
        this.appf = false;
        this.appg = false;
        this.appm = 5000;
        this.appn = 5000;
        this.appo = 5000;
        this.appp = 1;
        this.appq = 3;
        this.appr = false;
        this.apps = 0;
        this.appl = str;
        this.f46692appa = appfVar;
        if (sdkAdSlotConfig != null) {
            try {
                this.appp = sdkAdSlotConfig.getRequestType();
                this.appq = sdkAdSlotConfig.getRequestAdNumber();
                this.appm = sdkAdSlotConfig.getAdslotIdRequestTime();
                this.appn = sdkAdSlotConfig.getSingleRequetsTime();
                this.appo = sdkAdSlotConfig.getQueryPriceTime();
                this.appr = sdkAdSlotConfig.getRequestFailRetry() == 1;
                if (sdkAdSlotConfig.getOptimization() != null && sdkAdSlotConfig.getOptimization().getAdCache() != null) {
                    this.apps = sdkAdSlotConfig.getOptimization().getAdCache().getCacheCount();
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appe(f46689e, appa("代码位部分配置无效，使用默认值", th.toString()));
            }
        }
        this.appw = new ArrayBlockingQueue<>(list.size());
        this.appx = new ArrayBlockingQueue<>(list.size());
        this.appy = new ArrayBlockingQueue<>(list.size());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SdkThirdPlatform sdkThirdPlatform : list) {
            if (sdkThirdPlatform.getSdkThirdAdslotConfig().getSortType() == 1) {
                appa.appa.appf.appd.appa(f46689e, appa("兜底"));
                sdkThirdPlatform.setRequestIndex(-1);
                arrayList.add(sdkThirdPlatform);
            } else if (sdkThirdPlatform.getSdkThirdAdslotConfig().getBiddingType() == 2) {
                appa.appa.appf.appd.appa(f46689e, appa("竞价"));
                arrayList.add(sdkThirdPlatform);
            } else {
                appa.appa.appf.appd.appa(f46689e, appa("标准-按价格"));
                arrayList2.add(sdkThirdPlatform);
            }
        }
        if (!arrayList.isEmpty()) {
            this.appf = true;
            this.appt = new ArrayBlockingQueue<>(arrayList.size());
            this.appt.addAll(arrayList);
        }
        if (!arrayList2.isEmpty()) {
            this.appg = true;
            this.appv = new ArrayBlockingQueue<>(arrayList2.size());
            appc(arrayList2);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.appj = currentTimeMillis;
        this.appi = currentTimeMillis;
        Object[] objArr = new Object[2];
        objArr[0] = f46689e;
        Object[] objArr2 = new Object[4];
        objArr2[0] = "【竞价&兜底】需求方个数";
        ArrayBlockingQueue<SdkThirdPlatform> arrayBlockingQueue = this.appt;
        objArr2[1] = Integer.valueOf(arrayBlockingQueue != null ? arrayBlockingQueue.size() : 0);
        objArr2[2] = "【标准&按价格】需求方个数";
        ArrayBlockingQueue<SdkThirdPlatform> arrayBlockingQueue2 = this.appv;
        objArr2[3] = Integer.valueOf(arrayBlockingQueue2 != null ? arrayBlockingQueue2.size() : 0);
        objArr[1] = appa(objArr2);
        appa.appa.appf.appd.appc(objArr);
    }

    static /* synthetic */ int appf(appa appaVar) {
        int i10 = appaVar.appk;
        appaVar.appk = i10 + 1;
        return i10;
    }

    private void appc(SdkThirdPlatform sdkThirdPlatform) {
        if (sdkThirdPlatform.getSdkThirdAdslotConfig().getBiddingType() != 2 && sdkThirdPlatform.getSdkThirdAdslotConfig().getSortType() != 1) {
            this.appu.remove(sdkThirdPlatform);
            if (this.appu.isEmpty()) {
                appa.appa.appf.appd.appa(f46689e, appa("本轮执行中的【标准&按价格】需求方已全部执行完毕"));
                appe appeVar = this.f46693b;
                if (appeVar != null) {
                    this.appb.removeCallbacks(appeVar);
                }
                this.appe = true;
            } else {
                appa.appa.appf.appd.appa(f46689e, appa("本轮执行中的【标准&按价格】需求方还有", Integer.valueOf(this.appu.size()), "条未执行完，继续等待"));
            }
        } else {
            this.appt.remove(sdkThirdPlatform);
            if (this.appt.isEmpty()) {
                appa.appa.appf.appd.appa(f46689e, appa("执行中【竞价&兜底】需求方已全部执行完毕"));
                appd appdVar = this.f46691a;
                if (appdVar != null) {
                    this.appb.removeCallbacks(appdVar);
                }
                this.appd = true;
            } else {
                appa.appa.appf.appd.appa(f46689e, appa("执行中的【竞价&兜底】需求方还有", Integer.valueOf(this.appt.size()), "条未执行完，继续等待"));
            }
        }
        appf();
    }

    private int appd() {
        int i10;
        int i11;
        Iterator<SdkThirdPlatform> iterator2 = this.appv.iterator2();
        if (iterator2.hasNext()) {
            i11 = (int) (iterator2.next().getSdkThirdAdslotConfig().getDspBidPrice() * 100.0d);
            i10 = 1;
        } else {
            i10 = 0;
            i11 = -1;
        }
        while (iterator2.hasNext() && i11 == ((int) (iterator2.next().getSdkThirdAdslotConfig().getDspBidPrice() * 100.0d))) {
            i10++;
        }
        return i10;
    }

    private void appe() {
        ArrayBlockingQueue<DemandEntityHandle> arrayBlockingQueue = this.appx;
        if (arrayBlockingQueue != null && !arrayBlockingQueue.isEmpty()) {
            Iterator<DemandEntityHandle> iterator2 = this.appx.iterator2();
            while (iterator2.hasNext()) {
                DemandEntityHandle next = iterator2.next();
                appa.appa.appf.appd.appa(f46689e, appa("销毁执行失败的需求方", next.getDemandName(), next.getDemandAdSlotId()));
                next.onDestroy();
            }
        }
        apph();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void appf() {
        /*
            r9 = this;
            boolean r0 = r9.appg
            if (r0 == 0) goto L8
            boolean r0 = r9.appe
            if (r0 != 0) goto L10
        L8:
            boolean r0 = r9.appg
            if (r0 != 0) goto Laf
            boolean r0 = r9.appd
            if (r0 == 0) goto Laf
        L10:
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = r9.appi
            int r4 = r9.appm
            long r4 = (long) r4
            long r2 = r2 + r4
            r4 = 1
            r5 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 < 0) goto L25
            java.lang.String r0 = "【媒体代码位总请求时间超时】"
        L22:
            r1 = r0
            r0 = 0
            goto L3f
        L25:
            java.util.concurrent.ArrayBlockingQueue<com.wangmai.common.bean.SdkThirdPlatform> r0 = r9.appv
            if (r0 == 0) goto L3c
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L30
            goto L3c
        L30:
            int r0 = r9.appk
            if (r0 < r4) goto L37
            java.lang.String r0 = "【标准代码位已返回媒体需要数量的广告】"
            goto L22
        L37:
            java.lang.String r0 = ""
            r1 = r0
            r0 = 1
            goto L3f
        L3c:
            java.lang.String r0 = "【已就绪标准代码位队列为空】"
            goto L22
        L3f:
            if (r0 == 0) goto L45
            r9.appa()
            goto Laf
        L45:
            boolean r0 = r9.appf
            if (r0 == 0) goto L4d
            boolean r0 = r9.appd
            if (r0 == 0) goto Laf
        L4d:
            r0 = 2
            java.lang.Object[] r2 = new java.lang.Object[r0]
            java.lang.String r3 = com.wangmai.ad.dex.allmodules.appa.f46689e
            r2[r5] = r3
            r3 = 9
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r6 = "本次广告执行结束"
            r3[r5] = r6
            r3[r4] = r1
            java.lang.String r1 = "响应成功需求方个数"
            r3[r0] = r1
            r0 = 3
            java.util.concurrent.ArrayBlockingQueue<com.wangmai.ad.dex.allmodules.bean.DemandEntityHandle> r1 = r9.appy
            int r1 = r1.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3[r0] = r1
            r0 = 4
            java.lang.String r1 = "响应失败需求方个数"
            r3[r0] = r1
            r0 = 5
            java.util.concurrent.ArrayBlockingQueue<com.wangmai.ad.dex.allmodules.bean.DemandEntityHandle> r1 = r9.appx
            int r1 = r1.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3[r0] = r1
            r0 = 6
            java.lang.String r1 = "媒体代码位响应总耗时"
            r3[r0] = r1
            r0 = 7
            long r5 = java.lang.System.currentTimeMillis()
            long r7 = r9.appi
            long r5 = r5 - r7
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            r3[r0] = r1
            r0 = 8
            java.lang.String r1 = "ms"
            r3[r0] = r1
            java.lang.String r0 = r9.appa(r3)
            r2[r4] = r0
            appa.appa.appf.appd.appc(r2)
            com.wangmai.ad.dex.allmodules.appa$appg r0 = r9.appz
            if (r0 == 0) goto Lac
            android.os.Handler r1 = r9.appb
            r1.removeCallbacks(r0)
        Lac:
            r9.appg()
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.ad.dex.allmodules.appa.appf():void");
    }

    private void appg() {
        ThreadUtils.runOnThreadPool(new appb());
    }

    private void apph() {
        ArrayBlockingQueue<SdkThirdPlatform> arrayBlockingQueue = this.appt;
        if (arrayBlockingQueue != null) {
            arrayBlockingQueue.clear();
            this.appt = null;
        }
        ArrayBlockingQueue<SdkThirdPlatform> arrayBlockingQueue2 = this.appu;
        if (arrayBlockingQueue2 != null) {
            arrayBlockingQueue2.clear();
            this.appu = null;
        }
        ArrayBlockingQueue<SdkThirdPlatform> arrayBlockingQueue3 = this.appv;
        if (arrayBlockingQueue3 != null) {
            arrayBlockingQueue3.clear();
            this.appv = null;
        }
        ArrayBlockingQueue<SdkThirdPlatform> arrayBlockingQueue4 = this.appw;
        if (arrayBlockingQueue4 != null) {
            arrayBlockingQueue4.clear();
            this.appw = null;
        }
        ArrayBlockingQueue<DemandEntityHandle> arrayBlockingQueue5 = this.appx;
        if (arrayBlockingQueue5 != null) {
            arrayBlockingQueue5.clear();
            this.appx = null;
        }
        ArrayBlockingQueue<DemandEntityHandle> arrayBlockingQueue6 = this.appy;
        if (arrayBlockingQueue6 != null) {
            arrayBlockingQueue6.clear();
            this.appy = null;
        }
    }

    private void appb(List<SdkThirdPlatform> list) {
        if (list != null) {
            try {
                if (list.size() <= f46690f.length) {
                    HashMap<String, SdkThirdPlatform> hashMap = new HashMap<>();
                    List<String> appa2 = appa(list, hashMap);
                    ArrayList arrayList = new ArrayList();
                    appa(arrayList, hashMap, appa2);
                    this.appv.addAll(arrayList);
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appe(f46689e, appa("权重排序异常", th.toString()));
                return;
            }
        }
        appa.appa.appf.appd.appe(f46689e, appa("不满足权重排序", list));
    }

    public void appa() {
        ArrayBlockingQueue<SdkThirdPlatform> arrayBlockingQueue;
        int i10;
        this.apph++;
        this.appj = System.currentTimeMillis();
        ArrayBlockingQueue<SdkThirdPlatform> arrayBlockingQueue2 = this.appt;
        if ((arrayBlockingQueue2 != null && !arrayBlockingQueue2.isEmpty()) || ((arrayBlockingQueue = this.appv) != null && !arrayBlockingQueue.isEmpty())) {
            ArrayBlockingQueue<SdkThirdPlatform> arrayBlockingQueue3 = this.appv;
            if (arrayBlockingQueue3 != null && !arrayBlockingQueue3.isEmpty()) {
                this.appe = false;
                int i11 = this.appp;
                if (i11 == 2) {
                    i10 = this.appq;
                    appa.appa.appf.appd.appc(f46689e, appa("当前请求轮次", Integer.valueOf(this.apph), "并发类型为【固定数量】", "本轮并发数量为", Integer.valueOf(i10)));
                } else if (i11 != 3) {
                    i10 = this.appv.size();
                    appa.appa.appf.appd.appc(f46689e, appa("当前请求轮次", Integer.valueOf(this.apph), "并发类型为【请求加速器】", "本轮并发数量为", Integer.valueOf(i10)));
                } else {
                    i10 = appd();
                    appa.appa.appf.appd.appc(f46689e, appa("当前请求轮次", Integer.valueOf(this.apph), "并发类型为【按相同价格】", "本轮并发数量为", Integer.valueOf(i10)));
                }
                if (i10 <= 0) {
                    this.f46692appa.appa("广告请求失败，无效并发数量(" + this.appp + "," + this.appq + ")");
                    return;
                }
                if (this.appv.size() > i10) {
                    appa.appa.appf.appd.appa(f46689e, appa("已就绪标准代码位数量【大于】并发数量，从已就绪标准代码位队列中移出", Integer.valueOf(i10), "条需求方至运行中标准代码位队列内"));
                    this.appu = new ArrayBlockingQueue<>(i10);
                    for (int i12 = 0; i12 < i10; i12++) {
                        this.appu.offer(this.appv.poll());
                    }
                } else {
                    appa.appa.appf.appd.appa(f46689e, appa("已就绪标准代码位数量【小于等于】并发数量，全部添加到运行中标准代码位队列，同时清空已就绪标准代码位队列"));
                    this.appu = new ArrayBlockingQueue<>(this.appv.size());
                    this.appu.addAll(this.appv);
                    this.appv.clear();
                }
                appa.appa.appf.appd.appa(f46689e, appa("已就绪标准代码位还剩余", Integer.valueOf(this.appv.size()), "条需求方待执行"));
            }
            new appc().run();
            return;
        }
        this.f46692appa.appa("广告请求失败，暂无可用需求方配置");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean appb(SdkThirdPlatform sdkThirdPlatform) {
        ArrayBlockingQueue<SdkThirdPlatform> arrayBlockingQueue = this.appw;
        boolean z10 = (arrayBlockingQueue == null || arrayBlockingQueue.isEmpty() || !this.appw.contains(sdkThirdPlatform)) ? false : true;
        boolean z11 = (!this.appr || z10 || (sdkThirdPlatform.getSdkThirdAdslotConfig().getBiddingType() == 2 || sdkThirdPlatform.getSdkThirdAdslotConfig().getSortType() == 1 ? ((System.currentTimeMillis() - this.appi) > ((long) this.appo) ? 1 : ((System.currentTimeMillis() - this.appi) == ((long) this.appo) ? 0 : -1)) > 0 : ((System.currentTimeMillis() - this.appj) > ((long) this.appn) ? 1 : ((System.currentTimeMillis() - this.appj) == ((long) this.appn) ? 0 : -1)) > 0)) ? false : true;
        if (z11) {
            appa.appa.appf.appd.appe(f46689e, appa("发起失败重试"));
        } else if (!this.appr) {
            appa.appa.appf.appd.appe(f46689e, appa("需求方执行失败放弃重试（媒体未开启失败重试）"));
        } else if (z10) {
            appa.appa.appf.appd.appe(f46689e, appa("需求方执行失败放弃重试（需求方已执行过重试）"));
        } else {
            appa.appa.appf.appd.appe(f46689e, appa("需求方执行失败放弃重试（需求方请求超时）"));
        }
        return z11;
    }

    private void appc(List<SdkThirdPlatform> list) {
        Collections.sort(list, new appj());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (SdkThirdPlatform sdkThirdPlatform : list) {
            int dspBidPrice = (int) (sdkThirdPlatform.getSdkThirdAdslotConfig().getDspBidPrice() * 100.0d);
            List list2 = (List) linkedHashMap.get(Integer.valueOf(dspBidPrice));
            if (list2 == null || list2.isEmpty()) {
                list2 = new ArrayList();
            }
            list2.add(sdkThirdPlatform);
            linkedHashMap.put(Integer.valueOf(dspBidPrice), list2);
        }
        Iterator iterator2 = linkedHashMap.entrySet().iterator2();
        while (iterator2.hasNext()) {
            List<SdkThirdPlatform> list3 = (List) ((Map.Entry) iterator2.next()).getValue();
            if (list3.size() > 1) {
                appb(list3);
            } else {
                this.appv.addAll(list3);
            }
        }
        Iterator<SdkThirdPlatform> iterator22 = this.appv.iterator2();
        int i10 = 0;
        while (iterator22.hasNext()) {
            i10++;
            SdkThirdPlatform next = iterator22.next();
            next.setRequestIndex(i10);
            appa.appa.appf.appd.appa(f46689e, appa("最终排序标准需求方:", Integer.valueOf(next.getRequestIndex()), Integer.valueOf(next.getSdkThirdAdslotConfig().getWeightRatio()), Double.valueOf(next.getSdkThirdAdslotConfig().getDspBidPrice()), next.getName(), next.getSdkThirdAdslotConfig().getThirdSlotId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean appb(int i10, DemandEntityHandle demandEntityHandle, SdkThirdPlatform sdkThirdPlatform) {
        if (i10 > 0) {
            return false;
        }
        String str = "需求方价格无效(" + sdkThirdPlatform.getName() + "," + sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotId() + "," + i10 + ")";
        appa.appa.appf.appd.appe(f46689e, appa(str));
        demandEntityHandle.setError(str);
        appa(2, demandEntityHandle, sdkThirdPlatform);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appa(int i10, DemandEntityHandle demandEntityHandle, SdkThirdPlatform sdkThirdPlatform) {
        try {
            if (i10 == 2) {
                this.appx.offer(demandEntityHandle);
            } else {
                this.appy.offer(demandEntityHandle);
            }
            appc(sdkThirdPlatform);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46689e, "需求方处理失败(collectRespDemand):" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appa(appc appcVar, int i10) {
        try {
            if (i10 == 1) {
                if (this.appt != null && !this.appt.isEmpty()) {
                    appa(appcVar, this.appt.iterator2());
                }
                if (this.appu == null || this.appu.isEmpty()) {
                    return;
                }
                appa(appcVar, this.appu.iterator2());
                return;
            }
            if (i10 == 2) {
                if (this.appu == null || this.appu.isEmpty()) {
                    return;
                }
                appa(appcVar, this.appu.iterator2());
                return;
            }
            if (i10 != 3) {
                appa.appa.appf.appd.appe(f46689e, appa("未知超时类型"));
            } else {
                if (this.appt == null || this.appt.isEmpty()) {
                    return;
                }
                appa(appcVar, this.appt.iterator2());
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46689e, appa("处理超时任务异常", th.toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appc() {
        DemandEntityHandle poll;
        DemandEntityHandle demandEntityHandle = null;
        try {
            if (this.f46694c != null && !this.f46694c.isEmpty()) {
                Collections.sort(this.f46694c, new com.wangmai.ad.dex.allmodules.utils.appe(2));
                appa.appa.appf.appd.appa(f46689e, appa("竞价排序后", this.f46694c));
                if (this.apps > 0) {
                    com.wangmai.ad.dex.allmodules.appd.appa.appa().appa(this.appl, this.f46694c, "竞价完成，更新缓存");
                } else {
                    for (int size = this.f46694c.size() - 1; size > 0; size--) {
                        DemandEntityHandle demandEntityHandle2 = this.f46694c.get(size);
                        appa.appa.appf.appd.appe(f46689e, appa("媒体未开启缓存，销毁非竟胜方", demandEntityHandle2));
                        demandEntityHandle2.onDestroy();
                    }
                }
                demandEntityHandle = this.f46694c.get(0);
                this.f46692appa.appa(demandEntityHandle);
                appa(demandEntityHandle);
                this.f46695d.clear();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("需求方广告请求失败:");
            sb2.append(this.appl);
            if (this.appx != null && !this.appx.isEmpty() && (poll = this.appx.poll()) != null) {
                sb2.append(",");
                sb2.append(poll.getError());
            }
            this.f46692appa.appa(sb2.toString());
            appa(demandEntityHandle);
            this.f46695d.clear();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void appa(appc appcVar, Iterator<SdkThirdPlatform> it) {
        while (it.hasNext()) {
            try {
                SdkThirdPlatform next = it.next();
                appcVar.appb(next);
                this.f46692appa.appa(next);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe(f46689e, appa("处理超时需求方失败", th.toString()));
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appa(SdkThirdPlatform sdkThirdPlatform, int i10, DemandEntityHandle demandEntityHandle) {
        try {
            com.wangmai.ad.dex.allmodules.appc.appb.appa(this.appl, sdkThirdPlatform.getSdkThirdAdslotConfig().getThirdSlotIdKey(), i10, new C0674appa(sdkThirdPlatform, i10, demandEntityHandle));
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46689e, appa("获取媒体结算价失败", th.toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appa(double d10) {
        try {
            appa.appa.appf.appd.appa(f46689e, appa("执行中竞价需求方返回了价格", Double.valueOf(d10), "遍历已就绪的标准代码位队列，移除比他价格低的标准需求方"));
            if (this.appv != null) {
                Iterator<SdkThirdPlatform> iterator2 = this.appv.iterator2();
                while (iterator2.hasNext()) {
                    SdkThirdPlatform next = iterator2.next();
                    if (next.getSdkThirdAdslotConfig().getDspBidPrice() * 100.0d < d10) {
                        this.appv.remove(next);
                        appa.appa.appf.appd.appa(f46689e, appa("移除已就绪标准代码位队列中低价需求方(", next.getSdkThirdAdslotConfig().getThirdSlotId(), Double.valueOf(next.getSdkThirdAdslotConfig().getDspBidPrice()), ")"));
                    }
                }
                appa.appa.appf.appd.appa(f46689e, appa("已就绪队列中还剩(", Integer.valueOf(this.appv.size()), ")条标准代码位待执行"));
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46689e, appa("移除无效API需求方失败", th.toString()));
        }
    }

    private List<String> appa(List<SdkThirdPlatform> list, HashMap<String, SdkThirdPlatform> hashMap) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            for (int i11 = 0; i11 < list.get(i10).getSdkThirdAdslotConfig().getWeightRatio(); i11++) {
                if (!hashMap.containsKey(f46690f[i10])) {
                    hashMap.put(f46690f[i10], list.get(i10));
                }
                arrayList.add(f46690f[i10]);
            }
        }
        return arrayList;
    }

    private void appa(List<SdkThirdPlatform> list, HashMap<String, SdkThirdPlatform> hashMap, List<String> list2) {
        if (list2 != null) {
            try {
                if (list2.isEmpty()) {
                    return;
                }
                String str = list2.get(new Random().nextInt(list2.size()));
                if (hashMap.containsKey(str)) {
                    list.add(hashMap.get(str));
                    for (int size = list2.size() - 1; size >= 0; size--) {
                        if (str.equals(list2.get(size))) {
                            list2.remove(size);
                        }
                    }
                    appa(list, hashMap, list2);
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appe(f46689e, appa("从随机源中获取数据失败", th.toString()));
            }
        }
    }

    private void appa(DemandEntityHandle demandEntityHandle) {
        if (demandEntityHandle != null) {
            if (this.f46694c.size() > 1) {
                DemandEntityHandle demandEntityHandle2 = this.f46694c.get(1);
                if (demandEntityHandle.getBiddingType() == 2) {
                    appa(demandEntityHandle.getSdkProcesser(), demandEntityHandle.getDspBidPrice(), demandEntityHandle2.getDspBidPrice());
                }
                this.f46694c.addAll(this.appx);
                for (int i10 = 1; i10 < this.f46694c.size(); i10++) {
                    DemandEntityHandle demandEntityHandle3 = this.f46694c.get(i10);
                    if (demandEntityHandle3 != null && demandEntityHandle3.getSdkProcesser() != null && demandEntityHandle3.getBiddingType() == 2) {
                        appa(demandEntityHandle3, demandEntityHandle);
                    }
                }
            }
        }
        this.f46694c.clear();
        appe();
    }

    private void appa(appa.appa.appa.appa appaVar, int i10, int i11) {
        try {
            appaVar.sendWinNotification(String.valueOf(i10), String.valueOf(i11));
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46689e, appa("SDK需求方竞胜上报失败:", th.toString()));
        }
    }

    private void appa(DemandEntityHandle demandEntityHandle, DemandEntityHandle demandEntityHandle2) {
        try {
            String str = "time_out";
            if (demandEntityHandle.getStatus() == 3) {
                str = demandEntityHandle.getDspBidPrice() > 0 ? ConstantInfo.BID_FAILED : ConstantInfo.BID_FAILED_MISSING_PRICE;
            } else {
                String error = demandEntityHandle.getError();
                if (error == null || !error.contains("time_out")) {
                    str = error;
                }
            }
            demandEntityHandle.getSdkProcesser().sendLossNotification(str, String.valueOf(demandEntityHandle2.getDspBidPrice()), demandEntityHandle2.getDemandClassType());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46689e, appa("SDK需求方竞败上报失败:", th.toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appa(List<String> list) {
        if (this.apps <= 0 || list == null || list.isEmpty()) {
            return;
        }
        synchronized (this) {
            try {
                List<DemandEntityHandle> appa2 = com.wangmai.ad.dex.allmodules.appd.appa.appa().appa(this.appl, "API需求方执行返回");
                if (appa2 != null && appa2.size() > 0) {
                    for (String str : list) {
                        for (int size = appa2.size() - 1; size >= 0; size--) {
                            if (str.equals(appa2.get(size).getCrid())) {
                                appa.appa.appf.appd.appe(f46689e, appa("销毁无效API缓存", appa2.get(size)));
                                appa2.get(size).onDestroy();
                                appa2.remove(size);
                            }
                        }
                    }
                }
            } finally {
            }
        }
    }

    public boolean appa(SdkThirdPlatform sdkThirdPlatform) {
        if (sdkThirdPlatform.getSdkThirdAdslotConfig().getBiddingType() != 2 && sdkThirdPlatform.getSdkThirdAdslotConfig().getSortType() != 1) {
            ArrayBlockingQueue<SdkThirdPlatform> arrayBlockingQueue = this.appu;
            return arrayBlockingQueue != null && arrayBlockingQueue.contains(sdkThirdPlatform);
        }
        ArrayBlockingQueue<SdkThirdPlatform> arrayBlockingQueue2 = this.appt;
        return arrayBlockingQueue2 != null && arrayBlockingQueue2.contains(sdkThirdPlatform);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String appa(Object... objArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("【");
        sb2.append(this.appc);
        sb2.append("】");
        for (Object obj : objArr) {
            sb2.append(obj);
            sb2.append("->");
        }
        return sb2.substring(0, sb2.toString().length() - 2);
    }
}
