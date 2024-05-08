package com.huawei.appgallery.agd.core.internalapi;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.huawei.appgallery.agd.api.AgdConstant;
import com.huawei.appgallery.agd.base.api.AgdManager;
import com.huawei.appgallery.agd.base.api.AppMarketApi;
import com.huawei.appgallery.agd.base.api.DownloadStatus;
import com.huawei.appgallery.agd.base.api.IAppStatusListener;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.core.api.CoreConstants;
import com.huawei.appgallery.agd.core.impl.AgdAdManager;
import com.huawei.appgallery.agd.core.impl.report.MaintBi;
import com.huawei.appgallery.agd.serverreq.BuildConfig;
import com.huawei.appmarket.service.externalservice.distribution.download.request.PauseTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.ResumeTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.StartDownloadV2IPCRequest;
import com.huawei.openalliance.ad.constant.as;
import com.huawei.secure.android.common.intent.SafeIntent;
import m9.j;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class PpsWebJsObject implements IAppStatusListener, IReloadWhiteList {
    public static final String KEY_PACKAGE_NAME = "packageName";

    /* renamed from: b, reason: collision with root package name */
    public final String f27469b;

    /* renamed from: c, reason: collision with root package name */
    public final String f27470c;

    /* renamed from: d, reason: collision with root package name */
    public final String f27471d;

    /* renamed from: e, reason: collision with root package name */
    public final String f27472e;

    /* renamed from: f, reason: collision with root package name */
    public final String f27473f;

    /* renamed from: g, reason: collision with root package name */
    public final String f27474g;

    /* renamed from: h, reason: collision with root package name */
    public final String f27475h;

    /* renamed from: i, reason: collision with root package name */
    public final String f27476i;

    /* renamed from: j, reason: collision with root package name */
    public final Activity f27477j;

    /* renamed from: k, reason: collision with root package name */
    public WebView f27478k;

    /* renamed from: a, reason: collision with root package name */
    public boolean f27468a = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f27479l = true;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class LifecycleRunnable implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final Activity f27480b;

        public LifecycleRunnable(@NonNull Activity activity) {
            this.f27480b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentCallbacks2 componentCallbacks2 = this.f27480b;
            if (componentCallbacks2 instanceof LifecycleOwner) {
                ((LifecycleOwner) componentCallbacks2).getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.huawei.appgallery.agd.core.internalapi.PpsWebJsObject.LifecycleRunnable.1
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                            k9.b.d().h(PpsWebJsObject.this);
                            n9.a.f52175d.e("PpsWebJsObject", "LifecycleRunnable remove listener");
                            lifecycleOwner.getLifecycle().removeObserver(this);
                        }
                    }
                });
            }
        }
    }

    public PpsWebJsObject(@NonNull Activity activity, WebView webView) {
        this.f27477j = activity;
        wa.b bVar = new wa.b(new SafeIntent(activity.getIntent()).getExtras());
        this.f27469b = bVar.e(IntentKey.INTENT_KEY_SLOT_ID, "");
        this.f27470c = bVar.e(IntentKey.INTENT_KEY_SOURCE, "");
        this.f27471d = bVar.e(IntentKey.INTENT_KEY_DOWNLOAD_PARAM, "");
        this.f27472e = bVar.e(IntentKey.INTENT_KEY_PACKAGE_NAME, "");
        this.f27473f = bVar.e(IntentKey.INTENT_KEY_ICON_URI, "");
        this.f27474g = bVar.e(IntentKey.INTENT_KEY_APP_NAME, "");
        this.f27475h = bVar.e(IntentKey.INTENT_KEY_LAYOUT_ID, "");
        this.f27476i = bVar.e(IntentKey.INTENT_KEY_DETAILID, "");
        this.f27478k = webView;
        activity.runOnUiThread(new LifecycleRunnable(activity));
    }

    public final String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f27474g);
            jSONObject.put("icon", this.f27473f);
            n9.a.f52175d.i("PpsWebJsObject", "getAppInfo " + this.f27474g);
        } catch (JSONException unused) {
            n9.a.f52175d.e("PpsWebJsObject", "appInfo JSONException ");
        }
        return jSONObject.toString();
    }

    public final String b(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 7 ? "download" : "install" : "installed" : as.ah : "pause" : "downloading";
    }

    public void callAgdDownload(String str) {
        StartDownloadV2IPCRequest startDownloadV2IPCRequest = new StartDownloadV2IPCRequest();
        startDownloadV2IPCRequest.setPackageName(this.f27472e);
        startDownloadV2IPCRequest.setMediaPkg(AgdAdManager.getConfig().getMediaPkgName());
        startDownloadV2IPCRequest.setInstallType(str);
        startDownloadV2IPCRequest.setDownloadFlag(1);
        startDownloadV2IPCRequest.setSupportFunction(1);
        startDownloadV2IPCRequest.setReferrer(this.f27469b);
        startDownloadV2IPCRequest.setDownloadParams(this.f27471d);
        startDownloadV2IPCRequest.setAppInfo(a());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CoreConstants.AGD_PRO_VER, BuildConfig.VERSION_CODE);
            jSONObject.put(CoreConstants.MEDIA_PKG_SIGN, AgdAdManager.getConfig().getMediaPkgSign());
        } catch (JSONException unused) {
            n9.a.f52175d.e("PpsWebJsObject", "input json data failed! JSONException");
        }
        startDownloadV2IPCRequest.setJsonData(jSONObject.toString());
        AgdManager.startDownloadTaskV2(this.f27477j, startDownloadV2IPCRequest, this.f27469b, this.f27470c);
    }

    @JavascriptInterface
    public int download(String str) {
        n9.a.f52175d.i("PpsWebJsObject", "method(download(String))#Call Method params:" + str);
        return download();
    }

    @Override // com.huawei.appgallery.agd.core.internalapi.IReloadWhiteList
    public boolean needReloadWhiteList() {
        return this.f27479l;
    }

    @Override // com.huawei.appgallery.agd.base.api.IAppStatusListener
    public void onStatusChange(@NonNull DownloadStatus downloadStatus) {
        n9.a.f52175d.i("PpsWebJsObject", "method(resumeDownload)#onStatusChange downloadStatus:" + ((Object) downloadStatus));
    }

    @JavascriptInterface
    public void openApp() {
        n9.a.f52175d.i("PpsWebJsObject", "method(openApp)#Call Method");
        CoreApi.reportEvent(this.f27469b, new OpenEventInfo(2, this.f27475h, this.f27476i));
        AppMarketApi.openNative(ApplicationWrapper.getInstance().getContext(), this.f27472e);
    }

    @JavascriptInterface
    public void pause() {
        n9.a.f52175d.i("PpsWebJsObject", "method(pause)#Call Method");
        PauseTaskIPCRequest pauseTaskIPCRequest = new PauseTaskIPCRequest();
        pauseTaskIPCRequest.setPackageName(this.f27472e);
        pauseTaskIPCRequest.setMediaPkg(AgdAdManager.getConfig().getMediaPkgName());
        AgdManager.pauseTask(this.f27477j, pauseTaskIPCRequest, this.f27469b, this.f27470c);
    }

    @JavascriptInterface
    public String queryDownloadStatus() {
        if (!this.f27468a) {
            k9.b.d().b(this);
            this.f27468a = true;
        }
        DownloadStatus c4 = k9.b.d().c(this.f27472e);
        n9.a.f52175d.i("PpsWebJsObject", "getDownloadStatus is " + ((Object) c4));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", b(c4.status));
            jSONObject.put("percentage", c4.progress);
        } catch (JSONException unused) {
            n9.a.f52175d.e("PpsWebJsObject", "queryDownloadStatus::put Json data error");
        }
        n9.a.f52175d.i("PpsWebJsObject", "queryDownloadStatus return " + jSONObject.toString());
        return jSONObject.toString();
    }

    @Override // com.huawei.appgallery.agd.core.internalapi.IReloadWhiteList
    public void reloadWhiteListSuccess() {
        this.f27479l = false;
    }

    public int resumeDownload() {
        n9.a.f52175d.i("PpsWebJsObject", "run method(resumeDownload)");
        ResumeTaskIPCRequest resumeTaskIPCRequest = new ResumeTaskIPCRequest();
        resumeTaskIPCRequest.setPackageName(this.f27472e);
        resumeTaskIPCRequest.setSupportFunction(1);
        resumeTaskIPCRequest.setMediaPkg(AgdAdManager.getConfig().getMediaPkgName());
        AgdManager.resumeTask(this.f27477j, resumeTaskIPCRequest, this.f27469b, this.f27470c);
        return 0;
    }

    @JavascriptInterface
    public int download(String str, int i10) {
        n9.a.f52175d.i("PpsWebJsObject", "method(download(String,int))#Call Method params:" + str + ";" + i10);
        if (i10 == 0) {
            return download();
        }
        return -1;
    }

    @JavascriptInterface
    public int download() {
        n9.a aVar = n9.a.f52175d;
        aVar.i("PpsWebJsObject", "run method(download) ");
        WebView webView = this.f27478k;
        if (webView == null) {
            aVar.e("PpsWebJsObject", "Failed to check whitelist in PpsWebJsObject mWebView is null");
            return -1;
        }
        if (!j.c(webView, this)) {
            aVar.e("PpsWebJsObject", "Failed to check whitelist in PpsWebJsObject");
            MaintBi.reportCheckWapWhiteListError(2, new b(this.f27478k).b());
            return -1;
        }
        CoreApi.reportEvent(this.f27469b, new OpenEventInfo(2, this.f27475h, this.f27476i));
        DownloadStatus c4 = k9.b.d().c(this.f27472e);
        aVar.i("PpsWebJsObject", "getDownloadStatus is " + ((Object) c4));
        int i10 = c4.status;
        if (i10 == 2) {
            resumeDownload();
            return 0;
        }
        if (i10 == 1) {
            aVar.i("PpsWebJsObject", "downloadStatus is downloading, no need to handle");
            return 0;
        }
        callAgdDownload(AgdConstant.INSTALL_TYPE_AUTO);
        return 0;
    }
}
