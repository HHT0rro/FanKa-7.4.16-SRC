package com.wangmai.ad.dex.allmodules;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.wangmai.ad.dex.allmodules.utils.appf;
import com.wangmai.ad.dex.allmodules.utils.appy;
import com.wangmai.appsdkdex.WMDexAdHelper;
import com.wangmai.common.WMAdActListener;
import com.wangmai.common.utils.WMResources;
import com.wangmai.common.view.CustomWebView;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class WMAppWebView extends FrameLayout implements WMAdActListener {

    /* renamed from: appa, reason: collision with root package name */
    private String f46471appa;
    private CustomWebView appb;
    private ProgressBar appc;
    private ImageView appd;
    private String appe;
    private Context appf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa extends WebChromeClient {
        appa() {
        }

        @Override // android.webkit.WebChromeClient
        public Bitmap getDefaultVideoPoster() {
            try {
                return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("WMAppWebView", "getDefaultVideoPoster exception:" + th.toString());
                return super.getDefaultVideoPoster();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            WMAppWebView.this.appc.setProgress(i10);
            super.onProgressChanged(webView, i10);
        }

        @Override // android.webkit.WebChromeClient
        public void onReachedMaxAppCacheSize(long j10, long j11, WebStorage.QuotaUpdater quotaUpdater) {
            super.onReachedMaxAppCacheSize(j10, j11, quotaUpdater);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb extends appy {
        appb(Context context, String str) {
            super(context, str);
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appy
        public boolean appa(WebView webView, String str) {
            appa.appa.appf.appd.appa("WMAppWebView", "shouldOverrideUrlLoadingInternal:" + str);
            return super.appa(webView, str);
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appy, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            WMAppWebView.this.appc.setVisibility(8);
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appy, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WMAppWebView.this.appc.setVisibility(0);
            super.onPageStarted(webView, str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appc implements DownloadListener {
        appc() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
            if (WMDexAdHelper.getActivity(WMAppWebView.this.appe).isFinishing() || TextUtils.isEmpty(str)) {
                return;
            }
            appf.appa(WMDexAdHelper.getActivity(WMAppWebView.this.appe), str, str2, str3, str4, j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appd implements Runnable {
        appd() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!WMAppWebView.this.f46471appa.startsWith("http://") && !WMAppWebView.this.f46471appa.startsWith("https://")) {
                    if (WMAppWebView.this.f46471appa.startsWith("intent://")) {
                        Intent parseUri = Intent.parseUri(WMAppWebView.this.f46471appa, 1);
                        parseUri.addFlags(268435456);
                        parseUri.addCategory("android.intent.category.BROWSABLE");
                        parseUri.setComponent(null);
                        parseUri.setSelector(null);
                        WMDexAdHelper.getActivity(WMAppWebView.this.appe).startActivity(parseUri);
                        WMDexAdHelper.getActivity(WMAppWebView.this.appe).finish();
                    } else if (WMAppWebView.this.f46471appa.startsWith("wmText://")) {
                        WMAppWebView.this.appb.loadDataWithBaseURL(null, WMAppWebView.this.f46471appa.substring(WMAppWebView.this.f46471appa.indexOf("//") + 2), "text/html", "utf-8", null);
                    } else {
                        PackageManager packageManager = WMDexAdHelper.getActivity(WMAppWebView.this.appe).getPackageManager();
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(WMAppWebView.this.f46471appa));
                        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                            WMAppWebView.this.appb.loadUrl(WMAppWebView.this.f46471appa);
                        } else {
                            intent.addFlags(32768);
                            intent.addFlags(268435456);
                            WMDexAdHelper.getActivity(WMAppWebView.this.appe).startActivity(intent);
                            WMDexAdHelper.getActivity(WMAppWebView.this.appe).finish();
                        }
                    }
                }
                WMAppWebView.this.appb.loadUrl(WMAppWebView.this.f46471appa);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("WMAppWebView", "AppWebView exception1:" + th.toString());
                try {
                    WMAppWebView.this.appb.loadUrl(WMAppWebView.this.f46471appa);
                } catch (Throwable th2) {
                    appa.appa.appf.appd.appe("WMAppWebView", "AppWebView exception2:" + th2.toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appe implements View.OnClickListener {
        appe() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WMDexAdHelper.getActivity(WMAppWebView.this.appe).finish();
        }
    }

    public WMAppWebView(Context context, String str, String str2) {
        super(context);
        this.appf = appa.appa.appf.appa.appa(context, WMResources.resources);
        this.f46471appa = str2;
        appa.appa.appf.appd.appa("WMAppWebView", str2);
        this.appe = str;
        appa();
    }

    @Override // com.wangmai.common.WMAdActListener
    public void adOnActivityResult(int i10, int i11, Intent intent) {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void adOnConfigurationChanged(Configuration configuration) {
    }

    @Override // com.wangmai.common.WMAdActListener
    public boolean adOnKeyDown(int i10, KeyEvent keyEvent) {
        CustomWebView customWebView;
        appa.appa.appf.appd.appa("WMAppWebView", "adOnKeyDown");
        if (i10 != 4 || !this.appb.canGoBack() || (customWebView = this.appb) == null) {
            return false;
        }
        customWebView.goBack();
        return true;
    }

    @Override // com.wangmai.common.WMAdActListener
    public Resources getAdResources() {
        return null;
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdCreate(Bundle bundle) {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdDestroy() {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdPause() {
        CustomWebView customWebView = this.appb;
        if (customWebView != null) {
            customWebView.onPause();
        }
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdRestart() {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdResume() {
        CustomWebView customWebView = this.appb;
        if (customWebView != null) {
            customWebView.onResume();
        }
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdStart() {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdStop() {
    }

    private void appa() {
        View inflate = LayoutInflater.from(this.appf).inflate(R$layout.wm_ad, (ViewGroup) this, false);
        this.appb = (CustomWebView) ((FrameLayout) inflate.findViewById(R$id.wm_act_wmad_web_layout)).findViewById(R$id.wm_act_web);
        this.appc = (ProgressBar) inflate.findViewById(R$id.wm_act_wmad_pro);
        this.appd = (ImageView) inflate.findViewById(R$id.wm_image_clear);
        appa.appa.appf.appd.appa("WMAppWebView", "init1");
        this.appc.setMax(100);
        addView(inflate);
        appb();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void appb() {
        WebSettings settings = this.appb.getSettings();
        settings.setLoadsImagesAutomatically(true);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        this.appb.setWebChromeClient(new appa());
        this.appb.setWebViewClient(new appb(this.appf, "WMAppWebView"));
        this.appb.setDownloadListener(new appc());
        this.appb.post(new appd());
        this.appd.setOnClickListener(new appe());
    }
}
