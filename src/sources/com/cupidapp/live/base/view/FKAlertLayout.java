package com.cupidapp.live.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKAlertLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKAlertLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f12456d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public boolean f12457b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12458c;

    /* compiled from: FKAlertLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKAlertLayout a(@NotNull ViewGroup viewContainer) {
            kotlin.jvm.internal.s.i(viewContainer, "viewContainer");
            if (viewContainer.getTag() != null && (viewContainer.getTag() instanceof FKAlertLayout)) {
                Object tag = viewContainer.getTag();
                kotlin.jvm.internal.s.g(tag, "null cannot be cast to non-null type com.cupidapp.live.base.view.FKAlertLayout");
                return (FKAlertLayout) tag;
            }
            Context context = viewContainer.getContext();
            kotlin.jvm.internal.s.h(context, "viewGroup.context");
            FKAlertLayout fKAlertLayout = new FKAlertLayout(context);
            viewContainer.addView(fKAlertLayout, viewContainer.getChildCount(), new ViewGroup.LayoutParams(-1, -1));
            viewContainer.setTag(fKAlertLayout);
            return fKAlertLayout;
        }

        @NotNull
        public final FKAlertLayout b(@NotNull Window window) {
            kotlin.jvm.internal.s.i(window, "window");
            View rootView = window.getDecorView().getRootView();
            kotlin.jvm.internal.s.g(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            return a((ViewGroup) rootView);
        }

        public final void c(@NotNull ViewGroup viewContainer) {
            kotlin.jvm.internal.s.i(viewContainer, "viewContainer");
            if (viewContainer.getTag() == null || !(viewContainer.getTag() instanceof FKAlertLayout)) {
                return;
            }
            Object tag = viewContainer.getTag();
            kotlin.jvm.internal.s.g(tag, "null cannot be cast to non-null type com.cupidapp.live.base.view.FKAlertLayout");
            viewContainer.removeView((FKAlertLayout) tag);
            viewContainer.setTag(null);
        }

        public final void d(@Nullable Window window) {
            if (window == null) {
                return;
            }
            View rootView = window.getDecorView().getRootView();
            kotlin.jvm.internal.s.g(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            c((ViewGroup) rootView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKAlertLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12458c = new LinkedHashMap();
        b();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f12458c;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(R$layout.layout_alert, this);
    }

    @NotNull
    public final FKAlertLayout c(int i10) {
        String string = getContext().getString(i10);
        kotlin.jvm.internal.s.h(string, "context.getString(messageId)");
        return d(string);
    }

    @NotNull
    public final FKAlertLayout d(@NotNull String message) {
        kotlin.jvm.internal.s.i(message, "message");
        if (message.length() > 0) {
            int i10 = R$id.messageView;
            ((TextView) a(i10)).setVisibility(0);
            ((TextView) a(i10)).setText(message);
        }
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(@Nullable KeyEvent keyEvent) {
        boolean z10 = this.f12457b;
        return z10 ? z10 : super.dispatchKeyEventPreIme(keyEvent);
    }

    @NotNull
    public final FKAlertLayout e() {
        ((ProgressBar) a(R$id.progressView)).setVisibility(0);
        return this;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent motionEvent) {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKAlertLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12458c = new LinkedHashMap();
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKAlertLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12458c = new LinkedHashMap();
        b();
    }
}
