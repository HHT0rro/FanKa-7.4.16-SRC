package com.cupidapp.live.liveshow.view.comment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.cupidapp.live.liveshow.adapter.FKLiveCommentMessageViewModel;
import com.cupidapp.live.liveshow.model.CommentModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;

/* compiled from: FKLiveBarrageLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveBarrageLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public boolean f15347b;

    /* renamed from: c, reason: collision with root package name */
    public int f15348c;

    /* renamed from: d, reason: collision with root package name */
    public int f15349d;

    /* renamed from: e, reason: collision with root package name */
    public int f15350e;

    /* renamed from: f, reason: collision with root package name */
    public int f15351f;

    /* renamed from: g, reason: collision with root package name */
    public int f15352g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final ArrayList<FKLiveCommentMessageLayout> f15353h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15354i;

    /* compiled from: FKLiveBarrageLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FKLiveCommentMessageLayout f15355b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FKLiveBarrageLayout f15356c;

        public a(FKLiveCommentMessageLayout fKLiveCommentMessageLayout, FKLiveBarrageLayout fKLiveBarrageLayout) {
            this.f15355b = fKLiveCommentMessageLayout;
            this.f15356c = fKLiveBarrageLayout;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            animation.cancel();
            this.f15355b.setAnimation(false);
            this.f15356c.removeView(this.f15355b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBarrageLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15354i = new LinkedHashMap();
        this.f15348c = 1;
        this.f15350e = 5;
        this.f15353h = new ArrayList<>();
    }

    public static final void d(FKLiveBarrageLayout this$0) {
        s.i(this$0, "this$0");
        int height = this$0.getHeight();
        int i10 = this$0.f15348c;
        y.o(this$0, null, Integer.valueOf((height / i10) * i10), 1, null);
    }

    private final int getRandomTopMargin() {
        int random;
        if (this.f15349d == 0) {
            this.f15349d = getHeight() / this.f15348c;
        }
        int i10 = this.f15349d;
        if (i10 > 0) {
            if (i10 == 1) {
                return 0;
            }
            do {
                random = (int) (Math.random() * this.f15349d);
            } while (random == this.f15352g);
            this.f15352g = random;
        }
        return this.f15352g * (getHeight() / this.f15349d);
    }

    public final void b() {
        removeAllViews();
        this.f15353h.clear();
    }

    public final void c(boolean z10) {
        int c4;
        this.f15347b = z10;
        if (z10) {
            c4 = h.c(this, 60.0f);
        } else {
            c4 = h.c(this, 52.0f);
        }
        this.f15348c = c4;
        post(new Runnable() { // from class: com.cupidapp.live.liveshow.view.comment.a
            @Override // java.lang.Runnable
            public final void run() {
                FKLiveBarrageLayout.d(FKLiveBarrageLayout.this);
            }
        });
    }

    public final void e(@NotNull CommentModel model) {
        FKLiveCommentMessageLayout fKLiveCommentMessageLayout;
        s.i(model, "model");
        if (this.f15353h.size() < this.f15350e) {
            Context context = getContext();
            s.h(context, "context");
            fKLiveCommentMessageLayout = new FKLiveCommentMessageLayout(context, this.f15347b);
        } else if (this.f15353h.get(this.f15351f).g()) {
            this.f15350e++;
            Context context2 = getContext();
            s.h(context2, "context");
            fKLiveCommentMessageLayout = new FKLiveCommentMessageLayout(context2, this.f15347b);
        } else {
            FKLiveCommentMessageLayout fKLiveCommentMessageLayout2 = this.f15353h.get(this.f15351f);
            s.h(fKLiveCommentMessageLayout2, "commentLayoutCache[currentBarrageIndex]");
            fKLiveCommentMessageLayout = fKLiveCommentMessageLayout2;
            if (this.f15351f < this.f15353h.size() - 1) {
                this.f15351f++;
            } else {
                this.f15351f = 0;
            }
        }
        fKLiveCommentMessageLayout.setBarrage(true);
        fKLiveCommentMessageLayout.setCommentMessageModel(new FKLiveCommentMessageViewModel(model, false, 2, null));
        if (fKLiveCommentMessageLayout.getParent() == null) {
            addView(fKLiveCommentMessageLayout);
            ViewGroup.LayoutParams layoutParams = fKLiveCommentMessageLayout.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.setMargins(0, getRandomTopMargin(), 0, 0);
            }
        }
        if (this.f15353h.size() < this.f15350e) {
            this.f15353h.add(fKLiveCommentMessageLayout);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(fKLiveCommentMessageLayout, (Property<FKLiveCommentMessageLayout, Float>) View.TRANSLATION_X, h.l(this), -h.l(this));
        ofFloat.setDuration(5000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        fKLiveCommentMessageLayout.setAnimation(true);
        ofFloat.addListener(new a(fKLiveCommentMessageLayout, this));
        ofFloat.start();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBarrageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15354i = new LinkedHashMap();
        this.f15348c = 1;
        this.f15350e = 5;
        this.f15353h = new ArrayList<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveBarrageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15354i = new LinkedHashMap();
        this.f15348c = 1;
        this.f15350e = 5;
        this.f15353h = new ArrayList<>();
    }
}
