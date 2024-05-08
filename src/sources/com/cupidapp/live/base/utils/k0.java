package com.cupidapp.live.base.utils;

import android.view.View;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OnClickListenerUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class k0 implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public long f12336b;

    /* renamed from: c, reason: collision with root package name */
    public long f12337c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12338d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public View f12339e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Runnable f12340f = new Runnable() { // from class: com.cupidapp.live.base.utils.j0
        @Override // java.lang.Runnable
        public final void run() {
            k0.b(k0.this);
        }
    };

    public k0(long j10) {
        this.f12336b = j10;
        if (this.f12336b < 200) {
            this.f12336b = 200L;
        }
    }

    public static final void b(k0 this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (!this$0.f12338d) {
            this$0.c(this$0.f12339e);
            this$0.f12337c = 0L;
        }
        this$0.f12338d = false;
    }

    public abstract void c(@Nullable View view);

    public abstract void d(@Nullable View view);

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        if (System.currentTimeMillis() - this.f12337c < this.f12336b) {
            this.f12337c = 0L;
            this.f12338d = true;
            d(view);
            return;
        }
        this.f12339e = view;
        this.f12337c = System.currentTimeMillis();
        if (view != null) {
            view.removeCallbacks(this.f12340f);
        }
        if (view != null) {
            view.postDelayed(this.f12340f, this.f12336b);
        }
    }
}
