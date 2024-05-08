package com.cupidapp.live.startup.express.gdt;

import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.startup.express.FKBaseExpressAd;
import com.cupidapp.live.startup.express.b;
import com.cupidapp.live.startup.model.FKAdType;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: FKGDTExpressAd.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends FKBaseExpressAd {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final WeakReference<FragmentActivity> f18378b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18379c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f18380d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final String f18381e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final b f18382f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public NativeExpressAD f18383g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public NativeExpressADView f18384h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final FKAdType f18385i;

    /* renamed from: j, reason: collision with root package name */
    public final float f18386j;

    /* renamed from: k, reason: collision with root package name */
    public final float f18387k;

    /* compiled from: FKGDTExpressAd.kt */
    @d
    /* renamed from: com.cupidapp.live.startup.express.gdt.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0170a implements NativeExpressAD.NativeExpressADListener {
        public C0170a() {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(@Nullable NativeExpressADView nativeExpressADView) {
            a.this.f18382f.a(a.this.j(), a.this.f18379c);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(@Nullable NativeExpressADView nativeExpressADView) {
            b.a.c(a.this.f18382f, a.this.j(), a.this.f18379c, null, 4, null);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(@Nullable NativeExpressADView nativeExpressADView) {
            a.this.f18382f.c(a.this.j(), a.this.f18379c);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(@Nullable NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(@Nullable List<NativeExpressADView> list) {
            a.this.m(list);
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(@Nullable AdError adError) {
            a.this.f18382f.e(a.this.j(), a.this.f18379c, adError != null ? Integer.valueOf(adError.getErrorCode()) : null, adError != null ? adError.getErrorMsg() : null);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(@Nullable NativeExpressADView nativeExpressADView) {
            b.a.e(a.this.f18382f, a.this.j(), a.this.f18379c, -3, null, 8, null);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(@Nullable NativeExpressADView nativeExpressADView) {
            a.this.f18382f.b(a.this.j(), a.this.f18379c, nativeExpressADView);
        }
    }

    public a(@NotNull WeakReference<FragmentActivity> activity, int i10, @Nullable String str, @NotNull String adId, @NotNull b listener) {
        s.i(activity, "activity");
        s.i(adId, "adId");
        s.i(listener, "listener");
        this.f18378b = activity;
        this.f18379c = i10;
        this.f18380d = str;
        this.f18381e = adId;
        this.f18382f = listener;
        this.f18385i = FKAdType.GDT;
        this.f18386j = h.t(this, h.l(this));
        this.f18387k = (i() / 166) * 100;
    }

    @Override // com.cupidapp.live.startup.express.FKBaseExpressAd
    public float a() {
        return this.f18387k;
    }

    @Override // com.cupidapp.live.startup.express.FKBaseExpressAd
    public void b() {
        FragmentActivity fragmentActivity = this.f18378b.get();
        if (fragmentActivity != null) {
            String str = this.f18380d;
            if (str == null) {
                str = "1110569542";
            }
            GDTAdSdk.init(fragmentActivity, str);
            this.f18383g = new NativeExpressAD(fragmentActivity, new ADSize((int) i(), (int) a()), this.f18381e, new C0170a());
            k();
        }
    }

    @Override // com.cupidapp.live.startup.express.FKBaseExpressAd
    public void c() {
        l();
    }

    public float i() {
        return this.f18386j;
    }

    @NotNull
    public FKAdType j() {
        return this.f18385i;
    }

    public final void k() {
        VideoOption.Builder builder = new VideoOption.Builder();
        builder.setAutoPlayPolicy(0).setAutoPlayMuted(true).setDetailPageMuted(false);
        NativeExpressAD nativeExpressAD = this.f18383g;
        if (nativeExpressAD != null) {
            nativeExpressAD.setVideoOption(builder.build());
        }
        NativeExpressAD nativeExpressAD2 = this.f18383g;
        if (nativeExpressAD2 != null) {
            nativeExpressAD2.loadAD(1);
        }
    }

    public final void l() {
        NativeExpressADView nativeExpressADView = this.f18384h;
        if (nativeExpressADView != null) {
            ViewParent parent = nativeExpressADView.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(nativeExpressADView);
            }
            nativeExpressADView.destroy();
        }
    }

    public final void m(List<NativeExpressADView> list) {
        if (list == null || list.isEmpty()) {
            this.f18382f.e(j(), this.f18379c, -4, "NativeExpressADView List isNullOrEmpty");
            return;
        }
        l();
        this.f18384h = list.get(0);
        j.a aVar = j.f12332a;
        FKAdType j10 = j();
        NativeExpressADView nativeExpressADView = this.f18384h;
        aVar.a("ThirdPartyAd", "Express:" + ((Object) j10) + " renderAd ecpmLevel:" + (nativeExpressADView != null ? nativeExpressADView.getECPMLevel() : null));
        NativeExpressADView nativeExpressADView2 = this.f18384h;
        if (nativeExpressADView2 != null) {
            nativeExpressADView2.render();
        }
    }
}
