package com.tencent.bugly.idasc.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bm extends m implements Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public static ArrayList<String> f39764c;

    /* renamed from: a, reason: collision with root package name */
    public String f39765a = "";

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<String> f39766b = null;

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(k kVar) {
        this.f39765a = kVar.b(0, true);
        if (f39764c == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f39764c = arrayList;
            arrayList.add("");
        }
        this.f39766b = (ArrayList) kVar.a((k) f39764c, 1, false);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f39765a, 0);
        ArrayList<String> arrayList = this.f39766b;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(StringBuilder sb2, int i10) {
    }
}
