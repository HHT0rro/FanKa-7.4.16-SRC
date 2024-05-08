package com.huawei.quickcard.views.text.processor;

import android.widget.TextView;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.utils.ResourceUtils;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.processor.b;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.views.text.TextDefaultAttrValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TextColorStyle implements PropertyProcessor<TextView> {

    /* renamed from: a, reason: collision with root package name */
    private static Integer f34651a;

    private static int a() {
        if (f34651a == null) {
            f34651a = Integer.valueOf(ResourceUtils.getColor(TextDefaultAttrValue.DEFAULT_TEXT_COLOR));
        }
        return f34651a.intValue();
    }

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
        return ParserHelper.parseToColor(obj, a());
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull TextView textView, String str, QuickCardValue quickCardValue) {
        Number number = quickCardValue.getNumber();
        if (number != null) {
            textView.setTextColor(number.intValue());
        } else {
            textView.setTextColor(a());
        }
    }
}
