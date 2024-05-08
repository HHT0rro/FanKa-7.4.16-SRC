package com.huawei.openalliance.ad.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.huawei.hms.ads.gi;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.l;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class PPSBaseDialogContentView extends LinearLayout {
    public static final float D = 16.0f;
    public static final float F = 0.8f;
    public static final float L = 6.0f;

    /* renamed from: e, reason: collision with root package name */
    private static final String f32739e = "PPSBaseDialogContentView";

    /* renamed from: h, reason: collision with root package name */
    private static final float f32740h = 0.86f;

    /* renamed from: i, reason: collision with root package name */
    private static final float f32741i = 0.6f;

    /* renamed from: j, reason: collision with root package name */
    private static final float f32742j = 0.6f;
    public int[] B;
    public int[] C;
    public View Code;
    public View I;
    public int S;
    public View V;

    /* renamed from: a, reason: collision with root package name */
    public int f32743a;

    /* renamed from: b, reason: collision with root package name */
    public int f32744b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f32745c;

    /* renamed from: d, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f32746d;

    /* renamed from: f, reason: collision with root package name */
    private float f32747f;

    /* renamed from: g, reason: collision with root package name */
    private int f32748g;

    public PPSBaseDialogContentView(Context context) {
        super(context);
        this.S = (int) (com.huawei.openalliance.ad.utils.c.Code(getContext()) * 0.8f);
        this.f32746d = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseDialogContentView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = PPSBaseDialogContentView.this.V;
                    if (view == null) {
                        return;
                    }
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredHeight = PPSBaseDialogContentView.this.V.getMeasuredHeight();
                    PPSBaseDialogContentView pPSBaseDialogContentView = PPSBaseDialogContentView.this;
                    pPSBaseDialogContentView.Code(pPSBaseDialogContentView.V, Math.min(measuredHeight, pPSBaseDialogContentView.S));
                } catch (Throwable th) {
                    gl.I(PPSBaseDialogContentView.f32739e, "onGlobalLayout error: %s", th.getClass().getSimpleName());
                }
            }
        };
        I(context);
    }

    public PPSBaseDialogContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.S = (int) (com.huawei.openalliance.ad.utils.c.Code(getContext()) * 0.8f);
        this.f32746d = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseDialogContentView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = PPSBaseDialogContentView.this.V;
                    if (view == null) {
                        return;
                    }
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredHeight = PPSBaseDialogContentView.this.V.getMeasuredHeight();
                    PPSBaseDialogContentView pPSBaseDialogContentView = PPSBaseDialogContentView.this;
                    pPSBaseDialogContentView.Code(pPSBaseDialogContentView.V, Math.min(measuredHeight, pPSBaseDialogContentView.S));
                } catch (Throwable th) {
                    gl.I(PPSBaseDialogContentView.f32739e, "onGlobalLayout error: %s", th.getClass().getSimpleName());
                }
            }
        };
        I(context);
    }

    public PPSBaseDialogContentView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.S = (int) (com.huawei.openalliance.ad.utils.c.Code(getContext()) * 0.8f);
        this.f32746d = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseDialogContentView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = PPSBaseDialogContentView.this.V;
                    if (view == null) {
                        return;
                    }
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredHeight = PPSBaseDialogContentView.this.V.getMeasuredHeight();
                    PPSBaseDialogContentView pPSBaseDialogContentView = PPSBaseDialogContentView.this;
                    pPSBaseDialogContentView.Code(pPSBaseDialogContentView.V, Math.min(measuredHeight, pPSBaseDialogContentView.S));
                } catch (Throwable th) {
                    gl.I(PPSBaseDialogContentView.f32739e, "onGlobalLayout error: %s", th.getClass().getSimpleName());
                }
            }
        };
        I(context);
    }

    public PPSBaseDialogContentView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.S = (int) (com.huawei.openalliance.ad.utils.c.Code(getContext()) * 0.8f);
        this.f32746d = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseDialogContentView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = PPSBaseDialogContentView.this.V;
                    if (view == null) {
                        return;
                    }
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredHeight = PPSBaseDialogContentView.this.V.getMeasuredHeight();
                    PPSBaseDialogContentView pPSBaseDialogContentView = PPSBaseDialogContentView.this;
                    pPSBaseDialogContentView.Code(pPSBaseDialogContentView.V, Math.min(measuredHeight, pPSBaseDialogContentView.S));
                } catch (Throwable th) {
                    gl.I(PPSBaseDialogContentView.f32739e, "onGlobalLayout error: %s", th.getClass().getSimpleName());
                }
            }
        };
        I(context);
    }

    private void B(Context context) {
        int i10;
        int i11;
        if (this.I != null) {
            int V = com.huawei.openalliance.ad.utils.c.V(context);
            int Code = com.huawei.openalliance.ad.utils.c.Code(context);
            if (context instanceof Activity) {
                if (Build.VERSION.SDK_INT >= 30) {
                    Activity activity = (Activity) context;
                    i10 = activity.getWindowManager().getCurrentWindowMetrics().getBounds().width();
                    i11 = activity.getWindowManager().getCurrentWindowMetrics().getBounds().height();
                } else {
                    Point point = new Point();
                    ((Activity) context).getWindowManager().getDefaultDisplay().getSize(point);
                    i10 = point.x;
                    i11 = point.y;
                }
                int i12 = i10;
                Code = i11;
                V = i12;
            }
            ViewGroup.LayoutParams layoutParams = this.I.getLayoutParams();
            this.f32748g = (int) ((ay.c(context) == 1 ? V : Math.min(V, Code)) * this.f32747f);
            layoutParams.width = this.f32748g;
            this.I.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(View view, int i10) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i10;
        view.setLayoutParams(layoutParams);
    }

    private void I(Context context) {
        try {
            Code(context);
            Z(context);
            B(context);
            V(context);
            Code();
        } catch (Throwable th) {
            gl.I(f32739e, "init ex: %s", th.getClass().getSimpleName());
        }
    }

    private void Z(Context context) {
        if (l.B(context) || (l.S(context) && l.F(context))) {
            this.f32747f = 0.6f;
        } else {
            this.f32747f = f32740h;
        }
    }

    public abstract void Code();

    public void Code(int i10) {
        int i11 = this.f32743a;
        if (i11 > i10) {
            this.f32743a = i11 - i10;
        }
        int i12 = this.f32744b;
        if (i12 > i10) {
            this.f32744b = i12 - i10;
        }
        Code();
    }

    public abstract void Code(Context context);

    public void Code(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr2 == null) {
            return;
        }
        this.B = Arrays.copyOf(iArr, iArr.length);
        this.C = Arrays.copyOf(iArr2, iArr2.length);
    }

    public abstract void V(Context context);

    public boolean V() {
        return (this.C == null || this.B == null) ? false : true;
    }

    public float getViewWidthPercent() {
        return this.f32747f;
    }

    public int getViewWith() {
        return this.f32748g;
    }

    public void setAdContentData(AdContentData adContentData) {
    }

    public void setFeedbackListener(com.huawei.openalliance.ad.compliance.a aVar) {
    }

    public void setPaddingStart(int i10) {
        if (ay.I()) {
            this.f32743a = 0;
            this.f32744b = i10;
        } else {
            this.f32743a = i10;
            this.f32744b = 0;
        }
        Code();
    }

    public void setShowWhyThisAd(boolean z10) {
        this.f32745c = Boolean.valueOf(z10);
    }

    public void setViewClickListener(gi giVar) {
    }
}
