package com.cupidapp.live.club.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Layer;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.club.model.ClubRedEnvelopeModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: OpenRedEnvelopeLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OpenRedEnvelopeLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public boolean f13655b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public AnimatorSet f13656c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public AnimatorSet f13657d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Function0<p> f13658e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13659f;

    /* compiled from: Animator.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
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
            ImageView open_red_envelope_imageview = (ImageView) OpenRedEnvelopeLayout.this.a(R$id.open_red_envelope_imageview);
            s.h(open_red_envelope_imageview, "open_red_envelope_imageview");
            open_red_envelope_imageview.setVisibility(8);
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
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
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
            OpenRedEnvelopeLayout.this.f13655b = false;
            OpenRedEnvelopeLayout.this.setVisibility(8);
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
    public OpenRedEnvelopeLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13659f = new LinkedHashMap();
        f();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13659f;
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

    public final void e(@NotNull ClubRedEnvelopeModel redEnvelope, @NotNull Function0<p> openCallback) {
        s.i(redEnvelope, "redEnvelope");
        s.i(openCallback, "openCallback");
        setVisibility(0);
        this.f13658e = openCallback;
        ImageLoaderView giver_avatar_imageview = (ImageLoaderView) a(R$id.giver_avatar_imageview);
        s.h(giver_avatar_imageview, "giver_avatar_imageview");
        ImageLoaderView.g(giver_avatar_imageview, redEnvelope.getSenderAvatar(), null, null, 6, null);
        ((TextView) a(R$id.giver_name_textview)).setText(redEnvelope.getSenderName());
        ImageLoaderView envelop_imageview = (ImageLoaderView) a(R$id.envelop_imageview);
        s.h(envelop_imageview, "envelop_imageview");
        ImageLoaderView.g(envelop_imageview, redEnvelope.getGiftIcon(), null, null, 6, null);
        ((TextView) a(R$id.envelope_name_textview)).setText(redEnvelope.getGiftName());
    }

    public final void f() {
        z.a(this, R$layout.layout_open_red_envelope, true);
        setVisibility(8);
        TextView giver_name_textview = (TextView) a(R$id.giver_name_textview);
        s.h(giver_name_textview, "giver_name_textview");
        u.a(giver_name_textview);
        TextView envelope_name_textview = (TextView) a(R$id.envelope_name_textview);
        s.h(envelope_name_textview, "envelope_name_textview");
        u.a(envelope_name_textview);
        int i10 = R$id.open_red_envelope_imageview;
        ImageView open_red_envelope_imageview = (ImageView) a(i10);
        s.h(open_red_envelope_imageview, "open_red_envelope_imageview");
        y.d(open_red_envelope_imageview, new Function1<View, p>() { // from class: com.cupidapp.live.club.view.OpenRedEnvelopeLayout$initView$1
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
                boolean z10;
                Function0 function0;
                z10 = OpenRedEnvelopeLayout.this.f13655b;
                if (z10) {
                    return;
                }
                OpenRedEnvelopeLayout.this.f13655b = true;
                function0 = OpenRedEnvelopeLayout.this.f13658e;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat((ImageView) a(i10), (Property<ImageView, Float>) View.SCALE_X, 1.0f, 0.8f, 1.1f)).with(ObjectAnimator.ofFloat((ImageView) a(i10), (Property<ImageView, Float>) View.SCALE_Y, 1.0f, 0.8f, 1.1f));
        animatorSet.setDuration(240L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(ObjectAnimator.ofFloat((ImageView) a(i10), (Property<ImageView, Float>) View.SCALE_X, 1.1f, 0.0f)).with(ObjectAnimator.ofFloat((ImageView) a(i10), (Property<ImageView, Float>) View.SCALE_Y, 1.1f, 0.0f));
        animatorSet2.setStartDelay(240L);
        animatorSet2.setDuration(80L);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.play(animatorSet).with(animatorSet2);
        animatorSet3.addListener(new a());
        this.f13656c = animatorSet3;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Layer) a(R$id.red_envelope_layer), (Property<Layer, Float>) View.TRANSLATION_Y, 0.0f, -z0.h.c(this, 314.0f));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat((ImageView) a(R$id.bottom_imageview), (Property<ImageView, Float>) View.TRANSLATION_Y, 0.0f, z0.h.c(this, 230.0f));
        AnimatorSet animatorSet4 = new AnimatorSet();
        animatorSet4.play(ofFloat).with(ofFloat2);
        animatorSet4.setStartDelay(240L);
        animatorSet4.setDuration(280L);
        animatorSet4.addListener(new b());
        this.f13657d = animatorSet4;
    }

    public final void g() {
        AnimatorSet animatorSet = this.f13656c;
        if (animatorSet != null) {
            animatorSet.start();
        }
        AnimatorSet animatorSet2 = this.f13657d;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f13655b = false;
        AnimatorSet animatorSet = this.f13656c;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
        }
        AnimatorSet animatorSet2 = this.f13657d;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
        }
        AnimatorSet animatorSet3 = this.f13656c;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        AnimatorSet animatorSet4 = this.f13657d;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenRedEnvelopeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13659f = new LinkedHashMap();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenRedEnvelopeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13659f = new LinkedHashMap();
        f();
    }
}
