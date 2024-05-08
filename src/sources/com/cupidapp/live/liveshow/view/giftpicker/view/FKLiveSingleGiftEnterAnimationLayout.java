package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderUtil;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.scrolltext.RollingTextView;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.GiftItemModel;
import com.cupidapp.live.liveshow.model.LiveShowGiftModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.view.giftpicker.fragment.OpenLiveGiftEvent;
import com.cupidapp.live.liveshow.view.label.LiveLabelListView;
import com.cupidapp.live.liveshow.view.miniprofile.ShowLiveMiniProfileViewModel;
import com.cupidapp.live.profile.model.User;
import com.irisdt.client.live.LiveProtos;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKLiveSingleGiftEnterAnimationLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveSingleGiftEnterAnimationLayout extends FrameLayout implements Animator.AnimatorListener {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public String f15530b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15531c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public LiveShowGiftModel f15532d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.liveshow.view.giftpicker.view.b f15533e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15534f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f15535g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public AnimatorSet f15536h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public AnimatorSet f15537i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15538j;

    /* compiled from: FKLiveSingleGiftEnterAnimationLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            com.cupidapp.live.liveshow.view.giftpicker.view.b bVar = FKLiveSingleGiftEnterAnimationLayout.this.f15533e;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    /* compiled from: FKLiveSingleGiftEnterAnimationLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            FKLiveSingleGiftEnterAnimationLayout fKLiveSingleGiftEnterAnimationLayout = FKLiveSingleGiftEnterAnimationLayout.this;
            fKLiveSingleGiftEnterAnimationLayout.k(fKLiveSingleGiftEnterAnimationLayout.getGiftModel());
        }
    }

    /* compiled from: FKLiveSingleGiftEnterAnimationLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LiveShowGiftModel f15542c;

        public c(LiveShowGiftModel liveShowGiftModel) {
            this.f15542c = liveShowGiftModel;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            FKLiveSingleGiftEnterAnimationLayout.this.setAlpha(1.0f);
            FKLiveSingleGiftEnterAnimationLayout.this.setTranslationY(0.0f);
            FKLiveSingleGiftEnterAnimationLayout.this.setAnimating(false);
            FKLiveSingleGiftEnterAnimationLayout.this.setVisibility(4);
            LiveShowGiftModel liveShowGiftModel = this.f15542c;
            if (liveShowGiftModel != null) {
                FKLiveSingleGiftEnterAnimationLayout.this.g(liveShowGiftModel).l();
                return;
            }
            com.cupidapp.live.liveshow.view.giftpicker.view.b bVar = FKLiveSingleGiftEnterAnimationLayout.this.f15533e;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSingleGiftEnterAnimationLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15538j = new LinkedHashMap();
        i();
    }

    public static /* synthetic */ void n(FKLiveSingleGiftEnterAnimationLayout fKLiveSingleGiftEnterAnimationLayout, LiveShowGiftModel liveShowGiftModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            liveShowGiftModel = null;
        }
        fKLiveSingleGiftEnterAnimationLayout.m(liveShowGiftModel);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15538j;
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

    public final void d(LiveShowGiftModel liveShowGiftModel) {
        String bgImageAndroid = liveShowGiftModel.getBgImageAndroid();
        if (bgImageAndroid == null || bgImageAndroid.length() == 0) {
            ((LinearLayout) a(R$id.sendGiftContainerLayout)).setBackgroundResource(R$drawable.gift_layout_bg);
        } else {
            ImageLoaderUtil imageLoaderUtil = ImageLoaderUtil.f11832a;
            Context context = getContext();
            s.h(context, "context");
            imageLoaderUtil.h(context, liveShowGiftModel.getBgImageAndroid(), new Function1<Drawable, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKLiveSingleGiftEnterAnimationLayout$configBg$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Drawable drawable) {
                    invoke2(drawable);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Drawable drawable) {
                    if (drawable == null) {
                        ((LinearLayout) FKLiveSingleGiftEnterAnimationLayout.this.a(R$id.sendGiftContainerLayout)).setBackgroundResource(R$drawable.gift_layout_bg);
                    } else {
                        ((LinearLayout) FKLiveSingleGiftEnterAnimationLayout.this.a(R$id.sendGiftContainerLayout)).setBackground(drawable);
                    }
                }
            });
        }
        if (liveShowGiftModel.getTopIcon() != null) {
            int i10 = R$id.top_imageview;
            ImageLoaderView top_imageview = (ImageLoaderView) a(i10);
            s.h(top_imageview, "top_imageview");
            top_imageview.setVisibility(0);
            ImageLoaderView top_imageview2 = (ImageLoaderView) a(i10);
            s.h(top_imageview2, "top_imageview");
            y.o(top_imageview2, Integer.valueOf(liveShowGiftModel.getTopIcon().getScaleWidthByHeight(z0.h.c(this, 7.0f))), null, 2, null);
            ImageLoaderView top_imageview3 = (ImageLoaderView) a(i10);
            s.h(top_imageview3, "top_imageview");
            ImageLoaderView.g(top_imageview3, liveShowGiftModel.getTopIcon(), null, null, 6, null);
        } else {
            ImageLoaderView top_imageview4 = (ImageLoaderView) a(R$id.top_imageview);
            s.h(top_imageview4, "top_imageview");
            top_imageview4.setVisibility(8);
        }
        if (liveShowGiftModel.getBottomIcon() != null) {
            int i11 = R$id.bottom_imageview;
            ImageLoaderView bottom_imageview = (ImageLoaderView) a(i11);
            s.h(bottom_imageview, "bottom_imageview");
            bottom_imageview.setVisibility(0);
            ImageLoaderView bottom_imageview2 = (ImageLoaderView) a(i11);
            s.h(bottom_imageview2, "bottom_imageview");
            y.o(bottom_imageview2, Integer.valueOf(liveShowGiftModel.getBottomIcon().getScaleWidthByHeight(z0.h.c(this, 4.0f))), null, 2, null);
            ImageLoaderView bottom_imageview3 = (ImageLoaderView) a(i11);
            s.h(bottom_imageview3, "bottom_imageview");
            ImageLoaderView.g(bottom_imageview3, liveShowGiftModel.getBottomIcon(), null, null, 6, null);
            return;
        }
        ImageLoaderView bottom_imageview4 = (ImageLoaderView) a(R$id.bottom_imageview);
        s.h(bottom_imageview4, "bottom_imageview");
        bottom_imageview4.setVisibility(8);
    }

    public final void e(boolean z10) {
        this.f15534f = z10;
        if (z10) {
            ((LinearLayout) a(R$id.sendGiftContainerLayout)).getLayoutParams().height = z0.h.c(this, 42.0f);
            TextView textView = (TextView) a(R$id.sendGiftUserName);
            textView.setTextColor(-14522);
            textView.setTextSize(14.0f);
            ((TextView) a(R$id.giftDescription)).setTextSize(14.0f);
        }
    }

    public final void f(LiveShowGiftModel liveShowGiftModel) {
        String desc;
        String desc2 = liveShowGiftModel.getDesc();
        if (desc2 == null || desc2.length() == 0) {
            desc = getContext().getString(R$string.have_send_some_gift, liveShowGiftModel.getGift().getName());
        } else {
            desc = liveShowGiftModel.getDesc();
        }
        int i10 = R$id.giftDescription;
        if (s.d(desc, ((TextView) a(i10)).getText())) {
            return;
        }
        ((TextView) a(i10)).setText(desc);
    }

    @NotNull
    public final FKLiveSingleGiftEnterAnimationLayout g(@NotNull LiveShowGiftModel giftModel) {
        s.i(giftModel, "giftModel");
        this.f15532d = giftModel;
        d(giftModel);
        User sender = giftModel.getSender();
        if (sender != null) {
            ImageLoaderView sendGiftUserAvatar = (ImageLoaderView) a(R$id.sendGiftUserAvatar);
            s.h(sendGiftUserAvatar, "sendGiftUserAvatar");
            ImageLoaderView.g(sendGiftUserAvatar, sender.getAvatarImage(), null, null, 6, null);
            ((TextView) a(R$id.sendGiftUserName)).setText(sender.getName());
        }
        f(giftModel);
        ImageLoaderView sendGiftImageView = (ImageLoaderView) a(R$id.sendGiftImageView);
        s.h(sendGiftImageView, "sendGiftImageView");
        ImageLoaderView.g(sendGiftImageView, giftModel.getGift().getImage(), null, null, 6, null);
        ((TextView) a(R$id.giftCountTextView)).setText("");
        ((RollingTextView) a(R$id.rollingGiftCountTextView)).setText("", false);
        ((LinearLayout) a(R$id.rolling_layout)).setVisibility(8);
        h(giftModel.getSpokesman());
        LiveLabelListView gift_enter_label_view = (LiveLabelListView) a(R$id.gift_enter_label_view);
        s.h(gift_enter_label_view, "gift_enter_label_view");
        gift_enter_label_view.n(giftModel.getGiftTrackLabels(), null, (r12 & 4) != 0 ? 11.0f : 0.0f, (r12 & 8) != 0 ? Integer.MAX_VALUE : 0, (r12 & 16) != 0 ? false : false);
        return this;
    }

    @Nullable
    public final String getEnterSource() {
        return this.f15530b;
    }

    @Nullable
    public final LiveShowGiftModel getGiftModel() {
        return this.f15532d;
    }

    public final void h(ImageModel imageModel) {
        if (imageModel == null) {
            ((ImageLoaderView) a(R$id.spokesmanIcon)).setVisibility(8);
            return;
        }
        int i10 = R$id.spokesmanIcon;
        ((ImageLoaderView) a(i10)).setVisibility(0);
        ImageLoaderView spokesmanIcon = (ImageLoaderView) a(i10);
        s.h(spokesmanIcon, "spokesmanIcon");
        ImageLoaderView.g(spokesmanIcon, imageModel, null, null, 6, null);
    }

    public final void i() {
        z.a(this, R$layout.layout_live_single_gift_enter_animation, true);
        setVisibility(4);
        int i10 = R$id.rollingGiftCountTextView;
        ((RollingTextView) a(i10)).setAnimationDuration(350L);
        ((RollingTextView) a(i10)).g("0123456789");
        ((RollingTextView) a(i10)).f(this);
        LinearLayout sendGiftContainerLayout = (LinearLayout) a(R$id.sendGiftContainerLayout);
        s.h(sendGiftContainerLayout, "sendGiftContainerLayout");
        y.d(sendGiftContainerLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKLiveSingleGiftEnterAnimationLayout$initView$1
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
                User sender;
                LiveShowGiftModel giftModel = FKLiveSingleGiftEnterAnimationLayout.this.getGiftModel();
                if (giftModel == null || (sender = giftModel.getSender()) == null) {
                    return;
                }
                EventBus.c().l(new ShowLiveMiniProfileViewModel(sender.userId(), null, null, false, false, false, 54, null));
            }
        });
        ImageLoaderView sendGiftImageView = (ImageLoaderView) a(R$id.sendGiftImageView);
        s.h(sendGiftImageView, "sendGiftImageView");
        y.d(sendGiftImageView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKLiveSingleGiftEnterAnimationLayout$initView$2
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
                boolean z10;
                GiftItemModel gift;
                z10 = FKLiveSingleGiftEnterAnimationLayout.this.f15534f;
                if (z10) {
                    return;
                }
                LiveShowGiftModel giftModel = FKLiveSingleGiftEnterAnimationLayout.this.getGiftModel();
                if (giftModel == null || (gift = giftModel.getOriginalGift()) == null) {
                    LiveShowGiftModel giftModel2 = FKLiveSingleGiftEnterAnimationLayout.this.getGiftModel();
                    gift = giftModel2 != null ? giftModel2.getGift() : null;
                }
                EventBus.c().l(new OpenLiveGiftEvent(gift != null ? gift.getItemId() : null, gift != null ? gift.getFenceId() : null, null, 4, null));
                LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                if (liveShowModel != null) {
                    SensorsLogLiveShow.f12212a.f(liveShowModel.getItemId(), liveShowModel.getUser().userId(), LiveProtos.Type.DISPLAY_GIFT, (r13 & 8) != 0 ? null : FKLiveSingleGiftEnterAnimationLayout.this.getEnterSource(), (r13 & 16) != 0 ? null : null);
                }
            }
        });
    }

    public final boolean j() {
        return this.f15531c;
    }

    public final void k(@Nullable LiveShowGiftModel liveShowGiftModel) {
        if (liveShowGiftModel == null) {
            return;
        }
        f(liveShowGiftModel);
        LiveShowGiftModel liveShowGiftModel2 = this.f15532d;
        if (liveShowGiftModel2 != null) {
            liveShowGiftModel2.setRushCounter(liveShowGiftModel.getRushCounter());
        }
        if (liveShowGiftModel.getCount() >= 10) {
            ((TextView) a(R$id.giftCountTextView)).setVisibility(8);
            ((LinearLayout) a(R$id.rolling_layout)).setVisibility(0);
            ((RollingTextView) a(R$id.rollingGiftCountTextView)).setText(String.valueOf(liveShowGiftModel.getRushCounter()), true);
            return;
        }
        ((LinearLayout) a(R$id.rolling_layout)).setVisibility(8);
        int i10 = R$id.giftCountTextView;
        ((TextView) a(i10)).setVisibility(0);
        ((TextView) a(i10)).setText(getContext().getString(R$string.gift_count, Integer.valueOf(liveShowGiftModel.getRushCounter())));
        ((TextView) a(i10)).measure(View.MeasureSpec.makeMeasureSpec(z0.h.l(this), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(z0.h.k(this), Integer.MIN_VALUE));
        TextView giftCountTextView = (TextView) a(i10);
        s.h(giftCountTextView, "giftCountTextView");
        y.o(giftCountTextView, Integer.valueOf(((TextView) a(i10)).getMeasuredWidth() + z0.h.c(this, 6.0f)), null, 2, null);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((TextView) a(i10), (Property<TextView, Float>) View.SCALE_X, 2.0f, 1.0f);
        ofFloat.setRepeatMode(1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat((TextView) a(i10), (Property<TextView, Float>) View.SCALE_Y, 2.0f, 1.0f);
        ofFloat2.setRepeatMode(1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(380L);
        animatorSet.setInterpolator(new OvershootInterpolator());
        animatorSet.addListener(new a());
        this.f15536h = animatorSet;
        animatorSet.start();
    }

    public final void l() {
        this.f15531c = true;
        setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<FKLiveSingleGiftEnterAnimationLayout, Float>) View.TRANSLATION_X, -z0.h.l(this), 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.addListener(new b());
        this.f15535g = ofFloat;
        ofFloat.start();
    }

    public final void m(@Nullable LiveShowGiftModel liveShowGiftModel) {
        if (liveShowGiftModel != null) {
            this.f15532d = liveShowGiftModel;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<FKLiveSingleGiftEnterAnimationLayout, Float>) View.TRANSLATION_Y, 0.0f, -z0.h.c(this, 80.0f));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, (Property<FKLiveSingleGiftEnterAnimationLayout, Float>) View.ALPHA, 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(300L);
        animatorSet.setStartDelay(liveShowGiftModel == null ? 1000L : 0L);
        animatorSet.addListener(new c(liveShowGiftModel));
        this.f15537i = animatorSet;
        animatorSet.start();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@NotNull Animator p02) {
        s.i(p02, "p0");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@NotNull Animator animation) {
        s.i(animation, "animation");
        com.cupidapp.live.liveshow.view.giftpicker.view.b bVar = this.f15533e;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(@NotNull Animator p02) {
        s.i(p02, "p0");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(@NotNull Animator p02) {
        s.i(p02, "p0");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f15533e = null;
        ObjectAnimator objectAnimator = this.f15535g;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
        }
        ObjectAnimator objectAnimator2 = this.f15535g;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        AnimatorSet animatorSet = this.f15536h;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
        }
        AnimatorSet animatorSet2 = this.f15536h;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.f15537i;
        if (animatorSet3 != null) {
            animatorSet3.removeAllListeners();
        }
        AnimatorSet animatorSet4 = this.f15537i;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
        ((RollingTextView) a(R$id.rollingGiftCountTextView)).n(this);
    }

    public final void setAnimating(boolean z10) {
        this.f15531c = z10;
    }

    public final void setCheckGiftListAnimationListener(@NotNull com.cupidapp.live.liveshow.view.giftpicker.view.b listener) {
        s.i(listener, "listener");
        this.f15533e = listener;
    }

    public final void setEnterSource(@Nullable String str) {
        this.f15530b = str;
    }

    public final void setGiftModel(@Nullable LiveShowGiftModel liveShowGiftModel) {
        this.f15532d = liveShowGiftModel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSingleGiftEnterAnimationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15538j = new LinkedHashMap();
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSingleGiftEnterAnimationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15538j = new LinkedHashMap();
        i();
    }
}
