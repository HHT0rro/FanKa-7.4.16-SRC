package com.cupidapp.live.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.viewpager.widget.ViewPager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.match.view.NearByGuideView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: FKViewPagerTitleLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKViewPagerTitleLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public p f12530b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public List<TextView> f12531c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public List<ImageView> f12532d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public List<TextView> f12533e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public List<ImageView> f12534f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public List<View> f12535g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public List<NearByGuideView> f12536h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public Function2<? super Integer, ? super Boolean, kotlin.p> f12537i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public Function1<? super Integer, kotlin.p> f12538j;

    /* renamed from: k, reason: collision with root package name */
    public final int f12539k;

    /* renamed from: l, reason: collision with root package name */
    @ColorInt
    public int f12540l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12541m;

    /* compiled from: FKViewPagerTitleLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements com.cupidapp.live.match.view.q {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NearByGuideView f12542a;

        public a(NearByGuideView nearByGuideView) {
            this.f12542a = nearByGuideView;
        }

        @Override // com.cupidapp.live.match.view.q
        public void a() {
            this.f12542a.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKViewPagerTitleLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12541m = new LinkedHashMap();
        this.f12531c = new ArrayList();
        this.f12532d = new ArrayList();
        this.f12533e = new ArrayList();
        this.f12534f = new ArrayList();
        this.f12535g = new ArrayList();
        this.f12536h = new ArrayList();
        this.f12539k = z0.h.c(this, 10.0f);
        this.f12540l = -15066598;
        u();
    }

    public static final void D(FKViewPagerTitleLayout this$0, int i10) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        View childAt = ((LinearLayout) this$0.d(R$id.textViewLinearLayout)).getChildAt(i10);
        int i11 = R$id.viewpager_title_root_scroll_view;
        ((HorizontalScrollView) this$0.d(i11)).smoothScrollTo((childAt.getLeft() + (childAt.getWidth() / 2)) - (((HorizontalScrollView) this$0.d(i11)).getWidth() / 2), 0);
    }

    public static final void k(FKViewPagerTitleLayout this$0, int i10) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.o(i10, 0.0f);
    }

    public static final void m(NearByGuideView guideView, Function0 clickCallback, View view) {
        kotlin.jvm.internal.s.i(guideView, "$guideView");
        kotlin.jvm.internal.s.i(clickCallback, "$clickCallback");
        guideView.e();
        clickCallback.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentItem(int i10) {
        int i11 = 0;
        for (TextView textView : this.f12531c) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.s.s();
            }
            TextView textView2 = textView;
            p pVar = null;
            if (i11 == i10) {
                p pVar2 = this.f12530b;
                if (pVar2 == null) {
                    kotlin.jvm.internal.s.A("titleStyle");
                } else {
                    pVar = pVar2;
                }
                textView2.setTextColor(pVar.a());
            } else {
                p pVar3 = this.f12530b;
                if (pVar3 == null) {
                    kotlin.jvm.internal.s.A("titleStyle");
                } else {
                    pVar = pVar3;
                }
                textView2.setTextColor(pVar.e());
                u.e(textView2, 0, 0, 0, 0, 11, null);
            }
            i11 = i12;
        }
    }

    private final void setViewPagerOnPageChangeListener(ViewPager viewPager) {
        viewPager.clearOnPageChangeListeners();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.cupidapp.live.base.view.FKViewPagerTitleLayout$setViewPagerOnPageChangeListener$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i10) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i10, float f10, int i11) {
                if (f10 > 0.5f) {
                    FKViewPagerTitleLayout.this.E(i10, f10);
                } else {
                    FKViewPagerTitleLayout.this.o(i10, f10);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i10) {
                FKViewPagerTitleLayout.this.C(i10);
                Function1<Integer, kotlin.p> pageChangedCallBack = FKViewPagerTitleLayout.this.getPageChangedCallBack();
                if (pageChangedCallBack != null) {
                    pageChangedCallBack.invoke(Integer.valueOf(i10));
                }
                FKViewPagerTitleLayout.this.setCurrentItem(i10);
            }
        });
    }

    public final void A(int i10, @DrawableRes int i11) {
        if (i10 < this.f12532d.size() && i10 < this.f12533e.size()) {
            ImageView imageView = this.f12532d.get(i10);
            if (i11 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setImageResource(i11);
                imageView.setVisibility(0);
            }
        }
    }

    public final void B(int i10, int i11) {
        if (i10 >= this.f12533e.size()) {
            return;
        }
        TextView textView = this.f12533e.get(i10);
        if (i11 > 0) {
            textView.setVisibility(0);
            textView.setText(z0.m.d(i11));
        } else {
            textView.setVisibility(8);
        }
    }

    public final void C(final int i10) {
        ((HorizontalScrollView) d(R$id.viewpager_title_root_scroll_view)).post(new Runnable() { // from class: com.cupidapp.live.base.view.k
            @Override // java.lang.Runnable
            public final void run() {
                FKViewPagerTitleLayout.D(FKViewPagerTitleLayout.this, i10);
            }
        });
    }

    public final void E(int i10, float f10) {
        ((FKDynamicLine) d(R$id.dynamicLineView)).c(s(i10) + ((f10 - 0.5f) * 2 * p(i10)), s(i10 + 1) + this.f12539k, this.f12540l);
    }

    @Nullable
    public View d(int i10) {
        Map<Integer, View> map = this.f12541m;
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
    public final Function1<Integer, kotlin.p> getPageChangedCallBack() {
        return this.f12538j;
    }

    @Nullable
    public final Function2<Integer, Boolean, kotlin.p> getTabClickCallBack() {
        return this.f12537i;
    }

    public final void i(boolean z10) {
        p pVar = this.f12530b;
        if (pVar == null) {
            kotlin.jvm.internal.s.A("titleStyle");
            pVar = null;
        }
        pVar.g(z10);
        ((FKDynamicLine) d(R$id.dynamicLineView)).setVisibility(z10 ? 0 : 4);
    }

    public final void j(final int i10, @NotNull String value, boolean z10) {
        kotlin.jvm.internal.s.i(value, "value");
        if (i10 >= this.f12531c.size()) {
            return;
        }
        this.f12531c.get(i10).setText(value);
        if (z10) {
            return;
        }
        this.f12531c.get(i10).post(new Runnable() { // from class: com.cupidapp.live.base.view.j
            @Override // java.lang.Runnable
            public final void run() {
                FKViewPagerTitleLayout.k(FKViewPagerTitleLayout.this, i10);
            }
        });
    }

    public final void l(int i10, @NotNull ImageModel avatar, int i11, @NotNull final Function0<kotlin.p> clickCallback) {
        kotlin.jvm.internal.s.i(avatar, "avatar");
        kotlin.jvm.internal.s.i(clickCallback, "clickCallback");
        if (i10 >= this.f12536h.size() || i10 >= this.f12531c.size()) {
            return;
        }
        final NearByGuideView nearByGuideView = this.f12536h.get(i10);
        nearByGuideView.d(avatar, i11, this.f12531c.get(i10), new a(nearByGuideView));
        nearByGuideView.setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.base.view.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FKViewPagerTitleLayout.m(NearByGuideView.this, clickCallback, view);
            }
        });
    }

    public final void n(List<String> list, final ViewPager viewPager) {
        ((LinearLayout) d(R$id.textViewLinearLayout)).removeAllViews();
        this.f12531c.clear();
        this.f12532d.clear();
        this.f12533e.clear();
        this.f12534f.clear();
        this.f12535g.clear();
        this.f12536h.clear();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            p pVar = null;
            View b4 = z.b(this, R$layout.layout_single_title, false, 2, null);
            b4.setTag(Integer.valueOf(i10));
            y.d(b4, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.base.view.FKViewPagerTitleLayout$createTextViews$singleTitleLayout$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    Object tag = view != null ? view.getTag() : null;
                    Integer num = tag instanceof Integer ? (Integer) tag : null;
                    int intValue = num != null ? num.intValue() : 0;
                    ViewPager viewPager2 = ViewPager.this;
                    boolean z10 = (viewPager2 != null ? viewPager2.getCurrentItem() : 0) != intValue;
                    ViewPager viewPager3 = ViewPager.this;
                    if (viewPager3 == null) {
                        this.w(intValue);
                    } else {
                        viewPager3.setCurrentItem(intValue);
                    }
                    Function2<Integer, Boolean, kotlin.p> tabClickCallBack = this.getTabClickCallBack();
                    if (tabClickCallBack != null) {
                        tabClickCallBack.mo1743invoke(Integer.valueOf(intValue), Boolean.valueOf(z10));
                    }
                }
            });
            TextView singleTitleTextView = (TextView) b4.findViewById(R$id.singleTitleTextView);
            singleTitleTextView.setText(list.get(i10));
            p pVar2 = this.f12530b;
            if (pVar2 == null) {
                kotlin.jvm.internal.s.A("titleStyle");
            } else {
                pVar = pVar2;
            }
            singleTitleTextView.setTextSize(pVar.c());
            TextView unreadTextView = (TextView) b4.findViewById(R$id.unreadTextView);
            View redTextView = b4.findViewById(R$id.title_red_tips_view);
            ImageView tagView = (ImageView) b4.findViewById(R$id.tag_view);
            ImageView titleArrowView = (ImageView) b4.findViewById(R$id.title_arrow_img);
            NearByGuideView nearbyGuideView = (NearByGuideView) b4.findViewById(R$id.nearby_guide_view);
            ((LinearLayout) d(R$id.textViewLinearLayout)).addView(b4);
            List<TextView> list2 = this.f12531c;
            kotlin.jvm.internal.s.h(singleTitleTextView, "singleTitleTextView");
            list2.add(singleTitleTextView);
            List<ImageView> list3 = this.f12532d;
            kotlin.jvm.internal.s.h(titleArrowView, "titleArrowView");
            list3.add(titleArrowView);
            List<TextView> list4 = this.f12533e;
            kotlin.jvm.internal.s.h(unreadTextView, "unreadTextView");
            list4.add(unreadTextView);
            List<ImageView> list5 = this.f12534f;
            kotlin.jvm.internal.s.h(tagView, "tagView");
            list5.add(tagView);
            List<View> list6 = this.f12535g;
            kotlin.jvm.internal.s.h(redTextView, "redTextView");
            list6.add(redTextView);
            List<NearByGuideView> list7 = this.f12536h;
            kotlin.jvm.internal.s.h(nearbyGuideView, "nearbyGuideView");
            list7.add(nearbyGuideView);
        }
    }

    public final void o(int i10, float f10) {
        ((FKDynamicLine) d(R$id.dynamicLineView)).c(s(i10), this.f12539k + r0 + (f10 * 2 * p(i10)), this.f12540l);
    }

    public final int p(int i10) {
        return q(i10) + q(i10 + 1) + this.f12539k;
    }

    public final int q(int i10) {
        if (i10 < this.f12531c.size()) {
            return (r(i10) - this.f12539k) / 2;
        }
        return 0;
    }

    public final int r(int i10) {
        if (i10 >= this.f12531c.size()) {
            return 0;
        }
        TextView textView = (TextView) ((LinearLayout) d(R$id.textViewLinearLayout)).getChildAt(i10).findViewById(R$id.singleTitleTextView);
        int width = textView.getWidth();
        if (width != 0) {
            return width;
        }
        textView.measure(View.MeasureSpec.makeMeasureSpec(z0.h.l(this), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(z0.h.k(this), Integer.MIN_VALUE));
        return textView.getMeasuredWidth();
    }

    public final int s(int i10) {
        if (i10 >= this.f12531c.size()) {
            return 0;
        }
        int q10 = q(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            q10 += r(i11);
        }
        return q10;
    }

    public final void setCheckColorAndUnCheckColor(@ColorInt int i10, @ColorInt int i11, @ColorInt int i12) {
        p pVar = this.f12530b;
        p pVar2 = null;
        if (pVar == null) {
            kotlin.jvm.internal.s.A("titleStyle");
            pVar = null;
        }
        pVar.f(i10);
        p pVar3 = this.f12530b;
        if (pVar3 == null) {
            kotlin.jvm.internal.s.A("titleStyle");
        } else {
            pVar2 = pVar3;
        }
        pVar2.h(i11);
        this.f12540l = i12;
    }

    public final void setPageChangedCallBack(@Nullable Function1<? super Integer, kotlin.p> function1) {
        this.f12538j = function1;
    }

    public final void setTabClickCallBack(@Nullable Function2<? super Integer, ? super Boolean, kotlin.p> function2) {
        this.f12537i = function2;
    }

    @Nullable
    public final View t(int i10) {
        if (i10 >= 0) {
            int i11 = R$id.textViewLinearLayout;
            if (i10 < ((LinearLayout) d(i11)).getChildCount()) {
                return ((LinearLayout) d(i11)).getChildAt(i10);
            }
        }
        return null;
    }

    public final void u() {
        z.a(this, R$layout.layout_viewpager_title, true);
    }

    public final void v(@NotNull p titleStyle, @Nullable ViewPager viewPager, int i10) {
        kotlin.jvm.internal.s.i(titleStyle, "titleStyle");
        this.f12530b = titleStyle;
        n(titleStyle.d(), viewPager);
        if (viewPager == null) {
            w(i10);
        } else {
            setCurrentItem(i10);
            setViewPagerOnPageChangeListener(viewPager);
        }
        ((FKDynamicLine) d(R$id.dynamicLineView)).setVisibility(titleStyle.b() ? 0 : 4);
    }

    public final void w(int i10) {
        o(i10, 0.0f);
        setCurrentItem(i10);
    }

    public final boolean x(int i10) {
        return i10 < this.f12535g.size() && this.f12535g.get(i10).getVisibility() == 0;
    }

    public final void y(int i10, boolean z10) {
        if (i10 >= this.f12534f.size()) {
            return;
        }
        ImageView imageView = this.f12534f.get(i10);
        if (z10) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public final void z(int i10, boolean z10) {
        if (i10 >= this.f12535g.size()) {
            return;
        }
        this.f12535g.get(i10).setVisibility(z10 ? 0 : 8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKViewPagerTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12541m = new LinkedHashMap();
        this.f12531c = new ArrayList();
        this.f12532d = new ArrayList();
        this.f12533e = new ArrayList();
        this.f12534f = new ArrayList();
        this.f12535g = new ArrayList();
        this.f12536h = new ArrayList();
        this.f12539k = z0.h.c(this, 10.0f);
        this.f12540l = -15066598;
        u();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKViewPagerTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12541m = new LinkedHashMap();
        this.f12531c = new ArrayList();
        this.f12532d = new ArrayList();
        this.f12533e = new ArrayList();
        this.f12534f = new ArrayList();
        this.f12535g = new ArrayList();
        this.f12536h = new ArrayList();
        this.f12539k = z0.h.c(this, 10.0f);
        this.f12540l = -15066598;
        u();
    }
}
