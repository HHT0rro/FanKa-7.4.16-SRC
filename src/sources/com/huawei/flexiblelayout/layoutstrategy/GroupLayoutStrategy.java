package com.huawei.flexiblelayout.layoutstrategy;

import com.huawei.flexiblelayout.adapter.ViewContainer;
import com.huawei.flexiblelayout.data.FLCardData;
import java.util.Collection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface GroupLayoutStrategy {
    void clear();

    ViewContainer createContainer();

    String getIdentifier();

    int getSize(int i10);

    int indexToPosition(int i10);

    int positionToIndex(int i10);

    void update(FLCardData fLCardData);

    void update(Collection<FLCardData> collection);
}
