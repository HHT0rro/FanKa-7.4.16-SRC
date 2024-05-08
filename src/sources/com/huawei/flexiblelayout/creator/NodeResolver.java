package com.huawei.flexiblelayout.creator;

import com.huawei.flexiblelayout.card.FLNode;
import com.huawei.flexiblelayout.data.FLNodeData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface NodeResolver {
    <T extends FLNode> T create();

    <T extends FLNodeData> T createData(String str);
}
