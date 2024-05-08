package com.alibaba.security.realidentity.build;

import java.util.ArrayList;

/* compiled from: GetBucketLifecycleResult.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class eq extends ft {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<dt> f3566a;

    private void a(ArrayList<dt> arrayList) {
        this.f3566a = arrayList;
    }

    private ArrayList<dt> b() {
        return this.f3566a;
    }

    private void a(dt dtVar) {
        if (this.f3566a == null) {
            this.f3566a = new ArrayList<>();
        }
        this.f3566a.add(dtVar);
    }
}
