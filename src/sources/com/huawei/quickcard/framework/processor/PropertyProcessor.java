package com.huawei.quickcard.framework.processor;

import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.framework.parser.ValueParser;
import com.huawei.quickcard.framework.value.QuickCardValue;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface PropertyProcessor<T extends View> extends ValueParser {
    boolean isImmediate();

    boolean needRefresh();

    void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue);
}
