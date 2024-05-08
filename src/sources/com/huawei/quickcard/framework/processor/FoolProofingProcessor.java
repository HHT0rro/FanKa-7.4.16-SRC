package com.huawei.quickcard.framework.processor;

import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.ValueUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FoolProofingProcessor<T extends View> implements PropertyProcessor<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final long f33891a = 0;

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
        return ParserHelper.parseToNumber(obj, 0L);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        if (quickCardValue == null) {
            return;
        }
        PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(t2);
        obtainPropertyCacheBeanFromView.setFoolProofingTime(quickCardValue.getNumber().longValue());
        obtainPropertyCacheBeanFromView.setLastClickTime(-quickCardValue.getNumber().longValue());
        PropertyCacheBean obtainRootPropertyCacheBeanFromView = ValueUtils.obtainRootPropertyCacheBeanFromView(t2);
        if (obtainRootPropertyCacheBeanFromView != null) {
            obtainRootPropertyCacheBeanFromView.saveFoolProofView(t2);
        }
    }
}
