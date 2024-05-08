package com.bytedance.pangle.util.b.b;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public List<c> f10975a = new ArrayList();

    public final void a(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (c cVar : this.f10975a) {
            if (!set.contains(cVar.f10985h)) {
                arrayList.add(cVar);
            }
        }
        this.f10975a = arrayList;
    }
}
