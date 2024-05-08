package com.huawei.quickcard.views.progress;

import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.processor.b;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.QuickCardValueUtil;
import com.huawei.quickcard.views.progress.HorizontalProgressView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HorizontalSmoothProcessor<T extends HorizontalProgressView> implements PropertyProcessor<T> {
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
        return ParserHelper.parseToBool(obj, false);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        if (!QuickCardValueUtil.isInvalidValue(quickCardValue) && quickCardValue.isBool()) {
            t2.setSmoothEnable(quickCardValue.getBoolean());
        } else {
            t2.setSmoothEnable(false);
        }
    }
}
