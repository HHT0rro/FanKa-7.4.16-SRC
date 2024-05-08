package com.huawei.quickcard.rating.processor;

import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.processor.b;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.rating.utils.RatingAttr;
import com.huawei.quickcard.rating.view.QuickCardRating;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class RatingAttributesProcessor implements PropertyProcessor<QuickCardRating> {
    private void a(QuickCardRating quickCardRating, QuickCardValue quickCardValue) {
        if (b(quickCardValue)) {
            quickCardRating.setIsIndicator(false);
        } else {
            quickCardRating.setIsIndicator(quickCardValue.getBoolean());
        }
    }

    private void b(QuickCardRating quickCardRating, QuickCardValue quickCardValue) {
        float ratingRate = quickCardRating.getRatingRate();
        float ratingStepSize = quickCardRating.getRatingStepSize();
        if (!b(quickCardValue) && !a(quickCardValue)) {
            quickCardRating.setNumStars(Math.round(quickCardValue.getNumber().floatValue()));
            quickCardRating.setRating(ratingRate);
            quickCardRating.setStepSize(ratingStepSize);
        } else {
            quickCardRating.setNumStars(5);
            quickCardRating.setRating(ratingRate);
            quickCardRating.setStepSize(ratingStepSize);
        }
    }

    private void c(QuickCardRating quickCardRating, QuickCardValue quickCardValue) {
        if (!b(quickCardValue) && !a(quickCardValue)) {
            quickCardRating.setRating(Math.max(0.0f, Math.min(quickCardValue.getNumber().floatValue(), quickCardRating.getRatingNumStars())));
        } else {
            quickCardRating.setRating(0.0f);
        }
    }

    private void d(QuickCardRating quickCardRating, QuickCardValue quickCardValue) {
        float ratingRate = quickCardRating.getRatingRate();
        if (!b(quickCardValue) && !a(quickCardValue)) {
            float floatValue = quickCardValue.getNumber().floatValue();
            quickCardRating.setStepSize(floatValue > 0.0f ? floatValue : 0.5f);
            quickCardRating.setRating(ratingRate);
            return;
        }
        quickCardRating.setStepSize(0.5f);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public /* synthetic */ boolean isImmediate() {
        return b.a(this);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public /* synthetic */ boolean needRefresh() {
        return b.b(this);
    }

    @Override // com.huawei.quickcard.framework.parser.ValueParser
    @NonNull
    public QuickCardValue parseToValue(String str, Object obj) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1870308197:
                if (str.equals(RatingAttr.Attributes.NUM_STARS)) {
                    c4 = 0;
                    break;
                }
                break;
            case -938102371:
                if (str.equals("rating")) {
                    c4 = 1;
                    break;
                }
                break;
            case -711999985:
                if (str.equals("indicator")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1429446861:
                if (str.equals(RatingAttr.Attributes.STEP_SIZE)) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return ParserHelper.parseToNumber(obj, 5);
            case 1:
                return ParserHelper.parseToNumber(obj, 0);
            case 2:
                return ParserHelper.parseToBool(obj, false);
            case 3:
                return ParserHelper.parseToNumber(obj, Float.valueOf(0.5f));
            default:
                return QuickCardValue.EMPTY;
        }
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull QuickCardRating quickCardRating, String str, QuickCardValue quickCardValue) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1870308197:
                if (str.equals(RatingAttr.Attributes.NUM_STARS)) {
                    c4 = 0;
                    break;
                }
                break;
            case -938102371:
                if (str.equals("rating")) {
                    c4 = 1;
                    break;
                }
                break;
            case -711999985:
                if (str.equals("indicator")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1429446861:
                if (str.equals(RatingAttr.Attributes.STEP_SIZE)) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                b(quickCardRating, quickCardValue);
                return;
            case 1:
                c(quickCardRating, quickCardValue);
                return;
            case 2:
                a(quickCardRating, quickCardValue);
                return;
            case 3:
                d(quickCardRating, quickCardValue);
                return;
            default:
                return;
        }
    }

    private boolean a(QuickCardValue quickCardValue) {
        return !quickCardValue.isNumber() || quickCardValue.getNumber() == null;
    }

    private boolean b(QuickCardValue quickCardValue) {
        return quickCardValue == null || QuickCardValue.EMPTY.equals(quickCardValue);
    }
}
