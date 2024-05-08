package n;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: BaseLottieAnimator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class a extends ValueAnimator {

    /* renamed from: b, reason: collision with root package name */
    public final Set<ValueAnimator.AnimatorUpdateListener> f51999b = new CopyOnWriteArraySet();

    /* renamed from: c, reason: collision with root package name */
    public final Set<Animator.AnimatorListener> f52000c = new CopyOnWriteArraySet();

    /* renamed from: d, reason: collision with root package name */
    public final Set<Animator.AnimatorPauseListener> f52001d = new CopyOnWriteArraySet();

    public void a() {
        Iterator<Animator.AnimatorListener> iterator2 = this.f52000c.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onAnimationCancel(this);
        }
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.f52000c.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f52001d.add(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f51999b.add(animatorUpdateListener);
    }

    public void c(boolean z10) {
        for (Animator.AnimatorListener animatorListener : this.f52000c) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z10);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    public void d() {
        Iterator<Animator.AnimatorPauseListener> iterator2 = this.f52001d.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onAnimationPause(this);
        }
    }

    public void e() {
        Iterator<Animator.AnimatorListener> iterator2 = this.f52000c.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onAnimationRepeat(this);
        }
    }

    public void g() {
        Iterator<Animator.AnimatorPauseListener> iterator2 = this.f52001d.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onAnimationResume(this);
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public void h(boolean z10) {
        for (Animator.AnimatorListener animatorListener : this.f52000c) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z10);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    public void i() {
        Iterator<ValueAnimator.AnimatorUpdateListener> iterator2 = this.f51999b.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onAnimationUpdate(this);
        }
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.f52000c.clear();
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.f51999b.clear();
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.f52000c.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f52001d.remove(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f51999b.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j10) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j10) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }
}
