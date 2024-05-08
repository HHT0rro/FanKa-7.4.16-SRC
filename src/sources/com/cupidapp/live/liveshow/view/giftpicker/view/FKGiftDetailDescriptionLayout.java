package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.sensorslog.SensorLogActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.MarqueeTextView;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.entity.FKLiveGrpcEntity;
import com.cupidapp.live.liveshow.model.GiftItemModel;
import com.cupidapp.live.liveshow.model.GiftModel;
import com.cupidapp.live.liveshow.model.LiveGiftActivityModel;
import com.cupidapp.live.liveshow.pk.view.FKLivePkStatus;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: FKGiftDetailDescriptionLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKGiftDetailDescriptionLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Function0<p> f15505d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15506e;

    /* compiled from: FKGiftDetailDescriptionLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15507a;

        static {
            int[] iArr = new int[FKLivePkStatus.values().length];
            try {
                iArr[FKLivePkStatus.LivePkStart.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FKLivePkStatus.LivePkInProgress.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FKLivePkStatus.LivePkInteractive.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f15507a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKGiftDetailDescriptionLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15506e = new LinkedHashMap();
        l();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f15506e;
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

    public final void f(final GiftItemModel giftItemModel) {
        if (giftItemModel instanceof GiftModel) {
            GiftModel giftModel = (GiftModel) giftItemModel;
            if (giftModel.getActionGiftCard() == null) {
                ((ImageLoaderView) e(R$id.giftActivityImageView)).setVisibility(8);
                View e2 = e(R$id.blankView);
                ImageLoaderView gift_tab_imageview = (ImageLoaderView) e(R$id.gift_tab_imageview);
                s.h(gift_tab_imageview, "gift_tab_imageview");
                e2.setVisibility(gift_tab_imageview.getVisibility() == 0 ? 0 : 8);
                return;
            }
            setVisibility(k() ? 8 : 0);
            ((ImageLoaderView) e(R$id.gift_tab_imageview)).setVisibility(8);
            int i10 = R$id.giftActivityImageView;
            ((ImageLoaderView) e(i10)).setVisibility(0);
            e(R$id.blankView).setVisibility(0);
            ImageLoaderView giftActivityImageView = (ImageLoaderView) e(i10);
            s.h(giftActivityImageView, "giftActivityImageView");
            ImageLoaderView.g(giftActivityImageView, giftModel.getActionGiftCard(), null, null, 6, null);
            ImageLoaderView giftActivityImageView2 = (ImageLoaderView) e(i10);
            s.h(giftActivityImageView2, "giftActivityImageView");
            y.d(giftActivityImageView2, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKGiftDetailDescriptionLayout$configGiftActivityImage$1
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
                    EventBus.c().l(new FKLiveOpenWebFragmentEvent(((GiftModel) GiftItemModel.this).getActionGiftCardUrl(), true));
                }
            });
        }
    }

    public final void g(final GiftItemModel giftItemModel) {
        setVisibility(k() ? 8 : 0);
        ((ImageLoaderView) e(R$id.gift_banner_img)).setVisibility(8);
        int i10 = R$id.gift_description_layout;
        ((RelativeLayout) e(i10)).setVisibility(0);
        MarqueeTextView gift_detail_description = (MarqueeTextView) e(R$id.gift_detail_description);
        s.h(gift_detail_description, "gift_detail_description");
        u.h(gift_detail_description, giftItemModel.getDescText());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(z0.h.c(gradientDrawable, 10.0f));
        if (giftItemModel instanceof GiftModel) {
            String descBackgroundColor = giftItemModel.getDescBackgroundColor();
            boolean z10 = true;
            gradientDrawable.setColor(descBackgroundColor == null || descBackgroundColor.length() == 0 ? com.cupidapp.live.base.utils.h.a(-16777216, 0.85f) : com.cupidapp.live.base.utils.h.a(com.cupidapp.live.base.utils.h.b(giftItemModel.getDescBackgroundColor()), 0.85f));
            String descUrl = giftItemModel.getDescUrl();
            if (descUrl != null && descUrl.length() != 0) {
                z10 = false;
            }
            if (!z10) {
                ((ImageView) e(R$id.icon_arrow_imageview)).setVisibility(0);
                RelativeLayout gift_description_layout = (RelativeLayout) e(i10);
                s.h(gift_description_layout, "gift_description_layout");
                y.d(gift_description_layout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKGiftDetailDescriptionLayout$configGiftDetail$1
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
                        EventBus.c().l(new FKLiveOpenWebFragmentEvent(GiftItemModel.this.getDescUrl(), true));
                    }
                });
            } else {
                ((ImageView) e(R$id.icon_arrow_imageview)).setVisibility(8);
            }
        } else {
            gradientDrawable.setColor(com.cupidapp.live.base.utils.h.a(-16777216, 0.85f));
            ((ImageView) e(R$id.icon_arrow_imageview)).setVisibility(8);
        }
        ((RelativeLayout) e(i10)).setBackground(gradientDrawable);
    }

    @Nullable
    public final Function0<p> getBlankClickCallback() {
        return this.f15505d;
    }

    public final void h(ImageModel imageModel, final String str) {
        setVisibility(k() ? 8 : 0);
        ((RelativeLayout) e(R$id.gift_description_layout)).setVisibility(8);
        int i10 = R$id.gift_banner_img;
        ((ImageLoaderView) e(i10)).setVisibility(0);
        int scaleHeightByWidth = imageModel.getScaleHeightByWidth(z0.h.l(this));
        ImageLoaderView gift_banner_img = (ImageLoaderView) e(i10);
        s.h(gift_banner_img, "gift_banner_img");
        y.o(gift_banner_img, null, Integer.valueOf(scaleHeightByWidth), 1, null);
        ImageLoaderView gift_banner_img2 = (ImageLoaderView) e(i10);
        s.h(gift_banner_img2, "gift_banner_img");
        ImageLoaderView.g(gift_banner_img2, imageModel, null, null, 6, null);
        ImageLoaderView gift_banner_img3 = (ImageLoaderView) e(i10);
        s.h(gift_banner_img3, "gift_banner_img");
        y.d(gift_banner_img3, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKGiftDetailDescriptionLayout$configGiftDetailBanner$1
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
                EventBus.c().l(new FKLiveOpenWebFragmentEvent(String.this, true));
                SensorLogActivity.f12204a.a(SensorPosition.LiveShowRoom.getValue(), String.this, SensorLogActivity.Type.GIFT_BANNER.getType());
            }
        });
        SensorLogActivity.f12204a.b(SensorPosition.LiveShowRoom.getValue(), str, SensorLogActivity.Type.GIFT_BANNER.getType());
    }

    public final void i(@NotNull GiftItemModel gift) {
        s.i(gift, "gift");
        if (gift.getBannerImage() != null) {
            h(gift.getBannerImage(), gift.getDescUrl());
            FrameLayout activity_layout = (FrameLayout) e(R$id.activity_layout);
            s.h(activity_layout, "activity_layout");
            y.m(activity_layout, null, null, null, Integer.valueOf(z0.h.c(this, 8.0f)), 7, null);
        } else {
            String descText = gift.getDescText();
            if (!(descText == null || descText.length() == 0)) {
                g(gift);
                FrameLayout activity_layout2 = (FrameLayout) e(R$id.activity_layout);
                s.h(activity_layout2, "activity_layout");
                y.m(activity_layout2, null, null, null, Integer.valueOf(z0.h.c(this, 8.0f)), 7, null);
            } else {
                ((ImageLoaderView) e(R$id.gift_banner_img)).setVisibility(8);
                ((RelativeLayout) e(R$id.gift_description_layout)).setVisibility(8);
                FrameLayout activity_layout3 = (FrameLayout) e(R$id.activity_layout);
                s.h(activity_layout3, "activity_layout");
                y.m(activity_layout3, null, null, null, Integer.valueOf(z0.h.c(this, 16.0f)), 7, null);
            }
        }
        f(gift);
    }

    public final void j(@Nullable final LiveGiftActivityModel liveGiftActivityModel) {
        if ((liveGiftActivityModel != null ? liveGiftActivityModel.getIcon() : null) == null) {
            ((ImageLoaderView) e(R$id.gift_tab_imageview)).setVisibility(8);
            View e2 = e(R$id.blankView);
            ImageLoaderView giftActivityImageView = (ImageLoaderView) e(R$id.giftActivityImageView);
            s.h(giftActivityImageView, "giftActivityImageView");
            e2.setVisibility(giftActivityImageView.getVisibility() == 0 ? 0 : 8);
            return;
        }
        setVisibility(k() ? 8 : 0);
        ((ImageLoaderView) e(R$id.giftActivityImageView)).setVisibility(8);
        ((RelativeLayout) e(R$id.gift_description_layout)).setVisibility(8);
        ((ImageLoaderView) e(R$id.gift_banner_img)).setVisibility(8);
        e(R$id.blankView).setVisibility(0);
        int i10 = R$id.gift_tab_imageview;
        ((ImageLoaderView) e(i10)).setVisibility(0);
        ImageLoaderView gift_tab_imageview = (ImageLoaderView) e(i10);
        s.h(gift_tab_imageview, "gift_tab_imageview");
        ImageLoaderView.g(gift_tab_imageview, liveGiftActivityModel.getIcon(), null, null, 6, null);
        ImageLoaderView gift_tab_imageview2 = (ImageLoaderView) e(i10);
        s.h(gift_tab_imageview2, "gift_tab_imageview");
        y.d(gift_tab_imageview2, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKGiftDetailDescriptionLayout$configGiftTabBanner$1
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
                EventBus.c().l(new FKLiveOpenWebFragmentEvent(LiveGiftActivityModel.this.getPath(), true));
            }
        });
        FrameLayout activity_layout = (FrameLayout) e(R$id.activity_layout);
        s.h(activity_layout, "activity_layout");
        y.m(activity_layout, null, null, null, Integer.valueOf(z0.h.c(this, 16.0f)), 7, null);
    }

    public final boolean k() {
        int i10 = a.f15507a[FKLiveGrpcEntity.f14907e.a().f().ordinal()];
        return i10 == 1 || i10 == 2 || i10 == 3;
    }

    public final void l() {
        z.a(this, R$layout.layout_gift_detail_description, true);
        View blankView = e(R$id.blankView);
        s.h(blankView, "blankView");
        y.d(blankView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKGiftDetailDescriptionLayout$initView$1
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
                Function0<p> blankClickCallback = FKGiftDetailDescriptionLayout.this.getBlankClickCallback();
                if (blankClickCallback != null) {
                    blankClickCallback.invoke();
                }
            }
        });
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull HideGiftDetailDescriptionEvent event) {
        s.i(event, "event");
        setVisibility(event.getHide() ? 8 : 0);
    }

    public final void setBlankClickCallback(@Nullable Function0<p> function0) {
        this.f15505d = function0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKGiftDetailDescriptionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15506e = new LinkedHashMap();
        l();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKGiftDetailDescriptionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15506e = new LinkedHashMap();
        l();
    }
}
