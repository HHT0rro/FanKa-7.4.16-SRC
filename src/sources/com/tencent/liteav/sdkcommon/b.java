package com.tencent.liteav.sdkcommon;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final DashboardManager f43157a;

    /* renamed from: b, reason: collision with root package name */
    private final String f43158b;

    private b(DashboardManager dashboardManager, String str) {
        this.f43157a = dashboardManager;
        this.f43158b = str;
    }

    public static Runnable a(DashboardManager dashboardManager, String str) {
        return new b(dashboardManager, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f43157a.addDashboardInternal(this.f43158b);
    }
}
