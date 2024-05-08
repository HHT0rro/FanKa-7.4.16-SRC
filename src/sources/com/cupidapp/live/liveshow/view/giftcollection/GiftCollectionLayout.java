package com.cupidapp.live.liveshow.view.giftcollection;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.liveshow.model.GiftCollectionItemModel;
import com.cupidapp.live.liveshow.model.GiftCollectionModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.util.locale.LanguageTag;
import z0.h;
import z0.m;
import z0.y;
import z0.z;

/* compiled from: GiftCollectionLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GiftCollectionLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public final int f15416b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public GiftCollectionModel f15417c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15418d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public ValueAnimator f15419e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15420f;

    /* compiled from: GiftCollectionLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            if (GiftCollectionLayout.this.f15418d) {
                ((TextView) GiftCollectionLayout.this.b(R$id.collection_num_text)).setVisibility(0);
                ((ImageView) GiftCollectionLayout.this.b(R$id.icon_arrow_view)).setPadding(h.c(this, 8.0f), h.c(this, 4.0f), h.c(this, 6.0f), h.c(this, 6.0f));
            }
            GiftCollectionLayout.this.f15418d = !r5.f15418d;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            s.i(animation, "animation");
            if (GiftCollectionLayout.this.f15418d) {
                return;
            }
            ((TextView) GiftCollectionLayout.this.b(R$id.collection_num_text)).setVisibility(8);
            ((ImageView) GiftCollectionLayout.this.b(R$id.icon_arrow_view)).setPadding(h.c(this, 6.0f), h.c(this, 6.0f), h.c(this, 8.0f), h.c(this, 2.0f));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftCollectionLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15420f = new LinkedHashMap();
        this.f15416b = h.c(this, 32.0f);
        this.f15418d = true;
        i();
    }

    public static final void k(GiftCollectionLayout this$0, ValueAnimator it) {
        s.i(this$0, "this$0");
        s.i(it, "it");
        LinearLayout gift_collection_layout = (LinearLayout) this$0.b(R$id.gift_collection_layout);
        s.h(gift_collection_layout, "gift_collection_layout");
        Object animatedValue = it.getAnimatedValue();
        s.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        y.o(gift_collection_layout, null, (Integer) animatedValue, 1, null);
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f15420f;
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

    public final void g(boolean z10) {
        GiftCollectionModel giftCollectionModel = this.f15417c;
        if (giftCollectionModel != null) {
            s.f(giftCollectionModel);
            List<GiftCollectionItemModel> images = giftCollectionModel.getImages();
            s.f(images);
            if (images.size() <= 3) {
                return;
            }
            if (z10 && !this.f15418d) {
                j();
            } else {
                if (z10 || !this.f15418d) {
                    return;
                }
                j();
            }
        }
    }

    public final void h(@Nullable GiftCollectionModel giftCollectionModel) {
        List<GiftCollectionItemModel> images = giftCollectionModel != null ? giftCollectionModel.getImages() : null;
        if (images == null || images.isEmpty()) {
            setVisibility(8);
            return;
        }
        this.f15417c = giftCollectionModel;
        setVisibility(0);
        if (images.size() > 3) {
            int i10 = R$id.icon_arrow_view;
            ((ImageView) b(i10)).setVisibility(0);
            int i11 = R$id.collection_num_text;
            ((TextView) b(i11)).setText(giftCollectionModel.getStatus());
            if (this.f15418d) {
                ((TextView) b(i11)).setVisibility(8);
                ((ImageView) b(i10)).setRotation(180.0f);
                ((ImageView) b(i10)).setPadding(h.c(this, 6.0f), h.c(this, 6.0f), h.c(this, 8.0f), h.c(this, 2.0f));
            } else {
                ((TextView) b(i11)).setVisibility(0);
                ((ImageView) b(i10)).setRotation(0.0f);
                ((ImageView) b(i10)).setPadding(h.c(this, 8.0f), h.c(this, 4.0f), h.c(this, 6.0f), h.c(this, 6.0f));
            }
        } else {
            ((TextView) b(R$id.collection_num_text)).setVisibility(8);
            ((ImageView) b(R$id.icon_arrow_view)).setVisibility(8);
        }
        int i12 = R$id.gift_collection_layout;
        ((LinearLayout) b(i12)).setPadding(0, 0, 0, images.size() > 3 ? 0 : h.c(this, 6.0f));
        ((LinearLayout) b(i12)).removeAllViews();
        for (GiftCollectionItemModel giftCollectionItemModel : images) {
            int i13 = R$id.gift_collection_layout;
            LinearLayout gift_collection_layout = (LinearLayout) b(i13);
            s.h(gift_collection_layout, "gift_collection_layout");
            View b4 = z.b(gift_collection_layout, R$layout.layout_gift_collection_item, false, 2, null);
            ImageLoaderView gift_imageview = (ImageLoaderView) b4.findViewById(R$id.gift_imageview);
            s.h(gift_imageview, "gift_imageview");
            ImageLoaderView.g(gift_imageview, giftCollectionItemModel.getImage(), null, null, 6, null);
            if (giftCollectionItemModel.getCount() != null && giftCollectionItemModel.getCount().intValue() > 0) {
                int i14 = R$id.gift_count_textview;
                ((TextView) b4.findViewById(i14)).setVisibility(0);
                ((TextView) b4.findViewById(i14)).setText(giftCollectionItemModel.getCount().intValue() > 99 ? m.d(giftCollectionItemModel.getCount().intValue()) : LanguageTag.PRIVATEUSE + ((Object) giftCollectionItemModel.getCount()));
            } else {
                ((TextView) b4.findViewById(R$id.gift_count_textview)).setVisibility(8);
            }
            ((LinearLayout) b(i13)).addView(b4);
        }
    }

    public final void i() {
        z.a(this, R$layout.layout_gift_collection, true);
        ((TextView) b(R$id.collection_num_text)).getPaint().setFakeBoldText(true);
        setVisibility(8);
        LinearLayout gift_collection_layout = (LinearLayout) b(R$id.gift_collection_layout);
        s.h(gift_collection_layout, "gift_collection_layout");
        y.d(gift_collection_layout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftcollection.GiftCollectionLayout$initView$1
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
                GiftCollectionModel giftCollectionModel;
                String tips;
                giftCollectionModel = GiftCollectionLayout.this.f15417c;
                if (giftCollectionModel == null || (tips = giftCollectionModel.getTips()) == null) {
                    return;
                }
                Context context = GiftCollectionLayout.this.getContext();
                s.h(context, "context");
                new ActivityDescriptionLayout(context).d(tips);
            }
        });
        ImageView icon_arrow_view = (ImageView) b(R$id.icon_arrow_view);
        s.h(icon_arrow_view, "icon_arrow_view");
        y.d(icon_arrow_view, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftcollection.GiftCollectionLayout$initView$2
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
                GiftCollectionLayout.this.j();
            }
        });
    }

    public final void j() {
        if (this.f15417c == null) {
            return;
        }
        ValueAnimator valueAnimator = this.f15419e;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        if (this.f15418d) {
            ((ImageView) b(R$id.icon_arrow_view)).setRotation(0.0f);
        } else {
            ((ImageView) b(R$id.icon_arrow_view)).setRotation(180.0f);
        }
        GiftCollectionModel giftCollectionModel = this.f15417c;
        s.f(giftCollectionModel);
        List<GiftCollectionItemModel> images = giftCollectionModel.getImages();
        s.f(images);
        int size = images.size();
        boolean z10 = this.f15418d;
        int i10 = this.f15416b;
        if (z10) {
            i10 *= size;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i10, z10 ? this.f15416b : size * this.f15416b);
        ofInt.setDuration(100L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.liveshow.view.giftcollection.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                GiftCollectionLayout.k(GiftCollectionLayout.this, valueAnimator2);
            }
        });
        ofInt.addListener(new a());
        this.f15419e = ofInt;
        ofInt.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f15419e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftCollectionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15420f = new LinkedHashMap();
        this.f15416b = h.c(this, 32.0f);
        this.f15418d = true;
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftCollectionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15420f = new LinkedHashMap();
        this.f15416b = h.c(this, 32.0f);
        this.f15418d = true;
        i();
    }
}
