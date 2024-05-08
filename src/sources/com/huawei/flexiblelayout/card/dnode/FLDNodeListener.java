package com.huawei.flexiblelayout.card.dnode;

import androidx.annotation.NonNull;
import androidx.annotation.Px;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLDNodeData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface FLDNodeListener {
    void onDockingChanged(@NonNull FLContext fLContext, @NonNull FLDNodeData fLDNodeData, @NonNull FLCardData fLCardData, @NonNull FLDockingView fLDockingView, @Px int i10);

    void onDockingEnd(@NonNull FLContext fLContext, @NonNull FLDNodeData fLDNodeData, @NonNull FLCardData fLCardData, @NonNull FLDockingView fLDockingView);

    void onDockingStart(@NonNull FLContext fLContext, @NonNull FLDNodeData fLDNodeData, @NonNull FLCardData fLCardData, @NonNull FLDockingView fLDockingView);
}
