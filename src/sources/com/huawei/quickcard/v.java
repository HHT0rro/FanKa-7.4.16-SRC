package com.huawei.quickcard;

import android.content.Context;
import com.huawei.quickcard.elexecutor.IExpressionContext;
import com.huawei.quickcard.utils.ValueUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class v extends w {
    public v(CardContext cardContext) {
        super(cardContext);
    }

    @Override // com.huawei.quickcard.w
    public void a(IExpressionContext iExpressionContext, String str) {
    }

    @Override // com.huawei.quickcard.w
    public void c(Context context) {
        super.c(context);
        ValueUtils.putToMap(d(), 0, "screenWidth");
        ValueUtils.putToMap(d(), 0, "screenHeight");
        ValueUtils.putToMap(d(), 0, "screenLogicWidth");
        ValueUtils.putToMap(d(), 0, "screenLogicHeight");
        ValueUtils.putToMap(d(), 0, "windowWidth");
        ValueUtils.putToMap(d(), 0, "windowHeight");
        ValueUtils.putToMap(d(), 0, "windowLogicWidth");
        ValueUtils.putToMap(d(), 0, "windowLogicHeight");
    }
}
