package com.huawei.flexiblelayout.data;

import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class BlockNodeData extends FLNodeData {
    public BlockNodeData(String str) {
        super(str);
    }

    @Override // com.huawei.flexiblelayout.data.FLNodeData
    public void addChild(FLCardData fLCardData) {
        FLNodeData fLNodeData = (FLNodeData) getParent();
        if (fLNodeData == null) {
            super.addChild(fLCardData);
        } else {
            fLNodeData.addChild(fLCardData);
            fLNodeData.b(this);
        }
    }

    @Override // com.huawei.flexiblelayout.data.FLNodeData
    public List<FLCardData> c() {
        return Collections.unmodifiableList(super.c());
    }

    @Override // com.huawei.flexiblelayout.data.FLNodeData
    public int indexOf(FLCardData fLCardData) {
        FLNodeData fLNodeData = (FLNodeData) getParent();
        if (fLNodeData == null) {
            return super.indexOf(fLCardData);
        }
        return fLNodeData.indexOf(fLCardData);
    }
}
