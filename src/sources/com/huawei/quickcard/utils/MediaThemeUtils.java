package com.huawei.quickcard.utils;

import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.ThemeMode;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.interfaces.CardDataObject;
import com.huawei.quickcard.base.wrapper.WrapDataUtils;
import java.util.HashSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class MediaThemeUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34278a = "MediaThemeUtils";

    public static void setMediaTheme(CardContext cardContext, Object obj, Object obj2) {
        if (cardContext == null) {
            return;
        }
        int i10 = 0;
        boolean isTrue = ExpressionUtils.isTrue(obj2, false);
        Object wrap = WrapDataUtils.wrap(obj);
        if (wrap instanceof CardDataObject) {
            CardDataObject cardDataObject = (CardDataObject) wrap;
            int size = cardDataObject.size();
            if (isTrue) {
                ThemeMode themeMode = ThemeMode.AUTO;
                while (i10 < size) {
                    if (Attributes.UiMode.DARK.equals(cardDataObject.getString(i10))) {
                        themeMode = ThemeMode.DARK;
                    } else if (Attributes.UiMode.LIGHT.equals(cardDataObject.getString(i10))) {
                        themeMode = ThemeMode.LIGHT;
                    }
                    i10++;
                }
                cardContext.setThemeMode(themeMode);
                return;
            }
            cardContext.setThemeMode(ThemeMode.AUTO);
            HashSet hashSet = new HashSet(size);
            while (i10 < size) {
                hashSet.add(cardDataObject.getString(i10, ""));
                i10++;
            }
            cardContext.onThemeChange(hashSet);
        }
    }
}
