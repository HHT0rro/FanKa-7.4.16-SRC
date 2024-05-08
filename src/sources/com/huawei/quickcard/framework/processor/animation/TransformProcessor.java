package com.huawei.quickcard.framework.processor.animation;

import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.f1;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.processor.b;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.ValueUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TransformProcessor<T extends View> implements PropertyProcessor<T> {
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
        if ("transform".equals(str)) {
            return ParserHelper.parseToJsonObject(obj);
        }
        return QuickCardValue.EMPTY;
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull View view, String str, QuickCardValue quickCardValue) {
        f1 qTransform = ValueUtils.obtainPropertyCacheBeanFromView(view).getQTransform(view);
        if ("transform".equals(str) && quickCardValue.isJson()) {
            qTransform.d(quickCardValue.getJson());
        } else {
            qTransform.i();
        }
    }
}
