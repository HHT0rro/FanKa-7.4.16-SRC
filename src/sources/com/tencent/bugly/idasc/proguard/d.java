package com.tencent.bugly.idasc.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d extends c {

    /* renamed from: e, reason: collision with root package name */
    public HashMap<String, byte[]> f39873e = null;

    /* renamed from: g, reason: collision with root package name */
    private HashMap<String, Object> f39875g = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    public k f39874f = new k();

    private void c(String str, Object obj) {
        this.f39875g.put(str, obj);
    }

    @Override // com.tencent.bugly.idasc.proguard.c
    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    @Override // com.tencent.bugly.idasc.proguard.c
    public <T> void a(String str, T t2) {
        if (this.f39873e == null) {
            super.a(str, (String) t2);
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t2 == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t2 instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        l lVar = new l();
        lVar.a(this.f39870c);
        lVar.a(t2, 0);
        this.f39873e.put(str, n.a(lVar.f39901a));
    }

    @Override // com.tencent.bugly.idasc.proguard.c
    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception unused) {
            this.f39874f.a(bArr);
            this.f39874f.a(this.f39870c);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f39873e = this.f39874f.a((Map) hashMap, 0, false);
        }
    }

    @Override // com.tencent.bugly.idasc.proguard.c
    public byte[] a() {
        if (this.f39873e == null) {
            return super.a();
        }
        l lVar = new l(0);
        lVar.a(this.f39870c);
        lVar.a((Map) this.f39873e, 0);
        return n.a(lVar.f39901a);
    }

    public final <T> T b(String str, T t2) throws b {
        HashMap<String, byte[]> hashMap = this.f39873e;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            if (!this.f39875g.containsKey(str)) {
                try {
                    this.f39874f.a(this.f39873e.get(str));
                    this.f39874f.a(this.f39870c);
                    T t10 = (T) this.f39874f.a((k) t2, 0, true);
                    if (t10 != null) {
                        c(str, t10);
                    }
                    return t10;
                } catch (Exception e2) {
                    throw new b(e2);
                }
            }
        } else {
            if (!this.f39868a.containsKey(str)) {
                return null;
            }
            if (!this.f39875g.containsKey(str)) {
                byte[] bArr = new byte[0];
                Iterator<Map.Entry<String, byte[]>> iterator2 = this.f39868a.get(str).entrySet().iterator2();
                if (iterator2.hasNext()) {
                    Map.Entry<String, byte[]> next = iterator2.next();
                    next.getKey();
                    bArr = next.getValue();
                }
                try {
                    this.f39874f.a(bArr);
                    this.f39874f.a(this.f39870c);
                    T t11 = (T) this.f39874f.a((k) t2, 0, true);
                    c(str, t11);
                    return t11;
                } catch (Exception e10) {
                    throw new b(e10);
                }
            }
        }
        return (T) this.f39875g.get(str);
    }

    public void b() {
        this.f39873e = new HashMap<>();
    }
}
