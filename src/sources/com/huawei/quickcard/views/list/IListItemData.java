package com.huawei.quickcard.views.list;

import com.huawei.quickcard.framework.bean.CardElement;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IListItemData {
    CardElement getCardElement();

    int getInsertIndex();

    int getItemType();

    String getRef();

    int getShowCount();

    void update();

    void updateInsertIndex(int i10);
}
