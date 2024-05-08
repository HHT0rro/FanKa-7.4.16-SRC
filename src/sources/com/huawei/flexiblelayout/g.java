package com.huawei.flexiblelayout;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.b;
import com.huawei.flexiblelayout.card.FLCell;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: ExpressionWithPredicate.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class g implements b.a {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final b.a f28130a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final b.InterfaceC0264b f28131b;

    public g(@NonNull b.a aVar, @NonNull b.InterfaceC0264b interfaceC0264b) {
        this.f28130a = aVar;
        this.f28131b = interfaceC0264b;
    }

    @Override // com.huawei.flexiblelayout.b.a
    @NonNull
    public List<FLCell<?>> a(@NonNull List<FLCell<?>> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<FLCell<?>> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.addAll(this.f28131b.a(this.f28130a.a(Collections.singletonList(iterator2.next()))));
        }
        return arrayList;
    }
}
