package com.huawei.appgallery.agd.base.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.api.AgdApi;
import com.huawei.appgallery.agd.api.AgdApiClient;
import com.huawei.appgallery.agd.api.ApiStatusCodes;
import com.huawei.appgallery.agd.api.ConnectionResult;
import com.huawei.appgallery.agd.api.ResultCallback;
import com.huawei.appgallery.agd.base.R$string;
import com.huawei.appgallery.agd.base.guideinstall.GuideActivity;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.coreservice.api.CoreServiceApi;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appmarket.framework.coreservice.Status;
import com.huawei.appmarket.service.externalservice.distribution.download.request.CancelTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.PauseTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.QueryTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.ResumeTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.StartDownloadV2IPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.response.QueryTaskResponse;
import com.huawei.appmarket.service.externalservice.distribution.download.response.TaskInfo;
import com.huawei.appmarket.service.externalservice.distribution.download.response.TaskOperationResponse;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AgdManager {
    public static final String SOURCE_AGD_PRO = "agdpro";
    public static final String SOURCE_AGD_PRO_WEB = "agdpro_web";
    public static final String SOURCE_NATIVE = "native";
    public static final String SOURCE_NATIVE_WEB = "native_web";
    public static final String SOURCE_PPS_WEB = "pps_web";

    /* renamed from: a, reason: collision with root package name */
    public static volatile AgdApiClient f27304a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map<Integer, Runnable> f27305b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final Object f27306c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static BiReport f27307d;

    /* renamed from: e, reason: collision with root package name */
    public static String f27308e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface BiReport {
        void report(@NonNull ReportInfo reportInfo);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ChildReason {
        public static final int APP_INSTALLING = 9;
        public static final int CALLTYPE_DEFAULT = 11;
        public static final int CHILD_OMDLE_FAIL = 2;
        public static final int CONTENT_LIMIT_FAIL = 3;
        public static final int HIDDEN_INFO_NULL = 8;
        public static final int LOCAL_HIGH_VERSION_FAIL = 4;
        public static final int MOBIL_NET_DIALOG_FAIL = 5;
        public static final int RESUME_TASK = 6;
        public static final int UN_KNOW_DISTWAY = 7;
        public static final int VERIFICATION_FAIL = 1;
        public static final int WLAN_DOWNLOAD_BY_OTHER_MEDIA = 10;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class ConnectCallback implements AgdApiClient.ConnectionCallbacks {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f27309a;

        public ConnectCallback(boolean z10) {
            this.f27309a = z10;
        }

        @Override // com.huawei.appgallery.agd.api.AgdApiClient.ConnectionCallbacks
        public void onConnected() {
            j9.a.f50348d.d("AgdManager", "ConnectCallback : onConnected()");
            AgdManager.o();
        }

        @Override // com.huawei.appgallery.agd.api.AgdApiClient.ConnectionCallbacks
        public void onConnectionFailed(ConnectionResult connectionResult) {
            String str;
            j9.a aVar = j9.a.f50348d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onConnectionFailed result ");
            if (connectionResult == null) {
                str = "null ";
            } else {
                str = connectionResult.getStatusCode() + ", hasResolution " + connectionResult.hasResolution();
            }
            sb2.append(str);
            sb2.append(", isReconnect ");
            sb2.append(this.f27309a);
            aVar.e("AgdManager", sb2.toString());
            if (connectionResult != null && connectionResult.hasResolution() && !this.f27309a) {
                GuideActivity.c(ApplicationWrapper.getInstance().getContext(), connectionResult.getResolution(), true);
            } else {
                AgdManager.o();
            }
        }

        @Override // com.huawei.appgallery.agd.api.AgdApiClient.ConnectionCallbacks
        public void onConnectionSuspended(int i10) {
            j9.a.f50348d.e("AgdManager", "ConnectCallback : onConnectionSuspended() cause: " + i10);
            AgdManager.o();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class GuideResultCallback implements ResultCallback<TaskOperationResponse> {

        /* renamed from: a, reason: collision with root package name */
        public final BaseIPCRequest f27310a;

        /* renamed from: b, reason: collision with root package name */
        public final Set<Integer> f27311b = new HashSet();

        /* renamed from: c, reason: collision with root package name */
        public final ReportInfo f27312c;

        /* renamed from: d, reason: collision with root package name */
        public final WeakReference<Activity> f27313d;

        public GuideResultCallback(@NonNull Activity activity, @NonNull BaseIPCRequest baseIPCRequest, String str, String str2) {
            this.f27310a = baseIPCRequest;
            ReportInfo reportInfo = new ReportInfo();
            this.f27312c = reportInfo;
            reportInfo.request = baseIPCRequest;
            reportInfo.slotId = str;
            reportInfo.source = str2;
            this.f27313d = new WeakReference<>(activity);
        }

        public final void b(int i10) {
            Context context = ApplicationWrapper.getInstance().getContext();
            if (AgdManager.SOURCE_AGD_PRO.equals(this.f27312c.source) || AgdManager.SOURCE_AGD_PRO_WEB.equals(this.f27312c.source)) {
                if (i10 == 7) {
                    c(context, context.getString(R$string.no_available_network_prompt_toast));
                } else if (i10 == 18) {
                    c(context, context.getString(R$string.agd_pageframe_app_downloading_toast));
                }
            }
        }

        public final void c(@NonNull final Context context, final CharSequence charSequence) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.huawei.appgallery.agd.base.api.AgdManager.GuideResultCallback.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GuideResultCallback.this.c(context, charSequence);
                    }
                });
            } else {
                j9.a.f50348d.d("AgdManager", "show toast");
                Toast.makeText(context, charSequence, 0).show();
            }
        }

        @Override // com.huawei.appgallery.agd.api.ResultCallback
        public void onResult(Status<TaskOperationResponse> status) {
            int statusCode = status.getStatusCode();
            String str = "onResult " + ApiStatusCodes.getStatusCodeString(statusCode) + ", hasResolution " + status.hasResolution();
            String a10 = (status.getResponse() == null || status.getResponse().getResult() == 0) ? "" : f.a(status.getResponse().getResult());
            j9.a aVar = j9.a.f50348d;
            aVar.i("AgdManager", ((Object) this) + "msg: " + str + ", childReason " + a10);
            if (status.getResolution() != null && !this.f27311b.contains(Integer.valueOf(statusCode))) {
                this.f27311b.add(Integer.valueOf(statusCode));
                aVar.i("AgdManager", "guide with statusCode " + ApiStatusCodes.getStatusCodeString(statusCode));
                GuideActivity.c(this.f27313d.get(), status.getResolution(), false);
                return;
            }
            b(statusCode);
            this.f27312c.status = ApiStatusCodes.getStatusCodeString(statusCode);
            this.f27312c.reason = a10;
            if (AgdManager.f27307d != null) {
                AgdManager.f27307d.report(this.f27312c);
            }
            AgdManager.f27305b.remove(Integer.valueOf(this.f27310a.hashCode()));
        }

        public void setLayoutName(String str) {
            this.f27312c.layoutName = str;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class QueryResultCallback implements ResultCallback<QueryTaskResponse> {

        /* renamed from: a, reason: collision with root package name */
        public final QueryTaskIPCRequest f27317a;

        public QueryResultCallback(@NonNull QueryTaskIPCRequest queryTaskIPCRequest) {
            this.f27317a = queryTaskIPCRequest;
        }

        @Override // com.huawei.appgallery.agd.api.ResultCallback
        public void onResult(Status<QueryTaskResponse> status) {
            int statusCode = status.getStatusCode();
            j9.a.f50348d.i("AgdManager", "queryTasks| onResult:" + statusCode);
            if (statusCode == 0) {
                HashMap<String, TaskInfo> taskList = status.getResponse().getTaskList();
                if (taskList.size() > 0) {
                    for (Map.Entry<String, TaskInfo> entry : taskList.entrySet()) {
                        String key = entry.getKey();
                        int appStatusType = entry.getValue().getAppStatusType();
                        int status2 = entry.getValue().getStatus();
                        int progress = entry.getValue().getProgress();
                        k9.b.d().onStatusChange(new DownloadStatus(key, appStatusType, status2, progress));
                        j9.a.f50348d.i("AgdManager", "queryTasks| packageName = " + key + ", statusType = " + appStatusType + ", status = " + status2 + ", progress = " + progress);
                    }
                }
            }
            AgdManager.f27305b.remove(Integer.valueOf(this.f27317a.hashCode()));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class ReportInfo {
        public String layoutName;
        public String reason;
        public BaseIPCRequest request;
        public String slotId;
        public String source;
        public String status;
    }

    public static void cancelTask(@NonNull Activity activity, CancelTaskIPCRequest cancelTaskIPCRequest, String str) {
        cancelTask(activity, cancelTaskIPCRequest, str, "");
    }

    public static void disconnect() {
        if (f27304a != null) {
            f27304a.disconnect();
            f27304a = null;
        }
        synchronized (f27306c) {
            f27305b.clear();
        }
    }

    public static String getAppGalleryPkgName(Context context) {
        if (TextUtils.isEmpty(f27308e)) {
            f27308e = AgdApi.getAppGalleryPkg(context);
        }
        return f27308e;
    }

    public static boolean i(String str) {
        return !TextUtils.isEmpty(str) && str.length() > 1 && str.charAt(1) == '1';
    }

    public static boolean isConnected() {
        return f27304a != null && f27304a.isConnected();
    }

    public static /* synthetic */ void j(CancelTaskIPCRequest cancelTaskIPCRequest, GuideResultCallback guideResultCallback) {
        AgdApi.cancelTask(f27304a, cancelTaskIPCRequest).setResultCallback(guideResultCallback);
    }

    public static /* synthetic */ void k(PauseTaskIPCRequest pauseTaskIPCRequest, GuideResultCallback guideResultCallback) {
        AgdApi.pauseTask(f27304a, pauseTaskIPCRequest).setResultCallback(guideResultCallback);
    }

    public static /* synthetic */ void l(QueryTaskIPCRequest queryTaskIPCRequest, QueryResultCallback queryResultCallback) {
        AgdApi.queryTasks(f27304a, queryTaskIPCRequest).setResultCallback(queryResultCallback);
    }

    public static /* synthetic */ void m(ResumeTaskIPCRequest resumeTaskIPCRequest, GuideResultCallback guideResultCallback) {
        AgdApi.resumeTask(f27304a, resumeTaskIPCRequest).setResultCallback(guideResultCallback);
    }

    public static /* synthetic */ void n(StartDownloadV2IPCRequest startDownloadV2IPCRequest, GuideResultCallback guideResultCallback) {
        AgdApi.startDownloadTaskV2(f27304a, startDownloadV2IPCRequest).setResultCallback(guideResultCallback);
    }

    public static void o() {
        j9.a aVar = j9.a.f50348d;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("action size ");
        Map<Integer, Runnable> map = f27305b;
        sb2.append(map.size());
        aVar.d("AgdManager", sb2.toString());
        synchronized (f27306c) {
            Iterator<Runnable> iterator2 = map.values().iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().run();
            }
        }
    }

    public static void p(@NonNull BaseIPCRequest baseIPCRequest, @NonNull Runnable runnable) {
        q(baseIPCRequest, runnable, false);
    }

    public static void pauseTask(@NonNull Activity activity, PauseTaskIPCRequest pauseTaskIPCRequest, String str) {
        pauseTask(activity, pauseTaskIPCRequest, str, "");
    }

    public static void q(@NonNull BaseIPCRequest baseIPCRequest, @NonNull Runnable runnable, boolean z10) {
        Context context = ApplicationWrapper.getInstance().getContext();
        if (f27304a == null) {
            f27304a = new AgdApiClient.Builder(context).addConnectionCallbacks(new ConnectCallback(false)).build();
        }
        baseIPCRequest.setCallType(BaseIPCRequest.CALL_TYPE_AGD_PRO_SDK);
        j9.a.f50348d.i("AgdManager", "sendToAgd with " + baseIPCRequest.getMethod() + ", shouldGuide " + z10);
        if (z10) {
            ConnectionResult guideInstallPendingIntent = AgdApi.getGuideInstallPendingIntent(context);
            if (guideInstallPendingIntent.getResolution() != null) {
                synchronized (f27306c) {
                    f27305b.put(Integer.valueOf(baseIPCRequest.hashCode()), runnable);
                }
                GuideActivity.c(context, guideInstallPendingIntent.getResolution(), true);
                return;
            }
        }
        synchronized (f27306c) {
            f27305b.put(Integer.valueOf(baseIPCRequest.hashCode()), runnable);
        }
        if (f27304a.isConnected()) {
            runnable.run();
        } else {
            f27304a.connect();
        }
    }

    public static void queryTasks(final QueryTaskIPCRequest queryTaskIPCRequest) {
        final QueryResultCallback queryResultCallback = new QueryResultCallback(queryTaskIPCRequest);
        p(queryTaskIPCRequest, new Runnable() { // from class: com.huawei.appgallery.agd.base.api.c
            @Override // java.lang.Runnable
            public final void run() {
                AgdManager.l(QueryTaskIPCRequest.this, queryResultCallback);
            }
        });
    }

    public static boolean r(@NonNull StartDownloadV2IPCRequest startDownloadV2IPCRequest) {
        Context context = ApplicationWrapper.getInstance().getContext();
        String mediaPkg = startDownloadV2IPCRequest.getMediaPkg();
        if (TextUtils.isEmpty(mediaPkg) || mediaPkg.equals(context.getPackageName())) {
            return false;
        }
        int a10 = l9.b.a(context, CoreServiceApi.getAppGalleryPkg(context));
        return (i(startDownloadV2IPCRequest.getInstallType()) && a10 < 3) || (!i(startDownloadV2IPCRequest.getInstallType()) && a10 < 4);
    }

    @MainThread
    public static void reSendToAgd() {
        if (f27304a != null && f27304a.isConnected()) {
            o();
        } else {
            j9.a.f50348d.e("AgdManager", "reSendToAgd client not connect, clear pending request");
            f27305b.clear();
        }
    }

    @MainThread
    public static void reconnect() {
        j9.a.f50348d.e("AgdManager", "reconnect");
        new AgdApiClient.Builder(ApplicationWrapper.getInstance().getContext()).addConnectionCallbacks(new ConnectCallback(true)).build().connect();
    }

    public static void resumeTask(@NonNull Activity activity, ResumeTaskIPCRequest resumeTaskIPCRequest, String str) {
        resumeTask(activity, resumeTaskIPCRequest, str, "");
    }

    public static void setBiReportImpl(@NonNull BiReport biReport) {
        f27307d = biReport;
    }

    public static void startDownloadTaskV2(@NonNull Activity activity, @NonNull StartDownloadV2IPCRequest startDownloadV2IPCRequest, String str, String str2) {
        startDownloadTaskV2(activity, startDownloadV2IPCRequest, str, "", str2);
    }

    public static void cancelTask(@NonNull Activity activity, final CancelTaskIPCRequest cancelTaskIPCRequest, String str, String str2) {
        final GuideResultCallback guideResultCallback = new GuideResultCallback(activity, cancelTaskIPCRequest, str, str2);
        p(cancelTaskIPCRequest, new Runnable() { // from class: com.huawei.appgallery.agd.base.api.a
            @Override // java.lang.Runnable
            public final void run() {
                AgdManager.j(CancelTaskIPCRequest.this, guideResultCallback);
            }
        });
    }

    public static void pauseTask(@NonNull Activity activity, final PauseTaskIPCRequest pauseTaskIPCRequest, String str, String str2) {
        final GuideResultCallback guideResultCallback = new GuideResultCallback(activity, pauseTaskIPCRequest, str, str2);
        p(pauseTaskIPCRequest, new Runnable() { // from class: com.huawei.appgallery.agd.base.api.b
            @Override // java.lang.Runnable
            public final void run() {
                AgdManager.k(PauseTaskIPCRequest.this, guideResultCallback);
            }
        });
    }

    public static void resumeTask(@NonNull Activity activity, final ResumeTaskIPCRequest resumeTaskIPCRequest, String str, String str2) {
        final GuideResultCallback guideResultCallback = new GuideResultCallback(activity, resumeTaskIPCRequest, str, str2);
        p(resumeTaskIPCRequest, new Runnable() { // from class: com.huawei.appgallery.agd.base.api.d
            @Override // java.lang.Runnable
            public final void run() {
                AgdManager.m(ResumeTaskIPCRequest.this, guideResultCallback);
            }
        });
    }

    public static void startDownloadTaskV2(@NonNull Activity activity, @NonNull final StartDownloadV2IPCRequest startDownloadV2IPCRequest, String str, String str2, String str3) {
        final GuideResultCallback guideResultCallback = new GuideResultCallback(activity, startDownloadV2IPCRequest, str, str3);
        guideResultCallback.setLayoutName(str2);
        q(startDownloadV2IPCRequest, new Runnable() { // from class: com.huawei.appgallery.agd.base.api.e
            @Override // java.lang.Runnable
            public final void run() {
                AgdManager.n(StartDownloadV2IPCRequest.this, guideResultCallback);
            }
        }, r(startDownloadV2IPCRequest));
    }
}
