package com.huawei.quickcard.rating;

import android.widget.RatingBar;
import androidx.annotation.NonNull;
import com.huawei.quickcard.action.ActionsHelper;
import com.huawei.quickcard.framework.processor.EventProcessor;
import com.huawei.quickcard.rating.view.QuickCardRating;
import java.math.BigDecimal;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c implements EventProcessor<QuickCardRating> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements RatingBar.OnRatingBarChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private final String f34200a;

        public a(String str) {
            this.f34200a = str;
        }

        @Override // android.widget.RatingBar.OnRatingBarChangeListener
        public void onRatingChanged(RatingBar ratingBar, float f10, boolean z10) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("rating", Double.valueOf(new BigDecimal(String.valueOf(f10)).doubleValue()));
            ActionsHelper.doAction(ratingBar, this.f34200a, hashMap);
        }
    }

    @Override // com.huawei.quickcard.framework.processor.EventProcessor
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void applyEvent(@NonNull QuickCardRating quickCardRating, String str, String str2) {
        quickCardRating.setOnRatingBarChangeListener(new a(str2));
    }

    @Override // com.huawei.quickcard.framework.processor.EventProcessor
    public /* synthetic */ void cleanEvent(QuickCardRating quickCardRating, String str) {
        com.huawei.quickcard.framework.processor.a.a(this, quickCardRating, str);
    }
}
