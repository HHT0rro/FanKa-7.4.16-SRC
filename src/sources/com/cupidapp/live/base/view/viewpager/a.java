package com.cupidapp.live.base.view.viewpager;

import android.view.View;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKBasePagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final View f12950a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Object f12951b;

    /* renamed from: c, reason: collision with root package name */
    public int f12952c;

    public a(@NotNull View itemView, @NotNull Object model, int i10) {
        s.i(itemView, "itemView");
        s.i(model, "model");
        this.f12950a = itemView;
        this.f12951b = model;
        this.f12952c = i10;
    }

    @NotNull
    public final View a() {
        return this.f12950a;
    }

    @NotNull
    public final Object b() {
        return this.f12951b;
    }

    public final int c() {
        return this.f12952c;
    }

    public final void d(int i10) {
        this.f12952c = i10;
    }
}
