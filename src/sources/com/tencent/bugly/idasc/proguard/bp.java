package com.tencent.bugly.idasc.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bp extends m implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    public static ArrayList<bo> f39797b;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<bo> f39798a = null;

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(k kVar) {
        if (f39797b == null) {
            f39797b = new ArrayList<>();
            f39797b.add(new bo());
        }
        this.f39798a = (ArrayList) kVar.a((k) f39797b, 0, true);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(l lVar) {
        lVar.a((Collection) this.f39798a, 0);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(StringBuilder sb2, int i10) {
    }
}
