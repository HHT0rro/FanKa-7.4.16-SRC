package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.ea;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.hg;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ax;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.l;
import com.huawei.openalliance.ad.utils.v;
import java.util.IllegalFormatException;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSSkipButton extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    private Context f32867b;

    /* renamed from: c, reason: collision with root package name */
    private String f32868c;

    /* renamed from: d, reason: collision with root package name */
    private String f32869d;

    /* renamed from: e, reason: collision with root package name */
    private int f32870e;

    /* renamed from: f, reason: collision with root package name */
    private int f32871f;

    /* renamed from: g, reason: collision with root package name */
    private int f32872g;

    /* renamed from: h, reason: collision with root package name */
    private final String f32873h;

    /* renamed from: i, reason: collision with root package name */
    private hg f32874i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f32875j;

    /* renamed from: k, reason: collision with root package name */
    private Resources f32876k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f32877l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f32878m;

    /* renamed from: n, reason: collision with root package name */
    private int f32879n;

    /* renamed from: o, reason: collision with root package name */
    private float f32880o;

    /* renamed from: p, reason: collision with root package name */
    private int f32881p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f32882q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f32883r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f32884s;
    private static final String Code = PPSSkipButton.class.getSimpleName();
    private static int V = 16;
    private static int I = 16;
    private static int B = 4;
    private static int C = 16;
    private static int S = 16;
    private static int F = 24;
    private static int D = 24;

    public PPSSkipButton(Context context, String str, int i10, int i11, int i12, String str2, boolean z10, int i13, float f10, int i14, boolean z11) {
        super(context);
        this.f32872g = 0;
        this.f32878m = false;
        this.f32882q = false;
        this.f32883r = true;
        this.f32884s = false;
        this.f32867b = context;
        this.f32876k = context.getResources();
        V();
        this.f32870e = i10;
        this.f32871f = i11;
        this.f32872g = i12;
        this.f32873h = str2 == null ? "tr" : str2;
        this.f32868c = context.getString(R.string.hiad_default_skip_text);
        this.f32869d = Code(str);
        this.f32875j = z10;
        this.f32879n = i13;
        this.f32880o = f10;
        this.f32881p = i14;
        this.f32882q = z11;
        this.f32883r = ea.V(context);
        I();
        this.f32884s = false;
        Z();
    }

    private int Code(boolean z10) {
        int i10 = z10 ? F : I;
        if (5 == this.f32871f) {
            return z10 ? D : S;
        }
        return i10;
    }

    private String Code(String str) {
        String V2 = au.V(str);
        return au.Code(V2) ? this.f32867b.getString(R.string.hiad_default_skip_text_time) : V2;
    }

    private void I() {
        FrameLayout.inflate(getContext(), R.layout.hiad_view_skip_button, this);
        TextView textView = (TextView) findViewById(R.id.hiad_skip_text);
        this.f32877l = textView;
        textView.setText(this.f32868c);
        if (this.f32880o > 0.0f) {
            if (v.d(this.f32867b)) {
                this.f32877l.setTextSize(1, 24.0f);
                if (this.f32881p > 0) {
                    this.f32877l.setHeight(v.V(this.f32867b, 48.0f));
                }
            } else {
                this.f32877l.setTextSize(2, this.f32880o);
                int i10 = this.f32881p;
                if (i10 > 0) {
                    this.f32877l.setHeight(v.Z(this.f32867b, i10));
                }
            }
        }
        this.f32877l.setPadding(getSkipAdPaddingPx(), 0, getSkipAdPaddingPx(), 0);
        setPaddingRelative(getSkipAdLeftPaddingPx(), getSkipAdTopPaddingPx(), getSkipAdRightPaddingPx(), getSkipAdBottomPaddingPx());
        setClickable(true);
        setLayoutParams(getSkipAdLayoutParams());
    }

    private void V() {
        Context context;
        Resources resources = this.f32876k;
        if (resources == null || (context = this.f32867b) == null) {
            return;
        }
        V = v.I(context, resources.getDimension(R.dimen.hiad_splash_skip_phone_margin));
        I = v.I(this.f32867b, this.f32876k.getDimension(R.dimen.hiad_splash_skip_phone_margin_top));
        B = v.I(this.f32867b, this.f32876k.getDimension(R.dimen.hiad_splash_skip_third_margin));
        C = v.I(this.f32867b, this.f32876k.getDimension(R.dimen.hiad_splash_skip_tablet_margin));
        S = v.I(this.f32867b, this.f32876k.getDimension(R.dimen.hiad_splash_skip_tablet_margin_top));
        F = v.I(this.f32867b, this.f32876k.getDimension(R.dimen.hiad_splash_skip_phone_margin_bottom));
        D = v.I(this.f32867b, this.f32876k.getDimension(R.dimen.hiad_splash_skip_tablet_margin_bottom));
    }

    private void Z() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSSkipButton.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (motionEvent.getAction() == 0) {
                    if (gl.Code()) {
                        gl.Code(PPSSkipButton.Code, "touch down skipAdButton x=%f, y=%f", Float.valueOf(rawX), Float.valueOf(rawY));
                    }
                    if (!PPSSkipButton.this.f32884s && PPSSkipButton.this.f32874i != null) {
                        PPSSkipButton.this.f32884s = true;
                        PPSSkipButton.this.f32874i.Code((int) rawX, (int) rawY);
                    }
                }
                return true;
            }
        });
    }

    private int getHorizontalSideGapDpSize() {
        int i10 = V;
        if (5 == this.f32871f) {
            i10 = C;
        }
        return !this.f32883r ? B : i10;
    }

    private int getHorizontalSideMarginDp() {
        int horizontalSideGapDpSize = getHorizontalSideGapDpSize();
        int i10 = this.f32872g;
        if (horizontalSideGapDpSize < i10) {
            return 0;
        }
        return horizontalSideGapDpSize - i10;
    }

    private int getHorizontalSidePaddingDp() {
        return Math.min(getHorizontalSideGapDpSize(), this.f32872g);
    }

    private int getSkipAdBottomMarginPx() {
        if (!"lr".equals(this.f32873h)) {
            return 0;
        }
        int Code2 = this.f32875j ? 0 : ax.Code(this.f32867b);
        if (this.f32870e == 0 && 5 != this.f32871f && !l.S(this.f32867b) && !l.B(this.f32867b)) {
            Code2 = 0;
        }
        if (!this.f32875j && gl.Code()) {
            gl.Code(Code, "navigation bar h: %d", Integer.valueOf(Code2));
        }
        return ax.Code(this.f32867b, getVerticalSideBottomMarginDp()) + Code2;
    }

    private int getSkipAdBottomPaddingPx() {
        Context context;
        int i10;
        if ("lr".equals(this.f32873h)) {
            context = this.f32867b;
            i10 = getVerticalSidePaddingDp();
        } else {
            context = this.f32867b;
            i10 = this.f32872g;
        }
        return ax.Code(context, i10);
    }

    private RelativeLayout.LayoutParams getSkipAdLayoutParams() {
        int V2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule("lr".equals(this.f32873h) ? 12 : 10);
        layoutParams.addRule(21);
        int skipAdLeftMarginPx = getSkipAdLeftMarginPx();
        int skipAdTopMarginPx = getSkipAdTopMarginPx();
        int skipAdRightMarginPx = getSkipAdRightMarginPx();
        int skipAdBottomMarginPx = getSkipAdBottomMarginPx();
        if (1 != this.f32870e) {
            if (!this.f32882q) {
                skipAdRightMarginPx += this.f32879n;
            }
            skipAdRightMarginPx = this.f32883r ? skipAdRightMarginPx + ay.I(this.f32867b) : ay.I(this.f32867b);
            if ("tr".equals(this.f32873h)) {
                V2 = v.V(this.f32867b, 12.0f);
                skipAdTopMarginPx += V2;
            }
        } else if ("tr".equals(this.f32873h)) {
            V2 = this.f32879n;
            skipAdTopMarginPx += V2;
        }
        layoutParams.setMargins(skipAdLeftMarginPx, skipAdTopMarginPx, skipAdRightMarginPx, skipAdBottomMarginPx);
        layoutParams.setMarginEnd(skipAdRightMarginPx);
        return layoutParams;
    }

    private int getSkipAdLeftMarginPx() {
        return 0;
    }

    private int getSkipAdLeftPaddingPx() {
        return this.f32876k.getDimensionPixelOffset(R.dimen.hiad_margin_m);
    }

    private int getSkipAdPaddingPx() {
        return this.f32876k.getDimensionPixelOffset(R.dimen.hiad_margin_l);
    }

    private int getSkipAdRightMarginPx() {
        return ax.Code(this.f32867b, getHorizontalSideMarginDp());
    }

    private int getSkipAdRightPaddingPx() {
        return ax.Code(this.f32867b, getHorizontalSidePaddingDp());
    }

    private int getSkipAdTopMarginPx() {
        if ("lr".equals(this.f32873h)) {
            return 0;
        }
        return ax.Code(this.f32867b, getVerticalSideMarginDp());
    }

    private int getSkipAdTopPaddingPx() {
        Context context;
        int topPaddingDp;
        if ("lr".equals(this.f32873h)) {
            context = this.f32867b;
            topPaddingDp = this.f32872g;
        } else {
            context = this.f32867b;
            topPaddingDp = getTopPaddingDp();
        }
        return ax.Code(context, topPaddingDp);
    }

    private int getTopPaddingDp() {
        return Math.min(5 == this.f32871f ? S : I, this.f32872g);
    }

    private int getVerticalSideBottomMarginDp() {
        int Code2 = Code(true);
        int i10 = this.f32872g;
        if (Code2 < i10) {
            return 0;
        }
        return Code2 - i10;
    }

    private int getVerticalSideMarginDp() {
        int Code2 = Code(false);
        int i10 = this.f32872g;
        if (Code2 < i10) {
            return 0;
        }
        return Code2 - i10;
    }

    private int getVerticalSidePaddingDp() {
        return Math.min(Code(false), this.f32872g);
    }

    public void Code(int i10) {
        if (this.f32878m && !TextUtils.isEmpty(this.f32869d)) {
            try {
                String format = String.format(Locale.getDefault(), this.f32869d, Integer.valueOf(i10));
                gl.Code(Code, "updateLeftTime : %s", format);
                this.f32877l.setText(format);
                return;
            } catch (IllegalFormatException unused) {
                gl.Z(Code, "updateLeftTime IllegalFormatException");
            }
        }
        this.f32877l.setText(this.f32868c);
    }

    public void setAdMediator(hg hgVar) {
        this.f32874i = hgVar;
    }

    public void setLinkedOnTouchListener(View.OnTouchListener onTouchListener) {
        setOnTouchListener(onTouchListener);
    }

    public void setShowLeftTime(boolean z10) {
        this.f32878m = z10;
    }
}
