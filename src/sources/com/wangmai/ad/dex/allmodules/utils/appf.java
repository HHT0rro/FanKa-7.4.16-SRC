package com.wangmai.ad.dex.allmodules.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.wangmai.ad.dex.allmodules.R$id;
import com.wangmai.ad.dex.allmodules.R$layout;
import com.wangmai.ad.dex.allmodules.WMAppWebView;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.ad.dex.allmodules.bean.BidPriceMediaRequestBean;
import com.wangmai.ad.dex.allmodules.bean.DownloadBean;
import com.wangmai.ad.dex.allmodules.bean.HeadMediaRequestBean;
import com.wangmai.ad.dex.allmodules.bean.ReportDeviceBean;
import com.wangmai.ad.dex.allmodules.utils.appi;
import com.wangmai.appsdkdex.WMDexAdHelper;
import com.wangmai.appsdkdex.WMLandscapeActivity;
import com.wangmai.appsdkdex.WMPortraitActivity;
import com.wangmai.bean.WmConfigBean;
import com.wangmai.common.Ilistener.IWMAppDownloadListener;
import com.wangmai.common.runnable.HasTypeRunnable;
import com.wangmai.common.utils.AesUtil;
import com.wangmai.common.utils.ConstantInfo;
import com.wangmai.common.utils.GsonUtils;
import com.wangmai.common.utils.PrivateInfoHelper;
import com.wangmai.common.utils.SharedPreferencesHelper;
import com.wangmai.common.utils.Utils;
import com.wangmai.common.utils.WMResources;
import com.wangmai.common.view.CustomWebView;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.cache.CacheMode;
import com.wangmai.okhttp.callback.BitmapCallback;
import com.wangmai.okhttp.callback.EmptyCallback;
import com.wangmai.okhttp.callback.StringCallback;
import com.wangmai.okhttp.model.HttpHeaders;
import com.wangmai.okhttp.model.Response;
import com.wangmai.okhttp.request.GetRequest;
import com.wangmai.okhttp.request.PostRequest;
import com.wangmai.okserver.OkDownload;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: Constant.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appf {

    /* renamed from: a, reason: collision with root package name */
    static IWMAppDownloadListener f46825a = null;

    /* renamed from: appa, reason: collision with root package name */
    public static String f46826appa = "https://sdk.mobads.adwangmai.com/";
    public static String appb = f46826appa;
    public static int appc = 3000;
    public static String appd = "";
    public static int appe = 0;
    public static int appf = 0;
    public static int appg = 0;
    public static int apph = 0;
    public static int appi = 0;
    public static int appj = 0;
    public static String appk = null;
    public static int appl = 0;
    public static int appm = 1;
    public static int appn = 2;
    public static String appo;
    public static String appp;
    public static String appq;
    public static String appr;
    public static String apps;
    public static String appt;
    public static String appu;
    public static String appv;
    public static String appw;
    public static String appx;
    public static String appy;
    public static String appz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: Constant.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa implements View.OnClickListener {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ ApiBean.DownloadAppInfo f46827appa;
        final /* synthetic */ TextView appb;
        final /* synthetic */ CustomWebView appc;
        final /* synthetic */ com.wangmai.ad.dex.allmodules.utils.appl appd;

        appa(ApiBean.DownloadAppInfo downloadAppInfo, TextView textView, CustomWebView customWebView, com.wangmai.ad.dex.allmodules.utils.appl applVar) {
            this.f46827appa = downloadAppInfo;
            this.appb = textView;
            this.appc = customWebView;
            this.appd = applVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f46827appa.getPrivacy())) {
                return;
            }
            this.appb.setText("隐私协议");
            this.appc.loadUrl(this.f46827appa.getPrivacy());
            this.appd.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: Constant.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb implements View.OnClickListener {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ TextView f46828appa;
        final /* synthetic */ ApiBean.DownloadAppInfo appb;
        final /* synthetic */ CustomWebView appc;
        final /* synthetic */ com.wangmai.ad.dex.allmodules.utils.appl appd;

        appb(TextView textView, ApiBean.DownloadAppInfo downloadAppInfo, CustomWebView customWebView, com.wangmai.ad.dex.allmodules.utils.appl applVar) {
            this.f46828appa = textView;
            this.appb = downloadAppInfo;
            this.appc = customWebView;
            this.appd = applVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f46828appa.setText("功能介绍");
            if (!TextUtils.isEmpty(this.appb.getDesc_url())) {
                this.appc.loadUrl(this.appb.getDesc_url());
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("<html>");
                stringBuffer.append("<head><style>body{margin:0;padding:50 15 30 15;font-size:38;color:#666666}div{font-size:50;padding-bottom:30;color:#333333;font-weight:bold}</style></head>");
                stringBuffer.append("<body>");
                stringBuffer.append(this.appb.getDesc());
                stringBuffer.append("</body></html>");
                this.appc.loadDataWithBaseURL(null, stringBuffer.toString(), "text/html", "utf-8", null);
            }
            this.appd.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: Constant.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appd extends StringCallback {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46830appa;

        appd(String str) {
            this.f46830appa = str;
        }

        @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
        public void onError(Response<String> response) {
            appa.appa.appf.appd.appe("Constant", this.f46830appa + "失败：" + ((Object) response.getRawCall().request().url()));
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<String> response) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: Constant.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appe extends StringCallback {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ int f46831appa;

        appe(int i10) {
            this.f46831appa = i10;
        }

        @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
        public void onError(Response<String> response) {
            super.onError(response);
            appa.appa.appf.appd.appe("Constant", "API曝光上报失败:" + response.getException().toString());
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<String> response) {
            if (this.f46831appa == 0) {
                appa.appa.appf.appd.appa("Constant", "API曝光上报成功");
            } else {
                appa.appa.appf.appd.appa("Constant", "API曝光(不可视)上报成功");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: Constant.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.utils.appf$appf, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class C0695appf extends StringCallback {
        C0695appf() {
        }

        @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
        public void onError(Response<String> response) {
            appa.appa.appf.appd.appe("Constant", "API点击上报失败:" + response.getException().toString());
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<String> response) {
            appa.appa.appf.appd.appa("Constant", "API点击上报成功");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: Constant.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appg implements com.wangmai.ad.dex.allmodules.utils.appm {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ Context f46832appa;
        final /* synthetic */ String appb;

        appg(Context context, String str) {
            this.f46832appa = context;
            this.appb = str;
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appa() {
            appa.appa.appf.appd.appe("Constant", "应用下载失败 on WebView:" + this.appb);
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appa(int i10) {
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appb() {
            Toast.makeText(this.f46832appa, "开始下载", 0).show();
            appa.appa.appf.appd.appa("onWebViewDownloadStart", "开始下载:", this.appb);
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appc() {
            Toast.makeText(this.f46832appa, "该文件正在下载中,请稍后", 0).show();
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appa(String str) {
            appa.appa.appf.appd.appa("onWebViewDownloadStart", "下载成功:", this.appb);
            com.wangmai.ad.dex.allmodules.utils.appd.appc(this.f46832appa, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: Constant.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class apph implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        appq f46833appa;
        final /* synthetic */ String appb;
        final /* synthetic */ String appc;
        final /* synthetic */ HasTypeRunnable appd;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* compiled from: Constant.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class appa implements Runnable {
            appa() {
            }

            @Override // java.lang.Runnable
            public void run() {
                apph apphVar = apph.this;
                apphVar.appd.run(apphVar.f46833appa);
            }
        }

        apph(String str, String str2, HasTypeRunnable hasTypeRunnable) {
            this.appb = str;
            this.appc = str2;
            this.appd = hasTypeRunnable;
            this.f46833appa = new appq(this.appb);
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpURLConnection httpURLConnection;
            int responseCode;
            try {
                httpURLConnection = (HttpURLConnection) new URL(this.appb).openConnection();
                httpURLConnection.setRequestMethod(this.appc);
                httpURLConnection.setInstanceFollowRedirects(false);
                responseCode = httpURLConnection.getResponseCode();
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("Constant", "urlIsValidForApk exception:" + th.toString());
            }
            if (405 == responseCode) {
                if (TextUtils.equals(this.appc, "GET")) {
                    appf.appb(this.appb, "POST", this.appd);
                    return;
                } else {
                    if (TextUtils.equals(this.appc, "POST")) {
                        appf.appb(this.appb, "GET", this.appd);
                        return;
                    }
                    return;
                }
            }
            if (302 == responseCode || 301 == responseCode || 307 == responseCode || 308 == responseCode) {
                appf.appb(httpURLConnection.getHeaderField("Location"), this.appc, this.appd);
                return;
            }
            new Handler(Looper.getMainLooper()).post(new appa());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: Constant.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appi extends StringCallback {
        appi() {
        }

        @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
        public void onError(Response<String> response) {
            super.onError(response);
            appa.appa.appf.appd.appa("Constant", "异常上报失败：" + ((Object) response));
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<String> response) {
            appa.appa.appf.appd.appa("Constant", "异常上报完成：" + ((Object) response));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: Constant.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appj implements appi.apph {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ ApiBean f46835appa;
        final /* synthetic */ String appb;
        final /* synthetic */ float appc;
        final /* synthetic */ float appd;
        final /* synthetic */ float appe;
        final /* synthetic */ float appf;
        final /* synthetic */ Context appg;
        final /* synthetic */ com.wangmai.ad.dex.allmodules.appf.appa apph;
        final /* synthetic */ String appi;
        final /* synthetic */ String appj;
        final /* synthetic */ int appk;
        final /* synthetic */ boolean appl;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* compiled from: Constant.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class appa extends StringCallback {

            /* renamed from: appa, reason: collision with root package name */
            final /* synthetic */ ApiBean.WxadBean f46836appa;

            appa(ApiBean.WxadBean wxadBean) {
                this.f46836appa = wxadBean;
            }

            @Override // com.wangmai.okhttp.callback.Callback
            public void onSuccess(Response<String> response) {
                DownloadBean downloadBean;
                try {
                    downloadBean = (DownloadBean) GsonUtils.getInstance().fromJson(response.body(), DownloadBean.class);
                } catch (Throwable th) {
                    appf.appa(appj.this.appg, "", th.toString());
                    downloadBean = null;
                }
                if (downloadBean == null || downloadBean.getRet() != 0) {
                    return;
                }
                String replaceAll = downloadBean.getData().getDstlink().replaceAll("(?i)__CLICKID__", downloadBean.getData().getClickid());
                appa.appa.appf.appd.appa("Constant", "dstlink_url   " + replaceAll);
                SharedPreferencesHelper.getInstance(appj.this.appg).savePreferencesString("clickid", downloadBean.getData().getClickid());
                if (this.f46836appa.getDownloaded_track_urls() == null || this.f46836appa.getDownloaded_track_urls().size() <= 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < this.f46836appa.getDownloaded_track_urls().size(); i10++) {
                    arrayList.set(i10, this.f46836appa.getDownloaded_track_urls().get(i10).replaceAll("(?i)__CLICK_ID__", downloadBean.getData().getClickid()));
                }
                Context context = appj.this.appg;
                String app_package = this.f46836appa.getApp_package();
                appj appjVar = appj.this;
                appf.appb(context, app_package, appjVar.appj, appjVar.f46835appa, appjVar.appk, appjVar.apph, appjVar.appl, replaceAll, this.f46836appa.getDownload_track_urls(), arrayList, appj.this.f46835appa.getOptimization().getModelStoreStatus());
            }
        }

        appj(ApiBean apiBean, String str, float f10, float f11, float f12, float f13, Context context, com.wangmai.ad.dex.allmodules.appf.appa appaVar, String str2, String str3, int i10, boolean z10) {
            this.f46835appa = apiBean;
            this.appb = str;
            this.appc = f10;
            this.appd = f11;
            this.appe = f12;
            this.appf = f13;
            this.appg = context;
            this.apph = appaVar;
            this.appi = str2;
            this.appj = str3;
            this.appk = i10;
            this.appl = z10;
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appi.apph
        public void appa() {
            try {
                if (TextUtils.isEmpty(this.appb)) {
                    appa.appa.appf.appd.appe("Constant", "落地页为空，终止流程");
                    return;
                }
                ApiBean.WxadBean wxad = this.f46835appa.getRespObj().getWxad();
                String appb = appf.appb(this.appb, this.appc, this.appd, this.appe, this.appf);
                int interaction_type = wxad.getInteraction_type();
                if (interaction_type == 1) {
                    if (TextUtils.isEmpty(this.appi)) {
                        appf.appc(this.appg, appb);
                        if (this.apph != null) {
                            this.apph.destroy();
                            return;
                        }
                        return;
                    }
                    if (!TextUtils.isEmpty(wxad.getApp_package()) && !Utils.checkAppInstalled(this.appg, wxad.getApp_package())) {
                        appf.appa(wxad.getDp_app_uninstalled_urls(), "APP未安装上报");
                    }
                    appf.appa(wxad.getDp_failed_track_urls(), "DP唤醒失败上报");
                    int length = appb.length();
                    if (!TextUtils.isEmpty(this.appb) && !".apk".equals(appb.substring(length - 4, length))) {
                        appa.appa.appf.appd.appa("Constant", "deeplink唤醒失败，打开落地页");
                        appf.appc(this.appg, appb);
                        if (this.apph != null) {
                            this.apph.destroy();
                            return;
                        }
                        return;
                    }
                    appa.appa.appf.appd.appa("Constant", "API App下载地址：" + appb);
                    appf.appb(this.appg, wxad.getApp_package(), this.appj, this.f46835appa, this.appk, this.apph, this.appl, appb, wxad.getDownload_track_urls(), wxad.getDownloaded_track_urls(), this.f46835appa.getOptimization().getModelStoreStatus());
                    return;
                }
                if (interaction_type == 2) {
                    if (TextUtils.isEmpty(this.appi)) {
                        if (TextUtils.isEmpty(wxad.getApp_package())) {
                            return;
                        }
                        if (!Utils.checkAppInstalled(this.appg, wxad.getApp_package())) {
                            appf.appa(wxad.getDp_app_uninstalled_urls(), "APP未安装上报");
                        }
                        if (appf.appb(this.appg, wxad.getApp_package())) {
                            appf.appb(this.appg, wxad.getApp_package(), this.appj, this.f46835appa, this.appk, this.apph, this.appl, appb, wxad.getDownload_track_urls(), wxad.getDownloaded_track_urls(), this.f46835appa.getOptimization().getModelStoreStatus());
                            return;
                        }
                        return;
                    }
                    appf.appa(wxad.getDp_failed_track_urls(), "DP唤醒失败上报");
                    return;
                }
                if (interaction_type == 3) {
                    OkHttp.get(appb).execute(new appa(wxad));
                    return;
                }
                if (interaction_type == 4) {
                    if (!TextUtils.isEmpty(wxad.getMini_program_id())) {
                        if (appz.appa(this.appg, wxad.getMini_program_id(), wxad.getMini_program_path())) {
                            appf.appa(wxad.getMini_program_success_track_urls(), "调起微信成功上报");
                            return;
                        }
                        appa.appa.appf.appd.appa("Constant", "不支持微信环境或打开微信小程序失败，打开落地页");
                        appf.appc(this.appg, appb);
                        if (this.apph != null) {
                            this.apph.destroy();
                            return;
                        }
                        return;
                    }
                    appa.appa.appf.appd.appa("Constant", "目标小程序缺失必要唤醒信息，打开落地页");
                    appf.appc(this.appg, appb);
                    if (this.apph != null) {
                        this.apph.destroy();
                        return;
                    }
                    return;
                }
                if (interaction_type != 5) {
                    return;
                }
                if (TextUtils.isEmpty(this.appi)) {
                    if (!TextUtils.isEmpty(wxad.getApp_package())) {
                        if (Utils.isAppInstalled(this.appg, wxad.getApp_package())) {
                            Intent launchIntentForPackage = this.appg.getPackageManager().getLaunchIntentForPackage(wxad.getApp_package());
                            if (launchIntentForPackage != null) {
                                appa.appa.appf.appd.appa("Constant", "App已安装，直接打开");
                                launchIntentForPackage.setFlags(268435456);
                                this.appg.startActivity(launchIntentForPackage);
                                return;
                            }
                            return;
                        }
                        try {
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setFlags(268435456);
                            intent.setData(Uri.parse("market://details?id=" + wxad.getApp_package()));
                            this.appg.startActivity(intent);
                        } catch (Throwable unused) {
                            appa.appa.appf.appd.appe("Constant", "应用商店获取失败");
                        }
                    } else {
                        appa.appa.appf.appd.appe("Constant", "packageName为空");
                    }
                } else {
                    appf.appa(wxad.getDp_failed_track_urls(), "DP唤醒失败上报");
                }
                if (this.apph != null) {
                    this.apph.destroy();
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("Constant", "DP调起失败后续链路出错：" + ((Object) th));
                appf.appa(this.appg, "", "DP调起失败后续链路出错：" + th.getMessage());
            }
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appi.apph
        public void appb() {
            try {
                ApiBean.WxadBean wxad = this.f46835appa.getRespObj().getWxad();
                String appb = appf.appb(this.appb, this.appc, this.appd, this.appe, this.appf);
                int interaction_type = wxad.getInteraction_type();
                if (interaction_type != 1) {
                    if (interaction_type != 2 && interaction_type != 3 && interaction_type != 4 && interaction_type != 5) {
                        if (this.apph != null) {
                            appa.appa.appf.appd.appa("Constant", "apiAdControl.destroy");
                            this.apph.destroy();
                            return;
                        }
                        return;
                    }
                    appf.appa(wxad.getDp_success_track_urls(), "DP唤醒成功上报");
                    return;
                }
                if (!TextUtils.isEmpty(wxad.getApp_package())) {
                    appf.appa(wxad.getDp_app_installed_urls(), "App已安装上报");
                }
                appf.appa(wxad.getDp_success_track_urls(), "DP唤醒成功上报");
                try {
                    if (this.f46835appa == null || this.f46835appa.getOptimization() == null || this.f46835appa.getOptimization().getDpLandingPageObj() == null || this.f46835appa.getOptimization().getDpLandingPageObj().getOpenBtn() != 1 || Math.random() * 100.0d >= this.f46835appa.getOptimization().getDpLandingPageObj().getOpenRand()) {
                        return;
                    }
                    appa.appa.appf.appd.appa("Constant", "同时调起落地页", appb);
                    appf.appc(this.appg, appb);
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe("Constant", "同时打开落地页失败：" + th.toString());
                }
            } catch (Throwable th2) {
                appa.appa.appf.appd.appe("Constant", "DP调起成功后续链路出错：" + ((Object) th2));
                appf.appa(this.appg, "", "DP调起成功后续链路出错：" + th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: Constant.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appk extends BitmapCallback {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ ImageView f46837appa;

        appk(ImageView imageView) {
            this.f46837appa = imageView;
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<Bitmap> response) {
            if (response != null) {
                this.f46837appa.setImageBitmap(response.body());
                this.f46837appa.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: Constant.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appl implements View.OnClickListener {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ CustomWebView f46838appa;
        final /* synthetic */ com.wangmai.ad.dex.allmodules.utils.appl appb;

        appl(CustomWebView customWebView, com.wangmai.ad.dex.allmodules.utils.appl applVar) {
            this.f46838appa = customWebView;
            this.appb = applVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f46838appa.clearView();
            this.appb.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: Constant.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appm implements View.OnClickListener {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ com.wangmai.ad.dex.allmodules.utils.appl f46839appa;
        final /* synthetic */ com.wangmai.ad.dex.allmodules.utils.appl appb;
        final /* synthetic */ com.wangmai.ad.dex.allmodules.appf.appa appc;

        appm(com.wangmai.ad.dex.allmodules.utils.appl applVar, com.wangmai.ad.dex.allmodules.utils.appl applVar2, com.wangmai.ad.dex.allmodules.appf.appa appaVar) {
            this.f46839appa = applVar;
            this.appb = applVar2;
            this.appc = appaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f46839appa.dismiss();
            this.appb.dismiss();
            com.wangmai.ad.dex.allmodules.appf.appa appaVar = this.appc;
            if (appaVar != null) {
                appaVar.resume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: Constant.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appn implements View.OnClickListener {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ Context f46840appa;
        final /* synthetic */ String appb;
        final /* synthetic */ String appc;
        final /* synthetic */ boolean appd;
        final /* synthetic */ String appe;
        final /* synthetic */ List appf;
        final /* synthetic */ List appg;
        final /* synthetic */ com.wangmai.ad.dex.allmodules.utils.appl apph;
        final /* synthetic */ com.wangmai.ad.dex.allmodules.utils.appl appi;
        final /* synthetic */ com.wangmai.ad.dex.allmodules.appf.appa appj;

        appn(Context context, String str, String str2, boolean z10, String str3, List list, List list2, com.wangmai.ad.dex.allmodules.utils.appl applVar, com.wangmai.ad.dex.allmodules.utils.appl applVar2, com.wangmai.ad.dex.allmodules.appf.appa appaVar) {
            this.f46840appa = context;
            this.appb = str;
            this.appc = str2;
            this.appd = z10;
            this.appe = str3;
            this.appf = list;
            this.appg = list2;
            this.apph = applVar;
            this.appi = applVar2;
            this.appj = appaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            appf.appb(this.f46840appa, this.appb, this.appc, this.appd, this.appe, this.appf, this.appg);
            this.apph.dismiss();
            this.appi.dismiss();
            com.wangmai.ad.dex.allmodules.appf.appa appaVar = this.appj;
            if (appaVar != null) {
                appaVar.resume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: Constant.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appo implements View.OnClickListener {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ Context f46841appa;
        final /* synthetic */ String appb;
        final /* synthetic */ String appc;
        final /* synthetic */ boolean appd;
        final /* synthetic */ String appe;
        final /* synthetic */ List appf;
        final /* synthetic */ List appg;
        final /* synthetic */ com.wangmai.ad.dex.allmodules.utils.appl apph;
        final /* synthetic */ com.wangmai.ad.dex.allmodules.appf.appa appi;
        final /* synthetic */ com.wangmai.ad.dex.allmodules.utils.appl appj;

        appo(Context context, String str, String str2, boolean z10, String str3, List list, List list2, com.wangmai.ad.dex.allmodules.utils.appl applVar, com.wangmai.ad.dex.allmodules.appf.appa appaVar, com.wangmai.ad.dex.allmodules.utils.appl applVar2) {
            this.f46841appa = context;
            this.appb = str;
            this.appc = str2;
            this.appd = z10;
            this.appe = str3;
            this.appf = list;
            this.appg = list2;
            this.apph = applVar;
            this.appi = appaVar;
            this.appj = applVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            appf.appb(this.f46841appa, this.appb, this.appc, this.appd, this.appe, this.appf, this.appg);
            this.apph.dismiss();
            com.wangmai.ad.dex.allmodules.appf.appa appaVar = this.appi;
            if (appaVar != null) {
                appaVar.resume();
            }
            this.appj.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: Constant.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appp implements View.OnClickListener {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ TextView f46842appa;
        final /* synthetic */ ApiBean.DownloadAppInfo appb;
        final /* synthetic */ CustomWebView appc;
        final /* synthetic */ Context appd;
        final /* synthetic */ com.wangmai.ad.dex.allmodules.utils.appl appe;

        appp(TextView textView, ApiBean.DownloadAppInfo downloadAppInfo, CustomWebView customWebView, Context context, com.wangmai.ad.dex.allmodules.utils.appl applVar) {
            this.f46842appa = textView;
            this.appb = downloadAppInfo;
            this.appc = customWebView;
            this.appd = context;
            this.appe = applVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f46842appa.setText("应用权限");
            if (!TextUtils.isEmpty(this.appb.getPermission_url())) {
                this.appc.loadUrl(this.appb.getPermission_url());
            } else {
                List<ApiBean.Permission> permissions_list_bean = this.appb.getPermissions_list_bean(this.appd);
                StringBuffer stringBuffer = new StringBuffer();
                for (int i10 = 0; i10 < permissions_list_bean.size(); i10++) {
                    ApiBean.Permission permission = permissions_list_bean.get(i10);
                    stringBuffer.append("<li>");
                    stringBuffer.append("<h3>");
                    stringBuffer.append(permission.getTitle());
                    stringBuffer.append("</h3>");
                    stringBuffer.append("<p>");
                    stringBuffer.append(permission.getDescription());
                    stringBuffer.append("</p>");
                    stringBuffer.append("</li>");
                }
                this.appc.loadDataWithBaseURL(null, "<html><head><style type=\"text/css\">*{margin:0;padding:0;}ul{padding:10px;}li{list-style:none;}li+li{margin-top:15px;}h3{font-size:14px;color:#000;}p{font-size:12px;color:#999;margin-top:5px;}</style><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\"/><meta name=\"format-detection\" content=\"telephone=no\" /><meta name=\"apple-mobile-web-app-capable\" content=\"yes\" /></head><body><div id=\"content\" style=\"margin-left:20px;margin-top:20px;margin-right:20px\">" + stringBuffer.toString() + "</div></body></html>", "text/html", "utf-8", null);
            }
            this.appe.show();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: Constant.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class appq {

        /* renamed from: appa, reason: collision with root package name */
        private String f46843appa;

        public appq(String str) {
            this.f46843appa = str;
        }

        public String appa() {
            return this.f46843appa;
        }

        public String toString() {
            return "ApkHelperBean{, actualUrl='" + this.f46843appa + "'}";
        }
    }

    static {
        appa();
    }

    public static void appb(Context context) {
        appc(context);
        appa(context);
    }

    private static void appc(Context context) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put("User-Agent", appx.appg(context));
        httpHeaders.put("User-AppToken", ConstantInfo.getAppToken());
        httpHeaders.put("User-Version", "6.6.0");
        httpHeaders.put("User-JarVersion", "4.2.0");
        OkHttp.getInstance().init(context).setRetryCount(0).addCommonHeaders(httpHeaders);
        OkDownload.getInstance().init();
        appa.appa.appf.appd.appa("Constant", "initNetWork", "initSuccess");
    }

    private static void appd(Context context) {
        try {
            WmConfigBean appa2 = appa.appa.appf.appc.appa(context);
            if (appa2 == null || TextUtils.isEmpty(appa2.getBaseUrl())) {
                return;
            }
            f46826appa = appa2.getBaseUrl();
            appb = appa2.getBaseUrl();
            appa();
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("Constant", "update config exception" + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: Constant.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appc implements com.wangmai.ad.dex.allmodules.utils.appm {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ Context f46829appa;
        final /* synthetic */ List appb;
        final /* synthetic */ List appc;

        appc(Context context, List list, List list2) {
            this.f46829appa = context;
            this.appb = list;
            this.appc = list2;
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appa() {
            appa.appa.appf.appd.appe("Constant downLoadUtils", "应用下载失败");
            IWMAppDownloadListener iWMAppDownloadListener = appf.f46825a;
            if (iWMAppDownloadListener != null) {
                iWMAppDownloadListener.onDownloadFailed();
            }
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appb() {
            Toast.makeText(this.f46829appa, "开始下载", 0).show();
            appa.appa.appf.appd.appa("Constant downLoadUtils", "开始下载:", Arrays.toString(this.appb.toArray()));
            IWMAppDownloadListener iWMAppDownloadListener = appf.f46825a;
            if (iWMAppDownloadListener != null) {
                iWMAppDownloadListener.onDownloadStarted();
            }
            appf.appa((List<String>) this.appb, "APP开始下载上报");
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appc() {
            Toast.makeText(this.f46829appa, "该文件正在下载中,请稍后", 0).show();
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appa(String str) {
            appf.appa((List<String>) this.appc, "APP下载完成上报");
            IWMAppDownloadListener iWMAppDownloadListener = appf.f46825a;
            if (iWMAppDownloadListener != null) {
                iWMAppDownloadListener.onDownloadFinished();
            }
            com.wangmai.ad.dex.allmodules.utils.appd.appc(this.f46829appa, str);
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appa(int i10) {
            IWMAppDownloadListener iWMAppDownloadListener = appf.f46825a;
            if (iWMAppDownloadListener != null) {
                iWMAppDownloadListener.onProgressUpdate(i10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String appb(String str, float f10, float f11, float f12, float f13) {
        String valueOf = String.valueOf(f10);
        String valueOf2 = String.valueOf(f11);
        String valueOf3 = String.valueOf(f12);
        String valueOf4 = String.valueOf(f13);
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            str2 = str.replaceAll("(?i)__down_x__", valueOf).replaceAll("(?i)__down_y__", valueOf2).replaceAll("(?i)__up_x__", valueOf3).replaceAll("(?i)__up_y__", valueOf4).replaceAll("(?i)__re_down_x__", "-999").replaceAll("(?i)__re_down_y__", "-999").replaceAll("(?i)__re_up_x__", "-999").replaceAll("(?i)__re_up_y__", "-999").replaceAll("(?i)__utc_end_ts__", "-999").replaceAll("(?i)__utc_ts__", System.currentTimeMillis() + "");
        }
        appa.appa.appf.appd.appa("Constant", "API点击事件，落地页原地址:url", str);
        appa.appa.appf.appd.appa("Constant", "API点击事件，落地页宏替换后地址：new Url", str2);
        return str2;
    }

    public static void appa() {
        try {
            appa.appa.appf.appd.appa("Constant", "updateNormalUrl", f46826appa, appb);
            String str = f46826appa + "sdk/pm.api";
            appo = f46826appa + "sdk/media/request.api";
            String str2 = f46826appa + "sdk/mc.api";
            appp = f46826appa + "sc/adsz/";
            appq = f46826appa + "displayNotice.api";
            String str3 = f46826appa + "clickNotice.api";
            appr = appb + "sdk/thrid/request.api";
            apps = appb + "sdk/thrid/rs.api";
            appt = f46826appa + "sdk/pap.api";
            appu = f46826appa + "sdk/thrid/rf.api";
            appv = appb + "sdk/displayReport.api";
            appw = appb + "sdk/clickReport.api";
            appx = appb + "sdk/winnotice.api";
            appy = appb + "sdk/report/error.api";
            appz = f46826appa + "permissionInfo.api";
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("Constant", "updateNormalUrl error:" + th.toString());
        }
    }

    public static void appc(Context context, String str) {
        Class cls;
        appa.appa.appf.appd.appa("Constant", "skipWebview", str);
        if (TextUtils.isEmpty(str)) {
            appa.appa.appf.appd.appe("Constant", "webview url is empty");
            return;
        }
        try {
            if (!str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("wmText://")) {
                if (str.startsWith("intent://")) {
                    appa.appa.appf.appd.appa("Constant", "skipWebview", "intent");
                    Intent parseUri = Intent.parseUri(str, 1);
                    parseUri.addFlags(268435456);
                    parseUri.addCategory("android.intent.category.BROWSABLE");
                    parseUri.setComponent(null);
                    parseUri.setSelector(null);
                    context.startActivity(parseUri);
                } else {
                    appa.appa.appf.appd.appa("Constant", "skipWebview", "intent2");
                    Intent intent = new Intent();
                    intent.addFlags(268435456);
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    context.startActivity(intent);
                }
            }
            appa.appa.appf.appd.appa("Constant", "skipWebview", "http or https");
            String str2 = "skipWebView" + System.currentTimeMillis();
            WMAppWebView wMAppWebView = new WMAppWebView(context, str2, str);
            Intent intent2 = new Intent();
            if (context.getResources().getConfiguration().orientation == 2) {
                cls = WMLandscapeActivity.class;
            } else {
                cls = WMPortraitActivity.class;
            }
            WMDexAdHelper.startActivty(context, str2, wMAppWebView, cls, intent2);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("Constant", "open webview exception:" + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean appb(Context context, String str) {
        try {
            if (Utils.isAppInstalled(context, str)) {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
                if (launchIntentForPackage == null) {
                    return true;
                }
                appa.appa.appf.appd.appa("Constant", "App已安装，直接打开");
                launchIntentForPackage.setFlags(268435456);
                context.startActivity(launchIntentForPackage);
                return false;
            }
            String absolutePath = com.wangmai.ad.dex.allmodules.utils.appq.appd().appa().getAbsolutePath();
            appa.appa.appf.appd.appa("Constant", "App未安装--" + absolutePath);
            List<String> filesAllName = Utils.getFilesAllName(absolutePath);
            if (filesAllName != null && filesAllName.size() > 0) {
                for (int i10 = 0; i10 < filesAllName.size(); i10++) {
                    String GetApkInfoPackageName = Utils.GetApkInfoPackageName(context, filesAllName.get(i10));
                    if (!TextUtils.isEmpty(GetApkInfoPackageName) && GetApkInfoPackageName.equals(str)) {
                        appa.appa.appf.appd.appa("Constant", "App未安装--已下载，直接安装");
                        com.wangmai.ad.dex.allmodules.utils.appd.appc(context, filesAllName.get(i10));
                        return false;
                    }
                }
            }
            appa.appa.appf.appd.appa("Constant", "App未安装--未下载");
            return true;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("Constant", "checkAppNeedDownload error" + th.toString());
            return true;
        }
    }

    private static void appa(Context context) {
        com.wangmai.ad.dex.allmodules.utils.apph.appa().appb(context);
        appd(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void appa(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            ReportDeviceBean reportDeviceBean = new ReportDeviceBean();
            reportDeviceBean.setOs("1");
            if (context == null) {
                str2 = str2 + ",context 为空";
            } else {
                try {
                    reportDeviceBean.setAppPackageName(context.getPackageName() + "");
                    reportDeviceBean.setOaid(PrivateInfoHelper.getOaid(context));
                    reportDeviceBean.setAppVersion(Utils.getVersionName(context) + "");
                    if (Build.VERSION.SDK_INT <= 28) {
                        reportDeviceBean.setImei(PrivateInfoHelper.getIMEI(context));
                    }
                } catch (Throwable unused) {
                    str2 = str2 + ",设备信息采集异常";
                }
            }
            try {
                reportDeviceBean.setOsVersion(Build.VERSION.RELEASE + "");
                reportDeviceBean.setBrand(Build.BRAND + "");
                reportDeviceBean.setModel(Build.MODEL + "");
                reportDeviceBean.setAdSlotId(str);
                reportDeviceBean.setRequestTimeValue(System.currentTimeMillis() + " ");
                reportDeviceBean.setError_info(str2);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("Constant", "exReport device exception:" + th.toString());
            }
            try {
                String json = GsonUtils.getInstance().toJson(reportDeviceBean);
                appa.appa.appf.appd.appe("Constant", "异常上报：" + json);
                ((PostRequest) OkHttp.post(appy).headers("Content-Type", "application/json")).upString(json).execute(new appi());
            } catch (Throwable th2) {
                appa.appa.appf.appd.appe("Constant", "exReport exception:" + th2.toString());
            }
        } catch (Throwable th3) {
            appa.appa.appf.appd.appe("Constant", "exReport exception2:" + th3.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appb(Context context, String str, String str2, ApiBean apiBean, int i10, com.wangmai.ad.dex.allmodules.appf.appa appaVar, boolean z10, String str3, List<String> list, List<String> list2, int i11) {
        try {
            appa.appa.appf.appd.appa("Constant", "下载类型=" + i11, "下载弹窗类型=" + i10);
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 != 2) {
                        if (i11 == 3) {
                            appa(context, str, str2, apiBean, i10, appaVar, z10, str3, list, list2);
                            appa(context, str, apiBean);
                        }
                    }
                } else if (!appa(context, str, str2, apiBean, i10, appaVar, z10, str3, list, list2)) {
                    appa(context, str, apiBean);
                }
            }
            if (!appa(context, str, apiBean)) {
                appa(context, str, str2, apiBean, i10, appaVar, z10, str3, list, list2);
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("Constant", "downLoadUtils error:" + ((Object) th));
            appa(context, "", "downLoadUtils error:" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appb(Context context, String str, String str2, boolean z10, String str3, List<String> list, List<String> list2) {
        com.wangmai.ad.dex.allmodules.utils.appn.appa().appa(context, str2, z10, 1, str3, new appc(context, list, list2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appb(String str, String str2, HasTypeRunnable<appq> hasTypeRunnable) {
        new Thread(new apph(str, str2, hasTypeRunnable)).start();
    }

    public static HeadMediaRequestBean appa(Context context, String str, String str2, String str3, String str4, int i10, int i11, int i12, String str5, long j10, long j11, String str6, int i13, int i14, int i15, double d10, double d11) {
        HeadMediaRequestBean appa2 = appa(context, str, str2, i11, i12, str5);
        if (appa2 != null) {
            appa2.setThirdSlotId(str3);
            appa2.setThirdAppId(str4);
            appa2.setThirdSlotIdKey(i10);
            appa2.settTime(j10);
            appa2.setcTime(j11);
            appa2.setErrorInfo(str6);
            try {
                double doubleValue = new BigDecimal(i13 / 100.0d).setScale(2, 4).doubleValue();
                double doubleValue2 = new BigDecimal(i15 / 100.0d).setScale(2, 4).doubleValue();
                double doubleValue3 = new BigDecimal(i14 / 100.0d).setScale(2, 4).doubleValue();
                appa2.setDspBidPrice(doubleValue);
                appa2.setDspWinPrice(doubleValue2);
                appa2.setWinPrice(doubleValue3);
                String format = String.format("%.2f", Double.valueOf(doubleValue * d10 * d11));
                String format2 = String.format("%.2f", Double.valueOf(doubleValue3 * d11));
                ArrayMap arrayMap = new ArrayMap();
                arrayMap.put("priceRatio", String.valueOf(d10));
                arrayMap.put("gapRatio", String.valueOf(d11));
                arrayMap.put("calcDspBidPrice", format);
                arrayMap.put("calcDspWinPrice", format);
                arrayMap.put("calcMediaWinPrice", format2);
                appa2.setExt_data(arrayMap);
            } catch (Throwable th) {
                appa.appa.appf.appd.appb("Constant", "getHeadMediaBean:" + th.toString());
            }
        }
        return appa2;
    }

    public static HeadMediaRequestBean appa(Context context, String str, String str2, int i10, int i11, String str3) {
        System.currentTimeMillis();
        HeadMediaRequestBean headMediaRequestBean = new HeadMediaRequestBean();
        try {
            headMediaRequestBean.setRequestId(str);
            headMediaRequestBean.setAdSlotId(str2);
            headMediaRequestBean.setDeviceType(Utils.getDeviceType(context));
            headMediaRequestBean.setOsType(1);
            headMediaRequestBean.setConnectionType(PrivateInfoHelper.getConnectType(context));
            try {
                headMediaRequestBean.setUa(appx.appg(context));
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("Constant", "getHeadMediaBean-setUa:" + th.toString());
            }
            headMediaRequestBean.setPkgName(context.getApplicationContext().getPackageName() + "");
            headMediaRequestBean.setOsVersion(String.valueOf(Build.VERSION.RELEASE));
            headMediaRequestBean.setAppVersion(Utils.getVersionName(context) + "");
            headMediaRequestBean.setModel(Build.MODEL);
            headMediaRequestBean.setVendor(Build.BRAND);
            headMediaRequestBean.setSlotWidth(i10);
            headMediaRequestBean.setSlotHeight(i11);
            headMediaRequestBean.setScreenWidth(Utils.getWindowWidth(context));
            headMediaRequestBean.setScreenHeight(Utils.getWindowHeight(context));
            try {
                headMediaRequestBean.setLatitude(PrivateInfoHelper.getLatitude(context));
                headMediaRequestBean.setLongitude(PrivateInfoHelper.getLongitude(context));
            } catch (Throwable th2) {
                appa.appa.appf.appd.appe("Constant", "getHeadMediaBean-setLatitude:" + th2.toString());
            }
            try {
                headMediaRequestBean.setPpi((int) Utils.getDensity(context));
            } catch (Throwable th3) {
                appa.appa.appf.appd.appe("Constant", "getHeadMediaBean-setPpi:" + th3.toString());
            }
            if (!TextUtils.isEmpty(appd)) {
                try {
                    headMediaRequestBean.setGameId(Integer.parseInt(appd));
                } catch (Throwable th4) {
                    appa.appa.appf.appd.appe("Constant", "getHeadMediaBean-setGameId:" + th4.toString());
                }
            }
            headMediaRequestBean.setOaid(PrivateInfoHelper.getOaid(context));
            try {
                if (Build.VERSION.SDK_INT <= 28) {
                    headMediaRequestBean.setImei(PrivateInfoHelper.getIMEI(context));
                }
            } catch (Throwable th5) {
                appa.appa.appf.appd.appe("Constant", "getHeadMediaBean-setImei:" + th5.toString());
            }
            headMediaRequestBean.setAndroidId(PrivateInfoHelper.getAndroidId(context));
            headMediaRequestBean.setMac(PrivateInfoHelper.getMac(context));
            headMediaRequestBean.setOrientation(Utils.getOrientation(context.getApplicationContext()));
            headMediaRequestBean.setDevicePixelRatio(String.valueOf(Utils.getDensity(context.getApplicationContext())));
            headMediaRequestBean.setJarVersion("4.2.0");
            try {
                headMediaRequestBean.setFingerprint(ConstantInfo.deviceFingerprint);
                headMediaRequestBean.setBoot_mark(ConstantInfo.bootMark);
                headMediaRequestBean.setUpdate_mark(ConstantInfo.updateMark);
                headMediaRequestBean.setCtzid(ConstantInfo.wmId);
            } catch (Throwable th6) {
                appa.appa.appf.appd.appe("Constant", "getHeadMediaBean-setCtzid:" + th6.toString());
            }
            headMediaRequestBean.setSupportDeeplink(0);
            headMediaRequestBean.setLanguage(Locale.getDefault().getLanguage());
            headMediaRequestBean.setSecure(0);
            headMediaRequestBean.setOperator(PrivateInfoHelper.getOperator(context));
            headMediaRequestBean.setOperatorType(PrivateInfoHelper.getOperatorType(context));
            headMediaRequestBean.setImsi(PrivateInfoHelper.getIMSI(context));
            headMediaRequestBean.setV(str3);
            try {
                if (!TextUtils.isEmpty(appk)) {
                    headMediaRequestBean.setInstalledApp(appk);
                }
            } catch (Throwable th7) {
                appa.appa.appf.appd.appe("Constant", "headMediaRequestBean-setInstalledApp:", th7.toString());
            }
        } catch (Throwable th8) {
            appa.appa.appf.appd.appe("Constant", "headMediaRequestBean", "e " + th8.toString());
        }
        return headMediaRequestBean;
    }

    public static BidPriceMediaRequestBean appa(String str, int i10, double d10) {
        BidPriceMediaRequestBean bidPriceMediaRequestBean = new BidPriceMediaRequestBean();
        try {
            bidPriceMediaRequestBean.setAdSlotId(str);
            bidPriceMediaRequestBean.setThirdSlotIdKey(i10);
            bidPriceMediaRequestBean.setDspPrice(new BigDecimal(d10 / 100.0d).setScale(2, 4).doubleValue());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("Constant", "getMediaBidPriceBean:" + th.toString());
        }
        return bidPriceMediaRequestBean;
    }

    public static void appa(Context context, Map<String, String> map) {
        if (map != null) {
            try {
                if (PrivateInfoHelper.getAppList(context) != 0) {
                    ConstantInfo.CHECKINSTALLEDFLAG = 0;
                    String str = "";
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (Utils.checkAppInstalled(context, entry.getValue())) {
                            str = str + "," + entry.getKey();
                        }
                    }
                    if (TextUtils.isEmpty(str) || str.length() <= 1) {
                        return;
                    }
                    appk = str.substring(1);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void appa(IWMAppDownloadListener iWMAppDownloadListener) {
        f46825a = iWMAppDownloadListener;
    }

    public static void appa(String str, boolean z10, String str2, String str3, Context context, float f10, float f11, float f12, float f13, ApiBean apiBean, int i10, int i11) {
        appa(str, z10, str2, str3, context, f10, f11, f12, f13, apiBean, null, i10, i11);
    }

    public static void appa(String str, boolean z10, String str2, String str3, Context context, float f10, float f11, float f12, float f13, ApiBean apiBean, com.wangmai.ad.dex.allmodules.appf.appa appaVar, int i10, int i11) {
        try {
            Activity activity = (WMDexAdHelper.getTopActivity() == null || WMDexAdHelper.getTopActivity().get() == null) ? context : WMDexAdHelper.getTopActivity().get();
            com.wangmai.ad.dex.allmodules.utils.appi.appc(activity, str2, apiBean, i11, new appj(apiBean, str3, f10, f11, f12, f13, activity, appaVar, str2, str, i10, z10));
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("Constant", "clickEvent error：" + ((Object) th));
            appa(context, "", "clickEvent error：" + th.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r16v4 */
    private static boolean appa(Context context, String str, String str2, ApiBean apiBean, int i10, com.wangmai.ad.dex.allmodules.appf.appa appaVar, boolean z10, String str3, List<String> list, List<String> list2) {
        Object obj;
        int i11;
        ?? r16;
        ApiBean.DownloadAppInfo download_app_info;
        Activity activity;
        try {
            download_app_info = apiBean.getRespObj().getWxad().getDownload_app_info();
            activity = WMDexAdHelper.getTopActivity().get();
            appa.appa.appf.appd.appa("Constant", "downLoadUtils", Integer.valueOf(i10), download_app_info);
        } catch (Throwable th) {
            th = th;
            obj = "Constant";
        }
        try {
            if (i10 != 0 && download_app_info != null && activity != null) {
                IWMAppDownloadListener iWMAppDownloadListener = f46825a;
                View inflate = LayoutInflater.from(appa.appa.appf.appa.appa(context, WMResources.resources)).inflate(R$layout.wm_download1, (ViewGroup) null, false);
                com.wangmai.ad.dex.allmodules.utils.appl applVar = new com.wangmai.ad.dex.allmodules.utils.appl(activity, 0, inflate);
                applVar.setCancelable(false);
                View findViewById = inflate.findViewById(R$id.iv_close);
                ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_icon);
                TextView textView = (TextView) inflate.findViewById(R$id.tv_apk_name);
                TextView textView2 = (TextView) inflate.findViewById(R$id.tv_version);
                TextView textView3 = (TextView) inflate.findViewById(R$id.tv_apk_size);
                TextView textView4 = (TextView) inflate.findViewById(R$id.tv_developer);
                TextView textView5 = (TextView) inflate.findViewById(R$id.tv_permission);
                TextView textView6 = (TextView) inflate.findViewById(R$id.tv_private_rule);
                TextView textView7 = (TextView) inflate.findViewById(R$id.tv_desc);
                View findViewById2 = inflate.findViewById(R$id.ll_download);
                View inflate2 = LayoutInflater.from(appa.appa.appf.appa.appa(context, WMResources.resources)).inflate(R$layout.wm_download2, (ViewGroup) null, false);
                com.wangmai.ad.dex.allmodules.utils.appl applVar2 = new com.wangmai.ad.dex.allmodules.utils.appl(activity, 0, inflate2);
                applVar2.setCancelable(false);
                ImageView imageView2 = (ImageView) inflate2.findViewById(R$id.iv_back);
                TextView textView8 = (TextView) inflate2.findViewById(R$id.tv_title);
                CustomWebView customWebView = (CustomWebView) inflate2.findViewById(R$id.webview);
                LinearLayout linearLayout = (LinearLayout) inflate2.findViewById(R$id.ll_download);
                WebSettings settings = customWebView.getSettings();
                obj = "Constant";
                try {
                    settings.setLoadsImagesAutomatically(true);
                    settings.setJavaScriptEnabled(true);
                    settings.setDomStorageEnabled(true);
                    settings.setLoadWithOverviewMode(true);
                    settings.setUseWideViewPort(true);
                    settings.setBlockNetworkImage(false);
                    if (Build.VERSION.SDK_INT >= 21) {
                        try {
                            settings.setMixedContentMode(0);
                        } catch (Throwable th2) {
                            th = th2;
                            i11 = 2;
                            r16 = 0;
                            Object[] objArr = new Object[i11];
                            objArr[r16] = obj;
                            objArr[1] = "dialog show exception:" + th.toString();
                            appa.appa.appf.appd.appe(objArr);
                            return r16;
                        }
                    }
                    String icon_url = download_app_info.getIcon_url();
                    if (!TextUtils.isEmpty(icon_url)) {
                        ((GetRequest) OkHttp.get(icon_url).cacheMode(CacheMode.IF_NONE_CACHE_REQUEST)).execute(new appk(imageView));
                    } else {
                        imageView.setVisibility(8);
                    }
                    textView.setText(download_app_info.getApp_name());
                    textView2.setText("版本号：" + download_app_info.getVersion());
                    textView3.setText("安装包：" + com.wangmai.ad.dex.allmodules.utils.appn.appa(download_app_info.getPacket_size() * 1024));
                    textView4.setText("开发者：" + download_app_info.getDeveloper());
                    imageView2.setOnClickListener(new appl(customWebView, applVar2));
                    findViewById.setOnClickListener(new appm(applVar, applVar2, appaVar));
                    findViewById2.setOnClickListener(new appn(context, str, str2, z10, str3, list, list2, applVar, applVar2, appaVar));
                    linearLayout.setOnClickListener(new appo(context, str, str2, z10, str3, list, list2, applVar, appaVar, applVar2));
                    textView5.setOnClickListener(new appp(textView8, download_app_info, customWebView, context, applVar2));
                    textView6.setOnClickListener(new appa(download_app_info, textView8, customWebView, applVar2));
                    textView7.setOnClickListener(new appb(textView8, download_app_info, customWebView, applVar2));
                    if (appaVar != null) {
                        appaVar.pause();
                    }
                    applVar.show();
                } catch (Throwable th3) {
                    th = th3;
                    r16 = 0;
                    i11 = 2;
                    Object[] objArr2 = new Object[i11];
                    objArr2[r16] = obj;
                    objArr2[1] = "dialog show exception:" + th.toString();
                    appa.appa.appf.appd.appe(objArr2);
                    return r16;
                }
            } else {
                appa.appa.appf.appd.appe("Constant", "警告⚠⚠⚠⚠⚠⚠:当前应用下载未弹框提示六要素，不符合合规要求，请尽快完成整改！");
                appa.appa.appf.appd.appe("Constant", "警告⚠⚠⚠⚠⚠⚠:当前应用下载未弹框提示六要素，不符合合规要求，请尽快完成整改！");
                appa.appa.appf.appd.appe("Constant", "警告⚠⚠⚠⚠⚠⚠:当前应用下载未弹框提示六要素，不符合合规要求，请尽快完成整改！");
                appb(context, str, str2, z10, str3, list, list2);
            }
            return true;
        } catch (Throwable th4) {
            th = th4;
            i11 = 2;
            Object[] objArr22 = new Object[i11];
            objArr22[r16] = obj;
            objArr22[1] = "dialog show exception:" + th.toString();
            appa.appa.appf.appd.appe(objArr22);
            return r16;
        }
    }

    private static boolean appa(Context context, String str, ApiBean apiBean) {
        appa.appa.appf.appd.appa("Constant", "downLoadUtils", "skipToMarketDowload", str);
        List<String> modelStores = apiBean.getOptimization().getModelStores();
        if (modelStores != null && modelStores.size() != 0) {
            for (int i10 = 0; i10 < modelStores.size(); i10++) {
                String str2 = modelStores.get(i10);
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
                    intent.setPackage(str2);
                    intent.addFlags(268435456);
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                    if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                        appa.appa.appf.appd.appa("Constant", "三方市场下载:" + queryIntentActivities.get(0).activityInfo.name);
                        context.startActivity(intent);
                        return true;
                    }
                } catch (Exception e2) {
                    appa.appa.appf.appd.appe("Constant", "open applications market exception:" + e2.toString());
                }
            }
        } else {
            appa.appa.appf.appd.appa("Constant", "三方应用市场打开失败");
        }
        return false;
    }

    public static void appa(List<String> list, String str) {
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                for (int i10 = 0; i10 < list.size(); i10++) {
                    appa(list.get(i10), str);
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("Constant", str + " urlReport error:" + th.toString());
            }
        }
    }

    public static void appa(String str, String str2) {
        try {
            appa.appa.appf.appd.appa("Constant", str2 + " urlReport:", str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            OkHttp.get(str).execute(new appd(str2));
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("Constant", str2 + " urlReport error:" + th.toString());
        }
    }

    public static void appa(List<String> list, int i10, boolean z10) {
        int i11;
        String str;
        List<String> list2 = list;
        int i12 = i10;
        String str2 = "-999";
        int i13 = 0;
        try {
            appa.appa.appf.appd.appa("Constant", "API曝光上报win_notice_url---");
            if (list2 == null || list.isEmpty() || list.size() <= 0) {
                return;
            }
            String str3 = "(?i)__utc_ts__";
            while (i13 < list.size()) {
                String str4 = str3;
                String str5 = "";
                if (list2.get(i13).startsWith(appq)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    StringBuilder sb2 = new StringBuilder();
                    str = "";
                    sb2.append(String.valueOf(currentTimeMillis));
                    sb2.append(i12);
                    String encrypt = AesUtil.encrypt(sb2.toString(), ConstantInfo.getAppToken());
                    str5 = list2.get(i13) + "&s=" + encrypt;
                } else {
                    str = "";
                }
                if (TextUtils.isEmpty(str5)) {
                    str5 = list2.get(i13);
                }
                i11 = 2;
                try {
                    Object[] objArr = new Object[2];
                    objArr[0] = "Constant";
                    objArr[1] = "API曝光上报原地址winUrl---" + str5;
                    appa.appa.appf.appd.appa(objArr);
                    String replaceAll = str5.replaceAll("(?i)__down_x__", str2).replaceAll("(?i)__down_y__", str2).replaceAll("(?i)__up_x__", str2).replaceAll("(?i)__up_y__", str2).replaceAll("(?i)__re_down_x__", str2).replaceAll("(?i)__re_down_y__", str2).replaceAll("(?i)__re_up_x__", str2).replaceAll("(?i)__re_up_y__", str2).replaceAll("(?i)__utc_end_ts__", str2);
                    StringBuilder sb3 = new StringBuilder();
                    String str6 = str2;
                    sb3.append(System.currentTimeMillis());
                    sb3.append(str);
                    String replaceAll2 = replaceAll.replaceAll(str4, sb3.toString());
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = "Constant";
                    objArr2[1] = "API曝光上报宏替换后地址winUrl---" + replaceAll2;
                    appa.appa.appf.appd.appa(objArr2);
                    OkHttp.get(replaceAll2).execute(new appe(i10));
                    i13++;
                    list2 = list;
                    i12 = i10;
                    str2 = str6;
                    str3 = str4;
                } catch (Exception e2) {
                    e = e2;
                    Object[] objArr3 = new Object[i11];
                    objArr3[0] = "Constant";
                    objArr3[1] = "showUpEvent:" + e.toString();
                    appa.appa.appf.appd.appe(objArr3);
                    return;
                }
            }
        } catch (Exception e10) {
            e = e10;
            i11 = 2;
        }
    }

    public static void appa(List<String> list, List<String> list2, int i10, float f10, float f11, float f12, float f13) {
        int i11;
        List<String> list3 = list;
        int i12 = i10;
        String str = "-999";
        try {
            appa.appa.appf.appd.appa("Constant", "API点击上报 clickUpEventReport：" + i12, Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12), Float.valueOf(f13));
            if (list3 != null && !list.isEmpty() && list.size() > 0) {
                String valueOf = String.valueOf(f10);
                String str2 = "(?i)__utc_ts__";
                String valueOf2 = String.valueOf(f11);
                String str3 = "(?i)__utc_end_ts__";
                String valueOf3 = String.valueOf(f12);
                String str4 = "(?i)__re_up_y__";
                String valueOf4 = String.valueOf(f13);
                String str5 = "(?i)__re_down_y__";
                String str6 = "(?i)__re_up_x__";
                int i13 = 0;
                while (i13 < list.size()) {
                    String str7 = list3.get(i13);
                    int i14 = i13;
                    StringBuilder sb2 = new StringBuilder();
                    String str8 = str;
                    sb2.append("API点击上报原地址winUrl---");
                    sb2.append(str7);
                    appa.appa.appf.appd.appa("Constant", sb2.toString());
                    if (str7.contains("__CTYPE__") && (i12 == appm || i12 == appn)) {
                        appa.appa.appf.appd.appe("Constant", "虚拟点击-宏替换clickType=" + i12);
                        str7 = str7.replaceAll("__CTYPE__", String.valueOf(i10));
                    }
                    String replaceAll = str7.replaceAll("(?i)__down_x__", valueOf).replaceAll("(?i)__down_y__", valueOf2).replaceAll("(?i)__up_x__", valueOf3).replaceAll("(?i)__up_y__", valueOf4).replaceAll("(?i)__re_down_x__", str8);
                    String str9 = str5;
                    String str10 = str6;
                    String str11 = valueOf;
                    String str12 = str4;
                    String replaceAll2 = replaceAll.replaceAll(str9, str8).replaceAll(str10, str8).replaceAll(str12, str8);
                    str4 = str12;
                    String str13 = str3;
                    str3 = str13;
                    String str14 = str2;
                    String replaceAll3 = replaceAll2.replaceAll(str13, str8).replaceAll(str14, System.currentTimeMillis() + "");
                    i11 = 2;
                    try {
                        Object[] objArr = new Object[2];
                        objArr[0] = "Constant";
                        StringBuilder sb3 = new StringBuilder();
                        str2 = str14;
                        sb3.append("API点击上报宏替换后地址winUrl---");
                        sb3.append(replaceAll3);
                        objArr[1] = sb3.toString();
                        appa.appa.appf.appd.appa(objArr);
                        OkHttp.get(replaceAll3).execute(new C0695appf());
                        i12 = i10;
                        str5 = str9;
                        valueOf = str11;
                        str = str8;
                        str6 = str10;
                        i13 = i14 + 1;
                        list3 = list;
                    } catch (Exception e2) {
                        e = e2;
                        Object[] objArr2 = new Object[i11];
                        objArr2[0] = "Constant";
                        objArr2[1] = "API点击上报 clickUpEventReport error:" + e.toString();
                        appa.appa.appf.appd.appe(objArr2);
                        return;
                    }
                }
            }
            if (list2 == null || list2.isEmpty() || list2.size() <= 0) {
                return;
            }
            for (int i15 = 0; i15 < list2.size(); i15++) {
                OkHttp.get(list2.get(i15)).execute(new EmptyCallback());
            }
        } catch (Exception e10) {
            e = e10;
            i11 = 2;
        }
    }

    public static void appa(Context context, String str, String str2, String str3, String str4, long j10) {
        appa.appa.appf.appd.appa("onWebViewDownloadStart", str, str2, str3, str4, Long.valueOf(j10));
        try {
            if (!str3.contains(".apk") && !TextUtils.equals(str4, "application/vnd.android.package-archive") && !str.contains(".apk")) {
                Intent intent = new Intent("android.intent.action.VIEW");
                try {
                    intent.addCategory("android.intent.category.BROWSABLE");
                    intent.addFlags(268435456);
                    try {
                        intent.setDataAndType(Uri.parse(str), str4);
                        context.startActivity(intent);
                    } catch (Throwable unused) {
                        intent.setData(Uri.parse(str));
                        context.startActivity(intent);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            com.wangmai.ad.dex.allmodules.utils.appn.appa().appa(context, "", false, 1, str, new appg(context, str));
        } catch (Throwable th2) {
            appa.appa.appf.appd.appe("Constant", "onWebViewDownloadStart error:" + th2.toString());
        }
    }

    public static void appa(String str, HasTypeRunnable<appq> hasTypeRunnable) {
        appb(str, "GET", hasTypeRunnable);
    }
}
