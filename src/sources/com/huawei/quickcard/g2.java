package com.huawei.quickcard;

import android.view.View;
import com.huawei.quickcard.framework.bean.ThemeBean;
import com.huawei.quickcard.framework.ui.Component;
import com.huawei.quickcard.utils.ThemeUtils;
import com.huawei.quickcard.utils.ViewUtils;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final /* synthetic */ class g2 {
    public static void a(CardContext cardContext, LifeListener lifeListener) {
    }

    public static ThemeMode b(CardContext cardContext) {
        return ThemeMode.AUTO;
    }

    public static void c(CardContext cardContext) {
    }

    public static void d(CardContext cardContext) {
    }

    public static void e(CardContext cardContext, int i10) {
    }

    public static void f(CardContext cardContext, Set set) {
        ThemeBean themeBean = cardContext.getThemeBean();
        if (themeBean != null) {
            ThemeUtils.onThemeChange(themeBean, cardContext, set);
        }
    }

    public static boolean g(CardContext cardContext, View view, String str, boolean z10, long j10) {
        Component component = ViewUtils.getComponent(view);
        if (component != null) {
            return component.onViewStateChanged(cardContext, view, str, z10, j10);
        }
        return false;
    }
}
