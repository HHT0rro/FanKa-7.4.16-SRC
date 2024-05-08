package com.xiaomi.push;

import android.util.SparseArray;
import com.xiaomi.push.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class q extends n.b {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f48087c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(n nVar, n.a aVar) {
        super(aVar);
        this.f48087c = nVar;
    }

    @Override // com.xiaomi.push.n.b
    public void b() {
        Object obj;
        SparseArray sparseArray;
        obj = this.f48087c.f47980c;
        synchronized (obj) {
            sparseArray = this.f48087c.f47979b;
            sparseArray.remove(this.f47982b.a());
        }
    }
}
