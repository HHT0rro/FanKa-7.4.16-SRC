package com.cmic.sso.sdk;

import com.mobile.auth.f.a;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f11419a;

    public a(int i10) {
        this.f11419a = new ConcurrentHashMap<>(i10);
    }

    public com.cmic.sso.sdk.d.b a() {
        com.cmic.sso.sdk.d.b bVar = (com.cmic.sso.sdk.d.b) this.f11419a.get("logBean");
        return bVar != null ? bVar : new com.cmic.sso.sdk.d.b();
    }

    public void a(com.cmic.sso.sdk.d.b bVar) {
        if (bVar != null) {
            this.f11419a.put("logBean", bVar);
        }
    }

    public void a(com.mobile.auth.f.a aVar) {
        if (aVar != null) {
            this.f11419a.put("current_config", aVar);
        }
    }

    public void a(String str, int i10) {
        if (str != null) {
            this.f11419a.put(str, Integer.valueOf(i10));
        }
    }

    public void a(String str, long j10) {
        if (str != null) {
            this.f11419a.put(str, Long.valueOf(j10));
        }
    }

    public void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f11419a.put(str, str2);
    }

    public void a(String str, boolean z10) {
        if (str != null) {
            this.f11419a.put(str, Boolean.valueOf(z10));
        }
    }

    public void a(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return;
        }
        this.f11419a.put(str, bArr);
    }

    public byte[] a(String str) {
        if (str != null) {
            return (byte[]) this.f11419a.get(str);
        }
        return null;
    }

    public int b(String str, int i10) {
        return (str == null || !this.f11419a.containsKey(str)) ? i10 : ((Integer) this.f11419a.get(str)).intValue();
    }

    public long b(String str, long j10) {
        return (str == null || !this.f11419a.containsKey(str)) ? j10 : ((Long) this.f11419a.get(str)).longValue();
    }

    public com.mobile.auth.f.a b() {
        com.mobile.auth.f.a aVar = (com.mobile.auth.f.a) this.f11419a.get("current_config");
        if (aVar != null) {
            return aVar;
        }
        com.mobile.auth.n.c.a("UmcConfigBean为空", "请核查");
        return new a.C0556a().a();
    }

    public String b(String str) {
        return b(str, "");
    }

    public String b(String str, String str2) {
        return (str == null || !this.f11419a.containsKey(str)) ? str2 : (String) this.f11419a.get(str);
    }

    public boolean b(String str, boolean z10) {
        return (str == null || !this.f11419a.containsKey(str)) ? z10 : ((Boolean) this.f11419a.get(str)).booleanValue();
    }

    public int c(String str) {
        return b(str, 0);
    }
}
