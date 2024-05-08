package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c extends a {

    /* renamed from: d, reason: collision with root package name */
    public HashMap<String, byte[]> f40118d = null;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, Object> f40119e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private i f40120f = new i();

    @Override // com.tencent.bugly.proguard.a
    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    public final <T> T b(String str, T t2) throws b {
        HashMap<String, byte[]> hashMap = this.f40118d;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            if (this.f40119e.containsKey(str)) {
                return (T) this.f40119e.get(str);
            }
            try {
                this.f40120f.a(this.f40118d.get(str));
                this.f40120f.a(this.f39995b);
                T t10 = (T) this.f40120f.a((i) t2, 0, true);
                if (t10 != null) {
                    this.f40119e.put(str, t10);
                }
                return t10;
            } catch (Exception e2) {
                throw new b(e2);
            }
        }
        if (!this.f39994a.containsKey(str)) {
            return null;
        }
        if (this.f40119e.containsKey(str)) {
            return (T) this.f40119e.get(str);
        }
        byte[] bArr = new byte[0];
        Iterator<Map.Entry<String, byte[]>> iterator2 = this.f39994a.get(str).entrySet().iterator2();
        if (iterator2.hasNext()) {
            Map.Entry<String, byte[]> next = iterator2.next();
            next.getKey();
            bArr = next.getValue();
        }
        try {
            this.f40120f.a(bArr);
            this.f40120f.a(this.f39995b);
            T t11 = (T) this.f40120f.a((i) t2, 0, true);
            this.f40119e.put(str, t11);
            return t11;
        } catch (Exception e10) {
            throw new b(e10);
        }
    }

    public void c() {
        this.f40118d = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.a
    public <T> void a(String str, T t2) {
        if (this.f40118d == null) {
            super.a(str, (String) t2);
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t2 != null) {
            if (!(t2 instanceof Set)) {
                j jVar = new j();
                jVar.a(this.f39995b);
                jVar.a(t2, 0);
                this.f40118d.put(str, l.a(jVar.a()));
                return;
            }
            throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
    }

    @Override // com.tencent.bugly.proguard.a
    public byte[] a() {
        if (this.f40118d != null) {
            j jVar = new j(0);
            jVar.a(this.f39995b);
            jVar.a((Map) this.f40118d, 0);
            return l.a(jVar.a());
        }
        return super.a();
    }

    @Override // com.tencent.bugly.proguard.a
    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception unused) {
            this.f40120f.a(bArr);
            this.f40120f.a(this.f39995b);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f40118d = this.f40120f.a((Map) hashMap, 0, false);
        }
    }
}
