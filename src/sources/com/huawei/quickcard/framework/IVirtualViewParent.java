package com.huawei.quickcard.framework;

import com.huawei.quickcard.framework.value.QuickCardValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IVirtualViewParent extends IVirtualView {
    void addChild(String str, IVirtualView iVirtualView);

    void renderChildren();

    void setChildProperties(String str, String str2, String str3, QuickCardValue quickCardValue);

    void updateChildren(String str, String str2, String str3, Object obj);
}
