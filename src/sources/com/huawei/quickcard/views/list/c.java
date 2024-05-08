package com.huawei.quickcard.views.list;

import androidx.annotation.NonNull;
import com.huawei.quickcard.action.ActionsHelper;
import com.huawei.quickcard.framework.processor.EventProcessor;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c implements EventProcessor<QRecyclerView> {
    @Override // com.huawei.quickcard.framework.processor.EventProcessor
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void cleanEvent(@NonNull QRecyclerView qRecyclerView, String str) {
        qRecyclerView.setOnScrollEvent(null);
    }

    @Override // com.huawei.quickcard.framework.processor.EventProcessor
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void applyEvent(@NonNull final QRecyclerView qRecyclerView, String str, final String str2) {
        qRecyclerView.setOnScrollEvent(new i() { // from class: com.huawei.quickcard.views.list.o
            @Override // com.huawei.quickcard.views.list.i
            public final void a(Map map) {
                ActionsHelper.doAction(QRecyclerView.this, str2, map);
            }
        });
    }
}
