package com.cupidapp.live.base.recyclerview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MutableColumnRecyclerAdapter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class MutableColumnRecyclerAdapter extends FKBaseRecyclerViewAdapter implements g1.a {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final List<a> f12051f = new ArrayList();

    /* compiled from: MutableColumnRecyclerAdapter.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f12052a;

        /* renamed from: b, reason: collision with root package name */
        public int f12053b;

        public a(int i10, int i11) {
            this.f12052a = i10;
            this.f12053b = i11;
        }

        public final int a() {
            return this.f12053b;
        }

        public final int b() {
            return this.f12052a;
        }

        public final void c(int i10) {
            this.f12053b = i10;
        }
    }

    @Override // g1.a
    public int a(int i10) {
        Object obj;
        if (u(i10) > 1) {
            return 1;
        }
        Iterator<E> iterator2 = CollectionsKt___CollectionsKt.n0(this.f12051f).iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                obj = null;
                break;
            }
            obj = iterator2.next();
            if (((a) obj).b() <= i10) {
                break;
            }
        }
        a aVar = (a) obj;
        if (aVar == null) {
            return 1;
        }
        return (i10 - aVar.b()) % v();
    }

    @Override // g1.a
    public boolean b(int i10) {
        if (n() > i10) {
            return !w(i10);
        }
        return true;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter
    public void d(@NotNull Object model) {
        s.i(model, "model");
        super.d(model);
        if (w(kotlin.collections.s.l(j()))) {
            return;
        }
        if (w(kotlin.collections.s.l(j())) || this.f12051f.size() == 0) {
            this.f12051f.add(new a(kotlin.collections.s.l(j()), j().size()));
        } else {
            a aVar = (a) CollectionsKt___CollectionsKt.e0(this.f12051f);
            aVar.c(aVar.a() + 1);
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter
    public int e(@Nullable List<? extends Object> list) {
        int e2 = super.e(list);
        this.f12051f.clear();
        int n10 = n();
        Iterator<Object> iterator2 = j().iterator2();
        int i10 = 0;
        int i11 = 0;
        while (iterator2.hasNext()) {
            iterator2.next();
            int i12 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            if (w(i10) && i10 > i11) {
                this.f12051f.add(new a(i11, i10));
            } else if (!w(i10) && n10 == i12) {
                this.f12051f.add(new a(i11, i10));
            }
            if (w(i10)) {
                i11 = i12;
            }
            i10 = i12;
        }
        return e2;
    }

    public abstract int u(int i10);

    public abstract int v();

    public final boolean w(int i10) {
        return u(i10) == v();
    }
}
