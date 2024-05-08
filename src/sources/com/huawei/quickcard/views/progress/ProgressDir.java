package com.huawei.quickcard.views.progress;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.processor.DirProcessor;
import com.huawei.quickcard.framework.value.QuickCardValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ProgressDir extends DirProcessor<HorizontalProgressView> {
    @Override // com.huawei.quickcard.framework.processor.DirProcessor, com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull HorizontalProgressView horizontalProgressView, String str, QuickCardValue quickCardValue) {
        if (quickCardValue != null && !QuickCardValue.EMPTY.equals(quickCardValue) && quickCardValue.getString() != null) {
            horizontalProgressView.setDirection(quickCardValue.getString());
        } else {
            horizontalProgressView.setDirection(Attributes.LayoutDirection.AUTO);
            setAutoDirection(horizontalProgressView);
        }
    }
}
