package com.alibaba.security.biometrics.logic.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.opengl.GLSurfaceView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.activity.BaseAlBioActivity;
import com.alibaba.security.biometrics.build.o;
import com.alibaba.security.biometrics.build.r;
import com.alibaba.security.biometrics.build.t;
import com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView;
import com.alibaba.security.biometrics.logic.view.widget.CameraActivityWidgetParent;
import com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget;
import com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget;
import com.alibaba.security.biometrics.logic.view.widget.GuideWidget;
import com.alibaba.security.biometrics.logic.view.widget.PrivacyWidget;
import com.alibaba.security.biometrics.logic.view.widget.TitleBarWidget;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ALBiometricsActivityParentView extends RelativeLayout {

    /* renamed from: g, reason: collision with root package name */
    public static final long f2431g = 350;

    /* renamed from: h, reason: collision with root package name */
    public static final String f2432h = "";

    /* renamed from: i, reason: collision with root package name */
    public static final String f2433i = "guide";

    /* renamed from: j, reason: collision with root package name */
    public static final String f2434j = "privacy";

    /* renamed from: k, reason: collision with root package name */
    public static final String f2435k = "bio";

    /* renamed from: l, reason: collision with root package name */
    public static final String f2436l = "result";

    /* renamed from: p, reason: collision with root package name */
    private static final String f2437p = "ALBiometricsActivityParentView";

    /* renamed from: a, reason: collision with root package name */
    public CameraActivityWidgetParent f2438a;

    /* renamed from: b, reason: collision with root package name */
    public TitleBarWidget f2439b;

    /* renamed from: c, reason: collision with root package name */
    public GuideWidget f2440c;

    /* renamed from: d, reason: collision with root package name */
    public PrivacyWidget f2441d;

    /* renamed from: e, reason: collision with root package name */
    public DetectActionWidget f2442e;

    /* renamed from: f, reason: collision with root package name */
    public DetectActionResultWidget f2443f;

    /* renamed from: m, reason: collision with root package name */
    public BaseAlBioActivity f2444m;

    /* renamed from: n, reason: collision with root package name */
    public ALBiometricsParams f2445n;

    /* renamed from: o, reason: collision with root package name */
    public String f2446o;

    /* renamed from: q, reason: collision with root package name */
    private View f2447q;

    /* renamed from: r, reason: collision with root package name */
    private String f2448r;

    /* renamed from: s, reason: collision with root package name */
    private a f2449s;

    /* renamed from: com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass3 implements RPDetectCoreView.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f2455a;

        public AnonymousClass3(Runnable runnable) {
            this.f2455a = runnable;
        }

        @Override // com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.a
        public final void a() {
            this.f2455a.run();
        }

        @Override // com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.a
        public final void b() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void c(boolean z10);

        void d();

        void e();

        void g();
    }

    public ALBiometricsActivityParentView(Context context, ALBiometricsParams aLBiometricsParams) {
        super(context);
        this.f2446o = "";
        this.f2448r = "";
        this.f2444m = (BaseAlBioActivity) context;
        this.f2445n = aLBiometricsParams;
        View inflate = LayoutInflater.from(context).inflate(R.layout.rp_face_liveness_activity, this);
        this.f2447q = inflate;
        this.f2438a = (CameraActivityWidgetParent) inflate.findViewById(R.id.abfl_widget_camera);
        this.f2439b = (TitleBarWidget) this.f2447q.findViewById(R.id.widget_title_bar);
        this.f2442e = (DetectActionWidget) this.f2447q.findViewById(R.id.widget_abfl_detectaction);
        this.f2443f = (DetectActionResultWidget) this.f2447q.findViewById(R.id.widget_abfl_detectactionresult);
        this.f2440c = (GuideWidget) this.f2447q.findViewById(R.id.widget_abfl_guide);
        this.f2441d = (PrivacyWidget) this.f2447q.findViewById(R.id.widget_abfl_privacy);
        this.f2442e.setActivity(this.f2444m);
        this.f2446o = "";
        this.f2448r = "";
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.rp_face_liveness_activity, this);
        this.f2447q = inflate;
        this.f2438a = (CameraActivityWidgetParent) inflate.findViewById(R.id.abfl_widget_camera);
        this.f2439b = (TitleBarWidget) this.f2447q.findViewById(R.id.widget_title_bar);
        this.f2442e = (DetectActionWidget) this.f2447q.findViewById(R.id.widget_abfl_detectaction);
        this.f2443f = (DetectActionResultWidget) this.f2447q.findViewById(R.id.widget_abfl_detectactionresult);
        this.f2440c = (GuideWidget) this.f2447q.findViewById(R.id.widget_abfl_guide);
        this.f2441d = (PrivacyWidget) this.f2447q.findViewById(R.id.widget_abfl_privacy);
        this.f2442e.setActivity(this.f2444m);
        this.f2446o = "";
        this.f2448r = "";
    }

    private void h() {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.f2438a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.a();
        }
    }

    private void i() {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.f2438a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.b();
        }
    }

    private void j() {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.f2438a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.c();
        }
        TitleBarWidget titleBarWidget = this.f2439b;
        if (titleBarWidget != null) {
            titleBarWidget.d();
        }
        GuideWidget guideWidget = this.f2440c;
        if (guideWidget != null) {
            guideWidget.d();
        }
        PrivacyWidget privacyWidget = this.f2441d;
        if (privacyWidget != null) {
            privacyWidget.d();
        }
        DetectActionWidget detectActionWidget = this.f2442e;
        if (detectActionWidget != null) {
            detectActionWidget.d();
        }
        DetectActionResultWidget detectActionResultWidget = this.f2443f;
        if (detectActionResultWidget != null) {
            detectActionResultWidget.d();
        }
    }

    private void k() {
        this.f2438a = (CameraActivityWidgetParent) this.f2447q.findViewById(R.id.abfl_widget_camera);
        this.f2439b = (TitleBarWidget) this.f2447q.findViewById(R.id.widget_title_bar);
        this.f2442e = (DetectActionWidget) this.f2447q.findViewById(R.id.widget_abfl_detectaction);
        this.f2443f = (DetectActionResultWidget) this.f2447q.findViewById(R.id.widget_abfl_detectactionresult);
        this.f2440c = (GuideWidget) this.f2447q.findViewById(R.id.widget_abfl_guide);
        this.f2441d = (PrivacyWidget) this.f2447q.findViewById(R.id.widget_abfl_privacy);
        this.f2442e.setActivity(this.f2444m);
    }

    private void l() {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.f2438a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.setVisibility(0);
        }
    }

    private void m() {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.f2438a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.setVisibility(8);
        }
    }

    private void n() {
        DetectActionResultWidget detectActionResultWidget = this.f2443f;
        if (detectActionResultWidget == null || !detectActionResultWidget.g()) {
            return;
        }
        this.f2443f.f();
    }

    private void o() {
        DetectActionResultWidget detectActionResultWidget = this.f2443f;
        if (detectActionResultWidget != null) {
            detectActionResultWidget.f();
        }
        DetectActionWidget detectActionWidget = this.f2442e;
        if (detectActionWidget != null && !detectActionWidget.g()) {
            this.f2442e.e();
        }
        TitleBarWidget titleBarWidget = this.f2439b;
        if (titleBarWidget != null) {
            titleBarWidget.setTitle(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        TitleBarWidget titleBarWidget = this.f2439b;
        if (titleBarWidget != null) {
            titleBarWidget.e();
        }
    }

    private void q() {
        TitleBarWidget titleBarWidget = this.f2439b;
        if (titleBarWidget != null) {
            titleBarWidget.f();
        }
    }

    private static void r() {
    }

    private void s() {
        this.f2442e.i();
    }

    private static boolean t() {
        return false;
    }

    private static void u() {
    }

    public final boolean g() {
        return "result".equals(this.f2446o);
    }

    public String getCurrentShowView() {
        return this.f2446o;
    }

    public int getDetectResultErrorCode() {
        DetectActionResultWidget detectActionResultWidget = this.f2443f;
        if (detectActionResultWidget != null) {
            return detectActionResultWidget.getDetectResultErrorCode();
        }
        return -1;
    }

    public String getmLastShowView() {
        return this.f2448r;
    }

    public void setALBiometricsParams(ALBiometricsParams aLBiometricsParams) {
        this.f2445n = aLBiometricsParams;
    }

    public void setOnButtonClickListener(a aVar) {
        this.f2449s = aVar;
        TitleBarWidget titleBarWidget = this.f2439b;
        if (titleBarWidget != null) {
            titleBarWidget.setOnBioMainHandlerListener(aVar);
        }
        GuideWidget guideWidget = this.f2440c;
        if (guideWidget != null) {
            guideWidget.setOnBioMainHandlerListener(aVar);
        }
        PrivacyWidget privacyWidget = this.f2441d;
        if (privacyWidget != null) {
            privacyWidget.setOnBioMainHandlerListener(aVar);
        }
        DetectActionWidget detectActionWidget = this.f2442e;
        if (detectActionWidget != null) {
            detectActionWidget.setOnBioMainHandlerListener(aVar);
        }
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.f2439b.setOnCloseListener(onClickListener);
    }

    public void setOnDetectActionResultListener(o oVar) {
        this.f2443f.setOnDetectActionResultListener(oVar);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.f2438a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.setRenderer(renderer);
        }
    }

    public final void b() {
        if (this.f2440c != null) {
            this.f2441d.e();
        }
        p();
        this.f2439b.setTitle(getContext().getString(R.string.rp_privacy_title));
        this.f2448r = this.f2446o;
        this.f2446o = f2434j;
    }

    public final void c() {
        DetectActionWidget detectActionWidget = this.f2442e;
        if (detectActionWidget != null) {
            detectActionWidget.j();
            this.f2442e.h();
            this.f2442e.c();
        }
    }

    public final void d() {
        DetectActionWidget detectActionWidget = this.f2442e;
        if (detectActionWidget == null || detectActionWidget.getVisibility() != 0) {
            return;
        }
        this.f2442e.k();
        p();
    }

    public final void e() {
        p();
        CameraActivityWidgetParent cameraActivityWidgetParent = this.f2438a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.setVisibility(0);
        }
        DetectActionResultWidget detectActionResultWidget = this.f2443f;
        if (detectActionResultWidget != null) {
            detectActionResultWidget.f();
        }
        DetectActionWidget detectActionWidget = this.f2442e;
        if (detectActionWidget != null && !detectActionWidget.g()) {
            this.f2442e.e();
        }
        TitleBarWidget titleBarWidget = this.f2439b;
        if (titleBarWidget != null) {
            titleBarWidget.setTitle(null);
        }
        this.f2448r = this.f2446o;
        this.f2446o = f2435k;
    }

    public final void f() {
        DetectActionResultWidget detectActionResultWidget = this.f2443f;
        if (detectActionResultWidget != null) {
            detectActionResultWidget.h();
        }
        this.f2448r = this.f2446o;
        this.f2446o = "result";
    }

    private void b(Runnable runnable) {
        DetectActionWidget detectActionWidget = this.f2442e;
        if (detectActionWidget != null) {
            detectActionWidget.a(new AnonymousClass3(runnable));
        }
    }

    public final void b(String str) {
        DetectActionWidget detectActionWidget = this.f2442e;
        if (detectActionWidget != null) {
            detectActionWidget.a(str, this.f2445n);
        }
    }

    public final void a(Runnable runnable) {
        CameraActivityWidgetParent cameraActivityWidgetParent = this.f2438a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.a(runnable);
        }
    }

    private void a(boolean z10) {
        RPDetectCoreView rPDetectCoreView;
        DetectActionWidget detectActionWidget = this.f2442e;
        if (detectActionWidget == null || (rPDetectCoreView = detectActionWidget.f2513b) == null) {
            return;
        }
        if (z10) {
            rPDetectCoreView.a();
            return;
        }
        if (rPDetectCoreView.f2465g == null) {
            ValueAnimator duration = ValueAnimator.ofInt(100, 0).setDuration(1000L);
            rPDetectCoreView.f2465g = duration;
            duration.setRepeatCount(-1);
            rPDetectCoreView.f2465g.addUpdateListener(new RPDetectCoreView.AnonymousClass1());
            rPDetectCoreView.f2465g.start();
        }
        rPDetectCoreView.invalidate();
    }

    public final void a() {
        DetectActionWidget detectActionWidget = this.f2442e;
        if (detectActionWidget != null) {
            detectActionWidget.c();
        }
        DetectActionResultWidget detectActionResultWidget = this.f2443f;
        if (detectActionResultWidget != null) {
            detectActionResultWidget.f2490b = -1;
        }
    }

    public final void a(final List<r> list, final t tVar) {
        if (this.f2442e == null || list.isEmpty()) {
            return;
        }
        p();
        final int size = list.size();
        this.f2442e.a(list.get(0), new DetectActionWidget.a() { // from class: com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.1
            @Override // com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget.a
            public final r a(int i10) {
                if (i10 >= size) {
                    tVar.a();
                    return null;
                }
                if (i10 == 1) {
                    tVar.b();
                }
                return (r) list.get(i10);
            }
        }, 0);
    }

    public final void a(int i10, String str, String str2) {
        DetectActionResultWidget detectActionResultWidget = this.f2443f;
        if (detectActionResultWidget != null) {
            detectActionResultWidget.a(i10, new Runnable() { // from class: com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView.2
                @Override // java.lang.Runnable
                public final void run() {
                    ALBiometricsActivityParentView.a(ALBiometricsActivityParentView.this);
                    ALBiometricsActivityParentView.this.p();
                    ALBiometricsActivityParentView.this.c();
                    ALBiometricsActivityParentView.this.f2442e.setVisibility(8);
                    ALBiometricsActivityParentView.this.f2443f.setVisibility(0);
                    if (ALBiometricsActivityParentView.this.f2441d != null) {
                        ALBiometricsActivityParentView.this.f2441d.setVisibility(8);
                    }
                    if (ALBiometricsActivityParentView.this.f2440c != null) {
                        ALBiometricsActivityParentView.this.f2440c.setVisibility(8);
                    }
                }
            }, this.f2445n, str2, str);
        }
        this.f2448r = this.f2446o;
        this.f2446o = "result";
    }

    public final void a(int i10, int i11) {
        if (this.f2438a != null) {
            this.f2438a.a(i10, i11, this.f2442e.getMaskCircleDisplayY(), this.f2445n.cameraPreviewSizeSwitch);
        }
    }

    public final void a(String str) {
        GuideWidget guideWidget = this.f2440c;
        if (guideWidget != null) {
            guideWidget.e();
        }
        p();
        this.f2439b.setTitle(getContext().getString(R.string.rp_guide_title));
        this.f2448r = this.f2446o;
        this.f2446o = f2433i;
    }

    public final void a(int i10) {
        String string;
        if (this.f2442e != null) {
            Resources resources = getContext().getResources();
            if (i10 == -10219) {
                string = resources.getString(R.string.face_liveness_action_fail_tip_common);
            } else if (i10 == 1004) {
                string = resources.getString(R.string.face_detect_toast_too_shake);
            } else if (i10 == 1013) {
                string = resources.getString(R.string.face_detect_toast_pitch_angle_not_suitable);
            } else if (i10 == 1060) {
                string = resources.getString(R.string.face_liveness_env_too_bright);
            } else if (i10 == 1001) {
                string = resources.getString(R.string.face_detect_toast_too_dark);
            } else if (i10 != 1002) {
                switch (i10) {
                    case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_OCCLUSION /* -10215 */:
                        string = resources.getString(R.string.face_liveness_action_fail_tip_occlusion);
                        break;
                    case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_FACE /* -10214 */:
                        string = resources.getString(R.string.face_liveness_action_fail_tip_face_error);
                        break;
                    case GlobalErrorCode.ERROR_TOUCH_TOO_MUCH_MINE_ACTION /* -10213 */:
                        string = resources.getString(R.string.face_liveness_action_fail_tip_action_wrong);
                        break;
                    default:
                        switch (i10) {
                            case 1006:
                                string = resources.getString(R.string.face_detect_toast_no_dectect_action);
                                break;
                            case 1007:
                                string = resources.getString(R.string.face_detect_toast_too_close);
                                break;
                            case 1008:
                                string = resources.getString(R.string.face_detect_toast_too_far);
                                break;
                            default:
                                switch (i10) {
                                    case 1053:
                                        string = resources.getString(R.string.face_detect_toast_action_too_small);
                                        break;
                                    case 1054:
                                        string = resources.getString(R.string.face_detect_toast_raise_phone);
                                        break;
                                    case 1055:
                                        string = resources.getString(R.string.face_detect_toast_face_light);
                                        break;
                                    default:
                                        string = "";
                                        break;
                                }
                        }
                }
            } else {
                string = resources.getString(R.string.face_detect_toast_not_in_region);
            }
            this.f2442e.g(string);
        }
    }

    public final void a(ABDetectType aBDetectType) {
        DetectActionWidget detectActionWidget = this.f2442e;
        if (detectActionWidget != null) {
            detectActionWidget.setVisibility(0);
            this.f2442e.a(aBDetectType, this.f2445n);
        }
    }

    public static /* synthetic */ void a(ALBiometricsActivityParentView aLBiometricsActivityParentView) {
        CameraActivityWidgetParent cameraActivityWidgetParent = aLBiometricsActivityParentView.f2438a;
        if (cameraActivityWidgetParent != null) {
            cameraActivityWidgetParent.setVisibility(8);
        }
    }
}
