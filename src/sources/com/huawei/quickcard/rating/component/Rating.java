package com.huawei.quickcard.rating.component;

import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.framework.ui.Component;
import com.huawei.quickcard.rating.c;
import com.huawei.quickcard.rating.processor.RatingAttributesProcessor;
import com.huawei.quickcard.rating.processor.RatingStyleProcessor;
import com.huawei.quickcard.rating.utils.RatingAttr;
import com.huawei.quickcard.rating.view.QuickCardRating;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Rating extends Component<QuickCardRating> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34201a = "rating";

    public Rating() {
        RatingAttributesProcessor ratingAttributesProcessor = new RatingAttributesProcessor();
        addProcessor("rating", ratingAttributesProcessor);
        addProcessor(RatingAttr.Attributes.STEP_SIZE, ratingAttributesProcessor);
        addProcessor(RatingAttr.Attributes.NUM_STARS, ratingAttributesProcessor);
        addProcessor("indicator", ratingAttributesProcessor);
        RatingStyleProcessor ratingStyleProcessor = new RatingStyleProcessor();
        addProcessor(RatingAttr.Style.STAR_BACKGROUND, ratingStyleProcessor);
        addProcessor(RatingAttr.Style.STAR_FOREGROUND, ratingStyleProcessor);
        addProcessor(RatingAttr.Style.STAR_SECONDARY, ratingStyleProcessor);
        addEventProcessor("change", new c());
    }

    @Override // com.huawei.quickcard.framework.ui.Component
    @NonNull
    public String getName() {
        return "rating";
    }

    @Override // com.huawei.quickcard.framework.ui.Component
    public QuickCardRating createViewImpl(Context context) {
        QuickCardRating quickCardRating = new QuickCardRating(context);
        quickCardRating.setIsIndicator(false);
        quickCardRating.setNumStars(5);
        quickCardRating.setStepSize(0.5f);
        quickCardRating.setRating(0.0f);
        return quickCardRating;
    }
}
