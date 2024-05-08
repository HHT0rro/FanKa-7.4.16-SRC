package com.wangmai.ad.dex.allmodules.appc.appc;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wangmai.ad.dex.allmodules.R$mipmap;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.ad.dex.allmodules.utils.appa;
import com.wangmai.ad.dex.allmodules.utils.appu;
import com.wangmai.ad.dex.allmodules.utils.appv;
import com.wangmai.ad.dex.allmodules.view.WMVideoView2;
import com.wangmai.bean.NativeProcessorBean;
import com.wangmai.common.Ilistener.IWMAppDownloadListener;
import com.wangmai.common.nativepot.AdBaseInfo;
import com.wangmai.common.nativepot.HtmlBean;
import com.wangmai.common.nativepot.NativeWMResponse;
import com.wangmai.common.nativepot.Permission;
import com.wangmai.common.nativepot.WMVideoBean;
import com.wangmai.common.nativepot.WMVideoControl;
import com.wangmai.common.nativepot.WMVideoListener;
import com.wangmai.common.nativepot.WMVideoOption;
import com.wangmai.common.runnable.HasTypeRunnable;
import com.wangmai.common.utils.ConstantInfo;
import com.wangmai.common.utils.GsonUtils;
import com.wangmai.common.utils.SharedPreferencesHelper;
import com.wangmai.common.utils.Utils;
import com.wangmai.common.utils.WMResources;
import com.wangmai.common.view.CustomWebView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: ApiWMNativePotProcesser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appa extends appa.appa.appe.appd {

    /* renamed from: appa, reason: collision with root package name */
    public float f46722appa;
    public float appb;
    public float appc;
    public float appd;
    private CustomWebView appe;
    private WMVideoView2 appf;
    private RelativeLayout appg;
    private ApiBean apph;
    private NativeProcessorBean appi;
    private WMVideoBean appj;
    private IWMAppDownloadListener appk;
    private IWMAppDownloadListener appl;
    private appu appm;
    private appv appn;
    private appa.appc appo;
    private appa.appc appp;
    private boolean appq;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMNativePotProcesser.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.appc.appc.appa$appa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class C0680appa implements HasTypeRunnable<ApiBean> {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ NativeProcessorBean f46723appa;

        C0680appa(NativeProcessorBean nativeProcessorBean) {
            this.f46723appa = nativeProcessorBean;
        }

        @Override // com.wangmai.common.runnable.HasTypeRunnable
        /* renamed from: appa, reason: merged with bridge method [inline-methods] */
        public void run(ApiBean apiBean) {
            if (apiBean == null) {
                appa.appa.appf.appd.appb("ApiWMNativePotProcesser", "IPA.MW NativePot 广告请求失败");
                if (this.f46723appa.getAdListener() != null) {
                    this.f46723appa.getAdListener().onNoAd("广告请求失败");
                    return;
                }
                return;
            }
            ApiBean.RespObj respObj = apiBean.getRespObj();
            ApiBean.WxadBean wxad = respObj.getWxad();
            if (respObj.getError_code() == 0 && wxad != null) {
                appa.this.setWinReportUrl(respObj.getNurl());
                appa.this.appb(apiBean);
                appa.this.appa(apiBean);
                appa.this.setInValidCrids(apiBean.getInvalidCridList());
                appa.this.appc(apiBean);
                appa.this.appd(apiBean);
                return;
            }
            appa.appa.appf.appd.appb("ApiWMNativePotProcesser", "IPA.MW NativePot 广告请求失败:" + respObj.getError_code());
            appa.this.setInValidCrids(apiBean.getInvalidCridList());
            if (this.f46723appa.getAdListener() != null) {
                this.f46723appa.getAdListener().onNoAd("onNoAd:" + respObj.getError_code());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMNativePotProcesser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb implements NativeWMResponse {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ ApiBean.WxadBean f46724appa;
        final /* synthetic */ ApiBean appb;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* compiled from: ApiWMNativePotProcesser.java */
        /* renamed from: com.wangmai.ad.dex.allmodules.appc.appc.appa$appb$appa, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class C0681appa implements WMVideoView2.appf {

            /* renamed from: appa, reason: collision with root package name */
            final /* synthetic */ WMVideoListener f46725appa;

            C0681appa(WMVideoListener wMVideoListener) {
                this.f46725appa = wMVideoListener;
            }

            @Override // com.wangmai.ad.dex.allmodules.view.WMVideoView2.appf
            public void appa() {
                appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "Api NativePot onVideoPause");
            }

            @Override // com.wangmai.ad.dex.allmodules.view.WMVideoView2.appf
            public void appb() {
                appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "Api NativePot onVideoCompleted");
                this.f46725appa.onComplete();
            }

            @Override // com.wangmai.ad.dex.allmodules.view.WMVideoView2.appf
            public void appc() {
                appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "Api NativePot onVideoReady");
            }

            @Override // com.wangmai.ad.dex.allmodules.view.WMVideoView2.appf
            public void appd() {
                appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "Api NativePot onVideoResume");
            }

            @Override // com.wangmai.ad.dex.allmodules.view.WMVideoView2.appf
            public void appe() {
                appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "Api NativePot onVideoStart");
                this.f46725appa.onStart();
            }

            @Override // com.wangmai.ad.dex.allmodules.view.WMVideoView2.appf
            public void appf() {
                appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "Api NativePot onVideoClick");
                appa.this.appa(false, true, com.wangmai.ad.dex.allmodules.utils.appf.appl);
            }

            @Override // com.wangmai.ad.dex.allmodules.view.WMVideoView2.appf
            public void appg() {
                appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "Api NativePot onVideoStop");
                this.f46725appa.onStop();
            }

            @Override // com.wangmai.ad.dex.allmodules.view.WMVideoView2.appf
            public void onVideoError(String str) {
                appa.appa.appf.appd.appb("ApiWMNativePotProcesser", "Api NativePot onVideoError:" + str);
                this.f46725appa.onError(str);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* compiled from: ApiWMNativePotProcesser.java */
        /* renamed from: com.wangmai.ad.dex.allmodules.appc.appc.appa$appb$appb, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class C0682appb implements WMVideoControl {
            C0682appb() {
            }

            @Override // com.wangmai.common.nativepot.WMVideoControl
            public void pause() {
                if (appa.this.appf != null) {
                    appa.this.appf.appc();
                }
            }

            @Override // com.wangmai.common.nativepot.WMVideoControl
            public void resume() {
                if (appa.this.appf != null) {
                    appa.this.appf.appd();
                }
            }

            @Override // com.wangmai.common.nativepot.WMVideoControl
            public void setSilence(boolean z10) {
                if (appa.this.appf != null) {
                    appa.this.appf.setSilence(z10);
                }
            }

            @Override // com.wangmai.common.nativepot.WMVideoControl
            public void start() {
                if (appa.this.appf != null) {
                    appa.this.appf.appe();
                }
            }

            @Override // com.wangmai.common.nativepot.WMVideoControl
            public void stop() {
                if (appa.this.appf != null) {
                    appa.this.appf.appf();
                }
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* compiled from: ApiWMNativePotProcesser.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class appc implements CustomWebView.TouchCallback {
            appc() {
            }

            @Override // com.wangmai.common.view.CustomWebView.TouchCallback
            public void touchBack() {
                appa.this.appa(false, true, com.wangmai.ad.dex.allmodules.utils.appf.appl);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* compiled from: ApiWMNativePotProcesser.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class appd implements Runnable {

            /* renamed from: appa, reason: collision with root package name */
            final /* synthetic */ ViewGroup f46728appa;
            final /* synthetic */ View appb;

            appd(ViewGroup viewGroup, View view) {
                this.f46728appa = viewGroup;
                this.appb = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (((appa.appa.appe.appd) appa.this).autoGenerateAdLogo) {
                        ImageView imageView = new ImageView(appa.this.getApplicationContext());
                        imageView.setImageDrawable(WMResources.resources.getDrawable(R$mipmap.wm_ad_txt_logo));
                        int dip2px = Utils.dip2px(appa.this.getApplicationContext(), 52.0f);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px / 3);
                        layoutParams.addRule(12);
                        layoutParams.setMargins(15, 0, 0, 10);
                        imageView.setLayoutParams(layoutParams);
                        this.f46728appa.addView(imageView);
                    }
                    int width = this.appb.getWidth();
                    int height = this.appb.getHeight();
                    appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "mediaAdView.width:" + width, "mediaAdView.height:" + height);
                    this.f46728appa.getLayoutParams().width = width;
                    this.f46728appa.getLayoutParams().height = height;
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.appb.getLayoutParams();
                    appa.appa.appf.appd.appa("ApiWMNativePotProcesser", Integer.valueOf(marginLayoutParams.leftMargin), Integer.valueOf(marginLayoutParams.topMargin), Integer.valueOf(marginLayoutParams.rightMargin), Integer.valueOf(marginLayoutParams.bottomMargin));
                    ((ViewGroup.MarginLayoutParams) this.f46728appa.getLayoutParams()).setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    marginLayoutParams.setMargins(0, 0, 0, 0);
                    appa.this.appa(appb.this.appb.getOptimization(), this.f46728appa);
                } catch (Throwable th) {
                    appa.appa.appf.appd.appb("ApiWMNativePotProcesser", "IPA.MW bindToAdContainer error:" + th);
                }
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* compiled from: ApiWMNativePotProcesser.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class appe implements Runnable {

            /* renamed from: appa, reason: collision with root package name */
            final /* synthetic */ List f46729appa;

            appe(List list) {
                this.f46729appa = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (appa.this.appg.getParent() != null && appa.this.appg.getWidth() != 0 && appa.this.appg.getHeight() != 0 && appa.this.appg.getAlpha() != 0.0f && appa.this.appg.getVisibility() == 0) {
                        if (appa.this.checkProcessorBean()) {
                            appa.this.appi.getAdListener().onExposure();
                            appa.this.appi.getAdListener().appa();
                            com.wangmai.ad.dex.allmodules.utils.appf.appa(appa.this.apph.getRespObj().getWxad().getWin_notice_url(), "API展示上报");
                            appa.this.appa(this.f46729appa);
                        }
                    } else {
                        appa.appa.appf.appd.appb("ApiWMNativePotProcesser", "IPA.MW NativePot containerView加载异常,请检查广告加载流程是否正确或containerView是否正常显示");
                        if (appa.this.checkProcessorBean()) {
                            appa.this.appi.getAdListener().onNoAd("暂无广告");
                        }
                    }
                } catch (Throwable th) {
                    appa.appa.appf.appd.appb("ApiWMNativePotProcesser", "IPA.MW NativePot notifyAdViewShow error:" + th.toString());
                }
            }
        }

        appb(ApiBean.WxadBean wxadBean, ApiBean apiBean) {
            this.f46724appa = wxadBean;
            this.appb = apiBean;
        }

        @Override // com.wangmai.common.nativepot.NativeWMResponse
        public void bindToAdContainer(ViewGroup viewGroup, View view) {
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "Api NativePot bindToAdContainer");
            if (appa.this.checkProcessorBean()) {
                appa.this.appi.getAdListener().appb();
            }
            view.post(new appd(viewGroup, view));
            viewGroup.addView(view);
        }

        @Override // com.wangmai.common.nativepot.NativeWMResponse
        public ViewGroup buildContainer(boolean z10) {
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "Api NativePot buildContainer");
            ((appa.appa.appe.appd) appa.this).autoGenerateAdLogo = z10;
            appa appaVar = appa.this;
            appaVar.appg = new RelativeLayout(appaVar.getApplicationContext());
            appa.this.appg.setGravity(17);
            appa.this.appg.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            return appa.this.appg;
        }

        @Override // com.wangmai.common.nativepot.NativeWMResponse
        public HtmlBean buildHtmlView() {
            try {
                appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "Api NativePot buildHtmlView");
                if (this.f46724appa.getCreative_type() == 5) {
                    appa.this.appe = new CustomWebView(appa.this.getApplicationContext());
                    appa.this.appe.setTouchCallback(new appc());
                    WebSettings settings = appa.this.appe.getSettings();
                    settings.setLoadsImagesAutomatically(true);
                    settings.setJavaScriptEnabled(true);
                    settings.setDomStorageEnabled(true);
                    appa.this.appe.setHorizontalScrollBarEnabled(false);
                    appa.this.appe.setVerticalScrollBarEnabled(false);
                    String description = this.f46724appa.getDescription();
                    try {
                        appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "IPA.MW NativePot buildHtmlVie htmlData:" + description);
                        if (description.startsWith("<html>")) {
                            appa.this.appe.loadDataWithBaseURL(null, description, "text/html", "utf-8", null);
                        } else {
                            String str = "<html><head><style>* body{font-size:15px;margin:0;padding:0}{color:#212121;}img{max-width: 100%; width:auto; height: auto;}</style></head><body>" + description + "</body></html>";
                            appa.this.appe.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
                            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "IPA.MW NativePot buildHtmlView resultStr:" + str);
                        }
                    } catch (Throwable th) {
                        appa.appa.appf.appd.appb("ApiWMNativePotProcesser", "IPA.MW NativePot buildHtmlView error:" + th.toString());
                    }
                    HtmlBean htmlBean = new HtmlBean();
                    htmlBean.setView(appa.this.appe);
                    htmlBean.setCode(description);
                    return htmlBean;
                }
                appa.appa.appf.appd.appb("ApiWMNativePotProcesser", "IPA.MW NativePot buildHtmlView 只能用于 AdBaseInfo.Info.HTML 的对象");
                if (appa.this.checkProcessorBean()) {
                    appa.this.appi.getAdListener().onNoAd("暂无广告");
                }
                return null;
            } catch (Throwable th2) {
                appa.appa.appf.appd.appb("ApiWMNativePotProcesser", "IPA.MW NativePot buildHtmlView:" + th2.toString());
                if (appa.this.checkProcessorBean()) {
                    appa.this.appi.getAdListener().onNoAd("暂无广告");
                }
                return null;
            }
        }

        @Override // com.wangmai.common.nativepot.NativeWMResponse
        public WMVideoBean buildVideoView(WMVideoOption wMVideoOption, WMVideoListener wMVideoListener) {
            try {
                appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "Api NativePot buildVideoView");
                if (this.f46724appa.getCreative_type() == 6) {
                    appa.this.appf = new WMVideoView2(appa.this.getApplicationContext(), this.appb, wMVideoOption.isAutoPlay(), wMVideoOption.isSilence(), appa.this.appi.getDowlandDialogType(), appa.this.appi.getSdkInvokeFailRetry());
                    appa.this.appf.setLayoutParams(new ViewGroup.LayoutParams(-1, this.appb.getRespObj().getWxad().getMaterial_height()));
                    appa.this.appf.setVideoListener(new C0681appa(wMVideoListener));
                    appa.this.appj = new WMVideoBean(new C0682appb(), appa.this.appf);
                    return appa.this.appj;
                }
                appa.appa.appf.appd.appb("ApiWMNativePotProcesser", "IPA.MW NativePot buildVideoView 只能用于 AdBaseInfo.Info.VIDEO 的对象");
                if (appa.this.checkProcessorBean()) {
                    appa.this.appi.getAdListener().onNoAd("暂无广告");
                }
                return null;
            } catch (Throwable th) {
                appa.appa.appf.appd.appb("ApiWMNativePotProcesser", "IPA.MW NativePot buildVideoView error：" + th.toString());
                if (appa.this.checkProcessorBean()) {
                    appa.this.appi.getAdListener().onNoAd("暂无广告");
                }
                return null;
            }
        }

        @Override // com.wangmai.common.nativepot.NativeWMResponse
        public AdBaseInfo getBaseInfo() {
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "Api NativePot getBaseInfo");
            AdBaseInfo adBaseInfo = new AdBaseInfo();
            int creative_type = this.f46724appa.getCreative_type();
            if (creative_type == 1 || creative_type == 2 || creative_type == 3) {
                adBaseInfo.setMaterialType(AdBaseInfo.MaterialType.NORMAL);
                if (!TextUtils.isEmpty(this.f46724appa.getImage_src())) {
                    if (this.f46724appa.getImage_src().contains(";")) {
                        adBaseInfo.setImageUrls(Arrays.asList(this.f46724appa.getImage_src().split(";")));
                    } else {
                        adBaseInfo.setImageUrl(this.f46724appa.getImage_src());
                    }
                    adBaseInfo.setPictureWidth(this.f46724appa.getMaterial_width());
                    adBaseInfo.setPictureHeight(this.f46724appa.getMaterial_height());
                }
            } else if (creative_type == 5) {
                adBaseInfo.setMaterialType(AdBaseInfo.MaterialType.HTML);
                adBaseInfo.setDesc("");
            } else {
                if (creative_type != 6) {
                    appa.appa.appf.appd.appb("ApiWMNativePotProcesser", "IPA.MW NativePot 未知交互类型:" + this.f46724appa.getCreative_type());
                    if (!appa.this.checkProcessorBean()) {
                        return null;
                    }
                    appa.this.appi.getAdListener().onNoAd("未知交互类型");
                    return null;
                }
                adBaseInfo.setMaterialType(AdBaseInfo.MaterialType.VIDEO);
                adBaseInfo.setVideoWidth(this.f46724appa.getMaterial_width());
                adBaseInfo.setVideoHeight(this.f46724appa.getMaterial_height());
            }
            adBaseInfo.setTitle(this.f46724appa.getAd_title());
            adBaseInfo.setIconURL(this.f46724appa.getIcon_src());
            if (!TextUtils.isEmpty(this.f46724appa.getIcon_src())) {
                if (this.f46724appa.getIcon_src().contains(";")) {
                    adBaseInfo.setIconURL(this.f46724appa.getIcon_src().split(";")[0]);
                } else {
                    adBaseInfo.setIconURL(this.f46724appa.getIcon_src());
                }
            } else if (!TextUtils.isEmpty(this.f46724appa.getAdLogo())) {
                adBaseInfo.setIconURL(this.f46724appa.getAdLogo());
            }
            adBaseInfo.setDesc(this.f46724appa.getDescription());
            int interaction_type = this.f46724appa.getInteraction_type();
            if (interaction_type != 2 && interaction_type != 3 && interaction_type != 5) {
                adBaseInfo.setInteractionType(AdBaseInfo.InteractionType.NORMAL);
            } else {
                adBaseInfo.setInteractionType(AdBaseInfo.InteractionType.DOWNLOAD);
                appa.this.appa(this.f46724appa.getDownload_app_info(), adBaseInfo);
            }
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "IPA.MW NativePot AdBaseInfo:" + adBaseInfo.toString());
            return adBaseInfo;
        }

        @Override // com.wangmai.common.nativepot.NativeWMResponse
        public void notifyAdViewShow() {
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "Api NativePot notifyAdViewShow");
        }

        @Override // com.wangmai.common.nativepot.NativeWMResponse
        public void registerClickableViews(List<View> list) {
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "Api NativePot registerClickableViews");
            if (appa.this.appg != null) {
                appa.this.appg.post(new appe(list));
                return;
            }
            appa.appa.appf.appd.appb("ApiWMNativePotProcesser", "IPA.MW NativePot buildContainer方法未调用");
            if (appa.this.checkProcessorBean()) {
                appa.this.appi.getAdListener().onNoAd("暂无广告");
            }
        }

        @Override // com.wangmai.common.nativepot.NativeWMResponse
        public void setAppDownloadListener(IWMAppDownloadListener iWMAppDownloadListener) {
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "Api NativePot setAppDownloadListener");
            appa.this.appk = iWMAppDownloadListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMNativePotProcesser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appc implements View.OnTouchListener {
        appc() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                appa.this.f46722appa = motionEvent.getX();
                appa.this.appb = motionEvent.getY();
                appa.this.appc = motionEvent.getX();
                appa.this.appd = motionEvent.getY();
                ConstantInfo.downX = motionEvent.getX();
                ConstantInfo.downY = motionEvent.getY();
                appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "API 信息流自渲染广告点击", Double.valueOf(ConstantInfo.downX), Double.valueOf(ConstantInfo.downY));
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMNativePotProcesser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appd implements View.OnClickListener {
        appd() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            appa.this.appa(true, true, com.wangmai.ad.dex.allmodules.utils.appf.appl);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMNativePotProcesser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appe implements IWMAppDownloadListener {
        appe() {
        }

        @Override // com.wangmai.common.Ilistener.IWMAppDownloadListener
        public void handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "收到SDK合规弹窗通知，透传通知媒体");
            if (appa.this.appk != null) {
                appa.this.appk.handleDownloadDialog(onClickListener);
            }
        }

        @Override // com.wangmai.common.Ilistener.IWMAppDownloadListener
        public void onDownloadDialogDismiss() {
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "收到SDK合规弹窗关闭，透传通知媒体");
            if (appa.this.appk != null) {
                appa.this.appk.onDownloadDialogDismiss();
            }
        }

        @Override // com.wangmai.common.Ilistener.IWMAppDownloadListener
        public void onDownloadDialogShow() {
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "收到SDK合规弹窗展示，透传通知媒体");
            if (appa.this.appk != null) {
                appa.this.appk.onDownloadDialogShow();
            }
        }

        @Override // com.wangmai.common.Ilistener.IWMAppDownloadListener
        public void onDownloadFailed() {
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "收到SDK下载失败，透传通知媒体");
            if (appa.this.appk != null) {
                appa.this.appk.onDownloadFailed();
            }
        }

        @Override // com.wangmai.common.Ilistener.IWMAppDownloadListener
        public void onDownloadFinished() {
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "收到SDK下载完成，透传通知媒体");
            if (appa.this.appk != null) {
                appa.this.appk.onDownloadFinished();
            }
        }

        @Override // com.wangmai.common.Ilistener.IWMAppDownloadListener
        public void onDownloadPaused() {
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "收到SDK下载暂停，透传通知媒体");
            if (appa.this.appk != null) {
                appa.this.appk.onDownloadPaused();
            }
        }

        @Override // com.wangmai.common.Ilistener.IWMAppDownloadListener
        public void onDownloadResumed() {
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "收到SDK下载恢复，透传通知媒体");
            if (appa.this.appk != null) {
                appa.this.appk.onDownloadResumed();
            }
        }

        @Override // com.wangmai.common.Ilistener.IWMAppDownloadListener
        public void onDownloadStarted() {
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "收到SDK下载开始，透传通知媒体");
            if (appa.this.appk != null) {
                appa.this.appk.onDownloadStarted();
            }
        }

        @Override // com.wangmai.common.Ilistener.IWMAppDownloadListener
        public void onProgressUpdate(int i10) {
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "收到SDK下载进度，透传通知媒体" + i10);
            if (appa.this.appk != null) {
                appa.this.appk.onProgressUpdate(i10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMNativePotProcesser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appf implements appa.appc {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ View f46733appa;

        appf(View view) {
            this.f46733appa = view;
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appa.appc
        public void appa(int i10, float f10, float f11, float f12, float f13) {
            if (!appa.this.appq) {
                try {
                    this.f46733appa.getLocationOnScreen(new int[2]);
                    appa.this.f46722appa = r4[0] + (this.f46733appa.getWidth() / 2);
                    appa.this.appb = r4[1] + (this.f46733appa.getHeight() / 2);
                    appa.this.appc = appa.this.f46722appa;
                    appa.this.appd = appa.this.appb;
                    appa.this.appm.appf();
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe("ApiWMNativePotProcesser", "自渲染模拟点击预处理失败：" + th);
                }
                appa.this.appa(true, true, com.wangmai.ad.dex.allmodules.utils.appf.appm);
                return;
            }
            appa.appa.appf.appd.appe("ApiWMNativePotProcesser", "未触发模拟点击逻辑（已点击限制）");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: ApiWMNativePotProcesser.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appg implements appa.appc {
        appg() {
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appa.appc
        public void appa(int i10, float f10, float f11, float f12, float f13) {
            if (!appa.this.appq) {
                try {
                    appa.this.f46722appa = f10;
                    appa.this.appb = f11;
                    appa.this.appc = f12;
                    appa.this.appd = f13;
                    appa.this.appn.apph();
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe("ApiWMNativePotProcesser", "自渲染滑动点击预处理失败：" + th);
                }
                appa.this.appa(true, true, com.wangmai.ad.dex.allmodules.utils.appf.appn);
                return;
            }
            appa.appa.appf.appd.appe("ApiWMNativePotProcesser", "未触发滑动点击逻辑（已点击限制）");
        }
    }

    public appa(Context context) {
        super(context);
        this.f46722appa = -999.0f;
        this.appb = -999.0f;
        this.appc = -999.0f;
        this.appd = -999.0f;
        this.appq = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkProcessorBean() {
        NativeProcessorBean nativeProcessorBean = this.appi;
        return (nativeProcessorBean == null || nativeProcessorBean.getAdListener() == null) ? false : true;
    }

    @Override // appa.appa.appe.appd
    public void nativeAd(NativeProcessorBean nativeProcessorBean) {
        try {
            this.appi = nativeProcessorBean;
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "IPA.MW NativePot requestId:" + nativeProcessorBean.getRequestId(), "slotId:" + nativeProcessorBean.getSlotId());
            com.wangmai.ad.dex.allmodules.appc.appb.appa(getApplicationContext(), "ApiWMNativePotProcesser", nativeProcessorBean.getSlotId(), nativeProcessorBean.getRequestId(), new C0680appa(nativeProcessorBean));
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("ApiWMNativePotProcesser", "IPA.MW NativePot 广告请求失败:" + th.toString());
            if (nativeProcessorBean.getAdListener() != null) {
                nativeProcessorBean.getAdListener().onNoAd("广告请求失败");
            }
        }
    }

    @Override // appa.appa.appa.appa
    public void onDestroy() {
        try {
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "IPA.MW NativePot onDestroy");
            if (this.appe != null) {
                this.appe.destroy();
                appa.appa.appf.appb.appb(this.appe);
                appa.appa.appf.appb.appa(this.appe);
                this.appe = null;
            }
            if (this.appf != null) {
                this.appf.appb();
                appa.appa.appf.appb.appb(this.appf);
                appa.appa.appf.appb.appa(this.appf);
                this.appf = null;
            }
            if (this.appg != null) {
                appa.appa.appf.appb.appb(this.appg);
                appa.appa.appf.appb.appa(this.appg);
                this.appg.setOnClickListener(null);
                this.appg = null;
            }
            if (this.appm != null) {
                this.appm.appa(this.appo);
                this.appm = null;
            }
            if (this.appn != null) {
                this.appn.appa(this.appp);
                this.appn = null;
            }
            this.apph = null;
            this.appj = null;
            this.appi = null;
            this.appk = null;
            this.appl = null;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMNativePotProcesser", "NativePot onDestroy error:" + th.toString());
        }
    }

    @Override // appa.appa.appa.appa
    public void sendLossNotification(String str, String str2, String str3) {
    }

    @Override // appa.appa.appa.appa
    public void sendWinNotification(String str, String str2) {
    }

    void setDownloadListener() {
        this.appl = new appe();
        com.wangmai.ad.dex.allmodules.utils.appf.appa(this.appl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appc(ApiBean apiBean) {
        try {
            this.apph = apiBean;
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "IPA.MW NativePot loadUrl：" + ((Object) apiBean.getRespObj().getWxad().getWin_notice_url()) + "--" + ((Object) apiBean.getRespObj().getWxad().getClick_url()));
            if (apiBean.getRespObj().getWxad().getApp_package() == null || apiBean.getRespObj().getWxad().getInstalled_track_urls() == null || apiBean.getRespObj().getWxad().getInstalled_track_urls().size() <= 0) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("installed_track_urls_size", Integer.valueOf(apiBean.getRespObj().getWxad().getInstalled_track_urls().size()));
            for (int i10 = 0; i10 < apiBean.getRespObj().getWxad().getInstalled_track_urls().size(); i10++) {
                hashMap.put("installed_track_urls" + i10, apiBean.getRespObj().getWxad().getInstalled_track_urls().get(i10));
            }
            hashMap.put("brand_name", apiBean.getRespObj().getWxad().getApp_package());
            SharedPreferencesHelper.getInstance(getApplicationContext()).savePreferencesMap(hashMap);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("IPA.MW NativePot loadUrl解析发生异常", th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appd(ApiBean apiBean) {
        try {
            ApiBean.WxadBean wxad = apiBean.getRespObj().getWxad();
            if (checkProcessorBean()) {
                this.appi.getAdListener().onAdRequest();
                this.appi.getAdListener().onNativePresent(new appb(wxad, apiBean));
                appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "Api NativePot nativePotWm：" + GsonUtils.getInstance().toJson(wxad));
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("ApiWMNativePotProcesser", "IPA.MW NativePot error：", th.toString());
            if (checkProcessorBean()) {
                this.appi.getAdListener().onNoAd("暂无广告");
            }
        }
    }

    void appb(ApiBean apiBean) {
        try {
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "IPA.MW NativePot DspBidPrice:" + apiBean.getAdPrice().getDspBidPrice(), "MediaBidPrice:" + apiBean.getAdPrice().getMediaBidPrice());
            setDspPrice((int) Math.round(apiBean.getAdPrice().getDspBidPrice() * 100.0d));
            setMediaBidPrice((int) Math.round(apiBean.getAdPrice().getMediaBidPrice() * 100.0d));
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "IPA.MW NativePot DspBidPrice:" + getDspPrice(), "MediaBidPrice:" + getMediaBidPrice());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMNativePotProcesser", "IPA.MW NativePot setDspAndMediaPrice error" + th.toString());
        }
    }

    void appa(List<View> list) {
        RelativeLayout relativeLayout;
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list.isEmpty() && (relativeLayout = this.appg) != null) {
            list.add(relativeLayout);
        }
        for (View view : list) {
            view.setOnTouchListener(new appc());
            view.setOnClickListener(new appd());
        }
    }

    void appa(ApiBean.DownloadAppInfo downloadAppInfo, AdBaseInfo adBaseInfo) {
        setDownloadListener();
        AdBaseInfo.WMDownloadAppInfo wMDownloadAppInfo = new AdBaseInfo.WMDownloadAppInfo();
        wMDownloadAppInfo.setAppName(downloadAppInfo.getApp_name());
        wMDownloadAppInfo.setAppVersion(downloadAppInfo.getVersion());
        wMDownloadAppInfo.setAppDeveloper(downloadAppInfo.getDeveloper());
        wMDownloadAppInfo.setAppDescContent(downloadAppInfo.getDesc());
        wMDownloadAppInfo.setAppDescUrl(downloadAppInfo.getDesc_url());
        wMDownloadAppInfo.setPermissionUrl(downloadAppInfo.getPermission_url());
        List<ApiBean.Permission> permissions_list_bean = downloadAppInfo.getPermissions_list_bean(getApplicationContext());
        if (permissions_list_bean != null && !permissions_list_bean.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (ApiBean.Permission permission : permissions_list_bean) {
                Permission permission2 = new Permission();
                permission2.setTitle(permission.getTitle());
                permission2.setDescription(permission.getDescription());
                permission2.setPermissionValue(permission.getPermissionValue());
                arrayList.add(permission2);
            }
            wMDownloadAppInfo.setPermissionList(arrayList);
        }
        wMDownloadAppInfo.setPrivacyUrl(downloadAppInfo.getPrivacy());
        wMDownloadAppInfo.setAppIconUrl(downloadAppInfo.getIcon_url());
        wMDownloadAppInfo.setAppSize(downloadAppInfo.getPacket_size());
        adBaseInfo.setDownloadAppInfo(wMDownloadAppInfo);
    }

    void appa(ApiBean apiBean) {
        try {
            if (apiBean.getOptimization() == null || apiBean.getOptimization().getAdCache() == null) {
                return;
            }
            setAdCacheTime(apiBean.getOptimization().getAdCache().getCacheTime() * 60 * 1000);
            setExpireTime(apiBean.getOptimization().getAdCache().getExpireTime());
            setCrid(apiBean.getOptimization().getAdCache().getCrid());
            setThirdSlotIdKey(apiBean.getOptimization().getAdCache().getThirdSlotIdKey());
            appa.appa.appf.appd.appa("ApiWMNativePotProcesser", "IPA.MW NativePot adCacheTime:" + getAdCacheTime(), "expireTime:" + getExpireTime(), "ThirdSlotIdKey:" + getThirdSlotIdKey());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMNativePotProcesser", "IPA.MW NativePot setAdCache error：" + th.toString());
        }
    }

    void appa(boolean z10, boolean z11, int i10) {
        try {
            appa.appa.appf.appd.appe("ApiWMNativePotProcesser", "NativePot doClick:", Thread.currentThread().getName(), Integer.valueOf(i10));
            this.appq = true;
            if (z11 && checkProcessorBean()) {
                try {
                    this.appi.getAdListener().onClick();
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe("ApiWMNativePotProcesser", "NativePot media onClick error:" + ((Object) th));
                    com.wangmai.ad.dex.allmodules.utils.appf.appa(getApplicationContext(), this.appi.getSlotId(), "NativePot media onClick error：" + Log.getStackTraceString(th));
                }
            }
            if (z10) {
                appa(i10);
            }
        } catch (Throwable th2) {
            appa.appa.appf.appd.appe("ApiWMNativePotProcesser", "NativePot doClick error:" + ((Object) th2));
            com.wangmai.ad.dex.allmodules.utils.appf.appa(getApplicationContext(), checkProcessorBean() ? this.appi.getSlotId() : "", "NativePot doClick error：" + Log.getStackTraceString(th2));
        }
    }

    private void appa(int i10) {
        try {
            try {
                com.wangmai.ad.dex.allmodules.utils.appf.appa(this.apph.getRespObj().getWxad().getClick_url(), (List<String>) null, i10, this.f46722appa, this.appb, this.appc, this.appd);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("ApiWMNativePotProcesser", "NativePot clickUpEventReport error:" + ((Object) th));
                com.wangmai.ad.dex.allmodules.utils.appf.appa(getApplicationContext(), checkProcessorBean() ? this.appi.getSlotId() : "", "NativePot clickUpEventReport error:" + Log.getStackTraceString(th));
            }
            appa(this.apph.getRespObj().getWxad().getDeep_link(), this.apph.getRespObj().getWxad().getLanding_page_url());
        } catch (Throwable th2) {
            appa.appa.appf.appd.appe("ApiWMNativePotProcesser", "NativePot openLinkAddress error:" + ((Object) th2));
            com.wangmai.ad.dex.allmodules.utils.appf.appa(getApplicationContext(), checkProcessorBean() ? this.appi.getSlotId() : "", "NativePot openLinkAddress error:" + Log.getStackTraceString(th2));
        }
    }

    private void appa(String str, String str2) {
        int i10;
        int i11;
        try {
            if (checkProcessorBean()) {
                i10 = this.appi.getDowlandDialogType();
                i11 = this.appi.getSdkInvokeFailRetry();
            } else {
                i10 = 1;
                i11 = 0;
            }
            com.wangmai.ad.dex.allmodules.utils.appf.appa("", false, str, str2, getApplicationContext(), this.f46722appa, this.appb, this.appc, this.appd, this.apph, i10, i11);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMNativePotProcesser", "NativePot clickLoadPage error:" + ((Object) th));
            com.wangmai.ad.dex.allmodules.utils.appf.appa(getApplicationContext(), checkProcessorBean() ? this.appi.getSlotId() : "", "NativePot clickLoadPage error:" + Log.getStackTraceString(th));
        }
    }

    void appa(ApiBean.Optimization optimization, View view) {
        try {
            if (checkProcessorBean() && optimization != null) {
                this.appm = new appu(getApplicationContext(), this.appi.getMediaAdSlotId(), optimization, true);
                this.appo = new appf(view);
                this.appm.appb(this.appo);
                this.appn = new appv(getApplicationContext(), this.appi.getMediaAdSlotId(), optimization, true);
                this.appp = new appg();
                this.appn.appa(getTaskTopActivity().get(), this.appp);
            } else {
                appa.appa.appf.appd.appe("ApiWMNativePotProcesser", "模电误点未开启【优化配置为空或广告已开启互动】");
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMNativePotProcesser", "doVirtualClick error:" + th.toString());
        }
    }
}
