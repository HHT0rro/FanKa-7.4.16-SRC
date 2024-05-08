package com.cupidapp.live.feed.layout;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.feed.model.AdTipModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FeedAdTipLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedAdTipLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public AdTipModel f14443d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f14444e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14445f;

    /* compiled from: Animator.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements Animator.AnimatorListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f14446b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FeedAdTipLayout f14447c;

        public a(String str, FeedAdTipLayout feedAdTipLayout) {
            this.f14446b = str;
            this.f14447c = feedAdTipLayout;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            kotlin.jvm.internal.s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            kotlin.jvm.internal.s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            kotlin.jvm.internal.s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            kotlin.jvm.internal.s.i(animator, "animator");
            String str = this.f14446b;
            int b4 = str != null ? com.cupidapp.live.base.utils.h.b(str) : -15066598;
            TextView textView = (TextView) this.f14447c.f(R$id.adTipTextView);
            if (textView != null) {
                textView.setTextColor(b4);
            }
            ImageView imageView = (ImageView) this.f14447c.f(R$id.adTipIndicator);
            if (imageView != null) {
                imageView.setImageDrawable(z0.i.f54815a.b(ContextCompat.getDrawable(this.f14447c.getContext(), R$mipmap.ic_feed_tip_arrow), b4));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedAdTipLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14445f = new LinkedHashMap();
        k();
    }

    public static final void i(FeedAdTipLayout this$0, String str, String str2) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ObjectAnimator colorAnimator = ObjectAnimator.ofArgb((RelativeLayout) this$0.f(R$id.feedAdTipLayout), "backgroundColor", -1, com.cupidapp.live.base.utils.h.b(str));
        colorAnimator.setDuration(300L);
        colorAnimator.setStartDelay(com.huawei.openalliance.ad.ipc.c.Code);
        kotlin.jvm.internal.s.h(colorAnimator, "colorAnimator");
        colorAnimator.addListener(new a(str2, this$0));
        colorAnimator.start();
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f14445f;
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

    public final void h() {
        Integer duration;
        AdTipModel adTipModel = this.f14443d;
        final String foregroundColor = adTipModel != null ? adTipModel.getForegroundColor() : null;
        AdTipModel adTipModel2 = this.f14443d;
        final String backgroundColor = adTipModel2 != null ? adTipModel2.getBackgroundColor() : null;
        AdTipModel adTipModel3 = this.f14443d;
        if (((adTipModel3 == null || (duration = adTipModel3.getDuration()) == null) ? 0 : duration.intValue()) > 0) {
            if (foregroundColor == null && backgroundColor == null) {
                return;
            }
            ((RelativeLayout) f(R$id.feedAdTipLayout)).post(new Runnable() { // from class: com.cupidapp.live.feed.layout.a
                @Override // java.lang.Runnable
                public final void run() {
                    FeedAdTipLayout.i(FeedAdTipLayout.this, backgroundColor, foregroundColor);
                }
            });
        }
    }

    public final void j(@NotNull AdTipModel model, boolean z10) {
        kotlin.jvm.internal.s.i(model, "model");
        this.f14443d = model;
        int i10 = R$id.adTipTextView;
        ((TextView) f(i10)).setText(model.getTitle());
        if (z10) {
            m(model.getForegroundColor(), model.getBackgroundColor());
        } else {
            ((TextView) f(i10)).setTextColor(-15066598);
            ((ImageView) f(R$id.adTipIndicator)).setImageResource(R$mipmap.ic_feed_tip_arrow);
            ((RelativeLayout) f(R$id.feedAdTipLayout)).setBackgroundColor(-1);
        }
        this.f14444e = false;
    }

    public final void k() {
        z.a(this, R$layout.layout_feed_ad_tip, true);
        TextView adTipTextView = (TextView) f(R$id.adTipTextView);
        kotlin.jvm.internal.s.h(adTipTextView, "adTipTextView");
        z0.u.a(adTipTextView);
        y.d(this, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedAdTipLayout$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                AdTipModel adTipModel;
                j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                Context context = FeedAdTipLayout.this.getContext();
                adTipModel = FeedAdTipLayout.this.f14443d;
                j.a.b(aVar, context, adTipModel != null ? adTipModel.getJumpUrl() : null, null, 4, null);
            }
        });
    }

    public final void l() {
        Integer duration;
        AdTipModel adTipModel = this.f14443d;
        if (((adTipModel == null || (duration = adTipModel.getDuration()) == null) ? 0 : duration.intValue()) <= 0 || this.f14444e) {
            return;
        }
        this.f14444e = true;
        h();
    }

    public final void m(String str, String str2) {
        int b4 = str != null ? com.cupidapp.live.base.utils.h.b(str) : -15066598;
        TextView textView = (TextView) f(R$id.adTipTextView);
        if (textView != null) {
            textView.setTextColor(b4);
        }
        ImageView imageView = (ImageView) f(R$id.adTipIndicator);
        if (imageView != null) {
            imageView.setImageDrawable(z0.i.f54815a.b(ContextCompat.getDrawable(getContext(), R$mipmap.ic_feed_tip_arrow), b4));
        }
        ((RelativeLayout) f(R$id.feedAdTipLayout)).setBackgroundColor(str2 != null ? com.cupidapp.live.base.utils.h.b(str2) : -1);
        this.f14444e = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedAdTipLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14445f = new LinkedHashMap();
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedAdTipLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14445f = new LinkedHashMap();
        k();
    }
}
