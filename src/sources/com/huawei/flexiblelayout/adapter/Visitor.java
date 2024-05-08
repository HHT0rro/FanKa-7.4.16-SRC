package com.huawei.flexiblelayout.adapter;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.card.FLNode;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface Visitor {
    boolean onVisitCard(@NonNull FLCell<?> fLCell);

    boolean onVisitNode(@NonNull FLNode<?> fLNode);
}
