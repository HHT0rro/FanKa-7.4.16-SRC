package com.huawei.openalliance.ad.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.huawei.hms.ads.fr;
import com.huawei.hms.ads.fs;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.v;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSSplashProView extends RelativeLayout {
    private View B;
    private ScanningRelativeLayout C;
    private ImageView D;
    private TextView F;
    private boolean L;
    private int S;

    /* renamed from: a, reason: collision with root package name */
    private int f32885a;

    /* renamed from: b, reason: collision with root package name */
    private RoundLinearLayout f32886b;

    /* renamed from: c, reason: collision with root package name */
    private AnimatorSet f32887c;

    /* renamed from: d, reason: collision with root package name */
    private AnimatorSet f32888d;

    /* renamed from: e, reason: collision with root package name */
    private AnimatorSet f32889e;

    /* renamed from: f, reason: collision with root package name */
    private AnimatorSet f32890f;

    /* renamed from: g, reason: collision with root package name */
    private AnimatorSet f32891g;

    /* renamed from: h, reason: collision with root package name */
    private AnimatorSet f32892h;

    public PPSSplashProView(Context context) {
        super(context);
        this.S = 1;
        this.f32885a = 1;
        Code(context);
    }

    public PPSSplashProView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.S = 1;
        this.f32885a = 1;
        Code(context);
    }

    public PPSSplashProView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.S = 1;
        this.f32885a = 1;
        Code(context);
    }

    private void B() {
        this.f32889e = new AnimatorSet();
        this.f32890f = new AnimatorSet();
        this.f32891g = new AnimatorSet();
        this.f32892h = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.D, "scaleX", 1.0f, 1.225f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.D, "scaleY", 1.0f, 1.225f);
        ofFloat.setDuration(350L);
        ofFloat2.setDuration(350L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.D, "scaleX", 1.225f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.D, "scaleY", 1.225f, 1.0f);
        ofFloat3.setDuration(500L);
        ofFloat4.setDuration(500L);
        this.f32891g.playSequentially(ofFloat, ofFloat3);
        this.f32892h.playSequentially(ofFloat2, ofFloat4);
        this.f32891g.setInterpolator(new fs(0.2f, 0.0f, 0.2f, 1.0f));
        this.f32892h.setInterpolator(new fs(0.2f, 0.0f, 0.2f, 1.0f));
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.D, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.D, "scaleY", 1.0f, 0.0f);
        ofFloat5.setDuration(0L);
        ofFloat6.setDuration(0L);
        ofFloat5.addListener(new Animator.AnimatorListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                try {
                    PPSSplashProView.this.D.setVisibility(0);
                } catch (Throwable th) {
                    gl.I("PPSSplashProView", "arrowImage set visible err: %s", th.getClass().getSimpleName());
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.D, "scaleX", 0.0f, 1.225f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.D, "scaleY", 0.0f, 1.225f);
        ofFloat7.setDuration(400L);
        ofFloat8.setDuration(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.D, "scaleX", 1.225f, 0.989f);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.D, "scaleY", 1.225f, 0.989f);
        ofFloat9.setDuration(500L);
        ofFloat10.setDuration(500L);
        ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(this.D, "scaleX", 0.989f, 1.0f);
        ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(this.D, "scaleY", 0.989f, 1.0f);
        ofFloat11.setDuration(350L);
        ofFloat12.setDuration(350L);
        this.f32889e.playSequentially(ofFloat5, ofFloat7, ofFloat9, ofFloat11);
        this.f32890f.playSequentially(ofFloat6, ofFloat8, ofFloat10, ofFloat12);
        this.f32889e.setInterpolator(new fs(0.2f, 0.0f, 0.2f, 1.0f));
        this.f32890f.setInterpolator(new fs(0.2f, 0.0f, 0.2f, 1.0f));
        this.f32889e.addListener(new Animator.AnimatorListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSSplashProView.this.f32891g == null || PPSSplashProView.this.f32892h == null) {
                            return;
                        }
                        PPSSplashProView.this.f32891g.start();
                        PPSSplashProView.this.f32892h.start();
                    }
                }, 450L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
    }

    private void Code(Context context) {
        String str;
        try {
            View inflate = RelativeLayout.inflate(context, R.layout.hiad_layout_splash_pro, this);
            this.B = inflate;
            this.C = (ScanningRelativeLayout) inflate.findViewById(R.id.hiad_pro_layout);
            this.f32886b = (RoundLinearLayout) this.B.findViewById(R.id.hiad_pro_desc_layout);
            this.C.setBackground(getResources().getDrawable(R.drawable.hiad_splash_pro_bg));
            this.F = (TextView) this.B.findViewById(R.id.hiad_pro_desc);
            this.D = (ImageView) this.B.findViewById(R.id.hiad_pro_arrow);
            V();
        } catch (RuntimeException unused) {
            str = "init RuntimeException";
            gl.I("PPSSplashProView", str);
        } catch (Exception unused2) {
            str = "init error";
            gl.I("PPSSplashProView", str);
        }
    }

    private void I() {
        gl.V("PPSSplashProView", "showLogo:" + this.L + ",orientation:" + this.f32885a);
        if (this.L || this.f32885a != 1) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.bottomMargin += ay.I(getContext());
            setLayoutParams(layoutParams2);
        }
    }

    private void V() {
        Context applicationContext = getContext().getApplicationContext();
        fr Code = fr.Code(applicationContext);
        int V = v.V(applicationContext, Code.J());
        int M = Code.M();
        int V2 = v.V(applicationContext, Code.K());
        final int V3 = v.V(applicationContext, Code.V(applicationContext));
        this.C.setRadius(M);
        this.f32886b.setRectCornerRadius(v.V(applicationContext, M));
        this.C.setMinimumHeight(V);
        if (v.d(getContext())) {
            this.F.setTextSize(1, Code.K() * 2);
        } else {
            this.F.setTextSize(2, Code.K());
        }
        this.F.setMinimumHeight(V);
        ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        layoutParams.height = V2;
        layoutParams.width = V2;
        this.D.setLayoutParams(layoutParams);
        this.B.post(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.1
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams2 = PPSSplashProView.this.getLayoutParams();
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
                    layoutParams3.bottomMargin = V3;
                    PPSSplashProView.this.setLayoutParams(layoutParams3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        gl.V("PPSSplashProView", "startAnimators");
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f32886b, Key.ALPHA, 0.0f, 1.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.C, "scaleX", 0.85f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.C, "scaleY", 0.85f, 1.0f);
            ofFloat2.setDuration(300L);
            ofFloat3.setDuration(300L);
            AnimatorSet animatorSet = new AnimatorSet();
            this.f32887c = animatorSet;
            animatorSet.playTogether(ofFloat2, ofFloat3, ofFloat);
            this.f32887c.setInterpolator(new fs(0.2f, 0.0f, 0.2f, 1.0f));
            this.f32887c.addListener(new Animator.AnimatorListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    gl.V("PPSSplashProView", "upAndAlphaSet onAnimationEnd");
                    try {
                        PPSSplashProView.this.C.V();
                        if (PPSSplashProView.this.f32889e == null || PPSSplashProView.this.f32890f == null) {
                            return;
                        }
                        PPSSplashProView.this.f32889e.start();
                        PPSSplashProView.this.f32890f.start();
                    } catch (Throwable th) {
                        gl.I("PPSSplashProView", "scale err: %s", th.getClass().getSimpleName());
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    try {
                        PPSSplashProView.this.C.Code();
                    } catch (Throwable th) {
                        gl.I("PPSSplashProView", "prepare err: %s", th.getClass().getSimpleName());
                    }
                }
            });
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.C, "scaleX", 1.0f, 0.85f);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.C, "scaleY", 1.0f, 0.85f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.f32888d = animatorSet2;
            animatorSet2.setDuration(0L);
            this.f32888d.setInterpolator(new fs(0.2f, 0.0f, 0.2f, 1.0f));
            this.f32888d.playTogether(ofFloat4, ofFloat5);
            this.f32888d.addListener(new Animator.AnimatorListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    gl.V("PPSSplashProView", "scaleAnimationDown onAnimationEnd");
                    try {
                        PPSSplashProView.this.setVisibility(0);
                        if (PPSSplashProView.this.f32887c != null) {
                            PPSSplashProView.this.f32887c.start();
                        }
                    } catch (Throwable th) {
                        gl.I("PPSSplashProView", "up and alpha err: %s", th.getClass().getSimpleName());
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            this.D.setVisibility(4);
            B();
            this.f32888d.start();
        } catch (Throwable th) {
            gl.I("PPSSplashProView", "anim error: %s", th.getClass().getSimpleName());
            RoundLinearLayout roundLinearLayout = this.f32886b;
            if (roundLinearLayout != null) {
                roundLinearLayout.setBackground(getResources().getDrawable(R.drawable.hiad_splash_pro_bg_scan));
            }
            setVisibility(0);
        }
    }

    public void Code() {
        ScanningRelativeLayout scanningRelativeLayout = this.C;
        if (scanningRelativeLayout != null) {
            scanningRelativeLayout.I();
        }
        AnimatorSet animatorSet = this.f32888d;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f32888d = null;
        }
        AnimatorSet animatorSet2 = this.f32887c;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
            this.f32887c = null;
        }
        AnimatorSet animatorSet3 = this.f32889e;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
            this.f32889e = null;
        }
        AnimatorSet animatorSet4 = this.f32890f;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
            this.f32890f = null;
        }
        AnimatorSet animatorSet5 = this.f32891g;
        if (animatorSet5 != null) {
            animatorSet5.cancel();
            this.f32891g = null;
        }
        AnimatorSet animatorSet6 = this.f32892h;
        if (animatorSet6 != null) {
            animatorSet6.cancel();
            this.f32892h = null;
        }
    }

    public void Code(boolean z10, int i10) {
        this.L = z10;
        if (this.C != null && i10 == 0) {
            RoundLinearLayout roundLinearLayout = this.f32886b;
            if (roundLinearLayout != null) {
                roundLinearLayout.setBackground(getResources().getDrawable(R.drawable.hiad_splash_pro_bg_scan));
                this.f32886b.setAlpha(0.0f);
            }
            this.C.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                    if (i13 - i11 <= 0 || i14 - i12 <= 0 || i15 != 0 || i17 != 0) {
                        return;
                    }
                    PPSSplashProView.this.Z();
                }
            });
        }
        I();
    }

    public int getMode() {
        return this.S;
    }

    public void setDesc(String str) {
        if (this.F != null) {
            if (TextUtils.isEmpty(str)) {
                this.F.setText(R.string.hiad_splash_pro_desc);
            } else {
                this.F.setText(str);
            }
        }
    }

    public void setMode(int i10) {
        this.S = i10;
    }

    public void setOrientation(int i10) {
        this.f32885a = i10;
    }
}
