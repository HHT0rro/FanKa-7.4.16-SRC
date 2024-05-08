package com.cupidapp.live.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$styleable;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.main.view.FKUnreadCountTextView;
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

/* compiled from: FKTitleBarLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKTitleBarLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public ImageModel f12527b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12528c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKTitleBarLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12528c = new LinkedHashMap();
        i(this, context, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(FKTitleBarLayout fKTitleBarLayout, p pVar, ViewPager viewPager, int i10, Function1 function1, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        if ((i11 & 8) != 0) {
            function1 = null;
        }
        fKTitleBarLayout.e(pVar, viewPager, i10, function1);
    }

    public static /* synthetic */ void i(FKTitleBarLayout fKTitleBarLayout, Context context, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            attributeSet = null;
        }
        fKTitleBarLayout.h(context, attributeSet);
    }

    public static /* synthetic */ void setRightText$default(FKTitleBarLayout fKTitleBarLayout, String str, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = -49088;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        if ((i12 & 8) != 0) {
            z10 = true;
        }
        fKTitleBarLayout.setRightText(str, i10, i11, z10);
    }

    public static /* synthetic */ void setSingleTitle$default(FKTitleBarLayout fKTitleBarLayout, String str, Integer num, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            num = null;
        }
        fKTitleBarLayout.setSingleTitle(str, num);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f12528c;
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
        ((FKViewPagerTitleLayout) a(R$id.viewPagerTitleLayout)).i(z10);
    }

    public final void c(int i10, @NotNull String value, boolean z10) {
        kotlin.jvm.internal.s.i(value, "value");
        ((FKViewPagerTitleLayout) a(R$id.viewPagerTitleLayout)).j(i10, value, z10);
    }

    public final void d(int i10, @NotNull ImageModel avatar, int i11, @NotNull Function0<kotlin.p> clickCallback) {
        kotlin.jvm.internal.s.i(avatar, "avatar");
        kotlin.jvm.internal.s.i(clickCallback, "clickCallback");
        ((FKViewPagerTitleLayout) a(R$id.viewPagerTitleLayout)).l(i10, avatar, i11, clickCallback);
    }

    public final void e(@NotNull p titleStyle, @Nullable ViewPager viewPager, int i10, @Nullable Function1<? super Integer, kotlin.p> function1) {
        kotlin.jvm.internal.s.i(titleStyle, "titleStyle");
        int i11 = R$id.viewPagerTitleLayout;
        ((FKViewPagerTitleLayout) a(i11)).setVisibility(0);
        FKViewPagerTitleLayout fKViewPagerTitleLayout = (FKViewPagerTitleLayout) a(i11);
        fKViewPagerTitleLayout.v(titleStyle, viewPager, i10);
        if (viewPager != null) {
            fKViewPagerTitleLayout.setPageChangedCallBack(function1);
        }
    }

    @Nullable
    public final View g(int i10) {
        FKViewPagerTitleLayout fKViewPagerTitleLayout = (FKViewPagerTitleLayout) a(R$id.viewPagerTitleLayout);
        if (fKViewPagerTitleLayout != null) {
            return fKViewPagerTitleLayout.t(i10);
        }
        return null;
    }

    @Nullable
    public final View getFirstRightImage() {
        return (ImageView) a(R$id.rightFirstImageView);
    }

    @Nullable
    public final View getRightImage() {
        return (ImageView) a(R$id.rightImageView);
    }

    @NotNull
    public final List<Float> getRightImageLocation() {
        ((ImageLoaderView) a(R$id.right_image_loader_view)).getLocationInWindow(new int[2]);
        return kotlin.collections.s.m(Float.valueOf(r1[0] + (((ImageLoaderView) a(r2)).getWidth() / 2)), Float.valueOf(r1[1] + (((ImageLoaderView) a(r2)).getHeight() / 2)));
    }

    @NotNull
    public final TextView getRightTextView() {
        TextView rightTextView = (TextView) a(R$id.rightTextView);
        kotlin.jvm.internal.s.h(rightTextView, "rightTextView");
        return rightTextView;
    }

    @NotNull
    public final String getSingleTitle() {
        return ((TextView) a(R$id.singleTitleTextView)).getText().toString();
    }

    @NotNull
    public final View getTitleView() {
        FKViewPagerTitleLayout viewPagerTitleLayout = (FKViewPagerTitleLayout) a(R$id.viewPagerTitleLayout);
        kotlin.jvm.internal.s.h(viewPagerTitleLayout, "viewPagerTitleLayout");
        return viewPagerTitleLayout;
    }

    public final void h(Context context, AttributeSet attributeSet) {
        z.a(this, 2131559370, true);
        int i10 = R$id.titleBarContainerLayout;
        ConstraintLayout titleBarContainerLayout = (ConstraintLayout) a(i10);
        kotlin.jvm.internal.s.h(titleBarContainerLayout, "titleBarContainerLayout");
        s.b(context, titleBarContainerLayout);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FKTitleBarLayout);
        kotlin.jvm.internal.s.h(obtainStyledAttributes, "context.obtainStyledAttr…yleable.FKTitleBarLayout)");
        int resourceId = obtainStyledAttributes.getResourceId(7, 0);
        if (resourceId != 0) {
            int i11 = R$id.singleTitleTextView;
            ((TextView) a(i11)).getPaint().setFakeBoldText(true);
            ((TextView) a(i11)).setVisibility(0);
            ((TextView) a(i11)).setText(context.getString(resourceId));
        }
        ((TextView) a(R$id.singleTitleTextView)).setTextColor(obtainStyledAttributes.getColor(8, -15066598));
        int resourceId2 = obtainStyledAttributes.getResourceId(0, R$mipmap.icon_goback_black);
        int i12 = R$id.leftImageView;
        ((ImageView) a(i12)).setImageResource(resourceId2);
        ((ImageView) a(i12)).setVisibility(obtainStyledAttributes.getBoolean(1, true) ? 0 : 8);
        int resourceId3 = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId3 != 0) {
            int i13 = R$id.leftSpareImageView;
            ((ImageView) a(i13)).setImageResource(resourceId3);
            ((ImageView) a(i13)).setVisibility(0);
        }
        int resourceId4 = obtainStyledAttributes.getResourceId(6, 0);
        if (resourceId4 != 0) {
            int i14 = R$id.rightImageView;
            ((ImageView) a(i14)).setImageResource(resourceId4);
            ((ImageView) a(i14)).setVisibility(0);
        }
        int resourceId5 = obtainStyledAttributes.getResourceId(5, 0);
        if (resourceId5 != 0) {
            int i15 = R$id.rightFirstImageView;
            ((ImageView) a(i15)).setImageResource(resourceId5);
            ((ImageView) a(i15)).setVisibility(0);
        }
        int color = obtainStyledAttributes.getColor(4, -49088);
        int i16 = R$id.rightTextView;
        ((TextView) a(i16)).setTextColor(color);
        int resourceId6 = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId6 != 0) {
            ((TextView) a(i16)).getPaint().setFakeBoldText(true);
            ((TextView) a(i16)).setText(context.getString(resourceId6, ""));
            ((TextView) a(i16)).setVisibility(0);
        }
        ((ConstraintLayout) a(i10)).setBackgroundColor(obtainStyledAttributes.getColor(9, -1));
        obtainStyledAttributes.recycle();
    }

    public final boolean j(int i10) {
        return ((FKViewPagerTitleLayout) a(R$id.viewPagerTitleLayout)).x(i10);
    }

    public final void k() {
        int i10 = R$id.titleBarContainerLayout;
        ViewGroup.LayoutParams layoutParams = ((ConstraintLayout) a(i10)).getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = 0;
        }
        ((ConstraintLayout) a(i10)).setLayoutParams(marginLayoutParams);
    }

    public final void l() {
        int i10 = R$id.title_right_rl;
        ((RelativeLayout) a(i10)).removeAllViews();
        ((RelativeLayout) a(i10)).setVisibility(8);
    }

    public final void m(int i10, @DrawableRes int i11) {
        ((FKViewPagerTitleLayout) a(R$id.viewPagerTitleLayout)).A(i10, i11);
    }

    public final void setFirstRightImageClickEvent(@NotNull Function1<? super View, kotlin.p> clickCallBack) {
        kotlin.jvm.internal.s.i(clickCallBack, "clickCallBack");
        ImageView rightFirstImageView = (ImageView) a(R$id.rightFirstImageView);
        kotlin.jvm.internal.s.h(rightFirstImageView, "rightFirstImageView");
        y.d(rightFirstImageView, clickCallBack);
    }

    public final void setFirstRightImageRes(@DrawableRes int i10) {
        ((ImageView) a(R$id.rightFirstImageView)).setImageResource(i10);
    }

    public final void setFirstRightImageVisible(boolean z10) {
        ((ImageView) a(R$id.rightFirstImageView)).setVisibility(z10 ? 0 : 8);
    }

    public final void setLeftImageClickEvent(@NotNull Function1<? super View, kotlin.p> clickCallBack) {
        kotlin.jvm.internal.s.i(clickCallBack, "clickCallBack");
        ImageView leftImageView = (ImageView) a(R$id.leftImageView);
        kotlin.jvm.internal.s.h(leftImageView, "leftImageView");
        y.d(leftImageView, clickCallBack);
    }

    public final void setLeftImageDrawable(@Nullable Drawable drawable) {
        ((ImageView) a(R$id.leftImageView)).setImageDrawable(drawable);
    }

    public final void setLeftImageEndText(@NotNull String text, @ColorInt int i10, boolean z10, float f10, int i11) {
        kotlin.jvm.internal.s.i(text, "text");
        TextView setLeftImageEndText$lambda$11 = (TextView) a(R$id.left_image_end_text);
        setLeftImageEndText$lambda$11.setVisibility(0);
        setLeftImageEndText$lambda$11.setText(text);
        setLeftImageEndText$lambda$11.setTextColor(i10);
        if (z10) {
            kotlin.jvm.internal.s.h(setLeftImageEndText$lambda$11, "setLeftImageEndText$lambda$11");
            u.a(setLeftImageEndText$lambda$11);
        }
        setLeftImageEndText$lambda$11.setTextSize(f10);
        setLeftImageEndText$lambda$11.setPadding(i11, 0, i11, 0);
    }

    public final void setLeftImageEndTextClickEvent(@NotNull Function1<? super View, kotlin.p> clickCallBack) {
        kotlin.jvm.internal.s.i(clickCallBack, "clickCallBack");
        TextView left_image_end_text = (TextView) a(R$id.left_image_end_text);
        kotlin.jvm.internal.s.h(left_image_end_text, "left_image_end_text");
        y.d(left_image_end_text, clickCallBack);
    }

    public final void setLeftImageRes(@DrawableRes int i10) {
        ((ImageView) a(R$id.leftImageView)).setImageResource(i10);
    }

    public final void setLeftImageUnreadCount(int i10) {
        ((FKUnreadCountTextView) a(R$id.leftImageUnreadCountTextView)).setUnreadCount(i10);
    }

    public final void setLeftImageVisible(boolean z10) {
        ((ImageView) a(R$id.leftImageView)).setVisibility(z10 ? 0 : 8);
    }

    public final void setLeftSpareImageClickEvent(@NotNull Function1<? super View, kotlin.p> clickCallBack) {
        kotlin.jvm.internal.s.i(clickCallBack, "clickCallBack");
        ImageView leftSpareImageView = (ImageView) a(R$id.leftSpareImageView);
        kotlin.jvm.internal.s.h(leftSpareImageView, "leftSpareImageView");
        y.d(leftSpareImageView, clickCallBack);
    }

    public final void setLeftSpareImageRes(@DrawableRes int i10) {
        int i11 = R$id.leftSpareImageView;
        ((ImageView) a(i11)).setVisibility(0);
        ((ImageView) a(i11)).setImageResource(i10);
    }

    public final void setLeftSpareVisible(boolean z10) {
        ((ImageView) a(R$id.leftSpareImageView)).setVisibility(z10 ? 0 : 8);
    }

    public final void setRightImageClickEvent(@NotNull Function1<? super View, kotlin.p> clickCallBack) {
        kotlin.jvm.internal.s.i(clickCallBack, "clickCallBack");
        ImageView rightImageView = (ImageView) a(R$id.rightImageView);
        kotlin.jvm.internal.s.h(rightImageView, "rightImageView");
        y.d(rightImageView, clickCallBack);
    }

    public final void setRightImageDrawable(@Nullable Drawable drawable) {
        ((ImageView) a(R$id.rightImageView)).setImageDrawable(drawable);
    }

    public final void setRightImageLoaderClickEvent(@NotNull Function1<? super View, kotlin.p> clickCallBack) {
        kotlin.jvm.internal.s.i(clickCallBack, "clickCallBack");
        ImageLoaderView right_image_loader_view = (ImageLoaderView) a(R$id.right_image_loader_view);
        kotlin.jvm.internal.s.h(right_image_loader_view, "right_image_loader_view");
        y.d(right_image_loader_view, clickCallBack);
    }

    public final void setRightImageLoaderView(@Nullable ImageModel imageModel) {
        if (imageModel == null) {
            int i10 = R$id.right_image_loader_view;
            ImageLoaderView right_image_loader_view = (ImageLoaderView) a(i10);
            kotlin.jvm.internal.s.h(right_image_loader_view, "right_image_loader_view");
            ImageLoaderView.g(right_image_loader_view, null, null, null, 6, null);
            ((ImageLoaderView) a(i10)).setVisibility(8);
        } else if (!kotlin.jvm.internal.s.d(this.f12527b, imageModel)) {
            int i11 = R$id.right_image_loader_view;
            ((ImageLoaderView) a(i11)).setVisibility(0);
            ImageLoaderView right_image_loader_view2 = (ImageLoaderView) a(i11);
            kotlin.jvm.internal.s.h(right_image_loader_view2, "right_image_loader_view");
            ImageLoaderView.g(right_image_loader_view2, imageModel, null, null, 6, null);
        }
        this.f12527b = imageModel;
    }

    public final void setRightImageLoaderViewVisible(boolean z10) {
        ((ImageLoaderView) a(R$id.right_image_loader_view)).setVisibility(z10 ? 0 : 8);
    }

    public final void setRightImageRes(@DrawableRes @Nullable Integer num) {
        if (num == null) {
            ((ImageView) a(R$id.rightImageView)).setImageDrawable(null);
        } else {
            ((ImageView) a(R$id.rightImageView)).setImageResource(num.intValue());
        }
    }

    public final void setRightImageVisible(boolean z10) {
        ((ImageView) a(R$id.rightImageView)).setVisibility(z10 ? 0 : 8);
    }

    public final void setRightText(@Nullable String str, int i10, int i11, boolean z10) {
        int i12 = R$id.rightTextView;
        TextView textView = (TextView) a(i12);
        if (str == null) {
            str = "";
        }
        textView.setText(str);
        ((TextView) a(i12)).getPaint().setFakeBoldText(z10);
        ((TextView) a(i12)).setTextColor(i10);
        ((TextView) a(i12)).setVisibility(i11);
    }

    public final void setRightTextClickEvent(@NotNull Function1<? super View, kotlin.p> clickCallBack) {
        kotlin.jvm.internal.s.i(clickCallBack, "clickCallBack");
        TextView rightTextView = (TextView) a(R$id.rightTextView);
        kotlin.jvm.internal.s.h(rightTextView, "rightTextView");
        y.d(rightTextView, clickCallBack);
    }

    public final void setRightTextViewVisible(boolean z10) {
        ((TextView) a(R$id.rightTextView)).setVisibility(z10 ? 0 : 8);
    }

    public final void setSingleTitle(@Nullable String str, @Nullable Integer num) {
        int i10 = R$id.singleTitleTextView;
        ((TextView) a(i10)).setVisibility(0);
        ((TextView) a(i10)).getPaint().setFakeBoldText(true);
        ((TextView) a(i10)).setText(str);
        if (num == null || num.intValue() <= 0) {
            return;
        }
        ((TextView) a(i10)).setMaxEms(num.intValue());
    }

    public final void setSingleTitleVisible(boolean z10) {
        ((TextView) a(R$id.singleTitleTextView)).setVisibility(z10 ? 0 : 8);
    }

    public final void setTabClickCallback(@NotNull Function2<? super Integer, ? super Boolean, kotlin.p> clickCallBack) {
        kotlin.jvm.internal.s.i(clickCallBack, "clickCallBack");
        ((FKViewPagerTitleLayout) a(R$id.viewPagerTitleLayout)).setTabClickCallBack(clickCallBack);
    }

    public final void setTitleBackgroundColor(@ColorInt int i10) {
        ((ConstraintLayout) a(R$id.titleBarContainerLayout)).setBackgroundColor(i10);
    }

    public final void setTitleRightRl(@NotNull View containerView) {
        kotlin.jvm.internal.s.i(containerView, "containerView");
        int i10 = R$id.title_right_rl;
        ((RelativeLayout) a(i10)).removeAllViews();
        ((RelativeLayout) a(i10)).addView(containerView);
        ((RelativeLayout) a(i10)).setVisibility(0);
    }

    public final void setTitleTextColor(int i10) {
        ((TextView) a(R$id.singleTitleTextView)).setTextColor(i10);
    }

    public final void setViewPagerTitleNewTag(int i10, boolean z10) {
        ((FKViewPagerTitleLayout) a(R$id.viewPagerTitleLayout)).y(i10, z10);
    }

    public final void setViewPagerTitlePadding(int i10, int i11) {
        ((FKViewPagerTitleLayout) a(R$id.viewPagerTitleLayout)).setPadding(i10, 0, i11, 0);
    }

    public final void setViewPagerTitleRedTip(int i10, boolean z10) {
        ((FKViewPagerTitleLayout) a(R$id.viewPagerTitleLayout)).z(i10, z10);
    }

    public final void setViewPagerTitleUnreadCount(int i10, int i11) {
        ((FKViewPagerTitleLayout) a(R$id.viewPagerTitleLayout)).B(i10, i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKTitleBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12528c = new LinkedHashMap();
        h(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKTitleBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12528c = new LinkedHashMap();
        h(context, attributeSet);
    }
}
