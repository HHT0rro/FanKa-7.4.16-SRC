package com.huawei.flexiblelayout.parser;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.FLDataSource;
import com.huawei.flexiblelayout.data.FLNodeData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface FLDataDelegate {
    @Nullable
    FLDataGroup onApplyGroup(FLDataSource fLDataSource, FLDataGroup fLDataGroup, DataItem dataItem);

    @Nullable
    FLNodeData onApplyNode(FLDataGroup fLDataGroup, FLNodeData fLNodeData, DataItem dataItem);

    @Nullable
    DataItem onParseGroup(@NonNull DataItem dataItem, @NonNull DataItem dataItem2);

    @Nullable
    DataItem onParseNode(@NonNull DataItem dataItem, @NonNull DataItem dataItem2);
}
