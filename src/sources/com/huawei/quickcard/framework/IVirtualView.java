package com.huawei.quickcard.framework;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.framework.value.QuickCardValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IVirtualView {
    @Nullable
    String getName();

    @NonNull
    QuickCardValue makeAttr(String str, Object obj);
}
