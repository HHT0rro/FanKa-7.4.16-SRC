package com.cupidapp.live.liveshow.view.viewerenter;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.grpc.LiveUserEntryModel;
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
import z0.h;
import z0.u;
import z0.z;

/* compiled from: LiveViewerRightEnterAnimatorLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LiveViewerRightEnterAnimatorLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f16023b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f16024c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final List<LiveUserEntryModel> f16025d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16026e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16027f;

    /* compiled from: Animator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            LiveViewerRightEnterAnimatorLayout.this.i();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            s.i(animator, "animator");
        }
    }

    /* compiled from: Animator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            if (!LiveViewerRightEnterAnimatorLayout.this.f16025d.isEmpty()) {
                LiveViewerRightEnterAnimatorLayout.this.f16025d.remove(0);
            }
            LiveViewerRightEnterAnimatorLayout.this.e();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            s.i(animator, "animator");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveViewerRightEnterAnimatorLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16027f = new LinkedHashMap();
        this.f16025d = new ArrayList();
        f();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16027f;
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

    public final void e() {
        LiveUserEntryModel liveUserEntryModel = (LiveUserEntryModel) CollectionsKt___CollectionsKt.V(this.f16025d);
        User user = liveUserEntryModel != null ? liveUserEntryModel.getUser() : null;
        if (user == null) {
            setVisibility(8);
            this.f16026e = false;
            return;
        }
        setVisibility(0);
        this.f16026e = true;
        LiveLabelListView right_enter_live_label_view = (LiveLabelListView) a(R$id.right_enter_live_label_view);
        s.h(right_enter_live_label_view, "right_enter_live_label_view");
        right_enter_live_label_view.n(liveUserEntryModel.getEnterAnimationLabels(), null, (r12 & 4) != 0 ? 11.0f : 0.0f, (r12 & 8) != 0 ? Integer.MAX_VALUE : 0, (r12 & 16) != 0 ? false : false);
        ((TextView) a(R$id.viewer_name_textview)).setText(user.getName());
        h();
    }

    public final void f() {
        z.a(this, R$layout.layout_live_viewer_right_enter_animator, true);
        TextView viewer_name_textview = (TextView) a(R$id.viewer_name_textview);
        s.h(viewer_name_textview, "viewer_name_textview");
        u.a(viewer_name_textview);
        TextView enter_live_textview = (TextView) a(R$id.enter_live_textview);
        s.h(enter_live_textview, "enter_live_textview");
        u.a(enter_live_textview);
        setVisibility(8);
    }

    public final void g(@NotNull LiveUserEntryModel model) {
        s.i(model, "model");
        this.f16025d.add(model);
        if (this.f16026e) {
            return;
        }
        e();
    }

    public final void h() {
        if (this.f16023b == null) {
            ObjectAnimator startEnterAnimator$lambda$1 = ObjectAnimator.ofFloat((ConstraintLayout) a(R$id.right_enter_layout), (Property<ConstraintLayout, Float>) View.X, h.l(this), (h.l(this) - h.c(this, 260.0f)) / 2.0f);
            startEnterAnimator$lambda$1.setDuration(1000L);
            s.h(startEnterAnimator$lambda$1, "startEnterAnimator$lambda$1");
            startEnterAnimator$lambda$1.addListener(new a());
            this.f16023b = startEnterAnimator$lambda$1;
        }
        ObjectAnimator objectAnimator = this.f16023b;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    public final void i() {
        if (this.f16024c == null) {
            ObjectAnimator startExitAnimator$lambda$3 = ObjectAnimator.ofFloat((ConstraintLayout) a(R$id.right_enter_layout), (Property<ConstraintLayout, Float>) View.X, (h.l(this) - h.c(this, 260.0f)) / 2.0f, -h.c(this, 260.0f));
            startExitAnimator$lambda$3.setDuration(1000L);
            startExitAnimator$lambda$3.setStartDelay(2000L);
            s.h(startExitAnimator$lambda$3, "startExitAnimator$lambda$3");
            startExitAnimator$lambda$3.addListener(new b());
            this.f16024c = startExitAnimator$lambda$3;
        }
        ObjectAnimator objectAnimator = this.f16024c;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f16025d.clear();
        this.f16026e = false;
        ObjectAnimator objectAnimator = this.f16023b;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
        }
        ObjectAnimator objectAnimator2 = this.f16024c;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllListeners();
        }
        ObjectAnimator objectAnimator3 = this.f16023b;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
        }
        ObjectAnimator objectAnimator4 = this.f16024c;
        if (objectAnimator4 != null) {
            objectAnimator4.cancel();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveViewerRightEnterAnimatorLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16027f = new LinkedHashMap();
        this.f16025d = new ArrayList();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveViewerRightEnterAnimatorLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16027f = new LinkedHashMap();
        this.f16025d = new ArrayList();
        f();
    }
}
