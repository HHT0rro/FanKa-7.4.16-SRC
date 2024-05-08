package com.cupidapp.live.main.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.t;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: FollowLiveAvatarTabLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FollowLiveAvatarTabLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AnimatorSet f16207b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public AnimatorSet f16208c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public AnimatorSet f16209d;

    /* renamed from: e, reason: collision with root package name */
    public int f16210e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final List<ImageModel> f16211f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public View f16212g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public AnimationState f16213h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16214i;

    /* compiled from: FollowLiveAvatarTabLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16215a;

        static {
            int[] iArr = new int[AnimationState.values().length];
            try {
                iArr[AnimationState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnimationState.LiveTabIn.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f16215a = iArr;
        }
    }

    /* compiled from: Animator.kt */
    @kotlin.d
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
            FollowLiveAvatarTabLayout.this.h();
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
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            FollowLiveAvatarTabLayout.this.h();
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
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements Animator.AnimatorListener {
        public d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            FollowLiveAvatarTabLayout.this.setVisibility(0);
            FollowLiveAvatarTabLayout.this.m();
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
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class e implements Animator.AnimatorListener {
        public e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            FollowLiveAvatarTabLayout.this.f16210e++;
            if (FollowLiveAvatarTabLayout.this.f16210e < FollowLiveAvatarTabLayout.this.f16211f.size()) {
                FollowLiveAvatarTabLayout.this.m();
            } else {
                FollowLiveAvatarTabLayout.this.setVisibility(8);
                FollowLiveAvatarTabLayout.this.k();
            }
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
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class f implements Animator.AnimatorListener {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ObjectAnimator f16221c;

        public f(ObjectAnimator objectAnimator) {
            this.f16221c = objectAnimator;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            FollowLiveAvatarTabLayout followLiveAvatarTabLayout = FollowLiveAvatarTabLayout.this;
            ObjectAnimator startAvatarAnimation$lambda$15$lambda$9$lambda$8 = this.f16221c;
            s.h(startAvatarAnimation$lambda$15$lambda$9$lambda$8, "startAvatarAnimation$lambda$15$lambda$9$lambda$8");
            followLiveAvatarTabLayout.setPivotX(h.c(this.f16221c, 20.0f));
            FollowLiveAvatarTabLayout followLiveAvatarTabLayout2 = FollowLiveAvatarTabLayout.this;
            ObjectAnimator startAvatarAnimation$lambda$15$lambda$9$lambda$82 = this.f16221c;
            s.h(startAvatarAnimation$lambda$15$lambda$9$lambda$82, "startAvatarAnimation$lambda$15$lambda$9$lambda$8");
            followLiveAvatarTabLayout2.setPivotY(h.c(this.f16221c, 20.0f));
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
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class g implements Animator.AnimatorListener {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ObjectAnimator f16223c;

        public g(ObjectAnimator objectAnimator) {
            this.f16223c = objectAnimator;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            s.i(animator, "animator");
            FollowLiveAvatarTabLayout followLiveAvatarTabLayout = FollowLiveAvatarTabLayout.this;
            ObjectAnimator startAvatarAnimation$lambda$15$lambda$9$lambda$7 = this.f16223c;
            s.h(startAvatarAnimation$lambda$15$lambda$9$lambda$7, "startAvatarAnimation$lambda$15$lambda$9$lambda$7");
            followLiveAvatarTabLayout.setPivotX(h.c(this.f16223c, 20.0f));
            FollowLiveAvatarTabLayout followLiveAvatarTabLayout2 = FollowLiveAvatarTabLayout.this;
            ObjectAnimator startAvatarAnimation$lambda$15$lambda$9$lambda$72 = this.f16223c;
            s.h(startAvatarAnimation$lambda$15$lambda$9$lambda$72, "startAvatarAnimation$lambda$15$lambda$9$lambda$7");
            followLiveAvatarTabLayout2.setPivotY(h.c(this.f16223c, 40.0f));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowLiveAvatarTabLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16214i = new LinkedHashMap();
        this.f16211f = new ArrayList();
        this.f16213h = AnimationState.None;
        j();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16214i;
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

    public final boolean g() {
        return this.f16213h != AnimationState.None;
    }

    public final void h() {
        setVisibility(8);
        View view = this.f16212g;
        if (view != null) {
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setAlpha(1.0f);
        }
        AnimatorSet animatorSet = this.f16208c;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
        }
        AnimatorSet animatorSet2 = this.f16208c;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        this.f16208c = null;
        AnimatorSet animatorSet3 = this.f16207b;
        if (animatorSet3 != null) {
            animatorSet3.removeAllListeners();
        }
        AnimatorSet animatorSet4 = this.f16207b;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
        this.f16207b = null;
        AnimatorSet animatorSet5 = this.f16209d;
        if (animatorSet5 != null) {
            animatorSet5.removeAllListeners();
        }
        AnimatorSet animatorSet6 = this.f16209d;
        if (animatorSet6 != null) {
            animatorSet6.cancel();
        }
        this.f16209d = null;
        this.f16212g = null;
        this.f16213h = AnimationState.None;
        this.f16210e = 0;
        this.f16211f.clear();
        p1.g.f52734a.s2(null);
    }

    public final void i(@NotNull List<ImageModel> avatars, @Nullable View view) {
        s.i(avatars, "avatars");
        for (ImageModel imageModel : avatars) {
            List<ImageModel> list = this.f16211f;
            ArrayList arrayList = new ArrayList(t.t(list, 10));
            Iterator<ImageModel> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(iterator2.next().getImageId());
            }
            if (!arrayList.contains(imageModel.getImageId())) {
                this.f16211f.add(imageModel);
            }
        }
        int i10 = a.f16215a[this.f16213h.ordinal()];
        if (i10 != 1) {
            if (i10 == 2 && this.f16210e < this.f16211f.size()) {
                AnimatorSet animatorSet = this.f16208c;
                if (animatorSet != null) {
                    animatorSet.removeAllListeners();
                }
                AnimatorSet animatorSet2 = this.f16208c;
                if (animatorSet2 != null) {
                    animatorSet2.cancel();
                }
                AnimatorSet animatorSet3 = this.f16208c;
                if (animatorSet3 != null) {
                    animatorSet3.addListener(new b());
                }
                l();
                return;
            }
            return;
        }
        this.f16212g = view;
        l();
    }

    public final void j() {
        z.a(this, R$layout.follow_live_avatar_item_view, true);
        setVisibility(8);
    }

    public final void k() {
        this.f16213h = AnimationState.LiveTabIn;
        if (this.f16208c == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f16212g, View.SCALE_X, 0.5f, 1.0f);
            ofFloat.setDuration(400L);
            AnimatorSet.Builder play = animatorSet.play(ofFloat);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f16212g, View.SCALE_Y, 0.5f, 1.0f);
            ofFloat2.setDuration(400L);
            AnimatorSet.Builder with = play.with(ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f16212g, View.ALPHA, 0.0f, 1.0f);
            ofFloat3.setDuration(400L);
            with.with(ofFloat3);
            animatorSet.addListener(new c());
            this.f16208c = animatorSet;
        }
        AnimatorSet animatorSet2 = this.f16208c;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
    }

    public final void l() {
        this.f16213h = AnimationState.LiveTabOut;
        if (this.f16207b == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f16212g, View.SCALE_X, 1.0f, 0.5f);
            ofFloat.setDuration(400L);
            AnimatorSet.Builder play = animatorSet.play(ofFloat);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f16212g, View.SCALE_Y, 1.0f, 0.5f);
            ofFloat2.setDuration(400L);
            AnimatorSet.Builder with = play.with(ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f16212g, View.ALPHA, 1.0f, 0.0f);
            ofFloat3.setDuration(400L);
            with.with(ofFloat3);
            animatorSet.addListener(new d());
            this.f16207b = animatorSet;
        }
        AnimatorSet animatorSet2 = this.f16207b;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
    }

    public final void m() {
        this.f16213h = AnimationState.AvatarAnimating;
        ImageModel imageModel = this.f16211f.get(this.f16210e);
        ImageLoaderView follow_live_avatar_imageview = (ImageLoaderView) a(R$id.follow_live_avatar_imageview);
        s.h(follow_live_avatar_imageview, "follow_live_avatar_imageview");
        ImageLoaderView.g(follow_live_avatar_imageview, imageModel, null, null, 6, null);
        if (this.f16209d == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<FollowLiveAvatarTabLayout, Float>) View.ALPHA, 0.0f, 1.0f);
            ofFloat.setDuration(300L);
            AnimatorSet animatorSet2 = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, (Property<FollowLiveAvatarTabLayout, Float>) View.SCALE_X, 0.5f, 1.0f);
            ofFloat2.setDuration(300L);
            AnimatorSet.Builder play = animatorSet2.play(ofFloat2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, (Property<FollowLiveAvatarTabLayout, Float>) View.SCALE_Y, 0.5f, 1.0f);
            ofFloat3.setDuration(300L);
            play.with(ofFloat3);
            ObjectAnimator startAvatarAnimation$lambda$15$lambda$9 = ObjectAnimator.ofFloat(this, (Property<FollowLiveAvatarTabLayout, Float>) View.ROTATION, 0.0f, 10.0f, -5.0f, 3.0f, 0.0f);
            startAvatarAnimation$lambda$15$lambda$9.setStartDelay(1000L);
            startAvatarAnimation$lambda$15$lambda$9.setDuration(600L);
            startAvatarAnimation$lambda$15$lambda$9.setInterpolator(new DecelerateInterpolator());
            s.h(startAvatarAnimation$lambda$15$lambda$9, "startAvatarAnimation$lambda$15$lambda$9");
            startAvatarAnimation$lambda$15$lambda$9.addListener(new g(startAvatarAnimation$lambda$15$lambda$9));
            startAvatarAnimation$lambda$15$lambda$9.addListener(new f(startAvatarAnimation$lambda$15$lambda$9));
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.setStartDelay(2000L);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, (Property<FollowLiveAvatarTabLayout, Float>) View.SCALE_X, 1.0f, 0.5f);
            ofFloat4.setDuration(400L);
            AnimatorSet.Builder play2 = animatorSet3.play(ofFloat4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this, (Property<FollowLiveAvatarTabLayout, Float>) View.SCALE_Y, 1.0f, 0.5f);
            ofFloat5.setDuration(400L);
            play2.with(ofFloat5);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this, (Property<FollowLiveAvatarTabLayout, Float>) View.ALPHA, 1.0f, 0.0f);
            ofFloat6.setStartDelay(2000L);
            ofFloat6.setDuration(400L);
            animatorSet.play(ofFloat).with(animatorSet2).with(startAvatarAnimation$lambda$15$lambda$9).with(animatorSet3).with(ofFloat6);
            animatorSet.addListener(new e());
            this.f16209d = animatorSet;
        }
        AnimatorSet animatorSet4 = this.f16209d;
        if (animatorSet4 != null) {
            animatorSet4.start();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowLiveAvatarTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16214i = new LinkedHashMap();
        this.f16211f = new ArrayList();
        this.f16213h = AnimationState.None;
        j();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowLiveAvatarTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16214i = new LinkedHashMap();
        this.f16211f = new ArrayList();
        this.f16213h = AnimationState.None;
        j();
    }
}
