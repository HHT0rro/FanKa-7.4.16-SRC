package com.alibaba.security.realidentity.build;

import java.util.ArrayList;

/* compiled from: GetBucketRefererResult.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class eu extends ft {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<String> f3572a;

    /* renamed from: b, reason: collision with root package name */
    private String f3573b;

    private void a(String str) {
        this.f3573b = str;
    }

    private String b() {
        return this.f3573b;
    }

    private ArrayList<String> c() {
        return this.f3572a;
    }

    private void a(ArrayList<String> arrayList) {
        this.f3572a = arrayList;
    }

    private void b(String str) {
        if (this.f3572a == null) {
            this.f3572a = new ArrayList<>();
        }
        this.f3572a.add(str);
    }
}
