package com.huawei.quickcard.framework.parser;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.framework.value.QuickCardValue;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface ValueParser {
    @NonNull
    QuickCardValue parseToValue(String str, Object obj);
}
