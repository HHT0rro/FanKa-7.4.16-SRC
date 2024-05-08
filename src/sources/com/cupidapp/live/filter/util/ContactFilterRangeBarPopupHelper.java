package com.cupidapp.live.filter.util;

import android.content.Context;
import android.view.View;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.base.utils.l;
import com.cupidapp.live.filter.model.FilterTopOptionsUiModel;
import com.cupidapp.live.filter.model.FilterTopRangeUiModel;
import com.cupidapp.live.filter.model.TabLayoutStyle;
import com.cupidapp.live.filter.view.FilterBarUiModel;
import com.cupidapp.live.filter.view.FilterOptionLayout;
import com.cupidapp.live.filter.view.FilterRangeBarLayout;
import com.cupidapp.live.filter.view.OptionUiModel;
import com.cupidapp.live.filter.view.TextStyle;
import com.cupidapp.live.match.model.RangeMatchFilterViewModel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import z0.h;

/* compiled from: ContactFilterRangeBarPopupHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ContactFilterRangeBarPopupHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ContactFilterRangeBarPopupHelper f14616a = new ContactFilterRangeBarPopupHelper();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final l f14617b = new l();

    /* compiled from: ContactFilterRangeBarPopupHelper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14618a;

        static {
            int[] iArr = new int[TabLayoutStyle.values().length];
            try {
                iArr[TabLayoutStyle.GOLD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TabLayoutStyle.RED_BLACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TabLayoutStyle.RED_WHITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f14618a = iArr;
        }
    }

    public static final void i(View view, final Context context, FilterTopOptionsUiModel itemModel, TabLayoutStyle style, final View alphaBgView, final Function0 dismiss) {
        s.i(view, "$view");
        s.i(context, "$context");
        s.i(itemModel, "$itemModel");
        s.i(style, "$style");
        s.i(alphaBgView, "$alphaBgView");
        s.i(dismiss, "$dismiss");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        final int height = view.getHeight() + iArr[1];
        FilterOptionLayout filterOptionLayout = new FilterOptionLayout(context);
        ContactFilterRangeBarPopupHelper contactFilterRangeBarPopupHelper = f14616a;
        filterOptionLayout.g(itemModel, contactFilterRangeBarPopupHelper.f(style));
        l.f(f14617b, filterOptionLayout, h.l(contactFilterRangeBarPopupHelper), 0, 4, null).h(new Function0<p>() { // from class: com.cupidapp.live.filter.util.ContactFilterRangeBarPopupHelper$showOptionPopup$1$1
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
                dismiss.invoke();
                ContactFilterRangeBarPopupHelper.f14616a.g(false, height, alphaBgView, context);
            }
        }).i(view, 0, 0);
        contactFilterRangeBarPopupHelper.g(true, height, alphaBgView, context);
    }

    public static final void k(View view, final Context context, FilterTopRangeUiModel itemModel, final View alphaBgView, TabLayoutStyle style, final Function0 dismiss) {
        s.i(view, "$view");
        s.i(context, "$context");
        s.i(itemModel, "$itemModel");
        s.i(alphaBgView, "$alphaBgView");
        s.i(style, "$style");
        s.i(dismiss, "$dismiss");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        final int height = view.getHeight() + iArr[1];
        FilterRangeBarLayout filterRangeBarLayout = new FilterRangeBarLayout(context);
        RangeMatchFilterViewModel filterModel = itemModel.getFilterModel();
        if (filterModel != null) {
            filterRangeBarLayout.d(filterModel, f14616a.e(style));
        }
        l lVar = f14617b;
        ContactFilterRangeBarPopupHelper contactFilterRangeBarPopupHelper = f14616a;
        l.f(lVar, filterRangeBarLayout, h.l(contactFilterRangeBarPopupHelper), 0, 4, null).h(new Function0<p>() { // from class: com.cupidapp.live.filter.util.ContactFilterRangeBarPopupHelper$showRangePopup$1$2
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
                dismiss.invoke();
                ContactFilterRangeBarPopupHelper.f14616a.g(false, height, alphaBgView, context);
            }
        }).i(view, 0, 0);
        contactFilterRangeBarPopupHelper.g(true, height, alphaBgView, context);
    }

    public final void d() {
        f14617b.d();
    }

    public final FilterBarUiModel e(TabLayoutStyle tabLayoutStyle) {
        int i10 = a.f14618a[tabLayoutStyle.ordinal()];
        if (i10 == 1) {
            return new FilterBarUiModel(Integer.valueOf(R$drawable.rect_btm_cor_8_sd_1a1a1a), 14, TextStyle.MEDIUM, -1, -5658199, -207721, 14, -207721, kotlin.collections.s.m(Float.valueOf(16.0f), Float.valueOf(16.0f), Float.valueOf(16.0f), Float.valueOf(16.0f)));
        }
        if (i10 == 2) {
            return new FilterBarUiModel(Integer.valueOf(R$drawable.rect_btm_cor_8_sd_1a1a1a), 14, TextStyle.MEDIUM, -1, -5658199, -40864, 14, -40864, kotlin.collections.s.m(Float.valueOf(16.0f), Float.valueOf(16.0f), Float.valueOf(16.0f), Float.valueOf(16.0f)));
        }
        if (i10 == 3) {
            return new FilterBarUiModel(Integer.valueOf(R$drawable.rect_btm_cor_8_sd_ffffff), 14, TextStyle.MEDIUM, -15066598, -5658199, -49088, 14, -49088, kotlin.collections.s.m(Float.valueOf(16.0f), Float.valueOf(16.0f), Float.valueOf(16.0f), Float.valueOf(16.0f)));
        }
        throw new NoWhenBranchMatchedException();
    }

    public final OptionUiModel f(TabLayoutStyle tabLayoutStyle) {
        int i10 = a.f14618a[tabLayoutStyle.ordinal()];
        if (i10 == 1) {
            return new OptionUiModel(-1, -5658199, -207721, R$drawable.bg_mul_select_in_gold, R$drawable.rect_btm_cor_8_sd_1a1a1a);
        }
        if (i10 == 2) {
            return new OptionUiModel(-1, -5658199, -40864, R$drawable.bg_mul_select_in_black, R$drawable.rect_btm_cor_8_sd_1a1a1a);
        }
        if (i10 == 3) {
            return new OptionUiModel(-15066598, -8618884, -49088, R$drawable.mul_select_bg, R$drawable.rect_btm_cor_8_sd_ffffff);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        if ((r1.indexOfChild(r12) != -1) == true) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(boolean r10, int r11, android.view.View r12, android.content.Context r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof android.app.Activity
            r1 = 0
            if (r0 == 0) goto L8
            android.app.Activity r13 = (android.app.Activity) r13
            goto L9
        L8:
            r13 = r1
        L9:
            if (r13 == 0) goto L16
            android.view.Window r13 = r13.getWindow()
            if (r13 == 0) goto L16
            android.view.View r13 = r13.getDecorView()
            goto L17
        L16:
            r13 = r1
        L17:
            boolean r0 = r13 instanceof android.view.ViewGroup
            if (r0 == 0) goto L1e
            r1 = r13
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
        L1e:
            r13 = 1
            r0 = 0
            if (r1 == 0) goto L2f
            int r2 = r1.indexOfChild(r12)
            r3 = -1
            if (r2 == r3) goto L2b
            r2 = 1
            goto L2c
        L2b:
            r2 = 0
        L2c:
            if (r2 != r13) goto L2f
            goto L30
        L2f:
            r13 = 0
        L30:
            if (r13 == 0) goto L35
            r1.removeView(r12)
        L35:
            if (r10 == 0) goto L4a
            if (r1 == 0) goto L3c
            r1.addView(r12)
        L3c:
            r3 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)
            r5 = 0
            r6 = 0
            r7 = 13
            r8 = 0
            r2 = r12
            z0.y.m(r2, r3, r4, r5, r6, r7, r8)
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.filter.util.ContactFilterRangeBarPopupHelper.g(boolean, int, android.view.View, android.content.Context):void");
    }

    public final void h(@NotNull final Context context, @NotNull final View view, @NotNull final View alphaBgView, @NotNull final FilterTopOptionsUiModel itemModel, @NotNull final TabLayoutStyle style, @NotNull final Function0<p> dismiss) {
        s.i(context, "context");
        s.i(view, "view");
        s.i(alphaBgView, "alphaBgView");
        s.i(itemModel, "itemModel");
        s.i(style, "style");
        s.i(dismiss, "dismiss");
        f14617b.d();
        view.post(new Runnable() { // from class: com.cupidapp.live.filter.util.a
            @Override // java.lang.Runnable
            public final void run() {
                ContactFilterRangeBarPopupHelper.i(View.this, context, itemModel, style, alphaBgView, dismiss);
            }
        });
    }

    public final void j(@NotNull final Context context, @NotNull final View view, @NotNull final View alphaBgView, @NotNull final FilterTopRangeUiModel itemModel, @NotNull final TabLayoutStyle style, @NotNull final Function0<p> dismiss) {
        s.i(context, "context");
        s.i(view, "view");
        s.i(alphaBgView, "alphaBgView");
        s.i(itemModel, "itemModel");
        s.i(style, "style");
        s.i(dismiss, "dismiss");
        f14617b.d();
        view.post(new Runnable() { // from class: com.cupidapp.live.filter.util.b
            @Override // java.lang.Runnable
            public final void run() {
                ContactFilterRangeBarPopupHelper.k(View.this, context, itemModel, alphaBgView, style, dismiss);
            }
        });
    }
}
