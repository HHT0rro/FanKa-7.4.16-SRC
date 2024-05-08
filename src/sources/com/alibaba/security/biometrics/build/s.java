package com.alibaba.security.biometrics.build;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.activity.BaseBioNavigatorActivity;
import com.alibaba.security.biometrics.build.d;
import com.alibaba.security.biometrics.build.v;
import com.alibaba.security.biometrics.component.AudioSettingComponent;
import com.alibaba.security.biometrics.jni.ABJniDetectResult;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView;
import com.alibaba.security.biometrics.logic.view.widget.CameraActivityWidgetParent;
import com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget;
import com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget;
import com.alibaba.security.biometrics.logic.view.widget.GuideWidget;
import com.alibaba.security.biometrics.logic.view.widget.PrivacyWidget;
import com.alibaba.security.biometrics.logic.view.widget.TitleBarWidget;
import com.alibaba.security.biometrics.service.ALBiometricsService;
import com.alibaba.security.biometrics.service.ALBiometricsServiceEventListener;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.model.ABDetectFrame;
import com.alibaba.security.biometrics.service.model.ALBiometricsType;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.service.model.result.ABImageResult;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.biometrics.service.model.result.SensorInfo;
import com.alibaba.security.biometrics.service.sensor.SensorGetter;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.beauty.IBeautyRender;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.model.LastExitTrackMsg;
import com.alibaba.security.common.track.model.LastExitTrackMsgPage;
import com.alibaba.security.common.track.model.TrackConstants;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.BytesUtils;
import com.alibaba.security.common.utils.DisplayUtils;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.common.utils.PermissionsManager;
import com.alibaba.security.common.videorecorder.OnCameraVideoReorderListener;
import com.alibaba.security.realidentity.build.aq;
import com.huawei.quickcard.base.Attributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: ALBiometricsPresenter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class s implements GLSurfaceView.Renderer, j, o, ALBiometricsActivityParentView.a, ALBiometricsServiceEventListener {

    /* renamed from: a, reason: collision with root package name */
    public static final int f2329a = 1010;

    /* renamed from: b, reason: collision with root package name */
    public static final String f2330b = "model_loading_error_code";

    /* renamed from: e, reason: collision with root package name */
    private static final String f2331e = "ALBiometricsPresenter";

    /* renamed from: f, reason: collision with root package name */
    private static final long f2332f = 500;
    private u A;
    private SurfaceTexture B;
    private v C;
    private List<Integer> E;
    private ABJniDetectResult F;
    private SensorGetter G;
    private SensorInfo H;
    private SensorInfo I;

    /* renamed from: d, reason: collision with root package name */
    public ALBiometricsActivityParentView f2334d;

    /* renamed from: g, reason: collision with root package name */
    private final Activity f2335g;

    /* renamed from: h, reason: collision with root package name */
    private d f2336h;

    /* renamed from: i, reason: collision with root package name */
    private ALBiometricsService f2337i;

    /* renamed from: j, reason: collision with root package name */
    private ALBiometricsConfig f2338j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2339k;

    /* renamed from: l, reason: collision with root package name */
    private ALBiometricsEventListener f2340l;

    /* renamed from: m, reason: collision with root package name */
    private int f2341m;

    /* renamed from: n, reason: collision with root package name */
    private ABDetectType f2342n;

    /* renamed from: p, reason: collision with root package name */
    private int f2344p;

    /* renamed from: q, reason: collision with root package name */
    private ALBiometricsParams f2345q;

    /* renamed from: r, reason: collision with root package name */
    private String f2346r;

    /* renamed from: s, reason: collision with root package name */
    private List<r> f2347s;

    /* renamed from: t, reason: collision with root package name */
    private ALBiometricsResult f2348t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f2349u;

    /* renamed from: v, reason: collision with root package name */
    private String f2350v;

    /* renamed from: w, reason: collision with root package name */
    private int f2351w;

    /* renamed from: x, reason: collision with root package name */
    private long f2352x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f2353y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f2354z;

    /* renamed from: c, reason: collision with root package name */
    public int f2333c = 0;

    /* renamed from: o, reason: collision with root package name */
    private final Runnable f2343o = new Runnable() { // from class: com.alibaba.security.biometrics.build.s.1
        @Override // java.lang.Runnable
        public final void run() {
            if (s.this.f2342n == null || !s.this.f2339k) {
                return;
            }
            ((k) l.a(k.class)).a(s.this.f2342n);
        }
    };
    private final View.OnClickListener D = new View.OnClickListener() { // from class: com.alibaba.security.biometrics.build.s.6
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            s.this.a(s.this.f2338j == null || s.this.f2338j.isShouldAlertOnExit());
        }
    };

    public s(Activity activity) {
        this.f2335g = activity;
    }

    private void A() {
        String string = this.f2335g.getResources().getString(R.string.face_detect_action_mirror);
        ALBiometricsActivityParentView aLBiometricsActivityParentView = this.f2334d;
        if (aLBiometricsActivityParentView != null) {
            aLBiometricsActivityParentView.b(string);
        }
    }

    private boolean B() {
        v vVar = this.C;
        return vVar != null && vVar.b();
    }

    private void C() {
        if (this.f2349u) {
            this.f2349u = false;
            this.f2336h.a(null, true);
            this.f2334d.f2442e.i();
        }
    }

    private void D() {
        if (N()) {
            this.f2345q.timeout = 12;
        } else {
            this.f2345q.timeout = 40;
        }
    }

    private static r E() {
        r rVar = new r();
        rVar.title = "检测中···";
        rVar.setScreenLight(1.0f);
        rVar.setColor("#FFFFFF");
        rVar.setTextColor("#333333");
        rVar.setDuration(1.0f);
        return rVar;
    }

    private static List<r> F() {
        ArrayList arrayList = new ArrayList();
        r rVar = new r();
        rVar.title = "即将进行闪屏检测，请正脸看向屏幕";
        rVar.setScreenLight(0.1f);
        rVar.setColor("#FFFFFF");
        rVar.setDuration(1.0f);
        arrayList.add(rVar);
        r rVar2 = new r();
        rVar2.title = "即将进行闪屏检测，请保持姿势不变";
        rVar2.setScreenLight(0.2f);
        rVar2.setColor("#000000");
        rVar2.setDuration(1.0f);
        arrayList.add(rVar2);
        r rVar3 = new r();
        rVar3.title = "即将进行闪屏检测，请保持姿势不变";
        rVar3.setScreenLight(1.0f);
        rVar3.setColor("#ADFF2F");
        rVar3.setDuration(1.0f);
        arrayList.add(rVar3);
        r rVar4 = new r();
        rVar4.title = "即将进行闪屏检测，请保持姿势不变";
        rVar4.setScreenLight(0.5f);
        rVar4.setColor("#000000");
        rVar4.setDuration(1.0f);
        arrayList.add(rVar4);
        r rVar5 = new r();
        rVar5.title = "即将进行闪屏检测，请保持姿势不变";
        rVar5.setScreenLight(0.5f);
        rVar5.setColor("#ADFF2F");
        rVar5.setDuration(1.0f);
        arrayList.add(rVar5);
        return arrayList;
    }

    private void G() {
        ALBiometricsEventListener aLBiometricsEventListener = this.f2340l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onBusinessOk();
        }
    }

    private void H() {
        ((BaseBioNavigatorActivity) this.f2335g).a(this.f2343o);
        ((BaseBioNavigatorActivity) this.f2335g).b(this.f2343o);
    }

    private void I() {
        ((k) l.a(k.class)).d();
        ((BaseBioNavigatorActivity) this.f2335g).a(this.f2343o);
    }

    private void J() {
        this.f2341m = 8;
        Activity activity = this.f2335g;
        if (activity instanceof Activity) {
            activity.finish();
        }
    }

    private void K() {
        h();
    }

    private void L() {
        I();
        ALBiometricsService aLBiometricsService = this.f2337i;
        if (aLBiometricsService != null) {
            aLBiometricsService.release();
        }
    }

    private boolean M() {
        ALBiometricsParams aLBiometricsParams = this.f2345q;
        if (aLBiometricsParams == null) {
            return false;
        }
        return aLBiometricsParams.needSuccessVideo || aLBiometricsParams.needFailVideo;
    }

    private boolean N() {
        return ALBiometricsType.isDazzle(this.f2345q.mBiometricsType);
    }

    private static int a(int i10) {
        return (i10 < 4000 || i10 >= 5000) ? i10 : GlobalErrorCode.ERROR_CTID;
    }

    public static /* synthetic */ int g(s sVar) {
        sVar.f2341m = 2;
        return 2;
    }

    public static /* synthetic */ boolean l(s sVar) {
        sVar.f2349u = false;
        return false;
    }

    private void o() {
        this.f2333c = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        onCancel(q());
        c();
        J();
    }

    private int q() {
        ALBiometricsActivityParentView aLBiometricsActivityParentView = this.f2334d;
        if (aLBiometricsActivityParentView == null || !aLBiometricsActivityParentView.g()) {
            return -1;
        }
        return this.f2334d.getDetectResultErrorCode();
    }

    private boolean r() {
        return q() == 0;
    }

    private LastExitTrackMsg s() {
        if (this.f2334d == null) {
            return null;
        }
        LastExitTrackMsg lastExitTrackMsg = new LastExitTrackMsg();
        lastExitTrackMsg.setPage(LastExitTrackMsgPage.BIO.getMsg());
        lastExitTrackMsg.setView(this.f2334d.getCurrentShowView());
        HashMap hashMap = new HashMap();
        hashMap.put(Attributes.Style.STEP, Integer.valueOf(this.f2341m));
        hashMap.put("errorCode", Integer.valueOf(this.f2344p));
        hashMap.put("retryCounts", Integer.valueOf(this.f2333c));
        lastExitTrackMsg.setParams(JsonUtils.toJSON(JsonUtils.toJSON(hashMap)));
        return lastExitTrackMsg;
    }

    private String t() {
        HashMap hashMap = new HashMap();
        hashMap.put(Attributes.Style.STEP, Integer.valueOf(this.f2341m));
        hashMap.put("errorCode", Integer.valueOf(this.f2344p));
        hashMap.put("retryCounts", Integer.valueOf(this.f2333c));
        return JsonUtils.toJSON(hashMap);
    }

    private void u() {
        b(false);
    }

    private boolean v() {
        int i10 = this.f2344p;
        return i10 == -99999 || i10 == 0;
    }

    private void w() {
        c("view");
        ALBiometricsActivityParentView aLBiometricsActivityParentView = this.f2334d;
        DetectActionResultWidget detectActionResultWidget = aLBiometricsActivityParentView.f2443f;
        if (detectActionResultWidget != null && detectActionResultWidget.g()) {
            aLBiometricsActivityParentView.f2443f.f();
        }
        this.f2334d.b();
    }

    private void x() {
        d dVar = this.f2336h;
        if (dVar == null) {
            return;
        }
        onLogTrack(TrackLog.createStartCameraParametersLog(dVar.l()));
    }

    private void y() {
        d dVar = this.f2336h;
        if (dVar == null) {
            return;
        }
        onLogTrack(TrackLog.createFinishCameraParametersLog(dVar.m()));
    }

    private void z() {
        if (!PermissionsManager.hasPermissions(this.f2335g, "android.permission.CAMERA")) {
            PermissionsManager.requestPermissions(this.f2335g, new String[]{"android.permission.CAMERA"}, 1010, "人脸识别服务需要您授权相机权限", new Runnable() { // from class: com.alibaba.security.biometrics.build.s.11
                @Override // java.lang.Runnable
                public final void run() {
                    s.this.b(false);
                }
            }, new Runnable() { // from class: com.alibaba.security.biometrics.build.s.12
                @Override // java.lang.Runnable
                public final void run() {
                    s.f();
                }
            });
        } else {
            b(false);
        }
    }

    @Override // com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.a
    public final void e() {
        this.f2354z = false;
        c("startClick");
        b(false);
    }

    @Override // com.alibaba.security.biometrics.jni.listener.OnSgProcessListener
    public final String getAppKey() {
        ALBiometricsEventListener aLBiometricsEventListener = this.f2340l;
        if (aLBiometricsEventListener != null) {
            return aLBiometricsEventListener.getAppKey();
        }
        return null;
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnActionEndListener
    public final void onActionEnd(ABDetectType aBDetectType, int i10, int i11) {
        ALBiometricsActivityParentView aLBiometricsActivityParentView;
        HashMap hashMap = new HashMap();
        hashMap.put(Attributes.Style.INDEX, Integer.valueOf(i10));
        hashMap.put("actionType", JsonUtils.toJSON(aBDetectType));
        ALBiometricsJni.bhL(13, JsonUtils.toJSON(hashMap));
        onLogTrack(a("finishAction", aBDetectType.getValue(), i10));
        if (aBDetectType == ABDetectType.AIMLESS || (aLBiometricsActivityParentView = this.f2334d) == null) {
            return;
        }
        aLBiometricsActivityParentView.c();
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnActionStartListener
    public final void onActionStart(ABDetectType aBDetectType, int i10, int i11) {
        this.f2341m = 4;
        this.f2342n = aBDetectType;
        HashMap hashMap = new HashMap();
        hashMap.put(Attributes.Style.INDEX, Integer.valueOf(i10));
        hashMap.put("actionType", JsonUtils.toJSON(aBDetectType));
        ALBiometricsJni.bhL(12, JsonUtils.toJSON(hashMap));
        onLogTrack(a("startAction", aBDetectType.getValue(), i10));
        a(aBDetectType);
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnAdjustEndListener
    public final void onAdjustEnd() {
        ALBiometricsJni.bhL(11, "");
        onLogTrack(d("didAdjust"));
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnAdjustStartListener
    public final void onAdjustStart() {
        this.f2341m = 3;
        ALBiometricsJni.bhL(10, "");
        onLogTrack(d("willAdjust"));
        A();
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnBeforeRetryListener
    public final void onBeforeRetry(OnRetryListener onRetryListener, String str) {
        ALBiometricsEventListener aLBiometricsEventListener = this.f2340l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onBeforeRetry(onRetryListener, str);
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnCancelListener
    public final void onCancel(int i10) {
        LastExitTrackMsg lastExitTrackMsg;
        if (this.f2334d != null) {
            lastExitTrackMsg = new LastExitTrackMsg();
            lastExitTrackMsg.setPage(LastExitTrackMsgPage.BIO.getMsg());
            lastExitTrackMsg.setView(this.f2334d.getCurrentShowView());
            HashMap hashMap = new HashMap();
            hashMap.put(Attributes.Style.STEP, Integer.valueOf(this.f2341m));
            hashMap.put("errorCode", Integer.valueOf(this.f2344p));
            hashMap.put("retryCounts", Integer.valueOf(this.f2333c));
            lastExitTrackMsg.setParams(JsonUtils.toJSON(JsonUtils.toJSON(hashMap)));
        } else {
            lastExitTrackMsg = null;
        }
        RPTrack.setLastStepTrackMsg(lastExitTrackMsg);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("errorCode", Integer.valueOf(i10));
        ALBiometricsJni.bhL(21, JsonUtils.toJSON(hashMap2));
        String base64String = BytesUtils.toBase64String(ALBiometricsJni.dumpBeh(true));
        ALBiometricsEventListener aLBiometricsEventListener = this.f2340l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onCancel(i10, base64String);
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnDetectContinueListener
    public final void onDetectContinue(ABImageResult aBImageResult) {
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnDetectStartListener
    public final void onDetectStart() {
        if (M()) {
            this.f2336h.k();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        this.A.onDrawFrame(gl10);
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnFinishListener
    public final void onFinish(int i10, final Bundle bundle) {
        final ALBiometricsResult aLBiometricsResult = (ALBiometricsResult) bundle.getSerializable(ALBiometricsKeys.KEY_RESULT_DATA);
        if (bundle.containsKey(ALBiometricsKeys.KEY_RESULT_LOG_DATA)) {
            Bundle bundle2 = bundle.getBundle(ALBiometricsKeys.KEY_RESULT_LOG_DATA);
            if (bundle2 != null) {
                bundle2.putInt("time_show_nav", this.f2345q.stepNav ? 1 : 0);
            }
            onOldLogRecord(bundle2);
        }
        this.f2344p = i10;
        this.f2348t = aLBiometricsResult;
        if (i10 == 0) {
            ALBiometricsJni.bhL(18, JsonUtils.toJSON(this.F));
            if (M()) {
                this.f2336h.a(new OnCameraVideoReorderListener() { // from class: com.alibaba.security.biometrics.build.s.2
                    @Override // com.alibaba.security.common.videorecorder.OnCameraVideoReorderListener
                    public final void onFinish(String str, int i11) {
                        aLBiometricsResult.setVideoS(str);
                        s.this.a(aLBiometricsResult);
                    }
                }, false);
                return;
            } else {
                a(aLBiometricsResult);
                return;
            }
        }
        if (M()) {
            this.f2336h.a(new OnCameraVideoReorderListener() { // from class: com.alibaba.security.biometrics.build.s.3
                @Override // com.alibaba.security.common.videorecorder.OnCameraVideoReorderListener
                public final void onFinish(String str, int i11) {
                    aLBiometricsResult.setVideoF(str);
                    s.this.a(bundle.getInt(ALBiometricsKeys.KEY_ERROR_CODE), bundle);
                }
            }, false);
        } else {
            a(bundle.getInt(ALBiometricsKeys.KEY_ERROR_CODE), bundle);
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnFrameDetectedListener
    public final void onFrameDetected(ABDetectFrame aBDetectFrame) {
        RPDetectCoreView rPDetectCoreView;
        if (aBDetectFrame == null || this.f2334d == null || !this.f2339k) {
            return;
        }
        this.F = aBDetectFrame.getDetectResult();
        if (System.currentTimeMillis() - this.f2352x < 500) {
            return;
        }
        this.f2352x = System.currentTimeMillis();
        ALBiometricsActivityParentView aLBiometricsActivityParentView = this.f2334d;
        boolean hasFace = aBDetectFrame.hasFace();
        DetectActionWidget detectActionWidget = aLBiometricsActivityParentView.f2442e;
        if (detectActionWidget != null && (rPDetectCoreView = detectActionWidget.f2513b) != null) {
            if (hasFace) {
                rPDetectCoreView.a();
            } else {
                if (rPDetectCoreView.f2465g == null) {
                    ValueAnimator duration = ValueAnimator.ofInt(100, 0).setDuration(1000L);
                    rPDetectCoreView.f2465g = duration;
                    duration.setRepeatCount(-1);
                    rPDetectCoreView.f2465g.addUpdateListener(new RPDetectCoreView.AnonymousClass1());
                    rPDetectCoreView.f2465g.start();
                }
                rPDetectCoreView.invalidate();
            }
        }
        if (!aBDetectFrame.hasFace()) {
            this.f2334d.a(1002);
        }
        if (N()) {
            v vVar = this.C;
            if (vVar != null && vVar.b()) {
                return;
            }
            if (aBDetectFrame.hasFace()) {
                i(true);
            } else {
                C();
            }
        }
    }

    @Override // com.alibaba.security.biometrics.service.listener.OnLogTrackListener
    public final void onLogTrack(TrackLog trackLog) {
        ALBiometricsEventListener aLBiometricsEventListener = this.f2340l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onLogTrack(trackLog);
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnMessageListener
    public final void onMessage(int i10, Bundle bundle) {
        if (!this.f2339k || this.f2334d == null) {
            return;
        }
        if (i10 == -10213 || i10 == -10214 || i10 == -10215 || i10 == -10219) {
            onLogTrack(TrackLog.createBioMonitorExpLog(i10, bundle != null ? bundle.getString(ALBiometricsKeys.KEY_ERROR_MESSAGE, "") : ""));
        }
        if (N()) {
            return;
        }
        this.f2334d.a(i10);
    }

    public final void onModelLoadingResult(int i10, String str) {
        if (this.f2340l == null || i10 == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(f2330b, str);
        this.f2340l.onError(i10, bundle);
    }

    @Override // com.alibaba.security.biometrics.service.listener.OnLogTrackListener
    public final void onOldLogRecord(Bundle bundle) {
        try {
            ak.b().a().putAll(bundle);
        } catch (Exception unused) {
        }
        ALBiometricsEventListener aLBiometricsEventListener = this.f2340l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onOldLogRecord(bundle);
        }
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnRecognizeEndListener
    public final void onRecognizeEnd() {
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnRecognizeStartListener
    public final void onRecognizeStart() {
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnReflectEndListener
    public final void onReflectEnd() {
    }

    @Override // com.alibaba.security.biometrics.service.model.ALBiometricsEvents.OnReflectStartListener
    public final void onReflectStart() {
        this.f2341m = 5;
        DisplayUtils.setScreenBrightness(this.f2335g, 153);
        ALBiometricsActivityParentView aLBiometricsActivityParentView = this.f2334d;
        if (aLBiometricsActivityParentView != null) {
            aLBiometricsActivityParentView.d();
        }
    }

    @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
    public final void onSensorReset() {
        ALBiometricsEventListener aLBiometricsEventListener = this.f2340l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSensorReset();
        }
    }

    @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
    public final void onSensorStart() {
        ALBiometricsEventListener aLBiometricsEventListener = this.f2340l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSensorStart();
        }
    }

    @Override // com.alibaba.security.biometrics.service.listener.OnSensorTrackListener
    public final void onSensorStop() {
        ALBiometricsEventListener aLBiometricsEventListener = this.f2340l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSensorStop();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i10, int i11) {
        this.A.onSurfaceChanged(gl10, i10, i11);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.A.onSurfaceCreated(gl10, eGLConfig);
        SurfaceTexture surfaceTexture = this.A.f2381c;
        this.B = surfaceTexture;
        this.f2336h.a(surfaceTexture);
        this.B.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.alibaba.security.biometrics.build.s.13
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                CameraActivityWidgetParent cameraActivityWidgetParent = s.this.f2334d.f2438a;
                if (cameraActivityWidgetParent != null) {
                    cameraActivityWidgetParent.a();
                }
            }
        });
    }

    @Override // com.alibaba.security.biometrics.jni.listener.OnSgProcessListener
    public final String sign(String str) {
        ALBiometricsEventListener aLBiometricsEventListener = this.f2340l;
        if (aLBiometricsEventListener != null) {
            return aLBiometricsEventListener.sign(str);
        }
        return null;
    }

    private void b(ALBiometricsActivityParentView aLBiometricsActivityParentView) {
        aLBiometricsActivityParentView.setOnButtonClickListener(this);
        aLBiometricsActivityParentView.setOnCloseListener(this.D);
        aLBiometricsActivityParentView.setOnDetectActionResultListener(this);
        aLBiometricsActivityParentView.setRenderer(this);
    }

    private void c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("actionType", str);
        onLogTrack(TrackLog.createBioPrivacyPageLog(JsonUtils.toJsonString(hashMap)));
    }

    public static void f() {
        ((p) l.a(p.class)).a(GlobalErrorCode.ERROR_DEVICE_CAMERA_NO_PERMISSION, "CameraPermissionComponent ERROR_DEVICE_CAMERA_NO_PERMISSION", null);
    }

    private void h(boolean z10) {
        this.E.remove((Object) 2);
        if (this.f2346r == null) {
            RPLogging.e(f2331e, "mDazzleBizConfig is null");
            return;
        }
        DisplayUtils.setScreenBrightness(this.f2335g, 255);
        List<r> parseJsonArray = JsonUtils.parseJsonArray(this.f2346r, r.class);
        if (parseJsonArray == null) {
            RPLogging.e(f2331e, "mDazzleBizConfig is not json:\n" + this.f2346r);
            return;
        }
        Iterator<r> iterator2 = parseJsonArray.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().title = "检测中···";
        }
        this.f2347s = parseJsonArray;
        this.f2345q.mBiometricsType = 2;
        D();
        j(z10);
        i(false);
    }

    private void i() {
        ALBiometricsEventListener aLBiometricsEventListener = this.f2340l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSensorStart();
        }
    }

    private void j() {
        ALBiometricsEventListener aLBiometricsEventListener = this.f2340l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSensorStop();
        }
    }

    private void k() {
        ALBiometricsEventListener aLBiometricsEventListener = this.f2340l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSensorReset();
        }
    }

    private void l() {
        ALBiometricsActivityParentView aLBiometricsActivityParentView = this.f2334d;
        if (aLBiometricsActivityParentView != null) {
            aLBiometricsActivityParentView.f();
        }
    }

    private void m() {
        int i10 = this.f2333c + 1;
        this.f2333c = i10;
        ALBiometricsParams aLBiometricsParams = this.f2345q;
        if (i10 > aLBiometricsParams.retryThreshold) {
            a(GlobalErrorCode.ERROR_USER_RETRY_LIMITED, ALBiometricsKeys.KEY_RETRY_THRESHOLD, (String) null);
            return;
        }
        ALBiometricsService aLBiometricsService = this.f2337i;
        if (aLBiometricsService != null) {
            aLBiometricsService.setParams(aLBiometricsParams);
        }
        ALBiometricsJni.bhL(20, "");
        ALBiometricsEventListener aLBiometricsEventListener = this.f2340l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSensorReset();
        }
        n();
        b(true);
    }

    private void n() {
        if (this.f2345q.bioSteps != null) {
            this.E = new ArrayList(this.f2345q.bioSteps);
        }
        if (this.E == null) {
            this.E = new ArrayList();
        }
        if (this.E.isEmpty()) {
            this.E.add(1);
        }
    }

    @Override // com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.a
    public final void d() {
        this.f2353y = false;
        b("startClick");
        b(false);
    }

    @Override // com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.a
    public final void g() {
        if (this.f2339k && !N()) {
            int i10 = this.f2341m;
            if (i10 == 3) {
                A();
            } else if (i10 == 4) {
                a(this.f2342n);
            }
        }
    }

    private void f(boolean z10) {
        if (this.E.size() == 1 && this.E.contains(2)) {
            ALBiometricsParams aLBiometricsParams = this.f2345q;
            aLBiometricsParams.actionCount = 0;
            aLBiometricsParams.stepAdjust = true;
            this.E.add(0, 1);
        }
        if (this.E.indexOf(2) == 0 && this.f2346r != null) {
            h(z10);
        } else {
            g(z10);
        }
    }

    private void e(boolean z10) {
        if (this.f2339k) {
            return;
        }
        this.f2339k = true;
        this.f2344p = GlobalErrorCode.INIT;
        ALBiometricsEventListener aLBiometricsEventListener = this.f2340l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSensorStart();
        }
        this.f2334d.e();
        Point g3 = this.f2336h.g();
        if (g3 == null) {
            RPLogging.e(f2331e, "getCameraPreviewSize is null");
            return;
        }
        this.f2334d.a(g3.x, g3.y);
        this.f2341m = 1;
        ALBiometricsJni.bhL(2, this.f2336h.f());
        if (this.E.size() == 1 && this.E.contains(2)) {
            ALBiometricsParams aLBiometricsParams = this.f2345q;
            aLBiometricsParams.actionCount = 0;
            aLBiometricsParams.stepAdjust = true;
            this.E.add(0, 1);
        }
        if (this.E.indexOf(2) == 0 && this.f2346r != null) {
            h(z10);
        } else {
            g(z10);
        }
    }

    private void i(boolean z10) {
        if (this.f2347s == null || this.f2349u) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f2347s);
        arrayList.add(0, E());
        if (z10) {
            this.f2333c++;
        }
        if (this.f2333c > this.f2345q.retryThreshold) {
            a(GlobalErrorCode.ERROR_USER_RETRY_LIMITED, "dazzle retryThreshold", (String) null);
            return;
        }
        onLogTrack(TrackLog.createBioDazzleCollectLog());
        this.f2349u = true;
        I();
        this.f2337i.resetBioTimeOut(12);
        this.H = new SensorInfo(this.G.getCurrentLightValue(), this.G.getProximityValue());
        this.f2334d.a(arrayList, new t() { // from class: com.alibaba.security.biometrics.build.s.4
            @Override // com.alibaba.security.biometrics.build.t
            public final void a() {
                s sVar = s.this;
                sVar.I = new SensorInfo(sVar.G.getCurrentLightValue(), s.this.G.getProximityValue());
                s.l(s.this);
                s.this.f2336h.a(new OnCameraVideoReorderListener() { // from class: com.alibaba.security.biometrics.build.s.4.1
                    @Override // com.alibaba.security.common.videorecorder.OnCameraVideoReorderListener
                    public final void onFinish(String str, int i10) {
                        s.this.f2350v = str;
                        s.this.f2351w = i10;
                        s sVar2 = s.this;
                        sVar2.a(sVar2.f2348t);
                    }
                }, false);
            }

            @Override // com.alibaba.security.biometrics.build.t
            public final void b() {
                s.this.f2336h.k();
            }

            @Override // com.alibaba.security.biometrics.build.t
            public final void c() {
            }
        });
    }

    private void j(boolean z10) {
        ALBiometricsService aLBiometricsService = new ALBiometricsService(this.f2335g, this.f2345q, this);
        this.f2337i = aLBiometricsService;
        if (z10) {
            aLBiometricsService.restart();
        } else {
            aLBiometricsService.start();
        }
    }

    private void d(final boolean z10) {
        ALBiometricsParams aLBiometricsParams = this.f2345q;
        if (aLBiometricsParams.reachBusinessRetryLimit) {
            a(GlobalErrorCode.ERROR_USER_RETRY_LIMITED, "reachBusinessRetryLimit", (String) null);
            return;
        }
        int i10 = aLBiometricsParams.ctidResultCode;
        if (i10 != -2 && i10 != 0) {
            a(i10, "Error on CTID auth, code: ".concat(String.valueOf(i10)), (String) null);
            return;
        }
        if (this.f2353y) {
            b("view");
            this.f2334d.a(this.f2345q.userName);
            return;
        }
        if (this.f2354z) {
            c("view");
            ALBiometricsActivityParentView aLBiometricsActivityParentView = this.f2334d;
            DetectActionResultWidget detectActionResultWidget = aLBiometricsActivityParentView.f2443f;
            if (detectActionResultWidget != null && detectActionResultWidget.g()) {
                aLBiometricsActivityParentView.f2443f.f();
            }
            this.f2334d.b();
            return;
        }
        this.f2336h.a(new d.a() { // from class: com.alibaba.security.biometrics.build.s.9
            @Override // com.alibaba.security.biometrics.build.d.a
            public final void a(int i11, String str) {
                s.this.a(i11, str, (String) null);
                s.e(s.this);
            }

            @Override // com.alibaba.security.biometrics.build.d.a
            public final void a() {
                s.a(s.this, z10);
                s.e(s.this);
            }

            @Override // com.alibaba.security.biometrics.build.d.a
            public final void a(byte[] bArr, int i11, int i12, int i13) {
                if (s.this.f2341m == 1) {
                    s.g(s.this);
                }
                if (s.this.f2337i != null) {
                    s.this.f2337i.process(bArr, i11, i12, i13);
                }
            }
        });
        SurfaceTexture surfaceTexture = this.B;
        if (surfaceTexture != null) {
            this.f2336h.a(surfaceTexture);
        }
        ALBiometricsActivityParentView aLBiometricsActivityParentView2 = this.f2334d;
        Runnable runnable = new Runnable() { // from class: com.alibaba.security.biometrics.build.s.10
            @Override // java.lang.Runnable
            public final void run() {
                if (s.this.f2336h.j()) {
                    s.a(s.this, z10);
                }
            }
        };
        DetectActionWidget detectActionWidget = aLBiometricsActivityParentView2.f2442e;
        if (detectActionWidget != null) {
            detectActionWidget.a(new ALBiometricsActivityParentView.AnonymousClass3(runnable));
        }
    }

    private void b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("actionType", str);
        onLogTrack(TrackLog.createBioGuidePageLog(JsonUtils.toJsonString(hashMap)));
    }

    @Override // com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.a
    public final void c(boolean z10) {
        try {
            int i10 = 1;
            ((k) l.a(k.class)).a(!z10);
            int d10 = ((AudioSettingComponent) l.a(AudioSettingComponent.class)).d();
            if (z10) {
                boolean z11 = d10 == 0;
                ((AudioSettingComponent) l.a(AudioSettingComponent.class)).f2419d = z11;
                if (z11) {
                    try {
                        ((AudioSettingComponent) l.a(AudioSettingComponent.class)).f2420e.setRingerMode(2);
                    } catch (Throwable unused) {
                    }
                }
            }
            HashMap hashMap = new HashMap();
            if (!z10) {
                i10 = 0;
            }
            hashMap.put("isOn", Integer.valueOf(i10));
            onLogTrack(TrackLog.createSoundClickLog(JsonUtils.toJsonString(hashMap)));
        } catch (Throwable unused2) {
        }
    }

    private void g(boolean z10) {
        DisplayUtils.setScreenBrightness(this.f2335g, 255);
        this.E.remove((Object) 1);
        this.f2345q.mBiometricsType = 1;
        j(z10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0053, code lost:
    
        if (android.text.TextUtils.isEmpty(r2) == false) goto L12;
     */
    @Override // com.alibaba.security.biometrics.build.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(android.app.Activity r2, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams r3, com.alibaba.security.biometrics.theme.ALBiometricsConfig r4, com.alibaba.security.biometrics.ALBiometricsEventListener r5) {
        /*
            r1 = this;
            r1.f2340l = r5
            r1.f2345q = r3
            r1.f2338j = r4
            com.alibaba.security.biometrics.build.c r4 = new com.alibaba.security.biometrics.build.c
            r4.<init>(r2, r3)
            r1.f2336h = r4
            com.alibaba.security.biometrics.build.u r4 = new com.alibaba.security.biometrics.build.u
            com.alibaba.security.biometrics.build.d r5 = r1.f2336h
            com.alibaba.security.biometrics.service.model.params.ALBiometricsParams r0 = r1.f2345q
            r4.<init>(r2, r5, r0)
            r1.A = r4
            r2 = 0
            r1.f2341m = r2
            r2 = -99999(0xfffffffffffe7961, float:NaN)
            r1.f2344p = r2
            com.alibaba.security.biometrics.service.model.params.ALBiometricsParams r2 = r1.f2345q
            boolean r4 = r2.stepNav
            r1.f2353y = r4
            boolean r2 = r2.stepPrivacy
            r1.f2354z = r2
            r1.D()
            r1.n()
            java.util.List<java.lang.Integer> r2 = r1.E
            r4 = 2
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r2 = r2.contains(r4)
            if (r2 == 0) goto L56
            java.lang.String r2 = r3.bizConf
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L56
            byte[] r2 = com.alibaba.security.common.utils.BytesUtils.decodeBase64String(r2)
            if (r2 == 0) goto L56
            java.lang.String r2 = com.alibaba.security.biometrics.jni.ALBiometricsJni.dp(r2)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L56
            goto L57
        L56:
            r2 = 0
        L57:
            r1.f2346r = r2
            com.alibaba.security.biometrics.service.sensor.SensorGetter r2 = com.alibaba.security.biometrics.service.sensor.SensorGetter.getDefault()
            r1.G = r2
            r2.start()
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.build.s.a(android.app.Activity, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams, com.alibaba.security.biometrics.theme.ALBiometricsConfig, com.alibaba.security.biometrics.ALBiometricsEventListener):boolean");
    }

    @Override // com.alibaba.security.biometrics.build.j
    public final boolean b() {
        int i10 = this.f2341m;
        if (i10 != 0 && i10 != 6 && i10 != 7 && i10 != 8) {
            a(GlobalErrorCode.ERROR_DETECT_INTERRUPT, "onPause", (String) null);
        }
        return true;
    }

    public final void b(boolean z10) {
        if (PermissionsManager.hasPermissions(this.f2335g, "android.permission.CAMERA")) {
            d(z10);
        }
    }

    private static TrackLog b(int i10, String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService(TrackConstants.Service.BIOMETRICS);
        trackLog.setMethod(TrackConstants.Method.RESIGN_ACTIVE);
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i10));
        hashMap.put(aq.f3103ac, str);
        trackLog.setParams(JsonUtils.toJsonString(hashMap));
        return trackLog;
    }

    public final void h() {
        L();
        if (this.f2336h.j()) {
            y();
            this.f2336h.d();
        }
        this.f2339k = false;
    }

    @Override // com.alibaba.security.biometrics.build.j
    public final boolean c() {
        this.f2339k = false;
        this.f2333c = 0;
        h();
        ALBiometricsActivityParentView aLBiometricsActivityParentView = this.f2334d;
        if (aLBiometricsActivityParentView != null) {
            aLBiometricsActivityParentView.a();
        }
        ALBiometricsService aLBiometricsService = this.f2337i;
        if (aLBiometricsService != null) {
            aLBiometricsService.release();
        }
        v vVar = this.C;
        if (vVar != null && vVar.b()) {
            this.C.a();
        }
        ALBiometricsActivityParentView aLBiometricsActivityParentView2 = this.f2334d;
        if (aLBiometricsActivityParentView2 != null) {
            aLBiometricsActivityParentView2.a(new Runnable() { // from class: com.alibaba.security.biometrics.build.s.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (s.this.A != null) {
                        u uVar = s.this.A;
                        SurfaceTexture surfaceTexture = uVar.f2381c;
                        if (surfaceTexture != null) {
                            surfaceTexture.release();
                            uVar.f2381c = null;
                        }
                        uVar.f2379a = -1;
                        IBeautyRender iBeautyRender = uVar.f2380b;
                        if (iBeautyRender != null) {
                            iBeautyRender.release();
                        }
                    }
                }
            });
        }
        ALBiometricsEventListener aLBiometricsEventListener = this.f2340l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onBiometricsFinish(this.f2344p);
        }
        this.G.stop();
        return true;
    }

    private void b(ALBiometricsResult aLBiometricsResult) {
        this.f2341m = 7;
        this.f2339k = false;
        h();
        this.f2334d.d();
        aLBiometricsResult.setBh(BytesUtils.toBase64String(ALBiometricsJni.dumpBeh(true)));
        ALBiometricsEventListener aLBiometricsEventListener = this.f2340l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSuccess(aLBiometricsResult);
        }
    }

    public static /* synthetic */ void e(s sVar) {
        d dVar = sVar.f2336h;
        if (dVar != null) {
            sVar.onLogTrack(TrackLog.createStartCameraParametersLog(dVar.l()));
        }
    }

    private static TrackLog d(String str) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService(TrackConstants.Service.BIOMETRICS);
        trackLog.setMethod(TrackConstants.Method.ADJUST);
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        trackLog.setParams(JsonUtils.toJsonString(hashMap));
        return trackLog;
    }

    private static String a(String str) {
        byte[] decodeBase64String;
        if (TextUtils.isEmpty(str) || (decodeBase64String = BytesUtils.decodeBase64String(str)) == null) {
            return null;
        }
        String dp = ALBiometricsJni.dp(decodeBase64String);
        if (TextUtils.isEmpty(dp)) {
            return null;
        }
        return dp;
    }

    private void b(int i10) {
        am.a(i10, this.f2333c);
    }

    @Override // com.alibaba.security.biometrics.build.j
    public final void a(ALBiometricsActivityParentView aLBiometricsActivityParentView) {
        this.f2334d = aLBiometricsActivityParentView;
        b(aLBiometricsActivityParentView);
        z();
    }

    private void a(int i10, String str) {
        a(i10, str, (String) null);
    }

    public final void a(int i10, String str, String str2) {
        C();
        this.f2339k = false;
        if (i10 == 0) {
            this.f2341m = 7;
        } else {
            this.f2341m = 6;
        }
        h();
        this.f2344p = a(i10);
        if (this.f2333c > this.f2345q.retryThreshold && (i10 == -10204 || i10 == -10205 || i10 == -10206)) {
            i10 = GlobalErrorCode.ERROR_USER_RETRY_LIMITED;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("algoResult", JsonUtils.toJSON(this.F));
        hashMap.put("errorCode", Integer.valueOf(i10));
        hashMap.put("errorMsg", str);
        ALBiometricsJni.bhL(19, JsonUtils.toJSON(hashMap));
        this.f2334d.a(i10, str2, BytesUtils.toBase64String(ALBiometricsJni.dumpBeh(true)));
    }

    @Override // com.alibaba.security.biometrics.build.o
    public final void a(int i10, int i11, int i12) {
        if (i11 == 0) {
            a(i10, true, i12);
        } else {
            if (i11 != 1) {
                return;
            }
            a(i10, false, i12);
        }
    }

    private void a(int i10, int[] iArr) {
        if (i10 == 1010) {
            if ((iArr.length > 0 ? iArr[0] : -1) != 0) {
                f();
            } else {
                b(false);
            }
        }
    }

    @Override // com.alibaba.security.biometrics.build.j
    public final boolean a() {
        ALBiometricsActivityParentView aLBiometricsActivityParentView = this.f2334d;
        if (aLBiometricsActivityParentView == null) {
            return true;
        }
        CameraActivityWidgetParent cameraActivityWidgetParent = aLBiometricsActivityParentView.f2438a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.c();
        }
        TitleBarWidget titleBarWidget = aLBiometricsActivityParentView.f2439b;
        if (titleBarWidget != null) {
            titleBarWidget.d();
        }
        GuideWidget guideWidget = aLBiometricsActivityParentView.f2440c;
        if (guideWidget != null) {
            guideWidget.d();
        }
        PrivacyWidget privacyWidget = aLBiometricsActivityParentView.f2441d;
        if (privacyWidget != null) {
            privacyWidget.d();
        }
        DetectActionWidget detectActionWidget = aLBiometricsActivityParentView.f2442e;
        if (detectActionWidget != null) {
            detectActionWidget.d();
        }
        DetectActionResultWidget detectActionResultWidget = aLBiometricsActivityParentView.f2443f;
        if (detectActionResultWidget == null) {
            return true;
        }
        detectActionResultWidget.d();
        return true;
    }

    private void a(ABDetectType aBDetectType) {
        if (aBDetectType == null || aBDetectType == ABDetectType.AIMLESS) {
            return;
        }
        ((k) l.a(k.class)).a(aBDetectType);
        H();
        ALBiometricsActivityParentView aLBiometricsActivityParentView = this.f2334d;
        if (aLBiometricsActivityParentView != null) {
            aLBiometricsActivityParentView.a(aBDetectType);
        }
    }

    private static TrackLog a(String str, int i10, int i11) {
        TrackLog trackLog = new TrackLog();
        trackLog.setLayer("sdk");
        trackLog.setService(TrackConstants.Service.BIOMETRICS);
        trackLog.setMethod("action");
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(i10));
        hashMap.put(Attributes.Style.INDEX, Integer.valueOf(i11));
        hashMap.put("action", str);
        trackLog.setParams(JsonUtils.toJsonString(hashMap));
        return trackLog;
    }

    private void a(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(ALBiometricsKeys.KEY_RESULT_LOG_DATA)) {
            return;
        }
        Bundle bundle2 = bundle.getBundle(ALBiometricsKeys.KEY_RESULT_LOG_DATA);
        if (bundle2 != null) {
            bundle2.putInt("time_show_nav", this.f2345q.stepNav ? 1 : 0);
        }
        onOldLogRecord(bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ALBiometricsResult aLBiometricsResult) {
        if (this.E.contains(1)) {
            g(false);
            return;
        }
        if (this.E.contains(2) && this.f2346r != null) {
            h(false);
            return;
        }
        if (aLBiometricsResult == null) {
            RPLogging.e(f2331e, "bio result is null");
            return;
        }
        aLBiometricsResult.setDazzleVideoPath(this.f2350v);
        aLBiometricsResult.setDazzleCollectRotate(this.f2351w);
        aLBiometricsResult.addDazzleCollectConfigs(this.f2347s);
        aLBiometricsResult.getDazzleDataConfigs().setLastSensorInfo(this.I);
        aLBiometricsResult.getDazzleDataConfigs().setFirstSensorInfo(this.H);
        b(aLBiometricsResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, Bundle bundle) {
        if (i10 == -10211 || i10 == -10210 || i10 == -10209) {
            DisplayUtils.setScreenBrightness(this.f2335g, 255);
        }
        String string = bundle.getString(ALBiometricsKeys.KEY_ERROR_MESSAGE, "");
        onLogTrack(TrackLog.createBioMonitorExpLog(i10, string));
        a(i10, string, (String) null);
    }

    private void a(int i10, boolean z10, int i11) {
        if (i10 != 10002 && i10 != 10004) {
            if (i10 != 10005) {
                if (i10 != 10009) {
                    if (i10 != 10010) {
                        if (i10 == 10012) {
                            if (z10) {
                                ag.a(this.f2335g);
                            }
                            b(i11);
                            J();
                            onCancel(i11);
                            return;
                        }
                        if (i10 != 10013) {
                            switch (i10) {
                                case 20002:
                                case 20003:
                                    break;
                                case 20004:
                                    if (z10) {
                                        m();
                                        return;
                                    }
                                    return;
                                case BaseBioNavigatorActivity.f2184q /* 20005 */:
                                case BaseBioNavigatorActivity.f2186s /* 20007 */:
                                    if (z10) {
                                        m();
                                        return;
                                    }
                                    return;
                                case BaseBioNavigatorActivity.f2185r /* 20006 */:
                                    break;
                                case BaseBioNavigatorActivity.f2187t /* 20008 */:
                                    if (z10) {
                                        J();
                                        G();
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                }
            }
            b(i11);
            J();
            onCancel(i11);
            return;
        }
        if (z10) {
            m();
            return;
        }
        b(i11);
        J();
        onCancel(i11);
    }

    @Override // com.alibaba.security.biometrics.build.j
    public final boolean a(int i10, KeyEvent keyEvent) {
        boolean z10 = true;
        if (i10 != 4) {
            return true;
        }
        ALBiometricsConfig aLBiometricsConfig = this.f2338j;
        if (aLBiometricsConfig != null && !aLBiometricsConfig.isShouldAlertOnExit()) {
            z10 = false;
        }
        a(z10);
        return false;
    }

    public final void a(boolean z10) {
        if (q() == 0) {
            J();
            G();
            return;
        }
        if (z10) {
            if (N()) {
                C();
            }
            if (this.C == null) {
                v.a aVar = new v.a(this.f2335g);
                aVar.f2402b = this.f2335g.getResources().getString(R.string.face_dialog_exit_message);
                aVar.f2404d = true;
                aVar.f2405e = false;
                String string = this.f2335g.getResources().getString(R.string.face_dialog_exit_button_confirm);
                v.c cVar = new v.c() { // from class: com.alibaba.security.biometrics.build.s.8
                    @Override // com.alibaba.security.biometrics.build.v.c
                    public final void a(Dialog dialog) {
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                        s.this.p();
                    }
                };
                aVar.f2406f = string;
                aVar.f2408h = cVar;
                String string2 = this.f2335g.getResources().getString(R.string.face_dialog_exit_button_cancel);
                v.b bVar = new v.b() { // from class: com.alibaba.security.biometrics.build.s.7
                    @Override // com.alibaba.security.biometrics.build.v.b
                    public final void a(Dialog dialog) {
                        dialog.dismiss();
                    }
                };
                aVar.f2409i = string2;
                aVar.f2411k = bVar;
                this.C = new v(aVar);
            }
            v vVar = this.C;
            Dialog dialog = vVar.f2395a;
            if (dialog == null || dialog.isShowing()) {
                return;
            }
            vVar.f2395a.show();
            return;
        }
        p();
    }

    public static /* synthetic */ void a(s sVar, boolean z10) {
        if (sVar.f2339k) {
            return;
        }
        sVar.f2339k = true;
        sVar.f2344p = GlobalErrorCode.INIT;
        ALBiometricsEventListener aLBiometricsEventListener = sVar.f2340l;
        if (aLBiometricsEventListener != null) {
            aLBiometricsEventListener.onSensorStart();
        }
        sVar.f2334d.e();
        Point g3 = sVar.f2336h.g();
        if (g3 == null) {
            RPLogging.e(f2331e, "getCameraPreviewSize is null");
            return;
        }
        sVar.f2334d.a(g3.x, g3.y);
        sVar.f2341m = 1;
        ALBiometricsJni.bhL(2, sVar.f2336h.f());
        if (sVar.E.size() == 1 && sVar.E.contains(2)) {
            ALBiometricsParams aLBiometricsParams = sVar.f2345q;
            aLBiometricsParams.actionCount = 0;
            aLBiometricsParams.stepAdjust = true;
            sVar.E.add(0, 1);
        }
        if (sVar.E.indexOf(2) == 0 && sVar.f2346r != null) {
            sVar.h(z10);
        } else {
            sVar.g(z10);
        }
    }
}
