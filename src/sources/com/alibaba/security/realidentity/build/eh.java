package com.alibaba.security.realidentity.build;

import java.util.ArrayList;
import java.util.List;

/* compiled from: DeleteMultipleObjectResult.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class eh extends ft {

    /* renamed from: a, reason: collision with root package name */
    public List<String> f3547a;

    /* renamed from: b, reason: collision with root package name */
    private List<String> f3548b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3549c;

    private void a(String str) {
        if (this.f3547a == null) {
            this.f3547a = new ArrayList();
        }
        this.f3547a.add(str);
    }

    private void b() {
        List<String> list = this.f3547a;
        if (list != null) {
            list.clear();
        }
        List<String> list2 = this.f3548b;
        if (list2 != null) {
            list2.clear();
        }
    }

    private List<String> c() {
        return this.f3547a;
    }

    private List<String> d() {
        return this.f3548b;
    }

    private boolean e() {
        return this.f3549c;
    }

    private void a(boolean z10) {
        this.f3549c = z10;
    }

    private void b(String str) {
        if (this.f3548b == null) {
            this.f3548b = new ArrayList();
        }
        this.f3548b.add(str);
    }
}
