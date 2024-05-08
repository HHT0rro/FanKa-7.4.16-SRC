package com.huawei.flexiblelayout.layoutstrategy;

import com.huawei.flexiblelayout.adapter.ViewContainer;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.layoutstrategy.container.RegularContainer;
import java.util.Collection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DefaultLayoutStrategy implements GroupLayoutStrategy {

    /* renamed from: a, reason: collision with root package name */
    private static final GroupLayoutStrategy f28195a = new DefaultLayoutStrategy();

    public static GroupLayoutStrategy getInstance() {
        return f28195a;
    }

    @Override // com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy
    public void clear() {
    }

    @Override // com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy
    public ViewContainer createContainer() {
        return new RegularContainer();
    }

    @Override // com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy
    public String getIdentifier() {
        return "";
    }

    @Override // com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy
    public int getSize(int i10) {
        return i10;
    }

    @Override // com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy
    public int indexToPosition(int i10) {
        return i10;
    }

    @Override // com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy
    public int positionToIndex(int i10) {
        return i10;
    }

    @Override // com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy
    public void update(FLCardData fLCardData) {
    }

    @Override // com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy
    public void update(Collection<FLCardData> collection) {
    }
}
