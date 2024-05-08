package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKClickAnimationLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class FKClickAnimationLayout extends RelativeLayout {

    /* renamed from: b, reason: collision with root package name */
    public ScaleAnimation f16850b;

    /* renamed from: c, reason: collision with root package name */
    public ScaleAnimation f16851c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16852d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16853e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public b f16854f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16855g = new LinkedHashMap();

    /* compiled from: FKClickAnimationLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            FKClickAnimationLayout.this.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
        }
    }

    public FKClickAnimationLayout(@Nullable Context context) {
        super(context);
        a();
    }

    public final void a() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
        this.f16850b = scaleAnimation;
        scaleAnimation.setFillAfter(true);
        ScaleAnimation scaleAnimation2 = this.f16850b;
        ScaleAnimation scaleAnimation3 = null;
        if (scaleAnimation2 == null) {
            kotlin.jvm.internal.s.A("mrbBtnDownAnimation");
            scaleAnimation2 = null;
        }
        scaleAnimation2.setDuration(100L);
        ScaleAnimation scaleAnimation4 = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.f16851c = scaleAnimation4;
        scaleAnimation4.setFillAfter(true);
        ScaleAnimation scaleAnimation5 = this.f16851c;
        if (scaleAnimation5 == null) {
            kotlin.jvm.internal.s.A("mrbBtnUpAnimation");
            scaleAnimation5 = null;
        }
        scaleAnimation5.setDuration(100L);
        ScaleAnimation scaleAnimation6 = this.f16851c;
        if (scaleAnimation6 == null) {
            kotlin.jvm.internal.s.A("mrbBtnUpAnimation");
        } else {
            scaleAnimation3 = scaleAnimation6;
        }
        scaleAnimation3.setAnimationListener(new a());
    }

    public final boolean getDisable() {
        return this.f16853e;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        com.cupidapp.live.base.utils.j.f12332a.a("FKClickAnimationClick ACTION", "event:" + ((Object) event));
        ScaleAnimation scaleAnimation = null;
        if (this.f16853e) {
            if (this.f16852d) {
                this.f16852d = false;
                ScaleAnimation scaleAnimation2 = this.f16851c;
                if (scaleAnimation2 == null) {
                    kotlin.jvm.internal.s.A("mrbBtnUpAnimation");
                } else {
                    scaleAnimation = scaleAnimation2;
                }
                startAnimation(scaleAnimation);
            }
            b bVar = this.f16854f;
            if (bVar != null) {
                bVar.a(false);
            }
            return true;
        }
        int action = event.getAction();
        if (action == 0) {
            this.f16852d = true;
            ScaleAnimation scaleAnimation3 = this.f16850b;
            if (scaleAnimation3 == null) {
                kotlin.jvm.internal.s.A("mrbBtnDownAnimation");
            } else {
                scaleAnimation = scaleAnimation3;
            }
            startAnimation(scaleAnimation);
            b bVar2 = this.f16854f;
            if (bVar2 != null) {
                bVar2.a(true);
            }
        } else if (action == 1) {
            if (this.f16852d) {
                this.f16852d = false;
                ScaleAnimation scaleAnimation4 = this.f16851c;
                if (scaleAnimation4 == null) {
                    kotlin.jvm.internal.s.A("mrbBtnUpAnimation");
                } else {
                    scaleAnimation = scaleAnimation4;
                }
                startAnimation(scaleAnimation);
            }
            b bVar3 = this.f16854f;
            if (bVar3 != null) {
                bVar3.a(false);
            }
        } else if (action != 2) {
            if (action == 3) {
                if (this.f16852d) {
                    this.f16852d = false;
                    ScaleAnimation scaleAnimation5 = this.f16851c;
                    if (scaleAnimation5 == null) {
                        kotlin.jvm.internal.s.A("mrbBtnUpAnimation");
                    } else {
                        scaleAnimation = scaleAnimation5;
                    }
                    startAnimation(scaleAnimation);
                }
                b bVar4 = this.f16854f;
                if (bVar4 != null) {
                    bVar4.a(false);
                }
            }
        } else if (event.getX() < 0.0f || event.getX() > getWidth() || event.getY() < 0.0f || event.getY() > getHeight()) {
            if (this.f16852d) {
                this.f16852d = false;
                ScaleAnimation scaleAnimation6 = this.f16851c;
                if (scaleAnimation6 == null) {
                    kotlin.jvm.internal.s.A("mrbBtnUpAnimation");
                } else {
                    scaleAnimation = scaleAnimation6;
                }
                startAnimation(scaleAnimation);
            }
            b bVar5 = this.f16854f;
            if (bVar5 != null) {
                bVar5.a(false);
            }
        }
        return super.onTouchEvent(event);
    }

    public final void setDisable(boolean z10) {
        this.f16853e = z10;
    }

    public final void setTouchChangeListener(@NotNull b touchListener) {
        kotlin.jvm.internal.s.i(touchListener, "touchListener");
        this.f16854f = touchListener;
    }

    public FKClickAnimationLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public FKClickAnimationLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }
}
