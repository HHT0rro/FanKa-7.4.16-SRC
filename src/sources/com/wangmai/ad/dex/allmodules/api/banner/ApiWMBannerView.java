package com.wangmai.ad.dex.allmodules.api.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wangmai.ad.dex.allmodules.R$id;
import com.wangmai.ad.dex.allmodules.R$layout;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.ad.dex.allmodules.utils.appy;
import com.wangmai.appsdkdex.utils.VisibilityUtils;
import com.wangmai.common.runnable.HasTypeRunnable;
import com.wangmai.common.utils.ConstantInfo;
import com.wangmai.common.utils.SharedPreferencesHelper;
import com.wangmai.common.utils.Utils;
import com.wangmai.common.utils.WMResources;
import com.wangmai.common.view.CustomWebView;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.callback.BitmapCallback;
import com.wangmai.okhttp.callback.StringCallback;
import com.wangmai.okhttp.model.Response;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class ApiWMBannerView extends ViewGroup implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private int f46478a;

    /* renamed from: appa, reason: collision with root package name */
    private final appa.appa.appd.appa f46479appa;
    private int appb;
    private int appc;
    public float appd;
    public float appe;
    public float appf;
    public float appg;
    private int apph;
    private int appi;
    private int appj;
    private String appk;
    private ViewGroup appl;
    private int appm;
    private List<String> appn;
    private RelativeLayout appo;
    private ImageView appp;
    private CustomWebView appq;
    private String appr;
    private String apps;
    private ApiBean appt;
    private int appu;
    private int appv;
    private int appw;
    private long appx;
    private List<String> appy;
    private String appz;

    /* renamed from: b, reason: collision with root package name */
    String f46480b;

    /* renamed from: c, reason: collision with root package name */
    boolean f46481c;

    /* renamed from: d, reason: collision with root package name */
    private Context f46482d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa implements VisibilityUtils.ViewVisibilityChangeListener {
        appa() {
        }

        @Override // com.wangmai.appsdkdex.utils.VisibilityUtils.ViewVisibilityChangeListener
        public void invisible() {
        }

        @Override // com.wangmai.appsdkdex.utils.VisibilityUtils.ViewVisibilityChangeListener
        public void visible() {
            ApiWMBannerView apiWMBannerView = ApiWMBannerView.this;
            if (!apiWMBannerView.f46481c) {
                apiWMBannerView.f46481c = true;
                appa.appa.appf.appd.appa("ApiWMBannerView", "ApiWMBannerView检测到可见，回调曝光事件");
                if (ApiWMBannerView.this.f46479appa != null) {
                    appa.appa.appf.appd.appa("ApiWMBannerView", "Api Banner onExposure");
                    ApiWMBannerView.this.f46479appa.onExposure();
                    ApiWMBannerView.this.f46479appa.appa();
                    if (ApiWMBannerView.this.appn.isEmpty()) {
                        return;
                    }
                    ApiWMBannerView apiWMBannerView2 = ApiWMBannerView.this;
                    apiWMBannerView2.appa((List<String>) apiWMBannerView2.appn);
                    return;
                }
                return;
            }
            appa.appa.appf.appd.appa("ApiWMBannerView", "ApiWMBannerView检测到可见，已处理曝光回调");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb implements HasTypeRunnable<ApiBean> {
        appb() {
        }

        @Override // com.wangmai.common.runnable.HasTypeRunnable
        /* renamed from: appa, reason: merged with bridge method [inline-methods] */
        public void run(ApiBean apiBean) {
            try {
                if (apiBean == null) {
                    appa.appa.appf.appd.appb("ApiWMBannerView", "Api Banner 广告获取失败");
                    if (ApiWMBannerView.this.f46479appa != null) {
                        ApiWMBannerView.this.f46479appa.onNoAd("广告获取失败");
                        return;
                    }
                    return;
                }
                ApiWMBannerView.this.appa(apiBean);
            } catch (Throwable th) {
                th.printStackTrace();
                appa.appa.appf.appd.appb("ApiWMBannerView", "Api Banner 广告获取失败");
                if (ApiWMBannerView.this.f46479appa != null) {
                    ApiWMBannerView.this.f46479appa.onNoAd("广告获取失败");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appc extends BitmapCallback {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ ApiBean f46485appa;
        final /* synthetic */ String[] appb;

        appc(ApiBean apiBean, String[] strArr) {
            this.f46485appa = apiBean;
            this.appb = strArr;
        }

        @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
        public void onError(Response<Bitmap> response) {
            appa.appa.appf.appd.appb("ApiWMBannerView", "Api Banner load image onError :" + this.appb[0] + "," + response.getException().toString());
            if (ApiWMBannerView.this.f46479appa != null) {
                ApiWMBannerView.this.f46479appa.onNoAd("onError:" + response.getException().toString());
            }
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<Bitmap> response) {
            if (ApiWMBannerView.this.f46479appa == null) {
                return;
            }
            ApiWMBannerView.this.appa(response.body());
            ApiWMBannerView.this.appb(this.f46485appa);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appd implements DownloadListener {
        appd() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
            if (ApiWMBannerView.this.f46482d == null || TextUtils.isEmpty(str)) {
                return;
            }
            com.wangmai.ad.dex.allmodules.utils.appf.appa(ApiWMBannerView.this.f46482d, str, str2, str3, str4, j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appe extends appy {
        appe(Context context, String str) {
            super(context, str);
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appy
        public boolean appa(WebView webView, String str) {
            com.wangmai.ad.dex.allmodules.utils.appf.appc(ApiWMBannerView.this.getContext(), str);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appf extends StringCallback {
        appf(ApiWMBannerView apiWMBannerView) {
        }

        @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
        public void onError(Response<String> response) {
            super.onError(response);
            appa.appa.appf.appd.appe("ApiWMBannerView", "Api Banner 展示上报失败:" + response.getException().toString());
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<String> response) {
            appa.appa.appf.appd.appa("ApiWMBannerView", "Api Banner 展示上报成功");
        }
    }

    public ApiWMBannerView(Context context, String str, ViewGroup viewGroup, String str2, int i10, int i11, int i12, appa.appa.appd.appa appaVar) {
        super(context);
        this.appd = -999.0f;
        this.appe = -999.0f;
        this.appf = -999.0f;
        this.appg = -999.0f;
        this.f46481c = false;
        this.f46482d = context;
        this.appk = str;
        this.appl = viewGroup;
        this.appr = str2;
        this.f46479appa = appaVar;
        this.appb = i11;
        this.appc = i12;
        appb();
        appc();
    }

    public int getAdCacheTime() {
        return this.appw;
    }

    public long getAdExpireTime() {
        return this.appx;
    }

    public String getCrid() {
        return this.appz;
    }

    public int getDspBidPrice() {
        return this.appu;
    }

    public List<String> getInvalidCrids() {
        return this.appy;
    }

    public int getMediaBidPrice() {
        return this.appv;
    }

    public int getThirdSlotIdKey() {
        return this.f46478a;
    }

    public String getWinReportUrl() {
        return this.f46480b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (z10) {
            int i14 = 0;
            for (int i15 = 0; i15 < this.apph; i15++) {
                try {
                    getChildAt(i15).layout(i14, 0, this.appj + i14, this.appi);
                    i14 += this.appj;
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe("ApiWMBannerView", "onLayout:" + th.toString());
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        try {
            this.apph = getChildCount();
            if (this.apph == 0) {
                setMeasuredDimension(0, 0);
            } else {
                measureChildren(i10, i11);
                View childAt = getChildAt(0);
                this.appi = childAt.getMeasuredHeight();
                this.appj = childAt.getMeasuredWidth();
                setMeasuredDimension(this.appj * this.apph, this.appi);
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMBannerView", "onMeasure:" + th.toString());
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00f4 -> B:13:0x0101). Please report as a decompilation issue!!! */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.appd = motionEvent.getX();
            this.appe = motionEvent.getY();
            this.appf = motionEvent.getX();
            this.appg = motionEvent.getY();
            ConstantInfo.downX = this.appd;
            ConstantInfo.downY = this.appe;
            appa.appa.appf.appd.appa("ApiWMBannerView", "Api 横幅广告点击", Double.valueOf(ConstantInfo.downX), Double.valueOf(ConstantInfo.downY));
            appa.appa.appd.appa appaVar = this.f46479appa;
            if (appaVar != null) {
                appaVar.onClick();
            }
            try {
                appa.appa.appf.appd.appa("ApiWMBannerView", " Api Banner checkUpClickView--" + this.appt.getRespObj().getWxad().getLanding_page_url());
                com.wangmai.ad.dex.allmodules.utils.appf.appa(this.appt.getRespObj().getWxad().getClick_url(), (List<String>) null, com.wangmai.ad.dex.allmodules.utils.appf.appl, this.appd, this.appe, this.appf, this.appg);
                if (!TextUtils.isEmpty(this.appt.getRespObj().getWxad().getLanding_page_url())) {
                    if (TextUtils.isEmpty(this.appt.getRespObj().getWxad().getDeep_link())) {
                        appa("", this.appt.getRespObj().getWxad().getLanding_page_url());
                    } else {
                        appa(this.appt.getRespObj().getWxad().getDeep_link(), this.appt.getRespObj().getWxad().getLanding_page_url());
                    }
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("ApiWMBannerView", th.toString());
            }
        }
        return !TextUtils.isEmpty(this.appt.getRespObj().getWxad().getLanding_page_url());
    }

    void setAdCacheInfo(ApiBean apiBean) {
        try {
            if (apiBean.getOptimization() == null || apiBean.getOptimization().getAdCache() == null) {
                return;
            }
            setAdCacheTime(apiBean.getOptimization().getAdCache().getCacheTime() * 60 * 1000);
            setAdExpireTime(apiBean.getOptimization().getAdCache().getExpireTime());
            setCrid(apiBean.getOptimization().getAdCache().getCrid());
            setThirdSlotIdKey(apiBean.getOptimization().getAdCache().getThirdSlotIdKey());
            appa.appa.appf.appd.appa("ApiWMBannerView", "IPA.MW Banner adCacheTime:" + getAdCacheTime(), "expireTime:" + getAdExpireTime(), "ThirdSlotIdKey:" + getThirdSlotIdKey());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMBannerView", "IPA.MW Banner setAdCache exception" + th.toString());
        }
    }

    public void setAdCacheTime(int i10) {
        this.appw = i10;
    }

    public void setAdExpireTime(long j10) {
        this.appx = j10;
    }

    public void setCrid(String str) {
        this.appz = str;
    }

    void setDspAndMediaPrice(ApiBean apiBean) {
        try {
            appa.appa.appf.appd.appa("ApiWMBannerView", "IPA.MW Banner DspBidPrice:" + apiBean.getAdPrice().getDspBidPrice(), "MediaBidPrice:" + apiBean.getAdPrice().getMediaBidPrice());
            setDspBidPrice((int) Math.round(apiBean.getAdPrice().getDspBidPrice() * 100.0d));
            setMediaBidPrice((int) Math.round(apiBean.getAdPrice().getMediaBidPrice() * 100.0d));
            appa.appa.appf.appd.appa("ApiWMBannerView", "IPA.MW Banner DspBidPrice:" + getDspBidPrice(), "MediaBidPrice:" + getMediaBidPrice());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMBannerView", "IPA.MW Banner setDspAndMediaPrice exception" + th.toString());
        }
    }

    public void setDspBidPrice(int i10) {
        this.appu = i10;
    }

    public void setInvalidCrids(List<String> list) {
        this.appy = list;
    }

    public void setMediaBidPrice(int i10) {
        this.appv = i10;
    }

    public void setThirdSlotIdKey(int i10) {
        this.f46478a = i10;
    }

    public void setWinReportUrl(String str) {
        this.f46480b = str;
    }

    private void appc() {
        appa.appa.appf.appd.appa("ApiWMBannerView", "Api Banner requestId:" + this.appr, "slotId:" + this.appk);
        com.wangmai.ad.dex.allmodules.appc.appb.appa(this.f46482d, "ApiWMBannerView", this.appk, this.appr, new appb());
    }

    private void appb() {
        View inflate = LayoutInflater.from(appa.appa.appf.appa.appa(this.f46482d, WMResources.resources)).inflate(R$layout.wm_bad, (ViewGroup) null);
        this.appo = (RelativeLayout) inflate.findViewById(R$id.wm_bad_all);
        this.appp = (ImageView) inflate.findViewById(R$id.wm_bad_main);
        this.appq = (CustomWebView) inflate.findViewById(R$id.wm_bad_web);
        setOnTouchListener(this);
        VisibilityUtils.getInstance().addVisibleChangedListener(this, new appa());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appa(ApiBean apiBean) {
        try {
            ApiBean.RespObj respObj = apiBean.getRespObj();
            ApiBean.WxadBean wxad = respObj.getWxad();
            appa.appa.appf.appd.appa("ApiWMBannerView", "APi Banner response errorCode:" + respObj.getError_code() + "，requestId：" + respObj.getRequest_id());
            if (respObj.getError_code() == 0 && wxad != null) {
                setWinReportUrl(respObj.getNurl());
                setDspAndMediaPrice(apiBean);
                setAdCacheInfo(apiBean);
                setInvalidCrids(apiBean.getInvalidCridList());
                this.appm = wxad.getCreative_type();
                this.appn = wxad.getWin_notice_url();
                int i10 = this.appm;
                if (i10 != 2 && i10 != 3) {
                    if (i10 != 5) {
                        appa.appa.appf.appd.appe("ApiWMBannerView", "暂未支持该类型广告样式:" + this.appm);
                        return;
                    }
                    appb(apiBean);
                    appa(wxad.getDescription());
                    appa((Bitmap) null);
                    return;
                }
                String image_src = wxad.getImage_src();
                if (TextUtils.isEmpty(image_src)) {
                    appa.appa.appf.appd.appb("ApiWMBannerView", "Api Banner image src is null");
                    if (this.f46479appa != null) {
                        this.f46479appa.onNoAd("image src is null");
                        return;
                    }
                    return;
                }
                String[] split = image_src.split(";");
                appa.appa.appf.appd.appa("ApiWMBannerView", "Api Banner image:" + split[0]);
                OkHttp.get(split[0]).execute(new appc(apiBean, split));
                return;
            }
            appa.appa.appf.appd.appb("ApiWMBannerView", "Api Banner 广告请求失败:" + respObj.getError_code());
            setInvalidCrids(apiBean.getInvalidCridList());
            if (this.f46479appa != null) {
                this.f46479appa.onNoAd("广告请求失败:" + respObj.getError_code());
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("ApiWMBannerView", "Api Banner 广告加载失败:" + th.getMessage());
            appa.appa.appd.appa appaVar = this.f46479appa;
            if (appaVar != null) {
                appaVar.onNoAd("广告加载失败:" + th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appb(ApiBean apiBean) {
        try {
            this.appt = apiBean;
            appa.appa.appf.appd.appa("ApiWMBannerView", "安装链接:" + apiBean.getRespObj().getWxad().getInstalled_track_urls().size() + "    " + apiBean.getRespObj().getWxad().getApp_package());
            if (apiBean.getRespObj().getWxad().getApp_package() == null || apiBean.getRespObj().getWxad().getInstalled_track_urls() == null || apiBean.getRespObj().getWxad().getInstalled_track_urls().size() <= 0) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("installed_track_urls_size", Integer.valueOf(apiBean.getRespObj().getWxad().getInstalled_track_urls().size()));
            for (int i10 = 0; i10 < apiBean.getRespObj().getWxad().getInstalled_track_urls().size(); i10++) {
                hashMap.put("installed_track_urls" + i10, apiBean.getRespObj().getWxad().getInstalled_track_urls().get(i10));
            }
            hashMap.put("brand_name", apiBean.getRespObj().getWxad().getApp_package());
            SharedPreferencesHelper.getInstance(this.f46482d).savePreferencesMap(hashMap);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMBannerView", "APi Banner loadUrl:" + th.toString());
        }
    }

    private void appa(String str) {
        try {
            WebSettings settings = this.appq.getSettings();
            settings.setLoadsImagesAutomatically(true);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            this.appq.setHorizontalScrollBarEnabled(false);
            this.appq.setVerticalScrollBarEnabled(false);
            this.appq.getSettings().setLoadWithOverviewMode(true);
            try {
                appa.appa.appf.appd.appa("ApiWMBannerView", "htmlData---------- " + str + "---");
                if (str.startsWith("<html>")) {
                    this.appq.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
                } else {
                    String str2 = "<html><head><style>* body{font-size:15px;margin:0;padding:0;}{color:#212121;}img{max-height: 100%;max-width: 100%; width:auto; height: auto;}</style></head><body>" + str + "</body></html>";
                    this.appq.loadDataWithBaseURL(null, str2, "text/html", "utf-8", null);
                    appa.appa.appf.appd.appa("ApiWMBannerView", "resultStr---------- " + str2);
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appb("ApiWMBannerView", "Api Banner render html:" + th);
            }
            if (!TextUtils.isEmpty(this.appt.getRespObj().getWxad().getLanding_page_url())) {
                appa.appa.appf.appd.appa("ApiWMBannerView", " viewParent-webviewss");
                RelativeLayout relativeLayout = new RelativeLayout(this.f46482d);
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                relativeLayout.setGravity(17);
                this.appo.addView(relativeLayout, 2);
                invalidate();
                requestLayout();
                relativeLayout.setOnTouchListener(this);
                return;
            }
            this.appq.setDownloadListener(new appd());
            this.appq.setWebViewClient(new appe(getContext(), "ApiWMBannerView"));
            this.appq.setOnTouchListener(this);
        } catch (Throwable th2) {
            appa.appa.appf.appd.appb("ApiWMBannerView", "Api Banner render html:" + th2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appa(Bitmap bitmap) {
        try {
            int windowWidth = Utils.getWindowWidth(this.f46482d);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(windowWidth, (windowWidth * 10) / 64);
            removeAllViewsInLayout();
            invalidate();
            com.wangmai.ad.dex.allmodules.utils.appf.appe = layoutParams.height;
            this.appo.setLayoutParams(layoutParams);
            if (bitmap == null) {
                this.appp.setVisibility(8);
                this.appq.setVisibility(0);
            } else {
                this.appp.setImageBitmap(bitmap);
                this.appp.setVisibility(0);
                this.appq.setVisibility(8);
            }
            if (this.f46479appa != null) {
                addView(this.appo);
                this.appl.addView(this);
                this.f46479appa.onRenderSuccess(this.appl, 0, 0);
                this.f46479appa.onAdRequest();
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("ApiWMBannerView", "Api Banner 广告加载失败:" + th.toString());
            appa.appa.appd.appa appaVar = this.f46479appa;
            if (appaVar != null) {
                appaVar.onNoAd("广告加载失败");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appa(List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (int i10 = 0; i10 < list.size(); i10++) {
                        appa.appa.appf.appd.appa("ApiWMBannerView", "Api Banner 展示上报：" + list.get(i10));
                        OkHttp.get(list.get(i10)).execute(new appf(this));
                    }
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("ApiWMBannerView", "Api Banner 展示上报失败：" + th.toString());
            }
        }
    }

    private void appa(String str, String str2) {
        try {
            com.wangmai.ad.dex.allmodules.utils.appf.appa(this.apps, false, str, str2, this.f46482d, this.appd, this.appe, this.appf, this.appg, this.appt, this.appb, this.appc);
        } catch (Throwable th) {
            com.wangmai.ad.dex.allmodules.utils.appf.appa(this.f46482d, this.appk, th.toString());
        }
    }

    public void appa() {
        appa.appa.appf.appd.appa("ApiWMBannerView", "IPA.MW Banner destroy");
        appa.appa.appd.appa appaVar = this.f46479appa;
        if (appaVar == null || !this.f46481c) {
            return;
        }
        appaVar.onAdClose();
    }
}
