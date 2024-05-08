package com.huawei.hms.aaid.plugin;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ProxyCenter {
    private PushProxy proxy;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static ProxyCenter f28923a = new ProxyCenter();
    }

    private static ProxyCenter getInstance() {
        return a.f28923a;
    }

    public static PushProxy getProxy() {
        return getInstance().proxy;
    }

    public static void register(PushProxy pushProxy) {
        getInstance().proxy = pushProxy;
    }
}
