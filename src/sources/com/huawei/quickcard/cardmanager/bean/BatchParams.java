package com.huawei.quickcard.cardmanager.bean;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BatchParams {

    /* renamed from: a, reason: collision with root package name */
    private String[] f33495a;

    /* renamed from: b, reason: collision with root package name */
    private int f33496b = -1;

    public int getMaxSize() {
        return this.f33496b;
    }

    public String[] getUris() {
        String[] strArr = this.f33495a;
        return strArr == null ? new String[0] : (String[]) strArr.clone();
    }

    public void setMaxSize(int i10) {
        this.f33496b = i10;
    }

    public void setUris(@NonNull String[] strArr) {
        this.f33495a = (String[]) strArr.clone();
    }
}
