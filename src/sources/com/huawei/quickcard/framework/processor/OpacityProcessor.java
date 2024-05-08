package com.huawei.quickcard.framework.processor;

import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.ValueUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class OpacityProcessor<T extends View> implements PropertyProcessor<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33897a = "OpacityProcessor";

    /* renamed from: b, reason: collision with root package name */
    private static final int f33898b = 1;

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
        return ParserHelper.parseToNumber(obj, 1);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(t2);
        if (obtainPropertyCacheBeanFromView.isAnimationView()) {
            obtainPropertyCacheBeanFromView.getQAnimatorSet(t2).b().put(Attributes.Style.OPACITY, quickCardValue);
        }
        float f10 = 1.0f;
        if (quickCardValue != null && quickCardValue.isNumber() && !QuickCardValue.EMPTY.equals(quickCardValue)) {
            float floatValue = quickCardValue.getNumber().floatValue();
            if (floatValue >= 0.0f && floatValue <= 1.0f) {
                f10 = floatValue;
            }
            t2.setAlpha(f10);
            return;
        }
        t2.setAlpha(1.0f);
    }
}
