package com.huawei.hms.framework.network.grs.g.j;

import android.os.SystemClock;
import com.huawei.openalliance.ad.constant.u;
import java.util.concurrent.Future;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Future<com.huawei.hms.framework.network.grs.g.d> f30030a;

    /* renamed from: b, reason: collision with root package name */
    private final long f30031b = SystemClock.elapsedRealtime();

    public b(Future<com.huawei.hms.framework.network.grs.g.d> future) {
        this.f30030a = future;
    }

    public Future<com.huawei.hms.framework.network.grs.g.d> a() {
        return this.f30030a;
    }

    public boolean b() {
        return SystemClock.elapsedRealtime() - this.f30031b <= u.as;
    }
}
