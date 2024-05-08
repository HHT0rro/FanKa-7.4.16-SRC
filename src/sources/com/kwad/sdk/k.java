package com.kwad.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.kwad.components.core.request.g;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.loader.DynamicInstallReceiver;
import com.kwad.sdk.api.proxy.BaseProxyActivity;
import com.kwad.sdk.api.proxy.BaseProxyFragmentActivity;
import com.kwad.sdk.api.proxy.IComponentProxy;
import com.kwad.sdk.commercial.b;
import com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bk;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.y;
import java.io.File;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class k {
    private long YZ;
    private volatile boolean akT;
    private String akU;
    private int akV;
    private boolean akW;

    @Nullable
    private KsLoadManager akX;
    private long akY;
    private volatile boolean akZ;
    private boolean ala;
    private boolean alb;
    private String alc;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private static final k alg = new k(0);
    }

    public /* synthetic */ k(byte b4) {
        this();
    }

    private static boolean at(Context context) {
        String processName = aq.getProcessName(context);
        return !TextUtils.isEmpty(processName) && processName.endsWith("kssdk_remote");
    }

    public static void b(String str, Map<String, String> map, String str2) {
        com.kwad.sdk.core.a.d.a(str, map, str2);
    }

    public static String bY(String str) {
        return com.kwad.sdk.core.a.d.al(str);
    }

    public static String bZ(String str) {
        return com.kwad.sdk.core.a.d.getResponseData(str);
    }

    public static Object c(String str, Object... objArr) {
        try {
            if ("autoRT".equals(str)) {
                return -1;
            }
            if ("getAutoRevertTime".equals(str)) {
                return 10000;
            }
            boolean z10 = false;
            if ("TRANSFORM_API_HOST".equals(str)) {
                return com.kwad.sdk.core.network.idc.a.DU().Y(objArr[0].toString(), "api");
            }
            if ("reportDynamicUpdate".equals(str)) {
                com.kwad.sdk.commercial.b.g((JSONObject) objArr[0]);
                return Boolean.TRUE;
            }
            if (!"enableDynamic".equals(str) || ServiceProvider.KO() == null) {
                return null;
            }
            if (aq.isInMainProcess(ServiceProvider.KO()) && com.kwad.framework.a.a.adF.booleanValue()) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        } catch (Throwable th) {
            try {
                ServiceProvider.reportSdkCaughtException(th);
            } catch (Throwable unused) {
            }
            return null;
        }
    }

    public static void d(@NonNull Map<String, String> map) {
        com.kwad.sdk.core.a.d.f(map);
    }

    public static void deleteCache() {
        com.kwad.sdk.core.diskcache.b.a.Dc().delete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SdkConfigData sdkConfigData) {
        zf();
        zq();
        com.kwad.sdk.core.config.d.yn();
        if ((com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqT) && aq.isInMainProcess(ServiceProvider.KO())) || com.kwad.framework.a.a.f36635md.booleanValue()) {
            DynamicInstallReceiver.registerToApp(ServiceProvider.KO());
        }
        if (com.kwad.sdk.core.config.d.Cr()) {
            com.kwad.sdk.c.a.init(com.kwad.sdk.n.l.Ob());
        }
        zv();
        az.init(getContext());
        com.kwad.components.core.a.a.mr().eF();
        com.kwad.sdk.utils.f.a(getContext(), 30000L, new com.kwad.sdk.collector.h() { // from class: com.kwad.sdk.k.5
            @Override // com.kwad.sdk.collector.h
            public final void c(@NonNull JSONArray jSONArray) {
                com.kwad.components.core.o.a.qi().c(jSONArray);
            }
        });
        com.kwad.sdk.core.network.idc.a.DU().a(com.kwad.sdk.core.config.d.Cs(), com.kwad.sdk.core.config.d.Ct());
        com.kwad.sdk.ip.direct.a.a(sdkConfigData.httpDnsInfo);
        bk.a(com.kwad.sdk.core.config.d.Cu(), com.kwad.sdk.core.config.d.Cv(), ServiceProvider.getContext());
        zx();
        zt();
        com.kwad.components.core.h.a.oE().Y(getContext());
        com.kwad.sdk.crash.online.monitor.a.cH(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asC));
        ImageLoaderPerfUtil.report();
        com.kwad.sdk.ranger.d.cH(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asI));
        com.kwad.sdk.core.threads.c.cH(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asK));
        com.kwad.sdk.j.b.Jt();
        com.kwad.sdk.n.l.x(getContext(), ((Boolean) sdkConfigData.getAppConfigData(Boolean.FALSE, new com.kwad.sdk.g.b<JSONObject, Boolean>() { // from class: com.kwad.sdk.k.6
            private static Boolean f(JSONObject jSONObject) {
                return Boolean.valueOf(jSONObject.optBoolean("useContextClassLoader"));
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Boolean apply(JSONObject jSONObject) {
                return f(jSONObject);
            }
        })).booleanValue());
        com.kwad.sdk.kgeo.a.dC(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.atb));
        try {
            com.kwad.components.core.webview.tachikoma.g.sy().init();
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }

    public static String getAppId() {
        return ServiceProvider.KP().appId;
    }

    public static JSONObject getAppInfo() {
        return com.kwad.sdk.core.request.model.a.EY();
    }

    public static String getAppName() {
        return ServiceProvider.KP().appName;
    }

    public static Context getContext() {
        return ServiceProvider.getContext();
    }

    public static JSONObject getDeviceInfo() {
        return com.kwad.sdk.core.request.model.b.Fa().toJson();
    }

    public static String getDid() {
        return av.getDeviceId();
    }

    public static JSONObject getNetworkInfo() {
        return com.kwad.sdk.core.request.model.d.Fd().toJson();
    }

    public static String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static SdkConfig getSdkConfig() {
        return ServiceProvider.KP();
    }

    public static boolean isDebugLogEnable() {
        return ServiceProvider.KP().enableDebug;
    }

    public static void k(Throwable th) {
        ServiceProvider.reportSdkCaughtException(th);
    }

    public static <T> T newInstance(Class<T> cls) {
        try {
            return (T) com.kwad.sdk.service.b.h(cls).newInstance();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void pauseCurrentPlayer() {
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
    }

    public static void resumeCurrentPlayer() {
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
    }

    public static void setLoadingLottieAnimation(boolean z10, @RawRes int i10) {
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
    }

    public static void setLoadingLottieAnimationColor(boolean z10, @ColorInt int i10) {
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
    }

    public static void setThemeMode(int i10) {
        com.kwad.sdk.components.c.f(com.kwad.components.a.a.a.class);
    }

    public static k zd() {
        return a.alg;
    }

    private void ze() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.YZ = elapsedRealtime;
        com.kwad.sdk.service.b.init();
        i.yj();
        zn();
        zo();
        l.Y(this.akY);
        zg();
        zr();
        zs();
        zy();
        zk();
        zl();
        zh();
        zi();
        zj();
        zp();
        zw();
        zu();
        com.kwad.sdk.a.a.c.zM().zO();
        com.kwad.sdk.j.a.report();
        com.kwad.components.core.o.a.qi().qj();
        com.kwad.sdk.n.k.NZ();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        com.kwad.sdk.core.e.c.d("KSAdSDK", "KSAdSDK init time:" + elapsedRealtime2);
        com.kwad.sdk.core.e.c.i("KSAdSDK", "SDK_VERSION_NAME: 3.3.59.1 TK_VERSION_CODE: 5.1.7 BRIDGE_VERSION: 1.3");
        l.Z(elapsedRealtime2);
        a(ServiceProvider.KP());
        this.akT = true;
    }

    private void zf() {
        try {
            com.kwad.sdk.commercial.b.a(new b.a() { // from class: com.kwad.sdk.k.1
                @Override // com.kwad.sdk.commercial.b.a
                public final void j(String str, String str2, boolean z10) {
                    com.kwad.components.core.o.a.qi().e(str, str2, false);
                }

                @Override // com.kwad.sdk.commercial.b.a
                public final boolean zA() {
                    return com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.aqV);
                }

                @Override // com.kwad.sdk.commercial.b.a
                public final boolean zB() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqU);
                }

                @Override // com.kwad.sdk.commercial.b.a
                public final JSONObject zC() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.arg);
                }

                @Override // com.kwad.sdk.commercial.b.a
                public final String zD() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.atg);
                }
            }, this.akW);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void zg() {
        try {
            com.kwad.sdk.components.b.init(ServiceProvider.getContext());
        } catch (Throwable th) {
            m.l(th);
        }
    }

    private static void zh() {
        try {
            com.kwad.components.core.d.a.initAsync(ServiceProvider.getContext());
        } catch (Throwable th) {
            m.l(th);
        }
    }

    private void zi() {
        try {
            com.kwad.sdk.components.c.init(getContext());
        } catch (Throwable th) {
            m.l(th);
        }
    }

    private void zj() {
        try {
            com.kwad.components.core.n.b.b.init(getContext());
        } catch (Throwable th) {
            m.l(th);
        }
    }

    private void zk() {
        y.ag(ServiceProvider.getContext(), this.alc);
        this.alc = null;
    }

    private void zl() {
        try {
            com.kwad.components.core.request.g.a(new g.a() { // from class: com.kwad.sdk.k.4
                @Override // com.kwad.components.core.request.g.a
                public final void d(@NonNull SdkConfigData sdkConfigData) {
                    com.kwad.sdk.core.e.c.i("KSAdSDK", "onConfigRefresh()");
                    try {
                        k.this.e(sdkConfigData);
                    } catch (Throwable th) {
                        com.kwad.components.core.d.a.reportSdkCaughtException(th);
                    }
                }

                @Override // com.kwad.components.core.request.g.a
                public final void qv() {
                    com.kwad.sdk.core.e.c.i("KSAdSDK", "onCacheLoaded()");
                    k kVar = k.this;
                    k.zm();
                }
            });
        } catch (Throwable th) {
            m.l(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zm() {
        try {
            Map<String, String> parseJSON2MapString = u.parseJSON2MapString(com.kwad.sdk.core.config.c.asL.getValue());
            for (String str : parseJSON2MapString.h()) {
                String str2 = parseJSON2MapString.get(str);
                Objects.requireNonNull(str2);
                GlobalThreadPools.r(str, Integer.parseInt(str2));
            }
            GlobalThreadPools.FA();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void zn() {
        try {
            com.kwad.sdk.core.e.c.init(ServiceProvider.KP().enableDebug);
        } catch (Throwable th) {
            m.l(th);
        }
    }

    private static void zo() {
        try {
            com.kwad.sdk.n.e.NV().init();
        } catch (Throwable th) {
            m.l(th);
        }
    }

    private static void zp() {
        try {
            com.kwad.sdk.core.c.b.DD().init(ServiceProvider.getContext());
        } catch (Throwable th) {
            m.l(th);
        }
    }

    private void zq() {
        try {
            com.kwad.sdk.core.webview.b.a.GV().init(getContext());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void zr() {
        try {
            com.kwad.sdk.core.network.idc.a.DU().init(getContext());
        } catch (Throwable th) {
            m.l(th);
        }
    }

    private static void zs() {
        try {
            com.kwad.sdk.core.download.a.aV(ServiceProvider.getContext());
        } catch (Throwable th) {
            m.l(th);
        }
    }

    private void zt() {
        try {
            com.kwad.sdk.core.diskcache.a.aU(getContext());
        } catch (Throwable th) {
            m.l(th);
        }
    }

    private static void zu() {
        try {
            com.kwad.components.core.s.m.re().init();
        } catch (Throwable th) {
            m.l(th);
        }
    }

    private static void zv() {
        com.kwad.components.core.p.b.qA();
        com.kwad.components.core.p.b.f(com.kwad.sdk.core.config.d.BJ(), com.kwad.sdk.core.config.d.BK());
    }

    private void zw() {
        try {
            av.init(getContext());
        } catch (Throwable th) {
            m.l(th);
        }
    }

    private static void zx() {
        try {
            com.kwad.sdk.b.b.Ao().checkInit();
        } catch (Throwable th) {
            m.l(th);
        }
    }

    private void zy() {
        try {
            com.kwad.library.solder.lib.i.a(new i.a() { // from class: com.kwad.sdk.k.7
                @Override // com.kwad.library.solder.lib.i.a
                public final void b(String str, File file) {
                    com.kwad.sdk.core.download.a.a(str, file, true);
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final void d(String str, Throwable th) {
                    if (th instanceof Exception) {
                        com.kwad.sdk.core.network.idc.a.DU().g(str, th);
                    }
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final int getCorePoolSize() {
                    return com.kwad.sdk.core.config.d.BM();
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final int getMaxRetryCount() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asb);
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final boolean xh() {
                    return com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asa);
                }
            });
        } catch (Throwable th) {
            m.l(th);
        }
    }

    @NonNull
    public final KsLoadManager getAdManager() {
        if (this.akX == null) {
            this.akX = new com.kwad.components.core.b();
        }
        return this.akX;
    }

    public final String getApiVersion() {
        return this.akU;
    }

    public final int getApiVersionCode() {
        return this.akV;
    }

    public final synchronized void init(Context context, SdkConfig sdkConfig) {
        if (context != null && sdkConfig != null) {
            try {
            } catch (Throwable th) {
                String stackTraceString = Log.getStackTraceString(th);
                m.a(th, stackTraceString);
                a(sdkConfig, new e(10002, stackTraceString));
            }
            if (!TextUtils.isEmpty(sdkConfig.appId)) {
                StringBuilder sb2 = new StringBuilder("init appId:");
                sb2.append(sdkConfig.appId);
                sb2.append("--mIsSdkInit:");
                sb2.append(this.akT);
                if (this.akT) {
                    ServiceProvider.b(sdkConfig);
                    return;
                }
                ServiceProvider.b(sdkConfig);
                ServiceProvider.bC(context);
                if (at(context)) {
                    new StringBuilder("intKSRemoteProcess appId=").append(sdkConfig.appId);
                    ServiceProvider.KN();
                    i.yj();
                    zn();
                    this.akT = true;
                } else {
                    try {
                        m.zG();
                        ze();
                    } catch (Throwable th2) {
                        String stackTraceString2 = Log.getStackTraceString(th2);
                        m.a(th2, stackTraceString2);
                        a(sdkConfig, new e(10002, stackTraceString2));
                        return;
                    }
                }
                return;
            }
        }
        a(sdkConfig, e.akD);
    }

    public final <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj) {
        try {
            Class g3 = com.kwad.sdk.service.b.g(cls);
            if (g3 == null) {
                if (obj instanceof BaseProxyActivity) {
                    g3 = com.kwad.components.core.proxy.a.class;
                } else if (obj instanceof BaseProxyFragmentActivity) {
                    g3 = com.kwad.components.core.proxy.b.class;
                }
                com.kwad.components.core.d.a.reportSdkCaughtException(new RuntimeException("--getIsExternal:" + yp() + "--mIsSdkInit:" + ys() + "--componentClass" + ((Object) cls)));
            }
            return (T) g3.newInstance();
        } catch (Exception e2) {
            com.kwad.components.core.d.a.reportSdkCaughtException(e2);
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            return null;
        }
    }

    public final void setAdxEnable(boolean z10) {
        this.alb = z10;
    }

    public final void setApiVersion(String str) {
        this.akU = str;
    }

    public final void setApiVersionCode(int i10) {
        this.akV = i10;
    }

    public final void setAppTag(String str) {
        if (this.akT) {
            y.ag(ServiceProvider.getContext(), this.alc);
        } else {
            this.alc = str;
        }
    }

    public final void setIsExternal(boolean z10) {
        this.akW = z10;
    }

    public final void setLaunchTime(long j10) {
        this.akY = j10;
    }

    public final void setPersonalRecommend(boolean z10) {
        this.akZ = z10;
    }

    public final void setProgrammaticRecommend(boolean z10) {
        this.ala = z10;
    }

    public final void unInit() {
        com.kwad.sdk.core.download.b.De().aX(getContext());
    }

    public final boolean yp() {
        return this.akW;
    }

    public final boolean yq() {
        return this.akZ;
    }

    public final boolean yr() {
        return this.ala;
    }

    public final boolean ys() {
        return this.akT;
    }

    public final long zz() {
        return this.YZ;
    }

    private k() {
        this.akT = false;
        this.akU = "";
        this.akZ = true;
        this.ala = true;
        this.alb = false;
    }

    private static void a(SdkConfig sdkConfig, final e eVar) {
        if (sdkConfig != null) {
            try {
                final KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    bn.postOnUiThread(new ay() { // from class: com.kwad.sdk.k.2
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            KsInitCallback ksInitCallback2 = KsInitCallback.this;
                            e eVar2 = eVar;
                            ksInitCallback2.onFail(eVar2.code, eVar2.msg);
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void a(SdkConfig sdkConfig) {
        if (sdkConfig != null) {
            try {
                final KsInitCallback ksInitCallback = sdkConfig.ksInitCallback;
                if (ksInitCallback != null) {
                    bn.b(new ay() { // from class: com.kwad.sdk.k.3
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            KsInitCallback.this.onSuccess();
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }
}
