package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.model.CannedAccessControlList;
import com.alibaba.security.realidentity.oss.model.Owner;

/* compiled from: GetObjectACLResult.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ew extends ft {

    /* renamed from: a, reason: collision with root package name */
    public Owner f3576a = new Owner();

    /* renamed from: b, reason: collision with root package name */
    public CannedAccessControlList f3577b;

    private void a(String str) {
        this.f3576a.setDisplayName(str);
    }

    private Owner b() {
        return this.f3576a;
    }

    private String c() {
        return this.f3576a.getDisplayName();
    }

    private String d() {
        return this.f3576a.getId();
    }

    private String e() {
        CannedAccessControlList cannedAccessControlList = this.f3577b;
        if (cannedAccessControlList != null) {
            return cannedAccessControlList.toString();
        }
        return null;
    }

    private void b(String str) {
        this.f3576a.setId(str);
    }

    private void c(String str) {
        this.f3577b = CannedAccessControlList.parseACL(str);
    }
}
