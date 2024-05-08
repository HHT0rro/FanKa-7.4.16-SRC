package com.cupidapp.live.base.view.title;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.RawRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$styleable;
import com.cupidapp.live.base.view.FKViewPagerTitleLayout;
import com.cupidapp.live.base.view.animation.FKLottieAnimationView;
import com.cupidapp.live.base.view.p;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: MultiPageTitleBarLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPageTitleBarLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12942b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPageTitleBarLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12942b = new LinkedHashMap();
        f(this, context, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(MultiPageTitleBarLayout multiPageTitleBarLayout, p pVar, ViewPager viewPager, int i10, Function1 function1, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        if ((i11 & 8) != 0) {
            function1 = null;
        }
        multiPageTitleBarLayout.c(pVar, viewPager, i10, function1);
    }

    public static /* synthetic */ void f(MultiPageTitleBarLayout multiPageTitleBarLayout, Context context, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            attributeSet = null;
        }
        multiPageTitleBarLayout.e(context, attributeSet);
    }

    public static /* synthetic */ void setRightThirdLottieImg$default(MultiPageTitleBarLayout multiPageTitleBarLayout, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        multiPageTitleBarLayout.setRightThirdLottieImg(i10, z10);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f12942b;
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

    public final void b(boolean z10) {
        if (z10) {
            ((FrameLayout) a(R$id.multi_page_right_third_layout)).setVisibility(0);
            ((ImageView) a(R$id.multi_page_right_third_img)).setVisibility(0);
            ((FKLottieAnimationView) a(R$id.multi_page_right_third_lottie)).setVisibility(8);
        } else {
            ((FrameLayout) a(R$id.multi_page_right_third_layout)).setVisibility(0);
            ((ImageView) a(R$id.multi_page_right_third_img)).setVisibility(8);
            ((FKLottieAnimationView) a(R$id.multi_page_right_third_lottie)).setVisibility(0);
        }
    }

    public final void c(@NotNull p titleStyle, @Nullable ViewPager viewPager, int i10, @Nullable Function1<? super Integer, kotlin.p> function1) {
        s.i(titleStyle, "titleStyle");
        int i11 = R$id.multi_page_title_layout;
        ((FKViewPagerTitleLayout) a(i11)).setVisibility(0);
        ((FKViewPagerTitleLayout) a(i11)).v(titleStyle, viewPager, i10);
        if (viewPager != null) {
            ((FKViewPagerTitleLayout) a(i11)).setPageChangedCallBack(function1);
        }
    }

    public final void e(Context context, AttributeSet attributeSet) {
        z.a(this, R$layout.layout_multi_page_title_bar, true);
        ConstraintLayout multi_page_title_root_layout = (ConstraintLayout) a(R$id.multi_page_title_root_layout);
        s.h(multi_page_title_root_layout, "multi_page_title_root_layout");
        com.cupidapp.live.base.view.s.b(context, multi_page_title_root_layout);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MultiPageTitleBarLayout);
        s.h(obtainStyledAttributes, "context.obtainStyledAttr….MultiPageTitleBarLayout)");
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            int i10 = R$id.multi_page_right_first_img;
            ((ImageView) a(i10)).setImageResource(resourceId);
            ((ImageView) a(i10)).setVisibility(0);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId2 != 0) {
            int i11 = R$id.multi_page_right_second_img;
            ((ImageView) a(i11)).setImageResource(resourceId2);
            ((ImageView) a(i11)).setVisibility(0);
        }
        int resourceId3 = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId3 != 0) {
            ((ImageView) a(R$id.multi_page_right_third_img)).setImageResource(resourceId3);
            b(true);
        }
        obtainStyledAttributes.recycle();
    }

    public final void g(boolean z10) {
        View first_red_dot_view = a(R$id.first_red_dot_view);
        s.h(first_red_dot_view, "first_red_dot_view");
        first_red_dot_view.setVisibility(z10 ? 0 : 8);
    }

    public final void h(boolean z10) {
        View second_red_dot_view = a(R$id.second_red_dot_view);
        s.h(second_red_dot_view, "second_red_dot_view");
        second_red_dot_view.setVisibility(z10 ? 0 : 8);
    }

    public final void setRightFirstImgClickEvent(@NotNull Function1<? super View, kotlin.p> clickCallBack) {
        s.i(clickCallBack, "clickCallBack");
        ImageView multi_page_right_first_img = (ImageView) a(R$id.multi_page_right_first_img);
        s.h(multi_page_right_first_img, "multi_page_right_first_img");
        y.d(multi_page_right_first_img, clickCallBack);
    }

    public final void setRightSecondImgClickEvent(@NotNull Function1<? super View, kotlin.p> clickCallBack) {
        s.i(clickCallBack, "clickCallBack");
        ImageView multi_page_right_second_img = (ImageView) a(R$id.multi_page_right_second_img);
        s.h(multi_page_right_second_img, "multi_page_right_second_img");
        y.d(multi_page_right_second_img, clickCallBack);
    }

    public final void setRightThirdImgClickEvent(@NotNull Function1<? super View, kotlin.p> clickCallBack) {
        s.i(clickCallBack, "clickCallBack");
        FrameLayout multi_page_right_third_layout = (FrameLayout) a(R$id.multi_page_right_third_layout);
        s.h(multi_page_right_third_layout, "multi_page_right_third_layout");
        y.d(multi_page_right_third_layout, clickCallBack);
    }

    public final void setRightThirdLottieImg(@RawRes int i10, boolean z10) {
        b(false);
        FKLottieAnimationView fKLottieAnimationView = (FKLottieAnimationView) a(R$id.multi_page_right_third_lottie);
        fKLottieAnimationView.setLottieAnimation(i10);
        fKLottieAnimationView.setRepeatCount(z10 ? -1 : 0);
        fKLottieAnimationView.L();
    }

    public final void setViewPagerTitleUnreadCount(int i10, int i11) {
        ((FKViewPagerTitleLayout) a(R$id.multi_page_title_layout)).B(i10, i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPageTitleBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12942b = new LinkedHashMap();
        e(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPageTitleBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12942b = new LinkedHashMap();
        e(context, attributeSet);
    }
}
