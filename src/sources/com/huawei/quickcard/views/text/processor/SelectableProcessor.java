package com.huawei.quickcard.views.text.processor;

import android.widget.TextView;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.processor.b;
import com.huawei.quickcard.framework.value.QuickCardValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SelectableProcessor implements PropertyProcessor<TextView> {
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
        if (Attributes.Style.SELECTABLE.equals(str)) {
            return ParserHelper.parseToBool(obj, false);
        }
        return QuickCardValue.EMPTY;
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull TextView textView, String str, QuickCardValue quickCardValue) {
        if (!quickCardValue.isBool()) {
            textView.setTextIsSelectable(false);
        } else {
            textView.setTextIsSelectable(quickCardValue.getBoolean());
        }
    }
}
