package com.kwad.components.ad.reward.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.reward.n.d;
import com.kwad.components.ad.reward.n.r;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends d implements View.OnClickListener {
    private final ViewGroup gS;
    private TextView hz;
    private TextView lw;
    private int[] qL;
    private View qM;
    private ImageView qN;
    private TextView qO;
    private Button qP;

    @Nullable
    private b qQ;

    /* renamed from: com.kwad.components.ad.reward.b.a$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class AnonymousClass1 extends ay {
        public final /* synthetic */ r qR;
        public final /* synthetic */ long qS;

        public AnonymousClass1(r rVar, long j10) {
            this.qR = rVar;
            this.qS = j10;
        }

        @Override // com.kwad.sdk.utils.ay
        public final void doTask() {
            a aVar = a.this;
            final Animator a10 = a.a(aVar, aVar.qM);
            a10.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.b.a.1.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a10.removeListener(this);
                    com.kwad.sdk.core.adlog.c.b(AnonymousClass1.this.qR.getAdTemplate(), 169, (JSONObject) null);
                    a aVar2 = a.this;
                    a.a(aVar2, aVar2.qN, AnonymousClass1.this.qS).start();
                    bn.a(new Runnable() { // from class: com.kwad.components.ad.reward.b.a.1.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.gG();
                        }
                    }, null, AnonymousClass1.this.qS);
                }
            });
            a10.start();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.b.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class C0428a {
        private CharSequence qY;
        private CharSequence qZ;

        /* renamed from: ra, reason: collision with root package name */
        private CharSequence f36539ra;
        private CharSequence title;

        private C0428a(@NonNull CouponInfo couponInfo) {
            this.title = couponInfo.displayTitle;
            this.qY = couponInfo.displayValue;
            if (TextUtils.isEmpty(couponInfo.displayBase)) {
                this.qZ = "";
            } else {
                this.qZ = String.format("满%s可用", couponInfo.displayBase);
            }
            this.f36539ra = couponInfo.displayActionWords;
        }

        @Nullable
        public static C0428a H(AdTemplate adTemplate) {
            List<CouponInfo> list;
            AdProductInfo cP = com.kwad.sdk.core.response.b.a.cP(e.dQ(adTemplate));
            if (cP == null || (list = cP.couponList) == null || list.size() <= 0) {
                return null;
            }
            return a(cP.couponList.get(0));
        }

        @Nullable
        private static C0428a a(CouponInfo couponInfo) {
            if (couponInfo == null) {
                return null;
            }
            return new C0428a(couponInfo);
        }

        public final CharSequence L(Context context) {
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(R.dimen.ksad_coupon_dialog_value_prefix_text_size));
            SpannableString spannableString = new SpannableString("¥" + ((Object) this.qY));
            spannableString.setSpan(absoluteSizeSpan, 0, 1, 17);
            return spannableString;
        }

        public final CharSequence gH() {
            return this.qZ;
        }

        public final CharSequence gI() {
            return this.f36539ra;
        }

        public final CharSequence getTitle() {
            return this.title;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface b {
        void gJ();

        void gK();
    }

    public a(Context context, @Nullable ViewGroup viewGroup, @Nullable int[] iArr) {
        this.qL = iArr;
        ViewGroup viewGroup2 = (ViewGroup) l.a(context, R.layout.ksad_reward_coupon_dialog, viewGroup, false);
        this.gS = viewGroup2;
        d(viewGroup2);
    }

    public static /* synthetic */ Animator a(a aVar, View view) {
        return m(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gG() {
        final Animator n10 = n(this.qM);
        n10.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                n10.removeListener(this);
                if (a.this.qQ != null) {
                    a.this.qQ.gK();
                }
            }
        });
        n10.start();
    }

    private static Animator m(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    private Animator n(View view) {
        ObjectAnimator objectAnimator;
        int[] E;
        Interpolator create = PathInterpolatorCompat.create(0.89f, 0.02f, 0.72f, 1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.0f);
        ofFloat.setInterpolator(create);
        ofFloat2.setInterpolator(create);
        int[] iArr = this.qL;
        ObjectAnimator objectAnimator2 = null;
        if (iArr == null || iArr.length < 2 || (E = com.kwad.sdk.d.a.a.E(view)) == null) {
            objectAnimator = null;
        } else {
            Interpolator create2 = PathInterpolatorCompat.create(0.33f, 0.0f, 0.83f, 1.0f);
            objectAnimator2 = ObjectAnimator.ofFloat(view, Key.TRANSLATION_X, this.qL[0] - E[0]);
            objectAnimator = ObjectAnimator.ofFloat(view, Key.TRANSLATION_Y, this.qL[1] - E[1]);
            objectAnimator2.setInterpolator(create2);
            objectAnimator.setInterpolator(create2);
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, Key.ALPHA, 1.0f, 1.0f);
        ofFloat3.setDuration(200L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, Key.ALPHA, 1.0f, 0.0f);
        ofFloat4.setDuration(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat3, ofFloat4);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        if (objectAnimator2 != null) {
            animatorSet2.playTogether(ofFloat, ofFloat2, animatorSet, objectAnimator2, objectAnimator);
        } else {
            animatorSet2.playTogether(ofFloat, ofFloat2, animatorSet);
        }
        return animatorSet2;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup gF() {
        return this.gS;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        b bVar;
        if (!view.equals(this.qP) || (bVar = this.qQ) == null) {
            return;
        }
        bVar.gJ();
    }

    public static /* synthetic */ Animator a(a aVar, ImageView imageView, long j10) {
        return a(imageView, j10);
    }

    private void d(ViewGroup viewGroup) {
        this.qM = viewGroup.findViewById(R.id.ksad_coupon_dialog_card);
        this.qN = (ImageView) viewGroup.findViewById(R.id.ksad_coupon_dialog_bg);
        this.hz = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_title);
        this.qO = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_content);
        this.lw = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_desc);
        Button button = (Button) viewGroup.findViewById(R.id.ksad_coupon_dialog_btn_action);
        this.qP = button;
        button.setOnClickListener(this);
    }

    public final void a(@Nullable b bVar) {
        this.qQ = bVar;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(C0428a.H(rVar.getAdTemplate()));
        this.gS.post(new AnonymousClass1(rVar, com.kwad.components.ad.reward.a.b.gy()));
    }

    private void a(C0428a c0428a) {
        if (c0428a == null) {
            return;
        }
        TextView textView = this.hz;
        if (textView != null) {
            textView.setText(c0428a.getTitle());
        }
        TextView textView2 = this.qO;
        if (textView2 != null) {
            textView2.setText(c0428a.L(this.gS.getContext()));
        }
        TextView textView3 = this.lw;
        if (textView3 != null) {
            textView3.setText(c0428a.gH());
        }
        Button button = this.qP;
        if (button != null) {
            button.setText(c0428a.gI());
        }
    }

    private static Animator a(ImageView imageView, long j10) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, Key.ALPHA, imageView.getAlpha(), 0.0f);
        ofFloat.setDuration(j10);
        return ofFloat;
    }
}
