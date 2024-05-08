package com.huawei.quickcard.extension.format;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.interfaces.CardDataObject;
import com.huawei.quickcard.base.wrapper.WrapDataUtils;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.utils.IntlUtils;
import com.huawei.quickcard.y0;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FormatNumberUtils {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33645a;

        static {
            int[] iArr = new int[y0.values().length];
            f33645a = iArr;
            try {
                iArr[y0.CURRENCY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33645a[y0.PERCENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @NonNull
    public static IQuickNumberFormat createNumberFormatter(Object obj) {
        Object wrap = WrapDataUtils.wrap(obj);
        if (wrap instanceof CardDataObject) {
            CardDataObject cardDataObject = (CardDataObject) wrap;
            boolean booleanValue = cardDataObject.getBooleanValue(IQuickNumberFormat.USE_GROUPING, true);
            y0 y0Var = y0.DECIMAL;
            int i10 = a.f33645a[((y0) ParserHelper.object2Enum(y0.class, cardDataObject.getString("style", y0Var.name()), y0Var)).ordinal()];
            if (i10 == 1) {
                return IntlUtils.createCurrencyFormatter(booleanValue);
            }
            if (i10 != 2) {
                return IntlUtils.createDecimalFormatter(booleanValue);
            }
            return IntlUtils.createPercentFormatter(booleanValue);
        }
        return IntlUtils.createDecimalFormatter(true);
    }
}
