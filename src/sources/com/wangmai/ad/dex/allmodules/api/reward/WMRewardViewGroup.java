package com.wangmai.ad.dex.allmodules.api.reward;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.wangmai.ad.dex.allmodules.R$id;
import com.wangmai.ad.dex.allmodules.R$layout;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.ad.dex.allmodules.bean.ProgressTrackingBean;
import com.wangmai.ad.dex.allmodules.view.WMBaseViewGroup;
import com.wangmai.appsdkdex.utils.VisibilityUtils;
import com.wangmai.common.WMAdActListener;
import com.wangmai.common.utils.ConstantInfo;
import com.wangmai.common.utils.GsonUtils;
import com.wangmai.common.utils.SharedPreferencesHelper;
import com.wangmai.common.utils.WMResources;
import com.wangmai.common.view.CustomVideoView2;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.callback.BitmapCallback;
import com.wangmai.okhttp.model.Response;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class WMRewardViewGroup extends WMBaseViewGroup implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, WMAdActListener, com.wangmai.ad.dex.allmodules.appf.appa {

    /* renamed from: n, reason: collision with root package name */
    private static String f46618n = "WMRewardViewGroup";

    /* renamed from: a, reason: collision with root package name */
    private boolean f46619a;
    public float appb;
    public float appc;
    public float appd;
    public float appe;
    private View appf;
    private CustomVideoView2 appg;
    private TextView apph;
    private TextView appi;
    private LinearLayout appj;
    private ImageView appk;
    private TextView appl;
    private TextView appm;
    private Button appn;
    private TextView appo;
    private ProgressBar appp;
    private boolean appq;
    private int appr;
    private ApiBean apps;
    private int appt;
    int appu;
    private Context appv;
    private com.wangmai.ad.dex.allmodules.appf.appd appw;
    private int appx;
    private int appy;
    private int appz;

    /* renamed from: b, reason: collision with root package name */
    private boolean f46620b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f46621c;

    /* renamed from: d, reason: collision with root package name */
    private int f46622d;

    /* renamed from: e, reason: collision with root package name */
    private List<ProgressTrackingBean> f46623e;

    /* renamed from: f, reason: collision with root package name */
    private String f46624f;

    /* renamed from: g, reason: collision with root package name */
    private String f46625g;

    /* renamed from: h, reason: collision with root package name */
    private String f46626h;

    /* renamed from: i, reason: collision with root package name */
    private String f46627i;

    /* renamed from: j, reason: collision with root package name */
    private String f46628j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f46629k;

    /* renamed from: l, reason: collision with root package name */
    private Runnable f46630l;

    /* renamed from: m, reason: collision with root package name */
    private Handler f46631m;

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
            if (WMRewardViewGroup.this.f46620b) {
                appa.appa.appf.appd.appa(WMRewardViewGroup.f46618n, "激励视频容器可见，曝光回调已处理");
            } else {
                WMRewardViewGroup.this.f46620b = true;
                WMRewardViewGroup.this.appf();
                WMRewardViewGroup.this.appw.appa(WMRewardViewGroup.this.appv);
            }
            if (!WMRewardViewGroup.this.appq || WMRewardViewGroup.this.appg == null || WMRewardViewGroup.this.appg.isPlaying()) {
                return;
            }
            WMRewardViewGroup.this.resume();
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
                WMRewardViewGroup.this.appk.setImageBitmap(response.body());
            }
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
            appa.appa.appf.appd.appa(WMRewardViewGroup.f46618n, "用户点击关闭");
            WMRewardViewGroup.this.appw.onAdClose();
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
            appa.appa.appf.appd.appa(WMRewardViewGroup.f46618n, "用户点击交互按钮");
            WMRewardViewGroup.this.appa(false, com.wangmai.ad.dex.allmodules.utils.appf.appl);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appe implements View.OnTouchListener {
        appe() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                try {
                    if (WMRewardViewGroup.this.appg != null && WMRewardViewGroup.this.appg.isPlaying()) {
                        WMRewardViewGroup.this.appr = WMRewardViewGroup.this.appg.getCurrentPosition();
                        appa.appa.appf.appd.appa(WMRewardViewGroup.f46618n, "api reward OnTouch,video currentPosition " + WMRewardViewGroup.this.appr);
                        if (!TextUtils.isEmpty(WMRewardViewGroup.this.f46628j) && WMRewardViewGroup.this.apps.getRespObj().getWxad().getInteraction_type() != 2) {
                            WMRewardViewGroup.this.appg.pause();
                        }
                    }
                    WMRewardViewGroup.this.appb = motionEvent.getX();
                    WMRewardViewGroup.this.appc = motionEvent.getY();
                    WMRewardViewGroup.this.appd = motionEvent.getX();
                    WMRewardViewGroup.this.appe = motionEvent.getY();
                    ConstantInfo.downX = WMRewardViewGroup.this.appb;
                    ConstantInfo.downY = WMRewardViewGroup.this.appc;
                    appa.appa.appf.appd.appa(WMRewardViewGroup.f46618n, "API 激励视频点击", Double.valueOf(ConstantInfo.downX), Double.valueOf(ConstantInfo.downY));
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe(WMRewardViewGroup.f46618n, "API 激励视频点击预处理错误：" + th);
                }
                WMRewardViewGroup.this.appa(true, com.wangmai.ad.dex.allmodules.utils.appf.appl);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appf extends ClickableSpan {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ ApiBean.DownloadAppInfo f46637appa;

        appf(ApiBean.DownloadAppInfo downloadAppInfo) {
            this.f46637appa = downloadAppInfo;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            com.wangmai.ad.dex.allmodules.utils.appf.appc(WMRewardViewGroup.this.appv, this.f46637appa.getPrivacy());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appg extends ClickableSpan {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46638appa;
        final /* synthetic */ String appb;

        appg(String str, String str2) {
            this.f46638appa = str;
            this.appb = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.f46638appa)) {
                com.wangmai.ad.dex.allmodules.utils.appf.appc(WMRewardViewGroup.this.appv, this.f46638appa);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<html>");
            stringBuffer.append("<head><style>body{margin:0;padding:50 15 30 15;font-size:38;color:#666666}div{font-size:50;padding-bottom:30;color:#333333;font-weight:bold}</style></head>");
            stringBuffer.append("<body>");
            stringBuffer.append("<center><div>功能介绍</div></center>");
            stringBuffer.append(this.appb);
            stringBuffer.append("</body></html>");
            com.wangmai.ad.dex.allmodules.utils.appf.appc(WMRewardViewGroup.this.appv, "wmText://" + ((Object) stringBuffer));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class apph extends ClickableSpan {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46639appa;
        final /* synthetic */ List appb;

        apph(String str, List list) {
            this.f46639appa = str;
            this.appb = list;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (!TextUtils.isEmpty(this.f46639appa)) {
                com.wangmai.ad.dex.allmodules.utils.appf.appc(WMRewardViewGroup.this.appv, this.f46639appa);
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
            com.wangmai.ad.dex.allmodules.utils.appf.appc(WMRewardViewGroup.this.appv, "wmText://" + ((Object) stringBuffer));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appi implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        private int f46640appa;

        appi() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int duration;
            try {
                if (WMRewardViewGroup.this.appg == null || !WMRewardViewGroup.this.appg.isPlaying() || (duration = WMRewardViewGroup.this.appg.getDuration()) <= 0) {
                    return;
                }
                WMRewardViewGroup.this.appr = WMRewardViewGroup.this.appg.getCurrentPosition();
                int i10 = (WMRewardViewGroup.this.appr * 1000) / duration;
                if (WMRewardViewGroup.this.f46622d != 0 && this.f46640appa != i10) {
                    this.f46640appa = i10;
                    WMRewardViewGroup.this.setProgressTrackingEvent(this.f46640appa);
                }
                WMRewardViewGroup.this.appi.setText(String.valueOf((duration - WMRewardViewGroup.this.appr) / 1000));
                WMRewardViewGroup.this.f46631m.postDelayed(this, 1000L);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe(WMRewardViewGroup.f46618n, "IPA.MW Reward update progress exception:" + th.toString());
            }
        }
    }

    public WMRewardViewGroup(Context context, ApiBean apiBean, int i10, int i11, com.wangmai.ad.dex.allmodules.appf.appd appdVar) {
        super(context);
        this.appb = -999.0f;
        this.appc = -999.0f;
        this.appd = -999.0f;
        this.appe = -999.0f;
        this.appt = 1;
        this.appu = 0;
        this.f46619a = false;
        this.f46620b = false;
        this.f46621c = true;
        this.f46629k = false;
        this.f46630l = new appi();
        this.f46631m = new Handler(Looper.getMainLooper());
        this.appv = context;
        this.apps = apiBean;
        this.appt = i10;
        this.appu = i11;
        this.appw = appdVar;
        appc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:14|15|(6:44|45|18|19|20|(2:22|(2:24|25)(1:27))(4:28|(2:34|(1:39)(2:36|(1:38)))|40|41))|17|18|19|20|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x005c, code lost:
    
        r7 = 0.0d;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005f A[Catch: all -> 0x0093, TRY_ENTER, TryCatch #0 {all -> 0x0093, blocks: (B:3:0x0004, B:5:0x0008, B:7:0x000c, B:10:0x0015, B:12:0x001d, B:14:0x0027, B:22:0x005f, B:24:0x0063, B:28:0x0069, B:34:0x0081, B:40:0x008a), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0069 A[Catch: all -> 0x0093, TryCatch #0 {all -> 0x0093, blocks: (B:3:0x0004, B:5:0x0008, B:7:0x000c, B:10:0x0015, B:12:0x001d, B:14:0x0027, B:22:0x005f, B:24:0x0063, B:28:0x0069, B:34:0x0081, B:40:0x008a), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setProgressTrackingEvent(int r18) {
        /*
            r17 = this;
            r1 = r17
            r2 = 0
            r3 = 1
            int r0 = com.wangmai.ad.dex.allmodules.utils.appf.appi     // Catch: java.lang.Throwable -> L93
            if (r0 != 0) goto Lb5
            java.util.List<com.wangmai.ad.dex.allmodules.bean.ProgressTrackingBean> r0 = r1.f46623e     // Catch: java.lang.Throwable -> L93
            if (r0 == 0) goto Lb5
            java.util.List<com.wangmai.ad.dex.allmodules.bean.ProgressTrackingBean> r0 = r1.f46623e     // Catch: java.lang.Throwable -> L93
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L93
            if (r0 <= 0) goto Lb5
            r0 = 0
        L15:
            java.util.List<com.wangmai.ad.dex.allmodules.bean.ProgressTrackingBean> r4 = r1.f46623e     // Catch: java.lang.Throwable -> L93
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L93
            if (r0 >= r4) goto Lb5
            java.util.List<com.wangmai.ad.dex.allmodules.bean.ProgressTrackingBean> r4 = r1.f46623e     // Catch: java.lang.Throwable -> L93
            java.lang.Object r4 = r4.get(r0)     // Catch: java.lang.Throwable -> L93
            com.wangmai.ad.dex.allmodules.bean.ProgressTrackingBean r4 = (com.wangmai.ad.dex.allmodules.bean.ProgressTrackingBean) r4     // Catch: java.lang.Throwable -> L93
            if (r4 == 0) goto L8e
            long r5 = r4.getMillisec()     // Catch: java.lang.Throwable -> L93
            java.text.DecimalFormat r7 = new java.text.DecimalFormat     // Catch: java.lang.Throwable -> L93
            java.lang.String r8 = "0.00"
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L93
            r8 = 0
            r10 = 0
            int r12 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r12 <= 0) goto L4b
            int r8 = r1.f46622d     // Catch: java.lang.Throwable -> L4b
            int r8 = r8 * 1000
            float r8 = (float) r8     // Catch: java.lang.Throwable -> L4b
            float r5 = (float) r5     // Catch: java.lang.Throwable -> L4b
            float r8 = r8 / r5
            double r5 = (double) r8     // Catch: java.lang.Throwable -> L4b
            java.lang.String r5 = r7.format(r5)     // Catch: java.lang.Throwable -> L4b
            double r5 = java.lang.Double.parseDouble(r5)     // Catch: java.lang.Throwable -> L4b
            goto L4c
        L4b:
            r5 = r10
        L4c:
            r8 = 1120403456(0x42c80000, float:100.0)
            r9 = r18
            float r13 = (float) r9
            float r8 = r8 / r13
            double r13 = (double) r8
            java.lang.String r7 = r7.format(r13)     // Catch: java.lang.Throwable -> L5c
            double r7 = java.lang.Double.parseDouble(r7)     // Catch: java.lang.Throwable -> L5c
            goto L5d
        L5c:
            r7 = r10
        L5d:
            if (r12 != 0) goto L69
            boolean r5 = r1.f46619a     // Catch: java.lang.Throwable -> L93
            if (r5 != 0) goto L90
            r1.f46619a = r3     // Catch: java.lang.Throwable -> L93
            setProgressTrackingUrl(r4)     // Catch: java.lang.Throwable -> L93
            goto L90
        L69:
            double r12 = r5 - r7
            int r14 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r14 == 0) goto L8a
            r10 = 4581421828931458171(0x3f947ae147ae147b, double:0.02)
            r14 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 <= 0) goto L81
            int r16 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r16 < 0) goto L8a
        L81:
            double r7 = r7 - r5
            int r5 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r5 <= 0) goto L90
            int r5 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r5 >= 0) goto L90
        L8a:
            setProgressTrackingUrl(r4)     // Catch: java.lang.Throwable -> L93
            goto L90
        L8e:
            r9 = r18
        L90:
            int r0 = r0 + 1
            goto L15
        L93:
            r0 = move-exception
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = com.wangmai.ad.dex.allmodules.api.reward.WMRewardViewGroup.f46618n
            r4[r2] = r5
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "IPA.MW Reward setProgressTrackingEvent exception:"
            r2.append(r5)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r4[r3] = r0
            appa.appa.appf.appd.appe(r4)
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.ad.dex.allmodules.api.reward.WMRewardViewGroup.setProgressTrackingEvent(int):void");
    }

    private static void setProgressTrackingUrl(ProgressTrackingBean progressTrackingBean) {
        try {
            List<String> url = progressTrackingBean.getUrl();
            appa.appa.appf.appd.appa(f46618n, "IPA.MW Reward 播放进度上报:" + GsonUtils.getInstance().toJson(url));
            com.wangmai.ad.dex.allmodules.utils.appf.appa(url, 0, false);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46618n, "IPA.MW Reward setProgressTrackingUrl exception:" + th.toString());
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
        CustomVideoView2 customVideoView2 = this.appg;
        if (customVideoView2 != null) {
            customVideoView2.pause();
        }
    }

    @Override // com.wangmai.common.WMAdActListener
    public Resources getAdResources() {
        return WMResources.resources;
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdCreate(Bundle bundle) {
    }

    @Override // com.wangmai.common.WMAdActListener
    public void onAdDestroy() {
        removeAllViews();
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
        try {
            appa.appa.appf.appd.appa(f46618n, "Api reward MediaPlayer onCompletion");
            apph();
            if (this.f46621c) {
                appa(false, com.wangmai.ad.dex.allmodules.utils.appf.appl);
            } else {
                if (mediaPlayer.isPlaying()) {
                    return;
                }
                this.appw.appa(true, null);
                this.appw.appa(this.f46624f, this.f46625g, this.f46626h, this.f46627i, this.f46628j, this.apps);
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46618n, "Api reward onCompletion:" + ((Object) th));
            com.wangmai.ad.dex.allmodules.utils.appf.appa(this.appv, "", "Api reward onCompletion error:" + Log.getStackTraceString(th));
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
        String str = i11 != -1010 ? i11 != -1007 ? i11 != -1004 ? i11 != -110 ? "UNKNOW" : "Some operation takes too long to complete, usually more than 3-5 seconds" : "File or network related operation errors" : "Bitstream is not conforming to the related coding standard or file spec" : "the media framework does not support the file";
        this.appp.setVisibility(8);
        appa.appa.appf.appd.appb(f46618n, "IPA.MW Reward：" + str);
        com.wangmai.ad.dex.allmodules.appf.appd appdVar = this.appw;
        if (appdVar != null) {
            appdVar.appa(str);
        }
        apph();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (z10) {
            int i14 = 0;
            for (int i15 = 0; i15 < this.appx; i15++) {
                getChildAt(i15).layout(i14, 0, this.appz + i14, this.appy);
                i14 += this.appz;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.appx = getChildCount();
        if (this.appx == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        measureChildren(i10, i11);
        View childAt = getChildAt(0);
        this.appy = childAt.getMeasuredHeight();
        this.appz = childAt.getMeasuredWidth();
        setMeasuredDimension(this.appz * this.appx, this.appy);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        try {
            this.appq = true;
            appa.appa.appf.appd.appa(f46618n, "IPA.MW Reward onPrepared" + this.appr);
            appg();
            if (this.appr > 0) {
                this.appg.seekTo(this.appr);
            }
            this.appg.startVideo();
            this.appp.setVisibility(8);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46618n, "IPA.MW Reward onPrepared：" + th.toString());
            com.wangmai.ad.dex.allmodules.appf.appd appdVar = this.appw;
            if (appdVar != null) {
                appdVar.appa("播放异常");
            }
        }
    }

    @Override // com.wangmai.ad.dex.allmodules.appf.appa
    public void pause() {
        appa.appa.appf.appd.appa(f46618n, "IPA.MW Reward pause");
        CustomVideoView2 customVideoView2 = this.appg;
        if (customVideoView2 != null) {
            customVideoView2.pause();
        }
    }

    @Override // com.wangmai.ad.dex.allmodules.appf.appa
    public void resume() {
        appa.appa.appf.appd.appa(f46618n, "IPA.MW Reward resume");
        appa();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c9 A[Catch: all -> 0x00f1, TryCatch #0 {all -> 0x00f1, blocks: (B:3:0x0001, B:5:0x003a, B:6:0x0042, B:8:0x0048, B:9:0x0050, B:11:0x0056, B:12:0x005e, B:14:0x0067, B:15:0x007c, B:17:0x0082, B:21:0x009e, B:24:0x00a6, B:26:0x00bf, B:28:0x00c9, B:30:0x00d4, B:32:0x00db, B:34:0x00e2, B:35:0x00e7, B:39:0x00ac, B:40:0x008b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d4 A[Catch: all -> 0x00f1, TryCatch #0 {all -> 0x00f1, blocks: (B:3:0x0001, B:5:0x003a, B:6:0x0042, B:8:0x0048, B:9:0x0050, B:11:0x0056, B:12:0x005e, B:14:0x0067, B:15:0x007c, B:17:0x0082, B:21:0x009e, B:24:0x00a6, B:26:0x00bf, B:28:0x00c9, B:30:0x00d4, B:32:0x00db, B:34:0x00e2, B:35:0x00e7, B:39:0x00ac, B:40:0x008b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00db A[Catch: all -> 0x00f1, TryCatch #0 {all -> 0x00f1, blocks: (B:3:0x0001, B:5:0x003a, B:6:0x0042, B:8:0x0048, B:9:0x0050, B:11:0x0056, B:12:0x005e, B:14:0x0067, B:15:0x007c, B:17:0x0082, B:21:0x009e, B:24:0x00a6, B:26:0x00bf, B:28:0x00c9, B:30:0x00d4, B:32:0x00db, B:34:0x00e2, B:35:0x00e7, B:39:0x00ac, B:40:0x008b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e2 A[Catch: all -> 0x00f1, TryCatch #0 {all -> 0x00f1, blocks: (B:3:0x0001, B:5:0x003a, B:6:0x0042, B:8:0x0048, B:9:0x0050, B:11:0x0056, B:12:0x005e, B:14:0x0067, B:15:0x007c, B:17:0x0082, B:21:0x009e, B:24:0x00a6, B:26:0x00bf, B:28:0x00c9, B:30:0x00d4, B:32:0x00db, B:34:0x00e2, B:35:0x00e7, B:39:0x00ac, B:40:0x008b), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setDownLoadInfo(com.wangmai.ad.dex.allmodules.bean.ApiBean.DownloadAppInfo r12) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wangmai.ad.dex.allmodules.api.reward.WMRewardViewGroup.setDownLoadInfo(com.wangmai.ad.dex.allmodules.bean.ApiBean$DownloadAppInfo):void");
    }

    private void appc() {
        this.appf = LayoutInflater.from(appa.appa.appf.appa.appa(this.appv, WMResources.resources)).inflate(R$layout.wm_reward_layout, (ViewGroup) this, false);
        this.appg = (CustomVideoView2) this.appf.findViewById(1879179365);
        this.appp = (ProgressBar) this.appf.findViewById(1879179342);
        this.apph = (TextView) this.appf.findViewById(R$id.wm_tv_skip);
        this.appi = (TextView) this.appf.findViewById(R$id.wm_tv_duration);
        this.appj = (LinearLayout) this.appf.findViewById(R$id.wm_layout_video_detail);
        this.appk = (ImageView) this.appf.findViewById(R$id.iv_icon);
        this.appl = (TextView) this.appf.findViewById(R$id.tv_title);
        this.appm = (TextView) this.appf.findViewById(R$id.tv_desc);
        this.appn = (Button) this.appf.findViewById(R$id.bt_click);
        this.appo = (TextView) this.appf.findViewById(R$id.tv_download_info);
        appa(this.apps);
        VisibilityUtils.getInstance().addVisibleChangedListener(this, new appa());
    }

    private void appd() {
        com.wangmai.ad.dex.allmodules.appf.appd appdVar = this.appw;
        if (appdVar != null) {
            appdVar.appb();
            apph();
            removeAllViewsInLayout();
            invalidate();
        }
    }

    private void appe() {
        try {
            appa.appa.appf.appd.appa(f46618n, "setVideoInfo");
            this.appj.setVisibility(0);
            this.appn.setVisibility(0);
            if (!TextUtils.isEmpty(this.f46627i)) {
                this.appl.setVisibility(0);
                this.appl.setText(this.f46627i + "");
            }
            if (!TextUtils.isEmpty(this.f46626h)) {
                this.appm.setVisibility(0);
                this.appm.setText(this.f46626h + "");
            }
            if (!TextUtils.isEmpty(this.f46625g)) {
                this.appk.setVisibility(0);
                OkHttp.get(this.f46625g).execute(new appb());
            }
            this.apph.setOnClickListener(new appc());
            this.appn.setOnClickListener(new appd());
            this.appj.setOnTouchListener(new appe());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46618n, "setVideoInfo error:" + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appf() {
        try {
            com.wangmai.ad.dex.allmodules.utils.appf.appa(this.apps.getRespObj().getWxad().getWin_notice_url(), 0, true);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46618n, "激励视频曝光上报失败：" + th.toString());
        }
    }

    private void appg() {
        Runnable runnable;
        Handler handler = this.f46631m;
        if (handler == null || (runnable = this.f46630l) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.f46631m.post(this.f46630l);
    }

    private void apph() {
        Runnable runnable;
        Handler handler = this.f46631m;
        if (handler == null || (runnable = this.f46630l) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    private void appa(ApiBean apiBean) {
        if (apiBean == null) {
            appa.appa.appf.appd.appb(f46618n, "IPA.MW Reward 暂无广告");
            appd();
            return;
        }
        ApiBean.RespObj respObj = apiBean.getRespObj();
        ApiBean.WxadBean wxad = respObj.getWxad();
        if (respObj.getError_code() == 0 && wxad != null) {
            if (wxad.getDownload_app_info() != null) {
                setDownLoadInfo(wxad.getDownload_app_info());
            }
            if (wxad.getCreative_type() != 6) {
                appa.appa.appf.appd.appb(f46618n, "IPA.MW reward 未知广告交互类型");
                appd();
                return;
            }
            ApiBean.Video video = wxad.getVideo();
            String v_url = video.getV_url();
            if (video.getExt() != null) {
                this.f46621c = false;
                this.f46625g = video.getExt().getEndiconurl();
                this.f46627i = video.getExt().getEndtitle();
                this.f46626h = video.getExt().getEnddesc();
                this.f46624f = video.getExt().getEndimgurl();
                this.f46628j = video.getExt().getEndbuttonurl();
                this.f46622d = video.getDuration();
                if (video.getV_tracking() != null && video.getV_tracking().getV_progress_tracking_event() != null && video.getV_tracking().getV_progress_tracking_event().size() > 0) {
                    this.f46623e = video.getV_tracking().getV_progress_tracking_event();
                }
            }
            if (!TextUtils.isEmpty(this.f46628j)) {
                appe();
            }
            if (TextUtils.isEmpty(v_url)) {
                appa.appa.appf.appd.appb(f46618n, "IPA.MW reward 无效的视频物料");
                appd();
                return;
            } else {
                appa(wxad);
                appa(v_url);
                return;
            }
        }
        appa.appa.appf.appd.appb(f46618n, "IPA.MW reward 广告请求失败：" + respObj.getError_code());
        appd();
    }

    private void appa(ApiBean.WxadBean wxadBean) {
        if (this.apps.getRespObj().getWxad().getApp_package() == null || this.apps.getRespObj().getWxad().getInstalled_track_urls() == null || this.apps.getRespObj().getWxad().getInstalled_track_urls().size() <= 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("installed_track_urls_size", Integer.valueOf(this.apps.getRespObj().getWxad().getInstalled_track_urls().size()));
        for (int i10 = 0; i10 < this.apps.getRespObj().getWxad().getInstalled_track_urls().size(); i10++) {
            hashMap.put("installed_track_urls" + i10, this.apps.getRespObj().getWxad().getInstalled_track_urls().get(i10));
        }
        hashMap.put("brand_name", wxadBean.getApp_package());
        SharedPreferencesHelper.getInstance(this.appv).savePreferencesMap(hashMap);
    }

    private void appa(String str) {
        try {
            appa.appa.appf.appd.appa(f46618n, "IPA.MW reward addAd videoView:" + str);
            this.appg.setOnCompletionListener(this);
            this.appg.setOnErrorListener(this);
            this.appg.setOnPreparedListener(this);
            this.appg.setVideoPath(str);
            addView(this.appf);
            invalidate();
            com.wangmai.ad.dex.allmodules.utils.appf.apph = 1;
        } catch (Throwable th) {
            appa.appa.appf.appd.appb(f46618n, "IPA.MW reward 视频加载失败:" + th.toString());
            com.wangmai.ad.dex.allmodules.appf.appd appdVar = this.appw;
            if (appdVar != null) {
                appdVar.appa("视频加载失败:" + th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void appa(boolean z10, int i10) {
        try {
            appa.appa.appf.appd.appa(f46618n, "RewardViewGroup doClick:", Thread.currentThread().getName(), Integer.valueOf(i10));
            this.f46629k = true;
            if (z10 && this.appw != null) {
                try {
                    this.appw.appa();
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe(f46618n, "RewardViewGroup media onAdBarClick error:" + ((Object) th));
                    com.wangmai.ad.dex.allmodules.utils.appf.appa(this.appv, "", "RewardViewGroup media onAdBarClick error：" + Log.getStackTraceString(th));
                }
            }
            appa(i10);
        } catch (Throwable th2) {
            appa.appa.appf.appd.appe(f46618n, "RewardViewGroup doClick error:" + ((Object) th2));
            com.wangmai.ad.dex.allmodules.utils.appf.appa(this.appv, "", "RewardViewGroup doClick error：" + Log.getStackTraceString(th2));
        }
    }

    private void appa(int i10) {
        try {
            try {
                com.wangmai.ad.dex.allmodules.utils.appf.appa(this.apps.getRespObj().getWxad().getClick_url(), this.apps.getRespObj().getWxad().getDp_try_track_urls(), i10, this.appb, this.appc, this.appd, this.appe);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe(f46618n, "Api reward clickUpEventReport error:" + ((Object) th));
                com.wangmai.ad.dex.allmodules.utils.appf.appa(this.appv, "", "Api reward clickUpEventReport error:" + Log.getStackTraceString(th));
            }
            appa(this.apps.getRespObj().getWxad().getDeep_link(), this.f46628j);
        } catch (Throwable th2) {
            appa.appa.appf.appd.appe(f46618n, "Api Reward openLinkAddress error:" + ((Object) th2));
            com.wangmai.ad.dex.allmodules.utils.appf.appa(this.appv, "", "Api Reward openLinkAddress" + Log.getStackTraceString(th2));
        }
    }

    private void appa(String str, String str2) {
        try {
            com.wangmai.ad.dex.allmodules.utils.appf.appa("", false, str, str2, this.appv, this.appb, this.appc, this.appd, this.appe, this.apps, this, this.appt, this.appu);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46618n, "Api reward clickLoadPage error:" + ((Object) th));
            com.wangmai.ad.dex.allmodules.utils.appf.appa(this.appv, "", "Api reward clickLoadPage error:" + Log.getStackTraceString(th));
        }
    }

    public void appa() {
        try {
            appa.appa.appf.appd.appa(f46618n, "恢复:" + this.appr);
            if (this.appg != null) {
                this.appg.setVisibility(0);
                invalidate();
                this.appg.seekTo(this.appr);
                this.appg.startVideo();
                appg();
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(f46618n, "resumeVideo exception:" + th.toString());
        }
    }
}
