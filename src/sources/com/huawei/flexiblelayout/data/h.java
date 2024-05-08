package com.huawei.flexiblelayout.data;

import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FLReactDataList.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class h<T extends FLCardData> {

    /* renamed from: a, reason: collision with root package name */
    private GroupLayoutStrategy f28106a;

    /* renamed from: b, reason: collision with root package name */
    private final List<T> f28107b = new ArrayList();

    public h(GroupLayoutStrategy groupLayoutStrategy) {
        this.f28106a = groupLayoutStrategy;
    }

    public boolean a() {
        return this.f28107b.isEmpty();
    }

    public int b() {
        return this.f28107b.size();
    }

    public boolean c(T t2) {
        boolean remove = this.f28107b.remove(t2);
        if (remove) {
            c();
        }
        return remove;
    }

    public boolean a(T t2) {
        this.f28106a.update(t2);
        return this.f28107b.add(t2);
    }

    public T b(int i10) {
        T remove = this.f28107b.remove(i10);
        if (remove != null) {
            c();
        }
        return remove;
    }

    public void c() {
        this.f28106a.clear();
        this.f28106a.update(this.f28107b);
    }

    public void a(int i10, T t2) {
        this.f28107b.add(i10, t2);
        c();
    }

    public int b(T t2) {
        return this.f28107b.indexOf(t2);
    }

    public T a(int i10) {
        return this.f28107b.get(i10);
    }
}
