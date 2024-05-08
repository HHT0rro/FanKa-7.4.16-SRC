package com.huawei.quickcard.extension.global.api;

import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.annotation.DoNotShrink;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IGlobalFunction extends IJsFunction {
    void bindCardContext(CardContext cardContext);

    CardContext getCardContext();

    void unbindCardContext();
}
