package com.wangmai.ad.dex.allmodules.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.wangmai.ad.dex.allmodules.R$layout;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.common.utils.ConstantInfo;
import com.wangmai.common.utils.WMResources;
import com.wangmai.common.view.CustomVideoView2;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.callback.BitmapCallback;
import com.wangmai.okhttp.model.Response;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class WMVideoView2 extends ViewGroup implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, com.wangmai.ad.dex.allmodules.appf.appa {
    private static final String appy = WMVideoView2.class.getSimpleName();

    /* renamed from: appa, reason: collision with root package name */
    private Handler f46874appa;
    private Context appb;
    private ApiBean appc;
    private boolean appd;
    private boolean appe;
    private int appf;
    private int appg;
    private boolean apph;
    private appf appi;
    public float appj;
    public float appk;
    public float appl;
    public float appm;
    private int appn;
    private int appo;
    private int appp;
    private View appq;
    private CustomVideoView2 appr;
    private ProgressBar apps;
    private int appt;
    private ProgressBar appu;
    private ImageView appv;
    private ImageView appw;
    private Runnable appx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa implements View.OnClickListener {
        appa() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WMVideoView2.this.appe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb extends BitmapCallback {
        appb() {
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<Bitmap> response) {
            if (response != null) {
                WMVideoView2.this.appw.setImageBitmap(response.body());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appc implements View.OnTouchListener {
        appc(WMVideoView2 wMVideoView2) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ConstantInfo.downX = motionEvent.getX();
            ConstantInfo.downY = motionEvent.getY();
            appa.appa.appf.appd.appa(WMVideoView2.appy, "API 视频容器触摸", Double.valueOf(ConstantInfo.downX), Double.valueOf(ConstantInfo.downY));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appd implements View.OnClickListener {
        appd() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WMVideoView2.this.apph = true;
            try {
                appa.appa.appf.appd.appa(WMVideoView2.appy, "isClickReport  layout " + WMVideoView2.this.appt);
                if (WMVideoView2.this.appi != null) {
                    WMVideoView2.this.appi.appf();
                    WMVideoView2.this.appi.appa();
                    WMVideoView2.this.appc();
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appe(WMVideoView2.appy, "WMVideoView2 点击预处理错误：" + th.toString());
            }
            WMVideoView2.this.appa();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appe implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        private int f46878appa;

        appe() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int duration;
            try {
                if (WMVideoView2.this.appr == null || !WMVideoView2.this.appr.isPlaying() || (duration = WMVideoView2.this.appr.getDuration()) <= 0) {
                    return;
                }
                WMVideoView2.this.appt = WMVideoView2.this.appr.getCurrentPosition();
                int i10 = (WMVideoView2.this.appt * 100) / duration;
                WMVideoView2.this.appu.setProgress(i10);
                if (this.f46878appa != i10) {
                    this.f46878appa = i10;
                }
                WMVideoView2.this.f46874appa.postDelayed(this, 100L);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe(WMVideoView2.appy, "VideoView Update Progress Error:" + th.toString());
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public interface appf {
        void appa();

        void appb();

        void appc();

        void appd();

        void appe();

        void appf();

        void appg();

        void onVideoError(String str);
    }

    public WMVideoView2(Context context, ApiBean apiBean, boolean z10, boolean z11, int i10, int i11) {
        super(context);
        this.f46874appa = new Handler(Looper.getMainLooper());
        this.appf = 1;
        this.appg = 0;
        this.appj = -999.0f;
        this.appk = -999.0f;
        this.appl = -999.0f;
        this.appm = -999.0f;
        this.appx = new appe();
        this.appb = context;
        this.appc = apiBean;
        this.appd = z10;
        this.appe = z11;
        this.appf = i10;
        this.appg = i11;
        appi();
    }

    private void apph() {
        try {
            String v_url = this.appc.getRespObj().getWxad().getVideo().getV_url();
            appa.appa.appf.appd.appa(appy, "v2.api   videoView " + v_url);
            this.appv.setOnClickListener(new appa());
            this.appr.setOnCompletionListener(this);
            this.appr.setOnErrorListener(this);
            this.appr.setOnPreparedListener(this);
            this.appr.setVideoPath(v_url);
            appa.appa.appf.appd.appa(appy, "v2.api endimgurl " + this.appc.getRespObj().getWxad().getVideo().getExt().getEndimgurl());
            if (!TextUtils.isEmpty(this.appc.getRespObj().getWxad().getVideo().getExt().getEndimgurl())) {
                OkHttp.get(this.appc.getRespObj().getWxad().getVideo().getExt().getEndimgurl()).execute(new appb());
            }
            addView(this.appq);
            invalidate();
            this.appq.setOnTouchListener(new appc(this));
            this.appq.setOnClickListener(new appd());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appy, "addAd exception：" + th.toString());
            appf appfVar = this.appi;
            if (appfVar != null) {
                appfVar.onVideoError("视频格式错误");
            }
        }
    }

    private void appi() {
        try {
            appa.appa.appf.appd.appa(appy, "initView: ");
            this.appq = LayoutInflater.from(appa.appa.appf.appa.appa(this.appb, WMResources.resources)).inflate(R$layout.wm_native_video2_layout, (ViewGroup) this, false);
            this.appr = (CustomVideoView2) this.appq.findViewById(1879179365);
            this.apps = (ProgressBar) this.appq.findViewById(1879179342);
            this.appu = (ProgressBar) this.appq.findViewById(1879179341);
            this.appv = (ImageView) this.appq.findViewById(1879179363);
            this.appw = (ImageView) this.appq.findViewById(1879179309);
            apph();
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appy, "WMVideoView2 init error:" + th.toString());
        }
    }

    private void appj() {
        try {
            try {
                com.wangmai.ad.dex.allmodules.utils.appf.appa(this.appc.getRespObj().getWxad().getClick_url(), (List<String>) null, com.wangmai.ad.dex.allmodules.utils.appf.appl, 0.0f, 0.0f, 0.0f, 0.0f);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe(appy, "WMVideoView2 clickUpEventReport error:" + ((Object) th));
                com.wangmai.ad.dex.allmodules.utils.appf.appa(this.appb, "", "WMVideoView2 clickUpEventReport error:" + Log.getStackTraceString(th));
            }
            appa(this.appc.getRespObj().getWxad().getDeep_link(), this.appc.getRespObj().getWxad().getLanding_page_url());
        } catch (Throwable th2) {
            appa.appa.appf.appd.appe(appy, "WMVideoView2 openLinkAddress error:" + ((Object) th2));
            com.wangmai.ad.dex.allmodules.utils.appf.appa(this.appb, "", "WMVideoView2 openLinkAddress error:" + Log.getStackTraceString(th2));
        }
    }

    private void appk() {
        this.f46874appa.removeCallbacks(this.appx);
        this.f46874appa.post(this.appx);
    }

    private void appl() {
        this.f46874appa.removeCallbacks(this.appx);
    }

    @Override // com.wangmai.ad.dex.allmodules.appf.appa
    public void destroy() {
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        appa.appa.appf.appd.appa(appy, "MediaPlayer over");
        appl();
        try {
            if (mediaPlayer.isPlaying()) {
                return;
            }
            this.appt = 0;
            this.appv.setVisibility(0);
            this.apps.setVisibility(8);
            this.appr.setVisibility(8);
            invalidate();
            requestLayout();
            this.appi.appb();
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appy, "onCompletion error:" + th.toString());
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
        String str = i11 != -1010 ? i11 != -1007 ? i11 != -1004 ? i11 != -110 ? "UNKNOW" : "Some operation takes too long to complete, usually more than 3-5 seconds" : "File or network related operation errors" : "Bitstream is not conforming to the related coding standard or file spec" : "the media framework does not support the file";
        this.apps.setVisibility(8);
        appa.appa.appf.appd.appe(appy, "onPreparedonError  " + str);
        appf appfVar = this.appi;
        if (appfVar != null) {
            appfVar.onVideoError(str);
        }
        appl();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.apph || !z10) {
            return;
        }
        appa.appa.appf.appd.appa(appy, "onLayout--  ");
        int i14 = 0;
        for (int i15 = 0; i15 < this.appn; i15++) {
            getChildAt(i15).layout(i14, 0, this.appp + i14, this.appo);
            i14 += this.appp;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.appn = getChildCount();
        if (this.apph) {
            return;
        }
        if (this.appn == 0) {
            appa.appa.appf.appd.appa(appy, "onMeasure-1-  ");
            setMeasuredDimension(0, 0);
            return;
        }
        appa.appa.appf.appd.appa(appy, "onMeasure-2-  ");
        measureChildren(i10, i11);
        View childAt = getChildAt(0);
        this.appo = childAt.getMeasuredHeight();
        this.appp = childAt.getMeasuredWidth();
        setMeasuredDimension(this.appp * this.appn, this.appo);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        try {
            appa(mediaPlayer);
            appa.appa.appf.appd.appa(appy, "onPrepared:" + this.appt);
            appl();
            if (this.appt == 0) {
                if (this.appi != null) {
                    this.appi.appc();
                }
                if (this.appd) {
                    appe();
                }
            } else {
                appd();
            }
            this.apps.setVisibility(8);
        } catch (Throwable th) {
            appa.appa.appf.appd.appb(appy, "视频播放异常：" + th.toString());
            appf appfVar = this.appi;
            if (appfVar != null) {
                appfVar.onVideoError("播放异常");
            }
        }
    }

    @Override // com.wangmai.ad.dex.allmodules.appf.appa
    public void pause() {
        appc();
    }

    @Override // com.wangmai.ad.dex.allmodules.appf.appa
    public void resume() {
        appd();
    }

    public void setSilence(boolean z10) {
        appa.appa.appf.appd.appa(appy, "是否静音：" + z10);
        this.appe = z10;
        CustomVideoView2 customVideoView2 = this.appr;
        if (customVideoView2 != null) {
            if (z10) {
                customVideoView2.setVolume(0);
            } else {
                customVideoView2.setVolume(1);
            }
        }
    }

    public void setVideoListener(appf appfVar) {
        this.appi = appfVar;
    }

    public void appb() {
        try {
            if (this.appr != null) {
                this.appr.stopPlayback();
                this.appr = null;
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appy, "WMVideoView onDestroy error:" + th.toString());
        }
    }

    public void appc() {
        try {
            appa.appa.appf.appd.appa(appy, "暂停");
            if (this.appr != null) {
                this.appt = this.appr.getCurrentPosition();
                appa.appa.appf.appd.appa(appy, "pauseVideo seek=" + this.appt);
                this.appv.setVisibility(0);
                invalidate();
                this.appr.pause();
                if (this.appi != null) {
                    this.appi.appa();
                }
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appy, "pauseVideo exception:" + th.toString());
        }
    }

    public void appd() {
        try {
            appa.appa.appf.appd.appa(appy, "恢复:" + this.appt);
            if (this.appr != null) {
                this.appr.setVisibility(0);
                this.appv.setVisibility(8);
                invalidate();
                this.appr.seekTo(this.appt);
                this.appr.startVideo();
                appk();
                if (this.appi != null) {
                    this.appi.appd();
                }
                setSilence(this.appe);
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appy, "resumeVideo exception:" + th.toString());
        }
    }

    public void appe() {
        try {
            appa.appa.appf.appd.appa(appy, "播放", Integer.valueOf(this.appt));
            if (this.appr != null) {
                this.appr.setVisibility(0);
                this.appv.setVisibility(8);
                requestLayout();
                this.appr.seekTo(this.appt);
                this.appr.startVideo();
                appk();
                if (this.appi != null) {
                    this.appi.appe();
                }
                setSilence(this.appe);
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appy, "startVideo exception:" + th.toString());
        }
    }

    public void appf() {
        try {
            appa.appa.appf.appd.appa(appy, "停止");
            if (this.appr != null) {
                this.appt = 0;
                this.appv.setVisibility(0);
                invalidate();
                this.appr.seekTo(this.appt);
                this.appr.pause();
                if (this.appi != null) {
                    this.appi.appg();
                }
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appy, "stopVideo exception:" + th.toString());
        }
    }

    private void appa(MediaPlayer mediaPlayer) {
        float f10;
        float f11;
        float f12;
        int videoWidth = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        int i10 = getResources().getDisplayMetrics().widthPixels;
        int i11 = getResources().getDisplayMetrics().heightPixels;
        Log.d(appy, "changeVideoSize: deviceHeight=" + i11 + "deviceWidth=" + i10 + "--" + videoWidth + "---" + videoHeight);
        if (getResources().getConfiguration().orientation == 1) {
            f10 = i10;
            f11 = i11;
        } else {
            f10 = i11;
            f11 = i10;
        }
        float f13 = f10 / f11;
        if (videoWidth > videoHeight) {
            i11 = (int) (i10 * f13);
        } else {
            if (getResources().getConfiguration().orientation == 1) {
                float f14 = videoWidth;
                if (Math.abs((f14 / i11) - f13) >= 0.3d) {
                    f12 = f14 / f13;
                }
            } else {
                f12 = i11 * f13;
            }
            i10 = (int) f12;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.appr.getLayoutParams();
        layoutParams.width = i10;
        layoutParams.height = i11;
        this.appr.setLayoutParams(layoutParams);
        invalidate();
        requestLayout();
    }

    void appa() {
        appa.appa.appf.appd.appe(appy, "WmVideoView doClick", Thread.currentThread().getName());
        appj();
    }

    private void appa(String str, String str2) {
        try {
            com.wangmai.ad.dex.allmodules.utils.appf.appa("", false, str, str2, this.appb, this.appj, this.appk, this.appl, this.appm, this.appc, this, this.appf, this.appg);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appy, "WMVideoView2 clickLoadPage error:" + ((Object) th));
            com.wangmai.ad.dex.allmodules.utils.appf.appa(this.appb, "", "WMVideoView2 clickLoadPage error:" + Log.getStackTraceString(th));
        }
    }
}
