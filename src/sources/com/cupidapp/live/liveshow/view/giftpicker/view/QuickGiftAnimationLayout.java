package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderUtil;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.cupidapp.live.liveshow.model.QuickGiftModel;
import com.cupidapp.live.liveshow.model.SendGiftResult;
import com.cupidapp.live.liveshow.view.giftpicker.fragment.OpenDiamondBalanceEvent;
import com.cupidapp.live.liveshow.view.giftpicker.view.QuickGiftFirstSendLayout;
import com.cupidapp.live.liveshow.view.giftpicker.view.QuickGiftSendConfirmLayout;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.h0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.random.Random;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;
import z0.y;
import z0.z;

/* compiled from: QuickGiftAnimationLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class QuickGiftAnimationLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Function1<? super QuickGiftModel, p> f15560d;

    /* renamed from: e, reason: collision with root package name */
    public final int f15561e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15562f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.utils.i f15563g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public AtomicInteger f15564h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public AnimatorSet f15565i;

    /* renamed from: j, reason: collision with root package name */
    public int f15566j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15567k;

    /* compiled from: Animator.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements Animator.AnimatorListener {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImageLoaderView f15569c;

        public a(ImageLoaderView imageLoaderView) {
            this.f15569c = imageLoaderView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            ((FrameLayout) QuickGiftAnimationLayout.this.e(R$id.quick_gift_container_layout)).removeView(this.f15569c);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            s.i(animator, "animator");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickGiftAnimationLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15567k = new LinkedHashMap();
        this.f15561e = z0.h.c(this, 350.0f);
        this.f15564h = new AtomicInteger((int) (Math.random() * 10000));
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getQuickGift() {
        Disposable disposed = NetworkClient.f11868a.r().B0().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<QuickGiftModel, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.QuickGiftAnimationLayout$getQuickGift$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(QuickGiftModel quickGiftModel) {
                m2647invoke(quickGiftModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2647invoke(QuickGiftModel quickGiftModel) {
                QuickGiftModel quickGiftModel2 = quickGiftModel;
                LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
                if (fkLiveShowResult != null) {
                    fkLiveShowResult.setQuickGift(quickGiftModel2);
                }
                Function1<QuickGiftModel, p> refreshQuickGift = QuickGiftAnimationLayout.this.getRefreshQuickGift();
                if (refreshQuickGift != null) {
                    refreshQuickGift.invoke(quickGiftModel2);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f15567k;
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

    @Nullable
    public final Function1<QuickGiftModel, p> getRefreshQuickGift() {
        return this.f15560d;
    }

    public final Animator l(View view, float f10, float f11) {
        float f12 = this.f15561e;
        Path path = new Path();
        path.moveTo((f10 + f11) / 2.0f, 0.0f);
        path.quadTo((f10 / 4.0f) + ((3 * f11) / 4.0f), 0.0f, f11, f12);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.X, View.Y, path);
        ofFloat.setDuration(400L);
        ofFloat.setInterpolator(new AccelerateInterpolator(0.8f));
        s.h(ofFloat, "ofFloat(giftView, View.X…erpolator(0.8f)\n        }");
        return ofFloat;
    }

    public final Animator m(View view, boolean z10) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ROTATION, z10 ? 360.0f : 0.0f, z10 ? 0.0f : 360.0f);
        ofFloat.setDuration(800L);
        s.h(ofFloat, "ofFloat(giftView, View.R…duration = 800L\n        }");
        return ofFloat;
    }

    public final Animator o(View view, float f10, float f11) {
        int c4 = this.f15561e - z0.h.c(this, 47.0f);
        Path path = new Path();
        path.moveTo(f10, c4);
        path.quadTo(((3 * f10) / 4.0f) + (f11 / 4.0f), 0.0f, (f10 + f11) / 2.0f, 0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.X, View.Y, path);
        ofFloat.setDuration(400L);
        ofFloat.setInterpolator(new DecelerateInterpolator(0.8f));
        s.h(ofFloat, "ofFloat(giftView, View.X…erpolator(0.8f)\n        }");
        return ofFloat;
    }

    @Override // com.cupidapp.live.base.view.BaseLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((FKSVGAImageView) e(R$id.explosion_animation_view)).K();
        AnimatorSet animatorSet = this.f15565i;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
        }
        AnimatorSet animatorSet2 = this.f15565i;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        v();
    }

    public final void p() {
        z.a(this, R$layout.layout_quick_gift_animation, true);
        FrameLayout quick_gift_container_layout = (FrameLayout) e(R$id.quick_gift_container_layout);
        s.h(quick_gift_container_layout, "quick_gift_container_layout");
        y.o(quick_gift_container_layout, null, Integer.valueOf(this.f15561e), 1, null);
        setVisibility(8);
    }

    public final void q(final QuickGiftModel quickGiftModel, final boolean z10) {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().C0(itemId, quickGiftModel.getGift().getItemId(), this.f15562f ? this.f15564h.get() : this.f15564h.incrementAndGet(), quickGiftModel.getDiscountedPrice()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SendGiftResult, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.QuickGiftAnimationLayout$sendQuickGift$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SendGiftResult sendGiftResult) {
                m2648invoke(sendGiftResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2648invoke(SendGiftResult sendGiftResult) {
                SendGiftResult sendGiftResult2 = sendGiftResult;
                if (z10) {
                    LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
                    QuickGiftModel quickGift = fkLiveShowResult != null ? fkLiveShowResult.getQuickGift() : null;
                    if (quickGift != null) {
                        quickGift.setDiscountedPrice(null);
                    }
                    this.r(quickGiftModel.getGift().getImage());
                }
                p1.g.f52734a.W1(sendGiftResult2.getBalance());
                this.u();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.QuickGiftAnimationLayout$sendQuickGift$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                QuickGiftAnimationLayout.this.v();
                String a10 = com.cupidapp.live.base.network.j.f12008a.a(it);
                Integer valueOf = a10 != null ? Integer.valueOf(t.q(a10)) : null;
                int value = RequestErrorCode.InsufficientBalance.getValue();
                if (valueOf != null && valueOf.intValue() == value) {
                    EventBus.c().l(new OpenDiamondBalanceEvent());
                    return Boolean.TRUE;
                }
                int value2 = RequestErrorCode.QuickGiftSendFail.getValue();
                if (valueOf != null && valueOf.intValue() == value2) {
                    QuickGiftAnimationLayout.this.getQuickGift();
                }
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void r(ImageModel imageModel) {
        String url = imageModel.getUrl(z0.h.c(this, 224.0f));
        if (url == null) {
            return;
        }
        ImageLoaderUtil imageLoaderUtil = ImageLoaderUtil.f11832a;
        Context context = getContext();
        s.h(context, "context");
        ImageLoaderUtil.c(imageLoaderUtil, context, url, false, new Function1<Bitmap, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.QuickGiftAnimationLayout$showExplosionAnimation$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Bitmap bitmap) {
                s.i(bitmap, "bitmap");
                QuickGiftAnimationLayout quickGiftAnimationLayout = QuickGiftAnimationLayout.this;
                int i10 = R$id.explosion_animation_view;
                ((FKSVGAImageView) quickGiftAnimationLayout.e(i10)).setVisibility(0);
                FKSVGAImageView explosion_animation_view = (FKSVGAImageView) QuickGiftAnimationLayout.this.e(i10);
                s.h(explosion_animation_view, "explosion_animation_view");
                Map d10 = h0.d(kotlin.f.a("ic_gift", bitmap));
                final QuickGiftAnimationLayout quickGiftAnimationLayout2 = QuickGiftAnimationLayout.this;
                explosion_animation_view.G("anim_gift_boom.svga", (r23 & 2) != 0 ? null : null, (r23 & 4) != 0 ? -1 : 0, (r23 & 8) != 0 ? false : false, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? null : d10, (r23 & 256) == 0 ? 0 : 0, (r23 & 512) != 0 ? null : new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.QuickGiftAnimationLayout$showExplosionAnimation$1.1
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
                        ((FKSVGAImageView) QuickGiftAnimationLayout.this.e(R$id.explosion_animation_view)).setVisibility(8);
                    }
                }, (r23 & 1024) == 0 ? null : null);
            }
        }, 4, null);
    }

    public final void s(@NotNull final QuickGiftModel model, int i10) {
        s.i(model, "model");
        setVisibility(0);
        this.f15566j = i10;
        if (model.getDiscountedPrice() != null) {
            QuickGiftFirstSendLayout.a aVar = QuickGiftFirstSendLayout.f15570d;
            Context context = getContext();
            s.h(context, "context");
            ImageModel image = model.getGift().getImage();
            Integer discountedPrice = model.getDiscountedPrice();
            s.f(discountedPrice);
            aVar.a(context, image, discountedPrice.intValue(), model.getGift().getPrice(), new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.QuickGiftAnimationLayout$showQuickGiftAnimation$1
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
                    QuickGiftAnimationLayout.this.q(model, true);
                }
            });
            return;
        }
        p1.g gVar = p1.g.f52734a;
        if (s.d(gVar.d0().c(), Boolean.TRUE)) {
            QuickGiftSendConfirmLayout.a aVar2 = QuickGiftSendConfirmLayout.f15574d;
            Context context2 = getContext();
            s.h(context2, "context");
            aVar2.a(context2, model.getGift().getImage(), model.getGift().getPrice(), new Function1<Boolean, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.QuickGiftAnimationLayout$showQuickGiftAnimation$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return p.f51048a;
                }

                public final void invoke(boolean z10) {
                    p1.g gVar2 = p1.g.f52734a;
                    gVar2.d0().d(Boolean.valueOf(!z10));
                    if (gVar2.j() >= QuickGiftModel.this.getGift().getPrice()) {
                        this.q(QuickGiftModel.this, false);
                        this.t(QuickGiftModel.this.getGift().getImage());
                    } else {
                        EventBus.c().l(new OpenDiamondBalanceEvent());
                    }
                }
            });
            return;
        }
        if (gVar.j() >= model.getGift().getPrice()) {
            q(model, false);
            t(model.getGift().getImage());
        } else {
            EventBus.c().l(new OpenDiamondBalanceEvent());
        }
    }

    public final void setRefreshQuickGift(@Nullable Function1<? super QuickGiftModel, p> function1) {
        this.f15560d = function1;
    }

    public final void t(ImageModel imageModel) {
        int c4 = z0.h.c(this, 36.0f);
        Context context = getContext();
        s.h(context, "context");
        ImageLoaderView imageLoaderView = new ImageLoaderView(context);
        ((FrameLayout) e(R$id.quick_gift_container_layout)).addView(imageLoaderView, new FrameLayout.LayoutParams(c4, c4, 80));
        ImageLoaderView.g(imageLoaderView, imageModel, null, null, 6, null);
        float f10 = this.f15566j - (c4 / 2.0f);
        int nextInt = Random.Default.nextInt((-c4) / 2, z0.h.l(this) - (c4 / 2));
        AnimatorSet animatorSet = new AnimatorSet();
        float f11 = nextInt;
        animatorSet.playSequentially(o(imageLoaderView, f10, f11), l(imageLoaderView, f10, f11));
        AnimatorSet animatorSet2 = new AnimatorSet();
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = animatorSet;
        animatorArr[1] = m(imageLoaderView, f11 < f10);
        animatorSet2.playTogether(animatorArr);
        animatorSet2.addListener(new a(imageLoaderView));
        this.f15565i = animatorSet2;
        animatorSet2.start();
    }

    public final void u() {
        this.f15562f = true;
        com.cupidapp.live.base.utils.i iVar = this.f15563g;
        if (iVar != null) {
            iVar.g();
        }
        com.cupidapp.live.base.utils.i iVar2 = new com.cupidapp.live.base.utils.i();
        com.cupidapp.live.base.utils.i.d(iVar2, 10, 1, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.QuickGiftAnimationLayout$startCountDown$1$1
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
                QuickGiftAnimationLayout.this.f15562f = false;
            }
        }, null, 8, null);
        this.f15563g = iVar2;
    }

    public final void v() {
        com.cupidapp.live.base.utils.i iVar = this.f15563g;
        if (iVar != null) {
            iVar.g();
        }
        this.f15562f = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickGiftAnimationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15567k = new LinkedHashMap();
        this.f15561e = z0.h.c(this, 350.0f);
        this.f15564h = new AtomicInteger((int) (Math.random() * 10000));
        p();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickGiftAnimationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15567k = new LinkedHashMap();
        this.f15561e = z0.h.c(this, 350.0f);
        this.f15564h = new AtomicInteger((int) (Math.random() * 10000));
        p();
    }
}
