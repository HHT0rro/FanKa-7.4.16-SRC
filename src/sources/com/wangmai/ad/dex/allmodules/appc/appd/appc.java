package com.wangmai.ad.dex.allmodules.appc.appd;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wangmai.ad.dex.allmodules.R$id;
import com.wangmai.ad.dex.allmodules.R$layout;
import com.wangmai.ad.dex.allmodules.R$style;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.ad.dex.allmodules.utils.appa;
import com.wangmai.ad.dex.allmodules.utils.appc;
import com.wangmai.ad.dex.allmodules.utils.appu;
import com.wangmai.ad.dex.allmodules.utils.appv;
import com.wangmai.ad.dex.allmodules.utils.appx;
import com.wangmai.ad.dex.allmodules.utils.appy;
import com.wangmai.ad.dex.allmodules.view.WMBaseViewGroup;
import com.wangmai.ad.dex.allmodules.view.WMVideoView2;
import com.wangmai.common.runnable.HasTypeRunnable;
import com.wangmai.common.utils.ConstantInfo;
import com.wangmai.common.utils.SharedPreferencesHelper;
import com.wangmai.common.utils.Utils;
import com.wangmai.common.utils.WMResources;
import com.wangmai.common.view.CustomWebView;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.callback.BitmapCallback;
import com.wangmai.okhttp.model.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: WMInterstitialAdNew.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appc implements View.OnTouchListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {

    /* renamed from: a, reason: collision with root package name */
    private int f46738a;

    /* renamed from: appa, reason: collision with root package name */
    private int f46739appa;
    private int appb;
    private String appg;
    private com.wangmai.ad.dex.allmodules.appc.appd.appb apph;
    private appa.appa.appd.appb appi;
    private ImageView appj;
    private ImageView appk;
    private ImageView appl;
    private ImageView appm;
    private boolean appn;
    private String appo;
    private String appp;
    private List<String> appq;
    private String appr;
    private CustomWebView apps;
    private RelativeLayout appt;
    private RelativeLayout appu;
    private RelativeLayout appv;
    private RelativeLayout appw;
    private RelativeLayout appx;
    private int appy;
    private int appz;

    /* renamed from: b, reason: collision with root package name */
    private com.wangmai.ad.dex.allmodules.utils.appc f46740b;

    /* renamed from: d, reason: collision with root package name */
    private WMVideoView2 f46742d;

    /* renamed from: e, reason: collision with root package name */
    private ApiBean f46743e;

    /* renamed from: f, reason: collision with root package name */
    WMBaseViewGroup f46744f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f46745g;

    /* renamed from: h, reason: collision with root package name */
    private int f46746h;

    /* renamed from: i, reason: collision with root package name */
    private int f46747i;

    /* renamed from: j, reason: collision with root package name */
    private int f46748j;

    /* renamed from: k, reason: collision with root package name */
    private long f46749k;

    /* renamed from: l, reason: collision with root package name */
    private String f46750l;

    /* renamed from: m, reason: collision with root package name */
    private List<String> f46751m;

    /* renamed from: n, reason: collision with root package name */
    private String f46752n;

    /* renamed from: o, reason: collision with root package name */
    private int f46753o;

    /* renamed from: p, reason: collision with root package name */
    private Context f46754p;

    /* renamed from: q, reason: collision with root package name */
    private String f46755q;

    /* renamed from: r, reason: collision with root package name */
    private appu f46756r;

    /* renamed from: s, reason: collision with root package name */
    private appv f46757s;

    /* renamed from: t, reason: collision with root package name */
    private appa.appc f46758t;

    /* renamed from: u, reason: collision with root package name */
    private appa.appc f46759u;
    public float appc = -999.0f;
    public float appd = -999.0f;
    public float appe = -999.0f;
    public float appf = -999.0f;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f46741c = false;

    /* renamed from: v, reason: collision with root package name */
    private boolean f46760v = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMInterstitialAdNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa implements WMVideoView2.appf {
        appa() {
        }

        @Override // com.wangmai.ad.dex.allmodules.view.WMVideoView2.appf
        public void appa() {
        }

        @Override // com.wangmai.ad.dex.allmodules.view.WMVideoView2.appf
        public void appb() {
        }

        @Override // com.wangmai.ad.dex.allmodules.view.WMVideoView2.appf
        public void appc() {
        }

        @Override // com.wangmai.ad.dex.allmodules.view.WMVideoView2.appf
        public void appd() {
        }

        @Override // com.wangmai.ad.dex.allmodules.view.WMVideoView2.appf
        public void appe() {
        }

        @Override // com.wangmai.ad.dex.allmodules.view.WMVideoView2.appf
        public void appf() {
            appa.appa.appf.appd.appa("WMSelfInterstitialAd", "IPA.MW Interstitial onVideoClick");
            if (appc.this.appi != null) {
                appc.this.appi.onClick();
            }
        }

        @Override // com.wangmai.ad.dex.allmodules.view.WMVideoView2.appf
        public void appg() {
        }

        @Override // com.wangmai.ad.dex.allmodules.view.WMVideoView2.appf
        public void onVideoError(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMInterstitialAdNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb extends ClickableSpan {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ ApiBean.DownloadAppInfo f46762appa;

        appb(ApiBean.DownloadAppInfo downloadAppInfo) {
            this.f46762appa = downloadAppInfo;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            com.wangmai.ad.dex.allmodules.utils.appf.appc(appc.this.f46754p, this.f46762appa.getPrivacy());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMInterstitialAdNew.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.appc.appd.appc$appc, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class C0684appc extends ClickableSpan {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46763appa;
        final /* synthetic */ String appb;

        C0684appc(String str, String str2) {
            this.f46763appa = str;
            this.appb = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.f46763appa)) {
                com.wangmai.ad.dex.allmodules.utils.appf.appc(appc.this.f46754p, this.f46763appa);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<html>");
            stringBuffer.append("<head><style>body{margin:0;padding:50 15 30 15;font-size:38;color:#666666}div{font-size:50;padding-bottom:30;color:#333333;font-weight:bold}</style></head>");
            stringBuffer.append("<body>");
            stringBuffer.append("<center><div>功能介绍</div></center>");
            stringBuffer.append(this.appb);
            stringBuffer.append("</body></html>");
            com.wangmai.ad.dex.allmodules.utils.appf.appc(appc.this.f46754p, "wmText://" + ((Object) stringBuffer));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMInterstitialAdNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appd extends ClickableSpan {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46764appa;
        final /* synthetic */ List appb;

        appd(String str, List list) {
            this.f46764appa = str;
            this.appb = list;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.f46764appa)) {
                com.wangmai.ad.dex.allmodules.utils.appf.appc(appc.this.f46754p, this.f46764appa);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<html>");
            stringBuffer.append("<head><style>body{margin:0;padding:50 15 30 15;font-size:34;color:#999999}</style></head>");
            stringBuffer.append("<body>");
            stringBuffer.append("<center><div style=font-size:46;padding-bottom:30;color:#333333;font-weight:bold>应用权限</div></center>");
            StringBuffer stringBuffer2 = new StringBuffer();
            for (ApiBean.Permission permission : this.appb) {
                stringBuffer2.append("<div style=font-size:40;color:#666666;font-weight:bold;padding-bottom:20>");
                stringBuffer2.append(permission.getTitle());
                stringBuffer2.append("</div>");
                stringBuffer2.append("<div style=padding-bottom:50>");
                stringBuffer2.append(permission.getDescription());
                stringBuffer2.append("</div>");
            }
            stringBuffer.append(stringBuffer2);
            stringBuffer.append("</body></html>");
            com.wangmai.ad.dex.allmodules.utils.appf.appc(appc.this.f46754p, "wmText://" + ((Object) stringBuffer));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMInterstitialAdNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appe implements appa.appc {
        appe() {
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appa.appc
        public void appa(int i10, float f10, float f11, float f12, float f13) {
            if (!appc.this.f46760v) {
                try {
                    appc.this.f46744f.getLocationOnScreen(new int[2]);
                    appc.this.appc = r4[0] + (appc.this.f46744f.getWidth() / 2);
                    appc.this.appd = r4[1] + (appc.this.f46744f.getHeight() / 2);
                    appc.this.appe = appc.this.appc;
                    appc.this.appf = appc.this.appd;
                    appc.this.f46756r.appf();
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe("WMSelfInterstitialAd", "插屏模拟点击预处理失败：" + th);
                }
                appc.this.appa(com.wangmai.ad.dex.allmodules.utils.appf.appm);
                return;
            }
            appa.appa.appf.appd.appe("WMSelfInterstitialAd", "未触发模拟点击逻辑（已点击限制）");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMInterstitialAdNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appf implements appa.appc {
        appf() {
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appa.appc
        public void appa(int i10, float f10, float f11, float f12, float f13) {
            if (!appc.this.f46760v) {
                try {
                    appc.this.appc = f10;
                    appc.this.appd = f11;
                    appc.this.appe = f13;
                    appc.this.appf = f13;
                    appc.this.f46757s.apph();
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe("WMSelfInterstitialAd", "插屏滑动点击预处理失败：" + th);
                }
                appc.this.appa(com.wangmai.ad.dex.allmodules.utils.appf.appn);
                return;
            }
            appa.appa.appf.appd.appe("WMSelfInterstitialAd", "未触发滑动点击逻辑（已点击限制）");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMInterstitialAdNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appg implements View.OnClickListener {
        appg() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int nextInt = new Random().nextInt(100) + 1;
            if (appc.this.appy > 0 && nextInt <= appc.this.appy) {
                appc.this.appa(com.wangmai.ad.dex.allmodules.utils.appf.appl);
            }
            appc.this.appk();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMInterstitialAdNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class apph implements View.OnClickListener {
        apph() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int nextInt = new Random().nextInt(100) + 1;
            if (appc.this.appy > 0 && nextInt <= appc.this.appy) {
                appc.this.appa(com.wangmai.ad.dex.allmodules.utils.appf.appl);
            }
            appc.this.appk();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMInterstitialAdNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appi implements View.OnClickListener {
        appi() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            appc.this.appk();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMInterstitialAdNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appj implements DialogInterface.OnDismissListener {
        appj() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (appc.this.apps != null) {
                appc.this.apps.loadUrl("about:blank");
            }
            if (appc.this.f46742d != null) {
                appc.this.f46742d.destroy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMInterstitialAdNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appk implements DialogInterface.OnShowListener {
        appk() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            try {
                if (appc.this.appi != null) {
                    if (appc.this.f46740b != null) {
                        appc.this.f46740b.appa();
                    }
                    appc.this.appa(appc.this.f46743e.getOptimization());
                    appa.appa.appf.appd.appa("WMSelfInterstitialAd", "IPA.MW Interstitial onExposure");
                    appc.this.appi.onExposure();
                    appc.this.appi.appa();
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appb("WMSelfInterstitialAd", "Interstitial 展示失败:" + ((Object) th));
                if (appc.this.appi != null) {
                    appc.this.appi.appa("Interstitial 展示失败:" + th.toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMInterstitialAdNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appl implements HasTypeRunnable<ApiBean> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* compiled from: WMInterstitialAdNew.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        public class appa implements appc.appa {
            appa() {
            }

            @Override // com.wangmai.ad.dex.allmodules.utils.appc.appa
            public void appa() {
                if (appc.this.appi != null) {
                    appa.appa.appf.appd.appa("WMSelfInterstitialAd", "IPA.MW Interstitial onClick");
                    appc.this.appi.onClick();
                }
            }
        }

        appl() {
        }

        @Override // com.wangmai.common.runnable.HasTypeRunnable
        /* renamed from: appa, reason: merged with bridge method [inline-methods] */
        public void run(ApiBean apiBean) {
            appc appcVar = appc.this;
            appcVar.f46741c = false;
            if (apiBean == null) {
                appa.appa.appf.appd.appb("WMSelfInterstitialAd", "IPA.MW Interstitial 广告请求失败");
                if (appc.this.appi != null) {
                    appc.this.appi.onNoAd("广告请求失败");
                }
                appc.this.appl();
                return;
            }
            appcVar.f46743e = apiBean;
            ApiBean.RespObj respObj = apiBean.getRespObj();
            ApiBean.WxadBean wxad = respObj.getWxad();
            if (apiBean != null && apiBean.getOptimization() != null && apiBean.getOptimization().getReportObject() != null) {
                appc.this.appz = apiBean.getOptimization().getReportObject().getShrand();
                appc.this.f46738a = apiBean.getOptimization().getReportObject().getShcrandom();
            }
            appc appcVar2 = appc.this;
            appcVar2.f46740b = new com.wangmai.ad.dex.allmodules.utils.appc(null, appcVar2.f46754p, appc.this.appz, appc.this.f46738a, appc.this.f46739appa, appc.this.appb, apiBean);
            appc.this.f46740b.appa(new appa());
            if (respObj.getError_code() == 0 && wxad != null) {
                appc.this.appc(respObj.getNurl());
                appc.this.appb(apiBean);
                appc.this.appa(apiBean);
                appc.this.appa(apiBean.getInvalidCridList());
                if (appc.this.appi != null) {
                    appa.appa.appf.appd.appa("WMSelfInterstitialAd", "IPA.MW Interstitial onAdRequest、onAdReady");
                    appc.this.appb(wxad);
                    int interaction_type = wxad.getInteraction_type();
                    if (interaction_type == 2 || interaction_type == 3 || interaction_type == 5) {
                        appc.this.appa(wxad.getDownload_app_info());
                        return;
                    }
                    return;
                }
                return;
            }
            appa.appa.appf.appd.appb("WMSelfInterstitialAd", "IPA.MW Interstitial 广告请求失败:" + respObj.getError_code());
            appc.this.appa(apiBean.getInvalidCridList());
            if (appc.this.appi != null) {
                appc.this.appi.onNoAd("广告请求失败:" + respObj.getError_code());
            }
            appc.this.appl();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMInterstitialAdNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appm extends BitmapCallback {
        appm() {
        }

        @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
        public void onError(Response<Bitmap> response) {
            appa.appa.appf.appd.appb("WMSelfInterstitialAd", "Interstitial 图片物料加载失败：" + response.code() + "," + response.getException().toString());
            if (appc.this.appi != null) {
                appc.this.appi.onNoAd("Interstitial 图片物料加载失败");
            }
            appc.this.appl();
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<Bitmap> response) {
            if (response != null) {
                appc.this.appj.setImageBitmap(response.body());
                if (appc.this.appi != null) {
                    appa.appa.appf.appd.appa("WMSelfInterstitialAd", "图片物料下载成功，返回onAdRequest");
                    appc.this.appi.onAdRequest();
                    return;
                }
                return;
            }
            if (appc.this.appi != null) {
                appc.this.appi.onNoAd("Interstitial 图片物料加载失败");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMInterstitialAdNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appn implements DownloadListener {
        appn() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
            if (appc.this.f46754p == null || TextUtils.isEmpty(str)) {
                return;
            }
            com.wangmai.ad.dex.allmodules.utils.appf.appa(appc.this.f46754p, str, str2, str3, str4, j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMInterstitialAdNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appo extends appy {
        appo(Context context, String str) {
            super(context, str);
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appy
        public boolean appa(WebView webView, String str) {
            com.wangmai.ad.dex.allmodules.utils.appf.appc(appc.this.f46754p, str);
            return true;
        }
    }

    public appc(Context context, String str, String str2, String str3, int i10, int i11, int i12, appa.appa.appd.appb appbVar) {
        this.appn = true;
        if (!TextUtils.isEmpty(str2)) {
            this.appn = false;
            this.f46754p = context;
            this.f46755q = str;
            this.appo = str2;
            this.appp = str3;
            this.appy = i10;
            this.appi = appbVar;
            this.f46739appa = i11;
            this.appb = i12;
            View inflate = LayoutInflater.from(appa.appa.appf.appa.appa(this.f46754p, WMResources.resources)).inflate(R$layout.wm_pop_ad, (ViewGroup) null, false);
            this.f46744f = new WMBaseViewGroup(this.f46754p);
            this.f46744f.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f46744f.addView(inflate);
            this.appt = (RelativeLayout) inflate.findViewById(R$id.wm_layout_ad_image);
            this.appj = (ImageView) inflate.findViewById(R$id.wm_pop_ad_main);
            this.appk = (ImageView) inflate.findViewById(R$id.wm_pop_ad_cancel);
            this.apps = (CustomWebView) inflate.findViewById(R$id.wm_show_html);
            this.appu = (RelativeLayout) inflate.findViewById(R$id.wm_layout_ad_web);
            this.appl = (ImageView) inflate.findViewById(R$id.wm_pop_ad_web_cancel);
            this.appw = (RelativeLayout) inflate.findViewById(R$id.wm_layout_ad_video_container);
            this.appx = (RelativeLayout) inflate.findViewById(R$id.wm_layout_ad_video);
            this.appm = (ImageView) inflate.findViewById(R$id.wm_video_close);
            this.f46745g = (TextView) inflate.findViewById(R$id.tv_download_info);
            this.appk.setOnClickListener(new appg());
            this.appm.setOnClickListener(new apph());
            this.appl.setOnClickListener(new appi());
            this.apps.setOnTouchListener(this);
            this.appj.setOnTouchListener(this);
            this.appw.setOnTouchListener(this);
            return;
        }
        appa.appa.appf.appd.appb("WMSelfInterstitialAd", "IPA.MW Interstitial 缺失必要参数");
        if (appbVar != null) {
            appbVar.onNoAd("缺失必要参数");
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        appa.appa.appf.appd.appa("WMSelfInterstitialAd", "视频播放完成");
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
        appa.appa.appf.appd.appb("WMSelfInterstitialAd", "视频播放错误：" + i10 + "\textra:" + i11);
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        appa.appa.appf.appd.appa("WMSelfInterstitialAd", "视频准备就绪");
        mediaPlayer.start();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.appc = motionEvent.getX();
            this.appd = motionEvent.getY();
            this.appe = motionEvent.getX();
            this.appf = motionEvent.getY();
            ConstantInfo.downX = this.appc;
            ConstantInfo.downY = this.appd;
            appa.appa.appf.appd.appa("API 插屏广告点击", Double.valueOf(ConstantInfo.downX), Double.valueOf(ConstantInfo.downY));
            appa(com.wangmai.ad.dex.allmodules.utils.appf.appl);
        }
        return !TextUtils.isEmpty(this.appg);
    }

    private void appc(ApiBean.WxadBean wxadBean) {
        int creative_type = wxadBean.getCreative_type();
        if (creative_type == 0) {
            appa.appa.appf.appd.appb("WMSelfInterstitialAd", "IPA.MW Interstitial 未知交互类型:" + creative_type);
            appa.appa.appd.appb appbVar = this.appi;
            if (appbVar != null) {
                appbVar.onNoAd("Interstitial 未知交互类型:" + creative_type);
            }
            appl();
            return;
        }
        if (creative_type != 2 && creative_type != 3) {
            if (creative_type != 5) {
                if (creative_type != 6) {
                    return;
                }
                this.appw.setVisibility(0);
                appa(wxadBean);
                return;
            }
            try {
                this.appu.setVisibility(0);
                appd(wxadBean.getDescription());
                return;
            } catch (Throwable th) {
                appa.appa.appf.appd.appb("WMSelfInterstitialAd", "IPA.MW Interstitial render html：" + th.toString());
                appl();
                return;
            }
        }
        try {
            String image_src = wxadBean.getImage_src();
            if (TextUtils.isEmpty(image_src)) {
                appa.appa.appf.appd.appb("WMSelfInterstitialAd", "Interstitial image src is null");
                if (this.appi != null) {
                    this.appi.onNoAd("Interstitial 图片物料无效");
                }
                appl();
                return;
            }
            this.appt.setVisibility(0);
            String[] split = image_src.split(";");
            if (split.length == 0) {
                appa.appa.appf.appd.appb("WMSelfInterstitialAd", "Interstitial image src length 0");
                if (this.appi != null) {
                    this.appi.onNoAd("Interstitial 图片物料无效");
                }
                appl();
                return;
            }
            OkHttp.get(split[0]).execute(new appm());
        } catch (Throwable th2) {
            appa.appa.appf.appd.appb("WMSelfInterstitialAd", "Interstitial 图片涂料加载失败：" + th2.toString());
            appa.appa.appd.appb appbVar2 = this.appi;
            if (appbVar2 != null) {
                appbVar2.onNoAd("Interstitial 图片物料加载失败");
            }
            appl();
        }
    }

    private void appd(String str) {
        try {
            if (this.appi != null) {
                this.appi.onAdRequest();
            }
            WebSettings settings = this.apps.getSettings();
            settings.setLoadsImagesAutomatically(true);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            this.apps.setHorizontalScrollBarEnabled(false);
            this.apps.setVerticalScrollBarEnabled(false);
            appa.appa.appf.appd.appa("WMSelfInterstitialAd", "IPA.MW Interstitial htmlData：" + str);
            if (str.startsWith("<html>")) {
                this.apps.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
            } else {
                String str2 = "<html><head><style>* body{font-size:15px;margin:0;padding:0}{color:#212121;}img{max-width: 100%; width:auto; height: auto;}</style></head><body>" + str + "</body></html>";
                this.apps.loadDataWithBaseURL(null, str2, "text/html", "utf-8", null);
                appa.appa.appf.appd.appa("WMSelfInterstitialAd", "IPA.MW Interstitial resultStr：" + str2);
            }
            if (!TextUtils.isEmpty(this.appg)) {
                int i10 = 300;
                int intValue = appa(str, "width").intValue();
                int intValue2 = appa(str, "height").intValue();
                if (intValue <= 0 || intValue2 <= 0) {
                    intValue2 = 350;
                } else {
                    i10 = intValue;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Utils.dip2px(this.f46754p, i10), Utils.dip2px(this.f46754p, intValue2));
                layoutParams.addRule(13);
                this.apps.setLayoutParams(layoutParams);
                this.appv = new RelativeLayout(this.f46754p);
                this.appv.setLayoutParams(layoutParams);
                this.appu.addView(this.appv, 1);
                this.appv.setOnTouchListener(this);
                return;
            }
            this.apps.setDownloadListener(new appn());
            this.apps.setWebViewClient(new appo(this.f46754p, "WMSelfInterstitialAd"));
            this.apps.setOnTouchListener(this);
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("WMSelfInterstitialAd", "IPA.MW Interstitial render html：" + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appk() {
        try {
            if (this.apph != null) {
                this.apph.dismiss();
            }
            if (this.appi != null) {
                this.appi.onAdClose();
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("WMSelfInterstitialAd", "IPA.MW Interstitial deleteClick error:" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appl() {
        com.wangmai.ad.dex.allmodules.appc.appd.appb appbVar = this.apph;
        if (appbVar == null || !appbVar.isShowing()) {
            return;
        }
        this.apph.dismiss();
    }

    private void appm() {
        try {
            appa.appa.appf.appd.appa("WMSelfInterstitialAd", "IPA.MW Interstitial requestId:" + this.appp, "slotId:" + this.appo);
            com.wangmai.ad.dex.allmodules.appc.appb.appa(this.f46754p, "WMSelfInterstitialAd", this.appo, this.appp, new appl());
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("WMSelfInterstitialAd", "IPA.MW Interstitial 广告加载失败:" + th.toString());
            appa.appa.appd.appb appbVar = this.appi;
            if (appbVar != null) {
                appbVar.onNoAd("广告加载失败");
            }
            appl();
        }
    }

    public int appe() {
        return this.f46746h;
    }

    public List<String> appf() {
        return this.f46751m;
    }

    public int appg() {
        return this.f46747i;
    }

    public int apph() {
        return this.f46753o;
    }

    public String appi() {
        return this.f46750l;
    }

    public void appj() {
        try {
            if (this.appn) {
                appa.appa.appf.appd.appb("WMSelfInterstitialAd", "IPA.MW Interstitial 缺失必要参数");
                if (this.appi != null) {
                    this.appi.onNoAd("缺失必要参数");
                    return;
                }
                return;
            }
            if (this.f46741c) {
                return;
            }
            this.f46741c = true;
            appm();
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("WMSelfInterstitialAd", "IPA.MW Interstitial load error:" + th.toString());
            appa.appa.appd.appb appbVar = this.appi;
            if (appbVar != null) {
                appbVar.onNoAd("暂无广告");
            }
        }
    }

    void appb(ApiBean apiBean) {
        try {
            appa.appa.appf.appd.appa("WMSelfInterstitialAd", "IPA.MW Interstitial DspBidPrice:" + apiBean.getAdPrice().getDspBidPrice(), "MediaBidPrice:" + apiBean.getAdPrice().getMediaBidPrice());
            appc((int) Math.round(apiBean.getAdPrice().getDspBidPrice() * 100.0d));
            appd((int) Math.round(apiBean.getAdPrice().getMediaBidPrice() * 100.0d));
            appa.appa.appf.appd.appa("WMSelfInterstitialAd", "IPA.MW Interstitial DspBidPrice:" + appe(), "MediaBidPrice:" + appg());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("WMSelfInterstitialAd", "IPA.MW Interstitial setDspAndMediaPrice exception" + th.toString());
        }
    }

    public void appe(int i10) {
        this.f46753o = i10;
    }

    public void appa(Activity activity) {
        try {
            if (!this.appn) {
                this.appi.appa(appa.appa.appb.appa.READY);
                this.apph = new com.wangmai.ad.dex.allmodules.appc.appd.appb(activity, R$style.dialog, this.f46744f);
                this.apph.setCancelable(false);
                this.apph.setOnDismissListener(new appj());
                this.apph.setOnShowListener(new appk());
                this.apph.show();
            } else {
                appa.appa.appf.appd.appb("WMSelfInterstitialAd", "IPA.MW Interstitial show 缺失必要参数");
                if (this.appi != null) {
                    this.appi.appa(appa.appa.appb.appa.NOT_READY);
                    this.appi.appa("展示失败(缺失必要参数)");
                }
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("WMSelfInterstitialAd", "IPA.MW Interstitial show error:" + th.toString());
            appa.appa.appd.appb appbVar = this.appi;
            if (appbVar != null) {
                appbVar.appa("展示失败:" + th.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appb(ApiBean.WxadBean wxadBean) {
        List<String> list;
        new ArrayList();
        wxadBean.getDownload_track_urls();
        wxadBean.getDownloaded_track_urls();
        wxadBean.getWin_notice_url();
        wxadBean.getInteraction_type();
        this.appg = wxadBean.getLanding_page_url();
        wxadBean.getDeep_link();
        wxadBean.getClick_url();
        this.appq = wxadBean.getInstalled_track_urls();
        this.appr = wxadBean.getApp_package();
        if (this.appr != null && (list = this.appq) != null && list.size() > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("installed_track_urls_size", Integer.valueOf(this.appq.size()));
            for (int i10 = 0; i10 < this.appq.size(); i10++) {
                hashMap.put("installed_track_urls" + i10, this.appq.get(i10));
            }
            hashMap.put("brand_name", this.appr);
            SharedPreferencesHelper.getInstance(this.f46754p).savePreferencesMap(hashMap);
        }
        appc(wxadBean);
    }

    void appa(ApiBean apiBean) {
        try {
            if (apiBean.getOptimization() == null || apiBean.getOptimization().getAdCache() == null) {
                return;
            }
            appb(apiBean.getOptimization().getAdCache().getCacheTime() * 60 * 1000);
            appa(apiBean.getOptimization().getAdCache().getExpireTime());
            appb(apiBean.getOptimization().getAdCache().getCrid());
            appe(apiBean.getOptimization().getAdCache().getThirdSlotIdKey());
            appa.appa.appf.appd.appa("WMSelfInterstitialAd", "IPA.MW Interstitial adCacheTime:" + appb(), "expireTime:" + appc(), "ThirdSlotIdKey:" + apph());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("WMSelfInterstitialAd", "IPA.MW Interstitial setAdCache exception" + th.toString());
        }
    }

    private void appa(ApiBean.WxadBean wxadBean) {
        try {
            String v_url = wxadBean.getVideo().getV_url();
            appa.appa.appf.appd.appa("WMSelfInterstitialAd", "IPA.MW Interstitial videoUrl：" + v_url);
            if (TextUtils.isEmpty(v_url)) {
                appa.appa.appf.appd.appb("WMSelfInterstitialAd", "IPA.MW Interstitial 视频物料无效");
                appl();
                return;
            }
            appa(v_url);
            this.f46742d = new WMVideoView2(this.f46754p, this.f46743e, true, false, this.f46739appa, this.appb);
            this.f46742d.setVideoListener(new appa());
            if (this.appi != null) {
                this.appi.onAdRequest();
            }
            this.appx.addView(this.f46742d);
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("WMSelfInterstitialAd", "Interstitial init video error:" + th.toString());
            appa.appa.appd.appb appbVar = this.appi;
            if (appbVar != null) {
                appbVar.onNoAd("Interstitial 视频物料加载失败");
            }
            appl();
        }
    }

    public int appb() {
        return this.f46748j;
    }

    public void appb(int i10) {
        this.f46748j = i10;
    }

    public void appb(String str) {
        this.f46752n = str;
    }

    public void appd(int i10) {
        this.f46747i = i10;
    }

    public void appc(int i10) {
        this.f46746h = i10;
    }

    public String appd() {
        return this.f46752n;
    }

    public long appc() {
        return this.f46749k;
    }

    public void appc(String str) {
        this.f46750l = str;
    }

    void appa(String str) {
        int windowHeight;
        int windowHeight2;
        Uri parse = Uri.parse(str);
        int windowWidth = (int) (Utils.getWindowWidth(this.f46754p) * 0.8d);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
        } catch (Throwable th) {
            try {
                appa.appa.appf.appd.appe("WMSelfInterstitialAd", "Interstitial getVideo Size error:" + th.toString());
                windowHeight = (int) (Utils.getWindowHeight(this.f46754p) * 0.8d);
                appa.appa.appf.appd.appa("WMSelfInterstitialAd", "targetVideoWidth * targetVideoHeight", Integer.valueOf(windowWidth), Integer.valueOf(windowHeight));
            } catch (Throwable th2) {
                appa.appa.appf.appd.appa("WMSelfInterstitialAd", "targetVideoWidth * targetVideoHeight", Integer.valueOf(windowWidth), 0);
                this.appw.getLayoutParams().width = windowWidth;
                this.appw.getLayoutParams().height = 0;
                mediaMetadataRetriever.release();
                throw th2;
            }
        }
        if (parse != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", appx.appg(this.f46754p));
            mediaMetadataRetriever.setDataSource(str, hashMap);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
            if (!TextUtils.isEmpty(extractMetadata) && !TextUtils.isEmpty(extractMetadata2)) {
                float parseFloat = Float.parseFloat(extractMetadata) / Float.parseFloat(extractMetadata2);
                appa.appa.appf.appd.appa("WMSelfInterstitialAd", "originVideoWidth * originVideoHeight", extractMetadata, extractMetadata2, "dimensionsScale:" + parseFloat);
                windowHeight = (int) (((float) windowWidth) / parseFloat);
                appa.appa.appf.appd.appa("WMSelfInterstitialAd", "targetVideoWidth * targetVideoHeight", Integer.valueOf(windowWidth), Integer.valueOf(windowHeight));
                this.appw.getLayoutParams().width = windowWidth;
                this.appw.getLayoutParams().height = windowHeight;
                mediaMetadataRetriever.release();
            }
            windowHeight2 = Utils.getWindowHeight(this.f46754p);
        } else {
            windowHeight2 = Utils.getWindowHeight(this.f46754p);
        }
        windowHeight = (int) (windowHeight2 * 0.8d);
        appa.appa.appf.appd.appa("WMSelfInterstitialAd", "targetVideoWidth * targetVideoHeight", Integer.valueOf(windowWidth), Integer.valueOf(windowHeight));
        this.appw.getLayoutParams().width = windowWidth;
        this.appw.getLayoutParams().height = windowHeight;
        mediaMetadataRetriever.release();
    }

    public void appa() {
        appa.appa.appf.appd.appa("WMSelfInterstitialAd", "IPA.MW Interstitial destroy");
        com.wangmai.ad.dex.allmodules.appc.appd.appb appbVar = this.apph;
        if (appbVar != null && appbVar.isShowing()) {
            this.apph.dismiss();
        }
        appu appuVar = this.f46756r;
        if (appuVar != null) {
            appuVar.appa(this.f46758t);
            this.f46756r = null;
        }
        appv appvVar = this.f46757s;
        if (appvVar != null) {
            appvVar.appa(this.f46759u);
            this.f46757s = null;
        }
    }

    private Integer appa(String str, String str2) {
        try {
            Matcher matcher = Pattern.compile("<img[^<>]*?\\s" + str2 + "=['\"]?(.*?)['\"]?\\s.*?>").matcher(str);
            String str3 = "";
            while (matcher.find()) {
                str3 = matcher.group(1).replace("px", "").replace(";", "");
            }
            appa.appa.appf.appd.appa("WMSelfInterstitialAd", "getImgWidthOrHeightFromHtml", "string = " + str3);
            return Integer.valueOf(str3);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("WMSelfInterstitialAd", "getImgWidthOrHeightFromHtml:" + th.toString());
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c4 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:4:0x0003, B:6:0x0035, B:7:0x003d, B:9:0x0043, B:10:0x004b, B:12:0x0051, B:13:0x0059, B:15:0x0062, B:16:0x0077, B:18:0x007d, B:22:0x0099, B:25:0x00a1, B:27:0x00ba, B:29:0x00c4, B:31:0x00cf, B:33:0x00d6, B:35:0x00dd, B:36:0x00e2, B:40:0x00a7, B:41:0x0086), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cf A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:4:0x0003, B:6:0x0035, B:7:0x003d, B:9:0x0043, B:10:0x004b, B:12:0x0051, B:13:0x0059, B:15:0x0062, B:16:0x0077, B:18:0x007d, B:22:0x0099, B:25:0x00a1, B:27:0x00ba, B:29:0x00c4, B:31:0x00cf, B:33:0x00d6, B:35:0x00dd, B:36:0x00e2, B:40:0x00a7, B:41:0x0086), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d6 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:4:0x0003, B:6:0x0035, B:7:0x003d, B:9:0x0043, B:10:0x004b, B:12:0x0051, B:13:0x0059, B:15:0x0062, B:16:0x0077, B:18:0x007d, B:22:0x0099, B:25:0x00a1, B:27:0x00ba, B:29:0x00c4, B:31:0x00cf, B:33:0x00d6, B:35:0x00dd, B:36:0x00e2, B:40:0x00a7, B:41:0x0086), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00dd A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:4:0x0003, B:6:0x0035, B:7:0x003d, B:9:0x0043, B:10:0x004b, B:12:0x0051, B:13:0x0059, B:15:0x0062, B:16:0x0077, B:18:0x007d, B:22:0x0099, B:25:0x00a1, B:27:0x00ba, B:29:0x00c4, B:31:0x00cf, B:33:0x00d6, B:35:0x00dd, B:36:0x00e2, B:40:0x00a7, B:41:0x0086), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void appa(com.wangmai.ad.dex.allmodules.bean.ApiBean.DownloadAppInfo r12) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.ad.dex.allmodules.appc.appd.appc.appa(com.wangmai.ad.dex.allmodules.bean.ApiBean$DownloadAppInfo):void");
    }

    void appa(int i10) {
        try {
            appa.appa.appf.appd.appe("WMSelfInterstitialAd", "Interstitial doClick", Thread.currentThread().getName(), Integer.valueOf(i10));
            this.f46760v = true;
            if (this.f46740b != null) {
                this.f46740b.appa("", false, i10, this.appc, this.appd, this.appe, this.appf);
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("WMSelfInterstitialAd", "Interstitial doClick error:" + ((Object) th));
            com.wangmai.ad.dex.allmodules.utils.appf.appa(this.f46754p, "", "Interstitial doClick error：" + Log.getStackTraceString(th));
        }
    }

    void appa(ApiBean.Optimization optimization) {
        try {
            if (optimization != null) {
                this.f46756r = new appu(this.f46754p, this.f46755q, optimization, false);
                this.f46758t = new appe();
                this.f46756r.appb(this.f46758t);
                this.f46757s = new appv(this.f46754p, this.f46755q, optimization, false);
                this.f46759u = new appf();
                this.f46757s.appa(this.f46744f, this.f46759u);
            } else {
                appa.appa.appf.appd.appe("WMSelfInterstitialAd", "模电误点未开启【优化配置为空或广告已开启互动】");
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("WMSelfInterstitialAd", "registerVirtualClick error:" + th.toString());
        }
    }

    public void appa(long j10) {
        this.f46749k = j10;
    }

    public void appa(List<String> list) {
        this.f46751m = list;
    }
}
