package com.huawei.quickcard.framework.processor;

import android.view.View;
import androidx.annotation.NonNull;
import com.facebook.yoga.YogaNode;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.YogaUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AspectRatioProcessor<T extends View> implements PropertyProcessor<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final float f33865a = Float.NaN;

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
        return ParserHelper.parseToRatio(obj, Float.NaN);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        YogaNode yogaNode = YogaUtils.getYogaNode(t2);
        float floatValue = quickCardValue.isNumber() ? quickCardValue.getNumber().floatValue() : Float.NaN;
        if (yogaNode != null) {
            yogaNode.w(floatValue);
        }
    }
}
