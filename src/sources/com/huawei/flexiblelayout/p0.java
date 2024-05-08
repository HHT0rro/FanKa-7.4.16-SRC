package com.huawei.flexiblelayout;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.primitive.ListModel;
import java.util.List;

/* compiled from: ListWrapper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class p0 implements ListModel {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final List<Object> f28279a;

    public p0(@NonNull List<Object> list) {
        this.f28279a = list;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.ListModel
    public Object get(int i10) {
        return this.f28279a.get(i10);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.ListModel
    public boolean isEmpty() {
        return this.f28279a.isEmpty();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.ListModel
    public int size() {
        return this.f28279a.size();
    }
}
