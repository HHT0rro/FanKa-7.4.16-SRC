package com.vivo.push.b;

import com.baidu.mobads.sdk.internal.bk;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: TagCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class z extends c {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f46134a;

    public z(boolean z10, String str, ArrayList<String> arrayList) {
        super(z10 ? 2004 : 2005, str);
        this.f46134a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a(bk.f9903l, (Serializable) this.f46134a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f46134a = dVar.c(bk.f9903l);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "TagCommand";
    }
}
