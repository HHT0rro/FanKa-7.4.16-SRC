package com.huawei.appgallery.agd.core.api;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.base.api.AgdManager;
import com.huawei.appgallery.agd.base.api.InitProxy;
import com.huawei.appgallery.agd.common.FlavorApi;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.common.flavor.ReportErrorLogListener;
import com.huawei.appgallery.agd.common.gcd.DispatchBlock;
import com.huawei.appgallery.agd.common.gcd.DispatchQoS;
import com.huawei.appgallery.agd.common.gcd.DispatchQueue;
import com.huawei.appgallery.agd.common.grs.GrsDataKeeper;
import com.huawei.appgallery.agd.common.support.global.HomeCountryUtils;
import com.huawei.appgallery.agd.common.support.log.LogAdapter;
import com.huawei.appgallery.agd.core.api.RequestConfig;
import com.huawei.appgallery.agd.core.impl.AgdAdManager;
import com.huawei.appgallery.agd.core.impl.device.OaidUtil;
import com.huawei.appgallery.agd.core.impl.report.HiAnalysisUtil;
import com.huawei.appgallery.agd.core.impl.report.MaintBi;
import com.huawei.appgallery.agd.core.impl.report.MaintData;
import com.huawei.appgallery.agd.core.impl.report.MaintKey;
import com.huawei.appgallery.agd.core.impl.store.carddata.CardDataRequestBean;
import com.huawei.appgallery.agd.core.impl.store.carddata.CardDataResponseBean;
import com.huawei.appgallery.agd.core.impl.store.carddatav2.request.CardDataV2RequestBean;
import com.huawei.appgallery.agd.core.impl.store.configlist.ConfigListRequest;
import com.huawei.appgallery.agd.core.impl.store.configlist.ConfigListResponse;
import com.huawei.appgallery.agd.core.impl.store.mediaparams.MediaParamsRequest;
import com.huawei.appgallery.agd.core.impl.store.mediaparams.MediaParamsResponse;
import com.huawei.appgallery.agd.core.impl.store.openevent.OpenEventUploadRequest;
import com.huawei.appgallery.agd.core.impl.store.rewardverify.RewardVerifyRequest;
import com.huawei.appgallery.agd.core.internalapi.HwAdsConfigListener;
import com.huawei.appgallery.agd.core.internalapi.IQueryConfigList;
import com.huawei.appgallery.agd.internalapi.CrossClientApi;
import com.huawei.appgallery.agd.serverreq.ServerAgent;
import com.huawei.appgallery.agd.serverreq.ServerReqRegister;
import com.huawei.appgallery.agd.serverreq.bean.BaseResponseBean;
import com.huawei.appgallery.agd.serverreq.bean.startup.StartupRequest;
import com.huawei.appgallery.agd.serverreq.bean.startup.StartupResponse;
import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.store.SignSession;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.CancelTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.PauseTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.ResumeTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.StartDownloadV2IPCRequest;
import m9.i;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AgdAdApi {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f27395a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile RequestConfig f27396b;

    public static void c(@NonNull final Context context, @NonNull final AgdAdConfig agdAdConfig) {
        LogAdapter.setDebugMode(agdAdConfig.isDebug());
        ServerAgent.registerResponse(CardDataRequestBean.APIMETHOD, CardDataResponseBean.class);
        ServerAgent.registerResponse(OpenEventUploadRequest.APIMETHOD, BaseResponseBean.class);
        ServerAgent.registerResponse(RewardVerifyRequest.APIMETHOD, BaseResponseBean.class);
        ServerAgent.registerResponse(StartupRequest.APIMETHOD, StartupResponse.class);
        ServerAgent.registerResponse(CardDataV2RequestBean.API_METHOD, CardDataResponseBean.class);
        ServerAgent.registerResponse(MediaParamsRequest.API_METHOD, MediaParamsResponse.class);
        ServerAgent.registerResponse(ConfigListRequest.API_METHOD, ConfigListResponse.class);
        ServerReqRegister.registerSignProvider(new SignSession.ISignProvider() { // from class: com.huawei.appgallery.agd.core.api.a
            @Override // com.huawei.appgallery.agd.serverreq.store.SignSession.ISignProvider
            public final String getSign() {
                String f10;
                f10 = o9.a.f(context);
                return f10;
            }
        });
        OaidUtil.enableOAID(true);
        OaidUtil.refreshOAID();
        HomeCountryUtils.setHomeCountryOfMedia(GrsDataKeeper.getInstance().getHomeCountry());
        DispatchQueue.GLOBAL.async(DispatchQoS.SERIAL, new DispatchBlock() { // from class: com.huawei.appgallery.agd.core.api.AgdAdApi.1
            @Override // java.lang.Runnable
            public void run() {
                n9.a.f52175d.i("AgdAdApi", "HiAnalysisUtil INIT");
                HiAnalysisUtil.init(context, FlavorApi.getConfig().getBiUrl(context), o9.a.a(context), agdAdConfig.isDebug());
                i.e().c(new IQueryConfigList.Callback(this) { // from class: com.huawei.appgallery.agd.core.api.AgdAdApi.1.1
                    @Override // com.huawei.appgallery.agd.core.internalapi.IQueryConfigList.Callback
                    public void onFail(int i10, String str) {
                        n9.a.f52175d.i("AgdAdApi", "init getConfigList failed," + str);
                    }

                    @Override // com.huawei.appgallery.agd.core.internalapi.IQueryConfigList.Callback
                    public void onSuccess(ConfigListResponse configListResponse) {
                        n9.a.f52175d.i("AgdAdApi", "init getConfigList success.");
                    }
                });
            }
        });
        AgdManager.setBiReportImpl(new AgdManager.BiReport() { // from class: com.huawei.appgallery.agd.core.api.AgdAdApi.2
            @Override // com.huawei.appgallery.agd.base.api.AgdManager.BiReport
            public void report(@NonNull AgdManager.ReportInfo reportInfo) {
                MaintData.Builder builder;
                BaseIPCRequest baseIPCRequest = reportInfo.request;
                if (baseIPCRequest instanceof StartDownloadV2IPCRequest) {
                    builder = new MaintData.Builder(MaintKey.EVENT_AGD_START_DOWNLOAD_ERROR).setTaskPackageName(((StartDownloadV2IPCRequest) reportInfo.request).getPackageName()).setInstallType(((StartDownloadV2IPCRequest) reportInfo.request).getInstallType()).setLayoutName(reportInfo.layoutName);
                } else if (baseIPCRequest instanceof PauseTaskIPCRequest) {
                    builder = new MaintData.Builder(MaintKey.EVENT_AGD_PAUSE_DOWNLOAD_ERROR).setTaskPackageName(((PauseTaskIPCRequest) reportInfo.request).getPackageName());
                } else if (baseIPCRequest instanceof CancelTaskIPCRequest) {
                    builder = new MaintData.Builder(MaintKey.EVENT_AGD_CANCEL_DOWNLOAD_ERROR).setTaskPackageName(((CancelTaskIPCRequest) reportInfo.request).getPackageName());
                } else if (baseIPCRequest instanceof ResumeTaskIPCRequest) {
                    builder = new MaintData.Builder(MaintKey.EVENT_AGD_RESUME_DOWNLOAD_ERROR).setTaskPackageName(((ResumeTaskIPCRequest) reportInfo.request).getPackageName());
                } else {
                    j9.a.f50348d.w("AgdAdApi", "unknown request " + reportInfo.request.getMethod());
                    builder = null;
                }
                if (builder != null) {
                    MaintBi.report(builder.setSlotId(reportInfo.slotId).setSource(reportInfo.source).setStatus(reportInfo.status).setReason(reportInfo.reason).build());
                }
            }
        });
        LogAdapter.setReportErrorLogListener(new ReportErrorLogListener() { // from class: com.huawei.appgallery.agd.core.api.AgdAdApi.3
            @Override // com.huawei.appgallery.agd.common.flavor.ReportErrorLogListener
            public void onErrorLogReport(String str, String str2, Throwable th) {
                MaintBi.reportErrorLog(str, str2, th);
            }
        });
    }

    public static void d(RequestConfig requestConfig) {
        try {
            ((HwAdsConfigListener) Class.forName("com.huawei.appgallery.agd.nativead.impl.HwAdsConfigImpl").newInstance()).setHwAdsRequestOptions(requestConfig);
        } catch (Exception e2) {
            n9.a.f52175d.d("AgdAdApi", "seHwAdsConfig exception :" + e2.getMessage());
        }
    }

    public static RequestConfig getRequestConfig() {
        if (f27396b == null) {
            f27396b = new RequestConfig.Builder().build();
        }
        return f27396b;
    }

    public static void init(Context context, AgdAdConfig agdAdConfig, InitCallback initCallback) {
        n9.a aVar = n9.a.f52175d;
        aVar.i("AgdAdApi", "init with context: " + ((Object) context) + ", adConfig: " + ((Object) agdAdConfig));
        if (context != null && agdAdConfig != null && initCallback != null) {
            ApplicationWrapper.init(context.getApplicationContext());
            AgdAdManager.init(agdAdConfig);
            JsonBean.setIsDebug(agdAdConfig.isDebug());
            CrossClientApi.init(context);
            c(context, agdAdConfig);
            Pair<Boolean, String> initDynamicModule = InitProxy.initDynamicModule(context);
            if (!((Boolean) initDynamicModule.first).booleanValue()) {
                if (AgdManager.SOURCE_AGD_PRO.equals(initDynamicModule.second)) {
                    initCallback.onInitFail(1001, "quick card sdk init fail");
                    MaintBi.reportMediaInit(1001);
                } else if (AgdManager.SOURCE_NATIVE.equals(initDynamicModule.second)) {
                    initCallback.onInitFail(1002, "native ad sdk init fail");
                    MaintBi.reportMediaInit(1002);
                } else if ("none".equals(initDynamicModule.second)) {
                    initCallback.onInitFail(1003, "native ad sdk init fail");
                    MaintBi.reportMediaInit(1003);
                    aVar.e("AgdAdApi", "no module to init");
                } else {
                    initCallback.onInitFail(1004, "no ad module exist");
                    aVar.e("AgdAdApi", ((String) initDynamicModule.second) + " module init fail");
                }
                f27395a = false;
                return;
            }
            MaintBi.reportMediaInit(0);
            f27395a = true;
            initCallback.onInitSuccess();
            return;
        }
        String str = context != null ? agdAdConfig == null ? "adConfig" : "callback" : "context";
        aVar.e("AgdAdApi", "invalid param, " + str + " is null, return");
        throw new NullPointerException("Sdk init failed, " + str + " param is null.");
    }

    public static boolean isInitSuccess() {
        return f27395a;
    }

    public static void setRequestConfig(RequestConfig requestConfig) {
        if (requestConfig == null) {
            n9.a.f52175d.w("AgdAdApi", "config is null");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("tagForChildProtection == ");
        stringBuffer.append((Object) requestConfig.getTagForChildProtection());
        stringBuffer.append(", tagForUnderAgeOfPromise == ");
        stringBuffer.append((Object) requestConfig.getTagForUnderAgeOfPromise());
        stringBuffer.append(", personalizedAd == ");
        stringBuffer.append((Object) (requestConfig.getPersonalizedAd() == null ? null : Integer.valueOf(requestConfig.getPersonalizedAd().getInt(RequestConfig.PersonalizeConstant.KEY_PERSONALIZE, 0))));
        stringBuffer.append(", appInfo == ");
        stringBuffer.append(requestConfig.getApp() != null ? requestConfig.getApp().toString() : null);
        stringBuffer.append(", requestLocation == ");
        stringBuffer.append((Object) requestConfig.isRequestLocation());
        n9.a.f52175d.d("AgdAdApi", stringBuffer.toString());
        f27396b = requestConfig;
        d(requestConfig);
    }
}
