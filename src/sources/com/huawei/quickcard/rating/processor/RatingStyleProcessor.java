package com.huawei.quickcard.rating.processor;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.rating.R;
import com.huawei.quickcard.rating.b;
import com.huawei.quickcard.rating.utils.RatingAttr;
import com.huawei.quickcard.rating.view.QuickCardRating;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class RatingStyleProcessor implements PropertyProcessor<QuickCardRating> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34202a = "RatingStyleProcessor";

    private void a(QuickCardRating quickCardRating, QuickCardValue quickCardValue) {
        if (a(quickCardValue)) {
            a(quickCardRating);
            return;
        }
        String starBackground = quickCardRating.getStarBackground();
        if (starBackground == null || !starBackground.equals(quickCardValue.getString())) {
            quickCardRating.setRatingBackgroundDrawable(b.a(quickCardRating, quickCardValue.getString()));
            quickCardRating.saveRatingBackground(quickCardValue.getString());
        }
    }

    private void b(QuickCardRating quickCardRating, QuickCardValue quickCardValue) {
        if (a(quickCardValue)) {
            b(quickCardRating);
            return;
        }
        String starForeground = quickCardRating.getStarForeground();
        if (starForeground == null || !starForeground.equals(quickCardValue.getString())) {
            quickCardRating.setRatingForegroundDrawable(b.a(quickCardRating, quickCardValue.getString()));
            quickCardRating.saveRatingForeground(quickCardValue.getString());
        }
    }

    private void c(QuickCardRating quickCardRating, QuickCardValue quickCardValue) {
        if (a(quickCardValue)) {
            c(quickCardRating);
            return;
        }
        String starSecondary = quickCardRating.getStarSecondary();
        if (starSecondary == null || !starSecondary.equals(quickCardValue.getString())) {
            quickCardRating.setRatingSecondaryDrawable(b.a(quickCardRating, quickCardValue.getString()));
            quickCardRating.saveRatingSecondary(quickCardValue.getString());
        }
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public boolean isImmediate() {
        return true;
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public /* synthetic */ boolean needRefresh() {
        return com.huawei.quickcard.framework.processor.b.b(this);
    }

    @Override // com.huawei.quickcard.framework.parser.ValueParser
    @NonNull
    public QuickCardValue parseToValue(String str, Object obj) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1354625739:
                if (str.equals(RatingAttr.Style.STAR_FOREGROUND)) {
                    c4 = 0;
                    break;
                }
                break;
            case -376309472:
                if (str.equals(RatingAttr.Style.STAR_BACKGROUND)) {
                    c4 = 1;
                    break;
                }
                break;
            case 460162882:
                if (str.equals(RatingAttr.Style.STAR_SECONDARY)) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 1:
            case 2:
                return ParserHelper.parseToString(obj, null);
            default:
                return QuickCardValue.EMPTY;
        }
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull QuickCardRating quickCardRating, String str, QuickCardValue quickCardValue) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1354625739:
                if (str.equals(RatingAttr.Style.STAR_FOREGROUND)) {
                    c4 = 0;
                    break;
                }
                break;
            case -376309472:
                if (str.equals(RatingAttr.Style.STAR_BACKGROUND)) {
                    c4 = 1;
                    break;
                }
                break;
            case 460162882:
                if (str.equals(RatingAttr.Style.STAR_SECONDARY)) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                b(quickCardRating, quickCardValue);
                return;
            case 1:
                a(quickCardRating, quickCardValue);
                return;
            case 2:
                c(quickCardRating, quickCardValue);
                return;
            default:
                return;
        }
    }

    private void a(QuickCardRating quickCardRating) {
        try {
            Drawable drawable = ResourcesCompat.getDrawable(quickCardRating.getResources(), R.drawable.quick_card_rating_star_off, null);
            if (drawable != null) {
                quickCardRating.setRatingBackgroundDrawable(new BitmapDrawable(quickCardRating.getResources(), b.a(drawable)));
            }
        } catch (Resources.NotFoundException unused) {
            CardLogUtils.e(f34202a, "setDefaultSecondary error cause resource not found");
        }
    }

    private void b(QuickCardRating quickCardRating) {
        try {
            Drawable drawable = ResourcesCompat.getDrawable(quickCardRating.getResources(), R.drawable.quick_card_rating_star_on, null);
            if (drawable != null) {
                quickCardRating.setRatingBackgroundDrawable(new BitmapDrawable(quickCardRating.getResources(), b.a(drawable)));
            }
        } catch (Resources.NotFoundException unused) {
            CardLogUtils.e(f34202a, "setDefaultForeground error cause resource not found");
        }
    }

    private void c(QuickCardRating quickCardRating) {
        try {
            Drawable drawable = ResourcesCompat.getDrawable(quickCardRating.getResources(), R.drawable.quick_card_rating_star_off, null);
            if (drawable != null) {
                quickCardRating.setRatingSecondaryDrawable(new BitmapDrawable(quickCardRating.getResources(), b.a(drawable)));
                new BitmapDrawable(quickCardRating.getResources(), b.a(drawable));
            }
        } catch (Resources.NotFoundException unused) {
            CardLogUtils.e(f34202a, "setDefaultSecondary error cause resource not found");
        }
    }

    private boolean a(QuickCardValue quickCardValue) {
        return quickCardValue == null || QuickCardValue.EMPTY.equals(quickCardValue) || !quickCardValue.isString() || TextUtils.isEmpty(quickCardValue.getString());
    }
}
