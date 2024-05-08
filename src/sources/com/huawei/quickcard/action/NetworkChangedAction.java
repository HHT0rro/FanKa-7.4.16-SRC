package com.huawei.quickcard.action;

import android.text.TextUtils;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.log.CardLogUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NetworkChangedAction extends AbsQuickCardAction {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33270a = "NetworkchangedAction";

    public void onNetworkChanged(String str) {
        CardContext cardContext;
        if (TextUtils.isEmpty(str) || this.cardContextRef == null || (cardContext = getCardContext()) == null) {
            return;
        }
        try {
            cardContext.executeExpr(str);
        } catch (Exception unused) {
            CardLogUtils.e(f33270a, "exec expression fail");
        }
    }
}
