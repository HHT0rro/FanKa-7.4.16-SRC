package com.cupidapp.live.base.web.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Property;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.base.web.WebConfigViewModel;
import com.cupidapp.live.base.web.fragment.FKWebViewFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: FKCardWebActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKCardWebActivity extends FKBaseWebActivity {

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f13041u;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13042v = new LinkedHashMap();

    /* compiled from: FKCardWebActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            FKCardWebActivity.this.finish();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            s.i(animation, "animation");
            ((ConstraintLayout) FKCardWebActivity.this.o1(R$id.cardWebContainer)).setBackgroundColor(0);
        }
    }

    @Override // com.cupidapp.live.base.web.activity.FKBaseWebActivity
    public void l1() {
        onBackPressed();
    }

    @Nullable
    public View o1(int i10) {
        Map<Integer, View> map = this.f13042v;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (P0().b()) {
            return;
        }
        r1();
    }

    @Override // com.cupidapp.live.base.web.activity.FKBaseWebActivity, com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_card_web);
        float c4 = h.c(this, 10.0f);
        ((RoundedFrameLayout) o1(R$id.fragmentParentLayout)).setCornerRadius(c4, 0.0f, c4, 0.0f);
        q1();
        ((ConstraintLayout) o1(R$id.cardWebContainer)).setBackgroundColor(com.cupidapp.live.base.utils.h.a(-16777216, 0.5f));
        n1(FKWebViewFragment.f13075p.d(getIntent().getStringExtra("UrlKey"), this, new WebConfigViewModel(false, true, false, false, false, null, false, 125, null)));
        FKWebViewFragment m12 = m1();
        if (m12 != null) {
            m12.j1(new Function0<p>() { // from class: com.cupidapp.live.base.web.activity.FKCardWebActivity$onCreate$1
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
                    FKCardWebActivity.this.r1();
                }
            });
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        FKWebViewFragment m13 = m1();
        s.f(m13);
        beginTransaction.replace(R$id.fragmentContainerLayout, m13).commit();
        d1(0, 0);
    }

    @Override // com.cupidapp.live.base.web.activity.FKBaseWebActivity, com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ObjectAnimator objectAnimator = this.f13041u;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.f13041u = null;
    }

    public final void q1() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((RoundedFrameLayout) o1(R$id.fragmentParentLayout), (Property<RoundedFrameLayout, Float>) View.Y, h.k(this), h.m(this));
        this.f13041u = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(350L);
        }
        ObjectAnimator objectAnimator = this.f13041u;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    public final void r1() {
        ObjectAnimator objectAnimator = this.f13041u;
        if (objectAnimator != null) {
            objectAnimator.reverse();
        }
        ObjectAnimator objectAnimator2 = this.f13041u;
        if (objectAnimator2 != null) {
            objectAnimator2.addListener(new a());
        }
    }
}
