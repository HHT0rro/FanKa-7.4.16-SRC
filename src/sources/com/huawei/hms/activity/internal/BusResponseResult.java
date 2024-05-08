package com.huawei.hms.activity.internal;

import android.content.Intent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BusResponseResult {

    /* renamed from: a, reason: collision with root package name */
    private Intent f28943a;

    /* renamed from: b, reason: collision with root package name */
    private int f28944b;

    public int getCode() {
        return this.f28944b;
    }

    public Intent getIntent() {
        return this.f28943a;
    }

    public void setCode(int i10) {
        this.f28944b = i10;
    }

    public void setIntent(Intent intent) {
        this.f28943a = intent;
    }
}
