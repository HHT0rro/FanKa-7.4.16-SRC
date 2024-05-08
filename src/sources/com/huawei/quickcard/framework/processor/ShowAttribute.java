package com.huawei.quickcard.framework.processor;

import android.view.View;
import androidx.annotation.NonNull;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaNode;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.YogaUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ShowAttribute<T extends View> implements PropertyProcessor<T> {
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
        return ParserHelper.parseToBool(obj);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        boolean z10 = quickCardValue.getBoolean();
        t2.setVisibility(z10 ? 0 : 8);
        YogaNode yogaNode = YogaUtils.getYogaNode(t2);
        if (yogaNode != null) {
            yogaNode.A(z10 ? YogaDisplay.FLEX : YogaDisplay.NONE);
        }
    }
}
