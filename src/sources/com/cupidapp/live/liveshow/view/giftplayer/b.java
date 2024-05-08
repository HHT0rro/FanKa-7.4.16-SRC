package com.cupidapp.live.liveshow.view.giftplayer;

import android.app.Activity;
import android.view.View;
import com.cupidapp.live.R$mipmap;
import com.plattysoft.leonids.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveHeartRainAnimator.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final View f15660a;

    /* renamed from: b, reason: collision with root package name */
    public final long f15661b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15662c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15663d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public c f15664e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15665f;

    public b(@NotNull Activity activity, int i10, @NotNull View bottomView, long j10, int i11, int i12) {
        s.i(activity, "activity");
        s.i(bottomView, "bottomView");
        this.f15660a = bottomView;
        this.f15661b = j10;
        this.f15662c = i11;
        this.f15663d = i12;
        try {
            this.f15664e = new c(activity, 100, R$mipmap.icon_heart_rain, j10, i10).l(-2.0E-7f, 90).q(-0.1f, 0.1f, -0.15f, -0.25f).m(2000L).p(1.0f, 2.5f).o(-20, 20);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static final void d(b this$0, Function0 finished) {
        s.i(this$0, "this$0");
        s.i(finished, "$finished");
        this$0.f15665f = false;
        finished.invoke();
    }

    public final boolean b() {
        return this.f15665f;
    }

    public final void c(@NotNull final Function0<p> finished) {
        s.i(finished, "finished");
        if (this.f15665f) {
            return;
        }
        this.f15665f = true;
        c cVar = this.f15664e;
        if (cVar != null) {
            cVar.d();
        }
        c cVar2 = this.f15664e;
        if (cVar2 != null) {
            cVar2.h(this.f15660a, 48, this.f15663d, this.f15662c);
        }
        this.f15660a.postDelayed(new Runnable() { // from class: com.cupidapp.live.liveshow.view.giftplayer.a
            @Override // java.lang.Runnable
            public final void run() {
                b.d(b.this, finished);
            }
        }, this.f15662c + this.f15661b);
    }

    public final void e() {
        c cVar = this.f15664e;
        if (cVar != null) {
            cVar.d();
        }
    }

    public /* synthetic */ b(Activity activity, int i10, View view, long j10, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, i10, view, j10, i11, (i13 & 32) != 0 ? 30 : i12);
    }
}
