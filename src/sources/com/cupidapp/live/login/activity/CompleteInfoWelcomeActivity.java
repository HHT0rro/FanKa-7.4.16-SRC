package com.cupidapp.live.login.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Property;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.profile.model.User;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;

/* compiled from: CompleteInfoWelcomeActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CompleteInfoWelcomeActivity extends FKBaseActivity {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f16086s = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16088r = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final AnimatorSet f16087q = new AnimatorSet();

    /* compiled from: CompleteInfoWelcomeActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String avatarPath) {
            s.i(context, "context");
            s.i(avatarPath, "avatarPath");
            Intent intent = new Intent(context, (Class<?>) CompleteInfoWelcomeActivity.class);
            intent.putExtra("AVATAR_PATH", avatarPath);
            context.startActivity(intent);
            FKBaseActivity.f11750o.b(context, 0, R$anim.alpha_out_duration_180);
        }
    }

    /* compiled from: CompleteInfoWelcomeActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MainActivity.F.f(CompleteInfoWelcomeActivity.this, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) != 0 ? false : true, (r12 & 16) == 0 ? null : null, (r12 & 32) != 0 ? Boolean.FALSE : null);
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
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            s.i(animator, "animator");
            FKSVGAImageView welcome_imageview = (FKSVGAImageView) CompleteInfoWelcomeActivity.this.j1(R$id.welcome_imageview);
            s.h(welcome_imageview, "welcome_imageview");
            FKSVGAImageView.F(welcome_imageview, "welcome.svga", null, null, 6, null);
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
            AppApplication.f11612d.h().j().postDelayed(new b(), 2000L);
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

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f16088r;
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

    public final void k1() {
        ImageLoaderView user_avatar_imageview = (ImageLoaderView) j1(R$id.user_avatar_imageview);
        s.h(user_avatar_imageview, "user_avatar_imageview");
        ImageLoaderView.f(user_avatar_imageview, new com.cupidapp.live.base.imageloader.b(false, getIntent().getStringExtra("AVATAR_PATH"), null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
        int i10 = R$id.user_name_textview;
        ((TextView) j1(i10)).getPaint().setFakeBoldText(true);
        TextView textView = (TextView) j1(i10);
        User X = g.f52734a.X();
        textView.setText(X != null ? X.getName() : null);
    }

    public final void l1() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(330L);
        int i10 = R$id.user_avatar_imageview;
        animatorSet.play(ObjectAnimator.ofFloat((ImageLoaderView) j1(i10), (Property<ImageLoaderView, Float>) View.SCALE_X, 2.6f, 1.0f)).with(ObjectAnimator.ofFloat((ImageLoaderView) j1(i10), (Property<ImageLoaderView, Float>) View.SCALE_Y, 2.6f, 1.0f)).with(ObjectAnimator.ofFloat((ImageLoaderView) j1(i10), (Property<ImageLoaderView, Float>) View.TRANSLATION_Y, h.c(animatorSet, 160.0f), 0.0f));
        AnimatorSet animatorSet2 = new AnimatorSet();
        int i11 = R$id.user_name_textview;
        animatorSet2.play(ObjectAnimator.ofFloat((TextView) j1(i11), (Property<TextView, Float>) View.ALPHA, 0.0f, 1.0f)).with(ObjectAnimator.ofFloat((TextView) j1(i11), (Property<TextView, Float>) View.TRANSLATION_Y, h.c(animatorSet2, 60.0f), 0.0f));
        animatorSet2.setStartDelay(250L);
        animatorSet2.setDuration(250L);
        ObjectAnimator showEnterAnimation$lambda$3 = ObjectAnimator.ofFloat((ImageView) j1(R$id.avatar_bg_imageview), (Property<ImageView, Float>) View.ALPHA, 0.0f, 1.0f);
        showEnterAnimation$lambda$3.setStartDelay(720L);
        showEnterAnimation$lambda$3.setDuration(250L);
        s.h(showEnterAnimation$lambda$3, "showEnterAnimation$lambda$3");
        showEnterAnimation$lambda$3.addListener(new c());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((FrameLayout) j1(R$id.welcome_logo_layout), (Property<FrameLayout, Float>) View.ALPHA, 0.0f, 1.0f);
        ofFloat.setStartDelay(720L);
        ofFloat.setDuration(250L);
        AnimatorSet animatorSet3 = this.f16087q;
        animatorSet3.setInterpolator(new DecelerateInterpolator());
        animatorSet3.play(animatorSet).with(animatorSet2).with(showEnterAnimation$lambda$3).with(ofFloat);
        animatorSet3.addListener(new d());
        this.f16087q.start();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_complete_info_welcome);
        k1();
        l1();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, @Nullable KeyEvent keyEvent) {
        if (i10 == 4) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }
}
