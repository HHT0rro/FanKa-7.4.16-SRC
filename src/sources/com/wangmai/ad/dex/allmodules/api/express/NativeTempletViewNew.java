package com.wangmai.ad.dex.allmodules.api.express;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wangmai.ad.dex.allmodules.R$id;
import com.wangmai.ad.dex.allmodules.R$layout;
import com.wangmai.ad.dex.allmodules.R$mipmap;
import com.wangmai.ad.dex.allmodules.api.express.appc;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.ad.dex.allmodules.utils.appt;
import com.wangmai.ad.dex.allmodules.utils.appw;
import com.wangmai.ad.dex.allmodules.utils.appy;
import com.wangmai.appsdkdex.WMDexAdHelper;
import com.wangmai.appsdkdex.utils.VisibilityUtils;
import com.wangmai.common.utils.Utils;
import com.wangmai.common.utils.WMResources;
import com.wangmai.common.view.CustomVideoView2;
import com.wangmai.common.view.CustomWebView;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.callback.BitmapCallback;
import com.wangmai.okhttp.model.Response;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class NativeTempletViewNew extends FrameLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private appt f46489a;

    /* renamed from: appa, reason: collision with root package name */
    private String f46490appa;
    private boolean appb;
    private long appc;
    private View appd;
    private boolean appe;
    RelativeLayout appf;
    LinearLayout appg;
    ImageView apph;
    ImageView appi;
    ImageView appj;
    RelativeLayout appk;
    CustomVideoView2 appl;
    ImageView appm;
    ImageView appn;
    ImageView appo;
    ImageView appp;
    RelativeLayout appq;
    CustomWebView appr;
    TextView apps;
    TextView appt;
    ImageView appu;
    ImageView appv;
    TextView appw;
    TextView appx;
    private final ApiBean appy;
    private appw appz;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Activity> f46491b;

    /* renamed from: c, reason: collision with root package name */
    private VisibilityUtils.ViewVisibilityChangeListener f46492c;

    /* renamed from: d, reason: collision with root package name */
    private appc.appf f46493d;

    /* renamed from: e, reason: collision with root package name */
    private com.wangmai.ad.dex.allmodules.api.express.appa f46494e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f46495f;

    /* renamed from: g, reason: collision with root package name */
    private Bitmap f46496g;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f46497h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f46498i;

    /* renamed from: j, reason: collision with root package name */
    private Bitmap f46499j;

    /* renamed from: k, reason: collision with root package name */
    private int f46500k;

    /* renamed from: l, reason: collision with root package name */
    private Application.ActivityLifecycleCallbacks f46501l;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appa implements View.OnTouchListener {
        appa() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                NativeTempletViewNew.this.appc = motionEvent.getEventTime();
                appa.appa.appf.appd.appa("NativeTempletViewNew", "touchBack:ACTION_DOWN ");
            } else if (action == 1) {
                long eventTime = motionEvent.getEventTime() - NativeTempletViewNew.this.appc;
                appa.appa.appf.appd.appa("NativeTempletViewNew", "touchBack: ACTION_UP" + eventTime);
                if (eventTime <= 150) {
                    appa.appa.appf.appd.appa("NativeTempletViewNew", "touchBack: ACTION_Click");
                    if (NativeTempletViewNew.this.f46493d != null) {
                        NativeTempletViewNew.this.f46493d.appa(motionEvent);
                    }
                }
            }
            return true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appb implements DownloadListener {
        appb() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
            if (TextUtils.isEmpty(str) || !NativeTempletViewNew.this.appb("onDownloadStart")) {
                return;
            }
            com.wangmai.ad.dex.allmodules.utils.appf.appa(NativeTempletViewNew.this.getApplicationContext(), str, str2, str3, str4, j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appc implements appw.appa {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ float f46504appa;

        appc(float f10) {
            this.f46504appa = f10;
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appw.appa
        public void appa(int i10, float f10, float f11, float f12) {
            try {
                if (f12 < this.f46504appa || NativeTempletViewNew.this.f46493d == null) {
                    return;
                }
                NativeTempletViewNew.this.f46493d.appc();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appd implements appt.appa {
        appd() {
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appt.appa
        public void appa() {
            if (NativeTempletViewNew.this.f46493d != null) {
                NativeTempletViewNew.this.f46493d.appa();
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
            if (NativeTempletViewNew.this.appl.isVolumeOff()) {
                NativeTempletViewNew.this.appl.setVolume(1);
                NativeTempletViewNew.this.appp.setBackgroundResource(R$mipmap.wm_native_volume_on);
            } else {
                NativeTempletViewNew.this.appl.setVolume(0);
                NativeTempletViewNew.this.appp.setBackgroundResource(R$mipmap.wm_native_volume_off);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appf implements VisibilityUtils.ViewVisibilityChangeListener {
        appf() {
        }

        @Override // com.wangmai.appsdkdex.utils.VisibilityUtils.ViewVisibilityChangeListener
        public void invisible() {
            if (NativeTempletViewNew.this.f46489a != null) {
                NativeTempletViewNew.this.f46489a.appc();
            }
            if (NativeTempletViewNew.this.f46492c != null) {
                NativeTempletViewNew.this.f46492c.invisible();
            }
        }

        @Override // com.wangmai.appsdkdex.utils.VisibilityUtils.ViewVisibilityChangeListener
        public void visible() {
            if (NativeTempletViewNew.this.f46489a != null) {
                NativeTempletViewNew.this.f46489a.appe();
            }
            if (NativeTempletViewNew.this.f46492c != null) {
                NativeTempletViewNew.this.f46492c.visible();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appg implements Application.ActivityLifecycleCallbacks {
        appg() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            try {
                if (NativeTempletViewNew.this.getTaskTopActivity() != null && NativeTempletViewNew.this.getTaskTopActivity() == activity && NativeTempletViewNew.this.appb) {
                    NativeTempletViewNew.this.appo.performClick();
                }
                NativeTempletViewNew.this.f46491b = new WeakReference(activity);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("NativeTempletViewNew", "onActivityResumed:" + th.toString());
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class apph implements View.OnClickListener {
        apph() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NativeTempletViewNew.this.f46493d != null) {
                NativeTempletViewNew.this.f46493d.onClick();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appi implements View.OnClickListener {
        appi() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NativeTempletViewNew.this.f46493d != null) {
                NativeTempletViewNew.this.f46493d.appd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appj implements View.OnClickListener {
        appj() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (NativeTempletViewNew.this.appl == null || !NativeTempletViewNew.this.appa("imageVideoPlay")) {
                    return;
                }
                NativeTempletViewNew.this.appb = true;
                NativeTempletViewNew.this.appl.setVisibility(0);
                NativeTempletViewNew.this.appp.setVisibility(0);
                NativeTempletViewNew.this.appo.setVisibility(8);
                NativeTempletViewNew.this.appm.setVisibility(8);
                NativeTempletViewNew.this.appn.setVisibility(8);
                NativeTempletViewNew.this.appl.startVideo();
                NativeTempletViewNew.this.appl.seekTo(NativeTempletViewNew.this.f46500k);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("NativeTempletViewNew", "imageVideoPlay click error:" + th.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appk extends BitmapCallback {
        appk() {
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<Bitmap> response) {
            if (response != null) {
                NativeTempletViewNew.this.appv.setVisibility(0);
                NativeTempletViewNew.this.appv.setImageBitmap(response.body());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appl extends ClickableSpan {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ ApiBean.DownloadAppInfo f46513appa;

        appl(ApiBean.DownloadAppInfo downloadAppInfo) {
            this.f46513appa = downloadAppInfo;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            com.wangmai.ad.dex.allmodules.utils.appf.appc(NativeTempletViewNew.this.getApplicationContext(), this.f46513appa.getPrivacy());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appm extends ClickableSpan {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46514appa;
        final /* synthetic */ String appb;

        appm(String str, String str2) {
            this.f46514appa = str;
            this.appb = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.f46514appa)) {
                com.wangmai.ad.dex.allmodules.utils.appf.appc(NativeTempletViewNew.this.getApplicationContext(), this.f46514appa);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<html>");
            stringBuffer.append("<head><style>body{margin:0;padding:50 15 30 15;font-size:38;color:#666666}div{font-size:50;padding-bottom:30;color:#333333;font-weight:bold}</style></head>");
            stringBuffer.append("<body>");
            stringBuffer.append("<center><div>功能介绍</div></center>");
            stringBuffer.append(this.appb);
            stringBuffer.append("</body></html>");
            com.wangmai.ad.dex.allmodules.utils.appf.appc(NativeTempletViewNew.this.getApplicationContext(), "wmText://" + ((Object) stringBuffer));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appn extends ClickableSpan {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46515appa;
        final /* synthetic */ List appb;

        appn(String str, List list) {
            this.f46515appa = str;
            this.appb = list;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.f46515appa)) {
                com.wangmai.ad.dex.allmodules.utils.appf.appc(NativeTempletViewNew.this.getApplicationContext(), this.f46515appa);
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
            com.wangmai.ad.dex.allmodules.utils.appf.appc(NativeTempletViewNew.this.getApplicationContext(), "wmText://" + ((Object) stringBuffer));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appo extends BitmapCallback {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ ImageView f46516appa;

        appo(ImageView imageView) {
            this.f46516appa = imageView;
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<Bitmap> response) {
            if (response != null) {
                this.f46516appa.setVisibility(0);
                ImageView imageView = this.f46516appa;
                NativeTempletViewNew nativeTempletViewNew = NativeTempletViewNew.this;
                if (imageView == nativeTempletViewNew.apph) {
                    nativeTempletViewNew.f46495f = response.body();
                    this.f46516appa.setImageBitmap(NativeTempletViewNew.this.f46495f);
                } else if (imageView == nativeTempletViewNew.appi) {
                    nativeTempletViewNew.f46496g = response.body();
                    this.f46516appa.setImageBitmap(NativeTempletViewNew.this.f46496g);
                } else if (imageView == nativeTempletViewNew.appj) {
                    nativeTempletViewNew.f46497h = response.body();
                    this.f46516appa.setImageBitmap(NativeTempletViewNew.this.f46497h);
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appp extends BitmapCallback {
        appp() {
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<Bitmap> response) {
            if (response != null) {
                try {
                    NativeTempletViewNew.this.f46498i = response.body();
                    NativeTempletViewNew.this.appm.setImageBitmap(NativeTempletViewNew.this.f46498i);
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe("NativeTempletViewNew", "setVideoPreImage error:" + th.toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appq implements MediaPlayer.OnCompletionListener {

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class appa extends BitmapCallback {
            appa() {
            }

            @Override // com.wangmai.okhttp.callback.Callback
            public void onSuccess(Response<Bitmap> response) {
                if (response != null) {
                    try {
                        NativeTempletViewNew.this.f46499j = response.body();
                        NativeTempletViewNew.this.appn.setVisibility(0);
                        NativeTempletViewNew.this.appn.setImageBitmap(NativeTempletViewNew.this.f46499j);
                    } catch (Throwable th) {
                        appa.appa.appf.appd.appe("NativeTempletViewNew", "设置后贴图片失败:" + th.toString());
                    }
                }
            }
        }

        appq() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                if (mediaPlayer.isPlaying()) {
                    return;
                }
                NativeTempletViewNew.this.appb = false;
                NativeTempletViewNew.this.f46500k = 0;
                NativeTempletViewNew.this.f46493d.appb();
                NativeTempletViewNew.this.appo.setVisibility(0);
                NativeTempletViewNew.this.appm.setVisibility(8);
                NativeTempletViewNew.this.appl.setVisibility(8);
                NativeTempletViewNew.this.appp.setVisibility(8);
                if (NativeTempletViewNew.this.f46499j == null || NativeTempletViewNew.this.f46499j.isRecycled()) {
                    if (!TextUtils.isEmpty(NativeTempletViewNew.this.f46490appa)) {
                        OkHttp.get(NativeTempletViewNew.this.f46490appa).execute(new appa());
                    }
                } else {
                    NativeTempletViewNew.this.appn.setVisibility(0);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appr implements MediaPlayer.OnErrorListener {
        appr() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            appa.appa.appf.appd.appe("NativeTempletViewNew", "IPA.MW NativeTempletView MediaPlayer.OnErrorListener 视频流错误：" + i10 + "\t" + i11);
            if (NativeTempletViewNew.this.f46493d != null) {
                NativeTempletViewNew.this.f46493d.appa("视频流错误");
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class apps implements MediaPlayer.OnPreparedListener {
        apps() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                if (NativeTempletViewNew.this.appl.isVolumeOff()) {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                } else {
                    mediaPlayer.setVolume(8.0f, 8.0f);
                }
                if (NativeTempletViewNew.this.appl != null) {
                    NativeTempletViewNew.this.appl.setVisibility(0);
                    NativeTempletViewNew.this.appp.setVisibility(0);
                    NativeTempletViewNew.this.appo.setVisibility(8);
                    NativeTempletViewNew.this.appm.setVisibility(8);
                    NativeTempletViewNew.this.appn.setVisibility(8);
                    appa.appa.appf.appd.appa("NativeTempletViewNew", "onPrepared currentPosition:" + NativeTempletViewNew.this.f46500k);
                    NativeTempletViewNew.this.appl.startVideo();
                    NativeTempletViewNew.this.appl.seekTo(NativeTempletViewNew.this.f46500k);
                }
                NativeTempletViewNew.this.f46493d.start();
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("NativeTempletViewNew", "onPrepared exception:" + th.toString());
            }
        }
    }

    public NativeTempletViewNew(WeakReference<Activity> weakReference, ApiBean apiBean, VisibilityUtils.ViewVisibilityChangeListener viewVisibilityChangeListener) {
        super(weakReference.get().getApplicationContext());
        this.appe = false;
        this.f46501l = new appg();
        this.appy = apiBean;
        this.f46491b = new WeakReference<>(weakReference.get());
        this.f46492c = viewVisibilityChangeListener;
        appe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getApplicationContext() {
        try {
            if (this.f46491b == null || this.f46491b.get() == null) {
                this.f46491b = new WeakReference<>(WMDexAdHelper.getTopActivity().get());
            }
            return this.f46491b.get().getApplicationContext();
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("NativeTempletViewNew", "getApplicationContext：" + th.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getTaskTopActivity() {
        try {
            if (this.f46491b == null || this.f46491b.get() == null || this.f46491b.get().isFinishing()) {
                this.f46491b = new WeakReference<>(WMDexAdHelper.getTopActivity().get());
            }
            return this.f46491b.get();
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("NativeTempletViewNew", "getTaskTopActivity：" + th.toString());
            return null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        appw appwVar = this.appz;
        if (appwVar != null) {
            appwVar.appa(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            appa.appa.appf.appd.appa("NativeTempletViewNew", "onAttachedToWindow");
            this.f46491b = new WeakReference<>(WMDexAdHelper.getTopActivity().get());
            if (this.appy != null && this.appy.getOptimization() != null && this.appy.getOptimization().getInteractiveObjs() != null) {
                setInteractionType(this.appy.getOptimization().getInteractiveObjs());
            }
            if (this.f46489a != null) {
                this.f46489a.appd();
            }
            VisibilityUtils.getInstance().addVisibleChangedListener(this, new appf());
            appb();
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("NativeTempletViewNew", "IPA.MW NativeTempletView onAttachedToWindow:" + th.toString());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        appc.appf appfVar = this.f46493d;
        if (appfVar != null) {
            appfVar.onClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            appa.appa.appf.appd.appa("NativeTempletViewNew", "onDetachedFromWindow");
            if (this.f46489a != null) {
                this.f46489a.appa();
                this.f46489a = null;
            }
            if (this.appz != null) {
                this.appz.appa();
                this.appz = null;
            }
            if (this.f46494e != null) {
                this.f46494e.appa();
                this.f46494e = null;
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("NativeTempletViewNew", "IPA.MW NativeTempletView onDetachedFromWindow:" + th.toString());
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            motionEvent.getX();
            motionEvent.getY();
            motionEvent.getX();
            motionEvent.getY();
        }
        appw appwVar = this.appz;
        if (appwVar != null) {
            appwVar.appa(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            motionEvent.getX();
            motionEvent.getY();
            motionEvent.getX();
            motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c6 A[Catch: all -> 0x00ee, TryCatch #0 {all -> 0x00ee, blocks: (B:4:0x0003, B:6:0x0037, B:7:0x003f, B:9:0x0045, B:10:0x004d, B:12:0x0053, B:13:0x005b, B:15:0x0064, B:16:0x0079, B:18:0x007f, B:22:0x009b, B:25:0x00a3, B:27:0x00bc, B:29:0x00c6, B:31:0x00d1, B:33:0x00d8, B:35:0x00df, B:36:0x00e4, B:40:0x00a9, B:41:0x0088), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d1 A[Catch: all -> 0x00ee, TryCatch #0 {all -> 0x00ee, blocks: (B:4:0x0003, B:6:0x0037, B:7:0x003f, B:9:0x0045, B:10:0x004d, B:12:0x0053, B:13:0x005b, B:15:0x0064, B:16:0x0079, B:18:0x007f, B:22:0x009b, B:25:0x00a3, B:27:0x00bc, B:29:0x00c6, B:31:0x00d1, B:33:0x00d8, B:35:0x00df, B:36:0x00e4, B:40:0x00a9, B:41:0x0088), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d8 A[Catch: all -> 0x00ee, TryCatch #0 {all -> 0x00ee, blocks: (B:4:0x0003, B:6:0x0037, B:7:0x003f, B:9:0x0045, B:10:0x004d, B:12:0x0053, B:13:0x005b, B:15:0x0064, B:16:0x0079, B:18:0x007f, B:22:0x009b, B:25:0x00a3, B:27:0x00bc, B:29:0x00c6, B:31:0x00d1, B:33:0x00d8, B:35:0x00df, B:36:0x00e4, B:40:0x00a9, B:41:0x0088), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00df A[Catch: all -> 0x00ee, TryCatch #0 {all -> 0x00ee, blocks: (B:4:0x0003, B:6:0x0037, B:7:0x003f, B:9:0x0045, B:10:0x004d, B:12:0x0053, B:13:0x005b, B:15:0x0064, B:16:0x0079, B:18:0x007f, B:22:0x009b, B:25:0x00a3, B:27:0x00bc, B:29:0x00c6, B:31:0x00d1, B:33:0x00d8, B:35:0x00df, B:36:0x00e4, B:40:0x00a9, B:41:0x0088), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setDownLoadInfo(com.wangmai.ad.dex.allmodules.bean.ApiBean.DownloadAppInfo r12) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.ad.dex.allmodules.api.express.NativeTempletViewNew.setDownLoadInfo(com.wangmai.ad.dex.allmodules.bean.ApiBean$DownloadAppInfo):void");
    }

    public void setImage(List<String> list) {
        if (list != null) {
            try {
                this.appg.setVisibility(0);
                appa(list.get(0), this.apph);
                if (list.size() == 2) {
                    this.appi.setVisibility(0);
                    appa(list.get(1), this.appi);
                }
                if (list.size() == 3) {
                    this.appi.setVisibility(0);
                    appa(list.get(1), this.appi);
                    this.appj.setVisibility(0);
                    appa(list.get(2), this.appj);
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("NativeTempletViewNew", "IPA.MW NativeTempletView setImage:" + th.toString());
            }
        }
    }

    public void setInteractionType(List<ApiBean.InteractiveObj> list) {
        try {
            if (this.appd == null || list == null || list.isEmpty()) {
                return;
            }
            this.f46494e = new com.wangmai.ad.dex.allmodules.api.express.appa(getApplicationContext(), this.appd);
            for (ApiBean.InteractiveObj interactiveObj : list) {
                int intValue = interactiveObj.getType().intValue();
                if (intValue == 1) {
                    appa.appa.appf.appd.appa("NativeTempletViewNew", "API 信息流模板交互类型：摇一摇");
                    this.f46494e.appb();
                    if (this.f46489a == null && appb("setInteractionType ShakeUtils")) {
                        this.f46489a = new appt((SensorManager) getApplicationContext().getSystemService("sensor"), Utils.parseInt(interactiveObj.getData()), new appd());
                    }
                } else if (intValue == 2) {
                    appa.appa.appf.appd.appa("NativeTempletViewNew", "API 信息流模板交互类型：滑动");
                    this.f46494e.appc();
                    if (this.appz == null && appb("setInteractionType SwipeUtils")) {
                        this.appz = new appw(getApplicationContext(), new appc((Math.min(Utils.getWindowWidth(getContext()), Utils.getWindowHeight(getApplicationContext())) * Utils.parseInt(interactiveObj.getData())) / 100.0f));
                    }
                }
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("NativeTempletViewNew", "setInteractionType error" + th.toString());
        }
    }

    public void setListener(appc.appf appfVar) {
        this.f46493d = appfVar;
    }

    public void setVideo(String str) {
        try {
            String appb2 = appb(str, com.wangmai.ad.dex.allmodules.utils.appq.appd().appc().getAbsolutePath());
            if (!TextUtils.isEmpty(appb2)) {
                appc(appb2);
            } else {
                appa.appa.appf.appd.appe("NativeTempletViewNew", "IPA.MW NativeTempletView 视频路径错误");
                this.f46493d.appa("视频路径错误");
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("NativeTempletViewNew", "IPA.MW NativeTempletView setVideo:" + th.toString());
        }
    }

    public void setWebContent(String str) {
        try {
            this.appq.setVisibility(0);
            WebSettings settings = this.appr.getSettings();
            settings.setLoadsImagesAutomatically(true);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setBuiltInZoomControls(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            this.appr.setHorizontalScrollBarEnabled(false);
            this.appr.setVerticalScrollBarEnabled(false);
            appa.appa.appf.appd.appa("NativeTempletViewNew", "htmlData---------- " + str);
            if (str.startsWith("<html>")) {
                this.appr.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
            } else {
                String str2 = "<html><head><style>* body{font-size:15px;margin:0;padding:0}{color:#212121;}img{max-width: 100%; width:auto; height: auto;}</style></head><body>" + str + "</body></html>";
                this.appr.loadDataWithBaseURL(null, str2, "text/html", "utf-8", null);
                appa.appa.appf.appd.appa("NativeTempletViewNew", "resultStr---------- " + str2);
            }
            this.appr.setOnTouchListener(new appa());
            this.appr.setDownloadListener(new appb());
            if (appb("setWebViewClient")) {
                this.appr.setWebViewClient(new appy(getApplicationContext(), "NativeTempletViewNew"));
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("NativeTempletViewNew", "IPA.MW NativeTempletView setWebEndImage:" + th.toString());
        }
    }

    private void appf() {
        try {
            if (this.f46495f != null && !this.f46495f.isRecycled()) {
                this.f46495f.recycle();
                this.f46495f = null;
            }
            if (this.f46496g != null && !this.f46496g.isRecycled()) {
                this.f46496g.recycle();
                this.f46496g = null;
            }
            if (this.f46497h != null && !this.f46497h.isRecycled()) {
                this.f46497h.recycle();
                this.f46497h = null;
            }
            if (this.f46498i != null && !this.f46498i.isRecycled()) {
                this.f46498i.recycle();
                this.f46498i = null;
            }
            if (this.f46499j == null || this.f46499j.isRecycled()) {
                return;
            }
            this.f46499j.recycle();
            this.f46499j = null;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("NativeTempletViewNew", "recycleBitmap error:" + th.toString());
        }
    }

    private void appg() {
        try {
            if (this.appl != null) {
                this.appl.pause();
                this.appl.stopPlayback();
                appa.appa.appf.appb.appb(this.appl);
                appa.appa.appf.appb.appa(this.appl);
                this.appl.destroyDrawingCache();
                this.appl = null;
            }
            if (this.apph != null) {
                appa.appa.appf.appb.appa(this.apph);
                this.apph.destroyDrawingCache();
                this.apph = null;
            }
            if (this.appi != null) {
                appa.appa.appf.appb.appa(this.appi);
                this.appi.destroyDrawingCache();
                this.appi = null;
            }
            if (this.appj != null) {
                appa.appa.appf.appb.appa(this.appj);
                this.appj.destroyDrawingCache();
                this.appj = null;
            }
            if (this.appn != null) {
                appa.appa.appf.appb.appa(this.appn);
                this.appn.destroyDrawingCache();
                this.appn = null;
            }
            if (this.appm != null) {
                this.appm.destroyDrawingCache();
                this.appm = null;
            }
            if (this.appo != null) {
                this.appo.setOnClickListener(null);
                this.appo = null;
            }
            if (this.appr != null) {
                appa.appa.appf.appb.appa(this.appr);
                appa.appa.appf.appb.appb(this.appr);
                this.appr.destroyDrawingCache();
                this.appr = null;
            }
            this.appd = null;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("NativeTempletViewNew", "releaseView error:" + th.toString());
        }
    }

    private void apph() {
        try {
            String icon_src = this.appy.getRespObj().getWxad().getIcon_src();
            if (!TextUtils.isEmpty(icon_src)) {
                if (icon_src.contains(";")) {
                    icon_src = icon_src.substring(0, icon_src.indexOf(";"));
                }
            } else if (this.appy.getRespObj().getWxad().getDownload_app_info() != null) {
                icon_src = this.appy.getRespObj().getWxad().getDownload_app_info().getIcon_url();
            }
            if (TextUtils.isEmpty(icon_src)) {
                return;
            }
            OkHttp.get(icon_src).execute(new appk());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("NativeTempletViewNew", "IPA.MW setAppIcon error:" + th.toString());
        }
    }

    private void appi() {
        if (this.appy.getRespObj().getWxad().getCreative_type() != 5) {
            String description = this.appy.getRespObj().getWxad().getDescription();
            if (TextUtils.isEmpty(description)) {
                return;
            }
            this.appt.setVisibility(0);
            this.appt.setText(description);
        }
    }

    private void appj() {
        String ad_title = this.appy.getRespObj().getWxad().getAd_title();
        if (TextUtils.isEmpty(ad_title)) {
            ad_title = this.appy.getRespObj().getWxad().getBrand_name();
        }
        if (TextUtils.isEmpty(ad_title) && this.appy.getRespObj().getWxad().getDownload_app_info() != null) {
            ad_title = this.appy.getRespObj().getWxad().getDownload_app_info().getApp_name();
        }
        if (TextUtils.isEmpty(ad_title)) {
            return;
        }
        this.apps.setVisibility(0);
        this.apps.setText(ad_title);
    }

    private void appc(String str) {
        try {
            if (this.appl == null) {
                this.appl = (CustomVideoView2) findViewById(R$id.wm_video_native);
            }
            this.appl.setVolume(0);
            this.appl.setVisibility(0);
            this.appp.setVisibility(0);
            this.appp.setOnClickListener(new appe());
            if (!TextUtils.isEmpty(str)) {
                if (appa("playVideo")) {
                    this.appl.setOnCompletionListener(new appq());
                    this.appl.setOnPreparedListener(new apps());
                    this.appl.setOnErrorListener(new appr());
                    this.appl.setVideoPath(str);
                    return;
                }
                return;
            }
            appa.appa.appf.appd.appe("NativeTempletViewNew", "IPA.MW NativeTempletView 视频初始化错误");
            this.f46493d.appa("视频初始化异常");
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("NativeTempletViewNew", "IPA.MW NativeTempletView 视频格式错误：" + th.toString());
            this.f46493d.appa(th.toString());
            appa();
        }
    }

    private void appe() {
        try {
            removeAllViews();
            int interaction_type = this.appy.getRespObj().getWxad().getInteraction_type();
            if (interaction_type != 2 && interaction_type != 3 && interaction_type != 5) {
                this.appd = LayoutInflater.from(appa.appa.appf.appa.appa(getApplicationContext(), WMResources.resources)).inflate(R$layout.wm_native_express_normal_templet, this);
                this.appf = (RelativeLayout) this.appd.findViewById(R$id.wm_native_express);
            } else {
                this.appd = LayoutInflater.from(appa.appa.appf.appa.appa(getApplicationContext(), WMResources.resources)).inflate(R$layout.wm_native_express_dwonload_templet, this);
                this.appf = (RelativeLayout) this.appd.findViewById(R$id.wm_native_express);
                this.appv = (ImageView) this.appf.findViewById(R$id.iv_app_icon);
                this.appw = (TextView) this.appf.findViewById(R$id.tv_download);
                this.appx = (TextView) this.appf.findViewById(R$id.tv_app_info);
                apph();
                setDownLoadInfo(this.appy.getRespObj().getWxad().getDownload_app_info());
                this.appw.setOnClickListener(new apph());
            }
            this.appg = (LinearLayout) this.appf.findViewById(R$id.wm_layout_pic);
            this.apph = (ImageView) this.appf.findViewById(R$id.wm_iv_pic_one);
            this.appi = (ImageView) this.appf.findViewById(R$id.wm_iv_pic_two);
            this.appj = (ImageView) this.appf.findViewById(R$id.wm_iv_pic_three);
            this.appk = (RelativeLayout) this.appf.findViewById(R$id.wm_layout_native_video);
            this.appl = (CustomVideoView2) this.appf.findViewById(R$id.wm_video_native);
            this.appm = (ImageView) this.appf.findViewById(R$id.wm_iv_video_pre);
            this.appn = (ImageView) this.appf.findViewById(R$id.wm_iv_video_end);
            this.appo = (ImageView) this.appf.findViewById(R$id.wm_iv_video_play);
            this.appp = (ImageView) this.appf.findViewById(R$id.wm_iv_volume);
            this.appq = (RelativeLayout) this.appf.findViewById(R$id.wm_layout_web);
            this.appr = (CustomWebView) this.appf.findViewById(R$id.wm_webview_native);
            this.apps = (TextView) this.appf.findViewById(R$id.tv_app_name);
            this.appt = (TextView) this.appf.findViewById(R$id.tv_app_desc);
            this.appu = (ImageView) this.appf.findViewById(R$id.iv_native_express_close);
            appj();
            appi();
            this.appu.setOnClickListener(new appi());
            this.appo.setOnClickListener(new appj());
            this.appd.setOnClickListener(this);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("NativeTempletViewNew", "IPA.MW NativeTempletView initView:" + th.toString());
        }
    }

    void appd() {
        if (appa("unregisterActivityLifecycleCallbacks")) {
            appa.appa.appf.appd.appa("NativeTempletViewNew", "IPA.MW NativeTempletView unregisterActivityLifecycleCallbacks ：" + ((Object) getTaskTopActivity()) + "\t" + getTaskTopActivity().isFinishing());
            getTaskTopActivity().getApplication().unregisterActivityLifecycleCallbacks(this.f46501l);
            this.appe = false;
        }
    }

    private String appb(String str, String str2) {
        try {
            File[] listFiles = new File(str2).listFiles();
            if (listFiles != null && listFiles.length != 0) {
                String str3 = Utils.md5Decode(str) + str.substring(str.lastIndexOf("."));
                for (File file : listFiles) {
                    if (file.getAbsolutePath().contains(str3)) {
                        return file.getAbsolutePath();
                    }
                }
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private void appa(String str, ImageView imageView) {
        try {
            OkHttp.get(str).execute(new appo(imageView));
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("NativeTempletViewNew", "IPA.MW NativeTempletView updateImageBit:" + th.toString());
        }
    }

    public void appa(String str, String str2) {
        try {
            this.f46490appa = str2;
            this.appk.setVisibility(0);
            this.appm.setVisibility(0);
            this.appo.setVisibility(0);
            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                str = str2;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            OkHttp.get(str).execute(new appp());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("NativeTempletViewNew", "IPA.MW NativeTempletView setVideoEndImage：" + th.toString());
        }
    }

    void appb() {
        if (!appa("registerActivityLifecycleCallbacks") || this.appe) {
            return;
        }
        appa.appa.appf.appd.appa("NativeTempletViewNew", "IPA.MW NativeTempletView registerActivityLifecycleCallbacks ：" + ((Object) getTaskTopActivity()) + "\t" + getTaskTopActivity().isFinishing());
        getTaskTopActivity().getApplication().registerActivityLifecycleCallbacks(this.f46501l);
        this.appe = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean appb(String str) {
        if (getApplicationContext() != null) {
            return true;
        }
        appa.appa.appf.appd.appe("NativeTempletViewNew", str + " ApplicationContext is null");
        return false;
    }

    public void appa(boolean z10) {
        try {
            if (this.f46494e != null) {
                this.f46494e.appa(z10);
            }
            if (this.f46489a != null) {
                if (!z10) {
                    this.f46489a.appc();
                } else {
                    this.f46489a.appe();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void appc() {
        try {
            if (this.appl == null || !this.appl.isPlaying()) {
                return;
            }
            this.appl.pause();
            this.f46500k = this.appl.getCurrentPosition();
            this.appm.setVisibility(0);
            this.appo.setVisibility(0);
            this.appl.setVisibility(8);
            this.appp.setVisibility(8);
            this.appn.setVisibility(8);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void appa() {
        try {
            appg();
            appf();
            this.f46492c = null;
            this.f46493d = null;
            appd();
            this.f46501l = null;
            if (this.f46491b != null) {
                appa.appa.appf.appd.appe("NativeTempletViewNew", "回收activityWeakReference");
                this.f46491b.clear();
            }
            removeAllViews();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean appa(String str) {
        if (getTaskTopActivity() != null && !getTaskTopActivity().isFinishing()) {
            return true;
        }
        appa.appa.appf.appd.appe("NativeTempletViewNew", str + " mActivity is null or finishing");
        return false;
    }
}
