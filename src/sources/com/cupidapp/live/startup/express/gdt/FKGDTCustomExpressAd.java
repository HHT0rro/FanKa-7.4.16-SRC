package com.cupidapp.live.startup.express.gdt;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.startup.express.FKBaseExpressAd;
import com.cupidapp.live.startup.express.b;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.vip.c;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;

/* compiled from: FKGDTCustomExpressAd.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKGDTCustomExpressAd extends FKBaseExpressAd {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final WeakReference<FragmentActivity> f18368b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18369c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f18370d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final String f18371e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final com.cupidapp.live.startup.express.b f18372f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public NativeUnifiedAD f18373g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public NativeUnifiedADData f18374h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final FKAdType f18375i;

    /* compiled from: FKGDTCustomExpressAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements NativeADEventListener {
        public a() {
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            FKGDTCustomExpressAd.this.f18372f.a(FKGDTCustomExpressAd.this.j(), FKGDTCustomExpressAd.this.f18369c);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(@Nullable AdError adError) {
            FKGDTCustomExpressAd.this.f18372f.e(FKGDTCustomExpressAd.this.j(), FKGDTCustomExpressAd.this.f18369c, adError != null ? Integer.valueOf(adError.getErrorCode()) : null, adError != null ? adError.getErrorMsg() : null);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            FKGDTCustomExpressAd.this.f18372f.c(FKGDTCustomExpressAd.this.j(), FKGDTCustomExpressAd.this.f18369c);
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
            j.f12332a.a("ThirdPartyAd", "Express:" + ((Object) FKGDTCustomExpressAd.this.j()) + " onADStatusChanged");
        }
    }

    /* compiled from: FKGDTCustomExpressAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements NativeADMediaListener {
        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoClicked() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoCompleted() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoError(@Nullable AdError adError) {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoInit() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoaded(int i10) {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoading() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoPause() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoReady() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoResume() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStart() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStop() {
        }
    }

    /* compiled from: FKGDTCustomExpressAd.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements NativeADUnifiedListener {
        public c() {
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(@Nullable List<NativeUnifiedADData> list) {
            if (list != null && (list.isEmpty() ^ true)) {
                FKGDTCustomExpressAd.this.f18374h = list.get(0);
            }
            FKGDTCustomExpressAd.this.f18372f.b(FKGDTCustomExpressAd.this.j(), FKGDTCustomExpressAd.this.f18369c, FKGDTCustomExpressAd.this.k());
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(@Nullable AdError adError) {
            FKGDTCustomExpressAd.this.f18372f.e(FKGDTCustomExpressAd.this.j(), FKGDTCustomExpressAd.this.f18369c, adError != null ? Integer.valueOf(adError.getErrorCode()) : null, adError != null ? adError.getErrorMsg() : null);
        }
    }

    public FKGDTCustomExpressAd(@NotNull WeakReference<FragmentActivity> activity, int i10, @Nullable String str, @NotNull String adId, @NotNull com.cupidapp.live.startup.express.b listener) {
        s.i(activity, "activity");
        s.i(adId, "adId");
        s.i(listener, "listener");
        this.f18368b = activity;
        this.f18369c = i10;
        this.f18370d = str;
        this.f18371e = adId;
        this.f18372f = listener;
        this.f18375i = FKAdType.GDT_CUSTOM;
    }

    @Override // com.cupidapp.live.startup.express.FKBaseExpressAd
    public void b() {
        FragmentActivity fragmentActivity = this.f18368b.get();
        if (fragmentActivity != null) {
            String str = this.f18370d;
            if (str == null) {
                str = "1110569542";
            }
            GDTAdSdk.init(fragmentActivity, str);
            NativeUnifiedAD nativeUnifiedAD = new NativeUnifiedAD(fragmentActivity, this.f18371e, new c());
            this.f18373g = nativeUnifiedAD;
            nativeUnifiedAD.loadData(1);
        }
    }

    @Override // com.cupidapp.live.startup.express.FKBaseExpressAd
    public void c() {
        NativeUnifiedADData nativeUnifiedADData = this.f18374h;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.destroy();
        }
        this.f18374h = null;
    }

    @Override // com.cupidapp.live.startup.express.FKBaseExpressAd
    public void e() {
        NativeUnifiedADData nativeUnifiedADData = this.f18374h;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.resume();
        }
    }

    @NotNull
    public FKAdType j() {
        return this.f18375i;
    }

    public final ViewGroup k() {
        NativeUnifiedADData nativeUnifiedADData;
        FragmentActivity fragmentActivity = this.f18368b.get();
        if (fragmentActivity == null) {
            return null;
        }
        View inflate = fragmentActivity.getLayoutInflater().inflate(R$layout.view_holder_feed_native_ad_gdt, (ViewGroup) null);
        ViewGroup viewGroup = inflate instanceof ViewGroup ? (ViewGroup) inflate : null;
        if (viewGroup == null) {
            return null;
        }
        NativeUnifiedADData nativeUnifiedADData2 = this.f18374h;
        Integer valueOf = nativeUnifiedADData2 != null ? Integer.valueOf(nativeUnifiedADData2.getAdPatternType()) : null;
        ImageLoaderView userPhotoImageView = (ImageLoaderView) viewGroup.findViewById(R$id.userPhotoImageView);
        NativeAdContainer nativeAdContainer = (NativeAdContainer) viewGroup.findViewById(R$id.feedAdContainer);
        ImageLoaderView feedAdImageView = (ImageLoaderView) viewGroup.findViewById(R$id.feedAdImageView);
        TextView feedIntroductionTextView = (TextView) viewGroup.findViewById(R$id.feedIntroductionTextView);
        MediaView mediaView = (MediaView) viewGroup.findViewById(R$id.feedAdMediaView);
        TextView feedUserNameTextView = (TextView) viewGroup.findViewById(R$id.feedUserNameTextView);
        ConstraintLayout constraintLayout = (ConstraintLayout) viewGroup.findViewById(R$id.feedAdImageViewLayout);
        View closeView = viewGroup.findViewById(R$id.closeView);
        s.h(closeView, "closeView");
        y.d(closeView, new Function1<View, p>() { // from class: com.cupidapp.live.startup.express.gdt.FKGDTCustomExpressAd$inflateAdView$1
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
                if (view != null) {
                    final FKGDTCustomExpressAd fKGDTCustomExpressAd = FKGDTCustomExpressAd.this;
                    c.f18740a.d(view, new Function0<p>() { // from class: com.cupidapp.live.startup.express.gdt.FKGDTCustomExpressAd$inflateAdView$1$1$1
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
                            b.a.c(FKGDTCustomExpressAd.this.f18372f, FKGDTCustomExpressAd.this.j(), FKGDTCustomExpressAd.this.f18369c, null, 4, null);
                        }
                    });
                }
            }
        });
        ViewGroup.LayoutParams layoutParams = constraintLayout != null ? constraintLayout.getLayoutParams() : null;
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(h.l(this), (h.l(this) / 16) * 10);
        }
        if (constraintLayout != null) {
            constraintLayout.setLayoutParams(layoutParams);
        }
        j.a aVar = j.f12332a;
        FKAdType j10 = j();
        int i10 = feedAdImageView.getLayoutParams().height;
        NativeUnifiedADData nativeUnifiedADData3 = this.f18374h;
        aVar.a("ThirdPartyAd", "Express:" + ((Object) j10) + "  patternType:" + ((Object) valueOf) + "   height:" + i10 + "  imgUrl:" + (nativeUnifiedADData3 != null ? nativeUnifiedADData3.getImgUrl() : null));
        s.h(userPhotoImageView, "userPhotoImageView");
        NativeUnifiedADData nativeUnifiedADData4 = this.f18374h;
        ImageLoaderView.f(userPhotoImageView, new com.cupidapp.live.base.imageloader.b(false, null, null, Uri.parse(nativeUnifiedADData4 != null ? nativeUnifiedADData4.getIconUrl() : null), null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524279, null), null, 2, null);
        if (feedUserNameTextView != null) {
            NativeUnifiedADData nativeUnifiedADData5 = this.f18374h;
            feedUserNameTextView.setText(nativeUnifiedADData5 != null ? nativeUnifiedADData5.getTitle() : null);
        }
        if (feedIntroductionTextView != null) {
            NativeUnifiedADData nativeUnifiedADData6 = this.f18374h;
            feedIntroductionTextView.setText(nativeUnifiedADData6 != null ? nativeUnifiedADData6.getDesc() : null);
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            mediaView.setVisibility(8);
            feedAdImageView.setVisibility(0);
            s.h(feedAdImageView, "feedAdImageView");
            NativeUnifiedADData nativeUnifiedADData7 = this.f18374h;
            ImageLoaderView.f(feedAdImageView, new com.cupidapp.live.base.imageloader.b(false, null, null, Uri.parse(nativeUnifiedADData7 != null ? nativeUnifiedADData7.getImgUrl() : null), null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524279, null), null, 2, null);
        } else if (valueOf != null && valueOf.intValue() == 2) {
            mediaView.setVisibility(0);
            feedAdImageView.setVisibility(8);
        }
        s.h(feedAdImageView, "feedAdImageView");
        s.h(feedIntroductionTextView, "feedIntroductionTextView");
        s.h(feedUserNameTextView, "feedUserNameTextView");
        List<View> o10 = kotlin.collections.s.o(userPhotoImageView, feedAdImageView, feedIntroductionTextView, feedUserNameTextView);
        NativeUnifiedADData nativeUnifiedADData8 = this.f18374h;
        if (nativeUnifiedADData8 != null) {
            nativeUnifiedADData8.bindAdToView(fragmentActivity, nativeAdContainer, null, o10);
        }
        NativeUnifiedADData nativeUnifiedADData9 = this.f18374h;
        if (nativeUnifiedADData9 != null) {
            nativeUnifiedADData9.setNativeAdEventListener(new a());
        }
        NativeUnifiedADData nativeUnifiedADData10 = this.f18374h;
        if ((nativeUnifiedADData10 != null && nativeUnifiedADData10.getAdPatternType() == 2) && (nativeUnifiedADData = this.f18374h) != null) {
            nativeUnifiedADData.bindMediaView(mediaView, new VideoOption.Builder().setAutoPlayMuted(true).setAutoPlayPolicy(0).build(), new b());
        }
        return viewGroup;
    }
}
