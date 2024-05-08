package com.tencent.bugly.proguard;

import com.huawei.quickcard.base.Attributes;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ap extends k implements Cloneable {

    /* renamed from: n, reason: collision with root package name */
    private static Map<String, String> f40088n;

    /* renamed from: o, reason: collision with root package name */
    private static /* synthetic */ boolean f40089o = true;

    /* renamed from: m, reason: collision with root package name */
    private static ao f40087m = new ao();

    /* renamed from: a, reason: collision with root package name */
    public boolean f40090a = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f40091b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f40092c = true;

    /* renamed from: d, reason: collision with root package name */
    public String f40093d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f40094e = "";

    /* renamed from: f, reason: collision with root package name */
    public ao f40095f = null;

    /* renamed from: g, reason: collision with root package name */
    public Map<String, String> f40096g = null;

    /* renamed from: h, reason: collision with root package name */
    public long f40097h = 0;

    /* renamed from: j, reason: collision with root package name */
    private String f40099j = "";

    /* renamed from: k, reason: collision with root package name */
    private String f40100k = "";

    /* renamed from: l, reason: collision with root package name */
    private int f40101l = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f40098i = 0;

    static {
        HashMap hashMap = new HashMap();
        f40088n = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.f40090a, 0);
        jVar.a(this.f40091b, 1);
        jVar.a(this.f40092c, 2);
        String str = this.f40093d;
        if (str != null) {
            jVar.a(str, 3);
        }
        String str2 = this.f40094e;
        if (str2 != null) {
            jVar.a(str2, 4);
        }
        ao aoVar = this.f40095f;
        if (aoVar != null) {
            jVar.a((k) aoVar, 5);
        }
        Map<String, String> map = this.f40096g;
        if (map != null) {
            jVar.a((Map) map, 6);
        }
        jVar.a(this.f40097h, 7);
        String str3 = this.f40099j;
        if (str3 != null) {
            jVar.a(str3, 8);
        }
        String str4 = this.f40100k;
        if (str4 != null) {
            jVar.a(str4, 9);
        }
        jVar.a(this.f40101l, 10);
        jVar.a(this.f40098i, 11);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f40089o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ap apVar = (ap) obj;
        return l.a(this.f40090a, apVar.f40090a) && l.a(this.f40091b, apVar.f40091b) && l.a(this.f40092c, apVar.f40092c) && l.a(this.f40093d, apVar.f40093d) && l.a(this.f40094e, apVar.f40094e) && l.a(this.f40095f, apVar.f40095f) && l.a(this.f40096g, apVar.f40096g) && l.a(this.f40097h, apVar.f40097h) && l.a(this.f40099j, apVar.f40099j) && l.a(this.f40100k, apVar.f40100k) && l.a(this.f40101l, apVar.f40101l) && l.a(this.f40098i, apVar.f40098i);
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.f40090a = iVar.a(0, true);
        this.f40091b = iVar.a(1, true);
        this.f40092c = iVar.a(2, true);
        this.f40093d = iVar.b(3, false);
        this.f40094e = iVar.b(4, false);
        this.f40095f = (ao) iVar.a((k) f40087m, 5, false);
        this.f40096g = (Map) iVar.a((i) f40088n, 6, false);
        this.f40097h = iVar.a(this.f40097h, 7, false);
        this.f40099j = iVar.b(8, false);
        this.f40100k = iVar.b(9, false);
        this.f40101l = iVar.a(this.f40101l, 10, false);
        this.f40098i = iVar.a(this.f40098i, 11, false);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb2, int i10) {
        h hVar = new h(sb2, i10);
        hVar.a(this.f40090a, Attributes.Style.ENABLE);
        hVar.a(this.f40091b, "enableUserInfo");
        hVar.a(this.f40092c, "enableQuery");
        hVar.a(this.f40093d, "url");
        hVar.a(this.f40094e, "expUrl");
        hVar.a((k) this.f40095f, "security");
        hVar.a((Map) this.f40096g, "valueMap");
        hVar.a(this.f40097h, "strategylastUpdateTime");
        hVar.a(this.f40099j, "httpsUrl");
        hVar.a(this.f40100k, "httpsExpUrl");
        hVar.a(this.f40101l, "eventRecordCount");
        hVar.a(this.f40098i, "eventTimeInterval");
    }
}
