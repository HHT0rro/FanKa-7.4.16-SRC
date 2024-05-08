package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.model.CannedAccessControlList;
import com.alibaba.security.realidentity.oss.model.Owner;

/* compiled from: GetBucketACLResult.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class em extends ft {

    /* renamed from: a, reason: collision with root package name */
    public Owner f3561a = new Owner();

    /* renamed from: b, reason: collision with root package name */
    public CannedAccessControlList f3562b;

    private void a(String str) {
        this.f3561a.setDisplayName(str);
    }

    private Owner b() {
        return this.f3561a;
    }

    private String c() {
        return this.f3561a.getDisplayName();
    }

    private String d() {
        return this.f3561a.getId();
    }

    private String e() {
        CannedAccessControlList cannedAccessControlList = this.f3562b;
        if (cannedAccessControlList != null) {
            return cannedAccessControlList.toString();
        }
        return null;
    }

    private void b(String str) {
        this.f3561a.setId(str);
    }

    private void c(String str) {
        this.f3562b = CannedAccessControlList.parseACL(str);
    }
}
