package com.cupidapp.live.base.view.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLoadingLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f12743a = new h();

    public static /* synthetic */ void d(h hVar, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        hVar.c(str, z10);
    }

    public final ViewGroup a() {
        Activity activity;
        WeakReference<Activity> a10 = com.cupidapp.live.base.activity.a.f11763c.a();
        if (a10 == null || (activity = a10.get()) == null) {
            return null;
        }
        return (ViewGroup) activity.findViewById(16908290);
    }

    public final void b() {
        ViewGroup a10 = a();
        if (a10 == null) {
            return;
        }
        int childCount = a10.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = a10.getChildAt(i10);
            if (childAt instanceof FKLoadingLayout) {
                ((FKLoadingLayout) childAt).c();
                a10.removeView(childAt);
            }
        }
    }

    public final void c(@Nullable String str, boolean z10) {
        ViewGroup a10 = a();
        if (a10 == null) {
            return;
        }
        int childCount = a10.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = a10.getChildAt(i10);
            if (childAt instanceof FKLoadingLayout) {
                if (z10) {
                    return;
                }
                ((FKLoadingLayout) childAt).setLoadingText(str);
                return;
            }
        }
        Context context = a10.getContext();
        s.h(context, "contentView.context");
        FKLoadingLayout fKLoadingLayout = new FKLoadingLayout(context);
        fKLoadingLayout.setLoadingText(str);
        fKLoadingLayout.f();
        a10.addView(fKLoadingLayout);
    }
}
