package com.xiaomi.push;

import com.xiaomi.push.e2;
import com.xiaomi.push.r;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class g2 extends r.b {

    /* renamed from: a, reason: collision with root package name */
    public r.b f47316a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e2 f47317b;

    public g2(e2 e2Var) {
        this.f47317b = e2Var;
    }

    @Override // com.xiaomi.push.r.b
    public void b() {
        e2.b bVar = (e2.b) this.f47317b.f47198a.peek();
        if (bVar == null || !bVar.d()) {
            return;
        }
        if (this.f47317b.f47198a.remove(bVar)) {
            this.f47316a = bVar;
        }
        r.b bVar2 = this.f47316a;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    @Override // com.xiaomi.push.r.b
    public void c() {
        r.b bVar = this.f47316a;
        if (bVar != null) {
            bVar.c();
        }
    }
}
