package com.wangmai.ad.dex.allmodules.api.fullscreen;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wangmai.ad.dex.allmodules.R$id;
import com.wangmai.ad.dex.allmodules.R$layout;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.ad.dex.allmodules.utils.appy;
import com.wangmai.common.Ilistener.XAdFullScreenVideoListener;
import com.wangmai.common.utils.WMResources;
import com.wangmai.common.view.CustomWebView;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.callback.BitmapCallback;
import com.wangmai.okhttp.model.Response;
import java.util.List;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class WMFullSceenLadingViewGroup extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private int f46543a;

    /* renamed from: appa, reason: collision with root package name */
    private final ApiBean f46544appa;
    private int appb;
    private int appc;
    private TextView appd;
    private TextView appe;
    private ImageView appf;
    private ImageView appg;
    private ImageView apph;
    private ImageView appi;
    private ImageView appj;
    private String appk;
    private String appl;
    private String appm;
    private String appn;
    public float appo;
    public float appp;
    public float appq;
    public float appr;
    private XAdFullScreenVideoListener apps;
    private CustomWebView appt;
    private RelativeLayout appu;
    private RelativeLayout appv;
    private RelativeLayout appw;
    private LinearLayout appx;
    private View appy;
    private int appz;

    /* renamed from: b, reason: collision with root package name */
    private int f46545b;

    /* renamed from: c, reason: collision with root package name */
    private com.wangmai.ad.dex.allmodules.appf.appe f46546c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f46547d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f46548e;

    /* renamed from: f, reason: collision with root package name */
    private int f46549f;

    /* renamed from: g, reason: collision with root package name */
    private String f46550g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f46551h;

    /* renamed from: i, reason: collision with root package name */
    private Context f46552i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa implements DownloadListener {
        appa() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.wangmai.ad.dex.allmodules.utils.appf.appa(WMFullSceenLadingViewGroup.this.getContext(), str, str2, str3, str4, j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb implements View.OnTouchListener {
        appb() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            WMFullSceenLadingViewGroup.this.appo = motionEvent.getX();
            WMFullSceenLadingViewGroup.this.appp = motionEvent.getY();
            WMFullSceenLadingViewGroup.this.appq = motionEvent.getX();
            WMFullSceenLadingViewGroup.this.appr = motionEvent.getY();
            if (WMFullSceenLadingViewGroup.this.apps != null) {
                WMFullSceenLadingViewGroup.this.apps.onClick();
            }
            Log.d("FullScreenViewGroup", "CLICK5------");
            WMFullSceenLadingViewGroup.this.appa();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appc implements View.OnClickListener {
        appc() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int nextInt = new Random().nextInt(100) + 1;
            if (WMFullSceenLadingViewGroup.this.f46549f <= 0 || nextInt > WMFullSceenLadingViewGroup.this.f46549f) {
                if (WMFullSceenLadingViewGroup.this.apps != null) {
                    WMFullSceenLadingViewGroup.this.apps.onAdClose();
                }
                if (WMFullSceenLadingViewGroup.this.f46546c != null) {
                    WMFullSceenLadingViewGroup.this.f46546c.appa();
                    return;
                }
                return;
            }
            if (WMFullSceenLadingViewGroup.this.apps != null) {
                WMFullSceenLadingViewGroup.this.apps.onClick();
            }
            Log.d("FullScreenViewGroup", "CLICK6------");
            WMFullSceenLadingViewGroup.this.appa();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appd extends BitmapCallback {
        appd() {
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<Bitmap> response) {
            if (response != null) {
                WMFullSceenLadingViewGroup.this.appg.setImageBitmap(response.body());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appe extends BitmapCallback {
        appe() {
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<Bitmap> response) {
            if (response != null) {
                WMFullSceenLadingViewGroup.this.appf.setImageBitmap(response.body());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appf extends WebChromeClient {
        appf(WMFullSceenLadingViewGroup wMFullSceenLadingViewGroup) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appg implements View.OnTouchListener {
        appg() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            WMFullSceenLadingViewGroup.this.f46547d = true;
            WMFullSceenLadingViewGroup.this.f46548e = true;
            if (WMFullSceenLadingViewGroup.this.apps != null) {
                WMFullSceenLadingViewGroup.this.apps.onAdClose();
            }
            if (WMFullSceenLadingViewGroup.this.f46546c == null) {
                return false;
            }
            WMFullSceenLadingViewGroup.this.f46546c.appa();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class apph implements View.OnTouchListener {
        apph() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            WMFullSceenLadingViewGroup.this.f46547d = true;
            if (WMFullSceenLadingViewGroup.this.apps != null) {
                WMFullSceenLadingViewGroup.this.apps.onAdClose();
            }
            if (WMFullSceenLadingViewGroup.this.f46546c == null) {
                return false;
            }
            WMFullSceenLadingViewGroup.this.f46546c.appa();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appi implements View.OnTouchListener {
        appi() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            WMFullSceenLadingViewGroup.this.f46547d = true;
            if (WMFullSceenLadingViewGroup.this.f46548e) {
                return false;
            }
            WMFullSceenLadingViewGroup.this.appo = motionEvent.getX();
            WMFullSceenLadingViewGroup.this.appp = motionEvent.getY();
            WMFullSceenLadingViewGroup.this.appq = motionEvent.getX();
            WMFullSceenLadingViewGroup.this.appr = motionEvent.getY();
            if (WMFullSceenLadingViewGroup.this.apps != null) {
                WMFullSceenLadingViewGroup.this.apps.onClick();
            }
            Log.d("FullScreenViewGroup", "CLICK1------");
            if (WMFullSceenLadingViewGroup.this.f46546c != null) {
                WMFullSceenLadingViewGroup.this.f46546c.appa();
            }
            WMFullSceenLadingViewGroup.this.appa();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appj implements View.OnTouchListener {
        appj() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || WMFullSceenLadingViewGroup.this.f46547d) {
                return false;
            }
            if (WMFullSceenLadingViewGroup.this.apps != null) {
                WMFullSceenLadingViewGroup.this.apps.onClick();
            }
            Log.d("FullScreenViewGroup", "CLICK2------");
            if (TextUtils.isEmpty(WMFullSceenLadingViewGroup.this.f46544appa.getRespObj().getWxad().getLanding_page_url())) {
                return false;
            }
            if (TextUtils.isEmpty(WMFullSceenLadingViewGroup.this.f46544appa.getRespObj().getWxad().getDeep_link())) {
                WMFullSceenLadingViewGroup wMFullSceenLadingViewGroup = WMFullSceenLadingViewGroup.this;
                wMFullSceenLadingViewGroup.appa("", wMFullSceenLadingViewGroup.f46544appa.getRespObj().getWxad().getLanding_page_url());
                return false;
            }
            WMFullSceenLadingViewGroup wMFullSceenLadingViewGroup2 = WMFullSceenLadingViewGroup.this;
            wMFullSceenLadingViewGroup2.appa(wMFullSceenLadingViewGroup2.f46544appa.getRespObj().getWxad().getDeep_link(), WMFullSceenLadingViewGroup.this.f46544appa.getRespObj().getWxad().getLanding_page_url());
            return false;
        }
    }

    public WMFullSceenLadingViewGroup(Context context, String str, String str2, String str3, String str4, String str5, ApiBean apiBean, XAdFullScreenVideoListener xAdFullScreenVideoListener, int i10, int i11, int i12, com.wangmai.ad.dex.allmodules.appf.appe appeVar, boolean z10) {
        super(context);
        this.appo = -999.0f;
        this.appp = -999.0f;
        this.appq = -999.0f;
        this.appr = -999.0f;
        this.f46552i = context;
        this.appk = str;
        this.appl = str2;
        this.appm = str3;
        this.appn = str4;
        this.f46544appa = apiBean;
        this.appb = i11;
        this.appc = i12;
        this.apps = xAdFullScreenVideoListener;
        this.f46549f = i10;
        this.f46546c = appeVar;
        this.f46551h = z10;
        appb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (z10) {
            int i14 = 0;
            for (int i15 = 0; i15 < this.appz; i15++) {
                getChildAt(i15).layout(i14, 0, this.f46545b + i14, this.f46543a);
                i14 += this.f46545b;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.appz = getChildCount();
        if (this.appz == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        measureChildren(i10, i11);
        View childAt = getChildAt(0);
        this.f46543a = childAt.getMeasuredHeight();
        this.f46545b = childAt.getMeasuredWidth();
        setMeasuredDimension(this.f46545b * this.appz, this.f46543a);
    }

    private void appc() {
        try {
            this.appt.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.appt.getSettings().setUseWideViewPort(true);
            this.appt.getSettings().setDisplayZoomControls(false);
            this.appt.getSettings().setJavaScriptEnabled(true);
            this.appt.getSettings().setAllowFileAccess(true);
            this.appt.getSettings().setBuiltInZoomControls(true);
            this.appt.getSettings().setSupportZoom(true);
            this.appt.getSettings().setLoadWithOverviewMode(true);
            this.appt.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            this.appt.getSettings().setBlockNetworkImage(false);
            this.appt.getSettings().setDefaultTextEncodingName("UTF-8");
            this.appt.setWebChromeClient(new appf(this));
            this.appt.getSettings().setCacheMode(2);
            this.appt.setHorizontalScrollBarEnabled(false);
            this.appt.setVerticalScrollBarEnabled(false);
            this.appt.getSettings().setDomStorageEnabled(false);
            if (Build.VERSION.SDK_INT >= 21) {
                this.appt.getSettings().setMixedContentMode(0);
            }
            int i10 = new DisplayMetrics().densityDpi;
            if (i10 == 240) {
                this.appt.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
            } else if (i10 == 160) {
                this.appt.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
            } else if (i10 == 120) {
                this.appt.getSettings().setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
            } else if (i10 == 320) {
                this.appt.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
            } else if (i10 == 213) {
                this.appt.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
            } else {
                this.appt.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
            }
            this.appj.setOnTouchListener(new appg());
            this.appi.setOnTouchListener(new apph());
            this.appw.setOnTouchListener(new appi());
            this.appt.setOnTouchListener(new appj());
            this.appt.setWebViewClient(new appy(getContext(), "FullScreenViewGroup"));
            this.appt.setDownloadListener(new appa());
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("FullScreenViewGroup", "Api fullScreen init webview:" + th.toString());
        }
    }

    private void appd() {
        appa.appa.appf.appd.appa("FullScreenViewGroup", "htmlData---------- " + this.appk);
        if (this.appk.startsWith("<html>")) {
            this.appt.loadDataWithBaseURL(null, this.appk, "text/html", "utf-8", null);
            return;
        }
        String str = "<html><head><style>* body{font-size:15px;margin:0;padding:0}{color:#212121;}img{max-width: 100%; width:auto; height: auto;}</style></head><body>" + this.appk + "</body></html>";
        this.appt.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
        appa.appa.appf.appd.appa("FullScreenViewGroup", "resultStr---------- " + str);
    }

    private void appe() {
        this.appd.setText(this.appn);
        this.appe.setText(this.appm);
        if (!TextUtils.isEmpty(this.appl)) {
            OkHttp.get(this.appl).execute(new appd());
        }
        if (!TextUtils.isEmpty(this.appk)) {
            OkHttp.get(this.appk).execute(new appe());
        }
        appa(this.f46544appa.getRespObj().getWxad().getWin_notice_url());
    }

    private void appf() {
        appd();
    }

    private void appg() {
        appe();
        this.appx.setOnTouchListener(new appb());
        this.apph.setOnClickListener(new appc());
    }

    private void appb() {
        this.appy = LayoutInflater.from(appa.appa.appf.appa.appa(this.f46552i, WMResources.resources)).inflate(R$layout.wm_reward_lading_layout, (ViewGroup) this, false);
        this.appx = (LinearLayout) this.appy.findViewById(R$id.wm_layout_main);
        this.appu = (RelativeLayout) this.appy.findViewById(R$id.wm_layout_landing);
        this.appd = (TextView) this.appy.findViewById(R$id.wm_tv_title);
        this.appe = (TextView) this.appy.findViewById(R$id.wm_text_esc);
        this.appg = (ImageView) this.appy.findViewById(R$id.wm_image_icon);
        this.apph = (ImageView) this.appy.findViewById(R$id.wm_image_clear);
        this.appf = (ImageView) this.appy.findViewById(1879179309);
        this.appv = (RelativeLayout) this.appy.findViewById(R$id.wm_layout_webview);
        this.appt = (CustomWebView) this.appy.findViewById(R$id.wm_webview);
        this.appi = (ImageView) this.appy.findViewById(R$id.wm_image_web_clear);
        this.appw = (RelativeLayout) this.appy.findViewById(R$id.wm_webview_bg);
        this.appj = (ImageView) this.appy.findViewById(R$id.wm_image_web_clear_bg);
        addView(this.appy);
        invalidate();
        try {
            if (TextUtils.isEmpty(this.appk)) {
                return;
            }
            if (this.appk.startsWith("http")) {
                this.appv.setVisibility(8);
                this.appt.setVisibility(8);
                this.appi.setVisibility(8);
                this.appu.setVisibility(0);
                appg();
                return;
            }
            appa.appa.appf.appd.appa("FullScreenViewGroup", this.appk);
            appa(this.f46544appa.getRespObj().getWxad().getWin_notice_url());
            appc();
            this.appv.setVisibility(0);
            this.appt.setVisibility(0);
            this.appi.setVisibility(0);
            this.appu.setVisibility(8);
            if (!TextUtils.isEmpty(this.f46544appa.getRespObj().getWxad().getLanding_page_url())) {
                appa.appa.appf.appd.appa("FullScreenViewGroup", "clickPage------" + this.f46544appa.getRespObj().getWxad().getLanding_page_url());
                this.appw.setVisibility(0);
                this.appi.setVisibility(8);
            } else {
                appa.appa.appf.appd.appa("FullScreenViewGroup", "clickPage------");
                this.appw.setVisibility(8);
                this.appi.setVisibility(8);
            }
            appf();
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("FullScreenViewGroup", "Api fullScreen init exception2:" + th.toString());
            XAdFullScreenVideoListener xAdFullScreenVideoListener = this.apps;
            if (xAdFullScreenVideoListener != null) {
                xAdFullScreenVideoListener.onNoAd("全屏广告初始化失败:" + th.getMessage());
            }
        }
    }

    private void appa(List<String> list) {
        if (this.f46551h) {
            return;
        }
        com.wangmai.ad.dex.allmodules.utils.appf.appa(this.f46544appa.getRespObj().getWxad().getWin_notice_url(), 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appa() {
        if (!this.f46551h) {
            com.wangmai.ad.dex.allmodules.utils.appf.appa(this.f46544appa.getRespObj().getWxad().getClick_url(), this.f46544appa.getRespObj().getWxad().getDp_try_track_urls(), com.wangmai.ad.dex.allmodules.utils.appf.appl, this.appo, this.appp, this.appq, this.appr);
        }
        if (TextUtils.isEmpty(this.f46544appa.getRespObj().getWxad().getLanding_page_url())) {
            return;
        }
        if (TextUtils.isEmpty(this.f46544appa.getRespObj().getWxad().getDeep_link())) {
            appa("", this.f46544appa.getRespObj().getWxad().getLanding_page_url());
        } else {
            appa(this.f46544appa.getRespObj().getWxad().getDeep_link(), this.f46544appa.getRespObj().getWxad().getLanding_page_url());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appa(String str, String str2) {
        try {
            com.wangmai.ad.dex.allmodules.utils.appf.appa(this.f46550g, false, str, str2, this.f46552i, this.appo, this.appp, this.appq, this.appr, this.f46544appa, this.appb, this.appc);
        } catch (Throwable th) {
            com.wangmai.ad.dex.allmodules.utils.appf.appa(this.f46552i, "", th.toString());
        }
    }
}
