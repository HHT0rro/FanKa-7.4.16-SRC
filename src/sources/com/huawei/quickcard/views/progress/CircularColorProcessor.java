package com.huawei.quickcard.views.progress;

import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.processor.b;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.QuickCardValueUtil;
import com.huawei.quickcard.views.progress.CircularProgressView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CircularColorProcessor<T extends CircularProgressView> implements PropertyProcessor<T> {
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
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        if (!QuickCardValueUtil.isInvalidValue(quickCardValue) && quickCardValue.isNumber()) {
            t2.setProgressBarColor(quickCardValue.getNumber().intValue());
        } else {
            t2.setProgressBarColor(-13388545);
        }
    }
}
