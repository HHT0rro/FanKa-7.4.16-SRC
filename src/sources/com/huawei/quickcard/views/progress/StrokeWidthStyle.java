package com.huawei.quickcard.views.progress;

import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.processor.b;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.ViewUtils;
import com.kuaishou.weapon.p0.t;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class StrokeWidthStyle implements PropertyProcessor<HorizontalProgressView> {
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
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.endsWith(t.f36232q)) {
                return new QuickCardValue.DpValue(ViewUtils.parseFloat(str2.substring(0, str2.length() - 2), 0));
            }
        }
        return new QuickCardValue.DpValue(0);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull HorizontalProgressView horizontalProgressView, String str, QuickCardValue quickCardValue) {
        horizontalProgressView.setStrokeWidth(ViewUtils.dip2IntPx(ViewUtils.getConfigDensity(horizontalProgressView.getContext(), ViewUtils.getCardContext(horizontalProgressView)), quickCardValue.getDp()));
    }
}
