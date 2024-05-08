package com.cupidapp.live.startup.express;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.startup.express.b;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.splashad.KSSplashAd;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.t;

/* compiled from: FKKSExpressAd.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c extends FKBaseExpressAd {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final WeakReference<FragmentActivity> f18333b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18334c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f18335d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final String f18336e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final com.cupidapp.live.startup.express.b f18337f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final FKAdType f18338g;

    /* compiled from: FKKSExpressAd.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements KsFeedAd.AdInteractionListener {
        public a() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdClicked() {
            c.this.f18337f.a(c.this.i(), c.this.f18334c);
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdShow() {
            c.this.f18337f.c(c.this.i(), c.this.f18334c);
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDislikeClicked() {
            b.a.c(c.this.f18337f, c.this.i(), c.this.f18334c, null, 4, null);
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDownloadTipsDialogDismiss() {
            j.f12332a.a("FKKSExpressAd", "onDownloadTipsDialogDismiss");
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDownloadTipsDialogShow() {
            j.f12332a.a("FKKSExpressAd", "onDownloadTipsDialogShow");
        }
    }

    /* compiled from: FKKSExpressAd.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements KsLoadManager.FeedAdListener {
        public b() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onError(int i10, @Nullable String str) {
            c.this.f18337f.e(c.this.i(), c.this.f18334c, Integer.valueOf(i10), str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            c.this.f18337f.b(c.this.i(), c.this.f18334c, c.this.j((KsFeedAd) CollectionsKt___CollectionsKt.T(list)));
        }
    }

    public c(@NotNull WeakReference<FragmentActivity> activity, int i10, @Nullable String str, @NotNull String adId, @NotNull com.cupidapp.live.startup.express.b listener) {
        s.i(activity, "activity");
        s.i(adId, "adId");
        s.i(listener, "listener");
        this.f18333b = activity;
        this.f18334c = i10;
        this.f18335d = str;
        this.f18336e = adId;
        this.f18337f = listener;
        this.f18338g = FKAdType.KS;
    }

    @Override // com.cupidapp.live.startup.express.FKBaseExpressAd
    public void b() {
        FragmentActivity fragmentActivity = this.f18333b.get();
        if (fragmentActivity == null || !KSSplashAd.f18514l.a(fragmentActivity, this.f18335d)) {
            return;
        }
        k();
    }

    @NotNull
    public FKAdType i() {
        return this.f18338g;
    }

    public final View j(KsFeedAd ksFeedAd) {
        ksFeedAd.setVideoPlayConfig(new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).videoAutoPlayType(3).build());
        ksFeedAd.setAdInteractionListener(new a());
        return ksFeedAd.getFeedView(this.f18333b.get());
    }

    public final void k() {
        KsLoadManager loadManager;
        KsScene build = new KsScene.Builder(t.r(this.f18336e)).width(h.l(this)).adNum(1).build();
        if (KsAdSDK.getLoadManager() == null || (loadManager = KsAdSDK.getLoadManager()) == null) {
            return;
        }
        loadManager.loadConfigFeedAd(build, new b());
    }
}
