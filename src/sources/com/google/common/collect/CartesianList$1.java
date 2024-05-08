package com.google.common.collect;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class CartesianList$1 extends ImmutableList<Object> {
    public final /* synthetic */ l this$0;
    public final /* synthetic */ int val$index;

    public CartesianList$1(l lVar, int i10) {
        this.val$index = i10;
    }

    @Override // java.util.List
    public Object get(int i10) {
        com.google.common.base.o.p(i10, size());
        return ((List) l.b(null).get(i10)).get(l.c(null, this.val$index, i10));
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return l.b(null).size();
    }
}
