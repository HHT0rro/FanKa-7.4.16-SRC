package com.huawei.quickcard.framework.processor;

import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TagAttribute<T extends View> implements PropertyProcessor<T> {
    public static final int CSS_TAG = 1660944384;

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
        return ParserHelper.parseToString(obj, "");
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        t2.setTag(CSS_TAG, quickCardValue != null ? quickCardValue.getString() : null);
    }
}
