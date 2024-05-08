package com.cupidapp.live.startup.splashad;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.startup.model.EventTrackClickType;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.model.FKClickArea;
import com.cupidapp.live.startup.model.FKStartupMediaConfigModel;
import com.cupidapp.live.startup.model.SplashAdShowState;
import com.cupidapp.live.startup.view.AdSkipView;
import com.cupidapp.live.startup.view.b;
import com.google.android.material.badge.BadgeDrawable;
import com.jd.ad.sdk.bl.initsdk.JADPrivateController;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.model.IJADExtra;
import com.jd.ad.sdk.nativead.JADNative;
import com.jd.ad.sdk.nativead.JADNativeLoadListener;
import com.jd.ad.sdk.nativead.JADNativeSplashInteractionListener;
import com.jd.ad.sdk.nativead.JADNativeWidget;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;

/* compiled from: JDSplashAd.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class JDSplashAd extends FKBaseSplashAd {

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public static final a f18502n = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final FKStartupMediaConfigModel f18503f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f18504g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final String f18505h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f18506i;

    /* renamed from: j, reason: collision with root package name */
    public long f18507j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public JADNative f18508k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public final FKAdType f18509l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public final FKStartupMediaConfigModel f18510m;

    /* compiled from: JDSplashAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* compiled from: JDSplashAd.kt */
        @d
        /* renamed from: com.cupidapp.live.startup.splashad.JDSplashAd$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class C0172a extends JADPrivateController {
            @Override // com.jd.ad.sdk.bl.initsdk.JADPrivateController
            @NotNull
            public String getOaid() {
                String c4 = g.f52734a.f().c();
                return c4 == null ? "" : c4;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable String str) {
            JADYunSdkConfig.Builder builder = new JADYunSdkConfig.Builder();
            if (str == null) {
                str = "451627";
            }
            JADYunSdk.init(AppApplication.f11612d.h(), builder.setAppId(str).setEnableLog(false).setPrivateController(new C0172a()).build());
        }
    }

    /* compiled from: JDSplashAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements JADNativeSplashInteractionListener {
        public b() {
        }

        @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
        public void onClick(@Nullable View view) {
            JDSplashAd.this.f18506i = true;
            com.cupidapp.live.startup.view.b f10 = JDSplashAd.this.f();
            if (f10 != null) {
                b.a.b(f10, JDSplashAd.this.g(), null, 2, null);
            }
        }

        @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
        public void onClose(@Nullable View view) {
            JDSplashAd.this.h("onClose");
            JDSplashAd.this.w();
        }

        @Override // com.jd.ad.sdk.nativead.JADNativeSplashInteractionListener
        public void onCountdown(int i10) {
            JDSplashAd.this.h("onCountdown time:" + i10);
        }

        @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
        public void onExposure() {
            com.cupidapp.live.startup.view.b f10 = JDSplashAd.this.f();
            if (f10 != null) {
                f10.P(JDSplashAd.this.g());
            }
        }
    }

    /* compiled from: JDSplashAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements JADNativeLoadListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2<Boolean, String, p> f18513b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function2<? super Boolean, ? super String, p> function2) {
            this.f18513b = function2;
        }

        @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
        public void onLoadFailure(int i10, @Nullable String str) {
            com.cupidapp.live.startup.view.b f10 = JDSplashAd.this.f();
            if (f10 != null) {
                b.a.d(f10, JDSplashAd.this.g(), Integer.valueOf(i10), str, false, 8, null);
            }
            this.f18513b.mo1743invoke(Boolean.FALSE, str);
        }

        @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
        public void onLoadSuccess() {
            JADNative jADNative = JDSplashAd.this.f18508k;
            List<JADMaterialData> dataList = jADNative != null ? jADNative.getDataList() : null;
            if (!(dataList == null || dataList.isEmpty())) {
                WeakReference<FragmentActivity> e2 = JDSplashAd.this.e();
                if ((e2 != null ? e2.get() : null) != null) {
                    com.cupidapp.live.startup.view.b f10 = JDSplashAd.this.f();
                    if (f10 != null) {
                        f10.p0(JDSplashAd.this.g());
                    }
                    this.f18513b.mo1743invoke(Boolean.TRUE, null);
                    return;
                }
            }
            String str = ((Object) JDSplashAd.this.g()) + " onLoadSuccess data list is empty";
            com.cupidapp.live.startup.view.b f11 = JDSplashAd.this.f();
            if (f11 != null) {
                b.a.d(f11, JDSplashAd.this.g(), -1, str, false, 8, null);
            }
            this.f18513b.mo1743invoke(Boolean.FALSE, str);
        }
    }

    public JDSplashAd(@NotNull FKStartupMediaConfigModel mModel, @Nullable String str, @NotNull String mAdId) {
        s.i(mModel, "mModel");
        s.i(mAdId, "mAdId");
        this.f18503f = mModel;
        this.f18504g = str;
        this.f18505h = mAdId;
        this.f18507j = System.currentTimeMillis();
        this.f18509l = FKAdType.JD;
        this.f18510m = mModel;
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public int c() {
        IJADExtra jADExtra;
        JADNative jADNative = this.f18508k;
        int price = (jADNative == null || (jADExtra = jADNative.getJADExtra()) == null) ? 0 : jADExtra.getPrice();
        return price <= 0 ? this.f18503f.getAdvertisementBaseInfo().getPrice() : price;
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    @NotNull
    public FKAdType g() {
        return this.f18509l;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002f, code lost:
    
        if ((r0 == 0.0f) != false) goto L11;
     */
    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.String, kotlin.p> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "result"
            kotlin.jvm.internal.s.i(r7, r0)
            com.cupidapp.live.startup.splashad.JDSplashAd$a r0 = com.cupidapp.live.startup.splashad.JDSplashAd.f18502n
            java.lang.String r1 = r6.f18504g
            r0.a(r1)
            int r0 = z0.h.l(r6)
            int r0 = z0.h.t(r6, r0)
            float r0 = (float) r0
            int r1 = z0.h.k(r6)
            int r1 = z0.h.t(r6, r1)
            float r1 = (float) r1
            r2 = 0
            r3 = 0
            r4 = 1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L27
            r5 = 1
            goto L28
        L27:
            r5 = 0
        L28:
            if (r5 != 0) goto L31
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 != 0) goto L2f
            r2 = 1
        L2f:
            if (r2 == 0) goto L3f
        L31:
            r0 = 1080(0x438, float:1.513E-42)
            int r0 = z0.h.t(r6, r0)
            float r0 = (float) r0
            r1 = 1920(0x780, float:2.69E-42)
            int r1 = z0.h.t(r6, r1)
            float r1 = (float) r1
        L3f:
            com.jd.ad.sdk.dl.model.JADSlot$Builder r2 = new com.jd.ad.sdk.dl.model.JADSlot$Builder
            r2.<init>()
            java.lang.String r3 = r6.f18505h
            com.jd.ad.sdk.dl.model.JADSlot$Builder r2 = r2.setSlotID(r3)
            com.jd.ad.sdk.dl.model.JADSlot$Builder r0 = r2.setImageSize(r0, r1)
            com.jd.ad.sdk.dl.model.JADSlot$Builder r0 = r0.setAdType(r4)
            r1 = 5
            com.jd.ad.sdk.dl.model.JADSlot$Builder r0 = r0.setSkipTime(r1)
            com.jd.ad.sdk.dl.model.JADSlot r0 = r0.build()
            com.jd.ad.sdk.nativead.JADNative r1 = new com.jd.ad.sdk.nativead.JADNative
            r1.<init>(r0)
            r6.f18508k = r1
            com.cupidapp.live.startup.splashad.JDSplashAd$c r0 = new com.cupidapp.live.startup.splashad.JDSplashAd$c
            r0.<init>(r7)
            r1.loadAd(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.startup.splashad.JDSplashAd.j(kotlin.jvm.functions.Function2):void");
    }

    @Override // com.cupidapp.live.startup.splashad.FKBaseSplashAd
    public void m(@NotNull ViewGroup adContainer) {
        List<JADMaterialData> dataList;
        s.i(adContainer, "adContainer");
        JADNative jADNative = this.f18508k;
        JADMaterialData jADMaterialData = (jADNative == null || (dataList = jADNative.getDataList()) == null) ? null : (JADMaterialData) CollectionsKt___CollectionsKt.V(dataList);
        WeakReference<FragmentActivity> e2 = e();
        FragmentActivity fragmentActivity = e2 != null ? e2.get() : null;
        if (jADMaterialData != null && fragmentActivity != null) {
            View t2 = t(fragmentActivity, jADMaterialData);
            t2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            v(fragmentActivity, adContainer, t2);
            return;
        }
        String str = ((Object) g()) + " showAd fail, adData=" + ((Object) jADMaterialData) + "  activity=" + ((Object) fragmentActivity);
        com.cupidapp.live.startup.view.b f10 = f();
        if (f10 != null) {
            f10.Q(g(), -1, str);
        }
    }

    public final View t(Activity activity, JADMaterialData jADMaterialData) {
        View inflate = View.inflate(activity, R$layout.layout_ad_jd_splash, null);
        s.g(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        ImageLoaderView imageView = (ImageLoaderView) viewGroup.findViewById(R$id.img_splash_jd);
        FKSVGAImageView jumpImageView = (FKSVGAImageView) viewGroup.findViewById(R$id.jump_imageview);
        ArrayList arrayList = new ArrayList();
        if (this.f18503f.getClickHotArea() == FKClickArea.FullScreen.getArea()) {
            arrayList.add(imageView);
        }
        s.h(jADMaterialData.getImageUrls(), "data.imageUrls");
        if (!r6.isEmpty()) {
            s.h(imageView, "imageView");
            ImageLoaderView.f(imageView, new com.cupidapp.live.base.imageloader.b(false, null, null, Uri.parse(jADMaterialData.getImageUrls().get(0)), null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524279, null), null, 2, null);
        }
        int eventInteractionType = jADMaterialData.getEventInteractionType();
        if (eventInteractionType != 0) {
            if (eventInteractionType == 1) {
                View shakeAnimationView = JADNativeWidget.getShakeAnimationView(activity);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(h.c(this, 100.0f), h.c(this, 100.0f));
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = h.c(layoutParams, 50.0f);
                shakeAnimationView.setLayoutParams(layoutParams);
                viewGroup.addView(shakeAnimationView);
                arrayList.add(shakeAnimationView);
            } else if (eventInteractionType == 2) {
                View swipeAnimationView = JADNativeWidget.getSwipeAnimationView(activity);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, h.c(this, 120.0f));
                layoutParams2.gravity = 81;
                layoutParams2.bottomMargin = h.c(layoutParams2, 50.0f);
                swipeAnimationView.setLayoutParams(layoutParams2);
                viewGroup.addView(swipeAnimationView);
                arrayList.add(swipeAnimationView);
            }
        } else if (this.f18503f.getClickType() == EventTrackClickType.HOT_CLICK || this.f18503f.getClickType() == EventTrackClickType.SEMI_COMPLIANT_HOT) {
            jumpImageView.setVisibility(0);
            s.h(jumpImageView, "jumpImageView");
            FKSVGAImageView.F(jumpImageView, "startup_jump_button.svga", null, null, 6, null);
            arrayList.add(jumpImageView);
        }
        JADNative jADNative = this.f18508k;
        if (jADNative != null) {
            jADNative.registerNativeView(activity, viewGroup, arrayList, kotlin.collections.s.j(), new b());
        }
        return viewGroup;
    }

    public final void u() {
        h("onAdDismissed currentTimeMillis:" + System.currentTimeMillis() + "  mStartTime:" + this.f18507j + "  mIsADClicked:" + this.f18506i);
        if (this.f18506i) {
            return;
        }
        if (5000 - (System.currentTimeMillis() - this.f18507j) < 1000) {
            com.cupidapp.live.startup.view.b f10 = f();
            if (f10 != null) {
                f10.c0(g(), SplashAdShowState.COMPLETE_DISPLAY);
                return;
            }
            return;
        }
        com.cupidapp.live.startup.view.b f11 = f();
        if (f11 != null) {
            f11.J0(g());
        }
    }

    public final void v(Activity activity, ViewGroup viewGroup, View view) {
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        AdSkipView adSkipView = new AdSkipView(activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(h.c(this, 74.0f), h.c(this, 36.0f));
        layoutParams.gravity = BadgeDrawable.TOP_END;
        layoutParams.topMargin = h.c(this, 60.0f);
        layoutParams.rightMargin = h.c(this, 16.0f);
        adSkipView.setLayoutParams(layoutParams);
        adSkipView.c(d(), new Function0<p>() { // from class: com.cupidapp.live.startup.splashad.JDSplashAd$onAdRenderSuccess$1
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
                JDSplashAd.this.y();
            }
        }, new Function0<p>() { // from class: com.cupidapp.live.startup.splashad.JDSplashAd$onAdRenderSuccess$2
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
                JDSplashAd.this.x();
            }
        });
        viewGroup.addView(adSkipView);
        this.f18507j = System.currentTimeMillis();
        h("onAdRenderSuccess view:" + ((Object) view));
    }

    public final void w() {
        this.f18506i = false;
        JADNative jADNative = this.f18508k;
        if (jADNative != null) {
            jADNative.destroy();
        }
        this.f18508k = null;
    }

    public final void x() {
        h("onTimerEnd isADClicked:" + this.f18506i);
        if (this.f18506i) {
            return;
        }
        u();
    }

    public final void y() {
        h("onUserClickSkip isADClicked:" + this.f18506i);
        if (this.f18506i) {
            return;
        }
        u();
    }
}
