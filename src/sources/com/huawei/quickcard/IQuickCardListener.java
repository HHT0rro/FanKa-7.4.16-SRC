package com.huawei.quickcard;

import com.huawei.quickcard.action.AbsQuickCardAction;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IQuickCardListener {
    void onActionCreated(AbsQuickCardAction absQuickCardAction);

    void onActionRunFailed(String str);
}
