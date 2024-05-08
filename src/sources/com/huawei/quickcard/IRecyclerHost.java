package com.huawei.quickcard;

import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.framework.bean.CardElement;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IRecyclerHost {
    void addChildItem(CardElement cardElement);

    void endAddChildItem(CardContext cardContext);

    void update(String str);
}
