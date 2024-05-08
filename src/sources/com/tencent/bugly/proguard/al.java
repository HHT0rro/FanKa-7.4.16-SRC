package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class al extends k implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList<ak> f40047b;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<ak> f40048a = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a((Collection) this.f40048a, 0);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb2, int i10) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        if (f40047b == null) {
            f40047b = new ArrayList<>();
            f40047b.add(new ak());
        }
        this.f40048a = (ArrayList) iVar.a((i) f40047b, 0, true);
    }
}
