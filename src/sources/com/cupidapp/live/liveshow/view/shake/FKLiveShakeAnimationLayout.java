package com.cupidapp.live.liveshow.view.shake;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.download.LaunchDownloader;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.video.ExoMediaPlayer;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.animation.FKWebpAnimationView;
import com.cupidapp.live.liveshow.model.CommentModel;
import com.cupidapp.live.liveshow.model.LiveShowAnimationModel;
import com.cupidapp.live.liveshow.model.LiveShowShakeMessageModel;
import com.cupidapp.live.liveshow.model.LiveShowShakeResult;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKLiveShakeAnimationLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveShakeAnimationLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final List<LiveShowShakeMessageModel> f15889d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public LiveShowShakeMessageModel f15890e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15891f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15892g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f15893h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f15894i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f15895j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15896k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveShakeAnimationLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15896k = new LinkedHashMap();
        this.f15889d = new ArrayList();
        this.f15894i = c.b(new Function0<a>() { // from class: com.cupidapp.live.liveshow.view.shake.FKLiveShakeAnimationLayout$shakeListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                Context context2 = FKLiveShakeAnimationLayout.this.getContext();
                s.h(context2, "context");
                final FKLiveShakeAnimationLayout fKLiveShakeAnimationLayout = FKLiveShakeAnimationLayout.this;
                return new a(context2, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.shake.FKLiveShakeAnimationLayout$shakeListener$2.1
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
                        FKLiveShakeAnimationLayout.this.q();
                    }
                });
            }
        });
        r();
    }

    private final a getShakeListener() {
        return (a) this.f15894i.getValue();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f15896k;
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

    public final void k(@NotNull LiveShowShakeMessageModel shakeMessage) {
        s.i(shakeMessage, "shakeMessage");
        if (AppApplication.f11612d.g()) {
            this.f15889d.add(shakeMessage);
            w();
        }
    }

    public final void l(String str) {
        getShakeListener().b();
        if (this.f15895j) {
            ExoMediaPlayer.f12408a.z();
            this.f15895j = false;
        }
        if (u(str) || t(str)) {
            m();
        }
    }

    public final void m() {
        this.f15892g = false;
        this.f15893h = false;
        p();
        w();
    }

    public final void o() {
        this.f15889d.clear();
        this.f15890e = null;
        this.f15892g = false;
        this.f15893h = false;
        getShakeListener().b();
        if (this.f15895j) {
            ExoMediaPlayer.f12408a.z();
            this.f15895j = false;
        }
        p();
    }

    public final void p() {
        ((FKWebpAnimationView) e(R$id.shakeAnimationImageView)).i();
    }

    public final void q() {
        String itemId;
        LiveShowShakeMessageModel liveShowShakeMessageModel = this.f15890e;
        if (liveShowShakeMessageModel == null || (itemId = liveShowShakeMessageModel.getItemId()) == null) {
            return;
        }
        this.f15893h = true;
        getShakeListener().b();
        Disposable disposed = NetworkClient.f11868a.r().z(itemId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<LiveShowShakeResult, p>() { // from class: com.cupidapp.live.liveshow.view.shake.FKLiveShakeAnimationLayout$handleUserShake$lambda$3$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveShowShakeResult liveShowShakeResult) {
                m2658invoke(liveShowShakeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2658invoke(LiveShowShakeResult liveShowShakeResult) {
                LiveShowShakeResult liveShowShakeResult2 = liveShowShakeResult;
                CommentModel comment = liveShowShakeResult2.getComment();
                if (comment != null) {
                    EventBus.c().l(new InsertShakeCommentEvent(comment));
                }
                if (liveShowShakeResult2.getAnimation() != null) {
                    FKLiveShakeAnimationLayout.this.s(liveShowShakeResult2.getAnimation());
                } else {
                    FKLiveShakeAnimationLayout.this.m();
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.view.shake.FKLiveShakeAnimationLayout$handleUserShake$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                FKLiveShakeAnimationLayout.this.m();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void r() {
        z.a(this, R$layout.layout_shake_animation, true);
    }

    public final void s(final LiveShowAnimationModel liveShowAnimationModel) {
        if (liveShowAnimationModel == null) {
            return;
        }
        this.f15892g = true;
        p();
        ((FKWebpAnimationView) e(R$id.shakeAnimationImageView)).g(liveShowAnimationModel.getPresetLargeImageKey(), 1, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.shake.FKLiveShakeAnimationLayout$playAnimation$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                FKLiveShakeAnimationLayout.this.v(liveShowAnimationModel.getSoundKey());
            }
        }, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.shake.FKLiveShakeAnimationLayout$playAnimation$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                FKLiveShakeAnimationLayout.this.l(liveShowAnimationModel.getPresetLargeImageKey());
            }
        });
    }

    public final void setShakeable(boolean z10) {
        this.f15891f = z10;
    }

    public final boolean t(String str) {
        LiveShowAnimationModel animation;
        if (!this.f15893h) {
            LiveShowShakeMessageModel liveShowShakeMessageModel = this.f15890e;
            if (s.d(str, (liveShowShakeMessageModel == null || (animation = liveShowShakeMessageModel.getAnimation()) == null) ? null : animation.getPresetLargeImageKey())) {
                return true;
            }
        }
        return false;
    }

    public final boolean u(String str) {
        LiveShowAnimationModel animation;
        if (this.f15893h) {
            LiveShowShakeMessageModel liveShowShakeMessageModel = this.f15890e;
            if (!s.d(str, (liveShowShakeMessageModel == null || (animation = liveShowShakeMessageModel.getAnimation()) == null) ? null : animation.getPresetLargeImageKey())) {
                return true;
            }
        }
        return false;
    }

    public final void v(String str) {
        String u10;
        if (str == null || (u10 = LaunchDownloader.f11925a.u(str)) == null) {
            return;
        }
        this.f15895j = true;
        ExoMediaPlayer.t(ExoMediaPlayer.f12408a, u10, false, ExoMediaPlayer.PlayMode.SINGLE, false, 10, null);
    }

    public final void w() {
        if (this.f15892g) {
            return;
        }
        LiveShowShakeMessageModel liveShowShakeMessageModel = (LiveShowShakeMessageModel) CollectionsKt___CollectionsKt.V(this.f15889d);
        if (liveShowShakeMessageModel != null) {
            s(liveShowShakeMessageModel.getAnimation());
            this.f15889d.remove(liveShowShakeMessageModel);
            if (this.f15891f) {
                getShakeListener().a();
            }
        } else {
            liveShowShakeMessageModel = null;
        }
        this.f15890e = liveShowShakeMessageModel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveShakeAnimationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15896k = new LinkedHashMap();
        this.f15889d = new ArrayList();
        this.f15894i = c.b(new Function0<a>() { // from class: com.cupidapp.live.liveshow.view.shake.FKLiveShakeAnimationLayout$shakeListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                Context context2 = FKLiveShakeAnimationLayout.this.getContext();
                s.h(context2, "context");
                final FKLiveShakeAnimationLayout fKLiveShakeAnimationLayout = FKLiveShakeAnimationLayout.this;
                return new a(context2, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.shake.FKLiveShakeAnimationLayout$shakeListener$2.1
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
                        FKLiveShakeAnimationLayout.this.q();
                    }
                });
            }
        });
        r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveShakeAnimationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15896k = new LinkedHashMap();
        this.f15889d = new ArrayList();
        this.f15894i = c.b(new Function0<a>() { // from class: com.cupidapp.live.liveshow.view.shake.FKLiveShakeAnimationLayout$shakeListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                Context context2 = FKLiveShakeAnimationLayout.this.getContext();
                s.h(context2, "context");
                final FKLiveShakeAnimationLayout fKLiveShakeAnimationLayout = FKLiveShakeAnimationLayout.this;
                return new a(context2, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.shake.FKLiveShakeAnimationLayout$shakeListener$2.1
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
                        FKLiveShakeAnimationLayout.this.q();
                    }
                });
            }
        });
        r();
    }
}
