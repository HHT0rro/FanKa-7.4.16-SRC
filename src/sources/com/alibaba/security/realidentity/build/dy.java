package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.model.CannedAccessControlList;
import com.alibaba.security.realidentity.oss.model.OSSRequest;
import com.alibaba.security.realidentity.oss.model.StorageClass;

/* compiled from: CreateBucketRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dy extends OSSRequest {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3534a = "LocationConstraint";

    /* renamed from: b, reason: collision with root package name */
    public static final String f3535b = "StorageClass";

    /* renamed from: c, reason: collision with root package name */
    public String f3536c;

    /* renamed from: d, reason: collision with root package name */
    public CannedAccessControlList f3537d;

    /* renamed from: e, reason: collision with root package name */
    public String f3538e;

    /* renamed from: f, reason: collision with root package name */
    public StorageClass f3539f = StorageClass.Standard;

    private dy(String str) {
        this.f3536c = str;
    }

    private String a() {
        return this.f3536c;
    }

    @Deprecated
    private String b() {
        return this.f3538e;
    }

    private CannedAccessControlList c() {
        return this.f3537d;
    }

    private StorageClass d() {
        return this.f3539f;
    }

    private void a(String str) {
        this.f3536c = str;
    }

    @Deprecated
    private void b(String str) {
        this.f3538e = str;
    }

    private void a(CannedAccessControlList cannedAccessControlList) {
        this.f3537d = cannedAccessControlList;
    }

    private void a(StorageClass storageClass) {
        this.f3539f = storageClass;
    }
}
