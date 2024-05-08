package com.huawei.flexiblelayout.card.snode;

import androidx.recyclerview.widget.RecyclerView;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.data.FLSNodeData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface FLSNodeDelegate {
    RecyclerView.Adapter onCreateAdapter(FLContext fLContext, FLayout fLayout, FLSNodeData fLSNodeData);

    FLSNodeController onCreateController(FLContext fLContext, FLayout fLayout, FLSNodeData fLSNodeData);

    RecyclerView onCreateView(FLContext fLContext, FLayout fLayout);

    void onViewCreated(FLContext fLContext, FLayout fLayout, RecyclerView recyclerView);
}
