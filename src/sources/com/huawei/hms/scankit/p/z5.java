package com.huawei.hms.scankit.p;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ParticleProperties.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class z5 implements g4 {

    /* renamed from: a, reason: collision with root package name */
    private List<g4> f31790a = new ArrayList();

    @Override // com.huawei.hms.scankit.p.g4
    public void a(@NonNull w5 w5Var) {
        Iterator<g4> iterator2 = this.f31790a.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a(w5Var);
        }
    }

    public void a(@NonNull g4 g4Var) {
        if (this.f31790a == null) {
            this.f31790a = new ArrayList();
        }
        this.f31790a.add(g4Var);
    }
}
