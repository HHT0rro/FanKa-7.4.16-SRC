package com.google.common.collect;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class Sets$CartesianSet$1 extends ImmutableList<List<Object>> {
    public final /* synthetic */ ImmutableList val$axes;

    public Sets$CartesianSet$1(ImmutableList immutableList) {
        this.val$axes = immutableList;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.val$axes.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List
    public List<Object> get(int i10) {
        return ((ImmutableSet) this.val$axes.get(i10)).asList();
    }
}
