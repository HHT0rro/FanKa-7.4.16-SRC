package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.alimm.tanx.core.view.player.cache.PreloadManager;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.core.video.j;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.i;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class SplashPreloadManager {
    private HashMap<String, PreLoadItem> Cm;
    private List<String> Cn;
    private volatile SharedPreferences Co;
    private final Object mLock;

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class PreLoadItem extends com.kwad.sdk.core.response.a.a implements Serializable {
        public long cacheTime;
        public long expiredTime;
        public String preloadId;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {
        private static final SplashPreloadManager Cp = new SplashPreloadManager(0);
    }

    public /* synthetic */ SplashPreloadManager(byte b4) {
        this();
    }

    public static File T(String str) {
        if (str == null) {
            return null;
        }
        com.kwad.sdk.core.e.c.d(PreloadManager.TAG, "getVideoFile preloadId " + str + "  url " + str);
        File bV = com.kwad.sdk.core.diskcache.b.a.Dc().bV(str);
        if (bV == null || !bV.exists()) {
            return null;
        }
        return bV;
    }

    @AnyThread
    public static boolean f(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.b.a.bd(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    @AnyThread
    public static boolean g(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.b.a.bc(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    private void init() {
        Context context = ServiceProvider.getContext();
        if (context != null) {
            this.Co = context.getSharedPreferences("ksadsdk_splash_preload_id_list", 0);
            initData();
        }
    }

    private void initData() {
        Map<String, ?> all = this.Co.getAll();
        ArrayList arrayList = new ArrayList();
        for (String str : all.h()) {
            PreLoadItem preLoadItem = new PreLoadItem();
            try {
                Object obj = all.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (TextUtils.isEmpty(str2)) {
                        continue;
                    } else {
                        preLoadItem.parseJson(new JSONObject(str2));
                        if (TextUtils.isEmpty(preLoadItem.preloadId)) {
                            continue;
                        } else {
                            File bV = com.kwad.sdk.core.diskcache.b.a.Dc().bV(preLoadItem.preloadId);
                            if (bV != null && bV.exists()) {
                                synchronized (this.mLock) {
                                    this.Cm.put(str, preLoadItem);
                                    if (!this.Cn.contains(str)) {
                                        this.Cn.add(str);
                                    }
                                }
                            } else {
                                arrayList.add(preLoadItem.preloadId);
                                com.kwad.sdk.core.e.c.d(PreloadManager.TAG, "Remove null file list " + preLoadItem.preloadId);
                            }
                        }
                    }
                } else {
                    continue;
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.e.c.printStackTrace(e2);
            }
        }
        SharedPreferences.Editor edit = this.Co.edit();
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            edit.remove((String) iterator2.next());
        }
        edit.apply();
    }

    private void kx() {
        int size;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.mLock) {
            ArrayList<String> arrayList = new ArrayList();
            for (String str : this.Cm.h()) {
                PreLoadItem preLoadItem = this.Cm.get(str);
                if (preLoadItem != null && preLoadItem.expiredTime < currentTimeMillis) {
                    arrayList.add(str);
                }
            }
            SharedPreferences.Editor edit = this.Co.edit();
            for (String str2 : arrayList) {
                this.Cn.remove(str2);
                this.Cm.remove(str2);
                edit.remove(str2);
                com.kwad.sdk.core.diskcache.b.a.Dc().remove(str2);
            }
            edit.apply();
            size = this.Cn.size();
        }
        if (size > 30) {
            com.kwad.sdk.core.e.c.d(PreloadManager.TAG, "大于 30 按失效日期远近顺序移除");
            int i10 = size - 15;
            for (int i11 = 0; i11 < i10; i11++) {
                long j10 = Long.MAX_VALUE;
                String str3 = "";
                synchronized (this.mLock) {
                    for (PreLoadItem preLoadItem2 : this.Cm.values()) {
                        long j11 = preLoadItem2.expiredTime;
                        if (j11 < j10) {
                            str3 = preLoadItem2.preloadId;
                            j10 = j11;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        this.Cn.remove(str3);
                        this.Cm.remove(str3);
                        this.Co.edit().remove(str3).apply();
                        com.kwad.sdk.core.e.c.d(PreloadManager.TAG, "移除 preloadId = " + str3 + " expiredTime =  " + j10);
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    com.kwad.sdk.core.diskcache.b.a.Dc().remove(str3);
                }
            }
        }
    }

    @AnyThread
    public static SplashPreloadManager ky() {
        SplashPreloadManager splashPreloadManager = a.Cp;
        if (splashPreloadManager.Co == null) {
            splashPreloadManager.init();
        }
        return splashPreloadManager;
    }

    @AnyThread
    private void o(AdInfo adInfo) {
        PreLoadItem preLoadItem = new PreLoadItem();
        preLoadItem.cacheTime = System.currentTimeMillis();
        preLoadItem.expiredTime = System.currentTimeMillis() + (adInfo.adPreloadInfo.validityPeriod * 1000);
        preLoadItem.preloadId = com.kwad.sdk.core.response.b.a.aZ(adInfo);
        synchronized (this.mLock) {
            this.Cm.put(adInfo.adPreloadInfo.preloadId, preLoadItem);
            if (!this.Cn.contains(adInfo.adPreloadInfo.preloadId)) {
                this.Cn.add(adInfo.adPreloadInfo.preloadId);
            }
        }
        if (this.Co != null) {
            SharedPreferences.Editor edit = this.Co.edit();
            edit.putString(adInfo.adPreloadInfo.preloadId, preLoadItem.toJson().toString());
            edit.apply();
        }
    }

    private static boolean p(AdInfo adInfo) {
        return com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CQ) && com.kwad.sdk.core.response.b.a.bd(adInfo);
    }

    @AnyThread
    private boolean q(AdInfo adInfo) {
        if (p(adInfo)) {
            return KSImageLoader.isImageExist(com.kwad.sdk.core.response.b.a.aU(adInfo).materialUrl);
        }
        String str = adInfo.adPreloadInfo.preloadId;
        if (str != null) {
            File bV = com.kwad.sdk.core.diskcache.b.a.Dc().bV(str);
            StringBuilder sb2 = new StringBuilder("check preloadId ");
            sb2.append(str);
            sb2.append(" file exists ");
            sb2.append(bV == null ? "null" : Boolean.valueOf(bV.exists()));
            com.kwad.sdk.core.e.c.d(PreloadManager.TAG, sb2.toString());
            if (bV != null && bV.exists()) {
                return true;
            }
        }
        return false;
    }

    public final List<String> R() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            com.kwad.sdk.core.e.c.d(PreloadManager.TAG, "getPreloadIdList start ");
            for (int i10 = 0; i10 < this.Cn.size(); i10++) {
                String str = this.Cn.get(i10);
                File bV = com.kwad.sdk.core.diskcache.b.a.Dc().bV(str);
                if (bV != null && bV.exists()) {
                    arrayList.add(str);
                }
            }
            com.kwad.sdk.core.e.c.d(PreloadManager.TAG, "getPreloadIdList end ");
        }
        com.kwad.sdk.core.e.c.d(PreloadManager.TAG, "getPreloadIdList " + this.Cn.size());
        return arrayList;
    }

    @AnyThread
    public final int b(AdResultData adResultData, boolean z10) {
        String str;
        boolean a10;
        Iterator<AdTemplate> iterator2 = adResultData.getAdTemplateList().iterator2();
        com.kwad.components.ad.splashscreen.monitor.b.kV();
        com.kwad.components.ad.splashscreen.monitor.b.h(adResultData);
        int i10 = 0;
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            AdTemplate next = iterator2.next();
            if (next != null) {
                for (AdInfo adInfo : next.adInfoList) {
                    if (adInfo.adPreloadInfo != null && this.Co != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (!q(adInfo)) {
                            if (com.kwad.sdk.core.response.b.a.bc(adInfo)) {
                                str = com.kwad.sdk.core.response.b.a.K(adInfo);
                            } else {
                                str = com.kwad.sdk.core.response.b.a.bd(adInfo) ? com.kwad.sdk.core.response.b.a.aU(adInfo).materialUrl : null;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                String aZ = com.kwad.sdk.core.response.b.a.aZ(adInfo);
                                if (adInfo.adPreloadInfo.preloadType != 1 || ag.isWifiConnected(ServiceProvider.getContext()) || z10) {
                                    com.kwad.sdk.core.e.c.d(PreloadManager.TAG, "start Download preloadId " + aZ + " true url " + str);
                                    kx();
                                    a.C0527a c0527a = new a.C0527a();
                                    if (p(adInfo)) {
                                        a10 = KSImageLoader.loadImageSync(str) != null;
                                    } else {
                                        a10 = j.a(str, aZ, c0527a);
                                    }
                                    if (a10) {
                                        o(adInfo);
                                        i10++;
                                        com.kwad.components.ad.splashscreen.monitor.b.kV();
                                        com.kwad.components.ad.splashscreen.monitor.b.a(next, SystemClock.elapsedRealtime() - elapsedRealtime, 1);
                                    } else {
                                        com.kwad.components.ad.splashscreen.monitor.b.kV();
                                        com.kwad.components.ad.splashscreen.monitor.b.d(next, 4, c0527a.msg);
                                        com.kwad.components.core.o.a.qi().f(next, 1, c0527a.msg);
                                    }
                                } else {
                                    com.kwad.components.ad.splashscreen.monitor.b.kV();
                                    com.kwad.components.ad.splashscreen.monitor.b.d(next, 1, SplashMonitorInfo.ERROR_NET_MSG);
                                }
                            } else {
                                com.kwad.components.ad.splashscreen.monitor.b.kV();
                                com.kwad.components.ad.splashscreen.monitor.b.d(next, 2, SplashMonitorInfo.ERROR_URL_INVALID_MSG);
                            }
                        } else {
                            com.kwad.components.ad.splashscreen.monitor.b.kV();
                            com.kwad.components.ad.splashscreen.monitor.b.a(next, SystemClock.elapsedRealtime() - elapsedRealtime, 2);
                            o(adInfo);
                            i10++;
                        }
                    } else {
                        com.kwad.components.ad.splashscreen.monitor.b.kV();
                        com.kwad.components.ad.splashscreen.monitor.b.d(next, 3, SplashMonitorInfo.ERROR_PRELOAD_ID_INVALID_MSG);
                    }
                }
            }
        }
        AdTemplate adTemplate = adResultData.getAdTemplateList().size() > 0 ? adResultData.getAdTemplateList().get(0) : null;
        if (i10 > 0) {
            i.ap("splashAd_", "onSplashVideoAdCacheSuccess");
            com.kwad.components.core.o.a.qi().e(adTemplate, i10);
        } else {
            i.ap("splashAd_", "onSplashVideoAdCacheFailed");
        }
        return i10;
    }

    @AnyThread
    public final boolean e(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                AdInfo adInfo = adTemplate.adInfoList.get(0);
                if (adInfo.adPreloadInfo != null) {
                    if (p(adInfo)) {
                        return KSImageLoader.isImageExist(com.kwad.sdk.core.response.b.a.aU(adInfo).materialUrl);
                    }
                    return q(adInfo);
                }
            }
        }
        return false;
    }

    private SplashPreloadManager() {
        this.mLock = new Object();
        this.Cm = new HashMap<>();
        this.Cn = new ArrayList();
        init();
    }
}
