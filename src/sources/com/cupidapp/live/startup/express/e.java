package com.cupidapp.live.startup.express;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.startup.express.b;
import com.cupidapp.live.startup.model.FKAdType;
import com.huawei.appgallery.agd.agdpro.api.AdsContext;
import com.huawei.appgallery.agd.agdpro.api.DislikeClickListener;
import com.huawei.appgallery.agd.agdpro.api.ITemplateAd;
import com.huawei.appgallery.agd.agdpro.api.InteractionListener;
import com.huawei.appgallery.agd.agdpro.api.TemplateLoadListener;
import com.huawei.appgallery.agd.core.api.AdSlot;
import com.huawei.appgallery.agd.core.api.AgdAdApi;
import com.huawei.appgallery.agd.core.api.AgdAdConfig;
import com.huawei.appgallery.agd.core.api.InitCallback;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: HuaweiExpressAd.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e extends FKBaseExpressAd {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final WeakReference<FragmentActivity> f18356b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18357c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final String f18358d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final com.cupidapp.live.startup.express.b f18359e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final FKAdType f18360f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public List<ITemplateAd> f18361g;

    /* renamed from: h, reason: collision with root package name */
    public final float f18362h;

    /* renamed from: i, reason: collision with root package name */
    public final float f18363i;

    /* compiled from: HuaweiExpressAd.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements InitCallback {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f18365b;

        public a(FragmentActivity fragmentActivity) {
            this.f18365b = fragmentActivity;
        }

        @Override // com.huawei.appgallery.agd.core.api.InitCallback
        public void onInitFail(int i10, @Nullable String str) {
            e.this.f18359e.e(e.this.n(), e.this.f18357c, Integer.valueOf(i10), "初始化SDK失败 " + str);
        }

        @Override // com.huawei.appgallery.agd.core.api.InitCallback
        public void onInitSuccess() {
            e.this.o(this.f18365b);
        }
    }

    /* compiled from: HuaweiExpressAd.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements TemplateLoadListener {
        public b() {
        }

        @Override // com.huawei.appgallery.agd.agdpro.api.TemplateLoadListener
        public void onAdLoad(@Nullable List<ITemplateAd> list) {
            if ((list != null ? (ITemplateAd) CollectionsKt___CollectionsKt.V(list) : null) == null) {
                e.this.f18359e.e(e.this.n(), e.this.f18357c, -1, ((Object) e.this.n()) + "  onAdLoad  templateAd = null");
                return;
            }
            e.this.f18361g = list;
            e.this.p();
        }

        @Override // com.huawei.appgallery.agd.agdpro.api.ICardAd.LoadListener
        public void onError(int i10, @Nullable String str) {
            e.this.f18359e.e(e.this.n(), e.this.f18357c, Integer.valueOf(i10), "loadFeedAds onError " + str);
        }
    }

    /* compiled from: HuaweiExpressAd.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements InteractionListener {
        public c() {
        }

        @Override // com.huawei.appgallery.agd.agdpro.api.InteractionListener
        public void onAdClicked(@Nullable View view) {
            e.this.f18359e.a(e.this.n(), e.this.f18357c);
        }

        @Override // com.huawei.appgallery.agd.agdpro.api.InteractionListener
        public void onAdShow(@Nullable View view) {
            e.this.f18359e.c(e.this.n(), e.this.f18357c);
        }

        @Override // com.huawei.appgallery.agd.agdpro.api.InteractionListener
        public void onRenderFail(@Nullable View view, int i10, @Nullable String str) {
            e.this.f18359e.e(e.this.n(), e.this.f18357c, Integer.valueOf(i10), "onRenderFail " + str);
        }

        @Override // com.huawei.appgallery.agd.agdpro.api.InteractionListener
        public void onRenderSuccess(@Nullable View view, float f10, float f11) {
            e.this.f18359e.b(e.this.n(), e.this.f18357c, view);
        }
    }

    public e(@NotNull WeakReference<FragmentActivity> mActivity, int i10, @NotNull String mAdId, @NotNull com.cupidapp.live.startup.express.b mListener) {
        s.i(mActivity, "mActivity");
        s.i(mAdId, "mAdId");
        s.i(mListener, "mListener");
        this.f18356b = mActivity;
        this.f18357c = i10;
        this.f18358d = mAdId;
        this.f18359e = mListener;
        this.f18360f = FKAdType.HUAWEI;
        this.f18362h = h.l(this);
        this.f18363i = (m() / 166) * 100;
    }

    public static final void q(e this$0) {
        s.i(this$0, "this$0");
        b.a.c(this$0.f18359e, this$0.n(), this$0.f18357c, null, 4, null);
    }

    @Override // com.cupidapp.live.startup.express.FKBaseExpressAd
    public float a() {
        return this.f18363i;
    }

    @Override // com.cupidapp.live.startup.express.FKBaseExpressAd
    public void b() {
        FragmentActivity fragmentActivity = this.f18356b.get();
        if (fragmentActivity == null) {
            this.f18359e.e(n(), this.f18357c, -1, ((Object) n()) + " initExpressAd fail, activity = null");
            return;
        }
        AgdAdApi.init(AppApplication.f11612d.c(), new AgdAdConfig.Builder().debug(k1.a.f50625a.a()).build(), new a(fragmentActivity));
    }

    @Override // com.cupidapp.live.startup.express.FKBaseExpressAd
    public void c() {
        l();
    }

    public final void l() {
        ITemplateAd iTemplateAd;
        List<ITemplateAd> list = this.f18361g;
        if (list == null || (iTemplateAd = (ITemplateAd) CollectionsKt___CollectionsKt.V(list)) == null) {
            return;
        }
        iTemplateAd.destroy();
        List<ITemplateAd> list2 = this.f18361g;
        if (list2 != null) {
            list2.remove(0);
        }
        this.f18361g = null;
    }

    public float m() {
        return this.f18362h;
    }

    @NotNull
    public FKAdType n() {
        return this.f18360f;
    }

    public final void o(FragmentActivity fragmentActivity) {
        new AdsContext(fragmentActivity).loadFeedAds(new AdSlot.Builder().slotId(this.f18358d).adCount(1).darkMode(-1).acceptedSize((int) m(), (int) a()).build(), new b());
    }

    public final void p() {
        List<ITemplateAd> list = this.f18361g;
        ITemplateAd iTemplateAd = list != null ? (ITemplateAd) CollectionsKt___CollectionsKt.V(list) : null;
        if (iTemplateAd == null) {
            this.f18359e.e(n(), this.f18357c, -1, ((Object) n()) + "  showAd fail, templateAd = null");
            return;
        }
        iTemplateAd.setInteractionListener(new c());
        iTemplateAd.setDislikeClickListener(new DislikeClickListener() { // from class: com.cupidapp.live.startup.express.d
            @Override // com.huawei.appgallery.agd.agdpro.api.DislikeClickListener
            public final void onDislikeClick() {
                e.q(e.this);
            }
        });
        iTemplateAd.render();
    }
}
