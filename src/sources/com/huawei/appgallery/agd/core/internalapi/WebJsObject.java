package com.huawei.appgallery.agd.core.internalapi;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.text.TextUtils;
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
import com.huawei.appgallery.agd.base.util.CommonUtils;
import com.huawei.appgallery.agd.base.util.DeepLinkUtils;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.appgallery.agd.core.api.CoreConstants;
import com.huawei.appgallery.agd.core.impl.AgdAdManager;
import com.huawei.appgallery.agd.core.impl.report.MaintBi;
import com.huawei.appgallery.agd.serverreq.BuildConfig;
import com.huawei.appmarket.service.externalservice.distribution.download.request.PauseTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.ResumeTaskIPCRequest;
import com.huawei.appmarket.service.externalservice.distribution.download.request.StartDownloadV2IPCRequest;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import m9.j;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class WebJsObject implements IAppStatusListener, IReloadWhiteList {

    /* renamed from: b, reason: collision with root package name */
    public final String f27484b;

    /* renamed from: c, reason: collision with root package name */
    public final String f27485c;

    /* renamed from: d, reason: collision with root package name */
    public final String f27486d;

    /* renamed from: e, reason: collision with root package name */
    public final String f27487e;

    /* renamed from: f, reason: collision with root package name */
    public final String f27488f;

    /* renamed from: g, reason: collision with root package name */
    public final String f27489g;

    /* renamed from: h, reason: collision with root package name */
    public final String f27490h;

    /* renamed from: i, reason: collision with root package name */
    public final Activity f27491i;

    /* renamed from: j, reason: collision with root package name */
    public final WebView f27492j;

    /* renamed from: a, reason: collision with root package name */
    public boolean f27483a = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f27493k = true;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class LifecycleRunnable implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final Activity f27494b;

        public LifecycleRunnable(@NonNull Activity activity) {
            this.f27494b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentCallbacks2 componentCallbacks2 = this.f27494b;
            if (componentCallbacks2 instanceof LifecycleOwner) {
                ((LifecycleOwner) componentCallbacks2).getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.huawei.appgallery.agd.core.internalapi.WebJsObject.LifecycleRunnable.1
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                            k9.b.d().h(WebJsObject.this);
                            n9.a.f52175d.e("NativeObject", "LifecycleRunnable remove listener");
                            lifecycleOwner.getLifecycle().removeObserver(this);
                        }
                    }
                });
            }
        }
    }

    public WebJsObject(@NonNull Activity activity, String str, WebView webView) {
        this.f27491i = activity;
        wa.b bVar = new wa.b(new SafeIntent(activity.getIntent()).getExtras());
        this.f27484b = bVar.e(IntentKey.INTENT_KEY_SLOT_ID, "");
        this.f27485c = bVar.e(IntentKey.INTENT_KEY_SOURCE, "");
        this.f27486d = bVar.e(IntentKey.INTENT_KEY_DOWNLOAD_PARAM, "");
        this.f27487e = bVar.e(IntentKey.INTENT_KEY_PACKAGE_NAME, "");
        this.f27488f = bVar.e(IntentKey.INTENT_KEY_ICON_URI, "");
        this.f27489g = bVar.e(IntentKey.INTENT_KEY_APP_NAME, "");
        this.f27492j = webView;
        this.f27490h = str;
        activity.runOnUiThread(new LifecycleRunnable(activity));
    }

    public final String a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            String optString = jSONObject.optString("appName", this.f27489g);
            jSONObject2.put("name", optString);
            jSONObject2.put("icon", jSONObject.optString(DBDefinition.ICON_URL, this.f27488f));
            n9.a.f52175d.i("NativeObject", "getAppInfo from js " + optString);
        } catch (JSONException unused) {
            n9.a.f52175d.e("NativeObject", "appInfo JSONException ");
        }
        return jSONObject2.toString();
    }

    public void b(String str, JSONObject jSONObject) {
        StartDownloadV2IPCRequest startDownloadV2IPCRequest = new StartDownloadV2IPCRequest();
        startDownloadV2IPCRequest.setPackageName(this.f27487e);
        startDownloadV2IPCRequest.setMediaPkg(AgdAdManager.getConfig().getMediaPkgName());
        startDownloadV2IPCRequest.setInstallType(str);
        startDownloadV2IPCRequest.setDownloadFlag(1);
        startDownloadV2IPCRequest.setSupportFunction(1);
        startDownloadV2IPCRequest.setReferrer(this.f27484b);
        startDownloadV2IPCRequest.setDownloadParams(this.f27486d);
        startDownloadV2IPCRequest.setAppInfo(a(jSONObject));
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(CoreConstants.AGD_PRO_VER, BuildConfig.VERSION_CODE);
            jSONObject2.put(CoreConstants.MEDIA_PKG_SIGN, AgdAdManager.getConfig().getMediaPkgSign());
        } catch (JSONException unused) {
            n9.a.f52175d.e("NativeObject", "input json data failed! JSONException");
        }
        startDownloadV2IPCRequest.setJsonData(jSONObject2.toString());
        AgdManager.startDownloadTaskV2(this.f27491i, startDownloadV2IPCRequest, this.f27484b, this.f27485c);
    }

    @JavascriptInterface
    public int download(String str) {
        n9.a aVar = n9.a.f52175d;
        aVar.i("NativeObject", "method(download)#Call Method " + str);
        if (!j.c(this.f27492j, this)) {
            String b4 = new b(this.f27492j).b();
            aVar.e("NativeObject", "Failed to check whitelist in WebJsObject,url = " + b4);
            MaintBi.reportCheckWapWhiteListError(1, b4);
            return -1;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("packageName");
            if (!TextUtils.isEmpty(optString) && optString.equals(this.f27487e)) {
                b(AgdConstant.INSTALL_TYPE_AUTO, jSONObject);
                return 0;
            }
            MaintBi.reportNativeAdWapError("download::Package names are inconsistent:" + optString, this.f27490h);
            aVar.w("NativeObject", "method(download)#Package names are inconsistent");
            return -1;
        } catch (JSONException unused) {
            MaintBi.reportNativeAdWapError("download::Json data errorJson data error:" + str, this.f27490h);
            n9.a.f52175d.e("NativeObject", "method(download)#Json data error");
            return -1;
        }
    }

    @JavascriptInterface
    public String getAppStatus(String str) {
        if (!this.f27483a) {
            k9.b.d().b(this);
            this.f27483a = true;
        }
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str) && str.equals(this.f27487e)) {
            DownloadStatus c4 = k9.b.d().c(str);
            n9.a.f52175d.i("NativeObject", "getAppStatus return " + ((Object) c4));
            try {
                jSONObject.put("status", c4.status);
                jSONObject.put("progress", c4.progress);
            } catch (JSONException unused) {
                n9.a.f52175d.e("NativeObject", "getAppStatus::put Json data error:");
            }
            return jSONObject.toString();
        }
        n9.a.f52175d.w("NativeObject", "Package names are inconsistent");
        MaintBi.reportNativeAdWapError("getAppStatus PackageName is inconsistent: " + str, this.f27490h);
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String getMediaPkg() {
        n9.a.f52175d.i("NativeObject", "method(getMediaPkg)#Call Method");
        String mediaPkgName = AgdAdManager.getConfig().getMediaPkgName();
        return !TextUtils.isEmpty(mediaPkgName) ? mediaPkgName : ApplicationWrapper.getInstance().getContext().getPackageName();
    }

    @JavascriptInterface
    public boolean isInstalled(String str) {
        n9.a aVar = n9.a.f52175d;
        aVar.i("NativeObject", "method(isInstalled)#Call Method");
        try {
            String optString = new JSONObject(str).optString("packageName");
            if (!TextUtils.isEmpty(optString) && optString.equals(this.f27487e)) {
                return CommonUtils.hasAppInstalled(ApplicationWrapper.getInstance().getContext(), optString);
            }
            MaintBi.reportNativeAdWapError("isInstalled::Package names are inconsistent:" + optString, this.f27490h);
            aVar.w("NativeObject", "method(isInstalled)#Package names are inconsistent");
            return false;
        } catch (JSONException unused) {
            MaintBi.reportNativeAdWapError("isInstalled::Json data errorJson data error:" + str, this.f27490h);
            n9.a.f52175d.e("NativeObject", "method(isInstalled)#Json data error");
            return false;
        }
    }

    @JavascriptInterface
    public void launchApp(String str) {
        n9.a aVar = n9.a.f52175d;
        aVar.i("NativeObject", "method(launchApp)#Call Method");
        if (!StringUtils.isJSONString(str)) {
            aVar.e("NativeObject", "launchApp#Json data error");
            MaintBi.reportNativeAdWapError("launchApp::Json data error:" + str, this.f27490h);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("packageName");
            String string2 = jSONObject.getString("deepLink");
            if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string)) {
                MaintBi.reportNativeAdWapError("deeplink and pkgName all empty, " + str, this.f27490h);
                aVar.e("NativeObject", "launchApp#Json data error");
                return;
            }
            if (!TextUtils.isEmpty(string2)) {
                DeepLinkUtils.jumpDeeplink(ApplicationWrapper.getInstance().getContext(), string2);
                return;
            }
            if (string.equals(this.f27487e)) {
                AppMarketApi.openNative(ApplicationWrapper.getInstance().getContext(), string);
                return;
            }
            MaintBi.reportNativeAdWapError("launchApp::Package names are inconsistent:" + string, this.f27490h);
            aVar.w("NativeObject", "launchApp#Package names are inconsistent");
        } catch (JSONException unused) {
            MaintBi.reportNativeAdWapError("launchApp::Json data error:" + str, this.f27490h);
            n9.a.f52175d.e("NativeObject", "launchApp#launchApp Json data error");
        }
    }

    @Override // com.huawei.appgallery.agd.core.internalapi.IReloadWhiteList
    public boolean needReloadWhiteList() {
        return this.f27493k;
    }

    @Override // com.huawei.appgallery.agd.base.api.IAppStatusListener
    public void onStatusChange(@NonNull DownloadStatus downloadStatus) {
        n9.a.f52175d.i("NativeObject", "method(resumeDownload)#onStatusChange downloadStatus:" + ((Object) downloadStatus));
    }

    @JavascriptInterface
    public void pauseDownload(String str) {
        n9.a aVar = n9.a.f52175d;
        aVar.i("NativeObject", "method(pauseDownload)#Call Method");
        if (!TextUtils.isEmpty(str) && str.equals(this.f27487e)) {
            PauseTaskIPCRequest pauseTaskIPCRequest = new PauseTaskIPCRequest();
            pauseTaskIPCRequest.setPackageName(this.f27487e);
            pauseTaskIPCRequest.setMediaPkg(AgdAdManager.getConfig().getMediaPkgName());
            AgdManager.pauseTask(this.f27491i, pauseTaskIPCRequest, this.f27484b, this.f27485c);
            return;
        }
        aVar.w("NativeObject", "method(pauseDownload)#Package names are inconsistent");
        MaintBi.reportNativeAdWapError("pauseDownload::Package names are inconsistent:" + str, this.f27490h);
    }

    @Override // com.huawei.appgallery.agd.core.internalapi.IReloadWhiteList
    public void reloadWhiteListSuccess() {
        this.f27493k = false;
    }

    @JavascriptInterface
    public int resumeDownload(String str) {
        n9.a aVar = n9.a.f52175d;
        aVar.i("NativeObject", "method(resumeDownload)#Call Method");
        if (!TextUtils.isEmpty(str) && str.equals(this.f27487e)) {
            if (!j.c(this.f27492j, this)) {
                String b4 = new b(this.f27492j).b();
                aVar.e("NativeObject", "Failed to check whitelist in WebJsObject,url = " + b4);
                MaintBi.reportCheckWapWhiteListError(1, b4);
                return -1;
            }
            ResumeTaskIPCRequest resumeTaskIPCRequest = new ResumeTaskIPCRequest();
            resumeTaskIPCRequest.setPackageName(str);
            resumeTaskIPCRequest.setSupportFunction(1);
            resumeTaskIPCRequest.setMediaPkg(AgdAdManager.getConfig().getMediaPkgName());
            AgdManager.resumeTask(this.f27491i, resumeTaskIPCRequest, this.f27484b, this.f27485c);
            return 0;
        }
        aVar.w("NativeObject", "method(resumeDownload)#Package names are inconsistent");
        MaintBi.reportNativeAdWapError("resumeDownload::Package names are inconsistent:" + str, this.f27490h);
        return -1;
    }

    @JavascriptInterface
    public void toDetailPage(String str) {
        n9.a aVar = n9.a.f52175d;
        aVar.i("NativeObject", "method(toDetailPage)#Call Method");
        if (!TextUtils.isEmpty(str) && str.equals(this.f27487e)) {
            b(AgdConstant.INSTALL_TYPE_FULL_MANUAL, null);
        } else {
            aVar.w("NativeObject", "toDetailPage#Package names are inconsistent");
            MaintBi.reportNativeAdWapError("toDetailPage::Package names are inconsistent", this.f27490h);
        }
    }
}
