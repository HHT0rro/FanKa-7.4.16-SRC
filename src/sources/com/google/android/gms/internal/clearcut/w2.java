package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class w2 implements Iterator {

    /* renamed from: b, reason: collision with root package name */
    public int f24068b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f24069c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ u2 f24070d;

    public w2(u2 u2Var) {
        List list;
        this.f24070d = u2Var;
        list = u2Var.f24055c;
        this.f24068b = list.size();
    }

    public /* synthetic */ w2(u2 u2Var, v2 v2Var) {
        this(u2Var);
    }

    public final Iterator a() {
        Map map;
        if (this.f24069c == null) {
            map = this.f24070d.f24059g;
            this.f24069c = map.entrySet().iterator2();
        }
        return this.f24069c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i10 = this.f24068b;
        if (i10 > 0) {
            list = this.f24070d.f24055c;
            if (i10 <= list.size()) {
                return true;
            }
        }
        return a().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        Object obj;
        if (a().hasNext()) {
            obj = a().next();
        } else {
            list = this.f24070d.f24055c;
            int i10 = this.f24068b - 1;
            this.f24068b = i10;
            obj = list.get(i10);
        }
        return (Map.Entry) obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
