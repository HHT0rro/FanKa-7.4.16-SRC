package com.huawei.uikit.hwcommon.anim;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.util.Pair;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.huawei.uikit.hwcommon.drawable.HwDrawableWrapper;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwGradientAnimatorMgr implements HwDrawableWrapper.OnStateChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public static final int f34901a = 50;

    /* renamed from: b, reason: collision with root package name */
    public static final int f34902b = 16;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, Pair<Integer, Integer>> f34903c = new HashMap(16);

    /* renamed from: d, reason: collision with root package name */
    public OnAnimatorListener f34904d;

    /* renamed from: e, reason: collision with root package name */
    public Animator f34905e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnAnimatorListener {
        void onAnimationCancel(@NonNull Animator animator, @NonNull String str);

        void onAnimationEnd(@NonNull Animator animator, @NonNull String str);

        void onAnimationStart(@NonNull Animator animator, @NonNull String str);

        void onAnimationUpdate(@NonNull Animator animator, @NonNull String str, int i10);

        boolean onPrepareAnimation(@NonNull int[] iArr, @NonNull int[] iArr2, int i10, int i11, @NonNull Map<String, Pair<Integer, Integer>> map);
    }

    public Animator getAnimator(@NonNull Map<String, Pair<Integer, Integer>> map) {
        this.f34903c = map;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "GradientValue", 0.0f, 1.0f);
        ofFloat.setInterpolator(HwFocusClickAnimatorUtil.getFrictionInterpolator());
        ofFloat.setDuration(50L);
        ofFloat.addListener(new a(this));
        return ofFloat;
    }

    public OnAnimatorListener getOnAnimatorListener() {
        return this.f34904d;
    }

    @Override // com.huawei.uikit.hwcommon.drawable.HwDrawableWrapper.OnStateChangedListener
    public void onStateChanged(int[] iArr, int[] iArr2, int i10, int i11) {
        if (this.f34904d == null || iArr == null || iArr2 == null) {
            return;
        }
        HashMap hashMap = new HashMap(16);
        if (this.f34904d.onPrepareAnimation(iArr, iArr2, i10, i11, hashMap)) {
            Animator animator = this.f34905e;
            if (animator != null && animator.isRunning()) {
                this.f34905e.cancel();
            }
            Animator animator2 = getAnimator(hashMap);
            this.f34905e = animator2;
            animator2.start();
        }
    }

    @Keep
    public void setGradientValue(float f10) {
        if (this.f34904d == null || this.f34905e == null) {
            return;
        }
        ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        for (Map.Entry<String, Pair<Integer, Integer>> entry : this.f34903c.entrySet()) {
            Pair<Integer, Integer> value = entry.getValue();
            this.f34904d.onAnimationUpdate(this.f34905e, entry.getKey(), ((Integer) argbEvaluator.evaluate(f10, value.first, value.second)).intValue());
        }
    }

    public void setOnAnimatorListener(OnAnimatorListener onAnimatorListener) {
        this.f34904d = onAnimatorListener;
    }
}
