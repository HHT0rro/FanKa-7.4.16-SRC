package com.cupidapp.live.base.web.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.web.FKWebView;
import com.cupidapp.live.base.web.fragment.FKTransparentWebFragment;
import com.cupidapp.live.base.web.fragment.FKWebViewFragment;
import com.cupidapp.live.base.web.model.CloseTransparentWebEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKTransparentWebActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKTransparentWebActivity extends FKBaseActivity implements FKWebViewFragment.b {

    /* renamed from: w */
    @NotNull
    public static final a f13044w = new a(null);

    /* renamed from: q */
    @Nullable
    public String f13045q;

    /* renamed from: r */
    public boolean f13046r;

    /* renamed from: s */
    @Nullable
    public float[] f13047s;

    /* renamed from: t */
    @Nullable
    public FKTransparentWebFragment f13048t;

    /* renamed from: u */
    @Nullable
    public ScaleAnimation f13049u;

    /* renamed from: v */
    @NotNull
    public Map<Integer, View> f13050v = new LinkedHashMap();

    /* compiled from: FKTransparentWebActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, String str, boolean z10, float[] fArr, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            if ((i10 & 8) != 0) {
                fArr = null;
            }
            aVar.a(context, str, z10, fArr);
        }

        public final void a(@Nullable Context context, @Nullable String str, boolean z10, @Nullable float[] fArr) {
            if (context != null) {
                if (str == null || str.length() == 0) {
                    return;
                }
                Intent intent = new Intent(context, (Class<?>) FKTransparentWebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("TRANSPARENT_URL", str);
                bundle.putBoolean("CANCELABLE", z10);
                bundle.putFloatArray("PIVOT_LOCATION", fArr);
                intent.putExtra("TRANSPARENT_WEB_MESSAGE", bundle);
                context.startActivity(intent);
                FKBaseActivity.f11750o.b(context, 0, 0);
            }
        }
    }

    /* compiled from: FKTransparentWebActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            FKTransparentWebActivity.this.finish();
            EventBus.c().o(new CloseTransparentWebEvent());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
        }
    }

    /* compiled from: FKTransparentWebActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements FKTransparentWebFragment.b {
        public c() {
        }

        @Override // com.cupidapp.live.base.web.fragment.FKTransparentWebFragment.b
        public void a(boolean z10) {
            if (z10) {
                return;
            }
            FKTransparentWebActivity.this.finish();
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f13050v;
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

    public final void k1(boolean z10) {
        if (this.f13049u != null && z10) {
            int i10 = R$id.transparentWebLayout;
            if (((FrameLayout) j1(i10)).getAnimation() != null) {
                return;
            }
            ((FrameLayout) j1(i10)).startAnimation(this.f13049u);
            return;
        }
        finish();
    }

    public final void l1() {
        Bundle bundleExtra = getIntent().getBundleExtra("TRANSPARENT_WEB_MESSAGE");
        this.f13045q = bundleExtra != null ? bundleExtra.getString("TRANSPARENT_URL") : null;
        this.f13046r = bundleExtra != null ? bundleExtra.getBoolean("CANCELABLE") : false;
        this.f13047s = bundleExtra != null ? bundleExtra.getFloatArray("PIVOT_LOCATION") : null;
    }

    public final void m1() {
        float[] fArr = this.f13047s;
        if (fArr == null) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, fArr != null ? fArr[0] : 0.0f, fArr != null ? fArr[1] : 0.0f);
        scaleAnimation.setDuration(300L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new b());
        this.f13049u = scaleAnimation;
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_transparent_web);
        d1(0, 0);
        l1();
        this.f13048t = FKTransparentWebFragment.f13065l.a(this.f13045q, this, new c());
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        FKTransparentWebFragment fKTransparentWebFragment = this.f13048t;
        s.f(fKTransparentWebFragment);
        beginTransaction.replace(R$id.transparentWebLayout, fKTransparentWebFragment).commit();
        m1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ((FrameLayout) j1(R$id.transparentWebLayout)).clearAnimation();
        ScaleAnimation scaleAnimation = this.f13049u;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
        this.f13049u = null;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, @Nullable KeyEvent keyEvent) {
        if (i10 == 4) {
            if (getIntent().getBooleanExtra("CANCELABLE", false)) {
                return super.onKeyDown(i10, keyEvent);
            }
            P0().b();
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // com.cupidapp.live.base.web.fragment.FKWebViewFragment.b
    public void v(@Nullable j jVar) {
        if (jVar != null) {
            Lifecycle lifecycle = getLifecycle();
            s.h(lifecycle, "lifecycle");
            jVar.f(lifecycle, O0());
        }
    }

    @Override // com.cupidapp.live.base.web.fragment.FKWebViewFragment.b
    public void y(@NotNull FKWebView appWebView) {
        s.i(appWebView, "appWebView");
        Lifecycle lifecycle = getLifecycle();
        s.h(lifecycle, "lifecycle");
        appWebView.v(this, lifecycle, O0(), P0());
    }
}
