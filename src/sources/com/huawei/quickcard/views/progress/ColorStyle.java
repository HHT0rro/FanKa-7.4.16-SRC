package com.huawei.quickcard.views.progress;

import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.processor.b;
import com.huawei.quickcard.framework.value.QuickCardValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ColorStyle implements PropertyProcessor<HorizontalProgressView> {
    public static final int DEFAULT_COLOR = -13388545;

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
        return ParserHelper.parseToColor(obj, -13388545);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull HorizontalProgressView horizontalProgressView, String str, QuickCardValue quickCardValue) {
        if (quickCardValue != null && quickCardValue != QuickCardValue.EMPTY && quickCardValue.getNumber() != null) {
            horizontalProgressView.setColor(quickCardValue.getNumber().intValue());
        } else {
            horizontalProgressView.setColor(-13388545);
        }
    }
}