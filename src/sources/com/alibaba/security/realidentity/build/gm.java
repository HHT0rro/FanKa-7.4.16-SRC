package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.model.OSSRequest;
import java.util.Map;

/* compiled from: TriggerCallbackRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gm extends OSSRequest {

    /* renamed from: a, reason: collision with root package name */
    public String f3741a;

    /* renamed from: b, reason: collision with root package name */
    public String f3742b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, String> f3743c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f3744d;

    private gm(String str, String str2, Map<String, String> map, Map<String, String> map2) {
        this.f3741a = str;
        this.f3742b = str2;
        this.f3743c = map;
        this.f3744d = map2;
    }

    private String a() {
        return this.f3741a;
    }

    private String b() {
        return this.f3742b;
    }

    private Map<String, String> c() {
        return this.f3743c;
    }

    private Map<String, String> d() {
        return this.f3744d;
    }

    private void a(String str) {
        this.f3741a = str;
    }

    private void b(String str) {
        this.f3742b = str;
    }

    private void a(Map<String, String> map) {
        this.f3743c = map;
    }

    private void b(Map<String, String> map) {
        this.f3744d = map;
    }
}
