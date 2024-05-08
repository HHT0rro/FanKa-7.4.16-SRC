package com.huawei.hms.scankit.p;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ParticleAnimators.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class x5 implements f4 {

    /* renamed from: a, reason: collision with root package name */
    private List<f4> f31721a = new ArrayList();

    @Override // com.huawei.hms.scankit.p.f4
    public void a(@NonNull w5 w5Var, long j10) {
        Iterator<f4> iterator2 = this.f31721a.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a(w5Var, j10);
        }
    }

    public void a(@NonNull f4 f4Var) {
        if (this.f31721a == null) {
            this.f31721a = new ArrayList();
        }
        this.f31721a.add(f4Var);
    }
}
