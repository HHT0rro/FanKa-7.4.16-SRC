package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o1 extends k1 {
    public o1() {
        super();
    }

    public static <E> c1<E> e(Object obj, long j10) {
        return (c1) p3.M(obj, j10);
    }

    @Override // com.google.android.gms.internal.clearcut.k1
    public final void a(Object obj, long j10) {
        e(obj, j10).k();
    }

    @Override // com.google.android.gms.internal.clearcut.k1
    public final <E> void b(Object obj, Object obj2, long j10) {
        c1 e2 = e(obj, j10);
        c1 e10 = e(obj2, j10);
        int size = e2.size();
        int size2 = e10.size();
        if (size > 0 && size2 > 0) {
            if (!e2.j()) {
                e2 = e2.d(size2 + size);
            }
            e2.addAll(e10);
        }
        if (size > 0) {
            e10 = e2;
        }
        p3.i(obj, j10, e10);
    }
}
