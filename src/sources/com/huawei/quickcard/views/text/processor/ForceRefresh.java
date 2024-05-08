package com.huawei.quickcard.views.text.processor;

import android.widget.TextView;
import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.processor.b;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.views.text.view.IQuickText;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ForceRefresh implements PropertyProcessor<TextView> {
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
        return ParserHelper.parseToBool(obj, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull TextView textView, String str, QuickCardValue quickCardValue) {
        if (quickCardValue.isBool() && (textView instanceof IQuickText)) {
            ((IQuickText) textView).setForceRefresh(quickCardValue.getBoolean());
        }
    }
}
