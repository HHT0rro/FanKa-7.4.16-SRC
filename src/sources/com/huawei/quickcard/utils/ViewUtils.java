package com.huawei.quickcard.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import com.facebook.yoga.YogaNode;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.utils.Utils;
import com.huawei.quickcard.core.R;
import com.huawei.quickcard.elexecutor.ICSSRender;
import com.huawei.quickcard.framework.IComponentSupport;
import com.huawei.quickcard.framework.processor.TagAttribute;
import com.huawei.quickcard.framework.ui.Component;
import com.huawei.quickcard.framework.ui.ComponentRegistry;
import com.huawei.quickcard.framework.ui.YogaContainer;
import com.huawei.quickcard.views.text.view.IQuickText;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ViewUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final int f34305a = 2;

    /* renamed from: b, reason: collision with root package name */
    private static final int f34306b = 1;

    private static ICSSRender a(CardContext cardContext) {
        if (cardContext == null) {
            return null;
        }
        return cardContext.getCssRender();
    }

    public static String composeForItemScript(@NonNull View view, String str, boolean z10) {
        return ExpressionUtils.updateForScript(ExpressionUtils.getForChains(view), str, z10);
    }

    public static float dip2FloatPx(float f10, float f11) {
        return f11 * f10;
    }

    @Deprecated
    public static float dip2FloatPx(Context context, float f10) {
        return f10 * getAppDensity(context);
    }

    public static int dip2IntPx(View view, float f10) {
        return (int) (dip2FloatPx(view, f10) + 0.5f);
    }

    public static void dirty(View view) {
        YogaNode yogaNode = YogaUtils.getYogaNode(view);
        if (yogaNode != null) {
            yogaNode.c();
        }
    }

    public static void doFocus(@NonNull View view, boolean z10) {
        if (z10) {
            view.requestFocus();
        } else {
            view.clearFocus();
        }
    }

    public static float getAppDensity(@NonNull Context context) {
        Context applicationContext = context.getApplicationContext();
        return (applicationContext != null ? applicationContext.getResources() : context.getResources()).getDisplayMetrics().density;
    }

    public static CardContext getCardContext(View view) {
        return (CardContext) view.getTag(R.id.quick_card_context);
    }

    public static Component getComponent(View view) {
        if (view == null) {
            return null;
        }
        Object tag = view.getTag(R.id.quick_card_type);
        return ComponentRegistry.get(tag instanceof String ? (String) tag : null);
    }

    public static float getConfigDensity(@NonNull View view) {
        return getConfigDensity(view.getContext(), getCardContext(view));
    }

    public static float getConfigFontScale(@NonNull Context context, CardContext cardContext) {
        if (cardContext != null) {
            return cardContext.getConfigFontScale(context);
        }
        return context.getResources().getConfiguration().fontScale;
    }

    public static View getViewById(CardContext cardContext, String str) {
        return ValueUtils.obtainPropertyCacheBeanFromView(cardContext.getRoot().getRootViewGroup()).getViewById(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ViewParent getViewParent(@NonNull View view) {
        if (view instanceof IComponentSupport) {
            return ((IComponentSupport) view).getViewParent(view);
        }
        return view.getParent();
    }

    public static boolean hasCSSTag(CardContext cardContext, View view) {
        return (a(view) == null || a(cardContext) == null) ? false : true;
    }

    public static float parse2float(float f10, String str) {
        return parse2float(f10, str, 0);
    }

    public static int parse2int(float f10, String str) {
        return parse2int(f10, str, 0);
    }

    public static float parseFloat(String str, float f10) {
        try {
            return Float.parseFloat(str);
        } catch (Exception unused) {
            return f10;
        }
    }

    public static int px2IntDip(float f10, float f11) {
        return (int) (px2dip(f10, f11) + 0.5f);
    }

    public static float px2dip(float f10, float f11) {
        return f10 == 0.0f ? f11 : f11 / f10;
    }

    public static int pxInt2IntDip(float f10, int i10) {
        return (int) (pxInt2dip(f10, i10) + 0.5f);
    }

    public static float pxInt2dip(float f10, int i10) {
        return f10 == 0.0f ? i10 : i10 / f10;
    }

    public static void refreshSelf(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (!(view instanceof YogaContainer) && (parent instanceof YogaContainer)) {
                ((YogaContainer) parent).invalidate(view);
            }
            view.requestLayout();
        }
    }

    public static boolean renderCSSTag(CardContext cardContext, View view) {
        ICSSRender a10;
        String a11 = a(view);
        if (a11 == null || (a10 = a(cardContext)) == null) {
            return false;
        }
        a10.render(view, a11);
        return true;
    }

    public static float sp2FloatPx(float f10, float f11, float f12) {
        return f12 * f11 * f10;
    }

    public static float sp2FloatPx(View view, float f10) {
        float configFontScale;
        float f11;
        if (view == null) {
            f11 = 2.0f;
            configFontScale = 1.0f;
        } else {
            float configDensity = getConfigDensity(view.getContext(), getCardContext(view));
            configFontScale = getConfigFontScale(view.getContext(), getCardContext(view));
            f11 = configDensity;
        }
        return sp2FloatPx(f11, configFontScale, f10);
    }

    private static String a(View view) {
        Object tag = view.getTag(TagAttribute.CSS_TAG);
        if (tag instanceof String) {
            return (String) tag;
        }
        return null;
    }

    public static float dip2FloatPx(View view, float f10) {
        return dip2FloatPx(view == null ? 2.0f : getConfigDensity(view.getContext(), getCardContext(view)), f10);
    }

    public static int dip2IntPx(float f10) {
        return (int) (dip2FloatPx(2.0f, f10) + 0.5f);
    }

    public static float getConfigDensity(@NonNull Context context, @NonNull CardContext cardContext) {
        if (cardContext != null) {
            return cardContext.getConfigDensity(context);
        }
        return getAppDensity(context);
    }

    public static float parse2float(float f10, String str, int i10) {
        if (str == null) {
            return i10;
        }
        String trim = str.trim();
        if (Utils.isNum(trim)) {
            return parseFloat(trim, 0.0f);
        }
        if (Utils.isPercentValue(trim)) {
            return parseFloat(trim.substring(0, trim.length() - 1), i10) / 100.0f;
        }
        return Utils.isDpValue(trim) ? dip2FloatPx(f10, parseFloat(trim.substring(0, trim.length() - 2), i10)) : i10;
    }

    public static int parse2int(float f10, String str, int i10) {
        return (int) (parse2float(f10, str, i10) + 0.5f);
    }

    public static int dip2IntPx(IQuickText iQuickText, float f10) {
        return (int) (dip2FloatPx(iQuickText, f10) + 0.5f);
    }

    public static float dip2FloatPx(IQuickText iQuickText, float f10) {
        return dip2FloatPx(iQuickText == null ? 2.0f : getConfigDensity(iQuickText.getContext(), iQuickText.getCardContext()), f10);
    }

    public static int dip2IntPx(float f10, float f11) {
        return (int) (dip2FloatPx(f10, f11) + 0.5f);
    }

    public static Float sp2FloatPx(IQuickText iQuickText, float f10) {
        float configFontScale;
        float f11;
        if (iQuickText == null) {
            f11 = 2.0f;
            configFontScale = 1.0f;
        } else {
            float configDensity = getConfigDensity(iQuickText.getContext(), iQuickText.getCardContext());
            configFontScale = getConfigFontScale(iQuickText.getContext(), iQuickText.getCardContext());
            f11 = configDensity;
        }
        return Float.valueOf(sp2FloatPx(f11, configFontScale, f10));
    }
}
