package com.huawei.flexiblelayout;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.b;
import com.huawei.flexiblelayout.card.FLCell;
import java.util.Collections;
import java.util.List;

/* compiled from: RootExpression.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class i implements b.a {

    /* renamed from: a, reason: collision with root package name */
    public static final i f28147a = new i();

    @Override // com.huawei.flexiblelayout.b.a
    @NonNull
    public List<FLCell<?>> a(@NonNull List<FLCell<?>> list) {
        if (list.isEmpty()) {
            return list;
        }
        FLCell<?> fLCell = null;
        for (FLCell<?> fLCell2 = list.get(0); fLCell2 != null; fLCell2 = (FLCell) fLCell2.getParent()) {
            fLCell = fLCell2;
        }
        return fLCell != null ? Collections.singletonList(fLCell) : Collections.emptyList();
    }
}
