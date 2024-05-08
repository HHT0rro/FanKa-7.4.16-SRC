package com.cupidapp.live.liveshow.view.giftplayer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.RoundCornerModel;
import com.cupidapp.live.base.view.animation.FKWebpAnimationView;
import com.cupidapp.live.liveshow.model.FullLiveVisibleGiftModel;
import com.cupidapp.live.liveshow.view.tag.ParallelogramLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.d;
import kotlin.f;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: SkyGiftLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SkyGiftLayout extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final a f15643i;

    /* renamed from: j, reason: collision with root package name */
    public static final int f15644j;

    /* renamed from: k, reason: collision with root package name */
    public static final int f15645k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static final SkyGiftSizeModel f15646l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public static final Map<Integer, SkyGiftSizeModel> f15647m;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15648b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public String f15649c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f15650d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f15651e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f15652f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15653g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15654h;

    /* compiled from: SkyGiftLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Animator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements Animator.AnimatorListener {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f15656c;

        public b(Function0 function0) {
            this.f15656c = function0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            SkyGiftLayout.this.setShowBgAnimation(false);
            ((FKWebpAnimationView) SkyGiftLayout.this.a(R$id.sky_gift_webp_view)).e();
            SkyGiftLayout.this.f15648b = false;
            this.f15656c.invoke();
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
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
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
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            s.i(animator, "animator");
            SkyGiftLayout.this.setVisibility(0);
        }
    }

    static {
        a aVar = new a(null);
        f15643i = aVar;
        f15644j = h.c(aVar, 11.0f);
        f15645k = h.c(aVar, 1.0f);
        SkyGiftSizeModel skyGiftSizeModel = new SkyGiftSizeModel(h.c(aVar, 144.0f), h.c(aVar, 63.0f));
        f15646l = skyGiftSizeModel;
        f15647m = i0.g(f.a(0, skyGiftSizeModel), f.a(1, new SkyGiftSizeModel(h.c(aVar, 180.0f), h.c(aVar, 72.0f))), f.a(2, new SkyGiftSizeModel(h.c(aVar, 216.0f), h.c(aVar, 81.0f))), f.a(3, new SkyGiftSizeModel(h.c(aVar, 270.0f), h.c(aVar, 99.0f))));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkyGiftLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15654h = new LinkedHashMap();
        e();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15654h;
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

    public final void c(@NotNull FullLiveVisibleGiftModel model, @NotNull Function0<p> failCallback) {
        float f10;
        s.i(model, "model");
        s.i(failCallback, "failCallback");
        String animationPath = model.getAnimationPath();
        if (animationPath.length() == 0) {
            this.f15648b = false;
            failCallback.invoke();
            return;
        }
        this.f15648b = true;
        this.f15653g = model.getLaunchPathwayType() != null;
        SkyGiftSizeModel d10 = d(model.getAnimationSize());
        int height = d10.getHeight();
        float f11 = height;
        float f12 = f11 * 0.5f;
        int i10 = R$id.sky_gift_webp_view;
        FKWebpAnimationView sky_gift_webp_view = (FKWebpAnimationView) a(i10);
        s.h(sky_gift_webp_view, "sky_gift_webp_view");
        y.n(sky_gift_webp_view, Integer.valueOf((int) f12), Integer.valueOf(height));
        if (s.d(this.f15649c, animationPath)) {
            ((FKWebpAnimationView) a(i10)).f();
            f10 = f12;
        } else {
            FKWebpAnimationView sky_gift_webp_view2 = (FKWebpAnimationView) a(i10);
            s.h(sky_gift_webp_view2, "sky_gift_webp_view");
            f10 = f12;
            FKWebpAnimationView.b(sky_gift_webp_view2, animationPath, 0, null, null, 14, null);
            this.f15649c = animationPath;
        }
        int i11 = f15645k;
        int i12 = ((int) (f10 * 0.3f)) + (i11 * 2);
        int i13 = R$id.sky_gift_big_avatar_img;
        ImageLoaderView sky_gift_big_avatar_img = (ImageLoaderView) a(i13);
        s.h(sky_gift_big_avatar_img, "sky_gift_big_avatar_img");
        y.n(sky_gift_big_avatar_img, Integer.valueOf(i12), Integer.valueOf(i12));
        ImageLoaderView sky_gift_big_avatar_img2 = (ImageLoaderView) a(i13);
        s.h(sky_gift_big_avatar_img2, "sky_gift_big_avatar_img");
        y.m(sky_gift_big_avatar_img2, null, Integer.valueOf((int) (f11 * 0.125f)), null, null, 13, null);
        com.cupidapp.live.base.imageloader.b bVar = new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, 0, R$mipmap.icon_placeholder_circle_avatar, null, null, new RoundCornerModel(true, 0, i11, com.cupidapp.live.base.utils.h.b(model.getAvatarBorderColor()), false, false, false, false, 242, null), null, false, 0, 0, false, null, null, 521983, null);
        ImageLoaderView sky_gift_big_avatar_img3 = (ImageLoaderView) a(i13);
        s.h(sky_gift_big_avatar_img3, "sky_gift_big_avatar_img");
        ImageLoaderView.g(sky_gift_big_avatar_img3, model.getViewerAvatar(), bVar, null, 4, null);
        int i14 = ((int) (f10 * 0.15f)) + (i11 * 2);
        int i15 = R$id.sky_gift_small_avatar_img;
        ImageLoaderView sky_gift_small_avatar_img = (ImageLoaderView) a(i15);
        s.h(sky_gift_small_avatar_img, "sky_gift_small_avatar_img");
        y.n(sky_gift_small_avatar_img, Integer.valueOf(i14), Integer.valueOf(i14));
        ConstraintSet constraintSet = new ConstraintSet();
        int i16 = R$id.sky_gift_parent_layout;
        constraintSet.clone((ConstraintLayout) a(i16));
        constraintSet.constrainCircle(((ImageLoaderView) a(i15)).getId(), ((ImageLoaderView) a(i13)).getId(), i12 / 2, 135.0f);
        constraintSet.applyTo((ConstraintLayout) a(i16));
        ImageLoaderView sky_gift_small_avatar_img2 = (ImageLoaderView) a(i15);
        s.h(sky_gift_small_avatar_img2, "sky_gift_small_avatar_img");
        ImageLoaderView.g(sky_gift_small_avatar_img2, model.getAnchorAvatar(), bVar, null, 4, null);
        ParallelogramLayout sky_gift_parallelogram_layout = (ParallelogramLayout) a(R$id.sky_gift_parallelogram_layout);
        s.h(sky_gift_parallelogram_layout, "sky_gift_parallelogram_layout");
        y.m(sky_gift_parallelogram_layout, null, Integer.valueOf(f15644j), Integer.valueOf(d10.getDescMarginEnd()), null, 9, null);
        int i17 = R$id.sky_gift_desc_text_view;
        TextView sky_gift_desc_text_view = (TextView) a(i17);
        s.h(sky_gift_desc_text_view, "sky_gift_desc_text_view");
        y.i(sky_gift_desc_text_view, (r18 & 1) != 0 ? 0.0f : 0.0f, kotlin.collections.s.m(-157659, -56525), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : GradientDrawable.Orientation.TOP_BOTTOM, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
        ((TextView) a(i17)).setText(model.getDescription());
        g(height, failCallback);
    }

    public final SkyGiftSizeModel d(Integer num) {
        SkyGiftSizeModel skyGiftSizeModel = f15647m.get(num);
        return skyGiftSizeModel == null ? f15646l : skyGiftSizeModel;
    }

    public final void e() {
        z.a(this, R$layout.layout_sky_gift, true);
    }

    public final boolean f() {
        return this.f15648b;
    }

    public final void g(int i10, Function0<p> function0) {
        float a10 = z0.s.f54824a.a();
        float f10 = i10 / 2;
        float f11 = (0.6f * a10) - f10;
        float f12 = (0.65f * a10) - f10;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<SkyGiftLayout, Float>) View.Y, a10, f11);
        this.f15650d = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(2000L);
        }
        ObjectAnimator objectAnimator = this.f15650d;
        if (objectAnimator != null) {
            objectAnimator.addListener(new c());
        }
        ObjectAnimator objectAnimator2 = this.f15650d;
        if (objectAnimator2 != null) {
            objectAnimator2.start();
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, (Property<SkyGiftLayout, Float>) View.Y, f11, f12);
        this.f15651e = ofFloat2;
        if (ofFloat2 != null) {
            ofFloat2.setDuration(1500L);
        }
        ObjectAnimator objectAnimator3 = this.f15651e;
        if (objectAnimator3 != null) {
            objectAnimator3.setStartDelay(2000L);
        }
        ObjectAnimator objectAnimator4 = this.f15651e;
        if (objectAnimator4 != null) {
            objectAnimator4.start();
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, (Property<SkyGiftLayout, Float>) View.Y, f12, 0.0f - i10);
        this.f15652f = ofFloat3;
        if (ofFloat3 != null) {
            ofFloat3.setDuration(1000L);
        }
        ObjectAnimator objectAnimator5 = this.f15652f;
        if (objectAnimator5 != null) {
            objectAnimator5.setStartDelay(3500L);
        }
        ObjectAnimator objectAnimator6 = this.f15652f;
        if (objectAnimator6 != null) {
            objectAnimator6.addListener(new b(function0));
        }
        ObjectAnimator objectAnimator7 = this.f15652f;
        if (objectAnimator7 != null) {
            objectAnimator7.start();
        }
    }

    public final boolean getShowBgAnimation() {
        return this.f15653g;
    }

    public final void h() {
        ((FKWebpAnimationView) a(R$id.sky_gift_webp_view)).i();
        ObjectAnimator objectAnimator = this.f15650d;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
        }
        ObjectAnimator objectAnimator2 = this.f15650d;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        ObjectAnimator objectAnimator3 = this.f15651e;
        if (objectAnimator3 != null) {
            objectAnimator3.removeAllListeners();
        }
        ObjectAnimator objectAnimator4 = this.f15651e;
        if (objectAnimator4 != null) {
            objectAnimator4.cancel();
        }
        ObjectAnimator objectAnimator5 = this.f15652f;
        if (objectAnimator5 != null) {
            objectAnimator5.removeAllListeners();
        }
        ObjectAnimator objectAnimator6 = this.f15652f;
        if (objectAnimator6 != null) {
            objectAnimator6.cancel();
        }
    }

    public final void setShowBgAnimation(boolean z10) {
        this.f15653g = z10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkyGiftLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15654h = new LinkedHashMap();
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkyGiftLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15654h = new LinkedHashMap();
        e();
    }
}
