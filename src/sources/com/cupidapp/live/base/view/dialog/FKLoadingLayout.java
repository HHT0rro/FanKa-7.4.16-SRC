package com.cupidapp.live.base.view.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.view.loading.CircularLoadingView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKLoadingLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLoadingLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12717b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLoadingLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12717b = new LinkedHashMap();
        d();
    }

    public static final boolean e(View view, MotionEvent motionEvent) {
        view.performClick();
        return true;
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f12717b;
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

    public final void c() {
        ((CircularLoadingView) b(R$id.loading_view)).f();
    }

    public final void d() {
        z.a(this, 2131559237, true);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.base.view.dialog.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean e2;
                e2 = FKLoadingLayout.e(view, motionEvent);
                return e2;
            }
        });
    }

    public final void f() {
        ((CircularLoadingView) b(R$id.loading_view)).h();
    }

    public final void setLoadingText(@Nullable String str) {
        if (str == null || str.length() == 0) {
            int i10 = R$id.loading_text;
            ((TextView) b(i10)).setVisibility(8);
            ((TextView) b(i10)).setText((CharSequence) null);
        } else {
            int i11 = R$id.loading_text;
            ((TextView) b(i11)).setVisibility(0);
            ((TextView) b(i11)).setText(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLoadingLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12717b = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLoadingLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12717b = new LinkedHashMap();
        d();
    }
}
