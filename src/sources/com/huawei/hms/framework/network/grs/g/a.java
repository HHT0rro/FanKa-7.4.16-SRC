package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public d f29971a;

    /* renamed from: b, reason: collision with root package name */
    private final String f29972b;

    /* renamed from: c, reason: collision with root package name */
    private final c f29973c;

    /* renamed from: d, reason: collision with root package name */
    private final int f29974d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f29975e;

    /* renamed from: f, reason: collision with root package name */
    private final String f29976f;

    /* renamed from: g, reason: collision with root package name */
    private final GrsBaseInfo f29977g;

    /* renamed from: h, reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.e.c f29978h;

    public a(String str, int i10, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.c cVar2) {
        this.f29972b = str;
        this.f29973c = cVar;
        this.f29974d = i10;
        this.f29975e = context;
        this.f29976f = str2;
        this.f29977g = grsBaseInfo;
        this.f29978h = cVar2;
    }

    public Context a() {
        return this.f29975e;
    }

    public c b() {
        return this.f29973c;
    }

    public String c() {
        return this.f29972b;
    }

    public int d() {
        return this.f29974d;
    }

    public String e() {
        return this.f29976f;
    }

    public com.huawei.hms.framework.network.grs.e.c f() {
        return this.f29978h;
    }

    public Callable<d> g() {
        return new f(this.f29972b, this.f29974d, this.f29973c, this.f29975e, this.f29976f, this.f29977g, this.f29978h);
    }
}
