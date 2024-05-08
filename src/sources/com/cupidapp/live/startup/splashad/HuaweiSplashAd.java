package com.cupidapp.live.startup.splashad;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.model.FKStartupMediaConfigModel;
import com.cupidapp.live.startup.model.SplashAdShowState;
import com.cupidapp.live.startup.view.b;
import com.huawei.appgallery.agd.agdpro.api.AdsContext;
import com.huawei.appgallery.agd.agdpro.api.ITemplateAd;
import com.huawei.appgallery.agd.agdpro.api.SplashInteractionListener;
import com.huawei.appgallery.agd.agdpro.api.TemplateLoadListener;
import com.huawei.appgallery.agd.core.api.AdSlot;
import com.huawei.appgallery.agd.core.api.AgdAdApi;
import com.huawei.appgallery.agd.core.api.AgdAdConfig;
import com.huawei.appgallery.agd.core.api.InitCallback;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: HuaweiSplashAd.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class HuaweiSplashAd extends FKBaseSplashAd {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final FKStartupMediaConfigModel f18491f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final String f18492g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final FKAdType f18493h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public List<ITemplateAd> f18494i;

    /* compiled from: HuaweiSplashAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements TemplateLoadListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2<Boolean, String, p> f18496b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function2<? super Boolean, ? super String, p> function2) {
            this.f18496b = function2;
        }

        @Override // com.huawei.appgallery.agd.agdpro.api.TemplateLoadListener
        public void onAdLoad(@Nullable List<ITemplateAd> list) {
            if ((list != null ? (ITemplateAd) CollectionsKt___CollectionsKt.V(list) : null) == null) {
                String str = ((Object) HuaweiSplashAd.this.g()) + "  onAdLoad  templateAd = null";
                com.cupidapp.live.startup.view.b f10 = HuaweiSplashAd.this.f();
                if (f10 != null) {
                    b.a.d(f10, HuaweiSplashAd.this.g(), -1, str, false, 8, null);
                }
                this.f18496b.mo1743invoke(Boolean.FALSE, str);
                return;
            }
            HuaweiSplashAd.this.f18494i = list;
            com.cupidapp.live.startup.view.b f11 = HuaweiSplashAd.this.f();
            if (f11 != null) {
                f11.p0(HuaweiSplashAd.this.g());
            }
            this.f18496b.mo1743invoke(Boolean.TRUE, null);
        }

        @Override // com.huawei.appgallery.agd.agdpro.api.ICardAd.LoadListener
        public void onError(int i10, @Nullable String str) {
            HuaweiSplashAd.this.h("onError  p0:" + i10 + "  p1:" + str);
            com.cupidapp.live.startup.view.b f10 = HuaweiSplashAd.this.f();
            if (f10 != null) {
                b.a.d(f10, HuaweiSplashAd.this.g(), Integer.valueOf(i10), "loadSplashAds onError " + str, false, 8, null);
            }
            this.f18496b.mo1743invoke(Boolean.FALSE, str);
        }
    }

    /* compiled from: HuaweiSplashAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements InitCallback {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f18498b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function2<Boolean, String, p> f18499c;

        /* JADX WARN: Multi-variable type inference failed */
        public b(FragmentActivity fragmentActivity, Function2<? super Boolean, ? super String, p> function2) {
            this.f18498b = fragmentActivity;
            this.f18499c = function2;
        }

        @Override // com.huawei.appgallery.agd.core.api.InitCallback
        public void onInitFail(int i10, @Nullable String str) {
            String str2 = ((Object) HuaweiSplashAd.this.g()) + " requestAd fail, 初始化SDK失败  p0:" + i10 + "  p1:" + str;
            com.cupidapp.live.startup.view.b f10 = HuaweiSplashAd.this.f();
            if (f10 != null) {
                b.a.d(f10, HuaweiSplashAd.this.g(), Integer.valueOf(i10), "初始化SDK失败 " + str, false, 8, null);
            }
            this.f18499c.mo1743invoke(Boolean.FALSE, str2);
        }

        @Override // com.huawei.appgallery.agd.core.api.InitCallback
        public void onInitSuccess() {
            HuaweiSplashAd huaweiSplashAd = HuaweiSplashAd.this;
            huaweiSplashAd.h(((Object) huaweiSplashAd.g()) + " onInitSuccess");
            HuaweiSplashAd.this.s(this.f18498b, this.f18499c);
        }
    }

    /* compiled from: HuaweiSplashAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements SplashInteractionListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f18501b;

        public c(ViewGroup viewGroup) {
            this.f18501b = viewGroup;
        }

        @Override // com.huawei.appgallery.agd.agdpro.api.InteractionListener
        public void onAdClicked(@Nullable View view) {
            com.cupidapp.live.startup.view.b f10 = HuaweiSplashAd.this.f();
            if (f10 != null) {
                b.a.b(f10, HuaweiSplashAd.this.g(), null, 2, null);
            }
            HuaweiSplashAd.this.r();
        }

        @Override // com.huawei.appgallery.agd.agdpro.api.InteractionListener
        public void onAdShow(@Nullable View view) {
            com.cupidapp.live.startup.view.b f10 = HuaweiSplashAd.this.f();
            if (f10 != null) {
                f10.P(HuaweiSplashAd.this.g());
            }
        }

        @Override // com.huawei.appgallery.agd.agdpro.api.SplashInteractionListener
        public void onAdSkip() {
            com.cupidapp.live.startup.view.b f10 = HuaweiSplashAd.this.f();
            if (f10 != null) {
                f10.J0(HuaweiSplashAd.this.g());
            }
            HuaweiSplashAd.this.r();
        }

        @Override // com.huawei.appgallery.agd.agdpro.api.SplashInteractionListener
        public void onAdTimeOver() {
            com.cupidapp.live.startup.view.b f10 = HuaweiSplashAd.this.f();
            if (f10 != null) {
                f10.c0(HuaweiSplashAd.this.g(), SplashAdShowState.COMPLETE_DISPLAY);
            }
            HuaweiSplashAd.this.r();
        }

        @Override // com.huawei.appgallery.agd.agdpro.api.InteractionListener
        public void onRenderFail(@Nullable View view, int i10, @Nullable String str) {
            HuaweiSplashAd.this.h("onRenderFail  p1:" + i10 + "  p2:" + str);
            com.cupidapp.live.startup.view.b f10 = HuaweiSplashAd.this.f();
            if (f10 != null) {
                f10.Q(HuaweiSplashAd.this.g(), Integer.valueOf(i10), str);
            }
            HuaweiSplashAd.this.r();
        }

        @Override // com.huawei.appgallery.agd.agdpro.api.InteractionListener
        public void onRenderSuccess(@Nullable View view, float f10, float f11) {
            HuaweiSplashAd.this.h("onRenderSuccess  p0:" + ((Object) view) + "  p1:" + f10 + "  p2:" + f11);
            this.f18501b.addView(view);
        }
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public int c() {
        return this.f18491f.getAdvertisementBaseInfo().getPrice();
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    @NotNull
    public FKAdType g() {
        return this.f18493h;
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public void j(@NotNull Function2<? super Boolean, ? super String, p> result) {
        s.i(result, "result");
        WeakReference<FragmentActivity> e2 = e();
        FragmentActivity fragmentActivity = e2 != null ? e2.get() : null;
        if (fragmentActivity == null) {
            String str = ((Object) g()) + " requestAd fail, activity = null";
            com.cupidapp.live.startup.view.b f10 = f();
            if (f10 != null) {
                b.a.d(f10, g(), -1, str, false, 8, null);
            }
            result.mo1743invoke(Boolean.FALSE, str);
            return;
        }
        AgdAdApi.init(AppApplication.f11612d.c(), new AgdAdConfig.Builder().debug(k1.a.f50625a.a()).build(), new b(fragmentActivity, result));
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public void m(@NotNull ViewGroup adContainer) {
        s.i(adContainer, "adContainer");
        List<ITemplateAd> list = this.f18494i;
        ITemplateAd iTemplateAd = list != null ? (ITemplateAd) CollectionsKt___CollectionsKt.V(list) : null;
        if (iTemplateAd == null) {
            String str = ((Object) g()) + " showAd fail, templateAd = null";
            com.cupidapp.live.startup.view.b f10 = f();
            if (f10 != null) {
                f10.Q(g(), -1, str);
                return;
            }
            return;
        }
        iTemplateAd.setInteractionListener(new c(adContainer));
        iTemplateAd.render();
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd, androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        r();
    }

    public final void r() {
        ITemplateAd iTemplateAd;
        List<ITemplateAd> list = this.f18494i;
        if (list == null || (iTemplateAd = (ITemplateAd) CollectionsKt___CollectionsKt.V(list)) == null) {
            return;
        }
        iTemplateAd.destroy();
        List<ITemplateAd> list2 = this.f18494i;
        if (list2 != null) {
            list2.remove(0);
        }
        this.f18494i = null;
    }

    public final void s(FragmentActivity fragmentActivity, Function2<? super Boolean, ? super String, p> function2) {
        int t2 = h.t(this, h.l(this));
        int t10 = h.t(this, h.k(this));
        if (t2 == 0 || t10 == 0) {
            t2 = h.t(this, 1080);
            t10 = h.t(this, 1920);
        }
        new AdsContext(fragmentActivity).loadSplashAds(new AdSlot.Builder().slotId(this.f18492g).darkMode(-1).acceptedSize(t2, t10).disableSdkCountDown(Boolean.FALSE).build(), new a(function2));
    }
}
