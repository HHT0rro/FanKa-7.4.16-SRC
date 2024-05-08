package com.alipay.android.phone.mrpc.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class o extends t {

    /* renamed from: b, reason: collision with root package name */
    private String f4253b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f4254c;

    /* renamed from: g, reason: collision with root package name */
    private boolean f4258g;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<Header> f4256e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private Map<String, String> f4257f = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private String f4255d = "application/x-www-form-urlencoded";

    public o(String str) {
        this.f4253b = str;
    }

    public final String a() {
        return this.f4253b;
    }

    public final void a(String str) {
        this.f4255d = str;
    }

    public final void a(String str, String str2) {
        if (this.f4257f == null) {
            this.f4257f = new HashMap();
        }
        this.f4257f.put(str, str2);
    }

    public final void a(Header header) {
        this.f4256e.add(header);
    }

    public final void a(boolean z10) {
        this.f4258g = z10;
    }

    public final void a(byte[] bArr) {
        this.f4254c = bArr;
    }

    public final String b(String str) {
        Map<String, String> map = this.f4257f;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final byte[] b() {
        return this.f4254c;
    }

    public final String c() {
        return this.f4255d;
    }

    public final ArrayList<Header> d() {
        return this.f4256e;
    }

    public final boolean e() {
        return this.f4258g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        byte[] bArr = this.f4254c;
        if (bArr == null) {
            if (oVar.f4254c != null) {
                return false;
            }
        } else if (!bArr.equals(oVar.f4254c)) {
            return false;
        }
        String str = this.f4253b;
        String str2 = oVar.f4253b;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Map<String, String> map = this.f4257f;
        int hashCode = ((map == null || !map.containsKey("id")) ? 1 : this.f4257f.get("id").hashCode() + 31) * 31;
        String str = this.f4253b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return String.format("Url : %s,HttpHeader: %s", this.f4253b, this.f4256e);
    }
}
