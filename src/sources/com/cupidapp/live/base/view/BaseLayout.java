package com.cupidapp.live.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.base.activity.DefaultEvent;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaseLayout extends FrameLayout implements com.cupidapp.live.base.network.g {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public CompositeDisposable f12420b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12421c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12421c = new LinkedHashMap();
    }

    @Override // com.cupidapp.live.base.network.g
    public void H(@NotNull Disposable disposable) {
        kotlin.jvm.internal.s.i(disposable, "disposable");
        CompositeDisposable compositeDisposable = this.f12420b;
        if (compositeDisposable != null) {
            compositeDisposable.add(disposable);
        }
    }

    public final void a() {
        FKAlertLayout.f12456d.c(this);
    }

    public final void d() {
        FKAlertLayout.f12456d.a(this).e();
    }

    @Override // com.cupidapp.live.base.network.g
    @Nullable
    public Context getStartApiRequestContext() {
        return getContext();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        y0.a.b(y0.a.f54658a, this, null, 2, null);
        this.f12420b = new CompositeDisposable();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        y0.a.f54658a.c(this);
        CompositeDisposable compositeDisposable = this.f12420b;
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
        this.f12420b = null;
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull DefaultEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12421c = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12421c = new LinkedHashMap();
    }
}
