package com.cupidapp.live.base.view;

import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SoftKeyboardWatcher.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final FragmentActivity f12853a;

    /* renamed from: b, reason: collision with root package name */
    public int f12854b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public ViewTreeObserver.OnGlobalLayoutListener f12855c;

    /* renamed from: d, reason: collision with root package name */
    public int f12856d;

    public o(@NotNull FragmentActivity activity) {
        kotlin.jvm.internal.s.i(activity, "activity");
        this.f12853a = activity;
        this.f12856d = 50;
    }

    public static final void c(o this$0, Rect rect, Function2 callback) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(rect, "$rect");
        kotlin.jvm.internal.s.i(callback, "$callback");
        Rect rect2 = new Rect();
        this$0.f12853a.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
        int height = rect.height() - rect2.height();
        boolean z10 = height >= this$0.f12856d;
        if (!z10) {
            height = 0;
        }
        int abs = Math.abs(height);
        if (this$0.f12854b != abs) {
            this$0.f12854b = abs;
            callback.mo1743invoke(Integer.valueOf(abs), Boolean.valueOf(z10));
        }
    }

    public final void b(@NotNull final Function2<? super Integer, ? super Boolean, kotlin.p> callback) {
        kotlin.jvm.internal.s.i(callback, "callback");
        ViewGroup viewGroup = (ViewGroup) this.f12853a.findViewById(16908290);
        d();
        final Rect rect = new Rect();
        viewGroup.getWindowVisibleDisplayFrame(rect);
        this.f12856d = rect.height() / 6;
        this.f12855c = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.cupidapp.live.base.view.n
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                o.c(o.this, rect, callback);
            }
        };
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this.f12855c);
    }

    public final void d() {
        ((ViewGroup) this.f12853a.findViewById(16908290)).getViewTreeObserver().removeOnGlobalLayoutListener(this.f12855c);
    }
}
