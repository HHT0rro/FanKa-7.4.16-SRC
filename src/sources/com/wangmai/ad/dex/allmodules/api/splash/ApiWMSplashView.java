package com.wangmai.ad.dex.allmodules.api.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.SensorManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wangmai.ad.dex.allmodules.R$id;
import com.wangmai.ad.dex.allmodules.R$layout;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.ad.dex.allmodules.utils.appt;
import com.wangmai.ad.dex.allmodules.utils.appw;
import com.wangmai.ad.dex.allmodules.utils.appx;
import com.wangmai.ad.dex.allmodules.utils.appy;
import com.wangmai.appsdkdex.WMDexAdHelper;
import com.wangmai.appsdkdex.utils.VisibilityUtils;
import com.wangmai.common.utils.ThreadUtils;
import com.wangmai.common.utils.Utils;
import com.wangmai.common.utils.WMResources;
import com.wangmai.common.view.CustomWebView;
import java.io.File;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class ApiWMSplashView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private int f46652a;

    /* renamed from: appa, reason: collision with root package name */
    public float f46653appa;
    public float appb;
    public float appc;
    public float appd;
    private ImageView appe;
    private ImageView appf;
    private TextView appg;
    private TextView apph;
    private SurfaceView appi;
    private MediaPlayer appj;
    private appq appk;
    private String appl;
    private String appm;
    private CustomWebView appn;
    private Context appo;
    private int appp;
    private String appq;
    private int appr;
    private boolean apps;
    private Bitmap appt;
    private View appu;
    private TextView appv;
    private appt appw;
    private appw appx;
    protected boolean appy;
    private com.wangmai.ad.dex.allmodules.api.splash.appa appz;

    /* renamed from: b, reason: collision with root package name */
    appr f46654b;

    /* renamed from: c, reason: collision with root package name */
    Bitmap f46655c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa implements SurfaceHolder.Callback {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46656appa;

        appa(String str) {
            this.f46656appa = str;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (ApiWMSplashView.this.appj != null) {
                ApiWMSplashView.this.appj.setDisplay(surfaceHolder);
            } else {
                ApiWMSplashView.this.appa(surfaceHolder, this.f46656appa);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            ApiWMSplashView.this.appa();
            if (ApiWMSplashView.this.appk != null) {
                ApiWMSplashView.this.appk.appb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb implements MediaPlayer.OnErrorListener {
        appb() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            if (ApiWMSplashView.this.appk == null) {
                return false;
            }
            ApiWMSplashView.this.appk.appa("IPA.MW Splash 视频流错误");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appc implements MediaPlayer.OnPreparedListener {

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class appa implements MediaPlayer.OnInfoListener {
            appa() {
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i10, int i11) {
                if (i10 == 3) {
                    appa.appa.appf.appd.appa("ApiWMSplashView", "IPA.MW Splash 首帧已渲染");
                    if (ApiWMSplashView.this.appf != null && ApiWMSplashView.this.appf.getVisibility() == 0) {
                        ApiWMSplashView.this.appf.setVisibility(8);
                    }
                }
                return false;
            }
        }

        appc() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.setOnInfoListener(new appa());
            ApiWMSplashView.this.appj.start();
            if (ApiWMSplashView.this.appk != null) {
                ApiWMSplashView.this.appk.start();
            }
            ApiWMSplashView.this.appj.setLooping(true);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appd implements VisibilityUtils.ViewVisibilityChangeListener {
        appd() {
        }

        @Override // com.wangmai.appsdkdex.utils.VisibilityUtils.ViewVisibilityChangeListener
        public void invisible() {
            if (ApiWMSplashView.this.appw != null) {
                ApiWMSplashView.this.appw.appc();
            }
            appr apprVar = ApiWMSplashView.this.f46654b;
            if (apprVar != null) {
                apprVar.invisible();
            }
        }

        @Override // com.wangmai.appsdkdex.utils.VisibilityUtils.ViewVisibilityChangeListener
        public void visible() {
            if (ApiWMSplashView.this.appw != null) {
                ApiWMSplashView.this.appw.appe();
            }
            appr apprVar = ApiWMSplashView.this.f46654b;
            if (apprVar != null) {
                apprVar.visible();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appe implements Runnable {

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class appa implements Runnable {
            appa() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ApiWMSplashView.this.appf.setImageBitmap(ApiWMSplashView.this.f46655c);
            }
        }

        appe() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                if (Uri.parse(ApiWMSplashView.this.appm) != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("User-Agent", appx.appg(ApiWMSplashView.this.appo));
                    mediaMetadataRetriever.setDataSource(ApiWMSplashView.this.appm, hashMap);
                }
                ApiWMSplashView.this.f46655c = mediaMetadataRetriever.getFrameAtTime();
                if (ApiWMSplashView.this.f46655c != null) {
                    ThreadUtils.runOnUIThread(new appa());
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appf implements MediaPlayer.OnPreparedListener {

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class appa implements MediaPlayer.OnInfoListener {
            appa() {
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i10, int i11) {
                if (i10 == 3) {
                    appa.appa.appf.appd.appa("ApiWMSplashView", "IPA.MW Splash 首帧已渲染");
                    if (ApiWMSplashView.this.appf != null && ApiWMSplashView.this.appf.getVisibility() == 0) {
                        ApiWMSplashView.this.appf.setVisibility(8);
                    }
                }
                return false;
            }
        }

        appf() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.setOnInfoListener(new appa());
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
            mediaPlayer.seekTo(ApiWMSplashView.this.f46652a);
            if (ApiWMSplashView.this.appk != null) {
                ApiWMSplashView.this.appk.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appg implements MediaPlayer.OnErrorListener {
        appg() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            if (ApiWMSplashView.this.appk == null) {
                return false;
            }
            ApiWMSplashView.this.appk.appa("IPA.MW Splash 视频流错误");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class apph extends ClickableSpan {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ ApiBean.DownloadAppInfo f46666appa;

        apph(ApiBean.DownloadAppInfo downloadAppInfo) {
            this.f46666appa = downloadAppInfo;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            com.wangmai.ad.dex.allmodules.utils.appf.appc(ApiWMSplashView.this.appo, this.f46666appa.getPrivacy());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appi extends ClickableSpan {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46667appa;
        final /* synthetic */ String appb;

        appi(String str, String str2) {
            this.f46667appa = str;
            this.appb = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.f46667appa)) {
                com.wangmai.ad.dex.allmodules.utils.appf.appc(ApiWMSplashView.this.appo, this.f46667appa);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<html>");
            stringBuffer.append("<head><style>body{margin:0;padding:50 15 30 15;font-size:38;color:#666666}div{font-size:50;padding-bottom:30;color:#333333;font-weight:bold}</style></head>");
            stringBuffer.append("<body>");
            stringBuffer.append("<center><div>功能介绍</div></center>");
            stringBuffer.append(this.appb);
            stringBuffer.append("</body></html>");
            com.wangmai.ad.dex.allmodules.utils.appf.appc(ApiWMSplashView.this.appo, "wmText://" + ((Object) stringBuffer));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appj extends ClickableSpan {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46668appa;
        final /* synthetic */ List appb;

        appj(String str, List list) {
            this.f46668appa = str;
            this.appb = list;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.f46668appa)) {
                com.wangmai.ad.dex.allmodules.utils.appf.appc(ApiWMSplashView.this.appo, this.f46668appa);
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
            com.wangmai.ad.dex.allmodules.utils.appf.appc(ApiWMSplashView.this.appo, "wmText://" + ((Object) stringBuffer));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appk implements View.OnClickListener {
        appk() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            appa.appa.appf.appd.appa("ApiWMSplashView", "touchBack:onClick ");
            if (ApiWMSplashView.this.appk != null) {
                ApiWMSplashView.this.appk.appd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appl implements CustomWebView.TouchCallback {
        appl() {
        }

        @Override // com.wangmai.common.view.CustomWebView.TouchCallback
        public void touchBack() {
            appa.appa.appf.appd.appa("ApiWMSplashView", "touchBack: ");
            if (ApiWMSplashView.this.appk != null) {
                ApiWMSplashView.this.appk.appd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appm extends appy {
        appm(Context context, String str) {
            super(context, str);
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appy
        public boolean appa(WebView webView, String str) {
            try {
                com.wangmai.ad.dex.allmodules.utils.appf.appc(ApiWMSplashView.this.appo, str);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("ApiWMSplashView", "shouldOverrideUrlLoadingInternal:" + th.toString());
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appn implements DownloadListener {
        appn() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                com.wangmai.ad.dex.allmodules.utils.appf.appa(ApiWMSplashView.this.appo, str, str2, str3, str4, j10);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("ApiWMSplashView", "onDownloadStart:" + th.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appo implements appw.appa {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ float f46672appa;

        appo(float f10) {
            this.f46672appa = f10;
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appw.appa
        public void appa(int i10, float f10, float f11, float f12) {
            if (f12 < this.f46672appa || ApiWMSplashView.this.appk == null) {
                return;
            }
            ApiWMSplashView.this.appk.appc();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appp implements appt.appa {
        appp() {
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appt.appa
        public void appa() {
            if (ApiWMSplashView.this.appk != null) {
                ApiWMSplashView.this.appk.appa();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public interface appq {
        void appa();

        void appa(String str);

        void appb();

        void appc();

        void appd();

        void appe();

        void appf();

        void start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public interface appr {
        void invisible();

        void visible();
    }

    public ApiWMSplashView(Context context, int i10, int i11, boolean z10) {
        super(context);
        this.f46653appa = -999.0f;
        this.appb = -999.0f;
        this.appc = -999.0f;
        this.appd = -999.0f;
        this.appp = -1;
        this.apps = false;
        this.f46652a = 0;
        this.appo = context;
        this.appy = z10;
        appa(i10, i11);
    }

    public int getType() {
        return this.appp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        appa.appa.appf.appd.appa("ApiWMSplashView", "onAttachedToWindow");
        try {
            this.appo = WMDexAdHelper.getTopActivity().get().getApplicationContext();
            if (this.appw != null) {
                this.appw.appd();
            }
            VisibilityUtils.getInstance().addVisibleChangedListener(this, new appd());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMSplashView", "IPA.MW Splash onAttachedToWindow:" + th.toString());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        appa.appa.appf.appd.appa("ApiWMSplashView", "IPA.MW Splash onClick");
        if (this.appk != null) {
            if (view.getId() != 1879179297 && view.getId() != 1879179299) {
                if (view.getId() != 1879179295 && view.getId() != 1879179343 && view.getId() != 1879179349 && view.getId() != 1879179353) {
                    if (view.getId() == 1879179300) {
                        this.appk.appe();
                        return;
                    }
                    return;
                }
                this.appk.appf();
                return;
            }
            this.appk.appd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            appa.appa.appf.appd.appa("ApiWMSplashView", "onDetachedFromWindow");
            this.appz = null;
            if (this.appw != null) {
                this.appw.appa();
                this.appw = null;
            }
            if (this.f46655c != null) {
                this.f46655c.recycle();
                this.f46655c = null;
            }
            if (this.appt != null) {
                this.appt.recycle();
                this.appt = null;
            }
            if (this.appk != null) {
                this.appk = null;
            }
            this.appu = null;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMSplashView", "IPA.MW Splash onDetachedFromWindow:" + th.toString());
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f46653appa = motionEvent.getX();
            this.appb = motionEvent.getY();
            this.appc = motionEvent.getX();
            this.appd = motionEvent.getY();
        }
        appw appwVar = this.appx;
        if (appwVar != null) {
            appwVar.appa(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f46653appa = motionEvent.getX();
            this.appb = motionEvent.getY();
            this.appc = motionEvent.getX();
            this.appd = motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c4 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:4:0x0003, B:6:0x0035, B:7:0x003d, B:9:0x0043, B:10:0x004b, B:12:0x0051, B:13:0x0059, B:15:0x0062, B:16:0x0077, B:18:0x007d, B:22:0x0099, B:25:0x00a1, B:27:0x00ba, B:29:0x00c4, B:31:0x00cf, B:33:0x00d6, B:35:0x00dd, B:36:0x00e2, B:40:0x00a7, B:41:0x0086), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cf A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:4:0x0003, B:6:0x0035, B:7:0x003d, B:9:0x0043, B:10:0x004b, B:12:0x0051, B:13:0x0059, B:15:0x0062, B:16:0x0077, B:18:0x007d, B:22:0x0099, B:25:0x00a1, B:27:0x00ba, B:29:0x00c4, B:31:0x00cf, B:33:0x00d6, B:35:0x00dd, B:36:0x00e2, B:40:0x00a7, B:41:0x0086), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d6 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:4:0x0003, B:6:0x0035, B:7:0x003d, B:9:0x0043, B:10:0x004b, B:12:0x0051, B:13:0x0059, B:15:0x0062, B:16:0x0077, B:18:0x007d, B:22:0x0099, B:25:0x00a1, B:27:0x00ba, B:29:0x00c4, B:31:0x00cf, B:33:0x00d6, B:35:0x00dd, B:36:0x00e2, B:40:0x00a7, B:41:0x0086), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00dd A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:4:0x0003, B:6:0x0035, B:7:0x003d, B:9:0x0043, B:10:0x004b, B:12:0x0051, B:13:0x0059, B:15:0x0062, B:16:0x0077, B:18:0x007d, B:22:0x0099, B:25:0x00a1, B:27:0x00ba, B:29:0x00c4, B:31:0x00cf, B:33:0x00d6, B:35:0x00dd, B:36:0x00e2, B:40:0x00a7, B:41:0x0086), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setDownLoadInfo(com.wangmai.ad.dex.allmodules.bean.ApiBean.DownloadAppInfo r12) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.ad.dex.allmodules.api.splash.ApiWMSplashView.setDownLoadInfo(com.wangmai.ad.dex.allmodules.bean.ApiBean$DownloadAppInfo):void");
    }

    public void setImageView(Bitmap bitmap) {
        try {
            this.appt = bitmap;
            if (this.apps) {
                return;
            }
            this.appe.setImageBitmap(this.appt);
            this.appg.setVisibility(0);
            this.appi.setVisibility(8);
            this.apph.setVisibility(8);
            this.appn.setVisibility(8);
            this.appe.setVisibility(0);
            this.appp = 0;
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("ApiWMSplashView", "IPA.MW splash set imageView:" + th.toString());
        }
    }

    public void setInteractionType(List<ApiBean.InteractiveObj> list) {
        try {
            this.appz = new com.wangmai.ad.dex.allmodules.api.splash.appa(this.appo, this.appu, this.appr);
            this.appz.setOnClickListener(this);
            if (list != null && !list.isEmpty()) {
                for (ApiBean.InteractiveObj interactiveObj : list) {
                    int intValue = interactiveObj.getType().intValue();
                    if (intValue == 1) {
                        this.appz.appa();
                        if (this.appw == null) {
                            this.appw = new appt((SensorManager) this.appo.getSystemService("sensor"), Utils.parseInt(interactiveObj.getData()), new appp());
                        }
                    } else if (intValue == 2) {
                        this.appz.appb();
                        if (this.appx == null) {
                            this.appx = new appw(this.appo, new appo((Math.min(Utils.getWindowWidth(this.appo), Utils.getWindowHeight(this.appo)) * Utils.parseInt(interactiveObj.getData())) / 100.0f));
                        }
                    }
                }
            }
            this.appz.appa(this.appy);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMSplashView", "Api splash setInteractionType exception:" + th.toString());
        }
    }

    public void setListener(appq appqVar) {
        this.appk = appqVar;
    }

    public void setTextView(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.appg.setText(str);
    }

    public void setViewVisibleListener(appr apprVar) {
        this.f46654b = apprVar;
    }

    public void setVolume(float f10) {
        MediaPlayer mediaPlayer;
        if (this.appp == 1 && (mediaPlayer = this.appj) != null) {
            mediaPlayer.setVolume(f10, f10);
        }
    }

    private void appa(int i10, int i11) {
        try {
            this.apps = false;
            this.appu = LayoutInflater.from(appa.appa.appf.appa.appa(this.appo, WMResources.resources)).inflate(R$layout.wm_customrelative, this);
            this.appr = i10;
            this.appe = (ImageView) this.appu.findViewById(R$id.wm_customre_iv);
            this.appg = (TextView) this.appu.findViewById(R$id.wm_customre_tv);
            this.appv = (TextView) this.appu.findViewById(R$id.wm_download_info);
            this.apph = (TextView) findViewById(R$id.wm_customre_wf);
            this.appi = (SurfaceView) this.appu.findViewById(R$id.wm_customre_sv);
            this.appn = (CustomWebView) this.appu.findViewById(R$id.wm_show_html);
            this.appe.setOnClickListener(this);
            this.appg.setOnClickListener(this);
            this.appi.setOnClickListener(this);
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("ApiWMSplashView", "IPA.MW splash init view:" + th.toString());
        }
    }

    public void appb() {
        MediaPlayer mediaPlayer;
        if (this.appp == 1 && (mediaPlayer = this.appj) != null) {
            mediaPlayer.pause();
        }
    }

    public void appc() {
        MediaPlayer mediaPlayer;
        if (this.appp == 1 && (mediaPlayer = this.appj) != null) {
            mediaPlayer.start();
        }
    }

    void appd() {
        if (this.appf == null) {
            this.appf = (ImageView) findViewById(R$id.wm_customre_iv2);
        }
        this.appf.setVisibility(0);
        Bitmap bitmap = this.f46655c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.appf.setImageBitmap(this.f46655c);
        } else {
            ThreadUtils.runOnThreadPool(new appe());
        }
    }

    public void appe() {
        if (this.appp != 1) {
            return;
        }
        appc(this.appq);
    }

    private String appb(String str) {
        File[] listFiles;
        try {
            listFiles = new File(com.wangmai.ad.dex.allmodules.utils.appq.appd().appc().getAbsolutePath()).listFiles();
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMSplashView", "IPA.MW Splash isLocalHas:" + th.toString());
        }
        if (listFiles != null && listFiles.length != 0) {
            String str2 = Utils.md5Decode(str) + str.substring(str.lastIndexOf("."));
            for (File file : listFiles) {
                if (file.getAbsolutePath().contains(str2)) {
                    appa.appa.appf.appd.appa("ApiWMSplashView", "targetFilePath：" + file.getAbsolutePath());
                    return file.getAbsolutePath();
                }
            }
            return "";
        }
        return "";
    }

    private void appc(String str) {
        try {
            this.appl = str;
            if (this.appi == null) {
                this.appi = (SurfaceView) findViewById(R$id.wm_customre_sv);
            }
            appd();
            this.appi.setVisibility(0);
            this.appi.setZOrderOnTop(true);
            this.appi.setZOrderMediaOverlay(true);
            this.apph.setVisibility(8);
            this.appn.setVisibility(8);
            this.appg.setVisibility(0);
            this.appe.setVisibility(8);
            if (!TextUtils.isEmpty(str)) {
                this.appj = new MediaPlayer();
                this.appj.setVolume(0.0f, 0.0f);
                try {
                    this.appj.setDataSource(str);
                    this.appi.getHolder().addCallback(new appa(str));
                    this.appj.prepareAsync();
                    this.appj.setOnErrorListener(new appb());
                    this.appj.setOnPreparedListener(new appc());
                    return;
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe("ApiWMSplashView", "IPA.MW Splash playVideo:" + th.toString());
                    if (this.appk != null) {
                        this.appk.appa("IPA.MW Splash 视频加载出错:" + th.toString());
                    }
                    appa();
                    return;
                }
            }
            if (this.appk != null) {
                this.appk.appa("IPA.MW Splash 视频初始化异常");
            }
        } catch (Throwable th2) {
            appa.appa.appf.appd.appe("ApiWMSplashView", "IPA.MW Splash playVideo:" + th2.toString());
            appq appqVar = this.appk;
            if (appqVar != null) {
                appqVar.appa("IPA.MW Splash 视频播放异常：" + th2.toString());
            }
        }
    }

    public void appa(String str, String str2) {
        try {
            if (this.apps) {
                return;
            }
            this.appg.setVisibility(0);
            this.appi.setVisibility(8);
            this.apph.setVisibility(8);
            this.appn.setVisibility(0);
            this.appe.setVisibility(8);
            WebSettings settings = this.appn.getSettings();
            settings.setLoadsImagesAutomatically(true);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            this.appn.setHorizontalScrollBarEnabled(false);
            this.appn.setVerticalScrollBarEnabled(false);
            appa.appa.appf.appd.appa("ApiWMSplashView", "IPA.MW Splash htmlData:" + str);
            if (str.startsWith("<html>")) {
                this.appn.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
            } else {
                String str3 = "<html><head><style>* body{font-size:15px;margin:0;padding:0}{color:#212121;}img{max-width: 100%; width:auto; height: auto;}</style></head><body>" + str + "</body></html>";
                this.appn.loadDataWithBaseURL(null, str3, "text/html", "utf-8", null);
                appa.appa.appf.appd.appa("ApiWMSplashView", "Api Splash resultStr:" + str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                RelativeLayout relativeLayout = (RelativeLayout) this.appn.getParent();
                RelativeLayout relativeLayout2 = new RelativeLayout(this.appo);
                relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                relativeLayout.addView(relativeLayout2, 1);
                invalidate();
                requestLayout();
                relativeLayout2.setOnClickListener(new appk());
            } else {
                this.appn.setTouchCallback(new appl());
                this.appn.setWebViewClient(new appm(this.appo, "ApiWMSplashView"));
                this.appn.setDownloadListener(new appn());
            }
            this.appp = 2;
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("ApiWMSplashView", "IPA.MW Splash render html:" + th.toString());
        }
    }

    public boolean appa(String str) {
        try {
            if (!this.apps) {
                this.appq = appb(str);
                if (!TextUtils.isEmpty(this.appq)) {
                    this.appp = 1;
                    this.appm = str;
                    return true;
                }
                appa.appa.appf.appd.appe("ApiWMSplashView", "Api splash video error");
                return false;
            }
            appa.appa.appf.appd.appe("ApiWMSplashView", "isDestroy");
            return false;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("ApiWMSplashView", "Api splash Video exception:" + th.toString());
            return false;
        }
    }

    public void appa() {
        try {
            appa.appa.appf.appd.appa("ApiWMSplashView", "----destroyPlayer");
            if (!TextUtils.isEmpty(this.appq)) {
                String substring = this.appq.substring(this.appq.lastIndexOf("/"));
                if (!TextUtils.isEmpty(this.appl) && !this.appl.substring(this.appl.lastIndexOf("/")).equals(substring)) {
                    File file = new File(this.appl);
                    if (file.exists()) {
                        appa.appa.appf.appd.appa("ApiWMSplashView", "delete video file from disk cache:" + file.getAbsolutePath());
                        file.delete();
                    }
                }
            }
            if (this.appj != null) {
                this.f46652a = this.appj.getCurrentPosition();
                this.appj.stop();
                this.appj.release();
                this.appj = null;
                appa.appa.appf.appd.appa("ApiWMSplashView", "销毁播放器，释放资源");
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appa("ApiWMSplashView", "destroyPlayer：" + th.toString());
        }
        this.apps = true;
    }

    public void appa(SurfaceHolder surfaceHolder, String str) {
        try {
            appd();
            this.appj = new MediaPlayer();
            this.appj.setVolume(0.0f, 0.0f);
            this.appj.setOnPreparedListener(new appf());
            this.appj.setOnErrorListener(new appg());
            this.appj.setDisplay(surfaceHolder);
            try {
                this.appj.reset();
                this.appj.setDataSource(str);
                this.appj.prepareAsync();
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("ApiWMSplashView", "视频播放错误");
                appa.appa.appf.appd.appe("ApiWMSplashView", "IPA.MW Splash playVideo:" + th.toString());
                if (this.appk != null) {
                    this.appk.appa("IPA.MW Splash 视频加载出错:" + th.toString());
                }
                appa();
            }
        } catch (Throwable th2) {
            appa.appa.appf.appd.appe("ApiWMSplashView", "IPA.MW Splash playVideo:" + th2.toString());
            appq appqVar = this.appk;
            if (appqVar != null) {
                appqVar.appa("IPA.MW Splash 视频播放异常：" + th2.toString());
            }
        }
    }
}
