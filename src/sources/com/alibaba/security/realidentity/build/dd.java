package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.common.utils.CaseInsensitiveHashMap;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* compiled from: HttpMessage.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
abstract class dd {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f3427a = new CaseInsensitiveHashMap();

    /* renamed from: b, reason: collision with root package name */
    private InputStream f3428b;

    /* renamed from: c, reason: collision with root package name */
    private long f3429c;

    /* renamed from: d, reason: collision with root package name */
    private String f3430d;

    public Map<String, String> a() {
        return this.f3427a;
    }

    public InputStream b() {
        return this.f3428b;
    }

    public String c() {
        return this.f3430d;
    }

    public long d() {
        return this.f3429c;
    }

    public void e() throws IOException {
        InputStream inputStream = this.f3428b;
        if (inputStream != null) {
            inputStream.close();
            this.f3428b = null;
        }
    }

    public void a(Map<String, String> map) {
        if (this.f3427a == null) {
            this.f3427a = new CaseInsensitiveHashMap();
        }
        Map<String, String> map2 = this.f3427a;
        if (map2 != null && map2.size() > 0) {
            this.f3427a.clear();
        }
        this.f3427a.putAll(map);
    }

    public void a(String str, String str2) {
        this.f3427a.put(str, str2);
    }

    public void a(InputStream inputStream) {
        this.f3428b = inputStream;
    }

    public void a(String str) {
        this.f3430d = str;
    }

    public void a(long j10) {
        this.f3429c = j10;
    }
}
