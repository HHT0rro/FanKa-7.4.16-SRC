package com.huawei.flexiblelayout;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.b;
import com.huawei.flexiblelayout.card.FLCell;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ParentExpression.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class h implements b.a {

    /* renamed from: a, reason: collision with root package name */
    public static final h f28142a = new h();

    @Override // com.huawei.flexiblelayout.b.a
    @NonNull
    public List<FLCell<?>> a(@NonNull List<FLCell<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (FLCell<?> fLCell : list) {
            if (fLCell.getParent() instanceof FLCell) {
                arrayList.add((FLCell) fLCell.getParent());
            }
        }
        return arrayList;
    }
}
