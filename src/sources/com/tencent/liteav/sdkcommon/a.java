package com.tencent.liteav.sdkcommon;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final DashboardManager f43155a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f43156b;

    private a(DashboardManager dashboardManager, boolean z10) {
        this.f43155a = dashboardManager;
        this.f43156b = z10;
    }

    public static Runnable a(DashboardManager dashboardManager, boolean z10) {
        return new a(dashboardManager, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f43155a.showDashboardInternal(this.f43156b);
    }
}
