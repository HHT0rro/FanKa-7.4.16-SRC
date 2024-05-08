package com.tencent.bugly.idasc.proguard;

import com.huawei.quickcard.base.Attributes;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bt extends m implements Cloneable {

    /* renamed from: n, reason: collision with root package name */
    public static Map<String, String> f39838n;

    /* renamed from: a, reason: collision with root package name */
    public boolean f39840a = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f39841b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f39842c = true;

    /* renamed from: d, reason: collision with root package name */
    public String f39843d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f39844e = "";

    /* renamed from: f, reason: collision with root package name */
    public bs f39845f = null;

    /* renamed from: g, reason: collision with root package name */
    public Map<String, String> f39846g = null;

    /* renamed from: h, reason: collision with root package name */
    public long f39847h = 0;

    /* renamed from: i, reason: collision with root package name */
    public String f39848i = "";

    /* renamed from: j, reason: collision with root package name */
    public String f39849j = "";

    /* renamed from: k, reason: collision with root package name */
    public int f39850k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f39851l = 0;

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ boolean f39839o = true;

    /* renamed from: m, reason: collision with root package name */
    public static bs f39837m = new bs();

    static {
        HashMap hashMap = new HashMap();
        f39838n = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(k kVar) {
        this.f39840a = kVar.a(0, true);
        this.f39841b = kVar.a(1, true);
        this.f39842c = kVar.a(2, true);
        this.f39843d = kVar.b(3, false);
        this.f39844e = kVar.b(4, false);
        this.f39845f = (bs) kVar.a((m) f39837m, 5, false);
        this.f39846g = (Map) kVar.a((k) f39838n, 6, false);
        this.f39847h = kVar.a(this.f39847h, 7, false);
        this.f39848i = kVar.b(8, false);
        this.f39849j = kVar.b(9, false);
        this.f39850k = kVar.a(this.f39850k, 10, false);
        this.f39851l = kVar.a(this.f39851l, 11, false);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f39840a, 0);
        lVar.a(this.f39841b, 1);
        lVar.a(this.f39842c, 2);
        String str = this.f39843d;
        if (str != null) {
            lVar.a(str, 3);
        }
        String str2 = this.f39844e;
        if (str2 != null) {
            lVar.a(str2, 4);
        }
        bs bsVar = this.f39845f;
        if (bsVar != null) {
            lVar.a((m) bsVar, 5);
        }
        Map<String, String> map = this.f39846g;
        if (map != null) {
            lVar.a((Map) map, 6);
        }
        lVar.a(this.f39847h, 7);
        String str3 = this.f39848i;
        if (str3 != null) {
            lVar.a(str3, 8);
        }
        String str4 = this.f39849j;
        if (str4 != null) {
            lVar.a(str4, 9);
        }
        lVar.a(this.f39850k, 10);
        lVar.a(this.f39851l, 11);
    }

    @Override // com.tencent.bugly.idasc.proguard.m
    public final void a(StringBuilder sb2, int i10) {
        i iVar = new i(sb2, i10);
        iVar.a(this.f39840a, Attributes.Style.ENABLE);
        iVar.a(this.f39841b, "enableUserInfo");
        iVar.a(this.f39842c, "enableQuery");
        iVar.a(this.f39843d, "url");
        iVar.a(this.f39844e, "expUrl");
        iVar.a((m) this.f39845f, "security");
        iVar.a((Map) this.f39846g, "valueMap");
        iVar.a(this.f39847h, "strategylastUpdateTime");
        iVar.a(this.f39848i, "httpsUrl");
        iVar.a(this.f39849j, "httpsExpUrl");
        iVar.a(this.f39850k, "eventRecordCount");
        iVar.a(this.f39851l, "eventTimeInterval");
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f39839o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        bt btVar = (bt) obj;
        return n.a(this.f39840a, btVar.f39840a) && n.a(this.f39841b, btVar.f39841b) && n.a(this.f39842c, btVar.f39842c) && n.a(this.f39843d, btVar.f39843d) && n.a(this.f39844e, btVar.f39844e) && n.a(this.f39845f, btVar.f39845f) && n.a(this.f39846g, btVar.f39846g) && n.a(this.f39847h, btVar.f39847h) && n.a(this.f39848i, btVar.f39848i) && n.a(this.f39849j, btVar.f39849j) && n.a(this.f39850k, btVar.f39850k) && n.a(this.f39851l, btVar.f39851l);
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
