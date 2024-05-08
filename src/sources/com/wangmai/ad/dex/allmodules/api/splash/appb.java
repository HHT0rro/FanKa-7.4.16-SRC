package com.wangmai.ad.dex.allmodules.api.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import com.wangmai.ad.dex.allmodules.api.splash.ApiWMSplashView;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.ad.dex.allmodules.utils.appa;
import com.wangmai.ad.dex.allmodules.utils.appm;
import com.wangmai.ad.dex.allmodules.utils.appn;
import com.wangmai.ad.dex.allmodules.utils.appu;
import com.wangmai.ad.dex.allmodules.utils.appv;
import com.wangmai.bean.SplashProcessorBean;
import com.wangmai.common.Ilistener.XAdSplashListener;
import com.wangmai.common.runnable.HasTypeRunnable;
import com.wangmai.common.runnable.NoTypeRunnable;
import com.wangmai.common.utils.GsonUtils;
import com.wangmai.common.utils.SharedPreferencesHelper;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.callback.BitmapCallback;
import com.wangmai.okhttp.model.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: ApiWMSplashProcesser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appb extends appa.appa.appe.apph implements com.wangmai.ad.dex.allmodules.appf.appa {
    private static boolean appp = false;

    /* renamed from: appa, reason: collision with root package name */
    private SplashProcessorBean f46677appa;
    private ApiWMSplashView appb;
    private ApiBean appc;
    private ViewGroup appd;
    private apph appe;
    private appu appf;
    private appv appg;
    private appa.appc apph;
    private appa.appc appi;
    public float appj;
    public float appk;
    public float appl;
    public float appm;
    private boolean appn;
    private ApiWMSplashView.appr appo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMSplashProcesser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa implements ApiWMSplashView.appq {

        /* renamed from: appa, reason: collision with root package name */
        private boolean f46678appa;
        private long appb = 0;
        final /* synthetic */ int appc;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* compiled from: ApiWMSplashProcesser.java */
        /* renamed from: com.wangmai.ad.dex.allmodules.api.splash.appb$appa$appa, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class RunnableC0671appa implements Runnable {
            RunnableC0671appa() {
            }

            @Override // java.lang.Runnable
            public void run() {
                appb.this.appe();
            }
        }

        appa(int i10) {
            this.appc = i10;
        }

        private void appb(String str) {
            if (this.appb == 0 || System.currentTimeMillis() - this.appb > com.wangmai.ad.dex.allmodules.utils.appf.appc) {
                this.appb = System.currentTimeMillis();
                if (appb.this.appb != null) {
                    appb appbVar = appb.this;
                    appbVar.appj = appbVar.appb.f46653appa;
                    appb appbVar2 = appb.this;
                    appbVar2.appk = appbVar2.appb.appb;
                    appb appbVar3 = appb.this;
                    appbVar3.appl = appbVar3.appb.appc;
                    appb appbVar4 = appb.this;
                    appbVar4.appm = appbVar4.appb.appd;
                }
                appb appbVar5 = appb.this;
                appbVar5.appa(str, appbVar5.appc.getRespObj().getWxad().getLanding_page_url(), com.wangmai.ad.dex.allmodules.utils.appf.appl);
            }
        }

        @Override // com.wangmai.ad.dex.allmodules.api.splash.ApiWMSplashView.appq
        public void appa(String str) {
            appa.appa.appf.appd.appe("ApiWMSplashProcesser", "IPA.MW splash videoReflux:" + str);
        }

        @Override // com.wangmai.ad.dex.allmodules.api.splash.ApiWMSplashView.appq
        public void appb() {
        }

        @Override // com.wangmai.ad.dex.allmodules.api.splash.ApiWMSplashView.appq
        public void appc() {
            appa.appa.appf.appd.appa("ApiWMSplashProcesser", "Api splash swipe: ");
            appb(appb.this.appc.getRespObj().getWxad().getDeep_link());
        }

        @Override // com.wangmai.ad.dex.allmodules.api.splash.ApiWMSplashView.appq
        public void appd() {
            try {
                appa.appa.appf.appd.appa("ApiWMSplashProcesser", "Api splash touchEvent ClickRegionType=" + appb.this.f46677appa.getClickRegionType());
                int clickRegionType = appb.this.f46677appa.getClickRegionType();
                if (clickRegionType == 0 || clickRegionType == 1) {
                    appb(appb.this.appc.getRespObj().getWxad().getDeep_link());
                } else if (clickRegionType != 2 && clickRegionType == 3) {
                    appb("");
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("ApiWMSplashProcesser", "Api splash touchEvent error:" + th.toString());
            }
        }

        @Override // com.wangmai.ad.dex.allmodules.api.splash.ApiWMSplashView.appq
        public void appe() {
            try {
                this.f46678appa = false;
                if (appb.this.f46677appa.getCloseRand() > 0 && this.appc <= appb.this.f46677appa.getCloseRand()) {
                    this.f46678appa = true;
                    appa.appa.appf.appd.appa("ApiWMSplashProcesser", "Api splash skipEvent");
                    appb(appb.this.appc.getRespObj().getWxad().getDeep_link());
                }
                if (this.f46678appa) {
                    appb.this.appb.postDelayed(new RunnableC0671appa(), 1000L);
                } else {
                    appb.this.appe();
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("ApiWMSplashProcesser", "Api splash skipEvent error:" + th.toString());
            }
        }

        @Override // com.wangmai.ad.dex.allmodules.api.splash.ApiWMSplashView.appq
        public void appf() {
            appa.appa.appf.appd.appa("ApiWMSplashProcesser", "Api splash clickRegionTouchEvent");
            appb(appb.this.appc.getRespObj().getWxad().getDeep_link());
        }

        @Override // com.wangmai.ad.dex.allmodules.api.splash.ApiWMSplashView.appq
        public void start() {
        }

        @Override // com.wangmai.ad.dex.allmodules.api.splash.ApiWMSplashView.appq
        public void appa() {
            appa.appa.appf.appd.appa("ApiWMSplashProcesser", "Api splash shake: ");
            appb(appb.this.appc.getRespObj().getWxad().getDeep_link());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMSplashProcesser.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.api.splash.appb$appb, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class C0672appb implements HasTypeRunnable<ApiBean> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* compiled from: ApiWMSplashProcesser.java */
        /* renamed from: com.wangmai.ad.dex.allmodules.api.splash.appb$appb$appa */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        public class appa implements NoTypeRunnable {

            /* renamed from: appa, reason: collision with root package name */
            final /* synthetic */ ApiBean.WxadBean f46681appa;

            appa(ApiBean.WxadBean wxadBean) {
                this.f46681appa = wxadBean;
            }

            @Override // com.wangmai.common.runnable.NoTypeRunnable
            public void run() {
                if (appb.this.checkProcessorBean()) {
                    appb.this.f46677appa.getAdListener().onAdRequest();
                    int interaction_type = this.f46681appa.getInteraction_type();
                    if (interaction_type == 2 || interaction_type == 3 || interaction_type == 5) {
                        appb.this.appb.setDownLoadInfo(this.f46681appa.getDownload_app_info());
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* compiled from: ApiWMSplashProcesser.java */
        /* renamed from: com.wangmai.ad.dex.allmodules.api.splash.appb$appb$appb, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        public class C0673appb implements HasTypeRunnable<String> {
            C0673appb() {
            }

            @Override // com.wangmai.common.runnable.HasTypeRunnable
            /* renamed from: appa, reason: merged with bridge method [inline-methods] */
            public void run(String str) {
                if (appb.this.checkProcessorBean()) {
                    appb.this.f46677appa.getAdListener().onNoAd(str);
                }
            }
        }

        C0672appb() {
        }

        @Override // com.wangmai.common.runnable.HasTypeRunnable
        /* renamed from: appa, reason: merged with bridge method [inline-methods] */
        public void run(ApiBean apiBean) {
            try {
                if (apiBean == null) {
                    appa.appa.appf.appd.appe("ApiWMSplashProcesser", "IPA.MW splash 广告请求失败");
                    if (appb.this.checkProcessorBean()) {
                        appb.this.f46677appa.getAdListener().onNoAd("广告请求失败");
                        return;
                    }
                    return;
                }
                ApiBean.RespObj respObj = apiBean.getRespObj();
                ApiBean.WxadBean wxad = respObj.getWxad();
                if (respObj.getError_code() == 0 && wxad != null && appb.this.checkProcessorBean() && appb.this.appb != null) {
                    appb.this.appc = apiBean;
                    appb.this.setWinReportUrl(respObj.getNurl());
                    appb.this.appd();
                    appb.this.appc();
                    appb.this.setInValidCrids(apiBean.getInvalidCridList());
                    appb.this.appa(wxad);
                    appb.this.appa(apiBean, appb.this.appb, new appa(wxad), new C0673appb());
                    return;
                }
                appa.appa.appf.appd.appe("ApiWMSplashProcesser", "IPA.MW splash 广告请求失败：" + respObj.getError_code());
                appb.this.setInValidCrids(apiBean.getInvalidCridList());
                if (appb.this.checkProcessorBean()) {
                    appb.this.f46677appa.getAdListener().onNoAd("广告请求失败：" + respObj.getError_code());
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appb("ApiWMSplashProcesser", "IPA.MW splash 广告加载失败：" + th.toString());
                if (appb.this.checkProcessorBean()) {
                    appb.this.f46677appa.getAdListener().onNoAd("广告加载失败:" + th.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMSplashProcesser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appd extends BitmapCallback {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ long f46684appa;
        final /* synthetic */ ApiWMSplashView appb;
        final /* synthetic */ ApiBean appc;
        final /* synthetic */ NoTypeRunnable appd;
        final /* synthetic */ String[] appe;
        final /* synthetic */ HasTypeRunnable appf;

        appd(long j10, ApiWMSplashView apiWMSplashView, ApiBean apiBean, NoTypeRunnable noTypeRunnable, String[] strArr, HasTypeRunnable hasTypeRunnable) {
            this.f46684appa = j10;
            this.appb = apiWMSplashView;
            this.appc = apiBean;
            this.appd = noTypeRunnable;
            this.appe = strArr;
            this.appf = hasTypeRunnable;
        }

        @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
        public void onError(Response<Bitmap> response) {
            appa.appa.appf.appd.appb("ApiWMSplashProcesser", "IPA.MW splash 图片物料下载失败" + this.appe[0] + ",error:" + response.getException().toString());
            this.appf.run("图片物料下载失败");
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<Bitmap> response) {
            try {
                appa.appa.appf.appd.appa("ApiWMSplashProcesser", "Api splash onResponseImage", "图片物料下载耗时 " + (System.currentTimeMillis() - this.f46684appa) + " ms");
                if (!appb.this.checkProcessorBean() || response == null) {
                    return;
                }
                this.appb.setImageView(response.body());
                appb.this.appa(this.appc);
                this.appd.run();
            } catch (Throwable th) {
                appa.appa.appf.appd.appb("ApiWMSplashProcesser", "IPA.MW splash load image ：" + this.appe[0] + ",exception:" + th.toString());
                HasTypeRunnable hasTypeRunnable = this.appf;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("图片物料加载失败:");
                sb2.append(th.toString());
                hasTypeRunnable.run(sb2.toString());
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMSplashProcesser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appe implements ApiWMSplashView.appr {
        appe() {
        }

        @Override // com.wangmai.ad.dex.allmodules.api.splash.ApiWMSplashView.appr
        public void invisible() {
            appb.this.pause();
        }

        @Override // com.wangmai.ad.dex.allmodules.api.splash.ApiWMSplashView.appr
        public void visible() {
            appb.this.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMSplashProcesser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appf implements appa.appc {
        appf() {
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appa.appc
        public void appa(int i10, float f10, float f11, float f12, float f13) {
            if (!appb.this.appn) {
                try {
                    if (appb.this.appb != null) {
                        appb.this.appb.getLocationOnScreen(new int[2]);
                        appb.this.appj = r4[0] + (appb.this.appb.getWidth() / 2);
                        appb.this.appk = r4[1] + (appb.this.appb.getHeight() / 2);
                        appb.this.appl = appb.this.appj;
                        appb.this.appm = appb.this.appk;
                    }
                    appb.this.appf.appf();
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe("ApiWMSplashProcesser", "开屏模拟点击预处理失败：" + th);
                }
                appb appbVar = appb.this;
                appbVar.appa(appbVar.appc.getRespObj().getWxad().getDeep_link(), appb.this.appc.getRespObj().getWxad().getLanding_page_url(), com.wangmai.ad.dex.allmodules.utils.appf.appm);
                return;
            }
            appa.appa.appf.appd.appe("ApiWMSplashProcesser", "未触发模拟点击逻辑（已点击限制）");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMSplashProcesser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appg implements appa.appc {
        appg() {
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appa.appc
        public void appa(int i10, float f10, float f11, float f12, float f13) {
            if (!appb.this.appn) {
                try {
                    appb.this.appj = f10;
                    appb.this.appk = f11;
                    appb.this.appl = f12;
                    appb.this.appm = f13;
                    appb.this.appg.apph();
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe("ApiWMSplashProcesser", "开屏滑动点击预处理失败：" + th);
                }
                appb appbVar = appb.this;
                appbVar.appa(appbVar.appc.getRespObj().getWxad().getDeep_link(), appb.this.appc.getRespObj().getWxad().getLanding_page_url(), com.wangmai.ad.dex.allmodules.utils.appf.appn);
                return;
            }
            appa.appa.appf.appd.appe("ApiWMSplashProcesser", "未触发滑动点击逻辑（已点击限制）");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMSplashProcesser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class apph extends Handler {

        /* renamed from: appa, reason: collision with root package name */
        private int f46688appa;
        private ApiWMSplashView appb;
        private XAdSplashListener appc;

        public apph(Looper looper, ApiWMSplashView apiWMSplashView, XAdSplashListener xAdSplashListener) {
            super(looper);
            this.f46688appa = 5000;
            this.appb = apiWMSplashView;
            this.appc = xAdSplashListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            appa.appa.appf.appd.appa("ApiWMSplashProcesser", "onTick：" + this.f46688appa, "isPause:" + appb.appp);
            if (this.f46688appa >= 0) {
                if (!appb.appp) {
                    this.appb.setTextView((this.f46688appa / 1000) + " | 跳过");
                    this.f46688appa = this.f46688appa + (-500);
                }
                sendEmptyMessageDelayed(1, 500L);
                return;
            }
            if (this.appc != null) {
                appa.appa.appf.appd.appa("ApiWMSplashProcesser", "倒计时结束，回调上文onAdDismissed");
                this.appc.onAdDismissed();
            }
        }
    }

    public appb(Context context) {
        super(context);
        this.appj = -999.0f;
        this.appk = -999.0f;
        this.appl = -999.0f;
        this.appm = -999.0f;
        this.appn = false;
        this.appo = new appe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkProcessorBean() {
        SplashProcessorBean splashProcessorBean = this.f46677appa;
        return (splashProcessorBean == null || splashProcessorBean.getAdListener() == null) ? false : true;
    }

    @Override // com.wangmai.ad.dex.allmodules.appf.appa
    public void destroy() {
    }

    @Override // appa.appa.appe.apph
    public void load(SplashProcessorBean splashProcessorBean) {
        this.f46677appa = splashProcessorBean;
        appf();
        appb();
    }

    @Override // appa.appa.appa.appa
    public void onDestroy() {
        try {
            appa.appa.appf.appd.appa("ApiWMSplashProcesser", "IPA.MW Splash onDestroy");
            this.appb.appa();
            appa();
            if (this.appd != null) {
                this.appd.removeAllViews();
                this.appd = null;
            }
            if (this.appb != null) {
                this.appb.removeAllViews();
                this.appb.clearAnimation();
                this.appb.setListener(null);
                this.appb = null;
            }
            if (this.f46677appa != null) {
                this.f46677appa.setAdListener(null);
                this.f46677appa = null;
            }
            if (this.appf != null) {
                this.appf.appa(this.apph);
                this.appf = null;
            }
            if (this.appg != null) {
                this.appg.appa(this.appi);
                this.appg = null;
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMSplashProcesser", "Api splash onDestroy error:" + th.toString());
        }
    }

    @Override // com.wangmai.ad.dex.allmodules.appf.appa
    public void pause() {
        ApiWMSplashView apiWMSplashView = this.appb;
        if (apiWMSplashView != null) {
            apiWMSplashView.appb();
        }
        appp = true;
    }

    @Override // com.wangmai.ad.dex.allmodules.appf.appa
    public void resume() {
        ApiWMSplashView apiWMSplashView = this.appb;
        if (apiWMSplashView != null) {
            apiWMSplashView.appc();
        }
        appp = false;
    }

    @Override // appa.appa.appa.appa
    public void sendLossNotification(String str, String str2, String str3) {
    }

    @Override // appa.appa.appa.appa
    public void sendWinNotification(String str, String str2) {
    }

    @Override // appa.appa.appe.apph
    public void show(ViewGroup viewGroup) {
        try {
            this.appd = viewGroup;
            if (this.appc.getOptimization() != null) {
                this.appb.setInteractionType(this.appc.getOptimization().getInteractiveObjs());
            }
            if (this.appb.getType() != -1) {
                appa(this.appc.getOptimization());
                this.appb.appe();
                this.appb.setVolume(0.0f);
                if (this.appe == null) {
                    this.appe = new apph(Looper.getMainLooper(), this.appb, this.f46677appa.getAdListener());
                }
                this.appe.sendEmptyMessage(1);
                appa.appa.appf.appb.appb(this.appb);
                viewGroup.addView(this.appb);
                if (checkProcessorBean()) {
                    appg();
                    this.f46677appa.getAdListener().appa(appa.appa.appb.appa.READY);
                    this.f46677appa.getAdListener().onExposure();
                    this.f46677appa.getAdListener().appa(false);
                    this.f46677appa.getAdListener().appa();
                    return;
                }
                return;
            }
            appa.appa.appf.appd.appb("ApiWMSplashProcesser", "IPA.MW splash show error:广告尚未准备完毕");
            if (checkProcessorBean()) {
                this.f46677appa.getAdListener().appa("广告尚未准备完毕");
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("ApiWMSplashProcesser", "IPA.MW splash show error:" + th.getMessage());
            if (checkProcessorBean()) {
                this.f46677appa.getAdListener().appa("广告展示失败:" + th.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMSplashProcesser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appc implements appm {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46683appa;
        final /* synthetic */ HasTypeRunnable appb;
        final /* synthetic */ long appc;
        final /* synthetic */ ApiBean appd;
        final /* synthetic */ ApiWMSplashView appe;
        final /* synthetic */ NoTypeRunnable appf;

        appc(String str, HasTypeRunnable hasTypeRunnable, long j10, ApiBean apiBean, ApiWMSplashView apiWMSplashView, NoTypeRunnable noTypeRunnable) {
            this.f46683appa = str;
            this.appb = hasTypeRunnable;
            this.appc = j10;
            this.appd = apiBean;
            this.appe = apiWMSplashView;
            this.appf = noTypeRunnable;
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appa() {
            appa.appa.appf.appd.appb("ApiWMSplashProcesser", "IPA.MW splash downLoad video failed");
            this.appb.run("视频物料下载失败");
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appa(int i10) {
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appb() {
            appa.appa.appf.appd.appa("ApiWMSplashProcesser", "Api splash downLoad material start, request url：" + this.f46683appa);
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appc() {
            appa.appa.appf.appd.appa("ApiWMSplashProcesser", "Api splash downloading material...");
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appa(String str) {
            try {
                appa.appa.appf.appd.appa("ApiWMSplashProcesser", "Api splash downLoad material success, request url：" + this.f46683appa + " 视频物料下载耗时 " + (System.currentTimeMillis() - this.appc) + " ms");
                appb.this.appa((ApiBean) GsonUtils.getInstance().fromJson(GsonUtils.getInstance().toJson(this.appd), ApiBean.class));
                if (this.appe.appa(this.f46683appa)) {
                    this.appf.run();
                } else {
                    this.appb.run("视频物料路径错误");
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appb("ApiWMSplashProcesser", "IPA.MW splash 视频物料加载失败:" + th.toString());
                this.appb.run("视频物料加载失败:" + th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appe() {
        appa.appa.appf.appd.appa("ApiWMSplashProcesser", "Api splash clickSkipEvent");
        if (checkProcessorBean()) {
            this.f46677appa.getAdListener().onAdDismissed();
        }
        appa();
    }

    private void appf() {
        try {
            this.appb = new ApiWMSplashView(getApplicationContext(), this.f46677appa.getClickRegionType(), this.f46677appa.getDowlandDialogType(), this.f46677appa.getBean() == null || TextUtils.isEmpty(this.f46677appa.getBean().getWmTitle()) || TextUtils.isEmpty(this.f46677appa.getBean().getWmDesc()));
            this.appb.setListener(new appa(new Random().nextInt(100) + 1));
            this.appb.setViewVisibleListener(this.appo);
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("ApiWMSplashProcesser", "IPA.MW splash 广告初始化失败：" + th.toString());
            if (checkProcessorBean()) {
                this.f46677appa.getAdListener().onNoAd("暂无广告");
            }
        }
    }

    private void appg() {
        try {
            com.wangmai.ad.dex.allmodules.utils.appf.appa(this.appc.getRespObj().getWxad().getWin_notice_url(), "API展示上报");
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMSplashProcesser", "IPA.MW splash showReport:" + th.toString());
        }
    }

    void appc() {
        try {
            if (this.appc.getOptimization() == null || this.appc.getOptimization().getAdCache() == null) {
                return;
            }
            setAdCacheTime(this.appc.getOptimization().getAdCache().getCacheTime() * 60 * 1000);
            setExpireTime(this.appc.getOptimization().getAdCache().getExpireTime());
            setCrid(this.appc.getOptimization().getAdCache().getCrid());
            setThirdSlotIdKey(this.appc.getOptimization().getAdCache().getThirdSlotIdKey());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMSplashProcesser", "IPA.MW splash setAdCache exception:" + th.toString());
        }
    }

    void appd() {
        try {
            setDspPrice((int) Math.round(this.appc.getAdPrice().getDspBidPrice() * 100.0d));
            setMediaBidPrice((int) Math.round(this.appc.getAdPrice().getMediaBidPrice() * 100.0d));
            appa.appa.appf.appd.appa("ApiWMSplashProcesser", "IPA.MW splash DspBidPrice:" + getDspPrice(), "MediaBidPrice:" + getMediaBidPrice());
        } catch (Throwable th) {
            th.printStackTrace();
            appa.appa.appf.appd.appe("ApiWMSplashProcesser", "IPA.MW splash setDspAndMediaPrice exception:" + th.toString());
        }
    }

    void appb() {
        try {
            appa.appa.appf.appd.appa("ApiWMSplashProcesser", "requestAd requestId:" + this.f46677appa.getRequestId(), "slotId:" + this.f46677appa.getSlotId());
            com.wangmai.ad.dex.allmodules.appc.appb.appa(getApplicationContext(), "ApiWMSplashProcesser", this.f46677appa.getSlotId(), this.f46677appa.getRequestId(), new C0672appb());
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("ApiWMSplashProcesser", "IPA.MW splash 广告加载失败：" + th.toString());
            if (checkProcessorBean()) {
                this.f46677appa.getAdListener().onNoAd("广告加载失败:" + th.getMessage());
            }
        }
    }

    void appa(ApiBean.WxadBean wxadBean) {
        try {
            setTrackInfo(wxadBean.getSdk_track_url(), wxadBean.getSdk_track_event_type(), wxadBean.getSdk_dp_app_state_total_time());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMSplashProcesser", "IPA.MW splash setTrackInfo error:" + th.toString());
        }
    }

    void appa() {
        apph apphVar = this.appe;
        if (apphVar != null) {
            apphVar.removeMessages(1);
            this.appe = null;
        }
    }

    private void appb(String str, String str2, int i10) {
        try {
            try {
                com.wangmai.ad.dex.allmodules.utils.appf.appa(this.appc.getRespObj().getWxad().getClick_url(), (List<String>) null, i10, this.appj, this.appk, this.appl, this.appm);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("ApiWMSplashProcesser", "Splash clickUpEventReport error:" + ((Object) th));
                com.wangmai.ad.dex.allmodules.utils.appf.appa(getApplicationContext(), checkProcessorBean() ? this.f46677appa.getSlotId() : "", "Splash clickUpEventReport error:" + Log.getStackTraceString(th));
            }
            appa(str, str2);
        } catch (Throwable th2) {
            appa.appa.appf.appd.appe("ApiWMSplashProcesser", "Splash openLinkAddress error:" + ((Object) th2));
            com.wangmai.ad.dex.allmodules.utils.appf.appa(getApplicationContext(), checkProcessorBean() ? this.f46677appa.getSlotId() : "", "Splash openLinkAddress error:" + Log.getStackTraceString(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appa(ApiBean apiBean, ApiWMSplashView apiWMSplashView, NoTypeRunnable noTypeRunnable, HasTypeRunnable<String> hasTypeRunnable) {
        int creative_type = apiBean.getRespObj().getWxad().getCreative_type();
        if (creative_type == 2 || creative_type == 3) {
            String image_src = apiBean.getRespObj().getWxad().getImage_src();
            if (TextUtils.isEmpty(image_src)) {
                appa.appa.appf.appd.appb("ApiWMSplashProcesser", "IPA.MW splash image src is null");
                hasTypeRunnable.run("图片物料无效");
                return;
            }
            appa.appa.appf.appd.appa("ApiWMSplashProcesser", "Api splash image_src: --" + image_src);
            String[] split = image_src.split(";");
            try {
                OkHttp.get(split[0]).execute(new appd(System.currentTimeMillis(), apiWMSplashView, apiBean, noTypeRunnable, split, hasTypeRunnable));
                return;
            } catch (Throwable th) {
                appa.appa.appf.appd.appb("ApiWMSplashProcesser", "IPA.MW splash 物料加载失败：" + th.toString());
                hasTypeRunnable.run("物料加载失败:" + th.getMessage());
                return;
            }
        }
        if (creative_type == 5) {
            String description = apiBean.getRespObj().getWxad().getDescription();
            appa(apiBean);
            noTypeRunnable.run();
            apiWMSplashView.appa(description, apiBean.getRespObj().getWxad().getLanding_page_url());
            return;
        }
        if (creative_type != 6) {
            appa.appa.appf.appd.appb("ApiWMSplashProcesser", "IPA.MW splash 不支持的广告交互类型,请检查物料:" + creative_type);
            hasTypeRunnable.run("不支持的广告交互类型,请检查物料:" + creative_type);
            return;
        }
        ApiBean.Video video = apiBean.getRespObj().getWxad().getVideo();
        if (video == null) {
            appa.appa.appf.appd.appb("ApiWMSplashProcesser", "IPA.MW splash video is null");
            hasTypeRunnable.run("视频物料无效");
        } else if (video.getV_type() == 1 && appa.appa.appf.appb.appa(getApplicationContext()) == 1) {
            String v_url = video.getV_url();
            appn.appa().appa(getApplicationContext(), "", true, 0, v_url, new appc(v_url, hasTypeRunnable, System.currentTimeMillis(), apiBean, apiWMSplashView, noTypeRunnable));
        } else {
            appa.appa.appf.appd.appb("ApiWMSplashProcesser", "IPA.MW splash 当前网络环境较弱或视频格式错误！");
            hasTypeRunnable.run("当前网络环境较弱或视频格式错误！");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appa(ApiBean apiBean) {
        try {
            if (this.appc.getRespObj().getWxad().getApp_package() == null || this.appc.getRespObj().getWxad().getInstalled_track_urls() == null || this.appc.getRespObj().getWxad().getInstalled_track_urls().size() <= 0) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("installed_track_urls_size", Integer.valueOf(this.appc.getRespObj().getWxad().getInstalled_track_urls().size()));
            for (int i10 = 0; i10 < this.appc.getRespObj().getWxad().getInstalled_track_urls().size(); i10++) {
                hashMap.put("installed_track_urls" + i10, this.appc.getRespObj().getWxad().getInstalled_track_urls().get(i10));
            }
            hashMap.put("brand_name", apiBean.getRespObj().getWxad().getApp_package());
            SharedPreferencesHelper.getInstance(getApplicationContext()).savePreferencesMap(hashMap);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMSplashProcesser", "Api splash loadUrl:" + th.toString());
        }
    }

    void appa(String str, String str2, int i10) {
        try {
            appa.appa.appf.appd.appa("ApiWMSplashProcesser", "Splash doClick:", Thread.currentThread().getName(), Integer.valueOf(i10));
            this.appn = true;
            if (checkProcessorBean()) {
                try {
                    this.f46677appa.getAdListener().onClick();
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe("ApiWMSplashProcesser", "Splash media onClick error:" + ((Object) th));
                    com.wangmai.ad.dex.allmodules.utils.appf.appa(getApplicationContext(), this.f46677appa.getSlotId(), "Splash media onClick error：" + Log.getStackTraceString(th));
                }
            }
            appb(str, str2, i10);
        } catch (Throwable th2) {
            appa.appa.appf.appd.appe("ApiWMSplashProcesser", "Splash doClick error:" + ((Object) th2));
            com.wangmai.ad.dex.allmodules.utils.appf.appa(getApplicationContext(), checkProcessorBean() ? this.f46677appa.getSlotId() : "", "Splash doClick error：" + Log.getStackTraceString(th2));
        }
    }

    private void appa(String str, String str2) {
        int i10;
        int i11;
        try {
            if (checkProcessorBean()) {
                i10 = this.f46677appa.getDowlandDialogType();
                i11 = this.f46677appa.getSdkInvokeFailRetry();
            } else {
                i10 = 1;
                i11 = 0;
            }
            com.wangmai.ad.dex.allmodules.utils.appf.appa(null, false, str, str2, getApplicationContext(), this.appj, this.appk, this.appl, this.appm, this.appc, this, i10, i11);
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("ApiWMSplashProcesser", "Api splash clickLoadPage error:" + ((Object) th));
            com.wangmai.ad.dex.allmodules.utils.appf.appa(getApplicationContext(), checkProcessorBean() ? this.f46677appa.getSlotId() : "", "Api splash clickLoadPage error:" + Log.getStackTraceString(th));
        }
    }

    void appa(ApiBean.Optimization optimization) {
        try {
            if (checkProcessorBean() && optimization != null) {
                this.appf = new appu(getApplicationContext(), this.f46677appa.getMediaAdSlotId(), optimization, false);
                this.apph = new appf();
                this.appf.appb(this.apph);
                this.appg = new appv(getApplicationContext(), this.f46677appa.getMediaAdSlotId(), optimization, false);
                this.appi = new appg();
                this.appg.appa(getTaskTopActivity().get(), this.appi);
            } else {
                appa.appa.appf.appd.appe("ApiWMSplashProcesser", "模点误点未开启【优化配置为空或广告已开启互动】");
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMSplashProcesser", "registerVirtualClick error:" + th.toString());
        }
    }
}
