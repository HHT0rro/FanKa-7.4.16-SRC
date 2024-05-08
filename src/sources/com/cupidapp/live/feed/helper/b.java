package com.cupidapp.live.feed.helper;

import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CardAnimatorHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final View f14307a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f14308b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f14309c;

    public b(@NotNull View view) {
        s.i(view, "view");
        this.f14307a = view;
        a();
    }

    public final void a() {
        this.f14308b = ObjectAnimator.ofFloat(this.f14307a, View.TRANSLATION_X, 0.0f, z0.h.c(this, 8.0f));
        this.f14309c = ObjectAnimator.ofFloat(this.f14307a, View.TRANSLATION_X, 0.0f, -z0.h.c(this, 8.0f));
        ObjectAnimator objectAnimator = this.f14308b;
        if (objectAnimator != null) {
            objectAnimator.setDuration(60L);
        }
        ObjectAnimator objectAnimator2 = this.f14308b;
        if (objectAnimator2 != null) {
            objectAnimator2.setRepeatCount(1);
        }
        ObjectAnimator objectAnimator3 = this.f14308b;
        if (objectAnimator3 != null) {
            objectAnimator3.setRepeatMode(2);
        }
        ObjectAnimator objectAnimator4 = this.f14309c;
        if (objectAnimator4 != null) {
            objectAnimator4.setDuration(60L);
        }
        ObjectAnimator objectAnimator5 = this.f14309c;
        if (objectAnimator5 != null) {
            objectAnimator5.setRepeatCount(1);
        }
        ObjectAnimator objectAnimator6 = this.f14309c;
        if (objectAnimator6 == null) {
            return;
        }
        objectAnimator6.setRepeatMode(2);
    }

    public final void b() {
        ObjectAnimator objectAnimator = this.f14309c;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
        d();
    }

    public final void c() {
        ObjectAnimator objectAnimator = this.f14308b;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
        d();
    }

    public final void d() {
        if (Build.VERSION.SDK_INT >= 26) {
            VibrationEffect createOneShot = VibrationEffect.createOneShot(20L, -1);
            Object systemService = this.f14307a.getContext().getSystemService("vibrator");
            s.g(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            ((Vibrator) systemService).vibrate(createOneShot);
            return;
        }
        Object systemService2 = this.f14307a.getContext().getSystemService("vibrator");
        s.g(systemService2, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) systemService2).vibrate(20L);
    }
}
