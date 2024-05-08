package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hq;
import com.xiaomi.push.id;
import com.xiaomi.push.ip;
import com.xiaomi.push.l2;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c1 implements l2 {

    /* renamed from: a, reason: collision with root package name */
    public Context f46972a;

    public c1(Context context) {
        this.f46972a = context;
    }

    @Override // com.xiaomi.push.l2
    public String a() {
        return o0.c(this.f46972a).t();
    }

    @Override // com.xiaomi.push.l2
    public void a(ip ipVar, hq hqVar, id idVar) {
        h0.g(this.f46972a).t(ipVar, hqVar, idVar);
    }
}
