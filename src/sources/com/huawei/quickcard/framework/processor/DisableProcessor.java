package com.huawei.quickcard.framework.processor;

import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.QuickCardValueUtil;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DisableProcessor<T extends View> implements PropertyProcessor<T> {
    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public boolean isImmediate() {
        return true;
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
            t2.setEnabled(!quickCardValue.getBoolean());
        } else {
            t2.setEnabled(true);
        }
    }
}
