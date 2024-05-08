package com.danlan.android.cognition.sensor;

import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class DataGroupArrayList<T> extends ArrayList<T> {
    private final int limit;

    public DataGroupArrayList(int i10) {
        super(i10);
        this.limit = i10;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t2) {
        if (size() >= this.limit) {
            remove(0);
        }
        return super.add(t2);
    }
}
