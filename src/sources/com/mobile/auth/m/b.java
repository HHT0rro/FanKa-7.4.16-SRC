package com.mobile.auth.m;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f37502a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, List<String>> f37503b;

    /* renamed from: c, reason: collision with root package name */
    private String f37504c;

    public b(int i10, Map<String, List<String>> map, String str) {
        this.f37502a = i10;
        this.f37503b = map;
        this.f37504c = str;
    }

    public int a() {
        return this.f37502a;
    }

    public Map<String, List<String>> b() {
        Map<String, List<String>> map = this.f37503b;
        return map == null ? new HashMap() : map;
    }

    public String c() {
        String str = this.f37504c;
        return str == null ? "" : str;
    }

    public boolean d() {
        int i10 = this.f37502a;
        return i10 == 302 || i10 == 301;
    }
}
