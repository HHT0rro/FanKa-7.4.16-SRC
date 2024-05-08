package com.tencent.cloud.huiyansdkface.okhttp3.internal.connection;

import com.tencent.cloud.huiyansdkface.okhttp3.Route;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class RouteDatabase {

    /* renamed from: a, reason: collision with root package name */
    private final Set<Route> f41727a = new LinkedHashSet();

    public synchronized void connected(Route route) {
        this.f41727a.remove(route);
    }

    public synchronized void failed(Route route) {
        this.f41727a.add(route);
    }

    public synchronized boolean shouldPostpone(Route route) {
        return this.f41727a.contains(route);
    }
}
