package com.cupidapp.live.liveshow.view.giftplayer;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.liveshow.model.AnimationType;
import com.cupidapp.live.liveshow.model.LiveShowAnimationModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.x;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.z;

/* compiled from: FKLiveGiftAnimationLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveGiftAnimationLayout extends FrameLayout {

    /* renamed from: b */
    @NotNull
    public final List<LiveShowAnimationModel> f15612b;

    /* renamed from: c */
    public boolean f15613c;

    /* renamed from: d */
    public boolean f15614d;

    /* renamed from: e */
    @NotNull
    public Map<Integer, View> f15615e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveGiftAnimationLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15615e = new LinkedHashMap();
        this.f15612b = new ArrayList();
        f();
    }

    public static /* synthetic */ void h(FKLiveGiftAnimationLayout fKLiveGiftAnimationLayout, LiveShowAnimationModel liveShowAnimationModel, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 1;
        }
        fKLiveGiftAnimationLayout.g(liveShowAnimationModel, z10, i10);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15615e;
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

    public final void c() {
        this.f15612b.clear();
        ((FKLiveParticleGiftPlayerLayout) a(R$id.particleGiftPlayerLayout)).g();
        ((FKLiveApngGiftPlayerLayout) a(R$id.apngGiftPlayerLayout)).e();
        ((FKLiveWebpGiftPlayerLayout) a(R$id.webpGiftPlayerLayout)).o();
        ((FKLiveSVGAAnimationLayout) a(R$id.svgaGiftPlayerLayout)).J();
        ((FkLiveVideoGiftLayout) a(R$id.video_gift_layout)).g();
    }

    public final void d() {
        x.B(this.f15612b, new Function1<LiveShowAnimationModel, Boolean>() { // from class: com.cupidapp.live.liveshow.view.giftplayer.FKLiveGiftAnimationLayout$clearGiftList$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull LiveShowAnimationModel it) {
                s.i(it, "it");
                return Boolean.valueOf(it.getType() == AnimationType.Gift);
            }
        });
    }

    public final void e(@Nullable Activity activity) {
        if (activity == null) {
            return;
        }
        ((FKLiveParticleGiftPlayerLayout) a(R$id.particleGiftPlayerLayout)).d(activity);
    }

    public final void f() {
        z.a(this, R$layout.layout_live_gift_animation, true);
    }

    public final void g(@NotNull LiveShowAnimationModel model, boolean z10, int i10) {
        s.i(model, "model");
        if (this.f15613c) {
            return;
        }
        if (model.getType() == AnimationType.Gift && s.d(g.f52734a.Y0(), Boolean.FALSE)) {
            return;
        }
        if (z10) {
            this.f15612b.add(0, model);
        } else {
            for (int i11 = 0; i11 < i10; i11++) {
                this.f15612b.add(model);
            }
        }
        if (i()) {
            j(false);
        }
    }

    public final boolean i() {
        return (this.f15614d || ((FKLiveParticleGiftPlayerLayout) a(R$id.particleGiftPlayerLayout)).c() || ((FKLiveApngGiftPlayerLayout) a(R$id.apngGiftPlayerLayout)).b() || ((FKLiveWebpGiftPlayerLayout) a(R$id.webpGiftPlayerLayout)).l() || ((FKLiveSVGAAnimationLayout) a(R$id.svgaGiftPlayerLayout)).F() || ((FkLiveVideoGiftLayout) a(R$id.video_gift_layout)).c()) ? false : true;
    }

    public final void j(boolean z10) {
        if (z10) {
            this.f15614d = false;
        }
        LiveShowAnimationModel liveShowAnimationModel = (LiveShowAnimationModel) CollectionsKt___CollectionsKt.W(this.f15612b, 0);
        if (liveShowAnimationModel == null || !i()) {
            return;
        }
        this.f15614d = true;
        if (!this.f15612b.isEmpty()) {
            this.f15612b.remove(0);
        }
        String presetLargeImageKey = liveShowAnimationModel.getPresetLargeImageKey();
        if (presetLargeImageKey.length() == 0) {
            j(true);
            return;
        }
        int i10 = R$id.particleGiftPlayerLayout;
        if (((FKLiveParticleGiftPlayerLayout) a(i10)).f(presetLargeImageKey)) {
            ((FKLiveParticleGiftPlayerLayout) a(i10)).h(presetLargeImageKey, liveShowAnimationModel.getSoundKey(), new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftplayer.FKLiveGiftAnimationLayout$showLiveGiftAnimation$1
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
                    FKLiveGiftAnimationLayout.this.j(true);
                }
            });
            return;
        }
        int i11 = R$id.apngGiftPlayerLayout;
        if (((FKLiveApngGiftPlayerLayout) a(i11)).d(presetLargeImageKey)) {
            ((FKLiveApngGiftPlayerLayout) a(i11)).f(presetLargeImageKey, liveShowAnimationModel.getSoundKey(), new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftplayer.FKLiveGiftAnimationLayout$showLiveGiftAnimation$2
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
                    FKLiveGiftAnimationLayout.this.j(true);
                }
            });
            return;
        }
        int i12 = R$id.webpGiftPlayerLayout;
        if (((FKLiveWebpGiftPlayerLayout) a(i12)).n(presetLargeImageKey)) {
            ((FKLiveWebpGiftPlayerLayout) a(i12)).q(presetLargeImageKey, liveShowAnimationModel.getSoundKey(), new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftplayer.FKLiveGiftAnimationLayout$showLiveGiftAnimation$3
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
                    FKLiveGiftAnimationLayout.this.j(true);
                }
            });
            return;
        }
        int i13 = R$id.svgaGiftPlayerLayout;
        if (((FKLiveSVGAAnimationLayout) a(i13)).H(presetLargeImageKey)) {
            ((FKLiveSVGAAnimationLayout) a(i13)).K(presetLargeImageKey, liveShowAnimationModel.getSoundKey(), new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftplayer.FKLiveGiftAnimationLayout$showLiveGiftAnimation$4
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
                    FKLiveGiftAnimationLayout.this.j(true);
                }
            });
            return;
        }
        int i14 = R$id.video_gift_layout;
        if (((FkLiveVideoGiftLayout) a(i14)).d(presetLargeImageKey)) {
            ((FkLiveVideoGiftLayout) a(i14)).h(presetLargeImageKey, liveShowAnimationModel.getSoundKey(), new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftplayer.FKLiveGiftAnimationLayout$showLiveGiftAnimation$5
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
                    FKLiveGiftAnimationLayout.this.j(true);
                }
            });
        } else {
            j(true);
        }
    }

    public final void setResumeOrStopPlayGiftAnimation(boolean z10) {
        this.f15613c = z10;
        if (z10) {
            c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveGiftAnimationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15615e = new LinkedHashMap();
        this.f15612b = new ArrayList();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveGiftAnimationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15615e = new LinkedHashMap();
        this.f15612b = new ArrayList();
        f();
    }
}
