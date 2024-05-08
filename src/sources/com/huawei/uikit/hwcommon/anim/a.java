package com.huawei.uikit.hwcommon.anim;

import android.animation.Animator;
import com.huawei.uikit.hwcommon.anim.HwGradientAnimatorMgr;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a implements Animator.AnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HwGradientAnimatorMgr f34906a;

    public a(HwGradientAnimatorMgr hwGradientAnimatorMgr) {
        this.f34906a = hwGradientAnimatorMgr;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        HwGradientAnimatorMgr.OnAnimatorListener onAnimatorListener;
        Map map;
        HwGradientAnimatorMgr.OnAnimatorListener onAnimatorListener2;
        onAnimatorListener = this.f34906a.f34904d;
        if (onAnimatorListener != null) {
            map = this.f34906a.f34903c;
            for (String str : map.h()) {
                onAnimatorListener2 = this.f34906a.f34904d;
                onAnimatorListener2.onAnimationCancel(animator, str);
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        HwGradientAnimatorMgr.OnAnimatorListener onAnimatorListener;
        Map map;
        HwGradientAnimatorMgr.OnAnimatorListener onAnimatorListener2;
        onAnimatorListener = this.f34906a.f34904d;
        if (onAnimatorListener != null) {
            map = this.f34906a.f34903c;
            for (String str : map.h()) {
                onAnimatorListener2 = this.f34906a.f34904d;
                onAnimatorListener2.onAnimationEnd(animator, str);
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        HwGradientAnimatorMgr.OnAnimatorListener onAnimatorListener;
        Map map;
        HwGradientAnimatorMgr.OnAnimatorListener onAnimatorListener2;
        onAnimatorListener = this.f34906a.f34904d;
        if (onAnimatorListener != null) {
            map = this.f34906a.f34903c;
            for (String str : map.h()) {
                onAnimatorListener2 = this.f34906a.f34904d;
                onAnimatorListener2.onAnimationStart(animator, str);
            }
        }
    }
}
