package com.huawei.flexiblelayout;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.b;
import com.huawei.flexiblelayout.card.FLCell;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IndexPredicate.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class k implements b.InterfaceC0264b {

    /* renamed from: a, reason: collision with root package name */
    private final int f28179a;

    public k(int i10) {
        this.f28179a = i10;
    }

    @Override // com.huawei.flexiblelayout.b.InterfaceC0264b
    @NonNull
    public List<FLCell<?>> a(@NonNull List<FLCell<?>> list) {
        ArrayList arrayList = new ArrayList();
        int i10 = this.f28179a;
        if (i10 >= 1 && i10 <= list.size()) {
            arrayList.add(list.get(this.f28179a - 1));
        }
        return arrayList;
    }
}
