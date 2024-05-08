package com.cupidapp.live.liveshow.view.giftplayer;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKLiveParticleGiftPlayerLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveParticleGiftPlayerLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public b f15616b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f15617c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f15618d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15619e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveParticleGiftPlayerLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15619e = new LinkedHashMap();
        this.f15617c = "HeartsRainLarge";
        this.f15618d = c.b(new Function0<List<String>>() { // from class: com.cupidapp.live.liveshow.view.giftplayer.FKLiveParticleGiftPlayerLayout$particleKeyList$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<String> invoke() {
                String str;
                str = FKLiveParticleGiftPlayerLayout.this.f15617c;
                return kotlin.collections.s.o(str);
            }
        });
        e();
    }

    private final List<String> getParticleKeyList() {
        return (List) this.f15618d.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15619e;
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

    public boolean c() {
        b bVar = this.f15616b;
        if (bVar != null) {
            if (bVar != null && bVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final void d(@NotNull Activity activity) {
        s.i(activity, "activity");
        View particleBottomView = a(R$id.particleBottomView);
        s.h(particleBottomView, "particleBottomView");
        this.f15616b = new b(activity, R$id.particleGiftLayout, particleBottomView, com.huawei.openalliance.ad.ipc.c.Code, 10000, 0, 32, null);
    }

    public final void e() {
        z.a(this, R$layout.layout_live_particle_gift_player, true);
    }

    public boolean f(@NotNull String animationKey) {
        s.i(animationKey, "animationKey");
        return getParticleKeyList().contains(animationKey);
    }

    public void g() {
        b bVar = this.f15616b;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void h(@NotNull String animationKey, @Nullable String str, @NotNull Function0<p> showNextGiftAnimation) {
        s.i(animationKey, "animationKey");
        s.i(showNextGiftAnimation, "showNextGiftAnimation");
        if (!s.d(animationKey, this.f15617c)) {
            showNextGiftAnimation.invoke();
            return;
        }
        b bVar = this.f15616b;
        if (bVar != null) {
            bVar.c(showNextGiftAnimation);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveParticleGiftPlayerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15619e = new LinkedHashMap();
        this.f15617c = "HeartsRainLarge";
        this.f15618d = c.b(new Function0<List<String>>() { // from class: com.cupidapp.live.liveshow.view.giftplayer.FKLiveParticleGiftPlayerLayout$particleKeyList$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<String> invoke() {
                String str;
                str = FKLiveParticleGiftPlayerLayout.this.f15617c;
                return kotlin.collections.s.o(str);
            }
        });
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveParticleGiftPlayerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15619e = new LinkedHashMap();
        this.f15617c = "HeartsRainLarge";
        this.f15618d = c.b(new Function0<List<String>>() { // from class: com.cupidapp.live.liveshow.view.giftplayer.FKLiveParticleGiftPlayerLayout$particleKeyList$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<String> invoke() {
                String str;
                str = FKLiveParticleGiftPlayerLayout.this.f15617c;
                return kotlin.collections.s.o(str);
            }
        });
        e();
    }
}
