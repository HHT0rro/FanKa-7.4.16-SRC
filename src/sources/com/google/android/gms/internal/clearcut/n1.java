package com.google.android.gms.internal.clearcut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class n1 extends k1 {

    /* renamed from: c, reason: collision with root package name */
    public static final Class<?> f23957c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public n1() {
        super();
    }

    public static <E> List<E> e(Object obj, long j10) {
        return (List) p3.M(obj, j10);
    }

    @Override // com.google.android.gms.internal.clearcut.k1
    public final void a(Object obj, long j10) {
        Object unmodifiableList;
        List list = (List) p3.M(obj, j10);
        if (list instanceof j1) {
            unmodifiableList = ((j1) list).w();
        } else if (f23957c.isAssignableFrom(list.getClass())) {
            return;
        } else {
            unmodifiableList = Collections.unmodifiableList(list);
        }
        p3.i(obj, j10, unmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.clearcut.k1
    public final <E> void b(Object obj, Object obj2, long j10) {
        i1 i1Var;
        List e2 = e(obj2, j10);
        int size = e2.size();
        List e10 = e(obj, j10);
        if (e10.isEmpty()) {
            e10 = e10 instanceof j1 ? new i1(size) : new ArrayList(size);
            p3.i(obj, j10, e10);
        } else {
            if (f23957c.isAssignableFrom(e10.getClass())) {
                ArrayList arrayList = new ArrayList(e10.size() + size);
                arrayList.addAll(e10);
                i1Var = arrayList;
            } else if (e10 instanceof m3) {
                i1 i1Var2 = new i1(e10.size() + size);
                i1Var2.addAll((m3) e10);
                i1Var = i1Var2;
            }
            p3.i(obj, j10, i1Var);
            e10 = i1Var;
        }
        int size2 = e10.size();
        int size3 = e2.size();
        if (size2 > 0 && size3 > 0) {
            e10.addAll(e2);
        }
        if (size2 > 0) {
            e2 = e10;
        }
        p3.i(obj, j10, e2);
    }
}
