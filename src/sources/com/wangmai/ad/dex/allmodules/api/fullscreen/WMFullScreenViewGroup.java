package com.wangmai.ad.dex.allmodules.api.fullscreen;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.wangmai.ad.dex.allmodules.R$id;
import com.wangmai.ad.dex.allmodules.R$layout;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.ad.dex.allmodules.bean.ProgressTrackingBean;
import com.wangmai.ad.dex.allmodules.utils.appx;
import com.wangmai.common.Ilistener.XAdFullScreenVideoListener;
import com.wangmai.common.WMAdActListener;
import com.wangmai.common.runnable.HasTypeRunnable;
import com.wangmai.common.utils.WMResources;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.callback.BitmapCallback;
import com.wangmai.okhttp.model.Response;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class WMFullScreenViewGroup extends ViewGroup implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, WMAdActListener, com.wangmai.ad.dex.allmodules.appf.appa {

    /* renamed from: q, reason: collision with root package name */
    private static int f46562q;

    /* renamed from: r, reason: collision with root package name */
    private static List<ProgressTrackingBean> f46563r;

    /* renamed from: a, reason: collision with root package name */
    private ImageView f46564a;

    /* renamed from: appa, reason: collision with root package name */
    private int f46565appa;
    private int appb;
    public float appc;
    public float appd;
    public float appe;
    public float appf;
    private String appg;
    private String apph;
    private com.wangmai.ad.dex.allmodules.appf.appc appi;
    private int appj;
    private int appk;
    private int appl;
    private View appm;
    private int appn;
    private VideoView appo;
    private TextView appp;
    private TextView appq;
    private TextView appr;
    private String apps;
    private String appt;
    private String appu;
    private String appv;
    private String appw;
    private boolean appx;
    private ProgressBar appy;
    private RelativeLayout appz;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f46566b;

    /* renamed from: c, reason: collision with root package name */
    private int f46567c;

    /* renamed from: d, reason: collision with root package name */
    private ProgressBar f46568d;

    /* renamed from: e, reason: collision with root package name */
    private int f46569e;

    /* renamed from: f, reason: collision with root package name */
    private int f46570f;

    /* renamed from: g, reason: collision with root package name */
    private com.wangmai.ad.dex.allmodules.utils.appb f46571g;

    /* renamed from: h, reason: collision with root package name */
    private int f46572h;

    /* renamed from: i, reason: collision with root package name */
    private int f46573i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f46574j;

    /* renamed from: k, reason: collision with root package name */
    private ApiBean f46575k;

    /* renamed from: l, reason: collision with root package name */
    private int f46576l;

    /* renamed from: m, reason: collision with root package name */
    private int f46577m;

    /* renamed from: n, reason: collision with root package name */
    private final Context f46578n;

    /* renamed from: o, reason: collision with root package name */
    private Runnable f46579o;

    /* renamed from: p, reason: collision with root package name */
    private Handler f46580p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa implements Runnable {
        appa() {
        }

        @Override // java.lang.Runnable
        public void run() {
            appa.appa.appf.appd.appa("WMFullScreenViewGroup", "Api fullScreen isClickReport Handler");
            WMFullScreenViewGroup.this.f46566b.setVisibility(0);
            WMFullScreenViewGroup.this.requestLayout();
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
            if (apiBean == null) {
                appa.appa.appf.appd.appb("WMFullScreenViewGroup", "Api fullScreen 广告获取失败");
                WMFullScreenViewGroup.this.appi.appa("广告获取失败");
                WMFullScreenViewGroup.this.appe();
                return;
            }
            ApiBean.RespObj respObj = apiBean.getRespObj();
            if (respObj.getError_code() == 0) {
                ApiBean.WxadBean wxad = respObj.getWxad();
                if (wxad != null && wxad.getVideo() != null) {
                    if (apiBean.getOptimization() != null && apiBean.getOptimization().getReportObject() != null) {
                        WMFullScreenViewGroup.this.f46569e = apiBean.getOptimization().getReportObject().getShrand();
                        WMFullScreenViewGroup.this.f46570f = apiBean.getOptimization().getReportObject().getShcrandom();
                    }
                    try {
                        WMFullScreenViewGroup.this.appb(wxad.getVideo().getV_url());
                        WMFullScreenViewGroup.this.f46572h = wxad.getVideo().getOrientation();
                    } catch (Throwable th) {
                        appa.appa.appf.appd.appe("WMFullScreenViewGroup", "Api fullScreen response exception:" + th.toString());
                    }
                    appa.appa.appf.appd.appa("WMFullScreenViewGroup", "IPA.MW fullScreen DspBidPrice:" + apiBean.getAdPrice().getDspBidPrice(), "MediaBidPrice:" + apiBean.getAdPrice().getMediaBidPrice());
                    WMFullScreenViewGroup.this.setDspBidPrice((int) Math.round(apiBean.getAdPrice().getDspBidPrice() * 100.0d));
                    WMFullScreenViewGroup.this.setMediaBidPrice((int) Math.round(apiBean.getAdPrice().getMediaBidPrice() * 100.0d));
                    appa.appa.appf.appd.appa("WMFullScreenViewGroup", "IPA.MW fullScreen DspBidPrice:" + WMFullScreenViewGroup.this.getDspBidPrice(), "MediaBidPrice:" + WMFullScreenViewGroup.this.getMediaBidPrice());
                    WMFullScreenViewGroup.this.appa(apiBean);
                    return;
                }
                appa.appa.appf.appd.appb("WMFullScreenViewGroup", "Api fullScreen video is null");
                WMFullScreenViewGroup.this.appi.appa("广告物料无效");
                WMFullScreenViewGroup.this.appe();
                return;
            }
            appa.appa.appf.appd.appb("WMFullScreenViewGroup", "Api fullScreen 广告请求失败：" + respObj.getError_code());
            WMFullScreenViewGroup.this.appi.appa("广告请求失败：" + respObj.getError_code());
            WMFullScreenViewGroup.this.appe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appc extends BitmapCallback {
        appc() {
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<Bitmap> response) {
            if (response != null) {
                WMFullScreenViewGroup.this.f46564a.setImageBitmap(response.body());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appd implements View.OnTouchListener {
        appd() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                appa.appa.appf.appd.appa("WMFullScreenViewGroup", "Api fullScreen isClickReport  layout ");
                if (WMFullScreenViewGroup.this.appo != null && WMFullScreenViewGroup.this.appo.isPlaying()) {
                    WMFullScreenViewGroup wMFullScreenViewGroup = WMFullScreenViewGroup.this;
                    wMFullScreenViewGroup.f46567c = wMFullScreenViewGroup.appo.getCurrentPosition();
                    if (!TextUtils.isEmpty(WMFullScreenViewGroup.this.appw) && !WMFullScreenViewGroup.this.appw.endsWith("apk")) {
                        WMFullScreenViewGroup.this.appo.pause();
                    }
                }
                WMFullScreenViewGroup.this.appc = motionEvent.getX();
                WMFullScreenViewGroup.this.appd = motionEvent.getY();
                WMFullScreenViewGroup.this.appe = motionEvent.getX();
                WMFullScreenViewGroup.this.appf = motionEvent.getY();
                WMFullScreenViewGroup.this.appc();
                WMFullScreenViewGroup.this.appd();
            }
            return false;
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
            if (WMFullScreenViewGroup.this.appo != null) {
                WMFullScreenViewGroup.this.appo.pause();
            }
            if (WMFullScreenViewGroup.this.appi != null) {
                WMFullScreenViewGroup.this.appi.appb(WMFullScreenViewGroup.this.apps, WMFullScreenViewGroup.this.appt, WMFullScreenViewGroup.this.appu, WMFullScreenViewGroup.this.appv, WMFullScreenViewGroup.this.appw, WMFullScreenViewGroup.this.f46575k);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appf implements View.OnClickListener {
        appf() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WMFullScreenViewGroup.this.appi.onAdClose();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appg implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        private int f46587appa;

        appg() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int duration;
            try {
                if (WMFullScreenViewGroup.this.appo == null || !WMFullScreenViewGroup.this.appo.isPlaying() || (duration = WMFullScreenViewGroup.this.appo.getDuration()) <= 0) {
                    return;
                }
                WMFullScreenViewGroup.this.f46567c = WMFullScreenViewGroup.this.appo.getCurrentPosition();
                int i10 = (WMFullScreenViewGroup.this.f46567c * 100) / duration;
                WMFullScreenViewGroup.this.f46568d.setProgress(i10);
                if (this.f46587appa != i10) {
                    this.f46587appa = i10;
                }
                if (WMFullScreenViewGroup.f46562q != 0 && this.f46587appa != i10) {
                    this.f46587appa = i10;
                    WMFullScreenViewGroup.this.setProgressTrackingEvent(this.f46587appa);
                }
                WMFullScreenViewGroup.this.f46580p.postDelayed(this, 100L);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("WMFullScreenViewGroup", "Api fullScreen update progress exception:" + th.toString());
            }
        }
    }

    public WMFullScreenViewGroup(Context context, String str, String str2, int i10, int i11, XAdFullScreenVideoListener xAdFullScreenVideoListener, com.wangmai.ad.dex.allmodules.appf.appc appcVar) {
        super(context);
        this.appc = -999.0f;
        this.appd = -999.0f;
        this.appe = -999.0f;
        this.appf = -999.0f;
        this.appx = true;
        this.f46573i = 2;
        this.f46574j = false;
        this.f46579o = new appg();
        this.f46580p = new Handler(Looper.getMainLooper());
        this.f46578n = context;
        this.appg = str;
        this.apph = str2;
        this.f46565appa = i10;
        this.appb = i11;
        this.appi = appcVar;
        appb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:14|15|(6:45|46|18|19|20|(2:22|(2:24|25)(1:27))(4:28|(2:34|(1:39)(2:36|(1:38)))|40|41))|17|18|19|20|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007f, code lost:
    
        appa.appa.appf.appd.appb("WMFullScreenViewGroup", "Api fullScreen setProgressTrackingEvent exception2:" + r0.toString());
        r13 = com.google.android.material.shadow.ShadowDrawableWrapper.COS_45;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1 A[Catch: all -> 0x00d8, TryCatch #0 {all -> 0x00d8, blocks: (B:3:0x0007, B:5:0x000b, B:7:0x000f, B:10:0x0018, B:12:0x0020, B:14:0x002b, B:22:0x00a1, B:24:0x00a5, B:28:0x00ab, B:34:0x00c5, B:40:0x00ce, B:44:0x007f, B:49:0x004e, B:46:0x003c, B:20:0x0075), top: B:2:0x0007, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ab A[Catch: all -> 0x00d8, TryCatch #0 {all -> 0x00d8, blocks: (B:3:0x0007, B:5:0x000b, B:7:0x000f, B:10:0x0018, B:12:0x0020, B:14:0x002b, B:22:0x00a1, B:24:0x00a5, B:28:0x00ab, B:34:0x00c5, B:40:0x00ce, B:44:0x007f, B:49:0x004e, B:46:0x003c, B:20:0x0075), top: B:2:0x0007, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setProgressTrackingEvent(int r22) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.ad.dex.allmodules.api.fullscreen.WMFullScreenViewGroup.setProgressTrackingEvent(int):void");
    }

    private static void setProgressTrackingUrl(ProgressTrackingBean progressTrackingBean) {
        try {
            com.wangmai.ad.dex.allmodules.utils.appf.appa(progressTrackingBean.getUrl(), 0, false);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("WMFullScreenViewGroup", "Api fullScreen setProgressTrackingUrl exception:" + th.toString());
        }
    }

    @Override // com.wangmai.common.WMAdActListener
    public void adOnActivityResult(int i10, int i11, Intent intent) {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void adOnConfigurationChanged(Configuration configuration) {
    }

    @Override // com.wangmai.common.WMAdActListener
    public boolean adOnKeyDown(int i10, KeyEvent keyEvent) {
        return i10 == 4;
    }

    @Override // com.wangmai.ad.dex.allmodules.appf.appa
    public void destroy() {
        VideoView videoView = this.appo;
        if (videoView != null) {
            videoView.resume();
        }
    }

    @Override // com.wangmai.common.WMAdActListener
    public Resources getAdResources() {
        return WMResources.resources;
    }

    public int getDspBidPrice() {
        return this.f46576l;
    }

    public int getMediaBidPrice() {
        return this.f46577m;
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdCreate(Bundle bundle) {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdDestroy() {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdPause() {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdRestart() {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdResume() {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdStart() {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdStop() {
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        appa.appa.appf.appd.appa("WMFullScreenViewGroup", "Api fullScreen MediaPlayer over");
        apph();
        try {
            if (this.appx) {
                appd();
                return;
            }
            if (mediaPlayer.isPlaying()) {
                return;
            }
            this.appp.setVisibility(0);
            this.appp.setText("");
            this.appp.setBackgroundResource(1879310342);
            this.appp.setOnClickListener(new appf());
            this.appi.appb("");
            this.appi.appa(this.apps, this.appt, this.appu, this.appv, this.appw, this.f46575k);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("WMFullScreenViewGroup", "Api fullScreen onCompletion exception:" + th.toString());
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
        String str = i11 != -1010 ? i11 != -1007 ? i11 != -1004 ? i11 != -110 ? "UNKNOW" : "Some operation takes too long to complete, usually more than 3-5 seconds" : "File or network related operation errors" : "Bitstream is not conforming to the related coding standard or file spec" : "the media framework does not support the file";
        this.appy.setVisibility(8);
        appa.appa.appf.appd.appe("WMFullScreenViewGroup", "Api fullScreen onPreparedonError  " + str);
        apph();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (z10) {
            int i14 = 0;
            for (int i15 = 0; i15 < this.appj; i15++) {
                getChildAt(i15).layout(i14, 0, this.appl + i14, this.appk);
                i14 += this.appl;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.appj = getChildCount();
        if (this.appj == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        measureChildren(i10, i11);
        View childAt = getChildAt(0);
        this.appk = childAt.getMeasuredHeight();
        this.appl = childAt.getMeasuredWidth();
        setMeasuredDimension(this.appl * this.appj, this.appk);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        try {
            apph();
            if (this.f46567c > 0) {
                this.appo.seekTo(this.f46567c);
            }
            appg();
            mediaPlayer.start();
            this.appy.setVisibility(8);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("WMFullScreenViewGroup", "Api fullScreen 播放异常:" + th.toString());
        }
    }

    @Override // com.wangmai.ad.dex.allmodules.appf.appa
    public void pause() {
        appa.appa.appf.appd.appa("WMFullScreenViewGroup", "Api fullScreen pause");
        VideoView videoView = this.appo;
        if (videoView != null) {
            videoView.pause();
        }
    }

    @Override // com.wangmai.ad.dex.allmodules.appf.appa
    public void resume() {
        appa.appa.appf.appd.appa("WMFullScreenViewGroup", "Api fullScreen resume");
        VideoView videoView = this.appo;
        if (videoView != null) {
            videoView.resume();
        }
    }

    public void setDspBidPrice(int i10) {
        this.f46576l = i10;
    }

    public void setListener(com.wangmai.ad.dex.allmodules.appf.appc appcVar) {
        this.appi = appcVar;
    }

    public void setMediaBidPrice(int i10) {
        this.f46577m = i10;
    }

    private void appf() {
        appa.appa.appf.appd.appa("WMFullScreenViewGroup", "Api fullScreen requestId:" + this.apph, "slotId:" + this.appg);
        com.wangmai.ad.dex.allmodules.appc.appb.appa(this.f46578n, "WMFullScreenViewGroup", this.appg, this.apph, new appb());
    }

    private void appg() {
        this.f46580p.removeCallbacks(this.f46579o);
        this.f46580p.post(this.f46579o);
    }

    private void apph() {
        this.f46580p.removeCallbacks(this.f46579o);
    }

    private void appi() {
        try {
            if (!TextUtils.isEmpty(this.appv)) {
                this.appq.setText(this.appv + "");
            }
            if (!TextUtils.isEmpty(this.appu)) {
                this.appr.setText(this.appu + "");
            }
            if (!TextUtils.isEmpty(this.appt)) {
                OkHttp.get(this.appt).execute(new appc());
            }
            this.appz.setOnTouchListener(new appd());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("WMFullScreenViewGroup", "Api fullScreen upLoadIcon exception:" + th.toString());
        }
    }

    private void appb() {
        try {
            this.appm = LayoutInflater.from(appa.appa.appf.appa.appa(this.f46578n, WMResources.resources)).inflate(R$layout.wm_fullscreen_video_layout, (ViewGroup) this, false);
            this.appo = (VideoView) this.appm.findViewById(1879179365);
            this.appp = (TextView) this.appm.findViewById(R$id.wm_count_view);
            this.appy = (ProgressBar) this.appm.findViewById(1879179342);
            this.appz = (RelativeLayout) this.appm.findViewById(R$id.wm_layout_video_detail);
            this.f46564a = (ImageView) this.appm.findViewById(R$id.wm_image_icon);
            this.f46566b = (ImageView) this.appm.findViewById(R$id.wm_video_skip);
            this.appq = (TextView) this.appm.findViewById(R$id.wm_tv_title);
            this.appr = (TextView) this.appm.findViewById(R$id.wm_tv_msg);
            this.f46568d = (ProgressBar) this.appm.findViewById(1879179341);
            this.appp.setVisibility(8);
            new Handler().postDelayed(new appa(), 8000L);
            appf();
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("WMFullScreenViewGroup", "Api fullScreen init exception1:" + th.toString());
            com.wangmai.ad.dex.allmodules.appf.appc appcVar = this.appi;
            if (appcVar != null) {
                appcVar.appa("全屏广告初始化失败:" + th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appc() {
        com.wangmai.ad.dex.allmodules.appf.appc appcVar = this.appi;
        if (appcVar != null) {
            appcVar.appa();
        }
        this.f46571g.appa(com.wangmai.ad.dex.allmodules.utils.appf.appl, this.appc, this.appd, this.appe, this.appf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appd() {
        if (TextUtils.isEmpty(this.appw)) {
            return;
        }
        if (TextUtils.isEmpty(this.f46575k.getRespObj().getWxad().getDeep_link())) {
            appa("", this.appw);
        } else {
            appa(this.f46575k.getRespObj().getWxad().getDeep_link(), this.appw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appe() {
        apph();
        removeAllViewsInLayout();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appa(ApiBean apiBean) {
        ApiBean.RespObj respObj = apiBean.getRespObj();
        ApiBean.WxadBean wxad = respObj.getWxad();
        if (respObj.getError_code() == 0 && wxad != null) {
            this.appn = wxad.getCreative_type();
            if (this.appn != 6) {
                appa.appa.appf.appd.appb("WMFullScreenViewGroup", "Api fullScreen 解析失败，未知交互类型 " + this.appn);
                com.wangmai.ad.dex.allmodules.appf.appc appcVar = this.appi;
                if (appcVar != null) {
                    appcVar.appa("未知广告交互类型");
                }
                appe();
                return;
            }
            ApiBean.Video video = wxad.getVideo();
            String v_url = video.getV_url();
            if (video.getExt() != null) {
                this.appx = false;
                this.apps = video.getExt().getEndimgurl();
                this.appt = video.getExt().getEndiconurl();
                this.appu = video.getExt().getEnddesc();
                this.appv = video.getExt().getEndtitle();
                this.appw = video.getExt().getEndbuttonurl();
                f46562q = video.getDuration();
                if (video.getV_tracking() != null && video.getV_tracking().getV_progress_tracking_event() != null && video.getV_tracking().getV_progress_tracking_event().size() > 0) {
                    f46563r = video.getV_tracking().getV_progress_tracking_event();
                }
                this.f46571g = new com.wangmai.ad.dex.allmodules.utils.appb(null, this.f46578n, this.f46569e, this.f46570f, true, f46563r, wxad);
            }
            if (!TextUtils.isEmpty(this.appw)) {
                this.appz.setVisibility(0);
                appi();
            } else {
                this.appz.setVisibility(8);
            }
            if (TextUtils.isEmpty(v_url)) {
                appa.appa.appf.appd.appb("WMFullScreenViewGroup", "Api fullScreen 视频链接为空");
                com.wangmai.ad.dex.allmodules.appf.appc appcVar2 = this.appi;
                if (appcVar2 != null) {
                    appcVar2.appa("视频物料无效");
                }
                appe();
                return;
            }
            appb(apiBean);
            appa(v_url);
            return;
        }
        appa.appa.appf.appd.appb("WMFullScreenViewGroup", "Api fullScreen 广告请求失败：" + respObj.getError_code());
        com.wangmai.ad.dex.allmodules.appf.appc appcVar3 = this.appi;
        if (appcVar3 != null) {
            appcVar3.appa("广告请求失败：" + respObj.getError_code());
        }
        appe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appb(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        if (str != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("User-Agent", appx.appg(this.f46578n));
                mediaMetadataRetriever.setDataSource(str, hashMap);
            } finally {
                try {
                } finally {
                }
            }
        }
        String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
        if (Integer.parseInt(extractMetadata) > Integer.parseInt(extractMetadata2)) {
            this.f46573i = 1;
        } else {
            this.f46573i = 2;
        }
        appa.appa.appf.appd.appa("WMFullScreenViewGroup", "Api fullScreen view w=" + extractMetadata, "h=" + extractMetadata2);
    }

    private void appb(ApiBean apiBean) {
        this.f46575k = apiBean;
        this.f46566b.setOnClickListener(new appe());
    }

    private void appa(String str) {
        try {
            appa.appa.appf.appd.appa("WMFullScreenViewGroup", "Api fullScreen addAd videoUrl：" + str);
            Uri parse = Uri.parse(str);
            this.appo.setOnCompletionListener(this);
            this.appo.setOnErrorListener(this);
            this.appo.setOnPreparedListener(this);
            this.appo.setVideoURI(parse);
            addView(this.appm);
            invalidate();
            if (this.appi != null) {
                this.appi.onAdLoad();
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("WMFullScreenViewGroup", "Api fullScreen addAd 视频格式错误:" + th.toString());
            com.wangmai.ad.dex.allmodules.appf.appc appcVar = this.appi;
            if (appcVar != null) {
                appcVar.appa("视频物料无效");
            }
            appe();
        }
    }

    private void appa(String str, String str2) {
        try {
            com.wangmai.ad.dex.allmodules.utils.appf.appa("", false, str, str2, this.f46578n, this.appc, this.appd, this.appe, this.appf, this.f46575k, this, this.f46565appa, this.appb);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("WMFullScreenViewGroup", "Api fullScreen clickLoadPage exception:" + th.toString());
            com.wangmai.ad.dex.allmodules.utils.appf.appa(this.f46578n, this.appg, th.toString());
        }
    }

    public void appa(Context context) {
        com.wangmai.ad.dex.allmodules.appf.appc appcVar = this.appi;
        if (appcVar != null) {
            appcVar.appa(context, this.f46572h, this.f46573i);
        }
        com.wangmai.ad.dex.allmodules.utils.appf.apph = 1;
        this.appo.start();
    }
}
