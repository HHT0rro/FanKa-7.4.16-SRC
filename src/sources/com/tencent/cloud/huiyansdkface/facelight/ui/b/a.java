package com.tencent.cloud.huiyansdkface.facelight.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.core.app.NotificationCompat;
import com.huawei.quickcard.base.Attributes;
import com.tencent.cloud.huiyansdkface.R;
import com.tencent.cloud.huiyansdkface.a.c.a.i;
import com.tencent.cloud.huiyansdkface.a.d.a;
import com.tencent.cloud.huiyansdkface.a.f;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbCusFaceVerifyResult;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceVerifyResult;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceWillModeResult;
import com.tencent.cloud.huiyansdkface.facelight.c.a.e;
import com.tencent.cloud.huiyansdkface.facelight.c.a.g;
import com.tencent.cloud.huiyansdkface.facelight.c.a.h;
import com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.common.RotateSetting;
import com.tencent.cloud.huiyansdkface.facelight.common.WbCloudNetSecurityManger;
import com.tencent.cloud.huiyansdkface.facelight.common.WbThreadFactory;
import com.tencent.cloud.huiyansdkface.facelight.net.model.FaceWillResult;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelight.net.model.WbFaceWillContent;
import com.tencent.cloud.huiyansdkface.facelight.net.model.WbFaceWillRes;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.CusRequestBody;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.FlashReq;
import com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight.SelectData;
import com.tencent.cloud.huiyansdkface.facelight.process.FaceVerifyStatus;
import com.tencent.cloud.huiyansdkface.facelight.process.b;
import com.tencent.cloud.huiyansdkface.facelight.process.b.c;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceInnerError;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeProviders;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbWillFinishCallback;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbWillProcessCallback;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbWillVideoEncodeFinishCallback;
import com.tencent.cloud.huiyansdkface.facelight.provider.WillParam;
import com.tencent.cloud.huiyansdkface.facelight.ui.a.b;
import com.tencent.cloud.huiyansdkface.facelight.ui.widget.HeadBorderView;
import com.tencent.cloud.huiyansdkface.facelight.ui.widget.PreviewFrameLayout;
import com.tencent.cloud.huiyansdkface.facelight.ui.widget.PreviewMask;
import com.tencent.cloud.huiyansdkface.facelight.ui.widget.a;
import com.tencent.cloud.huiyansdkface.facelight.ui.widget.b;
import com.tencent.cloud.huiyansdkface.normal.thread.ThreadOperate;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.record.VideoEncoder;
import com.tencent.cloud.huiyansdkface.record.WbRecordFinishListener;
import com.tencent.cloud.huiyansdkface.record.WeMediaManager;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import com.tencent.open.SocialConstants;
import com.tencent.youtu.liveness.YTFaceTracker;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectColorData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.data.YTActRefImage;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends b implements com.tencent.cloud.huiyansdkface.facelight.process.b.a, com.tencent.cloud.huiyansdkface.facelight.process.b.b, c, com.tencent.cloud.huiyansdkface.facelight.ui.a.c, com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f40983a = a.class.getSimpleName();
    private RelativeLayout A;
    private TextView B;
    private PreviewFrameLayout C;
    private HeadBorderView D;
    private com.tencent.cloud.huiyansdkface.facelight.ui.widget.a E;
    private boolean F;
    private boolean G;
    private File N;
    private String O;
    private String P;
    private int R;
    private com.tencent.cloud.huiyansdkface.a.g.c U;
    private com.tencent.cloud.huiyansdkface.a.c V;
    private f W;
    private com.tencent.cloud.huiyansdkface.a.a Y;
    private int Z;
    private SensorManager aB;
    private Sensor aC;
    private String aD;
    private int aE;
    private PreviewMask aF;
    private SelectData aG;
    private ReflectColorData aH;
    private Camera aI;
    private boolean aJ;
    private boolean aL;
    private boolean aM;
    private ByteArrayOutputStream aN;
    private VideoEncoder aO;
    private byte[][] aT;
    private float aU;
    private Context aV;
    private WbWillVideoEncodeFinishCallback aW;
    private float aZ;

    /* renamed from: aa, reason: collision with root package name */
    private int f40984aa;

    /* renamed from: ab, reason: collision with root package name */
    private int f40985ab;

    /* renamed from: ac, reason: collision with root package name */
    private int f40986ac;

    /* renamed from: ad, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.c.d.c f40987ad;

    /* renamed from: ae, reason: collision with root package name */
    private e f40988ae;
    private com.tencent.cloud.huiyansdkface.facelight.c.a.b af;
    private boolean ag;
    private boolean ah;
    private boolean ai;
    private TextView aj;
    private TextView ak;
    private YTImageInfo am;
    private YTImageInfo an;
    private YTImageInfo ao;
    private ImageView ap;
    private com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aq;

    /* renamed from: ar, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.ui.widget.a f40989ar;
    private CloudFaceCountDownTimer as;
    private CloudFaceCountDownTimer at;
    private CloudFaceCountDownTimer au;
    private CloudFaceCountDownTimer av;
    private CloudFaceCountDownTimer aw;
    private CloudFaceCountDownTimer ax;
    private CloudFaceCountDownTimer ay;
    private CloudFaceCountDownTimer az;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.ui.widget.c f40992c;

    /* renamed from: d, reason: collision with root package name */
    private d f40993d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.a.b.a f40994e;

    /* renamed from: g, reason: collision with root package name */
    private FaceVerifyStatus f40996g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.process.e.a f40997h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.process.a.a f40998i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.process.a f40999j;

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.c.d f41000k;

    /* renamed from: m, reason: collision with root package name */
    private boolean f41002m;

    /* renamed from: n, reason: collision with root package name */
    private SoundPool f41003n;

    /* renamed from: o, reason: collision with root package name */
    private int f41004o;

    /* renamed from: p, reason: collision with root package name */
    private View f41005p;

    /* renamed from: q, reason: collision with root package name */
    private View f41006q;

    /* renamed from: r, reason: collision with root package name */
    private View f41007r;

    /* renamed from: s, reason: collision with root package name */
    private TextView f41008s;

    /* renamed from: t, reason: collision with root package name */
    private TextView f41009t;

    /* renamed from: u, reason: collision with root package name */
    private TextView f41010u;

    /* renamed from: v, reason: collision with root package name */
    private RelativeLayout f41011v;

    /* renamed from: w, reason: collision with root package name */
    private TextView f41012w;

    /* renamed from: x, reason: collision with root package name */
    private ImageView f41013x;

    /* renamed from: y, reason: collision with root package name */
    private TextView f41014y;

    /* renamed from: z, reason: collision with root package name */
    private TextView f41015z;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.c.b.e f40990b = new com.tencent.cloud.huiyansdkface.facelight.c.b.e(AutofillManager.MAX_TEMP_AUGMENTED_SERVICE_DURATION_MS);

    /* renamed from: f, reason: collision with root package name */
    private String f40995f = "";

    /* renamed from: l, reason: collision with root package name */
    private YTFaceTracker f41001l = null;
    private String H = "";
    private String I = "";
    private String J = "";
    private String K = "";
    private String L = "";
    private String M = "";
    private String Q = "";
    private boolean S = false;
    private com.tencent.cloud.huiyansdkface.facelight.b.b T = new com.tencent.cloud.huiyansdkface.facelight.b.b();
    private int X = 0;
    private Properties al = new Properties();
    private boolean aA = false;
    private int aK = 0;
    private int aP = 0;
    private int aQ = 2097152;
    private int aR = 30;
    private int aS = 1;
    private ExecutorService aX = Executors.newFixedThreadPool(1, new WbThreadFactory("wbcfYtEncode"));
    private ExecutorService aY = Executors.newFixedThreadPool(1, new WbThreadFactory("wbcfWbRecord"));

    /* renamed from: ba, reason: collision with root package name */
    private SensorEventListener f40991ba = new SensorEventListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.41
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            String str;
            String str2;
            if (sensorEvent != null) {
                Sensor sensor = sensorEvent.sensor;
                if (sensor != null) {
                    if (sensor.getType() != 5) {
                        return;
                    }
                    float f10 = sensorEvent.values[0];
                    if (f10 > 100000.0f) {
                        f10 = 100000.0f;
                    }
                    a.this.aD = String.valueOf((int) f10);
                    return;
                }
                str = a.f40983a;
                str2 = "light event.sensor is null";
            } else {
                str = a.f40983a;
                str2 = "light event is null";
            }
            WLogger.e(str, str2);
        }
    };

    /* renamed from: com.tencent.cloud.huiyansdkface.facelight.ui.b.a$22, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass22 extends CloudFaceCountDownTimer {
        public AnonymousClass22(long j10, long j11) {
            super(j10, j11);
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
        public void onFinish() {
            WLogger.d(a.f40983a, "findface timeoutCdt end!");
            a.this.f40996g.b(7);
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
        public void onTick(long j10) {
        }
    }

    /* renamed from: com.tencent.cloud.huiyansdkface.facelight.ui.b.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class C0626a implements SoundPool.OnLoadCompleteListener {

        /* renamed from: a, reason: collision with root package name */
        private int f41123a;

        public C0626a(int i10) {
            this.f41123a = i10;
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int i10, int i11) {
            WLogger.d(a.f40983a, "PlayVoice BEGIN");
            soundPool.play(this.f41123a, 1.0f, 1.0f, 1, 0, 1.0f);
        }
    }

    private boolean A() {
        YTFaceTracker yTFaceTracker;
        String str = f40983a;
        WLogger.d(str, "initYoutuTracker");
        WLogger.i(str, "YT Detect version:" + YTFaceTracker.getVersion());
        a(str, "YT Detect version:" + YTFaceTracker.getVersion());
        YTFaceTracker.setLoggerLevel(2);
        YTFaceTracker.setLoggerListener(new YTFaceTracker.IYtLoggerListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.12
            @Override // com.tencent.youtu.liveness.YTFaceTracker.IYtLoggerListener
            public void log(String str2, String str3) {
                WLogger.d("sunny------", "tag-tracker--" + str3);
                a.this.a("sunny------", "tag-tracker--" + str3);
            }
        });
        String t2 = this.f40994e.t();
        try {
            if (TextUtils.isEmpty(t2)) {
                WLogger.d(str, "init from asset");
                a(str, "init tracker from asset");
                yTFaceTracker = new YTFaceTracker(this.aV.getAssets(), "models/face-tracker-v001", "yt_model_config.ini");
            } else {
                WLogger.d(str, "init from filesystem,YTModelLoc=" + t2);
                a(str, "init tracker from filesystem,YTModelLoc=" + t2);
                yTFaceTracker = new YTFaceTracker(t2, "yt_model_config.ini");
            }
            this.f41001l = yTFaceTracker;
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            WLogger.e(f40983a, "initYoutu exception:" + e2.toString());
            KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_model_init_failed", "YTFaceTracker exception:" + e2.toString(), null);
            return false;
        }
    }

    private boolean B() {
        String str = f40983a;
        WLogger.d(str, "initYoutuActionLiveness");
        int a10 = com.tencent.cloud.huiyansdkface.facelight.process.b.a();
        if (a10 != 0) {
            WLogger.e(str, "initYoutu ACTION exception:" + a10);
            return false;
        }
        YTPoseDetectJNIInterface.configNativeLog(this.f40994e.O());
        YTPoseDetectJNIInterface.updateParam("log_level", "3");
        YTPoseDetectJNIInterface.setLoggerListener(new YTPoseDetectJNIInterface.IYtLoggerListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.23
            @Override // com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface.IYtLoggerListener
            public void log(String str2, String str3) {
                WLogger.d(str2, str3);
                a.this.a(str2, str3);
            }
        });
        String version = YTPoseDetectJNIInterface.getVersion();
        WLogger.i(str, "YTPose Version: " + version);
        a(str, "YTPose Version: " + version);
        return true;
    }

    private void C() {
        if (this.f40995f.contains("3")) {
            WLogger.d(f40983a, "light live init");
            I();
            H();
        }
        if (this.f40994e.S()) {
            return;
        }
        P();
    }

    private void D() {
        E();
        F();
        G();
        com.tencent.cloud.huiyansdkface.a.a.a.a aVar = com.tencent.cloud.huiyansdkface.a.a.a.a.FRONT;
        a(aVar);
        this.W = new f(aVar, this.V);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x026d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void E() {
        /*
            Method dump skipped, instructions count: 655
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.E():void");
    }

    private void F() {
        WLogger.d(f40983a, "init FaceDetect!");
        com.tencent.cloud.huiyansdkface.facelight.process.a aVar = new com.tencent.cloud.huiyansdkface.facelight.process.a(this.aV, this.f41001l, new com.tencent.cloud.huiyansdkface.facelight.process.c.b() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.3
            @Override // com.tencent.cloud.huiyansdkface.facelight.process.c.b
            public void a() {
                String str;
                String str2;
                if (a.this.f40996g == null) {
                    str = a.f40983a;
                    str2 = "mFaceVerifyStatus is null,return";
                } else if (a.this.f40996g.b() >= 6) {
                    str = a.f40983a;
                    str2 = "already in upload,no need reset";
                } else {
                    if (a.this.f40996g.b() != 4 || a.this.f40996g.d() != 3 || a.this.aE <= 1) {
                        WLogger.d(a.f40983a, "onDetectNoFace");
                        if (a.this.f40996g.b() == 5) {
                            KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "willpage_detect_intermediate", null, null);
                            a.this.f41010u.setVisibility(8);
                            a.this.f41009t.setVisibility(0);
                            if (a.this.G) {
                                a.this.f41011v.setVisibility(0);
                                a.this.f41012w.setVisibility(0);
                            }
                            if (a.this.aW != null) {
                                a.this.aW = null;
                            }
                            WbFaceModeProviders.faceMode().stopWill(a.this.getChildFragmentManager());
                            a.this.f40993d.b(false);
                        } else {
                            KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "facepage_detect_intermediate", null, null);
                        }
                        a.this.S();
                        a.this.f40996g.b(2);
                        if (a.this.f40995f.contains("3")) {
                            a.this.aF.b();
                            a.this.aF.setVisibility(8);
                            a.this.h(0);
                            a.this.ab();
                            if (WbCloudFaceContant.BLACK.equals(a.this.f40994e.J()) && a.this.G) {
                                a.this.f41011v.setBackgroundResource(R.drawable.wbcf_customer_long_tip_bg);
                                a.this.f41012w.setTextColor(a.this.c(R.color.wbcf_guide_text_black));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    str = a.f40983a;
                    str2 = "mState=" + a.this.aE + ",no need reset";
                }
                WLogger.d(str, str2);
            }
        });
        this.f40999j = aVar;
        aVar.a(this.f40996g);
        this.f40999j.a(this);
    }

    private void G() {
        KycWaSDK kycWaSDK;
        Activity activity;
        String str;
        String str2 = f40983a;
        WLogger.d(str2, "初始化相机配置");
        if (this.f40993d.e().B()) {
            WLogger.i(str2, "init turing preview");
            com.tencent.cloud.huiyansdkface.facelight.c.d.c a10 = com.tencent.cloud.huiyansdkface.facelight.c.d.d.a();
            this.f40987ad = a10;
            e a11 = a10.a();
            this.f40988ae = a11;
            if (a11 != null) {
                a11.a(this.f40987ad);
            }
            this.U.a(this.f40988ae);
            kycWaSDK = KycWaSDK.getInstance();
            activity = getActivity();
            str = "facepage_turing_preview";
        } else {
            WLogger.i(str2, "init system preview");
            this.U.a((com.tencent.cloud.huiyansdkface.a.g.a) null);
            kycWaSDK = KycWaSDK.getInstance();
            activity = getActivity();
            str = "facepage_system_preview";
        }
        kycWaSDK.trackCustomKVEvent(activity, str, null, null);
    }

    private void H() {
        boolean z10;
        SensorManager sensorManager = (SensorManager) this.aV.getSystemService("sensor");
        this.aB = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(5);
        this.aC = defaultSensor;
        if (defaultSensor == null) {
            WLogger.e(f40983a, "this phone does not have light sensor!");
            z10 = false;
        } else {
            WLogger.d(f40983a, "this phone has light sensor!");
            z10 = true;
        }
        this.aA = z10;
    }

    private void I() {
        WLogger.d(f40983a, "initFaceLive");
        YTAGReflectLiveCheckInterface.setReflectNotice(new com.tencent.cloud.huiyansdkface.facelight.process.c.a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.11
            @Override // com.tencent.cloud.huiyansdkface.facelight.process.c.a
            public void a() {
                ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WLogger.d(a.f40983a, "onDelayCalc");
                        if (a.this.aE == 1) {
                            a.this.h(2);
                            a.this.ab();
                            KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "facepage_reflect_delaycal", null, null);
                        } else {
                            WLogger.w(a.f40983a, "curLightState：" + a.this.aE + ",cant switch to STATE_DETECT_DELAY");
                        }
                    }
                });
            }
        });
        YTAGReflectLiveCheckInterface.setReflectListener(new YTAGReflectLiveCheckInterface.b() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.13
            @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.b
            public float a() {
                return a.this.R();
            }

            @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.b
            public void a(final int i10, float f10) {
                ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.aF.setReflectColor(i10);
                    }
                });
            }

            @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.b
            public void a(long j10) {
                WLogger.d(a.f40983a, "on reflection start " + j10);
                KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "facepage_reflect_start", null, null);
            }
        });
        YTAGReflectLiveCheckJNIInterface.configNativeLog(true);
        YTAGReflectLiveCheckJNIInterface.updateParam("log_level", "3");
        YTAGReflectLiveCheckJNIInterface.setLoggerListener(new YTAGReflectLiveCheckJNIInterface.IYtLoggerListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.14
            @Override // com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface.IYtLoggerListener
            public void log(String str, String str2) {
                WLogger.d("sunny------", "tag-AGReflect--" + str2);
                a.this.a("sunny------", "tag-AGReflect--" + str2);
            }
        });
    }

    private void J() {
        h(1);
        com.tencent.cloud.huiyansdkface.facelight.c.b.b.a(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.15
            @Override // java.lang.Runnable
            public void run() {
                a.this.K();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        String str = f40983a;
        WLogger.d(str, "startReflect：" + Thread.currentThread().getName());
        YTAGReflectLiveCheckInterface.cancel();
        j(-1);
        String M = this.f40994e.M();
        WLogger.d(str, "colorData=" + M);
        int i10 = this.f40993d.i();
        WLogger.w(str, "start count=" + i10);
        if (i10 > 0) {
            WLogger.w(str, "多次start:" + i10);
            KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_reflect_duplicate_start", "count=" + i10 + ",record=" + this.f40993d.m(), null);
            YTAGReflectLiveCheckInterface.cancel();
            this.f40993d.l();
            this.f40993d.p();
        }
        this.f40993d.j();
        this.f40993d.o();
        YTAGReflectLiveCheckInterface.start(getActivity(), this.aI, RotateSetting.getRotate(), M, new YTAGReflectLiveCheckInterface.c() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.16
            @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.c
            public void a(int i11, String str2, String str3) {
                WLogger.w(a.f40983a, "YTAGReflectLiveCheckInterface onFailed!result=" + i11 + ",message=" + str2 + ",tips=" + str3);
                a.this.aH = null;
                KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "facepage_light_error", i11 + ";" + str2, null);
                a.this.a(false, i11);
            }

            @Override // com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.c
            public void a(FullPack fullPack) {
                WLogger.i(a.f40983a, "YTAGReflectLiveCheckInterface onSuccess!");
                a.this.aH = com.tencent.cloud.huiyansdkface.facelight.c.b.a(fullPack.AGin);
                a.this.a(true, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void L() {
        String str = f40983a;
        WLogger.d(str, "checkRecordFile");
        YTImageInfo yTImageInfo = this.am;
        if (yTImageInfo == null || TextUtils.isEmpty(yTImageInfo.image)) {
            WLogger.e(str, "best image is null!");
            b(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainNativeProcess, WbFaceError.WBFaceErrorCodeNoBestPic, d(R.string.wbcf_light_get_pic_failed), "PIC_FILE_IO_FAILED,best image is null!"));
            return;
        }
        WLogger.d(str, "has liveImage");
        if (this.aL && this.aM) {
            byte[] videoByte = WeMediaManager.getInstance().getVideoByte();
            if (videoByte != null && videoByte.length != 0) {
                WLogger.d(str, "checkRecordFile wbVideoSize=" + (videoByte.length / 1024));
                if (videoByte.length < 50000) {
                    WLogger.e(str, "wbVideo is too small! ");
                    if (!this.f40994e.s()) {
                        d(true);
                        return;
                    }
                    b(-10, "wbVideo is too small!" + videoByte.length);
                    return;
                }
                if (videoByte.length <= 3000000) {
                    d(false);
                    return;
                }
                WLogger.e(str, "REFLECTION MODE:The Record File Size is too big! ");
                if (!this.f40994e.s()) {
                    d(true);
                    return;
                }
                b(-10, "wbVideo is too big!" + videoByte.length);
                return;
            }
            WLogger.e(str, "mCamera.getMediaFile is null!");
            if (this.f40994e.s()) {
                b(-10, "wbVideo Path is null!");
                return;
            }
            WLogger.e(str, "wbVideo is null, upload a null file");
        } else {
            WLogger.d(str, "no need to upload wbVideo");
            if (this.aL) {
                WeMediaManager.getInstance().resetVideoByte();
            }
        }
        d(true);
    }

    private void M() {
        int i10;
        synchronized (this) {
            SoundPool soundPool = this.f41003n;
            if (soundPool != null && (i10 = this.f41004o) > 0) {
                soundPool.stop(i10);
                this.f41003n.release();
                this.f41003n.setOnLoadCompleteListener(null);
                this.f41003n = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        String str = f40983a;
        WLogger.d(str, "showWillRetryTip");
        long as = this.f40993d.e().as();
        if (this.az == null) {
            this.az = new CloudFaceCountDownTimer(as, as / 2) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.26
                @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                public void onFinish() {
                    a.this.A.setVisibility(8);
                    a.this.B.setVisibility(8);
                    a.this.c(false);
                    a.this.f40996g.b(2);
                }

                @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                public void onTick(long j10) {
                }
            };
            if (this.B.getVisibility() != 0) {
                WLogger.d(str, "show willAnswerRetryTip.");
                this.A.setVisibility(0);
                this.B.setVisibility(0);
                this.az.start();
            }
        }
    }

    private void O() {
        if (this.aL) {
            String str = f40983a;
            WLogger.d(str, "start wbRecord:" + Thread.currentThread().getName());
            if (getActivity() != null) {
                if (WeMediaManager.getInstance().createMediaCodec(this.aV, this.X, u(), v())) {
                    WeMediaManager.getInstance().start(new WbRecordFinishListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.31
                        @Override // com.tencent.cloud.huiyansdkface.record.WbRecordFinishListener
                        public void onRecordFinish() {
                            String str2;
                            String str3;
                            WLogger.d(a.f40983a, "onWbRecordFinish");
                            a.this.f40996g.c(true);
                            int d10 = a.this.f40996g.d();
                            WLogger.d(a.f40983a, "curLiveCheck=" + d10);
                            if (a.this.f40995f.equals("1") && d10 == 1) {
                                str3 = "=================end silentCheck======================";
                                if (a.this.f40993d.e().x() && !YTPoseDetectJNIInterface.isRecordingDone()) {
                                    return;
                                } else {
                                    str2 = a.f40983a;
                                }
                            } else {
                                if (!a.this.f40995f.equals("2") || d10 != 2 || !a.this.f40996g.i()) {
                                    return;
                                }
                                str2 = a.f40983a;
                                str3 = "=================end actCheck======================";
                            }
                            WLogger.i(str2, str3);
                            a.this.f40996g.j();
                        }
                    });
                } else {
                    WLogger.e(str, "createMediaCodec failed, not record");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.f40997h.a(this.F, aa(), new ProcessCallback<WbFaceWillRes>() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.32
            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(WbFaceWillRes wbFaceWillRes) {
                if (!WbFaceModeProviders.isUseWillSdk() || wbFaceWillRes == null) {
                    return;
                }
                a.this.H = wbFaceWillRes.willType;
                WbFaceWillContent wbFaceWillContent = wbFaceWillRes.content;
                a.this.I = wbFaceWillContent.question;
                a.this.J = wbFaceWillContent.answer;
                a.this.K = wbFaceWillContent.questionAudio;
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onFailed(WbFaceInnerError wbFaceInnerError) {
                a.this.a(wbFaceInnerError.desc, wbFaceInnerError.domain, wbFaceInnerError.code, wbFaceInnerError.reason);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onUiNetworkRetryTip() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        String str = f40983a;
        WLogger.d(str, "finishActivity");
        if (getActivity() == null || getActivity().isFinishing()) {
            WLogger.d(str, "finishActivity:" + ((Object) getActivity()));
            return;
        }
        WLogger.d(str, "finish activity StackTrace");
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float R() {
        if (getActivity() != null) {
            return getActivity().getWindow().getAttributes().screenBrightness;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        String str = f40983a;
        WLogger.d(str, "clearState");
        T();
        if (this.f41015z.getVisibility() != 8) {
            this.f41015z.setVisibility(8);
        }
        if (this.A.getVisibility() != 8) {
            this.A.setVisibility(8);
        }
        if (this.B.getVisibility() != 8) {
            this.B.setVisibility(8);
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.ay;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.ay = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer2 = this.az;
        if (cloudFaceCountDownTimer2 != null) {
            cloudFaceCountDownTimer2.cancel();
            this.az = null;
        }
        M();
        if (this.aL) {
            WLogger.i(str, "=================no face end record======================");
            WeMediaManager.getInstance().stop(false);
            WeMediaManager.getInstance().resetVideoByte();
        }
    }

    public static /* synthetic */ int T(a aVar) {
        int i10 = aVar.R;
        aVar.R = i10 + 1;
        return i10;
    }

    private void T() {
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.at;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.at = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer2 = this.av;
        if (cloudFaceCountDownTimer2 != null) {
            cloudFaceCountDownTimer2.cancel();
            this.av = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer3 = this.au;
        if (cloudFaceCountDownTimer3 != null) {
            cloudFaceCountDownTimer3.cancel();
            this.au = null;
        }
    }

    private void U() {
        if (this.aA) {
            WLogger.d(f40983a, "unregister light listener");
            try {
                this.aB.unregisterListener(this.f40991ba);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void V() {
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.42
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i10, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 1 || i10 != 4) {
                    return false;
                }
                a.this.d("返回键：用户验证中取消");
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        WLogger.i(f40983a, "getBestPicAndVideo");
        com.tencent.cloud.huiyansdkface.facelight.process.b.a(new com.tencent.cloud.huiyansdkface.facelight.process.c.e() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.43
            @Override // com.tencent.cloud.huiyansdkface.facelight.process.c.e
            public void a(byte[][] bArr) {
                WLogger.d(a.f40983a, "onReceiveVideoDatas");
                a.this.aT = bArr;
                if (a.this.aT == null || a.this.aT.length == 0) {
                    WLogger.e(a.f40983a, "videoDatas is null!need Push backup data!");
                    a.this.f40999j.a(new com.tencent.cloud.huiyansdkface.facelight.process.c.d() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.43.1
                        @Override // com.tencent.cloud.huiyansdkface.facelight.process.c.d
                        public void a(YTActRefData yTActRefData) {
                            Param.appendBestImgInfo("1");
                            a.this.a(yTActRefData);
                        }
                    });
                    return;
                }
                WLogger.d(a.f40983a, "list num: " + a.this.aT.length);
                Param.appendBestImgInfo("0");
                a.this.X();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        WLogger.i(f40983a, "getActReflectData");
        com.tencent.cloud.huiyansdkface.facelight.process.b.a(new com.tencent.cloud.huiyansdkface.facelight.process.c.d() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.44
            @Override // com.tencent.cloud.huiyansdkface.facelight.process.c.d
            public void a(YTActRefData yTActRefData) {
                WLogger.d(a.f40983a, "onReceiveBestImg");
                a.this.a(yTActRefData);
            }
        });
    }

    private void Y() {
        String str;
        String str2 = f40983a;
        WLogger.i(str2, "checkPicsAndVideos");
        if (!this.f40993d.u()) {
            WLogger.d(str2, "not record ytVideo,upload wbVideo");
            this.aM = true;
            L();
            return;
        }
        byte[][] bArr = this.aT;
        if (bArr == null) {
            str = "ytVideo is null,upload wbVideo";
        } else {
            if (bArr == null || i(bArr.length)) {
                this.aX.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.46
                    @Override // java.lang.Runnable
                    public void run() {
                        WLogger.d(a.f40983a, "start encode");
                        a.this.a(new com.tencent.cloud.huiyansdkface.facelight.process.c.c() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.46.1
                            @Override // com.tencent.cloud.huiyansdkface.facelight.process.c.c
                            public void a() {
                                WLogger.d(a.f40983a, "onEncodeFinish");
                                a.this.b(false);
                            }
                        });
                    }
                });
                WLogger.d(str2, "start encode ctd");
                long Z = d.z().e().Z();
                WLogger.d(str2, "encodeTime=" + Z);
                this.ax = new CloudFaceCountDownTimer(Z, Z / 2) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.47
                    @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                    public void onFinish() {
                        WLogger.d(a.f40983a, "upload cdt onFinish!");
                        a.this.b(true);
                    }

                    @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                    public void onTick(long j10) {
                    }
                }.start();
                return;
            }
            str = "ytVideo not satisfied,upload wbVideo";
        }
        WLogger.d(str2, str);
        this.aM = true;
        L();
    }

    private void Z() {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.50
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(com.tencent.cloud.huiyansdkface.a.a.a.a.FRONT);
                a.this.W.a(a.this.V, new f.a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.50.1
                    @Override // com.tencent.cloud.huiyansdkface.a.f.a
                    public void a() {
                        WLogger.i(a.f40983a, "switchCamera onFinish");
                        KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "camera_switch_finished", null, null);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, String str) {
        String str2 = f40983a;
        WLogger.i(str2, "checkIsNeedRetryCam：" + i10 + "," + str);
        if (this.f40993d.e().E()) {
            WLogger.i(str2, "Need Retry Cam");
            if (!this.aJ) {
                WLogger.i(str2, "first Retry Cam");
                this.aJ = true;
                KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "camera_has_retry", null, null);
                Z();
                return;
            }
            WLogger.i(str2, "Already Retried!");
            KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "camera_retry_failed", null, null);
        } else {
            WLogger.i(str2, "No Need to Retry Cam");
        }
        b(i10, str);
    }

    private void a(int i10, String str, String str2, String str3) {
        if (i10 > 1) {
            WLogger.e(f40983a, "encry Exception count=" + i10 + ",too many times，need alert");
            c(WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainNativeProcess, str, str2, str3));
            return;
        }
        WLogger.d(f40983a, "encry Exception count=" + i10 + ",try again");
        g(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Camera camera, int i10) {
        this.aI = camera;
        if ("M5".equals(Param.getDeviceModel())) {
            int rotation = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay().getRotation();
            int i11 = 0;
            if (rotation != 0) {
                if (rotation == 1) {
                    i11 = 90;
                } else if (rotation == 2) {
                    i11 = 180;
                } else if (rotation == 3) {
                    i11 = 270;
                }
            }
            this.f40985ab = 1;
            camera.setDisplayOrientation((360 - ((i10 + i11) % 360)) % 360);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tencent.cloud.huiyansdkface.a.a.a.a aVar) {
        String str = f40983a;
        WLogger.d(str, "initCamera：" + ((Object) aVar));
        com.tencent.cloud.huiyansdkface.a.e.d dVar = new com.tencent.cloud.huiyansdkface.a.e.d() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.4
            @Override // com.tencent.cloud.huiyansdkface.a.e.d
            public void a(final com.tencent.cloud.huiyansdkface.a.e.a aVar2) {
                aVar2.a();
                a.this.a(aVar2);
                if (a.this.aL) {
                    a.this.aY.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WeMediaManager.getInstance().onPreviewFrame(aVar2.c());
                        }
                    });
                }
                if (a.this.f40993d.e().B() && a.this.f40987ad.b()) {
                    a.this.f40987ad.a(aVar2.c());
                }
            }
        };
        WLogger.d(str, "init CameraErrorCallback");
        this.V = new com.tencent.cloud.huiyansdkface.a.d(this.aV).a(aVar).a(this.U).a(new com.tencent.cloud.huiyansdkface.facelight.c.a.a().a()).a(com.tencent.cloud.huiyansdkface.facelight.b.a.f40595a).a(new com.tencent.cloud.huiyansdkface.a.b.a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.5
            @Override // com.tencent.cloud.huiyansdkface.a.b.a
            public void a(com.tencent.cloud.huiyansdkface.a.b.c cVar) {
                a aVar2;
                int i10;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("code=");
                stringBuffer.append(cVar.b());
                stringBuffer.append(";msg=");
                stringBuffer.append(cVar.d());
                stringBuffer.append(";cause=");
                stringBuffer.append((Object) cVar.getCause());
                stringBuffer.append(";trace=");
                stringBuffer.append(com.tencent.cloud.huiyansdkface.facelight.c.f.a(cVar));
                int b4 = cVar.b();
                if (b4 != 1) {
                    if (b4 == 3) {
                        aVar2 = a.this;
                        i10 = -2;
                        aVar2.a(i10, stringBuffer.toString());
                    } else if (b4 != 11 && b4 != 21) {
                        cVar.printStackTrace();
                        KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "camera_sdk_exception", stringBuffer.toString(), null);
                        return;
                    }
                }
                aVar2 = a.this;
                i10 = -1;
                aVar2.a(i10, stringBuffer.toString());
            }
        }).a(com.tencent.cloud.huiyansdkface.a.a.a.c.CROP_CENTER).b(com.tencent.cloud.huiyansdkface.a.a.b.b.a(new h(), new com.tencent.cloud.huiyansdkface.facelight.c.a.d())).c(com.tencent.cloud.huiyansdkface.a.a.b.b.a(new g(), new com.tencent.cloud.huiyansdkface.facelight.c.a.f())).a(com.tencent.cloud.huiyansdkface.a.a.b.b.a(new com.tencent.cloud.huiyansdkface.facelight.c.a.c(getActivity()), com.tencent.cloud.huiyansdkface.a.a.b.c.e())).a(dVar).a(new i() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.6
            @Override // com.tencent.cloud.huiyansdkface.a.c.a.i
            public void a(Camera.Parameters parameters, com.tencent.cloud.huiyansdkface.a.c.a.a aVar2) {
                parameters.setPreviewFormat(17);
            }
        }).a();
        WLogger.d(str, "初始化并注册相机适配器");
        this.Y = new com.tencent.cloud.huiyansdkface.a.a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.7

            /* renamed from: b, reason: collision with root package name */
            private Camera f41118b;

            @Override // com.tencent.cloud.huiyansdkface.a.a, com.tencent.cloud.huiyansdkface.a.b
            public void a() {
                super.a();
                WLogger.d(a.f40983a, "camera closed!");
            }

            @Override // com.tencent.cloud.huiyansdkface.a.a, com.tencent.cloud.huiyansdkface.a.b
            public void a(com.tencent.cloud.huiyansdkface.a.c.a aVar2) {
                super.a(aVar2);
                WLogger.i(a.f40983a, "cam start preview");
                ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.f40993d.e().v()) {
                            WLogger.i(a.f40983a, "setCurrentStep(FaceVerifyStatus.Status.FINDFACE)");
                            a.this.f40996g.b(2);
                        }
                        a.this.f41008s.setVisibility(0);
                        a.this.f41009t.setVisibility(0);
                        a.this.y();
                    }
                });
                a.this.T.a(0);
                a.this.T.a("success");
                a aVar3 = a.this;
                aVar3.a(aVar3.T);
                if (a.this.f40993d.e().B()) {
                    a.this.f40987ad.a(this.f41118b, Param.getAppId() + Param.getOrderNo());
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.a.a, com.tencent.cloud.huiyansdkface.a.b
            public void a(com.tencent.cloud.huiyansdkface.a.c.a aVar2, com.tencent.cloud.huiyansdkface.a.c.d dVar2, com.tencent.cloud.huiyansdkface.a.a.a aVar3) {
                super.a(aVar2, dVar2, aVar3);
                WLogger.d(a.f40983a, "cameraOpened ,previewSize=" + aVar3.a().toString());
                a.this.Z = aVar3.a().a();
                a.this.f40984aa = aVar3.a().b();
                com.tencent.cloud.huiyansdkface.a.c.a.a aVar4 = (com.tencent.cloud.huiyansdkface.a.c.a.a) dVar2;
                this.f41118b = aVar4.a();
                a.this.X = aVar4.f();
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(a.this.X, cameraInfo);
                a.this.f40985ab = cameraInfo.facing;
                a.this.f40986ac = cameraInfo.orientation;
                WLogger.d(a.f40983a, "cameraInfo.orientation =" + cameraInfo.orientation);
                a.this.a(aVar4.a(), a.this.f40986ac);
                RotateSetting.calRotateTag(a.this.aV, a.this.X, cameraInfo.facing);
                int rotate = RotateSetting.getRotate();
                WLogger.d(a.f40983a, "cameraOpened ,rotate=" + rotate);
                RotateSetting.setRotateInfo(rotate);
                a.this.f(rotate);
                if (a.this.f40993d.u()) {
                    WLogger.i(a.f40983a, "upload ytVideo");
                    a.this.a(RotateSetting.getRotate(), a.this.Z, a.this.f40984aa, 1);
                } else {
                    WLogger.d(a.f40983a, "cdn set no ytVideo,need wbVideo");
                    a.this.aM = true;
                }
                a.this.af.a(a.this.Z, a.this.f40984aa, RotateSetting.getRotate());
                WLogger.d(a.f40983a, "start set previewSize");
                if (rotate >= 5) {
                    a.this.f40999j.a(a.this.f40984aa, a.this.Z, 0);
                } else {
                    a.this.f40999j.a(a.this.Z, a.this.f40984aa, 1);
                }
                a.this.s();
            }
        };
        WLogger.d(str, " mWeCamera.registerCameraListener");
        this.V.a((com.tencent.cloud.huiyansdkface.a.b) this.Y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tencent.cloud.huiyansdkface.a.e.a aVar) {
        if (this.f40996g.b() < 6) {
            this.af.a(aVar);
        }
        if (this.f40996g.b() == 0) {
            WLogger.e(f40983a, "faceVerifyStatus current status not init!");
            return;
        }
        if (this.f40996g.b() == 2 || this.f40996g.b() == 3 || this.f40996g.b() == 4 || this.f40996g.b() == 5) {
            if (this.f40996g.b() == 5) {
                WbFaceModeProviders.faceMode().onPreviewFrame(aVar.c());
            }
            if (this.f40996g.b() == 4 && this.f40996g.d() == 3 && this.f40996g.e() > 1) {
                return;
            } else {
                this.f40999j.a(aVar.c(), u(), v());
            }
        }
        if (this.f40996g.b() == 6 || (this.aE == 2 && !WbFaceModeProviders.isUseWillSdk())) {
            a(aVar.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FaceWillResult faceWillResult) {
        if (this.f40993d.t()) {
            return;
        }
        String str = f40983a;
        WLogger.d(str, "successToResultPage");
        WbFaceWillModeResult wbFaceWillModeResult = null;
        this.f40993d.a(getActivity(), "0", (Properties) null);
        WLogger.d(str, "successToResultPage Activity is die?" + (getActivity() == null || getActivity().isFinishing()));
        this.f40993d.e(true);
        if (this.f40993d.y() != null) {
            WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
            wbFaceVerifyResult.setIsSuccess(true);
            wbFaceVerifyResult.setOrderNo(this.f40993d.w());
            wbFaceVerifyResult.setSign(faceWillResult.sign);
            wbFaceVerifyResult.setRiskInfo(faceWillResult.riskInfo);
            wbFaceVerifyResult.setLiveRate(faceWillResult.liveRate);
            wbFaceVerifyResult.setSimilarity(faceWillResult.similarity);
            if (this.f40993d.e().w()) {
                wbFaceVerifyResult.setUserImageString(this.am.image);
            }
            wbFaceVerifyResult.setError(null);
            if (WbFaceModeProviders.isUseWillSdk()) {
                wbFaceWillModeResult = faceWillResult.toWbFaceWillModeResult();
                if (this.f40994e.o()) {
                    wbFaceWillModeResult.setVideoPath(this.Q);
                }
            }
            wbFaceVerifyResult.setWillResult(wbFaceWillModeResult);
            this.f40993d.y().onFinish(wbFaceVerifyResult);
        }
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final WbFaceInnerError wbFaceInnerError) {
        com.tencent.cloud.huiyansdkface.facelight.a.a.b e2 = this.f40993d.e();
        String b4 = WbFaceError.WBFaceErrorCodeWillNoVoiceError.equals(wbFaceInnerError.code) ? e2.b() : WbFaceError.WBFaceErrorCodeWillLowPlayVolumeError.equals(wbFaceInnerError.code) ? e2.a() : "";
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar = this.E;
        if (aVar != null) {
            aVar.dismiss();
            this.E = null;
        }
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar2 = this.aq;
        if (aVar2 != null) {
            aVar2.dismiss();
            this.aq = null;
        }
        if (this.f40989ar == null) {
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.a d10 = new com.tencent.cloud.huiyansdkface.facelight.ui.widget.a(getActivity()).a(b4).c(this.f40993d.f().kyc_try_again).d(this.f40993d.f().kyc_cancel);
            this.f40989ar = d10;
            d10.getWindow().setBackgroundDrawableResource(R.color.wbcf_translucent_background);
            this.f40989ar.a(new a.InterfaceC0627a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.27
                @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0627a
                public void a() {
                    WLogger.d(a.f40983a, "restart will");
                    a.this.f40996g.b(2);
                }

                @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0627a
                public void b() {
                    a.this.c(wbFaceInnerError);
                }
            });
        }
        this.f40989ar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YTActRefData yTActRefData) {
        String str = f40983a;
        WLogger.i(str, "getBestPics");
        if (yTActRefData == null || yTActRefData.isEmpty()) {
            WLogger.e(str, "return ActReflectData is null empty!");
        } else {
            WLogger.d(str, "getActReflectData!");
            YTActRefImage yTActRefImage = yTActRefData.best;
            com.tencent.cloud.huiyansdkface.facelight.b.a.a aVar = new com.tencent.cloud.huiyansdkface.facelight.b.a.a(yTActRefImage.image, yTActRefImage.xys, yTActRefImage.checksum);
            YTActRefImage yTActRefImage2 = yTActRefData.eye;
            com.tencent.cloud.huiyansdkface.facelight.b.a.a aVar2 = new com.tencent.cloud.huiyansdkface.facelight.b.a.a(yTActRefImage2.image, yTActRefImage2.xys, yTActRefImage2.checksum);
            YTActRefImage yTActRefImage3 = yTActRefData.mouth;
            com.tencent.cloud.huiyansdkface.facelight.b.a.a aVar3 = new com.tencent.cloud.huiyansdkface.facelight.b.a.a(yTActRefImage3.image, yTActRefImage3.xys, yTActRefImage3.checksum);
            this.am = new YTImageInfo(aVar);
            this.an = new YTImageInfo(aVar2);
            this.ao = new YTImageInfo(aVar3);
        }
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        com.tencent.cloud.huiyansdkface.facelight.c.c.c.a().b(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2, final String str3, final String str4) {
        this.f40996g.b(9);
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.37
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.getActivity() == null) {
                    return;
                }
                if (a.this.aq == null) {
                    if (a.this.E != null) {
                        a.this.E.dismiss();
                        a.this.E = null;
                    }
                    if (a.this.f40989ar != null) {
                        a.this.f40989ar.dismiss();
                        a.this.f40989ar = null;
                    }
                    a.this.aq = new com.tencent.cloud.huiyansdkface.facelight.ui.widget.a(a.this.getActivity()).a(a.this.f40993d.f().kyc_internet_error).b(str).c(a.this.f40993d.f().kyc_try_again).d(a.this.f40993d.f().kyc_no_more);
                    a.this.aq.getWindow().setBackgroundDrawableResource(R.color.wbcf_translucent_background);
                    a.this.aq.a(new a.InterfaceC0627a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.37.1
                        @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0627a
                        public void a() {
                            WLogger.d(a.f40983a, "click try again");
                            if (a.this.aq != null) {
                                a.this.aq.dismiss();
                            }
                            KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "facepage_get_flash_res_retry", null, null);
                            a.this.F = true;
                            a.this.f40996g.b(2);
                            a.this.P();
                        }

                        @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0627a
                        public void b() {
                            KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "facepage_get_flash_res_quit", null, null);
                            AnonymousClass37 anonymousClass37 = AnonymousClass37.this;
                            a.this.b(str2, str3, str, str4);
                        }
                    });
                }
                if (a.this.getActivity() == null || a.this.getActivity().isFinishing()) {
                    return;
                }
                WLogger.d(a.f40983a, "mDialog.show()");
                a.this.aq.show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void a(final boolean z10, final int i10) {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.17
            @Override // java.lang.Runnable
            public void run() {
                WLogger.i(a.f40983a, "onReflectEnd");
                a.this.h(3);
                a.this.aF.setVisibility(8);
                KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "facepage_reflect_end", null, null);
                if (!z10) {
                    Param.appendLightLocalInfo(i10);
                }
                WLogger.d(a.f40983a, "onReflectEnd go to upload");
                a.this.f40996g.j();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z10, final FaceWillResult faceWillResult, final WbFaceInnerError wbFaceInnerError) {
        WLogger.d(f40983a, "endLoading:" + z10);
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar = this.E;
        if (aVar != null) {
            aVar.dismiss();
            this.E = null;
        }
        this.f41014y.setVisibility(8);
        this.C.b().a(50, new b.a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.39
            @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.b.a
            public void a() {
                if (z10) {
                    a.this.a(faceWillResult);
                } else {
                    a.this.c(wbFaceInnerError);
                }
            }
        });
    }

    private void a(byte[] bArr) {
        if (this.ag) {
            return;
        }
        b(bArr);
        this.ag = true;
    }

    private String aa() {
        if (!TextUtils.isEmpty(this.aD) && !this.aD.equals("0")) {
            return this.aD;
        }
        WLogger.w(f40983a, "lightDiffLux is null/zero! set default value!");
        return String.valueOf(this.f40993d.e().I());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab() {
        TextView textView;
        int i10;
        if (WbCloudFaceContant.BLACK.equals(this.f40994e.J())) {
            this.f41008s.setTextColor(c(R.color.wbcf_white));
            textView = this.f41009t;
            i10 = R.color.wbcf_guide_text_black;
        } else if (WbCloudFaceContant.WHITE.equals(this.f40994e.J())) {
            this.f41008s.setTextColor(c(R.color.wbcf_black_text));
            textView = this.f41009t;
            i10 = R.color.wbcf_guide_text;
        } else {
            if (!"custom".equals(this.f40994e.J())) {
                return;
            }
            this.f41008s.setTextColor(c(R.color.wbcf_custom_tips_text));
            textView = this.f41009t;
            i10 = R.color.wbcf_custom_customer_tip_text;
        }
        textView.setTextColor(c(i10));
    }

    private void ac() {
        if (this.aL) {
            WeMediaManager.getInstance().stop(true);
        }
        T();
        M();
        if (this.f40995f.contains("3")) {
            this.aF.setVisibility(8);
        }
        this.f41009t.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad() {
        this.f41010u.setVisibility(8);
        onUpdateLongTipVisibility(0);
        this.f41009t.setVisibility(0);
        this.f41009t.setText(d.z().x().v());
    }

    private void ae() {
        this.aW = (WbFaceModeProviders.isUseWillSdk() && this.f40994e.o()) ? new WbWillVideoEncodeFinishCallback() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.51
            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbWillVideoEncodeFinishCallback
            public void onEncodingComplete(final File file) {
                ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.51.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.f40996g.b() == 9) {
                            WLogger.d(a.f40983a, "already finished!return!");
                            return;
                        }
                        a.this.N = file;
                        WLogger.d(a.f40983a, "willVideo encode Ready to NEXT");
                        a.this.ag();
                    }
                });
            }
        } : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af() {
        String str;
        boolean z10;
        String str2 = f40983a;
        WLogger.i(str2, WbCloudFaceContant.CHECK_WILL_VIDEO);
        if (this.N == null) {
            WLogger.d(str2, "will video is null！");
            if (WbFaceModeProviders.isUseWillSdk() && this.f40994e.o() && this.f40994e.p()) {
                str = "willVideo is null!";
                b(-10, str);
                return;
            }
            W();
            return;
        }
        if (this.f40994e.p() && this.N.length() < 50000) {
            WLogger.e(str2, "willVideo is too small! ");
            str = "willVideo is too small!" + this.N.length();
            b(-10, str);
            return;
        }
        if (this.f40994e.r()) {
            this.Q = this.N.getAbsolutePath();
            WLogger.i(str2, "willVideoPath=" + this.Q);
            WLogger.d(str2, "upload will video!");
            z10 = true;
        } else {
            if (!this.f40994e.d()) {
                this.Q = this.N.getAbsolutePath();
                WLogger.i(str2, "willVideoPath=" + this.Q);
                W();
                return;
            }
            WLogger.d(str2, "just upload will video!");
            z10 = false;
        }
        h(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag() {
        if (this.f41000k == null) {
            return;
        }
        WLogger.d(f40983a, "readyToNext:" + this.f41000k.a());
        this.f41000k.a(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.53
            @Override // java.lang.Runnable
            public void run() {
                WLogger.d(a.f40983a, "Ready Go！");
                a.this.af();
            }
        });
    }

    private void b(float f10) {
        WLogger.d(f40983a, "setAppBrightness brightness=" + f10);
        if (getActivity() != null) {
            Window window = getActivity().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (f10 == -1.0f) {
                attributes.screenBrightness = -1.0f;
            } else {
                if (f10 <= 0.0f) {
                    f10 = 1.0f;
                }
                attributes.screenBrightness = f10 / 255.0f;
            }
            window.setAttributes(attributes);
        }
    }

    private void b(int i10, String str) {
        String str2 = f40983a;
        WLogger.i(str2, "processErrorMessage");
        this.T.a(i10);
        this.T.a(str);
        WLogger.e(str2, str);
        a(this.T);
    }

    private void b(final WbFaceInnerError wbFaceInnerError) {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.38
            @Override // java.lang.Runnable
            public void run() {
                a.this.f40996g.b(9);
                WLogger.d(a.f40983a, "camera fail, need trans thread");
                a.this.c(wbFaceInnerError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3, String str4) {
        WLogger.d(f40983a, "setCallbackAndFinished:" + str2 + "," + str4);
        this.f40996g.b(9);
        this.f40993d.e(true);
        if (this.f40993d.y() != null) {
            WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
            wbFaceVerifyResult.setIsSuccess(false);
            wbFaceVerifyResult.setOrderNo(this.f40993d.w());
            wbFaceVerifyResult.setSign(null);
            wbFaceVerifyResult.setRiskInfo(null);
            WbFaceError wbFaceError = new WbFaceError();
            wbFaceError.setDomain(str);
            wbFaceError.setCode(str2);
            wbFaceError.setDesc(str3);
            wbFaceError.setReason(str4);
            wbFaceVerifyResult.setError(wbFaceError);
            Properties properties = new Properties();
            properties.setProperty("errorDesc", wbFaceError.toString());
            this.f40993d.a(getActivity(), str2, properties);
            this.f40993d.y().onFinish(wbFaceVerifyResult);
        }
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar = this.aq;
        if (aVar != null) {
            aVar.dismiss();
            this.aq = null;
        }
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar2 = this.E;
        if (aVar2 != null) {
            aVar2.dismiss();
            this.E = null;
        }
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar3 = this.f40989ar;
        if (aVar3 != null) {
            aVar3.dismiss();
            this.f40989ar = null;
        }
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final boolean z10) {
        WLogger.d(f40983a, "checkEncodeFinished");
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.20
            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (a.this.ah) {
                    return;
                }
                if (a.this.f40996g == null || a.this.f40996g.b() != 6) {
                    if (a.this.f40996g == null) {
                        str = "mFaceVerifyStatus is NULL!";
                    } else {
                        str = "mFaceVerifyStatus.getCurStatus()=" + a.this.f40996g.b();
                    }
                    WLogger.w(a.f40983a, str);
                    return;
                }
                WLogger.d(a.f40983a, "mFaceVerifyStatus.getCurStatus()=" + a.this.f40996g.b());
                if (z10) {
                    WLogger.d(a.f40983a, "onEncodeFinish timeout!");
                    a aVar = a.this;
                    if (!aVar.i(aVar.aP)) {
                        a.this.a(false);
                        a.this.ah = true;
                        a.this.L();
                    }
                }
                a.this.a(true);
                a.this.ah = true;
                a.this.L();
            }
        });
    }

    private void b(byte[] bArr) {
        String str;
        String str2 = f40983a;
        WLogger.d(str2, "showLastPic");
        byte[] rawCamDataToJpg = RotateSetting.rawCamDataToJpg(RotateSetting.getRotate(), bArr, this.Z, this.f40984aa, true);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(rawCamDataToJpg, 0, rawCamDataToJpg.length);
        if (decodeByteArray != null) {
            Bitmap a10 = com.tencent.cloud.huiyansdkface.facelight.c.b.a.a(getActivity(), decodeByteArray);
            if (a10 != null) {
                a(a10);
                return;
            }
            str = "showLastPic blur is null";
        } else {
            str = "onPreviewFrame bitmap is null";
        }
        WLogger.e(str2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(WbFaceInnerError wbFaceInnerError) {
        if (this.f40993d.t()) {
            return;
        }
        String str = f40983a;
        WLogger.d(str, "failToResultPage goToResultPage");
        this.f40996g.b(9);
        Properties properties = new Properties();
        properties.setProperty("errorDesc", wbFaceInnerError.toString());
        this.f40993d.a(getActivity(), wbFaceInnerError.code, properties);
        if (this.f40994e.l()) {
            this.f40993d.e(true);
            if (this.f40993d.y() != null) {
                WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
                wbFaceVerifyResult.setIsSuccess(false);
                wbFaceVerifyResult.setError(wbFaceInnerError.toWbFaceError());
                this.f40993d.y().onFinish(wbFaceVerifyResult);
            }
        } else {
            WLogger.d(str, "failToResultPage Activity is die?" + (getActivity() == null || getActivity().isFinishing()));
            this.f40993d.e(true);
            if (this.f40993d.y() != null) {
                WbFaceVerifyResult wbFaceVerifyResult2 = wbFaceInnerError.toWbFaceVerifyResult();
                wbFaceVerifyResult2.setOrderNo(this.f40993d.w());
                WbFaceWillModeResult wbFaceWillModeResult = null;
                if (WbFaceModeProviders.isUseWillSdk()) {
                    wbFaceWillModeResult = wbFaceVerifyResult2.getWillResult();
                    if (this.f40994e.o()) {
                        wbFaceWillModeResult.setVideoPath(this.Q);
                    }
                }
                wbFaceVerifyResult2.setWillResult(wbFaceWillModeResult);
                this.f40993d.y().onFinish(wbFaceVerifyResult2);
            }
        }
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z10) {
        if (this.aW != null) {
            this.aW = null;
        }
        WbFaceModeProviders.faceMode().stopWill(getChildFragmentManager());
        this.f40993d.b(false);
        ad();
        S();
        if (z10) {
            this.f40996g.b(9);
        }
    }

    private boolean c(String str) {
        String str2 = f40983a;
        WLogger.d(str2, "initYoutuReflectLiveness:" + YTAGReflectLiveCheckJNIInterface.FRVersion());
        int initModel = YTAGReflectLiveCheckInterface.initModel(str);
        if (initModel == 0) {
            return true;
        }
        WLogger.e(str2, "failed to init reflect sdk " + initModel);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str) {
        KycWaSDK kycWaSDK;
        Activity activity;
        String str2;
        if (getActivity() != null) {
            if (this.E == null) {
                String A = this.f40994e.A();
                String B = this.f40994e.B();
                String C = this.f40994e.C();
                String D = this.f40994e.D();
                if (TextUtils.isEmpty(A) && (A = this.f40993d.e().l()) == null) {
                    A = this.f40993d.f().kyc_confirm_exit;
                }
                if (TextUtils.isEmpty(B) && (B = this.f40993d.e().m()) == null) {
                    B = this.f40993d.f().kyc_waiting;
                }
                if (TextUtils.isEmpty(C) && (C = this.f40993d.e().n()) == null) {
                    C = this.f40993d.f().kyc_make_sure;
                }
                if (TextUtils.isEmpty(D) && (D = this.f40993d.e().o()) == null) {
                    D = this.f40993d.f().kyc_cancel;
                }
                com.tencent.cloud.huiyansdkface.facelight.ui.widget.a d10 = new com.tencent.cloud.huiyansdkface.facelight.ui.widget.a(getActivity(), d.z().e().u()).a(A).b(B).c(C).d(D);
                this.E = d10;
                d10.getWindow().setBackgroundDrawableResource(R.color.wbcf_translucent_background);
            }
            this.E.a(new a.InterfaceC0627a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.40
                @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0627a
                public void a() {
                    KycWaSDK kycWaSDK2;
                    Activity activity2;
                    String str3;
                    String str4;
                    if (a.this.f40995f.contains("3")) {
                        a.this.aF.b();
                    }
                    if (a.this.f40996g.b() == 6) {
                        kycWaSDK2 = KycWaSDK.getInstance();
                        activity2 = a.this.getActivity();
                        str3 = str;
                        str4 = "uploadpage_exit_self";
                    } else if (a.this.f40996g.b() != 5) {
                        kycWaSDK2 = KycWaSDK.getInstance();
                        activity2 = a.this.getActivity();
                        str3 = str;
                        str4 = "facepage_exit_self";
                    } else if (a.this.f40993d.d()) {
                        kycWaSDK2 = KycWaSDK.getInstance();
                        activity2 = a.this.getActivity();
                        str3 = str;
                        str4 = "willpage_answer_exit_self";
                    } else {
                        kycWaSDK2 = KycWaSDK.getInstance();
                        activity2 = a.this.getActivity();
                        str3 = str;
                        str4 = "willpage_exit_self";
                    }
                    kycWaSDK2.trackCustomKVEvent(activity2, str4, str3, null);
                    a.this.b(WbFaceError.WBFaceErrorDomainNativeProcess, WbFaceError.WBFaceErrorCodeUserCancle, "用户取消", str);
                }

                @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0627a
                public void b() {
                    KycWaSDK kycWaSDK2;
                    Activity activity2;
                    String str3;
                    if (a.this.f40996g.b() == 5) {
                        kycWaSDK2 = KycWaSDK.getInstance();
                        activity2 = a.this.getActivity();
                        str3 = "willpage_exit_comfirm_cancel";
                    } else {
                        kycWaSDK2 = KycWaSDK.getInstance();
                        activity2 = a.this.getActivity();
                        str3 = "facepage_exit_comfirm_cancel";
                    }
                    kycWaSDK2.trackCustomKVEvent(activity2, str3, null, null);
                    if (a.this.E != null) {
                        a.this.E.dismiss();
                    }
                }
            });
            if (getActivity() == null || getActivity().isFinishing()) {
                return;
            }
            this.E.show();
            if (this.f40996g.b() == 5) {
                kycWaSDK = KycWaSDK.getInstance();
                activity = getActivity();
                str2 = "willpage_exit_comfirm_show";
            } else {
                kycWaSDK = KycWaSDK.getInstance();
                activity = getActivity();
                str2 = "facepage_exit_comfirm_show";
            }
            kycWaSDK.trackCustomKVEvent(activity, str2, null, null);
        }
    }

    private void d(boolean z10) {
        if (this.f40996g.b() == 9) {
            WLogger.d(f40983a, "On finish Step,No more works!");
            return;
        }
        String str = f40983a;
        WLogger.d(str, "startFaceUpload!");
        this.f40993d.a(true);
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "uploadpage_enter", null, null);
        if (this.f40994e.l()) {
            WLogger.d(str, "simple sdk mode wrap");
            g(z10);
        } else if (!this.f40994e.S()) {
            f(z10);
        } else {
            WLogger.d(str, "cus sdk mode wrap");
            e(z10);
        }
    }

    private void e(String str) {
        ab();
        this.f41008s.setText(str);
    }

    private void e(boolean z10) {
        String str = f40983a;
        WLogger.d(str, "startCusEncryAndReturn");
        String t2 = this.f40993d.e().t();
        this.aG = new SelectData(Float.valueOf(aa()).floatValue());
        WLogger.d(str, "selectData=" + this.aG.toString());
        FlashReq flashReq = new FlashReq();
        flashReq.colorData = this.f40994e.M();
        flashReq.liveSelectData = this.aG;
        flashReq.reflectData = this.aH;
        flashReq.liveImage = this.am;
        flashReq.eyeImage = this.an;
        flashReq.mouthImage = this.ao;
        CusRequestBody cusRequestBody = new CusRequestBody();
        WLogger.d(str, "deviceInfo=" + cusRequestBody.deviceInfo);
        if ("1".equals(this.f40993d.x().a())) {
            cusRequestBody.showAuth = "1";
        }
        cusRequestBody.activeType = this.f40994e.R();
        cusRequestBody.luxJudge = t2;
        cusRequestBody.flashReqDTO = flashReq;
        cusRequestBody.transSwitch = "1";
        byte[] byteArray = this.aN.toByteArray();
        byte[] videoByte = WeMediaManager.getInstance().getVideoByte();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ytVieo.len=");
        sb2.append(byteArray == null ? "null" : Integer.valueOf(byteArray.length));
        WLogger.d(str, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("wbVieo.len=");
        sb3.append(videoByte == null ? "null" : Integer.valueOf(videoByte.length));
        WLogger.d(str, sb3.toString());
        String str2 = null;
        try {
            cusRequestBody.userVideoStr = Base64.encodeToString(byteArray, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            WLogger.w(f40983a, "返回base64 string exception：" + e2.toString());
            KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_encrypt_error", "视频编码失败,返回base64 string exception：" + e2.toString(), null);
        }
        if (!z10 && videoByte != null && videoByte.length != 0) {
            try {
                cusRequestBody.wbVideoStr = Base64.encodeToString(videoByte, 0);
                cusRequestBody.rotate = Param.getRolateInfo();
            } catch (Exception e10) {
                e10.printStackTrace();
                WLogger.w(f40983a, "返回base64 string exception：" + e10.toString());
                KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_encrypt_error", "视频编码失败,返回base64 string exception：" + e10.toString(), null);
            }
        }
        String str3 = f40983a;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("param.userVideoStr=");
        String str4 = cusRequestBody.userVideoStr;
        sb4.append(str4 == null ? "null" : Integer.valueOf(str4.length()));
        WLogger.d(str3, sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("param.wbVideoStr=");
        String str5 = cusRequestBody.wbVideoStr;
        sb5.append(str5 != null ? Integer.valueOf(str5.length()) : "null");
        WLogger.d(str3, sb5.toString());
        String generateAESKey = WbCloudNetSecurityManger.generateAESKey();
        String encryptAESKey = WbCloudNetSecurityManger.encryptAESKey(false, generateAESKey, "cus faceCompare:");
        try {
            str2 = WbCloudNetSecurityManger.base64Encry(false, new WeJson().toJson(cusRequestBody), generateAESKey);
        } catch (Exception e11) {
            e11.printStackTrace();
            WLogger.w(f40983a, "encry request failed:" + e11.toString());
            KycWaSDK.getInstance().trackCustomKVEvent(null, "faceservice_data_serialize_encry_fail", "encry GetFaceResult failed!" + e11.toString(), null);
        }
        final WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
        wbFaceVerifyResult.setIsSuccess(true);
        if (this.f40993d.e().w()) {
            wbFaceVerifyResult.setUserImageString(this.am.image);
        }
        WbCusFaceVerifyResult wbCusFaceVerifyResult = new WbCusFaceVerifyResult();
        wbCusFaceVerifyResult.setEncryptAESKey(encryptAESKey);
        wbCusFaceVerifyResult.setIdentityStr(str2);
        wbFaceVerifyResult.setCusResult(wbCusFaceVerifyResult);
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.33
            @Override // java.lang.Runnable
            public void run() {
                a.this.C.b().a(50, new b.a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.33.1
                    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.b.a
                    public void a() {
                        a.this.f40993d.e(true);
                        if (a.this.f40993d.y() != null) {
                            a.this.f40993d.a(a.this.getActivity(), "0", (Properties) null);
                            a.this.f40993d.y().onFinish(wbFaceVerifyResult);
                        }
                        a.this.Q();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i10) {
        com.tencent.cloud.huiyansdkface.facelight.process.b.a(i10, new b.InterfaceC0623b() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.10
            @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.InterfaceC0623b
            public void a() {
                WLogger.d(a.f40983a, "start success!");
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.InterfaceC0623b
            public void a(int i11, String str, String str2) {
            }
        });
    }

    private void f(boolean z10) {
        if (this.f40996g.b() == 9) {
            WLogger.d(f40983a, "On finish Step,No more startNetworkUpload!");
        } else {
            WLogger.d(f40983a, "startNetworkUpload");
            this.f40998i.a(z10, aa(), this.aN.toByteArray(), this.aH, this.am, this.an, this.ao, this.H, this.O, this.P, this.L, this.M, new ProcessCallback<FaceWillResult>() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.35
                @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(FaceWillResult faceWillResult) {
                    KycWaSDK.getInstance().trackCustomKVEvent(a.this.aV, "facepage_upload_result", "0", null);
                    a.this.a(true, faceWillResult, (WbFaceInnerError) null);
                }

                @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
                public void onFailed(WbFaceInnerError wbFaceInnerError) {
                    Properties properties = new Properties();
                    properties.setProperty("msg", wbFaceInnerError.reason);
                    KycWaSDK.getInstance().trackCustomKVEvent(a.this.aV, "facepage_upload_result", wbFaceInnerError.code, properties);
                    a.this.a(false, (FaceWillResult) null, wbFaceInnerError);
                }

                @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
                public void onUiNetworkRetryTip() {
                    if (a.this.f41014y.getVisibility() != 0) {
                        WLogger.d(a.f40983a, "show network bad tips.");
                        a.this.f41014y.setVisibility(0);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i10) {
        if (!this.f40993d.v()) {
            WLogger.d(f40983a, "DONT playActTipVoice");
        } else {
            WLogger.d(f40983a, "playActTipVoice");
            e(i10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g(boolean r18) {
        /*
            Method dump skipped, instructions count: 1058
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.g(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i10) {
        WLogger.d(f40983a, "updataLightState:cur=" + this.aE + ",update:" + i10);
        this.aE = i10;
        FaceVerifyStatus faceVerifyStatus = this.f40996g;
        if (faceVerifyStatus != null) {
            faceVerifyStatus.a(i10);
        }
    }

    private void h(boolean z10) {
        this.f40998i.a(this.aV, z10, this.N, new ProcessCallback() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.52
            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onFailed(WbFaceInnerError wbFaceInnerError) {
                a.this.a(false, (FaceWillResult) null, wbFaceInnerError);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onSuccess(Object obj) {
                a.this.W();
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.ProcessCallback
            public void onUiNetworkRetryTip() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(int i10) {
        int ad2 = this.f40993d.e().ad();
        String str = f40983a;
        WLogger.d(str, "action framesize:" + i10 + ",request num:" + ad2);
        if (i10 >= ad2) {
            return true;
        }
        WLogger.w(str, "frame size < request,dont encode!");
        return false;
    }

    private void j(int i10) {
        YTFaceTracker yTFaceTracker = this.f41001l;
        if (yTFaceTracker == null) {
            return;
        }
        YTFaceTracker.Param param = yTFaceTracker.getParam();
        param.detInterval = i10;
        this.f41001l.setParam(param);
    }

    private int u() {
        return this.Z;
    }

    private int v() {
        return this.f40984aa;
    }

    private void w() {
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.c cVar = new com.tencent.cloud.huiyansdkface.facelight.ui.widget.c(this.aV);
        this.f40992c = cVar;
        cVar.a(new com.tencent.cloud.huiyansdkface.facelight.c.b.f(this.f40993d, getActivity(), this.f40996g));
    }

    private void x() {
        String str;
        String str2 = f40983a;
        WLogger.d(str2, "initUploadPrepare");
        if (WbFaceModeProviders.isUseWillSdk() && this.f40994e.o()) {
            this.f41000k = new com.tencent.cloud.huiyansdkface.facelight.c.d(2);
            str = "uploadPrepare need 2 prepare";
        } else {
            this.f41000k = new com.tencent.cloud.huiyansdkface.facelight.c.d(1);
            str = "uploadPrepare need 1 prepare";
        }
        WLogger.d(str2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        String str = f40983a;
        WLogger.d(str, "initWbVideoRecord");
        this.aL = false;
        int i10 = 25;
        if (this.f40994e.m()) {
            WLogger.d(str, "record wbVideo");
            this.aL = true;
            long W = this.f40993d.e().W();
            WLogger.i(str, "record time=" + W);
            if (W > 1000) {
                WLogger.d(str, "upload longer wbVideo!");
                this.aM = true;
            }
            float f10 = ((float) W) / 1000.0f;
            i10 = (int) (25 * f10);
            WLogger.d(str, "num=" + f10 + ",maxFameNum=" + i10);
        } else {
            WLogger.i(str, "not record wbVideo");
        }
        if (this.aL) {
            WeMediaManager.getInstance().init(i10);
        }
    }

    private boolean z() {
        String str = this.f40995f;
        if (str == null || !str.contains("3")) {
            if (A() && B()) {
                return true;
            }
        } else if (A() && B() && c("youtu_ios_0823")) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.a.c
    public RectF a(Rect rect) {
        return this.C.a(rect);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.b
    public void a(float f10) {
        String str = f40983a;
        WLogger.d(str, "onFinishPath");
        this.aZ = f10;
        WLogger.d(str, "totalScale=" + f10 + "," + this.aZ);
        float width = this.D.getBorderRect().width();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("w=");
        sb2.append(width);
        WLogger.d(str, sb2.toString());
        this.C.setCamViewWidth(width);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f41005p.getLayoutParams();
        int left = this.f41005p.getLeft();
        int i10 = (int) this.D.getBorderRect().top;
        layoutParams.setMargins(left, i10, this.f41005p.getRight(), this.f41005p.getBottom());
        this.f41005p.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f41006q.getLayoutParams();
        int left2 = this.f41006q.getLeft();
        int i11 = (int) this.D.getBorderRect().bottom;
        layoutParams2.setMargins(left2, i11, this.f41006q.getRight(), this.f41006q.getBottom());
        this.f41006q.setLayoutParams(layoutParams2);
        if (this.ai) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f41007r.getLayoutParams();
        layoutParams3.height = i11 - i10;
        this.f41007r.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f41007r.getLayoutParams();
        layoutParams4.setMargins(this.f41007r.getLeft(), i10, this.f41007r.getRight(), this.f41007r.getBottom());
        this.f41007r.setLayoutParams(layoutParams4);
        this.ai = true;
    }

    public void a(int i10, final int i11, final int i12, int i13) {
        String str = f40983a;
        WLogger.d(str, "??Init encoder");
        long currentTimeMillis = System.currentTimeMillis();
        if (i13 == 1 && (i10 == 5 || i10 == 6 || i10 == 7 || i10 == 8)) {
            i12 = i11;
            i11 = i12;
        }
        if (!this.aO.isEncodingStarted()) {
            WLogger.i(str, "codec info: rotatedWith: " + i11 + ",rotatedHeight: " + i12 + " bitrate: " + this.aQ + " framerate" + this.aR + " iframeinterval" + this.aS);
            this.aX.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.48
                @Override // java.lang.Runnable
                public void run() {
                    a.this.aO.startEncodingH264(i11, i12, a.this.aN, a.this.aQ, a.this.aR, a.this.aS);
                }
            });
            KycWaSDK kycWaSDK = KycWaSDK.getInstance();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(System.currentTimeMillis() - currentTimeMillis);
            sb2.append("ms");
            kycWaSDK.trackCustomKVEvent(null, "facepage_ytvideo_encoder_init", sb2.toString(), null);
        }
        WLogger.d(str, "finish init Encoder");
    }

    public void a(final Bitmap bitmap) {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.9
            @Override // java.lang.Runnable
            public void run() {
                a.this.C.setBlurImageView(bitmap);
                a.this.C.c();
            }
        });
    }

    public void a(com.tencent.cloud.huiyansdkface.facelight.b.b bVar) {
        WbFaceInnerError create;
        String d10;
        StringBuilder sb2;
        String str;
        if (getActivity() == null) {
            return;
        }
        int b4 = bVar.b();
        if (b4 == -10) {
            KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "camera_file_size_error", "视频大小不满足要求：" + bVar.c(), null);
            WLogger.e(f40983a, "FILE_SIZE_ERROR," + bVar.c());
            create = WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainNativeProcess, WbFaceError.WBFaceErrorCodeMediaFileError, "视频大小不满足要求，请清理内存或重启设备后重试。", "FILE_SIZE_ERROR," + bVar.c());
        } else {
            if (b4 != -2 && b4 != -1) {
                this.S = true;
                return;
            }
            if (this.S) {
                WLogger.w(f40983a, "restart camera error:" + bVar.c());
                KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "camera_restart_error", bVar.c(), null);
                d10 = d(R.string.wbcf_open_camera_permission);
                sb2 = new StringBuilder();
                str = "restart camera error,";
            } else {
                KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "camera_init_failed", bVar.c(), null);
                String str2 = f40983a;
                StringBuilder sb3 = new StringBuilder();
                str = "open/preview failed,";
                sb3.append("open/preview failed,");
                sb3.append(bVar.c());
                WLogger.e(str2, sb3.toString());
                d10 = d(R.string.wbcf_open_camera_permission);
                sb2 = new StringBuilder();
            }
            sb2.append(str);
            sb2.append(bVar.c());
            create = WbFaceInnerError.create(WbFaceError.WBFaceErrorDomainNativeProcess, WbFaceError.WBFaceErrorCodeCameraException, d10, sb2.toString());
        }
        b(create);
    }

    public void a(com.tencent.cloud.huiyansdkface.facelight.process.c.c cVar) {
        String str = f40983a;
        WLogger.i(str, "encodeVideo");
        long currentTimeMillis = System.currentTimeMillis();
        int rotate = RotateSetting.getRotate();
        int u10 = u();
        int v2 = v();
        if (rotate == 5 || rotate == 6 || rotate == 7 || rotate == 8) {
            u10 = v();
            v2 = u();
        }
        WLogger.d(str, "收到视频上传通知，每帧width：" + u10 + " 每帧height: " + v2);
        this.aP = 0;
        for (int i10 = 0; i10 < this.aT.length; i10++) {
            this.aO.queueFrameH264(new YuvImage(this.aT[i10], 17, u10, v2, null));
            this.aO.encodeH264();
            this.aP++;
        }
        WLogger.d(f40983a, "encode finish");
        cVar.a();
        KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_ytvideo_encoder_finish", (System.currentTimeMillis() - currentTimeMillis) + "ms", null);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.a.c
    public void a(String str) {
        this.aj.setText(str);
    }

    public void a(final boolean z10) {
        WLogger.d(f40983a, "stopEncode:" + ((Object) Thread.currentThread()));
        long currentTimeMillis = System.currentTimeMillis();
        this.aX.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.49
            @Override // java.lang.Runnable
            public void run() {
                a.this.aO.stopEncodingH264();
                if (z10) {
                    return;
                }
                WLogger.d(a.f40983a, "dont output,delete origin!");
                a.this.aN.reset();
            }
        });
        if (!z10) {
            this.aM = true;
        }
        KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_ytvideo_output", (System.currentTimeMillis() - currentTimeMillis) + "ms", null);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.a
    public boolean a() {
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.at;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.at = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer2 = this.av;
        if (cloudFaceCountDownTimer2 != null) {
            cloudFaceCountDownTimer2.cancel();
            this.av = null;
        }
        WLogger.i(f40983a, "openMouth");
        e(this.f40993d.f().kyc_open_mouth);
        this.au = new CloudFaceCountDownTimer(15000L, com.huawei.openalliance.ad.ipc.c.Code) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.28
            @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
            public void onFinish() {
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
            public void onTick(long j10) {
                a.this.g(R.raw.wbcf_open_mouth);
                KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "facepage_action_tips", "openMouth", null);
            }
        }.start();
        return false;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.a.c
    public void b(final String str) {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.34
            @Override // java.lang.Runnable
            public void run() {
                a.this.ak.setText(str);
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.a
    public boolean b() {
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.at;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.at = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer2 = this.au;
        if (cloudFaceCountDownTimer2 != null) {
            cloudFaceCountDownTimer2.cancel();
            this.au = null;
        }
        WLogger.i(f40983a, "shakeHead");
        e(this.f40993d.f().kyc_shake_head);
        this.av = new CloudFaceCountDownTimer(15000L, com.huawei.openalliance.ad.ipc.c.Code) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.29
            @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
            public void onFinish() {
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
            public void onTick(long j10) {
                a.this.g(R.raw.wbcf_shake_head);
                KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "facepage_action_tips", "shakeHead", null);
            }
        }.start();
        return false;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.a
    public boolean c() {
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.av;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.av = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer2 = this.au;
        if (cloudFaceCountDownTimer2 != null) {
            cloudFaceCountDownTimer2.cancel();
            this.au = null;
        }
        WLogger.i(f40983a, "wbcf_blinking");
        e(this.f40993d.f().kyc_blink);
        this.at = new CloudFaceCountDownTimer(15000L, com.huawei.openalliance.ad.ipc.c.Code) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.30
            @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
            public void onFinish() {
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
            public void onTick(long j10) {
                a.this.g(R.raw.wbcf_blinking);
                KycWaSDK.getInstance().trackCustomKVEvent(a.this.getActivity(), "facepage_action_tips", "blink", null);
            }
        }.start();
        return false;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.a
    public boolean d() {
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.at;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.at = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer2 = this.av;
        if (cloudFaceCountDownTimer2 != null) {
            cloudFaceCountDownTimer2.cancel();
            this.av = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer3 = this.au;
        if (cloudFaceCountDownTimer3 != null) {
            cloudFaceCountDownTimer3.cancel();
            this.au = null;
        }
        WLogger.i(f40983a, "actWaitRecordEnd");
        e(this.f40993d.f().kyc_confirming);
        return false;
    }

    public void e(int i10) {
        if (getActivity() == null) {
            return;
        }
        WLogger.d(f40983a, "PlayVoice IN");
        try {
            SoundPool soundPool = new SoundPool(1, 1, 1);
            this.f41003n = soundPool;
            int load = soundPool.load(this.aV, i10, 1);
            this.f41004o = load;
            this.f41003n.setOnLoadCompleteListener(new C0626a(load));
        } catch (Exception e2) {
            e2.printStackTrace();
            WLogger.w(f40983a, "playVoice exception:" + e2.toString());
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.b
    public boolean e() {
        HeadBorderView headBorderView;
        int i10;
        String str = f40983a;
        WLogger.i(str, "=================start silentCheck======================");
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_live_type", NotificationCompat.GROUP_KEY_SILENT, null);
        M();
        if (this.f40994e.J().equals("custom")) {
            headBorderView = this.D;
            i10 = R.color.wbcf_custom_border;
        } else {
            headBorderView = this.D;
            i10 = R.color.wbcf_sdk_base_blue;
        }
        headBorderView.a(c(i10));
        if (this.f40994e.m() || this.f40993d.e().x()) {
            ab();
            this.f41008s.setText(this.f40993d.f().kyc_confirming);
            return false;
        }
        WLogger.i(str, "=================end silentCheck======================");
        this.f40996g.j();
        return false;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.b
    public boolean f() {
        HeadBorderView headBorderView;
        int i10;
        WLogger.i(f40983a, "=================start actDetect======================");
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_live_type", SocialConstants.PARAM_ACT, null);
        j(20);
        this.f40996g.b(true);
        M();
        if (this.f40994e.J().equals("custom")) {
            headBorderView = this.D;
            i10 = R.color.wbcf_custom_border;
        } else {
            headBorderView = this.D;
            i10 = R.color.wbcf_sdk_base_blue;
        }
        headBorderView.a(c(i10));
        this.f40996g.b(this.f40994e.R());
        this.f40996g.k();
        return false;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.b
    public boolean g() {
        HeadBorderView a10;
        int i10;
        String str = f40983a;
        WLogger.i(str, "=================start faceLight======================");
        T();
        if (this.f40993d.t()) {
            WLogger.w(str, "before light,already finishVerify,RETURN");
            return false;
        }
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_live_type", Attributes.UiMode.LIGHT, null);
        M();
        this.f41008s.setText(this.f40993d.f().kyc_dimmer);
        this.f41008s.setTextColor(c(R.color.wbcf_white));
        this.f41009t.setTextColor(c(R.color.wbcf_white));
        if (WbCloudFaceContant.BLACK.equals(this.f40994e.J()) && this.G) {
            this.f41011v.setBackgroundResource(R.drawable.wbcf_customer_long_tip_bg_white);
            this.f41012w.setTextColor(c(R.color.wbcf_guide_text));
        }
        this.aF.setVisibility(0);
        if (this.f40994e.J().equals("custom")) {
            a10 = this.aF.a();
            i10 = R.color.wbcf_custom_border;
        } else {
            a10 = this.aF.a();
            i10 = R.color.wbcf_sdk_base_blue;
        }
        a10.a(c(i10));
        J();
        return false;
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.c
    public void h() {
        String str = f40983a;
        WLogger.i(str, "=================start preview======================");
        if (!this.f40993d.e().v()) {
            e(R.raw.wbcf_keep_face_in);
            this.f41008s.setText(this.f40993d.f().kyc_aim);
        }
        ab();
        this.f41009t.setText(this.f40994e.v());
        long Y = d.z().e().Y();
        WLogger.d(str, "verify back showTime=" + Y);
        this.aw = new CloudFaceCountDownTimer(Y, Y) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.21
            @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
            public void onFinish() {
                WLogger.d(a.f40983a, "verify back show!");
                a.this.f41013x.setVisibility(0);
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
            public void onTick(long j10) {
            }
        }.start();
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.c
    public void i() {
        WLogger.i(f40983a, "====================findFace====================");
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_predetect_enter", null, null);
        j(5);
        if (this.aL) {
            WeMediaManager.getInstance().stop(false);
        }
        com.tencent.cloud.huiyansdkface.facelight.process.a aVar = this.f40999j;
        if (aVar != null) {
            aVar.a(false);
            if (!this.f40993d.q()) {
                this.f40999j.b();
            }
        }
        this.f40993d.d(false);
        if (this.F) {
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar2 = this.aq;
            if (aVar2 != null) {
                aVar2.dismiss();
                this.aq = null;
            }
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar3 = this.E;
            if (aVar3 != null) {
                aVar3.dismiss();
                this.E = null;
            }
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar4 = this.f40989ar;
            if (aVar4 != null) {
                aVar4.dismiss();
                this.f40989ar = null;
            }
            String str = this.f40995f;
            if (str == null || !str.contains("3")) {
                return;
            }
            this.aF.setVisibility(8);
            h(0);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.c
    public void j() {
        String str = f40983a;
        WLogger.i(str, "====================Prepare start==========================");
        this.f41008s.setText("");
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_face_prepare", null, null);
        if (this.as != null) {
            WLogger.d(str, "Prepare cancel timeoutCdt");
            this.as.cancel();
            this.as = null;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.c
    public void k() {
        HeadBorderView headBorderView;
        int i10;
        String str = f40983a;
        WLogger.i(str, "=================start liveCheck======================");
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_detect_enter", null, this.al);
        if (this.as != null) {
            WLogger.d(str, "liveCheck cancel timeoutCdt");
            this.as.cancel();
            this.as = null;
        }
        O();
        M();
        if (this.f40994e.J().equals("custom")) {
            headBorderView = this.D;
            i10 = R.color.wbcf_custom_border;
        } else {
            headBorderView = this.D;
            i10 = R.color.wbcf_sdk_base_blue;
        }
        headBorderView.a(c(i10));
        this.f40996g.a(this.f40995f);
        this.f40996g.j();
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.c
    public void l() {
        KycWaSDK kycWaSDK;
        Context context;
        String str;
        String str2 = f40983a;
        WLogger.i(str2, "=================willExpress " + this.R + "=================");
        if (this.as != null) {
            WLogger.d(str2, "willExpress cancel timeoutCdt");
            this.as.cancel();
            this.as = null;
        }
        ac();
        this.f41010u.setVisibility(0);
        this.N = null;
        x();
        com.tencent.cloud.huiyansdkface.facelight.a.a.b e2 = this.f40993d.e();
        float q10 = this.f40993d.x().q();
        if (q10 < 0.1d || q10 > 1.0f) {
            WLogger.d(str2, "set maxWillPlayVolume:" + q10 + " illegal,use cdn set.");
            q10 = e2.aw();
        }
        WillParam willParam = new WillParam();
        willParam.setCamWidth(u()).setCamHeight(v()).setCamRotate(this.f40986ac).setPreviewPicWidth(this.C.getWidth()).setPreviewPicHeight(this.C.getHeight()).setWillVideoBitrateFactor(e2.al()).setLeft(this.C.getLeft()).setTop(this.C.getTop()).setBorderTop((int) this.D.getBorderRect().top).setScale(this.aZ).setLowestPlayVolThre(e2.av()).setScreenshotTime(e2.au()).setPassVolCheck(e2.c()).setAsrRequestTimeout(e2.am()).setAsrRequestRetryCount(e2.an()).setAsrCurCount(this.R).setAsrRetryCount(e2.aq()).setWillType(this.H).setQuestion(this.I).setAnswer(this.J).setAudio(this.K).setRecordWillVideo(this.f40994e.o()).setScreenshot(e2.e()).setPlayVolThreshold(q10).setMuteTimeout(e2.ay()).setMuteThreshold(e2.ax()).setMuteWaitTime(e2.az()).setPlayModeWaitTime(e2.at());
        ae();
        if (this.R == 0) {
            kycWaSDK = KycWaSDK.getInstance();
            context = this.aV;
            str = "willservice_start";
        } else {
            kycWaSDK = KycWaSDK.getInstance();
            context = this.aV;
            str = "willservice_start_retry";
        }
        kycWaSDK.trackCustomKVEvent(context, str, null, null);
        this.f40993d.b(true);
        WbFaceModeProviders.faceMode().startWill(getChildFragmentManager(), R.id.wbcf_face_will_container, willParam, this.aW, new WbWillFinishCallback() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.24
            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbWillFinishCallback
            public void onAnswerErrorRestart() {
                ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.24.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.getActivity() == null || a.this.getActivity().isFinishing()) {
                            return;
                        }
                        a.this.N();
                    }
                });
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbWillFinishCallback
            public void onFinish(final String str3, final String str4, final String str5, final String str6) {
                WLogger.d(a.f40983a, "will finished!");
                ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.24.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.O = str3;
                        a.this.P = str4;
                        a.this.L = str5;
                        a.this.M = str6;
                        WbFaceModeProviders.faceMode().stopWill(a.this.getChildFragmentManager());
                        a.this.f40993d.b(false);
                        a.this.ad();
                        a.this.f40996g.b(6);
                    }
                });
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbWillFinishCallback
            public void onNativeException(final WbFaceInnerError wbFaceInnerError) {
                WLogger.d(a.f40983a, "will onNativeException:" + wbFaceInnerError.reason);
                ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.24.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WbFaceModeProviders.faceMode().stopWill(a.this.getChildFragmentManager());
                        a.this.f40993d.b(false);
                        if (a.this.aW != null) {
                            a.this.aW = null;
                        }
                        a.this.ad();
                        a.this.c(wbFaceInnerError);
                    }
                });
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbWillFinishCallback
            public void onNoVoiceRestart(final WbFaceInnerError wbFaceInnerError) {
                WLogger.d(a.f40983a, "will onRestart");
                ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.24.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.getActivity() == null || a.this.getActivity().isFinishing()) {
                            return;
                        }
                        a.this.c(true);
                        a.this.a(wbFaceInnerError);
                    }
                });
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbWillFinishCallback
            public void onStartAsr() {
                ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.24.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.T(a.this);
                    }
                });
            }
        }, new WbWillProcessCallback() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.25
            @Override // com.tencent.cloud.huiyansdkface.facelight.provider.WbWillProcessCallback
            public void onEnterWillAnswer() {
                a.this.f40993d.c(true);
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.c
    public void m() {
        String str = f40983a;
        WLogger.i(str, "=================upload=================");
        b(this.aU);
        ac();
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.aw;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.aw = null;
        }
        this.f41013x.setVisibility(8);
        this.f41008s.setText(this.f40993d.f().kyc_not_exit);
        this.f41009t.setText(this.f40994e.w());
        ab();
        String J = this.f40994e.J();
        if (WbCloudFaceContant.BLACK.equals(J)) {
            this.D.a(c(R.color.wbcf_initial_border));
            if (this.G) {
                this.f41011v.setBackgroundResource(R.drawable.wbcf_customer_long_tip_bg);
                this.f41012w.setTextColor(c(R.color.wbcf_guide_text_black));
            }
        } else if (WbCloudFaceContant.WHITE.equals(J)) {
            this.D.a(c(R.color.wbcf_initial_border));
        } else if ("custom".equals(J)) {
            this.D.c(c(R.color.wbcf_custom_initial_border));
        }
        this.C.b().setVisibility(0);
        float top = this.C.getTop();
        float f10 = this.D.getBorderRect().bottom;
        float height = this.D.getBorderRect().height();
        float bottom = this.C.getBottom() - f10;
        WLogger.d(str, "top=" + top + ";bottom=" + f10 + ";height=" + height + ";init=" + bottom + ";end =" + height);
        this.C.b().setInitHeight(bottom);
        this.C.b().setEndHeight(height);
        int i10 = 1000;
        com.tencent.cloud.huiyansdkface.facelight.c.d.c cVar = this.f40987ad;
        if (cVar != null && cVar.b()) {
            WLogger.d(str, "upload need wait camToken.");
            i10 = 1000 + this.f40993d.e().F();
        }
        WLogger.d(str, "final loading time=" + i10);
        this.C.b().a(i10, 0.6f);
        Param.appendBlinkInfo(this.f40993d.e().H());
        Param.appendGmInfo();
        WLogger.d(str, "upload Ready to NEXT");
        ag();
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.c
    public void n() {
        String str = f40983a;
        WLogger.d(str, "outOfTime:" + this.al.toString());
        if (this.f40996g.f()) {
            WLogger.d(str, "ActiveDetect outOfTime");
            KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_exit_timeout", "动作检测超时", null);
            b(WbFaceError.WBFaceErrorDomainNativeProcess, WbFaceError.WBFaceErrorCodeActOutOfTime, "动作检测超时", "动作检测超时");
        } else {
            WLogger.d(str, "FindFace outOfTime");
            KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_exit_timeout", "预检测超时", this.al);
            b(WbFaceError.WBFaceErrorDomainNativeProcess, WbFaceError.WBFaceErrorCodeFindFaceOutOfTime, "人脸在框检测超时", "预检测人脸超时");
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.c
    public void o() {
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_exit_timeout", WbFaceError.WBFaceErrorCodeOutOfControlNum, null);
        b(WbFaceError.WBFaceErrorDomainNativeProcess, WbFaceError.WBFaceErrorCodeOutOfControlNum, "风险控制超出次数", "风险控制超出次数");
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.a.b, android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        WLogger.i(f40983a, "onConfigurationChanged");
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar = this.aq;
        if (aVar != null) {
            aVar.dismiss();
            this.aq = null;
        }
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar2 = this.E;
        if (aVar2 != null) {
            aVar2.dismiss();
            this.E = null;
        }
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_configuration_changed", null, null);
        Z();
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        String str = f40983a;
        WLogger.d(str, "onCreate");
        super.onCreate(bundle);
        Context applicationContext = getActivity().getApplicationContext();
        this.aV = applicationContext;
        this.af = new com.tencent.cloud.huiyansdkface.facelight.c.a.b(applicationContext);
        KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_enter", null, null);
        d z10 = d.z();
        this.f40993d = z10;
        if (this.F) {
            z10.a(false);
        }
        this.f40994e = this.f40993d.x();
        FaceVerifyStatus faceVerifyStatus = new FaceVerifyStatus(this, this, this);
        this.f40996g = faceVerifyStatus;
        faceVerifyStatus.a(new com.tencent.cloud.huiyansdkface.facelight.process.b.e() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.1
            @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.e
            public void a(int i10) {
                WbFaceModeProviders.faceMode().onFaceStatusChanged(i10);
            }
        });
        WbFaceModeProviders.faceMode().onEnterFaceLivePage(this.f40993d.f());
        this.f40997h = new com.tencent.cloud.huiyansdkface.facelight.process.e.a(this.f40993d, this.f40996g);
        this.f40998i = new com.tencent.cloud.huiyansdkface.facelight.process.a.a(this.f40993d, this.f40996g);
        this.f40995f = this.f40993d.x().N();
        this.aU = R();
        WLogger.d(str, "sceen origin bright=" + this.aU + ",set full brightness");
        b(255.0f);
        w();
        this.aN = new ByteArrayOutputStream();
        this.aO = new VideoEncoder(null, true);
        x();
        boolean z11 = z();
        this.f41002m = z11;
        if (!z11) {
            b(WbFaceError.WBFaceErrorDomainNativeProcess, WbFaceError.WBFaceErrorCodeInitModel, "初始化模型失败，请重试", "初始化模型失败");
        } else {
            KycWaSDK.getInstance().trackCustomKVEvent(getActivity(), "facepage_model_init", "initYoutu model success", null);
            C();
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        String str = f40983a;
        WLogger.i(str, "onDestroy");
        M();
        WbFaceModeProviders.faceMode().onQuitFaceLivePage();
        YTFaceTracker.setLoggerListener(null);
        YTPoseDetectJNIInterface.setLoggerListener(null);
        YTAGReflectLiveCheckJNIInterface.setLoggerListener(null);
        if (this.f40999j != null) {
            WLogger.d(str, "onDestroy release FaceDetect.");
            this.f40999j.a();
        }
        com.tencent.cloud.huiyansdkface.facelight.c.b.b.a(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.19
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f41001l != null) {
                    WLogger.d(a.f40983a, "yttracker destroy");
                    a.this.a(a.f40983a, "yttracker destroy");
                    a.this.f41001l.destroy();
                    a.this.f41001l = null;
                }
            }
        });
    }

    @Override // android.app.Fragment
    public void onPause() {
        WLogger.d(f40983a, "onPause:" + this.f40993d.b());
        super.onPause();
        M();
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.c cVar = this.f40992c;
        if (cVar != null) {
            cVar.b();
        }
        this.f40990b.a();
        U();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        String str = f40983a;
        WLogger.d(str, "onResume");
        V();
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.c cVar = this.f40992c;
        if (cVar != null) {
            cVar.a();
        }
        this.f40990b.a(this.aV);
        if (this.aA) {
            WLogger.d(str, "register light listener");
            try {
                this.aB.registerListener(this.f40991ba, this.aC, 2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        int b4 = this.f40996g.b();
        String str2 = f40983a;
        WLogger.w(str2, "status=" + b4);
        if (b4 == 0) {
            WLogger.d(str2, "init status,go to PREVIEW");
            this.f40996g.b(1);
            return;
        }
        WLogger.w(str2, "already status=" + b4 + ",NO RESET");
    }

    @Override // android.app.Fragment
    public void onStart() {
        String str = f40983a;
        WLogger.d(str, "onStart()");
        super.onStart();
        int b4 = this.f40996g.b();
        if (b4 != 0 && b4 == 9) {
            WLogger.e(str, "already finished!");
            return;
        }
        com.tencent.cloud.huiyansdkface.a.c cVar = this.V;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        e eVar;
        String str = f40983a;
        WLogger.i(str, "onStop:" + this.f40993d.b());
        super.onStop();
        if (this.V != null) {
            WLogger.d(str, "stop mWeCamera");
            this.V.d();
            this.V.b(this.Y);
            this.V.f();
            this.V.a(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.18
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.cloud.huiyansdkface.a.b.b.a((com.tencent.cloud.huiyansdkface.a.b.a) null);
                    com.tencent.cloud.huiyansdkface.a.d.a.a((a.d) null);
                }
            });
        }
        if (this.f40993d.e().B() && (eVar = this.f40988ae) != null) {
            eVar.a();
        }
        this.f40996g.b(9);
        com.tencent.cloud.huiyansdkface.facelight.process.a aVar = this.f40999j;
        if (aVar != null) {
            aVar.a((com.tencent.cloud.huiyansdkface.facelight.ui.a.c) null);
        }
        if (this.aW != null) {
            this.aW = null;
        }
        T();
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.ay;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.ay = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer2 = this.az;
        if (cloudFaceCountDownTimer2 != null) {
            cloudFaceCountDownTimer2.cancel();
            this.ay = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer3 = this.ax;
        if (cloudFaceCountDownTimer3 != null) {
            cloudFaceCountDownTimer3.cancel();
            this.ax = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer4 = this.aw;
        if (cloudFaceCountDownTimer4 != null) {
            cloudFaceCountDownTimer4.cancel();
            this.aw = null;
        }
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar2 = this.E;
        if (aVar2 != null) {
            aVar2.dismiss();
            this.E = null;
        }
        M();
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.FaceView
    public void onUpdateErrorTip(String str) {
        this.f41010u.setText(str);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.FaceView
    public void onUpdateErrorTipTextColor(int i10) {
        this.f41010u.setTextColor(i10);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.FaceView
    public void onUpdateFaceBorder(final int i10) {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.55
            @Override // java.lang.Runnable
            public void run() {
                a.this.D.a(i10);
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.FaceView
    public void onUpdateLongTipVisibility(int i10) {
        if (this.G) {
            this.f41011v.setVisibility(i10);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.FaceView
    public void onUpdateNetworkRetry() {
        long ap = this.f40993d.e().ap();
        if (this.ay == null) {
            this.ay = new CloudFaceCountDownTimer(ap, ap / 2) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.56
                @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                public void onFinish() {
                    a.this.f41015z.setVisibility(8);
                    a.this.ay = null;
                }

                @Override // com.tencent.cloud.huiyansdkface.facelight.common.CloudFaceCountDownTimer
                public void onTick(long j10) {
                }
            };
            if (this.f41015z.getVisibility() != 0) {
                WLogger.d(f40983a, "show network bad tips.");
                this.f41015z.setVisibility(0);
                this.ay.start();
            }
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.FaceView
    public void onUpdateRealFaceRect(RectF rectF) {
        this.D.a(rectF);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.FaceView
    public void onUpdateTip(final String str) {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.45
            @Override // java.lang.Runnable
            public void run() {
                a.this.f41008s.setText(str);
                if (!a.this.al.containsKey(str)) {
                    a.this.al.put(str, 1);
                } else {
                    a.this.al.put(str, Integer.valueOf(((Integer) a.this.al.get(str)).intValue() + 1));
                }
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.provider.FaceView
    public void onUpdateTipTextColor(final int i10) {
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.54
            @Override // java.lang.Runnable
            public void run() {
                a.this.f41008s.setTextColor(i10);
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.process.b.c
    public void p() {
        String str = f40983a;
        WLogger.i(str, "finished!");
        T();
        CloudFaceCountDownTimer cloudFaceCountDownTimer = this.ay;
        if (cloudFaceCountDownTimer != null) {
            cloudFaceCountDownTimer.cancel();
            this.ay = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer2 = this.az;
        if (cloudFaceCountDownTimer2 != null) {
            cloudFaceCountDownTimer2.cancel();
            this.ay = null;
        }
        if (this.as != null) {
            WLogger.d(str, "finished cancel timeoutCdt");
            this.as.cancel();
            this.as = null;
        }
        CloudFaceCountDownTimer cloudFaceCountDownTimer3 = this.ax;
        if (cloudFaceCountDownTimer3 != null) {
            cloudFaceCountDownTimer3.cancel();
            this.ax = null;
        }
        M();
        com.tencent.cloud.huiyansdkface.facelight.process.a aVar = this.f40999j;
        if (aVar != null) {
            aVar.a(true);
        }
        if (this.aL) {
            WeMediaManager.getInstance().destroy();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.a.b
    public void q() {
        String str = f40983a;
        WLogger.d(str, "setFragmentView");
        b(R.layout.wbcf_fragment_face_live);
        if (!this.f41002m) {
            WLogger.e(str, "init yt failed! finish!");
        } else {
            WLogger.d(str, "init yt success,go to next!");
            D();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.ui.a.c
    public RectF r() {
        return this.D.getBorderRect();
    }

    public void s() {
        WLogger.e(f40983a, "setPreviewSize" + Thread.currentThread().getName());
        ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.b.a.8
            @Override // java.lang.Runnable
            public void run() {
                a.this.C.a(a.this.Z, a.this.f40984aa);
            }
        });
    }
}
