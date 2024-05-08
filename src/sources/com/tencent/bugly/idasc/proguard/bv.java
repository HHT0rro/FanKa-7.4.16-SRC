package com.tencent.bugly.idasc.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bv extends m implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public static ArrayList<bu> f39861f;

    /* renamed from: g, reason: collision with root package name */
    public static Map<String, String> f39862g;

    /* renamed from: a, reason: collision with root package name */
    public byte f39863a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f39864b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f39865c = "";

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<bu> f39866d = null;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, String> f39867e = null;

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(k kVar) {
        this.f39863a = kVar.a(this.f39863a, 0, true);
        this.f39864b = kVar.b(1, false);
        this.f39865c = kVar.b(2, false);
        if (f39861f == null) {
            f39861f = new ArrayList<>();
            f39861f.add(new bu());
        }
        this.f39866d = (ArrayList) kVar.a((k) f39861f, 3, false);
        if (f39862g == null) {
            HashMap hashMap = new HashMap();
            f39862g = hashMap;
            hashMap.put("", "");
        }
        this.f39867e = (Map) kVar.a((k) f39862g, 4, false);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f39863a, 0);
        String str = this.f39864b;
        if (str != null) {
            lVar.a(str, 1);
        }
        String str2 = this.f39865c;
        if (str2 != null) {
            lVar.a(str2, 2);
        }
        ArrayList<bu> arrayList = this.f39866d;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f39867e;
        if (map != null) {
            lVar.a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(StringBuilder sb2, int i10) {
    }
}
