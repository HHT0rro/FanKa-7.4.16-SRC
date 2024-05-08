package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.model.CannedAccessControlList;
import com.alibaba.security.realidentity.oss.model.Owner;
import java.util.Date;

/* compiled from: OSSBucketSummary.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fr {

    /* renamed from: a, reason: collision with root package name */
    public String f3679a;

    /* renamed from: b, reason: collision with root package name */
    public Owner f3680b;

    /* renamed from: c, reason: collision with root package name */
    public Date f3681c;

    /* renamed from: d, reason: collision with root package name */
    public String f3682d;

    /* renamed from: e, reason: collision with root package name */
    public String f3683e;

    /* renamed from: f, reason: collision with root package name */
    public String f3684f;

    /* renamed from: g, reason: collision with root package name */
    public String f3685g;

    /* renamed from: h, reason: collision with root package name */
    public CannedAccessControlList f3686h;

    private String a() {
        CannedAccessControlList cannedAccessControlList = this.f3686h;
        if (cannedAccessControlList != null) {
            return cannedAccessControlList.toString();
        }
        return null;
    }

    public final String toString() {
        if (this.f3685g == null) {
            return "OSSBucket [name=" + this.f3679a + ", creationDate=" + ((Object) this.f3681c) + ", owner=" + this.f3680b.toString() + ", location=" + this.f3682d + "]";
        }
        return "OSSBucket [name=" + this.f3679a + ", creationDate=" + ((Object) this.f3681c) + ", owner=" + this.f3680b.toString() + ", location=" + this.f3682d + ", storageClass=" + this.f3685g + "]";
    }

    private void a(String str) {
        this.f3686h = CannedAccessControlList.parseACL(str);
    }
}
