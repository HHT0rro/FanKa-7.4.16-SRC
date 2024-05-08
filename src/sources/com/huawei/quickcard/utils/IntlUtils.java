package com.huawei.quickcard.utils;

import androidx.annotation.NonNull;
import com.huawei.quickcard.extension.format.IQuickNumberFormat;
import com.huawei.quickcard.extension.format.QuickNumberFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class IntlUtils {
    @NonNull
    public static IQuickNumberFormat createCurrencyFormatter(boolean z10) {
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        if (Locale.getDefault().getLanguage().equals("en")) {
            currencyInstance.setCurrency(Currency.getInstance("USD"));
        }
        currencyInstance.setGroupingUsed(z10);
        return new QuickNumberFormat(currencyInstance);
    }

    @NonNull
    public static IQuickNumberFormat createDecimalFormatter(boolean z10) {
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setGroupingUsed(z10);
        return new QuickNumberFormat(numberInstance);
    }

    @NonNull
    public static IQuickNumberFormat createPercentFormatter(boolean z10) {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setGroupingUsed(z10);
        return new QuickNumberFormat(percentInstance);
    }
}
