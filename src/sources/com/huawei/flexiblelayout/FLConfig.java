package com.huawei.flexiblelayout;

import com.huawei.flexiblelayout.parser.CardProvider;
import com.huawei.flexiblelayout.parser.DataKeys;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class FLConfig {
    public static FLConfig newConfig() {
        return new com.huawei.flexiblelayout.common.a();
    }

    public abstract DataKeys getBindFieldAlias();

    public abstract List<CardProvider> getCardProvider();

    public abstract FLConfig setBindFieldAlias(DataKeys dataKeys);

    public abstract FLConfig setCardProvider(List<CardProvider> list);
}
