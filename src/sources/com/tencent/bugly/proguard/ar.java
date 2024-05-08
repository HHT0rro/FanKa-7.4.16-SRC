package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ar extends k implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    private static ArrayList<aq> f40111f;

    /* renamed from: g, reason: collision with root package name */
    private static Map<String, String> f40112g;

    /* renamed from: a, reason: collision with root package name */
    public byte f40113a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f40114b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f40115c = "";

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<aq> f40116d = null;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, String> f40117e = null;

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f40113a, 0);
        String str = this.f40114b;
        if (str != null) {
            jVar.a(str, 1);
        }
        String str2 = this.f40115c;
        if (str2 != null) {
            jVar.a(str2, 2);
        }
        ArrayList<aq> arrayList = this.f40116d;
        if (arrayList != null) {
            jVar.a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f40117e;
        if (map != null) {
            jVar.a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb2, int i10) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f40113a = iVar.a(this.f40113a, 0, true);
        this.f40114b = iVar.b(1, false);
        this.f40115c = iVar.b(2, false);
        if (f40111f == null) {
            f40111f = new ArrayList<>();
            f40111f.add(new aq());
        }
        this.f40116d = (ArrayList) iVar.a((i) f40111f, 3, false);
        if (f40112g == null) {
            HashMap hashMap = new HashMap();
            f40112g = hashMap;
            hashMap.put("", "");
        }
        this.f40117e = (Map) iVar.a((i) f40112g, 4, false);
    }
}
