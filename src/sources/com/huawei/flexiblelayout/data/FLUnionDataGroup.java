package com.huawei.flexiblelayout.data;

import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLUnionDataGroup extends FLDataGroup {

    /* renamed from: l, reason: collision with root package name */
    private Map<FLNodeData, FLMap> f28077l;

    public FLUnionDataGroup(int i10, FLMap fLMap, GroupLayoutStrategy groupLayoutStrategy) {
        super(i10, fLMap, groupLayoutStrategy);
        this.f28077l = new HashMap();
    }

    public void addGroup(FLDataGroup fLDataGroup) {
        if (fLDataGroup == null) {
            return;
        }
        if (!fLDataGroup.isAttached()) {
            h<FLNodeData> children = fLDataGroup.getChildren();
            if (children.b() <= 0) {
                return;
            }
            FLDataGroup.PendingDataSet addData = addData();
            for (int i10 = 0; i10 < children.b(); i10++) {
                addData.add(children.a(i10));
                this.f28077l.put(children.a(i10), fLDataGroup.getData());
            }
            addData.commit();
            return;
        }
        throw new IllegalStateException("The group cannot be attached status.");
    }

    @Override // com.huawei.flexiblelayout.data.FLDataGroup
    public FLMap getData() {
        FLMap fLMap = this.f28077l.get(getCursor().current());
        return fLMap != null ? fLMap : super.getData();
    }

    @Override // com.huawei.flexiblelayout.data.FLDataGroup
    public void removeAllData() {
        super.removeAllData();
        this.f28077l.clear();
    }

    @Override // com.huawei.flexiblelayout.data.FLDataGroup
    public void removeData(FLNodeData fLNodeData) {
        super.removeData(fLNodeData);
        this.f28077l.remove(fLNodeData);
    }

    @Override // com.huawei.flexiblelayout.data.FLDataGroup
    public FLMap getData(FLCardData fLCardData) {
        FLNodeData rootNodeData = FLContext.getRootNodeData(fLCardData);
        FLMap fLMap = this.f28077l.get(rootNodeData);
        return (fLMap != null || getChildren().b((h<FLNodeData>) rootNodeData) == -1) ? fLMap : super.getData();
    }
}
