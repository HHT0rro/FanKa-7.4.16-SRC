package com.cupidapp.live.liveshow.view.viewerenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.grpc.LiveUserEntryModel;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.base.view.animation.FKWebpAnimationView;
import com.cupidapp.live.liveshow.view.label.LiveLabelListView;
import com.cupidapp.live.profile.model.User;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKLiveViewerEnterCarLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKLiveViewerEnterCarLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public boolean f16004b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f16005c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f16006d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final List<LiveUserEntryModel> f16007e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16008f;

    /* compiled from: FKLiveViewerEnterCarLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f16010c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f16011d;

        public a(float f10, float f11) {
            this.f16010c = f10;
            this.f16011d = f11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            FKLiveViewerEnterCarLayout.this.j(this.f16010c, -this.f16011d);
        }
    }

    /* compiled from: FKLiveViewerEnterCarLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            FKLiveViewerEnterCarLayout.this.f16007e.remove(0);
            FKLiveViewerEnterCarLayout.this.f16004b = false;
            FKLiveViewerEnterCarLayout.this.setVisibility(8);
            ((FKWebpAnimationView) FKLiveViewerEnterCarLayout.this.a(R$id.viewerEnterCarBackgroundImageView)).i();
            FKLiveViewerEnterCarLayout.this.k();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveViewerEnterCarLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16008f = new LinkedHashMap();
        this.f16007e = new ArrayList();
        g();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16008f;
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

    public final void f(LiveUserEntryModel liveUserEntryModel) {
        User user;
        int width;
        if (liveUserEntryModel == null || (user = liveUserEntryModel.getUser()) == null) {
            return;
        }
        boolean z10 = true;
        this.f16004b = true;
        setVisibility(0);
        int i10 = R$id.viewerEnterCarUserNameTextView;
        ((TextView) a(i10)).setText(user.getName());
        LiveLabelListView enter_car_live_label_view = (LiveLabelListView) a(R$id.enter_car_live_label_view);
        s.h(enter_car_live_label_view, "enter_car_live_label_view");
        enter_car_live_label_view.n(liveUserEntryModel.getFloatDecorationLabels(), null, (r12 & 4) != 0 ? 11.0f : 0.0f, (r12 & 8) != 0 ? Integer.MAX_VALUE : 0, (r12 & 16) != 0 ? false : false);
        String decoration = liveUserEntryModel.getDecoration();
        if (!(decoration == null || decoration.length() == 0)) {
            FKWebpAnimationView viewerEnterCarBackgroundImageView = (FKWebpAnimationView) a(R$id.viewerEnterCarBackgroundImageView);
            s.h(viewerEnterCarBackgroundImageView, "viewerEnterCarBackgroundImageView");
            FKWebpAnimationView.h(viewerEnterCarBackgroundImageView, liveUserEntryModel.getDecoration(), 0, null, null, 14, null);
        }
        String textColor = liveUserEntryModel.getTextColor();
        if (textColor != null && textColor.length() != 0) {
            z10 = false;
        }
        if (!z10) {
            ((TextView) a(i10)).setTextColor(h.b(liveUserEntryModel.getTextColor()));
        }
        if (getWidth() == 0) {
            measure(View.MeasureSpec.makeMeasureSpec(z0.h.l(this), 0), View.MeasureSpec.makeMeasureSpec(z0.h.k(this), Integer.MIN_VALUE));
            width = getMeasuredWidth();
        } else {
            width = getWidth();
        }
        i(width);
    }

    public final void g() {
        z.a(this, R$layout.layout_live_viewer_enter_car, true);
    }

    public final void h(@NotNull LiveUserEntryModel model) {
        s.i(model, "model");
        this.f16007e.add(model);
        k();
    }

    public final void i(float f10) {
        float l10 = z0.h.l(this);
        float f11 = (l10 - f10) / 2;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<FKLiveViewerEnterCarLayout, Float>) View.X, l10, f11);
        ofFloat.setDuration(1500L);
        ofFloat.addListener(new a(f11, f10));
        ofFloat.start();
        this.f16005c = ofFloat;
    }

    public final void j(float f10, float f11) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<FKLiveViewerEnterCarLayout, Float>) View.X, f10, f11);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(2500L);
        ofFloat.addListener(new b());
        ofFloat.start();
        this.f16006d = ofFloat;
    }

    public final void k() {
        if (this.f16004b) {
            return;
        }
        f((LiveUserEntryModel) CollectionsKt___CollectionsKt.V(this.f16007e));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f16005c;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
        }
        ObjectAnimator objectAnimator2 = this.f16005c;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        this.f16005c = null;
        ObjectAnimator objectAnimator3 = this.f16006d;
        if (objectAnimator3 != null) {
            objectAnimator3.removeAllListeners();
        }
        ObjectAnimator objectAnimator4 = this.f16006d;
        if (objectAnimator4 != null) {
            objectAnimator4.cancel();
        }
        this.f16006d = null;
        FKWebpAnimationView fKWebpAnimationView = (FKWebpAnimationView) a(R$id.viewerEnterCarBackgroundImageView);
        if (fKWebpAnimationView != null) {
            fKWebpAnimationView.i();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveViewerEnterCarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16008f = new LinkedHashMap();
        this.f16007e = new ArrayList();
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveViewerEnterCarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16008f = new LinkedHashMap();
        this.f16007e = new ArrayList();
        g();
    }
}
