package com.huawei.appgallery.agd.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.appgallery.agd.internal.support.log.AgdLog;
import com.huawei.appgallery.agd.serverreq.BuildConfig;
import com.huawei.appgallery.coreservice.api.CoreServiceApi;
import com.huawei.appmarket.service.externalservice.distribution.adsview.request.GenerateAdsViewIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.adsview.response.GenerateAdsViewIPCResponse;
import com.huawei.appmarket.service.externalservice.distribution.download.request.CancelTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.GetRecommendCardReq;
import com.huawei.appmarket.service.externalservice.distribution.download.request.PauseTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.QueryTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.RegisterDownloadCallbackIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.ResumeTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.StartDownloadIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.StartDownloadV2IPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.UnregisterDownloadCallbackIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.response.GetRecommendCardResponse;
import com.huawei.appmarket.service.externalservice.distribution.download.response.QueryTaskResponse;
import com.huawei.appmarket.service.externalservice.distribution.download.response.TaskOperationResponse;
import com.huawei.appmarket.service.externalservice.distribution.referrer.request.QueryReferrerIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.referrer.response.QueryReferrerResponse;
import com.huawei.appmarket.service.externalservice.distribution.reserve.request.ReserveAppIPCRequest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class AgdApi {
    @NonNull
    public static PendingResult<CancelTaskIPCRequest, TaskOperationResponse> cancelTask(AgdApiClient agdApiClient, CancelTaskIPCRequest cancelTaskIPCRequest) {
        return new PendingResult<>(agdApiClient, cancelTaskIPCRequest);
    }

    @NonNull
    public static PendingResult<GenerateAdsViewIPCRequest, GenerateAdsViewIPCResponse> generateAdsView(AgdApiClient agdApiClient, GenerateAdsViewIPCRequest generateAdsViewIPCRequest) {
        return new PendingResult<>(agdApiClient, generateAdsViewIPCRequest);
    }

    @Nullable
    public static String getAppGalleryPkg(Context context) {
        return CoreServiceApi.getAppGalleryPkg(context);
    }

    public static ConnectionResult getGuideInstallPendingIntent(Context context) {
        return new ConnectionResult(CoreServiceApi.getGuideInstallPendingIntent(context));
    }

    @NonNull
    public static PendingResult<QueryReferrerIPCRequest, QueryReferrerResponse> getInstallReferrer(AgdApiClient agdApiClient, QueryReferrerIPCRequest queryReferrerIPCRequest) {
        return new PendingResult<>(agdApiClient, queryReferrerIPCRequest);
    }

    @Nullable
    public static MarketInfo getMarketInfo(Context context) {
        AgdLog agdLog;
        StringBuilder sb2;
        String message;
        String appGalleryPkg = CoreServiceApi.getAppGalleryPkg(context);
        if (TextUtils.isEmpty(appGalleryPkg)) {
            AgdLog.LOG.w("AgdApi", "getMarketInfo AppGallery pkgName is empty");
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(appGalleryPkg, 128);
            if (packageInfo != null) {
                return new MarketInfo(packageInfo.versionName, packageInfo.versionCode);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            agdLog = AgdLog.LOG;
            sb2 = new StringBuilder();
            sb2.append("getPackageInfo NameNotFoundException: ");
            message = e2.getMessage();
            sb2.append(message);
            agdLog.e("AgdApi", sb2.toString());
            return null;
        } catch (RuntimeException e10) {
            agdLog = AgdLog.LOG;
            sb2 = new StringBuilder();
            sb2.append("getPackageInfo RuntimeException: ");
            message = e10.getMessage();
            sb2.append(message);
            agdLog.e("AgdApi", sb2.toString());
            return null;
        }
        return null;
    }

    @NonNull
    public static PendingResult<GetRecommendCardReq, GetRecommendCardResponse> getRecommendCardRequest(AgdApiClient agdApiClient, GetRecommendCardReq getRecommendCardReq) {
        return new PendingResult<>(agdApiClient, getRecommendCardReq);
    }

    public static String getVersion() {
        return "3.1.1.300_normal".replace('_', '.');
    }

    public static int getVersionCode() {
        return BuildConfig.VERSION_CODE;
    }

    @NonNull
    public static PendingResult<PauseTaskIPCRequest, TaskOperationResponse> pauseTask(AgdApiClient agdApiClient, PauseTaskIPCRequest pauseTaskIPCRequest) {
        return new PendingResult<>(agdApiClient, pauseTaskIPCRequest);
    }

    @NonNull
    public static PendingResult<QueryTaskIPCRequest, QueryTaskResponse> queryTasks(AgdApiClient agdApiClient, QueryTaskIPCRequest queryTaskIPCRequest) {
        if (queryTaskIPCRequest == null) {
            queryTaskIPCRequest = new QueryTaskIPCRequest();
        }
        return new PendingResult<>(agdApiClient, queryTaskIPCRequest);
    }

    @NonNull
    public static PendingResult<RegisterDownloadCallbackIPCRequest, TaskOperationResponse> registerDownloadCallback(AgdApiClient agdApiClient, RegisterDownloadCallbackIPCRequest registerDownloadCallbackIPCRequest) {
        return new PendingResult<>(agdApiClient, registerDownloadCallbackIPCRequest);
    }

    @NonNull
    public static PendingResult<ReserveAppIPCRequest, TaskOperationResponse> reserveApp(AgdApiClient agdApiClient, ReserveAppIPCRequest reserveAppIPCRequest) {
        return new PendingResult<>(agdApiClient, reserveAppIPCRequest);
    }

    @NonNull
    public static PendingResult<ResumeTaskIPCRequest, TaskOperationResponse> resumeTask(AgdApiClient agdApiClient, ResumeTaskIPCRequest resumeTaskIPCRequest) {
        return new PendingResult<>(agdApiClient, resumeTaskIPCRequest);
    }

    @NonNull
    @Deprecated
    public static PendingResult<StartDownloadIPCRequest, TaskOperationResponse> startDownloadTask(AgdApiClient agdApiClient, StartDownloadIPCRequest startDownloadIPCRequest) {
        return new PendingResult<>(agdApiClient, startDownloadIPCRequest);
    }

    @NonNull
    public static PendingResult<StartDownloadV2IPCRequest, TaskOperationResponse> startDownloadTaskV2(AgdApiClient agdApiClient, StartDownloadV2IPCRequest startDownloadV2IPCRequest) {
        return new PendingResult<>(agdApiClient, startDownloadV2IPCRequest);
    }

    @NonNull
    public static PendingResult<UnregisterDownloadCallbackIPCRequest, TaskOperationResponse> unregisterDownloadCallback(AgdApiClient agdApiClient, UnregisterDownloadCallbackIPCRequest unregisterDownloadCallbackIPCRequest) {
        return new PendingResult<>(agdApiClient, unregisterDownloadCallbackIPCRequest);
    }
}
