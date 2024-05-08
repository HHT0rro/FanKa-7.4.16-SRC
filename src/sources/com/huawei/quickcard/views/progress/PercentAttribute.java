package com.huawei.quickcard.views.progress;

import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.processor.b;
import com.huawei.quickcard.framework.value.QuickCardValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PercentAttribute implements PropertyProcessor<HorizontalProgressView> {
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
        int i10;
        if (obj instanceof Number) {
            i10 = ((Number) obj).intValue();
        } else {
            if (obj instanceof String) {
                try {
                    i10 = Integer.parseInt((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
            i10 = 0;
        }
        return new QuickCardValue.NumberValue(Integer.valueOf(i10));
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull HorizontalProgressView horizontalProgressView, String str, QuickCardValue quickCardValue) {
        if (quickCardValue != null && quickCardValue != QuickCardValue.EMPTY && quickCardValue.getNumber() != null) {
            horizontalProgressView.setPercent(quickCardValue.getNumber().intValue());
        } else {
            horizontalProgressView.setPercent(0);
        }
    }
}
