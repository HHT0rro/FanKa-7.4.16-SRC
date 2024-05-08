package com.tencent.liteav.sdkcommon;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final DashboardManager f43159a;

    /* renamed from: b, reason: collision with root package name */
    private final String f43160b;

    private c(DashboardManager dashboardManager, String str) {
        this.f43159a = dashboardManager;
        this.f43160b = str;
    }

    public static Runnable a(DashboardManager dashboardManager, String str) {
        return new c(dashboardManager, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f43159a.removeDashboardInternal(this.f43160b);
    }
}
