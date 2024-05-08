package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ai extends k implements Cloneable {

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<String> f40014c;

    /* renamed from: a, reason: collision with root package name */
    private String f40015a = "";

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<String> f40016b = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f40015a, 0);
        ArrayList<String> arrayList = this.f40016b;
        if (arrayList != null) {
            jVar.a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb2, int i10) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f40015a = iVar.b(0, true);
        if (f40014c == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f40014c = arrayList;
            arrayList.add("");
        }
        this.f40016b = (ArrayList) iVar.a((i) f40014c, 1, false);
    }
}
