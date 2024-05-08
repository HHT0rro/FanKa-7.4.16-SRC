package com.huawei.quickcard.views.list;

import androidx.annotation.NonNull;
import com.huawei.quickcard.action.ActionsHelper;
import com.huawei.quickcard.framework.processor.EventProcessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d implements EventProcessor<QRecyclerView> {
    @Override // com.huawei.quickcard.framework.processor.EventProcessor
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void cleanEvent(@NonNull QRecyclerView qRecyclerView, String str) {
        qRecyclerView.setOnScrollTopEvent(null);
    }

    @Override // com.huawei.quickcard.framework.processor.EventProcessor
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void applyEvent(@NonNull final QRecyclerView qRecyclerView, String str, final String str2) {
        qRecyclerView.setOnScrollTopEvent(new j() { // from class: com.huawei.quickcard.views.list.p
            @Override // com.huawei.quickcard.views.list.j
            public final void a() {
                ActionsHelper.doAction(QRecyclerView.this, str2, null);
            }
        });
    }
}
