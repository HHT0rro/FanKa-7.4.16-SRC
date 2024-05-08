package com.alibaba.security.biometrics.logic.view.widget;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.build.ae;
import com.alibaba.security.biometrics.build.r;
import com.alibaba.security.biometrics.build.w;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.skin.model.DetectAnimSkinData;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.utils.DisplayUtils;
import com.alibaba.security.common.view.GifImageView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DetectActionWidget extends BaseWidget {

    /* renamed from: c, reason: collision with root package name */
    private static final String f2507c = "DetectActionWidget";

    /* renamed from: d, reason: collision with root package name */
    private static final long f2508d = 500;

    /* renamed from: e, reason: collision with root package name */
    private static final long f2509e = 1000;

    /* renamed from: f, reason: collision with root package name */
    private static final int f2510f = 1;

    /* renamed from: g, reason: collision with root package name */
    private static final int f2511g = 2;

    /* renamed from: h, reason: collision with root package name */
    private static final int f2512h = 3;

    /* renamed from: b, reason: collision with root package name */
    public RPDetectCoreView f2513b;

    /* renamed from: i, reason: collision with root package name */
    private TextView f2514i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f2515j;

    /* renamed from: k, reason: collision with root package name */
    private LinearLayout f2516k;

    /* renamed from: l, reason: collision with root package name */
    private GifImageView f2517l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f2518m;

    /* renamed from: n, reason: collision with root package name */
    private View f2519n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f2520o;

    /* renamed from: p, reason: collision with root package name */
    private Handler f2521p;

    /* renamed from: q, reason: collision with root package name */
    private Activity f2522q;

    /* renamed from: r, reason: collision with root package name */
    private long f2523r;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        r a(int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final DetectActionWidget f2526a;

        public b(DetectActionWidget detectActionWidget) {
            super(Looper.getMainLooper());
            this.f2526a = detectActionWidget;
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            int i10 = message.what;
            if (i10 == 1) {
                DetectActionWidget.b(this.f2526a);
            } else if (i10 == 2) {
                DetectActionWidget.a(this.f2526a, message);
            } else {
                if (i10 != 3) {
                    return;
                }
                this.f2526a.f2523r = 0L;
            }
        }
    }

    public DetectActionWidget(Context context) {
        super(context);
        l();
    }

    private void l() {
        this.f2521p = new b(this);
    }

    private void m() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f2517l.getLayoutParams();
        layoutParams.setMargins(0, this.f2513b.getCircleBottom() + DisplayUtils.dip2px(getContext(), 80.0f), 0, 0);
        this.f2517l.setLayoutParams(layoutParams);
        this.f2517l.requestLayout();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f2518m.getLayoutParams();
        layoutParams2.setMargins(0, this.f2513b.getCircleBottom() + DisplayUtils.dip2px(getContext(), 78.0f), 0, 0);
        this.f2518m.setLayoutParams(layoutParams2);
        this.f2518m.requestLayout();
    }

    private void n() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f2514i.getLayoutParams();
        layoutParams.setMargins(0, this.f2513b.getCircleBottom() + DisplayUtils.dip2px(getContext(), 20.0f), 0, 0);
        this.f2514i.setLayoutParams(layoutParams);
        this.f2514i.requestLayout();
    }

    private void o() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f2520o.getLayoutParams();
        int radius = this.f2513b.getRadius();
        layoutParams.height = radius * 2;
        layoutParams.topMargin = this.f2513b.getCircleCenterY() - radius;
        this.f2520o.setLayoutParams(layoutParams);
        this.f2520o.requestLayout();
    }

    private void p() {
        this.f2523r = 0L;
    }

    private void q() {
        ALBiometricsActivityParentView.a aVar = this.f2487a;
        if (aVar != null) {
            aVar.g();
        }
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void b() {
        w.a(this.f2514i, d("actionTipText"));
        w.a(this.f2515j, d("messageText"));
        DetectAnimSkinData e2 = e("detectAnimation");
        if (e2 != null) {
            this.f2513b.setBreatheColor(ae.a(e2.getWarningColor(), -65536));
            this.f2513b.setWaitingColor(ae.a(e2.getLoadingColor(), -16776961));
        } else {
            this.f2513b.setBreatheColor(-65536);
            this.f2513b.setWaitingColor(-16776961);
        }
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void c() {
        h();
        this.f2520o.setVisibility(8);
        this.f2513b.b();
        this.f2521p.removeCallbacksAndMessages(null);
    }

    public final void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b();
        w.a(this.f2514i, d("actionTipText"));
        this.f2521p.removeMessages(1);
        this.f2521p.sendEmptyMessageDelayed(1, 1000L);
        if (System.currentTimeMillis() - this.f2523r >= 500) {
            this.f2514i.setText(str);
            this.f2523r = System.currentTimeMillis();
        }
    }

    public int getMaskCircleDisplayY() {
        return this.f2513b.getCircleCenterY();
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public String getSkinParentKey() {
        return "detectPage";
    }

    public final void h() {
        this.f2517l.setVisibility(8);
        this.f2518m.setVisibility(8);
    }

    public final void i() {
        RPLogging.e(f2507c, "stopDazzleCollectView");
        this.f2521p.removeMessages(2);
        this.f2513b.setBackgroundColor(-1);
        this.f2513b.invalidate();
    }

    public final void j() {
        this.f2514i.setText("");
        this.f2514i.setVisibility(4);
    }

    public final void k() {
        b();
        this.f2516k.setVisibility(4);
        this.f2514i.setVisibility(4);
        this.f2520o.setVisibility(0);
        RPDetectCoreView rPDetectCoreView = this.f2513b;
        if (rPDetectCoreView.f2466h == null) {
            ValueAnimator duration = ValueAnimator.ofInt(0, 360).setDuration(2000L);
            rPDetectCoreView.f2466h = duration;
            duration.setRepeatCount(-1);
            rPDetectCoreView.f2466h.addUpdateListener(new RPDetectCoreView.AnonymousClass2());
            rPDetectCoreView.f2466h.start();
        }
    }

    public void setActivity(Activity activity) {
        this.f2522q = activity;
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void a() {
        this.f2517l = (GifImageView) findViewById(R.id.abfl_widget_da_actionGuidance_image);
        this.f2518m = (ImageView) findViewById(R.id.abfl_widget_da_actionGuidance_anim_image);
        this.f2514i = (TextView) findViewById(R.id.abfl_widget_da_mainPrompt);
        this.f2515j = (TextView) findViewById(R.id.widget_da_self_name);
        this.f2516k = (LinearLayout) findViewById(R.id.widget_da_self_name_parent);
        this.f2519n = findViewById(R.id.abfl_widget_da_maskview_blurview);
        this.f2513b = (RPDetectCoreView) findViewById(R.id.abfl_widget_da_maskview);
        this.f2520o = (TextView) findViewById(R.id.abfl_waiting_tip);
    }

    public DetectActionWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        l();
    }

    private void h(String str) {
        this.f2523r = 0L;
        w.a(this.f2514i, d("actionTipText"));
        this.f2521p.removeMessages(1);
        this.f2514i.setText(str);
        this.f2514i.setVisibility(0);
    }

    public DetectActionWidget(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        l();
    }

    private void i(String str) {
        w.a(this.f2514i, d("actionTipText"));
        this.f2521p.removeMessages(1);
        this.f2521p.sendEmptyMessageDelayed(1, 1000L);
        if (System.currentTimeMillis() - this.f2523r < 500) {
            return;
        }
        this.f2514i.setText(str);
        this.f2523r = System.currentTimeMillis();
    }

    public static /* synthetic */ void b(DetectActionWidget detectActionWidget) {
        ALBiometricsActivityParentView.a aVar = detectActionWidget.f2487a;
        if (aVar != null) {
            aVar.g();
        }
    }

    private void a(int i10) {
        this.f2518m.setVisibility(0);
        this.f2518m.setImageDrawable(getResources().getDrawable(i10));
        ((AnimationDrawable) this.f2518m.getDrawable()).start();
    }

    public final void a(String str, ALBiometricsParams aLBiometricsParams) {
        b();
        h(str);
        String str2 = aLBiometricsParams.userName;
        if (!TextUtils.isEmpty(str2)) {
            w.a(this.f2515j, d("messageText"));
            this.f2516k.setVisibility(0);
            this.f2515j.setText(str2);
            return;
        }
        this.f2516k.setVisibility(8);
    }

    private void a(a aVar, int i10) {
        int i11 = i10 + 1;
        r a10 = aVar.a(i11);
        if (a10 != null) {
            a(a10, aVar, i11);
        }
    }

    public final void a(final RPDetectCoreView.a aVar) {
        b();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f2514i.getLayoutParams();
        layoutParams.setMargins(0, this.f2513b.getCircleBottom() + DisplayUtils.dip2px(getContext(), 20.0f), 0, 0);
        this.f2514i.setLayoutParams(layoutParams);
        this.f2514i.requestLayout();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f2517l.getLayoutParams();
        layoutParams2.setMargins(0, this.f2513b.getCircleBottom() + DisplayUtils.dip2px(getContext(), 80.0f), 0, 0);
        this.f2517l.setLayoutParams(layoutParams2);
        this.f2517l.requestLayout();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f2518m.getLayoutParams();
        layoutParams3.setMargins(0, this.f2513b.getCircleBottom() + DisplayUtils.dip2px(getContext(), 78.0f), 0, 0);
        this.f2518m.setLayoutParams(layoutParams3);
        this.f2518m.requestLayout();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f2520o.getLayoutParams();
        int radius = this.f2513b.getRadius();
        layoutParams4.height = radius * 2;
        layoutParams4.topMargin = this.f2513b.getCircleCenterY() - radius;
        this.f2520o.setLayoutParams(layoutParams4);
        this.f2520o.requestLayout();
        setVisibility(0);
        this.f2519n.setVisibility(0);
        RPDetectCoreView rPDetectCoreView = this.f2513b;
        RPDetectCoreView.a aVar2 = new RPDetectCoreView.a() { // from class: com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget.1
            @Override // com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.a
            public final void a() {
                RPDetectCoreView.a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a();
                }
            }

            @Override // com.alibaba.security.biometrics.logic.view.custom.RPDetectCoreView.a
            public final void b() {
                RPDetectCoreView.a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.b();
                }
                DetectActionWidget.this.f2519n.setVisibility(8);
            }
        };
        rPDetectCoreView.f2462d = 2.5f;
        rPDetectCoreView.f2463e = 1.0f;
        rPDetectCoreView.f2461c = 350L;
        rPDetectCoreView.f2459a = aVar2;
        rPDetectCoreView.f2464f = false;
        rPDetectCoreView.f2460b = SystemClock.uptimeMillis();
        rPDetectCoreView.invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.alibaba.security.biometrics.service.model.detector.ABDetectType r4, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams r5) {
        /*
            r3 = this;
            r3.b()
            java.lang.String r0 = ""
            if (r4 == 0) goto L5f
            int[] r1 = com.alibaba.security.biometrics.build.ac.AnonymousClass1.f2213a
            int r2 = r4.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto L55;
                case 2: goto L55;
                case 3: goto L4a;
                case 4: goto L4a;
                case 5: goto L3f;
                case 6: goto L3f;
                case 7: goto L34;
                case 8: goto L29;
                case 9: goto L1e;
                case 10: goto L13;
                case 11: goto L13;
                case 12: goto L5f;
                default: goto L12;
            }
        L12:
            goto L5f
        L13:
            android.content.res.Resources r0 = r3.getResources()
            int r1 = com.alibaba.security.biometrics.R.string.face_detect_action_turn_right_or_left
            java.lang.String r0 = r0.getString(r1)
            goto L5f
        L1e:
            android.content.res.Resources r0 = r3.getResources()
            int r1 = com.alibaba.security.biometrics.R.string.face_detect_action_turn_left
            java.lang.String r0 = r0.getString(r1)
            goto L5f
        L29:
            android.content.res.Resources r0 = r3.getResources()
            int r1 = com.alibaba.security.biometrics.R.string.face_detect_action_turn_right
            java.lang.String r0 = r0.getString(r1)
            goto L5f
        L34:
            android.content.res.Resources r0 = r3.getResources()
            int r1 = com.alibaba.security.biometrics.R.string.face_detect_action_pitch_down_head
            java.lang.String r0 = r0.getString(r1)
            goto L5f
        L3f:
            android.content.res.Resources r0 = r3.getResources()
            int r1 = com.alibaba.security.biometrics.R.string.face_detect_action_raise_head
            java.lang.String r0 = r0.getString(r1)
            goto L5f
        L4a:
            android.content.res.Resources r0 = r3.getResources()
            int r1 = com.alibaba.security.biometrics.R.string.face_detect_action_mounth
            java.lang.String r0 = r0.getString(r1)
            goto L5f
        L55:
            android.content.res.Resources r0 = r3.getResources()
            int r1 = com.alibaba.security.biometrics.R.string.face_detect_action_blink
            java.lang.String r0 = r0.getString(r1)
        L5f:
            r3.a(r0, r5)
            if (r4 == 0) goto L7c
            int[] r5 = com.alibaba.security.biometrics.build.ac.AnonymousClass1.f2213a
            int r4 = r4.ordinal()
            r4 = r5[r4]
            switch(r4) {
                case 1: goto L79;
                case 2: goto L79;
                case 3: goto L76;
                case 4: goto L76;
                case 5: goto L73;
                case 6: goto L73;
                case 7: goto L73;
                case 8: goto L70;
                case 9: goto L70;
                case 10: goto L70;
                case 11: goto L70;
                default: goto L6f;
            }
        L6f:
            goto L7c
        L70:
            int r4 = com.alibaba.security.biometrics.R.drawable.rp_face_guide_yaw_anim
            goto L7d
        L73:
            int r4 = com.alibaba.security.biometrics.R.drawable.rp_face_guide_pitch_anim
            goto L7d
        L76:
            int r4 = com.alibaba.security.biometrics.R.drawable.rp_face_guide_mouth_anim
            goto L7d
        L79:
            int r4 = com.alibaba.security.biometrics.R.drawable.rp_face_guide_blink_anim
            goto L7d
        L7c:
            r4 = -1
        L7d:
            if (r4 <= 0) goto L9d
            android.widget.ImageView r5 = r3.f2518m
            r0 = 0
            r5.setVisibility(r0)
            android.widget.ImageView r5 = r3.f2518m
            android.content.res.Resources r0 = r3.getResources()
            android.graphics.drawable.Drawable r4 = r0.getDrawable(r4)
            r5.setImageDrawable(r4)
            android.widget.ImageView r4 = r3.f2518m
            android.graphics.drawable.Drawable r4 = r4.getDrawable()
            android.graphics.drawable.AnimationDrawable r4 = (android.graphics.drawable.AnimationDrawable) r4
            r4.start()
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.logic.view.widget.DetectActionWidget.a(com.alibaba.security.biometrics.service.model.detector.ABDetectType, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams):void");
    }

    private void a(boolean z10) {
        RPDetectCoreView rPDetectCoreView = this.f2513b;
        if (rPDetectCoreView == null) {
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

    private void a(Message message) {
        a((a) message.obj, message.arg1);
    }

    public final void a(r rVar, a aVar, int i10) {
        h(rVar.title);
        this.f2516k.setVisibility(4);
        try {
            this.f2514i.setTextColor(Color.parseColor(rVar.getTextColor()));
        } catch (Exception unused) {
            this.f2514i.setTextColor(getContext().getResources().getColor(R.color.rpsdk_color_333333));
        }
        try {
            this.f2513b.setBackgroundColor(Color.parseColor(rVar.getColor()));
        } catch (Exception unused2) {
            this.f2513b.setBackgroundColor(-1);
        }
        rVar.setTimeInterval(System.currentTimeMillis());
        DisplayUtils.setScreenBrightness(this.f2522q, (int) (rVar.getScreenLight() * 255.0f));
        if (rVar.getDuration() <= 0.0f) {
            a(aVar, i10);
            return;
        }
        long duration = rVar.getDuration() * 1000.0f;
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.arg1 = i10;
        obtain.obj = aVar;
        this.f2521p.sendMessageDelayed(obtain, duration);
    }

    public static /* synthetic */ void a(DetectActionWidget detectActionWidget, Message message) {
        detectActionWidget.a((a) message.obj, message.arg1);
    }
}
