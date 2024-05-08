package com.alibaba.security.biometrics.logic.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.build.ad;
import com.alibaba.security.biometrics.build.o;
import com.alibaba.security.biometrics.build.w;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DetectActionResultWidget extends BaseWidget {

    /* renamed from: c, reason: collision with root package name */
    private static final String f2489c = "DetectActionResultWidget";

    /* renamed from: b, reason: collision with root package name */
    public int f2490b;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f2491d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f2492e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f2493f;

    /* renamed from: g, reason: collision with root package name */
    private Button f2494g;

    /* renamed from: h, reason: collision with root package name */
    private Button f2495h;

    /* renamed from: i, reason: collision with root package name */
    private o f2496i;

    public DetectActionResultWidget(Context context) {
        super(context);
        this.f2490b = 0;
    }

    private void i() {
        this.f2490b = -1;
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void b() {
        w.a(this.f2494g, c("mainButton"));
        w.a(this.f2492e, d("titleText"));
        w.a(this.f2493f, d("messageText"));
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void c() {
        this.f2490b = -1;
    }

    public int getDetectResultErrorCode() {
        return this.f2490b;
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public String getSkinParentKey() {
        return "resultPage";
    }

    public final void h() {
        b();
        w.a(this.f2491d, a("promptSucceedImageView"), R.drawable.rp_face_result_icon_ok);
        this.f2492e.setText(R.string.face_liveness_success);
        this.f2493f.setVisibility(4);
        this.f2494g.setVisibility(4);
        this.f2495h.setVisibility(4);
        setVisibility(0);
        setAlpha(1.0f);
    }

    public void setOnDetectActionResultListener(o oVar) {
        this.f2496i = oVar;
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void a() {
        this.f2490b = -1;
        this.f2491d = (ImageView) findViewById(R.id.abfl_widget_dar_icon);
        this.f2492e = (TextView) findViewById(R.id.abfl_widget_dar_title);
        this.f2493f = (TextView) findViewById(R.id.abfl_widget_dar_content);
        this.f2494g = (Button) findViewById(R.id.abfl_widget_dar_btn);
        this.f2495h = (Button) findViewById(R.id.abfl_widget_dar_other_btn);
    }

    public DetectActionResultWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2490b = 0;
    }

    public DetectActionResultWidget(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2490b = 0;
    }

    public final void a(final int i10, String str, CharSequence charSequence, String str2, boolean z10, final int i11) {
        b();
        if (i11 == 0) {
            w.a(this.f2491d, a("promptSucceedImageView"), R.drawable.rp_face_result_icon_ok);
        } else {
            w.a(this.f2491d, a("promptFailImageView"), R.drawable.rp_face_result_icon_fail);
        }
        this.f2492e.setText(str);
        this.f2494g.setText(str2);
        this.f2494g.setVisibility(0);
        try {
            ad.AnonymousClass1 anonymousClass1 = new ad.AnonymousClass1(this);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setFillBefore(true);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setDuration(500L);
            alphaAnimation.setAnimationListener(anonymousClass1);
            startAnimation(alphaAnimation);
        } catch (Throwable unused) {
        }
        if (charSequence != null) {
            this.f2493f.setText(charSequence);
        } else {
            this.f2493f.setText("");
        }
        this.f2493f.setVisibility(charSequence == null ? 4 : 0);
        this.f2494g.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (DetectActionResultWidget.this.f2496i != null) {
                    DetectActionResultWidget.this.f2496i.a(i10, 0, i11);
                }
                DetectActionResultWidget.this.setVisibility(8);
            }
        });
        if (z10) {
            this.f2495h.setVisibility(0);
            this.f2495h.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (DetectActionResultWidget.this.f2496i != null) {
                        DetectActionResultWidget.this.f2496i.a(20002, 1, i11);
                    }
                    DetectActionResultWidget.this.setVisibility(8);
                }
            });
        } else {
            this.f2495h.setVisibility(4);
        }
    }

    public final void a(final int i10, final Runnable runnable, final ALBiometricsParams aLBiometricsParams, String str, final String str2) {
        b();
        o oVar = this.f2496i;
        if (oVar != null) {
            oVar.onBeforeRetry(new OnRetryListener() { // from class: com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget.3
                @Override // com.alibaba.security.biometrics.service.listener.OnRetryListener
                public final void onRetry(int i11) {
                    int i12 = i10;
                    if (i11 != 0) {
                        i12 = GlobalErrorCode.ERROR_BUSINESS_RETRY_REACH_THRESHOLD;
                    }
                    DetectActionResultWidget.a(DetectActionResultWidget.this, i12, runnable, aLBiometricsParams, str2);
                }
            }, str);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0054. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r19, java.lang.Runnable r20, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 1350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget.a(int, java.lang.Runnable, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams, java.lang.String):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0051. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r19, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 1348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget.a(int, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams, java.lang.String):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void a(com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget r18, int r19, java.lang.Runnable r20, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 1362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget.a(com.alibaba.security.biometrics.logic.view.widget.DetectActionResultWidget, int, java.lang.Runnable, com.alibaba.security.biometrics.service.model.params.ALBiometricsParams, java.lang.String):void");
    }
}
