package com.huawei.hms.push.utils.ha;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PushAnalyticsCenter {

    /* renamed from: a, reason: collision with root package name */
    private PushBaseAnalytics f30473a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static PushAnalyticsCenter f30474a = new PushAnalyticsCenter();
    }

    public static PushAnalyticsCenter getInstance() {
        return a.f30474a;
    }

    public PushBaseAnalytics getPushAnalytics() {
        return this.f30473a;
    }

    public void register(PushBaseAnalytics pushBaseAnalytics) {
        this.f30473a = pushBaseAnalytics;
    }
}
