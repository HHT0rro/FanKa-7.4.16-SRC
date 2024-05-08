package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.base.view.progress.CircleProgressBarView;
import com.cupidapp.live.liveshow.model.GiftItemModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.h0;
import kotlin.collections.i0;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t1.b;
import z0.y;
import z0.z;

/* compiled from: CarGiftComboButton.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CarGiftComboButton extends BaseContinuousSendButton {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Map<Integer, Integer> f15482f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Map<Integer, Integer> f15483g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public AnimatorSet f15484h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public AnimatorSet f15485i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public ValueAnimator f15486j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15487k;

    /* compiled from: CarGiftComboButton.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements t1.b {
        public a() {
        }

        @Override // t1.b
        public void a() {
            c mListener = CarGiftComboButton.this.getMListener();
            if (mListener != null) {
                mListener.a();
            }
        }

        @Override // t1.b
        public void b(float f10) {
            b.a.a(this, f10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CarGiftComboButton(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15487k = new LinkedHashMap();
        this.f15482f = i0.g(kotlin.f.a(1, Integer.valueOf(R$mipmap.car_scale_one)), kotlin.f.a(2, Integer.valueOf(R$mipmap.car_scale_two)), kotlin.f.a(3, Integer.valueOf(R$mipmap.car_scale_three)), kotlin.f.a(4, Integer.valueOf(R$mipmap.car_scale_four)), kotlin.f.a(5, Integer.valueOf(R$mipmap.car_scale_five)), kotlin.f.a(6, Integer.valueOf(R$mipmap.car_scale_six)));
        this.f15483g = i0.g(kotlin.f.a(1, Integer.valueOf(R$mipmap.car_combo_one)), kotlin.f.a(2, Integer.valueOf(R$mipmap.car_combo_two)), kotlin.f.a(3, Integer.valueOf(R$mipmap.car_combo_three)), kotlin.f.a(4, Integer.valueOf(R$mipmap.car_combo_four)), kotlin.f.a(5, Integer.valueOf(R$mipmap.car_combo_five)), kotlin.f.a(6, Integer.valueOf(R$mipmap.car_combo_six)));
        l();
    }

    public static final void k(CarGiftComboButton this$0, ValueAnimator it) {
        s.i(this$0, "this$0");
        s.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        s.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.g(((Integer) animatedValue).intValue());
    }

    @Override // com.cupidapp.live.liveshow.view.giftpicker.view.BaseContinuousSendButton
    public void a() {
        super.a();
        ((FKSVGAImageView) d(R$id.cool_particle_animation)).K();
        ((FKSVGAImageView) d(R$id.color_light_ring_animation)).K();
        ((CircleProgressBarView) d(R$id.progress_view)).g();
        ((FKSVGAImageView) d(R$id.spread_ring_animation)).K();
        ValueAnimator valueAnimator = this.f15486j;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.f15486j;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    @Override // com.cupidapp.live.liveshow.view.giftpicker.view.BaseContinuousSendButton
    public void b(@NotNull GiftItemModel gift, int i10, @Nullable String str) {
        s.i(gift, "gift");
        String itemId = gift.getItemId();
        GiftItemModel giftModel = getGiftModel();
        if (s.d(itemId, giftModel != null ? giftModel.getItemId() : null)) {
            if (getGiftCount() == 6) {
                setGiftCount(1);
            } else {
                setGiftCount(getGiftCount() + 1);
            }
        } else {
            setGiftCount(1);
        }
        setGiftModel(gift);
        n();
        o();
        g(getGiftCount());
        q();
        r();
        p();
    }

    @Nullable
    public View d(int i10) {
        Map<Integer, View> map = this.f15487k;
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

    public final void g(int i10) {
        Integer num = this.f15482f.get(Integer.valueOf(i10));
        ((ImageView) d(R$id.scale_img)).setImageResource(num != null ? num.intValue() : 0);
    }

    public final void h() {
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet animatorSet2 = new AnimatorSet();
        int i10 = R$id.car_gift_bg_img;
        animatorSet2.play(ObjectAnimator.ofFloat((ImageView) d(i10), (Property<ImageView, Float>) View.SCALE_X, 1.0f, 0.7f)).with(ObjectAnimator.ofFloat((ImageView) d(i10), (Property<ImageView, Float>) View.SCALE_Y, 1.0f, 0.7f));
        animatorSet2.setDuration(100L);
        animatorSet2.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.play(ObjectAnimator.ofFloat((ImageView) d(i10), (Property<ImageView, Float>) View.SCALE_X, 0.7f, 1.1f, 1.0f)).with(ObjectAnimator.ofFloat((ImageView) d(i10), (Property<ImageView, Float>) View.SCALE_Y, 0.7f, 1.1f, 1.0f));
        animatorSet3.setStartDelay(100L);
        animatorSet3.setDuration(400L);
        animatorSet3.setInterpolator(new LinearInterpolator());
        animatorSet.playTogether(animatorSet2, animatorSet3);
        this.f15485i = animatorSet;
    }

    public final void i() {
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet animatorSet2 = new AnimatorSet();
        int i10 = R$id.gift_icon;
        animatorSet2.play(ObjectAnimator.ofFloat((ImageView) d(i10), (Property<ImageView, Float>) View.SCALE_X, 1.0f, 0.7f, 1.1f)).with(ObjectAnimator.ofFloat((ImageView) d(i10), (Property<ImageView, Float>) View.SCALE_Y, 1.0f, 0.7f, 1.1f));
        animatorSet2.setDuration(200L);
        animatorSet2.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.play(ObjectAnimator.ofFloat((ImageView) d(i10), (Property<ImageView, Float>) View.SCALE_X, 1.1f, 1.0f)).with(ObjectAnimator.ofFloat((ImageView) d(i10), (Property<ImageView, Float>) View.SCALE_Y, 1.1f, 1.0f));
        animatorSet3.setStartDelay(200L);
        animatorSet3.setDuration(200L);
        animatorSet3.setInterpolator(new LinearInterpolator());
        animatorSet.playTogether(animatorSet2, animatorSet3);
        this.f15484h = animatorSet;
    }

    public final void j() {
        ValueAnimator ofInt = ValueAnimator.ofInt(5, 0);
        ofInt.setDuration(300L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CarGiftComboButton.k(CarGiftComboButton.this, valueAnimator);
            }
        });
        this.f15486j = ofInt;
    }

    public final void l() {
        z.a(this, R$layout.car_gift_combo_button, true);
        i();
        h();
        j();
        ((CircleProgressBarView) d(R$id.progress_view)).setOnProgressChangeListener(new a());
        y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.CarGiftComboButton$initView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                ValueAnimator valueAnimator;
                GiftItemModel giftModel;
                if (((FKSVGAImageView) CarGiftComboButton.this.d(R$id.cool_particle_animation)).k()) {
                    return;
                }
                valueAnimator = CarGiftComboButton.this.f15486j;
                boolean z10 = false;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    z10 = true;
                }
                if (z10 || (giftModel = CarGiftComboButton.this.getGiftModel()) == null) {
                    return;
                }
                CarGiftComboButton carGiftComboButton = CarGiftComboButton.this;
                carGiftComboButton.m();
                c mListener = carGiftComboButton.getMListener();
                if (mListener != null) {
                    mListener.b(giftModel, 1, null);
                }
            }
        });
    }

    public final void m() {
        AnimatorSet animatorSet = this.f15484h;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.f15485i;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.f15484h;
        if (animatorSet3 != null) {
            animatorSet3.start();
        }
        AnimatorSet animatorSet4 = this.f15485i;
        if (animatorSet4 != null) {
            animatorSet4.start();
        }
        int i10 = R$id.progress_view;
        ((CircleProgressBarView) d(i10)).g();
        ((CircleProgressBarView) d(i10)).setProgress(1.0f);
    }

    public final void n() {
        if (getGiftCount() >= 5) {
            FKSVGAImageView color_light_ring_animation = (FKSVGAImageView) d(R$id.color_light_ring_animation);
            s.h(color_light_ring_animation, "color_light_ring_animation");
            FKSVGAImageView.F(color_light_ring_animation, "car_color_light_ring.svga", null, null, 6, null);
            return;
        }
        ((FKSVGAImageView) d(R$id.color_light_ring_animation)).K();
    }

    public final void o() {
        if (getGiftCount() == 6) {
            FKSVGAImageView cool_particle_animation = (FKSVGAImageView) d(R$id.cool_particle_animation);
            s.h(cool_particle_animation, "cool_particle_animation");
            FKSVGAImageView.F(cool_particle_animation, "car_cool_particle.svga", null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.CarGiftComboButton$showCoolParticleAnimation$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ValueAnimator valueAnimator;
                    if (CarGiftComboButton.this.getGiftCount() == 6) {
                        ((FKSVGAImageView) CarGiftComboButton.this.d(R$id.color_light_ring_animation)).K();
                        valueAnimator = CarGiftComboButton.this.f15486j;
                        if (valueAnimator != null) {
                            valueAnimator.start();
                        }
                    }
                }
            }, 2, null);
            return;
        }
        ((FKSVGAImageView) d(R$id.cool_particle_animation)).K();
    }

    public final void p() {
        Integer num = this.f15483g.get(Integer.valueOf(getGiftCount()));
        int intValue = num != null ? num.intValue() : 0;
        FKSVGAImageView gift_count_animation = (FKSVGAImageView) d(R$id.gift_count_animation);
        s.h(gift_count_animation, "gift_count_animation");
        gift_count_animation.G("car_combo_count.svga", (r23 & 2) != 0 ? null : null, (r23 & 4) != 0 ? -1 : 0, (r23 & 8) != 0 ? false : false, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : h0.d(kotlin.f.a("Hits_01", Integer.valueOf(intValue))), (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? null : null, (r23 & 256) == 0 ? 0 : 0, (r23 & 512) != 0 ? null : null, (r23 & 1024) == 0 ? null : null);
    }

    public final void q() {
        int i10 = R$id.progress_view;
        ((CircleProgressBarView) d(i10)).g();
        ((CircleProgressBarView) d(i10)).setProgressColor(r.e(Integer.valueOf(com.cupidapp.live.base.utils.h.a(-1, 0.5f))));
        ((CircleProgressBarView) d(i10)).e(10000L);
    }

    public final void r() {
        String str = getGiftCount() < 6 ? "car_blue_spread_ring.svga" : "car_yellow_spread_ring.svga";
        FKSVGAImageView spread_ring_animation = (FKSVGAImageView) d(R$id.spread_ring_animation);
        s.h(spread_ring_animation, "spread_ring_animation");
        FKSVGAImageView.F(spread_ring_animation, str, null, null, 6, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CarGiftComboButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15487k = new LinkedHashMap();
        this.f15482f = i0.g(kotlin.f.a(1, Integer.valueOf(R$mipmap.car_scale_one)), kotlin.f.a(2, Integer.valueOf(R$mipmap.car_scale_two)), kotlin.f.a(3, Integer.valueOf(R$mipmap.car_scale_three)), kotlin.f.a(4, Integer.valueOf(R$mipmap.car_scale_four)), kotlin.f.a(5, Integer.valueOf(R$mipmap.car_scale_five)), kotlin.f.a(6, Integer.valueOf(R$mipmap.car_scale_six)));
        this.f15483g = i0.g(kotlin.f.a(1, Integer.valueOf(R$mipmap.car_combo_one)), kotlin.f.a(2, Integer.valueOf(R$mipmap.car_combo_two)), kotlin.f.a(3, Integer.valueOf(R$mipmap.car_combo_three)), kotlin.f.a(4, Integer.valueOf(R$mipmap.car_combo_four)), kotlin.f.a(5, Integer.valueOf(R$mipmap.car_combo_five)), kotlin.f.a(6, Integer.valueOf(R$mipmap.car_combo_six)));
        l();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CarGiftComboButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15487k = new LinkedHashMap();
        this.f15482f = i0.g(kotlin.f.a(1, Integer.valueOf(R$mipmap.car_scale_one)), kotlin.f.a(2, Integer.valueOf(R$mipmap.car_scale_two)), kotlin.f.a(3, Integer.valueOf(R$mipmap.car_scale_three)), kotlin.f.a(4, Integer.valueOf(R$mipmap.car_scale_four)), kotlin.f.a(5, Integer.valueOf(R$mipmap.car_scale_five)), kotlin.f.a(6, Integer.valueOf(R$mipmap.car_scale_six)));
        this.f15483g = i0.g(kotlin.f.a(1, Integer.valueOf(R$mipmap.car_combo_one)), kotlin.f.a(2, Integer.valueOf(R$mipmap.car_combo_two)), kotlin.f.a(3, Integer.valueOf(R$mipmap.car_combo_three)), kotlin.f.a(4, Integer.valueOf(R$mipmap.car_combo_four)), kotlin.f.a(5, Integer.valueOf(R$mipmap.car_combo_five)), kotlin.f.a(6, Integer.valueOf(R$mipmap.car_combo_six)));
        l();
    }
}
