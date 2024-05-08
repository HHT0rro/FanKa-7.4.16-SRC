package com.huawei.quickcard.elexecutor;

import androidx.annotation.NonNull;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IQuickCardProvider {
    String getCardId();

    ICSSRender getCssRender();

    IExpressionContext getExpressionContext(String str);

    IExpressionContext getExpressionContext(String str, int i10);

    void release();

    void setOptions(@NonNull Map<String, String> map);

    void setTemplate(@NonNull String str);
}
