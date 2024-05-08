package com.vivo.push.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChangeNetPermissionTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b extends com.vivo.push.s {
    public b(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        boolean b4;
        com.vivo.push.model.b a10 = com.vivo.push.util.aa.a(this.f46360a, com.vivo.push.restructure.a.a().f());
        try {
            if (((com.vivo.push.b.d) vVar).d()) {
                b4 = j.a(this.f46360a);
            } else {
                b4 = j.b(this.f46360a);
            }
            if (b4) {
                com.vivo.push.model.b a11 = com.vivo.push.util.aa.a(this.f46360a, com.vivo.push.restructure.a.a().f());
                if (a10 == null || a11 == null || a11.a() == null || !a11.a().equals(a10.a())) {
                    if (a10 != null && a10.a() != null) {
                        com.vivo.push.a.a.a(this.f46360a, a10.a(), new com.vivo.push.b.y(a10.a()));
                    }
                    if (a11 == null || a11.a() == null) {
                        return;
                    }
                    com.vivo.push.b.f fVar = new com.vivo.push.b.f();
                    com.vivo.push.restructure.a.a();
                    fVar.d();
                    com.vivo.push.a.a.a(this.f46360a, a11.a(), fVar);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
