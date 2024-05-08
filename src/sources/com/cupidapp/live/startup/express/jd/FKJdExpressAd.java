package com.cupidapp.live.startup.express.jd;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.startup.express.FKBaseExpressAd;
import com.cupidapp.live.startup.express.b;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.splashad.JDSplashAd;
import com.cupidapp.live.vip.c;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.nativead.JADNative;
import com.jd.ad.sdk.nativead.JADNativeInteractionListener;
import com.jd.ad.sdk.nativead.JADNativeLoadListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;

/* compiled from: FKJdExpressAd.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKJdExpressAd extends FKBaseExpressAd {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final WeakReference<FragmentActivity> f18389b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18390c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f18391d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final String f18392e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final b f18393f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public JADNative f18394g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final FKAdType f18395h;

    /* renamed from: i, reason: collision with root package name */
    public final float f18396i;

    /* renamed from: j, reason: collision with root package name */
    public final float f18397j;

    /* compiled from: FKJdExpressAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements JADNativeLoadListener {
        public a() {
        }

        @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
        public void onLoadFailure(int i10, @Nullable String str) {
            FKJdExpressAd.this.f18393f.e(FKJdExpressAd.this.l(), FKJdExpressAd.this.f18390c, Integer.valueOf(i10), str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
        public void onLoadSuccess() {
            JADNative jADNative = FKJdExpressAd.this.f18394g;
            List<JADMaterialData> dataList = jADNative != null ? jADNative.getDataList() : null;
            if (dataList == null || dataList.isEmpty()) {
                b.a.e(FKJdExpressAd.this.f18393f, FKJdExpressAd.this.l(), FKJdExpressAd.this.f18390c, null, "load ad is empty", 4, null);
                return;
            }
            FragmentActivity fragmentActivity = (FragmentActivity) FKJdExpressAd.this.f18389b.get();
            if (fragmentActivity != null) {
                FKJdExpressAd fKJdExpressAd = FKJdExpressAd.this;
                JADMaterialData adData = (JADMaterialData) CollectionsKt___CollectionsKt.T(dataList);
                s.h(adData, "adData");
                ViewGroup m10 = fKJdExpressAd.m(adData, fragmentActivity);
                ViewGroup.LayoutParams layoutParams = m10.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ConstraintLayout.LayoutParams(-1, -2);
                } else {
                    s.h(layoutParams, "view.layoutParams ?: Con…                        )");
                }
                m10.setLayoutParams(layoutParams);
                fKJdExpressAd.f18393f.b(fKJdExpressAd.l(), fKJdExpressAd.f18390c, m10);
            }
        }
    }

    public FKJdExpressAd(@NotNull WeakReference<FragmentActivity> activity, int i10, @Nullable String str, @NotNull String adId, @NotNull b listener) {
        s.i(activity, "activity");
        s.i(adId, "adId");
        s.i(listener, "listener");
        this.f18389b = activity;
        this.f18390c = i10;
        this.f18391d = str;
        this.f18392e = adId;
        this.f18393f = listener;
        this.f18395h = FKAdType.JD;
        this.f18396i = h.t(this, h.l(this));
        this.f18397j = (k() / 166) * 100;
    }

    @Override // com.cupidapp.live.startup.express.FKBaseExpressAd
    public float a() {
        return this.f18397j;
    }

    @Override // com.cupidapp.live.startup.express.FKBaseExpressAd
    public void b() {
        JDSplashAd.f18502n.a(this.f18391d);
        JADNative jADNative = new JADNative(new JADSlot.Builder().setSlotID(this.f18392e).setImageSize(k(), a()).setAdType(2).build());
        this.f18394g = jADNative;
        jADNative.loadAd(new a());
    }

    @Override // com.cupidapp.live.startup.express.FKBaseExpressAd
    public void c() {
        JADNative jADNative = this.f18394g;
        if (jADNative != null) {
            jADNative.destroy();
        }
        this.f18394g = null;
    }

    public float k() {
        return this.f18396i;
    }

    @NotNull
    public FKAdType l() {
        return this.f18395h;
    }

    public final ViewGroup m(JADMaterialData jADMaterialData, Activity activity) {
        View inflate = LayoutInflater.from(activity).inflate(R$layout.view_holder_feed_native_ad, (ViewGroup) null);
        s.g(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        ImageLoaderView userPhotoImageView = (ImageLoaderView) viewGroup.findViewById(R$id.userPhotoImageView);
        ImageLoaderView feedAdImageView = (ImageLoaderView) viewGroup.findViewById(R$id.feedAdImageView);
        TextView feedIntroductionTextView = (TextView) viewGroup.findViewById(R$id.feedIntroductionTextView);
        TextView feedUserNameTextView = (TextView) viewGroup.findViewById(R$id.feedUserNameTextView);
        View closeView = viewGroup.findViewById(R$id.closeView);
        s.h(userPhotoImageView, "userPhotoImageView");
        ImageLoaderView.f(userPhotoImageView, new com.cupidapp.live.base.imageloader.b(false, null, null, null, Integer.valueOf(R$mipmap.icon_jd), null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524271, null), null, 2, null);
        feedUserNameTextView.getPaint().setFakeBoldText(true);
        feedUserNameTextView.setText(activity.getString(R$string.splash_ad_jd));
        feedIntroductionTextView.setText(jADMaterialData.getTitle());
        s.h(feedAdImageView, "feedAdImageView");
        y.n(feedAdImageView, Integer.valueOf(h.l(this)), Integer.valueOf((h.l(this) / 166) * 100));
        s.h(jADMaterialData.getImageUrls(), "data.imageUrls");
        if (!r8.isEmpty()) {
            ImageLoaderView.f(feedAdImageView, new com.cupidapp.live.base.imageloader.b(false, null, null, Uri.parse(jADMaterialData.getImageUrls().get(0)), null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524279, null), null, 2, null);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(userPhotoImageView);
        arrayList.add(feedAdImageView);
        s.h(feedIntroductionTextView, "feedIntroductionTextView");
        arrayList.add(feedIntroductionTextView);
        s.h(feedUserNameTextView, "feedUserNameTextView");
        arrayList.add(feedUserNameTextView);
        ArrayList arrayList2 = new ArrayList();
        s.h(closeView, "closeView");
        arrayList2.add(closeView);
        JADNative jADNative = this.f18394g;
        if (jADNative != null) {
            jADNative.registerNativeView(activity, viewGroup, arrayList, arrayList2, new JADNativeInteractionListener() { // from class: com.cupidapp.live.startup.express.jd.FKJdExpressAd$inflateAdView$1
                @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
                public void onClick(@Nullable View view) {
                    FKJdExpressAd.this.f18393f.a(FKJdExpressAd.this.l(), FKJdExpressAd.this.f18390c);
                }

                @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
                public void onClose(@Nullable View view) {
                    boolean z10 = false;
                    if (view != null && view.getId() == 2131362614) {
                        z10 = true;
                    }
                    if (z10) {
                        c cVar = c.f18740a;
                        final FKJdExpressAd fKJdExpressAd = FKJdExpressAd.this;
                        cVar.d(view, new Function0<p>() { // from class: com.cupidapp.live.startup.express.jd.FKJdExpressAd$inflateAdView$1$onClose$1
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
                                b.a.c(FKJdExpressAd.this.f18393f, FKJdExpressAd.this.l(), FKJdExpressAd.this.f18390c, null, 4, null);
                            }
                        });
                    }
                }

                @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
                public void onExposure() {
                    FKJdExpressAd.this.f18393f.c(FKJdExpressAd.this.l(), FKJdExpressAd.this.f18390c);
                }
            });
        }
        return viewGroup;
    }
}
