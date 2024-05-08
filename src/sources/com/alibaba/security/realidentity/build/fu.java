package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.common.utils.CaseInsensitiveHashMap;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

/* compiled from: ObjectMetadata.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fu {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3700a = "AES256";

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f3701b = new CaseInsensitiveHashMap();

    /* renamed from: c, reason: collision with root package name */
    public Map<String, Object> f3702c = new CaseInsensitiveHashMap();

    private Map<String, String> a() {
        return this.f3701b;
    }

    private Date b() {
        return (Date) this.f3702c.get("Last-Modified");
    }

    private Date c() throws ParseException {
        return cr.a((String) this.f3702c.get("Expires"));
    }

    private String d() {
        return (String) this.f3702c.get("Expires");
    }

    private long e() {
        Long l10 = (Long) this.f3702c.get("Content-Length");
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    private String f() {
        return (String) this.f3702c.get("Content-Type");
    }

    private String g() {
        return (String) this.f3702c.get(cs.P);
    }

    private String h() {
        return (String) this.f3702c.get(cc.f3278g);
    }

    private String i() {
        return (String) this.f3702c.get("Content-Encoding");
    }

    private String j() {
        return (String) this.f3702c.get("Cache-Control");
    }

    private String k() {
        return (String) this.f3702c.get("Content-Disposition");
    }

    private String l() {
        return (String) this.f3702c.get("ETag");
    }

    private String m() {
        return (String) this.f3702c.get(cc.f3279h);
    }

    private String n() {
        return (String) this.f3702c.get(cc.J);
    }

    private Map<String, Object> o() {
        return Collections.unmodifiableMap(this.f3702c);
    }

    public final String toString() {
        String str;
        try {
            str = cr.a((String) this.f3702c.get("Expires")).toString();
        } catch (Exception unused) {
            str = "";
        }
        StringBuilder sb2 = new StringBuilder("Last-Modified:");
        sb2.append(this.f3702c.get("Last-Modified"));
        sb2.append("\nExpires:");
        sb2.append(str);
        sb2.append("\nrawExpires:");
        sb2.append((String) this.f3702c.get("Expires"));
        sb2.append("\nContent-MD5:");
        sb2.append((String) this.f3702c.get(cs.P));
        sb2.append("\nx-oss-object-type:");
        sb2.append((String) this.f3702c.get(cc.J));
        sb2.append("\nx-oss-server-side-encryption:");
        sb2.append((String) this.f3702c.get(cc.f3279h));
        sb2.append("\nContent-Disposition:");
        sb2.append((String) this.f3702c.get("Content-Disposition"));
        sb2.append("\nContent-Encoding:");
        sb2.append((String) this.f3702c.get("Content-Encoding"));
        sb2.append("\nCache-Control:");
        sb2.append((String) this.f3702c.get("Cache-Control"));
        sb2.append("\nETag:");
        sb2.append((String) this.f3702c.get("ETag"));
        sb2.append("\n");
        return sb2.toString();
    }

    private void a(Map<String, String> map) {
        this.f3701b.clear();
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f3701b.putAll(map);
    }

    private void b(Date date) {
        this.f3702c.put("Expires", cr.a(date));
    }

    private void c(String str) {
        this.f3702c.put(cc.f3278g, str);
    }

    private void d(String str) {
        this.f3702c.put("Content-Encoding", str);
    }

    private void f(String str) {
        this.f3702c.put("Content-Disposition", str);
    }

    private void g(String str) {
        this.f3702c.put(cc.f3279h, str);
    }

    private void b(String str) {
        this.f3702c.put(cs.P, str);
    }

    private void e(String str) {
        this.f3702c.put("Cache-Control", str);
    }

    public final void a(String str, Object obj) {
        this.f3702c.put(str, obj);
    }

    private void a(String str, String str2) {
        this.f3701b.put(str, str2);
    }

    private void a(Date date) {
        this.f3702c.put("Last-Modified", date);
    }

    private void a(long j10) {
        if (j10 <= cb.f3265k) {
            this.f3702c.put("Content-Length", Long.valueOf(j10));
            return;
        }
        throw new IllegalArgumentException("The content length could not be more than 5GB.");
    }

    private void a(String str) {
        this.f3702c.put("Content-Type", str);
    }
}
