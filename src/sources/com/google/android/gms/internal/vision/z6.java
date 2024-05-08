package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class z6 implements Iterator {

    /* renamed from: b, reason: collision with root package name */
    public int f25714b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f25715c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ x6 f25716d;

    public z6(x6 x6Var) {
        List list;
        this.f25716d = x6Var;
        list = x6Var.f25697c;
        this.f25714b = list.size();
    }

    public final Iterator a() {
        Map map;
        if (this.f25715c == null) {
            map = this.f25716d.f25701g;
            this.f25715c = map.entrySet().iterator2();
        }
        return this.f25715c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i10 = this.f25714b;
        if (i10 > 0) {
            list = this.f25716d.f25697c;
            if (i10 <= list.size()) {
                return true;
            }
        }
        return a().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        if (a().hasNext()) {
            return (Map.Entry) a().next();
        }
        list = this.f25716d.f25697c;
        int i10 = this.f25714b - 1;
        this.f25714b = i10;
        return (Map.Entry) list.get(i10);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ z6(x6 x6Var, w6 w6Var) {
        this(x6Var);
    }
}
