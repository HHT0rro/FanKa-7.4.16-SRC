package com.tencent.cloud.huiyansdkface.a;

import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e implements b {

    /* renamed from: a, reason: collision with root package name */
    private List<b> f40415a = new ArrayList();

    public e a(b bVar) {
        if (bVar != null && !this.f40415a.contains(bVar)) {
            this.f40415a.add(bVar);
        }
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.b
    public void a() {
        for (int size = this.f40415a.size() - 1; size >= 0; size--) {
            this.f40415a.get(size).a();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.b
    public void a(com.tencent.cloud.huiyansdkface.a.c.a aVar) {
        for (int i10 = 0; i10 < this.f40415a.size(); i10++) {
            this.f40415a.get(i10).a(aVar);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.b
    public void a(com.tencent.cloud.huiyansdkface.a.c.a aVar, com.tencent.cloud.huiyansdkface.a.c.d dVar, com.tencent.cloud.huiyansdkface.a.a.a aVar2) {
        for (int i10 = 0; i10 < this.f40415a.size(); i10++) {
            this.f40415a.get(i10).a(aVar, dVar, aVar2);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.b
    public void a(com.tencent.cloud.huiyansdkface.a.g.b bVar, com.tencent.cloud.huiyansdkface.a.a.a aVar, com.tencent.cloud.huiyansdkface.a.e.b bVar2, com.tencent.cloud.huiyansdkface.a.c.d dVar) {
        for (int i10 = 0; i10 < this.f40415a.size(); i10++) {
            this.f40415a.get(i10).a(bVar, aVar, bVar2, dVar);
        }
    }

    public e b(b bVar) {
        if (bVar != null && this.f40415a.contains(bVar)) {
            this.f40415a.remove(bVar);
        }
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.b
    public void b(com.tencent.cloud.huiyansdkface.a.c.a aVar) {
        for (int size = this.f40415a.size() - 1; size >= 0; size--) {
            this.f40415a.get(size).b(aVar);
        }
    }
}
