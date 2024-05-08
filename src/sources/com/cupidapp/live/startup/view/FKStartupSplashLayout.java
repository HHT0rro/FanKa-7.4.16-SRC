package com.cupidapp.live.startup.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.model.FKClickArea;
import com.cupidapp.live.startup.splashad.FKBaseSplashAd;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.y;
import z0.z;

/* compiled from: FKStartupSplashLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStartupSplashLayout extends BaseLayout implements DefaultLifecycleObserver {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public b f18561d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18562e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKStartupSplashLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18562e = new LinkedHashMap();
        k();
    }

    public static final boolean j(FKStartupSplashLayout this$0, View view, MotionEvent event) {
        View view2;
        boolean z10;
        s.i(this$0, "this$0");
        view.performClick();
        if (event.getAction() != 0) {
            return false;
        }
        FrameLayout splash_container_layout = (FrameLayout) this$0.f(R$id.splash_container_layout);
        s.h(splash_container_layout, "splash_container_layout");
        Iterator<View> it = ViewGroupKt.getChildren(splash_container_layout).iterator();
        while (true) {
            if (!it.hasNext()) {
                view2 = null;
                break;
            }
            view2 = it.next();
            if (view2 instanceof AdSkipView) {
                break;
            }
        }
        View view3 = view2;
        if (view3 != null) {
            s.h(event, "event");
            z10 = this$0.l(event, view3);
        } else {
            z10 = false;
        }
        s.h(event, "event");
        FKSVGAImageView splash_jump_button = (FKSVGAImageView) this$0.f(R$id.splash_jump_button);
        s.h(splash_jump_button, "splash_jump_button");
        return (this$0.l(event, splash_jump_button) || z10) ? false : true;
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f18562e;
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

    public final void h(final FKAdType fKAdType) {
        TextView vip_remove_splash_view = (TextView) f(R$id.vip_remove_splash_view);
        s.h(vip_remove_splash_view, "vip_remove_splash_view");
        y.d(vip_remove_splash_view, new Function1<View, p>() { // from class: com.cupidapp.live.startup.view.FKStartupSplashLayout$bindClickEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                b bVar;
                ConstantsUrlModel urlModel;
                ConstantsResult q10 = g.f52734a.q();
                String urlVipMe = (q10 == null || (urlModel = q10.getUrlModel()) == null) ? null : urlModel.getUrlVipMe();
                if (urlVipMe == null || urlVipMe.length() == 0) {
                    return;
                }
                bVar = FKStartupSplashLayout.this.f18561d;
                if (bVar != null) {
                    bVar.v(fKAdType, urlVipMe);
                }
                SensorsLogKeyButtonClick.SplashVipClick.Vip.click();
                z3.d.f54832a.j("开机图按钮");
            }
        });
    }

    public final void i(boolean z10, int i10) {
        if (z10) {
            int i11 = R$id.splash_click_layout;
            ((FrameLayout) f(i11)).setVisibility(0);
            FKSVGAImageView splash_jump_button = (FKSVGAImageView) f(R$id.splash_jump_button);
            s.h(splash_jump_button, "splash_jump_button");
            FKSVGAImageView.F(splash_jump_button, "startup_jump_button.svga", null, null, 6, null);
            if (i10 == FKClickArea.JumpButton.getArea()) {
                ((FrameLayout) f(i11)).setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.startup.view.c
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        boolean j10;
                        j10 = FKStartupSplashLayout.j(FKStartupSplashLayout.this, view, motionEvent);
                        return j10;
                    }
                });
                return;
            }
            return;
        }
        ((FrameLayout) f(R$id.splash_click_layout)).setVisibility(4);
    }

    public final void k() {
        z.a(this, R$layout.layout_start_up_splash, true);
        setVisibility(4);
    }

    public final boolean l(MotionEvent motionEvent, View view) {
        return ((motionEvent.getX() > ((float) view.getLeft()) ? 1 : (motionEvent.getX() == ((float) view.getLeft()) ? 0 : -1)) >= 0 && (motionEvent.getX() > ((float) view.getRight()) ? 1 : (motionEvent.getX() == ((float) view.getRight()) ? 0 : -1)) <= 0) && ((motionEvent.getY() > ((float) view.getTop()) ? 1 : (motionEvent.getY() == ((float) view.getTop()) ? 0 : -1)) >= 0 && (motionEvent.getY() > ((float) view.getBottom()) ? 1 : (motionEvent.getY() == ((float) view.getBottom()) ? 0 : -1)) <= 0);
    }

    public final void m(@NotNull LifecycleOwner lifecycleOwner) {
        s.i(lifecycleOwner, "lifecycleOwner");
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    public final void o(@NotNull FKAdType type, @Nullable FKBaseSplashAd fKBaseSplashAd) {
        s.i(type, "type");
        if (fKBaseSplashAd == null) {
            String str = "type:" + ((Object) type) + " showAd fail，showThirdPartyAd baseSplashAd = null";
            b bVar = this.f18561d;
            if (bVar != null) {
                bVar.Q(type, -1, str);
                return;
            }
            return;
        }
        setVisibility(0);
        FrameLayout splash_container_layout = (FrameLayout) f(R$id.splash_container_layout);
        s.h(splash_container_layout, "splash_container_layout");
        fKBaseSplashAd.m(splash_container_layout);
        h(type);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.a(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        ((FKSVGAImageView) f(R$id.splash_jump_button)).K();
        setStartupListener(null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.c(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.d(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.e(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.f(this, lifecycleOwner);
    }

    public final void setAdType(@NotNull FKAdType type) {
        s.i(type, "type");
    }

    public final void setStartupListener(@Nullable b bVar) {
        this.f18561d = bVar;
    }

    public final void setVipRemoveAdVisible(boolean z10) {
        ((TextView) f(R$id.vip_remove_splash_view)).setVisibility(z10 ? 0 : 8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKStartupSplashLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18562e = new LinkedHashMap();
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKStartupSplashLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18562e = new LinkedHashMap();
        k();
    }
}
