package com.huawei.quickcard;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huawei.quickcard.base.Attributes;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class r0 {
    public static Object a(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        Locale locale;
        if (!(obj instanceof String)) {
            return Attributes.LayoutDirection.AUTO;
        }
        if (obj2 instanceof String) {
            if (obj3 instanceof String) {
                locale = new Locale(obj.toString(), obj2.toString(), obj3.toString());
            } else {
                locale = new Locale(obj.toString(), obj2.toString());
            }
        } else {
            locale = new Locale(obj.toString());
        }
        return TextUtils.getLayoutDirectionFromLocale(locale) == 1 ? Attributes.LayoutDirection.RTL : Attributes.LayoutDirection.LTR;
    }
}
