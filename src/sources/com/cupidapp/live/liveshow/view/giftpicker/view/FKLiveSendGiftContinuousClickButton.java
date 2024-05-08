package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.liveshow.model.GiftItemModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKLiveSendGiftContinuousClickButton.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveSendGiftContinuousClickButton extends BaseContinuousSendButton {

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public AnimatorSet f15521f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public AnimatorSet f15522g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public AnimatorSet f15523h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public AnimatorSet f15524i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public ValueAnimator f15525j;

    /* renamed from: k, reason: collision with root package name */
    public final int f15526k;

    /* renamed from: l, reason: collision with root package name */
    public long f15527l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.utils.i f15528m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15529n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSendGiftContinuousClickButton(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15529n = new LinkedHashMap();
        this.f15526k = z0.h.c(this, 140.0f);
        n();
    }

    public static final boolean g(FKLiveSendGiftContinuousClickButton this$0, View view, MotionEvent motionEvent) {
        c mListener;
        s.i(this$0, "this$0");
        view.performClick();
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this$0.o();
        } else if (valueOf != null && valueOf.intValue() == 1) {
            this$0.p();
            ValueAnimator valueAnimator = this$0.f15525j;
            boolean z10 = false;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                z10 = true;
            }
            if (z10) {
                return true;
            }
            if (this$0.f15527l != 0 && System.currentTimeMillis() - this$0.f15527l <= 300) {
                this$0.f15527l = 0L;
            } else {
                this$0.f15527l = System.currentTimeMillis();
                GiftItemModel giftModel = this$0.getGiftModel();
                if (giftModel != null && (mListener = this$0.getMListener()) != null) {
                    mListener.b(giftModel, 1, null);
                }
            }
        }
        return true;
    }

    public static final void k(FKLiveSendGiftContinuousClickButton this$0, ValueAnimator it) {
        s.i(this$0, "this$0");
        s.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        s.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        View continuous_progress_view = this$0.e(R$id.continuous_progress_view);
        s.h(continuous_progress_view, "continuous_progress_view");
        y.o(continuous_progress_view, Integer.valueOf(intValue), null, 2, null);
    }

    @Override // com.cupidapp.live.liveshow.view.giftpicker.view.BaseContinuousSendButton
    public void a() {
        super.a();
        AnimatorSet animatorSet = this.f15523h;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        ValueAnimator valueAnimator = this.f15525j;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        com.cupidapp.live.base.utils.i iVar = this.f15528m;
        if (iVar != null) {
            iVar.g();
        }
        this.f15528m = null;
    }

    @Override // com.cupidapp.live.liveshow.view.giftpicker.view.BaseContinuousSendButton
    public void b(@NotNull GiftItemModel gift, int i10, @Nullable String str) {
        ValueAnimator valueAnimator;
        s.i(gift, "gift");
        String itemId = gift.getItemId();
        GiftItemModel giftModel = getGiftModel();
        if (s.d(itemId, giftModel != null ? giftModel.getItemId() : null)) {
            setGiftCount(getGiftCount() + 1);
        } else {
            setGiftCount(1);
        }
        setGiftModel(gift);
        if (gift.getRushIcon() != null) {
            ((Group) e(R$id.effects_group)).setVisibility(0);
            ImageLoaderView effects_imageview = (ImageLoaderView) e(R$id.effects_imageview);
            s.h(effects_imageview, "effects_imageview");
            ImageLoaderView.g(effects_imageview, gift.getRushIcon(), null, null, 6, null);
        } else {
            ((Group) e(R$id.effects_group)).setVisibility(8);
        }
        Integer rushAnimationTriggerThreshold = gift.getRushAnimationTriggerThreshold();
        int intValue = rushAnimationTriggerThreshold != null ? rushAnimationTriggerThreshold.intValue() : 0;
        if (intValue == 0) {
            ((TextView) e(R$id.trigger_effects_count_textview)).setVisibility(8);
            View continuous_progress_view = e(R$id.continuous_progress_view);
            s.h(continuous_progress_view, "continuous_progress_view");
            y.o(continuous_progress_view, Integer.valueOf(this.f15526k), null, 2, null);
        } else {
            int i11 = R$id.trigger_effects_count_textview;
            ((TextView) e(i11)).setVisibility(0);
            ((TextView) e(i11)).setText(getContext().getString(R$string.trigger_effects, Integer.valueOf(intValue)));
            if (getGiftCount() == intValue + 1) {
                setGiftCount(1);
            }
            float giftCount = getGiftCount() / intValue;
            View continuous_progress_view2 = e(R$id.continuous_progress_view);
            s.h(continuous_progress_view2, "continuous_progress_view");
            y.o(continuous_progress_view2, Integer.valueOf((int) (this.f15526k * giftCount)), null, 2, null);
            if ((giftCount == 1.0f) && (valueAnimator = this.f15525j) != null) {
                valueAnimator.start();
            }
        }
        ((TextView) e(R$id.send_count_textview)).setText(getContext().getString(R$string.gift_count, Integer.valueOf(getGiftCount())));
        AnimatorSet animatorSet = this.f15524i;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.f15524i;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
        ((TextView) e(R$id.count_down_textview)).setText(getContext().getString(R$string.continuous_send_count_down, 30));
        com.cupidapp.live.base.utils.i iVar = this.f15528m;
        if (iVar != null) {
            iVar.g();
        }
        com.cupidapp.live.base.utils.i iVar2 = new com.cupidapp.live.base.utils.i();
        iVar2.e(5000L, 100L, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKLiveSendGiftContinuousClickButton$showContinuousBtn$1$1
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
                c mListener = FKLiveSendGiftContinuousClickButton.this.getMListener();
                if (mListener != null) {
                    mListener.a();
                }
            }
        }, new Function1<Long, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKLiveSendGiftContinuousClickButton$showContinuousBtn$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Long l10) {
                invoke(l10.longValue());
                return p.f51048a;
            }

            public final void invoke(long j10) {
                ((TextView) FKLiveSendGiftContinuousClickButton.this.e(R$id.count_down_textview)).setText(FKLiveSendGiftContinuousClickButton.this.getContext().getString(R$string.continuous_send_count_down, Long.valueOf(j10 / 100)));
            }
        });
        this.f15528m = iVar2;
        AnimatorSet animatorSet3 = this.f15523h;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        AnimatorSet animatorSet4 = this.f15523h;
        if (animatorSet4 != null) {
            animatorSet4.start();
        }
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f15529n;
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

    public final void f() {
        e(R$id.bottom_bg_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.j
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean g3;
                g3 = FKLiveSendGiftContinuousClickButton.g(FKLiveSendGiftContinuousClickButton.this, view, motionEvent);
                return g3;
            }
        });
    }

    public final void h() {
        AnimatorSet animatorSet = new AnimatorSet();
        int i10 = R$id.continuous_btn_layout;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((ConstraintLayout) e(i10), (Property<ConstraintLayout, Float>) View.SCALE_X, 1.0f, 0.9f);
        animatorSet.play(ofFloat).with(ObjectAnimator.ofFloat((ConstraintLayout) e(i10), (Property<ConstraintLayout, Float>) View.SCALE_Y, 1.0f, 0.9f));
        animatorSet.setDuration(80L);
        this.f15521f = animatorSet;
    }

    public final void i() {
        AnimatorSet animatorSet = new AnimatorSet();
        int i10 = R$id.send_count_textview;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((TextView) e(i10), (Property<TextView, Float>) View.TRANSLATION_Y, z0.h.c(animatorSet, 28.0f), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat((TextView) e(i10), (Property<TextView, Float>) View.ALPHA, 0.0f, 1.0f);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(1);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(400L);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        this.f15524i = animatorSet;
    }

    public final void j() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f15526k, 0);
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FKLiveSendGiftContinuousClickButton.k(FKLiveSendGiftContinuousClickButton.this, valueAnimator);
            }
        });
        this.f15525j = ofInt;
    }

    public final void l() {
        AnimatorSet animatorSet = new AnimatorSet();
        int i10 = R$id.continuous_btn_layout;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((ConstraintLayout) e(i10), (Property<ConstraintLayout, Float>) View.SCALE_X, 1.0f, 0.98f);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat((ConstraintLayout) e(i10), (Property<ConstraintLayout, Float>) View.SCALE_Y, 1.0f, 0.98f);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(400L);
        this.f15523h = animatorSet;
    }

    public final void m() {
        AnimatorSet animatorSet = new AnimatorSet();
        int i10 = R$id.continuous_btn_layout;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((ConstraintLayout) e(i10), (Property<ConstraintLayout, Float>) View.SCALE_X, 0.9f, 1.0f);
        animatorSet.play(ofFloat).with(ObjectAnimator.ofFloat((ConstraintLayout) e(i10), (Property<ConstraintLayout, Float>) View.SCALE_Y, 0.9f, 1.0f));
        animatorSet.setDuration(80L);
        this.f15522g = animatorSet;
    }

    public final void n() {
        z.a(this, R$layout.layout_send_gift_continuous_click_button, true);
        ((TextView) e(R$id.count_down_textview)).getPaint().setFakeBoldText(true);
        h();
        m();
        l();
        i();
        j();
        f();
    }

    public final void o() {
        AnimatorSet animatorSet = this.f15522g;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.f15521f;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.f15521f;
        if (animatorSet3 != null) {
            animatorSet3.start();
        }
    }

    public final void p() {
        AnimatorSet animatorSet = this.f15521f;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.f15522g;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.f15522g;
        if (animatorSet3 != null) {
            animatorSet3.start();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSendGiftContinuousClickButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15529n = new LinkedHashMap();
        this.f15526k = z0.h.c(this, 140.0f);
        n();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSendGiftContinuousClickButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15529n = new LinkedHashMap();
        this.f15526k = z0.h.c(this, 140.0f);
        n();
    }
}
