package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Layer;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.base.view.progress.CircleProgressBarView;
import com.cupidapp.live.liveshow.model.GiftItemModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t1.b;
import z0.y;
import z0.z;

/* compiled from: RocketGiftComboButton.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RocketGiftComboButton extends BaseContinuousSendButton {

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f15578f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f15579g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public AnimatorSet f15580h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15581i;

    /* compiled from: RocketGiftComboButton.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements t1.b {
        public a() {
        }

        @Override // t1.b
        public void a() {
            c mListener = RocketGiftComboButton.this.getMListener();
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
    public RocketGiftComboButton(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15581i = new LinkedHashMap();
        i();
    }

    @Override // com.cupidapp.live.liveshow.view.giftpicker.view.BaseContinuousSendButton
    public void a() {
        super.a();
        ((FKSVGAImageView) c(R$id.rotation_light_animation)).K();
        ((FKSVGAImageView) c(R$id.light_ring_animation)).K();
        ((CircleProgressBarView) c(R$id.progress_view)).g();
    }

    @Override // com.cupidapp.live.liveshow.view.giftpicker.view.BaseContinuousSendButton
    public void b(@NotNull GiftItemModel gift, int i10, @Nullable String str) {
        s.i(gift, "gift");
        String itemId = gift.getItemId();
        GiftItemModel giftModel = getGiftModel();
        if (s.d(itemId, giftModel != null ? giftModel.getItemId() : null)) {
            setGiftCount(getGiftCount() + 1);
        } else {
            setGiftCount(1);
        }
        setGiftModel(gift);
        k();
    }

    @Nullable
    public View c(int i10) {
        Map<Integer, View> map = this.f15581i;
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
        int i10;
        switch (getGiftCount()) {
            case 1:
                i10 = R$mipmap.rocket_scale_one;
                break;
            case 2:
                i10 = R$mipmap.rocket_scale_two;
                break;
            case 3:
                i10 = R$mipmap.rocket_scale_three;
                break;
            case 4:
                i10 = R$mipmap.rocket_scale_four;
                break;
            case 5:
                i10 = R$mipmap.rocket_scale_five;
                break;
            case 6:
                i10 = R$mipmap.rocket_scale_six;
                break;
            case 7:
                i10 = R$mipmap.rocket_scale_seven;
                break;
            case 8:
                i10 = R$mipmap.rocket_scale_eight;
                break;
            case 9:
                i10 = R$mipmap.rocket_scale_nine;
                break;
            default:
                i10 = R$mipmap.rocket_scale_ten;
                break;
        }
        ((ImageView) c(R$id.scale_img)).setImageResource(i10);
    }

    public final void f() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((ImageView) c(R$id.gift_icon), (Property<ImageView, Float>) View.TRANSLATION_Y, 0.0f, z0.h.c(this, 15.0f), -z0.h.c(this, 5.0f), 0.0f);
        ofFloat.setDuration(500L);
        this.f15578f = ofFloat;
    }

    public final void g() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Layer) c(R$id.combo_animation_layer), (Property<Layer, Float>) View.TRANSLATION_Y, 0.0f, -z0.h.c(this, 15.0f), z0.h.c(this, 5.0f), 0.0f);
        ofFloat.setDuration(500L);
        this.f15579g = ofFloat;
    }

    public final void h() {
        AnimatorSet animatorSet = new AnimatorSet();
        int i10 = R$id.combo_txt;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((TextView) c(i10), (Property<TextView, Float>) View.TRANSLATION_X, -z0.h.c(animatorSet, 10.0f), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat((TextView) c(i10), (Property<TextView, Float>) View.TRANSLATION_Y, z0.h.c(animatorSet, 10.0f), 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat((TextView) c(i10), (Property<TextView, Float>) View.ALPHA, 0.0f, 1.0f);
        ofFloat3.setRepeatMode(2);
        ofFloat3.setRepeatCount(1);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        this.f15580h = animatorSet;
    }

    public final void i() {
        z.a(this, R$layout.rocket_gift_combo_button, true);
        f();
        g();
        h();
        ((CircleProgressBarView) c(R$id.progress_view)).setOnProgressChangeListener(new a());
        Layer combo_animation_layer = (Layer) c(R$id.combo_animation_layer);
        s.h(combo_animation_layer, "combo_animation_layer");
        y.d(combo_animation_layer, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.RocketGiftComboButton$initView$2
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
                GiftItemModel giftModel = RocketGiftComboButton.this.getGiftModel();
                if (giftModel != null) {
                    RocketGiftComboButton rocketGiftComboButton = RocketGiftComboButton.this;
                    rocketGiftComboButton.j();
                    c mListener = rocketGiftComboButton.getMListener();
                    if (mListener != null) {
                        mListener.b(giftModel, 1, null);
                    }
                }
            }
        });
    }

    public final void j() {
        ObjectAnimator objectAnimator = this.f15578f;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f15579g;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        ObjectAnimator objectAnimator3 = this.f15578f;
        if (objectAnimator3 != null) {
            objectAnimator3.start();
        }
        ObjectAnimator objectAnimator4 = this.f15579g;
        if (objectAnimator4 != null) {
            objectAnimator4.start();
        }
        int i10 = R$id.progress_view;
        ((CircleProgressBarView) c(i10)).g();
        ((CircleProgressBarView) c(i10)).setProgress(1.0f);
    }

    public final void k() {
        int i10;
        String str;
        int giftCount = getGiftCount();
        int i11 = -1;
        String str2 = null;
        if (!(1 <= giftCount && giftCount < 4)) {
            if (4 <= giftCount && giftCount < 8) {
                i11 = -16715265;
                i10 = -11272961;
                str = "rocket_light_ring_blue.svga";
            } else {
                if (8 <= giftCount && giftCount <= Integer.MAX_VALUE) {
                    i11 = -7621;
                    i10 = -2190;
                    str2 = "rocket_rotation_light_yellow.svga";
                    str = "rocket_light_ring_yellow.svga";
                }
            }
            o(str2);
            n(str);
            e();
            m(i11);
            l(i10);
        }
        str = null;
        i10 = -1;
        o(str2);
        n(str);
        e();
        m(i11);
        l(i10);
    }

    public final void l(int i10) {
        int i11 = R$id.combo_txt;
        ((TextView) c(i11)).setTextColor(i10);
        ((TextView) c(i11)).setText(getContext().getString(R$string.double_hit, Integer.valueOf(getGiftCount())));
        AnimatorSet animatorSet = this.f15580h;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.f15580h;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
    }

    public final void m(int i10) {
        int i11 = R$id.progress_view;
        ((CircleProgressBarView) c(i11)).g();
        ((CircleProgressBarView) c(i11)).setProgressColor(r.e(Integer.valueOf(i10)));
        ((CircleProgressBarView) c(i11)).e(10000L);
    }

    public final void n(String str) {
        if (str == null || str.length() == 0) {
            ((FKSVGAImageView) c(R$id.light_ring_animation)).K();
            return;
        }
        FKSVGAImageView light_ring_animation = (FKSVGAImageView) c(R$id.light_ring_animation);
        s.h(light_ring_animation, "light_ring_animation");
        FKSVGAImageView.F(light_ring_animation, str, null, null, 6, null);
    }

    public final void o(String str) {
        if (str == null || str.length() == 0) {
            ((FKSVGAImageView) c(R$id.rotation_light_animation)).K();
            return;
        }
        FKSVGAImageView rotation_light_animation = (FKSVGAImageView) c(R$id.rotation_light_animation);
        s.h(rotation_light_animation, "rotation_light_animation");
        FKSVGAImageView.F(rotation_light_animation, str, null, null, 6, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RocketGiftComboButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15581i = new LinkedHashMap();
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RocketGiftComboButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15581i = new LinkedHashMap();
        i();
    }
}
