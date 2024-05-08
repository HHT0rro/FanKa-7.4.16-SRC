package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class j1 {

    /* renamed from: a, reason: collision with root package name */
    public int f47025a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f47026b = "";

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof j1)) {
            return false;
        }
        j1 j1Var = (j1) obj;
        return !TextUtils.isEmpty(j1Var.f47026b) && j1Var.f47026b.equals(this.f47026b);
    }
}
